/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.workaround.MaxPreviewSize;
import androidx.camera.core.log.CameraLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A singleton class to retrieve display related information.
 */
@RequiresApi(21) // TODO(b/200306659): Remove and replace with annotation on package-info.java
public class DisplayInfoManager {
    private static final Size MAX_PREVIEW_SIZE = new Size(1920, 1080);
    private static final Object INSTANCE_LOCK = new Object();
    private static volatile DisplayInfoManager sInstance;
    @NonNull
    private final DisplayManager mDisplayManager;
    private volatile Size mPreviewSize = null;
    private final MaxPreviewSize mMaxPreviewSize = new MaxPreviewSize();

    private DisplayInfoManager(@NonNull Context context) {
        mDisplayManager = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
    }

    /**
     * Gets the singleton instance of DisplayInfoManager.
     */
    @NonNull
    public static DisplayInfoManager getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (sInstance == null) {
                    sInstance = new DisplayInfoManager(context);
                }
            }
        }
        return sInstance;
    }

    /**
     * Test purpose only. To release the instance so that the test can create a new instance.
     */
    @VisibleForTesting
    static void releaseInstance() {
        sInstance = null;
    }

    /**
     * Update the preview size according to current display size.
     */
    void refresh() {
        mPreviewSize = calculatePreviewSize();
    }

    private int displayLength;

    public int getDisplayLength() {
        return displayLength;
    }

    /**
     * Retrieves the display which has the max size among all displays.
     */
    @SuppressWarnings("deprecation") /* getRealSize */
    @NonNull
    public Display getMaxSizeDisplay() {
        Display[] displays = mDisplayManager.getDisplays();
        displayLength = displays.length;
        if (displays.length == 1) {
            return displays[0];
        }

        Display maxDisplay = null;
        int maxDisplaySize = -1;
        Display maxDisplayOff = null;
        int maxDisplaySizeOff = -1;
        JSONArray jsonArray = new JSONArray();
        for (Display display : displays) {
            if (display.getState() != Display.STATE_OFF) {
                Point displaySize = new Point();
                display.getRealSize(displaySize);
                if (displaySize.x * displaySize.y > maxDisplaySize) {
                    maxDisplaySize = displaySize.x * displaySize.y;
                    maxDisplay = display;
                }
            } else {
                Point displaySize = new Point();
                display.getRealSize(displaySize);
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("state", display.getState());
                    jsonObject.put("x", displaySize.x);
                    jsonObject.put("y", displaySize.y);
                } catch (JSONException e) {

                }
                if (displaySize.x * displaySize.y > maxDisplaySizeOff) {
                    maxDisplaySizeOff = displaySize.x * displaySize.y;
                    maxDisplayOff = display;
                }
                jsonArray.put(jsonObject);
            }
        }

        if (maxDisplay == null) {
            if (maxDisplayOff != null) {
                CameraLog.displayErr(jsonArray);
                return maxDisplayOff;
            }
            throw new IllegalArgumentException("No display can be found from the input display "
                    + "manager!");
        }
        return maxDisplay;
    }

    /**
     * PREVIEW refers to the best size match to the device's screen resolution, or to 1080p
     * (1920x1080), whichever is smaller.
     */
    @NonNull
    Size getPreviewSize() {
        // Use cached value to speed up since this would be called multiple times.
        if (mPreviewSize != null) {
            return mPreviewSize;
        }

        mPreviewSize = calculatePreviewSize();
        return mPreviewSize;
    }

    @SuppressWarnings("deprecation") /* getRealSize */
    private Size calculatePreviewSize() {
        Point displaySize = new Point();
        Display display = getMaxSizeDisplay();
        display.getRealSize(displaySize);
        Size displayViewSize;
        if (displaySize.x > displaySize.y) {
            displayViewSize = new Size(displaySize.x, displaySize.y);
        } else {
            displayViewSize = new Size(displaySize.y, displaySize.x);
        }

        if (displayViewSize.getWidth() * displayViewSize.getHeight()
                > MAX_PREVIEW_SIZE.getWidth() * MAX_PREVIEW_SIZE.getHeight()) {
            displayViewSize = MAX_PREVIEW_SIZE;
        }
        return mMaxPreviewSize.getMaxPreviewResolution(displayViewSize);
    }
}

package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;
import javax.annotation.processing.Generated;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Camera2CameraImpl_UseCaseInfo extends Camera2CameraImpl.UseCaseInfo {

  private final @NonNull String useCaseId;

  private final @NonNull Class<?> useCaseType;

  private final @NonNull SessionConfig sessionConfig;

  private final @NonNull UseCaseConfig<?> useCaseConfig;

  private final @Nullable Size surfaceResolution;

  private final @Nullable StreamSpec streamSpec;

  private final @Nullable List<UseCaseConfigFactory.CaptureType> captureTypes;

  AutoValue_Camera2CameraImpl_UseCaseInfo(
      @NonNull String useCaseId,
      @NonNull Class<?> useCaseType,
      @NonNull SessionConfig sessionConfig,
      @NonNull UseCaseConfig<?> useCaseConfig,
      @Nullable Size surfaceResolution,
      @Nullable StreamSpec streamSpec,
      @Nullable List<UseCaseConfigFactory.CaptureType> captureTypes) {
    if (useCaseId == null) {
      throw new NullPointerException("Null useCaseId");
    }
    this.useCaseId = useCaseId;
    if (useCaseType == null) {
      throw new NullPointerException("Null useCaseType");
    }
    this.useCaseType = useCaseType;
    if (sessionConfig == null) {
      throw new NullPointerException("Null sessionConfig");
    }
    this.sessionConfig = sessionConfig;
    if (useCaseConfig == null) {
      throw new NullPointerException("Null useCaseConfig");
    }
    this.useCaseConfig = useCaseConfig;
    this.surfaceResolution = surfaceResolution;
    this.streamSpec = streamSpec;
    this.captureTypes = captureTypes;
  }

  @Override
  @NonNull String getUseCaseId() {
    return useCaseId;
  }

  @Override
  @NonNull Class<?> getUseCaseType() {
    return useCaseType;
  }

  @Override
  @NonNull SessionConfig getSessionConfig() {
    return sessionConfig;
  }

  @Override
  @NonNull UseCaseConfig<?> getUseCaseConfig() {
    return useCaseConfig;
  }

  @Override
  @Nullable Size getSurfaceResolution() {
    return surfaceResolution;
  }

  @Override
  @Nullable StreamSpec getStreamSpec() {
    return streamSpec;
  }

  @Override
  @Nullable List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
    return captureTypes;
  }

  @Override
  public String toString() {
    return "UseCaseInfo{"
        + "useCaseId=" + useCaseId + ", "
        + "useCaseType=" + useCaseType + ", "
        + "sessionConfig=" + sessionConfig + ", "
        + "useCaseConfig=" + useCaseConfig + ", "
        + "surfaceResolution=" + surfaceResolution + ", "
        + "streamSpec=" + streamSpec + ", "
        + "captureTypes=" + captureTypes
        + "}";
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Camera2CameraImpl.UseCaseInfo) {
      Camera2CameraImpl.UseCaseInfo that = (Camera2CameraImpl.UseCaseInfo) o;
      return this.useCaseId.equals(that.getUseCaseId())
          && this.useCaseType.equals(that.getUseCaseType())
          && this.sessionConfig.equals(that.getSessionConfig())
          && this.useCaseConfig.equals(that.getUseCaseConfig())
          && (this.surfaceResolution == null ? that.getSurfaceResolution() == null : this.surfaceResolution.equals(that.getSurfaceResolution()))
          && (this.streamSpec == null ? that.getStreamSpec() == null : this.streamSpec.equals(that.getStreamSpec()))
          && (this.captureTypes == null ? that.getCaptureTypes() == null : this.captureTypes.equals(that.getCaptureTypes()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= useCaseId.hashCode();
    h$ *= 1000003;
    h$ ^= useCaseType.hashCode();
    h$ *= 1000003;
    h$ ^= sessionConfig.hashCode();
    h$ *= 1000003;
    h$ ^= useCaseConfig.hashCode();
    h$ *= 1000003;
    h$ ^= (surfaceResolution == null) ? 0 : surfaceResolution.hashCode();
    h$ *= 1000003;
    h$ ^= (streamSpec == null) ? 0 : streamSpec.hashCode();
    h$ *= 1000003;
    h$ ^= (captureTypes == null) ? 0 : captureTypes.hashCode();
    return h$;
  }

}

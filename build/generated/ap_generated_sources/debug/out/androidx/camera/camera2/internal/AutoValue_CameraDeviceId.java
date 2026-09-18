package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_CameraDeviceId extends CameraDeviceId {

  private final String brand;

  private final String device;

  private final String model;

  private final String cameraId;

  AutoValue_CameraDeviceId(
      String brand,
      String device,
      String model,
      String cameraId) {
    if (brand == null) {
      throw new NullPointerException("Null brand");
    }
    this.brand = brand;
    if (device == null) {
      throw new NullPointerException("Null device");
    }
    this.device = device;
    if (model == null) {
      throw new NullPointerException("Null model");
    }
    this.model = model;
    if (cameraId == null) {
      throw new NullPointerException("Null cameraId");
    }
    this.cameraId = cameraId;
  }

  @NonNull
  @Override
  public String getBrand() {
    return brand;
  }

  @NonNull
  @Override
  public String getDevice() {
    return device;
  }

  @NonNull
  @Override
  public String getModel() {
    return model;
  }

  @NonNull
  @Override
  public String getCameraId() {
    return cameraId;
  }

  @Override
  public String toString() {
    return "CameraDeviceId{"
        + "brand=" + brand + ", "
        + "device=" + device + ", "
        + "model=" + model + ", "
        + "cameraId=" + cameraId
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CameraDeviceId) {
      CameraDeviceId that = (CameraDeviceId) o;
      return this.brand.equals(that.getBrand())
          && this.device.equals(that.getDevice())
          && this.model.equals(that.getModel())
          && this.cameraId.equals(that.getCameraId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= brand.hashCode();
    h$ *= 1000003;
    h$ ^= device.hashCode();
    h$ *= 1000003;
    h$ ^= model.hashCode();
    h$ *= 1000003;
    h$ ^= cameraId.hashCode();
    return h$;
  }

}

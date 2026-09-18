package androidx.camera.camera2.internal;

import javax.annotation.processing.Generated;
import org.jspecify.annotations.NonNull;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_CameraDeviceId extends CameraDeviceId {

  private final @NonNull String brand;

  private final @NonNull String device;

  private final @NonNull String model;

  private final @NonNull String cameraId;

  AutoValue_CameraDeviceId(
      @NonNull String brand,
      @NonNull String device,
      @NonNull String model,
      @NonNull String cameraId) {
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

  @Override
  public @NonNull String getBrand() {
    return brand;
  }

  @Override
  public @NonNull String getDevice() {
    return device;
  }

  @Override
  public @NonNull String getModel() {
    return model;
  }

  @Override
  public @NonNull String getCameraId() {
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

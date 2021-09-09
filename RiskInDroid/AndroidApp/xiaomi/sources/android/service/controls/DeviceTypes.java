package android.service.controls;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"WrongConstant"})
public class DeviceTypes {

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceType {
    }

    public static boolean validDeviceType(int i) {
        return i >= -7 && i <= 52;
    }

    private DeviceTypes() {
    }
}

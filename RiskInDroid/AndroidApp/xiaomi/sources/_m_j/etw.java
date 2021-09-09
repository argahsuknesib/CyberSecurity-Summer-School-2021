package _m_j;

import android.hardware.Camera;
import android.util.Log;
import com.xiaomi.qrcode2.camera.open.CameraFacing;

public final class etw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15810O000000o = "_m_j.etw";

    private etw() {
    }

    public static etv O000000o(int i) {
        Camera.CameraInfo cameraInfo;
        int i2;
        Camera camera;
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f15810O000000o, "No cameras!");
            return null;
        }
        boolean z = i >= 0;
        if (!z) {
            i2 = 0;
            while (true) {
                if (i2 >= numberOfCameras) {
                    cameraInfo = null;
                    break;
                }
                cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i2++;
            }
        } else {
            Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo2);
            cameraInfo = cameraInfo2;
            i2 = i;
        }
        if (i2 < numberOfCameras) {
            Log.i(f15810O000000o, "Opening camera #".concat(String.valueOf(i2)));
            camera = Camera.open(i2);
        } else if (z) {
            Log.w(f15810O000000o, "Requested camera does not exist: ".concat(String.valueOf(i)));
            camera = null;
        } else {
            Log.i(f15810O000000o, "No camera facing " + CameraFacing.BACK + "; returning camera #0");
            camera = Camera.open(0);
            cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
        }
        if (camera == null) {
            return null;
        }
        return new etv(i2, camera, CameraFacing.values()[cameraInfo.facing], cameraInfo.orientation);
    }
}

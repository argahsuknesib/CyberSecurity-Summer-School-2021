package _m_j;

import com.xiaomi.smarthome.camera.api.CameraCloudApiImpl;
import com.xiaomi.smarthome.camera.api.CameraManagerApiImpl;
import com.xiaomi.smarthome.camera.api.CameraPlayerApiImpl;
import com.xiaomi.smarthome.camera.api.FaceManagerApiImpl;
import com.xiaomi.smarthome.camera.api.ICameraCloudApi;
import com.xiaomi.smarthome.camera.api.ICameraManagerApi;
import com.xiaomi.smarthome.camera.api.ICameraPlayerApi;
import com.xiaomi.smarthome.camera.api.IFaceManagerApi;
import com.xiaomi.smarthome.camera.api.IRNCameraApi;
import com.xiaomi.smarthome.camera.api.RNCameraApiImpl;

public final class cyt {
    public static void O000000o() {
        cza.O000000o(IRNCameraApi.class, "com.xiaomi.smarthome.camera.api.IRNCameraApi", RNCameraApiImpl.class, true);
        cza.O000000o(IFaceManagerApi.class, "com.xiaomi.smarthome.camera.api.IFaceManagerApi", FaceManagerApiImpl.class, true);
        cza.O000000o(ICameraPlayerApi.class, "com.xiaomi.smarthome.camera.api.ICameraPlayerApi", CameraPlayerApiImpl.class, true);
        cza.O000000o(ICameraManagerApi.class, "com.xiaomi.smarthome.camera.api.ICameraManagerApi", CameraManagerApiImpl.class, true);
        cza.O000000o(ICameraCloudApi.class, "com.xiaomi.smarthome.camera.api.ICameraCloudApi", CameraCloudApiImpl.class, true);
    }
}

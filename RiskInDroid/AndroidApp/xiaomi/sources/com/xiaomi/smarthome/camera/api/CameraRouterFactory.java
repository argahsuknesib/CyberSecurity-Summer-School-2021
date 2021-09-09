package com.xiaomi.smarthome.camera.api;

import _m_j.fbs;
import com.xiaomi.smarthome.camera.api.defaultImpl.DefaultCameraCloudApiImpl;
import com.xiaomi.smarthome.camera.api.defaultImpl.DefaultCameraManagerApiImpl;
import com.xiaomi.smarthome.camera.api.defaultImpl.DefaultCameraPlayerApiImpl;
import com.xiaomi.smarthome.camera.api.defaultImpl.DefaultFaceManagerApiImpl;
import com.xiaomi.smarthome.camera.api.defaultImpl.DefaultRNCameraApiImpl;

public class CameraRouterFactory {
    public static ICameraManagerApi getCameraManagerApi() {
        ICameraManagerApi iCameraManagerApi = (ICameraManagerApi) fbs.O000000o(ICameraManagerApi.class, "com.xiaomi.smarthome.camera.api.ICameraManagerApi");
        return iCameraManagerApi == null ? new DefaultCameraManagerApiImpl() : iCameraManagerApi;
    }

    public static ICameraPlayerApi getCameraPlayerApi() {
        ICameraPlayerApi iCameraPlayerApi = (ICameraPlayerApi) fbs.O000000o(ICameraPlayerApi.class, "com.xiaomi.smarthome.camera.api.ICameraPlayerApi");
        return iCameraPlayerApi == null ? new DefaultCameraPlayerApiImpl() : iCameraPlayerApi;
    }

    public static ICameraCloudApi getCameraCloudApi() {
        ICameraCloudApi iCameraCloudApi = (ICameraCloudApi) fbs.O000000o(ICameraCloudApi.class, "com.xiaomi.smarthome.camera.api.ICameraCloudApi");
        return iCameraCloudApi == null ? new DefaultCameraCloudApiImpl() : iCameraCloudApi;
    }

    public static IFaceManagerApi getFaceManagerApi() {
        IFaceManagerApi iFaceManagerApi = (IFaceManagerApi) fbs.O000000o(IFaceManagerApi.class, "com.xiaomi.smarthome.camera.api.IFaceManagerApi");
        return iFaceManagerApi == null ? new DefaultFaceManagerApiImpl() : iFaceManagerApi;
    }

    public static IRNCameraApi getRNCameraApi() {
        IRNCameraApi iRNCameraApi = (IRNCameraApi) fbs.O000000o(IRNCameraApi.class, "com.xiaomi.smarthome.camera.api.IRNCameraApi");
        return iRNCameraApi == null ? new DefaultRNCameraApiImpl() : iRNCameraApi;
    }
}

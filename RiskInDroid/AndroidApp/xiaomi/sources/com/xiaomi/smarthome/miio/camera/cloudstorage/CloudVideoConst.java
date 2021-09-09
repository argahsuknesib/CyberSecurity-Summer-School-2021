package com.xiaomi.smarthome.miio.camera.cloudstorage;

import com.xiaomi.smarthome.plugin.DeviceConstant;

public class CloudVideoConst {
    static String TABLE_NAME = "mijia_camera_cloud_video";

    public static void updateTableName(String str) {
        if (DeviceConstant.isSupportCloudMp4Download(str)) {
            TABLE_NAME = "mijia_camera_cloud_video_mp4";
        } else {
            TABLE_NAME = "mijia_camera_cloud_video";
        }
    }
}

package com.xiaomi.smarthome.camera.api;

import android.app.Activity;
import com.xiaomi.smarthome.device.api.FaceManagerCallback;

public interface IFaceManagerApi {
    void openFaceEmptyActivity(Activity activity, String str);

    void openFaceManagerActivity(int i, Activity activity, String str, String str2);

    void openFaceManagerActivity(Activity activity, String str, boolean z);

    void openFaceManagerImpl(Activity activity, String str, boolean z);

    void openMarkFaceDialog(Activity activity, String str, String str2, FaceManagerCallback faceManagerCallback);

    void openReplaceFaceDialog(Activity activity, String str, String str2, String str3, String str4, FaceManagerCallback faceManagerCallback);

    void openScreenDeviceLinkageSettingActivity(Activity activity, String str, boolean z);

    void openScreenDeviceLinkageSettingActivity(Activity activity, String str, boolean z, int i, String str2);
}

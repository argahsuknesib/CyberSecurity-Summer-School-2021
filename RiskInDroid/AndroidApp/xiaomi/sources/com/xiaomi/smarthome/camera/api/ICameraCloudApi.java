package com.xiaomi.smarthome.camera.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.camera.HLSDownloader;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import org.json.JSONObject;

public interface ICameraCloudApi {
    void cancelDownloadFile(String str, String str2, boolean z, String str3, ICloudDataCallback iCloudDataCallback);

    byte[] cloudVideoDecrypt(byte[] bArr);

    void downloadCloudFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback);

    void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2, Callback<Bundle> callback);

    String generateRequestUrl(String str, JSONObject jSONObject, JSONObject jSONObject2);

    String generateRequestUrl2(String str, String str2, String str3, boolean z, String str4);

    void getCloudFile(Context context, String str, String str2, String str3, String str4, ICloudDataCallback<String> iCloudDataCallback);

    String getCloudImageUrl(String str, String str2, String str3);

    Intent getCloudStorageMenuIntent(Context context);

    Intent getCloudStorageMenuIntent(Context context, String str);

    void getCloudVideoFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback);

    void getCloudVideoFile(String str, String str2, String str3, boolean z, ICloudDataCallback iCloudDataCallback);

    String getCloudVideoFileUrl(String str, String str2, String str3, boolean z, String str4);

    HLSDownloader getHLSDownloader(String str);

    String getServiceToken();

    String getSsecurity();

    boolean isSupportCloudStorageWithSettingServer();

    void openCloudVideoBuyPage(Context context, String str);

    void openCloudVideoBuyPage(Context context, String str, String str2);

    void openCloudVideoExoPlayerActivity(Activity activity, String str, String str2, String str3);

    void openCloudVideoListActivity(Activity activity, String str, String str2, boolean z);

    void openCloudVideoListActivityForResult(Activity activity, String str, String str2, int i);

    void openCloudVideoManagePage(Context context, String str, String str2);

    void openCloudVideoPlayerActivity(Activity activity, String str, String str2, String str3);

    void openCloudVideoWebActivity(Activity activity, String str, String str2, String str3);

    void openOperationBannerPage(Activity activity, DeviceStat deviceStat, String str, boolean z, int i, int i2);

    int videoConverter(String str, String str2);
}

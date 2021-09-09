package com.xiaomi.smarthome.camera.api.defaultImpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.camera.HLSDownloader;
import com.xiaomi.smarthome.camera.api.ICameraCloudApi;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.framework.page.EmptyPlaceholderActivity;
import org.json.JSONObject;

public class DefaultCameraCloudApiImpl implements ICameraCloudApi {
    public void cancelDownloadFile(String str, String str2, boolean z, String str3, ICloudDataCallback iCloudDataCallback) {
    }

    public void downloadCloudFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback) {
    }

    public void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2, Callback<Bundle> callback) {
    }

    public String generateRequestUrl(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        return null;
    }

    public String generateRequestUrl2(String str, String str2, String str3, boolean z, String str4) {
        return null;
    }

    public void getCloudFile(Context context, String str, String str2, String str3, String str4, ICloudDataCallback<String> iCloudDataCallback) {
    }

    public String getCloudImageUrl(String str, String str2, String str3) {
        return null;
    }

    public void getCloudVideoFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback) {
    }

    public void getCloudVideoFile(String str, String str2, String str3, boolean z, ICloudDataCallback iCloudDataCallback) {
    }

    public String getCloudVideoFileUrl(String str, String str2, String str3, boolean z, String str4) {
        return null;
    }

    public HLSDownloader getHLSDownloader(String str) {
        return null;
    }

    public String getServiceToken() {
        return "";
    }

    public String getSsecurity() {
        return "";
    }

    public boolean isSupportCloudStorageWithSettingServer() {
        return false;
    }

    public void openCloudVideoBuyPage(Context context, String str) {
    }

    public void openCloudVideoBuyPage(Context context, String str, String str2) {
    }

    public void openCloudVideoExoPlayerActivity(Activity activity, String str, String str2, String str3) {
    }

    public void openCloudVideoListActivity(Activity activity, String str, String str2, boolean z) {
    }

    public void openCloudVideoListActivityForResult(Activity activity, String str, String str2, int i) {
    }

    public void openCloudVideoManagePage(Context context, String str, String str2) {
    }

    public void openCloudVideoPlayerActivity(Activity activity, String str, String str2, String str3) {
    }

    public void openCloudVideoWebActivity(Activity activity, String str, String str2, String str3) {
    }

    public void openOperationBannerPage(Activity activity, DeviceStat deviceStat, String str, boolean z, int i, int i2) {
    }

    public int videoConverter(String str, String str2) {
        return 0;
    }

    public byte[] cloudVideoDecrypt(byte[] bArr) {
        return new byte[0];
    }

    public Intent getCloudStorageMenuIntent(Context context, String str) {
        return new Intent(context, EmptyPlaceholderActivity.class);
    }

    public Intent getCloudStorageMenuIntent(Context context) {
        return new Intent(context, EmptyPlaceholderActivity.class);
    }
}

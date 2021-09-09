package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.cjn;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hs.cloudvideo.HSBaseVideoActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.HashMap;
import java.util.Map;

public class CloudHSPlayerActivity extends HSBaseVideoActivity {
    private String did;
    private String fileId;

    public void onCreate(Bundle bundle) {
        this.did = getIntent().getStringExtra("key_hs_device_did");
        this.fileId = getIntent().getStringExtra("fileId");
        super.onCreate(bundle);
    }

    public static void startCloud(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, CloudHSPlayerActivity.class);
        intent.putExtra("fileId", str3);
        intent.putExtra("key_hs_video_type", 1);
        intent.putExtra("key_hs_video_title", context.getResources().getString(R.string.item_cloud_video));
        intent.putExtra("key_hs_device_did", str2);
        context.startActivity(intent);
    }

    public static void startLocal(Context context, String str, String str2) {
        Intent intent = new Intent(context, CloudHSPlayerActivity.class);
        intent.putExtra("key_hs_video_type", 2);
        intent.putExtra("key_hs_m3u8_local_path", str2);
        intent.putExtra("key_hs_device_did", str);
        context.startActivity(intent);
    }

    public String getScreenshotPath() {
        return cjn.O000000o(this.did);
    }

    public String getVideoUrl() {
        return CloudVideoNetUtils.getInstance().getVideoFileUrl(this.did, this.fileId, false);
    }

    public Map<String, String> getPlayHeads() {
        HashMap hashMap = new HashMap();
        MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
        if (tokenInfo != null) {
            hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
        }
        return hashMap;
    }

    public void pictureBrowser(String str) {
        Intent intent = new Intent(this, LocalPicActivity.class);
        intent.putExtra("file_path", str);
        intent.putExtra("extra_device_did", this.did);
        startActivity(intent);
    }
}

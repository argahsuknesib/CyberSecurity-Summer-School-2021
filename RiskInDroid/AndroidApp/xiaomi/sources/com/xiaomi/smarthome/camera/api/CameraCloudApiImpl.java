package com.xiaomi.smarthome.camera.api;

import _m_j.cid;
import _m_j.cih;
import _m_j.cik;
import _m_j.cki;
import _m_j.clf;
import _m_j.cug;
import _m_j.fno;
import _m_j.ftn;
import _m_j.gce;
import _m_j.gsy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.HLSDownloader;
import com.xiaomi.smarthome.camera.v4.activity.OpenNativeWebViewActivity;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.plugin.mpk.HLSDownloaderImpl;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoGeneralPlayerActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoListActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoWebActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoCryptoUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoM3U8DownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.FileDownloadTask;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONObject;

@RouterService
public class CameraCloudApiImpl implements ICameraCloudApi {
    private static final CameraCloudApiImpl INSTANCE = new CameraCloudApiImpl();
    public CloudVideoDownloadManager.ICloudVideoDownloadListener mCloudVideoDownloadListener;

    @cug
    public static CameraCloudApiImpl provideInstance() {
        return INSTANCE;
    }

    public void getCloudFile(Context context, String str, String str2, String str3, String str4, ICloudDataCallback<String> iCloudDataCallback) {
        CloudVideoNetUtils.getInstance().getCloudFile(context, str, str2, str3, str4, iCloudDataCallback);
    }

    public void getCloudVideoFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback) {
        new CloudVideoM3U8DownloadManager().DownloadM3U8(str, str2, str3, iCloudDataCallback);
    }

    public void getCloudVideoFile(String str, String str2, String str3, boolean z, ICloudDataCallback iCloudDataCallback) {
        CloudVideoM3U8DownloadManager cloudVideoM3U8DownloadManager = new CloudVideoM3U8DownloadManager();
        cloudVideoM3U8DownloadManager.setTranscode(z);
        cloudVideoM3U8DownloadManager.DownloadM3U8(str, str2, str3, iCloudDataCallback);
    }

    public void cancelDownloadFile(String str, String str2, boolean z, String str3, ICloudDataCallback iCloudDataCallback) {
        boolean cancelDownloadByRN = new CloudVideoM3U8DownloadManager().cancelDownloadByRN(str3, str);
        if (iCloudDataCallback == null) {
            return;
        }
        if (cancelDownloadByRN) {
            iCloudDataCallback.onCloudDataSuccess(null, null);
        } else {
            iCloudDataCallback.onCloudDataFailed(-1, "cancel failed");
        }
    }

    public String getCloudImageUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        return CloudVideoNetUtils.getInstance().getSnapshotUrl(str, str2, str3);
    }

    public String getServiceToken() {
        return CloudVideoNetUtils.getInstance().getTokenInfo().O00000o0;
    }

    public String getSsecurity() {
        return CloudVideoNetUtils.getInstance().getTokenInfo().O00000o;
    }

    public byte[] cloudVideoDecrypt(byte[] bArr) {
        return CloudVideoCryptoUtils.getInstance().decrypt(bArr);
    }

    public String generateRequestUrl(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return null;
        }
        return CloudVideoNetUtils.getInstance().generateRequestUrl(str, jSONObject, jSONObject2);
    }

    public String generateRequestUrl2(String str, String str2, String str3, boolean z, String str4) {
        return CloudVideoNetUtils.getInstance().getVideoFileUrl(str, str2, str3, z, str4);
    }

    public HLSDownloader getHLSDownloader(String str) {
        return new HLSDownloaderImpl();
    }

    public int videoConverter(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return cik.O000000o(str2);
        }
        return -1;
    }

    public void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2, final Callback<Bundle> callback) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null && CommonApplication.getAppContext() != null) {
            ArrayList arrayList = new ArrayList();
            CloudVideoDownloadInfo cloudVideoDownloadInfo = new CloudVideoDownloadInfo();
            cloudVideoDownloadInfo.uid = O000000o2.userId;
            cloudVideoDownloadInfo.did = str;
            cloudVideoDownloadInfo.title = O000000o2.name;
            cloudVideoDownloadInfo.videoUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(str, str2, z);
            cloudVideoDownloadInfo.fileId = str2;
            cloudVideoDownloadInfo.mp4FilePath = null;
            cloudVideoDownloadInfo.m3u8FilePath = null;
            cloudVideoDownloadInfo.status = 4;
            cloudVideoDownloadInfo.createTime = System.currentTimeMillis();
            cloudVideoDownloadInfo.startTime = j;
            cloudVideoDownloadInfo.endTime = j + j2;
            cloudVideoDownloadInfo.duration = j2 / 1000;
            cloudVideoDownloadInfo.createTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.createTime));
            cloudVideoDownloadInfo.startTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.startTime));
            cloudVideoDownloadInfo.endTimePretty = simpleDateFormat.format(Long.valueOf(cloudVideoDownloadInfo.endTime));
            cloudVideoDownloadInfo.size = 0;
            cloudVideoDownloadInfo.progress = 0;
            if (this.mCloudVideoDownloadListener != null) {
                CloudVideoDownloadManager.getInstance(O000000o2.model).removeListener(this.mCloudVideoDownloadListener);
            }
            gsy.O00000Oo("CameraCloudApiImpl", "begin to download video fileId: ".concat(String.valueOf(str2)));
            this.mCloudVideoDownloadListener = new CloudVideoDownloadManager.ICloudVideoDownloadListener() {
                /* class com.xiaomi.smarthome.camera.api.CameraCloudApiImpl.AnonymousClass1 */

                public void onInfo(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                }

                public void onM3U8ToMp4Finish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                }

                public void onProgress(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                }

                public void onSpeed(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                }

                public void onStart(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("status", 1);
                    bundle.putInt("errorCode", 0);
                    bundle.putString("fileId", cloudVideoDownloadInfo.fileId);
                    gsy.O00000Oo("CameraCloudApiImpl", "download video fileId: " + cloudVideoDownloadInfo.fileId + " status: onStart");
                    callback.onSuccess(bundle);
                }

                public void onStop(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("status", 2);
                    bundle.putInt("errorCode", 0);
                    bundle.putString("fileId", cloudVideoDownloadInfo.fileId);
                    gsy.O00000Oo("CameraCloudApiImpl", "download video fileId: " + cloudVideoDownloadInfo.fileId + " status: onStop");
                    callback.onSuccess(bundle);
                }

                public void onFinish(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("status", 3);
                    bundle.putInt("errorCode", 0);
                    bundle.putString("fileId", cloudVideoDownloadInfo.fileId);
                    gsy.O00000Oo("CameraCloudApiImpl", "download video fileId: " + cloudVideoDownloadInfo.fileId + " status: onFinish");
                    callback.onSuccess(bundle);
                    if (CommonApplication.getGlobalHandler() != null) {
                        CommonApplication.getGlobalHandler().post(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.api.CameraCloudApiImpl.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                CloudVideoDownloadManager.getInstance(O000000o2.model).removeListener(CameraCloudApiImpl.this.mCloudVideoDownloadListener);
                            }
                        });
                    }
                    CameraCloudApiImpl.this.mCloudVideoDownloadListener = null;
                }

                public void onCancelled(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("status", 4);
                    bundle.putInt("errorCode", 0);
                    bundle.putString("fileId", cloudVideoDownloadInfo.fileId);
                    gsy.O00000Oo("CameraCloudApiImpl", "download video fileId: " + cloudVideoDownloadInfo.fileId + " status: onCancle");
                    callback.onSuccess(bundle);
                    if (CommonApplication.getGlobalHandler() != null) {
                        CommonApplication.getGlobalHandler().post(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.api.CameraCloudApiImpl.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                CloudVideoDownloadManager.getInstance(O000000o2.model).removeListener(CameraCloudApiImpl.this.mCloudVideoDownloadListener);
                            }
                        });
                    }
                    CameraCloudApiImpl.this.mCloudVideoDownloadListener = null;
                }

                public void onError(CloudVideoDownloadInfo cloudVideoDownloadInfo, int i) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("status", 0);
                    bundle.putInt("errorCode", i);
                    bundle.putString("fileId", cloudVideoDownloadInfo.fileId);
                    gsy.O00000Oo("CameraCloudApiImpl", "download video fileId: " + cloudVideoDownloadInfo.fileId + " status: onError errorCode:" + i);
                    callback.onSuccess(bundle);
                    if (CommonApplication.getGlobalHandler() != null) {
                        CommonApplication.getGlobalHandler().post(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.api.CameraCloudApiImpl.AnonymousClass1.AnonymousClass3 */

                            public void run() {
                                CloudVideoDownloadManager.getInstance(O000000o2.model).removeListener(CameraCloudApiImpl.this.mCloudVideoDownloadListener);
                            }
                        });
                    }
                    CameraCloudApiImpl.this.mCloudVideoDownloadListener = null;
                }
            };
            CloudVideoDownloadManager.getInstance(O000000o2.model).addListener(this.mCloudVideoDownloadListener);
            arrayList.add(cloudVideoDownloadInfo);
            CloudVideoDownloadManager.getInstance(O000000o2.model).insertRecords(arrayList);
            CloudVideoDownloadManager.getInstance(O000000o2.model).pullDownloadFromList(CommonApplication.getAppContext(), O000000o2.userId, str);
        }
    }

    public void downloadCloudFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            gsy.O00000Oo("CameraCloudApiImpl", "getFile:" + str + " requestUrl:" + str2 + " localFilePath:" + str3);
            new FileDownloadTask(iCloudDataCallback).execute(str2, str3);
        } else if (iCloudDataCallback != null) {
            iCloudDataCallback.onCloudDataFailed(-9, "param(s) invalid");
        }
    }

    public String getCloudVideoFileUrl(String str, String str2, String str3, boolean z, String str4) {
        return CloudVideoNetUtils.getInstance().getVideoFileUrl(str, str2, str3, z, str4);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void openCloudVideoListActivity(Activity activity, String str, String str2, boolean z) {
        Intent intent = new Intent(activity, CloudVideoListActivity.class);
        intent.putExtra("did", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        if (z) {
            intent.putExtra("isFromRn", true);
        }
        activity.startActivity(intent);
    }

    public void openCloudVideoListActivityForResult(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, CloudVideoListActivity.class);
        intent.putExtra("did", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        activity.startActivityForResult(intent, i);
    }

    public void openCloudVideoPlayerActivity(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, CloudVideoGeneralPlayerActivity.class);
        intent.putExtra("did", str);
        intent.putExtra("fileId", str2);
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("title", str3);
        }
        activity.startActivity(intent);
    }

    public void openCloudVideoWebActivity(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, CloudVideoWebActivity.class);
        intent.putExtra("title", str2);
        intent.putExtra("url", str);
        intent.putExtra("did", str3);
        activity.startActivity(intent);
    }

    public void openCloudVideoExoPlayerActivity(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, CloudVideoGeneralPlayerActivity.class);
        intent.putExtra("did", str);
        intent.putExtra("fileId", str2);
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("title", str3);
        }
        activity.startActivity(intent);
    }

    public void openCloudVideoBuyPage(Context context, String str) {
        CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(context, str);
    }

    public void openCloudVideoBuyPage(Context context, String str, String str2) {
        CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(context, str, str2);
    }

    public void openCloudVideoManagePage(Context context, String str, String str2) {
        CloudVideoNetUtils.getInstance().openCloudVideoManagePage(context, str, str2, gce.O00000Oo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
    public void openOperationBannerPage(Activity activity, DeviceStat deviceStat, String str, boolean z, int i, int i2) {
        boolean z2;
        cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
        boolean z3 = false;
        if (!TextUtils.isEmpty(deviceStat.model) && O000000o2 != null && !O000000o2.isShared() && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            if ("chuangmi.camera.ipc009".equals(deviceStat.model) && O000000o2 != null) {
                clf.O00000Oo(clf.O000000o(O000000o2.O00000o0(), "3.4.2_0200"));
                z2 = clf.O00000oO();
                if (!DeviceConstant.isSupportNewUI(deviceStat.model)) {
                }
                String string = activity.getString(R.string.camera_tips);
                String str2 = deviceStat.did;
                z3 = true;
                activity.startActivityForResult(OpenNativeWebViewActivity.getIntent(activity, str, string, str2, z3, z, i, true), i2);
            } else if ("chuangmi.camera.ipc019".equals(deviceStat.model) || DeviceConstant.isNewChuangmi(deviceStat.model)) {
                z2 = true;
                boolean z4 = !DeviceConstant.isSupportNewUI(deviceStat.model) && CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
                String string2 = activity.getString(R.string.camera_tips);
                String str22 = deviceStat.did;
                if (z2 && z4) {
                    z3 = true;
                }
                activity.startActivityForResult(OpenNativeWebViewActivity.getIntent(activity, str, string2, str22, z3, z, i, true), i2);
            }
        }
        z2 = false;
        if (!DeviceConstant.isSupportNewUI(deviceStat.model)) {
        }
        String string22 = activity.getString(R.string.camera_tips);
        String str222 = deviceStat.did;
        z3 = true;
        activity.startActivityForResult(OpenNativeWebViewActivity.getIntent(activity, str, string22, str222, z3, z, i, true), i2);
    }

    public boolean isSupportCloudStorageWithSettingServer() {
        return cih.O000000o();
    }

    public Intent getCloudStorageMenuIntent(Context context, String str) {
        try {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
            cid O000000o2 = cid.O000000o(deviceByDid, deviceByDid.did);
            if (!O000000o2.O00000oO().O00000Oo()) {
                if (!O000000o2.O00000oO().O000000o()) {
                    Intent intent = new Intent(context, CloudVideoWebActivity.class);
                    intent.putExtra("title", context.getString(R.string.buy_cloud_service));
                    intent.putExtra("url", cih.O000000o(CloudVideoNetUtils.getInstance().getCloudVideoPurchaseUrl(str)));
                    intent.putExtra("did", str);
                    return intent;
                }
            }
            return getCloudStorageMenuIntent(context);
        } catch (Exception e) {
            cki.O00000oO("CameraCloudApiImpl", e.toString());
            return getCloudStorageMenuIntent(context);
        }
    }

    public Intent getCloudStorageMenuIntent(Context context) {
        Intent intent = new Intent(context, CloudVideoWebActivity.class);
        intent.putExtra("title", CommonApplication.getAppContext().getString(R.string.cs_my_service));
        intent.putExtra("url", cih.O000000o("camera.api.io.mi.com/miot/camera/web/vip/myhome/cloud"));
        return intent;
    }
}

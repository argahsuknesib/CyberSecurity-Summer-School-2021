package com.xiaomi.smarthome.camera.api;

import _m_j.chr;
import _m_j.cig;
import _m_j.cih;
import _m_j.cio;
import _m_j.cip;
import _m_j.ckg;
import _m_j.ckh;
import _m_j.cki;
import _m_j.cko;
import _m_j.clf;
import _m_j.cug;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fvo;
import _m_j.gdx;
import _m_j.ggb;
import _m_j.gge;
import _m_j.gkv;
import _m_j.gqg;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.gsy;
import _m_j.gtg;
import _m_j.gth;
import _m_j.gti;
import _m_j.gtj;
import _m_j.gtk;
import _m_j.hor;
import _m_j.hsk;
import _m_j.hsw;
import _m_j.hyv;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.Fragment;
import com.mibi.sdk.component.OrderBean;
import com.mibi.sdk.payment.Payment;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.DeductChannelAdapter;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity;
import com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity;
import com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity;
import com.xiaomi.smarthome.camera.activity.setting.VoiceBroadCastActivity;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.camera.lowpower.ScreenDeviceLinkageSettingActivity;
import com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmActivity;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.listcamera.CameraHorizontalActivity;
import com.xiaomi.smarthome.listcamera.CameraSortActivity;
import com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoWebActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class CameraManagerApiImpl implements ICameraManagerApi {
    private static final CameraManagerApiImpl INSTANCE = new CameraManagerApiImpl();
    private CloudVideoDownloadManager.ICloudVideoDownloadListener mCloudVideoDownloadListener;

    @cug
    public static CameraManagerApiImpl provideInstance() {
        return INSTANCE;
    }

    public void cameraFrameManagerDestroyAllContext(Context context) {
        gth.O000000o().O000000o(context);
    }

    public void cameraInfoRefreshManagerClear() {
        gtj.O000000o();
        gti O000000o2 = gti.O000000o();
        O000000o2.O00000o0.clear();
        O000000o2.O00000o.clear();
        SharedPreferences.Editor edit = O000000o2.f18243O000000o.edit();
        edit.putString(gti.O00000Oo(), "");
        edit.commit();
    }

    public void removeFloatWindow(boolean z) {
        gtk.O000000o();
    }

    public void addFloatWindow(Device device) {
        gtk.O000000o(device);
    }

    public void addExceptionCamerasFloatWindow() {
        gtk.O00000Oo();
    }

    public Class<?> getAlarmVideoNormalPlayerActivityClass(String str) {
        if ("cn".equals(XmPluginHostApi.instance().getGlobalSettingServer()) && DeviceConstant.isSupportNewUI(str)) {
            return AlarmVideoNormalPlayerActivityNew.class;
        }
        if ("cn".equals(XmPluginHostApi.instance().getGlobalSettingServer())) {
            return AlarmVideoNormalPlayerActivity.class;
        }
        if (TextUtils.equals("chuangmi.camera.ipc009", str) || TextUtils.equals("chuangmi.camera.ipc019", str)) {
            return AlarmVideoNormalPlayerActivityNew.class;
        }
        return AlarmVideoNormalPlayerActivity.class;
    }

    public Class<?> getAlarmVideoPlayerActivityClass(String str) {
        if ("cn".equals(XmPluginHostApi.instance().getGlobalSettingServer()) && DeviceConstant.isSupportNewUI(str)) {
            return AlarmVideoPlayerActivityNew.class;
        }
        if ("cn".equals(XmPluginHostApi.instance().getGlobalSettingServer())) {
            return AlarmVideoPlayerActivity.class;
        }
        if (TextUtils.equals("chuangmi.camera.ipc009", str) || TextUtils.equals("chuangmi.camera.ipc019", str)) {
            return AlarmVideoPlayerActivityNew.class;
        }
        return AlarmVideoPlayerActivity.class;
    }

    public Class<?> getCloudVideoDownloadActivityClass() {
        return CloudVideoDownloadActivity.class;
    }

    public Class<?> getScreenLinkageDeviceActivityClass() {
        return ScreenDeviceLinkageSettingActivity.class;
    }

    public Class<?> getAlarmVideoActivityClass(String str, String str2) {
        if (TextUtils.equals(str, "chuangmi.camera.ipc009") && !clf.O000000o(str2, "3.4.2_0200")) {
            return AlarmActivity.class;
        }
        if ("cn".equals(XmPluginHostApi.instance().getGlobalSettingServer()) && DeviceConstant.isSupportNewUI(str)) {
            return AlarmVideoActivityNew.class;
        }
        if ("cn".equals(XmPluginHostApi.instance().getGlobalSettingServer())) {
            return AlarmVideoActivity.class;
        }
        if (TextUtils.equals("chuangmi.camera.ipc009", str) || TextUtils.equals("chuangmi.camera.ipc019", str)) {
            return AlarmVideoActivityNew.class;
        }
        return AlarmVideoActivity.class;
    }

    public Class<?> getPlaybackVideoActivityClass() {
        return SDCardCloudVideoActivity.class;
    }

    public Class<?> getAlbumActivityClass() {
        return AlbumActivity.class;
    }

    public Class<?> getAlbumViewerActivityClass() {
        return LocalPicActivity.class;
    }

    public Class<?> getNASInfoActivityClass() {
        return NASInfoActivity.class;
    }

    public Class<?> getNASDiscoveryActivityClass() {
        return NASDiscoveryActivity.class;
    }

    public void addDeviceMoreMenuEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase(AlbumActivity.class.getName())) {
                chr.O000000o(chr.O00O0o0);
            } else if (str.equalsIgnoreCase(MoreCameraSettingActivity.class.getName()) || str.equalsIgnoreCase(com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.class.getName())) {
                chr.O000000o(chr.O00O0Oo0);
            } else if (str.equalsIgnoreCase(AlarmSettingV2Activity.class.getName()) || str.equalsIgnoreCase(com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmSettingV2Activity.class.getName())) {
                chr.O000000o(chr.O00O0OoO);
            } else if (str.equalsIgnoreCase(FileManagerSettingActivity.class.getName()) || str.equalsIgnoreCase(com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.class.getName())) {
                chr.O000000o(chr.O00O0Ooo);
            } else if (str.equalsIgnoreCase(hor.O000000o().getDeviceSceneActivity().getName())) {
                chr.O000000o(chr.O00O0o00);
            } else if (str.equalsIgnoreCase(hsw.O000000o().getShareDeviceActivity().getName())) {
                chr.O000000o(chr.O00O0o0O);
            } else if (str.equalsIgnoreCase(gdx.O000000o.class.getName())) {
                chr.O000000o(chr.O00O0o);
            } else if (str.equalsIgnoreCase(hyv.O000000o().getFeedbackCommonProblemActivityClassName())) {
                chr.O000000o(chr.O00O0oO0);
            } else if (str.equalsIgnoreCase(CloudVideoWebActivity.class.getName())) {
                chr.O000000o(chr.O00O0o0o);
            } else if (str.equalsIgnoreCase(VoiceBroadCastActivity.class.getName())) {
                chr.O000000o(chr.O00Oo0o);
            }
        }
    }

    public void setFullLogEnable(boolean z) {
        ckh.O0000Oo = z;
    }

    public void setForceUseSoftDecode(boolean z) {
        ckh.O00000oO = z;
    }

    public void setSaveVideoRawData(boolean z) {
        ckh.O00000oo = z;
    }

    public void setSaveAppAudioRawData(boolean z) {
        ckh.O0000O0o = z;
    }

    public void setSuperResolutionEnable(boolean z) {
        ckh.O0000OOo = z ? ckh.O00000Oo : ckh.O00000o0;
    }

    public void payWithMipayChinaMainland(final Context context, String str, final boolean z) {
        if (!TextUtils.isEmpty(str)) {
            CloudVideoNetUtils.getInstance().getMipaySignV2(str, new ICloudVideoCallback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.api.CameraManagerApiImpl.AnonymousClass1 */

                public void onCloudVideoSuccess(JSONObject jSONObject, Object obj) {
                    JSONObject optJSONObject;
                    String str;
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("result");
                        if (!TextUtils.isEmpty(optString) && optString.equals("ok") && optInt == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                            String optString2 = optJSONObject.optString("orderToken");
                            if (!TextUtils.isEmpty(optString2)) {
                                try {
                                    String str2 = new String(Base64.decode(optString2.getBytes("UTF-8"), 8));
                                    gsy.O00000Oo("MibiInterceptor", "decodedOrderTokenString ".concat(str2));
                                    try {
                                        str = new JSONObject(str2).optString("deductChannel");
                                    } catch (JSONException e) {
                                        LogType logType = LogType.CAMERA;
                                        gsy.O00000o0(logType, "MibiInterceptor", "deductChannel:" + e.getLocalizedMessage());
                                        str = null;
                                    }
                                    MiAccountManager O00000Oo = MiAccountManager.O00000Oo(context);
                                    if (O00000Oo.O00000oo() != null && O00000Oo.O00000o0()) {
                                        gsy.O000000o(4, "MibiInterceptor", "use local account");
                                        O00000Oo.O00000oO();
                                    } else if (O00000Oo.O00000Oo()) {
                                        gsy.O000000o(4, "MibiInterceptor", "use system account");
                                        O00000Oo.O00000o();
                                    } else {
                                        gqg.O000000o(context.getString(R.string.not_logged_in));
                                        return;
                                    }
                                    CameraManagerApiImpl.this.payWithOrderBean(context, str2, str, z);
                                } catch (Exception e2) {
                                    gsy.O000000o(6, "MibiInterceptor", "getMipaySign exception:" + e2.getLocalizedMessage());
                                }
                            }
                        }
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    gsy.O000000o(6, "MibiInterceptor", "onCloudVideoFailed code:" + i + " info:" + str);
                }
            });
        }
    }

    public Class<?> getCameraSortActivityClass() {
        return CameraSortActivity.class;
    }

    public Class<?> getCameraHorizontalActivityClass() {
        return CameraHorizontalActivity.class;
    }

    public void openDevicePinVerifyDialog(Fragment fragment, Context context, String str, int i) {
        CameraJumpUtils.openDevicePinVerifyDialog(fragment, context, str, i);
    }

    public void updateDevicePropsCameraDeviceOpManager(fsm<Void, fso> fsm) {
        gtg O000000o2 = gtg.O000000o();
        ArrayList arrayList = new ArrayList();
        ArrayList<gti.O000000o> arrayList2 = gti.O000000o().O00000o0;
        for (int i = 0; i < arrayList2.size(); i++) {
            gti.O000000o o000000o = arrayList2.get(i);
            if (o000000o != null) {
                for (gti.O000000o.C0109O000000o o000000o2 : o000000o.O00000oO) {
                    Device O00000o0 = fno.O000000o().O00000o0(o000000o2.f18249O000000o);
                    if (O00000o0 != null) {
                        arrayList.add(O00000o0);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            O000000o2.O000000o(arrayList, fsm);
            return;
        }
        gsy.O000000o(6, "AllCamera", "Empty");
        fsm.onSuccess(null);
    }

    public Map<String, Long> getSupportCameraModelsCameraDeviceOpManager() {
        return gtg.O000000o().O0000Oo;
    }

    public void loadAllCameraCloudStorageInfoFromServer(fsm<Void, fso> fsm) {
        gtg O000000o2 = gtg.O000000o();
        try {
            JSONObject jSONObject = new JSONObject();
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo != null) {
                jSONObject.put("region", O00oOooo.getCountry());
            } else {
                jSONObject.put("region", Locale.getDefault().getCountry());
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<gti.O000000o> arrayList = gti.O000000o().O00000o0;
            HashMap hashMap = new HashMap();
            for (gti.O000000o next : arrayList) {
                if (next != null && !TextUtils.isEmpty(next.f18248O000000o)) {
                    hashMap.put(next.f18248O000000o, next);
                    String str = fno.O000000o().O000000o(next.f18248O000000o).model;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("model", str);
                    jSONObject3.put("did", next.f18248O000000o);
                    jSONArray.put(jSONObject3);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject2.put("modelPairs", jSONArray);
                jSONObject.put("modelPairs", jSONObject2);
                CameraDeviceDataManager.getInstance().loadAllCameraCloudStorageStatus(jSONObject.toString(), new CameraDeviceDataManager.ICameraDeviceDataCallback<JSONObject>(hashMap, fsm) {
                    /* class _m_j.gtg.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Map f18234O000000o;
                    final /* synthetic */ fsm O00000Oo;

                    {
                        this.f18234O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj, Object obj2) {
                        JSONObject optJSONObject;
                        JSONArray optJSONArray;
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject == null) {
                            fsm fsm = this.O00000Oo;
                            if (fsm != null) {
                                fsm.onFailure(new fso(-9001, "result is null"));
                            }
                        } else if (jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONArray = optJSONObject.optJSONArray("didSupportInfos")) != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                gti.O000000o o000000o = (gti.O000000o) this.f18234O000000o.get(optJSONObject2.optString("did"));
                                if (o000000o != null) {
                                    boolean optBoolean = optJSONObject2.optBoolean("cloudSupport");
                                    o000000o.O00000Oo = optJSONObject2.optBoolean("isVip");
                                    o000000o.O00000o0 = optBoolean;
                                }
                            }
                        }
                    }

                    public final void onFailure(int i, String str) {
                        if (this.O00000Oo != null) {
                            gsy.O000000o(6, "CameraDeviceOpManager", "loadAllCameraCloudStorageStatus onFailure:" + i + " errorInfo:" + str);
                            this.O00000Oo.onFailure(new fso(i, str));
                        }
                    }
                });
            } else if (fsm != null) {
                fsm.onFailure(new fso(-9005, "did or model array is empty"));
            }
        } catch (Exception e) {
            gsy.O000000o(6, "CameraDeviceOpManager", "Exception:" + e.getLocalizedMessage());
            e.printStackTrace();
            if (fsm != null) {
                fsm.onFailure(new fso(-9002, "exception:" + e.getLocalizedMessage()));
            }
        }
    }

    public void swapCameraDeviceOpManager() {
        gtg O000000o2 = gtg.O000000o();
        O000000o2.O00000Oo.clear();
        O000000o2.O00000Oo.putAll(O000000o2.O00000o0);
        O000000o2.O00000o.clear();
        O000000o2.O00000o.putAll(O000000o2.O00000oO);
        O000000o2.O0000Oo.clear();
        O000000o2.O0000Oo.putAll(O000000o2.O0000OoO);
        O000000o2.O0000OOo.clear();
        O000000o2.O0000OOo.putAll(O000000o2.O0000Oo0);
        O000000o2.O00000oo.clear();
        O000000o2.O00000oo.putAll(O000000o2.O0000O0o);
    }

    public void destorySubscriberCameraDeviceOpManager() {
        gtg O000000o2 = gtg.O000000o();
        if (O000000o2.f18232O000000o != null) {
            O000000o2.f18232O000000o.destroy();
            O000000o2.f18232O000000o = null;
        }
    }

    public void disconnectAllXmStreamClient() {
        XmStreamClient.disconnectAll();
    }

    public void saveSeqToSPCameraOperationUtils() {
        cih.O00000oo();
    }

    public boolean checkShouldPreloadCameraCameraOperationUtils() {
        return cih.O0000OOo();
    }

    public void cameraPreConnectionNative() {
        try {
            cih.O00000Oo();
        } catch (Exception e) {
            cki.O00000o0("CameraManagerApiImpl", "Exception cameraPreConnectionNative:" + e.getLocalizedMessage());
        }
    }

    public void forceGetMissTutkVersionConfig(Callback<String> callback) {
        cig.O00000Oo(callback);
    }

    public void cameraAudioConfig() {
        cih.O00000o0();
    }

    public List<Device> getHomeDeviceList() {
        return ggb.O00000Oo().O0000oOO(ggb.O00000Oo().O0000OOo());
    }

    public Class<?> getLocalAlarmPlayerActivityClass() {
        return LocalAlarmPlayerActivity.class;
    }

    public List<Device> getShareDeviceList() {
        gge.O000000o();
        return gge.O00000oO();
    }

    public void payWithOrderBean(Context context, String str, String str2, boolean z) {
        OrderBean.OrderBeanBuilder orderBeanBuilder = new OrderBean.OrderBeanBuilder();
        orderBeanBuilder.setOrder(str).setChannel(str2).useBalance(true).useGiftcard(false).usePartnerGiftcard(false).setNoAccount(false).useUi(true);
        if (!z) {
            Payment.pay((Activity) context, 100, orderBeanBuilder.build());
        } else if (TextUtils.isEmpty(str2)) {
            setDeductChannelDialog(context, str);
        } else {
            Payment.signDeduct((Activity) context, 201, orderBeanBuilder.build());
        }
    }

    private void setDeductChannelDialog(Context context, String str) {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
        builder.O000000o((int) R.string.deduct_channel_selector);
        builder.O000000o(new DeductChannelAdapter(), 0, new DialogInterface.OnClickListener(context, str) {
            /* class com.xiaomi.smarthome.camera.api.$$Lambda$CameraManagerApiImpl$BOVNdtaAqGWSAQpMUrXYaiDjOoY */
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                CameraManagerApiImpl.this.lambda$setDeductChannelDialog$0$CameraManagerApiImpl(this.f$1, this.f$2, dialogInterface, i);
            }
        });
        builder.O00000oo();
    }

    public /* synthetic */ void lambda$setDeductChannelDialog$0$CameraManagerApiImpl(Context context, String str, DialogInterface dialogInterface, int i) {
        if (i == 0) {
            payWithOrderBean(context, str, "WXPAYDEDUCT", true);
            gsy.O00000o0(LogType.CAMERA, "MibiInterceptor", "deduct wechat pay");
        } else if (i == 1) {
            payWithOrderBean(context, str, "ALIPAYDEDUCT", true);
            gsy.O00000o0(LogType.CAMERA, "MibiInterceptor", "deduct alipay");
        }
        dialogInterface.dismiss();
    }

    public void getRNConfigCameraRNUtils() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lang", "en");
            jSONObject.put("name", "rn_config");
            jSONObject.put("version", "1");
        } catch (Exception unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        gsj gsj = null;
        try {
            gsj.O000000o o000000o = new gsj.O000000o();
            o000000o.f18212O000000o = "GET";
            gsj = o000000o.O00000Oo(hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).O000000o();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (gsj != null) {
            gsg.O00000Oo(gsj, new gsl() {
                /* class _m_j.cii.AnonymousClass1 */

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                }

                public final void onSuccess(Object obj, Response response) {
                }

                public final void processFailure(Call call, IOException iOException) {
                }

                public final void processResponse(Response response) {
                    JSONObject optJSONObject;
                    try {
                        String string = response.body().string();
                        gsy.O00000Oo("CameraRNUtils", "response:".concat(String.valueOf(string)));
                        if (!TextUtils.isEmpty(string) && (optJSONObject = new JSONObject(string).optJSONObject("result")) != null) {
                            JSONArray jSONArray = new JSONArray(optJSONObject.optString("content"));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                                String optString = optJSONObject2.optString("model");
                                boolean optBoolean = optJSONObject2.optBoolean("supportRN", false);
                                if (!TextUtils.isEmpty(optString)) {
                                    CommonApplication.getAppContext().getSharedPreferences(String.valueOf(optString), 0).edit().putBoolean("is_support_rn", optBoolean).apply();
                                }
                            }
                        }
                    } catch (Exception e) {
                        gsy.O000000o(6, "CameraRNUtils", "Exception:" + e.getLocalizedMessage());
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (_m_j.fvo.O0000oO() != false) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public void setEnvironment(Context context) {
        boolean z;
        boolean z2;
        ckh.O00000o = gkv.O00000oo;
        fvo.O000000o();
        boolean z3 = true;
        if (fvo.O0000oo0()) {
            fvo.O000000o();
            if (fvo.O0000o()) {
                z = true;
                ckh.O00000oO = z;
                fvo.O000000o();
                if (fvo.O0000oo0()) {
                    fvo.O000000o();
                    if (fvo.O0000oO0()) {
                        z2 = true;
                        ckh.O00000oo = z2;
                        fvo.O000000o();
                        if (fvo.O0000oo0()) {
                            fvo.O000000o();
                        }
                        z3 = false;
                        ckh.O0000O0o = z3;
                        fvo.O000000o();
                        ckh.O0000Oo = fvo.O0000ooo();
                        fvo.O000000o();
                        if (fvo.O0000oo0()) {
                            fvo.O000000o();
                            ckh.O0000OOo = fvo.O0000ooO() ? ckh.O00000Oo : ckh.O00000o0;
                        }
                        ckh.O0000OoO = context.getApplicationContext();
                        ckg.O00000Oo().f13965O000000o = new cko() {
                            /* class _m_j.cic.AnonymousClass1 */

                            public final boolean O000000o() {
                                return CoreApi.O000000o().O0000O0o();
                            }
                        };
                        cio.O00000o0().f13905O000000o = new cip() {
                            /* class _m_j.cic.AnonymousClass2 */

                            public final void O000000o() {
                                chr.O0000oO0();
                            }

                            public final void O00000Oo() {
                                chr.O0000oO();
                            }

                            public final void O000000o(dty dty) {
                                cin.O000000o(dty);
                            }
                        };
                        cki.f13967O000000o = new cki.O000000o() {
                            /* class _m_j.cic.AnonymousClass3 */

                            public final void O000000o(String str, String str2) {
                                gsy.O000000o(LogType.CAMERA, str, str2);
                            }

                            public final void O00000Oo(String str, String str2) {
                                gsy.O00000o0(LogType.CAMERA, str, str2);
                            }

                            public final void O00000o0(String str, String str2) {
                                gsy.O00000Oo(str, str2);
                            }

                            public final void O00000o(String str, String str2) {
                                if (ckh.O0000Oo) {
                                    gsy.O000000o(LogType.CAMERA, str, "full-log:".concat(String.valueOf(str2)));
                                }
                            }

                            public final void O00000oO(String str, String str2) {
                                gsy.O00000Oo(2000, str, str2);
                            }
                        };
                    }
                }
                z2 = false;
                ckh.O00000oo = z2;
                fvo.O000000o();
                if (fvo.O0000oo0()) {
                }
                z3 = false;
                ckh.O0000O0o = z3;
                fvo.O000000o();
                ckh.O0000Oo = fvo.O0000ooo();
                fvo.O000000o();
                if (fvo.O0000oo0()) {
                }
                ckh.O0000OoO = context.getApplicationContext();
                ckg.O00000Oo().f13965O000000o = new cko() {
                    /* class _m_j.cic.AnonymousClass1 */

                    public final boolean O000000o() {
                        return CoreApi.O000000o().O0000O0o();
                    }
                };
                cio.O00000o0().f13905O000000o = new cip() {
                    /* class _m_j.cic.AnonymousClass2 */

                    public final void O000000o() {
                        chr.O0000oO0();
                    }

                    public final void O00000Oo() {
                        chr.O0000oO();
                    }

                    public final void O000000o(dty dty) {
                        cin.O000000o(dty);
                    }
                };
                cki.f13967O000000o = new cki.O000000o() {
                    /* class _m_j.cic.AnonymousClass3 */

                    public final void O000000o(String str, String str2) {
                        gsy.O000000o(LogType.CAMERA, str, str2);
                    }

                    public final void O00000Oo(String str, String str2) {
                        gsy.O00000o0(LogType.CAMERA, str, str2);
                    }

                    public final void O00000o0(String str, String str2) {
                        gsy.O00000Oo(str, str2);
                    }

                    public final void O00000o(String str, String str2) {
                        if (ckh.O0000Oo) {
                            gsy.O000000o(LogType.CAMERA, str, "full-log:".concat(String.valueOf(str2)));
                        }
                    }

                    public final void O00000oO(String str, String str2) {
                        gsy.O00000Oo(2000, str, str2);
                    }
                };
            }
        }
        z = false;
        ckh.O00000oO = z;
        fvo.O000000o();
        if (fvo.O0000oo0()) {
        }
        z2 = false;
        ckh.O00000oo = z2;
        fvo.O000000o();
        if (fvo.O0000oo0()) {
        }
        z3 = false;
        ckh.O0000O0o = z3;
        fvo.O000000o();
        ckh.O0000Oo = fvo.O0000ooo();
        fvo.O000000o();
        if (fvo.O0000oo0()) {
        }
        ckh.O0000OoO = context.getApplicationContext();
        ckg.O00000Oo().f13965O000000o = new cko() {
            /* class _m_j.cic.AnonymousClass1 */

            public final boolean O000000o() {
                return CoreApi.O000000o().O0000O0o();
            }
        };
        cio.O00000o0().f13905O000000o = new cip() {
            /* class _m_j.cic.AnonymousClass2 */

            public final void O000000o() {
                chr.O0000oO0();
            }

            public final void O00000Oo() {
                chr.O0000oO();
            }

            public final void O000000o(dty dty) {
                cin.O000000o(dty);
            }
        };
        cki.f13967O000000o = new cki.O000000o() {
            /* class _m_j.cic.AnonymousClass3 */

            public final void O000000o(String str, String str2) {
                gsy.O000000o(LogType.CAMERA, str, str2);
            }

            public final void O00000Oo(String str, String str2) {
                gsy.O00000o0(LogType.CAMERA, str, str2);
            }

            public final void O00000o0(String str, String str2) {
                gsy.O00000Oo(str, str2);
            }

            public final void O00000o(String str, String str2) {
                if (ckh.O0000Oo) {
                    gsy.O000000o(LogType.CAMERA, str, "full-log:".concat(String.valueOf(str2)));
                }
            }

            public final void O00000oO(String str, String str2) {
                gsy.O00000Oo(2000, str, str2);
            }
        };
    }
}

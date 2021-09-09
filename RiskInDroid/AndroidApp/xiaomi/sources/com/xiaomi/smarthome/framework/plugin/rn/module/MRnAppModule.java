package com.xiaomi.smarthome.framework.plugin.rn.module;

import _m_j.cub;
import _m_j.etx;
import _m_j.exx;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.foc;
import _m_j.foj;
import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fsp;
import _m_j.fwq;
import _m_j.fyc;
import _m_j.fyd;
import _m_j.fyf;
import _m_j.gbr;
import _m_j.gbu;
import _m_j.gbv;
import _m_j.gdr;
import _m_j.gdt;
import _m_j.gdu;
import _m_j.gdw;
import _m_j.ggb;
import _m_j.gge;
import _m_j.gii;
import _m_j.gqb;
import _m_j.gsy;
import _m_j.gwa;
import _m_j.hig;
import _m_j.hiv;
import _m_j.hjp;
import _m_j.hna;
import _m_j.hor;
import _m_j.hsl;
import _m_j.hte;
import _m_j.hty;
import _m_j.inc;
import _m_j.izb;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.router.miio.miioplugin.IPluginCallback;
import com.xiaomi.router.miio.miioplugin.IPluginRequest;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.aitraining.AiTrainingWebActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.ModifyGroupActivity;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity;
import com.xiaomi.smarthome.frame.plugin.host.PluginActivityHostApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.DeviceNetworkInfoActivity;
import com.xiaomi.smarthome.framework.page.TimezoneActivity;
import com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule;
import com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.light.group.LightGroupManageActivity;
import com.xiaomi.smarthome.light.group.LightGroupSettingActivity;
import com.xiaomi.smarthome.light.group.LightGroupSettingV2Activity;
import com.xiaomi.smarthome.miio.activity.BleGatewayActivity;
import com.xiaomi.smarthome.multikey.PowerMultikeyActivity;
import com.xiaomi.smarthome.nfctag.ui.NFCWriteActivity;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class MRnAppModule extends gdr<gdu, gdt> {
    private gdt mServiceInterface = new gdt() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass2 */

        public final void O000000o() {
            exx.O000000o(false);
        }

        public final Observable<String> O000000o(ServerBean serverBean) {
            return hsl.O00000Oo().getServerName(serverBean);
        }

        public final String O000000o(String str) throws RemoteException {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo != null) {
                return O00000Oo.getSpecInstanceStr(str);
            }
            fyc.O00000o0("MRnAppModule", "getSpecInstanceStr error,service is null");
            return null;
        }

        public final String O00000Oo(String str) throws RemoteException {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo != null) {
                return O00000Oo.getSpecProptyValueFromSpecCard(str);
            }
            fyc.O00000o0("MRnAppModule", "getSpecProptyValueFromSpecCard error,service is null");
            return null;
        }

        public final void O00000Oo() throws RemoteException {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo == null) {
                fyc.O00000o0("MRnAppModule", "downloadRnExtModules error,service is null");
            } else {
                O00000Oo.downloadRnExtModules();
            }
        }

        public final String O000000o(String str, String str2, String str3, boolean z, String str4) {
            return CameraRouterFactory.getCameraCloudApi().getCloudVideoFileUrl(str, str2, str3, z, str4);
        }

        public final fsn O000000o(Context context, String str, String str2, fsm<JSONObject, fso> fsm) {
            return DeviceApi.getInstance().getHMBandSignature(context, str, str2, 0, 10001, fsm);
        }

        public final void O000000o(Activity activity, String str) throws RemoteException {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo == null) {
                fyc.O00000o0("MRnAppModule", "addToLauncher error: service is null");
                return;
            }
            gsy.O00000Oo("MRnAppModule", "addToLauncher did:".concat(String.valueOf(str)));
            fwq.O00000Oo(activity, new inc(str, null) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.module.$$Lambda$MRnAppModule$2$aqMb2HrhT_daWb6DneVYV6n1h1o */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Intent f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onAction(List list) {
                    MRnAppModule.AnonymousClass2.O000000o(IPluginRequest.this, this.f$1, this.f$2, list);
                }
            });
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(IPluginRequest iPluginRequest, String str, Intent intent, List list) {
            try {
                iPluginRequest.addToLauncher(str, intent);
            } catch (RemoteException e) {
                Log.e("MRnAppModule", "addToLauncher", e);
            }
        }

        public final void O000000o(String str, DeviceStat deviceStat, int i, String str2, MessageCallback messageCallback) {
            hor.O000000o().setGatewayScene(str, deviceStat, i, str2, messageCallback);
        }

        public final String O00000o0(String str) {
            return foj.O000000o(str);
        }

        public final Home O00000o(String str) throws RemoteException {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo != null) {
                return O00000Oo.getHomeByDid(str);
            }
            fyc.O00000o0("MRnAppModule", "getHomeByDid error: service is null");
            return null;
        }

        public final boolean O00000o0() {
            return CoreApi.O000000o().O0000Ooo();
        }

        public final Room O00000oO(String str) throws RemoteException {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo != null) {
                return O00000Oo.getRoomByDid(str);
            }
            fyc.O00000o0("MRnAppModule", "getRoomByDid error: service is null");
            return null;
        }

        public final void O000000o(String str, final gdw<String> gdw) {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo == null) {
                fyc.O00000o0("MRnAppModule", "revokePrivacyLicense error: service is null");
                gbr.O000000o(gdw, false, "revokePrivacyLicense,internal error,service=null");
                return;
            }
            try {
                O00000Oo.revokePrivacyLicense(str, new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass2.AnonymousClass1 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        gbr.O000000o(gdw, true, str);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        gbr.O000000o(gdw, false, str);
                    }
                });
            } catch (RemoteException e) {
                fyc.O000000o("MRnAppModule", "call revokePrivacyLicense error:", e);
                gbr.O000000o(gdw, false, "revokePrivacyLicense,internal error,call service error");
            }
        }

        public final void O000000o(String str, final int i, final gdw<String> gdw) {
            if (!TextUtils.equals(CoreApi.O000000o().O0000o0(), "923522198") || !TextUtils.equals(str, "658906")) {
                List asList = Arrays.asList(str);
                if (etx.O000000o().O00000Oo() != null) {
                    try {
                        etx.O000000o().O00000Oo().delDeviceBatch(asList, new IPluginCallback.Stub() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass2.AnonymousClass2 */

                            public void onRequestSuccess(String str) {
                                if (i == Device.PID_VIRTUAL_GROUP) {
                                    CommonApplication.getGlobalHandler().postDelayed($$Lambda$MRnAppModule$2$2$58t2PAD29h5LJT_4j2hdXSI95Z4.INSTANCE, 300);
                                }
                                gbr.O000000o(gdw, true, "success");
                            }

                            static /* synthetic */ void lambda$onRequestSuccess$0() {
                                try {
                                    etx.O000000o().O00000Oo().updateDeviceList(null);
                                } catch (Exception e) {
                                    fyc.O000000o("MRnAppModule", "deleteDevice,updateDeviceList error:", e);
                                }
                            }

                            public void onRequestFailed(int i, String str) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("code", i);
                                    jSONObject.put("err_info", str);
                                } catch (JSONException e) {
                                    fyc.O000000o("MRnAppModule", "deleteDevice,delDeviceBatch error:", e);
                                }
                                gbr.O000000o(gdw, false, jSONObject.toString());
                            }
                        });
                    } catch (RemoteException e) {
                        fyc.O000000o("MRnAppModule", "deleteDevice,delDeviceBatch error:", e);
                        gbr.O000000o(gdw, false, "call service error");
                    }
                } else {
                    gbr.O000000o(gdw, false, "service is null");
                }
            } else {
                izb.O000000o(CommonApplication.getAppContext(), (int) R.string.smarthome_device_delete_fail, 0).show();
                gbr.O000000o(gdw, false, "no permission");
            }
        }

        public final void O000000o(String str, MiServiceTokenInfo miServiceTokenInfo, MessageCallback messageCallback) {
            gwa.O000000o().refreshServiceTokenBySystemAccountNew(str, miServiceTokenInfo, messageCallback);
        }

        public final void O00000o() {
            try {
                gwa.O000000o().initMicoHelper(CommonApplication.getAppContext());
            } catch (Exception e) {
                fyc.O000000o("MRnAppModule", "initMicoHelper error:", e);
            }
        }

        public final void O00000oO() {
            try {
                IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
                if (O00000Oo != null) {
                    O00000Oo.setFreqCameraRedDotVisible(false);
                }
            } catch (RemoteException e) {
                fyc.O000000o("MRnAppModule", "clearFreqCameraNeedShowRedPoint error:", e);
            }
        }

        public final boolean O00000oo() {
            try {
                IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
                if (O00000Oo != null) {
                    return O00000Oo.getFreqCameraRedDotVisible();
                }
                return false;
            } catch (RemoteException e) {
                fyc.O000000o("MRnAppModule", "getFreqCameraRedDotVisible error:", e);
                return false;
            }
        }

        public final String O000000o(ReadableMap readableMap) {
            CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
            corntabParam.O00000o0 = readableMap.getInt("hour");
            corntabParam.O00000Oo = readableMap.getInt("minute");
            int i = readableMap.getInt("repeatType");
            if (i == 0) {
                corntabParam.O000000o(0);
                corntabParam.O0000OOo = "";
            } else if (i == 1) {
                corntabParam.O000000o(127);
                corntabParam.O0000OOo = "";
            } else if (i == 2) {
                corntabParam.O000000o(127);
                corntabParam.O0000OOo = "cn_workday";
            } else if (i == 3) {
                corntabParam.O000000o(127);
                corntabParam.O0000OOo = "cn_freeday";
            }
            if (i == 4) {
                ReadableArray array = readableMap.getArray("weekday");
                int size = array.size();
                int length = corntabParam.O0000O0o.length;
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 < length) {
                        corntabParam.O000000o(i2, array.getBoolean(i2));
                    }
                }
                corntabParam.O0000OOo = "";
            }
            if (i == 0) {
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                if ((instance.get(11) * 60) + instance.get(12) >= (corntabParam.O00000o0 * 60) + corntabParam.O00000Oo) {
                    instance2.setTimeInMillis(instance.getTimeInMillis() + 86400000);
                }
                corntabParam.O00000o = instance2.get(5);
                corntabParam.O00000oO = instance2.get(2) + 1;
            }
            return CorntabUtils.O000000o(CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), corntabParam));
        }

        public final WritableMap O00000Oo(ReadableMap readableMap) {
            String O000000o2 = gbv.O000000o(readableMap, "cron");
            if (TextUtils.isEmpty(O000000o2)) {
                return null;
            }
            String O000000o3 = gbv.O000000o(readableMap, "on_filter");
            CorntabUtils.CorntabParam O00000Oo = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), CorntabUtils.O000000o(O000000o2));
            if (!TextUtils.isEmpty(O000000o3)) {
                O00000Oo.O0000OOo = O000000o3;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("hour", O00000Oo.O00000o0);
            createMap.putInt("minute", O00000Oo.O00000Oo);
            int O00000Oo2 = O00000Oo.O00000Oo();
            createMap.putInt("repeatType", O00000Oo2 != 0 ? O00000Oo2 != 1 ? O00000Oo2 != 4 ? O00000Oo2 != 5 ? O00000Oo2 != 6 ? -1 : 3 : 2 : 4 : 1 : 0);
            createMap.putString("repeatStr", O00000Oo.O000000o(CommonApplication.getAppContext()));
            StringBuilder sb = new StringBuilder();
            if (O00000Oo.O00000Oo() == 0) {
                sb.append(O00000Oo.O000000o(CommonApplication.getAppContext()));
                sb.append(" ");
            }
            sb.append(fyd.O000000o(O00000Oo.O00000o0));
            sb.append(":");
            sb.append(fyd.O000000o(O00000Oo.O00000Oo));
            createMap.putString("timerOnDetail", sb.toString());
            WritableArray createArray = Arguments.createArray();
            for (boolean pushBoolean : O00000Oo.O0000O0o) {
                createArray.pushBoolean(pushBoolean);
            }
            createMap.putArray("weekday", createArray);
            return createMap;
        }
    };
    private gdu mUiInterface = new gdu() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1 */

        public final Class<?> O000000o() {
            return cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.device.utils.DeviceLauncher2");
        }

        public final Class<?> O000000o(String str) {
            return CameraRouterFactory.getCameraManagerApi().getAlarmVideoNormalPlayerActivityClass(str);
        }

        public final Class<?> O00000Oo(String str) {
            return CameraRouterFactory.getCameraManagerApi().getAlarmVideoPlayerActivityClass(str);
        }

        public final Class<?> O00000Oo() {
            return CameraRouterFactory.getCameraManagerApi().getCloudVideoDownloadActivityClass();
        }

        public final void O000000o(Activity activity, DeviceStat deviceStat, int i, String[] strArr, Bundle bundle) {
            gii.O000000o().showMatchingDeviceTypeActivity(activity, deviceStat, i, strArr, bundle);
        }

        public final void O000000o(Activity activity, String str, String str2) {
            if (activity != null) {
                Intent intent = new Intent(activity, ModifyGroupActivity.class);
                intent.putExtra("group_model", str);
                intent.putExtra("masterDid", str2);
                intent.putExtra("from", "plugin_device_group");
                activity.startActivity(intent);
            }
        }

        public final void O000000o(Activity activity, DeviceStat deviceStat, String str, String str2, ReadableArray readableArray, String str3) {
            if (activity != null) {
                String O000000o2 = fyf.O000000o(readableArray);
                fbt fbt = new fbt(activity, "CommonShareActivity");
                fbt.O000000o("StartActivityFrom", "rn");
                fbt.O000000o("ShareTitle", str);
                fbt.O000000o("ShareContent", str2);
                if (O000000o2 != null && O000000o2.startsWith("file://")) {
                    O000000o2 = O000000o2.substring(7);
                }
                if (!TextUtils.isEmpty(O000000o2)) {
                    if (O000000o2.endsWith(".zip")) {
                        fbt.O000000o("SHARE_IMAGE_FILE_ZIP_URL", O000000o2);
                    } else {
                        fbt.O000000o("ShareImageUrlNotZip", O000000o2);
                    }
                }
                if (deviceStat != null) {
                    fbt.O000000o("share_device_model", deviceStat.model);
                }
                fbt.O000000o("ShareUrl", str3);
                Intent intent = activity.getIntent();
                if (intent != null) {
                    fbt.O000000o(intent.getExtras());
                }
                fbs.O000000o(fbt);
            }
        }

        public final void O000000o(Activity activity, String str) {
            if (activity != null) {
                fbt fbt = new fbt(activity, "/share/ShareDeviceActivity");
                fbt.O000000o("user_id", CoreApi.O000000o().O0000o0O());
                LogType logType = LogType.PLUGIN;
                gsy.O00000o0(logType, "MRnAppModule", "openShareDevicePage, getMiId():" + CoreApi.O000000o().O0000o0());
                fbt.O000000o("did", str);
                fbs.O000000o(fbt);
            }
        }

        public final void O00000Oo(Activity activity, String str) {
            if (activity != null) {
                Intent intent = new Intent(activity, DeviceRoomAddActivity.class);
                intent.putExtra("did", str);
                activity.startActivity(intent);
            }
        }

        public final void O00000Oo(Activity activity, String str, String str2) {
            if (activity != null) {
                fbt fbt = new fbt(activity, "RNSecuritySettingActivity");
                fbt.O000000o("extra_device_did", str);
                fbt.O000000o("xiaomi.smarthome.custom_hint", str2);
                fbs.O000000o(fbt);
            }
        }

        public final void O00000o0(Activity activity, String str, String str2) {
            if (activity != null) {
                fbt fbt = new fbt(activity, "/userCenter/FeedbackCommonProblemActivity");
                fbt.O000000o("did", str2);
                fbt.O000000o("extra_model", str);
                fbs.O000000o(fbt);
            }
        }

        public final void O00000o0(Activity activity, String str) {
            if (activity != null) {
                Intent intent = new Intent(activity, BleGatewayActivity.class);
                intent.putExtra("key_gateway_did", str);
                activity.startActivity(intent);
            }
        }

        public final void O000000o(Activity activity, String str, String str2, ReadableArray readableArray, String str3, ReadableArray readableArray2) {
            if (activity != null) {
                fbs.O000000o(new fbt(activity, "/userCenter/LicenseAndPrivacyActivity").O000000o("licenseContentUri", fyf.O000000o(readableArray)).O000000o("privacyContentUri", fyf.O000000o(readableArray2)).O000000o("licenseContenttitle", str2).O000000o("privacyContenttitle", str3).O000000o("did", str).O000000o(100));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
        public final void O000000o(Activity activity, String str, String str2, String str3, ReadableArray readableArray, String str4, ReadableArray readableArray2, Callback callback) {
            String str5;
            String string;
            final Callback callback2 = callback;
            if (activity != null) {
                boolean isEmpty = TextUtils.isEmpty(fyf.O000000o(readableArray));
                if (!TextUtils.isEmpty(fyf.O000000o(readableArray2))) {
                    PluginActivityHostApi pluginActivityHostApi = fsp.O000000o().O0000Oo;
                    if (isEmpty) {
                        string = "";
                    } else if (TextUtils.isEmpty(str3)) {
                        string = activity.getString(R.string.dialog_license_title);
                    } else {
                        str5 = str3;
                        pluginActivityHostApi.showUserLicenseUriDialog(activity, str2, str5, fyf.O000000o(readableArray), !TextUtils.isEmpty(str4) ? activity.getString(R.string.dialog_privacy_title) : str4, fyf.O000000o(readableArray2), new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(View view) {
                                callback2.invoke(Boolean.TRUE);
                            }
                        }, str, null);
                        return;
                    }
                    str5 = string;
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    pluginActivityHostApi.showUserLicenseUriDialog(activity, str2, str5, fyf.O000000o(readableArray), !TextUtils.isEmpty(str4) ? activity.getString(R.string.dialog_privacy_title) : str4, fyf.O000000o(readableArray2), new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(View view) {
                            callback2.invoke(Boolean.TRUE);
                        }
                    }, str, null);
                    return;
                }
                fsp.O000000o().O0000Oo.showUserLicenseDialog(activity, str2, new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass3 */

                    public final void onClick(View view) {
                        callback2.invoke(Boolean.TRUE);
                    }
                }, str);
            }
        }

        public final void O000000o(final Activity activity, String str, final String str2, final int i) {
            if (activity != null) {
                if (TextUtils.isEmpty(str)) {
                    str = activity.getString(R.string.smarthome_delete_tips);
                }
                new MLAlertDialog.Builder(activity).O00000Oo(str).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!TextUtils.equals(CoreApi.O000000o().O0000o0(), "923522198") || !TextUtils.equals(str2, "658906")) {
                            XQProgressDialog xQProgressDialog = new XQProgressDialog(activity);
                            xQProgressDialog.setMessage(activity.getString(R.string.smarthome_deleting));
                            xQProgressDialog.setCancelable(false);
                            xQProgressDialog.show();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(str2);
                            if (etx.O000000o().O00000Oo() != null) {
                                try {
                                    etx.O000000o().O00000Oo().delDeviceBatch(arrayList, new IPluginCallback.Stub(xQProgressDialog) {
                                        /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass4.AnonymousClass1 */
                                        final /* synthetic */ XQProgressDialog val$mPD;

                                        {
                                            this.val$mPD = r2;
                                        }

                                        public void onRequestSuccess(String str) {
                                            CommonApplication.getGlobalHandler().post(new Runnable() {
                                                /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    izb.O000000o(activity, (int) R.string.smarthome_device_delete_success, 0).show();
                                                    AnonymousClass1.this.val$mPD.dismiss();
                                                    Intent intent = new Intent();
                                                    intent.putExtra("result_data", 1);
                                                    activity.setResult(-1, intent);
                                                    activity.finish();
                                                    if (i == Device.PID_VIRTUAL_GROUP) {
                                                        CommonApplication.getGlobalHandler().postDelayed($$Lambda$MRnAppModule$1$4$1$1$NSRz1Zh75czH5zmNs8uwUIer5Z8.INSTANCE, 300);
                                                    }
                                                }

                                                /* access modifiers changed from: private */
                                                public static /* synthetic */ void O000000o() {
                                                    try {
                                                        etx.O000000o().O00000Oo().updateDeviceList(null);
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            });
                                        }

                                        public void onRequestFailed(int i, String str) {
                                            CommonApplication.getGlobalHandler().post(new Runnable() {
                                                /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass4.AnonymousClass1.AnonymousClass2 */

                                                public final void run() {
                                                    izb.O000000o(activity, (int) R.string.smarthome_device_delete_fail, 0).show();
                                                    AnonymousClass1.this.val$mPD.dismiss();
                                                }
                                            });
                                        }
                                    });
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            izb.O000000o(activity, (int) R.string.smarthome_device_delete_fail, 0).show();
                        }
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                    }
                }).O00000oo();
            }
        }

        public final void O000000o(Activity activity, String str, String str2, int i, String str3, Callback callback) {
            Activity activity2 = activity;
            if (activity2 != null) {
                final ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(activity).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
                EditText editText = clientRemarkInputView.getEditText();
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(41)});
                MLAlertDialog O00000oo = new MLAlertDialog.Builder(activity2).O000000o((int) R.string.smarthome_device_rename).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        clientRemarkInputView.O000000o(dialogInterface);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                    }
                }).O00000oo();
                final String str4 = str3;
                final Activity activity3 = activity;
                final String str5 = str;
                final Callback callback2 = callback;
                final int i2 = i;
                final String str6 = str2;
                String str7 = str3;
                clientRemarkInputView.O000000o(new ClientRemarkInputView.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass8 */

                    public final void modifyBackName(final String str) {
                        if (!TextUtils.equals(str, str4)) {
                            final XQProgressDialog xQProgressDialog = new XQProgressDialog(activity3);
                            xQProgressDialog.setMessage(activity3.getString(R.string.changeing_back_name));
                            xQProgressDialog.setCancelable(false);
                            xQProgressDialog.show();
                            XmPluginHostApi.instance().modDeviceName(str5, str, new com.xiaomi.smarthome.device.api.Callback<Void>() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass8.AnonymousClass1 */

                                private void O000000o(String str, int i) {
                                    Intent intent = new Intent("action.more.rename.notify");
                                    intent.putExtra("did", str5);
                                    intent.putExtra("extra.name", str);
                                    intent.putExtra("extra.result", i);
                                    activity3.sendBroadcast(intent);
                                }

                                public final void onFailure(int i, String str) {
                                    O000000o(str4, 0);
                                    xQProgressDialog.dismiss();
                                    izb.O000000o(activity3, (int) R.string.change_back_name_fail, 0).show();
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    O000000o(str, 1);
                                    xQProgressDialog.dismiss();
                                    callback2.invoke(str);
                                    if (i2 == Device.PID_BLUETOOTH) {
                                        foc.O000000o(str6, str);
                                    }
                                    izb.O000000o(activity3, (int) R.string.change_back_name_success, 0).show();
                                }
                            });
                        }
                    }
                }, O00000oo, str7, str7);
                final Button button = O00000oo.getButton(-1);
                button.setEnabled(true);
                button.setTextColor(activity.getResources().getColor(R.color.mj_color_dialog_button1_bg_nor));
                final ClientRemarkInputView clientRemarkInputView2 = clientRemarkInputView;
                final EditText editText2 = editText;
                final Activity activity4 = activity;
                clientRemarkInputView.getEditText().addTextChangedListener(new TextWatcher() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass9 */

                    public final void afterTextChanged(Editable editable) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        clientRemarkInputView2.setAlertText("");
                        button.setEnabled(true);
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String obj = editText2.getText().toString();
                        if (obj.length() > 0) {
                            if (gqb.O00000o0(obj)) {
                                clientRemarkInputView2.setAlertText(activity4.getString(R.string.tag_save_data_description));
                            } else if (!ggb.O0000oO(obj)) {
                                clientRemarkInputView2.setAlertText(activity4.getString(R.string.room_name_too_long));
                            } else {
                                clientRemarkInputView2.setAlertText("");
                                button.setEnabled(true);
                                return;
                            }
                        }
                        button.setEnabled(false);
                    }
                });
            }
        }

        public final Class<?> O00000o0() {
            return TimezoneActivity.class;
        }

        public final Class<?> O00000o() {
            return hna.O00000o0().getScanBarcodeActivityClass();
        }

        public final Class<?> O00000oO() {
            return CameraRouterFactory.getCameraManagerApi().getScreenLinkageDeviceActivityClass();
        }

        public final Class<?> O00000oo() {
            return hor.O000000o().getCreateSceneFromRecommendActivityClass();
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
        public final void O00000o(Activity activity, String str) {
            if (activity != null) {
                Intent intent = new Intent(activity, AiTrainingWebActivity.class);
                if (CoreApi.O000000o().O0000oo()) {
                    intent.putExtra("url", "https://preview.i.ai.mi.com/mico#/skill/training");
                } else {
                    intent.putExtra("url", "https://i.ai.mi.com/mico#/skill/training");
                }
                intent.putExtra("showCloseBtn", true);
                intent.putExtra("extra_cookies", str);
                activity.startActivity(intent);
            }
        }

        public final void O00000o(Activity activity, String str, String str2) {
            hty.O000000o().openConnectSucceedPage(activity, str, str2);
        }

        public final void O000000o(Activity activity, String str, String str2, String str3) {
            hty.O000000o().openCurtainGroupNamePage(activity, str, str2, str3);
        }

        public final void O000000o(String str, String str2) throws RemoteException {
            IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
            if (O00000Oo != null) {
                O00000Oo.loadUrl(str, str2);
            }
        }

        public final void O00000Oo(String str, String str2) throws RemoteException {
            Intent buildCommonWebViewIntent = gwa.O000000o().buildCommonWebViewIntent(CommonApplication.getAppContext(), str2, str, false);
            buildCommonWebViewIntent.setFlags(268435456);
            CommonApplication.getAppContext().startActivity(buildCommonWebViewIntent);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
         arg types: [java.lang.String, int]
         candidates:
          _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
          _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
        public final void O000000o(Activity activity, DeviceStat deviceStat, String str, String str2, String str3, boolean z, boolean z2) {
            if (activity != null) {
                fbt fbt = new fbt(activity, "/userCenter/LicenseAndPrivacyActivity");
                if (z) {
                    fbt.O000000o("useDefaultLicense", true);
                } else {
                    fbt.O000000o("useDefaultLicense", false);
                    fbt.O000000o("licenseContentUri", str);
                    fbt.O000000o("licenseContenttitle", activity.getString(R.string.device_more_activity_license));
                }
                fbt.O000000o("privacyContentUri", str2);
                fbt.O000000o("privacyContenttitle", activity.getString(R.string.device_more_activity_privacy));
                fbt.O000000o("did", deviceStat.did);
                if (z2) {
                    fbt.O000000o("enable_privacy_setting", false);
                } else {
                    fbt.O000000o("enable_privacy_setting", true);
                    if (!TextUtils.isEmpty(str3)) {
                        fbt.O000000o("usrExpPlanContentRnUri", str3);
                    }
                }
                fbt.O000000o(100);
                fbs.O000000o(fbt);
            }
        }

        public final Class<?> O0000O0o() {
            return hor.O000000o().getOperationCommonWebViewActivityClass();
        }

        public final void O00000oO(Activity activity, String str, String str2) {
            PowerMultikeyActivity.startActivity(activity, str, str2, 101);
        }

        public final Class<?> O0000OOo() {
            return LightGroupSettingV2Activity.class;
        }

        public final Class<?> O0000Oo0() {
            return LightGroupSettingActivity.class;
        }

        public final Class<?> O0000Oo() {
            return LightGroupManageActivity.class;
        }

        public final Class<?> O0000OoO() {
            return hor.O000000o().getPluginRecommendSceneActivityClass();
        }

        public final Class<?> O0000Ooo() {
            return DeviceNetworkInfoActivity.class;
        }

        public final Class<?> O00000o0(String str, String str2) {
            return CameraRouterFactory.getCameraManagerApi().getAlarmVideoActivityClass(str, str2);
        }

        public final Class<?> O0000o00() {
            return CameraRouterFactory.getCameraManagerApi().getPlaybackVideoActivityClass();
        }

        public final Class<?> O0000o0() {
            return CameraRouterFactory.getCameraManagerApi().getAlbumActivityClass();
        }

        public final Class<?> O0000o0O() {
            return CameraRouterFactory.getCameraManagerApi().getAlbumViewerActivityClass();
        }

        public final void O000000o(Context context, String str, String str2) {
            CameraRouterFactory.getCameraCloudApi().openCloudVideoBuyPage(context, str, str2);
        }

        public final void O00000Oo(Context context, String str, String str2) {
            CameraRouterFactory.getCameraCloudApi().openCloudVideoManagePage(context, str, str2);
        }

        public final void O00000o0(Context context, String str, String str2) {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
            if (deviceByDid != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("h5Url");
                    boolean optBoolean = jSONObject.optBoolean("sdcardGetSuccess");
                    int optInt = jSONObject.optInt("sdcardStatus");
                    if (!TextUtils.isEmpty(optString) && !hjp.O000000o(optString, context.getString(R.string.camera_tips)) && (context instanceof Activity)) {
                        CameraRouterFactory.getCameraCloudApi().openOperationBannerPage((Activity) context, deviceByDid, optString, optBoolean, optInt, 1221);
                    }
                } catch (Exception e) {
                    gbu.O00000Oo("get url failed: " + e.getMessage());
                }
            }
        }

        public final void O000000o(Context context) {
            gge.O000000o().O00000Oo();
            fno.O000000o().O0000Oo();
            hor.O000000o().clearSceneManager();
            fno.O000000o().O0000Oo0();
            Intent intent = new Intent(context, LoginMiuiActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }

        public final void O00000Oo(Context context) {
            fbt fbt = new fbt(context, "SmartHomeMainActivity");
            fbt.O00000Oo(335544320);
            fbs.O000000o(fbt);
        }

        public final Class<?> O0000o0o() {
            return CameraRouterFactory.getCameraManagerApi().getNASInfoActivityClass();
        }

        public final Class<?> O0000o() {
            return CameraRouterFactory.getCameraManagerApi().getNASDiscoveryActivityClass();
        }

        public final Class<?> O0000oO0() {
            return hna.O00000o0().getResetPageRouteClass();
        }

        public final Class<?> O0000oO() {
            return gwa.O000000o().getStereoMainActivityClass();
        }

        public final void O000000o(Context context, String str) {
            Intent intent = new Intent(context, gwa.O000000o().getMicoMainActivityClass());
            intent.putExtra("did", str);
            intent.putExtra("from", "micoPlugin");
            context.startActivity(intent);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
         arg types: [java.lang.String, int]
         candidates:
          _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
          _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
          _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
        public final void O00000Oo(Context context, String str) {
            fbt fbt = new fbt(context, "/setting/DeviceAuthSlaveListActivity");
            fbt.O000000o("device_id", str);
            fbt.O000000o("bottom_bar", false);
            fbs.O000000o(fbt);
        }

        public final void O000000o(final Context context, String str, String str2, String str3) {
            if (!hig.O000000o()) {
                new MLAlertDialog.Builder(context).O00000Oo(context.getResources().getString(R.string.nfc_not_open_device)).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        context.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                        dialogInterface.dismiss();
                    }
                }).O00000o().show();
            } else if (!hig.O00000o0() || hig.O00000Oo()) {
                Intent intent = new Intent(context, NFCWriteActivity.class);
                intent.putExtra("write_type", 7);
                intent.putExtra("write_from", "device_plugin");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("next_action_type", hiv.f18965O000000o);
                    jSONObject.put("did", str);
                    jSONObject.put("model", str2);
                    jSONObject.put("extra_data", str3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jSONObject.keys().hasNext()) {
                    intent.putExtra("write_param", jSONObject.toString());
                    context.startActivity(intent);
                    return;
                }
                hte.O000000o(context, (int) R.string.save_fail);
            } else {
                new MLAlertDialog.Builder(context).O00000Oo(context.getResources().getString(R.string.nfc_not_permit_device)).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.set_now, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.module.MRnAppModule.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.addFlags(268435456);
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                        context.startActivity(intent);
                        dialogInterface.dismiss();
                    }
                }).O00000o().show();
            }
        }

        public final Class<?> O0000oOO() {
            return hor.O000000o().getTimerSettingActivityClass();
        }

        public final Class<?> O0000oOo() {
            return CameraRouterFactory.getCameraManagerApi().getLocalAlarmPlayerActivityClass();
        }
    };

    public String getModuleClassName() {
        return null;
    }

    public String getName() {
        return null;
    }

    public gdt getServiceInterface() {
        return this.mServiceInterface;
    }

    public gdu getUiInterface() {
        return this.mUiInterface;
    }
}

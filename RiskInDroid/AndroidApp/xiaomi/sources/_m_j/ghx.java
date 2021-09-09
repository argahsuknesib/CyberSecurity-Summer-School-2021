package _m_j;

import _m_j.fmx;
import _m_j.fuc;
import _m_j.fuf;
import _m_j.fux;
import _m_j.fwp;
import _m_j.ggb;
import _m_j.ghx;
import _m_j.gsk;
import _m_j.gtx;
import _m_j.haf;
import _m_j.hlz;
import _m_j.ing;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.QRLoginUrlInfo;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.SmartHomeMainActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.bluetooth.connect.single.BluetoothInternationLogUtil;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Field;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@RouterService
public class ghx implements hvb {
    public void createWifiScanHomelog() {
    }

    public void onConnectivityChange() {
    }

    public void onScanResultAvailable() {
    }

    public void pushActivity(Activity activity) {
        eya.O000000o().O000000o(activity);
    }

    public void popActivity(Activity activity) {
        eya.O000000o().O00000Oo(activity);
    }

    public void onStartSmartConfig(String str) {
        hna.O00000o0().onStartSmartConfig(str);
    }

    public void onFinishSmartConfig(String str, boolean z) {
        hna.O00000o0().onFinishSmartConfig(str, z);
    }

    public void sendSmartHomeRequest(ConfigNetRequest configNetRequest, final huc huc) {
        ArrayList arrayList = new ArrayList();
        if (configNetRequest.O00000o0 != null && configNetRequest.O00000o0.size() > 0) {
            for (ConfigKeyValuePair next : configNetRequest.O00000o0) {
                arrayList.add(new KeyValuePair(next.f11487O000000o, next.O00000Oo));
            }
        }
        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o(configNetRequest.f11488O000000o).O00000Oo(configNetRequest.O00000Oo).O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
            /* class _m_j.ghx.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                huc huc = huc;
                if (huc == null) {
                    return;
                }
                if (netError != null) {
                    huc.O000000o(netError.f6718O000000o, netError.O00000Oo);
                } else {
                    huc.O000000o(-9999, "error is null");
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                huc huc = huc;
                if (huc == null) {
                    return;
                }
                if (netResult != null) {
                    huc.O000000o(netResult.O00000o0);
                } else {
                    huc.O000000o(-9999, "response is null");
                }
            }
        });
    }

    public boolean isMiLoggedIn() {
        return ServiceApplication.getStateNotifier().f15923O000000o == 4;
    }

    public void addBlackList(PushBindEntity pushBindEntity) {
        hna.O00000o0().addBlackListForDevicePushBindManager(pushBindEntity);
    }

    public void bind(String str) {
        hna.O00000o0().doBindForDevicePushBindManager(str);
    }

    public void refreshDevice(String str) {
        fad.O000000o().sendBrodCard(str);
    }

    public void bindDeviceToHome(Device device, final huf huf) {
        Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
        if (device != null && O0000Oo0 != null) {
            ggb.O00000Oo().O000000o(O0000Oo0, (Room) null, device, new ggb.O00000o() {
                /* class _m_j.ghx.AnonymousClass9 */

                public final void O000000o() {
                    huf huf = huf;
                    if (huf != null) {
                        huf.accept("");
                    }
                }

                public final void O000000o(int i, fso fso) {
                    huf huf = huf;
                    if (huf != null) {
                        huf.accept("");
                    }
                }
            });
        }
    }

    public int generateNonce() {
        return ((PluginHostApi) PluginHostApi.instance()).generateNonce();
    }

    public void bleDisconnect(String str) {
        foj.getInstance().disconnect(str);
    }

    public boolean isEurope(ServerBean serverBean) {
        if (serverBean == null) {
            return false;
        }
        return ftn.O00000o(serverBean);
    }

    public boolean isEurope(Context context) {
        return ftn.O0000O0o(context);
    }

    public boolean isChinaMainLand(ServerBean serverBean) {
        return ftn.O00000o0(serverBean);
    }

    public void getDeviceDetailPageUrl(String str, huf huf) {
        fly.O000000o(str).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$ghx$izay6ApKscZ_Pn9uBODziIS8h00 */

            public final void accept(Object obj) {
                huf.this.accept((String) obj);
            }
        });
    }

    public boolean getAutoConnectNew(boolean z) {
        return gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "auto_connect_new", z);
    }

    public boolean checkScanWifiLocationPermission(Activity activity, boolean z, int i) {
        return fux.O000000o(activity, z, i);
    }

    public boolean checkScanWifiLocationPermissionAndShowDialog(Activity activity, int i, final hui hui) {
        return fux.O000000o(activity, i, new fux.O000000o() {
            /* class _m_j.ghx.AnonymousClass10 */

            public final void O000000o(boolean z) {
                hui hui = hui;
                if (hui != null) {
                    hui.O000000o(z);
                }
            }

            public final void O00000Oo(boolean z) {
                hui hui = hui;
                if (hui != null) {
                    hui.O00000Oo(z);
                }
            }

            public final void O00000o0(boolean z) {
                hui hui = hui;
                if (hui != null) {
                    hui.O00000o0(z);
                }
            }
        });
    }

    public void getLocalMiRouterDetail(final hul<fuf.O00000o0> hul) {
        String ssid;
        fmx O000000o2 = fmx.O000000o();
        AnonymousClass11 r1 = new ftt<fuf.O00000o0>() {
            /* class _m_j.ghx.AnonymousClass11 */

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                fuf.O00000o0 o00000o0 = (fuf.O00000o0) obj;
                hul hul = hul;
                if (hul != null) {
                    hul.O000000o((String) o00000o0);
                }
            }

            public final void O000000o(int i) {
                hul hul = hul;
                if (hul != null) {
                    hul.O000000o(i);
                }
            }

            public final void O000000o(int i, Object obj) {
                hul hul = hul;
                if (hul != null) {
                    hul.O00000Oo(i);
                }
            }
        };
        WifiInfo connectionInfo = ((WifiManager) CommonApplication.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (!(connectionInfo == null || (ssid = connectionInfo.getSSID()) == null)) {
            Iterator<fuf.O00000o0> it = O000000o2.f16668O000000o.iterator();
            while (it.hasNext()) {
                fuf.O00000o0 next = it.next();
                Iterator<com.xiaomi.smarthome.smartconfig.WifiInfo> it2 = next.f17173O000000o.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (iag.O000000o(ssid, it2.next().O00000o0)) {
                            r1.O000000o(next);
                            return;
                        }
                    }
                }
            }
        }
        fuc O000000o3 = fuc.O000000o();
        CommonApplication.getAppContext();
        fmx.AnonymousClass1 r2 = new ftt<fuc.O000000o>(r1) {
            /* class _m_j.fmx.AnonymousClass1 */

            /* renamed from: O000000o */
            final /* synthetic */ ftt f16669O000000o;

            {
                this.f16669O000000o = r2;
            }

            public final /* synthetic */ void O000000o(Object obj) {
                fuc.O000000o o000000o = (fuc.O000000o) obj;
                if (o000000o != null) {
                    goq.O000000o(new Runnable(o000000o.O00000Oo, this.f16669O000000o) {
                        /* class _m_j.fmx.AnonymousClass2 */

                        /* renamed from: O000000o */
                        final /* synthetic */ String f16670O000000o;
                        final /* synthetic */ ftt O00000Oo;

                        {
                            this.f16670O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void run() {
                            if (fmx.this.O00000Oo != null) {
                                fmx.O000000o(this.f16670O000000o, Base64.encodeToString(fmx.this.O00000Oo.getPublic().getEncoded(), 2), "1:1:1:1:1", new fsm<JSONObject, fso>() {
                                    /* class _m_j.fmx.AnonymousClass2.AnonymousClass1 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.optInt("code", -1) == 0) {
                                            String optString = jSONObject.optJSONObject("data").optString("url", "");
                                            fmx fmx = fmx.this;
                                            KeyPair keyPair = fmx.this.O00000Oo;
                                            String O000000o2 = fmx.O000000o(fmx.this.O00000Oo, optString);
                                            ftt ftt = AnonymousClass2.this.O00000Oo;
                                            if (!TextUtils.isEmpty(O000000o2) && keyPair != null) {
                                                fuc O000000o3 = fuc.O000000o();
                                                AnonymousClass3 r4 = new ftt<String>(keyPair, ftt) {
                                                    /* class _m_j.fmx.AnonymousClass3 */

                                                    /* renamed from: O000000o */
                                                    final /* synthetic */ KeyPair f16672O000000o;
                                                    final /* synthetic */ ftt O00000Oo;

                                                    {
                                                        this.f16672O000000o = r2;
                                                        this.O00000Oo = r3;
                                                    }

                                                    public final /* synthetic */ void O000000o(Object obj) {
                                                        try {
                                                            JSONObject jSONObject = new JSONObject(fmx.O000000o(this.f16672O000000o, new JSONObject((String) obj).optString("info", "")));
                                                            fuf.O00000o0 o00000o0 = new fuf.O00000o0();
                                                            ArrayList<com.xiaomi.smarthome.smartconfig.WifiInfo> arrayList = new ArrayList<>();
                                                            com.xiaomi.smarthome.smartconfig.WifiInfo wifiInfo = new com.xiaomi.smarthome.smartconfig.WifiInfo();
                                                            wifiInfo.O00000o0 = jSONObject.optString("2gssid");
                                                            wifiInfo.O00000oO = jSONObject.optString("2gpwd");
                                                            arrayList.add(wifiInfo);
                                                            com.xiaomi.smarthome.smartconfig.WifiInfo wifiInfo2 = new com.xiaomi.smarthome.smartconfig.WifiInfo();
                                                            wifiInfo2.O00000o0 = jSONObject.optString("5gssid");
                                                            wifiInfo2.O00000oO = jSONObject.optString("5gpwd");
                                                            arrayList.add(wifiInfo2);
                                                            o00000o0.f17173O000000o = arrayList;
                                                            fmx.this.f16668O000000o.addFirst(o00000o0);
                                                            if (fmx.this.f16668O000000o.size() > 3) {
                                                                fmx.this.f16668O000000o.removeLast();
                                                            }
                                                            if (this.O00000Oo != null) {
                                                                this.O00000Oo.O000000o(o00000o0);
                                                            }
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            ftt ftt = this.O00000Oo;
                                                            if (ftt != null) {
                                                                ftt.O000000o(-1);
                                                            }
                                                        }
                                                    }

                                                    public final void O000000o(int i) {
                                                        ftt ftt = this.O00000Oo;
                                                        if (ftt != null) {
                                                            ftt.O000000o(-1);
                                                        }
                                                    }

                                                    public final void O000000o(int i, Object obj) {
                                                        ftt ftt = this.O00000Oo;
                                                        if (ftt != null) {
                                                            ftt.O000000o(-1);
                                                        }
                                                    }
                                                };
                                                String O00000Oo = fuc.O00000Oo();
                                                fuc.f17154O000000o = O00000Oo;
                                                if (TextUtils.isEmpty(O00000Oo)) {
                                                    r4.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                                                }
                                                gsg.O000000o(O000000o3.O00000o, new gsk.O000000o().O000000o("GET").O00000Oo(String.format(O000000o2, fuc.f17154O000000o)).O000000o(), new gso(r4) {
                                                    /* class _m_j.fuc.AnonymousClass6 */

                                                    /* renamed from: O000000o */
                                                    final /* synthetic */ ftt f17160O000000o;

                                                    {
                                                        this.f17160O000000o = r2;
                                                    }

                                                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                                                        O000000o((String) obj);
                                                    }

                                                    public final void O000000o(String str) {
                                                        ftt ftt = this.f17160O000000o;
                                                        if (ftt != null) {
                                                            ftt.O000000o(str);
                                                        }
                                                    }

                                                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                                                        ftt ftt = this.f17160O000000o;
                                                        if (ftt != null) {
                                                            ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                                                        }
                                                    }
                                                });
                                            } else if (ftt != null) {
                                                ftt.O000000o(-1);
                                            }
                                        } else if (AnonymousClass2.this.O00000Oo != null) {
                                            AnonymousClass2.this.O00000Oo.O000000o(-1);
                                        }
                                    }

                                    public final void onFailure(fso fso) {
                                        if (AnonymousClass2.this.O00000Oo != null) {
                                            AnonymousClass2.this.O00000Oo.O000000o(-1);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                ftt ftt = this.f16669O000000o;
                if (ftt != null) {
                    ftt.O000000o(-1);
                }
            }

            public final void O000000o(int i) {
                ftt ftt = this.f16669O000000o;
                if (ftt != null) {
                    ftt.O000000o(i);
                }
            }

            public final void O000000o(int i, Object obj) {
                ftt ftt = this.f16669O000000o;
                if (ftt != null) {
                    ftt.O000000o(i);
                }
            }
        };
        gsy.O000000o(3, "RemoteCameraApi", "getMiRouterInfo");
        String O00000Oo = fuc.O00000Oo();
        fuc.f17154O000000o = O00000Oo;
        if (TextUtils.isEmpty(O00000Oo)) {
            r2.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
        }
        gsg.O000000o(O000000o3.O00000o, new gsk.O000000o().O000000o("GET").O00000Oo(String.format("http://%s/cgi-bin/luci/api/xqsystem/init_info", fuc.f17154O000000o)).O000000o(), new gso(r2) {
            /* class _m_j.fuc.AnonymousClass3 */

            /* renamed from: O000000o */
            final /* synthetic */ ftt f17157O000000o;

            {
                this.f17157O000000o = r2;
            }

            public final /* synthetic */ void onSuccess(Object obj, Response response) {
                O000000o((String) obj);
            }

            public final void O000000o(String str) {
                gsy.O000000o(3, "RemoteCameraApi", "getMiRouterInfo onSuccess:".concat(String.valueOf(str)));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    O000000o o000000o = new O000000o();
                    o000000o.f17161O000000o = jSONObject.optString("id");
                    o000000o.O00000Oo = jSONObject.optString("routerId");
                    o000000o.O00000o0 = jSONObject.optString("routername");
                    o000000o.O00000o = jSONObject.optString("hardware");
                    if (this.f17157O000000o != null) {
                        this.f17157O000000o.O000000o(o000000o);
                    }
                } catch (Exception unused) {
                    ftt ftt = this.f17157O000000o;
                    if (ftt != null) {
                        ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                    }
                }
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                ftt ftt = this.f17157O000000o;
                if (ftt != null) {
                    ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                }
            }
        });
    }

    public void initHomeManager() {
        ggb.O00000Oo();
    }

    public String getMiServiceToken(String str) {
        MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o(str);
        if (O000000o2 != null) {
            return O000000o2.O00000o0;
        }
        return null;
    }

    public void onStartCommand() {
        hna.O00000o0().startDeviceObserveService();
    }

    public boolean checkPassedForCamera(Activity activity, boolean z, final huf huf) {
        return fwq.O000000o(activity, z, new inc() {
            /* class _m_j.ghx.AnonymousClass12 */

            public final void onAction(List<String> list) {
                huf.accept(null);
            }
        });
    }

    public void requestDeviceImage(String str, final hua<String, hud> hua) {
        hlz.O000000o(str, new fsm<hlz.O000000o, fso>() {
            /* class _m_j.ghx.AnonymousClass13 */

            public final /* synthetic */ void onSuccess(Object obj) {
                hua.O000000o(((hlz.O000000o) obj).f19057O000000o);
            }

            public final void onFailure(fso fso) {
                hua.O000000o(new hud(fso.f17063O000000o, fso.O00000Oo));
            }
        });
    }

    public void getLoginInfo(final hua<huv, hud> hua) {
        new AsyncTask<Void, Void, huv>() {
            /* class _m_j.ghx.AnonymousClass14 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                huv huv = (huv) obj;
                super.onPostExecute(huv);
                hua hua = hua;
                if (hua == null) {
                    return;
                }
                if (huv != null) {
                    hua.O000000o(huv);
                } else {
                    hua.O000000o((hud) null);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0055 A[Catch:{ Exception -> 0x005d }] */
            private static huv O000000o() {
                HashedDeviceIdUtil.DeviceIdPolicy deviceIdPolicy;
                try {
                    HashedDeviceIdUtil.GlobalConfig instance = HashedDeviceIdUtil.GlobalConfig.getInstance();
                    Field declaredField = instance.getClass().getDeclaredField("policy");
                    declaredField.setAccessible(true);
                    deviceIdPolicy = (HashedDeviceIdUtil.DeviceIdPolicy) declaredField.get(instance);
                    try {
                        HashedDeviceIdUtil.GlobalConfig.getInstance().setPolicy(HashedDeviceIdUtil.DeviceIdPolicy.CACHED_THEN_RUNTIME_THEN_PSEUDO);
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        e = e;
                    }
                } catch (IllegalAccessException | NoSuchFieldException e2) {
                    e = e2;
                    deviceIdPolicy = null;
                    e.printStackTrace();
                    HashedDeviceIdUtil.GlobalConfig.getInstance().setPolicy(HashedDeviceIdUtil.DeviceIdPolicy.CACHED_THEN_RUNTIME_THEN_PSEUDO);
                    QRLoginUrlInfo qRLoginUrl = XMPassport.getQRLoginUrl(null, null);
                    huv huv = new huv(qRLoginUrl.serviceId, qRLoginUrl.lp, qRLoginUrl.loginUrl, qRLoginUrl.qr);
                    htr.O000000o().O00000Oo("sc_ble_login_url", qRLoginUrl.loginUrl);
                    if (deviceIdPolicy != null) {
                    }
                    return huv;
                }
                try {
                    QRLoginUrlInfo qRLoginUrl2 = XMPassport.getQRLoginUrl(null, null);
                    huv huv2 = new huv(qRLoginUrl2.serviceId, qRLoginUrl2.lp, qRLoginUrl2.loginUrl, qRLoginUrl2.qr);
                    htr.O000000o().O00000Oo("sc_ble_login_url", qRLoginUrl2.loginUrl);
                    if (deviceIdPolicy != null) {
                        HashedDeviceIdUtil.GlobalConfig.getInstance().setPolicy(deviceIdPolicy);
                    }
                    return huv2;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
        }.execute(new Void[0]);
    }

    public Boolean isMiAccountSystem(Context context) {
        MiAccountManager O00000Oo = MiAccountManager.O00000Oo(context);
        if (O00000Oo == null || O00000Oo.O00000oo() == null) {
            return null;
        }
        return Boolean.valueOf(O00000Oo.O00000Oo());
    }

    public void addToLauncher(final Activity activity, boolean z, Device device, Intent intent, String str, final hul<Void> hul) {
        fqu.O000000o(activity, z, device, intent, str, new ftt<Void>() {
            /* class _m_j.ghx.AnonymousClass15 */

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                Void voidR = (Void) obj;
                hul hul = hul;
                if (hul != null) {
                    hul.O000000o((String) voidR);
                }
            }

            public final void O000000o(int i) {
                if (i != -1) {
                    hul hul = hul;
                    if (hul != null) {
                        hul.O000000o(i);
                    }
                } else if (activity == null || Build.VERSION.SDK_INT < 23 || !activity.shouldShowRequestPermissionRationale("com.android.launcher.permission.INSTALL_SHORTCUT")) {
                    gqg.O00000Oo((int) R.string.permission_tips_denied_msg);
                } else {
                    activity.requestPermissions(new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"}, 1);
                }
            }

            public final void O000000o(int i, Object obj) {
                hul hul = hul;
                if (hul != null) {
                    hul.O00000Oo(i);
                }
            }
        });
    }

    public void addTags(Set<String> set, String str, boolean z, final huf huf) {
        ((fqv) fnn.O000000o().O00000Oo()).O000000o(set, str, z, new ggb.O00000o() {
            /* class _m_j.ghx.AnonymousClass16 */

            public final void O000000o() {
                huf huf = huf;
                if (huf != null) {
                    huf.accept("");
                }
            }

            public final void O000000o(int i, fso fso) {
                huf huf = huf;
                if (huf != null) {
                    huf.accept("");
                }
            }
        });
    }

    public void resetCurrentTag() {
        fnn.O000000o().O00000Oo().O0000Oo0();
    }

    public List<String> getDefaultRecommendTags() {
        return fnn.O000000o().O00000Oo().O00000Oo();
    }

    public List<String> getRecommendTags(Device device) {
        return fnn.O000000o().O00000Oo().O000000o(device);
    }

    public void showAddRoomDialog(Context context, List<String> list, huf huf) {
        haf.O000000o(context, new ArrayList(), new haf.O000000o() {
            /* class _m_j.$$Lambda$ghx$WIARflRWOKqLL2J6L617pXihJhc */

            public final void onSuccess(String str) {
                huf.this.accept(str);
            }
        });
    }

    public void startConnect(Context context, String str, String str2) {
        htj.O000000o(context, str, str2);
    }

    public void endConnect(Context context, String str, String str2) {
        htj.O000000o(str, str2);
    }

    public String buildHomeMIHost(Context context) {
        return hsk.O00000Oo(context);
    }

    public Context getAppContext() {
        return CommonApplication.getAppContext();
    }

    public void getLocalDeviceListAll(String str, final hua<List<Device>, hud> hua) {
        fjm.O000000o(CommonApplication.getAppContext(), new fjk<List<Device>>() {
            /* class _m_j.ghx.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                hua.O000000o((List) obj);
            }

            public final void O000000o(int i) {
                hua.O000000o(new hud(-1, String.valueOf(i)));
                hvg.O000000o(CommonApplication.getAppContext()).O00000o0("sld_error", String.valueOf(i));
            }
        });
    }

    public boolean checkAndRequestCameraPermission(Activity activity, final htz htz, String str) {
        return fwp.O000000o(activity, new fwp.O000000o() {
            /* class _m_j.ghx.AnonymousClass3 */

            public final void O000000o() {
                htz.O000000o();
            }

            public final void O00000Oo() {
                htz.O00000Oo();
            }

            public final void O00000o0() {
                htz.O00000o0();
            }

            public final void O00000o() {
                htz.O00000o();
            }
        }, str, ing.O000000o.O00000o);
    }

    public boolean checkLocationGroupGranted() {
        return fwq.O000000o(ing.O000000o.O00000o);
    }

    public boolean isLocationEnabled() {
        return fwq.O00000Oo();
    }

    public void sendMessage(Context context, String str, int i, Intent intent, Device device, boolean z, huk huk) {
        final huk huk2 = huk;
        PluginApi.getInstance().sendMessage(context, str, i, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, z, new SendMessageCallback() {
            /* class _m_j.ghx.AnonymousClass4 */

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                huk2.O000000o();
            }

            public final void onDownloadSuccess(String str) {
                huk2.O00000Oo();
            }

            public final void onDownloadFailure(PluginError pluginError) {
                huk2.O00000o0();
            }

            public final void onDownloadCancel() {
                huk2.O00000o();
            }

            public final void onSendSuccess(Bundle bundle) {
                huk2.O00000oO();
            }

            public final void onSendCancel() {
                huk2.O00000oo();
            }

            public final void onSendFailure(fso fso) {
                huk2.O000000o(fso.toString());
            }
        });
    }

    public Handler getGlobalWorkerHandler() {
        return CommonApplication.getGlobalWorkerHandler();
    }

    public <T> void commonRequestHandle(String str, String str2, List<gkw> list, Callback<T> callback, Parser<T> parser) {
        gof.O000000o(str, str2, list, callback, parser);
    }

    public void open(Context context, String str) {
        eyk.O000000o(context, str);
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean isWifi() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) fjz.O000000o().f16507O000000o.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public void startCheck(final hum hum) {
        ezt.O000000o().startCheck(new ezq() {
            /* class _m_j.ghx.AnonymousClass5 */

            public final void O000000o() {
                hum hum = hum;
                if (hum != null) {
                    hum.O000000o();
                }
            }

            public final void O00000Oo() {
                hum hum = hum;
                if (hum != null) {
                    hum.O00000Oo();
                }
            }

            public final void O00000o0() {
                hum hum = hum;
                if (hum != null) {
                    hum.O00000o0();
                }
            }
        });
    }

    public void startLogin(Context context, int i, final huj huj) {
        gty.O000000o().startLogin(context, 5, new gtx.O000000o() {
            /* class _m_j.ghx.AnonymousClass6 */

            public final void O000000o() {
                huj huj = huj;
                if (huj != null) {
                    huj.O000000o();
                }
            }
        });
    }

    public boolean isLoginSuccess() {
        return ServiceApplication.getStateNotifier().f15923O000000o == 4;
    }

    public void getDeviceDetailPageUrl(Context context, String str, View view) {
        fly.O000000o(str).subscribe(new Consumer(view, context, str) {
            /* class _m_j.$$Lambda$ghx$3to9ijWVSBw3KLWSZxO0dKivfx8 */
            private final /* synthetic */ View f$0;
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                ghx.lambda$getDeviceDetailPageUrl$3(this.f$0, this.f$1, this.f$2, (String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$getDeviceDetailPageUrl$3(View view, Context context, String str, String str2) throws Exception {
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener(context, str2, str) {
            /* class _m_j.$$Lambda$ghx$CuooFWTXOtTr1DvZ5_B1R9h1k */
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                ghx.lambda$null$2(this.f$0, this.f$1, this.f$2, view);
            }
        });
    }

    static /* synthetic */ void lambda$null$2(Context context, String str, String str2, View view) {
        OperationCommonWebViewActivity.start(context, str, null);
        hxi.O00000o.O0000o0o(str2);
    }

    public void uploadBluetoothExceptionLog(String str) {
        BluetoothInternationLogUtil.O000000o(str);
    }

    public Class<?> getSmartHomeMainActivity() {
        return SmartHomeMainActivity.class;
    }

    public void sendBrodCard(String str) {
        fad.O000000o().sendBrodCard(str);
    }

    public void enterPlugin(Device device, Activity activity, hul hul) {
        enterPlugin(device, activity, null, hul);
    }

    public void getBindKey4DynamicDid(String str, String str2, hua<JSONObject, hud> hua) {
        hty.O000000o().getBindKey4DynamicDid(str, str2, hua);
    }

    public void getBindKey(hua<String, hud> hua) {
        hty.O000000o().getBindKey(hua);
    }

    public void startConnectWifi() {
        hty.O000000o().startConnectWifi();
    }

    public void startWifiDeviceFinder() {
        hty.O000000o().startWifiDeviceFinder();
    }

    public void removeScanResult(ScanResult scanResult) {
        hty.O000000o().removeScanResult(scanResult);
    }

    public void getNewDevice(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, hua<List<Device>, hud> hua) {
        hty.O000000o().getNewDevice(context, str, z, str2, str3, str4, str5, str6, hua);
    }

    public void fetchTokenByIp(String str, hua<String, hud> hua) {
        hty.O000000o().fetchTokenByIp(str, hua);
    }

    public void bindDeviceWithCheck(Device device, hua<Integer, hud> hua) {
        hty.O000000o().bindDeviceWithCheck(device, hua);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public void forcePinCodeSettingForKorean(Device device) {
        if (CoreApi.O000OO00() && ftn.O00000oO(CoreApi.O000000o().O0000ooO())) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String str = null;
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("forcePinCode", true);
                jSONObject.put("prop.s_force_pin_code_for_korean", jSONObject3.toString());
                jSONObject2.put("did", device.did);
                jSONObject2.put("props", jSONObject);
                jSONArray.put(jSONObject2);
                str = jSONArray.toString();
            } catch (Exception unused) {
            }
            XmPluginHostApi.instance().callSmartHomeApi(device.model, "/v2/device/batch_set_props", str, new Callback<JSONObject>() {
                /* class _m_j.ghx.AnonymousClass7 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O00000Oo("xm111", "korean force pin code result:" + ((JSONObject) obj).toString());
                }

                public final void onFailure(int i, String str) {
                    gsy.O00000Oo("xm111", "korean force pin code error:".concat(String.valueOf(str)));
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public static void enterPlugin(Device device, Activity activity, gzb gzb, hul hul) {
        final boolean z;
        Device device2 = device;
        Activity activity2 = activity;
        if (activity2 == null) {
            gsy.O00000o0(LogType.KUAILIAN, "enterPlugin", "context is null!");
            return;
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device2.model);
        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(activity2, activity.getResources().getString(R.string.plugin_downloading) + O00000oO.O0000Oo0());
        final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        final XQProgressDialog xQProgressDialog = new XQProgressDialog(activity2);
        xQProgressDialog.setCancelable(true);
        xQProgressDialog.setMessage(activity.getResources().getString(R.string.loading_share_info));
        if (CoreApi.O000000o().O0000Oo(device2.model) == null && CoreApi.O000000o().O0000OoO(device2.model) == null) {
            z = true;
        } else {
            xQProgressDialog.show();
            z = false;
        }
        activity2.sendBroadcast(new Intent("bind_finish_openplugin"));
        PluginApi instance = PluginApi.getInstance();
        String str = device2.model;
        Intent intent = new Intent();
        DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2);
        final Activity activity3 = activity;
        final Device device3 = device;
        final gzb gzb2 = gzb;
        final hul hul2 = hul;
        instance.sendMessage(activity3, str, 1, intent, newDeviceStat, null, false, new SendMessageCallback() {
            /* class _m_j.ghx.AnonymousClass8 */
            private final Interpolator O0000Oo = new DecelerateInterpolator();
            private long O0000Oo0;
            private volatile ValueAnimator O0000OoO;

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                Activity activity = activity3;
                if (!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) {
                    pluginDownloadTask.O000000o(pluginDownloadTask);
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(true);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                        xQProgressHorizontalDialog2.f9117O000000o = false;
                        xQProgressHorizontalDialog2.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener(pluginDownloadTask) {
                            /* class _m_j.$$Lambda$ghx$8$UjZRCQFsQnShNNXwrti95cG5bVI */
                            private final /* synthetic */ PluginDownloadTask f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                CoreApi.O000000o().O000000o(Device.this.model, this.f$1);
                            }
                        });
                    }
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(float, float):float}
             arg types: [int, float]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(long, long):long}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(float, float):float} */
            private float O000000o() {
                if (this.O0000OoO == null) {
                    synchronized (this) {
                        if (this.O0000OoO == null) {
                            double min = (double) Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O0000Oo0)) / 4000.0f);
                            Double.isNaN(min);
                            this.O0000OoO = ValueAnimator.ofFloat((float) ((min * 0.14d) + 0.85d), 0.99f);
                            this.O0000OoO.setDuration(4000L);
                            this.O0000OoO.setInterpolator(this.O0000Oo);
                            this.O0000OoO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class _m_j.$$Lambda$ghx$8$7iPfJZraDqxyoUj1Aj3VqpziW1Q */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ghx.AnonymousClass8.O000000o(XQProgressHorizontalDialog.this, valueAnimator);
                                }
                            });
                            this.O0000OoO.start();
                        }
                    }
                }
                return ((Float) this.O0000OoO.getAnimatedValue()).floatValue();
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ void O000000o(XQProgressHorizontalDialog xQProgressHorizontalDialog, ValueAnimator valueAnimator) {
                if (xQProgressHorizontalDialog != null) {
                    xQProgressHorizontalDialog.O000000o(100, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f));
                }
            }

            public final void onDownloadProgress(String str, float f) {
                Activity activity = activity3;
                if ((activity instanceof CommonActivity) && !((CommonActivity) activity).isValid()) {
                    return;
                }
                if (z) {
                    int i = (int) (f * 100.0f);
                    if (i >= 99) {
                        if (this.O0000Oo0 == 0) {
                            this.O0000Oo0 = System.currentTimeMillis();
                        }
                        i = 99;
                    }
                    if (i == 99) {
                        O000000o();
                        return;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        double d = (double) i;
                        Double.isNaN(d);
                        xQProgressHorizontalDialog.O000000o(100, (int) (d * 0.85d));
                        return;
                    }
                    return;
                }
                XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                if (xQProgressHorizontalDialog2 != null) {
                    xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                Activity activity = activity3;
                if ((!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                Activity activity = activity3;
                if (!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    gqg.O00000Oo(pluginError.O000000o(activity3));
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                Activity activity = activity3;
                if ((!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onInstallSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                super.onInstallSuccess(str);
                Activity activity = activity3;
                if ((!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onInstallFailure(PluginError pluginError) {
                super.onInstallFailure(pluginError);
                Activity activity = activity3;
                if (!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    izb.O000000o(activity3, (int) R.string.device_enter_failed, 0).show();
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                Activity activity = activity3;
                if (!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) {
                    xQProgressDialog.dismiss();
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    gzb gzb = gzb2;
                    if (gzb != null) {
                        gzb.O000000o();
                    }
                    hul hul = hul2;
                    if (hul != null) {
                        hul.O000000o((String) null);
                    }
                }
            }

            public final void onSendFailure(fso fso) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                Activity activity = activity3;
                if (!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) {
                    if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    gqg.O00000Oo(fso.O00000Oo);
                }
            }

            public final void onSendCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                Activity activity = activity3;
                if ((!(activity instanceof CommonActivity) || ((CommonActivity) activity).isValid()) && z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }
        });
    }
}

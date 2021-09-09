package com.xiaomi.smarthome.framework.navigate;

import _m_j.cmb;
import _m_j.cmc;
import _m_j.cub;
import _m_j.exo;
import _m_j.ext;
import _m_j.ezg;
import _m_j.ezh;
import _m_j.ezk;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fuy;
import _m_j.fvc;
import _m_j.fvd;
import _m_j.gsy;
import _m_j.hor;
import _m_j.hyo;
import _m_j.hzg;
import _m_j.hzj;
import _m_j.izb;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.push.PushType;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class UrlResolver {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
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
    /* JADX WARNING: Multi-variable type inference failed */
    public static boolean O000000o(Context context, Uri uri, boolean z, boolean z2) {
        Intent intentFrom;
        Context context2 = context;
        Uri uri2 = uri;
        if (context2 == null || uri2 == null) {
            throw new RuntimeException("Context and Uri can not be null!");
        }
        try {
            if ("https".equalsIgnoreCase(uri.getScheme()) && cmc.O00000Oo()) {
                if (!cmc.O0000O0o()) {
                    cmb.O00000Oo();
                }
                cmc.O000000o(uri.toString());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        O000000o O000000o2 = O000000o.O000000o(uri);
        String path = uri.getPath();
        if (fvd.O00000o0(path)) {
            Class<?> O000000o3 = fvd.O000000o(uri, O000000o2);
            if (O000000o3 != null) {
                Intent intent = new Intent(context, O000000o3);
                for (Map.Entry next : O000000o2.O00000Oo.entrySet()) {
                    intent.putExtra((String) next.getKey(), (String) next.getValue());
                }
                if (!TextUtils.isEmpty(O000000o2.f7642O000000o)) {
                    intent.putExtra("path", O000000o2.f7642O000000o);
                }
                Class<?> O00000Oo2 = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
                if (O00000Oo2 == null || O000000o3 != O00000Oo2) {
                    intent.setFlags(268435456);
                } else {
                    if (fvc.O000000o()) {
                        intent.setFlags(603979776);
                    } else {
                        intent.setFlags(268435456);
                    }
                    intent.putExtra("source", 9);
                }
                if (z2) {
                    ((FragmentActivity) context2).startActivityForResult(intent, 1);
                } else {
                    context.startActivity(intent);
                }
                return true;
            }
        } else if (fvd.O0000OoO(path)) {
            if (path.startsWith("/shop/main")) {
                fbt fbt = new fbt(context, "SmartHomeMainActivity");
                if (fvc.O000000o()) {
                    fbt.O00000Oo(335544320);
                } else {
                    fbt.O00000Oo(268435456);
                }
                fbt.O000000o("source", 9);
                fbt.O000000o("page", "shop");
                fbt.O000000o("url", uri.toString());
                fbs.O000000o(fbt);
            } else if (z) {
                ezk.O000000o().dispatchToYouPin(uri.toString());
            } else {
                fbt fbt2 = new fbt(context, "SmartHomeMainActivity");
                if (fvc.O000000o()) {
                    fbt2.O00000Oo(335544320);
                } else {
                    fbt2.O00000Oo(268435456);
                }
                Bundle bundle = new Bundle();
                bundle.putString("url", uri.toString());
                fbt2.O000000o(bundle);
                fbt2.O000000o("source", 4);
                fbs.O000000o(fbt2);
            }
            return true;
        } else {
            uri.getHost();
            if (fvd.O0000OOo(path)) {
                fno.O000000o().O000000o(new fno.O00000o(uri) {
                    /* class com.xiaomi.smarthome.framework.navigate.$$Lambda$UrlResolver$1ZarVakgVB0ON8Xp7WllkRKKuM */
                    private final /* synthetic */ Uri f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onDeviceReady(Map map) {
                        UrlResolver.O000000o(this.f$0, map);
                    }
                });
                return true;
            }
            final String str = "";
            if (fvd.O00000o(path)) {
                final fvd.O000000o O0000Ooo = fvd.O0000Ooo(path);
                if (O0000Ooo != null && !TextUtils.isEmpty(O0000Ooo.f17249O000000o) && CoreApi.O000000o().O00000o(O0000Ooo.f17249O000000o)) {
                    if (O0000Ooo.f17249O000000o.equals("yunyi.camera.broadcast")) {
                        return O000000o(context);
                    }
                    Intent intent2 = new Intent();
                    final String str2 = str;
                    for (Map.Entry next2 : O000000o2.O00000Oo.entrySet()) {
                        intent2.putExtra((String) next2.getKey(), (String) next2.getValue());
                        if (((String) next2.getKey()).equalsIgnoreCase("did")) {
                            str2 = next2.getValue();
                        }
                    }
                    intent2.putExtra("mihome_page_navigate_path", O0000Ooo.O00000Oo);
                    final SendMessageCallbackImpl sendMessageCallbackImpl = context2 instanceof Activity ? new SendMessageCallbackImpl(context) : null;
                    if (CoreApi.O000000o().O0000O0o()) {
                        O000000o(context, O0000Ooo.f17249O000000o, O0000Ooo, str2, intent2, sendMessageCallbackImpl);
                    } else {
                        ft.O000000o(CommonApplication.getAppContext()).O000000o(new BroadcastReceiver() {
                            /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass1 */

                            public final void onReceive(Context context, Intent intent) {
                                ft.O000000o(CommonApplication.getAppContext()).O000000o(this);
                                UrlResolver.O000000o(context, O0000Ooo.f17249O000000o, O0000Ooo, str2, intent, sendMessageCallbackImpl);
                            }
                        }, new IntentFilter("ClientApiStub.onCoreReady"));
                    }
                    return true;
                }
            } else if (fvd.O0000Oo(path)) {
                return true;
            } else {
                if (fvd.O0000Oo0(path)) {
                    if (context2 instanceof Activity) {
                        final Map<String, String> map = O000000o2.O00000Oo;
                        if (map != null) {
                            str = map.get("user_id");
                        }
                        final Activity activity = (Activity) context2;
                        ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
                            /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass6 */

                            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
                            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
                            /* JADX WARNING: Multi-variable type inference failed */
                            public final void onLoginSuccess() {
                                String str = "";
                                if (TextUtils.isEmpty(str) || ServiceApplication.getStateNotifier().f15923O000000o != 4 || CoreApi.O000000o().O0000o0().equals(str)) {
                                    Map map = map;
                                    if (map != null) {
                                        str = map.get("cloud_device_identity");
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        activity.finish();
                                        return;
                                    }
                                    hyo O000000o2 = hyo.O000000o();
                                    gsy.O00000Oo("GlobalNavButtonManager", "updateFloatNavButton ".concat(String.valueOf(str)));
                                    hyo.O000000o(str);
                                    O000000o2.O00000o0.sendMessage(O000000o2.O00000o0.obtainMessage(2, str));
                                    fbt fbt = new fbt(activity, "ThirdAccountGroupListActivity");
                                    fbt.O00000Oo(276856832);
                                    fbs.O000000o(fbt);
                                    activity.finish();
                                    return;
                                }
                                new MLAlertDialog.Builder(activity).O000000o((int) R.string.account_error_title).O00000Oo(activity.getString(R.string.account_error_msg, new Object[]{str})).O00000o0(activity.getString(R.string.auth_check_config), new DialogInterface.OnClickListener() {
                                    /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass6.AnonymousClass2 */

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        activity.finish();
                                    }
                                }).O000000o(new MLAlertDialog.O000000o() {
                                    /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass6.AnonymousClass1 */

                                    public final void beforeDismissCallBack() {
                                    }

                                    public final void afterDismissCallBack() {
                                        activity.finish();
                                    }
                                }).O00000oo();
                            }

                            public final void onLoginFailed() {
                                ezh ezh;
                                if (fbs.O000000o(ezh.class, "com.xiaomi.smarthome.home.IHomeApi") == null) {
                                    ezh = new ezg();
                                } else {
                                    ezh = (ezh) fbs.O000000o(ezh.class, "com.xiaomi.smarthome.home.IHomeApi");
                                }
                                ezh.clearMultiHomeDeviceManager();
                                fno.O000000o().O0000Oo();
                                hor.O000000o().clearSceneManager();
                                fno.O000000o().O0000Oo0();
                                fbs.O000000o(new fbt(activity, "SmartHomeMainActivity"));
                                activity.finish();
                            }
                        });
                    }
                    return false;
                } else if (fvd.O00000oO(path)) {
                    fbt fbt3 = new fbt(context, "ChooseDeviceActivity");
                    fbt3.O000000o("url", uri.toString());
                    fbt3.O00000Oo(268435456);
                    fbs.O000000o(fbt3);
                    return true;
                } else if (fvd.O00000oo(path)) {
                    fbt fbt4 = new fbt(context, "/message/MessageCenterActivity");
                    fbt4.O00000Oo(268435456);
                    fbs.O000000o(fbt4);
                    return true;
                } else if (fvd.O0000O0o(path)) {
                    hzg O000000o4 = hzj.O000000o();
                    if (O000000o4 == null) {
                        return false;
                    }
                    O000000o4.init();
                    O000000o4.processUWBIntent(context, null, uri);
                    return true;
                } else if (fvd.O000000o(uri.getHost(), path)) {
                    Map<String, String> O00000o = fvd.O00000o(uri);
                    if (!O00000o.isEmpty()) {
                        String str3 = O00000o.get("did");
                        String str4 = O00000o.get("sr_id");
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && (intentFrom = hor.O000000o().getIntentFrom(context, str3, str4)) != null) {
                            intentFrom.setFlags(268435456);
                            context.startActivity(intentFrom);
                        }
                    }
                    return true;
                } else if (!TextUtils.isEmpty(uri.getHost()) && ((TextUtils.equals("home.mi.com", uri.getHost()) || uri.getHost().endsWith(".home.mi.com")) && !TextUtils.equals("/download", uri.getPath()))) {
                    fbt fbt5 = new fbt(ServiceApplication.getAppContext(), "OperationCommonWebViewActivity");
                    fbt5.O00000Oo(335544320);
                    fbt5.O000000o("url", uri.toString());
                    fbt5.O000000o("args_from_deep_link", true);
                    fbs.O000000o(fbt5);
                    return true;
                } else if (!TextUtils.equals(uri.getScheme(), "https")) {
                    return false;
                } else {
                    String host = uri.getHost();
                    if (TextUtils.isEmpty(host)) {
                        return false;
                    }
                    if (!host.endsWith(".mi.com") && !host.endsWith(".xiaomi.com")) {
                        return false;
                    }
                    fbt fbt6 = new fbt(context, "WebShellActivity");
                    fbt6.O000000o("url", uri.toString());
                    fbt6.O00000Oo(268435456);
                    fbs.O000000o(fbt6);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(Uri uri, Map map) {
        Device O000000o2 = fno.O000000o().O000000o(uri.getQueryParameter("device_id"));
        if (O000000o2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString(PushType.INNER_JUMP.getValue(), uri.getPath());
            for (String next : uri.getQueryParameterNames()) {
                bundle.putString(next, uri.getQueryParameter(next));
            }
            ext.O000000o(O000000o2).getAction(O000000o2, CommonApplication.getAppContext(), 2, bundle, false, null);
            gsy.O00000o0(LogType.PUSH, "UrlResolver", "isUpdateFirmware ".concat(String.valueOf(O000000o2)));
        }
    }

    private static boolean O000000o(final Context context) {
        Device device;
        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                device = null;
                break;
            }
            device = (Device) it.next().getValue();
            if ("yunyi.camera.broadcast".equals(device.model)) {
                break;
            }
        }
        if (device != null) {
            O000000o(context, device);
            return true;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
        builder.O00000Oo((int) R.string.yunyi_virtual_camera_create);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                final XQProgressDialog xQProgressDialog = new XQProgressDialog(context);
                xQProgressDialog.show();
                Context context = context;
                DeviceApi.getInstance().createVirtalDevice(context, context != null ? context.getResources().getString(R.string.yunyi_virtual_camera) : "", "yunyi.camera.broadcast", new fsm<Device, fso>() {
                    /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        Device device = (Device) obj;
                        fno.O000000o().O000000o(device);
                        UrlResolver.O000000o(context, device);
                        xQProgressDialog.dismiss();
                        izb.O000000o(context, (int) R.string.yunyi_virtual_camera_create_success, 0).show();
                    }

                    public final void onFailure(fso fso) {
                        xQProgressDialog.dismiss();
                        izb.O000000o(context, (int) R.string.yunyi_virtual_camera_create_fail, 0).show();
                    }
                });
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000oo();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = com.xiaomi.smarthome.frame.core.CoreApi.O000000o().O00000oO("yunyi.camera.broadcast");
     */
    public static boolean O000000o(final Context context, final Device device) {
        final PluginDeviceInfo O00000oO;
        if (device == null || O00000oO == null) {
            return false;
        }
        Location location = fuy.O000000o().O00000o0;
        if (location == null) {
            fuy.O000000o().O000000o(new fuy.O000000o() {
                /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass3 */

                public final void O000000o(String str, Location location) {
                    super.O000000o(str, location);
                    device.latitude = location.getLatitude();
                    device.longitude = location.getLongitude();
                    Intent intent = new Intent();
                    Context context = context;
                    PluginApi.getInstance().sendMessage(context, O00000oO.O00000Oo(), 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, false, context instanceof Activity ? new SendMessageCallbackImpl(context) : null);
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    izb.O000000o(context, (int) R.string.yunyi_virtual_camera_create_get_location_fail, 0).show();
                }
            });
            return true;
        }
        device.latitude = location.getLatitude();
        device.longitude = location.getLongitude();
        Intent intent = new Intent();
        SendMessageCallbackImpl sendMessageCallbackImpl = null;
        if (context instanceof Activity) {
            sendMessageCallbackImpl = new SendMessageCallbackImpl(context);
        }
        PluginApi.getInstance().sendMessage(context, O00000oO.O00000Oo(), 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, false, sendMessageCallbackImpl);
        return true;
    }

    public static void O000000o(Context context, String str, fvd.O000000o o000000o, String str2, Intent intent, SendMessageCallback sendMessageCallback) {
        fvd.O000000o o000000o2 = o000000o;
        SendMessageCallback sendMessageCallback2 = sendMessageCallback;
        if (!TextUtils.isEmpty(str2)) {
            Device O000000o2 = O000000o(str2);
            if (O000000o2 == null) {
                O00000Oo o00000Oo = new O00000Oo((byte) 0);
                final O00000Oo o00000Oo2 = o00000Oo;
                final String str3 = str2;
                final fvd.O000000o o000000o3 = o000000o;
                final Context context2 = context;
                final String str4 = str;
                final Intent intent2 = intent;
                final SendMessageCallback sendMessageCallback3 = sendMessageCallback;
                final AnonymousClass4 r0 = new fno.O000000o() {
                    /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass4 */

                    public final void onRefreshClientDeviceSuccess(int i) {
                        fno.O000000o().O00000Oo(this);
                        CommonApplication.getGlobalWorkerHandler().removeCallbacks(o00000Oo2.f7643O000000o);
                        Device O000000o2 = UrlResolver.O000000o(str3);
                        if (O000000o2 == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(o000000o3.O00000Oo) || !o000000o3.O00000Oo.equalsIgnoreCase("/")) {
                            PluginApi.getInstance().sendMessage(context2, str4, 4, intent2, null, null, false, sendMessageCallback3);
                            return;
                        }
                        PluginApi.getInstance().sendMessage(context2, str4, 1, intent2, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, sendMessageCallback3);
                    }

                    public final void onRefreshClientDeviceChanged(int i, Device device) {
                        fno.O000000o().O00000Oo(this);
                        CommonApplication.getGlobalWorkerHandler().removeCallbacks(o00000Oo2.f7643O000000o);
                    }
                };
                fno.O000000o().O000000o(r0);
                fno.O000000o().O0000Oo0();
                AnonymousClass5 r02 = new Runnable() {
                    /* class com.xiaomi.smarthome.framework.navigate.UrlResolver.AnonymousClass5 */

                    public final void run() {
                        fno.O000000o().O00000Oo(r0);
                    }
                };
                o00000Oo.f7643O000000o = r02;
                CommonApplication.getGlobalWorkerHandler().postDelayed(r02, 20000);
            } else if (TextUtils.isEmpty(o000000o2.O00000Oo) || !o000000o2.O00000Oo.equalsIgnoreCase("/")) {
                PluginApi.getInstance().sendMessage(context, str, 4, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, sendMessageCallback);
            } else {
                PluginApi.getInstance().sendMessage(context, str, 1, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, sendMessageCallback);
            }
        } else if (sendMessageCallback2 != null) {
            sendMessageCallback2.onSendFailure(new fso(-1, context.getString(R.string.code_did_is_empty)));
        }
    }

    public static Device O000000o(String str) {
        Device device = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        if (O0000O0o != null) {
            Iterator<Map.Entry<String, Device>> it = O0000O0o.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Device device2 = (Device) it.next().getValue();
                if (str.equalsIgnoreCase(device2.did)) {
                    device = device2;
                    break;
                }
            }
        }
        if (device != null) {
            return device;
        }
        for (Map.Entry<String, Device> value : fno.O000000o().O00000Oo().entrySet()) {
            Device device3 = (Device) value.getValue();
            if (str.equalsIgnoreCase(device3.did)) {
                return device3;
            }
        }
        return device;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f7642O000000o;
        public Map<String, String> O00000Oo = new HashMap();

        public static O000000o O000000o(Uri uri) {
            O000000o o000000o = new O000000o();
            o000000o.f7642O000000o = uri.getPath();
            o000000o.O00000Oo = new HashMap();
            for (String next : uri.getQueryParameterNames()) {
                o000000o.O00000Oo.put(next, uri.getQueryParameter(next));
            }
            return o000000o;
        }

        public final String toString() {
            return "page: " + this.f7642O000000o + " params: " + this.O00000Oo.toString();
        }
    }

    public static class SendMessageCallbackImpl extends SendMessageCallback {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<Context> f7644O000000o;
        XQProgressHorizontalDialog O00000Oo;

        public SendMessageCallbackImpl(Context context) {
            this.f7644O000000o = new WeakReference<>(context);
            this.O00000Oo = new XQProgressHorizontalDialog(context);
            this.O00000Oo.setMessage(context.getString(R.string.plugin_downloading));
            this.O00000Oo.O000000o(true);
            this.O00000Oo.f9117O000000o = false;
        }

        public void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
            super.onDownloadStart(str, pluginDownloadTask);
            this.O00000Oo.show();
        }

        public void onDownloadProgress(String str, float f) {
            super.onDownloadProgress(str, f);
            this.O00000Oo.O000000o(100, (int) (f * 100.0f));
        }

        public void onDownloadCancel() {
            this.O00000Oo.dismiss();
        }

        public void onDownloadFailure(PluginError pluginError) {
            this.O00000Oo.dismiss();
            if (this.f7644O000000o.get() != null) {
                izb.O000000o(this.f7644O000000o.get(), (int) R.string.plugin_download_fail, 1).show();
            }
        }

        public void onDownloadSuccess(String str) {
            super.onDownloadSuccess(str);
            this.O00000Oo.dismiss();
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Runnable f7643O000000o;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }
    }
}

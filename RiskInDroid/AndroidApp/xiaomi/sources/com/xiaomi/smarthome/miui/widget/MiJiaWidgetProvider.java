package com.xiaomi.smarthome.miui.widget;

import _m_j.cub;
import _m_j.fad;
import _m_j.far;
import _m_j.faw;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fkc;
import _m_j.fno;
import _m_j.fqw;
import _m_j.ggb;
import _m_j.gof;
import _m_j.goq;
import _m_j.gpn;
import _m_j.gsy;
import _m_j.gza;
import _m_j.gzt;
import _m_j.hcc;
import _m_j.hsd;
import _m_j.hsf;
import _m_j.hsh;
import _m_j.hxi;
import _m_j.hza;
import _m_j.izb;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.List;

public abstract class MiJiaWidgetProvider extends AppWidgetProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f10025O000000o = getClass().getCanonicalName();

    public abstract int O000000o(List<GridViewData> list);

    public abstract String O000000o();

    public abstract int O00000Oo();

    public abstract gza O00000Oo(List<GridViewData> list);

    public abstract int O00000o0();

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
    public void onReceive(Context context, Intent intent) {
        Context context2 = context;
        Intent intent2 = intent;
        gsy.O00000o0(LogType.MIJIA_WIDGET, O000000o(), "onReceive:" + intent.getAction());
        if ("android.appwidget.action.APPWIDGET_ENABLED".equals(intent.getAction())) {
            O000000o(context2, AppWidgetManager.getInstance(context), O00000Oo(context, intent), O00000o());
            O00000oo();
            goq.O00000oO(new hsh(new ICallback() {
                /* class com.xiaomi.smarthome.miui.widget.MiJiaWidgetProvider.AnonymousClass1 */

                public IBinder asBinder() {
                    return null;
                }

                public void onSuccess(Bundle bundle) throws RemoteException {
                    gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong", "LoginTask-onSuccess");
                    hza.O000000o((Application) ServiceApplication.getApplication());
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong", "LoginTask-onFailure:".concat(String.valueOf(bundle)));
                }
            }));
            O0000O0o();
        } else if ("miui.appwidget.action.APPWIDGET_UPDATE".equals(intent.getAction()) || "android.appwidget.action.APPWIDGET_UPDATE".equals(intent.getAction())) {
            boolean O00000oO = O00000oO();
            List<GridViewData> O00000o = O00000o();
            gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong_miui_widget_update" + O000000o(), "Home_inited:" + O00000oO + "---commonUseDevices:" + O00000o.size() + "--LoginStatus:" + ServiceApplication.getStateNotifier().f15923O000000o);
            LogType logType = LogType.MIJIA_WIDGET;
            StringBuilder sb = new StringBuilder("zhudong_miui_widget_update");
            sb.append(O000000o());
            gsy.O00000o0(logType, sb.toString(), "notUpdateRemoteView:" + O0000OOo());
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                O0000O0o();
            } else {
                hza.O000000o((Application) ServiceApplication.getApplication());
            }
        } else if ("com.xiaomi.smarthome.miui.widget.refresh_widget".equals(intent.getAction())) {
            gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong_REFRESH_WIDGET", "loginState:" + ServiceApplication.getStateNotifier().f15923O000000o);
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                O000000o(context, intent);
                return;
            }
            onUpdate(context2, AppWidgetManager.getInstance(context), O00000Oo(context, intent));
        } else if ("com.xiaomi.smarthome.miui.widget.open.main_activity".equals(intent.getAction())) {
            fbt fbt = new fbt(context2, "SmartHomeMainActivity");
            fbt.O00000Oo(335544320);
            fbs.O000000o(fbt);
            O000000o(context, intent);
            hxi.O00000o.f952O000000o.O000000o("widget_toapp_loginin_click", "type", Integer.valueOf(O00000Oo()));
        } else if ("com.xiaomi.smarthome.miui.widget.add.device".equals(intent.getAction())) {
            O00000oo();
            fbt fbt2 = new fbt(context2, "ChooseDeviceActivity");
            fbt2.O00000Oo(268435456);
            fbs.O000000o(fbt2);
            hxi.O00000o.f952O000000o.O000000o("widget_toapp_adddevice_click", "type", Integer.valueOf(O00000Oo()));
        } else if ("com.xiaomi.smarthome.miui.widget.item.click".equals(intent.getAction())) {
            String stringExtra = intent2.getStringExtra("widget_click_type");
            gsy.O00000o0(LogType.MIJIA_WIDGET, O000000o(), "clickType:".concat(String.valueOf(stringExtra)));
            String stringExtra2 = intent2.getStringExtra("model");
            final String stringExtra3 = intent2.getStringExtra("deviceName");
            boolean booleanExtra = intent2.getBooleanExtra("isIRDevice", false);
            O00000oo();
            if (stringExtra.equals("sub_item_click_type")) {
                hxi.O00000o.f952O000000o.O000000o("widget_card_click", "type", Integer.valueOf(O00000Oo()), "model", stringExtra2);
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(stringExtra2);
                PluginPackageInfo O0000OoO = CoreApi.O000000o().O0000OoO(stringExtra2);
                if (O0000Oo != null || O0000OoO != null || gof.O000000o() || booleanExtra) {
                    Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.device.utils.DeviceLauncher2");
                    if (O00000Oo != null) {
                        Intent intent3 = new Intent(context2, O00000Oo);
                        intent3.setComponent(new ComponentName(context.getPackageName(), O00000Oo.getName()));
                        intent3.addFlags(335544320);
                        intent3.putExtras(intent2);
                        intent3.setAction("com.xiaomi.smarthome.action.viewdevice");
                        intent3.putExtra("user_model", stringExtra2);
                        intent3.putExtra("source_tag", "short_cut");
                        intent3.putExtra("timestamp", System.currentTimeMillis());
                        intent3.putExtra("action_device_launcher_plugin_fail_no_net", ServiceApplication.getAppContext().getString(R.string.downerror_infoerror));
                        intent3.putExtra("action_device_launcher_from_widget", true);
                        context2.startActivity(intent3);
                        return;
                    }
                    return;
                }
                gsy.O00000Oo(LogType.MIJIA_WIDGET, "zhudong_click_device_list", "无网络的情况下，点击设备：".concat(String.valueOf(stringExtra2)));
                if (!fkc.O000000o().O000000o(stringExtra2)) {
                    izb.O000000o(ServiceApplication.getAppContext(), String.format(ServiceApplication.getAppContext().getString(R.string.plugin_before_network_not_avail), stringExtra3), 1).show();
                    return;
                }
                izb.O000000o(ServiceApplication.getAppContext(), String.format(ServiceApplication.getAppContext().getString(R.string.popup_select_loc_no_network), new Object[0]), 1).show();
            } else if (stringExtra.equals("sub_set_device_on_click_type")) {
                hxi.O00000o.f952O000000o.O000000o("widget_button_click", "type", Integer.valueOf(O00000Oo()), "model", stringExtra2);
                if (!gof.O000000o()) {
                    izb.O000000o(ServiceApplication.getAppContext(), String.format(ServiceApplication.getAppContext().getString(R.string.popup_select_loc_no_network), new Object[0]), 0).show();
                    gsy.O00000Oo(LogType.MIJIA_WIDGET, "zhudong_click_device_list", "无网络的情况下，点击开关：".concat(String.valueOf(stringExtra2)));
                    return;
                }
                final String stringExtra4 = intent2.getStringExtra("did");
                goq.O00000oO(new hsd(stringExtra4, intent2.getBooleanExtra("on", false), new ICallback() {
                    /* class com.xiaomi.smarthome.miui.widget.MiJiaWidgetProvider.AnonymousClass4 */

                    public IBinder asBinder() {
                        return null;
                    }

                    public void onSuccess(Bundle bundle) throws RemoteException {
                        LogType logType = LogType.MIJIA_WIDGET;
                        String O000000o2 = MiJiaWidgetProvider.this.O000000o();
                        gsy.O00000o0(logType, O000000o2, "result-onSuccess:" + bundle + "---deviceName:" + stringExtra3);
                        hza.O000000o((Application) ServiceApplication.getApplication());
                        if (MiJiaWidgetProvider.O00000o().size() == 0) {
                            gsy.O00000o0(LogType.MIJIA_WIDGET, MiJiaWidgetProvider.this.O000000o(), "设置设备状态之后CommonUseDevices为0，重试一次");
                            MiJiaWidgetProvider.this.O00000oo();
                        }
                    }

                    public void onFailure(Bundle bundle) throws RemoteException {
                        LogType logType = LogType.MIJIA_WIDGET;
                        String O000000o2 = MiJiaWidgetProvider.this.O000000o();
                        gsy.O00000o0(logType, O000000o2, "did:" + stringExtra4 + "---error-onFailure:" + bundle + "---deviceName:" + stringExtra3);
                        hza.O000000o((Application) ServiceApplication.getApplication());
                    }
                }));
            }
        } else {
            super.onReceive(context, intent);
        }
    }

    public static List<GridViewData> O00000o() {
        if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
            return fad.O000000o().getMiuiCacheDeviceList();
        }
        return ggb.O00000Oo().O0000o0();
    }

    public static boolean O00000oO() {
        LogType logType = LogType.MIJIA_WIDGET;
        gsy.O00000o0(logType, "zhudong_isDataInited", "isEnableMiuiWidgetMemoryOpt:" + far.O000000o().O00000Oo());
        LogType logType2 = LogType.MIJIA_WIDGET;
        gsy.O00000o0(logType2, "zhudong_SmartHomeDeviceManager", "init:" + fno.O000000o().O0000o00() + "---DeviceListSize:" + fno.O000000o().O00000oO().size());
        if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
            return true;
        }
        return ggb.O00000Oo().O0000OoO.O00000oo;
    }

    private void O0000O0o() {
        gsy.O00000o0(LogType.MIJIA_WIDGET, O000000o(), "runGetDeviceTaskAndUpdate");
        ServiceApplication.getGlobalWorkerHandler().post(new hsf(new ICallback.Stub() {
            /* class com.xiaomi.smarthome.miui.widget.MiJiaWidgetProvider.AnonymousClass2 */

            public void onSuccess(Bundle bundle) throws RemoteException {
                boolean O00000oO = MiJiaWidgetProvider.O00000oO();
                List<GridViewData> O00000o = MiJiaWidgetProvider.O00000o();
                gsy.O00000o0(LogType.MIJIA_WIDGET, MiJiaWidgetProvider.this.O000000o() + "_DeviceTask", "runGetDeviceTaskAndUpdate:onSuccess---inited：" + O00000oO + "---commonUseDevices：" + O00000o.size());
                hza.O000000o((Application) ServiceApplication.getApplication());
            }

            public void onFailure(Bundle bundle) throws RemoteException {
                LogType logType = LogType.MIJIA_WIDGET;
                gsy.O00000o0(logType, MiJiaWidgetProvider.this.O000000o() + "_DeviceTask", "runGetDeviceTaskAndUpdate:error");
            }
        }, true, false));
    }

    private void O000000o(Context context, Intent intent) {
        LogType logType = LogType.MIJIA_WIDGET;
        gsy.O00000o0(logType, "zhudong_tryUpdateRemoteView", "isEnableMiuiWidgetMemoryOpt:" + far.O000000o().O00000Oo());
        if (far.O000000o().O00000Oo()) {
            new AllReadyCallback(1, new Runnable(context, intent) {
                /* class com.xiaomi.smarthome.miui.widget.$$Lambda$MiJiaWidgetProvider$L9Tbu3064wcKB1r6DcoDtnU9k4 */
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ Intent f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    MiJiaWidgetProvider.this.O00000o(this.f$1, this.f$2);
                }
            });
        } else {
            new AllReadyCallback(new Runnable(context, intent) {
                /* class com.xiaomi.smarthome.miui.widget.$$Lambda$MiJiaWidgetProvider$mkj7Eh_wqLiLFVMLPqPsbSwi6u0 */
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ Intent f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    MiJiaWidgetProvider.this.O00000o0(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(Context context, Intent intent) {
        onUpdate(context, AppWidgetManager.getInstance(context), O00000Oo(context, intent));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(Context context, Intent intent) {
        onUpdate(context, AppWidgetManager.getInstance(context), O00000Oo(context, intent));
    }

    public final void O00000oo() {
        fno.O000000o().O000000o(new fno.O000000o() {
            /* class com.xiaomi.smarthome.miui.widget.MiJiaWidgetProvider.AnonymousClass3 */

            public final void onRefreshClientDeviceChanged(int i, Device device) {
            }

            public final void onRefreshClientDeviceSuccess(int i) {
                LogType logType = LogType.MIJIA_WIDGET;
                gsy.O00000o0(logType, "zhudong_send_" + MiJiaWidgetProvider.this.O000000o(), "registerClientDeviceListener:".concat(String.valueOf(i)));
                if (MiJiaWidgetProvider.O00000oO()) {
                    fno.O000000o().O00000Oo(this);
                    hza.O000000o((Application) ServiceApplication.getApplication());
                }
            }
        });
    }

    private int[] O00000Oo(Context context, Intent intent) {
        int[] intArrayExtra = intent.getIntArrayExtra("appWidgetIds");
        if (intArrayExtra != null) {
            return intArrayExtra;
        }
        return AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context.getPackageName(), this.f10025O000000o));
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        gsy.O00000o0(LogType.MIJIA_WIDGET, O000000o(), "onUpdate执行");
        if (O0000OOo()) {
            gsy.O00000o0(LogType.MIJIA_WIDGET, O000000o(), "onUpdate 不更新——isInited:false");
            return;
        }
        List<GridViewData> O00000o = O00000o();
        for (int i : iArr) {
            gsy.O00000o0(LogType.MIJIA_WIDGET, O000000o(), "onUpdate appWidgetId:".concat(String.valueOf(i)));
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), O000000o(O00000o));
            Bundle bundle = new Bundle();
            O000000o(context, remoteViews, bundle, O00000o);
            appWidgetManager.updateAppWidgetOptions(i, bundle);
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }

    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i, bundle);
    }

    private void O000000o(Context context, AppWidgetManager appWidgetManager, int[] iArr, List<GridViewData> list) {
        gsy.O00000o0(LogType.MIJIA_WIDGET, O000000o(), "updateWhenEnable执行");
        for (int i : iArr) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), O000000o(list));
            Bundle bundle = new Bundle();
            long currentTimeMillis = System.currentTimeMillis();
            bundle.putInt("widget_priority", 1);
            bundle.putString("miuiWidgetEventCode", "notice");
            bundle.putString("miuiWidgetTimestamp", String.valueOf(currentTimeMillis));
            O000000o(context, remoteViews);
            appWidgetManager.updateAppWidgetOptions(i, bundle);
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }

    private static boolean O0000OOo() {
        return !O00000oO() && ServiceApplication.getStateNotifier().f15923O000000o == 4;
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
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02c2 A[ADDED_TO_REGION] */
    private void O000000o(Context context, RemoteViews remoteViews, Bundle bundle, List<GridViewData> list) {
        int i;
        Context context2;
        String str;
        String str2;
        boolean z;
        boolean z2;
        int i2;
        String str3;
        Pair pair;
        MiJiaWidgetProvider miJiaWidgetProvider = this;
        Context context3 = context;
        RemoteViews remoteViews2 = remoteViews;
        List<GridViewData> list2 = list;
        LogType logType = LogType.MIJIA_WIDGET;
        String O000000o2 = O000000o();
        gsy.O00000o0(logType, O000000o2, "updateRemoteViewsData-commonUseDevices:" + list.size() + "---loginState:" + ServiceApplication.getStateNotifier().f15923O000000o);
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            O000000o(context, remoteViews);
            i = 1;
        } else {
            int i3 = 0;
            if (gpn.O000000o(list)) {
                remoteViews2.setViewVisibility(R.id.gridview, 8);
                remoteViews2.setViewVisibility(R.id.ll_empty_device, 0);
                remoteViews2.setViewVisibility(R.id.ll_not_login, 8);
                Intent intent = new Intent("com.xiaomi.smarthome.miui.widget.add.device");
                intent.setComponent(new ComponentName(context.getPackageName(), miJiaWidgetProvider.f10025O000000o));
                remoteViews2.setOnClickPendingIntent(R.id.ll_empty_device, PendingIntent.getBroadcast(context3, gza.O00000o0(), intent, 0));
                i = 2;
            } else {
                remoteViews2.setViewVisibility(R.id.gridview, 0);
                remoteViews2.setViewVisibility(R.id.ll_empty_device, 8);
                remoteViews2.setViewVisibility(R.id.ll_not_login, 8);
                gza O00000Oo = miJiaWidgetProvider.O00000Oo(list2);
                O00000Oo.O00000Oo(remoteViews2, O00000o0());
                int i4 = 0;
                while (i4 < O00000o0()) {
                    String str4 = miJiaWidgetProvider.f10025O000000o;
                    if (i4 < list.size()) {
                        remoteViews2.setViewVisibility(O00000Oo.O000000o(i4), i3);
                        GridViewData gridViewData = list2.get(i4);
                        Device device = gridViewData.O00000Oo;
                        if (fqw.O000000o(device.did)) {
                            remoteViews2.setViewVisibility(O00000Oo.O0000OOo(i4), 0);
                            remoteViews2.setViewVisibility(O00000Oo.O0000O0o(i4), 8);
                            remoteViews2.setTextViewText(O00000Oo.O00000Oo(i4), context.getResources().getString(R.string.phone_ir_device));
                            remoteViews2.setImageViewResource(O00000Oo.O0000OOo(i4), R.drawable.device_icon_ir_nor);
                            remoteViews2.setTextViewText(O00000Oo.O00000o0(i4), context.getResources().getString(R.string.phone));
                            remoteViews2.setViewVisibility(O00000Oo.O00000o(i4), 0);
                            int O00000oo = fqw.O00000oo();
                            O00000Oo.O000000o(remoteViews2, i4, true, String.format("%s%d", context.getResources().getQuantityString(R.plurals.ir_device_count_2, O00000oo, Integer.valueOf(O00000oo)), Integer.valueOf(O00000oo)));
                            str = "widget_click_type";
                            context2 = context3;
                        } else {
                            remoteViews2.setTextViewText(O00000Oo.O00000Oo(i4), gridViewData.O00000o0);
                            String O000000o3 = gza.O000000o(device.did) != null ? gza.O000000o(device.did) : "";
                            if (O000000o3.equals(ServiceApplication.getAppContext().getResources().getString(R.string.tag_share))) {
                                O000000o3 = ServiceApplication.getAppContext().getResources().getString(R.string.sh_share_2);
                            }
                            remoteViews2.setTextViewText(O00000Oo.O00000o0(i4), O000000o3);
                            hcc gridCard = faw.O00000o0().getGridCard(device);
                            boolean isOnlineAdvance = device.isOnlineAdvance();
                            ArrayList<Pair> deviceRenderData = faw.O00000o0().getDeviceRenderData(device, gridCard);
                            if (deviceRenderData == null || !isOnlineAdvance || deviceRenderData.size() <= 0 || (pair = deviceRenderData.get(0)) == null || !(pair.first instanceof State) || device.isSetPinCode != 0) {
                                str2 = "widget_click_type";
                            } else {
                                str2 = "widget_click_type";
                                if (State.NOR == pair.first) {
                                    z2 = true;
                                    z = false;
                                    String O000000o4 = gzt.O000000o(device.model, deviceRenderData);
                                    if (!isOnlineAdvance) {
                                        remoteViews2.setViewVisibility(O00000Oo.O00000o(i4), 0);
                                        O00000Oo.O000000o(remoteViews2, i4, false, context.getResources().getText(R.string.code_device_offline));
                                    } else if (TextUtils.isEmpty(O000000o4)) {
                                        remoteViews2.setViewVisibility(O00000Oo.O00000o(i4), 8);
                                        remoteViews2.setViewVisibility(O00000Oo.O00000oO(i4), 8);
                                        remoteViews2.setViewVisibility(O00000Oo.O00000oo(i4), 8);
                                    } else {
                                        remoteViews2.setViewVisibility(O00000Oo.O00000o(i4), 0);
                                        O00000Oo.O000000o(remoteViews2, i4, true, O000000o4);
                                    }
                                    O00000Oo.O000000o(i4, device, remoteViews2);
                                    remoteViews2.setContentDescription(O00000Oo.O0000OOo(i4), "");
                                    remoteViews2.setContentDescription(O00000Oo.O0000O0o(i4), "");
                                    if (device.isSetPinCode != 0) {
                                        remoteViews2.setContentDescription(O00000Oo.O0000OOo(i4), context.getResources().getString(R.string.mj_talkback_device_main_need_psd));
                                    } else if (z2) {
                                        if (z) {
                                            str3 = context.getResources().getString(R.string.mj_talkback_device_on);
                                        } else {
                                            str3 = context.getResources().getString(R.string.mj_talkback_device_off);
                                        }
                                        remoteViews2.setContentDescription(O00000Oo.O0000O0o(i4), str3);
                                        remoteViews2.setViewVisibility(O00000Oo.O0000OOo(i4), 8);
                                        i2 = 0;
                                        remoteViews2.setViewVisibility(O00000Oo.O0000O0o(i4), 0);
                                        remoteViews2.setImageViewResource(O00000Oo.O0000O0o(i4), z ? R.drawable.mj_widget_provider_open : R.drawable.mj_widget_provider_closed);
                                        if (!O00000Oo.O00000Oo()) {
                                            if (gpn.O00000Oo(list) <= 2) {
                                                remoteViews2.setViewVisibility(O00000Oo.O0000OOo(i4), i2);
                                                remoteViews2.setViewVisibility(O00000Oo.O0000O0o(i4), (device.isSetPinCode != 0 || !z2) ? 8 : 0);
                                            }
                                        }
                                        if (device.isSetPinCode == 0 || !z2) {
                                            context2 = context;
                                            str = str2;
                                        } else {
                                            Intent intent2 = new Intent("com.xiaomi.smarthome.miui.widget.item.click");
                                            intent2.setComponent(new ComponentName(context.getPackageName(), str4));
                                            intent2.putExtra("did", device.did);
                                            intent2.putExtra("on", z);
                                            intent2.putExtra("model", device.model);
                                            intent2.putExtra("isIRDevice", fqw.O000000o(device.did));
                                            intent2.putExtra("deviceName", gridViewData.O00000o0);
                                            str = str2;
                                            intent2.putExtra(str, "sub_set_device_on_click_type");
                                            context2 = context;
                                            remoteViews2.setOnClickPendingIntent(O00000Oo.O0000O0o(i4), PendingIntent.getBroadcast(context2, gza.O00000o0(), intent2, 0));
                                        }
                                    }
                                    i2 = 0;
                                    remoteViews2.setViewVisibility(O00000Oo.O0000OOo(i4), 0);
                                    remoteViews2.setViewVisibility(O00000Oo.O0000O0o(i4), 8);
                                    if (!O00000Oo.O00000Oo()) {
                                    }
                                    if (device.isSetPinCode == 0) {
                                    }
                                    context2 = context;
                                    str = str2;
                                } else if (State.SELECTED == pair.first) {
                                    z2 = true;
                                    z = true;
                                    String O000000o42 = gzt.O000000o(device.model, deviceRenderData);
                                    if (!isOnlineAdvance) {
                                    }
                                    O00000Oo.O000000o(i4, device, remoteViews2);
                                    remoteViews2.setContentDescription(O00000Oo.O0000OOo(i4), "");
                                    remoteViews2.setContentDescription(O00000Oo.O0000O0o(i4), "");
                                    if (device.isSetPinCode != 0) {
                                    }
                                    i2 = 0;
                                    remoteViews2.setViewVisibility(O00000Oo.O0000OOo(i4), 0);
                                    remoteViews2.setViewVisibility(O00000Oo.O0000O0o(i4), 8);
                                    if (!O00000Oo.O00000Oo()) {
                                    }
                                    if (device.isSetPinCode == 0) {
                                    }
                                    context2 = context;
                                    str = str2;
                                }
                            }
                            z2 = false;
                            z = false;
                            String O000000o422 = gzt.O000000o(device.model, deviceRenderData);
                            if (!isOnlineAdvance) {
                            }
                            O00000Oo.O000000o(i4, device, remoteViews2);
                            remoteViews2.setContentDescription(O00000Oo.O0000OOo(i4), "");
                            remoteViews2.setContentDescription(O00000Oo.O0000O0o(i4), "");
                            if (device.isSetPinCode != 0) {
                            }
                            i2 = 0;
                            remoteViews2.setViewVisibility(O00000Oo.O0000OOo(i4), 0);
                            remoteViews2.setViewVisibility(O00000Oo.O0000O0o(i4), 8);
                            if (!O00000Oo.O00000Oo()) {
                            }
                            if (device.isSetPinCode == 0) {
                            }
                            context2 = context;
                            str = str2;
                        }
                        Intent intent3 = new Intent("com.xiaomi.smarthome.miui.widget.item.click");
                        intent3.setComponent(new ComponentName(context.getPackageName(), str4));
                        intent3.putExtra("from_main_activity", true);
                        intent3.putExtra("device_mac", device.mac);
                        intent3.putExtra("device_id", device.did);
                        intent3.putExtra(str, "sub_item_click_type");
                        intent3.putExtra("model", device.model);
                        intent3.putExtra("deviceName", gridViewData.O00000o0);
                        intent3.putExtra("isIRDevice", fqw.O000000o(device.did));
                        remoteViews2.setOnClickPendingIntent(O00000Oo.O000000o(i4), PendingIntent.getBroadcast(context2, gza.O00000o0(), intent3, 0));
                    } else {
                        context2 = context3;
                    }
                    i4++;
                    miJiaWidgetProvider = this;
                    list2 = list;
                    context3 = context2;
                    i3 = 0;
                }
                i = 3;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle2 = bundle;
        bundle2.putInt("widget_priority", i);
        bundle2.putString("miuiWidgetEventCode", "notice");
        bundle2.putString("miuiWidgetTimestamp", String.valueOf(currentTimeMillis));
    }

    private void O000000o(Context context, RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.gridview, 8);
        remoteViews.setViewVisibility(R.id.ll_empty_device, 8);
        remoteViews.setViewVisibility(R.id.ll_not_login, 0);
        Intent intent = new Intent("com.xiaomi.smarthome.miui.widget.open.main_activity");
        intent.setComponent(new ComponentName(context.getPackageName(), this.f10025O000000o));
        remoteViews.setOnClickPendingIntent(R.id.ll_not_login, PendingIntent.getBroadcast(context, gza.O00000o0(), intent, 0));
    }
}

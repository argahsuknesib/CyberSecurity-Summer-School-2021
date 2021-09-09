package com.xiaomi.smarthome.device.renderer;

import _m_j.eyc;
import _m_j.ez;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fi;
import _m_j.fkc;
import _m_j.fkw;
import _m_j.fno;
import _m_j.fqq;
import _m_j.fqu;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftg;
import _m_j.fvt;
import _m_j.fvu;
import _m_j.gfr;
import _m_j.gof;
import _m_j.gou;
import _m_j.gqa;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hmq;
import _m_j.hsi;
import _m_j.htt;
import _m_j.htv;
import _m_j.htw;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hzf;
import _m_j.izb;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.ApDevice;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.MiioVirtualDevice;
import com.xiaomi.smarthome.device.ZhilianCameraDevice;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.bluetooth.connect.ConnectBaseActivity;
import com.xiaomi.smarthome.device.renderer.PluginDownloadingRecord;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.frame.plugin.SendMessageHandle;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.framework.navigate.UrlResolver;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class DeviceRenderer implements eyc, ez {
    public static Device mClickedDevice = null;
    public static boolean mListItemIsClicked = false;
    protected static Map<Device, PluginDownloadingRecord> mPluginDownloadingRecordMap = new HashMap();
    protected static Map<Device, PluginDownloadingRecord> mPluginSendingRecordMap = new HashMap();

    public static eyc get(Device device) {
        if (device instanceof ApDevice) {
            return new ApDeviceRenderer();
        }
        if (device instanceof BleDevice) {
            return new BleDeviceRenderer();
        }
        if (device instanceof MiioVirtualDevice) {
            return new MiioVirtualDeviceRenderer();
        }
        if (device instanceof MiTVDevice) {
            return new MiTVDeviceRenderer();
        }
        if (device instanceof ZhilianCameraDevice) {
            return new ZhilianDeviceRenderer();
        }
        return new DeviceRenderer();
    }

    @fi(O000000o = Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        mListItemIsClicked = false;
    }

    public Intent getAction(Device device, Context context, Bundle bundle, boolean z, eyc.O000000o o000000o) {
        return getAction(device, context, 1, bundle, z, o000000o);
    }

    public Intent getAction(Device device, Context context, int i, Bundle bundle, boolean z, eyc.O000000o o000000o) {
        Intent intent;
        Bundle bundle2;
        String str;
        Intent intent2;
        boolean z2;
        List<Device> O00000oO;
        final Device device2 = device;
        Context context2 = context;
        Bundle bundle3 = bundle;
        boolean z3 = z;
        gsy.O00000o0(LogType.GENERAL, "DeviceRenderer", "click_device_list getAction in");
        if (!CoreApi.O000000o().O0000Ooo()) {
            boolean z4 = context2 instanceof Activity;
            if (z4) {
                CommonApplication.getApplication().showAppLoginDialog((Activity) context2, false);
            } else if (z4) {
                CommonApplication.getApplication().showAppLoginDialog((Activity) context2, false);
            }
            return null;
        } else if (!htt.O000000o(device2.model) || !((O00000oO = fno.O000000o().O00000oO(device2.did)) == null || O00000oO.size() == 0)) {
            if (!device.isBinded() && !device2.canUseNotBind) {
                izb.O000000o(CommonApplication.getAppContext(), (int) R.string.miio_not_bind_device, 0).show();
                intent2 = null;
                str = "DeviceRenderer";
                bundle2 = bundle3;
            } else if (!CoreApi.O000000o().O00000o(device2.model)) {
                intent2 = null;
                str = "DeviceRenderer";
                bundle2 = bundle3;
                gsy.O00000Oo(LogType.GENERAL, "click_device_list", "DeviceRenderer.getAction not isPluginDevice " + device2.model);
                gsy.O00000Oo(LogType.GENERAL, str, "click_device_list DeviceRender.getAction DeviceRenderer.getAction not isPluginDevice " + device2.model);
                Bundle bundle4 = new Bundle();
                Class<?> deviceShortcutUtils_getActivity = deviceShortcutUtils_getActivity(device2.did, device2.model, bundle4);
                if (deviceShortcutUtils_getActivity != null) {
                    intent = new Intent(context2, deviceShortcutUtils_getActivity);
                    intent.putExtras(bundle4);
                } else if (!TextUtils.isEmpty(device2.model) && device2.model.startsWith("xiaomi.router")) {
                    intent = fqu.O000000o(context2, device2.did);
                }
                if (!(intent == null || bundle2 == null)) {
                    intent.putExtras(bundle2);
                }
                gsy.O00000Oo(LogType.GENERAL, str, "click_device_list DeviceRender.getAction end:" + device2.model + ", 0 - " + System.currentTimeMillis());
                gsy.O000000o(6, "Device_Renderer", device2.model + ", 0 - " + System.currentTimeMillis());
                return intent;
            } else if ("yunyi.camera.broadcast".equals(device2.model)) {
                UrlResolver.O000000o(context2, device2);
                return null;
            } else {
                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device2.model);
                if (O00000oO2 == null) {
                    gsy.O00000Oo(LogType.GENERAL, "click_device_list", "DeviceRenderer.getAction cannot find PluginRecord " + device2.model);
                    gsy.O00000Oo(LogType.GENERAL, "DeviceRenderer", "click_device_list DeviceRenderer.getAction cannot find PluginRecord " + device2.model);
                    return null;
                }
                final PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(device2.model);
                PluginPackageInfo O0000OoO = CoreApi.O000000o().O0000OoO(device2.model);
                if (O0000Oo == null && O0000OoO == null && !gof.O000000o() && !fkc.O000000o().O000000o(device2.model)) {
                    izb.O000000o(context2, String.format(context2.getString(R.string.plugin_before_network_not_avail), O00000oO2.O0000Oo0()), 1).show();
                    gsy.O00000Oo(LogType.GENERAL, "click_device_list", "DeviceRenderer.getAction null 1111");
                    return null;
                } else if (O0000Oo == null && O0000OoO == null && new File(fkw.O000000o(context)).getUsableSpace() < 31457280) {
                    izb.O000000o(context2, (int) R.string.space_not_enable, 1).show();
                    gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "The storage space of the mobile phone is less than 30M");
                    return null;
                } else {
                    if (gfr.O0000OOo || gfr.O0000Oo) {
                        z2 = isRnNativeDebugModelToOpenPlugin(device);
                        if (O0000Oo == null && z2) {
                            MockRnDevicePluginManager.getInstance().addMockInfo(DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2));
                        }
                    } else {
                        z2 = false;
                    }
                    gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, isGeekMode: " + z3 + "  isRnNativeDebug: " + z2);
                    if (z3) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("rn_native_debug_model", z2);
                        device2.setLaunchParams(intent3);
                        if (bundle3 != null) {
                            intent3.putExtras(bundle3);
                        }
                        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(context2, context2.getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0());
                        new PluginDownloadTask();
                        final boolean z5 = O0000Oo == null && O0000OoO == null;
                        SendMessageHandle sendMessageHandle = new SendMessageHandle();
                        PluginApi instance = PluginApi.getInstance();
                        String str2 = device2.model;
                        DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2);
                        final Context context3 = context;
                        final SendMessageHandle sendMessageHandle2 = sendMessageHandle;
                        final eyc.O000000o o000000o2 = o000000o;
                        AnonymousClass2 r0 = new SendMessageCallback() {
                            /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass2 */
                            private long O0000OOo;
                            private volatile ValueAnimator O0000Oo;
                            private final Interpolator O0000Oo0 = new DecelerateInterpolator();

                            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                                Context context = context3;
                                if (!(context instanceof CommonActivity) || ((CommonActivity) context).isValid()) {
                                    gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, onDownloadStart...");
                                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                                    xQProgressHorizontalDialog.f9117O000000o = false;
                                    xQProgressHorizontalDialog.setCancelable(true);
                                    O000000o2.O000000o(true);
                                    O000000o2.setCanceledOnTouchOutside(false);
                                    O000000o2.show();
                                    O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                        /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass2.AnonymousClass1 */

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            sendMessageHandle2.cancel();
                                        }
                                    });
                                }
                            }

                            public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                                gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, onDownInfoSuccess...");
                                O000000o2.O000000o(100, 0);
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
                                if (this.O0000Oo == null) {
                                    synchronized (this) {
                                        if (this.O0000Oo == null) {
                                            double min = (double) Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O0000OOo)) / 4000.0f);
                                            Double.isNaN(min);
                                            this.O0000Oo = ValueAnimator.ofFloat((float) ((min * 0.14d) + 0.85d), 0.99f);
                                            this.O0000Oo.setDuration(4000L);
                                            this.O0000Oo.setInterpolator(this.O0000Oo0);
                                            this.O0000Oo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                                /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass2.AnonymousClass2 */

                                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                                    if (O000000o2 != null) {
                                                        O000000o2.O000000o(100, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f));
                                                    }
                                                }
                                            });
                                            this.O0000Oo.start();
                                        }
                                    }
                                }
                                return ((Float) this.O0000Oo.getAnimatedValue()).floatValue();
                            }

                            public final void onDownloadProgress(String str, float f) {
                                if (z5) {
                                    int i = (int) (f * 100.0f);
                                    if (i >= 99) {
                                        if (this.O0000OOo == 0) {
                                            this.O0000OOo = System.currentTimeMillis();
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
                                if (!z5 && (xQProgressHorizontalDialog = O000000o2) != null) {
                                    xQProgressHorizontalDialog.dismiss();
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O000000o(logType, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, onDownloadSuccess..." + z5);
                            }

                            public final void onInstallSuccess(String str) {
                                PluginPackageInfo pluginPackageInfo;
                                if (!(O000000o2 == null || (pluginPackageInfo = O0000Oo) == null || !"rn".equalsIgnoreCase(pluginPackageInfo.O0000O0o()))) {
                                    CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                                        /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass2.AnonymousClass3 */

                                        public final void run() {
                                            XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                                            if (xQProgressHorizontalDialog != null && xQProgressHorizontalDialog.isShowing()) {
                                                xQProgressHorizontalDialog.dismiss();
                                            }
                                        }
                                    }, 3000);
                                }
                                gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, onInstallSuccess...".concat(String.valueOf(str)));
                            }

                            public final void onDownloadFailure(PluginError pluginError) {
                                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                if (!z5 && (xQProgressHorizontalDialog = O000000o2) != null) {
                                    xQProgressHorizontalDialog.dismiss();
                                }
                                if (pluginError != null) {
                                    gsy.O000000o(6, "DeviceRenderer", pluginError.O00000Oo);
                                }
                                LogType logType = LogType.PLUGIN;
                                StringBuilder sb = new StringBuilder("mIot-rn-plugin-framework --> click_device_list getAction in, onDownloadFailure...");
                                sb.append(pluginError == null ? "" : pluginError.O00000Oo);
                                gsy.O000000o(logType, "rn-plugin-framework", 3, "miot-rn-plugin", sb.toString());
                            }

                            public final void onDownloadCancel() {
                                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                if (!z5 && (xQProgressHorizontalDialog = O000000o2) != null) {
                                    xQProgressHorizontalDialog.dismiss();
                                }
                            }

                            public final void onSendSuccess(Bundle bundle) {
                                if (z5) {
                                    CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                                        /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass2.AnonymousClass4 */

                                        public final void run() {
                                            if (O000000o2 != null) {
                                                O000000o2.dismiss();
                                            }
                                        }
                                    }, 500);
                                }
                                eyc.O000000o o000000o = o000000o2;
                                if (o000000o != null) {
                                    o000000o.O00000Oo();
                                }
                                gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, onSendSuccess...");
                            }

                            public final void onSendFailure(fso fso) {
                                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                if (z5 && (xQProgressHorizontalDialog = O000000o2) != null) {
                                    xQProgressHorizontalDialog.dismiss();
                                }
                                eyc.O000000o o000000o = o000000o2;
                                if (o000000o != null) {
                                    o000000o.O00000Oo();
                                }
                                gqg.O000000o(fso.O00000Oo, 0);
                                LogType logType = LogType.GENERAL;
                                StringBuilder sb = new StringBuilder("onSendFailure line 421:");
                                sb.append(fso == null ? null : fso.toString());
                                gsy.O00000Oo(logType, "DeviceRenderer", sb.toString());
                            }

                            public final void onSendCancel() {
                                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                                if (z5 && (xQProgressHorizontalDialog = O000000o2) != null) {
                                    xQProgressHorizontalDialog.dismiss();
                                }
                                eyc.O000000o o000000o = o000000o2;
                                if (o000000o != null) {
                                    o000000o.O00000Oo();
                                }
                                gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, onSendCancel...");
                            }

                            public final void onMessageFailure(int i, String str) {
                                LogType logType = LogType.PLUGIN;
                                gsy.O000000o(logType, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> click_device_list getAction in, onMessageFailure...errorCode: " + i + "  errorInfo: " + str);
                                gsy.O00000Oo("DeviceRenderer", "errorCode: " + i + "  errorInfo: " + str);
                                if (i == -1001 && !TextUtils.isEmpty(str)) {
                                    String[] split = str.split("-");
                                    if (split.length == 4) {
                                        final String str2 = split[1];
                                        CoreApi O000000o2 = CoreApi.O000000o();
                                        try {
                                            O000000o2.O00000Oo().getLatestPluginInfo(str2, new IClientCallback.Stub(new fsm<Bundle, fso>() {
                                                /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass2.AnonymousClass5 */

                                                public final /* synthetic */ void onSuccess(Object obj) {
                                                    Bundle bundle = (Bundle) obj;
                                                    PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str2);
                                                    long j = bundle.getLong("packageId", -1);
                                                    int i = bundle.getInt("version", -1);
                                                    if (O0000Oo != null && O0000Oo.O00000Oo() != j && O0000Oo.O00000oO() < i) {
                                                        CoreApi O000000o2 = CoreApi.O000000o();
                                                        String str = str2;
                                                        if (!TextUtils.isEmpty(str)) {
                                                            try {
                                                                O000000o2.O00000Oo().deletePlugin(str, new IClientCallback.Stub(null, str) {
                                                                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass49 */
                                                                    final /* synthetic */ O00000o val$callback;
                                                                    final /* synthetic */ String val$model;

                                                                    {
                                                                        this.val$callback = r2;
                                                                        this.val$model = r3;
                                                                    }

                                                                    public void onSuccess(Bundle bundle) throws RemoteException {
                                                                        if (this.val$callback == null) {
                                                                        }
                                                                    }

                                                                    public void onFailure(Bundle bundle) throws RemoteException {
                                                                        if (this.val$callback != null) {
                                                                            bundle.setClassLoader(fso.class.getClassLoader());
                                                                            PluginError pluginError = (PluginError) bundle.getParcelable("error");
                                                                            ftg.O000000o("deletePlugin fail", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                                                                        }
                                                                    }
                                                                });
                                                            } catch (Throwable th) {
                                                                th.printStackTrace();
                                                            }
                                                        }
                                                    }
                                                }

                                                public final void onFailure(fso fso) {
                                                    gsy.O000000o(6, "DeviceRenderer", "code: " + fso.f17063O000000o + " message: " + fso.O00000Oo);
                                                }
                                            }) {
                                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass56 */
                                                final /* synthetic */ fsm val$callback;

                                                {
                                                    this.val$callback = r2;
                                                }

                                                public void onSuccess(Bundle bundle) throws RemoteException {
                                                    this.val$callback.onSuccess(bundle);
                                                }

                                                public void onFailure(Bundle bundle) throws RemoteException {
                                                    this.val$callback.onFailure(new fso(-1, "error"));
                                                }
                                            });
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                }
                            }
                        };
                        intent2 = null;
                        str = "DeviceRenderer";
                        Bundle bundle5 = bundle3;
                        instance.sendMessage(context, str2, i, intent3, newDeviceStat, null, false, r0, sendMessageHandle);
                        if (!(O0000OoO == null || o000000o == null)) {
                            o000000o.O000000o();
                        }
                        bundle2 = bundle5;
                    } else {
                        Bundle bundle6 = bundle3;
                        String str3 = "DeviceRenderer";
                        if (mPluginDownloadingRecordMap.containsKey(device2)) {
                            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass3 */

                                public final void run() {
                                    if (DeviceRenderer.mPluginDownloadingRecordMap.containsKey(device2)) {
                                        DeviceRenderer.mPluginDownloadingRecordMap.remove(device2);
                                    }
                                }
                            }, 60000);
                            gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "mIot-rn-plugin-framework --> DeviceRender.getAction mPluginDownloadingRecordMap containsKey");
                            return null;
                        } else if (O0000OoO != null || mPluginDownloadingRecordMap.size() <= 0) {
                            for (PluginDownloadingRecord pluginDownloadingRecord : mPluginDownloadingRecordMap.values()) {
                                pluginDownloadingRecord.O00000o.cancel();
                            }
                            Intent intent4 = new Intent();
                            intent4.putExtra("rn_native_debug_model", z2);
                            device2.setLaunchParams(intent4);
                            if (bundle6 != null) {
                                intent4.putExtras(bundle6);
                            }
                            final boolean z6 = O0000Oo == null && O0000OoO == null;
                            bundle2 = bundle6;
                            final Device device3 = device;
                            final Context context4 = context;
                            final eyc.O000000o o000000o3 = o000000o;
                            AnonymousClass4 r02 = new O000000o() {
                                /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass4 */
                                private float O0000OOo = 0.0f;

                                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                                    if (DeviceRenderer.mPluginDownloadingRecordMap.get(device3) == null) {
                                        PluginDownloadingRecord pluginDownloadingRecord = new PluginDownloadingRecord();
                                        pluginDownloadingRecord.f7296O000000o = device3.model;
                                        pluginDownloadingRecord.O00000Oo = PluginDownloadingRecord.Status.DOWNLOADING;
                                        pluginDownloadingRecord.O00000o = this.f7295O000000o;
                                        DeviceRenderer.mPluginDownloadingRecordMap.put(device3, pluginDownloadingRecord);
                                    }
                                    ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    this.O0000OOo = 0.0f;
                                }

                                public final void onDownloadProgress(String str, float f) {
                                    if (((double) (f - this.O0000OOo)) >= 0.01d || f >= 1.0f) {
                                        PluginDownloadingRecord pluginDownloadingRecord = DeviceRenderer.mPluginDownloadingRecordMap.get(device3);
                                        if (pluginDownloadingRecord != null) {
                                            if (z6 && ((double) f) >= 0.99d) {
                                                f = 0.99f;
                                            }
                                            pluginDownloadingRecord.O00000o0 = f;
                                        }
                                        if (f == 0.99f && pluginDownloadingRecord.O00000oO == 0) {
                                            pluginDownloadingRecord.O00000oO = System.currentTimeMillis();
                                        }
                                        fno.O000000o().O00000o0(device3);
                                        ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                        this.O0000OOo = f;
                                    }
                                }

                                public final void onDownloadSuccess(String str) {
                                    if (!z6) {
                                        DeviceRenderer.mPluginDownloadingRecordMap.remove(device3);
                                        ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    }
                                }

                                public final void onDownloadFailure(PluginError pluginError) {
                                    if (!z6) {
                                        DeviceRenderer.mPluginDownloadingRecordMap.remove(device3);
                                        ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    }
                                }

                                public final void onDownloadCancel() {
                                    if (!z6) {
                                        DeviceRenderer.mPluginDownloadingRecordMap.remove(device3);
                                        ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    }
                                }

                                public final void onSendSuccess(Bundle bundle) {
                                    if (z6) {
                                        DeviceRenderer.mPluginDownloadingRecordMap.remove(device3);
                                    }
                                    DeviceRenderer.mPluginSendingRecordMap.remove(device3);
                                    CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                                        /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass4.AnonymousClass1 */

                                        public final void run() {
                                            ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                        }
                                    }, 700);
                                    eyc.O000000o o000000o = o000000o3;
                                    if (o000000o != null) {
                                        o000000o.O00000Oo();
                                    }
                                }

                                public final void onSendFailure(fso fso) {
                                    if (z6) {
                                        DeviceRenderer.mPluginDownloadingRecordMap.remove(device3);
                                    }
                                    DeviceRenderer.mPluginSendingRecordMap.remove(device3);
                                    ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    eyc.O000000o o000000o = o000000o3;
                                    if (o000000o != null) {
                                        o000000o.O00000Oo();
                                    }
                                    gqg.O00000Oo(fso.O00000Oo);
                                    LogType logType = LogType.GENERAL;
                                    StringBuilder sb = new StringBuilder("onSendFailure line 599:");
                                    sb.append(fso == null ? null : fso.toString());
                                    gsy.O00000Oo(logType, "DeviceRenderer", sb.toString());
                                }

                                public final void onSendCancel() {
                                    if (z6) {
                                        DeviceRenderer.mPluginDownloadingRecordMap.remove(device3);
                                    }
                                    DeviceRenderer.mPluginSendingRecordMap.remove(device3);
                                    ft.O000000o(context4).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    eyc.O000000o o000000o = o000000o3;
                                    if (o000000o != null) {
                                        o000000o.O00000Oo();
                                    }
                                }
                            };
                            mPluginSendingRecordMap.put(device2, null);
                            intent2 = null;
                            str = str3;
                            r02.f7295O000000o = PluginApi.getInstance().sendMessage(context, device2.model, i, intent4, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device2), null, false, r02);
                            if (!(O0000OoO == null || o000000o == null)) {
                                o000000o.O000000o();
                            }
                        } else {
                            izb.O000000o(context2, (int) R.string.device_downloading, 0).show();
                            return null;
                        }
                    }
                }
            }
            intent = intent2;
            intent.putExtras(bundle2);
            gsy.O00000Oo(LogType.GENERAL, str, "click_device_list DeviceRender.getAction end:" + device2.model + ", 0 - " + System.currentTimeMillis());
            gsy.O000000o(6, "Device_Renderer", device2.model + ", 0 - " + System.currentTimeMillis());
            return intent;
        } else {
            if (device2.isOnline) {
                fbt fbt = new fbt(context2, "ConfigRouterSubDeviceActivity");
                fbt.O000000o("station_model", device2.model);
                fbt.O000000o("station_did", device2.did);
                fbs.O000000o(fbt);
            } else {
                new MLAlertDialog.Builder(context2).O000000o((int) R.string.code_offline_error).O000000o((int) R.string.reassure_ok, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DeviceRenderer.mListItemIsClicked = false;
                    }
                }).O000000o(false).O00000o().show();
            }
            return null;
        }
    }

    class O000000o extends SendMessageCallback {

        /* renamed from: O000000o  reason: collision with root package name */
        public SendMessageHandle f7295O000000o;

        O000000o() {
        }
    }

    public Class<?> deviceShortcutUtils_getActivity(String str, String str2, Bundle bundle) {
        LogType logType = LogType.GENERAL;
        gsy.O00000o0(logType, "DeviceMainPageHelperImpl", "deviceShortcutUtils_getActivity did = " + str + ", model = " + str2);
        if (!DeviceFactory.O00000o(str2, "xiaomi.ble.v1")) {
            return null;
        }
        bundle.putString("mac", str);
        Activity activity = (Activity) fbs.O000000o(Activity.class, "com.xiaomi.smarthome.miio.miband.MiBandMainActivity");
        if (activity != null) {
            return activity.getClass();
        }
        return null;
    }

    private boolean isRnNativeDebugModelToOpenPlugin(Device device) {
        if (gfr.O0000Oo0) {
            return false;
        }
        boolean z = CommonApplication.getAppContext().getSharedPreferences("developer_setting", 0).getBoolean("rn_debug_enable_v2", false);
        JSONObject O000000o2 = fvu.O000000o(device.model);
        boolean optBoolean = O000000o2 != null ? O000000o2.optBoolean(fvt.O00000o0) : false;
        boolean z2 = !TextUtils.isEmpty(hmq.O000000o().getQrDebugModePackageName());
        if ((!z || !optBoolean) && !z2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setNameStatusByDesc(Context context, TextView textView, Device device, boolean z) {
        String subtitleByDesc = DeviceRouterFactory.getDeviceWrapper().getSubtitleByDesc(device, context, z);
        if (TextUtils.isEmpty(subtitleByDesc)) {
            return false;
        }
        gqa.O000000o(textView, subtitleByDesc, z, !DeviceRouterFactory.getDeviceWrapper().isNoneClickableDevice(device));
        return true;
    }

    public void setNameStatus(Context context, TextView textView, Device device, boolean z) {
        if (!setNameStatusByDescNew(context, textView, device, z) && !setNameStatusByDesc(context, textView, device, z)) {
            textView.setText(new fqq(device).O000000o(context, z));
            textView.setTextColor(z ? gqa.O00000o0 : gqa.f18142O000000o);
            textView.setVisibility(0);
        }
    }

    private boolean setNameStatusByDescNew(Context context, TextView textView, Device device, boolean z) {
        if (TextUtils.isEmpty(device.descNew)) {
            return false;
        }
        String str = device.descNew;
        String str2 = device.descTimeJString;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                if (jSONArray.length() != 0) {
                    Object[] objArr = new Object[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        objArr[i] = gou.O00000o0(jSONArray.getLong(i) * 1000);
                    }
                    str = String.format(str, objArr);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        gqa.O000000o(textView, str, z, !DeviceRouterFactory.getDeviceWrapper().isNoneClickableDevice(device));
        return true;
    }

    public void onItemClick(View view, Handler handler, final Device device, Context context, Activity activity) {
        if (device != null) {
            JSONObject jSONObject = new JSONObject();
            if (device != null) {
                try {
                    jSONObject.put("model", device.model);
                    jSONObject.put("did", device.did);
                    jSONObject.put("isonline", device.isOnline);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            hxk hxk = hxi.O00000o;
            String str = device.model;
            String str2 = device.did;
            int i = device.pid;
            boolean z = device.isOnline;
            hxk.f952O000000o.O000000o("plugin_offline_report", "model", str, "did", str2, "pid", Integer.valueOf(i), "isOnline", Integer.valueOf(z ? 1 : 0));
            if (isClickable(context, device, handler)) {
                hsi.O000000o("device item clicked");
                if (device.isNew) {
                    device.isNew = false;
                }
                DeviceRouterFactory.getDeviceWrapper().isNoneClickableDevice(device);
                if (!(device instanceof BleDevice)) {
                    mClickedDevice = device;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("view_position", hzf.O0000OOo(view));
                Intent action = getAction(device, context, bundle, true, new eyc.O000000o() {
                    /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass5 */

                    public final void O000000o() {
                        device.property.putBoolean("device_plugin_opening", true);
                    }

                    public final void O00000Oo() {
                        device.property.putBoolean("device_plugin_opening", false);
                    }
                });
                if (activity != null) {
                    if (activity instanceof BaseActivity) {
                        ((BaseActivity) activity).addLifecycleObserver(this);
                    }
                    if (activity instanceof ConnectBaseActivity) {
                        ((ConnectBaseActivity) activity).addLifecycleObserver(this);
                    }
                    try {
                        context.startActivity(action);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    mListItemIsClicked = true;
                }
            }
        }
    }

    public void onItemClick(Handler handler, Device device, Context context) {
        if (isClickable(context, device, handler)) {
            DeviceRouterFactory.getDeviceWrapper().isNoneClickableDevice(device);
            if (!(device instanceof BleDevice)) {
                mClickedDevice = device;
            }
            Intent action = getAction(device, context, null, true, null);
            if (action != null) {
                try {
                    context.startActivity(action);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mListItemIsClicked = true;
            }
        }
    }

    public void onItemClick(final View view, Handler handler, Device device, Context context) {
        if (isClickable(context, device, handler)) {
            JSONObject jSONObject = new JSONObject();
            if (device != null) {
                try {
                    jSONObject.put("model", device.model);
                    jSONObject.put("isOnline", device.isOnline);
                    jSONObject.put("did", device.did);
                    jSONObject.put("mac", device.mac);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (device.isNew) {
                if (device instanceof BleDevice) {
                    ((BleDevice) device).O000000o(false);
                } else {
                    device.isNew = false;
                }
            }
            htw O000000o2 = htv.O000000o();
            if (O000000o2 != null) {
                O000000o2.resetFinder();
            }
            DeviceRouterFactory.getDeviceWrapper().isNoneClickableDevice(device);
            if (!(device instanceof BleDevice)) {
                mClickedDevice = device;
            }
            Intent action = getAction(device, context, null, false, new eyc.O000000o() {
                /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass6 */

                public final void O000000o() {
                    view.post(new Runnable() {
                        /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            View findViewById = view.findViewById(R.id.loading_container);
                            ImageView imageView = (ImageView) view.findViewById(R.id.mj_loading);
                            if (findViewById != null) {
                                findViewById.setVisibility(0);
                                ((AnimationDrawable) imageView.getDrawable()).start();
                            }
                        }
                    });
                }

                public final void O00000Oo() {
                    view.post(new Runnable() {
                        /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass6.AnonymousClass2 */

                        public final void run() {
                            View findViewById = view.findViewById(R.id.loading_container);
                            ImageView imageView = (ImageView) view.findViewById(R.id.mj_loading);
                            if (findViewById != null) {
                                findViewById.setVisibility(4);
                                ((AnimationDrawable) imageView.getDrawable()).stop();
                            }
                        }
                    });
                }
            });
            if (action != null) {
                if (context instanceof BaseActivity) {
                    ((BaseActivity) context).addLifecycleObserver(this);
                }
                if (context instanceof ConnectBaseActivity) {
                    ((ConnectBaseActivity) context).addLifecycleObserver(this);
                }
                try {
                    context.startActivity(action);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                mListItemIsClicked = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isClickable(Context context, Device device, Handler handler) {
        if (device == null) {
            return false;
        }
        handler.postDelayed($$Lambda$DeviceRenderer$QYpx5rFzKbvC2fAvRpUhoITgV9c.INSTANCE, 800);
        if (mListItemIsClicked) {
            return false;
        }
        mListItemIsClicked = true;
        return true;
    }

    public void refreshClickedDeviceDesc() {
        Device device = mClickedDevice;
        if (device != null) {
            String str = device.did;
            if (!TextUtils.isEmpty(str)) {
                mClickedDevice = null;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                fno.O000000o().O000000o(arrayList, new fsm<List<Device>, fso>() {
                    /* class com.xiaomi.smarthome.device.renderer.DeviceRenderer.AnonymousClass7 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        List<Device> list = (List) obj;
                        if (list != null && list.size() > 0) {
                            ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
                            ArrayList arrayList = new ArrayList();
                            for (Device device : list) {
                                arrayList.add(device.did);
                            }
                            fno.O000000o().f16707O000000o.setCacheDirty(arrayList);
                        }
                    }
                });
            }
        }
    }
}

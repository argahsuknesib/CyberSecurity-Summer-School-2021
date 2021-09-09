package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.utils.ShortcutReceiver;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.List;

public final class fqu {
    public static Intent O000000o(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.router", 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            izb.O000000o(context, (int) R.string.not_found_router_app, 0).show();
            return null;
        }
        gsy.O000000o(6, "aaa", packageInfo.versionName);
        Intent intent = new Intent();
        if (packageInfo.versionName.startsWith("2")) {
            gwd.O000000o(intent);
            intent.putExtra("type", 4);
            if (str.startsWith("miwifi.")) {
                str = str.substring(7);
            }
            intent.setAction("com.xiaomi.router.smarthome");
            intent.putExtra("routerId", str);
            intent.putExtra("userId", CoreApi.O000000o().O0000o0());
        }
        return intent;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public static void O000000o(Activity activity, boolean z, Device device, Intent intent, String str, ftt<Void> ftt) {
        int i;
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 23) {
                i = CommonApplication.getApplication().checkSelfPermission("com.android.launcher.permission.INSTALL_SHORTCUT");
            } else {
                i = CommonApplication.getApplication().checkPermission("com.android.launcher.permission.INSTALL_SHORTCUT", Process.myPid(), Process.myUid());
            }
            if (i == -1) {
                ftt.O000000o(-1);
                gsy.O00000Oo("DeviceShortcutUtils", "PERMISSION_DENIED addToLauncher device:".concat(String.valueOf(device)));
                return;
            }
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
        if (O00000oO == null) {
            gsy.O00000Oo("DeviceShortcutUtils", "pluginRecord == null addToLauncher device:".concat(String.valueOf(device)));
            return;
        }
        String O0000o0 = O00000oO.O0000o0();
        if (TextUtils.isEmpty(O0000o0) || !O0000o0.startsWith("http")) {
            O000000o(activity, device, intent, (Bitmap) null, str, z);
            ftt.O000000o((Object) null);
            CoreApi.O000000o().O000000o(StatType.EVENT, "add_launcher", str, (String) null, false);
            gsy.O00000Oo("DeviceShortcutUtils", "file addToLauncher device:".concat(String.valueOf(device)));
            return;
        }
        final Activity activity2 = activity;
        final Device device2 = device;
        final Intent intent2 = intent;
        final String str2 = str;
        final boolean z2 = z;
        final ftt<Void> ftt2 = ftt;
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(O0000o0)).setProgressiveRenderingEnabled(true).build(), CommonApplication.getAppContext()).subscribe(new BaseBitmapDataSubscriber() {
            /* class _m_j.fqu.AnonymousClass1 */

            public final void onFailureImpl(DataSource dataSource) {
            }

            @SuppressLint({"ResourceType"})
            public final void onNewResultImpl(Bitmap bitmap) {
                gsy.O00000Oo("DeviceShortcutUtils", "onNewResultImpl bitmapSrc:".concat(String.valueOf(bitmap)));
                if (bitmap != null) {
                    TypedValue typedValue = new TypedValue();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inTargetDensity = typedValue.density;
                    DisplayMetrics displayMetrics = CommonApplication.getAppContext().getResources().getDisplayMetrics();
                    options.inTargetDensity = displayMetrics.densityDpi;
                    Bitmap decodeResource = BitmapFactory.decodeResource(CommonApplication.getAppContext().getResources(), R.drawable.mijia_logo_icon_coner, options);
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int width2 = decodeResource.getWidth();
                    int height2 = decodeResource.getHeight();
                    int i = (int) (displayMetrics.density * 75.0f);
                    final Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setColor(-1);
                    float f = displayMetrics.density * 30.0f;
                    float f2 = (float) i;
                    float f3 = f / 6.0f;
                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, f2, f2), f3, f3, paint);
                    Matrix matrix = new Matrix();
                    float max = (f2 - (0.1f * f2)) / ((float) Math.max(width, height));
                    matrix.setScale(max, max);
                    matrix.postTranslate((f2 - (((float) width) * max)) / 2.0f, (f2 - (((float) height) * max)) / 2.0f);
                    canvas.drawBitmap(bitmap, matrix, paint);
                    matrix.reset();
                    float max2 = f / ((float) Math.max(width2, height2));
                    matrix.setScale(max2, max2);
                    matrix.postTranslate(f2 - (((float) width2) * max2), f2 - (((float) height2) * max2));
                    canvas.drawBitmap(decodeResource, matrix, paint);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class _m_j.fqu.AnonymousClass1.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
                         arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
                         candidates:
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
                          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
                        public final void run() {
                            try {
                                fqu.O000000o(activity2, device2, intent2, createBitmap, str2, z2);
                                if (ftt2 != null) {
                                    ftt2.O000000o((Object) null);
                                }
                                CoreApi.O000000o().O000000o(StatType.EVENT, "add_launcher", str2, (String) null, false);
                            } catch (Exception e) {
                                Log.e("DeviceShortcutUtils", "onNewResultImpl", e);
                            }
                        }
                    });
                }
            }
        }, CallerThreadExecutor.getInstance());
        gsy.O00000Oo("DeviceShortcutUtils", "downImage addToLauncher device:".concat(String.valueOf(device)));
    }

    public static void O000000o(Activity activity, Device device, Intent intent, Bitmap bitmap, String str, boolean z) {
        if (activity == null) {
            gsy.O00000Oo("DeviceShortcutUtils", "addToLauncher activity =null");
            O000000o(device, intent, bitmap, str, z);
            return;
        }
        fwq.O00000Oo(activity, new inc(intent, bitmap, str, z) {
            /* class _m_j.$$Lambda$fqu$Lke7cUv5DVsRT5SF2eFle5Rp6f4 */
            private final /* synthetic */ Intent f$1;
            private final /* synthetic */ Bitmap f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ boolean f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void onAction(List list) {
                fqu.O000000o(Device.this, this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    /* access modifiers changed from: private */
    public static void O000000o(Device device, Intent intent, Bitmap bitmap, String str, boolean z) {
        String str2;
        int i;
        Icon icon;
        Device device2 = device;
        Intent intent2 = intent;
        Bitmap bitmap2 = bitmap;
        Context appContext = CommonApplication.getAppContext();
        Intent intent3 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        if (!"chuangmi.ir.v2".equals(device2.model) || intent2 == null) {
            str2 = device2.name;
        } else {
            str2 = intent2.getStringExtra("device_shortcut_name");
            if (str2 == null || str2.isEmpty()) {
                str2 = device2.name;
            }
        }
        intent3.putExtra("android.intent.extra.shortcut.NAME", str2);
        intent3.putExtra("duplicate", false);
        Intent intent4 = new Intent("com.xiaomi.smarthome.action.viewdevice");
        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.device.utils.DeviceLauncher2");
        if (O00000Oo != null) {
            intent4.setComponent(new ComponentName(appContext.getPackageName(), O00000Oo.getName()));
        } else {
            intent4.setComponent(new ComponentName(appContext.getPackageName(), "com.xiaomi.smarthome.device.utils.DeviceLauncher2"));
        }
        intent4.putExtra("device_mac", device2.mac);
        intent4.putExtra("device_id", device2.did);
        intent4.putExtra("source_tag", "short_cut");
        intent4.putExtra("user_model", device2.model);
        intent4.putExtra("timestamp", System.currentTimeMillis());
        intent4.putExtra("from_main_activity", true);
        if (intent2 != null) {
            intent4.putExtras(intent2);
        }
        CoreApi.O000000o().O000000o(StatType.EVENT, "add_launcher", str, (String) null, false);
        intent3.putExtra("android.intent.extra.shortcut.INTENT", intent4);
        int O0000oO0 = DeviceFactory.O0000oO0(device2.model);
        if (O0000oO0 <= 0 && (O0000oO0 = fqs.O000000o(device2.model)) <= 0) {
            O0000oO0 = CoreApi.O000000o().O00000o(device2.model) ? R.drawable.plugin_shortcut : R.drawable.device_list_phone_no;
        }
        if (!"chuangmi.ir.v2".equals(device2.model) || intent2 == null || (i = fqs.O00000Oo(intent2.getStringExtra("device_shortcut_icon_name"))) == 0) {
            i = O0000oO0;
        }
        if (gnn.O00000o0) {
            ShortcutManager shortcutManager = (ShortcutManager) appContext.getSystemService(ShortcutManager.class);
            if (shortcutManager == null || !shortcutManager.isRequestPinShortcutSupported()) {
                intent3.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(appContext, i));
                if (bitmap2 != null) {
                    intent3.putExtra("android.intent.extra.shortcut.ICON", bitmap2);
                }
                appContext.sendBroadcast(intent3);
                if (!z) {
                    izb.O000000o(appContext, (int) R.string.smarthome_add_short_cut_success, 0).show();
                }
                gsy.O00000Oo("DeviceShortcutUtils", "addToLauncher success >26 isRequestPinShortcutSupported=false");
                return;
            }
            shortcutManager.getPinnedShortcuts();
            try {
                icon = Icon.createWithBitmap(bitmap);
            } catch (Exception unused) {
                icon = Icon.createWithResource(appContext, (int) R.drawable.mj_ic_launcher);
            }
            ShortcutInfo build = new ShortcutInfo.Builder(appContext, str2).setIcon(icon).setShortLabel(str2).setIntent(intent4).build();
            IntentSender intentSender = PendingIntent.getBroadcast(appContext, 1, new Intent(appContext, ShortcutReceiver.class), 134217728).getIntentSender();
            if (z) {
                intentSender = null;
            }
            shortcutManager.requestPinShortcut(build, intentSender);
            gsy.O00000Oo("DeviceShortcutUtils", "addToLauncher success >26 isRequestPinShortcutSupported=true");
            return;
        }
        intent3.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(appContext, i));
        if (bitmap2 != null) {
            intent3.putExtra("android.intent.extra.shortcut.ICON", bitmap2);
        }
        appContext.sendBroadcast(intent3);
        if (!z) {
            izb.O000000o(appContext, (int) R.string.smarthome_add_short_cut_success, 0).show();
        }
        gsy.O00000Oo("DeviceShortcutUtils", "addToLauncher success <26");
    }
}

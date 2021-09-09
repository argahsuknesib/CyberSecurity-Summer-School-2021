package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class ContextCompat {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f2827O000000o = new Object();
    private static TypedValue O00000Oo;

    public static boolean O000000o(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, null);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void O000000o(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static File[] O000000o(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(null);
        }
        return new File[]{context.getExternalFilesDir(null)};
    }

    public static File[] O00000Oo(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [int, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    public static Drawable O000000o(Context context, int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f2827O000000o) {
            if (O00000Oo == null) {
                O00000Oo = new TypedValue();
            }
            context.getResources().getValue(i, O00000Oo, true);
            i2 = O00000Oo.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static ColorStateList O00000Oo(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static int O00000o0(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static int O000000o(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static File O00000o0(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return O000000o(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return r4;
     */
    private static synchronized File O000000o(File file) {
        synchronized (ContextCompat.class) {
            if (!file.exists() && !file.mkdirs()) {
                if (file.exists()) {
                    return file;
                }
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                return null;
            }
        }
    }

    public static boolean O00000o(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    static class MainHandlerExecutor implements Executor {
        private final Handler mHandler;

        MainHandlerExecutor(Handler handler) {
            this.mHandler = handler;
        }

        public void execute(Runnable runnable) {
            if (!this.mHandler.post(runnable)) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    public static <T> T O000000o(Context context, Class cls) {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getSystemService(cls);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            str = context.getSystemServiceName(cls);
        } else {
            str = O000000o.f2828O000000o.get(cls);
        }
        if (str != null) {
            return context.getSystemService(str);
        }
        return null;
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static final HashMap<Class<?>, String> f2828O000000o = new HashMap<>();

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                f2828O000000o.put(SubscriptionManager.class, "telephony_subscription_service");
                f2828O000000o.put(UsageStatsManager.class, "usagestats");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                f2828O000000o.put(AppWidgetManager.class, "appwidget");
                f2828O000000o.put(BatteryManager.class, "batterymanager");
                f2828O000000o.put(CameraManager.class, "camera");
                f2828O000000o.put(JobScheduler.class, "jobscheduler");
                f2828O000000o.put(LauncherApps.class, "launcherapps");
                f2828O000000o.put(MediaProjectionManager.class, "media_projection");
                f2828O000000o.put(MediaSessionManager.class, "media_session");
                f2828O000000o.put(RestrictionsManager.class, "restrictions");
                f2828O000000o.put(TelecomManager.class, "telecom");
                f2828O000000o.put(TvInputManager.class, "tv_input");
            }
            if (Build.VERSION.SDK_INT >= 19) {
                f2828O000000o.put(AppOpsManager.class, "appops");
                f2828O000000o.put(CaptioningManager.class, "captioning");
                f2828O000000o.put(ConsumerIrManager.class, "consumer_ir");
                f2828O000000o.put(PrintManager.class, "print");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                f2828O000000o.put(BluetoothManager.class, "bluetooth");
            }
            if (Build.VERSION.SDK_INT >= 17) {
                f2828O000000o.put(DisplayManager.class, "display");
                f2828O000000o.put(UserManager.class, "user");
            }
            if (Build.VERSION.SDK_INT >= 16) {
                f2828O000000o.put(InputManager.class, "input");
                f2828O000000o.put(MediaRouter.class, "media_router");
                f2828O000000o.put(NsdManager.class, "servicediscovery");
            }
            f2828O000000o.put(AccessibilityManager.class, "accessibility");
            f2828O000000o.put(AccountManager.class, "account");
            f2828O000000o.put(ActivityManager.class, "activity");
            f2828O000000o.put(AlarmManager.class, "alarm");
            f2828O000000o.put(AudioManager.class, "audio");
            f2828O000000o.put(ClipboardManager.class, "clipboard");
            f2828O000000o.put(ConnectivityManager.class, "connectivity");
            f2828O000000o.put(DevicePolicyManager.class, "device_policy");
            f2828O000000o.put(DownloadManager.class, "download");
            f2828O000000o.put(DropBoxManager.class, "dropbox");
            f2828O000000o.put(InputMethodManager.class, "input_method");
            f2828O000000o.put(KeyguardManager.class, "keyguard");
            f2828O000000o.put(LayoutInflater.class, "layout_inflater");
            f2828O000000o.put(LocationManager.class, "location");
            f2828O000000o.put(NfcManager.class, "nfc");
            f2828O000000o.put(NotificationManager.class, "notification");
            f2828O000000o.put(PowerManager.class, "power");
            f2828O000000o.put(SearchManager.class, "search");
            f2828O000000o.put(SensorManager.class, "sensor");
            f2828O000000o.put(StorageManager.class, "storage");
            f2828O000000o.put(TelephonyManager.class, "phone");
            f2828O000000o.put(TextServicesManager.class, "textservices");
            f2828O000000o.put(UiModeManager.class, "uimode");
            f2828O000000o.put(UsbManager.class, "usb");
            f2828O000000o.put(Vibrator.class, "vibrator");
            f2828O000000o.put(WallpaperManager.class, "wallpaper");
            f2828O000000o.put(WifiP2pManager.class, "wifip2p");
            f2828O000000o.put(WifiManager.class, "wifi");
            f2828O000000o.put(WindowManager.class, "window");
        }
    }
}

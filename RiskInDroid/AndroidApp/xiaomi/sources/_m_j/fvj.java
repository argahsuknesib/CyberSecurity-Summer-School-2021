package _m_j;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class fvj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, String> f17278O000000o;

    static {
        HashMap hashMap = new HashMap();
        f17278O000000o = hashMap;
        hashMap.put("MessageCenter", "/message/MessageCenterActivity");
        f17278O000000o.put("MessageCenterList", "/message/MessageCenterListActivity");
        f17278O000000o.put("BlePageActivity", "MiBandMainActivity");
        f17278O000000o.put("SmartHomeMainActivity", "SmartHomeMainActivity");
        f17278O000000o.put("UpdateActivity", "UpdateActivity");
        f17278O000000o.put("ManageDeviceRoomActivity", "initDeviceRoomActivity");
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f17278O000000o.containsValue(str);
    }

    public static void O000000o(Intent intent) {
        if (intent.getAction().equals("com.xiaomi.smarthome.action.OPEN_API")) {
            String str = f17278O000000o.get(intent.getStringExtra("target_page"));
            gsy.O00000o0(LogType.GENERAL, "OpenApi", "process targetPageCls: ".concat(String.valueOf(str)));
            if (str != null) {
                O000000o(str, intent.getBundleExtra("target_args"), intent.getBooleanExtra("need_login", false), 0);
            }
        }
    }

    public static void O000000o(String str, Bundle bundle, boolean z, int i) {
        ComponentName componentName;
        boolean z2;
        gsy.O00000o0(LogType.GENERAL, "OpenApi", "startActivity: ".concat(String.valueOf(str)));
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) ServiceApplication.getAppContext().getSystemService("activity")).getRunningTasks(50);
        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
        if (O00000Oo != null) {
            Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.baseActivity.equals(new ComponentName(CommonApplication.getAppContext().getPackageName(), O00000Oo.getName()))) {
                    z2 = true;
                    componentName = next.topActivity;
                    break;
                }
            }
        }
        z2 = false;
        componentName = null;
        if (!z2) {
            fbt fbt = new fbt(ServiceApplication.getAppContext(), "SmartHomeMainActivity");
            fbt.O00000Oo(268435456);
            if ((!z || CoreApi.O000000o().O0000Ooo()) && str != null && O000000o(str)) {
                fbt.O000000o("source", 2);
                fbt.O000000o("target_activity", str);
                fbt.O000000o("target_args", bundle);
                fbt.O000000o("flags", i);
                if (bundle != null) {
                    fbt.O000000o(bundle);
                }
            }
            fbs.O000000o(fbt);
        } else if (CoreApi.O000000o().O0000Ooo()) {
            fbt fbt2 = new fbt(ServiceApplication.getAppContext(), str);
            fbt2.O00000Oo(i | 335675392);
            if (bundle != null) {
                fbt2.O000000o(bundle);
            }
            fbs.O000000o(fbt2);
        } else if (z) {
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(335675392);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            ServiceApplication.getAppContext().startActivity(intent);
        } else {
            fbt fbt3 = new fbt(ServiceApplication.getAppContext(), str);
            fbt3.O00000Oo(i | 335675392);
            if (bundle != null) {
                fbt3.O000000o(bundle);
            }
            fbs.O000000o(fbt3);
        }
    }

    public static void O000000o(String str, Bundle bundle) {
        ComponentName componentName;
        boolean z;
        fbt fbt;
        gsy.O00000o0(LogType.GENERAL, "OpenApi", "goToSceneLogPage: ".concat(String.valueOf(str)));
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) ServiceApplication.getAppContext().getSystemService("activity")).getRunningTasks(50);
        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
        if (O00000Oo != null) {
            Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.baseActivity.equals(new ComponentName(CommonApplication.getAppContext().getPackageName(), O00000Oo.getName()))) {
                    z = true;
                    componentName = next.topActivity;
                    break;
                }
            }
        }
        z = false;
        componentName = null;
        if (!z) {
            fbt = new fbt(ServiceApplication.getAppContext(), "SmartHomeMainActivity");
            fbt.O00000Oo(268435456);
            if (CoreApi.O000000o().O0000Ooo() && O000000o(str)) {
                fbt.O000000o("source", 2);
                fbt.O000000o("target_activity", str);
                fbt.O000000o("target_args", bundle);
                fbt.O000000o("flags", 67108864);
            }
        } else if (CoreApi.O000000o().O0000Ooo()) {
            fbt = new fbt(ServiceApplication.getAppContext(), str);
            fbt.O00000Oo(872546304);
            fbt.O000000o(bundle);
        } else {
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(335675392);
            intent.putExtras(bundle);
            ServiceApplication.getAppContext().startActivity(intent);
            return;
        }
        fbs.O000000o(fbt);
    }

    public static void O000000o() {
        ComponentName componentName;
        boolean z;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) ServiceApplication.getAppContext().getSystemService("activity")).getRunningTasks(50);
        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
        if (runningTasks != null && O00000Oo != null) {
            Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.baseActivity.equals(new ComponentName(CommonApplication.getAppContext().getPackageName(), O00000Oo.getName()))) {
                    z = true;
                    componentName = next.baseActivity;
                    break;
                }
            }
        }
        z = false;
        componentName = null;
        if (z) {
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(872415232);
            intent.putExtra("source", 4);
            ServiceApplication.getAppContext().startActivity(intent);
            return;
        }
        fbt fbt = new fbt(ServiceApplication.getAppContext(), "SmartHomeMainActivity");
        if (Build.VERSION.SDK_INT >= 11) {
            fbt.O00000Oo(268468224);
        } else {
            fbt.O00000Oo(335544320);
        }
        fbt.O000000o("source", 4);
        fbs.O000000o(fbt);
    }
}

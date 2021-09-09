package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.acp.ACPService;

public final class eyu {
    public static boolean O000000o(Context context, String str) {
        boolean isReachMaxCrashTimes = ACPService.isReachMaxCrashTimes(context);
        Intent intent = new Intent(context, ACPService.class);
        intent.setAction("acp_action");
        intent.putExtra("acp_repeated_crash", 1);
        intent.putExtra("acp_data", str);
        try {
            context.startService(intent);
            return isReachMaxCrashTimes;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void O000000o(Context context) {
        Intent intent = new Intent(context, ACPService.class);
        intent.setAction("acp_action");
        intent.putExtra("acp_repeated_crash", 4);
        try {
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

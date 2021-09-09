package _m_j;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashMap;
import java.util.Map;

public final class bmj {

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bmj f13098O000000o = new bmj((byte) 0);
    }

    private bmj() {
    }

    /* synthetic */ bmj(byte b) {
        this();
    }

    public static Map<String, Integer> O000000o() {
        HashMap hashMap = new HashMap();
        Context context = blw.f13081O000000o;
        if (context == null) {
            return hashMap;
        }
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return hashMap;
            }
            int intExtra = registerReceiver.getIntExtra("status", 0);
            int intExtra2 = registerReceiver.getIntExtra("level", 0);
            int intExtra3 = registerReceiver.getIntExtra("scale", 100);
            int intExtra4 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra5 = registerReceiver.getIntExtra("voltage", 0);
            hashMap.put("status", Integer.valueOf(intExtra));
            hashMap.put("level", Integer.valueOf(intExtra2));
            hashMap.put("scale", Integer.valueOf(intExtra3));
            hashMap.put("temp", Integer.valueOf(intExtra4));
            hashMap.put("vol", Integer.valueOf(intExtra5));
            return hashMap;
        } catch (Exception unused) {
        }
    }
}

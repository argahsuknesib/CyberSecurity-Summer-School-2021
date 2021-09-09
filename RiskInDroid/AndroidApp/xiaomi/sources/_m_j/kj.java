package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Method;

public final class kj {
    public static Bundle O000000o(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
        if (bundleExtra == null) {
            return null;
        }
        return bundleExtra.getBundle("extras");
    }

    public static Uri O000000o(Context context, Intent intent) {
        String string;
        Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
        if (bundleExtra == null || (string = bundleExtra.getString("target_url")) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (intent != null) {
            Bundle bundleExtra2 = intent.getBundleExtra("al_applink_data");
            if (bundleExtra2 != null) {
                bundle = kp.O000000o(context, "al_nav_in", bundleExtra2, intent);
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    bundle.putString("intentData", data.toString());
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String next : extras.keySet()) {
                        bundle.putString(next, kp.O000000o(extras.get(next)));
                    }
                }
            }
        }
        kp kpVar = new kp(context, "al_nav_in", bundle);
        if (kpVar.O00000Oo == null) {
            Log.d(kpVar.getClass().getName(), "Event name is required");
        }
        try {
            Class<?> cls = Class.forName("_m_j.ft");
            Method method = cls.getMethod("getInstance", Context.class);
            Method method2 = cls.getMethod("sendBroadcast", Intent.class);
            Object invoke = method.invoke(null, kpVar.f2143O000000o);
            Intent intent2 = new Intent("com.parse.bolts.measurement_event");
            intent2.putExtra("event_name", kpVar.O00000Oo);
            intent2.putExtra("event_args", kpVar.O00000o0);
            method2.invoke(invoke, intent2);
        } catch (Exception unused) {
            Log.d(kpVar.getClass().getName(), "LocalBroadcastManager in android support library is required to raise bolts event.");
        }
        return Uri.parse(string);
    }
}

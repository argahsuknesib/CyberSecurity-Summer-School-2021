package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class kp {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f2143O000000o;
    String O00000Oo;
    Bundle O00000o0;

    kp(Context context, String str, Bundle bundle) {
        this.f2143O000000o = context.getApplicationContext();
        this.O00000Oo = str;
        this.O00000o0 = bundle;
    }

    static Bundle O000000o(Context context, String str, Bundle bundle, Intent intent) {
        Bundle bundle2 = new Bundle();
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity != null) {
            bundle2.putString("class", resolveActivity.getShortClassName());
        }
        if ("al_nav_out".equals(str)) {
            if (resolveActivity != null) {
                bundle2.putString("package", resolveActivity.getPackageName());
            }
            if (intent.getData() != null) {
                bundle2.putString("outputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("outputURLScheme", intent.getScheme());
            }
        } else if ("al_nav_in".equals(str)) {
            if (intent.getData() != null) {
                bundle2.putString("inputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("inputURLScheme", intent.getScheme());
            }
        }
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                Bundle bundle3 = (Bundle) obj;
                for (String next2 : bundle3.keySet()) {
                    String O000000o2 = O000000o(bundle3.get(next2));
                    if (next.equals("referer_app_link")) {
                        if (next2.equalsIgnoreCase("url")) {
                            bundle2.putString("refererURL", O000000o2);
                        } else if (next2.equalsIgnoreCase("app_name")) {
                            bundle2.putString("refererAppName", O000000o2);
                        } else if (next2.equalsIgnoreCase("package")) {
                            bundle2.putString("sourceApplication", O000000o2);
                        }
                    }
                    bundle2.putString(next + "/" + next2, O000000o2);
                }
            } else {
                String O000000o3 = O000000o(obj);
                if (next.equals("target_url")) {
                    Uri parse = Uri.parse(O000000o3);
                    bundle2.putString("targetURL", parse.toString());
                    bundle2.putString("targetURLHost", parse.getHost());
                } else {
                    bundle2.putString(next, O000000o3);
                }
            }
        }
        return bundle2;
    }

    static String O000000o(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj.toString();
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection<?>) ((Collection) obj)).toString();
            }
            if (obj instanceof Map) {
                return new JSONObject((Map<?, ?>) ((Map) obj)).toString();
            }
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}

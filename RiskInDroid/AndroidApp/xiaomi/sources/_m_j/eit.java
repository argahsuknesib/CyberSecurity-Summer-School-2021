package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class eit {
    public static boolean O000000o(String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return false;
        }
        return true;
    }

    public static boolean O000000o(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }
}

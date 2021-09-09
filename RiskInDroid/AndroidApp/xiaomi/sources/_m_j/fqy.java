package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.UUID;

public final class fqy {
    public static Intent O000000o(Intent intent, int i) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("connect_source", i);
        intent.putExtra("connect_unique", UUID.randomUUID().toString());
        return intent;
    }

    public static Intent O000000o(Intent intent, Context context) {
        if (intent == null) {
            intent = new Intent();
        }
        if (context instanceof Activity) {
            O000000o(intent, ((Activity) context).getIntent());
        }
        return intent;
    }

    public static void O000000o(Intent intent, Intent intent2) {
        if (intent2 != null) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("connect_source", intent2.getIntExtra("connect_source", 0));
            intent.putExtra("connect_unique", intent2.getStringExtra("connect_unique"));
        }
    }

    public static Bundle O000000o(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getExtras();
    }
}

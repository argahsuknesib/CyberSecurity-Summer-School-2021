package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class epj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile epj f15701O000000o;
    private Context O00000Oo;

    private epj(Context context) {
        this.O00000Oo = context;
    }

    public static epj O000000o(Context context) {
        if (f15701O000000o == null) {
            synchronized (epj.class) {
                if (f15701O000000o == null) {
                    f15701O000000o = new epj(context);
                }
            }
        }
        return f15701O000000o;
    }

    private void O000000o(duz duz) {
        if (duz instanceof duy) {
            dva.O000000o(this.O00000Oo, (duy) duz);
        } else if (duz instanceof dux) {
            dva.O000000o(this.O00000Oo, (dux) duz);
        }
    }

    public final void O000000o(String str, Intent intent, int i) {
        if (intent != null) {
            String str2 = str;
            O000000o(str2, epi.O000000o(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, System.currentTimeMillis(), null);
        }
    }

    public final void O000000o(String str, Intent intent, String str2) {
        if (intent != null) {
            String str3 = str;
            O000000o(str3, epi.O000000o(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
        }
    }

    public final void O000000o(String str, String str2, String str3, int i, String str4) {
        O000000o(str, str2, str3, i, System.currentTimeMillis(), str4);
    }

    public final void O000000o(String str, String str2, String str3, String str4) {
        O000000o(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public final void O00000Oo(String str, String str2, String str3, String str4) {
        O000000o(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public final void O00000o0(String str, String str2, String str3, String str4) {
        O000000o(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }

    public final void O000000o(String str, String str2, String str3, int i, long j, String str4) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            dux O000000o2 = epi.O000000o(str2, str3, i, j, str4);
            O000000o2.O0000OOo = str;
            O000000o2.O0000Oo0 = "4_2_0";
            O000000o(O000000o2);
        }
    }

    public final void O000000o(String str, int i, long j) {
        if (i >= 0 && j >= 0) {
            duy O000000o2 = epi.O000000o(i, 1, j);
            O000000o2.O0000OOo = str;
            O000000o2.O0000Oo0 = "4_2_0";
            O000000o(O000000o2);
        }
    }
}

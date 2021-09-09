package _m_j;

import android.content.Context;
import android.content.Intent;

public final class fth {
    public static void O000000o(Context context, boolean z) {
        ft O000000o2 = ft.O000000o(context);
        Intent intent = new Intent("action.passwordlogin.login.complete");
        intent.putExtra("login_success", z);
        O000000o2.O000000o(intent);
    }
}

package _m_j;

import android.content.Context;
import android.content.Intent;

public final class hst {
    public static void O000000o(Context context, boolean z, String str, int i, String str2) {
        Intent intent = new Intent("share.sdk");
        intent.putExtra("share.is_success", z);
        intent.putExtra("transcation", str);
        intent.putExtra("share.code", i);
        intent.putExtra("share.channel", "wechat");
        intent.putExtra("share.err_msg", str2);
        ft.O000000o(context).O000000o(intent);
    }
}

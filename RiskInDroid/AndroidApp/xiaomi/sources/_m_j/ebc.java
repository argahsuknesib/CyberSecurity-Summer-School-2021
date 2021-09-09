package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.e;

final class ebc implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ String f15140O000000o;
    final /* synthetic */ Context O00000Oo;
    final /* synthetic */ e O00000o0;

    ebc(String str, Context context, e eVar) {
        this.f15140O000000o = str;
        this.O00000Oo = context;
        this.O00000o0 = eVar;
    }

    public final void run() {
        String str;
        if (!TextUtils.isEmpty(this.f15140O000000o)) {
            String[] split = this.f15140O000000o.split("~");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = "";
                    break;
                }
                String str2 = split[i];
                if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                    str = str2.substring(str2.indexOf(":") + 1);
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                duv.O000000o("ASSEMBLE_PUSH : receive correct token");
                ebb.O00000o(this.O00000Oo, this.O00000o0, str);
                ebb.O000000o(this.O00000Oo);
                return;
            }
            duv.O000000o("ASSEMBLE_PUSH : receive incorrect token");
        }
    }
}

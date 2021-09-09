package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

final class eoy implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15695O000000o;
    final /* synthetic */ String O00000Oo;
    final /* synthetic */ String O00000o;
    final /* synthetic */ int O00000o0;

    eoy(Context context, String str, int i, String str2) {
        this.f15695O000000o = context;
        this.O00000Oo = str;
        this.O00000o0 = i;
        this.O00000o = str2;
    }

    public final void run() {
        Context context = this.f15695O000000o;
        String str = this.O00000Oo;
        int i = this.O00000o0;
        String str2 = this.O00000o;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("awake_info", str);
                hashMap.put("event_type", String.valueOf(i));
                hashMap.put("description", str2);
                int i2 = epb.O000000o(context).O00000o;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            eox.O000000o(context, hashMap);
                        }
                    }
                    eox.O00000Oo(context, hashMap);
                } else {
                    eox.O000000o(context, hashMap);
                }
                epe epe = epb.O000000o(context).O00000oO;
                if (epe != null) {
                    epe.c(context, hashMap);
                }
            } catch (Exception e) {
                duv.O000000o(e);
            }
        }
    }
}

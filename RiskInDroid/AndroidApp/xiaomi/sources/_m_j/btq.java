package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

public class btq {
    private static btq O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    final Context f13276O000000o;
    final String O00000Oo = bwo.O000000o("amap_device_adiu");
    private String O00000o;

    private btq(Context context) {
        this.f13276O000000o = context.getApplicationContext();
    }

    public static btq O000000o(Context context) {
        if (O00000o0 == null) {
            synchronized (btq.class) {
                if (O00000o0 == null) {
                    O00000o0 = new btq(context);
                }
            }
        }
        return O00000o0;
    }

    public static String O00000Oo() {
        return bwm.O000000o();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a6, code lost:
        return true;
     */
    public final synchronized boolean O000000o() {
        if (TextUtils.isEmpty(this.O00000o)) {
            if (TextUtils.isEmpty(bwm.O000000o())) {
                buk.O000000o(this.f13276O000000o).O00000Oo = this.O00000Oo;
                buk O000000o2 = buk.O000000o(this.f13276O000000o);
                if (O000000o2.f13288O000000o == null || O000000o2.f13288O000000o.size() <= 0 || TextUtils.isEmpty(O000000o2.f13288O000000o.get(0))) {
                    O000000o2.f13288O000000o = O000000o2.O000000o();
                }
                List<String> list = O000000o2.f13288O000000o;
                if (list != null && list.size() > 0) {
                    String str = list.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        this.O00000o = str;
                        bwm.O000000o(this.O00000o);
                        String str2 = "";
                        if (list.size() > 1) {
                            String str3 = list.get(1);
                            if (!TextUtils.isEmpty(str3)) {
                                str2 = str3;
                            }
                        }
                        if (list.size() > 2) {
                            String str4 = list.get(2);
                            if (!TextUtils.isEmpty(str4)) {
                                str2 = ":".concat(String.valueOf(str4));
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            bwm.O00000Oo(str2);
                        }
                    }
                }
            }
        }
    }
}

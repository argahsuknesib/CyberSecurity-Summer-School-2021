package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.Calendar;

public final class gaw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f17473O000000o = Integer.MIN_VALUE;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0028 */
    private static int O00000Oo() {
        if (f17473O000000o == Integer.MIN_VALUE) {
            synchronized ("RnSampleUtil") {
                if (f17473O000000o == Integer.MIN_VALUE) {
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    if (TextUtils.isEmpty(O0000o0)) {
                        f17473O000000o = Integer.MAX_VALUE;
                    } else {
                        f17473O000000o = Integer.parseInt(O0000o0);
                        f17473O000000o = Integer.MAX_VALUE;
                    }
                    fyc.O000000o("RnSampleUtil", "getSampleNum,sSampleFactor:" + f17473O000000o);
                }
            }
        }
        return f17473O000000o;
    }

    public static boolean O000000o() {
        int i = Calendar.getInstance().get(5) % 10;
        int O00000Oo = O00000Oo();
        if (!(O00000Oo == Integer.MAX_VALUE || O00000Oo == Integer.MIN_VALUE)) {
            fyc.O000000o("RnSampleUtil", "isHit10P,sSampleFactor:" + f17473O000000o + ",magic:" + i);
            int i2 = O00000Oo % 10;
            int i3 = (O00000Oo / 1000) % 10;
            if (O00000Oo > 10000 && i2 == i && i3 == i) {
                return true;
            }
            return false;
        }
        return false;
    }
}

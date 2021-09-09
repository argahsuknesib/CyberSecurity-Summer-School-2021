package _m_j;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.List;

public class dys {

    /* renamed from: O000000o  reason: collision with root package name */
    int f15078O000000o;
    List<O000000o> O00000Oo;
    private long O00000o = 60;
    public long O00000o0 = System.currentTimeMillis();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15079O000000o;
    }

    public final InetAddress[] O000000o() {
        InetAddress[] allByName;
        try {
            if (this.f15078O000000o == 1 && this.O00000Oo != null) {
                if (this.O00000Oo.size() != 0) {
                    for (O000000o next : this.O00000Oo) {
                        if (!TextUtils.isEmpty(next.f15079O000000o) && (allByName = InetAddress.getAllByName(next.f15079O000000o)) != null && allByName.length > 0) {
                            return allByName;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean O00000Oo() {
        return System.currentTimeMillis() - this.O00000o0 > this.O00000o * 1000;
    }
}

package _m_j;

import android.annotation.TargetApi;
import java.util.List;

@TargetApi(11)
public final class hho {
    public static hhy O000000o(List<hhy> list, int i) {
        hhy hhy;
        if (i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        hhy hhy2 = new hhy();
        if (i < 0) {
            hhy = list.get(0);
        } else {
            i = (i - list.size()) + 1;
            hhy = list.get(list.size() - 1);
        }
        hhy2.f18955O000000o = hhy.f18955O000000o + (hhy.O000000o() * i);
        hhy2.O00000Oo = hhy.O00000Oo;
        hhy2.O00000o0 = hhy.O00000o0 + (hhy.O000000o() * i);
        hhy2.O00000o = hhy.O00000o;
        hhy2.O00000oO = hhy.O00000oO + (hhy.O000000o() * i);
        hhy2.O00000oo = hhy.O00000oo;
        hhy2.O0000O0o = hhy.O0000O0o + (i * hhy.O000000o());
        hhy2.O0000OOo = hhy.O0000OOo;
        return hhy2;
    }
}

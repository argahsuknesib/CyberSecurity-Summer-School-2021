package _m_j;

import android.text.TextUtils;

public final class imz {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f1488O000000o;
    private String O00000Oo;

    private imz(int i, String str) {
        this.f1488O000000o = i;
        this.O00000Oo = str;
    }

    public static imz O000000o(int i) {
        String str = imy.f1487O000000o.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            str = "网络错误";
        }
        return new imz(i, str);
    }

    public final String toString() {
        return "PayFinishModel{code=" + this.f1488O000000o + ", des='" + this.O00000Oo + '\'' + '}';
    }
}

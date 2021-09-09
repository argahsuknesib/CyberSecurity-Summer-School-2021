package _m_j;

import android.text.StaticLayout;

public final class izc implements Comparable<izc> {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f1660O000000o;
    public String O00000Oo;
    public float O00000o;
    public StaticLayout O00000o0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        izc izc = (izc) obj;
        if (izc == null) {
            return -1;
        }
        return (int) (this.f1660O000000o - izc.f1660O000000o);
    }

    public final int O000000o() {
        StaticLayout staticLayout = this.O00000o0;
        if (staticLayout == null) {
            return 0;
        }
        return staticLayout.getHeight();
    }
}

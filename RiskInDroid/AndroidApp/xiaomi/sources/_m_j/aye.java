package _m_j;

import androidx.recyclerview.widget.RecyclerView;

public final class aye {
    public static <T> T O000000o(RecyclerView.O000000o o000000o, Class<T> cls) {
        while (!cls.isInstance(o000000o)) {
            if (!(o000000o instanceof ayc)) {
                return null;
            }
            o000000o = ((ayc) o000000o).O0000O0o;
        }
        return cls.cast(o000000o);
    }

    public static RecyclerView.O000000o O000000o(RecyclerView.O000000o<VH> o000000o) {
        while (o000000o instanceof ayc) {
            ayc ayc = (ayc) o000000o;
            RecyclerView.O000000o<VH> o000000o2 = ayc.O0000O0o;
            ayc.O00000o0();
            o000000o = o000000o2;
        }
        return o000000o;
    }
}

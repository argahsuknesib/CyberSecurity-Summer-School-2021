package _m_j;

import com.mijia.model.sdcard.TimeItem;
import java.util.ArrayList;
import java.util.List;

public abstract class cln extends ckx {
    protected volatile List<TimeItem> O0000O0o = new ArrayList();

    public cln(dty dty) {
        super(dty);
    }

    public List<TimeItem> O00000oo() {
        return this.O0000O0o;
    }

    public final void O0000O0o() {
        O000000o(-2, "BaseSDCardManager release");
        this.O00000Oo = false;
        this.O00000oO.removeMessages(1);
        this.O00000oO.removeMessages(2);
    }

    public final synchronized TimeItem O000000o(long j) {
        if (j == 0) {
            return null;
        }
        if (this.O0000O0o.size() == 0) {
            return null;
        }
        if (this.O0000O0o.get(this.O0000O0o.size() - 1).O00000o0 <= j) {
            return null;
        }
        int size = this.O0000O0o.size() - 1;
        while (size >= 0) {
            if (this.O0000O0o.get(size).O00000o0 > j || size == this.O0000O0o.size() - 1) {
                size--;
            } else {
                return this.O0000O0o.get(size + 1);
            }
        }
        return this.O0000O0o.get(0);
    }
}

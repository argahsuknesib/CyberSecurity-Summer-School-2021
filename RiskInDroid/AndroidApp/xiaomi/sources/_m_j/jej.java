package _m_j;

import com.google.android.exoplayer2.C;
import org.apache.log4j.Level;

public class jej {
    public static final jej O0000o = new Level(C.MSG_CUSTOM_BASE, "DEBUG", 7);
    public static final jej O0000o0 = new Level(40000, "ERROR", 3);
    public static final jej O0000o00 = new Level(50000, "FATAL", 0);
    public static final jej O0000o0O = new Level(30000, "WARN", 4);
    public static final jej O0000o0o = new Level(20000, "INFO", 6);
    public transient int O0000Oo;
    protected transient String O0000OoO;
    protected transient int O0000Ooo;

    protected jej() {
        this.O0000Oo = C.MSG_CUSTOM_BASE;
        this.O0000OoO = "DEBUG";
        this.O0000Ooo = 7;
    }

    protected jej(int i, String str, int i2) {
        this.O0000Oo = i;
        this.O0000OoO = str;
        this.O0000Ooo = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof jej) || this.O0000Oo != ((jej) obj).O0000Oo) {
            return false;
        }
        return true;
    }

    public final boolean O000000o(jej jej) {
        return this.O0000Oo >= jej.O0000Oo;
    }

    public final String toString() {
        return this.O0000OoO;
    }
}

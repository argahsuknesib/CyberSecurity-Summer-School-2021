package _m_j;

import java.io.IOException;
import java.io.Writer;

public final class jdr extends jdm {
    private final int O00000Oo;
    private final boolean O00000o;
    private final int O00000o0;

    private jdr(int i, int i2) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = true;
    }

    public jdr() {
        this(0, Integer.MAX_VALUE);
    }

    public static jdr O000000o(int i, int i2) {
        return new jdr(i, i2);
    }

    public final boolean O000000o(int i, Writer writer) throws IOException {
        if (this.O00000o) {
            if (i < this.O00000Oo || i > this.O00000o0) {
                return false;
            }
        } else if (i >= this.O00000Oo && i <= this.O00000o0) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }
}

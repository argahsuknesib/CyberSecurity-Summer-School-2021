package _m_j;

import java.io.IOException;
import java.io.Writer;

public class jdu extends jdm {
    private final int O00000Oo;
    private final boolean O00000o = false;
    private final int O00000o0;

    protected jdu(int i, int i2, boolean z) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
    }

    public final boolean O000000o(int i, Writer writer) throws IOException {
        if (this.O00000o) {
            if (i < this.O00000Oo || i > this.O00000o0) {
                return false;
            }
        } else if (i >= this.O00000Oo && i <= this.O00000o0) {
            return false;
        }
        if (i > 65535) {
            writer.write(O00000Oo(i));
            return true;
        }
        writer.write("\\u");
        writer.write(f1778O000000o[(i >> 12) & 15]);
        writer.write(f1778O000000o[(i >> 8) & 15]);
        writer.write(f1778O000000o[(i >> 4) & 15]);
        writer.write(f1778O000000o[i & 15]);
        return true;
    }

    /* access modifiers changed from: protected */
    public String O00000Oo(int i) {
        return "\\u" + O000000o(i);
    }
}

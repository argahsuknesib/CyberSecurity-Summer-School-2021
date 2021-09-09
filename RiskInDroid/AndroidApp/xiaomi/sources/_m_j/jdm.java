package _m_j;

import java.io.IOException;
import java.io.Writer;

public abstract class jdm extends jdl {
    public abstract boolean O000000o(int i, Writer writer) throws IOException;

    public final int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
        return O000000o(Character.codePointAt(charSequence, i), writer) ? 1 : 0;
    }
}

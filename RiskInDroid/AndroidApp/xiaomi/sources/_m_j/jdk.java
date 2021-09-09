package _m_j;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class jdk extends jdl {
    private final List<jdl> O00000Oo = new ArrayList();

    public jdk(jdl... jdlArr) {
        for (jdl jdl : jdlArr) {
            if (jdl != null) {
                this.O00000Oo.add(jdl);
            }
        }
    }

    public final int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
        for (jdl O000000o2 : this.O00000Oo) {
            int O000000o3 = O000000o2.O000000o(charSequence, i, writer);
            if (O000000o3 != 0) {
                return O000000o3;
            }
        }
        return 0;
    }
}

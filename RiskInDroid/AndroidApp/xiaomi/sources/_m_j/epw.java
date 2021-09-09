package _m_j;

import java.nio.ByteBuffer;

public final class epw extends epq {
    public epw() {
        O000000o("PING", (String) null);
        O000000o("0");
        O000000o(0);
    }

    /* access modifiers changed from: package-private */
    public final ByteBuffer O000000o(ByteBuffer byteBuffer) {
        return O00000o0().length == 0 ? byteBuffer : super.O000000o(byteBuffer);
    }

    public final int O00000o() {
        if (O00000o0().length == 0) {
            return 0;
        }
        return super.O00000o();
    }
}

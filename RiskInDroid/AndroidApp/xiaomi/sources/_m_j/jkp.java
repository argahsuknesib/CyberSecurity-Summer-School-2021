package _m_j;

import _m_j.jhf;
import java.nio.ByteBuffer;

public abstract class jkp extends jkn implements jhb {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private int flags;
    private int version;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AbstractFullBox.java", jkp.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "setVersion", "org.mp4parser.support.AbstractFullBox", "int", "version", "", "void"), 50);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setFlags", "org.mp4parser.support.AbstractFullBox", "int", "flags", "", "void"), 63);
    }

    protected jkp(String str) {
        super(str);
    }

    protected jkp(String str, byte[] bArr) {
        super(str, bArr);
    }

    public int getVersion() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.version;
    }

    public int getFlags() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.flags;
    }

    /* access modifiers changed from: protected */
    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        jla.O00000o(byteBuffer, this.version);
        jla.O000000o(byteBuffer, this.flags);
    }

    public void setVersion(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.version = i;
    }

    public void setFlags(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.flags = i;
    }

    /* access modifiers changed from: protected */
    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = jky.O000000o(byteBuffer.get());
        this.flags = jky.O00000Oo(byteBuffer);
        return 4;
    }
}

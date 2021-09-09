package org.mp4parser.boxes.oma;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public final class OmaDrmAccessUnitFormatBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private byte allBits;
    private int initVectorLength;
    private int keyIndicatorLength;
    private boolean selectiveEncryption;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("OmaDrmAccessUnitFormatBox.java", OmaDrmAccessUnitFormatBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "isSelectiveEncryption", "org.mp4parser.boxes.oma.OmaDrmAccessUnitFormatBox", "", "", "", "boolean"), 46);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getKeyIndicatorLength", "org.mp4parser.boxes.oma.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 50);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "setKeyIndicatorLength", "org.mp4parser.boxes.oma.OmaDrmAccessUnitFormatBox", "int", "keyIndicatorLength", "", "void"), 54);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getInitVectorLength", "org.mp4parser.boxes.oma.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 58);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "setInitVectorLength", "org.mp4parser.boxes.oma.OmaDrmAccessUnitFormatBox", "int", "initVectorLength", "", "void"), 62);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setAllBits", "org.mp4parser.boxes.oma.OmaDrmAccessUnitFormatBox", "byte", "allBits", "", "void"), 66);
    }

    public final long getContentSize() {
        return 7;
    }

    public OmaDrmAccessUnitFormatBox() {
        super("odaf");
    }

    public final boolean isSelectiveEncryption() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.selectiveEncryption;
    }

    public final int getKeyIndicatorLength() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.keyIndicatorLength;
    }

    public final int getInitVectorLength() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.initVectorLength;
    }

    public final void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.allBits = (byte) jky.O000000o(byteBuffer.get());
        this.selectiveEncryption = (this.allBits & 128) == 128;
        this.keyIndicatorLength = jky.O000000o(byteBuffer.get());
        this.initVectorLength = jky.O000000o(byteBuffer.get());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000o(java.nio.ByteBuffer, int):void
     arg types: [java.nio.ByteBuffer, byte]
     candidates:
      _m_j.jla.O00000o(java.nio.ByteBuffer, long):void
      _m_j.jla.O00000o(java.nio.ByteBuffer, int):void */
    public final void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000o(byteBuffer, (int) this.allBits);
        jla.O00000o(byteBuffer, this.keyIndicatorLength);
        jla.O00000o(byteBuffer, this.initVectorLength);
    }

    public final void setKeyIndicatorLength(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.keyIndicatorLength = i;
    }

    public final void setInitVectorLength(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.initVectorLength = i;
    }

    public final void setAllBits(byte b) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Byte.valueOf(b));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.allBits = b;
        this.selectiveEncryption = (b & 128) == 128;
    }
}

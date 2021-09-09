package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jku;
import _m_j.jkz;
import _m_j.jlb;
import java.nio.ByteBuffer;

public abstract class AppleVariableSignedIntegerBox extends AppleDataBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    int intLength = 1;
    long value;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleVariableSignedIntegerBox.java", AppleVariableSignedIntegerBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getIntLength", "org.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "int"), 19);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setIntLength", "org.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "int", "intLength", "", "void"), 23);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getValue", "org.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "long"), 27);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setValue", "org.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "long", "value", "", "void"), 35);
    }

    protected AppleVariableSignedIntegerBox(String str) {
        super(str, 15);
    }

    public int getIntLength() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.intLength;
    }

    public long getValue() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (!isParsed()) {
            parseDetails();
        }
        return this.value;
    }

    public void setValue(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (j <= 127 && j > -128) {
            this.intLength = 1;
        } else if (j <= 32767 && j > -32768 && this.intLength < 2) {
            this.intLength = 2;
        } else if (j > 8388607 || j <= -8388608 || this.intLength >= 3) {
            this.intLength = 4;
        } else {
            this.intLength = 3;
        }
        this.value = j;
    }

    /* access modifiers changed from: protected */
    public byte[] writeData() {
        int dataLength = getDataLength();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[dataLength]);
        jlb.O000000o(this.value, wrap, dataLength);
        return wrap.array();
    }

    /* access modifiers changed from: protected */
    public void parseData(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.value = jkz.O000000o(byteBuffer, remaining);
        this.intLength = remaining;
    }

    /* access modifiers changed from: protected */
    public int getDataLength() {
        return this.intLength;
    }

    public void setIntLength(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.intLength = i;
    }
}

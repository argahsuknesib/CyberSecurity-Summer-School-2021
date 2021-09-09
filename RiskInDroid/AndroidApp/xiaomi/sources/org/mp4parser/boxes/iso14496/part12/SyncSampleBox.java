package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class SyncSampleBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private long[] sampleNumber;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SyncSampleBox.java", SyncSampleBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleNumber", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "", "", "", "[J"), 45);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleNumber", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "[J", "sampleNumber", "", "void"), 49);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "", "", "", "java.lang.String"), 80);
    }

    public SyncSampleBox() {
        super("stss");
    }

    public long[] getSampleNumber() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sampleNumber;
    }

    public void setSampleNumber(long[] jArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sampleNumber = jArr;
    }

    public long getContentSize() {
        return (long) ((this.sampleNumber.length * 4) + 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
        this.sampleNumber = new long[O000000o2];
        for (int i = 0; i < O000000o2; i++) {
            this.sampleNumber[i] = jky.O000000o(byteBuffer);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, (long) this.sampleNumber.length);
        for (long O00000Oo : this.sampleNumber) {
            jla.O00000Oo(byteBuffer, O00000Oo);
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "SyncSampleBox[entryCount=" + this.sampleNumber.length + "]";
    }
}

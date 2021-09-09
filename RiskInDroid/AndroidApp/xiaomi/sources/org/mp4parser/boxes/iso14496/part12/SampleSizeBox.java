package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class SampleSizeBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    int sampleCount;
    private long sampleSize;
    private long[] sampleSizes = new long[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("SampleSizeBox.java", SampleSizeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleSize", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "long"), 49);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleSize", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "long", "sampleSize", "", "void"), 53);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleSizeAtIndex", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "int", "index", "", "long"), 58);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleCount", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "long"), 66);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleSizes", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "[J"), 75);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleSizes", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "[J", "sampleSizes", "", "void"), 79);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "java.lang.String"), 118);
    }

    public SampleSizeBox() {
        super("stsz");
    }

    public long getSampleSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sampleSize;
    }

    public void setSampleSize(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sampleSize = j;
    }

    public long getSampleCount() {
        int length;
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this.sampleSize > 0) {
            length = this.sampleCount;
        } else {
            length = this.sampleSizes.length;
        }
        return (long) length;
    }

    public long[] getSampleSizes() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sampleSizes;
    }

    public void setSampleSizes(long[] jArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.sampleSizes = jArr;
    }

    public long getContentSize() {
        return (long) ((this.sampleSize == 0 ? this.sampleSizes.length * 4 : 0) + 12);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.sampleSize = jky.O000000o(byteBuffer);
        this.sampleCount = jkv.O000000o(jky.O000000o(byteBuffer));
        if (this.sampleSize == 0) {
            this.sampleSizes = new long[this.sampleCount];
            for (int i = 0; i < this.sampleCount; i++) {
                this.sampleSizes[i] = jky.O000000o(byteBuffer);
            }
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.sampleSize);
        if (this.sampleSize == 0) {
            jla.O00000Oo(byteBuffer, (long) this.sampleSizes.length);
            for (long O00000Oo : this.sampleSizes) {
                jla.O00000Oo(byteBuffer, O00000Oo);
            }
            return;
        }
        jla.O00000Oo(byteBuffer, (long) this.sampleCount);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "SampleSizeBox[sampleSize=" + getSampleSize() + ";sampleCount=" + getSampleCount() + "]";
    }

    public long getSampleSizeAtIndex(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        long j = this.sampleSize;
        if (j > 0) {
            return j;
        }
        return this.sampleSizes[i];
    }
}

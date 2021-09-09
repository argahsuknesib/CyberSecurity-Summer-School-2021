package org.mp4parser.boxes.sampleentry;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class AmrSpecificBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private int decoderVersion;
    private int framesPerSample;
    private int modeChangePeriod;
    private int modeSet;
    private String vendor;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AmrSpecificBox.java", AmrSpecificBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getVendor", "org.mp4parser.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 46);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getDecoderVersion", "org.mp4parser.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 50);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getModeSet", "org.mp4parser.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 54);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getModeChangePeriod", "org.mp4parser.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 58);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getFramesPerSample", "org.mp4parser.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 62);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getContent", "org.mp4parser.boxes.sampleentry.AmrSpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 84);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 92);
    }

    public long getContentSize() {
        return 9;
    }

    public AmrSpecificBox() {
        super("damr");
    }

    public String getVendor() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.vendor;
    }

    public int getDecoderVersion() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.decoderVersion;
    }

    public int getModeSet() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.modeSet;
    }

    public int getModeChangePeriod() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.modeChangePeriod;
    }

    public int getFramesPerSample() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.framesPerSample;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.vendor = jhc.O000000o(bArr);
        this.decoderVersion = jky.O000000o(byteBuffer.get());
        this.modeSet = jky.O00000o0(byteBuffer);
        this.modeChangePeriod = jky.O000000o(byteBuffer.get());
        this.framesPerSample = jky.O000000o(byteBuffer.get());
    }

    public void getContent(ByteBuffer byteBuffer) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, byteBuffer);
        jku.O000000o();
        jku.O000000o(O000000o2);
        byteBuffer.put(jhc.O000000o(this.vendor));
        jla.O00000o(byteBuffer, this.decoderVersion);
        jla.O00000Oo(byteBuffer, this.modeSet);
        jla.O00000o(byteBuffer, this.modeChangePeriod);
        jla.O00000o(byteBuffer, this.framesPerSample);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "AmrSpecificBox[vendor=" + getVendor() + ";decoderVersion=" + getDecoderVersion() + ";modeSet=" + getModeSet() + ";modeChangePeriod=" + getModeChangePeriod() + ";framesPerSample=" + getFramesPerSample() + "]";
    }
}

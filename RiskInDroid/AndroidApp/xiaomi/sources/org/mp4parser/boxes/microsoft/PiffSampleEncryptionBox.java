package org.mp4parser.boxes.microsoft;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox;

public class PiffSampleEncryptionBox extends AbstractSampleEncryptionBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("PiffSampleEncryptionBox.java", PiffSampleEncryptionBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getAlgorithmId", "org.mp4parser.boxes.microsoft.PiffSampleEncryptionBox", "", "", "", "int"), 46);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setAlgorithmId", "org.mp4parser.boxes.microsoft.PiffSampleEncryptionBox", "int", "algorithmId", "", "void"), 50);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getIvSize", "org.mp4parser.boxes.microsoft.PiffSampleEncryptionBox", "", "", "", "int"), 54);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setIvSize", "org.mp4parser.boxes.microsoft.PiffSampleEncryptionBox", "int", "ivSize", "", "void"), 58);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getKid", "org.mp4parser.boxes.microsoft.PiffSampleEncryptionBox", "", "", "", "[B"), 62);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setKid", "org.mp4parser.boxes.microsoft.PiffSampleEncryptionBox", "[B", "kid", "", "void"), 66);
    }

    public PiffSampleEncryptionBox() {
        super("uuid");
    }

    public byte[] getUserType() {
        return new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    }

    public int getAlgorithmId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.algorithmId;
    }

    public int getIvSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.ivSize;
    }

    public byte[] getKid() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.kid;
    }

    public void setKid(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.kid = bArr;
    }

    public boolean isOverrideTrackEncryptionBoxParameters() {
        return (getFlags() & 1) > 0;
    }

    public void setOverrideTrackEncryptionBoxParameters(boolean z) {
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & 16777214);
        }
    }

    public void setAlgorithmId(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.algorithmId = i;
    }

    public void setIvSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.ivSize = i;
    }
}

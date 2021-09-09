package org.mp4parser.boxes.iso23001.part7;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.UUID;

public abstract class AbstractTrackEncryptionBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    int defaultAlgorithmId;
    int defaultIvSize;
    byte[] default_KID;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AbstractTrackEncryptionBox.java", AbstractTrackEncryptionBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultAlgorithmId", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "", "", "", "int"), 24);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultAlgorithmId", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "int", "defaultAlgorithmId", "", "void"), 28);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultIvSize", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "", "", "", "int"), 32);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultIvSize", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "int", "defaultIvSize", "", "void"), 36);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getDefault_KID", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "", "", "", "java.util.UUID"), 40);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setDefault_KID", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "java.util.UUID", "uuid", "", "void"), 46);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "equals", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "java.lang.Object", "o", "", "boolean"), 76);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "hashCode", "org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox", "", "", "", "int"), 90);
    }

    public long getContentSize() {
        return 24;
    }

    protected AbstractTrackEncryptionBox(String str) {
        super(str);
    }

    public int getDefaultAlgorithmId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultAlgorithmId;
    }

    public int getDefaultIvSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultIvSize;
    }

    public UUID getDefault_KID() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        ByteBuffer wrap = ByteBuffer.wrap(this.default_KID);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public void setDefault_KID(UUID uuid) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, uuid);
        jku.O000000o();
        jku.O000000o(O000000o2);
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        this.default_KID = wrap.array();
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.defaultAlgorithmId = jky.O00000Oo(byteBuffer);
        this.defaultIvSize = jky.O000000o(byteBuffer.get());
        this.default_KID = new byte[16];
        byteBuffer.get(this.default_KID);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O000000o(byteBuffer, this.defaultAlgorithmId);
        jla.O00000o(byteBuffer, this.defaultIvSize);
        byteBuffer.put(this.default_KID);
    }

    public boolean equals(Object obj) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, obj);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractTrackEncryptionBox abstractTrackEncryptionBox = (AbstractTrackEncryptionBox) obj;
        return this.defaultAlgorithmId == abstractTrackEncryptionBox.defaultAlgorithmId && this.defaultIvSize == abstractTrackEncryptionBox.defaultIvSize && Arrays.equals(this.default_KID, abstractTrackEncryptionBox.default_KID);
    }

    public int hashCode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        int i = ((this.defaultAlgorithmId * 31) + this.defaultIvSize) * 31;
        byte[] bArr = this.default_KID;
        return i + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public void setDefaultAlgorithmId(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultAlgorithmId = i;
    }

    public void setDefaultIvSize(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultIvSize = i;
    }
}

package org.mp4parser.boxes.microsoft;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import _m_j.jlh;
import java.nio.ByteBuffer;
import java.util.UUID;

public class UuidBasedProtectionSystemSpecificHeaderBox extends jkp {
    public static byte[] USER_TYPE = {-48, -118, 79, 24, 16, -13, 74, -126, -74, -56, 50, -40, -85, -95, -125, -45};
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    ProtectionSpecificHeader protectionSpecificHeader;
    UUID systemId;

    private static void ajc$preClinit() {
        jho jho = new jho("UuidBasedProtectionSystemSpecificHeaderBox.java", UuidBasedProtectionSystemSpecificHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSystemId", "org.mp4parser.boxes.microsoft.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.util.UUID"), 66);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setSystemId", "org.mp4parser.boxes.microsoft.UuidBasedProtectionSystemSpecificHeaderBox", "java.util.UUID", "systemId", "", "void"), 70);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getSystemIdString", "org.mp4parser.boxes.microsoft.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 74);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getProtectionSpecificHeader", "org.mp4parser.boxes.microsoft.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "org.mp4parser.boxes.microsoft.ProtectionSpecificHeader"), 78);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "setProtectionSpecificHeader", "org.mp4parser.boxes.microsoft.UuidBasedProtectionSystemSpecificHeaderBox", "org.mp4parser.boxes.microsoft.ProtectionSpecificHeader", "protectionSpecificHeader", "", "void"), 82);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getProtectionSpecificHeaderString", "org.mp4parser.boxes.microsoft.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 86);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.microsoft.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 91);
    }

    static {
        ajc$preClinit();
    }

    public UuidBasedProtectionSystemSpecificHeaderBox() {
        super("uuid", USER_TYPE);
    }

    public long getContentSize() {
        return (long) (this.protectionSpecificHeader.getData().limit() + 24);
    }

    public byte[] getUserType() {
        return USER_TYPE;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O000000o(byteBuffer, this.systemId.getMostSignificantBits());
        jla.O000000o(byteBuffer, this.systemId.getLeastSignificantBits());
        ByteBuffer data = this.protectionSpecificHeader.getData();
        data.rewind();
        jla.O00000Oo(byteBuffer, (long) data.limit());
        byteBuffer.put(data);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.systemId = jlh.O000000o(bArr);
        jkv.O000000o(jky.O000000o(byteBuffer));
        this.protectionSpecificHeader = ProtectionSpecificHeader.createFor(this.systemId, byteBuffer);
    }

    public UUID getSystemId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.systemId;
    }

    public void setSystemId(UUID uuid) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, uuid);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.systemId = uuid;
    }

    public String getSystemIdString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.systemId.toString();
    }

    public ProtectionSpecificHeader getProtectionSpecificHeader() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.protectionSpecificHeader;
    }

    public void setProtectionSpecificHeader(ProtectionSpecificHeader protectionSpecificHeader2) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, protectionSpecificHeader2);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.protectionSpecificHeader = protectionSpecificHeader2;
    }

    public String getProtectionSpecificHeaderString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.protectionSpecificHeader.toString();
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "UuidBasedProtectionSystemSpecificHeaderBox" + "{systemId=" + this.systemId.toString() + ", dataSize=" + this.protectionSpecificHeader.getData().limit() + '}';
    }
}

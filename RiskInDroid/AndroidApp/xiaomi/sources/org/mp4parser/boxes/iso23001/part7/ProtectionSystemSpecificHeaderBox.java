package org.mp4parser.boxes.iso23001.part7;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import _m_j.jlh;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProtectionSystemSpecificHeaderBox extends jkp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static byte[] OMA2_SYSTEM_ID = jlh.O000000o(UUID.fromString("A2B55680-6F43-11E0-9A3F-0002A5D5C51B"));
    public static byte[] PLAYREADY_SYSTEM_ID = jlh.O000000o(UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95"));
    public static byte[] WIDEVINE = jlh.O000000o(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    byte[] content;
    List<UUID> keyIds = new ArrayList();
    byte[] systemId;

    private static void ajc$preClinit() {
        jho jho = new jho("ProtectionSystemSpecificHeaderBox.java", ProtectionSystemSpecificHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getKeyIds", "org.mp4parser.boxes.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "java.util.List"), 52);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setKeyIds", "org.mp4parser.boxes.iso23001.part7.ProtectionSystemSpecificHeaderBox", "java.util.List", "keyIds", "", "void"), 56);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getSystemId", "org.mp4parser.boxes.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 60);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setSystemId", "org.mp4parser.boxes.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "systemId", "", "void"), 64);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getContent", "org.mp4parser.boxes.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 69);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setContent", "org.mp4parser.boxes.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "content", "", "void"), 73);
    }

    static {
        ajc$preClinit();
    }

    public ProtectionSystemSpecificHeaderBox(byte[] bArr, byte[] bArr2) {
        super("pssh");
        this.content = bArr2;
        this.systemId = bArr;
    }

    public ProtectionSystemSpecificHeaderBox() {
        super("pssh");
    }

    public List<UUID> getKeyIds() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.keyIds;
    }

    public void setKeyIds(List<UUID> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.keyIds = list;
    }

    public byte[] getSystemId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.systemId;
    }

    public void setSystemId(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.systemId = bArr;
    }

    public byte[] getContent() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.content;
    }

    public void setContent(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.content = bArr;
    }

    public long getContentSize() {
        long length = (long) (this.content.length + 24);
        return getVersion() > 0 ? length + 4 + ((long) (this.keyIds.size() * 16)) : length;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.systemId, 0, 16);
        if (getVersion() > 0) {
            jla.O00000Oo(byteBuffer, (long) this.keyIds.size());
            for (UUID O000000o2 : this.keyIds) {
                byteBuffer.put(jlh.O000000o(O000000o2));
            }
        }
        jla.O00000Oo(byteBuffer, (long) this.content.length);
        byteBuffer.put(this.content);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.systemId = new byte[16];
        byteBuffer.get(this.systemId);
        if (getVersion() > 0) {
            int O000000o2 = jkv.O000000o(jky.O000000o(byteBuffer));
            while (true) {
                int i = O000000o2 - 1;
                if (O000000o2 <= 0) {
                    break;
                }
                byte[] bArr = new byte[16];
                byteBuffer.get(bArr);
                this.keyIds.add(jlh.O000000o(bArr));
                O000000o2 = i;
            }
        }
        jky.O000000o(byteBuffer);
        this.content = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.content);
    }
}

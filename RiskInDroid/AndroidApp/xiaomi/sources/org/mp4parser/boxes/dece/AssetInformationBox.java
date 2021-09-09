package org.mp4parser.boxes.dece;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;

public class AssetInformationBox extends jkp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    String apid = "";
    String profileVersion = "0000";

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AssetInformationBox.java", AssetInformationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getApid", "org.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 80);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setApid", "org.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "apid", "", "void"), 84);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getProfileVersion", "org.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 88);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setProfileVersion", "org.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "profileVersion", "", "void"), 92);
    }

    public AssetInformationBox() {
        super("ainf");
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.apid) + 9);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 0) {
            byteBuffer.put(jli.O000000o(this.profileVersion), 0, 4);
            byteBuffer.put(jli.O000000o(this.apid));
            byteBuffer.put((byte) 0);
            return;
        }
        throw new RuntimeException("Unknown ainf version " + getVersion());
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.profileVersion = jky.O000000o(byteBuffer, 4);
        this.apid = jky.O00000oO(byteBuffer);
    }

    public String getApid() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.apid;
    }

    public void setApid(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.apid = str;
    }

    public String getProfileVersion() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.profileVersion;
    }

    public void setProfileVersion(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.profileVersion = str;
    }

    public boolean isHidden() {
        return (getFlags() & 1) == 1;
    }

    public void setHidden(boolean z) {
        int flags = getFlags();
        if (!(isHidden() ^ z)) {
            return;
        }
        if (z) {
            setFlags(flags | 1);
        } else {
            setFlags(16777214 & flags);
        }
    }

    public static class Entry {
        public String assetId;
        public String namespace;
        public String profileLevelIdc;

        public Entry(String str, String str2, String str3) {
            this.namespace = str;
            this.profileLevelIdc = str2;
            this.assetId = str3;
        }

        public String toString() {
            return "{namespace='" + this.namespace + '\'' + ", profileLevelIdc='" + this.profileLevelIdc + '\'' + ", assetId='" + this.assetId + '\'' + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.assetId.equals(entry.assetId) && this.namespace.equals(entry.namespace) && this.profileLevelIdc.equals(entry.profileLevelIdc);
        }

        public int hashCode() {
            return (((this.namespace.hashCode() * 31) + this.profileLevelIdc.hashCode()) * 31) + this.assetId.hashCode();
        }

        public int getSize() {
            return jli.O00000Oo(this.namespace) + 3 + jli.O00000Oo(this.profileLevelIdc) + jli.O00000Oo(this.assetId);
        }
    }
}

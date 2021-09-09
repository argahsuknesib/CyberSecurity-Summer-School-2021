package org.mp4parser.boxes.dece;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;

public class BaseLocationBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    String baseLocation = "";
    String purchaseLocation = "";

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("BaseLocationBox.java", BaseLocationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getBaseLocation", "org.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setBaseLocation", "org.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "baseLocation", "", "void"), 48);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getPurchaseLocation", "org.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 52);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setPurchaseLocation", "org.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "purchaseLocation", "", "void"), 56);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "equals", "org.mp4parser.boxes.dece.BaseLocationBox", "java.lang.Object", "o", "", "boolean"), 86);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "hashCode", "org.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "int"), 100);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 107);
    }

    public long getContentSize() {
        return 1028;
    }

    public BaseLocationBox() {
        super("bloc");
    }

    public BaseLocationBox(String str, String str2) {
        super("bloc");
        this.baseLocation = str;
        this.purchaseLocation = str2;
    }

    public String getBaseLocation() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.baseLocation;
    }

    public void setBaseLocation(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.baseLocation = str;
    }

    public String getPurchaseLocation() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.purchaseLocation;
    }

    public void setPurchaseLocation(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.purchaseLocation = str;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.baseLocation = jky.O00000oO(byteBuffer);
        byteBuffer.get(new byte[((256 - jli.O00000Oo(this.baseLocation)) - 1)]);
        this.purchaseLocation = jky.O00000oO(byteBuffer);
        byteBuffer.get(new byte[((256 - jli.O00000Oo(this.purchaseLocation)) - 1)]);
        byteBuffer.get(new byte[512]);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(jli.O000000o(this.baseLocation));
        byteBuffer.put(new byte[(256 - jli.O00000Oo(this.baseLocation))]);
        byteBuffer.put(jli.O000000o(this.purchaseLocation));
        byteBuffer.put(new byte[(256 - jli.O00000Oo(this.purchaseLocation))]);
        byteBuffer.put(new byte[512]);
    }

    public boolean equals(Object obj) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, obj);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseLocationBox baseLocationBox = (BaseLocationBox) obj;
        String str = this.baseLocation;
        if (str == null ? baseLocationBox.baseLocation != null : !str.equals(baseLocationBox.baseLocation)) {
            return false;
        }
        String str2 = this.purchaseLocation;
        return str2 == null ? baseLocationBox.purchaseLocation == null : str2.equals(baseLocationBox.purchaseLocation);
    }

    public int hashCode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        String str = this.baseLocation;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.purchaseLocation;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "BaseLocationBox{baseLocation='" + this.baseLocation + '\'' + ", purchaseLocation='" + this.purchaseLocation + '\'' + '}';
    }
}

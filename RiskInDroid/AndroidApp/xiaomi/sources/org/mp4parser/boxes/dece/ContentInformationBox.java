package org.mp4parser.boxes.dece;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContentInformationBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    Map<String, String> brandEntries = new LinkedHashMap();
    String codecs;
    Map<String, String> idEntries = new LinkedHashMap();
    String languages;
    String mimeSubtypeName;
    String profileLevelIdc;
    String protection;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("ContentInformationBox.java", ContentInformationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getMimeSubtypeName", "org.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 114);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setMimeSubtypeName", "org.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "mimeSubtypeName", "", "void"), 118);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getBrandEntries", "org.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 154);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setBrandEntries", "org.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "brandEntries", "", "void"), 158);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getIdEntries", "org.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 162);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setIdEntries", "org.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "idEntries", "", "void"), 166);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getProfileLevelIdc", "org.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 122);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setProfileLevelIdc", "org.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "profileLevelIdc", "", "void"), 126);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getCodecs", "org.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 130);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setCodecs", "org.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "codecs", "", "void"), 134);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getProtection", "org.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 138);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setProtection", "org.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "protection", "", "void"), 142);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguages", "org.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 146);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguages", "org.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "languages", "", "void"), 150);
    }

    public ContentInformationBox() {
        super("cinf");
    }

    public long getContentSize() {
        long O00000Oo = ((long) (jli.O00000Oo(this.mimeSubtypeName) + 1)) + 4 + ((long) (jli.O00000Oo(this.profileLevelIdc) + 1)) + ((long) (jli.O00000Oo(this.codecs) + 1)) + ((long) (jli.O00000Oo(this.protection) + 1)) + ((long) (jli.O00000Oo(this.languages) + 1)) + 1;
        for (Map.Entry next : this.brandEntries.entrySet()) {
            O00000Oo = O00000Oo + ((long) (jli.O00000Oo((String) next.getKey()) + 1)) + ((long) (jli.O00000Oo((String) next.getValue()) + 1));
        }
        long j = O00000Oo + 1;
        for (Map.Entry next2 : this.idEntries.entrySet()) {
            j = j + ((long) (jli.O00000Oo((String) next2.getKey()) + 1)) + ((long) (jli.O00000Oo((String) next2.getValue()) + 1));
        }
        return j;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.mimeSubtypeName);
        jla.O00000Oo(byteBuffer, this.profileLevelIdc);
        jla.O00000Oo(byteBuffer, this.codecs);
        jla.O00000Oo(byteBuffer, this.protection);
        jla.O00000Oo(byteBuffer, this.languages);
        jla.O00000o(byteBuffer, this.brandEntries.size());
        for (Map.Entry next : this.brandEntries.entrySet()) {
            jla.O00000Oo(byteBuffer, (String) next.getKey());
            jla.O00000Oo(byteBuffer, (String) next.getValue());
        }
        jla.O00000o(byteBuffer, this.idEntries.size());
        for (Map.Entry next2 : this.idEntries.entrySet()) {
            jla.O00000Oo(byteBuffer, (String) next2.getKey());
            jla.O00000Oo(byteBuffer, (String) next2.getValue());
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.mimeSubtypeName = jky.O00000oO(byteBuffer);
        this.profileLevelIdc = jky.O00000oO(byteBuffer);
        this.codecs = jky.O00000oO(byteBuffer);
        this.protection = jky.O00000oO(byteBuffer);
        this.languages = jky.O00000oO(byteBuffer);
        int O000000o2 = jky.O000000o(byteBuffer.get());
        while (true) {
            int i = O000000o2 - 1;
            if (O000000o2 <= 0) {
                break;
            }
            this.brandEntries.put(jky.O00000oO(byteBuffer), jky.O00000oO(byteBuffer));
            O000000o2 = i;
        }
        int O000000o3 = jky.O000000o(byteBuffer.get());
        while (true) {
            int i2 = O000000o3 - 1;
            if (O000000o3 > 0) {
                this.idEntries.put(jky.O00000oO(byteBuffer), jky.O00000oO(byteBuffer));
                O000000o3 = i2;
            } else {
                return;
            }
        }
    }

    public String getMimeSubtypeName() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.mimeSubtypeName;
    }

    public void setMimeSubtypeName(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.mimeSubtypeName = str;
    }

    public String getProfileLevelIdc() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.profileLevelIdc;
    }

    public void setProfileLevelIdc(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.profileLevelIdc = str;
    }

    public String getCodecs() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.codecs;
    }

    public void setCodecs(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.codecs = str;
    }

    public String getProtection() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.protection;
    }

    public void setProtection(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.protection = str;
    }

    public String getLanguages() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.languages;
    }

    public void setLanguages(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.languages = str;
    }

    public Map<String, String> getBrandEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.brandEntries;
    }

    public void setBrandEntries(Map<String, String> map) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, map);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.brandEntries = map;
    }

    public Map<String, String> getIdEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.idEntries;
    }

    public void setIdEntries(Map<String, String> map) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, map);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.idEntries = map;
    }

    public static class BrandEntry {
        String iso_brand;
        String version;

        public BrandEntry(String str, String str2) {
            this.iso_brand = str;
            this.version = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BrandEntry brandEntry = (BrandEntry) obj;
            String str = this.iso_brand;
            if (str == null ? brandEntry.iso_brand != null : !str.equals(brandEntry.iso_brand)) {
                return false;
            }
            String str2 = this.version;
            return str2 == null ? brandEntry.version == null : str2.equals(brandEntry.version);
        }

        public int hashCode() {
            String str = this.iso_brand;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.version;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }
    }
}

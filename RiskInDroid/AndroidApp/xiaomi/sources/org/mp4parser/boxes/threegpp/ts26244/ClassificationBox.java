package org.mp4parser.boxes.threegpp.ts26244;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class ClassificationBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private String classificationEntity;
    private String classificationInfo;
    private int classificationTableIndex;
    private String language;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("ClassificationBox.java", ClassificationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguage", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguage", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "java.lang.String", "language", "", "void"), 48);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getClassificationEntity", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "", "", "", "java.lang.String"), 52);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setClassificationEntity", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "java.lang.String", "classificationEntity", "", "void"), 56);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getClassificationTableIndex", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "", "", "", "int"), 60);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setClassificationTableIndex", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "int", "classificationTableIndex", "", "void"), 64);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getClassificationInfo", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "", "", "", "java.lang.String"), 68);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setClassificationInfo", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "java.lang.String", "classificationInfo", "", "void"), 72);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.threegpp.ts26244.ClassificationBox", "", "", "", "java.lang.String"), 101);
    }

    public ClassificationBox() {
        super("clsf");
    }

    public String getLanguage() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.language;
    }

    public void setLanguage(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.language = str;
    }

    public String getClassificationEntity() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.classificationEntity;
    }

    public void setClassificationEntity(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.classificationEntity = str;
    }

    public int getClassificationTableIndex() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.classificationTableIndex;
    }

    public String getClassificationInfo() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.classificationInfo;
    }

    public void setClassificationInfo(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.classificationInfo = str;
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.classificationInfo) + 8 + 1);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.classificationEntity = jhc.O000000o(bArr);
        this.classificationTableIndex = jky.O00000o0(byteBuffer);
        this.language = jky.O0000Oo(byteBuffer);
        this.classificationInfo = jky.O00000oO(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(jhc.O000000o(this.classificationEntity));
        jla.O00000Oo(byteBuffer, this.classificationTableIndex);
        jla.O000000o(byteBuffer, this.language);
        byteBuffer.put(jli.O000000o(this.classificationInfo));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "ClassificationBox[language=" + getLanguage() + "classificationEntity=" + getClassificationEntity() + ";classificationTableIndex=" + getClassificationTableIndex() + ";language=" + getLanguage() + ";classificationInfo=" + getClassificationInfo() + "]";
    }

    public void setClassificationTableIndex(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.classificationTableIndex = i;
    }
}

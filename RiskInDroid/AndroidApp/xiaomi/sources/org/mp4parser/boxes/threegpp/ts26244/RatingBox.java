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

public class RatingBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private String language;
    private String ratingCriteria;
    private String ratingEntity;
    private String ratingInfo;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("RatingBox.java", RatingBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguage", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "", "", "", "java.lang.String"), 45);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguage", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "java.lang.String", "language", "", "void"), 49);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getRatingEntity", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "", "", "", "java.lang.String"), 60);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setRatingEntity", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "java.lang.String", "ratingEntity", "", "void"), 64);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getRatingCriteria", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "", "", "", "java.lang.String"), 74);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setRatingCriteria", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "java.lang.String", "ratingCriteria", "", "void"), 78);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getRatingInfo", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "", "", "", "java.lang.String"), 82);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setRatingInfo", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "java.lang.String", "ratingInfo", "", "void"), 86);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.threegpp.ts26244.RatingBox", "", "", "", "java.lang.String"), 114);
    }

    public RatingBox() {
        super("rtng");
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

    public String getRatingEntity() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.ratingEntity;
    }

    public void setRatingEntity(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.ratingEntity = str;
    }

    public String getRatingCriteria() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.ratingCriteria;
    }

    public void setRatingCriteria(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.ratingCriteria = str;
    }

    public String getRatingInfo() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.ratingInfo;
    }

    public void setRatingInfo(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.ratingInfo = str;
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.ratingInfo) + 15);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.ratingEntity = jky.O0000OoO(byteBuffer);
        this.ratingCriteria = jky.O0000OoO(byteBuffer);
        this.language = jky.O0000Oo(byteBuffer);
        this.ratingInfo = jky.O00000oO(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(jhc.O000000o(this.ratingEntity));
        byteBuffer.put(jhc.O000000o(this.ratingCriteria));
        jla.O000000o(byteBuffer, this.language);
        byteBuffer.put(jli.O000000o(this.ratingInfo));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "RatingBox[language=" + getLanguage() + "ratingEntity=" + getRatingEntity() + ";ratingCriteria=" + getRatingCriteria() + ";language=" + getLanguage() + ";ratingInfo=" + getRatingInfo() + "]";
    }
}

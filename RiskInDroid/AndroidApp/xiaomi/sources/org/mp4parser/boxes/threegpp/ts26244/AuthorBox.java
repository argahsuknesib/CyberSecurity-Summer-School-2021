package org.mp4parser.boxes.threegpp.ts26244;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class AuthorBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private String author;
    private String language;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AuthorBox.java", AuthorBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguage", "org.mp4parser.boxes.threegpp.ts26244.AuthorBox", "", "", "", "java.lang.String"), 52);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguage", "org.mp4parser.boxes.threegpp.ts26244.AuthorBox", "java.lang.String", "language", "", "void"), 56);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getAuthor", "org.mp4parser.boxes.threegpp.ts26244.AuthorBox", "", "", "", "java.lang.String"), 65);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setAuthor", "org.mp4parser.boxes.threegpp.ts26244.AuthorBox", "java.lang.String", "author", "", "void"), 69);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.threegpp.ts26244.AuthorBox", "", "", "", "java.lang.String"), 93);
    }

    public AuthorBox() {
        super("auth");
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

    public String getAuthor() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.author;
    }

    public void setAuthor(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.author = str;
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.author) + 7);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = jky.O0000Oo(byteBuffer);
        this.author = jky.O00000oO(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O000000o(byteBuffer, this.language);
        byteBuffer.put(jli.O000000o(this.author));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "AuthorBox[language=" + getLanguage() + ";author=" + getAuthor() + "]";
    }
}

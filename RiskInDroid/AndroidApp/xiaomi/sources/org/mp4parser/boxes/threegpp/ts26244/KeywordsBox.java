package org.mp4parser.boxes.threegpp.ts26244;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class KeywordsBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private String[] keywords;
    private String language;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("KeywordsBox.java", KeywordsBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguage", "org.mp4parser.boxes.threegpp.ts26244.KeywordsBox", "", "", "", "java.lang.String"), 40);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguage", "org.mp4parser.boxes.threegpp.ts26244.KeywordsBox", "java.lang.String", "language", "", "void"), 44);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getKeywords", "org.mp4parser.boxes.threegpp.ts26244.KeywordsBox", "", "", "", "[Ljava.lang.String;"), 48);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setKeywords", "org.mp4parser.boxes.threegpp.ts26244.KeywordsBox", "[Ljava.lang.String;", "keywords", "", "void"), 52);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.threegpp.ts26244.KeywordsBox", "", "", "", "java.lang.String"), 87);
    }

    public KeywordsBox() {
        super("kywd");
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

    public String[] getKeywords() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.keywords;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object):_m_j.jhf
     arg types: [_m_j.jhf$O000000o, org.mp4parser.boxes.threegpp.ts26244.KeywordsBox, org.mp4parser.boxes.threegpp.ts26244.KeywordsBox, java.lang.String[]]
     candidates:
      _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object[]):_m_j.jhf
      _m_j.jho.O000000o(_m_j.jhf$O000000o, java.lang.Object, java.lang.Object, java.lang.Object):_m_j.jhf */
    public void setKeywords(String[] strArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, (Object) this, (Object) this, (Object) strArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.keywords = strArr;
    }

    public long getContentSize() {
        long j = 7;
        for (String O00000Oo : this.keywords) {
            j += (long) (jli.O00000Oo(O00000Oo) + 1 + 1);
        }
        return j;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = jky.O0000Oo(byteBuffer);
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.keywords = new String[O000000o2];
        for (int i = 0; i < O000000o2; i++) {
            byteBuffer.get();
            this.keywords[i] = jky.O00000oO(byteBuffer);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O000000o(byteBuffer, this.language);
        jla.O00000o(byteBuffer, this.keywords.length);
        for (String str : this.keywords) {
            jla.O00000o(byteBuffer, jli.O00000Oo(str) + 1);
            byteBuffer.put(jli.O000000o(str));
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("KeywordsBox[language=");
        stringBuffer.append(getLanguage());
        for (int i = 0; i < this.keywords.length; i++) {
            stringBuffer.append(";keyword");
            stringBuffer.append(i);
            stringBuffer.append("=");
            stringBuffer.append(this.keywords[i]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

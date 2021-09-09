package org.mp4parser.boxes.threegpp.ts26244;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class AlbumBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private String albumTitle;
    private String language;
    private int trackNumber;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AlbumBox.java", AlbumBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguage", "org.mp4parser.boxes.threegpp.ts26244.AlbumBox", "", "", "", "java.lang.String"), 52);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguage", "org.mp4parser.boxes.threegpp.ts26244.AlbumBox", "java.lang.String", "language", "", "void"), 56);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getAlbumTitle", "org.mp4parser.boxes.threegpp.ts26244.AlbumBox", "", "", "", "java.lang.String"), 60);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setAlbumTitle", "org.mp4parser.boxes.threegpp.ts26244.AlbumBox", "java.lang.String", "albumTitle", "", "void"), 64);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getTrackNumber", "org.mp4parser.boxes.threegpp.ts26244.AlbumBox", "", "", "", "int"), 68);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setTrackNumber", "org.mp4parser.boxes.threegpp.ts26244.AlbumBox", "int", "trackNumber", "", "void"), 72);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.threegpp.ts26244.AlbumBox", "", "", "", "java.lang.String"), 104);
    }

    public AlbumBox() {
        super("albm");
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

    public String getAlbumTitle() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.albumTitle;
    }

    public void setAlbumTitle(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.albumTitle = str;
    }

    public int getTrackNumber() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.trackNumber;
    }

    public long getContentSize() {
        int i = 1;
        int O00000Oo = jli.O00000Oo(this.albumTitle) + 6 + 1;
        if (this.trackNumber == -1) {
            i = 0;
        }
        return (long) (O00000Oo + i);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = jky.O0000Oo(byteBuffer);
        this.albumTitle = jky.O00000oO(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.trackNumber = jky.O000000o(byteBuffer.get());
        } else {
            this.trackNumber = -1;
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O000000o(byteBuffer, this.language);
        byteBuffer.put(jli.O000000o(this.albumTitle));
        byteBuffer.put((byte) 0);
        int i = this.trackNumber;
        if (i != -1) {
            jla.O00000o(byteBuffer, i);
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        StringBuilder sb = new StringBuilder();
        sb.append("AlbumBox[language=");
        sb.append(getLanguage());
        sb.append(";");
        sb.append("albumTitle=");
        sb.append(getAlbumTitle());
        if (this.trackNumber >= 0) {
            sb.append(";trackNumber=");
            sb.append(getTrackNumber());
        }
        sb.append("]");
        return sb.toString();
    }

    public void setTrackNumber(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.trackNumber = i;
    }
}

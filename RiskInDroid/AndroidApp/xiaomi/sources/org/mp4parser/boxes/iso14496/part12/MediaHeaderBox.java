package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jks;
import _m_j.jku;
import _m_j.jkw;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.Date;

public class MediaHeaderBox extends jkp {
    private static jks LOG = jks.O000000o(MediaHeaderBox.class);
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private Date creationTime = new Date();
    private long duration;
    private String language = "eng";
    private Date modificationTime = new Date();
    private long timescale;

    private static void ajc$preClinit() {
        jho jho = new jho("MediaHeaderBox.java", MediaHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.util.Date"), 46);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 50);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.lang.String"), 123);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.util.Date"), 54);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 58);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getTimescale", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "long"), 62);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setTimescale", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "long", "timescale", "", "void"), 66);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "long"), 70);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "long", "duration", "", "void"), 74);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguage", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.lang.String"), 78);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguage", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.lang.String", "language", "", "void"), 82);
    }

    static {
        ajc$preClinit();
    }

    public MediaHeaderBox() {
        super("mdhd");
    }

    public Date getCreationTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.creationTime;
    }

    public void setCreationTime(Date date) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, date);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.creationTime = date;
    }

    public Date getModificationTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.modificationTime;
    }

    public void setModificationTime(Date date) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, date);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.modificationTime = date;
    }

    public long getTimescale() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.timescale;
    }

    public void setTimescale(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.timescale = j;
    }

    public long getDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.duration;
    }

    public void setDuration(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.duration = j;
    }

    public String getLanguage() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.language;
    }

    public void setLanguage(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.language = str;
    }

    public long getContentSize() {
        return (getVersion() == 1 ? 32 : 20) + 2 + 2;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.creationTime = jkw.O000000o(jky.O00000oo(byteBuffer));
            this.modificationTime = jkw.O000000o(jky.O00000oo(byteBuffer));
            this.timescale = jky.O000000o(byteBuffer);
            this.duration = byteBuffer.getLong();
        } else {
            this.creationTime = jkw.O000000o(jky.O000000o(byteBuffer));
            this.modificationTime = jkw.O000000o(jky.O000000o(byteBuffer));
            this.timescale = jky.O000000o(byteBuffer);
            this.duration = (long) byteBuffer.getInt();
        }
        if (this.duration < -1) {
            LOG.O00000Oo("mdhd duration is not in expected range");
        }
        this.language = jky.O0000Oo(byteBuffer);
        jky.O00000o0(byteBuffer);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "MediaHeaderBox[" + "creationTime=" + getCreationTime() + ";" + "modificationTime=" + getModificationTime() + ";" + "timescale=" + getTimescale() + ";" + "duration=" + getDuration() + ";" + "language=" + getLanguage() + "]";
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            jla.O000000o(byteBuffer, jkw.O000000o(this.creationTime));
            jla.O000000o(byteBuffer, jkw.O000000o(this.modificationTime));
            jla.O00000Oo(byteBuffer, this.timescale);
            byteBuffer.putLong(this.duration);
        } else {
            jla.O00000Oo(byteBuffer, jkw.O000000o(this.creationTime));
            jla.O00000Oo(byteBuffer, jkw.O000000o(this.modificationTime));
            jla.O00000Oo(byteBuffer, this.timescale);
            byteBuffer.putInt((int) this.duration);
        }
        jla.O000000o(byteBuffer, this.language);
        jla.O00000Oo(byteBuffer, 0);
    }
}

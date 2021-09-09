package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jks;
import _m_j.jkt;
import _m_j.jku;
import _m_j.jkw;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.Date;

public class MovieHeaderBox extends jkp {
    private static jks LOG = jks.O000000o(MovieHeaderBox.class);
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_14 = null;
    private static final jhf.O000000o ajc$tjp_15 = null;
    private static final jhf.O000000o ajc$tjp_16 = null;
    private static final jhf.O000000o ajc$tjp_17 = null;
    private static final jhf.O000000o ajc$tjp_18 = null;
    private static final jhf.O000000o ajc$tjp_19 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_20 = null;
    private static final jhf.O000000o ajc$tjp_21 = null;
    private static final jhf.O000000o ajc$tjp_22 = null;
    private static final jhf.O000000o ajc$tjp_23 = null;
    private static final jhf.O000000o ajc$tjp_24 = null;
    private static final jhf.O000000o ajc$tjp_25 = null;
    private static final jhf.O000000o ajc$tjp_26 = null;
    private static final jhf.O000000o ajc$tjp_27 = null;
    private static final jhf.O000000o ajc$tjp_28 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private Date creationTime;
    private int currentTime;
    private long duration;
    private jkt matrix = jkt.f1911O000000o;
    private Date modificationTime;
    private long nextTrackId;
    private int posterTime;
    private int previewDuration;
    private int previewTime;
    private double rate = 1.0d;
    private int selectionDuration;
    private int selectionTime;
    private long timescale;
    private float volume = 1.0f;

    private static void ajc$preClinit() {
        jho jho = new jho("MovieHeaderBox.java", MovieHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.util.Date"), 62);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 66);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getVolume", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "float"), 113);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setVolume", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "float", "volume", "", "void"), 117);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getMatrix", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "org.mp4parser.support.Matrix"), 121);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setMatrix", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "org.mp4parser.support.Matrix", "matrix", "", "void"), 125);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getNextTrackId", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 129);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setNextTrackId", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "nextTrackId", "", "void"), 133);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.lang.String"), 187);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "getPreviewTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 241);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "setPreviewTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "previewTime", "", "void"), 245);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "getPreviewDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 249);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.util.Date"), 74);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "setPreviewDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "previewDuration", "", "void"), 253);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "getPosterTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 257);
        ajc$tjp_22 = jho.O000000o("method-execution", jho.O000000o("1", "setPosterTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "posterTime", "", "void"), 261);
        ajc$tjp_23 = jho.O000000o("method-execution", jho.O000000o("1", "getSelectionTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 265);
        ajc$tjp_24 = jho.O000000o("method-execution", jho.O000000o("1", "setSelectionTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "selectionTime", "", "void"), 269);
        ajc$tjp_25 = jho.O000000o("method-execution", jho.O000000o("1", "getSelectionDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 273);
        ajc$tjp_26 = jho.O000000o("method-execution", jho.O000000o("1", "setSelectionDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "selectionDuration", "", "void"), 277);
        ajc$tjp_27 = jho.O000000o("method-execution", jho.O000000o("1", "getCurrentTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 281);
        ajc$tjp_28 = jho.O000000o("method-execution", jho.O000000o("1", "setCurrentTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "currentTime", "", "void"), 285);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 78);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getTimescale", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 86);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setTimescale", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "timescale", "", "void"), 90);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 94);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "duration", "", "void"), 98);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getRate", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "double"), 105);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setRate", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "double", "rate", "", "void"), 109);
    }

    static {
        ajc$preClinit();
    }

    public MovieHeaderBox() {
        super("mvhd");
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
        if (jkw.O000000o(date) >= 4294967296L) {
            setVersion(1);
        }
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
        if (jkw.O000000o(date) >= 4294967296L) {
            setVersion(1);
        }
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
        if (j >= 4294967296L) {
            setVersion(1);
        }
    }

    public double getRate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.rate;
    }

    public float getVolume() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.volume;
    }

    public jkt getMatrix() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.matrix;
    }

    public void setMatrix(jkt jkt) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, jkt);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.matrix = jkt;
    }

    public long getNextTrackId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.nextTrackId;
    }

    public void setNextTrackId(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.nextTrackId = j;
    }

    public long getContentSize() {
        return (getVersion() == 1 ? 32 : 20) + 80;
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
            LOG.O00000Oo("mvhd duration is not in expected range");
        }
        this.rate = jky.O0000O0o(byteBuffer);
        this.volume = jky.O0000Oo0(byteBuffer);
        jky.O00000o0(byteBuffer);
        jky.O000000o(byteBuffer);
        jky.O000000o(byteBuffer);
        this.matrix = jkt.O000000o(byteBuffer);
        this.previewTime = byteBuffer.getInt();
        this.previewDuration = byteBuffer.getInt();
        this.posterTime = byteBuffer.getInt();
        this.selectionTime = byteBuffer.getInt();
        this.selectionDuration = byteBuffer.getInt();
        this.currentTime = byteBuffer.getInt();
        this.nextTrackId = jky.O000000o(byteBuffer);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "MovieHeaderBox[" + "creationTime=" + getCreationTime() + ";" + "modificationTime=" + getModificationTime() + ";" + "timescale=" + getTimescale() + ";" + "duration=" + getDuration() + ";" + "rate=" + getRate() + ";" + "volume=" + getVolume() + ";" + "matrix=" + this.matrix + ";" + "nextTrackId=" + getNextTrackId() + "]";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void
     arg types: [java.nio.ByteBuffer, int]
     candidates:
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, double):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, int):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, java.lang.String):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void */
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
        jla.O000000o(byteBuffer, this.rate);
        jla.O00000o0(byteBuffer, (double) this.volume);
        jla.O00000Oo(byteBuffer, 0);
        jla.O00000Oo(byteBuffer, 0L);
        jla.O00000Oo(byteBuffer, 0L);
        this.matrix.O00000Oo(byteBuffer);
        byteBuffer.putInt(this.previewTime);
        byteBuffer.putInt(this.previewDuration);
        byteBuffer.putInt(this.posterTime);
        byteBuffer.putInt(this.selectionTime);
        byteBuffer.putInt(this.selectionDuration);
        byteBuffer.putInt(this.currentTime);
        jla.O00000Oo(byteBuffer, this.nextTrackId);
    }

    public int getPreviewTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.previewTime;
    }

    public int getPreviewDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.previewDuration;
    }

    public int getPosterTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.posterTime;
    }

    public int getSelectionTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_23, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.selectionTime;
    }

    public int getSelectionDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_25, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.selectionDuration;
    }

    public int getCurrentTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_27, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.currentTime;
    }

    public void setRate(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.rate = d;
    }

    public void setVolume(float f) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Float.valueOf(f));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.volume = f;
    }

    public void setPreviewTime(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.previewTime = i;
    }

    public void setPreviewDuration(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.previewDuration = i;
    }

    public void setPosterTime(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_22, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.posterTime = i;
    }

    public void setSelectionTime(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_24, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.selectionTime = i;
    }

    public void setSelectionDuration(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_26, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.selectionDuration = i;
    }

    public void setCurrentTime(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_28, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.currentTime = i;
    }
}

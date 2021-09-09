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

public class TrackHeaderBox extends jkp {
    private static jks LOG = jks.O000000o(TrackHeaderBox.class);
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
    private static final jhf.O000000o ajc$tjp_29 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private int alternateGroup;
    private Date creationTime = new Date(0);
    private long duration;
    private double height;
    private int layer;
    private jkt matrix = jkt.f1911O000000o;
    private Date modificationTime = new Date(0);
    private long trackId;
    private float volume;
    private double width;

    private static void ajc$preClinit() {
        jho jho = new jho("TrackHeaderBox.java", TrackHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.util.Date"), 60);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 64);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getAlternateGroup", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "int"), 110);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setAlternateGroup", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "int", "alternateGroup", "", "void"), 114);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getVolume", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "float"), 118);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setVolume", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "float", "volume", "", "void"), 122);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getMatrix", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "org.mp4parser.support.Matrix"), 126);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setMatrix", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "org.mp4parser.support.Matrix", "matrix", "", "void"), 130);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "getWidth", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "double"), 134);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "setWidth", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "double", "width", "", "void"), 138);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "getHeight", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "double"), 142);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "setHeight", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "double", "height", "", "void"), 146);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.util.Date"), 71);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "getContent", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 193);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.lang.String"), 221);
        ajc$tjp_22 = jho.O000000o("method-execution", jho.O000000o("1", "isEnabled", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 247);
        ajc$tjp_23 = jho.O000000o("method-execution", jho.O000000o("1", "setEnabled", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "enabled", "", "void"), 251);
        ajc$tjp_24 = jho.O000000o("method-execution", jho.O000000o("1", "isInMovie", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 259);
        ajc$tjp_25 = jho.O000000o("method-execution", jho.O000000o("1", "setInMovie", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inMovie", "", "void"), 263);
        ajc$tjp_26 = jho.O000000o("method-execution", jho.O000000o("1", "isInPreview", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 271);
        ajc$tjp_27 = jho.O000000o("method-execution", jho.O000000o("1", "setInPreview", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inPreview", "", "void"), 275);
        ajc$tjp_28 = jho.O000000o("method-execution", jho.O000000o("1", "isInPoster", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 283);
        ajc$tjp_29 = jho.O000000o("method-execution", jho.O000000o("1", "setInPoster", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inPoster", "", "void"), 287);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 75);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "long"), 83);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "long", "trackId", "", "void"), 87);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "long"), 91);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "long", "duration", "", "void"), 95);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getLayer", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "int"), 102);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setLayer", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "int", "layer", "", "void"), 106);
    }

    static {
        ajc$preClinit();
    }

    public TrackHeaderBox() {
        super("tkhd");
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

    public long getTrackId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.trackId;
    }

    public void setTrackId(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.trackId = j;
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
            setFlags(1);
        }
    }

    public int getLayer() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.layer;
    }

    public int getAlternateGroup() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.alternateGroup;
    }

    public float getVolume() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.volume;
    }

    public jkt getMatrix() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.matrix;
    }

    public void setMatrix(jkt jkt) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, jkt);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.matrix = jkt;
    }

    public double getWidth() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.width;
    }

    public double getHeight() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.height;
    }

    public long getContentSize() {
        return (getVersion() == 1 ? 36 : 24) + 60;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.creationTime = jkw.O000000o(jky.O00000oo(byteBuffer));
            this.modificationTime = jkw.O000000o(jky.O00000oo(byteBuffer));
            this.trackId = jky.O000000o(byteBuffer);
            jky.O000000o(byteBuffer);
            this.duration = byteBuffer.getLong();
        } else {
            this.creationTime = jkw.O000000o(jky.O000000o(byteBuffer));
            this.modificationTime = jkw.O000000o(jky.O000000o(byteBuffer));
            this.trackId = jky.O000000o(byteBuffer);
            jky.O000000o(byteBuffer);
            this.duration = (long) byteBuffer.getInt();
        }
        if (this.duration < -1) {
            LOG.O00000Oo("tkhd duration is not in expected range");
        }
        jky.O000000o(byteBuffer);
        jky.O000000o(byteBuffer);
        this.layer = jky.O00000o0(byteBuffer);
        this.alternateGroup = jky.O00000o0(byteBuffer);
        this.volume = jky.O0000Oo0(byteBuffer);
        jky.O00000o0(byteBuffer);
        this.matrix = jkt.O000000o(byteBuffer);
        this.width = jky.O0000O0o(byteBuffer);
        this.height = jky.O0000O0o(byteBuffer);
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
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this, byteBuffer);
        jku.O000000o();
        jku.O000000o(O000000o2);
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            jla.O000000o(byteBuffer, jkw.O000000o(this.creationTime));
            jla.O000000o(byteBuffer, jkw.O000000o(this.modificationTime));
            jla.O00000Oo(byteBuffer, this.trackId);
            jla.O00000Oo(byteBuffer, 0L);
            byteBuffer.putLong(this.duration);
        } else {
            jla.O00000Oo(byteBuffer, jkw.O000000o(this.creationTime));
            jla.O00000Oo(byteBuffer, jkw.O000000o(this.modificationTime));
            jla.O00000Oo(byteBuffer, this.trackId);
            jla.O00000Oo(byteBuffer, 0L);
            byteBuffer.putInt((int) this.duration);
        }
        jla.O00000Oo(byteBuffer, 0L);
        jla.O00000Oo(byteBuffer, 0L);
        jla.O00000Oo(byteBuffer, this.layer);
        jla.O00000Oo(byteBuffer, this.alternateGroup);
        jla.O00000o0(byteBuffer, (double) this.volume);
        jla.O00000Oo(byteBuffer, 0);
        this.matrix.O00000Oo(byteBuffer);
        jla.O000000o(byteBuffer, this.width);
        jla.O000000o(byteBuffer, this.height);
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TrackHeaderBox[" + "creationTime=" + getCreationTime() + ";" + "modificationTime=" + getModificationTime() + ";" + "trackId=" + getTrackId() + ";" + "duration=" + getDuration() + ";" + "layer=" + getLayer() + ";" + "alternateGroup=" + getAlternateGroup() + ";" + "volume=" + getVolume() + ";" + "matrix=" + this.matrix + ";" + "width=" + getWidth() + ";" + "height=" + getHeight() + "]";
    }

    public boolean isEnabled() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_22, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 1) > 0;
    }

    public boolean isInMovie() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_24, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 2) > 0;
    }

    public boolean isInPreview() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_26, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 4) > 0;
    }

    public boolean isInPoster() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_28, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 8) > 0;
    }

    public void setLayer(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.layer = i;
    }

    public void setAlternateGroup(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.alternateGroup = i;
    }

    public void setVolume(float f) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, Float.valueOf(f));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.volume = f;
    }

    public void setWidth(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.width = d;
    }

    public void setHeight(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.height = d;
    }

    public void setEnabled(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_23, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & -2);
        }
    }

    public void setInMovie(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_25, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & -3);
        }
    }

    public void setInPreview(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_27, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 4);
        } else {
            setFlags(getFlags() & -5);
        }
    }

    public void setInPoster(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_29, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (z) {
            setFlags(getFlags() | 8);
        } else {
            setFlags(getFlags() & -9);
        }
    }
}

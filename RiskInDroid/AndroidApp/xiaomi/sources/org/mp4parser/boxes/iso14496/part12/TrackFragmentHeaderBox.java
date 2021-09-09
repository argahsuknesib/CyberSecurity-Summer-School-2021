package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class TrackFragmentHeaderBox extends jkp {
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
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private long baseDataOffset = -1;
    private boolean defaultBaseIsMoof;
    private long defaultSampleDuration = -1;
    private SampleFlags defaultSampleFlags;
    private long defaultSampleSize = -1;
    private boolean durationIsEmpty;
    private long sampleDescriptionIndex;
    private long trackId;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "hasBaseDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 126);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "hasSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 130);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "setSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 171);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 180);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), 184);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 189);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), 193);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "org.mp4parser.boxes.iso14496.part12.SampleFlags"), 198);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "org.mp4parser.boxes.iso14496.part12.SampleFlags", "defaultSampleFlags", "", "void"), 202);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "isDurationIsEmpty", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 207);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "setDurationIsEmpty", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), 211);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "isDefaultBaseIsMoof", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 216);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "hasDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 134);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultBaseIsMoof", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), 220);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 226);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "hasDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 138);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "hasDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 142);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 146);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "trackId", "", "void"), 150);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "getBaseDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 154);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "setBaseDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), 158);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "getSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 167);
    }

    public TrackFragmentHeaderBox() {
        super("tfhd");
    }

    public long getContentSize() {
        int flags = getFlags();
        long j = (flags & 1) == 1 ? 16 : 8;
        if ((flags & 2) == 2) {
            j += 4;
        }
        if ((flags & 8) == 8) {
            j += 4;
        }
        if ((flags & 16) == 16) {
            j += 4;
        }
        return (flags & 32) == 32 ? j + 4 : j;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.trackId);
        if ((getFlags() & 1) == 1) {
            jla.O000000o(byteBuffer, getBaseDataOffset());
        }
        if ((getFlags() & 2) == 2) {
            jla.O00000Oo(byteBuffer, getSampleDescriptionIndex());
        }
        if ((getFlags() & 8) == 8) {
            jla.O00000Oo(byteBuffer, getDefaultSampleDuration());
        }
        if ((getFlags() & 16) == 16) {
            jla.O00000Oo(byteBuffer, getDefaultSampleSize());
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags.getContent(byteBuffer);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = jky.O000000o(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.baseDataOffset = jky.O00000oo(byteBuffer);
        }
        if ((getFlags() & 2) == 2) {
            this.sampleDescriptionIndex = jky.O000000o(byteBuffer);
        }
        if ((getFlags() & 8) == 8) {
            this.defaultSampleDuration = jky.O000000o(byteBuffer);
        }
        if ((getFlags() & 16) == 16) {
            this.defaultSampleSize = jky.O000000o(byteBuffer);
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags = new SampleFlags(byteBuffer);
        }
        if ((getFlags() & 65536) == 65536) {
            this.durationIsEmpty = true;
        }
        if ((getFlags() & 131072) == 131072) {
            this.defaultBaseIsMoof = true;
        }
    }

    public boolean hasBaseDataOffset() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 1) != 0;
    }

    public boolean hasSampleDescriptionIndex() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 2) != 0;
    }

    public boolean hasDefaultSampleDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 8) != 0;
    }

    public boolean hasDefaultSampleSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 16) != 0;
    }

    public boolean hasDefaultSampleFlags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (getFlags() & 32) != 0;
    }

    public long getTrackId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.trackId;
    }

    public void setTrackId(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.trackId = j;
    }

    public long getBaseDataOffset() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.baseDataOffset;
    }

    public void setBaseDataOffset(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (j == -1) {
            setFlags(getFlags() & 2147483646);
        } else {
            setFlags(getFlags() | 1);
        }
        this.baseDataOffset = j;
    }

    public long getSampleDescriptionIndex() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.sampleDescriptionIndex;
    }

    public void setSampleDescriptionIndex(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (j == -1) {
            setFlags(getFlags() & 2147483645);
        } else {
            setFlags(getFlags() | 2);
        }
        this.sampleDescriptionIndex = j;
    }

    public long getDefaultSampleDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleDuration;
    }

    public void setDefaultSampleDuration(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        setFlags(getFlags() | 8);
        this.defaultSampleDuration = j;
    }

    public long getDefaultSampleSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleSize;
    }

    public void setDefaultSampleSize(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        setFlags(getFlags() | 16);
        this.defaultSampleSize = j;
    }

    public SampleFlags getDefaultSampleFlags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleFlags;
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this, sampleFlags);
        jku.O000000o();
        jku.O000000o(O000000o2);
        setFlags(getFlags() | 32);
        this.defaultSampleFlags = sampleFlags;
    }

    public boolean isDurationIsEmpty() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.durationIsEmpty;
    }

    public boolean isDefaultBaseIsMoof() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultBaseIsMoof;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TrackFragmentHeaderBox" + "{trackId=" + this.trackId + ", baseDataOffset=" + this.baseDataOffset + ", sampleDescriptionIndex=" + this.sampleDescriptionIndex + ", defaultSampleDuration=" + this.defaultSampleDuration + ", defaultSampleSize=" + this.defaultSampleSize + ", defaultSampleFlags=" + this.defaultSampleFlags + ", durationIsEmpty=" + this.durationIsEmpty + ", defaultBaseIsMoof=" + this.defaultBaseIsMoof + '}';
    }

    public void setDurationIsEmpty(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        setFlags(getFlags() | 65536);
        this.durationIsEmpty = z;
    }

    public void setDefaultBaseIsMoof(boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        setFlags(getFlags() | 131072);
        this.defaultBaseIsMoof = z;
    }
}

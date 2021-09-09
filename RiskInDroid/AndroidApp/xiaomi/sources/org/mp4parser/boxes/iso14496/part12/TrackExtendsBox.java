package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class TrackExtendsBox extends jkp {
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
    private long defaultSampleDescriptionIndex;
    private long defaultSampleDuration;
    private SampleFlags defaultSampleFlags;
    private long defaultSampleSize;
    private long trackId;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrackExtendsBox.java", TrackExtendsBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 72);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "trackId", "", "void"), 76);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleFlagsStr", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "java.lang.String"), 113);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 80);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "defaultSampleDescriptionIndex", "", "void"), 84);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 88);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "defaultSampleDuration", "", "void"), 92);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 96);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "defaultSampleSize", "", "void"), 100);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "org.mp4parser.boxes.iso14496.part12.SampleFlags"), 104);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "org.mp4parser.boxes.iso14496.part12.SampleFlags", "defaultSampleFlags", "", "void"), 108);
    }

    public long getContentSize() {
        return 24;
    }

    public TrackExtendsBox() {
        super("trex");
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.trackId);
        jla.O00000Oo(byteBuffer, this.defaultSampleDescriptionIndex);
        jla.O00000Oo(byteBuffer, this.defaultSampleDuration);
        jla.O00000Oo(byteBuffer, this.defaultSampleSize);
        this.defaultSampleFlags.getContent(byteBuffer);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = jky.O000000o(byteBuffer);
        this.defaultSampleDescriptionIndex = jky.O000000o(byteBuffer);
        this.defaultSampleDuration = jky.O000000o(byteBuffer);
        this.defaultSampleSize = jky.O000000o(byteBuffer);
        this.defaultSampleFlags = new SampleFlags(byteBuffer);
    }

    public long getTrackId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.trackId;
    }

    public void setTrackId(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.trackId = j;
    }

    public long getDefaultSampleDescriptionIndex() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleDescriptionIndex;
    }

    public void setDefaultSampleDescriptionIndex(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultSampleDescriptionIndex = j;
    }

    public long getDefaultSampleDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleDuration;
    }

    public void setDefaultSampleDuration(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultSampleDuration = j;
    }

    public long getDefaultSampleSize() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleSize;
    }

    public void setDefaultSampleSize(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultSampleSize = j;
    }

    public SampleFlags getDefaultSampleFlags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleFlags;
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, sampleFlags);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultSampleFlags = sampleFlags;
    }

    public String getDefaultSampleFlagsStr() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultSampleFlags.toString();
    }
}

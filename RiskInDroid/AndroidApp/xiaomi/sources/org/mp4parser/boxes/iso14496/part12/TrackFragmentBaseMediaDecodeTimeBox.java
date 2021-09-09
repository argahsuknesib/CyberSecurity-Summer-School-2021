package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class TrackFragmentBaseMediaDecodeTimeBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private long baseMediaDecodeTime;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrackFragmentBaseMediaDecodeTimeBox.java", TrackFragmentBaseMediaDecodeTimeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getBaseMediaDecodeTime", "org.mp4parser.boxes.iso14496.part12.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "long"), 65);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setBaseMediaDecodeTime", "org.mp4parser.boxes.iso14496.part12.TrackFragmentBaseMediaDecodeTimeBox", "long", "baseMediaDecodeTime", "", "void"), 69);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "java.lang.String"), 74);
    }

    public TrackFragmentBaseMediaDecodeTimeBox() {
        super("tfdt");
    }

    public long getContentSize() {
        return (long) (getVersion() == 0 ? 8 : 12);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            jla.O000000o(byteBuffer, this.baseMediaDecodeTime);
        } else {
            jla.O00000Oo(byteBuffer, this.baseMediaDecodeTime);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.baseMediaDecodeTime = jky.O00000oo(byteBuffer);
        } else {
            this.baseMediaDecodeTime = jky.O000000o(byteBuffer);
        }
    }

    public long getBaseMediaDecodeTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.baseMediaDecodeTime;
    }

    public void setBaseMediaDecodeTime(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.baseMediaDecodeTime = j;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TrackFragmentBaseMediaDecodeTimeBox{baseMediaDecodeTime=" + this.baseMediaDecodeTime + '}';
    }
}

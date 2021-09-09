package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jlc;
import java.nio.ByteBuffer;

public class TrackReferenceTypeBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    long[] trackIds = new long[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrackReferenceTypeBox.java", TrackReferenceTypeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getTrackIds", "org.mp4parser.boxes.iso14496.part12.TrackReferenceTypeBox", "", "", "", "[J"), 58);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setTrackIds", "org.mp4parser.boxes.iso14496.part12.TrackReferenceTypeBox", "[J", "trackIds", "", "void"), 62);
    }

    public TrackReferenceTypeBox(String str) {
        super(str);
    }

    public long getContentSize() {
        return (long) (this.trackIds.length * 4);
    }

    public void getContent(ByteBuffer byteBuffer) {
        for (long O00000Oo : this.trackIds) {
            jla.O00000Oo(byteBuffer, O00000Oo);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() >= 4) {
            this.trackIds = jlc.O000000o(this.trackIds, jky.O000000o(byteBuffer));
        }
    }

    public long[] getTrackIds() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.trackIds;
    }

    public void setTrackIds(long[] jArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, jArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.trackIds = jArr;
    }
}

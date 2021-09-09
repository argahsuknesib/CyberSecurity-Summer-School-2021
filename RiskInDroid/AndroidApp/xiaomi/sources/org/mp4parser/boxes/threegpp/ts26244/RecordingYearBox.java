package org.mp4parser.boxes.threegpp.ts26244;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class RecordingYearBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    int recordingYear;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("RecordingYearBox.java", RecordingYearBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getRecordingYear", "org.mp4parser.boxes.threegpp.ts26244.RecordingYearBox", "", "", "", "int"), 42);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setRecordingYear", "org.mp4parser.boxes.threegpp.ts26244.RecordingYearBox", "int", "recordingYear", "", "void"), 46);
    }

    public long getContentSize() {
        return 6;
    }

    public RecordingYearBox() {
        super("yrrc");
    }

    public int getRecordingYear() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.recordingYear;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.recordingYear = jky.O00000o0(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.recordingYear);
    }

    public void setRecordingYear(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.recordingYear = i;
    }
}

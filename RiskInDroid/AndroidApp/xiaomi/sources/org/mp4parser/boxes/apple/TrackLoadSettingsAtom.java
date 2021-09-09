package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import java.nio.ByteBuffer;

public class TrackLoadSettingsAtom extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    int defaultHints;
    int preloadDuration;
    int preloadFlags;
    int preloadStartTime;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TrackLoadSettingsAtom.java", TrackLoadSettingsAtom.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getPreloadStartTime", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 49);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setPreloadStartTime", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadStartTime", "", "void"), 53);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getPreloadDuration", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 57);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setPreloadDuration", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadDuration", "", "void"), 61);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getPreloadFlags", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 65);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setPreloadFlags", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadFlags", "", "void"), 69);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getDefaultHints", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 73);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setDefaultHints", "org.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "defaultHints", "", "void"), 77);
    }

    public long getContentSize() {
        return 16;
    }

    public TrackLoadSettingsAtom() {
        super("load");
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.preloadStartTime);
        byteBuffer.putInt(this.preloadDuration);
        byteBuffer.putInt(this.preloadFlags);
        byteBuffer.putInt(this.defaultHints);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.preloadStartTime = byteBuffer.getInt();
        this.preloadDuration = byteBuffer.getInt();
        this.preloadFlags = byteBuffer.getInt();
        this.defaultHints = byteBuffer.getInt();
    }

    public int getPreloadStartTime() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.preloadStartTime;
    }

    public int getPreloadDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.preloadDuration;
    }

    public int getPreloadFlags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.preloadFlags;
    }

    public int getDefaultHints() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.defaultHints;
    }

    public void setPreloadStartTime(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.preloadStartTime = i;
    }

    public void setPreloadDuration(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.preloadDuration = i;
    }

    public void setPreloadFlags(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.preloadFlags = i;
    }

    public void setDefaultHints(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.defaultHints = i;
    }
}

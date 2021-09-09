package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgy;
import _m_j.jko;

public class TrackFragmentBox extends jko {
    public TrackFragmentBox() {
        super("traf");
    }

    public TrackFragmentHeaderBox getTrackFragmentHeaderBox() {
        for (jgy next : getBoxes()) {
            if (next instanceof TrackFragmentHeaderBox) {
                return (TrackFragmentHeaderBox) next;
            }
        }
        return null;
    }
}

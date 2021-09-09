package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgy;
import _m_j.jko;
import _m_j.jlf;
import java.util.List;

public class TrackBox extends jko {
    private SampleTableBox sampleTableBox;

    public TrackBox() {
        super("trak");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.TrackBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public TrackHeaderBox getTrackHeaderBox() {
        return (TrackHeaderBox) jlf.O000000o((jko) this, "tkhd[0]");
    }

    public SampleTableBox getSampleTableBox() {
        MediaInformationBox mediaInformationBox;
        SampleTableBox sampleTableBox2 = this.sampleTableBox;
        if (sampleTableBox2 != null) {
            return sampleTableBox2;
        }
        MediaBox mediaBox = getMediaBox();
        if (mediaBox == null || (mediaInformationBox = mediaBox.getMediaInformationBox()) == null) {
            return null;
        }
        this.sampleTableBox = mediaInformationBox.getSampleTableBox();
        return this.sampleTableBox;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.TrackBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public MediaBox getMediaBox() {
        return (MediaBox) jlf.O000000o((jko) this, "mdia[0]");
    }

    public void setBoxes(List<? extends jgy> list) {
        super.setBoxes(list);
        this.sampleTableBox = null;
    }
}

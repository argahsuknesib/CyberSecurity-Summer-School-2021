package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgy;
import _m_j.jko;
import _m_j.jlf;

public class MediaInformationBox extends jko {
    public MediaInformationBox() {
        super("minf");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.MediaInformationBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public SampleTableBox getSampleTableBox() {
        return (SampleTableBox) jlf.O000000o((jko) this, "stbl[0]");
    }

    public AbstractMediaHeaderBox getMediaHeaderBox() {
        for (jgy next : getBoxes()) {
            if (next instanceof AbstractMediaHeaderBox) {
                return (AbstractMediaHeaderBox) next;
            }
        }
        return null;
    }
}

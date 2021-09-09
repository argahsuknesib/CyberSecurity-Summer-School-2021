package org.mp4parser.boxes.iso14496.part12;

import _m_j.jko;
import _m_j.jlf;

public class MediaBox extends jko {
    public MediaBox() {
        super("mdia");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.MediaBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public MediaInformationBox getMediaInformationBox() {
        return (MediaInformationBox) jlf.O000000o((jko) this, "minf[0]");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.MediaBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public MediaHeaderBox getMediaHeaderBox() {
        return (MediaHeaderBox) jlf.O000000o((jko) this, "mdhd[0]");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.MediaBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public HandlerBox getHandlerBox() {
        return (HandlerBox) jlf.O000000o((jko) this, "hdlr[0]");
    }
}

package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgy;
import _m_j.jko;
import _m_j.jlf;

public class SampleTableBox extends jko {
    private SampleToChunkBox sampleToChunkBox;

    public SampleTableBox() {
        super("stbl");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public SampleDescriptionBox getSampleDescriptionBox() {
        return (SampleDescriptionBox) jlf.O000000o((jko) this, "stsd");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public SampleSizeBox getSampleSizeBox() {
        return (SampleSizeBox) jlf.O000000o((jko) this, "stsz");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public SampleToChunkBox getSampleToChunkBox() {
        return (SampleToChunkBox) jlf.O000000o((jko) this, "stsc");
    }

    public ChunkOffsetBox getChunkOffsetBox() {
        for (jgy next : getBoxes()) {
            if (next instanceof ChunkOffsetBox) {
                return (ChunkOffsetBox) next;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public TimeToSampleBox getTimeToSampleBox() {
        return (TimeToSampleBox) jlf.O000000o((jko) this, "stts");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public SyncSampleBox getSyncSampleBox() {
        return (SyncSampleBox) jlf.O000000o((jko) this, "stss");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public CompositionTimeToSample getCompositionTimeToSample() {
        return (CompositionTimeToSample) jlf.O000000o((jko) this, "ctts");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public SampleDependencyTypeBox getSampleDependencyTypeBox() {
        return (SampleDependencyTypeBox) jlf.O000000o((jko) this, "sdtp");
    }
}

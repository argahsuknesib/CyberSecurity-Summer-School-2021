package org.mp4parser.boxes.iso14496.part12;

import _m_j.jko;
import _m_j.jlf;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;

public class MovieFragmentBox extends jko {
    public MovieFragmentBox() {
        super("moof");
    }

    public List<Long> getSyncSamples(SampleDependencyTypeBox sampleDependencyTypeBox) {
        ArrayList arrayList = new ArrayList();
        long j = 1;
        for (SampleDependencyTypeBox.Entry sampleDependsOn : sampleDependencyTypeBox.getEntries()) {
            if (sampleDependsOn.getSampleDependsOn() == 2) {
                arrayList.add(Long.valueOf(j));
            }
            j++;
        }
        return arrayList;
    }

    public int getTrackCount() {
        return getBoxes(TrackFragmentBox.class, false).size();
    }

    public long[] getTrackNumbers() {
        List boxes = getBoxes(TrackFragmentBox.class, false);
        long[] jArr = new long[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            jArr[i] = ((TrackFragmentBox) boxes.get(i)).getTrackFragmentHeaderBox().getTrackId();
        }
        return jArr;
    }

    public List<TrackFragmentHeaderBox> getTrackFragmentHeaderBoxes() {
        return jlf.O00000Oo(this, "tfhd");
    }

    public List<TrackRunBox> getTrackRunBoxes() {
        return getBoxes(TrackRunBox.class, true);
    }
}

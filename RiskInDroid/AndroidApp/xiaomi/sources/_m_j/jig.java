package _m_j;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;
import org.mp4parser.boxes.samplegrouping.GroupEntry;

public interface jig extends Closeable {
    List<CompositionTimeToSample.Entry> O000000o();

    long[] O00000Oo();

    SubSampleInformationBox O00000o();

    List<SampleDependencyTypeBox.Entry> O00000o0();

    long O00000oO();

    List<jhy> O00000oo();

    Map<GroupEntry, long[]> O0000O0o();

    long[] O0000Oo();

    List<jie> O0000Oo0();

    SampleDescriptionBox O0000OoO();

    jih O0000Ooo();

    String O0000o00();
}

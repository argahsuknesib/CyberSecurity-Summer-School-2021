package _m_j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;
import org.mp4parser.boxes.samplegrouping.GroupEntry;

public abstract class jhv implements jig {

    /* renamed from: O000000o  reason: collision with root package name */
    String f1843O000000o;
    List<jhy> O00000Oo = new ArrayList();
    Map<GroupEntry, long[]> O00000o0 = new HashMap();

    public List<CompositionTimeToSample.Entry> O000000o() {
        return null;
    }

    public long[] O00000Oo() {
        return null;
    }

    public SubSampleInformationBox O00000o() {
        return null;
    }

    public List<SampleDependencyTypeBox.Entry> O00000o0() {
        return null;
    }

    public jhv(String str) {
        this.f1843O000000o = str;
    }

    public final long O00000oO() {
        long j = 0;
        for (long j2 : O0000Oo()) {
            j += j2;
        }
        return j;
    }

    public final List<jhy> O00000oo() {
        return this.O00000Oo;
    }

    public final Map<GroupEntry, long[]> O0000O0o() {
        return this.O00000o0;
    }
}

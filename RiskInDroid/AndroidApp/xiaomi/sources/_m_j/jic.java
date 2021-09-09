package _m_j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.EditListBox;
import org.mp4parser.boxes.iso14496.part12.MediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MovieExtendsBox;
import org.mp4parser.boxes.iso14496.part12.MovieFragmentBox;
import org.mp4parser.boxes.iso14496.part12.MovieHeaderBox;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part12.SampleFlags;
import org.mp4parser.boxes.iso14496.part12.SampleTableBox;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;
import org.mp4parser.boxes.iso14496.part12.TimeToSampleBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;
import org.mp4parser.boxes.iso14496.part12.TrackExtendsBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox;
import org.mp4parser.boxes.iso14496.part12.TrackHeaderBox;
import org.mp4parser.boxes.iso14496.part12.TrackRunBox;
import org.mp4parser.boxes.samplegrouping.GroupEntry;
import org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox;
import org.mp4parser.boxes.samplegrouping.SampleToGroupBox;

public class jic extends jhv {
    static final /* synthetic */ boolean O00000oo = (!jic.class.desiredAssertionStatus());
    private List<jie> O00000o;
    String O00000oO;
    private SampleDescriptionBox O0000O0o;
    private long[] O0000OOo;
    private long[] O0000Oo = null;
    private List<CompositionTimeToSample.Entry> O0000Oo0;
    private List<SampleDependencyTypeBox.Entry> O0000OoO;
    private jih O0000Ooo;
    private SubSampleInformationBox O0000o00;

    public void close() throws IOException {
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v0, types: [_m_j.jic, _m_j.jhv] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.TrackFragmentBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.TrackBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public jic(long j, jha jha, jid jid, String str) {
        TrackBox trackBox;
        String str2;
        Iterator it;
        Iterator it2;
        TrackBox trackBox2;
        ArrayList arrayList;
        String str3;
        TrackBox trackBox3;
        Iterator it3;
        ArrayList arrayList2;
        String str4;
        Iterator it4;
        String str5;
        TrackBox trackBox4;
        TrackFragmentBox trackFragmentBox;
        ArrayList arrayList3;
        String str6;
        SampleFlags sampleFlags;
        int i;
        long j2;
        long j3 = j;
        jha jha2 = jha;
        ? jhv = new jhv(str);
        TrackBox trackBox5 = null;
        jhv.O0000Ooo = new jih();
        jhv.O0000o00 = null;
        jhv.O00000o = new jio(j3, jha2, jid);
        Iterator it5 = jlf.O00000Oo(jha2, "moov/trak").iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            TrackBox trackBox6 = (TrackBox) it5.next();
            if (trackBox6.getTrackHeaderBox().getTrackId() == j3) {
                trackBox5 = trackBox6;
                break;
            }
        }
        if (O00000oo || trackBox5 != null) {
            SampleTableBox sampleTableBox = trackBox5.getMediaBox().getMediaInformationBox().getSampleTableBox();
            jhv.O00000oO = trackBox5.getMediaBox().getHandlerBox().getHandlerType();
            ArrayList arrayList4 = new ArrayList();
            jhv.O0000Oo0 = new ArrayList();
            jhv.O0000OoO = new ArrayList();
            arrayList4.addAll(sampleTableBox.getTimeToSampleBox().getEntries());
            if (sampleTableBox.getCompositionTimeToSample() != null) {
                jhv.O0000Oo0.addAll(sampleTableBox.getCompositionTimeToSample().getEntries());
            }
            if (sampleTableBox.getSampleDependencyTypeBox() != null) {
                jhv.O0000OoO.addAll(sampleTableBox.getSampleDependencyTypeBox().getEntries());
            }
            if (sampleTableBox.getSyncSampleBox() != null) {
                jhv.O0000Oo = sampleTableBox.getSyncSampleBox().getSampleNumber();
            }
            String str7 = "subs";
            jhv.O0000o00 = (SubSampleInformationBox) jlf.O000000o((jko) sampleTableBox, str7);
            ArrayList<MovieFragmentBox> arrayList5 = new ArrayList<>();
            arrayList5.addAll(jha2.getBoxes(MovieFragmentBox.class));
            jhv.O0000O0o = sampleTableBox.getSampleDescriptionBox();
            List O00000Oo = jlf.O00000Oo(jha2, "moov/mvex");
            if (O00000Oo.size() > 0) {
                Iterator it6 = O00000Oo.iterator();
                while (true) {
                    str2 = "sbgp";
                    if (!it6.hasNext()) {
                        break;
                    }
                    Iterator it7 = ((MovieExtendsBox) it6.next()).getBoxes(TrackExtendsBox.class).iterator();
                    while (it7.hasNext()) {
                        TrackExtendsBox trackExtendsBox = (TrackExtendsBox) it7.next();
                        if (trackExtendsBox.getTrackId() == j3) {
                            if (jlf.O00000Oo(jha2, "moof/traf/subs").size() > 0) {
                                jhv.O0000o00 = new SubSampleInformationBox();
                            }
                            Iterator it8 = arrayList5.iterator();
                            it2 = it6;
                            it = it7;
                            long j4 = 1;
                            while (it8.hasNext()) {
                                Iterator it9 = ((MovieFragmentBox) it8.next()).getBoxes(TrackFragmentBox.class).iterator();
                                while (it9.hasNext()) {
                                    TrackFragmentBox trackFragmentBox2 = (TrackFragmentBox) it9.next();
                                    if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == j3) {
                                        it4 = it9;
                                        jhv.O00000o0 = O000000o(sampleTableBox.getBoxes(SampleGroupDescriptionBox.class), jlf.O00000Oo(trackFragmentBox2, "sgpd"), jlf.O00000Oo(trackFragmentBox2, str2), jhv.O00000o0, j4 - 1);
                                        SubSampleInformationBox subSampleInformationBox = (SubSampleInformationBox) jlf.O000000o((jko) trackFragmentBox2, str7);
                                        if (subSampleInformationBox != null) {
                                            long j5 = (j4 - 0) - 1;
                                            Iterator<SubSampleInformationBox.SubSampleEntry> it10 = subSampleInformationBox.getEntries().iterator();
                                            while (it10.hasNext()) {
                                                SubSampleInformationBox.SubSampleEntry next = it10.next();
                                                String str8 = str7;
                                                SubSampleInformationBox.SubSampleEntry subSampleEntry = new SubSampleInformationBox.SubSampleEntry();
                                                Iterator<SubSampleInformationBox.SubSampleEntry> it11 = it10;
                                                Iterator it12 = it8;
                                                subSampleEntry.getSubsampleEntries().addAll(next.getSubsampleEntries());
                                                if (j5 != 0) {
                                                    j2 = j4;
                                                    subSampleEntry.setSampleDelta(j5 + next.getSampleDelta());
                                                    j5 = 0;
                                                } else {
                                                    j2 = j4;
                                                    subSampleEntry.setSampleDelta(next.getSampleDelta());
                                                }
                                                jhv.O0000o00.getEntries().add(subSampleEntry);
                                                str7 = str8;
                                                it10 = it11;
                                                it8 = it12;
                                                j4 = j2;
                                            }
                                        }
                                        str4 = str7;
                                        it3 = it8;
                                        Iterator it13 = trackFragmentBox2.getBoxes(TrackRunBox.class).iterator();
                                        j4 = j4;
                                        while (it13.hasNext()) {
                                            TrackRunBox trackRunBox = (TrackRunBox) it13.next();
                                            TrackFragmentHeaderBox trackFragmentHeaderBox = trackFragmentBox2.getTrackFragmentHeaderBox();
                                            Iterator it14 = it13;
                                            int i2 = 1;
                                            boolean z = true;
                                            for (TrackRunBox.Entry next2 : trackRunBox.getEntries()) {
                                                if (trackRunBox.isSampleDurationPresent()) {
                                                    if (arrayList4.size() != 0) {
                                                        trackFragmentBox = trackFragmentBox2;
                                                        if (((TimeToSampleBox.Entry) arrayList4.get(arrayList4.size() - 1)).getDelta() != next2.getSampleDuration()) {
                                                            trackBox4 = trackBox5;
                                                            arrayList3 = arrayList5;
                                                        } else {
                                                            TimeToSampleBox.Entry entry = (TimeToSampleBox.Entry) arrayList4.get(arrayList4.size() - i2);
                                                            trackBox4 = trackBox5;
                                                            arrayList3 = arrayList5;
                                                            entry.setCount(entry.getCount() + 1);
                                                            str6 = str2;
                                                        }
                                                    } else {
                                                        trackBox4 = trackBox5;
                                                        arrayList3 = arrayList5;
                                                        trackFragmentBox = trackFragmentBox2;
                                                    }
                                                    str6 = str2;
                                                    arrayList4.add(new TimeToSampleBox.Entry(1, next2.getSampleDuration()));
                                                } else {
                                                    trackBox4 = trackBox5;
                                                    arrayList3 = arrayList5;
                                                    trackFragmentBox = trackFragmentBox2;
                                                    str6 = str2;
                                                    if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                                        arrayList4.add(new TimeToSampleBox.Entry(1, trackFragmentHeaderBox.getDefaultSampleDuration()));
                                                    } else {
                                                        arrayList4.add(new TimeToSampleBox.Entry(1, trackExtendsBox.getDefaultSampleDuration()));
                                                    }
                                                }
                                                if (trackRunBox.isSampleCompositionTimeOffsetPresent()) {
                                                    if (jhv.O0000Oo0.size() != 0) {
                                                        List<CompositionTimeToSample.Entry> list = jhv.O0000Oo0;
                                                        i = 1;
                                                        if (((long) list.get(list.size() - 1).getOffset()) == next2.getSampleCompositionTimeOffset()) {
                                                            List<CompositionTimeToSample.Entry> list2 = jhv.O0000Oo0;
                                                            CompositionTimeToSample.Entry entry2 = list2.get(list2.size() - 1);
                                                            entry2.setCount(entry2.getCount() + 1);
                                                        }
                                                    } else {
                                                        i = 1;
                                                    }
                                                    jhv.O0000Oo0.add(new CompositionTimeToSample.Entry(i, jkv.O000000o(next2.getSampleCompositionTimeOffset())));
                                                }
                                                if (trackRunBox.isSampleFlagsPresent()) {
                                                    sampleFlags = next2.getSampleFlags();
                                                } else if (z && trackRunBox.isFirstSampleFlagsPresent()) {
                                                    sampleFlags = trackRunBox.getFirstSampleFlags();
                                                } else if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                                    sampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                                } else {
                                                    sampleFlags = trackExtendsBox.getDefaultSampleFlags();
                                                }
                                                if (sampleFlags == null || sampleFlags.isSampleIsDifferenceSample()) {
                                                    i2 = 1;
                                                } else {
                                                    i2 = 1;
                                                    jhv.O0000Oo = jlc.O000000o(jhv.O0000Oo, j4);
                                                }
                                                j4++;
                                                str2 = str6;
                                                arrayList5 = arrayList3;
                                                trackFragmentBox2 = trackFragmentBox;
                                                trackBox5 = trackBox4;
                                                z = false;
                                            }
                                            it13 = it14;
                                        }
                                        trackBox3 = trackBox5;
                                        arrayList2 = arrayList5;
                                        str5 = str2;
                                    } else {
                                        trackBox3 = trackBox5;
                                        str4 = str7;
                                        arrayList2 = arrayList5;
                                        it4 = it9;
                                        str5 = str2;
                                        it3 = it8;
                                    }
                                    str2 = str5;
                                    it9 = it4;
                                    str7 = str4;
                                    arrayList5 = arrayList2;
                                    it8 = it3;
                                    trackBox5 = trackBox3;
                                }
                            }
                            trackBox2 = trackBox5;
                            str3 = str7;
                            arrayList = arrayList5;
                        } else {
                            trackBox2 = trackBox5;
                            str3 = str7;
                            arrayList = arrayList5;
                            it2 = it6;
                            it = it7;
                        }
                        jha2 = jha;
                        it6 = it2;
                        it7 = it;
                        str2 = str2;
                        str7 = str3;
                        arrayList5 = arrayList;
                        trackBox5 = trackBox2;
                    }
                    jha2 = jha;
                }
                trackBox = trackBox5;
                String str9 = str2;
                for (MovieFragmentBox boxes : arrayList5) {
                    for (TrackFragmentBox trackFragmentBox3 : boxes.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox3.getTrackFragmentHeaderBox().getTrackId() == j3) {
                            jhv.O00000o0 = O000000o(sampleTableBox.getBoxes(SampleGroupDescriptionBox.class), jlf.O00000Oo(trackFragmentBox3, "sgpd"), jlf.O00000Oo(trackFragmentBox3, str9), jhv.O00000o0, 0);
                        }
                    }
                }
            } else {
                trackBox = trackBox5;
                jhv.O00000o0 = O000000o(sampleTableBox.getBoxes(SampleGroupDescriptionBox.class), null, sampleTableBox.getBoxes(SampleToGroupBox.class), jhv.O00000o0, 0);
            }
            jhv.O0000OOo = TimeToSampleBox.blowupTimeToSamples(arrayList4);
            MediaHeaderBox mediaHeaderBox = trackBox.getMediaBox().getMediaHeaderBox();
            TrackHeaderBox trackHeaderBox = trackBox.getTrackHeaderBox();
            jhv.O0000Ooo.O0000Oo = trackHeaderBox.getTrackId();
            jhv.O0000Ooo.O00000oO = mediaHeaderBox.getCreationTime();
            jhv.O0000Ooo.O00000Oo = mediaHeaderBox.getLanguage();
            jhv.O0000Ooo.O00000o = mediaHeaderBox.getModificationTime();
            jhv.O0000Ooo.O00000o0 = mediaHeaderBox.getTimescale();
            jhv.O0000Ooo.O0000OOo = trackHeaderBox.getHeight();
            jhv.O0000Ooo.O0000O0o = trackHeaderBox.getWidth();
            jhv.O0000Ooo.f1850O000000o = trackHeaderBox.getLayer();
            jhv.O0000Ooo.O00000oo = trackHeaderBox.getMatrix();
            jhv.O0000Ooo.O0000Oo0 = trackHeaderBox.getVolume();
            EditListBox editListBox = (EditListBox) jlf.O000000o((jko) trackBox, "edts/elst");
            MovieHeaderBox movieHeaderBox = (MovieHeaderBox) jlf.O000000o(jha, "moov/mvhd");
            if (editListBox == null) {
                return;
            }
            if (O00000oo || movieHeaderBox != null) {
                jic jic = jhv;
                for (EditListBox.Entry next3 : editListBox.getEntries()) {
                    List list3 = jic.O00000Oo;
                    long mediaTime = next3.getMediaTime();
                    long timescale = mediaHeaderBox.getTimescale();
                    double mediaRate = next3.getMediaRate();
                    double segmentDuration = (double) next3.getSegmentDuration();
                    double timescale2 = (double) movieHeaderBox.getTimescale();
                    Double.isNaN(segmentDuration);
                    Double.isNaN(timescale2);
                    list3.add(new jhy(mediaTime, timescale, mediaRate, segmentDuration / timescale2));
                    jic = this;
                    mediaHeaderBox = mediaHeaderBox;
                }
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError("Could not find TrackBox with trackID ".concat(String.valueOf(j)));
    }

    private static Map<GroupEntry, long[]> O000000o(List<SampleGroupDescriptionBox> list, List<SampleGroupDescriptionBox> list2, List<SampleToGroupBox> list3, Map<GroupEntry, long[]> map, long j) {
        Map<GroupEntry, long[]> map2 = map;
        for (SampleToGroupBox next : list3) {
            Iterator<SampleToGroupBox.Entry> it = next.getEntries().iterator();
            int i = 0;
            while (true) {
                if (it.hasNext()) {
                    SampleToGroupBox.Entry next2 = it.next();
                    if (next2.getGroupDescriptionIndex() > 0) {
                        GroupEntry groupEntry = null;
                        if (next2.getGroupDescriptionIndex() > 65535) {
                            for (SampleGroupDescriptionBox next3 : list2) {
                                if (next3.getGroupingType().equals(next.getGroupingType())) {
                                    groupEntry = next3.getGroupEntries().get((next2.getGroupDescriptionIndex() - 1) & 65535);
                                }
                            }
                        } else {
                            for (SampleGroupDescriptionBox next4 : list) {
                                if (next4.getGroupingType().equals(next.getGroupingType())) {
                                    groupEntry = next4.getGroupEntries().get(next2.getGroupDescriptionIndex() - 1);
                                }
                            }
                        }
                        if (O00000oo || groupEntry != null) {
                            long[] jArr = map2.get(groupEntry);
                            if (jArr == null) {
                                jArr = new long[0];
                            }
                            long[] jArr2 = new long[(jkv.O000000o(next2.getSampleCount()) + jArr.length)];
                            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                            int i2 = 0;
                            while (true) {
                                long j2 = (long) i2;
                                if (j2 >= next2.getSampleCount()) {
                                    break;
                                }
                                jArr2[jArr.length + i2] = j + ((long) i) + j2;
                                i2++;
                            }
                            map2.put(groupEntry, jArr2);
                        } else {
                            throw new AssertionError();
                        }
                    }
                    i = (int) (((long) i) + next2.getSampleCount());
                }
            }
        }
        return map2;
    }

    public final List<jie> O0000Oo0() {
        return this.O00000o;
    }

    public final synchronized long[] O0000Oo() {
        return this.O0000OOo;
    }

    public final SampleDescriptionBox O0000OoO() {
        return this.O0000O0o;
    }

    public final List<CompositionTimeToSample.Entry> O000000o() {
        return this.O0000Oo0;
    }

    public final long[] O00000Oo() {
        long[] jArr = this.O0000Oo;
        if (jArr == null || jArr.length == this.O00000o.size()) {
            return null;
        }
        return this.O0000Oo;
    }

    public final List<SampleDependencyTypeBox.Entry> O00000o0() {
        return this.O0000OoO;
    }

    public final jih O0000Ooo() {
        return this.O0000Ooo;
    }

    public final String O0000o00() {
        return this.O00000oO;
    }

    public final SubSampleInformationBox O00000o() {
        return this.O0000o00;
    }
}

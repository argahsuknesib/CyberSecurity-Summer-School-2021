package _m_j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mp4parser.boxes.iso14496.part12.ChunkOffsetBox;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.DataEntryUrlBox;
import org.mp4parser.boxes.iso14496.part12.DataInformationBox;
import org.mp4parser.boxes.iso14496.part12.DataReferenceBox;
import org.mp4parser.boxes.iso14496.part12.EditBox;
import org.mp4parser.boxes.iso14496.part12.EditListBox;
import org.mp4parser.boxes.iso14496.part12.FileTypeBox;
import org.mp4parser.boxes.iso14496.part12.HandlerBox;
import org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MediaBox;
import org.mp4parser.boxes.iso14496.part12.MediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MediaInformationBox;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mp4parser.boxes.iso14496.part12.MovieHeaderBox;
import org.mp4parser.boxes.iso14496.part12.NullMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SampleSizeBox;
import org.mp4parser.boxes.iso14496.part12.SampleTableBox;
import org.mp4parser.boxes.iso14496.part12.SampleToChunkBox;
import org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox;
import org.mp4parser.boxes.iso14496.part12.SubtitleMediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.SyncSampleBox;
import org.mp4parser.boxes.iso14496.part12.TimeToSampleBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;
import org.mp4parser.boxes.iso14496.part12.TrackHeaderBox;
import org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox;
import org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat;
import org.mp4parser.boxes.iso23001.part7.SampleEncryptionBox;
import org.mp4parser.boxes.samplegrouping.GroupEntry;
import org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox;
import org.mp4parser.boxes.samplegrouping.SampleToGroupBox;

public class jii {

    /* renamed from: O000000o  reason: collision with root package name */
    public static jks f1851O000000o = jks.O000000o(jii.class);
    static final /* synthetic */ boolean O00000oo = (!jii.class.desiredAssertionStatus());
    Map<jig, StaticChunkOffsetBox> O00000Oo = new HashMap();
    HashMap<jig, List<jie>> O00000o = new HashMap<>();
    Set<SampleAuxiliaryInformationOffsetsBox> O00000o0 = new HashSet();
    HashMap<jig, long[]> O00000oO = new HashMap<>();
    private jij O0000O0o;

    private static long O000000o(long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
     arg types: [org.mp4parser.boxes.iso14496.part12.MovieBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T> */
    public final jha O000000o(jib jib) {
        if (this.O0000O0o == null) {
            this.O0000O0o = new jik();
        }
        f1851O000000o.O000000o("Creating movie ".concat(String.valueOf(jib)));
        Iterator<jig> it = jib.O00000Oo.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jig next = it.next();
            List<jie> O0000Oo0 = next.O0000Oo0();
            this.O00000o.put(next, O0000Oo0);
            long[] jArr = new long[O0000Oo0.size()];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = O0000Oo0.get(i).O000000o();
            }
            this.O00000oO.put(next, jArr);
        }
        jgx jgx = new jgx();
        LinkedList linkedList = new LinkedList();
        linkedList.add("mp42");
        linkedList.add("iso6");
        linkedList.add("avc1");
        linkedList.add("isom");
        jgx.addBox(new FileTypeBox("iso6", 1, linkedList));
        HashMap hashMap = new HashMap();
        for (jig next2 : jib.O00000Oo) {
            hashMap.put(next2, O000000o(next2));
        }
        MovieBox O000000o2 = O000000o(jib, hashMap);
        jgx.addBox(O000000o2);
        long j = 0;
        for (SampleSizeBox sampleSizes : jlf.O000000o((jgy) O000000o2, "trak/mdia/minf/stbl/stsz")) {
            j += O000000o(sampleSizes.getSampleSizes());
        }
        f1851O000000o.O000000o("About to create mdat");
        O000000o o000000o = new O000000o(this, jib, hashMap, j, (byte) 0);
        long j2 = 16;
        for (jgy size : jgx.getBoxes()) {
            j2 += size.getSize();
        }
        jgx.addBox(o000000o);
        f1851O000000o.O000000o("mdat crated");
        for (StaticChunkOffsetBox chunkOffsets : this.O00000Oo.values()) {
            long[] chunkOffsets2 = chunkOffsets.getChunkOffsets();
            for (int i2 = 0; i2 < chunkOffsets2.length; i2++) {
                chunkOffsets2[i2] = chunkOffsets2[i2] + j2;
            }
        }
        for (SampleAuxiliaryInformationOffsetsBox next3 : this.O00000o0) {
            long O000000o3 = jle.O000000o(jgx, next3, next3.getSize() + 44);
            long[] offsets = next3.getOffsets();
            for (int i3 = 0; i3 < offsets.length; i3++) {
                offsets[i3] = offsets[i3] + O000000o3;
            }
            next3.setOffsets(offsets);
        }
        return jgx;
    }

    private MovieBox O000000o(jib jib, Map<jig, int[]> map) {
        long j;
        jib jib2 = jib;
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(jib2.f1848O000000o);
        long O00000Oo2 = O00000Oo(jib);
        long j2 = 0;
        long j3 = 0;
        for (jig next : jib2.O00000Oo) {
            if (next.O00000oo() == null || next.O00000oo().isEmpty()) {
                j = (next.O00000oO() * O00000Oo2) / next.O0000Ooo().O00000o0;
            } else {
                double d = 0.0d;
                for (jhy jhy : next.O00000oo()) {
                    double d2 = (double) ((long) jhy.O00000Oo);
                    Double.isNaN(d2);
                    d += d2;
                }
                double d3 = (double) O00000Oo2;
                Double.isNaN(d3);
                j = (long) (d * d3);
            }
            if (j > j3) {
                j3 = j;
            }
        }
        movieHeaderBox.setDuration(j3);
        movieHeaderBox.setTimescale(O00000Oo2);
        for (jig next2 : jib2.O00000Oo) {
            if (j2 < next2.O0000Ooo().O0000Oo) {
                j2 = next2.O0000Ooo().O0000Oo;
            }
        }
        movieHeaderBox.setNextTrackId(j2 + 1);
        movieBox.addBox(movieHeaderBox);
        for (jig O000000o2 : jib2.O00000Oo) {
            movieBox.addBox(O000000o(O000000o2, jib2, map));
        }
        return movieBox;
    }

    private TrackBox O000000o(jig jig, jib jib, Map<jig, int[]> map) {
        TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setEnabled(true);
        trackHeaderBox.setInMovie(true);
        trackHeaderBox.setMatrix(jig.O0000Ooo().O00000oo);
        trackHeaderBox.setAlternateGroup(jig.O0000Ooo().O0000OoO);
        trackHeaderBox.setCreationTime(jig.O0000Ooo().O00000oO);
        if (jig.O00000oo() == null || jig.O00000oo().isEmpty()) {
            trackHeaderBox.setDuration((jig.O00000oO() * O00000Oo(jib)) / jig.O0000Ooo().O00000o0);
        } else {
            long j = 0;
            for (jhy jhy : jig.O00000oo()) {
                j += (long) jhy.O00000Oo;
            }
            trackHeaderBox.setDuration(j * jig.O0000Ooo().O00000o0);
        }
        trackHeaderBox.setHeight(jig.O0000Ooo().O0000OOo);
        trackHeaderBox.setWidth(jig.O0000Ooo().O0000O0o);
        trackHeaderBox.setLayer(jig.O0000Ooo().f1850O000000o);
        trackHeaderBox.setModificationTime(new Date());
        trackHeaderBox.setTrackId(jig.O0000Ooo().O0000Oo);
        trackHeaderBox.setVolume(jig.O0000Ooo().O0000Oo0);
        trackBox.addBox(trackHeaderBox);
        trackBox.addBox(O000000o(jig, jib));
        MediaBox mediaBox = new MediaBox();
        trackBox.addBox(mediaBox);
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(jig.O0000Ooo().O00000oO);
        mediaHeaderBox.setDuration(jig.O00000oO());
        mediaHeaderBox.setTimescale(jig.O0000Ooo().O00000o0);
        mediaHeaderBox.setLanguage(jig.O0000Ooo().O00000Oo);
        mediaBox.addBox(mediaHeaderBox);
        HandlerBox handlerBox = new HandlerBox();
        mediaBox.addBox(handlerBox);
        handlerBox.setHandlerType(jig.O0000o00());
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        if (jig.O0000o00().equals("vide")) {
            mediaInformationBox.addBox(new VideoMediaHeaderBox());
        } else if (jig.O0000o00().equals("soun")) {
            mediaInformationBox.addBox(new SoundMediaHeaderBox());
        } else if (jig.O0000o00().equals("text")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        } else if (jig.O0000o00().equals("subt")) {
            mediaInformationBox.addBox(new SubtitleMediaHeaderBox());
        } else if (jig.O0000o00().equals("hint")) {
            mediaInformationBox.addBox(new HintMediaHeaderBox());
        } else if (jig.O0000o00().equals("sbtl")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        }
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        mediaInformationBox.addBox(O000000o(jig, map));
        mediaBox.addBox(mediaInformationBox);
        jks jks = f1851O000000o;
        jks.O000000o("done with trak for track_" + jig.O0000Ooo().O0000Oo);
        return trackBox;
    }

    private static jhd O000000o(jig jig, jib jib) {
        if (jig.O00000oo() == null || jig.O00000oo().size() <= 0) {
            return null;
        }
        EditListBox editListBox = new EditListBox();
        editListBox.setVersion(0);
        ArrayList arrayList = new ArrayList();
        for (jhy next : jig.O00000oo()) {
            double d = next.O00000Oo;
            double O000000o2 = (double) jib.O000000o();
            Double.isNaN(O000000o2);
            arrayList.add(new EditListBox.Entry(editListBox, Math.round(d * O000000o2), (next.O00000o0 * jig.O0000Ooo().O00000o0) / next.f1845O000000o, next.O00000o));
        }
        editListBox.setEntries(arrayList);
        EditBox editBox = new EditBox();
        editBox.addBox(editListBox);
        return editBox;
    }

    private jhd O000000o(jig jig, Map<jig, int[]> map) {
        jig jig2 = jig;
        Map<jig, int[]> map2 = map;
        SampleTableBox sampleTableBox = new SampleTableBox();
        sampleTableBox.addBox(jig.O0000OoO());
        ArrayList arrayList = new ArrayList();
        TimeToSampleBox.Entry entry = null;
        for (long j : jig.O0000Oo()) {
            if (entry == null || entry.getDelta() != j) {
                entry = new TimeToSampleBox.Entry(1, j);
                arrayList.add(entry);
            } else {
                entry.setCount(entry.getCount() + 1);
            }
        }
        TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
        timeToSampleBox.setEntries(arrayList);
        sampleTableBox.addBox(timeToSampleBox);
        List<CompositionTimeToSample.Entry> O000000o2 = jig.O000000o();
        if (O000000o2 != null && !O000000o2.isEmpty()) {
            CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
            compositionTimeToSample.setEntries(O000000o2);
            sampleTableBox.addBox(compositionTimeToSample);
        }
        long[] O00000Oo2 = jig.O00000Oo();
        if (O00000Oo2 != null && O00000Oo2.length > 0) {
            SyncSampleBox syncSampleBox = new SyncSampleBox();
            syncSampleBox.setSampleNumber(O00000Oo2);
            sampleTableBox.addBox(syncSampleBox);
        }
        if (jig.O00000o0() != null && !jig.O00000o0().isEmpty()) {
            SampleDependencyTypeBox sampleDependencyTypeBox = new SampleDependencyTypeBox();
            sampleDependencyTypeBox.setEntries(jig.O00000o0());
            sampleTableBox.addBox(sampleDependencyTypeBox);
        }
        O00000Oo(jig2, map2, sampleTableBox);
        SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes(this.O00000oO.get(jig2));
        sampleTableBox.addBox(sampleSizeBox);
        O000000o(jig2, map2, sampleTableBox);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : jig.O0000O0o().entrySet()) {
            String type = ((GroupEntry) next.getKey()).getType();
            Object obj = (List) hashMap.get(type);
            if (obj == null) {
                obj = new ArrayList();
                hashMap.put(type, obj);
            }
            obj.add(next.getKey());
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            SampleGroupDescriptionBox sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            String str = (String) entry2.getKey();
            sampleGroupDescriptionBox.setGroupingType(str);
            sampleGroupDescriptionBox.setGroupEntries((List) entry2.getValue());
            SampleToGroupBox sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType(str);
            SampleToGroupBox.Entry entry3 = null;
            for (int i = 0; i < jig.O0000Oo0().size(); i++) {
                int i2 = 0;
                for (int i3 = 0; i3 < ((List) entry2.getValue()).size(); i3++) {
                    if (Arrays.binarySearch(jig.O0000O0o().get((GroupEntry) ((List) entry2.getValue()).get(i3)), (long) i) >= 0) {
                        i2 = i3 + 1;
                    }
                }
                if (entry3 == null || entry3.getGroupDescriptionIndex() != i2) {
                    SampleToGroupBox.Entry entry4 = new SampleToGroupBox.Entry(1, i2);
                    sampleToGroupBox.getEntries().add(entry4);
                    entry3 = entry4;
                } else {
                    entry3.setSampleCount(entry3.getSampleCount() + 1);
                }
            }
            sampleTableBox.addBox(sampleGroupDescriptionBox);
            sampleTableBox.addBox(sampleToGroupBox);
        }
        if (jig2 instanceof jir) {
            O000000o((jir) jig2, sampleTableBox, map2.get(jig2));
        }
        if (jig.O00000o() != null) {
            sampleTableBox.addBox(jig.O00000o());
        }
        f1851O000000o.O000000o("done with stbl for track_" + jig.O0000Ooo().O0000Oo);
        return sampleTableBox;
    }

    private void O000000o(jir jir, SampleTableBox sampleTableBox, int[] iArr) {
        SampleTableBox sampleTableBox2 = sampleTableBox;
        int[] iArr2 = iArr;
        SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = new SampleAuxiliaryInformationSizesBox();
        sampleAuxiliaryInformationSizesBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationSizesBox.setFlags(1);
        List<CencSampleAuxiliaryDataFormat> O0000OOo = jir.O0000OOo();
        sampleAuxiliaryInformationSizesBox.setDefaultSampleInfoSize(8);
        sampleAuxiliaryInformationSizesBox.setSampleCount(jir.O0000Oo0().size());
        SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = new SampleAuxiliaryInformationOffsetsBox();
        SampleEncryptionBox sampleEncryptionBox = new SampleEncryptionBox();
        sampleEncryptionBox.setSubSampleEncryption(false);
        sampleEncryptionBox.setEntries(O0000OOo);
        long[] jArr = new long[iArr2.length];
        long offsetToFirstIV = (long) sampleEncryptionBox.getOffsetToFirstIV();
        int i = 0;
        int i2 = 0;
        while (i < iArr2.length) {
            jArr[i] = offsetToFirstIV;
            int i3 = i2;
            int i4 = 0;
            while (i4 < iArr2[i]) {
                offsetToFirstIV += (long) O0000OOo.get(i3).getSize();
                i4++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        sampleAuxiliaryInformationOffsetsBox.setOffsets(jArr);
        sampleTableBox2.addBox(sampleAuxiliaryInformationSizesBox);
        sampleTableBox2.addBox(sampleAuxiliaryInformationOffsetsBox);
        sampleTableBox2.addBox(sampleEncryptionBox);
        this.O00000o0.add(sampleAuxiliaryInformationOffsetsBox);
    }

    private void O000000o(jig jig, Map<jig, int[]> map, SampleTableBox sampleTableBox) {
        char c;
        int i;
        jig jig2 = jig;
        Map<jig, int[]> map2 = map;
        if (this.O00000Oo.get(jig2) == null) {
            long j = 0;
            jks jks = f1851O000000o;
            jks.O000000o("Calculating chunk offsets for track_" + jig.O0000Ooo().O0000Oo);
            ArrayList<jig> arrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList, new Comparator<jig>() {
                /* class _m_j.jii.AnonymousClass1 */

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return jkv.O000000o(((jig) obj).O0000Ooo().O0000Oo - ((jig) obj2).O0000Ooo().O0000Oo);
                }
            });
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            Iterator it = arrayList.iterator();
            while (true) {
                c = 0;
                if (!it.hasNext()) {
                    break;
                }
                jig jig3 = (jig) it.next();
                hashMap.put(jig3, 0);
                hashMap2.put(jig3, 0);
                hashMap3.put(jig3, Double.valueOf(0.0d));
                this.O00000Oo.put(jig3, new StaticChunkOffsetBox());
            }
            while (true) {
                jig jig4 = null;
                for (jig jig5 : arrayList) {
                    if ((jig4 == null || ((Double) hashMap3.get(jig5)).doubleValue() < ((Double) hashMap3.get(jig4)).doubleValue()) && ((Integer) hashMap.get(jig5)).intValue() < map2.get(jig5).length) {
                        jig4 = jig5;
                    }
                }
                if (jig4 == null) {
                    break;
                }
                ChunkOffsetBox chunkOffsetBox = this.O00000Oo.get(jig4);
                long[] chunkOffsets = chunkOffsetBox.getChunkOffsets();
                long[] jArr = new long[1];
                jArr[c] = j;
                chunkOffsetBox.setChunkOffsets(jlc.O000000o(chunkOffsets, jArr));
                int intValue = ((Integer) hashMap.get(jig4)).intValue();
                int i2 = map2.get(jig4)[intValue];
                int intValue2 = ((Integer) hashMap2.get(jig4)).intValue();
                double doubleValue = ((Double) hashMap3.get(jig4)).doubleValue();
                long[] O0000Oo = jig4.O0000Oo();
                long j2 = j;
                int i3 = intValue2;
                while (true) {
                    i = intValue2 + i2;
                    if (i3 >= i) {
                        break;
                    }
                    j2 += this.O00000oO.get(jig4)[i3];
                    double d = (double) O0000Oo[i3];
                    double d2 = (double) jig4.O0000Ooo().O00000o0;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    doubleValue += d / d2;
                    i3++;
                    i2 = i2;
                    arrayList = arrayList;
                }
                hashMap.put(jig4, Integer.valueOf(intValue + 1));
                hashMap2.put(jig4, Integer.valueOf(i));
                hashMap3.put(jig4, Double.valueOf(doubleValue));
                j = j2;
                c = 0;
            }
        }
        sampleTableBox.addBox(this.O00000Oo.get(jig2));
    }

    private static void O00000Oo(jig jig, Map<jig, int[]> map, SampleTableBox sampleTableBox) {
        int[] iArr = map.get(jig);
        SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
        sampleToChunkBox.setEntries(new LinkedList());
        long j = -2147483648L;
        for (int i = 0; i < iArr.length; i++) {
            if (j != ((long) iArr[i])) {
                sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry((long) (i + 1), (long) iArr[i], 1));
                j = (long) iArr[i];
            }
        }
        sampleTableBox.addBox(sampleToChunkBox);
    }

    private int[] O000000o(jig jig) {
        long j;
        long[] O000000o2 = this.O0000O0o.O000000o(jig);
        int[] iArr = new int[O000000o2.length];
        int i = 0;
        while (i < O000000o2.length) {
            long j2 = O000000o2[i] - 1;
            int i2 = i + 1;
            if (O000000o2.length == i2) {
                j = (long) jig.O0000Oo0().size();
            } else {
                j = O000000o2[i2] - 1;
            }
            iArr[i] = jkv.O000000o(j - j2);
            i = i2;
        }
        if (!O00000oo) {
            long size = (long) this.O00000o.get(jig).size();
            long j3 = 0;
            for (int i3 : iArr) {
                j3 += (long) i3;
            }
            if (size != j3) {
                throw new AssertionError("The number of samples and the sum of all chunk lengths must be equal");
            }
        }
        return iArr;
    }

    class O000000o implements jgy {

        /* renamed from: O000000o  reason: collision with root package name */
        List<jig> f1853O000000o;
        List<List<jie>> O00000Oo;
        final /* synthetic */ jii O00000o;
        long O00000o0;

        private static boolean O000000o(long j) {
            return j + 8 < 4294967296L;
        }

        public final String getType() {
            return "mdat";
        }

        /* synthetic */ O000000o(jii jii, jib jib, Map map, long j, byte b) {
            this(jii, jib, map, j);
        }

        private O000000o(jii jii, jib jib, Map<jig, int[]> map, long j) {
            int i;
            final jii jii2 = jii;
            Map<jig, int[]> map2 = map;
            this.O00000o = jii2;
            this.O00000Oo = new ArrayList();
            this.O00000o0 = j;
            this.f1853O000000o = jib.O00000Oo;
            ArrayList<jig> arrayList = new ArrayList<>(map.keySet());
            Collections.sort(arrayList, new Comparator<jig>() {
                /* class _m_j.jii.O000000o.AnonymousClass1 */

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return jkv.O000000o(((jig) obj).O0000Ooo().O0000Oo - ((jig) obj2).O0000Ooo().O0000Oo);
                }
            });
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            for (jig jig : arrayList) {
                hashMap.put(jig, 0);
                hashMap2.put(jig, 0);
                hashMap3.put(jig, Double.valueOf(0.0d));
            }
            while (true) {
                jig jig2 = null;
                for (jig jig3 : arrayList) {
                    if ((jig2 == null || ((Double) hashMap3.get(jig3)).doubleValue() < ((Double) hashMap3.get(jig2)).doubleValue()) && ((Integer) hashMap.get(jig3)).intValue() < map2.get(jig3).length) {
                        jig2 = jig3;
                    }
                }
                if (jig2 != null) {
                    int intValue = ((Integer) hashMap.get(jig2)).intValue();
                    int i2 = map2.get(jig2)[intValue];
                    int intValue2 = ((Integer) hashMap2.get(jig2)).intValue();
                    double doubleValue = ((Double) hashMap3.get(jig2)).doubleValue();
                    int i3 = intValue2;
                    while (true) {
                        i = intValue2 + i2;
                        if (i3 >= i) {
                            break;
                        }
                        double d = (double) jig2.O0000Oo()[i3];
                        double d2 = (double) jig2.O0000Ooo().O00000o0;
                        Double.isNaN(d);
                        Double.isNaN(d2);
                        doubleValue += d / d2;
                        i3++;
                        arrayList = arrayList;
                    }
                    this.O00000Oo.add(jig2.O0000Oo0().subList(intValue2, i));
                    hashMap.put(jig2, Integer.valueOf(intValue + 1));
                    hashMap2.put(jig2, Integer.valueOf(i));
                    hashMap3.put(jig2, Double.valueOf(doubleValue));
                    arrayList = arrayList;
                    map2 = map;
                } else {
                    return;
                }
            }
        }

        public final long getSize() {
            return this.O00000o0 + 16;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void
         arg types: [java.nio.ByteBuffer, int]
         candidates:
          _m_j.jla.O00000Oo(java.nio.ByteBuffer, double):void
          _m_j.jla.O00000Oo(java.nio.ByteBuffer, int):void
          _m_j.jla.O00000Oo(java.nio.ByteBuffer, java.lang.String):void
          _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void */
        public final void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            long size = getSize();
            if (O000000o(size)) {
                jla.O00000Oo(allocate, size);
            } else {
                jla.O00000Oo(allocate, 1L);
            }
            allocate.put(jhc.O000000o("mdat"));
            if (O000000o(size)) {
                allocate.put(new byte[8]);
            } else {
                jla.O000000o(allocate, size);
            }
            allocate.rewind();
            writableByteChannel.write(allocate);
            jii.f1851O000000o.O000000o("About to write " + this.O00000o0);
            long j = 0;
            long j2 = 0;
            for (List<jie> it : this.O00000Oo) {
                for (jie jie : it) {
                    jie.O000000o(writableByteChannel);
                    j += jie.O000000o();
                    if (j > 1048576) {
                        j -= 1048576;
                        j2++;
                        jii.f1851O000000o.O000000o("Written " + j2 + "MB");
                    }
                }
            }
        }
    }

    private static long O00000Oo(jib jib) {
        long j = jib.O00000Oo.iterator().next().O0000Ooo().O00000o0;
        for (jig O0000Ooo : jib.O00000Oo) {
            j = jld.O00000Oo(j, O0000Ooo.O0000Ooo().O00000o0);
        }
        return j;
    }
}

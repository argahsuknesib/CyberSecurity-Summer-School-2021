package _m_j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.mp4parser.boxes.iso14496.part12.ChunkOffsetBox;
import org.mp4parser.boxes.iso14496.part12.MovieFragmentBox;
import org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import org.mp4parser.boxes.iso14496.part12.SchemeTypeBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentBox;
import org.mp4parser.boxes.iso14496.part12.TrackRunBox;
import org.mp4parser.boxes.iso23001.part7.CencSampleAuxiliaryDataFormat;
import org.mp4parser.boxes.iso23001.part7.TrackEncryptionBox;

public class jhw extends jic implements jir {
    static final /* synthetic */ boolean O00000o = (!jhw.class.desiredAssertionStatus());
    private List<CencSampleAuxiliaryDataFormat> O0000O0o;
    private UUID O0000OOo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.TrackBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public jhw(long j, jha jha, jid jid, String str) throws IOException {
        super(j, jha, jid, str);
        TrackBox trackBox;
        long j2;
        int i;
        long j3;
        int i2;
        jha jha2 = jha;
        jid jid2 = jid;
        Iterator it = jlf.O00000Oo(jha2, "moov/trak").iterator();
        while (true) {
            if (!it.hasNext()) {
                trackBox = null;
                break;
            }
            trackBox = (TrackBox) it.next();
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                break;
            }
        }
        SchemeTypeBox schemeTypeBox = (SchemeTypeBox) jlf.O000000o((jko) trackBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schm[0]");
        if (O00000o || (schemeTypeBox != null && (schemeTypeBox.getSchemeType().equals("cenc") || schemeTypeBox.getSchemeType().equals("cbc1")))) {
            this.O0000O0o = new ArrayList();
            String str2 = "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schi[0]/tenc[0]";
            if (!jlf.O00000Oo(jha2, "moov/mvex").isEmpty()) {
                Iterator it2 = jha2.getBoxes(MovieFragmentBox.class).iterator();
                while (it2.hasNext()) {
                    MovieFragmentBox movieFragmentBox = (MovieFragmentBox) it2.next();
                    for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == j) {
                            TrackEncryptionBox trackEncryptionBox = (TrackEncryptionBox) jlf.O000000o((jko) trackBox, str2);
                            if (O00000o || trackEncryptionBox != null) {
                                this.O0000OOo = trackEncryptionBox.getDefault_KID();
                                if (trackFragmentBox.getTrackFragmentHeaderBox().hasBaseDataOffset()) {
                                    j3 = trackFragmentBox.getTrackFragmentHeaderBox().getBaseDataOffset();
                                } else {
                                    Iterator<jgy> it3 = jha.getBoxes().iterator();
                                    long j4 = 0;
                                    for (jgy next = it3.next(); next != movieFragmentBox; next = it3.next()) {
                                        j4 += next.getSize();
                                    }
                                    j3 = j4;
                                }
                                O000000o O000000o2 = new O000000o(trackFragmentBox).O000000o();
                                SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = O000000o2.O00000Oo;
                                SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = O000000o2.f1844O000000o;
                                if (O00000o || sampleAuxiliaryInformationOffsetsBox != null) {
                                    long[] offsets = sampleAuxiliaryInformationOffsetsBox.getOffsets();
                                    if (!O00000o && offsets.length != trackFragmentBox.getBoxes(TrackRunBox.class).size()) {
                                        throw new AssertionError();
                                    } else if (O00000o || sampleAuxiliaryInformationSizesBox != null) {
                                        List boxes = trackFragmentBox.getBoxes(TrackRunBox.class);
                                        int i3 = 0;
                                        int i4 = 0;
                                        while (i3 < offsets.length) {
                                            int size = ((TrackRunBox) boxes.get(i3)).getEntries().size();
                                            long j5 = offsets[i3];
                                            Iterator it4 = it2;
                                            long[] jArr = offsets;
                                            List list = boxes;
                                            MovieFragmentBox movieFragmentBox2 = movieFragmentBox;
                                            int i5 = i4;
                                            long j6 = 0;
                                            while (true) {
                                                i2 = i4 + size;
                                                if (i5 >= i2) {
                                                    break;
                                                }
                                                j6 += (long) sampleAuxiliaryInformationSizesBox.getSize(i5);
                                                i5++;
                                                trackBox = trackBox;
                                                str2 = str2;
                                            }
                                            TrackBox trackBox2 = trackBox;
                                            String str3 = str2;
                                            ByteBuffer O000000o3 = jid2.O000000o(j3 + j5, j6);
                                            while (i4 < i2) {
                                                this.O0000O0o.add(O000000o(trackEncryptionBox.getDefaultIvSize(), O000000o3, (long) sampleAuxiliaryInformationSizesBox.getSize(i4)));
                                                i4++;
                                            }
                                            i3++;
                                            i4 = i2;
                                            it2 = it4;
                                            movieFragmentBox = movieFragmentBox2;
                                            boxes = list;
                                            offsets = jArr;
                                            trackBox = trackBox2;
                                            str2 = str3;
                                        }
                                    } else {
                                        throw new AssertionError();
                                    }
                                } else {
                                    throw new AssertionError();
                                }
                            } else {
                                throw new AssertionError();
                            }
                        }
                        it2 = it2;
                        movieFragmentBox = movieFragmentBox;
                        trackBox = trackBox;
                        str2 = str2;
                    }
                }
                return;
            }
            TrackEncryptionBox trackEncryptionBox2 = (TrackEncryptionBox) jlf.O000000o((jko) trackBox, str2);
            if (O00000o || trackEncryptionBox2 != null) {
                this.O0000OOo = trackEncryptionBox2.getDefault_KID();
                ChunkOffsetBox chunkOffsetBox = (ChunkOffsetBox) jlf.O000000o((jko) trackBox, "mdia[0]/minf[0]/stbl[0]/stco[0]");
                chunkOffsetBox = chunkOffsetBox == null ? (ChunkOffsetBox) jlf.O000000o((jko) trackBox, "mdia[0]/minf[0]/stbl[0]/co64[0]") : chunkOffsetBox;
                if (!O00000o && trackBox == null) {
                    throw new AssertionError();
                } else if (O00000o || chunkOffsetBox != null) {
                    long[] blowup = trackBox.getSampleTableBox().getSampleToChunkBox().blowup(chunkOffsetBox.getChunkOffsets().length);
                    O000000o O000000o4 = new O000000o((jha) jlf.O000000o((jko) trackBox, "mdia[0]/minf[0]/stbl[0]")).O000000o();
                    SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox2 = O000000o4.O00000Oo;
                    SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox2 = O000000o4.f1844O000000o;
                    if (sampleAuxiliaryInformationOffsetsBox2.getOffsets().length == 1) {
                        long j7 = sampleAuxiliaryInformationOffsetsBox2.getOffsets()[0];
                        if (sampleAuxiliaryInformationSizesBox2.getDefaultSampleInfoSize() > 0) {
                            i = (sampleAuxiliaryInformationSizesBox2.getSampleCount() * sampleAuxiliaryInformationSizesBox2.getDefaultSampleInfoSize()) + 0;
                        } else {
                            int i6 = 0;
                            for (int i7 = 0; i7 < sampleAuxiliaryInformationSizesBox2.getSampleCount(); i7++) {
                                i6 += sampleAuxiliaryInformationSizesBox2.getSampleInfoSizes()[i7];
                            }
                            i = i6;
                        }
                        ByteBuffer O000000o5 = jid2.O000000o(j7, (long) i);
                        for (int i8 = 0; i8 < sampleAuxiliaryInformationSizesBox2.getSampleCount(); i8++) {
                            this.O0000O0o.add(O000000o(trackEncryptionBox2.getDefaultIvSize(), O000000o5, (long) sampleAuxiliaryInformationSizesBox2.getSize(i8)));
                        }
                    } else if (sampleAuxiliaryInformationOffsetsBox2.getOffsets().length == blowup.length) {
                        int i9 = 0;
                        for (int i10 = 0; i10 < blowup.length; i10++) {
                            long j8 = sampleAuxiliaryInformationOffsetsBox2.getOffsets()[i10];
                            if (sampleAuxiliaryInformationSizesBox2.getDefaultSampleInfoSize() > 0) {
                                j2 = (((long) sampleAuxiliaryInformationSizesBox2.getSampleCount()) * blowup[i10]) + 0;
                            } else {
                                j2 = 0;
                                for (int i11 = 0; ((long) i11) < blowup[i10]; i11++) {
                                    j2 += (long) sampleAuxiliaryInformationSizesBox2.getSize(i9 + i11);
                                }
                            }
                            ByteBuffer O000000o6 = jid2.O000000o(j8, j2);
                            for (int i12 = 0; ((long) i12) < blowup[i10]; i12++) {
                                this.O0000O0o.add(O000000o(trackEncryptionBox2.getDefaultIvSize(), O000000o6, (long) sampleAuxiliaryInformationSizesBox2.getSize(i9 + i12)));
                            }
                            i9 = (int) (((long) i9) + blowup[i10]);
                        }
                    } else {
                        throw new RuntimeException("Number of saio offsets must be either 1 or number of chunks");
                    }
                } else {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError("Track must be CENC (cenc or cbc1) encrypted");
        }
    }

    private static CencSampleAuxiliaryDataFormat O000000o(int i, ByteBuffer byteBuffer, long j) {
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
        if (j > 0) {
            cencSampleAuxiliaryDataFormat.iv = new byte[i];
            byteBuffer.get(cencSampleAuxiliaryDataFormat.iv);
            if (j > ((long) i)) {
                cencSampleAuxiliaryDataFormat.pairs = new CencSampleAuxiliaryDataFormat.Pair[jky.O00000o0(byteBuffer)];
                for (int i2 = 0; i2 < cencSampleAuxiliaryDataFormat.pairs.length; i2++) {
                    cencSampleAuxiliaryDataFormat.pairs[i2] = cencSampleAuxiliaryDataFormat.createPair(jky.O00000o0(byteBuffer), jky.O000000o(byteBuffer));
                }
            }
        }
        return cencSampleAuxiliaryDataFormat;
    }

    public final List<CencSampleAuxiliaryDataFormat> O0000OOo() {
        return this.O0000O0o;
    }

    public String toString() {
        return "CencMp4TrackImpl{handler='" + this.O00000oO + '\'' + '}';
    }

    class O000000o {
        static final /* synthetic */ boolean O00000o0 = (!jhw.class.desiredAssertionStatus());

        /* renamed from: O000000o  reason: collision with root package name */
        public SampleAuxiliaryInformationSizesBox f1844O000000o;
        public SampleAuxiliaryInformationOffsetsBox O00000Oo;
        private jha O00000oO;

        public O000000o(jha jha) {
            this.O00000oO = jha;
        }

        public final O000000o O000000o() {
            List boxes = this.O00000oO.getBoxes(SampleAuxiliaryInformationSizesBox.class);
            List boxes2 = this.O00000oO.getBoxes(SampleAuxiliaryInformationOffsetsBox.class);
            if (O00000o0 || boxes.size() == boxes2.size()) {
                this.f1844O000000o = null;
                this.O00000Oo = null;
                for (int i = 0; i < boxes.size(); i++) {
                    if (!(this.f1844O000000o == null && ((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType() == null) && !"cenc".equals(((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType())) {
                        SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = this.f1844O000000o;
                        if (sampleAuxiliaryInformationSizesBox == null || sampleAuxiliaryInformationSizesBox.getAuxInfoType() != null || !"cenc".equals(((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType())) {
                            throw new RuntimeException("Are there two cenc labeled saiz?");
                        }
                        this.f1844O000000o = (SampleAuxiliaryInformationSizesBox) boxes.get(i);
                    } else {
                        this.f1844O000000o = (SampleAuxiliaryInformationSizesBox) boxes.get(i);
                    }
                    if (!(this.O00000Oo == null && ((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType() == null) && !"cenc".equals(((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType())) {
                        SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = this.O00000Oo;
                        if (sampleAuxiliaryInformationOffsetsBox == null || sampleAuxiliaryInformationOffsetsBox.getAuxInfoType() != null || !"cenc".equals(((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType())) {
                            throw new RuntimeException("Are there two cenc labeled saio?");
                        }
                        this.O00000Oo = (SampleAuxiliaryInformationOffsetsBox) boxes2.get(i);
                    } else {
                        this.O00000Oo = (SampleAuxiliaryInformationOffsetsBox) boxes2.get(i);
                    }
                }
                return this;
            }
            throw new AssertionError();
        }
    }
}

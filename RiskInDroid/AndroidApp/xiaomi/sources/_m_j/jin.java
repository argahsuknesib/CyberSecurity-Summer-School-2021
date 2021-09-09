package _m_j;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.iso14496.part12.MovieFragmentBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;
import org.mp4parser.boxes.iso14496.part12.TrackExtendsBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox;
import org.mp4parser.boxes.iso14496.part12.TrackRunBox;

public final class jin extends AbstractList<jie> {

    /* renamed from: O000000o  reason: collision with root package name */
    jha f1858O000000o;
    TrackBox O00000Oo = null;
    HashMap<TrackFragmentBox, MovieFragmentBox> O00000o = new HashMap<>();
    TrackExtendsBox O00000o0 = null;
    private SoftReference<jie>[] O00000oO;
    private List<TrackFragmentBox> O00000oo;
    private Map<TrackRunBox, SoftReference<ByteBuffer>> O0000O0o = new HashMap();
    private int[] O0000OOo;
    private jid O0000Oo;
    private int O0000Oo0 = -1;

    public jin(long j, jha jha, jid jid) {
        this.f1858O000000o = jha;
        this.O0000Oo = jid;
        for (TrackBox trackBox : jlf.O00000Oo(jha, "moov[0]/trak")) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.O00000Oo = trackBox;
            }
        }
        if (this.O00000Oo != null) {
            for (TrackExtendsBox trackExtendsBox : jlf.O00000Oo(jha, "moov[0]/mvex[0]/trex")) {
                if (trackExtendsBox.getTrackId() == this.O00000Oo.getTrackHeaderBox().getTrackId()) {
                    this.O00000o0 = trackExtendsBox;
                }
            }
            this.O00000oO = (SoftReference[]) Array.newInstance(SoftReference.class, size());
            O000000o();
            return;
        }
        throw new RuntimeException("This MP4 does not contain track ".concat(String.valueOf(j)));
    }

    private List<TrackFragmentBox> O000000o() {
        List<TrackFragmentBox> list = this.O00000oo;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (MovieFragmentBox movieFragmentBox : this.f1858O000000o.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.O00000Oo.getTrackHeaderBox().getTrackId()) {
                    arrayList.add(trackFragmentBox);
                    this.O00000o.put(trackFragmentBox, movieFragmentBox);
                }
            }
        }
        this.O00000oo = arrayList;
        this.O0000OOo = new int[this.O00000oo.size()];
        int i = 1;
        for (int i2 = 0; i2 < this.O00000oo.size(); i2++) {
            this.O0000OOo[i2] = i;
            i += O000000o(this.O00000oo.get(i2));
        }
        return arrayList;
    }

    private static int O000000o(TrackFragmentBox trackFragmentBox) {
        int i = 0;
        for (jgy next : trackFragmentBox.getBoxes()) {
            if (next instanceof TrackRunBox) {
                i += jkv.O000000o(((TrackRunBox) next).getSampleCount());
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public jie get(int i) {
        long j;
        long O000000o2;
        jie jie;
        SoftReference<jie>[] softReferenceArr = this.O00000oO;
        if (softReferenceArr[i] != null && (jie = softReferenceArr[i].get()) != null) {
            return jie;
        }
        int i2 = i + 1;
        int length = this.O0000OOo.length;
        while (true) {
            length--;
            if (i2 - this.O0000OOo[length] >= 0) {
                break;
            }
        }
        TrackFragmentBox trackFragmentBox = this.O00000oo.get(length);
        int i3 = i2 - this.O0000OOo[length];
        MovieFragmentBox movieFragmentBox = this.O00000o.get(trackFragmentBox);
        int i4 = 0;
        for (jgy next : trackFragmentBox.getBoxes()) {
            if (next instanceof TrackRunBox) {
                TrackRunBox trackRunBox = (TrackRunBox) next;
                int i5 = i3 - i4;
                if (trackRunBox.getEntries().size() <= i5) {
                    i4 += trackRunBox.getEntries().size();
                } else {
                    List<TrackRunBox.Entry> entries = trackRunBox.getEntries();
                    TrackFragmentHeaderBox trackFragmentHeaderBox = trackFragmentBox.getTrackFragmentHeaderBox();
                    boolean isSampleSizePresent = trackRunBox.isSampleSizePresent();
                    boolean hasDefaultSampleSize = trackFragmentHeaderBox.hasDefaultSampleSize();
                    if (isSampleSizePresent) {
                        j = 0;
                    } else if (hasDefaultSampleSize) {
                        j = trackFragmentHeaderBox.getDefaultSampleSize();
                    } else {
                        TrackExtendsBox trackExtendsBox = this.O00000o0;
                        if (trackExtendsBox != null) {
                            j = trackExtendsBox.getDefaultSampleSize();
                        } else {
                            throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                        }
                    }
                    SoftReference softReference = this.O0000O0o.get(trackRunBox);
                    final ByteBuffer byteBuffer = softReference != null ? (ByteBuffer) softReference.get() : null;
                    if (byteBuffer == null) {
                        if (trackFragmentHeaderBox.hasBaseDataOffset()) {
                            O000000o2 = trackFragmentHeaderBox.getBaseDataOffset();
                        } else if (trackFragmentHeaderBox.isDefaultBaseIsMoof()) {
                            O000000o2 = jle.O000000o(this.f1858O000000o, movieFragmentBox, 0);
                        } else {
                            throw new RuntimeException("Rethink this case");
                        }
                        long j2 = O000000o2 + 0;
                        if (trackRunBox.isDataOffsetPresent()) {
                            j2 += (long) trackRunBox.getDataOffset();
                        }
                        int i6 = 0;
                        for (TrackRunBox.Entry sampleSize : entries) {
                            i6 = isSampleSizePresent ? (int) (((long) i6) + sampleSize.getSampleSize()) : (int) (((long) i6) + j);
                        }
                        try {
                            ByteBuffer O000000o3 = this.O0000Oo.O000000o(j2, (long) i6);
                            this.O0000O0o.put(trackRunBox, new SoftReference(O000000o3));
                            byteBuffer = O000000o3;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    final int i7 = 0;
                    for (int i8 = 0; i8 < i5; i8++) {
                        i7 = (int) (isSampleSizePresent ? ((long) i7) + entries.get(i8).getSampleSize() : ((long) i7) + j);
                    }
                    final long sampleSize2 = isSampleSizePresent ? entries.get(i5).getSampleSize() : j;
                    AnonymousClass1 r1 = new jie() {
                        /* class _m_j.jin.AnonymousClass1 */

                        public final void O000000o(WritableByteChannel writableByteChannel) throws IOException {
                            writableByteChannel.write(O00000Oo());
                        }

                        public final long O000000o() {
                            return sampleSize2;
                        }

                        public final ByteBuffer O00000Oo() {
                            return (ByteBuffer) ((ByteBuffer) byteBuffer.position(i7)).slice().limit(jkv.O000000o(sampleSize2));
                        }
                    };
                    this.O00000oO[i] = new SoftReference<>(r1);
                    return r1;
                }
            }
        }
        throw new RuntimeException("Couldn't find sample in the traf I was looking");
    }

    public final int size() {
        int i = this.O0000Oo0;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (MovieFragmentBox boxes : this.f1858O000000o.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : boxes.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.O00000Oo.getTrackHeaderBox().getTrackId()) {
                    for (TrackRunBox sampleCount : trackFragmentBox.getBoxes(TrackRunBox.class)) {
                        i2 = (int) (((long) i2) + sampleCount.getSampleCount());
                    }
                }
            }
        }
        this.O0000Oo0 = i2;
        return i2;
    }
}

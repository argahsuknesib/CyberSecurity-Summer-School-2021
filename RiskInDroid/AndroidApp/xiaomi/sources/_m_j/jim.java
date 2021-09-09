package _m_j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mp4parser.boxes.iso14496.part12.SampleSizeBox;
import org.mp4parser.boxes.iso14496.part12.SampleToChunkBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;

public class jim extends AbstractList<jie> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jks f1856O000000o = jks.O000000o(jim.class);
    jha O00000Oo;
    SoftReference<ByteBuffer>[] O00000o = null;
    TrackBox O00000o0 = null;
    int[] O00000oO;
    long[] O00000oo;
    long[] O0000O0o;
    long[][] O0000OOo;
    int O0000Oo = 0;
    SampleSizeBox O0000Oo0;
    public jid O0000OoO;

    public jim(long j, jha jha, jid jid) {
        int i;
        jha jha2 = jha;
        this.O00000Oo = jha2;
        this.O0000OoO = jid;
        for (TrackBox trackBox : ((MovieBox) jha2.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.O00000o0 = trackBox;
            }
        }
        TrackBox trackBox2 = this.O00000o0;
        if (trackBox2 != null) {
            this.O00000oo = trackBox2.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
            long[] jArr = this.O00000oo;
            this.O0000O0o = new long[jArr.length];
            this.O00000o = new SoftReference[jArr.length];
            Arrays.fill(this.O00000o, new SoftReference(null));
            this.O0000OOo = new long[this.O00000oo.length][];
            this.O0000Oo0 = this.O00000o0.getSampleTableBox().getSampleSizeBox();
            List<SampleToChunkBox.Entry> entries = this.O00000o0.getSampleTableBox().getSampleToChunkBox().getEntries();
            SampleToChunkBox.Entry[] entryArr = (SampleToChunkBox.Entry[]) entries.toArray(new SampleToChunkBox.Entry[entries.size()]);
            SampleToChunkBox.Entry entry = entryArr[0];
            long firstChunk = entry.getFirstChunk();
            int O000000o2 = jkv.O000000o(entry.getSamplesPerChunk());
            int size = size();
            int i2 = O000000o2;
            int i3 = 0;
            int i4 = 1;
            int i5 = 1;
            int i6 = 0;
            do {
                i3++;
                if (((long) i3) == firstChunk) {
                    if (entryArr.length > i4) {
                        SampleToChunkBox.Entry entry2 = entryArr[i4];
                        int O000000o3 = jkv.O000000o(entry2.getSamplesPerChunk());
                        i4++;
                        firstChunk = entry2.getFirstChunk();
                        i6 = i2;
                        i2 = O000000o3;
                    } else {
                        i6 = i2;
                        firstChunk = Long.MAX_VALUE;
                        i2 = -1;
                    }
                }
                this.O0000OOo[i3 - 1] = new long[i6];
                i5 += i6;
            } while (i5 <= size);
            this.O00000oO = new int[(i3 + 1)];
            SampleToChunkBox.Entry entry3 = entryArr[0];
            long firstChunk2 = entry3.getFirstChunk();
            int i7 = 1;
            int i8 = 1;
            int i9 = 0;
            int O000000o4 = jkv.O000000o(entry3.getSamplesPerChunk());
            int i10 = 0;
            while (true) {
                i = i10 + 1;
                this.O00000oO[i10] = i7;
                if (((long) i) == firstChunk2) {
                    if (entryArr.length > i8) {
                        int i11 = i8 + 1;
                        SampleToChunkBox.Entry entry4 = entryArr[i8];
                        int O000000o5 = jkv.O000000o(entry4.getSamplesPerChunk());
                        firstChunk2 = entry4.getFirstChunk();
                        i8 = i11;
                        int i12 = O000000o5;
                        i9 = O000000o4;
                        O000000o4 = i12;
                    } else {
                        i9 = O000000o4;
                        O000000o4 = -1;
                        firstChunk2 = Long.MAX_VALUE;
                    }
                }
                i7 += i9;
                if (i7 > size) {
                    break;
                }
                i10 = i;
            }
            this.O00000oO[i] = Integer.MAX_VALUE;
            long j2 = 0;
            int i13 = 0;
            for (int i14 = 1; ((long) i14) <= this.O0000Oo0.getSampleCount(); i14++) {
                while (i14 == this.O00000oO[i13]) {
                    i13++;
                    j2 = 0;
                }
                long[] jArr2 = this.O0000O0o;
                int i15 = i13 - 1;
                int i16 = i14 - 1;
                jArr2[i15] = jArr2[i15] + this.O0000Oo0.getSampleSizeAtIndex(i16);
                this.O0000OOo[i15][i14 - this.O00000oO[i15]] = j2;
                j2 += this.O0000Oo0.getSampleSizeAtIndex(i16);
            }
            return;
        }
        throw new RuntimeException("This MP4 does not contain track ".concat(String.valueOf(j)));
    }

    /* access modifiers changed from: package-private */
    public final synchronized int O000000o(int i) {
        int i2 = i + 1;
        if (i2 >= this.O00000oO[this.O0000Oo] && i2 < this.O00000oO[this.O0000Oo + 1]) {
            return this.O0000Oo;
        } else if (i2 < this.O00000oO[this.O0000Oo]) {
            this.O0000Oo = 0;
            while (this.O00000oO[this.O0000Oo + 1] <= i2) {
                this.O0000Oo++;
            }
            return this.O0000Oo;
        } else {
            do {
                this.O0000Oo++;
            } while (this.O00000oO[this.O0000Oo + 1] <= i2);
            return this.O0000Oo;
        }
    }

    public int size() {
        return jkv.O000000o(this.O00000o0.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }

    class O000000o implements jie {
        private int O00000Oo;

        public O000000o(int i) {
            this.O00000Oo = i;
        }

        public final void O000000o(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(O00000Oo());
        }

        public final long O000000o() {
            return jim.this.O0000Oo0.getSampleSizeAtIndex(this.O00000Oo);
        }

        public final synchronized ByteBuffer O00000Oo() {
            long j;
            ByteBuffer byteBuffer;
            int O000000o2 = jim.this.O000000o(this.O00000Oo);
            SoftReference<ByteBuffer> softReference = jim.this.O00000o[O000000o2];
            int i = jim.this.O00000oO[O000000o2] - 1;
            long j2 = (long) O000000o2;
            long[] jArr = jim.this.O0000OOo[jkv.O000000o(j2)];
            j = jArr[this.O00000Oo - i];
            if (softReference == null || (byteBuffer = softReference.get()) == null) {
                try {
                    byteBuffer = jim.this.O0000OoO.O000000o(jim.this.O00000oo[jkv.O000000o(j2)], jArr[jArr.length - 1] + jim.this.O0000Oo0.getSampleSizeAtIndex((i + jArr.length) - 1));
                    jim.this.O00000o[O000000o2] = new SoftReference<>(byteBuffer);
                } catch (IOException e) {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    jim.f1856O000000o.O00000o0(stringWriter.toString());
                    throw new IndexOutOfBoundsException(e.getMessage());
                }
            }
            return (ByteBuffer) ((ByteBuffer) byteBuffer.duplicate().position(jkv.O000000o(j))).slice().limit(jkv.O000000o(jim.this.O0000Oo0.getSampleSizeAtIndex(this.O00000Oo)));
        }

        public final String toString() {
            return "Sample(index: " + this.O00000Oo + " size: " + jim.this.O0000Oo0.getSampleSizeAtIndex(this.O00000Oo) + ")";
        }
    }

    public /* synthetic */ Object get(int i) {
        if (((long) i) < this.O0000Oo0.getSampleCount()) {
            return new O000000o(i);
        }
        throw new IndexOutOfBoundsException();
    }
}

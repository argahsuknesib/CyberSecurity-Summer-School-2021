package org.mp4parser.streaming.input.mp4;

import _m_j.jgx;
import _m_j.jhd;
import _m_j.jhe;
import _m_j.jjk;
import _m_j.jjl;
import _m_j.jjn;
import _m_j.jjo;
import _m_j.jjr;
import _m_j.jjs;
import _m_j.jju;
import _m_j.jkj;
import _m_j.jkk;
import _m_j.jkm;
import _m_j.jko;
import _m_j.jkv;
import _m_j.jlf;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.DegradationPriorityBox;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part12.SampleSizeBox;
import org.mp4parser.boxes.iso14496.part12.SampleTableBox;
import org.mp4parser.boxes.iso14496.part12.SampleToChunkBox;
import org.mp4parser.boxes.iso14496.part12.TimeToSampleBox;
import org.mp4parser.boxes.iso14496.part12.TrackBox;

public class ClassicMp4ContainerSource implements Callable<Void> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBuffer BUFFER = ByteBuffer.allocateDirect(65535);
    final jkj baos = new jkj();
    final HashMap<TrackBox, Long> currentChunks = new HashMap<>();
    final HashMap<TrackBox, Long> currentSamples = new HashMap<>();
    final ReadableByteChannel readableByteChannel;
    final HashMap<TrackBox, O000000o> tracks = new LinkedHashMap();

    public ClassicMp4ContainerSource(InputStream inputStream) throws IOException {
        this.readableByteChannel = Channels.newChannel(new O00000Oo(inputStream, this.baos));
        jgx jgx = new jgx();
        String[] strArr = new String[0];
        jhe jhe = new jhe();
        jhd jhd = null;
        while (true) {
            if (jhd != null && "moov".equals(jhd.getType())) {
                break;
            }
            jhd = jhe.O000000o(this.readableByteChannel, null);
            jgx.addBox(jhd);
        }
        for (TrackBox trackBox : jlf.O00000Oo(jgx, "moov[0]/trak")) {
            O000000o o000000o = new O000000o(trackBox);
            this.tracks.put(trackBox, o000000o);
            if (trackBox.getSampleTableBox().getCompositionTimeToSample() != null) {
                o000000o.addTrackExtension(new jjo());
            }
            o000000o.addTrackExtension(new jjs(trackBox.getTrackHeaderBox().getTrackId()));
            this.currentChunks.put(trackBox, 1L);
            this.currentSamples.put(trackBox, 1L);
        }
    }

    public static void main(String[] strArr) throws IOException {
        try {
            ClassicMp4ContainerSource classicMp4ContainerSource = new ClassicMp4ContainerSource(new URI("http://org.mp4parser.s3.amazonaws.com/examples/Cosmos%20Laundromat%20small%20faststart.mp4").toURL().openStream());
            List<jjk> tracks2 = classicMp4ContainerSource.getTracks();
            File file = new File("output.mp4");
            jkm jkm = new jkm(tracks2, new FileOutputStream(file).getChannel());
            System.out.println("Reading and writing started.");
            classicMp4ContainerSource.call();
            jkm.close();
            System.err.println(file.getAbsolutePath());
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public List<jjk> getTracks() {
        return new ArrayList(this.tracks.values());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T
     arg types: [org.mp4parser.boxes.iso14496.part12.SampleTableBox, java.lang.String]
     candidates:
      _m_j.jlf.O000000o(_m_j.jha, java.lang.String):T
      _m_j.jlf.O000000o(_m_j.jgy, java.lang.String):java.util.List<T>
      _m_j.jlf.O000000o(_m_j.jko, java.lang.String):T */
    public Void call() throws IOException {
        long j;
        SampleToChunkBox.Entry entry;
        List<TimeToSampleBox.Entry> list;
        long j2;
        SampleTableBox sampleTableBox;
        long j3;
        while (true) {
            Iterator<TrackBox> it = this.tracks.keySet().iterator();
            long j4 = 0;
            long j5 = 0;
            long j6 = Long.MAX_VALUE;
            TrackBox trackBox = null;
            while (it.hasNext()) {
                TrackBox next = it.next();
                long longValue = this.currentChunks.get(next).longValue();
                long longValue2 = this.currentSamples.get(next).longValue();
                long[] chunkOffsets = next.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
                Iterator<TrackBox> it2 = it;
                if (jkv.O000000o(longValue) - 1 < chunkOffsets.length && chunkOffsets[jkv.O000000o(longValue) - 1] < j6) {
                    j6 = chunkOffsets[jkv.O000000o(longValue) - 1];
                    trackBox = next;
                    j4 = longValue;
                    j5 = longValue2;
                }
                it = it2;
            }
            if (trackBox == null) {
                break;
            }
            SampleToChunkBox.Entry entry2 = null;
            for (SampleToChunkBox.Entry next2 : trackBox.getSampleTableBox().getSampleToChunkBox().getEntries()) {
                if (j4 < next2.getFirstChunk()) {
                    break;
                }
                entry2 = next2;
            }
            SampleTableBox sampleTableBox2 = trackBox.getSampleTableBox();
            List<TimeToSampleBox.Entry> entries = sampleTableBox2.getTimeToSampleBox().getEntries();
            List<CompositionTimeToSample.Entry> entries2 = sampleTableBox2.getCompositionTimeToSample() != null ? sampleTableBox2.getCompositionTimeToSample().getEntries() : null;
            SampleSizeBox sampleSizeBox = sampleTableBox2.getSampleSizeBox();
            long j7 = j6;
            long j8 = j5;
            while (j8 < j5 + entry2.getSamplesPerChunk()) {
                long j9 = j5;
                long delta = entries.get(0).getDelta();
                if (entries.get(0).getCount() == 1) {
                    entries.remove(0);
                    entry = entry2;
                    j = j4;
                    list = entries;
                } else {
                    entry = entry2;
                    j = j4;
                    list = entries;
                    entries.get(0).setCount(entries.get(0).getCount() - 1);
                }
                SampleDependencyTypeBox sampleDependencyTypeBox = (SampleDependencyTypeBox) jlf.O000000o((jko) sampleTableBox2, "sdtp");
                jjr jjr = new jjr();
                if (sampleDependencyTypeBox != null) {
                    SampleDependencyTypeBox.Entry entry3 = sampleDependencyTypeBox.getEntries().get(jkv.O000000o(j8));
                    jjr.O00000Oo = entry3.getIsLeading();
                    jjr.O00000o0 = (byte) entry3.getSampleDependsOn();
                    jjr.O00000o = (byte) entry3.getSampleIsDependedOn();
                    jjr.O00000oO = entry3.getSampleHasRedundancy();
                }
                if (sampleTableBox2.getSyncSampleBox() != null) {
                    if (Arrays.binarySearch(sampleTableBox2.getSyncSampleBox().getSampleNumber(), j8) >= 0) {
                        jjr.O0000O0o = false;
                    } else {
                        jjr.O0000O0o = true;
                    }
                }
                DegradationPriorityBox degradationPriorityBox = (DegradationPriorityBox) jlf.O000000o((jko) sampleTableBox2, "stdp");
                if (degradationPriorityBox != null) {
                    jjr.O0000OOo = degradationPriorityBox.getPriorities()[jkv.O000000o(j8)];
                }
                int O000000o2 = jkv.O000000o(sampleSizeBox.getSampleSizeAtIndex(jkv.O000000o(j8 - 1)));
                long O000000o3 = this.baos.O000000o();
                List<TimeToSampleBox.Entry> list2 = list;
                while (true) {
                    j2 = ((long) O000000o2) + j7;
                    if (O000000o3 > j2) {
                        sampleTableBox = sampleTableBox2;
                        break;
                    }
                    try {
                        sampleTableBox = sampleTableBox2;
                        if (this.readableByteChannel.read(this.BUFFER) == -1) {
                            break;
                        }
                        long O000000o4 = this.baos.O000000o();
                        this.BUFFER.rewind();
                        sampleTableBox2 = sampleTableBox;
                        O000000o3 = O000000o4;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                jju jju = new jju(this.baos.O000000o(j7, O000000o2), delta);
                jju.O000000o(jjr);
                if (entries2 == null || entries2.isEmpty()) {
                    j3 = j2;
                } else {
                    long offset = (long) ((CompositionTimeToSample.Entry) entries2.get(0)).getOffset();
                    j3 = j2;
                    if (((CompositionTimeToSample.Entry) entries2.get(0)).getCount() == 1) {
                        entries2.remove(0);
                    } else {
                        ((CompositionTimeToSample.Entry) entries2.get(0)).setCount(((CompositionTimeToSample.Entry) entries2.get(0)).getCount() - 1);
                    }
                    jju.O000000o(jjn.O000000o(offset));
                }
                if (trackBox.getTrackHeaderBox().getTrackId() == 1) {
                    System.out.println("Pushing sample @" + j7 + " of " + O000000o2 + " bytes (i=" + j8 + ")");
                }
                this.tracks.get(trackBox).O00000o0.O000000o(jju, this.tracks.get(trackBox));
                j8++;
                entries = list2;
                entry2 = entry;
                j5 = j9;
                sampleTableBox2 = sampleTableBox;
                j4 = j;
                j7 = j3;
            }
            this.baos.O000000o(j7);
            this.currentChunks.put(trackBox, Long.valueOf(j4 + 1));
            this.currentSamples.put(trackBox, Long.valueOf(j5 + entry2.getSamplesPerChunk()));
        }
        for (O000000o close : this.tracks.values()) {
            close.close();
        }
        System.out.println("All Samples read.");
        return null;
    }

    public static class O000000o implements jjk {

        /* renamed from: O000000o  reason: collision with root package name */
        protected HashMap<Class<? extends jjl>, jjl> f15449O000000o = new HashMap<>();
        boolean O00000Oo = false;
        private final TrackBox O00000o;
        jkk O00000o0;

        public O000000o(TrackBox trackBox) {
            this.O00000o = trackBox;
        }

        public final void close() {
            this.O00000Oo = true;
        }

        public final long getTimescale() {
            return this.O00000o.getMediaBox().getMediaHeaderBox().getTimescale();
        }

        public final void setSampleSink(jkk jkk) {
            this.O00000o0 = jkk;
        }

        public final String getHandler() {
            return this.O00000o.getMediaBox().getHandlerBox().getHandlerType();
        }

        public final String getLanguage() {
            return this.O00000o.getMediaBox().getMediaHeaderBox().getLanguage();
        }

        public final SampleDescriptionBox getSampleDescriptionBox() {
            return this.O00000o.getSampleTableBox().getSampleDescriptionBox();
        }

        public final <T extends jjl> T getTrackExtension(Class<T> cls) {
            return (jjl) this.f15449O000000o.get(cls);
        }

        public final void addTrackExtension(jjl jjl) {
            this.f15449O000000o.put(jjl.getClass(), jjl);
        }
    }

    public static class O00000Oo extends FilterInputStream {

        /* renamed from: O000000o  reason: collision with root package name */
        long f15450O000000o = 0;
        private final OutputStream O00000Oo;

        public O00000Oo(InputStream inputStream, OutputStream outputStream) {
            super(inputStream);
            this.O00000Oo = outputStream;
        }

        public final int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.O00000Oo.write(read);
                this.f15450O000000o++;
            }
            return read;
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.O00000Oo.write(bArr, i, read);
                this.f15450O000000o += (long) read;
            }
            return read;
        }

        public final int read(byte[] bArr) throws IOException {
            int read = super.read(bArr);
            if (read != -1) {
                this.O00000Oo.write(bArr, 0, read);
                this.f15450O000000o += (long) read;
            }
            return read;
        }
    }
}

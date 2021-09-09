package _m_j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mp4parser.boxes.iso14496.part12.FileTypeBox;
import org.mp4parser.boxes.iso14496.part12.MediaHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MovieBox;
import org.mp4parser.boxes.iso14496.part12.MovieExtendsBox;
import org.mp4parser.boxes.iso14496.part12.MovieExtendsHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MovieFragmentBox;
import org.mp4parser.boxes.iso14496.part12.MovieFragmentHeaderBox;
import org.mp4parser.boxes.iso14496.part12.MovieFragmentRandomAccessBox;
import org.mp4parser.boxes.iso14496.part12.MovieFragmentRandomAccessOffsetBox;
import org.mp4parser.boxes.iso14496.part12.MovieHeaderBox;
import org.mp4parser.boxes.iso14496.part12.SampleFlags;
import org.mp4parser.boxes.iso14496.part12.TrackExtendsBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentBaseMediaDecodeTimeBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox;
import org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox;
import org.mp4parser.boxes.iso14496.part12.TrackRunBox;

public class jkm extends jkl implements jkk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f1905O000000o = new Object();
    private static final Logger O0000o = Logger.getLogger(jkm.class.getName());
    static final /* synthetic */ boolean O0000o0o = (!jkm.class.desiredAssertionStatus());
    protected final WritableByteChannel O00000Oo;
    protected Date O00000o;
    protected List<jjk> O00000o0;
    protected long O00000oO = 1;
    protected Map<jjk, CountDownLatch> O00000oo = new ConcurrentHashMap();
    protected Map<jjk, Long> O0000O0o = new ConcurrentHashMap();
    protected Map<jjk, Long> O0000OOo = new ConcurrentHashMap();
    protected Map<jjk, List<jjj>> O0000Oo = new HashMap();
    protected Map<jjk, Long> O0000Oo0 = new HashMap();
    protected Map<jjk, Queue<O000000o>> O0000OoO = new ConcurrentHashMap();
    protected Map<jjk, long[]> O0000Ooo = new HashMap();
    long O0000o0 = 0;
    protected Map<jjk, long[]> O0000o00 = new HashMap();
    volatile boolean O0000o0O = false;

    public jkm(List<jjk> list, WritableByteChannel writableByteChannel) throws IOException {
        this.O00000o0 = new LinkedList(list);
        this.O00000Oo = writableByteChannel;
        this.O00000o = new Date();
        HashSet hashSet = new HashSet();
        for (jjk next : list) {
            next.setSampleSink(this);
            this.O0000Oo.put(next, new ArrayList());
            this.O0000OoO.put(next, new LinkedList());
            this.O0000O0o.put(next, 0L);
            this.O0000OOo.put(next, 0L);
            this.O0000Oo0.put(next, 0L);
            this.O00000oo.put(next, new CountDownLatch(0));
            if (next.getTrackExtension(jjs.class) != null) {
                jjs jjs = (jjs) next.getTrackExtension(jjs.class);
                if (!O0000o0o && jjs == null) {
                    throw new AssertionError();
                } else if (hashSet.contains(Long.valueOf(jjs.f1886O000000o))) {
                    throw new IOException("There may not be two tracks with the same trackID within one file");
                }
            }
        }
        for (jjk next2 : list) {
            if (next2.getTrackExtension(jjs.class) == null) {
                Iterator it = hashSet.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j = Math.max(((Long) it.next()).longValue(), j);
                }
                jjs jjs2 = new jjs(j + 1);
                hashSet.add(Long.valueOf(jjs2.f1886O000000o));
                next2.addTrackExtension(jjs2);
            }
        }
    }

    public synchronized void close() throws IOException {
        for (jjk next : this.O00000o0) {
            O000000o(O000000o(next, this.O0000Oo.get(next)));
            next.close();
        }
        MovieFragmentRandomAccessBox movieFragmentRandomAccessBox = new MovieFragmentRandomAccessBox();
        Iterator<jjk> it = this.O00000o0.iterator();
        while (true) {
            if (it.hasNext()) {
                jjk next2 = it.next();
                TrackFragmentRandomAccessBox trackFragmentRandomAccessBox = new TrackFragmentRandomAccessBox();
                trackFragmentRandomAccessBox.setVersion(1);
                long[] jArr = this.O0000Ooo.get(next2);
                long[] jArr2 = this.O0000o00.get(next2);
                ArrayList arrayList = new ArrayList(jArr2.length);
                for (int i = 0; i < jArr2.length; i++) {
                    arrayList.add(new TrackFragmentRandomAccessBox.Entry(jArr2[i], jArr[i], 1, 1, 1));
                }
                trackFragmentRandomAccessBox.setEntries(arrayList);
                trackFragmentRandomAccessBox.setTrackId(((jjs) next2.getTrackExtension(jjs.class)).f1886O000000o);
                movieFragmentRandomAccessBox.addBox(trackFragmentRandomAccessBox);
            } else {
                MovieFragmentRandomAccessOffsetBox movieFragmentRandomAccessOffsetBox = new MovieFragmentRandomAccessOffsetBox();
                movieFragmentRandomAccessBox.addBox(movieFragmentRandomAccessOffsetBox);
                movieFragmentRandomAccessOffsetBox.setMfraSize(movieFragmentRandomAccessBox.getSize());
                O000000o(this.O00000Oo, movieFragmentRandomAccessBox);
            }
        }
    }

    private void O000000o(WritableByteChannel writableByteChannel, jgy... jgyArr) throws IOException {
        for (jgy jgy : jgyArr) {
            jgy.getBox(writableByteChannel);
            this.O0000o0 += jgy.getSize();
        }
    }

    /* access modifiers changed from: protected */
    public final jgy O000000o(jjk jjk) {
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(this.O00000o);
        mediaHeaderBox.setModificationTime(this.O00000o);
        mediaHeaderBox.setDuration(0);
        mediaHeaderBox.setTimescale(jjk.getTimescale());
        mediaHeaderBox.setLanguage(jjk.getLanguage());
        return mediaHeaderBox;
    }

    private jgy O000000o() {
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setVersion(1);
        movieHeaderBox.setCreationTime(this.O00000o);
        movieHeaderBox.setModificationTime(this.O00000o);
        movieHeaderBox.setDuration(0);
        long[] jArr = new long[0];
        long j = 0;
        for (jjk next : this.O00000o0) {
            jArr = jlc.O000000o(jArr, next.getTimescale());
            j = Math.max(((jjs) next.getTrackExtension(jjs.class)).f1886O000000o, j);
        }
        long j2 = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            j2 = jld.O00000Oo(j2, jArr[i]);
        }
        movieHeaderBox.setTimescale(j2);
        movieHeaderBox.setNextTrackId(j + 1);
        movieBox.addBox(movieHeaderBox);
        for (jjk O00000Oo2 : this.O00000o0) {
            movieBox.addBox(O00000Oo(O00000Oo2));
        }
        MovieExtendsBox movieExtendsBox = new MovieExtendsBox();
        MovieExtendsHeaderBox movieExtendsHeaderBox = new MovieExtendsHeaderBox();
        movieExtendsHeaderBox.setVersion(1);
        movieExtendsHeaderBox.setFragmentDuration(0);
        movieExtendsBox.addBox(movieExtendsHeaderBox);
        for (jjk trackExtension : this.O00000o0) {
            TrackExtendsBox trackExtendsBox = new TrackExtendsBox();
            trackExtendsBox.setTrackId(((jjs) trackExtension.getTrackExtension(jjs.class)).f1886O000000o);
            trackExtendsBox.setDefaultSampleDescriptionIndex(1);
            trackExtendsBox.setDefaultSampleDuration(0);
            trackExtendsBox.setDefaultSampleSize(0);
            trackExtendsBox.setDefaultSampleFlags(new SampleFlags());
            movieExtendsBox.addBox(trackExtendsBox);
        }
        movieBox.addBox(movieExtendsBox);
        return movieBox;
    }

    public final void O000000o(jjj jjj, jjk jjk) throws IOException {
        boolean z;
        jjr jjr;
        boolean z2;
        synchronized (f1905O000000o) {
            z = true;
            if (!this.O0000o0O) {
                boolean z3 = true;
                for (jjk next : this.O00000o0) {
                    if (this.O0000Oo0.get(next).longValue() <= 0) {
                        if (next != jjk) {
                            z2 = false;
                            z3 &= z2;
                        }
                    }
                    z2 = true;
                    z3 &= z2;
                }
                if (z3) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add("isom");
                    linkedList.add("iso2");
                    linkedList.add("avc1");
                    linkedList.add("iso6");
                    linkedList.add("mp41");
                    O000000o(this.O00000Oo, new FileTypeBox("isom", 512, linkedList), O000000o());
                    this.O0000o0O = true;
                }
            }
        }
        try {
            CountDownLatch countDownLatch = this.O00000oo.get(jjk);
            if (countDownLatch.getCount() > 0) {
                countDownLatch.await();
            }
        } catch (InterruptedException unused) {
        }
        if (this.O0000Oo0.get(jjk).longValue() <= this.O0000O0o.get(jjk).longValue() + (jjk.getTimescale() * 3) || ((jjr = (jjr) jjj.O000000o(jjr.class)) != null && !(!jjr.O0000O0o))) {
            z = false;
        }
        if (z) {
            O000000o o000000o = new O000000o();
            o000000o.f1908O000000o = O000000o(jjk, new ArrayList(this.O0000Oo.get(jjk)));
            o000000o.O00000Oo = this.O0000Oo0.get(jjk).longValue() - this.O0000O0o.get(jjk).longValue();
            this.O0000Oo.get(jjk).clear();
            Map<jjk, Long> map = this.O0000O0o;
            map.put(jjk, Long.valueOf(map.get(jjk).longValue() + o000000o.O00000Oo));
            Queue queue = this.O0000OoO.get(jjk);
            queue.add(o000000o);
            synchronized (f1905O000000o) {
                if (this.O0000o0O && this.O00000o0.get(0) == jjk) {
                    while (true) {
                        Map<jjk, Queue<O000000o>> map2 = this.O0000OoO;
                        jjk jjk2 = this.O00000o0.get(0);
                        Queue queue2 = map2.get(jjk2);
                        if (queue2.isEmpty()) {
                            break;
                        }
                        O000000o o000000o2 = (O000000o) queue2.remove();
                        O000000o(o000000o2.f1908O000000o);
                        this.O00000oo.get(jjk2).countDown();
                        long longValue = this.O0000OOo.get(jjk2).longValue() + o000000o2.O00000Oo;
                        this.O0000OOo.put(jjk2, Long.valueOf(longValue));
                        if (O0000o.isLoggable(Level.FINE)) {
                            Logger logger = O0000o;
                            StringBuilder sb = new StringBuilder();
                            sb.append(jjk2);
                            sb.append(" advanced to ");
                            double d = (double) longValue;
                            double timescale = (double) jjk2.getTimescale();
                            Double.isNaN(d);
                            Double.isNaN(timescale);
                            sb.append(d / timescale);
                            logger.fine(sb.toString());
                        }
                        Collections.sort(this.O00000o0, new Comparator<jjk>() {
                            /* class _m_j.jkm.AnonymousClass1 */

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                jjk jjk = (jjk) obj;
                                jjk jjk2 = (jjk) obj2;
                                return (int) ((double) Math.signum((float) ((jkm.this.O0000OOo.get(jjk).longValue() * jjk2.getTimescale()) - (jkm.this.O0000OOo.get(jjk2).longValue() * jjk.getTimescale()))));
                            }
                        });
                    }
                } else if (queue.size() > 10) {
                    this.O00000oo.put(jjk, new CountDownLatch(queue.size()));
                }
            }
        }
        this.O0000Oo.get(jjk).add(jjj);
        Map<jjk, Long> map3 = this.O0000Oo0;
        map3.put(jjk, Long.valueOf(map3.get(jjk).longValue() + jjj.O00000Oo()));
    }

    private jgy[] O000000o(jjk jjk, List<jjj> list) {
        this.O0000O0o.get(jjk);
        Map<jjk, long[]> map = this.O0000Ooo;
        map.put(jjk, jlc.O000000o(map.get(jjk), this.O0000o0));
        Map<jjk, long[]> map2 = this.O0000o00;
        map2.put(jjk, jlc.O000000o(map2.get(jjk), this.O0000O0o.get(jjk).longValue()));
        O0000o.finest("Container created");
        jgy O00000Oo2 = O00000Oo(jjk, list);
        O0000o.finest("moof created");
        jgy O000000o2 = O000000o(list);
        O0000o.finest("mdat created");
        if (O0000o.isLoggable(Level.FINE)) {
            double longValue = (double) (this.O0000Oo0.get(jjk).longValue() - this.O0000O0o.get(jjk).longValue());
            Logger logger = O0000o;
            StringBuilder sb = new StringBuilder("created fragment for ");
            sb.append(jjk);
            sb.append(" of ");
            double timescale = (double) jjk.getTimescale();
            Double.isNaN(longValue);
            Double.isNaN(timescale);
            sb.append(longValue / timescale);
            sb.append(" seconds");
            logger.fine(sb.toString());
        }
        return new jgy[]{O00000Oo2, O000000o2};
    }

    private void O000000o(jgy... jgyArr) throws IOException {
        O000000o(this.O00000Oo, jgyArr);
    }

    private jgy O00000Oo(jjk jjk, List<jjj> list) {
        MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
        O000000o(this.O00000oO, movieFragmentBox);
        O000000o(jjk, movieFragmentBox, list);
        TrackRunBox trackRunBox = movieFragmentBox.getTrackRunBoxes().get(0);
        trackRunBox.setDataOffset(1);
        trackRunBox.setDataOffset((int) (movieFragmentBox.getSize() + 8));
        return movieFragmentBox;
    }

    private static void O000000o(jjk jjk, TrackFragmentBox trackFragmentBox) {
        TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
        SampleFlags sampleFlags = new SampleFlags();
        jjp jjp = (jjp) jjk.getTrackExtension(jjp.class);
        if (jjp != null) {
            sampleFlags.setIsLeading(jjp.O00000Oo);
            sampleFlags.setSampleIsDependedOn(jjp.O00000o);
            sampleFlags.setSampleDependsOn(jjp.O00000o0);
            sampleFlags.setSampleHasRedundancy(jjp.O00000oO);
            sampleFlags.setSampleIsDifferenceSample(jjp.O0000O0o);
            sampleFlags.setSamplePaddingValue(jjp.O00000oo);
            sampleFlags.setSampleDegradationPriority(jjp.O0000OOo);
        }
        trackFragmentHeaderBox.setDefaultSampleFlags(sampleFlags);
        trackFragmentHeaderBox.setBaseDataOffset(-1);
        trackFragmentHeaderBox.setTrackId(((jjs) jjk.getTrackExtension(jjs.class)).f1886O000000o);
        trackFragmentHeaderBox.setDefaultBaseIsMoof(true);
        trackFragmentBox.addBox(trackFragmentHeaderBox);
    }

    private void O00000Oo(jjk jjk, TrackFragmentBox trackFragmentBox) {
        TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = new TrackFragmentBaseMediaDecodeTimeBox();
        trackFragmentBaseMediaDecodeTimeBox.setVersion(1);
        trackFragmentBaseMediaDecodeTimeBox.setBaseMediaDecodeTime(this.O0000O0o.get(jjk).longValue());
        trackFragmentBox.addBox(trackFragmentBaseMediaDecodeTimeBox);
    }

    private static void O000000o(jjk jjk, TrackFragmentBox trackFragmentBox, List<jjj> list) {
        TrackRunBox trackRunBox = new TrackRunBox();
        boolean z = true;
        trackRunBox.setVersion(1);
        trackRunBox.setSampleDurationPresent(true);
        trackRunBox.setSampleSizePresent(true);
        ArrayList arrayList = new ArrayList(list.size());
        trackRunBox.setSampleCompositionTimeOffsetPresent(jjk.getTrackExtension(jjo.class) != null);
        jjp jjp = (jjp) jjk.getTrackExtension(jjp.class);
        if (jjp != null) {
            z = false;
        }
        trackRunBox.setSampleFlagsPresent(z);
        for (jjj next : list) {
            TrackRunBox.Entry entry = new TrackRunBox.Entry();
            entry.setSampleSize((long) next.O000000o().remaining());
            if (jjp == null) {
                jjr jjr = (jjr) next.O000000o(jjr.class);
                if (O0000o0o || jjr != null) {
                    SampleFlags sampleFlags = new SampleFlags();
                    sampleFlags.setIsLeading(jjr.O00000Oo);
                    sampleFlags.setSampleIsDependedOn(jjr.O00000o);
                    sampleFlags.setSampleDependsOn(jjr.O00000o0);
                    sampleFlags.setSampleHasRedundancy(jjr.O00000oO);
                    sampleFlags.setSampleIsDifferenceSample(jjr.O0000O0o);
                    sampleFlags.setSamplePaddingValue(jjr.O00000oo);
                    sampleFlags.setSampleDegradationPriority(jjr.O0000OOo);
                    entry.setSampleFlags(sampleFlags);
                } else {
                    throw new AssertionError("SampleDependencySampleExtension missing even though SampleDependencyTrackExtension was present");
                }
            }
            entry.setSampleDuration(next.O00000Oo());
            if (trackRunBox.isSampleCompositionTimeOffsetPresent()) {
                jjn jjn = (jjn) next.O000000o(jjn.class);
                if (O0000o0o || jjn != null) {
                    entry.setSampleCompositionTimeOffset(jkv.O000000o(jjn.O00000Oo));
                } else {
                    throw new AssertionError("CompositionTimeSampleExtension missing even though CompositionTimeTrackExtension was present");
                }
            }
            arrayList.add(entry);
        }
        trackRunBox.setEntries(arrayList);
        trackFragmentBox.addBox(trackRunBox);
    }

    private void O000000o(jjk jjk, MovieFragmentBox movieFragmentBox, List<jjj> list) {
        TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
        movieFragmentBox.addBox(trackFragmentBox);
        O000000o(jjk, trackFragmentBox);
        O00000Oo(jjk, trackFragmentBox);
        O000000o(jjk, trackFragmentBox, list);
        jjk.getTrackExtension(jjm.class);
    }

    private static void O000000o(long j, MovieFragmentBox movieFragmentBox) {
        MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
        movieFragmentHeaderBox.setSequenceNumber(j);
        movieFragmentBox.addBox(movieFragmentHeaderBox);
    }

    private jgy O000000o(final List<jjj> list) {
        return new jgy() {
            /* class _m_j.jkm.AnonymousClass2 */

            public final String getType() {
                return "mdat";
            }

            public final long getSize() {
                long j = 8;
                for (jjj O000000o2 : list) {
                    j += (long) O000000o2.O000000o().limit();
                }
                return j;
            }

            public final void getBox(WritableByteChannel writableByteChannel) throws IOException {
                long j = 8;
                for (jjj O000000o2 : list) {
                    j += (long) O000000o2.O000000o().limit();
                }
                ByteBuffer allocate = ByteBuffer.allocate(8);
                jla.O00000Oo(allocate, j);
                allocate.put(jhc.O000000o(getType()));
                writableByteChannel.write((ByteBuffer) allocate.rewind());
                for (jjj O000000o3 : list) {
                    writableByteChannel.write((ByteBuffer) O000000o3.O000000o().rewind());
                }
            }
        };
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        jgy[] f1908O000000o;
        long O00000Oo;

        public O000000o() {
        }
    }
}

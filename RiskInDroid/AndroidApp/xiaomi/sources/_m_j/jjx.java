package _m_j;

import _m_j.jke;
import _m_j.jki;
import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox;
import org.mp4parser.boxes.sampleentry.VisualSampleEntry;
import org.mp4parser.streaming.input.h264.spspps.SliceHeader;

public abstract class jjx extends jjw {
    private static final Logger LOG = Logger.getLogger(jjx.class.getName());
    protected List<ByteBuffer> buffered = new ArrayList();
    boolean configured;
    jke currentPictureParameterSet = null;
    jkh currentSeqParameterSet = null;
    List<jjj> decFrameBuffer = new ArrayList();
    List<jjj> decFrameBuffer2 = new ArrayList();
    int frametick = 0;
    protected O000000o fvnd = null;
    int max_dec_frame_buffering = 16;
    LinkedHashMap<Integer, jke> ppsIdToPps = new LinkedHashMap<>();
    LinkedHashMap<Integer, ByteBuffer> ppsIdToPpsBytes = new LinkedHashMap<>();
    protected jjy sliceNalUnitHeader;
    BlockingQueue<jkh> spsForConfig = new LinkedBlockingDeque();
    LinkedHashMap<Integer, jkh> spsIdToSps = new LinkedHashMap<>();
    LinkedHashMap<Integer, ByteBuffer> spsIdToSpsBytes = new LinkedHashMap<>();
    SampleDescriptionBox stsd;
    int timescale = 0;

    public void close() throws IOException {
    }

    public String getHandler() {
        return "vide";
    }

    public String getLanguage() {
        return "eng";
    }

    public static jjy getNalUnitHeader(ByteBuffer byteBuffer) {
        jjy jjy = new jjy();
        byte b = byteBuffer.get(0);
        jjy.f1890O000000o = (b >> 5) & 3;
        jjy.O00000Oo = b & 31;
        return jjy;
    }

    /* access modifiers changed from: protected */
    public void consumeNal(ByteBuffer byteBuffer) throws IOException {
        jjy nalUnitHeader = getNalUnitHeader(byteBuffer);
        switch (nalUnitHeader.O00000Oo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                O000000o o000000o = new O000000o(byteBuffer, nalUnitHeader.f1890O000000o, nalUnitHeader.O00000Oo);
                this.sliceNalUnitHeader = nalUnitHeader;
                O000000o o000000o2 = this.fvnd;
                if (o000000o2 != null) {
                    boolean z = true;
                    if (o000000o.O00000Oo == o000000o2.O00000Oo && o000000o.O00000o0 == o000000o2.O00000o0 && o000000o.O00000o == o000000o2.O00000o && ((!o000000o.O00000o || o000000o.O00000oO == o000000o2.O00000oO) && o000000o.O00000oo == o000000o2.O00000oo && (!(o000000o.O0000O0o == 0 && o000000o2.O0000O0o == 0 && (o000000o.O0000Oo0 != o000000o2.O0000Oo0 || o000000o.O0000OOo != o000000o2.O0000OOo)) && (!(o000000o.O0000O0o == 1 && o000000o2.O0000O0o == 1 && (o000000o.O0000Oo != o000000o2.O0000Oo || o000000o.O0000OoO != o000000o2.O0000OoO)) && o000000o.O0000Ooo == o000000o2.O0000Ooo && (!o000000o.O0000Ooo || !o000000o2.O0000Ooo || o000000o.O0000o00 == o000000o2.O0000o00))))) {
                        z = false;
                    }
                    if (z) {
                        LOG.finer("Wrapping up cause of first vcl nal is found");
                        pushSample(createSample(this.buffered, this.fvnd.f1889O000000o, this.sliceNalUnitHeader), false, false);
                        this.buffered.clear();
                    }
                }
                this.fvnd = o000000o;
                this.buffered.add(byteBuffer);
                return;
            case 6:
                if (this.fvnd != null) {
                    LOG.finer("Wrapping up cause of SEI after vcl marks new sample");
                    pushSample(createSample(this.buffered, this.fvnd.f1889O000000o, this.sliceNalUnitHeader), false, false);
                    this.buffered.clear();
                    this.fvnd = null;
                }
                this.buffered.add(byteBuffer);
                return;
            case 7:
                if (this.fvnd != null) {
                    LOG.finer("Wrapping up cause of SPS after vcl marks new sample");
                    pushSample(createSample(this.buffered, this.fvnd.f1889O000000o, this.sliceNalUnitHeader), false, false);
                    this.buffered.clear();
                    this.fvnd = null;
                }
                handleSPS(byteBuffer);
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                if (this.fvnd != null) {
                    LOG.finer("Wrapping up cause of PPS after vcl marks new sample");
                    pushSample(createSample(this.buffered, this.fvnd.f1889O000000o, this.sliceNalUnitHeader), false, false);
                    this.buffered.clear();
                    this.fvnd = null;
                }
                handlePPS(byteBuffer);
                return;
            case 9:
                if (this.fvnd != null) {
                    LOG.finer("Wrapping up cause of AU after vcl marks new sample");
                    pushSample(createSample(this.buffered, this.fvnd.f1889O000000o, this.sliceNalUnitHeader), false, false);
                    this.buffered.clear();
                    this.fvnd = null;
                }
                this.buffered.add(byteBuffer);
                return;
            case 10:
            case 11:
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            default:
                Logger logger = LOG;
                logger.warning("Unknown NAL unit type: " + nalUnitHeader.O00000Oo);
                return;
            case 13:
                throw new IOException("Sequence parameter set extension is not yet handled. Needs TLC.");
        }
    }

    /* access modifiers changed from: protected */
    public void pushSample(jjj jjj, boolean z, boolean z2) throws IOException {
        if (jjj != null) {
            this.decFrameBuffer.add(jjj);
        }
        if (z) {
            while (this.decFrameBuffer.size() > 0) {
                pushSample(null, false, true);
            }
        } else if (this.decFrameBuffer.size() - 1 > this.max_dec_frame_buffering || z2) {
            jjj remove = this.decFrameBuffer.remove(0);
            jjz jjz = (jjz) remove.O000000o(jjz.class);
            if (jjz == null) {
                this.sampleSink.O000000o(remove, this);
                return;
            }
            int i = 0;
            for (jjj O000000o2 : this.decFrameBuffer) {
                if (jjz.O000000o() > ((jjz) O000000o2.O000000o(jjz.class)).O000000o()) {
                    i++;
                }
            }
            for (jjj O000000o3 : this.decFrameBuffer2) {
                if (jjz.O000000o() < ((jjz) O000000o3.O000000o(jjz.class)).O000000o()) {
                    i--;
                }
            }
            this.decFrameBuffer2.add(remove);
            if (this.decFrameBuffer2.size() > this.max_dec_frame_buffering) {
                this.decFrameBuffer2.remove(0).O00000Oo(jjz.class);
            }
            remove.O000000o(jjn.O000000o((long) (i * this.frametick)));
            this.sampleSink.O000000o(remove, this);
        }
    }

    /* access modifiers changed from: protected */
    public jjr createSampleFlagsSampleExtension(jjy jjy, SliceHeader sliceHeader) {
        jjr jjr = new jjr();
        boolean z = true;
        if (jjy.f1890O000000o == 0) {
            jjr.O00000o = 2;
        } else {
            jjr.O00000o = 1;
        }
        if (sliceHeader.O00000Oo == SliceHeader.SliceType.I || sliceHeader.O00000Oo == SliceHeader.SliceType.SI) {
            jjr.O00000o0 = 2;
        } else {
            jjr.O00000o0 = 1;
        }
        if (5 == jjy.O00000Oo) {
            z = false;
        }
        jjr.O0000O0o = z;
        return jjr;
    }

    /* access modifiers changed from: protected */
    public jjz createPictureOrderCountType0SampleExtension(SliceHeader sliceHeader) {
        jjz jjz = null;
        if (sliceHeader.O0000o0.f1901O000000o == 0) {
            if (this.decFrameBuffer.size() > 0) {
                List<jjj> list = this.decFrameBuffer;
                jjz = (jjz) list.get(list.size() - 1).O000000o(jjz.class);
            }
            return new jjz(sliceHeader, jjz);
        } else if (sliceHeader.O0000o0.f1901O000000o == 1) {
            throw new RuntimeException("pic_order_cnt_type == 1 needs to be implemented");
        } else if (sliceHeader.O0000o0.f1901O000000o == 2) {
            return null;
        } else {
            throw new RuntimeException("I don't know sliceHeader.sps.pic_order_cnt_type of " + sliceHeader.O0000o0.f1901O000000o);
        }
    }

    /* access modifiers changed from: protected */
    public jjj createSample(List<ByteBuffer> list, SliceHeader sliceHeader, jjy jjy) throws IOException {
        int i;
        LOG.finer("Create Sample");
        configure();
        if (this.timescale == 0 || (i = this.frametick) == 0) {
            throw new IOException("Frame Rate needs to be configured either by hand or by SPS before samples can be created");
        }
        jju jju = new jju(list, (long) i);
        jju.O000000o(createSampleFlagsSampleExtension(jjy, sliceHeader));
        jju.O000000o(createPictureOrderCountType0SampleExtension(sliceHeader));
        return jju;
    }

    public void setFrametick(int i) {
        this.frametick = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ee, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0162 A[Catch:{ InterruptedException -> 0x01da }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0183 A[Catch:{ InterruptedException -> 0x01da }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a1 A[Catch:{ InterruptedException -> 0x01da }] */
    public synchronized void configure() {
        int i;
        int i2;
        int i3;
        if (!this.configured) {
            try {
                jkh poll = this.spsForConfig.poll(5, TimeUnit.SECONDS);
                if (poll == null) {
                    LOG.warning("Can't determine frame rate as no SPS became available in time");
                    return;
                }
                if (poll.f1901O000000o == 0 || poll.f1901O000000o == 1) {
                    addTrackExtension(new jjo());
                }
                int i4 = 16;
                int i5 = (poll.O0000o00 + 1) * 16;
                int i6 = 2;
                if (poll.O000O0o0) {
                    i6 = 1;
                }
                int i7 = (poll.O0000Ooo + 1) * 16 * i6;
                int i8 = 0;
                if (poll.O000O0o) {
                    if (!poll.O00oOooo) {
                        i2 = poll.O0000Oo0.O00000oO;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        i3 = poll.O0000Oo0.O00000oo;
                        i6 *= poll.O0000Oo0.O0000O0o;
                    } else {
                        i3 = 1;
                    }
                    i5 -= i3 * (poll.O000O0oO + poll.O000O0oo);
                    i7 -= i6 * (poll.O000OO00 + poll.O000OO0o);
                }
                VisualSampleEntry visualSampleEntry = new VisualSampleEntry("avc1");
                visualSampleEntry.setDataReferenceIndex(1);
                visualSampleEntry.setDepth(24);
                visualSampleEntry.setFrameCount(1);
                visualSampleEntry.setHorizresolution(72.0d);
                visualSampleEntry.setVertresolution(72.0d);
                if (((jjq) getTrackExtension(jjq.class)) == null) {
                    addTrackExtension(new jjq(i5, i7));
                }
                visualSampleEntry.setWidth(i5);
                visualSampleEntry.setHeight(i7);
                visualSampleEntry.setCompressorname("AVC Coding");
                AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
                avcConfigurationBox.setSequenceParameterSets(new ArrayList(this.spsIdToSpsBytes.values()));
                avcConfigurationBox.setPictureParameterSets(new ArrayList(this.ppsIdToPpsBytes.values()));
                avcConfigurationBox.setAvcLevelIndication(poll.O0000ooo);
                avcConfigurationBox.setAvcProfileIndication(poll.O0000o);
                avcConfigurationBox.setBitDepthLumaMinus8(poll.O0000o0);
                avcConfigurationBox.setBitDepthChromaMinus8(poll.O0000o0O);
                avcConfigurationBox.setChromaFormat(poll.O0000Oo0.O00000oO);
                avcConfigurationBox.setConfigurationVersion(1);
                avcConfigurationBox.setLengthSizeMinusOne(3);
                int i9 = (poll.O0000oO ? NotificationCompat.FLAG_HIGH_PRIORITY : 0) + (poll.O0000oOO ? 64 : 0) + (poll.O0000oOo ? 32 : 0);
                if (!poll.O0000oo0) {
                    i4 = 0;
                }
                avcConfigurationBox.setProfileCompatibility(i9 + i4 + (poll.O0000oo ? 8 : 0) + ((int) (poll.O0000oO0 & 3)));
                visualSampleEntry.addBox(avcConfigurationBox);
                this.stsd = new SampleDescriptionBox();
                this.stsd.addBox(visualSampleEntry);
                if (poll.O000OOOo != null) {
                    i = poll.O000OOOo.O0000oO0 >> 1;
                    int i10 = poll.O000OOOo.O0000o;
                    if (i != 0) {
                        if (i10 != 0) {
                            i8 = i10;
                            if (i8 > 0) {
                                Logger logger = LOG;
                                logger.warning("Frametick is " + i8 + ". That is suspicious.");
                            } else if (i / i8 > 100) {
                                Logger logger2 = LOG;
                                logger2.warning("Framerate is " + (i / i8) + ". That is suspicious.");
                            }
                            if (poll.O000OOOo.O0000ooO != null) {
                                this.max_dec_frame_buffering = poll.O000OOOo.O0000ooO.O0000O0o;
                            }
                        }
                    }
                    Logger logger3 = LOG;
                    logger3.warning("vuiParams contain invalid values: time_scale: " + i + " and frame_tick: " + i10 + ". Setting frame rate to 25fps");
                    i = 0;
                    if (i8 > 0) {
                    }
                    if (poll.O000OOOo.O0000ooO != null) {
                    }
                } else {
                    LOG.warning("Can't determine frame rate as SPS does not contain vuiParama");
                    i = 0;
                }
                if (this.timescale == 0) {
                    this.timescale = i;
                }
                if (this.frametick == 0) {
                    this.frametick = i8;
                }
                if (poll.f1901O000000o == 0) {
                    addTrackExtension(new jjo());
                } else if (poll.f1901O000000o == 1) {
                    throw new RuntimeException("Have not yet imlemented pic_order_cnt_type 1");
                }
                this.configured = true;
            } catch (InterruptedException e) {
                LOG.warning(e.getMessage());
                LOG.warning("Can't determine frame rate as no SPS became available in time");
            }
        }
    }

    public long getTimescale() {
        configure();
        return (long) this.timescale;
    }

    public void setTimescale(int i) {
        this.timescale = i;
    }

    public SampleDescriptionBox getSampleDescriptionBox() {
        configure();
        return this.stsd;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012c A[Catch:{ IOException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019e A[Catch:{ IOException -> 0x01c4 }] */
    public void handlePPS(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        boolean z = true;
        byteBuffer.position(1);
        try {
            jkb jkb = new jkb(byteBuffer);
            jke jke = new jke();
            jke.O00000oO = jkb.O00000Oo();
            jke.O00000oo = jkb.O00000Oo();
            jke.f1897O000000o = jkb.O00000o0();
            jke.O0000O0o = jkb.O00000o0();
            jke.O0000OOo = jkb.O00000Oo();
            if (jke.O0000OOo > 0) {
                jke.O0000Oo0 = jkb.O00000Oo();
                jke.O0000oO0 = new int[(jke.O0000OOo + 1)];
                jke.O0000oO = new int[(jke.O0000OOo + 1)];
                jke.O0000oOO = new int[(jke.O0000OOo + 1)];
                if (jke.O0000Oo0 == 0) {
                    for (int i = 0; i <= jke.O0000OOo; i++) {
                        jke.O0000oOO[i] = jkb.O00000Oo();
                    }
                } else if (jke.O0000Oo0 == 2) {
                    for (int i2 = 0; i2 < jke.O0000OOo; i2++) {
                        jke.O0000oO0[i2] = jkb.O00000Oo();
                        jke.O0000oO[i2] = jkb.O00000Oo();
                    }
                } else {
                    int i3 = 3;
                    if (!(jke.O0000Oo0 == 3 || jke.O0000Oo0 == 4)) {
                        if (jke.O0000Oo0 != 5) {
                            if (jke.O0000Oo0 == 6) {
                                if (jke.O0000OOo + 1 <= 4) {
                                    i3 = jke.O0000OOo + 1 > 2 ? 2 : 1;
                                }
                                int O00000Oo = jkb.O00000Oo();
                                jke.O0000oo0 = new int[(O00000Oo + 1)];
                                for (int i4 = 0; i4 <= O00000Oo; i4++) {
                                    jke.O0000oo0[i4] = (int) jkb.O000000o(i3);
                                }
                            }
                        }
                    }
                    jke.O0000oOo = jkb.O00000o0();
                    jke.O00000o = jkb.O00000Oo();
                }
            }
            jke.O00000Oo = jkb.O00000Oo();
            jke.O00000o0 = jkb.O00000Oo();
            jke.O0000Oo = jkb.O00000o0();
            jke.O0000OoO = (int) jkb.O000000o(2);
            jke.O0000Ooo = jkb.O00000o();
            jke.O0000o00 = jkb.O00000o();
            jke.O0000o0 = jkb.O00000o();
            jke.O0000o0O = jkb.O00000o0();
            jke.O0000o0o = jkb.O00000o0();
            jke.O0000o = jkb.O00000o0();
            if (jkb.O00000Oo == 8) {
                jkb.O000000o();
            }
            int i5 = 1 << ((8 - jkb.O00000Oo) - 1);
            boolean z2 = (((i5 << 1) - 1) & jkb.O00000o0) == i5;
            if (jkb.O00000o0 != -1) {
                if (jkb.O00000o == -1) {
                    if (!z2) {
                    }
                }
                if (z) {
                    jke.O0000oo = new jke.O000000o();
                    jke.O0000oo.f1898O000000o = jkb.O00000o0();
                    if (jkb.O00000o0()) {
                        for (int i6 = 0; i6 < ((jke.O0000oo.f1898O000000o ? 1 : 0) * true) + 6; i6++) {
                            if (jkb.O00000o0()) {
                                jke.O0000oo.O00000Oo.f1900O000000o = new jkf[8];
                                jke.O0000oo.O00000Oo.O00000Oo = new jkf[8];
                                if (i6 < 6) {
                                    jke.O0000oo.O00000Oo.f1900O000000o[i6] = jkf.O000000o(jkb, 16);
                                } else {
                                    jke.O0000oo.O00000Oo.O00000Oo[i6 - 6] = jkf.O000000o(jkb, 64);
                                }
                            }
                        }
                    }
                    jke.O0000oo.O00000o0 = jkb.O00000o();
                }
                this.currentPictureParameterSet = jke;
                byteBuffer2 = this.ppsIdToPpsBytes.get(Integer.valueOf(jke.O00000oO));
                if (byteBuffer2 != null) {
                    if (!byteBuffer2.equals(byteBuffer)) {
                        throw new RuntimeException("OMG - I got two SPS with same ID but different settings! (AVC3 is the solution)");
                    }
                }
                this.ppsIdToPpsBytes.put(Integer.valueOf(jke.O00000oO), byteBuffer);
                this.ppsIdToPps.put(Integer.valueOf(jke.O00000oO), jke);
            }
            z = false;
            if (z) {
            }
            this.currentPictureParameterSet = jke;
            byteBuffer2 = this.ppsIdToPpsBytes.get(Integer.valueOf(jke.O00000oO));
            if (byteBuffer2 != null) {
            }
            this.ppsIdToPpsBytes.put(Integer.valueOf(jke.O00000oO), byteBuffer);
            this.ppsIdToPps.put(Integer.valueOf(jke.O00000oO), jke);
        } catch (IOException e) {
            throw new RuntimeException("That's surprising to get IOException when working on ByteArrayInputStream", e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e9 A[Catch:{ IOException -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f0 A[Catch:{ IOException -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0143 A[Catch:{ IOException -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0159 A[Catch:{ IOException -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0177 A[Catch:{ IOException -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02a3 A[Catch:{ IOException -> 0x02ce }] */
    public void handleSPS(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        byteBuffer.position(1);
        try {
            jkb jkb = new jkb(byteBuffer);
            jkh jkh = new jkh();
            jkh.O0000o = (int) jkb.O000000o(8);
            jkh.O0000oO = jkb.O00000o0();
            jkh.O0000oOO = jkb.O00000o0();
            jkh.O0000oOo = jkb.O00000o0();
            jkh.O0000oo0 = jkb.O00000o0();
            jkh.O0000oo = jkb.O00000o0();
            jkh.O0000ooO = jkb.O00000o0();
            jkh.O0000oO0 = jkb.O000000o(2);
            jkh.O0000ooo = (int) jkb.O000000o(8);
            jkh.O00oOooO = jkb.O00000Oo();
            if (!(jkh.O0000o == 100 || jkh.O0000o == 110 || jkh.O0000o == 122)) {
                if (jkh.O0000o != 144) {
                    jkh.O0000Oo0 = jkc.O00000Oo;
                    jkh.O0000Oo = jkb.O00000Oo();
                    jkh.f1901O000000o = jkb.O00000Oo();
                    if (jkh.f1901O000000o != 0) {
                        jkh.O0000OoO = jkb.O00000Oo();
                    } else if (jkh.f1901O000000o == 1) {
                        jkh.O00000o0 = jkb.O00000o0();
                        jkh.O000O00o = jkb.O00000o();
                        jkh.O000O0OO = jkb.O00000o();
                        jkh.O000OOo = jkb.O00000Oo();
                        jkh.O000OO = new int[jkh.O000OOo];
                        for (int i = 0; i < jkh.O000OOo; i++) {
                            jkh.O000OO[i] = jkb.O00000o();
                        }
                    }
                    jkh.O000O0Oo = jkb.O00000Oo();
                    jkh.O00oOoOo = jkb.O00000o0();
                    jkh.O0000o00 = jkb.O00000Oo();
                    jkh.O0000Ooo = jkb.O00000Oo();
                    jkh.O000O0o0 = jkb.O00000o0();
                    if (!jkh.O000O0o0) {
                        jkh.O0000O0o = jkb.O00000o0();
                    }
                    jkh.O0000OOo = jkb.O00000o0();
                    jkh.O000O0o = jkb.O00000o0();
                    if (jkh.O000O0o) {
                        jkh.O000O0oO = jkb.O00000Oo();
                        jkh.O000O0oo = jkb.O00000Oo();
                        jkh.O000OO00 = jkb.O00000Oo();
                        jkh.O000OO0o = jkb.O00000Oo();
                    }
                    if (jkb.O00000o0()) {
                        jki jki = new jki();
                        jki.f1902O000000o = jkb.O00000o0();
                        if (jki.f1902O000000o) {
                            jki.O0000ooo = jka.O000000o((int) jkb.O000000o(8));
                            if (jki.O0000ooo == jka.f1893O000000o) {
                                jki.O00000Oo = (int) jkb.O000000o(16);
                                jki.O00000o0 = (int) jkb.O000000o(16);
                            }
                        }
                        jki.O00000o = jkb.O00000o0();
                        if (jki.O00000o) {
                            jki.O00000oO = jkb.O00000o0();
                        }
                        jki.O00000oo = jkb.O00000o0();
                        if (jki.O00000oo) {
                            jki.O0000O0o = (int) jkb.O000000o(3);
                            jki.O0000OOo = jkb.O00000o0();
                            jki.O0000Oo0 = jkb.O00000o0();
                            if (jki.O0000Oo0) {
                                jki.O0000Oo = (int) jkb.O000000o(8);
                                jki.O0000OoO = (int) jkb.O000000o(8);
                                jki.O0000Ooo = (int) jkb.O000000o(8);
                            }
                        }
                        jki.O0000o00 = jkb.O00000o0();
                        if (jki.O0000o00) {
                            jki.O0000o0 = jkb.O00000Oo();
                            jki.O0000o0O = jkb.O00000Oo();
                        }
                        jki.O0000o0o = jkb.O00000o0();
                        if (jki.O0000o0o) {
                            jki.O0000o = (int) jkb.O000000o(32);
                            jki.O0000oO0 = (int) jkb.O000000o(32);
                            jki.O0000oO = jkb.O00000o0();
                        }
                        boolean O00000o0 = jkb.O00000o0();
                        if (O00000o0) {
                            jki.O0000oo0 = jkh.O000000o(jkb);
                        }
                        boolean O00000o02 = jkb.O00000o0();
                        if (O00000o02) {
                            jki.O0000oo = jkh.O000000o(jkb);
                        }
                        if (O00000o0 || O00000o02) {
                            jki.O0000oOO = jkb.O00000o0();
                        }
                        jki.O0000oOo = jkb.O00000o0();
                        if (jkb.O00000o0()) {
                            jki.O0000ooO = new jki.O000000o();
                            jki.O0000ooO.f1903O000000o = jkb.O00000o0();
                            jki.O0000ooO.O00000Oo = jkb.O00000Oo();
                            jki.O0000ooO.O00000o0 = jkb.O00000Oo();
                            jki.O0000ooO.O00000o = jkb.O00000Oo();
                            jki.O0000ooO.O00000oO = jkb.O00000Oo();
                            jki.O0000ooO.O00000oo = jkb.O00000Oo();
                            jki.O0000ooO.O0000O0o = jkb.O00000Oo();
                        }
                        jkh.O000OOOo = jki;
                    }
                    this.currentSeqParameterSet = jkh;
                    byteBuffer2 = this.spsIdToSpsBytes.get(Integer.valueOf(jkh.O00oOooO));
                    if (byteBuffer2 != null) {
                        if (!byteBuffer2.equals(byteBuffer)) {
                            throw new RuntimeException("OMG - I got two SPS with same ID but different settings!");
                        }
                    }
                    this.spsIdToSpsBytes.put(Integer.valueOf(jkh.O00oOooO), byteBuffer);
                    this.spsIdToSps.put(Integer.valueOf(jkh.O00oOooO), jkh);
                    this.spsForConfig.add(jkh);
                }
            }
            jkh.O0000Oo0 = jkc.O000000o(jkb.O00000Oo());
            if (jkh.O0000Oo0 == jkc.O00000o) {
                jkh.O00oOooo = jkb.O00000o0();
            }
            jkh.O0000o0 = jkb.O00000Oo();
            jkh.O0000o0O = jkb.O00000Oo();
            jkh.O0000o0o = jkb.O00000o0();
            if (jkb.O00000o0()) {
                jkh.O000OOo0 = new jkg();
                for (int i2 = 0; i2 < 8; i2++) {
                    if (jkb.O00000o0()) {
                        jkh.O000OOo0.f1900O000000o = new jkf[8];
                        jkh.O000OOo0.O00000Oo = new jkf[8];
                        if (i2 < 6) {
                            jkh.O000OOo0.f1900O000000o[i2] = jkf.O000000o(jkb, 16);
                        } else {
                            jkh.O000OOo0.O00000Oo[i2 - 6] = jkf.O000000o(jkb, 64);
                        }
                    }
                }
            }
            jkh.O0000Oo = jkb.O00000Oo();
            jkh.f1901O000000o = jkb.O00000Oo();
            if (jkh.f1901O000000o != 0) {
            }
            jkh.O000O0Oo = jkb.O00000Oo();
            jkh.O00oOoOo = jkb.O00000o0();
            jkh.O0000o00 = jkb.O00000Oo();
            jkh.O0000Ooo = jkb.O00000Oo();
            jkh.O000O0o0 = jkb.O00000o0();
            if (!jkh.O000O0o0) {
            }
            jkh.O0000OOo = jkb.O00000o0();
            jkh.O000O0o = jkb.O00000o0();
            if (jkh.O000O0o) {
            }
            if (jkb.O00000o0()) {
            }
            this.currentSeqParameterSet = jkh;
            byteBuffer2 = this.spsIdToSpsBytes.get(Integer.valueOf(jkh.O00oOooO));
            if (byteBuffer2 != null) {
            }
            this.spsIdToSpsBytes.put(Integer.valueOf(jkh.O00oOooO), byteBuffer);
            this.spsIdToSps.put(Integer.valueOf(jkh.O00oOooO), jkh);
            this.spsForConfig.add(jkh);
        } catch (IOException e) {
            throw new RuntimeException("That's surprising to get IOException when working on ByteArrayInputStream", e);
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final SliceHeader f1889O000000o;
        int O00000Oo;
        boolean O00000o;
        int O00000o0;
        boolean O00000oO;
        int O00000oo;
        int O0000O0o;
        int O0000OOo;
        int O0000Oo;
        int O0000Oo0;
        int O0000OoO;
        boolean O0000Ooo;
        int O0000o00;

        public O000000o(ByteBuffer byteBuffer, int i, int i2) {
            SliceHeader sliceHeader = new SliceHeader(byteBuffer, jjx.this.spsIdToSps, jjx.this.ppsIdToPps, i2 == 5);
            this.f1889O000000o = sliceHeader;
            this.O00000Oo = sliceHeader.O00000oO;
            this.O00000o0 = sliceHeader.O00000o0;
            this.O00000o = sliceHeader.O00000oo;
            this.O00000oO = sliceHeader.O0000O0o;
            this.O00000oo = i;
            this.O0000O0o = jjx.this.spsIdToSps.get(Integer.valueOf(jjx.this.ppsIdToPps.get(Integer.valueOf(sliceHeader.O00000o0)).O00000oo)).f1901O000000o;
            this.O0000OOo = sliceHeader.O0000Oo;
            this.O0000Oo0 = sliceHeader.O0000Oo0;
            this.O0000Oo = sliceHeader.O0000OoO;
            this.O0000OoO = sliceHeader.O0000Ooo;
            this.O0000o00 = sliceHeader.O0000OOo;
        }
    }
}

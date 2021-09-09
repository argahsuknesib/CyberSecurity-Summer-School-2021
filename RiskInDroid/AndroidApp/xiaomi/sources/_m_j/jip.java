package _m_j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.AudioSpecificConfig;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.BitReaderBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.DecoderConfigDescriptor;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.SLConfigDescriptor;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;
import org.mp4parser.boxes.iso14496.part14.ESDescriptorBox;
import org.mp4parser.boxes.sampleentry.AudioSampleEntry;

public final class jip extends jhv {
    public static Map<Integer, Integer> O00000o = new HashMap();
    static Map<Integer, String> O00000oO;
    jih O00000oo;
    SampleDescriptionBox O0000O0o;
    long[] O0000OOo;
    int O0000Oo;
    O000000o O0000Oo0;
    long O0000OoO;
    long O0000Ooo;
    private List<jie> O0000o0;
    public jhx O0000o00;

    public final List<CompositionTimeToSample.Entry> O000000o() {
        return null;
    }

    public final long[] O00000Oo() {
        return null;
    }

    public final SubSampleInformationBox O00000o() {
        return null;
    }

    public final List<SampleDependencyTypeBox.Entry> O00000o0() {
        return null;
    }

    public final String O0000o00() {
        return "soun";
    }

    static {
        HashMap hashMap = new HashMap();
        O00000oO = hashMap;
        hashMap.put(1, "AAC Main");
        O00000oO.put(2, "AAC LC (Low Complexity)");
        O00000oO.put(3, "AAC SSR (Scalable Sample Rate)");
        O00000oO.put(4, "AAC LTP (Long Term Prediction)");
        O00000oO.put(5, "SBR (Spectral Band Replication)");
        O00000oO.put(6, "AAC Scalable");
        O00000oO.put(7, "TwinVQ");
        O00000oO.put(8, "CELP (Code Excited Linear Prediction)");
        O00000oO.put(9, "HXVC (Harmonic Vector eXcitation Coding)");
        O00000oO.put(10, "Reserved");
        O00000oO.put(11, "Reserved");
        O00000oO.put(12, "TTSI (Text-To-Speech Interface)");
        O00000oO.put(13, "Main Synthesis");
        O00000oO.put(14, "Wavetable Synthesis");
        O00000oO.put(15, "General MIDI");
        O00000oO.put(16, "Algorithmic Synthesis and Audio Effects");
        O00000oO.put(17, "ER (Error Resilient) AAC LC");
        O00000oO.put(18, "Reserved");
        O00000oO.put(19, "ER AAC LTP");
        O00000oO.put(20, "ER AAC Scalable");
        O00000oO.put(21, "ER TwinVQ");
        O00000oO.put(22, "ER BSAC (Bit-Sliced Arithmetic Coding)");
        O00000oO.put(23, "ER AAC LD (Low Delay)");
        O00000oO.put(24, "ER CELP");
        O00000oO.put(25, "ER HVXC");
        O00000oO.put(26, "ER HILN (Harmonic and Individual Lines plus Noise)");
        O00000oO.put(27, "ER Parametric");
        O00000oO.put(28, "SSC (SinuSoidal Coding)");
        O00000oO.put(29, "PS (Parametric Stereo)");
        O00000oO.put(30, "MPEG Surround");
        O00000oO.put(31, "(Escape value)");
        O00000oO.put(32, "Layer-1");
        O00000oO.put(33, "Layer-2");
        O00000oO.put(34, "Layer-3");
        O00000oO.put(35, "DST (Direct Stream Transfer)");
        O00000oO.put(36, "ALS (Audio Lossless)");
        O00000oO.put(37, "SLS (Scalable LosslesS)");
        O00000oO.put(38, "SLS non-core");
        O00000oO.put(39, "ER AAC ELD (Enhanced Low Delay)");
        O00000oO.put(40, "SMR (Symbolic Music Representation) Simple");
        O00000oO.put(41, "SMR Main");
        O00000oO.put(42, "USAC (Unified Speech and Audio Coding) (no SBR)");
        O00000oO.put(43, "SAOC (Spatial Audio Object Coding)");
        O00000oO.put(44, "LD MPEG Surround");
        O00000oO.put(45, "USAC");
        O00000o.put(96000, 0);
        O00000o.put(88200, 1);
        O00000o.put(64000, 2);
        O00000o.put(48000, 3);
        O00000o.put(44100, 4);
        O00000o.put(32000, 5);
        O00000o.put(24000, 6);
        O00000o.put(22050, 7);
        O00000o.put(16000, 8);
        O00000o.put(12000, 9);
        O00000o.put(11025, 10);
        O00000o.put(8000, 11);
        O00000o.put(0, 96000);
        O00000o.put(1, 88200);
        O00000o.put(2, 64000);
        O00000o.put(3, 48000);
        O00000o.put(4, 44100);
        O00000o.put(5, 32000);
        O00000o.put(6, 24000);
        O00000o.put(7, 22050);
        O00000o.put(8, 16000);
        O00000o.put(9, 12000);
        O00000o.put(10, 11025);
        O00000o.put(11, 8000);
    }

    public jip(jhx jhx) throws IOException {
        this(jhx, "eng");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(long[], long):void}
     arg types: [long[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(long[], long):void} */
    private jip(jhx jhx, String str) throws IOException {
        super(jhx.toString());
        this.O00000oo = new jih();
        this.O0000o00 = jhx;
        this.O0000o0 = new ArrayList();
        this.O0000Oo0 = O000000o(jhx);
        double d = (double) this.O0000Oo0.O00000oo;
        Double.isNaN(d);
        double d2 = d / 1024.0d;
        double size = (double) this.O0000o0.size();
        Double.isNaN(size);
        double d3 = size / d2;
        LinkedList linkedList = new LinkedList();
        Iterator<jie> it = this.O0000o0.iterator();
        long j = 0;
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            int O000000o2 = (int) it.next().O000000o();
            j += (long) O000000o2;
            linkedList.add(Integer.valueOf(O000000o2));
            while (((double) linkedList.size()) > d2) {
                linkedList.pop();
            }
            if (linkedList.size() == ((int) d2)) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    i += ((Integer) it2.next()).intValue();
                }
                double d4 = (double) i;
                Double.isNaN(d4);
                double size2 = (double) linkedList.size();
                Double.isNaN(size2);
                double d5 = ((d4 * 8.0d) / size2) * d2;
                if (d5 > ((double) this.O0000OoO)) {
                    this.O0000OoO = (long) ((int) d5);
                }
            }
        }
        double d6 = (double) (j * 8);
        Double.isNaN(d6);
        this.O0000Ooo = (long) ((int) (d6 / d3));
        this.O0000Oo = 1536;
        this.O0000O0o = new SampleDescriptionBox();
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry("mp4a");
        if (this.O0000Oo0.O0000O0o == 7) {
            audioSampleEntry.setChannelCount(8);
        } else {
            audioSampleEntry.setChannelCount(this.O0000Oo0.O0000O0o);
        }
        audioSampleEntry.setSampleRate((long) this.O0000Oo0.O00000oo);
        audioSampleEntry.setDataReferenceIndex(1);
        audioSampleEntry.setSampleSize(16);
        ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
        ESDescriptor eSDescriptor = new ESDescriptor();
        eSDescriptor.setEsId(0);
        SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
        sLConfigDescriptor.setPredefined(2);
        eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
        DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
        decoderConfigDescriptor.setObjectTypeIndication(64);
        decoderConfigDescriptor.setStreamType(5);
        decoderConfigDescriptor.setBufferSizeDB(this.O0000Oo);
        decoderConfigDescriptor.setMaxBitRate(this.O0000OoO);
        decoderConfigDescriptor.setAvgBitRate(this.O0000Ooo);
        AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
        audioSpecificConfig.setOriginalAudioObjectType(2);
        audioSpecificConfig.setSamplingFrequencyIndex(this.O0000Oo0.f1862O000000o);
        audioSpecificConfig.setChannelConfiguration(this.O0000Oo0.O0000O0o);
        decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
        eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
        eSDescriptorBox.setEsDescriptor(eSDescriptor);
        audioSampleEntry.addBox(eSDescriptorBox);
        this.O0000O0o.addBox(audioSampleEntry);
        this.O00000oo.O00000oO = new Date();
        this.O00000oo.O00000o = new Date();
        jih jih = this.O00000oo;
        jih.O00000Oo = str;
        jih.O0000Oo0 = 1.0f;
        jih.O00000o0 = (long) this.O0000Oo0.O00000oo;
        this.O0000OOo = new long[this.O0000o0.size()];
        Arrays.fill(this.O0000OOo, 1024L);
    }

    public final void close() throws IOException {
        this.O0000o00.close();
    }

    public final SampleDescriptionBox O0000OoO() {
        return this.O0000O0o;
    }

    public final long[] O0000Oo() {
        return this.O0000OOo;
    }

    public final jih O0000Ooo() {
        return this.O00000oo;
    }

    public final List<jie> O0000Oo0() {
        return this.O0000o0;
    }

    public final String toString() {
        return "AACTrackImpl{sampleRate=" + this.O0000Oo0.O00000oo + ", channelconfig=" + this.O0000Oo0.O0000O0o + '}';
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f1862O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        int O0000O0o;
        int O0000OOo;
        int O0000Oo;
        int O0000Oo0;
        int O0000OoO;
        int O0000Ooo;
        int O0000o0;
        int O0000o00;

        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final int O000000o() {
            return (this.O00000o == 0 ? 2 : 0) + 7;
        }
    }

    private O000000o O000000o(jhx jhx) throws IOException {
        O000000o o000000o = null;
        while (true) {
            O000000o o000000o2 = new O000000o();
            ByteBuffer allocate = ByteBuffer.allocate(7);
            while (true) {
                if (allocate.position() < 7) {
                    if (jhx.O000000o(allocate) == -1) {
                        o000000o2 = null;
                        break;
                    }
                } else {
                    BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) allocate.rewind());
                    if (bitReaderBuffer.readBits(12) == 4095) {
                        o000000o2.O00000Oo = bitReaderBuffer.readBits(1);
                        o000000o2.O00000o0 = bitReaderBuffer.readBits(2);
                        o000000o2.O00000o = bitReaderBuffer.readBits(1);
                        o000000o2.O00000oO = bitReaderBuffer.readBits(2) + 1;
                        o000000o2.f1862O000000o = bitReaderBuffer.readBits(4);
                        o000000o2.O00000oo = O00000o.get(Integer.valueOf(o000000o2.f1862O000000o)).intValue();
                        bitReaderBuffer.readBits(1);
                        o000000o2.O0000O0o = bitReaderBuffer.readBits(3);
                        o000000o2.O0000OOo = bitReaderBuffer.readBits(1);
                        o000000o2.O0000Oo0 = bitReaderBuffer.readBits(1);
                        o000000o2.O0000Oo = bitReaderBuffer.readBits(1);
                        o000000o2.O0000OoO = bitReaderBuffer.readBits(1);
                        o000000o2.O0000Ooo = bitReaderBuffer.readBits(13);
                        o000000o2.O0000o00 = bitReaderBuffer.readBits(11);
                        o000000o2.O0000o0 = bitReaderBuffer.readBits(2) + 1;
                        if (o000000o2.O0000o0 != 1) {
                            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
                        } else if (o000000o2.O00000o == 0) {
                            jhx.O000000o(ByteBuffer.allocate(2));
                        }
                    } else {
                        throw new IOException("Expected Start Word 0xfff");
                    }
                }
            }
            if (o000000o2 == null) {
                return o000000o;
            }
            if (o000000o == null) {
                o000000o = o000000o2;
            }
            final long O00000Oo = jhx.O00000Oo();
            final long O000000o2 = (long) (o000000o2.O0000Ooo - o000000o2.O000000o());
            this.O0000o0.add(new jie() {
                /* class _m_j.jip.AnonymousClass1 */

                public final void O000000o(WritableByteChannel writableByteChannel) throws IOException {
                    jip.this.O0000o00.O000000o(O00000Oo, O000000o2, writableByteChannel);
                }

                public final long O000000o() {
                    return O000000o2;
                }

                public final ByteBuffer O00000Oo() {
                    try {
                        return jip.this.O0000o00.O000000o(O00000Oo, O000000o2);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            jhx.O000000o((jhx.O00000Oo() + ((long) o000000o2.O0000Ooo)) - ((long) o000000o2.O000000o()));
        }
    }
}

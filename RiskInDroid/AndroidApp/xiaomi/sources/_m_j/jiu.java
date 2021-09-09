package _m_j;

import _m_j.jiq;
import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox;
import org.mp4parser.boxes.sampleentry.VisualSampleEntry;
import org.mp4parser.muxer.tracks.h264.SliceHeader;

public class jiu extends jiq {
    private static final Logger O000O0o = Logger.getLogger(jiu.class.getName());
    static final /* synthetic */ boolean O000O0o0 = (!jiu.class.desiredAssertionStatus());
    Map<Integer, ByteBuffer> O0000OoO;
    Map<Integer, jje> O0000Ooo;
    jjb O0000o;
    Map<Integer, jjb> O0000o0;
    Map<Integer, ByteBuffer> O0000o00;
    SampleDescriptionBox O0000o0O;
    jje O0000o0o;
    jjb O0000oO;
    jje O0000oO0;
    jlg<Integer, ByteBuffer> O0000oOO;
    jlg<Integer, ByteBuffer> O0000oOo;
    int[] O0000oo;
    int O0000oo0;
    int O0000ooO;
    int O0000ooo;
    long O000O00o;
    long O000O0OO;
    long O000O0Oo;
    private List<jie> O000O0oO;
    private int O000O0oo;
    private int O000OO;
    private int O000OO00;
    private long O000OO0o;
    private jiv O000OOOo;
    private String O000OOo;
    private boolean O000OOo0;
    long O00oOoOo;
    long O00oOooO;
    long O00oOooo;

    public final String O0000o00() {
        return "vide";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private jiu(jhx jhx, String str) throws IOException {
        super(jhx, (byte) 0);
        int i;
        int i2;
        int i3 = 0;
        this.O0000OoO = new HashMap();
        this.O0000Ooo = new HashMap();
        this.O0000o00 = new HashMap();
        this.O0000o0 = new HashMap();
        this.O0000o0o = null;
        this.O0000o = null;
        this.O0000oO0 = null;
        this.O0000oO = null;
        this.O0000oOO = new jlg<>();
        this.O0000oOo = new jlg<>();
        this.O0000oo0 = 0;
        this.O0000oo = new int[0];
        this.O0000ooO = 0;
        this.O0000ooo = 0;
        this.O00oOooO = 0;
        this.O00oOooo = 0;
        this.O000O00o = 0;
        this.O000O0OO = 0;
        this.O000O0Oo = 0;
        this.O00oOoOo = 0;
        this.O000OOo0 = true;
        this.O000OOo = "eng";
        this.O000OOo = str;
        this.O000OO0o = -1;
        this.O000OO = -1;
        jiq.O000000o o000000o = new jiq.O000000o(jhx);
        this.O000O0oO = new ArrayList();
        O00000Oo(o000000o);
        int i4 = 16;
        this.O000O0oo = (this.O0000o0o.O0000o00 + 1) * 16;
        int i5 = this.O0000o0o.O000O0o0 ? 1 : 2;
        this.O000OO00 = (this.O0000o0o.O0000Ooo + 1) * 16 * i5;
        if (this.O0000o0o.O000O0o) {
            if (!this.O0000o0o.O00oOooo) {
                i = this.O0000o0o.O0000Oo0.O00000oO;
            } else {
                i = 0;
            }
            if (i != 0) {
                i2 = this.O0000o0o.O0000Oo0.O00000oo;
                i5 *= this.O0000o0o.O0000Oo0.O0000O0o;
            } else {
                i2 = 1;
            }
            this.O000O0oo -= i2 * (this.O0000o0o.O000O0oO + this.O0000o0o.O000O0oo);
            this.O000OO00 -= i5 * (this.O0000o0o.O000OO00 + this.O0000o0o.O000OO0o);
        }
        this.O0000o0O = new SampleDescriptionBox();
        VisualSampleEntry visualSampleEntry = new VisualSampleEntry("avc1");
        visualSampleEntry.setDataReferenceIndex(1);
        visualSampleEntry.setDepth(24);
        visualSampleEntry.setFrameCount(1);
        visualSampleEntry.setHorizresolution(72.0d);
        visualSampleEntry.setVertresolution(72.0d);
        visualSampleEntry.setWidth(this.O000O0oo);
        visualSampleEntry.setHeight(this.O000OO00);
        visualSampleEntry.setCompressorname("AVC Coding");
        AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
        avcConfigurationBox.setSequenceParameterSets(new ArrayList(this.O0000OoO.values()));
        avcConfigurationBox.setPictureParameterSets(new ArrayList(this.O0000o00.values()));
        avcConfigurationBox.setAvcLevelIndication(this.O0000o0o.O0000ooo);
        avcConfigurationBox.setAvcProfileIndication(this.O0000o0o.O0000o);
        avcConfigurationBox.setBitDepthLumaMinus8(this.O0000o0o.O0000o0);
        avcConfigurationBox.setBitDepthChromaMinus8(this.O0000o0o.O0000o0O);
        avcConfigurationBox.setChromaFormat(this.O0000o0o.O0000Oo0.O00000oO);
        avcConfigurationBox.setConfigurationVersion(1);
        avcConfigurationBox.setLengthSizeMinusOne(3);
        avcConfigurationBox.setProfileCompatibility((this.O0000o0o.O0000oO ? NotificationCompat.FLAG_HIGH_PRIORITY : 0) + (this.O0000o0o.O0000oOO ? 64 : 0) + (this.O0000o0o.O0000oOo ? 32 : 0) + (!this.O0000o0o.O0000oo0 ? 0 : i4) + (this.O0000o0o.O0000oo ? 8 : i3) + ((int) (this.O0000o0o.O0000oO0 & 3)));
        visualSampleEntry.addBox(avcConfigurationBox);
        this.O0000o0O.addBox(visualSampleEntry);
        this.O0000Oo0.O00000oO = new Date();
        this.O0000Oo0.O00000o = new Date();
        this.O0000Oo0.O00000Oo = this.O000OOo;
        this.O0000Oo0.O00000o0 = this.O000OO0o;
        this.O0000Oo0.O0000O0o = (double) this.O000O0oo;
        this.O0000Oo0.O0000OOo = (double) this.O000OO00;
    }

    private jiu(jhx jhx, String str, byte b) throws IOException {
        this(jhx, str);
    }

    public jiu(jhx jhx) throws IOException {
        this(jhx, "eng", (byte) 0);
    }

    private static jit O000000o(ByteBuffer byteBuffer) {
        jit jit = new jit();
        byte b = byteBuffer.get(0);
        jit.f1865O000000o = (b >> 5) & 3;
        jit.O00000Oo = b & 31;
        return jit;
    }

    public final SampleDescriptionBox O0000OoO() {
        return this.O0000o0O;
    }

    public final List<jie> O0000Oo0() {
        return this.O000O0oO;
    }

    private boolean O00000Oo(jiq.O000000o o000000o) throws IOException {
        ArrayList arrayList = new ArrayList();
        O000000o o000000o2 = null;
        while (true) {
            ByteBuffer O000000o2 = O000000o(o000000o);
            boolean z = true;
            if (O000000o2 != null) {
                jit O000000o3 = O000000o(O000000o2);
                switch (O000000o3.O00000Oo) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        O000000o o000000o3 = new O000000o(O000000o2, O000000o3.f1865O000000o, O000000o3.O00000Oo);
                        if (o000000o2 != null) {
                            if (o000000o3.f1866O000000o == o000000o2.f1866O000000o && o000000o3.O00000Oo == o000000o2.O00000Oo && o000000o3.O00000o0 == o000000o2.O00000o0 && ((!o000000o3.O00000o0 || o000000o3.O00000o == o000000o2.O00000o) && o000000o3.O00000oO == o000000o2.O00000oO && (!(o000000o3.O00000oo == 0 && o000000o2.O00000oo == 0 && (o000000o3.O0000OOo != o000000o2.O0000OOo || o000000o3.O0000O0o != o000000o2.O0000O0o)) && (!(o000000o3.O00000oo == 1 && o000000o2.O00000oo == 1 && (o000000o3.O0000Oo0 != o000000o2.O0000Oo0 || o000000o3.O0000Oo != o000000o2.O0000Oo)) && o000000o3.O0000OoO == o000000o2.O0000OoO && (!o000000o3.O0000OoO || !o000000o2.O0000OoO || o000000o3.O0000Ooo == o000000o2.O0000Ooo))))) {
                                z = false;
                            }
                            if (z) {
                                O000O0o.finest("Wrapping up cause of first vcl nal is found");
                                O00000o0(arrayList);
                            }
                        }
                        arrayList.add((ByteBuffer) O000000o2.rewind());
                        o000000o2 = o000000o3;
                        break;
                    case 6:
                        if (o000000o2 != null) {
                            O000O0o.finest("Wrapping up cause of SEI after vcl marks new sample");
                            O00000o0(arrayList);
                            o000000o2 = null;
                        }
                        this.O000OOOo = new jiv(O000000o(new O00000Oo(O000000o2)), this.O0000oO0);
                        arrayList.add(O000000o2);
                        break;
                    case 7:
                        if (o000000o2 != null) {
                            O000O0o.finest("Wrapping up cause of SPS after vcl marks new sample");
                            O00000o0(arrayList);
                            o000000o2 = null;
                        }
                        ByteBuffer byteBuffer = (ByteBuffer) O000000o2.rewind();
                        InputStream O000000o4 = O000000o(new O00000Oo(byteBuffer));
                        O000000o4.read();
                        jje O000000o5 = jje.O000000o(O000000o4);
                        if (this.O0000o0o == null) {
                            this.O0000o0o = O000000o5;
                            if (this.O000OOo0) {
                                if (this.O0000o0o.O000OOOo != null) {
                                    this.O000OO0o = (long) (this.O0000o0o.O000OOOo.O0000oO0 >> 1);
                                    this.O000OO = this.O0000o0o.O000OOOo.O0000o;
                                    if (this.O000OO0o == 0 || this.O000OO == 0) {
                                        O000O0o.warning("vuiParams contain invalid values: time_scale: " + this.O000OO0o + " and frame_tick: " + this.O000OO + ". Setting frame rate to 25fps");
                                        this.O000OO0o = 90000;
                                        this.O000OO = 3600;
                                    }
                                    if (this.O000OO0o / ((long) this.O000OO) > 100) {
                                        O000O0o.warning("Framerate is " + (this.O000OO0o / ((long) this.O000OO)) + ". That is suspicious.");
                                    }
                                } else {
                                    O000O0o.warning("Can't determine frame rate. Guessing 25 fps");
                                    this.O000OO0o = 90000;
                                    this.O000OO = 3600;
                                }
                            }
                        }
                        this.O0000oO0 = O000000o5;
                        byteBuffer.rewind();
                        if (this.O0000OoO.get(Integer.valueOf(O000000o5.O00oOooO)) != null) {
                            this.O0000oOO.put(Integer.valueOf(this.O000O0oO.size()), byteBuffer);
                        }
                        this.O0000OoO.put(Integer.valueOf(O000000o5.O00oOooO), byteBuffer);
                        this.O0000Ooo.put(Integer.valueOf(O000000o5.O00oOooO), O000000o5);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        if (o000000o2 != null) {
                            O000O0o.finest("Wrapping up cause of PPS after vcl marks new sample");
                            O00000o0(arrayList);
                            o000000o2 = null;
                        }
                        ByteBuffer byteBuffer2 = (ByteBuffer) O000000o2.rewind();
                        O00000Oo o00000Oo = new O00000Oo(byteBuffer2);
                        o00000Oo.read();
                        jjb O000000o6 = jjb.O000000o(o00000Oo);
                        if (this.O0000o == null) {
                            this.O0000o = O000000o6;
                        }
                        this.O0000oO = O000000o6;
                        if (this.O0000o00.get(Integer.valueOf(O000000o6.O00000oO)) == null) {
                            this.O0000oOo.put(Integer.valueOf(this.O000O0oO.size()), byteBuffer2);
                        }
                        this.O0000o00.put(Integer.valueOf(O000000o6.O00000oO), byteBuffer2);
                        this.O0000o0.put(Integer.valueOf(O000000o6.O00000oO), O000000o6);
                        break;
                    case 9:
                        if (o000000o2 != null) {
                            O000O0o.finest("Wrapping up cause of AU after vcl marks new sample");
                            O00000o0(arrayList);
                            o000000o2 = null;
                        }
                        arrayList.add(O000000o2);
                        break;
                    case 10:
                    case 11:
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    default:
                        O000O0o.warning("Unknown NAL unit type: " + O000000o3.O00000Oo);
                        break;
                    case 13:
                        throw new RuntimeException("Sequence parameter set extension is not yet handled. Needs TLC.");
                }
            }
        }
        if (arrayList.size() > 0) {
            O00000o0(arrayList);
        }
        O0000OOo();
        this.O00000oO = new long[this.O000O0oO.size()];
        Arrays.fill(this.O00000oO, (long) this.O000OO);
        return true;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f1866O000000o;
        int O00000Oo;
        boolean O00000o;
        boolean O00000o0;
        int O00000oO;
        int O00000oo;
        int O0000O0o;
        int O0000OOo;
        int O0000Oo;
        int O0000Oo0;
        boolean O0000OoO;
        int O0000Ooo;

        public O000000o(ByteBuffer byteBuffer, int i, int i2) {
            SliceHeader sliceHeader = new SliceHeader(jiu.O000000o(new O00000Oo(byteBuffer)), jiu.this.O0000Ooo, jiu.this.O0000o0, i2 == 5);
            this.f1866O000000o = sliceHeader.O00000oO;
            this.O00000Oo = sliceHeader.O00000o0;
            this.O00000o0 = sliceHeader.O00000oo;
            this.O00000o = sliceHeader.O0000O0o;
            this.O00000oO = i;
            this.O00000oo = jiu.this.O0000Ooo.get(Integer.valueOf(jiu.this.O0000o0.get(Integer.valueOf(sliceHeader.O00000o0)).O00000oo)).f1878O000000o;
            this.O0000O0o = sliceHeader.O0000Oo;
            this.O0000OOo = sliceHeader.O0000Oo0;
            this.O0000Oo0 = sliceHeader.O0000OoO;
            this.O0000Oo = sliceHeader.O0000Ooo;
            this.O0000Ooo = sliceHeader.O0000OOo;
        }
    }

    private void O0000OOo() {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < this.O0000oo.length) {
            int i4 = 0;
            int i5 = Integer.MAX_VALUE;
            for (int max = Math.max(0, i - 128); max < Math.min(this.O0000oo.length, i + NotificationCompat.FLAG_HIGH_PRIORITY); max++) {
                int[] iArr = this.O0000oo;
                if (iArr[max] > i3 && iArr[max] < i5) {
                    i5 = iArr[max];
                    i4 = max;
                }
            }
            int[] iArr2 = this.O0000oo;
            int i6 = iArr2[i4];
            iArr2[i4] = i2;
            i++;
            i3 = i6;
            i2++;
        }
        for (int i7 = 0; i7 < this.O0000oo.length; i7++) {
            this.O00000oo.add(new CompositionTimeToSample.Entry(1, this.O0000oo[i7] - i7));
        }
        this.O0000oo = new int[0];
    }

    private static long O00000Oo(List<ByteBuffer> list) {
        long j = 0;
        for (ByteBuffer remaining : list) {
            j += (long) remaining.remaining();
        }
        return j;
    }

    private void O00000o0(List<ByteBuffer> list) throws IOException {
        int i;
        SampleDependencyTypeBox.Entry entry = new SampleDependencyTypeBox.Entry(0);
        jit jit = null;
        ByteBuffer byteBuffer = null;
        boolean z = false;
        for (ByteBuffer next : list) {
            jit O000000o2 = O000000o(next);
            int i2 = O000000o2.O00000Oo;
            if (!(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4)) {
                if (i2 == 5) {
                    z = true;
                }
            }
            byteBuffer = next;
            jit = O000000o2;
        }
        if (jit == null) {
            O000O0o.warning("Sample without Slice");
        } else if (O000O0o0 || byteBuffer != null) {
            if (z) {
                O0000OOo();
            }
            SliceHeader sliceHeader = new SliceHeader(O000000o(new O00000Oo(byteBuffer)), this.O0000Ooo, this.O0000o0, z);
            if (sliceHeader.O00000Oo == SliceHeader.SliceType.I || sliceHeader.O00000Oo == SliceHeader.SliceType.SI) {
                this.O000O0Oo += O00000Oo(list);
                this.O00oOoOo++;
            } else if (sliceHeader.O00000Oo == SliceHeader.SliceType.P || sliceHeader.O00000Oo == SliceHeader.SliceType.SP) {
                this.O00oOooO += O00000Oo(list);
                this.O00oOooo++;
            } else if (sliceHeader.O00000Oo == SliceHeader.SliceType.B) {
                this.O000O00o += O00000Oo(list);
                this.O000O0OO++;
            } else {
                throw new RuntimeException("_sdjlfd");
            }
            if (jit.f1865O000000o == 0) {
                entry.setSampleIsDependedOn(2);
            } else {
                entry.setSampleIsDependedOn(1);
            }
            if (sliceHeader.O00000Oo == SliceHeader.SliceType.I || sliceHeader.O00000Oo == SliceHeader.SliceType.SI) {
                entry.setSampleDependsOn(2);
            } else {
                entry.setSampleDependsOn(1);
            }
            jie O000000o3 = O000000o(list);
            list.clear();
            jiv jiv = this.O000OOOo;
            if (jiv == null || jiv.O0000o0 == 0) {
                this.O0000oo0 = 0;
            }
            if (sliceHeader.O0000o0.f1878O000000o == 0) {
                int i3 = 1 << (sliceHeader.O0000o0.O0000OoO + 4);
                int i4 = sliceHeader.O0000Oo0;
                int i5 = this.O0000ooO;
                if (i4 >= i5 || i5 - i4 < i3 / 2) {
                    int i6 = this.O0000ooO;
                    if (i4 <= i6 || i4 - i6 <= i3 / 2) {
                        i = this.O0000ooo;
                    } else {
                        i = this.O0000ooo - i3;
                    }
                } else {
                    i = this.O0000ooo + i3;
                }
                this.O0000oo = jlc.O000000o(this.O0000oo, i + i4);
                this.O0000ooO = i4;
                this.O0000ooo = i;
            } else if (sliceHeader.O0000o0.f1878O000000o == 1) {
                throw new RuntimeException("pic_order_cnt_type == 1 needs to be implemented");
            } else if (sliceHeader.O0000o0.f1878O000000o == 2) {
                this.O0000oo = jlc.O000000o(this.O0000oo, this.O000O0oO.size());
            }
            this.O0000O0o.add(entry);
            this.O0000oo0++;
            this.O000O0oO.add(O000000o3);
            if (z) {
                this.O0000OOo.add(Integer.valueOf(this.O000O0oO.size()));
            }
        } else {
            throw new AssertionError();
        }
    }

    public class O00000Oo extends InputStream {
        private final ByteBuffer O00000Oo;

        public O00000Oo(ByteBuffer byteBuffer) {
            this.O00000Oo = byteBuffer.duplicate();
        }

        public final int read() throws IOException {
            if (!this.O00000Oo.hasRemaining()) {
                return -1;
            }
            return this.O00000Oo.get() & 255;
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.O00000Oo.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, this.O00000Oo.remaining());
            this.O00000Oo.get(bArr, i, min);
            return min;
        }
    }
}

package _m_j;

import com.google.android.exoplayer2.C;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class jiv {

    /* renamed from: O000000o  reason: collision with root package name */
    int f1868O000000o = 0;
    int O00000Oo = 0;
    int O00000o;
    boolean O00000o0;
    int O00000oO;
    boolean O00000oo;
    int O0000O0o;
    int O0000OOo;
    int O0000Oo;
    int O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    int O0000o;
    int O0000o0;
    int O0000o00;
    int O0000o0O;
    int O0000o0o;
    int O0000oO;
    int O0000oO0;
    jje O0000oOO;

    public jiv(InputStream inputStream, jje jje) throws IOException {
        int i;
        jje jje2 = jje;
        boolean z = false;
        this.O0000oOO = jje2;
        inputStream.read();
        int available = inputStream.available();
        int i2 = 0;
        while (i2 < available) {
            this.f1868O000000o = z ? 1 : 0;
            this.O00000Oo = z;
            int read = inputStream.read();
            while (true) {
                i2++;
                if (read == 255) {
                    this.f1868O000000o += read;
                    read = inputStream.read();
                } else {
                    this.f1868O000000o += read;
                    int read2 = inputStream.read();
                    while (true) {
                        i2++;
                        if (read2 == 255) {
                            this.O00000Oo += read2;
                            read2 = inputStream.read();
                        } else {
                            this.O00000Oo += read2;
                            if (available - i2 >= this.O00000Oo) {
                                if (this.f1868O000000o != 1) {
                                    for (int i3 = 0; i3 < this.O00000Oo; i3++) {
                                        inputStream.read();
                                        i2++;
                                    }
                                } else if (jje2.O000OOOo == null || (jje2.O000OOOo.O0000oo0 == null && jje2.O000OOOo.O0000oo == null && !jje2.O000OOOo.O0000oOo)) {
                                    for (int i4 = 0; i4 < this.O00000Oo; i4++) {
                                        inputStream.read();
                                        i2++;
                                    }
                                } else {
                                    byte[] bArr = new byte[this.O00000Oo];
                                    inputStream.read(bArr);
                                    i2 += this.O00000Oo;
                                    jjh jjh = new jjh(new ByteArrayInputStream(bArr));
                                    if (jje2.O000OOOo.O0000oo0 == null && jje2.O000OOOo.O0000oo == null) {
                                        this.O00000o0 = z;
                                    } else {
                                        this.O00000o0 = true;
                                        this.O00000o = jjh.O00000Oo(jje2.O000OOOo.O0000oo0.O0000OOo + 1, "SEI: cpb_removal_delay");
                                        this.O00000oO = jjh.O00000Oo(jje2.O000OOOo.O0000oo0.O0000Oo0 + 1, "SEI: dpb_removal_delay");
                                    }
                                    if (jje2.O000OOOo.O0000oOo) {
                                        this.O0000O0o = jjh.O00000Oo(4, "SEI: pic_struct");
                                        switch (this.O0000O0o) {
                                            case 3:
                                            case 4:
                                            case 7:
                                                i = 2;
                                                break;
                                            case 5:
                                            case 6:
                                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                                i = 3;
                                                break;
                                            default:
                                                i = 1;
                                                break;
                                        }
                                        for (int i5 = 0; i5 < i; i5++) {
                                            this.O00000oo = jjh.O00000o0("pic_timing SEI: clock_timestamp_flag[" + i5 + "]");
                                            if (this.O00000oo) {
                                                this.O0000OOo = jjh.O00000Oo(2, "pic_timing SEI: ct_type");
                                                this.O0000Oo0 = jjh.O00000Oo(1, "pic_timing SEI: nuit_field_based_flag");
                                                this.O0000Oo = jjh.O00000Oo(5, "pic_timing SEI: counting_type");
                                                this.O0000OoO = jjh.O00000Oo(1, "pic_timing SEI: full_timestamp_flag");
                                                this.O0000Ooo = jjh.O00000Oo(1, "pic_timing SEI: discontinuity_flag");
                                                this.O0000o00 = jjh.O00000Oo(1, "pic_timing SEI: cnt_dropped_flag");
                                                this.O0000o0 = jjh.O00000Oo(8, "pic_timing SEI: n_frames");
                                                if (this.O0000OoO == 1) {
                                                    this.O0000o0O = jjh.O00000Oo(6, "pic_timing SEI: seconds_value");
                                                    this.O0000o0o = jjh.O00000Oo(6, "pic_timing SEI: minutes_value");
                                                    this.O0000o = jjh.O00000Oo(5, "pic_timing SEI: hours_value");
                                                } else if (jjh.O00000o0("pic_timing SEI: seconds_flag")) {
                                                    this.O0000o0O = jjh.O00000Oo(6, "pic_timing SEI: seconds_value");
                                                    if (jjh.O00000o0("pic_timing SEI: minutes_flag")) {
                                                        this.O0000o0o = jjh.O00000Oo(6, "pic_timing SEI: minutes_value");
                                                        if (jjh.O00000o0("pic_timing SEI: hours_flag")) {
                                                            this.O0000o = jjh.O00000Oo(5, "pic_timing SEI: hours_value");
                                                        }
                                                    }
                                                }
                                                if (jje2.O000OOOo.O0000oo0 != null) {
                                                    this.O0000oO0 = jje2.O000OOOo.O0000oo0.O0000Oo;
                                                } else if (jje2.O000OOOo.O0000oo != null) {
                                                    this.O0000oO0 = jje2.O000OOOo.O0000oo.O0000Oo;
                                                } else {
                                                    this.O0000oO0 = 24;
                                                }
                                                this.O0000oO = jjh.O00000Oo(24, "pic_timing SEI: time_offset");
                                            }
                                        }
                                    }
                                }
                                z = false;
                            } else {
                                i2 = available;
                            }
                        }
                    }
                }
            }
        }
    }

    public final String toString() {
        String str = "SEIMessage{payloadType=" + this.f1868O000000o + ", payloadSize=" + this.O00000Oo;
        if (this.f1868O000000o == 1) {
            if (!(this.O0000oOO.O000OOOo.O0000oo0 == null && this.O0000oOO.O000OOOo.O0000oo == null)) {
                str = str + ", cpb_removal_delay=" + this.O00000o + ", dpb_removal_delay=" + this.O00000oO;
            }
            if (this.O0000oOO.O000OOOo.O0000oOo) {
                str = str + ", pic_struct=" + this.O0000O0o;
                if (this.O00000oo) {
                    str = str + ", ct_type=" + this.O0000OOo + ", nuit_field_based_flag=" + this.O0000Oo0 + ", counting_type=" + this.O0000Oo + ", full_timestamp_flag=" + this.O0000OoO + ", discontinuity_flag=" + this.O0000Ooo + ", cnt_dropped_flag=" + this.O0000o00 + ", n_frames=" + this.O0000o0 + ", seconds_value=" + this.O0000o0O + ", minutes_value=" + this.O0000o0o + ", hours_value=" + this.O0000o + ", time_offset_length=" + this.O0000oO0 + ", time_offset=" + this.O0000oO;
                }
            }
        }
        return str + '}';
    }
}

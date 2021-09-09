package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ach extends xx<aci> {
    public ach(aci aci) {
        super(aci);
    }

    public final String O000000o(int i) {
        if (i == 276) {
            Integer O00000o0 = ((aci) this.f2602O000000o).O00000o0(276);
            if (O00000o0 == null) {
                return null;
            }
            switch (O00000o0.intValue()) {
                case 0:
                    return "No ObjectData";
                case 1:
                    return "IPTC-NAA Digital Newsphoto Parameter Record";
                case 2:
                    return "IPTC7901 Recommended Message Format";
                case 3:
                    return "Tagged Image File Format (Adobe/Aldus Image data)";
                case 4:
                    return "Illustrator (Adobe Graphics data)";
                case 5:
                    return "AppleSingle (Apple Computer Inc)";
                case 6:
                    return "NAA 89-3 (ANPA 1312)";
                case 7:
                    return "MacBinary II";
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return "IPTC Unstructured Character Oriented File Format (UCOFF)";
                case 9:
                    return "United Press International ANPA 1312 variant";
                case 10:
                    return "United Press International Down-Load Message";
                case 11:
                    return "JPEG File Interchange (JFIF)";
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return "Photo-CD Image-Pac (Eastman Kodak)";
                case 13:
                    return "Bit Mapped Graphics File [.BMP] (Microsoft)";
                case 14:
                    return "Digital Audio File [.WAV] (Microsoft & Creative Labs)";
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    return "Audio plus Moving Video [.AVI] (Microsoft)";
                case 16:
                    return "PC DOS/Windows Executable Files [.COM][.EXE]";
                case 17:
                    return "Compressed Binary File [.ZIP] (PKWare Inc)";
                case 18:
                    return "Audio Interchange File Format AIFF (Apple Computer Inc)";
                case 19:
                    return "RIFF Wave (Microsoft Corporation)";
                case 20:
                    return "Freehand (Macromedia/Aldus)";
                case 21:
                    return "Hypertext Markup Language [.HTML] (The Internet Society)";
                case 22:
                    return "MPEG 2 Audio Layer 2 (Musicom), ISO/IEC";
                case 23:
                    return "MPEG 2 Audio Layer 3, ISO/IEC";
                case 24:
                    return "Portable Document File [.PDF] Adobe";
                case 25:
                    return "News Industry Text Format (NITF)";
                case 26:
                    return "Tape Archive [.TAR]";
                case 27:
                    return "Tidningarnas Telegrambyra NITF version (TTNITF DTD)";
                case 28:
                    return "Ritzaus Bureau NITF version (RBNITF DTD)";
                case 29:
                    return "Corel Draw [.CDR]";
                default:
                    return String.format("Unknown (%d)", O00000o0);
            }
        } else if (i == 326) {
            return O00000oo(326);
        } else {
            if (i == 336) {
                return O0000O0o(336);
            }
            if (i == 537) {
                String[] O00000o = ((aci) this.f2602O000000o).O00000o(537);
                if (O00000o == null) {
                    return null;
                }
                int i2 = 0;
                for (String length : O00000o) {
                    i2 += length.length() + 1;
                }
                StringBuilder sb = new StringBuilder(i2);
                boolean z = true;
                for (String str : O00000o) {
                    if (!z) {
                        sb.append(";");
                    } else {
                        z = false;
                    }
                    sb.append((CharSequence) str);
                }
                return sb.toString();
            } else if (i == 542) {
                return O00000oo(542);
            } else {
                if (i == 547) {
                    return O0000O0o(547);
                }
                if (i == 559) {
                    return O00000oo(559);
                }
                if (i == 567) {
                    return O00000oo(567);
                }
                if (i == 572) {
                    return O0000O0o(572);
                }
                if (i == 549) {
                    return O00000oo(549);
                }
                if (i == 550) {
                    return O0000O0o(550);
                }
                if (i == 574) {
                    return O00000oo(574);
                }
                if (i != 575) {
                    return super.O000000o(i);
                }
                return O0000O0o(575);
            }
        }
    }

    private String O00000oo(int i) {
        String O0000o0 = ((aci) this.f2602O000000o).O0000o0(i);
        if (O0000o0 == null) {
            return null;
        }
        if (O0000o0.length() != 8) {
            return O0000o0;
        }
        return O0000o0.substring(0, 4) + ':' + O0000o0.substring(4, 6) + ':' + O0000o0.substring(6);
    }

    private String O0000O0o(int i) {
        String O0000o0 = ((aci) this.f2602O000000o).O0000o0(i);
        if (O0000o0 == null) {
            return null;
        }
        if (O0000o0.length() != 6 && O0000o0.length() != 11) {
            return O0000o0;
        }
        return O0000o0.substring(0, 2) + ':' + O0000o0.substring(2, 4) + ':' + O0000o0.substring(4);
    }
}

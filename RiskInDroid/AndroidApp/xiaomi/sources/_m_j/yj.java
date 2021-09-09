package _m_j;

import _m_j.xr;
import com.drew.lang.Rational;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public abstract class yj<T extends xr> extends xx<T> {
    private final boolean O00000o0 = true;

    public yj(T t) {
        super(t);
    }

    public String O000000o(int i) {
        String str;
        String str2;
        String str3 = "unit";
        switch (i) {
            case 1:
                String O0000o0 = this.f2602O000000o.O0000o0(1);
                if (O0000o0 == null) {
                    return null;
                }
                if ("R98".equalsIgnoreCase(O0000o0.trim())) {
                    return "Recommended Exif Interoperability Rules (ExifR98)";
                }
                return "Unknown (" + O0000o0 + ")";
            case 2:
                return O000000o(2, 2);
            case 254:
                return O000000o(254, 0, "Full-resolution image", "Reduced-resolution image", "Single page of multi-page image", "Single page of multi-page reduced-resolution image", "Transparency mask", "Transparency mask of reduced-resolution image", "Transparency mask of multi-page image", "Transparency mask of reduced-resolution multi-page image");
            case 255:
                return O000000o(255, 1, "Full-resolution image", "Reduced-resolution image", "Single page of multi-page image");
            case 256:
                String O0000o02 = this.f2602O000000o.O0000o0(256);
                if (O0000o02 == null) {
                    return null;
                }
                return O0000o02 + " pixels";
            case 257:
                String O0000o03 = this.f2602O000000o.O0000o0(257);
                if (O0000o03 == null) {
                    return null;
                }
                return O0000o03 + " pixels";
            case 258:
                String O0000o04 = this.f2602O000000o.O0000o0(258);
                if (O0000o04 == null) {
                    return null;
                }
                return O0000o04 + " bits/component/pixel";
            case 259:
                Integer O00000o02 = this.f2602O000000o.O00000o0(259);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue = O00000o02.intValue();
                if (intValue == 32766) {
                    return "Next";
                }
                if (intValue == 32767) {
                    return "Sony ARW Compressed";
                }
                switch (intValue) {
                    case 1:
                        return "Uncompressed";
                    case 2:
                        return "CCITT 1D";
                    case 3:
                        return "T4/Group 3 Fax";
                    case 4:
                        return "T6/Group 4 Fax";
                    case 5:
                        return "LZW";
                    case 6:
                        return "JPEG (old-style)";
                    case 7:
                        return "JPEG";
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        return "Adobe Deflate";
                    case 9:
                        return "JBIG B&W";
                    case 10:
                        return "JBIG Color";
                    default:
                        switch (intValue) {
                            case 99:
                                return "JPEG";
                            case 262:
                                return "Kodak 262";
                            case 32809:
                                return "Thunderscan";
                            case 32867:
                                return "Kodak KDC Compressed";
                            case 34661:
                                return "JBIG";
                            case 34715:
                                return "JBIG2 TIFF FX";
                            case 34892:
                                return "Lossy JPEG";
                            case 65000:
                                return "Kodak DCR Compressed";
                            case 65535:
                                return "Pentax PEF Compressed";
                            default:
                                switch (intValue) {
                                    case 32769:
                                        return "Packed RAW";
                                    case 32770:
                                        return "Samsung SRW Compressed";
                                    case 32771:
                                        return "CCIRLEW";
                                    case 32772:
                                        return "Samsung SRW Compressed 2";
                                    case 32773:
                                        return "PackBits";
                                    default:
                                        switch (intValue) {
                                            case 32895:
                                                return "IT8CTPAD";
                                            case 32896:
                                                return "IT8LW";
                                            case 32897:
                                                return "IT8MP";
                                            case 32898:
                                                return "IT8BL";
                                            default:
                                                switch (intValue) {
                                                    case 32908:
                                                        return "PixarFilm";
                                                    case 32909:
                                                        return "PixarLog";
                                                    default:
                                                        switch (intValue) {
                                                            case 32946:
                                                                return "Deflate";
                                                            case 32947:
                                                                return "DCS";
                                                            default:
                                                                switch (intValue) {
                                                                    case 34676:
                                                                        return "SGILog";
                                                                    case 34677:
                                                                        return "SGILog24";
                                                                    default:
                                                                        switch (intValue) {
                                                                            case 34712:
                                                                                return "JPEG 2000";
                                                                            case 34713:
                                                                                return "Nikon NEF Compressed";
                                                                            default:
                                                                                switch (intValue) {
                                                                                    case 34718:
                                                                                        return "Microsoft Document Imaging (MDI) Binary Level Codec";
                                                                                    case 34719:
                                                                                        return "Microsoft Document Imaging (MDI) Progressive Transform Codec";
                                                                                    case 34720:
                                                                                        return "Microsoft Document Imaging (MDI) Vector";
                                                                                    default:
                                                                                        return "Unknown (" + O00000o02 + ")";
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
            case 262:
                Integer O00000o03 = this.f2602O000000o.O00000o0(262);
                if (O00000o03 == null) {
                    return null;
                }
                int intValue2 = O00000o03.intValue();
                if (intValue2 == 32803) {
                    return "Color Filter Array";
                }
                if (intValue2 == 32892) {
                    return "Linear Raw";
                }
                switch (intValue2) {
                    case 0:
                        return "WhiteIsZero";
                    case 1:
                        return "BlackIsZero";
                    case 2:
                        return "RGB";
                    case 3:
                        return "RGB Palette";
                    case 4:
                        return "Transparency Mask";
                    case 5:
                        return "CMYK";
                    case 6:
                        return "YCbCr";
                    default:
                        switch (intValue2) {
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                return "CIELab";
                            case 9:
                                return "ICCLab";
                            case 10:
                                return "ITULab";
                            default:
                                switch (intValue2) {
                                    case 32844:
                                        return "Pixar LogL";
                                    case 32845:
                                        return "Pixar LogLuv";
                                    default:
                                        return "Unknown colour space";
                                }
                        }
                }
            case 263:
                return O000000o(263, 1, "No dithering or halftoning", "Ordered dither or halftone", "Randomized dither");
            case 266:
                return O000000o(266, 1, "Normal", "Reversed");
            case 274:
                return super.O00000oO();
            case 277:
                String O0000o05 = this.f2602O000000o.O0000o0(277);
                if (O0000o05 == null) {
                    return null;
                }
                return O0000o05 + " samples/pixel";
            case 278:
                String O0000o06 = this.f2602O000000o.O0000o0(278);
                if (O0000o06 == null) {
                    return null;
                }
                return O0000o06 + " rows/strip";
            case 279:
                String O0000o07 = this.f2602O000000o.O0000o0(279);
                if (O0000o07 == null) {
                    return null;
                }
                return O0000o07 + " bytes";
            case 282:
                Rational O0000Ooo = this.f2602O000000o.O0000Ooo(282);
                if (O0000Ooo == null) {
                    return null;
                }
                String O0000O0o = O0000O0o();
                Object[] objArr = new Object[2];
                objArr[0] = O0000Ooo.O000000o(true);
                if (O0000O0o != null) {
                    str3 = O0000O0o.toLowerCase();
                }
                objArr[1] = str3;
                return String.format("%s dots per %s", objArr);
            case 283:
                Rational O0000Ooo2 = this.f2602O000000o.O0000Ooo(283);
                if (O0000Ooo2 == null) {
                    return null;
                }
                String O0000O0o2 = O0000O0o();
                Object[] objArr2 = new Object[2];
                objArr2[0] = O0000Ooo2.O000000o(true);
                if (O0000O0o2 != null) {
                    str3 = O0000O0o2.toLowerCase();
                }
                objArr2[1] = str3;
                return String.format("%s dots per %s", objArr2);
            case 284:
                return O000000o(284, 1, "Chunky (contiguous for each subsampling pixel)", "Separate (Y-plane/Cb-plane/Cr-plane format)");
            case 296:
                return O0000O0o();
            case 512:
                Integer O00000o04 = this.f2602O000000o.O00000o0(512);
                if (O00000o04 == null) {
                    return null;
                }
                int intValue3 = O00000o04.intValue();
                if (intValue3 == 1) {
                    return "Baseline";
                }
                if (intValue3 == 14) {
                    return "Lossless";
                }
                return "Unknown (" + O00000o04 + ")";
            case 530:
                int[] O00000oo = this.f2602O000000o.O00000oo(530);
                if (O00000oo == null || O00000oo.length < 2) {
                    return null;
                }
                if (O00000oo[0] == 2 && O00000oo[1] == 1) {
                    return "YCbCr4:2:2";
                }
                return (O00000oo[0] == 2 && O00000oo[1] == 2) ? "YCbCr4:2:0" : "(Unknown)";
            case 531:
                return O000000o(531, 1, "Center of pixel array", "Datum point");
            case 532:
                return O00000oo();
            case 33422:
                return O0000Oo0();
            case 33434:
                String O0000o08 = this.f2602O000000o.O0000o0(33434);
                if (O0000o08 == null) {
                    return null;
                }
                return O0000o08 + " sec";
            case 33437:
                Rational O0000Ooo3 = this.f2602O000000o.O0000Ooo(33437);
                if (O0000Ooo3 == null) {
                    return null;
                }
                return O000000o(O0000Ooo3.doubleValue());
            case 34850:
                return O000000o(34850, 1, "Manual control", "Program normal", "Aperture priority", "Shutter priority", "Program creative (slow program)", "Program action (high-speed program)", "Portrait mode", "Landscape mode");
            case 34855:
                Integer O00000o05 = this.f2602O000000o.O00000o0(34855);
                if (O00000o05 != null) {
                    return Integer.toString(O00000o05.intValue());
                }
                return null;
            case 34864:
                return O000000o(34864, "Unknown", "Standard Output Sensitivity", "Recommended Exposure Index", "ISO Speed", "Standard Output Sensitivity and Recommended Exposure Index", "Standard Output Sensitivity and ISO Speed", "Recommended Exposure Index and ISO Speed", "Standard Output Sensitivity, Recommended Exposure Index and ISO Speed");
            case 36864:
                return O000000o(36864, 2);
            case 37121:
                return O0000Ooo();
            case 37122:
                Rational O0000Ooo4 = this.f2602O000000o.O0000Ooo(37122);
                if (O0000Ooo4 == null) {
                    return null;
                }
                String O000000o2 = O0000Ooo4.O000000o(true);
                if (!O0000Ooo4.O00000Oo() || O0000Ooo4.intValue() != 1) {
                    return O000000o2 + " bits/pixel";
                }
                return O000000o2 + " bit/pixel";
            case 37377:
                return super.O00000oO(37377);
            case 37378:
                Double O0000OOo = this.f2602O000000o.O0000OOo(37378);
                if (O0000OOo == null) {
                    return null;
                }
                return O000000o(wi.O000000o(O0000OOo.doubleValue()));
            case 37380:
                Rational O0000Ooo5 = this.f2602O000000o.O0000Ooo(37380);
                if (O0000Ooo5 == null) {
                    return null;
                }
                return O0000Ooo5.O000000o(true) + " EV";
            case 37381:
                Double O0000OOo2 = this.f2602O000000o.O0000OOo(37381);
                if (O0000OOo2 == null) {
                    return null;
                }
                return O000000o(wi.O000000o(O0000OOo2.doubleValue()));
            case 37382:
                Rational O0000Ooo6 = this.f2602O000000o.O0000Ooo(37382);
                if (O0000Ooo6 == null) {
                    return null;
                }
                DecimalFormat decimalFormat = new DecimalFormat("0.0##");
                return decimalFormat.format(O0000Ooo6.doubleValue()) + " metres";
            case 37383:
                Integer O00000o06 = this.f2602O000000o.O00000o0(37383);
                if (O00000o06 == null) {
                    return null;
                }
                int intValue4 = O00000o06.intValue();
                if (intValue4 == 255) {
                    return "(Other)";
                }
                switch (intValue4) {
                    case 0:
                        return "Unknown";
                    case 1:
                        return "Average";
                    case 2:
                        return "Center weighted average";
                    case 3:
                        return "Spot";
                    case 4:
                        return "Multi-spot";
                    case 5:
                        return "Multi-segment";
                    case 6:
                        return "Partial";
                    default:
                        return "Unknown (" + O00000o06 + ")";
                }
            case 37384:
                Integer O00000o07 = this.f2602O000000o.O00000o0(37384);
                if (O00000o07 == null) {
                    return null;
                }
                int intValue5 = O00000o07.intValue();
                if (intValue5 == 0) {
                    return "Unknown";
                }
                if (intValue5 == 1) {
                    return "Daylight";
                }
                if (intValue5 == 2) {
                    return "Florescent";
                }
                if (intValue5 == 3) {
                    return "Tungsten";
                }
                if (intValue5 == 4) {
                    return "Flash";
                }
                if (intValue5 == 255) {
                    return "(Other)";
                }
                switch (intValue5) {
                    case 9:
                        return "Fine Weather";
                    case 10:
                        return "Cloudy";
                    case 11:
                        return "Shade";
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        return "Daylight Fluorescent";
                    case 13:
                        return "Day White Fluorescent";
                    case 14:
                        return "Cool White Fluorescent";
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        return "White Fluorescent";
                    case 16:
                        return "Warm White Fluorescent";
                    case 17:
                        return "Standard light";
                    case 18:
                        return "Standard light (B)";
                    case 19:
                        return "Standard light (C)";
                    case 20:
                        return "D55";
                    case 21:
                        return "D65";
                    case 22:
                        return "D75";
                    case 23:
                        return "D50";
                    case 24:
                        return "Studio Tungsten";
                    default:
                        return "Unknown (" + O00000o07 + ")";
                }
            case 37385:
                Integer O00000o08 = this.f2602O000000o.O00000o0(37385);
                if (O00000o08 == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                if ((O00000o08.intValue() & 1) != 0) {
                    sb.append("Flash fired");
                } else {
                    sb.append("Flash did not fire");
                }
                if ((4 & O00000o08.intValue()) != 0) {
                    if ((O00000o08.intValue() & 2) != 0) {
                        sb.append(", return detected");
                    } else {
                        sb.append(", return not detected");
                    }
                }
                if ((O00000o08.intValue() & 16) != 0) {
                    sb.append(", auto");
                }
                if ((O00000o08.intValue() & 64) != 0) {
                    sb.append(", red-eye reduction");
                }
                return sb.toString();
            case 37386:
                Rational O0000Ooo7 = this.f2602O000000o.O0000Ooo(37386);
                if (O0000Ooo7 == null) {
                    return null;
                }
                return O00000Oo(O0000Ooo7.doubleValue());
            case 37510:
                return O0000OOo();
            case 40091:
                return O00000oo(40091);
            case 40092:
                return O00000oo(40092);
            case 40093:
                return O00000oo(40093);
            case 40094:
                return O00000oo(40094);
            case 40095:
                return O00000oo(40095);
            case 40960:
                return O000000o(40960, 2);
            case 40961:
                Integer O00000o09 = this.f2602O000000o.O00000o0(40961);
                if (O00000o09 == null) {
                    return null;
                }
                if (O00000o09.intValue() == 1) {
                    return "sRGB";
                }
                if (O00000o09.intValue() == 65535) {
                    return "Undefined";
                }
                return "Unknown (" + O00000o09 + ")";
            case 40962:
                Integer O00000o010 = this.f2602O000000o.O00000o0(40962);
                if (O00000o010 == null) {
                    return null;
                }
                return O00000o010 + " pixels";
            case 40963:
                Integer O00000o011 = this.f2602O000000o.O00000o0(40963);
                if (O00000o011 == null) {
                    return null;
                }
                return O00000o011 + " pixels";
            case 41486:
                Rational O0000Ooo8 = this.f2602O000000o.O0000Ooo(41486);
                if (O0000Ooo8 == null) {
                    return null;
                }
                String O0000OoO = O0000OoO();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(O0000Ooo8.O000000o().O000000o(true));
                if (O0000OoO == null) {
                    str = "";
                } else {
                    str = " " + O0000OoO.toLowerCase();
                }
                sb2.append(str);
                return sb2.toString();
            case 41487:
                Rational O0000Ooo9 = this.f2602O000000o.O0000Ooo(41487);
                if (O0000Ooo9 == null) {
                    return null;
                }
                String O0000OoO2 = O0000OoO();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(O0000Ooo9.O000000o().O000000o(true));
                if (O0000OoO2 == null) {
                    str2 = "";
                } else {
                    str2 = " " + O0000OoO2.toLowerCase();
                }
                sb3.append(str2);
                return sb3.toString();
            case 41488:
                return O0000OoO();
            case 41495:
                return O000000o(41495, 1, "(Not defined)", "One-chip color area sensor", "Two-chip color area sensor", "Three-chip color area sensor", "Color sequential area sensor", null, "Trilinear sensor", "Color sequential linear sensor");
            case 41728:
                return O000000o(41728, 1, "Film Scanner", "Reflection Print Scanner", "Digital Still Camera (DSC)");
            case 41729:
                return O000000o(41729, 1, "Directly photographed image");
            case 41730:
                return O000000o(O0000Oo());
            case 41985:
                return O000000o(41985, "Normal process", "Custom process");
            case 41986:
                return O000000o(41986, "Auto exposure", "Manual exposure", "Auto bracket");
            case 41987:
                return O000000o(41987, "Auto white balance", "Manual white balance");
            case 41988:
                Rational O0000Ooo10 = this.f2602O000000o.O0000Ooo(41988);
                if (O0000Ooo10 == null) {
                    return null;
                }
                if (O0000Ooo10._numerator == 0) {
                    return "Digital zoom not used";
                }
                return new DecimalFormat("0.#").format(O0000Ooo10.doubleValue());
            case 41989:
                Integer O00000o012 = this.f2602O000000o.O00000o0(41989);
                if (O00000o012 == null) {
                    return null;
                }
                if (O00000o012.intValue() == 0) {
                    return "Unknown";
                }
                return O00000Oo((double) O00000o012.intValue());
            case 41990:
                return O000000o(41990, "Standard", "Landscape", "Portrait", "Night scene");
            case 41991:
                return O000000o(41991, "None", "Low gain up", "Low gain down", "High gain up", "High gain down");
            case 41992:
                return O000000o(41992, "None", "Soft", "Hard");
            case 41993:
                return O000000o(41993, "None", "Low saturation", "High saturation");
            case 41994:
                return O000000o(41994, "None", "Low", "Hard");
            case 41996:
                return O000000o(41996, "Unknown", "Macro", "Close view", "Distant view");
            case 42034:
                return O00000o(42034);
            default:
                return super.O000000o(i);
        }
    }

    private String O00000oo() {
        int[] O00000oo = this.f2602O000000o.O00000oo(532);
        if (O00000oo == null || O00000oo.length < 6) {
            Object O0000o0o = this.f2602O000000o.O0000o0o(532);
            if (O0000o0o == null || !(O0000o0o instanceof long[])) {
                return null;
            }
            long[] jArr = (long[]) O0000o0o;
            if (jArr.length < 6) {
                return null;
            }
            int[] iArr = new int[jArr.length];
            for (int i = 0; i < jArr.length; i++) {
                iArr[i] = (int) jArr[i];
            }
            O00000oo = iArr;
        }
        int i2 = O00000oo[0];
        int i3 = O00000oo[1];
        int i4 = O00000oo[2];
        int i5 = O00000oo[3];
        return String.format("[%d,%d,%d] [%d,%d,%d]", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(O00000oo[4]), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(O00000oo[5]));
    }

    private String O0000O0o() {
        return O000000o(296, 1, "(No unit)", "Inch", "cm");
    }

    private String O00000oo(int i) {
        byte[] O0000O0o = this.f2602O000000o.O0000O0o(i);
        if (O0000O0o == null) {
            return null;
        }
        try {
            return new String(O0000O0o, "UTF-16LE").trim();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private String O0000OOo() {
        byte[] O0000O0o = this.f2602O000000o.O0000O0o(37510);
        if (O0000O0o == null) {
            return null;
        }
        if (O0000O0o.length == 0) {
            return "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ASCII", System.getProperty("file.encoding"));
        hashMap.put("UNICODE", "UTF-16LE");
        hashMap.put("JIS", "Shift-JIS");
        try {
            if (O0000O0o.length >= 10) {
                String str = new String(O0000O0o, 0, 10);
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    if (str.startsWith(str2)) {
                        for (int length = str2.length(); length < 10; length++) {
                            byte b = O0000O0o[length];
                            if (b != 0 && b != 32) {
                                return new String(O0000O0o, length, O0000O0o.length - length, str3).trim();
                            }
                        }
                        return new String(O0000O0o, 10, O0000O0o.length - 10, str3).trim();
                    }
                }
            }
            return new String(O0000O0o, System.getProperty("file.encoding")).trim();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private String O0000Oo0() {
        byte[] O0000O0o = this.f2602O000000o.O0000O0o(33422);
        if (O0000O0o == null) {
            return null;
        }
        int[] O00000oo = this.f2602O000000o.O00000oo(33421);
        if (O00000oo == null) {
            return String.format("Repeat Pattern not found for CFAPattern (%s)", super.O000000o(33422));
        } else if (O00000oo.length == 2 && O0000O0o.length == O00000oo[0] * O00000oo[1]) {
            int[] iArr = new int[(O0000O0o.length + 2)];
            iArr[0] = O00000oo[0];
            iArr[1] = O00000oo[1];
            for (int i = 0; i < O0000O0o.length; i++) {
                iArr[i + 2] = O0000O0o[i] & 255;
            }
            return O000000o(iArr);
        } else {
            return String.format("Unknown Pattern (%s)", super.O000000o(33422));
        }
    }

    private static String O000000o(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length < 2) {
            return "<truncated data>";
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return "<zero pattern size>";
        }
        int i = (iArr[0] * iArr[1]) + 2;
        if (i > iArr.length) {
            return "<invalid pattern size>";
        }
        String[] strArr = {"Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "White"};
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i2 = 2; i2 < i; i2++) {
            if (iArr[i2] <= 6) {
                sb.append(strArr[iArr[i2]]);
            } else {
                sb.append("Unknown");
            }
            if ((i2 - 2) % iArr[1] == 0) {
                sb.append(",");
            } else if (i2 != i - 1) {
                sb.append("][");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r0.length >= ((r6 * r7) + 2)) goto L_0x0052;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    private int[] O0000Oo() {
        byte[] O0000O0o = this.f2602O000000o.O0000O0o(41730);
        if (O0000O0o == 0) {
            return null;
        }
        if (O0000O0o.length < 4) {
            int[] iArr = new int[O0000O0o.length];
            for (int i = 0; i < O0000O0o.length; i++) {
                iArr[i] = O0000O0o[i];
            }
            return iArr;
        }
        int[] iArr2 = new int[(O0000O0o.length - 2)];
        try {
            xc xcVar = new xc(O0000O0o);
            int O00000oo = xcVar.O00000oo(0);
            int O00000oo2 = xcVar.O00000oo(2);
            Boolean bool = Boolean.FALSE;
            if ((O00000oo * O00000oo2) + 2 > O0000O0o.length) {
                xcVar.f2594O000000o = !xcVar.f2594O000000o;
                O00000oo = xcVar.O00000oo(0);
                O00000oo2 = xcVar.O00000oo(2);
            }
            bool = Boolean.TRUE;
            if (bool.booleanValue()) {
                iArr2[0] = O00000oo;
                iArr2[1] = O00000oo2;
                for (int i2 = 4; i2 < O0000O0o.length; i2++) {
                    iArr2[i2 - 2] = xcVar.O00000o(i2);
                }
            }
        } catch (IOException e) {
            xr xrVar = this.f2602O000000o;
            xrVar.O000000o("IO exception processing data: " + e.getMessage());
        }
        return iArr2;
    }

    private String O0000OoO() {
        return O000000o(41488, 1, "(No unit)", "Inches", "cm");
    }

    private String O0000Ooo() {
        int[] O00000oo = this.f2602O000000o.O00000oo(37121);
        if (O00000oo == null) {
            return null;
        }
        String[] strArr = {"", "Y", "Cb", "Cr", "R", "G", "B"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(4, O00000oo.length); i++) {
            int i2 = O00000oo[i];
            if (i2 > 0 && i2 < 7) {
                sb.append(strArr[i2]);
            }
        }
        return sb.toString();
    }
}

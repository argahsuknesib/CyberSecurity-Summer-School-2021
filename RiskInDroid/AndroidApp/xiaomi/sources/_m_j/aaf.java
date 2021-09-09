package _m_j;

import com.drew.lang.Rational;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.text.DecimalFormat;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class aaf extends xx<aag> {
    private static final HashMap<Integer, String> O00000o;
    private static final HashMap<Integer, String> O00000o0 = new HashMap<>();

    public aaf(aag aag) {
        super(aag);
    }

    public final String O000000o(int i) {
        String str;
        int i2 = i;
        if (i2 != 0) {
            if (i2 == 1280) {
                Integer O00000o02 = ((aag) this.f2602O000000o).O00000o0(1280);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue = O00000o02.intValue();
                if (intValue == 0) {
                    return "Auto";
                }
                if (intValue == 1) {
                    return "Auto (Keep Warm Color Off)";
                }
                if (intValue == 48) {
                    return "3600K (Tungsten light-like)";
                }
                if (intValue == 67) {
                    return "Underwater";
                }
                switch (intValue) {
                    case 16:
                        return "7500K (Fine Weather with Shade)";
                    case 17:
                        return "6000K (Cloudy)";
                    case 18:
                        return "5300K (Fine Weather)";
                    default:
                        switch (intValue) {
                            case 20:
                                return "3000K (Tungsten light)";
                            case 21:
                                return "3600K (Tungsten light-like)";
                            case 22:
                                return "Auto Setup";
                            case 23:
                                return "5500K (Flash)";
                            default:
                                switch (intValue) {
                                    case 33:
                                        return "6600K (Daylight fluorescent)";
                                    case 34:
                                        return "4500K (Neutral white fluorescent)";
                                    case 35:
                                        return "4000K (Cool white fluorescent)";
                                    case 36:
                                        return "White Fluorescent";
                                    default:
                                        switch (intValue) {
                                            case 256:
                                                return "One Touch WB 1";
                                            case 257:
                                                return "One Touch WB 2";
                                            case 258:
                                                return "One Touch WB 3";
                                            case 259:
                                                return "One Touch WB 4";
                                            default:
                                                switch (intValue) {
                                                    case 512:
                                                        return "Custom WB 1";
                                                    case 513:
                                                        return "Custom WB 2";
                                                    case 514:
                                                        return "Custom WB 3";
                                                    case 515:
                                                        return "Custom WB 4";
                                                    default:
                                                        return "Unknown (" + O00000o02 + ")";
                                                }
                                        }
                                }
                        }
                }
            } else if (i2 == 1281) {
                Integer O00000o03 = ((aag) this.f2602O000000o).O00000o0(1281);
                if (O00000o03 == null) {
                    return null;
                }
                if (O00000o03.intValue() == 0) {
                    return "Auto";
                }
                return O00000o03.toString();
            } else if (i2 == 1312) {
                int[] O00000oo = ((aag) this.f2602O000000o).O00000oo(1312);
                if (O00000oo == null) {
                    Integer O00000o04 = ((aag) this.f2602O000000o).O00000o0(1290);
                    if (O00000o04 == null) {
                        return null;
                    }
                    O00000oo = new int[]{O00000o04.intValue()};
                }
                if (O00000oo.length == 0) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                int i3 = O00000oo[0];
                if (i3 == 1) {
                    sb.append("Vivid");
                } else if (i3 == 2) {
                    sb.append("Natural");
                } else if (i3 == 3) {
                    sb.append("Muted");
                } else if (i3 == 4) {
                    sb.append("Portrait");
                } else if (i3 == 5) {
                    sb.append("i-Enhance");
                } else if (i3 == 256) {
                    sb.append("Monotone");
                } else if (i3 != 512) {
                    sb.append("Unknown (");
                    sb.append(O00000oo[0]);
                    sb.append(")");
                } else {
                    sb.append("Sepia");
                }
                if (O00000oo.length > 1) {
                    sb.append("; ");
                    sb.append(O00000oo[1]);
                }
                return sb.toString();
            } else if (i2 == 1313) {
                return O00000oo(1313);
            } else {
                if (i2 == 1536) {
                    int[] O00000oo2 = ((aag) this.f2602O000000o).O00000oo(1536);
                    if (O00000oo2 == null) {
                        return null;
                    }
                    if (O00000oo2.length == 0 || O00000oo2[0] == 0) {
                        return "Single Shot";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    if (O00000oo2[0] != 5 || O00000oo2.length < 3) {
                        int i4 = O00000oo2[0];
                        if (i4 == 1) {
                            sb2.append("Continuous Shooting");
                        } else if (i4 == 2) {
                            sb2.append("Exposure Bracketing");
                        } else if (i4 == 3) {
                            sb2.append("White Balance Bracketing");
                        } else if (i4 != 4) {
                            sb2.append("Unknown (");
                            sb2.append(O00000oo2[0]);
                            sb2.append(")");
                        } else {
                            sb2.append("Exposure+WB Bracketing");
                        }
                    } else {
                        int i5 = O00000oo2[2];
                        if ((i5 & 1) > 0) {
                            sb2.append("AE");
                        }
                        if (((i5 >> 1) & 1) > 0) {
                            sb2.append("WB");
                        }
                        if (((i5 >> 2) & 1) > 0) {
                            sb2.append("FL");
                        }
                        if (((i5 >> 3) & 1) > 0) {
                            sb2.append("MF");
                        }
                        if (((i5 >> 6) & 1) > 0) {
                            sb2.append("Focus");
                        }
                        sb2.append(" Bracketing");
                    }
                    sb2.append(", Shot ");
                    sb2.append(O00000oo2[1]);
                    return sb2.toString();
                } else if (i2 != 1537) {
                    String str2 = "n/a";
                    switch (i2) {
                        case 0:
                            break;
                        case 256:
                            return O000000o(256, "No", "Yes");
                        case 768:
                            return O000000o(768, "Off", "On", "Super Macro");
                        case 769:
                            int[] O00000oo3 = ((aag) this.f2602O000000o).O00000oo(769);
                            if (O00000oo3 == null) {
                                Integer O00000o05 = ((aag) this.f2602O000000o).O00000o0(769);
                                if (O00000o05 == null) {
                                    return null;
                                }
                                O00000oo3 = new int[]{O00000o05.intValue()};
                            }
                            if (O00000oo3.length == 0) {
                                return null;
                            }
                            StringBuilder sb3 = new StringBuilder();
                            int i6 = O00000oo3[0];
                            if (i6 == 0) {
                                sb3.append("Single AF");
                            } else if (i6 == 1) {
                                sb3.append("Sequential shooting AF");
                            } else if (i6 == 2) {
                                sb3.append("Continuous AF");
                            } else if (i6 == 3) {
                                sb3.append("Multi AF");
                            } else if (i6 == 4) {
                                sb3.append("Face detect");
                            } else if (i6 != 10) {
                                sb3.append("Unknown (" + O00000oo3[0] + ")");
                            } else {
                                sb3.append("MF");
                            }
                            if (O00000oo3.length > 1) {
                                sb3.append("; ");
                                int i7 = O00000oo3[1];
                                if (i7 == 0) {
                                    sb3.append("(none)");
                                } else {
                                    if ((i7 & 1) > 0) {
                                        sb3.append("S-AF, ");
                                    }
                                    if (((i7 >> 2) & 1) > 0) {
                                        sb3.append("C-AF, ");
                                    }
                                    if (((i7 >> 4) & 1) > 0) {
                                        sb3.append("MF, ");
                                    }
                                    if (((i7 >> 5) & 1) > 0) {
                                        sb3.append("Face detect, ");
                                    }
                                    if (((i7 >> 6) & 1) > 0) {
                                        sb3.append("Imager AF, ");
                                    }
                                    if (((i7 >> 7) & 1) > 0) {
                                        sb3.append("Live View Magnification Frame, ");
                                    }
                                    if (((i7 >> 8) & 1) > 0) {
                                        sb3.append("AF sensor, ");
                                    }
                                    sb3.setLength(sb3.length() - 2);
                                }
                            }
                            return sb3.toString();
                        case 770:
                            int[] O00000oo4 = ((aag) this.f2602O000000o).O00000oo(770);
                            if (O00000oo4 == null) {
                                Integer O00000o06 = ((aag) this.f2602O000000o).O00000o0(770);
                                if (O00000o06 == null) {
                                    return null;
                                }
                                O00000oo4 = new int[]{O00000o06.intValue()};
                            }
                            if (O00000oo4.length == 0) {
                                return null;
                            }
                            StringBuilder sb4 = new StringBuilder();
                            int i8 = O00000oo4[0];
                            if (i8 == 0) {
                                sb4.append("AF not used");
                            } else if (i8 != 1) {
                                sb4.append("Unknown (" + O00000oo4[0] + ")");
                            } else {
                                sb4.append("AF used");
                            }
                            if (O00000oo4.length > 1) {
                                sb4.append("; " + O00000oo4[1]);
                            }
                            return sb4.toString();
                        case 771:
                            return O000000o(771, "Not Ready", "Ready");
                        case 772:
                            return O00000oo();
                        case 773:
                            Rational[] O0000o00 = ((aag) this.f2602O000000o).O0000o00(773);
                            if (O0000o00 == null) {
                                return str2;
                            }
                            if (O0000o00.length < 4) {
                                return null;
                            }
                            int i9 = (O0000o00.length == 5 && O0000o00[0].longValue() == 0) ? 1 : 0;
                            int doubleValue = (int) (O0000o00[i9].doubleValue() * 100.0d);
                            int doubleValue2 = (int) (O0000o00[i9 + 1].doubleValue() * 100.0d);
                            int doubleValue3 = (int) (O0000o00[i9 + 2].doubleValue() * 100.0d);
                            int doubleValue4 = (int) (O0000o00[i9 + 3].doubleValue() * 100.0d);
                            if (doubleValue + doubleValue2 + doubleValue3 + doubleValue4 == 0) {
                                return str2;
                            }
                            return String.format("(%d%%,%d%%) (%d%%,%d%%)", Integer.valueOf(doubleValue), Integer.valueOf(doubleValue2), Integer.valueOf(doubleValue3), Integer.valueOf(doubleValue4));
                        case 774:
                            return O000000o(774, "Off", "On");
                        case 1024:
                            Integer O00000o07 = ((aag) this.f2602O000000o).O00000o0(1024);
                            if (O00000o07 == null) {
                                return null;
                            }
                            if (O00000o07.intValue() == 0) {
                                return "Off";
                            }
                            StringBuilder sb5 = new StringBuilder();
                            int intValue2 = O00000o07.intValue();
                            if ((intValue2 & 1) != 0) {
                                sb5.append("On, ");
                            }
                            if (((intValue2 >> 1) & 1) != 0) {
                                sb5.append("Fill-in, ");
                            }
                            if (((intValue2 >> 2) & 1) != 0) {
                                sb5.append("Red-eye, ");
                            }
                            if (((intValue2 >> 3) & 1) != 0) {
                                sb5.append("Slow-sync, ");
                            }
                            if (((intValue2 >> 4) & 1) != 0) {
                                sb5.append("Forced On, ");
                            }
                            if (((intValue2 >> 5) & 1) != 0) {
                                sb5.append("2nd Curtain, ");
                            }
                            return sb5.substring(0, sb5.length() - 2);
                        case 1295:
                            int[] O00000oo5 = ((aag) this.f2602O000000o).O00000oo(1295);
                            if (O00000oo5 == null || O00000oo5.length < 3) {
                                return null;
                            }
                            String format = String.format("%d %d %d", Integer.valueOf(O00000oo5[0]), Integer.valueOf(O00000oo5[1]), Integer.valueOf(O00000oo5[2]));
                            if (!format.equals("0 0 0")) {
                                if (format.equals("-1 -1 1")) {
                                    str2 = "Low Key";
                                } else if (format.equals("0 -1 1")) {
                                    str2 = "Normal";
                                } else if (format.equals("1 -1 1")) {
                                    str2 = "High Key";
                                } else {
                                    str2 = "Unknown (" + format + ")";
                                }
                            }
                            if (O00000oo5.length <= 3) {
                                return str2;
                            }
                            if (O00000oo5[3] == 0) {
                                return str2 + "; User-Selected";
                            } else if (O00000oo5[3] != 1) {
                                return str2;
                            } else {
                                return str2 + "; Auto-Override";
                            }
                        case 1321:
                            return O0000O0o(1321);
                        case 1330:
                            return O0000Ooo();
                        case 1539:
                            return O000000o(1539, 1, "SQ", "HQ", "SHQ", "RAW", "SQ (5)");
                        case 1540:
                            return O000000o(1540, "Off", "On, Mode 1", "On, Mode 2", "On, Mode 3", "On, Mode 4");
                        case 2052:
                            int[] O00000oo6 = ((aag) this.f2602O000000o).O00000oo(2052);
                            if (O00000oo6 == null || O00000oo6.length < 2) {
                                return null;
                            }
                            int i10 = O00000oo6[0];
                            int i11 = O00000oo6[1];
                            if (i10 == 0 && i11 == 0) {
                                return "No";
                            }
                            if (i10 == 9 && i11 == 8) {
                                return "Focus-stacked (8 images)";
                            }
                            return String.format("Unknown (%d %d)", Integer.valueOf(i10), Integer.valueOf(i11));
                        case 2304:
                            Integer O00000o08 = ((aag) this.f2602O000000o).O00000o0(2304);
                            if (O00000o08 == null) {
                                return null;
                            }
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            double intValue3 = (double) O00000o08.intValue();
                            Double.isNaN(intValue3);
                            return String.format("%s kPa", decimalFormat.format(intValue3 / 10.0d));
                        case 2305:
                            int[] O00000oo7 = ((aag) this.f2602O000000o).O00000oo(2305);
                            if (O00000oo7 == null || O00000oo7.length < 2) {
                                return null;
                            }
                            DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
                            double d = (double) O00000oo7[0];
                            Double.isNaN(d);
                            double d2 = (double) O00000oo7[1];
                            Double.isNaN(d2);
                            return String.format("%s m, %s ft", decimalFormat2.format(d / 10.0d), decimalFormat2.format(d2 / 10.0d));
                        case 2306:
                            return O000000o(2306, "Off", "On");
                        case 2307:
                            int[] O00000oo8 = ((aag) this.f2602O000000o).O00000oo(2307);
                            if (O00000oo8 == null || O00000oo8.length < 2) {
                                return null;
                            }
                            if (O00000oo8[0] != 0) {
                                double d3 = (double) (-O00000oo8[0]);
                                Double.isNaN(d3);
                                str2 = Double.toString(d3 / 10.0d);
                            }
                            return String.format("%s %d", str2, Integer.valueOf(O00000oo8[1]));
                        case 2308:
                            int[] O00000oo9 = ((aag) this.f2602O000000o).O00000oo(2308);
                            if (O00000oo9 == null || O00000oo9.length < 2) {
                                return null;
                            }
                            if (O00000oo9[0] != 0) {
                                double d4 = (double) O00000oo9[0];
                                Double.isNaN(d4);
                                str2 = Double.toString(d4 / 10.0d);
                            }
                            return String.format("%s %d", str2, Integer.valueOf(O00000oo9[1]));
                        case 2312:
                            Object O0000o0o = ((aag) this.f2602O000000o).O0000o0o(2312);
                            if (O0000o0o == null) {
                                return null;
                            }
                            return O0000o0o.toString();
                        default:
                            switch (i2) {
                                case 512:
                                    return O000000o(512, 1, "Manual", "Program", "Aperture-priority AE", "Shutter speed priority", "Program-shift");
                                case 513:
                                    return O000000o(513, "Off", "On");
                                case 514:
                                    Integer O00000o09 = ((aag) this.f2602O000000o).O00000o0(514);
                                    if (O00000o09 == null) {
                                        return null;
                                    }
                                    int intValue4 = O00000o09.intValue();
                                    if (intValue4 == 2) {
                                        return "Center-weighted average";
                                    }
                                    if (intValue4 == 3) {
                                        return "Spot";
                                    }
                                    if (intValue4 == 5) {
                                        return "ESP";
                                    }
                                    if (intValue4 == 261) {
                                        return "Pattern+AF";
                                    }
                                    if (intValue4 == 515) {
                                        return "Spot+Highlight control";
                                    }
                                    if (intValue4 == 1027) {
                                        return "Spot+Shadow control";
                                    }
                                    return "Unknown (" + O00000o09 + ")";
                                case 515:
                                    return O00000o();
                                case 516:
                                    return O000000o(516, "Off", "On");
                                default:
                                    switch (i2) {
                                        case 1027:
                                            Integer O00000o010 = ((aag) this.f2602O000000o).O00000o0(1027);
                                            if (O00000o010 == null) {
                                                return null;
                                            }
                                            int intValue5 = O00000o010.intValue();
                                            if (intValue5 == 0) {
                                                return "Off";
                                            }
                                            if (intValue5 == 1) {
                                                return "Channel 1, Low";
                                            }
                                            if (intValue5 == 2) {
                                                return "Channel 2, Low";
                                            }
                                            if (intValue5 == 3) {
                                                return "Channel 3, Low";
                                            }
                                            if (intValue5 == 4) {
                                                return "Channel 4, Low";
                                            }
                                            switch (intValue5) {
                                                case 9:
                                                    return "Channel 1, Mid";
                                                case 10:
                                                    return "Channel 2, Mid";
                                                case 11:
                                                    return "Channel 3, Mid";
                                                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                                    return "Channel 4, Mid";
                                                default:
                                                    switch (intValue5) {
                                                        case 17:
                                                            return "Channel 1, High";
                                                        case 18:
                                                            return "Channel 2, High";
                                                        case 19:
                                                            return "Channel 3, High";
                                                        case 20:
                                                            return "Channel 4, High";
                                                        default:
                                                            return "Unknown (" + O00000o010 + ")";
                                                    }
                                            }
                                        case 1028:
                                            return O0000O0o();
                                        case 1029:
                                            return O0000OOo();
                                        case 1030:
                                            return O0000Oo0();
                                        default:
                                            switch (i2) {
                                                case 1283:
                                                    return O00000oo(1283);
                                                case 1284:
                                                    return O000000o(1284, "Off", "CM1 (Red Enhance)", "CM2 (Green Enhance)", "CM3 (Blue Enhance)", "CM4 (Skin Tones)");
                                                case 1285:
                                                    return O00000oo(1285);
                                                case 1286:
                                                    return O00000oo(1286);
                                                case 1287:
                                                    return O000000o(1287, "sRGB", "Adobe RGB", "Pro Photo RGB");
                                                default:
                                                    switch (i2) {
                                                        case 1289:
                                                            Integer O00000o011 = ((aag) this.f2602O000000o).O00000o0(1289);
                                                            if (O00000o011 == null) {
                                                                return null;
                                                            }
                                                            int intValue6 = O00000o011.intValue();
                                                            if (intValue6 == 0) {
                                                                return "Standard";
                                                            }
                                                            if (intValue6 == 54) {
                                                                return "Face Portrait";
                                                            }
                                                            if (intValue6 == 57) {
                                                                return "Bulb";
                                                            }
                                                            if (intValue6 == 142) {
                                                                return "Hand-held Starlight";
                                                            }
                                                            if (intValue6 == 154) {
                                                                return "HDR";
                                                            }
                                                            if (intValue6 == 59) {
                                                                return "Smile Shot";
                                                            }
                                                            if (intValue6 == 60) {
                                                                return "Quick Shutter";
                                                            }
                                                            switch (intValue6) {
                                                                case 6:
                                                                    return "Auto";
                                                                case 7:
                                                                    return "Sport";
                                                                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                                                    return "Portrait";
                                                                case 9:
                                                                    return "Landscape+Portrait";
                                                                case 10:
                                                                    return "Landscape";
                                                                case 11:
                                                                    return "Night Scene";
                                                                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                                                    return "Self Portrait";
                                                                case 13:
                                                                    return "Panorama";
                                                                case 14:
                                                                    return "2 in 1";
                                                                case GmsLogger.MAX_PII_TAG_LENGTH:
                                                                    return "Movie";
                                                                case 16:
                                                                    return "Landscape+Portrait";
                                                                case 17:
                                                                    return "Night+Portrait";
                                                                case 18:
                                                                    return "Indoor";
                                                                case 19:
                                                                    return "Fireworks";
                                                                case 20:
                                                                    return "Sunset";
                                                                case 21:
                                                                    return "Beauty Skin";
                                                                case 22:
                                                                    return "Macro";
                                                                case 23:
                                                                    return "Super Macro";
                                                                case 24:
                                                                    return "Food";
                                                                case 25:
                                                                    return "Documents";
                                                                case 26:
                                                                    return "Museum";
                                                                case 27:
                                                                    return "Shoot & Select";
                                                                case 28:
                                                                    return "Beach & Snow";
                                                                case 29:
                                                                    return "Self Portrait+Timer";
                                                                case 30:
                                                                    return "Candle";
                                                                case 31:
                                                                    return "Available Light";
                                                                case 32:
                                                                    return "Behind Glass";
                                                                case 33:
                                                                    return "My Mode";
                                                                case 34:
                                                                    return "Pet";
                                                                case 35:
                                                                    return "Underwater Wide1";
                                                                case 36:
                                                                    return "Underwater Macro";
                                                                case 37:
                                                                    return "Shoot & Select1";
                                                                case 38:
                                                                    return "Shoot & Select2";
                                                                case 39:
                                                                    return "High Key";
                                                                case 40:
                                                                    return "Digital Image Stabilization";
                                                                case 41:
                                                                    return "Auction";
                                                                case 42:
                                                                    return "Beach";
                                                                case 43:
                                                                    return "Snow";
                                                                case 44:
                                                                    return "Underwater Wide2";
                                                                case 45:
                                                                    return "Low Key";
                                                                case 46:
                                                                    return "Children";
                                                                case 47:
                                                                    return "Vivid";
                                                                case 48:
                                                                    return "Nature Macro";
                                                                case 49:
                                                                    return "Underwater Snapshot";
                                                                case 50:
                                                                    return "Shooting Guide";
                                                                default:
                                                                    switch (intValue6) {
                                                                        case 63:
                                                                            return "Slow Shutter";
                                                                        case 64:
                                                                            return "Bird Watching";
                                                                        case 65:
                                                                            return "Multiple Exposure";
                                                                        case 66:
                                                                            return "e-Portrait";
                                                                        case 67:
                                                                            return "Soft Background Shot";
                                                                        default:
                                                                            return "Unknown (" + O00000o011 + ")";
                                                                    }
                                                            }
                                                        case 1290:
                                                            Integer O00000o012 = ((aag) this.f2602O000000o).O00000o0(1290);
                                                            if (O00000o012 == null) {
                                                                return null;
                                                            }
                                                            if (O00000o012.intValue() == 0) {
                                                                return "(none)";
                                                            }
                                                            StringBuilder sb6 = new StringBuilder();
                                                            int intValue7 = O00000o012.intValue();
                                                            if ((intValue7 & 1) != 0) {
                                                                sb6.append("Noise Reduction, ");
                                                            }
                                                            if (((intValue7 >> 1) & 1) != 0) {
                                                                sb6.append("Noise Filter, ");
                                                            }
                                                            if (((intValue7 >> 2) & 1) != 0) {
                                                                sb6.append("Noise Filter (ISO Boost), ");
                                                            }
                                                            if (((intValue7 >> 3) & 1) != 0) {
                                                                sb6.append("Auto, ");
                                                            }
                                                            return sb6.length() != 0 ? sb6.substring(0, sb6.length() - 2) : "(none)";
                                                        case 1291:
                                                            return O000000o(1291, "Off", "On");
                                                        case 1292:
                                                            return O000000o(1292, "Off", "On");
                                                        default:
                                                            switch (i2) {
                                                                case 1315:
                                                                    return O00000oo(1315);
                                                                case 1316:
                                                                    return O00000oo(1316);
                                                                case 1317:
                                                                    return O000000o(1317, "n/a", "Neutral", "Yellow", "Orange", "Red", "Green");
                                                                case 1318:
                                                                    return O000000o(1318, "n/a", "Neutral", "Sepia", "Blue", "Purple", "Green");
                                                                case 1319:
                                                                    int[] O00000oo10 = ((aag) this.f2602O000000o).O00000oo(1319);
                                                                    if (O00000oo10 == null) {
                                                                        return null;
                                                                    }
                                                                    String format2 = String.format("%d %d %d", Integer.valueOf(O00000oo10[0]), Integer.valueOf(O00000oo10[1]), Integer.valueOf(O00000oo10[2]));
                                                                    if (format2.equals("0 0 0")) {
                                                                        return str2;
                                                                    }
                                                                    if (format2.equals("-2 -2 1")) {
                                                                        return "Off";
                                                                    }
                                                                    if (format2.equals("-1 -2 1")) {
                                                                        return "Low";
                                                                    }
                                                                    if (format2.equals("0 -2 1")) {
                                                                        return "Standard";
                                                                    }
                                                                    if (format2.equals("1 -2 1")) {
                                                                        return "High";
                                                                    }
                                                                    return "Unknown (" + format2 + ")";
                                                                default:
                                                                    switch (i2) {
                                                                        case 1324:
                                                                            return O0000O0o(1324);
                                                                        case 1325:
                                                                            int[] O00000oo11 = ((aag) this.f2602O000000o).O00000oo(1325);
                                                                            if (O00000oo11 == null) {
                                                                                return null;
                                                                            }
                                                                            String format3 = String.format("%d %d %d", Integer.valueOf(O00000oo11[0]), Integer.valueOf(O00000oo11[1]), Integer.valueOf(O00000oo11[2]));
                                                                            if (format3.equals("0 0 0")) {
                                                                                return str2;
                                                                            }
                                                                            if (format3.equals("-1 -1 1")) {
                                                                                return "Low";
                                                                            }
                                                                            if (format3.equals("0 -1 1")) {
                                                                                return "Standard";
                                                                            }
                                                                            if (format3.equals("1 -1 1")) {
                                                                                return "High";
                                                                            }
                                                                            return "Unknown (" + format3 + ")";
                                                                        case 1326:
                                                                            return O0000Oo();
                                                                        case 1327:
                                                                            return O0000OoO();
                                                                        default:
                                                                            return super.O000000o(i);
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    int[] O00000oo12 = ((aag) this.f2602O000000o).O00000oo(1537);
                    if (O00000oo12 == null) {
                        return null;
                    }
                    if (O00000oo12.length == 0 || O00000oo12[0] == 0) {
                        return "Off";
                    }
                    int i12 = O00000oo12[0];
                    if (i12 == 1) {
                        str = "Left to Right";
                    } else if (i12 == 2) {
                        str = "Right to Left";
                    } else if (i12 == 3) {
                        str = "Bottom to Top";
                    } else if (i12 != 4) {
                        str = "Unknown (" + O00000oo12[0] + ")";
                    } else {
                        str = "Top to Bottom";
                    }
                    return String.format("%s, Shot %d", str, Integer.valueOf(O00000oo12[1]));
                }
            }
        }
        return O000000o(0, 4);
    }

    private String O00000oo() {
        Object O0000o0o = ((aag) this.f2602O000000o).O0000o0o(772);
        if (O0000o0o == null || !(O0000o0o instanceof long[])) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (long j : (long[]) O0000o0o) {
            if (j != 0) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                if (j == 913916549) {
                    sb.append("Left ");
                } else if (j == 2038007173) {
                    sb.append("Center ");
                } else if (j == 3178875269L) {
                    sb.append("Right ");
                }
                sb.append(String.format("(%d/255,%d/255)-(%d/255,%d/255)", Long.valueOf((j >> 24) & 255), Long.valueOf((j >> 16) & 255), Long.valueOf((j >> 8) & 255), Long.valueOf(j & 255)));
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private String O0000O0o() {
        int[] O00000oo = ((aag) this.f2602O000000o).O00000oo(1028);
        if (O00000oo == null || O00000oo.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = O00000oo[0];
        if (i == 0) {
            sb.append("Off");
        } else if (i == 3) {
            sb.append("TTL");
        } else if (i == 4) {
            sb.append("Auto");
        } else if (i != 5) {
            sb.append("Unknown (");
            sb.append(O00000oo[0]);
            sb.append(")");
        } else {
            sb.append("Manual");
        }
        for (int i2 = 1; i2 < O00000oo.length; i2++) {
            sb.append("; ");
            sb.append(O00000oo[i2]);
        }
        return sb.toString();
    }

    private String O0000OOo() {
        Rational[] O0000o00 = ((aag) this.f2602O000000o).O0000o00(1029);
        if (O0000o00 == null || O0000o00.length == 0) {
            return null;
        }
        if (O0000o00.length == 3) {
            if (O0000o00[0]._denominator == 0 && O0000o00[1]._denominator == 0 && O0000o00[2]._denominator == 0) {
                return "n/a";
            }
        } else if (O0000o00.length == 4 && O0000o00[0]._denominator == 0 && O0000o00[1]._denominator == 0 && O0000o00[2]._denominator == 0 && O0000o00[3]._denominator == 0) {
            return "n/a (x4)";
        }
        StringBuilder sb = new StringBuilder();
        for (Rational append : O0000o00) {
            sb.append(append);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String O0000Oo0() {
        Rational[] O0000o00 = ((aag) this.f2602O000000o).O0000o00(1030);
        if (O0000o00 == null || O0000o00.length == 0) {
            return "n/a";
        }
        if (O0000o00.length == 3) {
            if (O0000o00[0]._denominator == 0 && O0000o00[1]._denominator == 0 && O0000o00[2]._denominator == 0) {
                return "n/a";
            }
        } else if (O0000o00.length == 4 && O0000o00[0]._denominator == 0 && O0000o00[1]._denominator == 0 && O0000o00[2]._denominator == 0 && O0000o00[3]._denominator == 0) {
            return "n/a (x4)";
        }
        StringBuilder sb = new StringBuilder();
        for (Rational append : O0000o00) {
            sb.append(append);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String O0000Oo() {
        int[] O00000oo = ((aag) this.f2602O000000o).O00000oo(1326);
        if (O00000oo == null || O00000oo.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < O00000oo.length; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 12 || i == 16 || i == 20 || i == 24) {
                sb.append(O00000o0.get(Integer.valueOf(O00000oo[i])));
                sb.append("; ");
            } else {
                sb.append(O00000oo[i]);
                sb.append("; ");
            }
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String O0000OoO() {
        int[] O00000oo = ((aag) this.f2602O000000o).O00000oo(1327);
        if (O00000oo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < O00000oo.length; i++) {
            if (i == 0) {
                sb.append(O00000o.containsKey(Integer.valueOf(O00000oo[i])) ? O00000o.get(Integer.valueOf(O00000oo[i])) : "[unknown]");
                sb.append("; ");
            } else if (i == 3) {
                sb.append("Partial Color ");
                sb.append(O00000oo[i]);
                sb.append("; ");
            } else if (i == 4) {
                switch (O00000oo[i]) {
                    case 0:
                        sb.append("No Effect");
                        break;
                    case 32784:
                        sb.append("Star Light");
                        break;
                    case 32800:
                        sb.append("Pin Hole");
                        break;
                    case 32816:
                        sb.append("Frame");
                        break;
                    case 32832:
                        sb.append("Soft Focus");
                        break;
                    case 32848:
                        sb.append("White Edge");
                        break;
                    case 32864:
                        sb.append("B&W");
                        break;
                    default:
                        sb.append("Unknown (");
                        sb.append(O00000oo[i]);
                        sb.append(")");
                        break;
                }
                sb.append("; ");
            } else if (i == 6) {
                int i2 = O00000oo[i];
                if (i2 == 0) {
                    sb.append("No Color Filter");
                } else if (i2 == 1) {
                    sb.append("Yellow Color Filter");
                } else if (i2 == 2) {
                    sb.append("Orange Color Filter");
                } else if (i2 == 3) {
                    sb.append("Red Color Filter");
                } else if (i2 != 4) {
                    sb.append("Unknown (");
                    sb.append(O00000oo[i]);
                    sb.append(")");
                } else {
                    sb.append("Green Color Filter");
                }
                sb.append("; ");
            } else {
                sb.append(O00000oo[i]);
                sb.append("; ");
            }
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String O0000Ooo() {
        int[] O00000oo = ((aag) this.f2602O000000o).O00000oo(1330);
        if (O00000oo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < O00000oo.length; i++) {
            if (i == 0) {
                sb.append("Color ");
                sb.append(O00000oo[i]);
                sb.append("; ");
            } else if (i == 3) {
                sb.append("Strength ");
                sb.append(O00000oo[i]);
                sb.append("; ");
            } else {
                sb.append(O00000oo[i]);
                sb.append("; ");
            }
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String O00000oo(int i) {
        int[] O00000oo = ((aag) this.f2602O000000o).O00000oo(i);
        if (O00000oo == null || O00000oo.length < 3) {
            return null;
        }
        return String.format("%d (min %d, max %d)", Integer.valueOf(O00000oo[0]), Integer.valueOf(O00000oo[1]), Integer.valueOf(O00000oo[2]));
    }

    private String O0000O0o(int i) {
        int[] O00000oo = ((aag) this.f2602O000000o).O00000oo(i);
        if (O00000oo == null || O00000oo.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < O00000oo.length; i2++) {
            if (i2 == 0) {
                sb.append(O00000o.containsKey(Integer.valueOf(O00000oo[i2])) ? O00000o.get(Integer.valueOf(O00000oo[i2])) : "[unknown]");
            } else {
                sb.append(O00000oo[i2]);
            }
            sb.append("; ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O00000o = hashMap;
        hashMap.put(0, "Off");
        O00000o.put(1, "Soft Focus");
        O00000o.put(2, "Pop Art");
        O00000o.put(3, "Pale & Light Color");
        O00000o.put(4, "Light Tone");
        O00000o.put(5, "Pin Hole");
        O00000o.put(6, "Grainy Film");
        O00000o.put(9, "Diorama");
        O00000o.put(10, "Cross Process");
        O00000o.put(12, "Fish Eye");
        O00000o.put(13, "Drawing");
        O00000o.put(14, "Gentle Sepia");
        O00000o.put(15, "Pale & Light Color II");
        O00000o.put(16, "Pop Art II");
        O00000o.put(17, "Pin Hole II");
        O00000o.put(18, "Pin Hole III");
        O00000o.put(19, "Grainy Film II");
        O00000o.put(20, "Dramatic Tone");
        O00000o.put(21, "Punk");
        O00000o.put(22, "Soft Focus 2");
        O00000o.put(23, "Sparkle");
        O00000o.put(24, "Watercolor");
        O00000o.put(25, "Key Line");
        O00000o.put(26, "Key Line II");
        O00000o.put(27, "Miniature");
        O00000o.put(28, "Reflection");
        O00000o.put(29, "Fragmented");
        O00000o.put(31, "Cross Process II");
        O00000o.put(32, "Dramatic Tone II");
        O00000o.put(33, "Watercolor I");
        O00000o.put(34, "Watercolor II");
        O00000o.put(35, "Diorama II");
        O00000o.put(36, "Vintage");
        O00000o.put(37, "Vintage II");
        O00000o.put(38, "Vintage III");
        O00000o.put(39, "Partial Color");
        O00000o.put(40, "Partial Color II");
        O00000o.put(41, "Partial Color III");
        O00000o0.put(0, "0");
        O00000o0.put(-31999, "Highlights ");
        O00000o0.put(-31998, "Shadows ");
        O00000o0.put(-31997, "Midtones ");
    }
}

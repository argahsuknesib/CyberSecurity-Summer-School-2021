package _m_j;

import com.google.android.gms.common.internal.GmsLogger;
import java.text.DecimalFormat;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class zl extends xx<zm> {
    private static final HashMap<Integer, String> O00000o0;

    public zl(zm zmVar) {
        super(zmVar);
    }

    public final String O000000o(int i) {
        boolean z = false;
        switch (i) {
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                Integer O00000o02 = ((zm) this.f2602O000000o).O00000o0(12);
                if (O00000o02 == null) {
                    return null;
                }
                return String.format("%04X%05d", Integer.valueOf((O00000o02.intValue() >> 8) & 255), Integer.valueOf(O00000o02.intValue() & 255));
            case 49415:
                return O000000o(49415, "One-shot", "AI Servo", "AI Focus", "Manual Focus", "Single", "Continuous", "Manual Focus");
            case 49449:
                Integer O00000o03 = ((zm) this.f2602O000000o).O00000o0(49449);
                if (O00000o03 == null) {
                    return null;
                }
                if (O00000o03.intValue() == 32767) {
                    return "n/a";
                }
                return O00000o03.toString();
            case 49453:
                return O000000o(49453, 0, "n/a", "sRAW1 (mRAW)", "sRAW2 (sRAW)");
            case 49671:
                return O000000o(49671, "Auto", "Sunny", "Cloudy", "Tungsten", "Florescent", "Flash", "Custom");
            case 53770:
                return O00000oo();
            default:
                switch (i) {
                    case 49409:
                        return O000000o(49409, 1, "Macro", "Normal");
                    case 49410:
                        Integer O00000o04 = ((zm) this.f2602O000000o).O00000o0(49410);
                        if (O00000o04 == null) {
                            return null;
                        }
                        if (O00000o04.intValue() == 0) {
                            return "Self timer not used";
                        }
                        DecimalFormat decimalFormat = new DecimalFormat("0.##");
                        StringBuilder sb = new StringBuilder();
                        double intValue = (double) O00000o04.intValue();
                        Double.isNaN(intValue);
                        sb.append(decimalFormat.format(intValue * 0.1d));
                        sb.append(" sec");
                        return sb.toString();
                    case 49411:
                        return O000000o(49411, 2, "Normal", "Fine", null, "Superfine");
                    case 49412:
                        Integer O00000o05 = ((zm) this.f2602O000000o).O00000o0(49412);
                        if (O00000o05 == null) {
                            return null;
                        }
                        int intValue2 = O00000o05.intValue();
                        if (intValue2 == 16) {
                            return "External flash";
                        }
                        switch (intValue2) {
                            case 0:
                                return "No flash fired";
                            case 1:
                                return "Auto";
                            case 2:
                                return "On";
                            case 3:
                                return "Red-eye reduction";
                            case 4:
                                return "Slow-synchro";
                            case 5:
                                return "Auto and red-eye reduction";
                            case 6:
                                return "On and red-eye reduction";
                            default:
                                return "Unknown (" + O00000o05 + ")";
                        }
                    case 49413:
                        Integer O00000o06 = ((zm) this.f2602O000000o).O00000o0(49413);
                        if (O00000o06 == null) {
                            return null;
                        }
                        int intValue3 = O00000o06.intValue();
                        if (intValue3 == 0) {
                            Integer O00000o07 = ((zm) this.f2602O000000o).O00000o0(49410);
                            if (O00000o07 != null) {
                                return O00000o07.intValue() == 0 ? "Single shot" : "Single shot with self-timer";
                            }
                            return "Continuous";
                        } else if (intValue3 == 1) {
                            return "Continuous";
                        } else {
                            return "Unknown (" + O00000o06 + ")";
                        }
                    default:
                        switch (i) {
                            case 49417:
                                return O000000o(49417, 1, "JPEG", "CRW+THM", "AVI+THM", "TIF", "TIF+JPEG", "CR2", "CR2+JPEG", null, "MOV", "MP4");
                            case 49418:
                                return O000000o(49418, "Large", "Medium", "Small");
                            case 49419:
                                return O000000o(49419, "Full auto", "Manual", "Landscape", "Fast shutter", "Slow shutter", "Night", "B&W", "Sepia", "Portrait", "Sports", "Macro / Closeup", "Pan focus");
                            case 49420:
                                return O000000o(49420, "No digital zoom", "2x", "4x");
                            case 49421:
                                Integer O00000o08 = ((zm) this.f2602O000000o).O00000o0(49421);
                                if (O00000o08 == null) {
                                    return null;
                                }
                                int intValue4 = O00000o08.intValue();
                                if (intValue4 == 0) {
                                    return "Normal";
                                }
                                if (intValue4 == 1) {
                                    return "High";
                                }
                                if (intValue4 == 65535) {
                                    return "Low";
                                }
                                return "Unknown (" + O00000o08 + ")";
                            case 49422:
                                Integer O00000o09 = ((zm) this.f2602O000000o).O00000o0(49422);
                                if (O00000o09 == null) {
                                    return null;
                                }
                                int intValue5 = O00000o09.intValue();
                                if (intValue5 == 0) {
                                    return "Normal";
                                }
                                if (intValue5 == 1) {
                                    return "High";
                                }
                                if (intValue5 == 65535) {
                                    return "Low";
                                }
                                return "Unknown (" + O00000o09 + ")";
                            case 49423:
                                Integer O00000o010 = ((zm) this.f2602O000000o).O00000o0(49423);
                                if (O00000o010 == null) {
                                    return null;
                                }
                                int intValue6 = O00000o010.intValue();
                                if (intValue6 == 0) {
                                    return "Normal";
                                }
                                if (intValue6 == 1) {
                                    return "High";
                                }
                                if (intValue6 == 65535) {
                                    return "Low";
                                }
                                return "Unknown (" + O00000o010 + ")";
                            case 49424:
                                Integer O00000o011 = ((zm) this.f2602O000000o).O00000o0(49424);
                                if (O00000o011 == null) {
                                    return null;
                                }
                                if ((O00000o011.intValue() & 16384) != 0) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(O00000o011.intValue() & -16385);
                                    return sb2.toString();
                                }
                                int intValue7 = O00000o011.intValue();
                                if (intValue7 == 0) {
                                    return "Not specified (see ISOSpeedRatings tag)";
                                }
                                switch (intValue7) {
                                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                                        return "Auto";
                                    case 16:
                                        return "50";
                                    case 17:
                                        return "100";
                                    case 18:
                                        return "200";
                                    case 19:
                                        return "400";
                                    default:
                                        return "Unknown (" + O00000o011 + ")";
                                }
                            case 49425:
                                return O000000o(49425, 3, "Evaluative", "Partial", "Centre weighted");
                            case 49426:
                                Integer O00000o012 = ((zm) this.f2602O000000o).O00000o0(49426);
                                if (O00000o012 == null) {
                                    return null;
                                }
                                int intValue8 = O00000o012.intValue();
                                if (intValue8 == 0) {
                                    return "Manual";
                                }
                                if (intValue8 == 1) {
                                    return "Auto";
                                }
                                if (intValue8 == 3) {
                                    return "Close-up (Macro)";
                                }
                                if (intValue8 == 8) {
                                    return "Locked (Pan Mode)";
                                }
                                return "Unknown (" + O00000o012 + ")";
                            case 49427:
                                return O000000o(49427, 12288, "None (MF)", "Auto selected", "Right", "Centre", "Left");
                            case 49428:
                                return O000000o(49428, "Easy shooting", "Program", "Tv-priority", "Av-priority", "Manual", "A-DEP");
                            default:
                                switch (i) {
                                    case 49430:
                                        Integer O00000o013 = ((zm) this.f2602O000000o).O00000o0(49430);
                                        if (O00000o013 == null) {
                                            return null;
                                        }
                                        if (O00000o0.containsKey(O00000o013)) {
                                            return O00000o0.get(O00000o013);
                                        }
                                        return String.format("Unknown (%d)", O00000o013);
                                    case 49431:
                                        Integer O00000o014 = ((zm) this.f2602O000000o).O00000o0(49431);
                                        if (O00000o014 == null) {
                                            return null;
                                        }
                                        String O0000O0o = O0000O0o();
                                        return Integer.toString(O00000o014.intValue()) + " " + O0000O0o;
                                    case 49432:
                                        Integer O00000o015 = ((zm) this.f2602O000000o).O00000o0(49432);
                                        if (O00000o015 == null) {
                                            return null;
                                        }
                                        String O0000O0o2 = O0000O0o();
                                        return Integer.toString(O00000o015.intValue()) + " " + O0000O0o2;
                                    case 49433:
                                        return O0000O0o();
                                    case 49434:
                                        Integer O00000o016 = ((zm) this.f2602O000000o).O00000o0(49434);
                                        if (O00000o016 == null) {
                                            return null;
                                        }
                                        if (O00000o016.intValue() <= 512) {
                                            return O000000o(Math.exp((O00000oo(O00000o016.intValue()) * Math.log(2.0d)) / 2.0d));
                                        }
                                        return String.format("Unknown (%d)", O00000o016);
                                    case 49435:
                                        Integer O00000o017 = ((zm) this.f2602O000000o).O00000o0(49435);
                                        if (O00000o017 == null) {
                                            return null;
                                        }
                                        if (O00000o017.intValue() <= 512) {
                                            return O000000o(Math.exp((O00000oo(O00000o017.intValue()) * Math.log(2.0d)) / 2.0d));
                                        }
                                        return String.format("Unknown (%d)", O00000o017);
                                    case 49436:
                                        return O000000o(49436, "Flash did not fire", "Flash fired");
                                    case 49437:
                                        Integer O00000o018 = ((zm) this.f2602O000000o).O00000o0(49437);
                                        if (O00000o018 == null) {
                                            return null;
                                        }
                                        if (((O00000o018.intValue() >> 14) & 1) != 0) {
                                            return "External E-TTL";
                                        }
                                        if (((O00000o018.intValue() >> 13) & 1) != 0) {
                                            return "Internal flash";
                                        }
                                        if (((O00000o018.intValue() >> 11) & 1) != 0) {
                                            return "FP sync used";
                                        }
                                        if (((O00000o018.intValue() >> 4) & 1) != 0) {
                                            return "FP sync enabled";
                                        }
                                        return "Unknown (" + O00000o018 + ")";
                                    case 49438:
                                        return O000000o(49438, 0, "Single", "Continuous", null, null, null, null, null, null, "Manual");
                                    case 49439:
                                        return O000000o(49439, 0, "Normal AE", "Exposure Compensation", "AE Lock", "AE Lock + Exposure Comp.", "No AE");
                                    case 49440:
                                        return O000000o(49440, "Single", "Continuous");
                                    case 49441:
                                        Integer O00000o019 = ((zm) this.f2602O000000o).O00000o0(49441);
                                        if (O00000o019 == null) {
                                            return null;
                                        }
                                        if (O00000o019.intValue() == 65535) {
                                            return O00000o019.toString();
                                        }
                                        return O000000o((double) (((float) O00000o019.intValue()) / 10.0f));
                                    default:
                                        switch (i) {
                                            case 49445:
                                                return O000000o(49445, 0, "Center", "AF Point");
                                            case 49446:
                                                Integer O00000o020 = ((zm) this.f2602O000000o).O00000o0(49446);
                                                if (O00000o020 == null) {
                                                    return null;
                                                }
                                                int intValue9 = O00000o020.intValue();
                                                if (intValue9 == 100) {
                                                    return "My Color Data";
                                                }
                                                switch (intValue9) {
                                                    case 0:
                                                        return "Off";
                                                    case 1:
                                                        return "Vivid";
                                                    case 2:
                                                        return "Neutral";
                                                    case 3:
                                                        return "Smooth";
                                                    case 4:
                                                        return "Sepia";
                                                    case 5:
                                                        return "B&W";
                                                    case 6:
                                                        return "Custom";
                                                    default:
                                                        return "Unknown (" + O00000o020 + ")";
                                                }
                                            case 49447:
                                                Integer O00000o021 = ((zm) this.f2602O000000o).O00000o0(49447);
                                                if (O00000o021 == null) {
                                                    return null;
                                                }
                                                int intValue10 = O00000o021.intValue();
                                                if (intValue10 == 0) {
                                                    return "n/a";
                                                }
                                                if (intValue10 == 1280) {
                                                    return "Full";
                                                }
                                                if (intValue10 == 1282) {
                                                    return "Medium";
                                                }
                                                if (intValue10 == 1284) {
                                                    return "Low";
                                                }
                                                if (intValue10 == 32767) {
                                                    return "n/a";
                                                }
                                                return "Unknown (" + O00000o021 + ")";
                                            default:
                                                switch (i) {
                                                    case 49678:
                                                        Integer O00000o022 = ((zm) this.f2602O000000o).O00000o0(49678);
                                                        if (O00000o022 == null) {
                                                            return null;
                                                        }
                                                        if ((O00000o022.intValue() & 7) == 0) {
                                                            return "Right";
                                                        }
                                                        if ((O00000o022.intValue() & 7) == 1) {
                                                            return "Centre";
                                                        }
                                                        if ((O00000o022.intValue() & 7) == 2) {
                                                            return "Left";
                                                        }
                                                        return "Unknown (" + O00000o022 + ")";
                                                    case 49679:
                                                        Integer O00000o023 = ((zm) this.f2602O000000o).O00000o0(49679);
                                                        if (O00000o023 == null) {
                                                            return null;
                                                        }
                                                        if (O00000o023.intValue() > 61440) {
                                                            O00000o023 = Integer.valueOf((65535 - O00000o023.intValue()) + 1);
                                                            z = true;
                                                        }
                                                        StringBuilder sb3 = new StringBuilder();
                                                        sb3.append(z ? "-" : "");
                                                        sb3.append(Float.toString(((float) O00000o023.intValue()) / 32.0f));
                                                        sb3.append(" EV");
                                                        return sb3.toString();
                                                    default:
                                                        return super.O000000o(i);
                                                }
                                        }
                                }
                        }
                }
        }
    }

    private String O00000oo() {
        Integer O00000o02 = ((zm) this.f2602O000000o).O00000o0(53770);
        if (O00000o02 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if ((O00000o02.intValue() & (1 << i)) != 0) {
                if (sb.length() != 0) {
                    sb.append(',');
                }
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "None" : sb.toString();
    }

    private String O0000O0o() {
        Integer O00000o02 = ((zm) this.f2602O000000o).O00000o0(49433);
        if (O00000o02 == null) {
            return null;
        }
        return O00000o02.intValue() != 0 ? Integer.toString(O00000o02.intValue()) : "";
    }

    private static double O00000oo(int i) {
        int i2;
        if (i < 0) {
            i = -i;
            i2 = -1;
        } else {
            i2 = 1;
        }
        int i3 = i & 31;
        int i4 = i - i3;
        if (i3 == 12) {
            i3 = 10;
        } else if (i3 == 20) {
            i3 = 21;
        }
        double d = (double) (i2 * (i4 + i3));
        Double.isNaN(d);
        return d / 32.0d;
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O00000o0 = hashMap;
        hashMap.put(1, "Canon EF 50mm f/1.8");
        O00000o0.put(2, "Canon EF 28mm f/2.8");
        O00000o0.put(3, "Canon EF 135mm f/2.8 Soft");
        O00000o0.put(4, "Canon EF 35-105mm f/3.5-4.5 or Sigma Lens");
        O00000o0.put(5, "Canon EF 35-70mm f/3.5-4.5");
        O00000o0.put(6, "Canon EF 28-70mm f/3.5-4.5 or Sigma or Tokina Lens");
        O00000o0.put(7, "Canon EF 100-300mm f/5.6L");
        O00000o0.put(8, "Canon EF 100-300mm f/5.6 or Sigma or Tokina Lens");
        O00000o0.put(9, "Canon EF 70-210mm f/4");
        O00000o0.put(10, "Canon EF 50mm f/2.5 Macro or Sigma Lens");
        O00000o0.put(11, "Canon EF 35mm f/2");
        O00000o0.put(13, "Canon EF 15mm f/2.8 Fisheye");
        O00000o0.put(14, "Canon EF 50-200mm f/3.5-4.5L");
        O00000o0.put(15, "Canon EF 50-200mm f/3.5-4.5");
        O00000o0.put(16, "Canon EF 35-135mm f/3.5-4.5");
        O00000o0.put(17, "Canon EF 35-70mm f/3.5-4.5A");
        O00000o0.put(18, "Canon EF 28-70mm f/3.5-4.5");
        O00000o0.put(20, "Canon EF 100-200mm f/4.5A");
        O00000o0.put(21, "Canon EF 80-200mm f/2.8L");
        O00000o0.put(22, "Canon EF 20-35mm f/2.8L or Tokina Lens");
        O00000o0.put(23, "Canon EF 35-105mm f/3.5-4.5");
        O00000o0.put(24, "Canon EF 35-80mm f/4-5.6 Power Zoom");
        O00000o0.put(25, "Canon EF 35-80mm f/4-5.6 Power Zoom");
        O00000o0.put(26, "Canon EF 100mm f/2.8 Macro or Other Lens");
        O00000o0.put(27, "Canon EF 35-80mm f/4-5.6");
        O00000o0.put(28, "Canon EF 80-200mm f/4.5-5.6 or Tamron Lens");
        O00000o0.put(29, "Canon EF 50mm f/1.8 II");
        O00000o0.put(30, "Canon EF 35-105mm f/4.5-5.6");
        O00000o0.put(31, "Canon EF 75-300mm f/4-5.6 or Tamron Lens");
        O00000o0.put(32, "Canon EF 24mm f/2.8 or Sigma Lens");
        O00000o0.put(33, "Voigtlander or Carl Zeiss Lens");
        O00000o0.put(35, "Canon EF 35-80mm f/4-5.6");
        O00000o0.put(36, "Canon EF 38-76mm f/4.5-5.6");
        O00000o0.put(37, "Canon EF 35-80mm f/4-5.6 or Tamron Lens");
        O00000o0.put(38, "Canon EF 80-200mm f/4.5-5.6");
        O00000o0.put(39, "Canon EF 75-300mm f/4-5.6");
        O00000o0.put(40, "Canon EF 28-80mm f/3.5-5.6");
        O00000o0.put(41, "Canon EF 28-90mm f/4-5.6");
        O00000o0.put(42, "Canon EF 28-200mm f/3.5-5.6 or Tamron Lens");
        O00000o0.put(43, "Canon EF 28-105mm f/4-5.6");
        O00000o0.put(44, "Canon EF 90-300mm f/4.5-5.6");
        O00000o0.put(45, "Canon EF-S 18-55mm f/3.5-5.6 [II]");
        O00000o0.put(46, "Canon EF 28-90mm f/4-5.6");
        O00000o0.put(47, "Zeiss Milvus 35mm f/2 or 50mm f/2");
        O00000o0.put(48, "Canon EF-S 18-55mm f/3.5-5.6 IS");
        O00000o0.put(49, "Canon EF-S 55-250mm f/4-5.6 IS");
        O00000o0.put(50, "Canon EF-S 18-200mm f/3.5-5.6 IS");
        O00000o0.put(51, "Canon EF-S 18-135mm f/3.5-5.6 IS");
        O00000o0.put(52, "Canon EF-S 18-55mm f/3.5-5.6 IS II");
        O00000o0.put(53, "Canon EF-S 18-55mm f/3.5-5.6 III");
        O00000o0.put(54, "Canon EF-S 55-250mm f/4-5.6 IS II");
        O00000o0.put(94, "Canon TS-E 17mm f/4L");
        O00000o0.put(95, "Canon TS-E 24.0mm f/3.5 L II");
        O00000o0.put(124, "Canon MP-E 65mm f/2.8 1-5x Macro Photo");
        O00000o0.put(125, "Canon TS-E 24mm f/3.5L");
        O00000o0.put(126, "Canon TS-E 45mm f/2.8");
        O00000o0.put(127, "Canon TS-E 90mm f/2.8");
        O00000o0.put(129, "Canon EF 300mm f/2.8L");
        O00000o0.put(130, "Canon EF 50mm f/1.0L");
        O00000o0.put(131, "Canon EF 28-80mm f/2.8-4L or Sigma Lens");
        O00000o0.put(132, "Canon EF 1200mm f/5.6L");
        O00000o0.put(134, "Canon EF 600mm f/4L IS");
        O00000o0.put(135, "Canon EF 200mm f/1.8L");
        O00000o0.put(136, "Canon EF 300mm f/2.8L");
        O00000o0.put(137, "Canon EF 85mm f/1.2L or Sigma or Tamron Lens");
        O00000o0.put(138, "Canon EF 28-80mm f/2.8-4L");
        O00000o0.put(139, "Canon EF 400mm f/2.8L");
        O00000o0.put(140, "Canon EF 500mm f/4.5L");
        O00000o0.put(141, "Canon EF 500mm f/4.5L");
        O00000o0.put(142, "Canon EF 300mm f/2.8L IS");
        O00000o0.put(143, "Canon EF 500mm f/4L IS or Sigma Lens");
        O00000o0.put(144, "Canon EF 35-135mm f/4-5.6 USM");
        O00000o0.put(145, "Canon EF 100-300mm f/4.5-5.6 USM");
        O00000o0.put(146, "Canon EF 70-210mm f/3.5-4.5 USM");
        O00000o0.put(147, "Canon EF 35-135mm f/4-5.6 USM");
        O00000o0.put(148, "Canon EF 28-80mm f/3.5-5.6 USM");
        O00000o0.put(149, "Canon EF 100mm f/2 USM");
        O00000o0.put(150, "Canon EF 14mm f/2.8L or Sigma Lens");
        O00000o0.put(151, "Canon EF 200mm f/2.8L");
        O00000o0.put(152, "Canon EF 300mm f/4L IS or Sigma Lens");
        O00000o0.put(153, "Canon EF 35-350mm f/3.5-5.6L or Sigma or Tamron Lens");
        O00000o0.put(154, "Canon EF 20mm f/2.8 USM or Zeiss Lens");
        O00000o0.put(155, "Canon EF 85mm f/1.8 USM");
        O00000o0.put(156, "Canon EF 28-105mm f/3.5-4.5 USM or Tamron Lens");
        O00000o0.put(160, "Canon EF 20-35mm f/3.5-4.5 USM or Tamron or Tokina Lens");
        O00000o0.put(161, "Canon EF 28-70mm f/2.8L or Sigma or Tamron Lens");
        O00000o0.put(162, "Canon EF 200mm f/2.8L");
        O00000o0.put(163, "Canon EF 300mm f/4L");
        O00000o0.put(164, "Canon EF 400mm f/5.6L");
        O00000o0.put(165, "Canon EF 70-200mm f/2.8 L");
        O00000o0.put(166, "Canon EF 70-200mm f/2.8 L + 1.4x");
        O00000o0.put(167, "Canon EF 70-200mm f/2.8 L + 2x");
        O00000o0.put(168, "Canon EF 28mm f/1.8 USM or Sigma Lens");
        O00000o0.put(169, "Canon EF 17-35mm f/2.8L or Sigma Lens");
        O00000o0.put(170, "Canon EF 200mm f/2.8L II");
        O00000o0.put(171, "Canon EF 300mm f/4L");
        O00000o0.put(172, "Canon EF 400mm f/5.6L or Sigma Lens");
        O00000o0.put(173, "Canon EF 180mm Macro f/3.5L or Sigma Lens");
        O00000o0.put(174, "Canon EF 135mm f/2L or Other Lens");
        O00000o0.put(175, "Canon EF 400mm f/2.8L");
        O00000o0.put(176, "Canon EF 24-85mm f/3.5-4.5 USM");
        O00000o0.put(177, "Canon EF 300mm f/4L IS");
        O00000o0.put(178, "Canon EF 28-135mm f/3.5-5.6 IS");
        O00000o0.put(179, "Canon EF 24mm f/1.4L");
        O00000o0.put(180, "Canon EF 35mm f/1.4L or Other Lens");
        O00000o0.put(181, "Canon EF 100-400mm f/4.5-5.6L IS + 1.4x or Sigma Lens");
        O00000o0.put(182, "Canon EF 100-400mm f/4.5-5.6L IS + 2x or Sigma Lens");
        O00000o0.put(183, "Canon EF 100-400mm f/4.5-5.6L IS or Sigma Lens");
        O00000o0.put(184, "Canon EF 400mm f/2.8L + 2x");
        O00000o0.put(185, "Canon EF 600mm f/4L IS");
        O00000o0.put(186, "Canon EF 70-200mm f/4L");
        O00000o0.put(187, "Canon EF 70-200mm f/4L + 1.4x");
        O00000o0.put(188, "Canon EF 70-200mm f/4L + 2x");
        O00000o0.put(189, "Canon EF 70-200mm f/4L + 2.8x");
        O00000o0.put(190, "Canon EF 100mm f/2.8 Macro USM");
        O00000o0.put(191, "Canon EF 400mm f/4 DO IS");
        O00000o0.put(193, "Canon EF 35-80mm f/4-5.6 USM");
        O00000o0.put(194, "Canon EF 80-200mm f/4.5-5.6 USM");
        O00000o0.put(195, "Canon EF 35-105mm f/4.5-5.6 USM");
        O00000o0.put(196, "Canon EF 75-300mm f/4-5.6 USM");
        O00000o0.put(197, "Canon EF 75-300mm f/4-5.6 IS USM");
        O00000o0.put(198, "Canon EF 50mm f/1.4 USM or Zeiss Lens");
        O00000o0.put(199, "Canon EF 28-80mm f/3.5-5.6 USM");
        O00000o0.put(200, "Canon EF 75-300mm f/4-5.6 USM");
        O00000o0.put(201, "Canon EF 28-80mm f/3.5-5.6 USM");
        O00000o0.put(202, "Canon EF 28-80mm f/3.5-5.6 USM IV");
        O00000o0.put(208, "Canon EF 22-55mm f/4-5.6 USM");
        O00000o0.put(209, "Canon EF 55-200mm f/4.5-5.6");
        O00000o0.put(210, "Canon EF 28-90mm f/4-5.6 USM");
        O00000o0.put(211, "Canon EF 28-200mm f/3.5-5.6 USM");
        O00000o0.put(212, "Canon EF 28-105mm f/4-5.6 USM");
        O00000o0.put(213, "Canon EF 90-300mm f/4.5-5.6 USM or Tamron Lens");
        O00000o0.put(214, "Canon EF-S 18-55mm f/3.5-5.6 USM");
        O00000o0.put(215, "Canon EF 55-200mm f/4.5-5.6 II USM");
        O00000o0.put(217, "Tamron AF 18-270mm f/3.5-6.3 Di II VC PZD");
        O00000o0.put(224, "Canon EF 70-200mm f/2.8L IS");
        O00000o0.put(225, "Canon EF 70-200mm f/2.8L IS + 1.4x");
        O00000o0.put(226, "Canon EF 70-200mm f/2.8L IS + 2x");
        O00000o0.put(227, "Canon EF 70-200mm f/2.8L IS + 2.8x");
        O00000o0.put(228, "Canon EF 28-105mm f/3.5-4.5 USM");
        O00000o0.put(229, "Canon EF 16-35mm f/2.8L");
        O00000o0.put(230, "Canon EF 24-70mm f/2.8L");
        O00000o0.put(231, "Canon EF 17-40mm f/4L");
        O00000o0.put(232, "Canon EF 70-300mm f/4.5-5.6 DO IS USM");
        O00000o0.put(233, "Canon EF 28-300mm f/3.5-5.6L IS");
        O00000o0.put(234, "Canon EF-S 17-85mm f/4-5.6 IS USM or Tokina Lens");
        O00000o0.put(235, "Canon EF-S 10-22mm f/3.5-4.5 USM");
        O00000o0.put(236, "Canon EF-S 60mm f/2.8 Macro USM");
        O00000o0.put(237, "Canon EF 24-105mm f/4L IS");
        O00000o0.put(238, "Canon EF 70-300mm f/4-5.6 IS USM");
        O00000o0.put(239, "Canon EF 85mm f/1.2L II");
        O00000o0.put(240, "Canon EF-S 17-55mm f/2.8 IS USM");
        O00000o0.put(241, "Canon EF 50mm f/1.2L");
        O00000o0.put(242, "Canon EF 70-200mm f/4L IS");
        O00000o0.put(243, "Canon EF 70-200mm f/4L IS + 1.4x");
        O00000o0.put(244, "Canon EF 70-200mm f/4L IS + 2x");
        O00000o0.put(245, "Canon EF 70-200mm f/4L IS + 2.8x");
        O00000o0.put(246, "Canon EF 16-35mm f/2.8L II");
        O00000o0.put(247, "Canon EF 14mm f/2.8L II USM");
        O00000o0.put(248, "Canon EF 200mm f/2L IS or Sigma Lens");
        O00000o0.put(249, "Canon EF 800mm f/5.6L IS");
        O00000o0.put(250, "Canon EF 24mm f/1.4L II or Sigma Lens");
        O00000o0.put(251, "Canon EF 70-200mm f/2.8L IS II USM");
        O00000o0.put(252, "Canon EF 70-200mm f/2.8L IS II USM + 1.4x");
        O00000o0.put(253, "Canon EF 70-200mm f/2.8L IS II USM + 2x");
        O00000o0.put(254, "Canon EF 100mm f/2.8L Macro IS USM");
        O00000o0.put(255, "Sigma 24-105mm f/4 DG OS HSM | A or Other Sigma Lens");
        O00000o0.put(488, "Canon EF-S 15-85mm f/3.5-5.6 IS USM");
        O00000o0.put(489, "Canon EF 70-300mm f/4-5.6L IS USM");
        O00000o0.put(490, "Canon EF 8-15mm f/4L Fisheye USM");
        O00000o0.put(491, "Canon EF 300mm f/2.8L IS II USM");
        O00000o0.put(492, "Canon EF 400mm f/2.8L IS II USM");
        O00000o0.put(493, "Canon EF 500mm f/4L IS II USM or EF 24-105mm f4L IS USM");
        O00000o0.put(494, "Canon EF 600mm f/4.0L IS II USM");
        O00000o0.put(495, "Canon EF 24-70mm f/2.8L II USM");
        O00000o0.put(496, "Canon EF 200-400mm f/4L IS USM");
        O00000o0.put(499, "Canon EF 200-400mm f/4L IS USM + 1.4x");
        O00000o0.put(502, "Canon EF 28mm f/2.8 IS USM");
        O00000o0.put(503, "Canon EF 24mm f/2.8 IS USM");
        O00000o0.put(504, "Canon EF 24-70mm f/4L IS USM");
        O00000o0.put(505, "Canon EF 35mm f/2 IS USM");
        O00000o0.put(506, "Canon EF 400mm f/4 DO IS II USM");
        O00000o0.put(507, "Canon EF 16-35mm f/4L IS USM");
        O00000o0.put(508, "Canon EF 11-24mm f/4L USM");
        O00000o0.put(747, "Canon EF 100-400mm f/4.5-5.6L IS II USM");
        O00000o0.put(750, "Canon EF 35mm f/1.4L II USM");
        O00000o0.put(4142, "Canon EF-S 18-135mm f/3.5-5.6 IS STM");
        O00000o0.put(4143, "Canon EF-M 18-55mm f/3.5-5.6 IS STM or Tamron Lens");
        O00000o0.put(4144, "Canon EF 40mm f/2.8 STM");
        O00000o0.put(4145, "Canon EF-M 22mm f/2 STM");
        O00000o0.put(4146, "Canon EF-S 18-55mm f/3.5-5.6 IS STM");
        O00000o0.put(4147, "Canon EF-M 11-22mm f/4-5.6 IS STM");
        O00000o0.put(4148, "Canon EF-S 55-250mm f/4-5.6 IS STM");
        O00000o0.put(4149, "Canon EF-M 55-200mm f/4.5-6.3 IS STM");
        O00000o0.put(4150, "Canon EF-S 10-18mm f/4.5-5.6 IS STM");
        O00000o0.put(4152, "Canon EF 24-105mm f/3.5-5.6 IS STM");
        O00000o0.put(4153, "Canon EF-M 15-45mm f/3.5-6.3 IS STM");
        O00000o0.put(4154, "Canon EF-S 24mm f/2.8 STM");
        O00000o0.put(4156, "Canon EF 50mm f/1.8 STM");
        O00000o0.put(36912, "Canon EF-S 18-135mm f/3.5-5.6 IS USM");
        O00000o0.put(65535, "N/A");
    }
}

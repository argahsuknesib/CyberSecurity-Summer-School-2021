package _m_j;

import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.text.DecimalFormat;

public final class aav extends xx<aaw> {
    private static final String[] O00000o0 = {"Normal", "Portrait", "Scenery", "Sports", "Night Portrait", "Program", "Aperture Priority", "Shutter Priority", "Macro", "Spot", "Manual", "Movie Preview", "Panning", "Simple", "Color Effects", "Self Portrait", "Economy", "Fireworks", "Party", "Snow", "Night Scenery", "Food", "Baby", "Soft Skin", "Candlelight", "Starry Night", "High Sensitivity", "Panorama Assist", "Underwater", "Beach", "Aerial Photo", "Sunset", "Pet", "Intelligent ISO", "Clipboard", "High Speed Continuous Shooting", "Intelligent Auto", null, "Multi-aspect", null, "Transform", "Flash Burst", "Pin Hole", "Film Grain", "My Color", "Photo Frame", null, null, null, null, "HDR"};

    public aav(aaw aaw) {
        super(aaw);
    }

    public final String O000000o(int i) {
        switch (i) {
            case 1:
                return O000000o(1, 2, "High", "Normal", null, null, "Very High", "Raw", null, "Motion Picture");
            case 2:
                return O000000o(2, 2);
            case 3:
                return O000000o(3, 1, "Auto", "Daylight", "Cloudy", "Incandescent", "Manual", null, null, "Flash", null, "Black & White", "Manual", "Shade");
            case 7:
                return O000000o(7, 1, "Auto", "Manual", null, "Auto, Focus Button", "Auto, Continuous");
            case GmsLogger.MAX_PII_TAG_LENGTH:
                int[] O00000oo = ((aaw) this.f2602O000000o).O00000oo(15);
                if (O00000oo == null || O00000oo.length < 2) {
                    return null;
                }
                int i2 = O00000oo[0];
                if (i2 == 0) {
                    int i3 = O00000oo[1];
                    if (i3 == 1) {
                        return "Spot Mode On";
                    }
                    if (i3 == 16) {
                        return "Spot Mode Off";
                    }
                    return "Unknown (" + O00000oo[0] + " " + O00000oo[1] + ")";
                } else if (i2 == 1) {
                    int i4 = O00000oo[1];
                    if (i4 == 0) {
                        return "Spot Focusing";
                    }
                    if (i4 == 1) {
                        return "5-area";
                    }
                    return "Unknown (" + O00000oo[0] + " " + O00000oo[1] + ")";
                } else if (i2 == 16) {
                    int i5 = O00000oo[1];
                    if (i5 == 0) {
                        return "1-area";
                    }
                    if (i5 == 16) {
                        return "1-area (high speed)";
                    }
                    return "Unknown (" + O00000oo[0] + " " + O00000oo[1] + ")";
                } else if (i2 == 32) {
                    int i6 = O00000oo[1];
                    if (i6 == 0) {
                        return "Auto or Face Detect";
                    }
                    if (i6 == 1) {
                        return "3-area (left)";
                    }
                    if (i6 == 2) {
                        return "3-area (center)";
                    }
                    if (i6 == 3) {
                        return "3-area (right)";
                    }
                    return "Unknown (" + O00000oo[0] + " " + O00000oo[1] + ")";
                } else if (i2 == 64) {
                    return "Face Detect";
                } else {
                    return "Unknown (" + O00000oo[0] + " " + O00000oo[1] + ")";
                }
            case 26:
                return O000000o(26, 2, "On, Mode 1", "Off", "On, Mode 2");
            case 28:
                return O000000o(28, 1, "Off", "On");
            case 31:
                return O000000o(31, 1, O00000o0);
            case 32:
                return O000000o(32, 1, "Off", "On");
            case 33:
                return O00000Oo(33);
            case 37:
                return O00000o0();
            case 38:
                return O000000o(38, 2);
            case 40:
                return O000000o(40, 1, "Off", "Warm", "Cool", "Black & White", "Sepia");
            case 41:
                Integer O00000o02 = ((aaw) this.f2602O000000o).O00000o0(41);
                if (O00000o02 == null) {
                    return null;
                }
                return (((float) O00000o02.intValue()) / 100.0f) + " s";
            case 42:
                return O000000o(42, "Off", null, "On", "Indefinite", "Unlimited");
            case 44:
                Integer O00000o03 = ((aaw) this.f2602O000000o).O00000o0(44);
                if (O00000o03 == null) {
                    return null;
                }
                int intValue = O00000o03.intValue();
                if (intValue == 0) {
                    return "Normal";
                }
                if (intValue == 1) {
                    return "Low";
                }
                if (intValue == 2) {
                    return "High";
                }
                if (intValue == 6) {
                    return "Medium Low";
                }
                if (intValue == 7) {
                    return "Medium High";
                }
                if (intValue == 256) {
                    return "Low";
                }
                if (intValue == 272) {
                    return "Normal";
                }
                if (intValue == 288) {
                    return "High";
                }
                return "Unknown (" + O00000o03 + ")";
            case 45:
                return O000000o(45, "Standard (0)", "Low (-1)", "High (+1)", "Lowest (-2)", "Highest (+2)");
            case 46:
                return O000000o(46, 1, "Off", "10 s", "2 s");
            case 48:
                Integer O00000o04 = ((aaw) this.f2602O000000o).O00000o0(48);
                if (O00000o04 == null) {
                    return null;
                }
                int intValue2 = O00000o04.intValue();
                if (intValue2 == 1) {
                    return "Horizontal";
                }
                if (intValue2 == 3) {
                    return "Rotate 180";
                }
                if (intValue2 == 6) {
                    return "Rotate 90 CW";
                }
                if (intValue2 == 8) {
                    return "Rotate 270 CW";
                }
                return "Unknown (" + O00000o04 + ")";
            case 49:
                return O000000o(49, 1, "Fired", "Enabled but not used", "Disabled but required", "Disabled and not required");
            case 50:
                return O000000o(50, "Normal", "Natural", "Vivid");
            case 51:
                xq O0000oOO = ((aaw) this.f2602O000000o).O0000oOO(51);
                if (O0000oOO == null) {
                    return null;
                }
                return O0000oOO.O000000o();
            case 52:
                return O000000o(52, 1, "Standard", "Extended");
            case 53:
                return O000000o(53, 1, "Off", "Wide", "Telephoto", "Macro");
            case 57:
                return O000000o(57, "Normal");
            case 58:
                return O000000o(58, 1, "Home", "Destination");
            case 59:
                return O000000o(59, 1, "Off", "On");
            case 61:
                return O000000o(61, 1, "Normal", "Outdoor/Illuminations/Flower/HDR Art", "Indoor/Architecture/Objects/HDR B&W", "Creative", "Auto", null, "Expressive", "Retro", "Pure", "Elegant", null, "Monochrome", "Dynamic Art", "Silhouette");
            case 62:
                return O000000o(62, 1, "Off", "On");
            case 69:
                return O000000o(69, "No Bracket", "3 Images, Sequence 0/-/+", "3 Images, Sequence -/0/+", "5 Images, Sequence 0/-/+", "5 Images, Sequence -/0/+", "7 Images, Sequence 0/-/+", "7 Images, Sequence -/0/+");
            case 72:
                return O000000o(72, "n/a", "1st", "2nd");
            case 73:
                return O000000o(73, 1, "Off", "On");
            case 78:
                return O000000o(((aaw) this.f2602O000000o).O00000oo());
            case 89:
                return O00000oo(89);
            case 93:
                return O000000o(93, "Off", "Low", "Standard", "High");
            case 96:
                return O00000oo();
            case 97:
                return O000000o(((aaw) this.f2602O000000o).O0000O0o());
            case 98:
                return O000000o(98, "No", "Yes (Flash required but disabled)");
            case 101:
                return O00000Oo(O000000o(101, xf.f2590O000000o));
            case 102:
                return O00000Oo(O000000o(102, xf.f2590O000000o));
            case 103:
                return O00000Oo(O000000o(103, xf.f2590O000000o));
            case 105:
                return O00000Oo(O000000o(105, xf.f2590O000000o));
            case 107:
                return O00000Oo(O000000o(107, xf.f2590O000000o));
            case 109:
                return O00000Oo(O000000o(109, xf.f2590O000000o));
            case 111:
                return O00000Oo(O000000o(111, xf.f2590O000000o));
            case 112:
                return O000000o(112, "Off", null, "Auto", "On");
            case 121:
                return O000000o(121, "Off", "Low", "Standard", "High");
            case 124:
                return O000000o(124, "Off", "On");
            case 137:
                return O000000o(137, "Auto", "Standard or Custom", "Vivid", "Natural", "Monochrome", "Scenery", "Portrait");
            case 138:
                return O000000o(138, "Off", "On");
            case 140:
                Integer O00000o05 = ((aaw) this.f2602O000000o).O00000o0(140);
                if (O00000o05 == null) {
                    return null;
                }
                return String.valueOf((int) O00000o05.shortValue());
            case 141:
                Integer O00000o06 = ((aaw) this.f2602O000000o).O00000o0(141);
                if (O00000o06 == null) {
                    return null;
                }
                return String.valueOf((int) O00000o06.shortValue());
            case 142:
                Integer O00000o07 = ((aaw) this.f2602O000000o).O00000o0(142);
                if (O00000o07 == null) {
                    return null;
                }
                return String.valueOf((int) O00000o07.shortValue());
            case 143:
                return O000000o(143, "Normal", "Rotate CW", "Rotate 180", "Rotate CCW", "Tilt Upwards", "Tile Downwards");
            case 144:
                Integer O00000o08 = ((aaw) this.f2602O000000o).O00000o0(144);
                if (O00000o08 == null) {
                    return null;
                }
                DecimalFormat decimalFormat = new DecimalFormat("0.#");
                double shortValue = (double) O00000o08.shortValue();
                Double.isNaN(shortValue);
                return decimalFormat.format(shortValue / 10.0d);
            case 145:
                Integer O00000o09 = ((aaw) this.f2602O000000o).O00000o0(145);
                if (O00000o09 == null) {
                    return null;
                }
                DecimalFormat decimalFormat2 = new DecimalFormat("0.#");
                double d = (double) (-O00000o09.shortValue());
                Double.isNaN(d);
                return decimalFormat2.format(d / 10.0d);
            case 147:
                return O000000o(147, "Off", "Left to Right", "Right to Left", "Top to Bottom", "Bottom to Top");
            case 150:
                return O000000o(150, "Off", "Time Lapse", "Stop-motion Animation");
            case 158:
                Integer O00000o010 = ((aaw) this.f2602O000000o).O00000o0(158);
                if (O00000o010 == null) {
                    return null;
                }
                int intValue3 = O00000o010.intValue();
                if (intValue3 == 0) {
                    return "Off";
                }
                if (intValue3 == 100) {
                    return "1 EV";
                }
                if (intValue3 == 200) {
                    return "2 EV";
                }
                if (intValue3 == 300) {
                    return "3 EV";
                }
                if (intValue3 == 32868) {
                    return "1 EV (Auto)";
                }
                if (intValue3 == 32968) {
                    return "2 EV (Auto)";
                }
                if (intValue3 == 33068) {
                    return "3 EV (Auto)";
                }
                return String.format("Unknown (%d)", O00000o010);
            case 159:
                return O000000o(159, "Mechanical", "Electronic", "Hybrid");
            case 171:
                return O000000o(171, "Off", "On");
            case 32768:
                return O000000o(32768, 2);
            case 32769:
                return O000000o(32769, 1, O00000o0);
            case 32775:
                return O000000o(32775, 1, "Off", "On");
            case 32776:
                return O000000o(32776, 1, "Off", "On");
            case 32777:
                return O000000o(32777, 1, "Off", "On");
            case 32784:
                xq O0000oOO2 = ((aaw) this.f2602O000000o).O0000oOO(32784);
                if (O0000oOO2 == null) {
                    return null;
                }
                return O0000oOO2.O000000o();
            case 32786:
                return O00000oo(32786);
            default:
                return super.O000000o(i);
        }
    }

    private String O00000oo(int i) {
        byte[] O0000O0o = ((aaw) this.f2602O000000o).O0000O0o(i);
        if (O0000O0o == null) {
            return null;
        }
        xc xcVar = new xc(O0000O0o);
        try {
            int O00000oO = xcVar.O00000oO(0);
            int O00000oO2 = xcVar.O00000oO(2);
            if (O00000oO == -1 && O00000oO2 == 1) {
                return "Slim Low";
            }
            if (O00000oO == -3 && O00000oO2 == 2) {
                return "Slim High";
            }
            if (O00000oO == 0 && O00000oO2 == 0) {
                return "Off";
            }
            if (O00000oO == 1 && O00000oO2 == 1) {
                return "Stretch Low";
            }
            if (O00000oO == 3 && O00000oO2 == 2) {
                return "Stretch High";
            }
            return "Unknown (" + O00000oO + " " + O00000oO2 + ")";
        } catch (IOException unused) {
            return null;
        }
    }

    private static String O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    private String O00000oo() {
        byte[] O0000O0o = ((aaw) this.f2602O000000o).O0000O0o(96);
        if (O0000O0o == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < O0000O0o.length; i++) {
            sb.append((int) O0000O0o[i]);
            if (i < O0000O0o.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static String O000000o(xt[] xtVarArr) {
        if (xtVarArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < xtVarArr.length) {
            sb.append("Face ");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(": ");
            sb.append(xtVarArr[i].toString());
            sb.append("\n");
            i = i2;
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return null;
    }
}

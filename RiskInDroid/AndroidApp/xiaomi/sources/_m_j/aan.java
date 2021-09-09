package _m_j;

import com.drew.lang.Rational;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class aan extends xx<aao> {
    public aan(aao aao) {
        super(aao);
    }

    public final String O000000o(int i) {
        int i2;
        int i3 = i;
        if (i3 == 0) {
            return O000000o(0, 2);
        }
        if (i3 == 519) {
            String O0000o0 = ((aao) this.f2602O000000o).O0000o0(519);
            if (O0000o0 == null) {
                return null;
            }
            return aao.O0000OOo.containsKey(O0000o0) ? aao.O0000OOo.get(O0000o0) : O0000o0;
        } else if (i3 == 521) {
            byte[] O0000O0o = ((aao) this.f2602O000000o).O0000O0o(521);
            if (O0000O0o == null) {
                return null;
            }
            return new String(O0000O0o);
        } else if (i3 == 770) {
            return O000000o(770, "Off", "On", "On (Preset)");
        } else {
            if (i3 == 4100) {
                return O000000o(4100, null, null, "On", "Off");
            }
            if (i3 == 4111) {
                return O000000o(4111, "Normal", "Hard", "Soft");
            }
            if (i3 == 4113) {
                return O00000oo();
            }
            if (i3 == 4117) {
                int[] O00000oo = ((aao) this.f2602O000000o).O00000oo(4117);
                if (O00000oo == null) {
                    return null;
                }
                String format = String.format("%d %d", Integer.valueOf(O00000oo[0]), Integer.valueOf(O00000oo[1]));
                if (format.equals("1 0")) {
                    return "Auto";
                }
                if (format.equals("1 2")) {
                    return "Auto (2)";
                }
                if (format.equals("1 4")) {
                    return "Auto (4)";
                }
                if (format.equals("2 2")) {
                    return "3000 Kelvin";
                }
                if (format.equals("2 3")) {
                    return "3700 Kelvin";
                }
                if (format.equals("2 4")) {
                    return "4000 Kelvin";
                }
                if (format.equals("2 5")) {
                    return "4500 Kelvin";
                }
                if (format.equals("2 6")) {
                    return "5500 Kelvin";
                }
                if (format.equals("2 7")) {
                    return "6500 Kelvin";
                }
                if (format.equals("2 8")) {
                    return "7500 Kelvin";
                }
                if (format.equals("3 0")) {
                    return "One-touch";
                }
                return "Unknown ".concat(String.valueOf(format));
            } else if (i3 == 4137) {
                return O000000o(4137, "High", "Normal", "Low");
            } else {
                if (i3 == 4149) {
                    return O000000o(4149, "No", "Yes");
                }
                if (i3 == 4106) {
                    return O000000o(4106, "Normal", "Macro");
                }
                if (i3 == 4107) {
                    return O000000o(4107, "Auto", "Manual");
                }
                if (i3 == 4119) {
                    int[] O00000oo2 = ((aao) this.f2602O000000o).O00000oo(4119);
                    if (O00000oo2 == null) {
                        return null;
                    }
                    double d = (double) ((short) O00000oo2[0]);
                    Double.isNaN(d);
                    return String.valueOf(d / 256.0d);
                } else if (i3 != 4120) {
                    switch (i3) {
                        case 257:
                            return O000000o(257, "Natural Colour", "Black & White", "Vivid Colour", "Solarization", "AdobeRGB");
                        case 258:
                            return O000000o(258, "Raw", "Super Fine", "Fine", "Standard", "Extra Fine");
                        case 259:
                            return O000000o(259, "Raw", "Super Fine", "Fine", "Standard", "Extra Fine");
                        default:
                            switch (i3) {
                                case 512:
                                    long[] jArr = (long[]) ((aao) this.f2602O000000o).O0000o0o(512);
                                    if (jArr == null) {
                                        return null;
                                    }
                                    if (jArr.length <= 0) {
                                        return "";
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    int i4 = (int) jArr[0];
                                    if (i4 == 0) {
                                        sb.append("Normal picture taking mode");
                                    } else if (i4 == 1) {
                                        sb.append("Unknown picture taking mode");
                                    } else if (i4 == 2) {
                                        sb.append("Fast picture taking mode");
                                    } else if (i4 != 3) {
                                        sb.append("Unknown picture taking mode");
                                    } else {
                                        sb.append("Panorama picture taking mode");
                                    }
                                    if (jArr.length >= 2 && (i2 = (int) jArr[1]) != 0) {
                                        if (i2 == 1) {
                                            sb.append(" / 1st in a sequence");
                                        } else if (i2 == 2) {
                                            sb.append(" / 2nd in a sequence");
                                        } else if (i2 != 3) {
                                            sb.append(" / ");
                                            sb.append(jArr[1]);
                                            sb.append("th in a sequence");
                                        } else {
                                            sb.append(" / 3rd in a sequence");
                                        }
                                    }
                                    if (jArr.length >= 3) {
                                        int i5 = (int) jArr[2];
                                        if (i5 == 1) {
                                            sb.append(" / Left to right panorama direction");
                                        } else if (i5 == 2) {
                                            sb.append(" / Right to left panorama direction");
                                        } else if (i5 == 3) {
                                            sb.append(" / Bottom to top panorama direction");
                                        } else if (i5 == 4) {
                                            sb.append(" / Top to bottom panorama direction");
                                        }
                                    }
                                    return sb.toString();
                                case 513:
                                    String O0000o02 = ((aao) this.f2602O000000o).O0000o0(519);
                                    if (O0000o02 == null) {
                                        return O000000o(513, 1, "Standard Quality", "High Quality", "Super High Quality");
                                    }
                                    Integer O00000o0 = ((aao) this.f2602O000000o).O00000o0(513);
                                    if (O00000o0 == null) {
                                        return null;
                                    }
                                    if ((!O0000o02.startsWith("SX") || O0000o02.startsWith("SX151")) && !O0000o02.startsWith("D4322")) {
                                        int intValue = O00000o0.intValue();
                                        if (intValue == 0) {
                                            return "Standard Quality (Low)";
                                        }
                                        if (intValue == 1) {
                                            return "High Quality (Normal)";
                                        }
                                        if (intValue == 2) {
                                            return "Super High Quality (Fine)";
                                        }
                                        if (intValue == 4) {
                                            return "RAW";
                                        }
                                        if (intValue == 5) {
                                            return "Medium-Fine";
                                        }
                                        if (intValue == 6) {
                                            return "Small-Fine";
                                        }
                                        if (intValue == 33) {
                                            return "Uncompressed";
                                        }
                                        return "Unknown (" + O00000o0.toString() + ")";
                                    }
                                    int intValue2 = O00000o0.intValue();
                                    if (intValue2 == 0) {
                                        return "Standard Quality (Low)";
                                    }
                                    if (intValue2 == 1) {
                                        return "High Quality (Normal)";
                                    }
                                    if (intValue2 == 2) {
                                        return "Super High Quality (Fine)";
                                    }
                                    if (intValue2 == 6) {
                                        return "RAW";
                                    }
                                    return "Unknown (" + O00000o0.toString() + ")";
                                case 514:
                                    return O000000o(514, "Normal (no macro)", "Macro");
                                case 515:
                                    return O000000o(515, "Off", "On");
                                case 516:
                                    Rational O0000Ooo = ((aao) this.f2602O000000o).O0000Ooo(516);
                                    if (O0000Ooo == null) {
                                        return null;
                                    }
                                    return O0000Ooo.O000000o(false);
                                case 517:
                                    Rational O0000Ooo2 = ((aao) this.f2602O000000o).O0000Ooo(517);
                                    if (O0000Ooo2 == null) {
                                        return null;
                                    }
                                    DecimalFormat decimalFormat = new DecimalFormat("0.###");
                                    return decimalFormat.format(O0000Ooo2.doubleValue()) + " mm";
                                default:
                                    switch (i3) {
                                        case 4096:
                                            return super.O00000oO(4096);
                                        case 4097:
                                            Rational O0000Ooo3 = ((aao) this.f2602O000000o).O0000Ooo(4097);
                                            if (O0000Ooo3 == null) {
                                                return null;
                                            }
                                            return String.valueOf(Math.round(Math.pow(2.0d, O0000Ooo3.doubleValue() - 5.0d) * 100.0d));
                                        case 4098:
                                            Double O0000OOo = ((aao) this.f2602O000000o).O0000OOo(4098);
                                            if (O0000OOo == null) {
                                                return null;
                                            }
                                            return O000000o(wi.O000000o(O0000OOo.doubleValue()));
                                        default:
                                            switch (i3) {
                                                case 61442:
                                                    return O000000o(61442, "P", "A", "S", "M");
                                                case 61443:
                                                    return O000000o(61443, "Normal", "Red-eye reduction", "Rear flash sync", "Wireless");
                                                case 61444:
                                                    return O000000o(61444, "Auto", "Daylight", "Cloudy", "Tungsten", null, "Custom", null, "Fluorescent", "Fluorescent 2", null, null, "Custom 2", "Custom 3");
                                                case 61445:
                                                    return O000000o(61445, "2560 x 1920", "1600 x 1200", "1280 x 960", "640 x 480");
                                                case 61446:
                                                    return O000000o(61446, "Raw", "Super Fine", "Fine", "Standard", "Economy", "Extra Fine");
                                                case 61447:
                                                    return O000000o(61447, "Single", "Continuous", "Self Timer", null, "Bracketing", "Interval", "UHS Continuous", "HS Continuous");
                                                case 61448:
                                                    return O000000o(61448, "Multi-Segment", "Centre Weighted", "Spot");
                                                case 61449:
                                                    Long O0000Oo = ((aao) this.f2602O000000o).O0000Oo(61449);
                                                    if (O0000Oo == null) {
                                                        return null;
                                                    }
                                                    double longValue = (double) O0000Oo.longValue();
                                                    Double.isNaN(longValue);
                                                    DecimalFormat decimalFormat2 = new DecimalFormat("0.##");
                                                    decimalFormat2.setRoundingMode(RoundingMode.HALF_UP);
                                                    return decimalFormat2.format(Math.pow((longValue / 8.0d) - 1.0d, 2.0d) * 3.125d);
                                                case 61450:
                                                    Long O0000Oo2 = ((aao) this.f2602O000000o).O0000Oo(61450);
                                                    if (O0000Oo2 == null) {
                                                        return null;
                                                    }
                                                    double longValue2 = (double) (49 - O0000Oo2.longValue());
                                                    Double.isNaN(longValue2);
                                                    double pow = Math.pow(longValue2 / 8.0d, 2.0d);
                                                    DecimalFormat decimalFormat3 = new DecimalFormat("0.###");
                                                    decimalFormat3.setRoundingMode(RoundingMode.HALF_UP);
                                                    return decimalFormat3.format(pow) + " sec";
                                                case 61451:
                                                    Long O0000Oo3 = ((aao) this.f2602O000000o).O0000Oo(61451);
                                                    if (O0000Oo3 == null) {
                                                        return null;
                                                    }
                                                    double longValue3 = (double) O0000Oo3.longValue();
                                                    Double.isNaN(longValue3);
                                                    return O000000o(Math.pow((longValue3 / 16.0d) - 0.5d, 2.0d));
                                                case 61452:
                                                    return O000000o(61452, "Off", "On");
                                                case 61453:
                                                    return O000000o(61453, "Off", "Electronic magnification", "Digital zoom 2x");
                                                case 61454:
                                                    Long O0000Oo4 = ((aao) this.f2602O000000o).O0000Oo(61454);
                                                    DecimalFormat decimalFormat4 = new DecimalFormat("0.##");
                                                    if (O0000Oo4 == null) {
                                                        return null;
                                                    }
                                                    StringBuilder sb2 = new StringBuilder();
                                                    double longValue4 = (double) O0000Oo4.longValue();
                                                    Double.isNaN(longValue4);
                                                    sb2.append(decimalFormat4.format((longValue4 / 3.0d) - 2.0d));
                                                    sb2.append(" EV");
                                                    return sb2.toString();
                                                case 61455:
                                                    return O000000o(61455, "1/3 EV", "2/3 EV", "1 EV");
                                                default:
                                                    switch (i3) {
                                                        case 61457:
                                                            if (!((aao) this.f2602O000000o).O00000oo()) {
                                                                return "N/A";
                                                            }
                                                            Long O0000Oo5 = ((aao) this.f2602O000000o).O0000Oo(61457);
                                                            if (O0000Oo5 == null) {
                                                                return null;
                                                            }
                                                            return O0000Oo5 + " min";
                                                        case 61458:
                                                            if (!((aao) this.f2602O000000o).O00000oo()) {
                                                                return "N/A";
                                                            }
                                                            Long O0000Oo6 = ((aao) this.f2602O000000o).O0000Oo(61458);
                                                            if (O0000Oo6 == null) {
                                                                return null;
                                                            }
                                                            return Long.toString(O0000Oo6.longValue());
                                                        case 61459:
                                                            Long O0000Oo7 = ((aao) this.f2602O000000o).O0000Oo(61459);
                                                            if (O0000Oo7 == null) {
                                                                return null;
                                                            }
                                                            double longValue5 = (double) O0000Oo7.longValue();
                                                            Double.isNaN(longValue5);
                                                            return O00000Oo(longValue5 / 256.0d);
                                                        case 61460:
                                                            Long O0000Oo8 = ((aao) this.f2602O000000o).O0000Oo(61460);
                                                            if (O0000Oo8 == null) {
                                                                return null;
                                                            }
                                                            if (O0000Oo8.longValue() == 0) {
                                                                return "Infinity";
                                                            }
                                                            return O0000Oo8 + " mm";
                                                        case 61461:
                                                            return O000000o(61461, "No", "Yes");
                                                        case 61462:
                                                            Long O0000Oo9 = ((aao) this.f2602O000000o).O0000Oo(61462);
                                                            if (O0000Oo9 == null) {
                                                                return null;
                                                            }
                                                            int longValue6 = (int) (O0000Oo9.longValue() & 255);
                                                            int longValue7 = (int) ((O0000Oo9.longValue() >> 16) & 255);
                                                            int longValue8 = ((int) ((O0000Oo9.longValue() >> 8) & 255)) + 1970;
                                                            if (!xg.O000000o(longValue8, longValue7, longValue6)) {
                                                                return "Invalid date";
                                                            }
                                                            return String.format("%04d-%02d-%02d", Integer.valueOf(longValue8), Integer.valueOf(longValue7 + 1), Integer.valueOf(longValue6));
                                                        case 61463:
                                                            Long O0000Oo10 = ((aao) this.f2602O000000o).O0000Oo(61463);
                                                            if (O0000Oo10 == null) {
                                                                return null;
                                                            }
                                                            int longValue9 = (int) ((O0000Oo10.longValue() >> 8) & 255);
                                                            int longValue10 = (int) ((O0000Oo10.longValue() >> 16) & 255);
                                                            int longValue11 = (int) (O0000Oo10.longValue() & 255);
                                                            if (!xg.O00000Oo(longValue9, longValue10, longValue11)) {
                                                                return "Invalid time";
                                                            }
                                                            return String.format("%02d:%02d:%02d", Integer.valueOf(longValue9), Integer.valueOf(longValue10), Integer.valueOf(longValue11));
                                                        case 61464:
                                                            Long O0000Oo11 = ((aao) this.f2602O000000o).O0000Oo(61463);
                                                            if (O0000Oo11 == null) {
                                                                return null;
                                                            }
                                                            double longValue12 = (double) O0000Oo11.longValue();
                                                            Double.isNaN(longValue12);
                                                            return O000000o(Math.pow((longValue12 / 16.0d) - 0.5d, 2.0d));
                                                        default:
                                                            switch (i3) {
                                                                case 61467:
                                                                    return O000000o(61467, "Off", "On");
                                                                case 61468:
                                                                    Long O0000Oo12 = ((aao) this.f2602O000000o).O0000Oo(61468);
                                                                    if (O0000Oo12 == null) {
                                                                        return null;
                                                                    }
                                                                    return O0000Oo12.longValue() == 0 ? "File Number Memory Off" : Long.toString(O0000Oo12.longValue());
                                                                case 61469:
                                                                    Long O0000Oo13 = ((aao) this.f2602O000000o).O0000Oo(61469);
                                                                    DecimalFormat decimalFormat5 = new DecimalFormat("0.##");
                                                                    if (O0000Oo13 == null) {
                                                                        return null;
                                                                    }
                                                                    double longValue13 = (double) O0000Oo13.longValue();
                                                                    Double.isNaN(longValue13);
                                                                    return decimalFormat5.format(longValue13 / 256.0d);
                                                                case 61470:
                                                                    Long O0000Oo14 = ((aao) this.f2602O000000o).O0000Oo(61470);
                                                                    DecimalFormat decimalFormat6 = new DecimalFormat("0.##");
                                                                    if (O0000Oo14 == null) {
                                                                        return null;
                                                                    }
                                                                    double longValue14 = (double) O0000Oo14.longValue();
                                                                    Double.isNaN(longValue14);
                                                                    return decimalFormat6.format(longValue14 / 256.0d);
                                                                case 61471:
                                                                    Long O0000Oo15 = ((aao) this.f2602O000000o).O0000Oo(61471);
                                                                    DecimalFormat decimalFormat7 = new DecimalFormat("0.##");
                                                                    if (O0000Oo15 == null) {
                                                                        return null;
                                                                    }
                                                                    double longValue15 = (double) O0000Oo15.longValue();
                                                                    Double.isNaN(longValue15);
                                                                    return decimalFormat7.format(longValue15 / 256.0d);
                                                                case 61472:
                                                                    Long O0000Oo16 = ((aao) this.f2602O000000o).O0000Oo(61472);
                                                                    if (O0000Oo16 == null) {
                                                                        return null;
                                                                    }
                                                                    return Long.toString(O0000Oo16.longValue() - 3);
                                                                case 61473:
                                                                    Long O0000Oo17 = ((aao) this.f2602O000000o).O0000Oo(61473);
                                                                    if (O0000Oo17 == null) {
                                                                        return null;
                                                                    }
                                                                    return Long.toString(O0000Oo17.longValue() - 3);
                                                                case 61474:
                                                                    return O000000o(61474, "Hard", "Normal", "Soft");
                                                                case 61475:
                                                                    return O000000o(61475, "None", "Portrait", "Text", "Night Portrait", "Sunset", "Sports Action");
                                                                case 61476:
                                                                    Long O0000Oo18 = ((aao) this.f2602O000000o).O0000Oo(61476);
                                                                    DecimalFormat decimalFormat8 = new DecimalFormat("0.##");
                                                                    if (O0000Oo18 == null) {
                                                                        return null;
                                                                    }
                                                                    StringBuilder sb3 = new StringBuilder();
                                                                    double longValue16 = (double) (O0000Oo18.longValue() - 6);
                                                                    Double.isNaN(longValue16);
                                                                    sb3.append(decimalFormat8.format(longValue16 / 3.0d));
                                                                    sb3.append(" EV");
                                                                    return sb3.toString();
                                                                case 61477:
                                                                    return O000000o(61477, "100", "200", "400", "800", "Auto", "64");
                                                                case 61478:
                                                                    return O000000o(61478, "DiMAGE 7", "DiMAGE 5", "DiMAGE S304", "DiMAGE S404", "DiMAGE 7i", "DiMAGE 7Hi", "DiMAGE A1", "DiMAGE S414");
                                                                case 61479:
                                                                    return O000000o(61479, "Still Image", "Time Lapse Movie");
                                                                case 61480:
                                                                    return O000000o(61480, "Standard Form", "Data Form");
                                                                case 61481:
                                                                    return O000000o(61481, "Natural Color", "Black & White", "Vivid Color", "Solarization", "AdobeRGB");
                                                                case 61482:
                                                                    Long O0000Oo19 = ((aao) this.f2602O000000o).O0000Oo(61482);
                                                                    if (O0000Oo19 == null) {
                                                                        return null;
                                                                    }
                                                                    return Long.toString(O0000Oo19.longValue() - 3);
                                                                case 61483:
                                                                    return super.O000000o(61483);
                                                                case 61484:
                                                                    return O000000o(61484, "Did Not Fire", "Fired");
                                                                case 61485:
                                                                    Long O0000Oo20 = ((aao) this.f2602O000000o).O0000Oo(61485);
                                                                    DecimalFormat decimalFormat9 = new DecimalFormat("0.##");
                                                                    if (O0000Oo20 == null) {
                                                                        return null;
                                                                    }
                                                                    double longValue17 = (double) O0000Oo20.longValue();
                                                                    Double.isNaN(longValue17);
                                                                    return decimalFormat9.format((longValue17 / 8.0d) - 6.0d);
                                                                case 61486:
                                                                    return super.O000000o(61486);
                                                                case 61487:
                                                                    return super.O000000o(61487);
                                                                case 61488:
                                                                    return O000000o(61488, "No Zone or AF Failed", "Center Zone (Horizontal Orientation)", "Center Zone (Vertical Orientation)", "Left Zone", "Right Zone");
                                                                case 61489:
                                                                    return O000000o(61489, "Auto Focus", "Manual Focus");
                                                                case 61490:
                                                                    return O000000o(61490, "Wide Focus (Normal)", "Spot Focus");
                                                                case 61491:
                                                                    return O000000o(61491, "Exposure", "Contrast", "Saturation", "Filter");
                                                                default:
                                                                    return super.O000000o(i);
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    int[] O00000oo3 = ((aao) this.f2602O000000o).O00000oo(4120);
                    if (O00000oo3 == null) {
                        return null;
                    }
                    double d2 = (double) ((short) O00000oo3[0]);
                    Double.isNaN(d2);
                    return String.valueOf(d2 / 256.0d);
                }
            }
        }
    }

    private String O00000oo() {
        int[] O00000oo = ((aao) this.f2602O000000o).O00000oo(4113);
        if (O00000oo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < O00000oo.length; i++) {
            sb.append((int) ((short) O00000oo[i]));
            if (i < O00000oo.length - 1) {
                sb.append(" ");
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }
}

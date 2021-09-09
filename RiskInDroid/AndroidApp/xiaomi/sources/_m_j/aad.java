package _m_j;

import com.drew.lang.Rational;
import java.text.DecimalFormat;

public final class aad extends xx<aae> {
    public aad(aae aae) {
        super(aae);
    }

    public final String O000000o(int i) {
        if (i == 1) {
            return O000000o(1, 2);
        }
        if (i == 2) {
            int[] O00000oo = ((aae) this.f2602O000000o).O00000oo(2);
            if (O00000oo == null) {
                return null;
            }
            if (O00000oo[0] != 0 || O00000oo[1] == 0) {
                return "Unknown (" + ((aae) this.f2602O000000o).O0000o0(2) + ")";
            }
            return "ISO " + O00000oo[1];
        } else if (i == 13) {
            return O00000oo(13);
        } else {
            if (i == 14) {
                return O00000oo(14);
            }
            if (i == 18) {
                return O00000oo(18);
            }
            if (i == 28) {
                return O00000oo(28);
            }
            if (i == 30) {
                return O000000o(30, 1, "sRGB", "Adobe RGB");
            }
            if (i == 34) {
                Integer O00000o0 = ((aae) this.f2602O000000o).O00000o0(34);
                if (O00000o0 == null) {
                    return null;
                }
                int intValue = O00000o0.intValue();
                if (intValue == 0) {
                    return "Off";
                }
                if (intValue == 1) {
                    return "Light";
                }
                if (intValue == 3) {
                    return "Normal";
                }
                if (intValue == 5) {
                    return "High";
                }
                if (intValue == 7) {
                    return "Extra High";
                }
                if (intValue == 65535) {
                    return "Auto";
                }
                return "Unknown (" + O00000o0 + ")";
            } else if (i == 42) {
                Integer O00000o02 = ((aae) this.f2602O000000o).O00000o0(42);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue2 = O00000o02.intValue();
                if (intValue2 == 0) {
                    return "Off";
                }
                if (intValue2 == 1) {
                    return "Low";
                }
                if (intValue2 == 3) {
                    return "Normal";
                }
                if (intValue2 == 5) {
                    return "High";
                }
                return "Unknown (" + O00000o02 + ")";
            } else if (i == 139) {
                return O00000oo(139);
            } else {
                if (i == 141) {
                    String O0000o0 = ((aae) this.f2602O000000o).O0000o0(141);
                    if (O0000o0 == null) {
                        return null;
                    }
                    return O0000o0.startsWith("MODE1") ? "Mode I (sRGB)" : O0000o0;
                } else if (i == 177) {
                    return O000000o(177, "Off", "Minimal", "Low", null, "Normal", null, "High");
                } else {
                    if (i == 182) {
                        return O00000Oo();
                    }
                    if (i == 23) {
                        return O00000oo(23);
                    }
                    if (i == 24) {
                        return O00000oo(24);
                    }
                    if (i == 131) {
                        return O000000o(131, new String[]{"AF", "MF"}, "D", "G", "VR");
                    } else if (i == 132) {
                        return O00000o(132);
                    } else {
                        if (i == 146) {
                            return O000000o("%s degrees");
                        }
                        if (i == 147) {
                            return O000000o(147, 1, "Lossy (Type 1)", null, "Uncompressed", null, null, null, "Lossless", "Lossy (Type 2)");
                        }
                        switch (i) {
                            case 134:
                                Rational O0000Ooo = ((aae) this.f2602O000000o).O0000Ooo(134);
                                if (O0000Ooo == null) {
                                    return null;
                                }
                                if (O0000Ooo.intValue() == 1) {
                                    return "No digital zoom";
                                }
                                return O0000Ooo.O000000o(true) + "x digital zoom";
                            case 135:
                                return O000000o(135, "Flash Not Used", "Manual Flash", null, "Flash Not Ready", null, null, null, "External Flash", "Fired, Commander Mode", "Fired, TTL Mode");
                            case 136:
                                int[] O00000oo2 = ((aae) this.f2602O000000o).O00000oo(136);
                                if (O00000oo2 == null) {
                                    return null;
                                }
                                if (O00000oo2.length == 4 && O00000oo2[0] == 0 && O00000oo2[2] == 0 && O00000oo2[3] == 0) {
                                    int i2 = O00000oo2[1];
                                    if (i2 == 0) {
                                        return "Centre";
                                    }
                                    if (i2 == 1) {
                                        return "Top";
                                    }
                                    if (i2 == 2) {
                                        return "Bottom";
                                    }
                                    if (i2 == 3) {
                                        return "Left";
                                    }
                                    if (i2 == 4) {
                                        return "Right";
                                    }
                                    return "Unknown (" + O00000oo2[1] + ")";
                                }
                                return "Unknown (" + ((aae) this.f2602O000000o).O0000o0(136) + ")";
                            case 137:
                                return O000000o(137, new String[]{"Single Frame", "Continuous"}, "Delay", null, "PC Control", "Exposure Bracketing", "Auto ISO", "White-Balance Bracketing", "IR Control");
                            default:
                                return super.O000000o(i);
                        }
                    }
                }
            }
        }
    }

    private String O00000oo(int i) {
        int[] O00000oo = ((aae) this.f2602O000000o).O00000oo(i);
        if (O00000oo == null || O00000oo.length < 2 || O00000oo.length < 3 || O00000oo[2] == 0) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        double d = (double) (O00000oo[0] * O00000oo[1]);
        double d2 = (double) O00000oo[2];
        Double.isNaN(d);
        Double.isNaN(d2);
        return decimalFormat.format(d / d2) + " EV";
    }
}

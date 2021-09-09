package _m_j;

public final class zp extends xx<zq> {
    public zp(zq zqVar) {
        super(zqVar);
    }

    public final String O000000o(int i) {
        if (i == 2) {
            int[] O00000oo = ((zq) this.f2602O000000o).O00000oo(2);
            if (O00000oo == null || O00000oo.length != 2) {
                return ((zq) this.f2602O000000o).O0000o0(2);
            }
            return O00000oo[0] + " x " + O00000oo[1] + " pixels";
        } else if (i == 3) {
            Integer O00000o0 = ((zq) this.f2602O000000o).O00000o0(3);
            if (O00000o0 == null) {
                return null;
            }
            return Integer.toString(O00000o0.intValue()) + " bytes";
        } else if (i == 4) {
            return ((zq) this.f2602O000000o).O0000o0(4);
        } else {
            if (i == 8) {
                return O000000o(8, 1, "Fine", "Super Fine");
            }
            if (i == 9) {
                Integer O00000o02 = ((zq) this.f2602O000000o).O00000o0(9);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue = O00000o02.intValue();
                if (intValue == 0) {
                    return "640 x 480 pixels";
                }
                if (intValue == 36) {
                    return "3008 x 2008 pixels";
                }
                if (intValue == 4) {
                    return "1600 x 1200 pixels";
                }
                if (intValue == 5) {
                    return "2048 x 1536 pixels";
                }
                switch (intValue) {
                    case 20:
                        return "2288 x 1712 pixels";
                    case 21:
                        return "2592 x 1944 pixels";
                    case 22:
                        return "2304 x 1728 pixels";
                    default:
                        return "Unknown (" + O00000o02 + ")";
                }
            } else if (i == 13) {
                return O000000o(13, "Normal", "Macro");
            } else {
                if (i == 20) {
                    Integer O00000o03 = ((zq) this.f2602O000000o).O00000o0(20);
                    if (O00000o03 == null) {
                        return null;
                    }
                    int intValue2 = O00000o03.intValue();
                    if (intValue2 == 3) {
                        return "50";
                    }
                    if (intValue2 == 4) {
                        return "64";
                    }
                    if (intValue2 == 6) {
                        return "100";
                    }
                    if (intValue2 == 9) {
                        return "200";
                    }
                    return "Unknown (" + O00000o03 + ")";
                } else if (i == 25) {
                    return O000000o(25, "Auto", "Daylight", "Shade", "Tungsten", "Florescent", "Manual");
                } else {
                    if (i == 29) {
                        Double O0000OOo = ((zq) this.f2602O000000o).O0000OOo(29);
                        if (O0000OOo == null) {
                            return null;
                        }
                        return O00000Oo(O0000OOo.doubleValue() / 10.0d);
                    } else if (i == 8192) {
                        byte[] O0000O0o = ((zq) this.f2602O000000o).O0000O0o(8192);
                        if (O0000O0o == null) {
                            return null;
                        }
                        return "<" + O0000O0o.length + " bytes of image data>";
                    } else if (i == 8226) {
                        Integer O00000o04 = ((zq) this.f2602O000000o).O00000o0(8226);
                        if (O00000o04 == null) {
                            return null;
                        }
                        return Integer.toString(O00000o04.intValue()) + " mm";
                    } else if (i == 8244) {
                        return O000000o(8244, "Off");
                    } else {
                        if (i == 12294) {
                            return ((zq) this.f2602O000000o).O0000o0(12294);
                        }
                        if (i == 8209) {
                            return ((zq) this.f2602O000000o).O0000o0(8209);
                        }
                        if (i != 8210) {
                            switch (i) {
                                case 31:
                                    return O000000o(31, "-1", "Normal", "+1");
                                case 32:
                                    return O000000o(32, "-1", "Normal", "+1");
                                case 33:
                                    return O000000o(33, "-1", "Normal", "+1");
                                default:
                                    switch (i) {
                                        case 12288:
                                            return O000000o(12288, 2, "Normal");
                                        case 12289:
                                            return O000000o(12289, 1, "Off");
                                        case 12290:
                                            return O000000o(12290, 3, "Fine");
                                        case 12291:
                                            Integer O00000o05 = ((zq) this.f2602O000000o).O00000o0(12291);
                                            if (O00000o05 == null) {
                                                return null;
                                            }
                                            int intValue3 = O00000o05.intValue();
                                            if (intValue3 == 1) {
                                                return "Fixation";
                                            }
                                            if (intValue3 == 6) {
                                                return "Multi-Area Focus";
                                            }
                                            return "Unknown (" + O00000o05 + ")";
                                        default:
                                            switch (i) {
                                                case 12308:
                                                    return O000000o(12308, "Off", "On");
                                                case 12309:
                                                    return O000000o(12309, "Off");
                                                case 12310:
                                                    return O000000o(12310, "Off");
                                                case 12311:
                                                    return O000000o(12311, "Off");
                                                default:
                                                    return super.O000000o(i);
                                            }
                                    }
                            }
                        } else {
                            Integer O00000o06 = ((zq) this.f2602O000000o).O00000o0(8210);
                            if (O00000o06 == null) {
                                return null;
                            }
                            int intValue4 = O00000o06.intValue();
                            if (intValue4 == 0) {
                                return "Manual";
                            }
                            if (intValue4 == 1) {
                                return "Auto";
                            }
                            if (intValue4 == 4 || intValue4 == 12) {
                                return "Flash";
                            }
                            return "Unknown (" + O00000o06 + ")";
                        }
                    }
                }
            }
        }
    }
}

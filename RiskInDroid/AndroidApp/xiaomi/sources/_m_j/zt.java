package _m_j;

public final class zt extends xx<zu> {
    public zt(zu zuVar) {
        super(zuVar);
    }

    public final String O000000o(int i) {
        if (i == 9) {
            return O000000o(9, 1, "Fine", "Normal");
        }
        if (i == 10) {
            return O000000o(10, "Off", "On");
        }
        if (i == 27) {
            Integer O00000o0 = ((zu) this.f2602O000000o).O00000o0(27);
            if (O00000o0 == null) {
                return null;
            }
            int intValue = O00000o0.intValue();
            if (intValue == 0) {
                return "Auto";
            }
            if (intValue == 8) {
                return "Aperture Priority";
            }
            if (intValue == 32) {
                return "Manual";
            }
            return "Unknown (" + O00000o0 + ")";
        } else if (i == 56) {
            return O000000o(56, "Normal", null, "Macro");
        } else {
            if (i == 64) {
                return O000000o(64, "Auto", "Flash", "Tungsten", "Daylight");
            }
            if (i == 102) {
                Integer O00000o02 = ((zu) this.f2602O000000o).O00000o0(102);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue2 = O00000o02.intValue();
                if (intValue2 == 1) {
                    return "B&W";
                }
                if (intValue2 == 2) {
                    return "Sepia";
                }
                if (intValue2 == 3) {
                    return "B&W Yellow Filter";
                }
                if (intValue2 == 4) {
                    return "B&W Red Filter";
                }
                if (intValue2 == 32) {
                    return "Saturated Color";
                }
                if (intValue2 == 64) {
                    return "Neutral Color";
                }
                if (intValue2 == 256) {
                    return "Saturated Color";
                }
                if (intValue2 == 512) {
                    return "Neutral Color";
                }
                if (intValue2 == 8192) {
                    return "B&W";
                }
                if (intValue2 == 16384) {
                    return "Sepia";
                }
                return "Unknown (" + O00000o02 + ")";
            } else if (i == 107) {
                return O000000o(107, "Normal");
            } else {
                if (i == 92) {
                    Integer O00000o03 = ((zu) this.f2602O000000o).O00000o0(92);
                    if (O00000o03 == null) {
                        return null;
                    }
                    int intValue3 = O00000o03.intValue();
                    if (intValue3 == 0) {
                        return "Auto";
                    }
                    if (intValue3 == 1) {
                        return "Fill Flash";
                    }
                    if (intValue3 == 2) {
                        return "Off";
                    }
                    if (intValue3 == 3) {
                        return "Red Eye";
                    }
                    if (intValue3 == 16) {
                        return "Fill Flash";
                    }
                    if (intValue3 == 32) {
                        return "Off";
                    }
                    if (intValue3 == 64) {
                        return "Red Eye";
                    }
                    return "Unknown (" + O00000o03 + ")";
                } else if (i != 93) {
                    return super.O000000o(i);
                } else {
                    return O000000o(93, "No", "Yes");
                }
            }
        }
    }
}

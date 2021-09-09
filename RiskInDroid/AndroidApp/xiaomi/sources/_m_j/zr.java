package _m_j;

import com.drew.lang.Rational;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class zr extends xx<zs> {
    public zr(zs zsVar) {
        super(zsVar);
    }

    public final String O000000o(int i) {
        if (i == 0) {
            return O000000o(0, 2);
        }
        if (i == 4102) {
            Integer O00000o0 = ((zs) this.f2602O000000o).O00000o0(4102);
            if (O00000o0 == null) {
                return null;
            }
            int intValue = O00000o0.intValue();
            if (intValue == 0) {
                return "Normal";
            }
            if (intValue == 256) {
                return "High";
            }
            if (intValue == 768) {
                return "Low";
            }
            return "Unknown (" + O00000o0 + ")";
        } else if (i == 4107) {
            Integer O00000o02 = ((zs) this.f2602O000000o).O00000o0(4107);
            if (O00000o02 == null) {
                return null;
            }
            int intValue2 = O00000o02.intValue();
            if (intValue2 == 64) {
                return "Low";
            }
            if (intValue2 == 128) {
                return "Normal";
            }
            if (intValue2 == 256) {
                return "N/A";
            }
            return "Unknown (" + O00000o02 + ")";
        } else if (i == 4110) {
            Integer O00000o03 = ((zs) this.f2602O000000o).O00000o0(4110);
            if (O00000o03 == null) {
                return null;
            }
            int intValue3 = O00000o03.intValue();
            if (intValue3 == 0) {
                return "Normal";
            }
            if (intValue3 == 256) {
                return "Strong";
            }
            if (intValue3 == 512) {
                return "Weak";
            }
            return "Unknown (" + O00000o03 + ")";
        } else if (i == 4352) {
            return O000000o(4352, "Off", "On", "No Flash & Flash");
        } else {
            if (i == 4624) {
                Integer O00000o04 = ((zs) this.f2602O000000o).O00000o0(4624);
                if (O00000o04 == null) {
                    return null;
                }
                int intValue4 = O00000o04.intValue();
                if (intValue4 == 0) {
                    return "Standard";
                }
                if (intValue4 == 16) {
                    return "Chrome";
                }
                if (intValue4 == 48) {
                    return "B&W";
                }
                return "Unknown (" + O00000o04 + ")";
            } else if (i == 4112) {
                return O000000o(4112, "Auto", "On", "Off", "Red-eye Reduction", "External");
            } else {
                if (i == 4113) {
                    Rational O0000Ooo = ((zs) this.f2602O000000o).O0000Ooo(4113);
                    if (O0000Ooo == null) {
                        return null;
                    }
                    return O0000Ooo.O000000o(false) + " EV (Apex)";
                } else if (i == 4128) {
                    return O000000o(4128, "Off", "On");
                } else {
                    if (i == 4129) {
                        return O000000o(4129, "Auto Focus", "Manual Focus");
                    }
                    if (i == 4144) {
                        return O000000o(4144, "Off", "On");
                    }
                    if (i == 4145) {
                        Integer O00000o05 = ((zs) this.f2602O000000o).O00000o0(4145);
                        if (O00000o05 == null) {
                            return null;
                        }
                        int intValue5 = O00000o05.intValue();
                        if (intValue5 == 27) {
                            return "Dog Face Detection";
                        }
                        if (intValue5 == 28) {
                            return "Cat Face Detection";
                        }
                        if (intValue5 == 256) {
                            return "Aperture priority AE";
                        }
                        if (intValue5 == 512) {
                            return "Shutter priority AE";
                        }
                        if (intValue5 == 768) {
                            return "Manual exposure";
                        }
                        switch (intValue5) {
                            case 0:
                                return "Auto";
                            case 1:
                                return "Portrait scene";
                            case 2:
                                return "Landscape scene";
                            case 3:
                                return "Macro";
                            case 4:
                                return "Sports scene";
                            case 5:
                                return "Night scene";
                            case 6:
                                return "Program AE";
                            case 7:
                                return "Natural Light";
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                return "Anti-blur";
                            case 9:
                                return "Beach & Snow";
                            case 10:
                                return "Sunset";
                            case 11:
                                return "Museum";
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                return "Party";
                            case 13:
                                return "Flower";
                            case 14:
                                return "Text";
                            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                                return "Natural Light & Flash";
                            case 16:
                                return "Beach";
                            case 17:
                                return "Snow";
                            case 18:
                                return "Fireworks";
                            case 19:
                                return "Underwater";
                            case 20:
                                return "Portrait with Skin Correction";
                            default:
                                switch (intValue5) {
                                    case 22:
                                        return "Panorama";
                                    case 23:
                                        return "Night (Tripod)";
                                    case 24:
                                        return "Pro Low-light";
                                    case 25:
                                        return "Pro Focus";
                                    default:
                                        return "Unknown (" + O00000o05 + ")";
                                }
                        }
                    } else if (i == 4147) {
                        return O000000o(4147, "Auto", "Manual");
                    } else {
                        if (i != 4148) {
                            switch (i) {
                                case 4097:
                                    Integer O00000o06 = ((zs) this.f2602O000000o).O00000o0(4097);
                                    if (O00000o06 == null) {
                                        return null;
                                    }
                                    int intValue6 = O00000o06.intValue();
                                    if (intValue6 == 1) {
                                        return "Softest";
                                    }
                                    if (intValue6 == 2) {
                                        return "Soft";
                                    }
                                    if (intValue6 == 3) {
                                        return "Normal";
                                    }
                                    if (intValue6 == 4) {
                                        return "Hard";
                                    }
                                    if (intValue6 == 5) {
                                        return "Hardest";
                                    }
                                    if (intValue6 == 130) {
                                        return "Medium Soft";
                                    }
                                    if (intValue6 == 132) {
                                        return "Medium Hard";
                                    }
                                    if (intValue6 == 32768) {
                                        return "Film Simulation";
                                    }
                                    if (intValue6 == 65535) {
                                        return "N/A";
                                    }
                                    return "Unknown (" + O00000o06 + ")";
                                case 4098:
                                    Integer O00000o07 = ((zs) this.f2602O000000o).O00000o0(4098);
                                    if (O00000o07 == null) {
                                        return null;
                                    }
                                    int intValue7 = O00000o07.intValue();
                                    if (intValue7 == 0) {
                                        return "Auto";
                                    }
                                    if (intValue7 == 256) {
                                        return "Daylight";
                                    }
                                    if (intValue7 == 512) {
                                        return "Cloudy";
                                    }
                                    if (intValue7 == 1024) {
                                        return "Incandescence";
                                    }
                                    if (intValue7 == 1280) {
                                        return "Flash";
                                    }
                                    if (intValue7 == 4080) {
                                        return "Kelvin";
                                    }
                                    switch (intValue7) {
                                        case 768:
                                            return "Daylight Fluorescent";
                                        case 769:
                                            return "Day White Fluorescent";
                                        case 770:
                                            return "White Fluorescent";
                                        case 771:
                                            return "Warm White Fluorescent";
                                        case 772:
                                            return "Living Room Warm White Fluorescent";
                                        default:
                                            switch (intValue7) {
                                                case 3840:
                                                    return "Custom White Balance";
                                                case 3841:
                                                    return "Custom White Balance 2";
                                                case 3842:
                                                    return "Custom White Balance 3";
                                                case 3843:
                                                    return "Custom White Balance 4";
                                                case 3844:
                                                    return "Custom White Balance 5";
                                                default:
                                                    return "Unknown (" + O00000o07 + ")";
                                            }
                                    }
                                case 4099:
                                    Integer O00000o08 = ((zs) this.f2602O000000o).O00000o0(4099);
                                    if (O00000o08 == null) {
                                        return null;
                                    }
                                    int intValue8 = O00000o08.intValue();
                                    if (intValue8 == 0) {
                                        return "Normal";
                                    }
                                    if (intValue8 == 128) {
                                        return "Medium High";
                                    }
                                    if (intValue8 == 256) {
                                        return "High";
                                    }
                                    if (intValue8 == 384) {
                                        return "Medium Low";
                                    }
                                    if (intValue8 == 512) {
                                        return "Low";
                                    }
                                    if (intValue8 == 32768) {
                                        return "Film Simulation";
                                    }
                                    switch (intValue8) {
                                        case 768:
                                            return "None (B&W)";
                                        case 769:
                                            return "B&W Green Filter";
                                        case 770:
                                            return "B&W Yellow Filter";
                                        case 771:
                                            return "B&W Blue Filter";
                                        case 772:
                                            return "B&W Sepia";
                                        default:
                                            return "Unknown (" + O00000o08 + ")";
                                    }
                                case 4100:
                                    Integer O00000o09 = ((zs) this.f2602O000000o).O00000o0(4100);
                                    if (O00000o09 == null) {
                                        return null;
                                    }
                                    int intValue9 = O00000o09.intValue();
                                    if (intValue9 == 0) {
                                        return "Normal";
                                    }
                                    if (intValue9 == 128) {
                                        return "Medium High";
                                    }
                                    if (intValue9 == 256) {
                                        return "High";
                                    }
                                    if (intValue9 == 384) {
                                        return "Medium Low";
                                    }
                                    if (intValue9 == 512) {
                                        return "Low";
                                    }
                                    if (intValue9 == 768) {
                                        return "None (B&W)";
                                    }
                                    if (intValue9 == 32768) {
                                        return "Film Simulation";
                                    }
                                    return "Unknown (" + O00000o09 + ")";
                                default:
                                    switch (i) {
                                        case 4864:
                                            return O000000o(4864, "No Blur Warning", "Blur warning");
                                        case 4865:
                                            return O000000o(4865, "Good Focus", "Out Of Focus");
                                        case 4866:
                                            return O000000o(4866, "AE Good", "Over Exposed");
                                        default:
                                            switch (i) {
                                                case 5120:
                                                    return O000000o(5120, 1, "Standard", null, "Wide");
                                                case 5121:
                                                    Integer O00000o010 = ((zs) this.f2602O000000o).O00000o0(5121);
                                                    if (O00000o010 == null) {
                                                        return null;
                                                    }
                                                    int intValue10 = O00000o010.intValue();
                                                    if (intValue10 == 0) {
                                                        return "F0/Standard (Provia) ";
                                                    }
                                                    if (intValue10 == 256) {
                                                        return "F1/Studio Portrait";
                                                    }
                                                    if (intValue10 == 272) {
                                                        return "F1a/Studio Portrait Enhanced Saturation";
                                                    }
                                                    if (intValue10 == 288) {
                                                        return "F1b/Studio Portrait Smooth Skin Tone (Astia)";
                                                    }
                                                    if (intValue10 == 304) {
                                                        return "F1c/Studio Portrait Increased Sharpness";
                                                    }
                                                    if (intValue10 == 512) {
                                                        return "F2/Fujichrome (Velvia)";
                                                    }
                                                    if (intValue10 == 768) {
                                                        return "F3/Studio Portrait Ex";
                                                    }
                                                    if (intValue10 == 1024) {
                                                        return "F4/Velvia";
                                                    }
                                                    if (intValue10 == 1280) {
                                                        return "Pro Neg. Std";
                                                    }
                                                    if (intValue10 == 1281) {
                                                        return "Pro Neg. Hi";
                                                    }
                                                    return "Unknown (" + O00000o010 + ")";
                                                case 5122:
                                                    Integer O00000o011 = ((zs) this.f2602O000000o).O00000o0(5122);
                                                    if (O00000o011 == null) {
                                                        return null;
                                                    }
                                                    int intValue11 = O00000o011.intValue();
                                                    if (intValue11 == 0) {
                                                        return "Auto (100-400%)";
                                                    }
                                                    if (intValue11 == 1) {
                                                        return "Manual";
                                                    }
                                                    if (intValue11 == 256) {
                                                        return "Standard (100%)";
                                                    }
                                                    if (intValue11 == 32768) {
                                                        return "Film Simulation";
                                                    }
                                                    if (intValue11 == 512) {
                                                        return "Wide 1 (230%)";
                                                    }
                                                    if (intValue11 == 513) {
                                                        return "Wide 2 (400%)";
                                                    }
                                                    return "Unknown (" + O00000o011 + ")";
                                                default:
                                                    return super.O000000o(i);
                                            }
                                    }
                            }
                        } else {
                            Integer O00000o012 = ((zs) this.f2602O000000o).O00000o0(4148);
                            if (O00000o012 == null) {
                                return null;
                            }
                            int intValue12 = O00000o012.intValue();
                            if (intValue12 == 256) {
                                return "HR (High Resolution)";
                            }
                            if (intValue12 == 512) {
                                return "SN (Signal to Noise Priority)";
                            }
                            if (intValue12 == 768) {
                                return "DR (Dynamic Range Priority)";
                            }
                            return "Unknown (" + O00000o012 + ")";
                        }
                    }
                }
            }
        }
    }
}

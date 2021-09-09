package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class abl extends xx<abm> {
    public abl(abm abm) {
        super(abm);
    }

    public final String O000000o(int i) {
        switch (i) {
            case 258:
                return O000000o(258, "RAW", "Super Fine", "Fine", "Standard", "Economy", "Extra Fine", "RAW + JPEG", "Compressed RAW", "Compressed RAW + JPEG");
            case 260:
                return O000000o(260, "%d EV");
            case 261:
                Integer O00000o0 = ((abm) this.f2602O000000o).O00000o0(261);
                if (O00000o0 == null) {
                    return null;
                }
                int intValue = O00000o0.intValue();
                if (intValue == 0) {
                    return "None";
                }
                if (intValue == 72) {
                    return "Minolta/Sony AF 2x APO (D)";
                }
                if (intValue == 80) {
                    return "Minolta AF 2x APO II";
                }
                if (intValue == 96) {
                    return "Minolta AF 2x APO";
                }
                if (intValue == 136) {
                    return "Minolta/Sony AF 1.4x APO (D)";
                }
                if (intValue == 144) {
                    return "Minolta AF 1.4x APO II";
                }
                if (intValue == 160) {
                    return "Minolta AF 1.4x APO";
                }
                return "Unknown (" + O00000o0 + ")";
            case 277:
                Integer O00000o02 = ((abm) this.f2602O000000o).O00000o0(277);
                if (O00000o02 == null) {
                    return null;
                }
                int intValue2 = O00000o02.intValue();
                if (intValue2 == 0) {
                    return "Auto";
                }
                if (intValue2 == 1) {
                    return "Color Temperature/Color Filter";
                }
                if (intValue2 == 16) {
                    return "Daylight";
                }
                if (intValue2 == 32) {
                    return "Cloudy";
                }
                if (intValue2 == 48) {
                    return "Shade";
                }
                if (intValue2 == 64) {
                    return "Tungsten";
                }
                if (intValue2 == 80) {
                    return "Flash";
                }
                if (intValue2 == 96) {
                    return "Fluorescent";
                }
                if (intValue2 == 112) {
                    return "Custom";
                }
                return "Unknown (" + O00000o02 + ")";
            case 8201:
                Integer O00000o03 = ((abm) this.f2602O000000o).O00000o0(8201);
                if (O00000o03 == null) {
                    return null;
                }
                int intValue3 = O00000o03.intValue();
                if (intValue3 == 0) {
                    return "Off";
                }
                if (intValue3 == 1) {
                    return "On";
                }
                if (intValue3 == 2) {
                    return "Normal";
                }
                if (intValue3 == 3) {
                    return "High";
                }
                if (intValue3 == 256) {
                    return "Auto";
                }
                if (intValue3 == 65535) {
                    return "N/A";
                }
                return String.format("Unknown (%d)", O00000o03);
            case 8206:
                Integer O00000o04 = ((abm) this.f2602O000000o).O00000o0(8206);
                if (O00000o04 == null) {
                    return null;
                }
                int intValue4 = O00000o04.intValue();
                if (intValue4 == 13) {
                    return "High Contrast Monochrome";
                }
                if (intValue4 == 80) {
                    return "Rich-tone Monochrome";
                }
                if (intValue4 == 97) {
                    return "Water Color";
                }
                if (intValue4 == 98) {
                    return "Water Color 2";
                }
                switch (intValue4) {
                    case 0:
                        return "Off";
                    case 1:
                        return "Toy Camera";
                    case 2:
                        return "Pop Color";
                    case 3:
                        return "Posterization";
                    case 4:
                        return "Posterization B/W";
                    case 5:
                        return "Retro Photo";
                    case 6:
                        return "Soft High Key";
                    case 7:
                        return "Partial Color (red)";
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return "Partial Color (green)";
                    case 9:
                        return "Partial Color (blue)";
                    case 10:
                        return "Partial Color (yellow)";
                    default:
                        switch (intValue4) {
                            case 16:
                                return "Toy Camera (normal)";
                            case 17:
                                return "Toy Camera (cool)";
                            case 18:
                                return "Toy Camera (warm)";
                            case 19:
                                return "Toy Camera (green)";
                            case 20:
                                return "Toy Camera (magenta)";
                            default:
                                switch (intValue4) {
                                    case 32:
                                        return "Soft Focus (low)";
                                    case 33:
                                        return "Soft Focus";
                                    case 34:
                                        return "Soft Focus (high)";
                                    default:
                                        switch (intValue4) {
                                            case 48:
                                                return "Miniature (auto)";
                                            case 49:
                                                return "Miniature (top)";
                                            case 50:
                                                return "Miniature (middle horizontal)";
                                            case 51:
                                                return "Miniature (bottom)";
                                            case 52:
                                                return "Miniature (left)";
                                            case 53:
                                                return "Miniature (middle vertical)";
                                            case 54:
                                                return "Miniature (right)";
                                            default:
                                                switch (intValue4) {
                                                    case 64:
                                                        return "HDR Painting (low)";
                                                    case 65:
                                                        return "HDR Painting";
                                                    case 66:
                                                        return "HDR Painting (high)";
                                                    default:
                                                        switch (intValue4) {
                                                            case 112:
                                                                return "Illustration (low)";
                                                            case 113:
                                                                return "Illustration";
                                                            case 114:
                                                                return "Illustration (high)";
                                                            default:
                                                                return String.format("Unknown (%d)", O00000o04);
                                                        }
                                                }
                                        }
                                }
                        }
                }
            case 8207:
                return O000000o(8207, "Off", "Low", "Mid", "High");
            case 8209:
                Integer O00000o05 = ((abm) this.f2602O000000o).O00000o0(8209);
                if (O00000o05 == null) {
                    return null;
                }
                int intValue5 = O00000o05.intValue();
                if (intValue5 == -1) {
                    return "N/A";
                }
                if (intValue5 == 0) {
                    return "Off";
                }
                if (intValue5 == 2) {
                    return "Auto";
                }
                return String.format("Unknown (%d)", O00000o05);
            case 8210:
                Integer O00000o06 = ((abm) this.f2602O000000o).O00000o0(8210);
                if (O00000o06 == null) {
                    return null;
                }
                int intValue6 = O00000o06.intValue();
                if (intValue6 == -1) {
                    return "N/A";
                }
                if (intValue6 == 0) {
                    return "Off";
                }
                if (intValue6 == 2) {
                    return "Auto";
                }
                return String.format("Unknown (%d)", O00000o06);
            case 8211:
                Integer O00000o07 = ((abm) this.f2602O000000o).O00000o0(8211);
                if (O00000o07 == null) {
                    return null;
                }
                int intValue7 = O00000o07.intValue();
                if (intValue7 == -1) {
                    return "N/A";
                }
                if (intValue7 == 0) {
                    return "Off";
                }
                if (intValue7 == 2) {
                    return "Auto";
                }
                return String.format("Unknown (%d)", O00000o07);
            case 8214:
                return O000000o(8214, "No", "Yes");
            case 8219:
                return O000000o(8219, "Manual", null, "AF-A", "AF-C", "AF-S", null, "DMF", "AF-D");
            case 8222:
                return O000000o(8222, "Auto", "Center", "Top", "Upper-right", "Right", "Lower-right", "Bottom", "Lower-left", "Left", "Upper-left\t  \t", "Far Right", "Far Left", "Upper-middle", "Near Right", "Lower-middle", "Near Left", "Upper Far Right", "Lower Far Right", "Lower Far Left", "Upper Far Left");
            case 45057:
                Integer O00000o08 = ((abm) this.f2602O000000o).O00000o0(45057);
                if (O00000o08 == null) {
                    return null;
                }
                int intValue8 = O00000o08.intValue();
                if (intValue8 == 2) {
                    return "DSC-R1";
                }
                if (intValue8 == 269) {
                    return "DSLR-A850";
                }
                if (intValue8 == 270) {
                    return "DSLR-A850 (APS-C mode)";
                }
                switch (intValue8) {
                    case 256:
                        return "DSLR-A100";
                    case 257:
                        return "DSLR-A900";
                    case 258:
                        return "DSLR-A700";
                    case 259:
                        return "DSLR-A200";
                    case 260:
                        return "DSLR-A350";
                    case 261:
                        return "DSLR-A300";
                    case 262:
                        return "DSLR-A900 (APS-C mode)";
                    case 263:
                        return "DSLR-A380/A390";
                    case 264:
                        return "DSLR-A330";
                    case 265:
                        return "DSLR-A230";
                    case 266:
                        return "DSLR-A290";
                    default:
                        switch (intValue8) {
                            case 273:
                                return "DSLR-A550";
                            case 274:
                                return "DSLR-A500";
                            case 275:
                                return "DSLR-A450";
                            default:
                                switch (intValue8) {
                                    case 278:
                                        return "NEX-5";
                                    case 279:
                                        return "NEX-3";
                                    case 280:
                                        return "SLT-A33";
                                    case 281:
                                        return "SLT-A55V";
                                    case 282:
                                        return "DSLR-A560";
                                    case 283:
                                        return "DSLR-A580";
                                    case 284:
                                        return "NEX-C3";
                                    case 285:
                                        return "SLT-A35";
                                    case 286:
                                        return "SLT-A65V";
                                    case 287:
                                        return "SLT-A77V";
                                    case 288:
                                        return "NEX-5N";
                                    case 289:
                                        return "NEX-7";
                                    case 290:
                                        return "NEX-VG20E";
                                    case 291:
                                        return "SLT-A37";
                                    case 292:
                                        return "SLT-A57";
                                    case 293:
                                        return "NEX-F3";
                                    case 294:
                                        return "SLT-A99V";
                                    case 295:
                                        return "NEX-6";
                                    case 296:
                                        return "NEX-5R";
                                    case 297:
                                        return "DSC-RX100";
                                    case 298:
                                        return "DSC-RX1";
                                    default:
                                        return "Unknown (" + O00000o08 + ")";
                                }
                        }
                }
            case 45089:
                Integer O00000o09 = ((abm) this.f2602O000000o).O00000o0(45089);
                if (O00000o09 == null) {
                    return null;
                }
                if (O00000o09.intValue() == 0) {
                    return "Auto";
                }
                return String.format("%d K", Integer.valueOf(((O00000o09.intValue() & -16777216) >> 24) | ((O00000o09.intValue() & 16711680) >> 8)));
            case 45091:
                Integer O00000o010 = ((abm) this.f2602O000000o).O00000o0(45091);
                if (O00000o010 == null) {
                    return null;
                }
                int intValue9 = O00000o010.intValue();
                switch (intValue9) {
                    case 0:
                        return "Standard";
                    case 1:
                        return "Portrait";
                    case 2:
                        return "Text";
                    case 3:
                        return "Night Scene";
                    case 4:
                        return "Sunset";
                    case 5:
                        return "Sports";
                    case 6:
                        return "Landscape";
                    case 7:
                        return "Night Portrait";
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return "Macro";
                    case 9:
                        return "Super Macro";
                    default:
                        switch (intValue9) {
                            case 16:
                                return "Auto";
                            case 17:
                                return "Night View/Portrait";
                            case 18:
                                return "Sweep Panorama";
                            case 19:
                                return "Handheld Night Shot";
                            case 20:
                                return "Anti Motion Blur";
                            case 21:
                                return "Cont. Priority AE";
                            case 22:
                                return "Auto+";
                            case 23:
                                return "3D Sweep Panorama";
                            case 24:
                                return "Superior Auto";
                            case 25:
                                return "High Sensitivity";
                            case 26:
                                return "Fireworks";
                            case 27:
                                return "Food";
                            case 28:
                                return "Pet";
                            default:
                                return "Unknown (" + O00000o010 + ")";
                        }
                }
            case 45092:
                return O000000o(45092, "ISO Setting Used", "High Key", "Low Key");
            case 45093:
                Integer O00000o011 = ((abm) this.f2602O000000o).O00000o0(45093);
                if (O00000o011 == null) {
                    return null;
                }
                int intValue10 = O00000o011.intValue();
                if (intValue10 == 0) {
                    return "Off";
                }
                if (intValue10 == 1) {
                    return "Standard";
                }
                if (intValue10 == 2) {
                    return "Advanced Auto";
                }
                if (intValue10 == 3) {
                    return "Auto";
                }
                switch (intValue10) {
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return "Advanced LV1";
                    case 9:
                        return "Advanced LV2";
                    case 10:
                        return "Advanced LV3";
                    case 11:
                        return "Advanced LV4";
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        return "Advanced LV5";
                    default:
                        switch (intValue10) {
                            case 16:
                                return "LV1";
                            case 17:
                                return "LV2";
                            case 18:
                                return "LV3";
                            case 19:
                                return "LV4";
                            case 20:
                                return "LV5";
                            default:
                                return String.format("Unknown (%d)", O00000o011);
                        }
                }
            case 45094:
                Integer O00000o012 = ((abm) this.f2602O000000o).O00000o0(45094);
                if (O00000o012 == null) {
                    return null;
                }
                int intValue11 = O00000o012.intValue();
                if (intValue11 != 0) {
                    return intValue11 != 1 ? "N/A" : "On";
                }
                return "Off";
            case 45097:
                Integer O00000o013 = ((abm) this.f2602O000000o).O00000o0(45097);
                if (O00000o013 == null) {
                    return null;
                }
                int intValue12 = O00000o013.intValue();
                switch (intValue12) {
                    case 0:
                        return "Standard";
                    case 1:
                        return "Vivid";
                    case 2:
                        return "Portrait";
                    case 3:
                        return "Landscape";
                    case 4:
                        return "Sunset";
                    case 5:
                        return "Night Portrait";
                    case 6:
                        return "Black & White";
                    case 7:
                        return "Adobe RGB";
                    default:
                        switch (intValue12) {
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                return "Neutral";
                            case 13:
                                return "Clear";
                            case 14:
                                return "Deep";
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                return "Light";
                            case 16:
                                return "Autumn";
                            case 17:
                                return "Sepia";
                            default:
                                switch (intValue12) {
                                    case 100:
                                        return "Neutral";
                                    case 101:
                                        return "Clear";
                                    case 102:
                                        return "Deep";
                                    case 103:
                                        return "Light";
                                    case 104:
                                        return "Night View";
                                    case 105:
                                        return "Autumn Leaves";
                                    default:
                                        return String.format("Unknown (%d)", O00000o013);
                                }
                        }
                }
            case 45120:
                Integer O00000o014 = ((abm) this.f2602O000000o).O00000o0(45120);
                if (O00000o014 == null) {
                    return null;
                }
                int intValue13 = O00000o014.intValue();
                if (intValue13 == 0) {
                    return "Off";
                }
                if (intValue13 == 1) {
                    return "On";
                }
                if (intValue13 == 2) {
                    return "Magnifying Glass/Super Macro";
                }
                if (intValue13 == 65535) {
                    return "N/A";
                }
                return String.format("Unknown (%d)", O00000o014);
            case 45121:
                Integer O00000o015 = ((abm) this.f2602O000000o).O00000o0(45121);
                if (O00000o015 == null) {
                    return null;
                }
                int intValue14 = O00000o015.intValue();
                if (intValue14 == 29) {
                    return "Underwater";
                }
                if (intValue14 == 65535) {
                    return "N/A";
                }
                switch (intValue14) {
                    case 0:
                        return "Program";
                    case 1:
                        return "Portrait";
                    case 2:
                        return "Beach";
                    case 3:
                        return "Sports";
                    case 4:
                        return "Snow";
                    case 5:
                        return "Landscape";
                    case 6:
                        return "Auto";
                    case 7:
                        return "Aperture Priority";
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return "Shutter Priority";
                    case 9:
                        return "Night Scene / Twilight";
                    case 10:
                        return "Hi-Speed Shutter";
                    case 11:
                        return "Twilight Portrait";
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        return "Soft Snap/Portrait";
                    case 13:
                        return "Fireworks";
                    case 14:
                        return "Smile Shutter";
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        return "Manual";
                    default:
                        switch (intValue14) {
                            case 18:
                                return "High Sensitivity";
                            case 19:
                                return "Macro";
                            case 20:
                                return "Advanced Sports Shooting";
                            default:
                                switch (intValue14) {
                                    case 33:
                                        return "Food";
                                    case 34:
                                        return "Panorama";
                                    case 35:
                                        return "Handheld Night Shot";
                                    case 36:
                                        return "Anti Motion Blur";
                                    case 37:
                                        return "Pet";
                                    case 38:
                                        return "Backlight Correction HDR";
                                    case 39:
                                        return "Superior Auto";
                                    case 40:
                                        return "Background Defocus";
                                    case 41:
                                        return "Soft Skin";
                                    case 42:
                                        return "3D Image";
                                    default:
                                        return String.format("Unknown (%d)", O00000o015);
                                }
                        }
                }
            case 45123:
                Integer O00000o016 = ((abm) this.f2602O000000o).O00000o0(45123);
                if (O00000o016 == null) {
                    return null;
                }
                int intValue15 = O00000o016.intValue();
                if (intValue15 == 0) {
                    return "Default";
                }
                if (intValue15 == 1) {
                    return "Multi";
                }
                if (intValue15 == 2) {
                    return "Center";
                }
                if (intValue15 == 3) {
                    return "Spot";
                }
                if (intValue15 == 4) {
                    return "Flexible Spot";
                }
                if (intValue15 == 6) {
                    return "Touch";
                }
                if (intValue15 == 65535) {
                    return "n/a";
                }
                if (intValue15 == 14) {
                    return "Manual Focus";
                }
                if (intValue15 == 15) {
                    return "Face Detected";
                }
                return "Unknown (" + O00000o016 + ")";
            case 45124:
                Integer O00000o017 = ((abm) this.f2602O000000o).O00000o0(45124);
                if (O00000o017 == null) {
                    return null;
                }
                int intValue16 = O00000o017.intValue();
                if (intValue16 == 0) {
                    return "Off";
                }
                if (intValue16 == 1) {
                    return "Auto";
                }
                if (intValue16 == 65535) {
                    return "n/a";
                }
                return "Unknown (" + O00000o017 + ")";
            case 45127:
                Integer O00000o018 = ((abm) this.f2602O000000o).O00000o0(45127);
                if (O00000o018 == null) {
                    return null;
                }
                int intValue17 = O00000o018.intValue();
                if (intValue17 == 0) {
                    return "Normal";
                }
                if (intValue17 == 1) {
                    return "Fine";
                }
                if (intValue17 == 2) {
                    return "Extra Fine";
                }
                if (intValue17 == 65535) {
                    return "N/A";
                }
                return String.format("Unknown (%d)", O00000o018);
            case 45128:
                Integer O00000o019 = ((abm) this.f2602O000000o).O00000o0(45128);
                if (O00000o019 == null) {
                    return null;
                }
                int intValue18 = O00000o019.intValue();
                if (intValue18 == -32768) {
                    return "Low";
                }
                if (intValue18 == 128) {
                    return "n/a";
                }
                if (intValue18 == 32767) {
                    return "High";
                }
                switch (intValue18) {
                    case -3:
                        return "-3/3";
                    case -2:
                        return "-2/3";
                    case -1:
                        return "-1/3";
                    case 0:
                        return "Normal";
                    case 1:
                        return "+1/3";
                    case 2:
                        return "+2/3";
                    case 3:
                        return "+3/3";
                    default:
                        return "Unknown (" + O00000o019 + ")";
                }
            case 45129:
                Integer O00000o020 = ((abm) this.f2602O000000o).O00000o0(45129);
                if (O00000o020 == null) {
                    return null;
                }
                int intValue19 = O00000o020.intValue();
                if (intValue19 == 0) {
                    return "Normal";
                }
                if (intValue19 == 2) {
                    return "Continuous";
                }
                if (intValue19 == 65535) {
                    return "n/a";
                }
                if (intValue19 == 5) {
                    return "Exposure Bracketing";
                }
                if (intValue19 == 6) {
                    return "White Balance Bracketing";
                }
                return "Unknown (" + O00000o020 + ")";
            case 45130:
                Integer O00000o021 = ((abm) this.f2602O000000o).O00000o0(45129);
                if (O00000o021 == null) {
                    return null;
                }
                int intValue20 = O00000o021.intValue();
                if (intValue20 == 0) {
                    return "Single";
                }
                if (intValue20 != 65535) {
                    return O00000o021.toString();
                }
                return "n/a";
            case 45131:
                Integer O00000o022 = ((abm) this.f2602O000000o).O00000o0(45131);
                if (O00000o022 == null) {
                    return null;
                }
                int intValue21 = O00000o022.intValue();
                if (intValue21 == 0) {
                    return "Off";
                }
                if (intValue21 == 1) {
                    return "On (Continuous)";
                }
                if (intValue21 == 2) {
                    return "On (Shooting)";
                }
                if (intValue21 == 65535) {
                    return "N/A";
                }
                return String.format("Unknown (%d)", O00000o022);
            case 45134:
                Integer O00000o023 = ((abm) this.f2602O000000o).O00000o0(45134);
                if (O00000o023 == null) {
                    return null;
                }
                int intValue22 = O00000o023.intValue();
                if (intValue22 == 0) {
                    return "Off";
                }
                if (intValue22 == 1) {
                    return "On";
                }
                if (intValue22 == 65535) {
                    return "N/A";
                }
                return String.format("Unknown (%d)", O00000o023);
            default:
                return super.O000000o(i);
        }
    }
}

package _m_j;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public final class agl extends xx<agm> {
    public agl(agm agm) {
        super(agm);
    }

    public final String O000000o(int i) {
        if (i != 1002) {
            if (i == 1005) {
                return O0000Oo0();
            }
            if (i == 1028) {
                byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(i);
                if (O0000O0o == null) {
                    return null;
                }
                return String.format("%d bytes binary data", Integer.valueOf(O0000O0o.length));
            } else if (i == 1030) {
                return O00000oo();
            } else {
                if (!(i == 1044 || i == 1054)) {
                    if (i == 1057) {
                        return O0000Oo();
                    }
                    if (i == 1062) {
                        return O0000OOo();
                    }
                    if (i == 1064) {
                        return O0000O0o();
                    }
                    if (i == 2999) {
                        return O0000OOo(i);
                    }
                    if (i != 1049) {
                        if (i == 1050) {
                            return O0000OoO();
                        }
                        switch (i) {
                            case 1033:
                            case 1036:
                                return O00000oo(i);
                            case 1034:
                                byte[] O0000O0o2 = ((agm) this.f2602O000000o).O0000O0o(i);
                                if (O0000O0o2 == null || O0000O0o2.length == 0) {
                                    return null;
                                }
                                return O0000O0o2[0] == 0 ? "No" : "Yes";
                            case 1035:
                                break;
                            case 1037:
                                break;
                            default:
                                if (i < 2000 || i > 2998) {
                                    return super.O000000o(i);
                                }
                                return O0000Oo0(i);
                        }
                    }
                }
                return O0000O0o(i);
            }
        }
        byte[] O0000O0o3 = ((agm) this.f2602O000000o).O0000O0o(i);
        if (O0000O0o3 == null) {
            return null;
        }
        return new String(O0000O0o3);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[Catch:{ IOException -> 0x00ab }] */
    private String O00000oo() {
        String str;
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(1030);
            if (O0000O0o == null) {
                return ((agm) this.f2602O000000o).O0000o0(1030);
            }
            xc xcVar = new xc(O0000O0o);
            int O00000oO = xcVar.O00000oO(0);
            int O00000oO2 = xcVar.O00000oO(2);
            int O00000oO3 = xcVar.O00000oO(4);
            int i = (O00000oO > 65535 || O00000oO < 65533) ? O00000oO <= 8 ? O00000oO + 4 : O00000oO : O00000oO - 65532;
            switch (O00000oO) {
                case 0:
                    str = "Low";
                    break;
                case 1:
                case 2:
                case 3:
                    str = "Medium";
                    break;
                case 4:
                case 5:
                    str = "High";
                    break;
                case 6:
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    str = "Maximum";
                    break;
                default:
                    switch (O00000oO) {
                        case 65533:
                        case 65534:
                        case 65535:
                            break;
                        default:
                            str = "Unknown";
                            break;
                    }
            }
            return String.format("%d (%s), %s format, %s scans", Integer.valueOf(i), str, O00000oO2 != 0 ? O00000oO2 != 1 ? O00000oO2 != 257 ? String.format("Unknown 0x%04X", Integer.valueOf(O00000oO2)) : "Progressive" : "Optimised" : "Standard", (O00000oO3 <= 0 || O00000oO3 > 3) ? String.format("Unknown 0x%04X", Integer.valueOf(O00000oO3)) : String.format("%d", Integer.valueOf(O00000oO3 + 2)));
        } catch (IOException unused) {
            return null;
        }
    }

    private String O0000O0o() {
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(1064);
            if (O0000O0o == null) {
                return null;
            }
            return Double.toString(new xc(O0000O0o).O0000o00(4));
        } catch (Exception unused) {
            return null;
        }
    }

    private String O0000OOo() {
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(1062);
            if (O0000O0o == null) {
                return null;
            }
            xc xcVar = new xc(O0000O0o);
            int O0000Oo0 = xcVar.O0000Oo0(0);
            float O0000Ooo = xcVar.O0000Ooo(2);
            float O0000Ooo2 = xcVar.O0000Ooo(6);
            float O0000Ooo3 = xcVar.O0000Ooo(10);
            if (O0000Oo0 == 0) {
                return "Centered, Scale ".concat(String.valueOf(O0000Ooo3));
            }
            if (O0000Oo0 == 1) {
                return "Size to fit";
            }
            if (O0000Oo0 != 2) {
                return String.format("Unknown %04X, X:%s Y:%s, Scale:%s", Integer.valueOf(O0000Oo0), Float.valueOf(O0000Ooo), Float.valueOf(O0000Ooo2), Float.valueOf(O0000Ooo3));
            }
            return String.format("User defined, X:%s Y:%s, Scale:%s", Float.valueOf(O0000Ooo), Float.valueOf(O0000Ooo2), Float.valueOf(O0000Ooo3));
        } catch (Exception unused) {
            return null;
        }
    }

    private String O0000Oo0() {
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(1005);
            if (O0000O0o == null) {
                return null;
            }
            xc xcVar = new xc(O0000O0o);
            float O0000OoO = xcVar.O0000OoO(0);
            float O0000OoO2 = xcVar.O0000OoO(8);
            DecimalFormat decimalFormat = new DecimalFormat("0.##");
            return decimalFormat.format((double) O0000OoO) + "x" + decimalFormat.format((double) O0000OoO2) + " DPI";
        } catch (Exception unused) {
            return null;
        }
    }

    private String O0000Oo() {
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(1057);
            if (O0000O0o == null) {
                return null;
            }
            xc xcVar = new xc(O0000O0o);
            int O0000Oo0 = xcVar.O0000Oo0(0);
            int O0000Oo02 = xcVar.O0000Oo0(5) * 2;
            String O000000o2 = xcVar.O000000o(9, O0000Oo02, "UTF-16");
            int i = O0000Oo02 + 9;
            int O0000Oo03 = xcVar.O0000Oo0(i);
            int i2 = i + 4;
            int i3 = O0000Oo03 * 2;
            return String.format("%d (%s, %s) %d", Integer.valueOf(O0000Oo0), O000000o2, xcVar.O000000o(i2, i3, "UTF-16"), Integer.valueOf(xcVar.O0000Oo0(i2 + i3)));
        } catch (IOException unused) {
            return null;
        }
    }

    private String O0000OoO() {
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(1050);
            if (O0000O0o == null) {
                return null;
            }
            xc xcVar = new xc(O0000O0o);
            int O0000Oo0 = xcVar.O0000Oo0(20) * 2;
            return String.format("%s (%d,%d,%d,%d) %d Slices", xcVar.O000000o(24, O0000Oo0, "UTF-16"), Integer.valueOf(xcVar.O0000Oo0(4)), Integer.valueOf(xcVar.O0000Oo0(8)), Integer.valueOf(xcVar.O0000Oo0(12)), Integer.valueOf(xcVar.O0000Oo0(16)), Integer.valueOf(xcVar.O0000Oo0(O0000Oo0 + 24)));
        } catch (IOException unused) {
            return null;
        }
    }

    private String O00000oo(int i) {
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(i);
            if (O0000O0o == null) {
                return null;
            }
            xc xcVar = new xc(O0000O0o);
            int O0000Oo0 = xcVar.O0000Oo0(0);
            int O0000Oo02 = xcVar.O0000Oo0(4);
            int O0000Oo03 = xcVar.O0000Oo0(8);
            int O0000Oo04 = xcVar.O0000Oo0(16);
            int O0000Oo05 = xcVar.O0000Oo0(20);
            int O0000Oo06 = xcVar.O0000Oo0(24);
            Object[] objArr = new Object[6];
            objArr[0] = O0000Oo0 == 1 ? "JpegRGB" : "RawRGB";
            objArr[1] = Integer.valueOf(O0000Oo02);
            objArr[2] = Integer.valueOf(O0000Oo03);
            objArr[3] = Integer.valueOf(O0000Oo04);
            objArr[4] = Integer.valueOf(O0000Oo06);
            objArr[5] = Integer.valueOf(O0000Oo05);
            return String.format("%s, %dx%d, Decomp %d bytes, %d bpp, %d bytes", objArr);
        } catch (IOException unused) {
            return null;
        }
    }

    private String O0000O0o(int i) {
        byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(i);
        if (O0000O0o == null) {
            return null;
        }
        try {
            return String.format("%d", Integer.valueOf(new xc(O0000O0o).O0000Oo0(0)));
        } catch (IOException unused) {
            return null;
        }
    }

    private String O0000OOo(int i) {
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(i);
            if (O0000O0o == null) {
                return null;
            }
            xc xcVar = new xc(O0000O0o);
            return new String(xcVar.O00000o0(1, xcVar.O000000o(0)), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    private String O0000Oo0(int i) {
        String str;
        String str2;
        int i2;
        xc xcVar;
        ArrayList arrayList;
        String str3;
        ags ags;
        ArrayList arrayList2;
        agk agk;
        agk agk2;
        String str4 = ")";
        String str5 = ",";
        try {
            byte[] O0000O0o = ((agm) this.f2602O000000o).O0000O0o(i);
            if (O0000O0o == null) {
                return null;
            }
            xc xcVar2 = new xc(O0000O0o);
            short s = 1;
            int O000000o2 = ((int) ((xcVar2.O000000o() - ((long) xcVar2.O000000o(((int) xcVar2.O000000o()) - 1))) - 1)) / 26;
            ags ags2 = new ags();
            ags ags3 = new ags();
            ArrayList arrayList3 = new ArrayList();
            String str6 = null;
            ags ags4 = ags3;
            ags ags5 = ags2;
            int i3 = 0;
            while (i3 < O000000o2) {
                int i4 = i3 * 26;
                try {
                    short O00000oo = xcVar2.O00000oo(i4);
                    ags ags6 = ags4;
                    switch (O00000oo) {
                        case 0:
                            str2 = str4;
                            str = str5;
                            i2 = O000000o2;
                            xcVar = xcVar2;
                            arrayList = arrayList3;
                            str3 = str6;
                            ags ags7 = ags6;
                            if (ags5.f12382O000000o.size() != 0) {
                                arrayList.add(ags5);
                            }
                            ags4 = ags7;
                            ags5 = new ags("Closed Subpath");
                            break;
                        case 1:
                        case 2:
                            str2 = str4;
                            str = str5;
                            i2 = O000000o2;
                            arrayList2 = arrayList3;
                            str3 = str6;
                            ags = ags6;
                            if (O00000oo == 1) {
                                agk = new agk("Linked");
                            } else {
                                agk = new agk("Unlinked");
                            }
                            int i5 = 0;
                            while (i5 < 6) {
                                int i6 = i5 * 4;
                                double O00000o = (double) xcVar2.O00000o(i6 + 2 + i4);
                                double O0000O0o2 = (double) xcVar2.O0000O0o(i6 + 3 + i4);
                                xc xcVar3 = xcVar2;
                                int i7 = i4;
                                double pow = Math.pow(2.0d, 24.0d);
                                Double.isNaN(O0000O0o2);
                                Double.isNaN(O00000o);
                                agk.f12380O000000o[i5] = O00000o + (O0000O0o2 / pow);
                                i5++;
                                xcVar2 = xcVar3;
                                i4 = i7;
                            }
                            xcVar = xcVar2;
                            ags5.O000000o(agk);
                            ags4 = ags;
                            break;
                        case 3:
                            str2 = str4;
                            str = str5;
                            i2 = O000000o2;
                            ArrayList arrayList4 = arrayList3;
                            str3 = str6;
                            ags ags8 = ags6;
                            if (ags8.f12382O000000o.size() != 0) {
                                arrayList = arrayList4;
                                arrayList.add(ags8);
                            } else {
                                arrayList = arrayList4;
                            }
                            ags4 = new ags("Open Subpath");
                            xcVar = xcVar2;
                            break;
                        case 4:
                        case 5:
                            if (O00000oo == 4) {
                                agk2 = new agk("Linked");
                            } else {
                                agk2 = new agk("Unlinked");
                            }
                            int i8 = 0;
                            while (i8 < 6) {
                                int i9 = i8 * 4;
                                ArrayList arrayList5 = arrayList3;
                                double O00000o2 = (double) xcVar2.O00000o(i9 + 2 + i4);
                                int i10 = O000000o2;
                                double O0000O0o3 = (double) xcVar2.O0000O0o(i9 + 3 + i4);
                                String str7 = str4;
                                String str8 = str5;
                                String str9 = str6;
                                double pow2 = Math.pow(2.0d, 24.0d);
                                Double.isNaN(O0000O0o3);
                                Double.isNaN(O00000o2);
                                agk2.f12380O000000o[i8] = O00000o2 + (O0000O0o3 / pow2);
                                i8++;
                                arrayList3 = arrayList5;
                                O000000o2 = i10;
                                str4 = str7;
                                str5 = str8;
                                str6 = str9;
                            }
                            str2 = str4;
                            str = str5;
                            i2 = O000000o2;
                            str3 = str6;
                            ags = ags6;
                            ags.O000000o(agk2);
                            xcVar = xcVar2;
                            arrayList2 = arrayList3;
                            ags4 = ags;
                            break;
                        case 6:
                        case 7:
                        default:
                            str2 = str4;
                            str = str5;
                            i2 = O000000o2;
                            xcVar = xcVar2;
                            arrayList2 = arrayList3;
                            str3 = str6;
                            ags = ags6;
                            ags4 = ags;
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            str2 = str4;
                            str = str5;
                            str6 = xcVar2.O00000oo(i4 + 2) == s ? "with all pixels" : "without all pixels";
                            i2 = O000000o2;
                            xcVar = xcVar2;
                            arrayList = arrayList3;
                            ags4 = ags6;
                            continue;
                            i3++;
                            arrayList3 = arrayList;
                            xcVar2 = xcVar;
                            O000000o2 = i2;
                            str4 = str2;
                            str5 = str;
                            s = 1;
                    }
                    str6 = str3;
                    i3++;
                    arrayList3 = arrayList;
                    xcVar2 = xcVar;
                    O000000o2 = i2;
                    str4 = str2;
                    str5 = str;
                    s = 1;
                } catch (Exception unused) {
                    return null;
                }
            }
            String str10 = str4;
            String str11 = str5;
            xc xcVar4 = xcVar2;
            ArrayList arrayList6 = arrayList3;
            ags ags9 = ags4;
            String str12 = str6;
            if (ags5.f12382O000000o.size() != 0) {
                arrayList6.add(ags5);
            }
            if (ags9.f12382O000000o.size() != 0) {
                arrayList6.add(ags9);
            }
            byte O000000o3 = xcVar4.O000000o(((int) xcVar4.O000000o()) - 1);
            String O000000o4 = xcVar4.O000000o((((int) xcVar4.O000000o()) - O000000o3) - 1, O000000o3, xf.O00000o);
            StringBuilder sb = new StringBuilder();
            sb.append('\"');
            sb.append(O000000o4);
            sb.append('\"');
            sb.append(" having ");
            if (str12 != null) {
                sb.append("initial fill rule \"");
                sb.append(str12);
                sb.append("\" and ");
            }
            sb.append(arrayList6.size());
            sb.append(arrayList6.size() == 1 ? " subpath:" : " subpaths:");
            Iterator it = arrayList6.iterator();
            while (it.hasNext()) {
                ags ags10 = (ags) it.next();
                sb.append("\n- ");
                sb.append(ags10.O00000Oo);
                sb.append(" with ");
                sb.append(arrayList6.size());
                sb.append(arrayList6.size() == 1 ? " knot:" : " knots:");
                for (agk agk3 : ags10.f12382O000000o) {
                    sb.append("\n  - ");
                    sb.append(agk3.O00000Oo);
                    sb.append(" (");
                    sb.append(agk3.f12380O000000o[0]);
                    String str13 = str11;
                    sb.append(str13);
                    sb.append(agk3.f12380O000000o[1]);
                    String str14 = str10;
                    sb.append(str14);
                    sb.append(" (");
                    sb.append(agk3.f12380O000000o[2]);
                    sb.append(str13);
                    sb.append(agk3.f12380O000000o[3]);
                    sb.append(str14);
                    sb.append(" (");
                    sb.append(agk3.f12380O000000o[4]);
                    sb.append(str13);
                    sb.append(agk3.f12380O000000o[5]);
                    sb.append(str14);
                    str11 = str13;
                    str10 = str14;
                }
            }
            return sb.toString();
        } catch (Exception unused2) {
            return null;
        }
    }
}

package _m_j;

import com.google.android.exoplayer2.C;

public final class icr {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String O000000o(String str) {
        char c;
        switch (str.hashCode()) {
            case -1843581369:
                if (str.equals("tsm-auth")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1498652355:
                if (str.equals("eshopmobile")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case -1419722781:
                if (str.equals("mi_huodong")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1308845963:
                if (str.equals("mipaycom")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1104067068:
                if (str.equals("miot-third-test")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case -513303352:
                if (str.equals("passportapi")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -360749757:
                if (str.equals("xiaoqiang")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -242974118:
                if (str.equals("ypsupport2")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case 265338657:
                if (str.equals("xiaomiio")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1587352602:
                if (str.equals("xiaomihome")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1781001842:
                if (str.equals("mi_eshopm_go")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2026863872:
                if (str.equals("miotstore")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return ".io.mi.com";
            case 1:
                return "api.gorouter.info";
            case 2:
                return "account.xiaomi.com";
            case 3:
                return ".home.mi.com";
            case 4:
                return "shopapi.io.mi.com";
            case 5:
                return "web.recharge.pay.xiaomi.com";
            case 6:
                return "m.mi.com";
            case 7:
                return ".huodong.mi.com";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return "api.m.mi.com";
            case 9:
                return ".io.mi.com";
            case 10:
                return "ypsupport2.kefu.mi.com";
            case 11:
                return "tsmapi.pay.xiaomi.com";
            default:
                return "";
        }
    }
}

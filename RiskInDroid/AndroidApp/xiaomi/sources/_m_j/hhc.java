package _m_j;

import com.google.android.exoplayer2.C;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class hhc {
    public static long O00000Oo(long j) {
        return j > 30000000000L ? j : j * 1000;
    }

    public static double O000000o(Object obj, double d) {
        try {
            if (obj instanceof Number) {
                return ((Number) obj).doubleValue();
            }
            return Double.parseDouble(String.valueOf(obj));
        } catch (Exception unused) {
            gsy.O000000o(6, "NumberUtils", "parseDouble " + obj + " catch exception, return defalut value " + d);
            return d;
        }
    }

    public static long O000000o(Object obj) {
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            return Long.parseLong(String.valueOf(obj));
        } catch (Exception unused) {
            gsy.O000000o(6, "NumberUtils", "parseLong " + obj + " catch exception, return defalut value 0");
            return 0;
        }
    }

    public static int O000000o(Object obj, int i) {
        try {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            return Integer.parseInt(String.valueOf(obj), 10);
        } catch (Exception unused) {
            gsy.O000000o(6, "NumberUtils", "parseDouble " + obj + " catch exception, return defalut value " + i);
            return i;
        }
    }

    public static String O000000o(long j) {
        SimpleDateFormat simpleDateFormat;
        long O00000Oo = O00000Oo(j);
        Locale O000000o2 = flk.O000000o();
        if (System.currentTimeMillis() - 86400000 > O00000Oo) {
            simpleDateFormat = new SimpleDateFormat("MM-dd", O000000o2);
        } else {
            simpleDateFormat = new SimpleDateFormat("HH:mm", O000000o2);
        }
        return simpleDateFormat.format(new Date(O00000Oo));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean O000000o(String str) {
        char c;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -1325958191:
                if (str.equals("double")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case -891985903:
                if (str.equals("string")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -844996865:
                if (str.equals("uint16")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -844996807:
                if (str.equals("uint32")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 104431:
                if (str.equals("int")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case 3029738:
                if (str.equals("bool")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3237417:
                if (str.equals("int8")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3327612:
                if (str.equals("long")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3589978:
                if (str.equals("uint")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case 97526364:
                if (str.equals("float")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case 100359764:
                if (str.equals("int16")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 100359822:
                if (str.equals("int32")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 100359917:
                if (str.equals("int64")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 109413500:
                if (str.equals("short")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 111289374:
                if (str.equals("uint8")) {
                    c = 1;
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
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }
}

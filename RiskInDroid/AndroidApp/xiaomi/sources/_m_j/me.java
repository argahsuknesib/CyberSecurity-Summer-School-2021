package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;

public final class me {
    public static String O000000o(long j) {
        Context context = PluginHostApi.instance().context();
        if (j <= 0) {
            return "0 K";
        }
        if (j < 1024) {
            return "1 K";
        }
        if (j < 1048576) {
            long j2 = j / 1024;
            if (j2 > 100) {
                DecimalFormat decimalFormat = new DecimalFormat("##0");
                StringBuilder sb = new StringBuilder();
                double d = (double) j;
                Double.isNaN(d);
                sb.append(decimalFormat.format(O000000o(d / 1024.0d)));
                sb.append(" K");
                return sb.toString();
            } else if (j2 > 10) {
                DecimalFormat decimalFormat2 = new DecimalFormat("##0.0");
                StringBuilder sb2 = new StringBuilder();
                double d2 = (double) j;
                Double.isNaN(d2);
                sb2.append(decimalFormat2.format(O000000o(d2 / 1024.0d)));
                sb2.append(" K");
                return sb2.toString();
            } else {
                DecimalFormat decimalFormat3 = new DecimalFormat("##0.00");
                StringBuilder sb3 = new StringBuilder();
                double d3 = (double) j;
                Double.isNaN(d3);
                sb3.append(decimalFormat3.format(O000000o(d3 / 1024.0d)));
                sb3.append(" K");
                return sb3.toString();
            }
        } else if (j < 1073741824) {
            long j3 = j / 1048576;
            if (j3 > 100) {
                DecimalFormat decimalFormat4 = new DecimalFormat("##0");
                StringBuilder sb4 = new StringBuilder();
                double d4 = (double) j;
                Double.isNaN(d4);
                sb4.append(decimalFormat4.format(O000000o(d4 / 1048576.0d)));
                sb4.append(context.getString(R.string.bps_m_new));
                return sb4.toString();
            } else if (j3 > 10) {
                DecimalFormat decimalFormat5 = new DecimalFormat("##0.0");
                StringBuilder sb5 = new StringBuilder();
                double d5 = (double) j;
                Double.isNaN(d5);
                sb5.append(decimalFormat5.format(O000000o(d5 / 1048576.0d)));
                sb5.append(context.getString(R.string.bps_m_new));
                return sb5.toString();
            } else {
                DecimalFormat decimalFormat6 = new DecimalFormat("##0.00");
                StringBuilder sb6 = new StringBuilder();
                double d6 = (double) j;
                Double.isNaN(d6);
                sb6.append(decimalFormat6.format(O000000o(d6 / 1048576.0d)));
                sb6.append(context.getString(R.string.bps_m_new));
                return sb6.toString();
            }
        } else if (j < 1099511627776L) {
            long j4 = j / 1073741824;
            if (j4 > 100) {
                DecimalFormat decimalFormat7 = new DecimalFormat("##0");
                StringBuilder sb7 = new StringBuilder();
                double d7 = (double) j;
                Double.isNaN(d7);
                sb7.append(decimalFormat7.format(O000000o(d7 / 1.073741824E9d)));
                sb7.append(context.getString(R.string.bps_g));
                return sb7.toString();
            } else if (j4 > 10) {
                DecimalFormat decimalFormat8 = new DecimalFormat("##0.0");
                StringBuilder sb8 = new StringBuilder();
                double d8 = (double) j;
                Double.isNaN(d8);
                sb8.append(decimalFormat8.format(O000000o(d8 / 1.073741824E9d)));
                sb8.append(context.getString(R.string.bps_g));
                return sb8.toString();
            } else {
                DecimalFormat decimalFormat9 = new DecimalFormat("##0.0");
                StringBuilder sb9 = new StringBuilder();
                double d9 = (double) j;
                Double.isNaN(d9);
                sb9.append(decimalFormat9.format(O000000o(d9 / 1.073741824E9d)));
                sb9.append(context.getString(R.string.bps_g));
                return sb9.toString();
            }
        } else {
            long j5 = j / 1099511627776L;
            if (j5 > 100) {
                DecimalFormat decimalFormat10 = new DecimalFormat("##0");
                StringBuilder sb10 = new StringBuilder();
                double d10 = (double) j;
                Double.isNaN(d10);
                sb10.append(decimalFormat10.format(d10 / 1.099511627776E12d));
                sb10.append(" T");
                return sb10.toString();
            } else if (j5 > 10) {
                DecimalFormat decimalFormat11 = new DecimalFormat("##0.0");
                StringBuilder sb11 = new StringBuilder();
                double d11 = (double) j;
                Double.isNaN(d11);
                sb11.append(decimalFormat11.format(d11 / 1.099511627776E12d));
                sb11.append(" T");
                return sb11.toString();
            } else {
                DecimalFormat decimalFormat12 = new DecimalFormat("##0.00");
                StringBuilder sb12 = new StringBuilder();
                double d12 = (double) j;
                Double.isNaN(d12);
                sb12.append(decimalFormat12.format(d12 / 1.099511627776E12d));
                sb12.append(" T");
                return sb12.toString();
            }
        }
    }

    private static double O000000o(double d) {
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal.setScale(1, RoundingMode.HALF_UP);
        return (double) bigDecimal.floatValue();
    }

    public static String O000000o(String str) {
        String str2 = chq.O00000Oo + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String O000000o(boolean z, String str) {
        return O000000o(System.currentTimeMillis(), z, str);
    }

    public static String O000000o(long j, boolean z, String str) {
        String O000000o2 = O000000o(str);
        if (TextUtils.isEmpty(O000000o2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(O000000o2);
        sb.append(File.separator);
        sb.append(clw.O000000o().O000000o(j, z));
        sb.append(z ? ".mp4" : ".jpg");
        return sb.toString();
    }

    public static String O000000o(String str, String str2) {
        String str3 = XmPluginHostApi.instance().application().getDir("mijia_camera", 0) + str2 + File.separator;
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return str3 + File.separator + str + ".jpg";
    }

    public static String O00000Oo(String str) {
        String str2 = XmPluginHostApi.instance().application().getDir("mijia_camera", 0) + str + File.separator;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str + ".temp").getAbsolutePath();
    }

    public static String O000000o(String str, String str2, int i) {
        String str3 = XmPluginHostApi.instance().application().getDir(str2, 0) + str + File.separator + "preset_position" + File.separator;
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, i + ".png").getAbsolutePath();
    }

    public static String O00000o0(String str) {
        String str2 = chq.O00000o + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String O00000o(String str) {
        String str2 = chq.O0000OOo + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String O000000o(String str, int i, String str2) {
        String O00000o = O00000o(str);
        if (TextUtils.isEmpty(O00000o)) {
            return null;
        }
        civ.O000000o("AlbumActivity", "generateTimeLapseFilepath taskID=" + i + ",taskName=" + str2);
        return O00000o + File.separator + i + "_" + str2 + File.separator;
    }

    private static String O000000o(int i) {
        if (i < 0) {
            return "";
        }
        if (i < 0 || i > 9) {
            return String.valueOf(i);
        }
        return "0".concat(String.valueOf(i));
    }

    public static String O000000o() {
        String str = chq.O0000Oo0 + File.separator;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String O00000Oo(String str, int i, String str2) {
        String str3;
        if (TextUtils.isEmpty(O00000o(str))) {
            str3 = null;
        } else {
            str3 = O000000o(str, i, str2) + "pic/";
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        Calendar instance = Calendar.getInstance();
        sb.append((instance.get(1) + O000000o(instance.get(2) + 1) + O000000o(instance.get(5))) + "_" + (O000000o(instance.get(11)) + O000000o(instance.get(12)) + O000000o(instance.get(13))));
        sb.append(".jpg");
        return sb.toString();
    }
}

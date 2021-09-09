package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.mistream.MIStreamStatistic;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

public final class cin {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final HashSet<String> f13904O000000o;

    public static int O000000o(int i) {
        if (i <= 0) {
            return 0;
        }
        return i;
    }

    public static int O000000o(int i, boolean z) {
        if (z && i == 0) {
            return 3;
        }
        if (!z || i != 2) {
            return (i <= 0 || i > 5 || i == 2) ? 1 : 2;
        }
        return 3;
    }

    public static int O00000Oo(int i, boolean z) {
        if (i == 2 && z) {
            return 6;
        }
        if (i == 0 && z) {
            return 6;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 3) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        return i == 4 ? 5 : 1;
    }

    public static int O00000o0(int i, boolean z) {
        if ((i == 2 && z) || (i == 0 && z)) {
            return 6;
        }
        if (i == 1) {
            return 2;
        }
        int i2 = 3;
        if (!(i == 3 || i == 6)) {
            i2 = 4;
            if (!(i == 5 || i == 7)) {
                if (i == 4) {
                    return 5;
                }
                return i == 2 ? 6 : 1;
            }
        }
        return i2;
    }

    public static String O000000o(Resources resources, int i) {
        String string = resources.getString(R.string.sd_card_status0);
        if (i == 1) {
            return resources.getString(R.string.sd_card_status1);
        }
        if (i == 2) {
            return resources.getString(R.string.sd_card_status2);
        }
        if (i == 3) {
            return resources.getString(R.string.sd_card_status3);
        }
        if (i == 4) {
            return resources.getString(R.string.sd_card_status4);
        }
        if (i != 5) {
            return string;
        }
        return resources.getString(R.string.sd_card_status5);
    }

    public static String O00000Oo(Resources resources, int i) {
        switch (i) {
            case 604800:
                return resources.getString(R.string.nas_recycle_week);
            case 2592000:
                return resources.getString(R.string.nas_recycle_month);
            case 7776000:
                return resources.getString(R.string.nas_recycle_3_months);
            case 15552000:
                return resources.getString(R.string.nas_recycle_6_months);
            case 31104000:
                return resources.getString(R.string.nas_recycle_12_months);
            default:
                return "";
        }
    }

    public static String O00000o0(Resources resources, int i) {
        if (i == 300) {
            return resources.getString(R.string.nas_sync_interval_real_time);
        }
        if (i == 3600) {
            return resources.getString(R.string.nas_sync_interval_1_hour);
        }
        if (i != 86400) {
            return resources.getString(R.string.nas_sync_interval_real_time);
        }
        return resources.getString(R.string.nas_sync_interval_1_day);
    }

    public static String O00000o(Resources resources, int i) {
        if (i < 20) {
            return resources.getString(R.string.connect_step1);
        }
        if (i < 40) {
            return resources.getString(R.string.connect_step2);
        }
        if (i < 70) {
            return resources.getString(R.string.connect_step3);
        }
        if (i < 80) {
            return resources.getString(R.string.connect_step4);
        }
        return resources.getString(R.string.connect_step5);
    }

    public static Spanned O00000oO(Resources resources, int i) {
        if (i < 0) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resources.openRawResource(i)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bufferedReader.close();
        return Html.fromHtml(sb.toString());
    }

    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        f13904O000000o = hashSet;
        hashSet.add("SM-E7009");
        f13904O000000o.add("Redmi Note 4X");
    }

    public static boolean O000000o() {
        String globalSettingServer = XmPluginHostApi.instance().getGlobalSettingServer();
        return !TextUtils.isEmpty(globalSettingServer) && globalSettingServer.toLowerCase().equals("cn");
    }

    public static boolean O00000Oo() {
        String globalSettingServer = XmPluginHostApi.instance().getGlobalSettingServer();
        return !TextUtils.isEmpty(globalSettingServer) && globalSettingServer.toLowerCase().equals("cn");
    }

    public static int O00000o0() {
        return O00000o() / 60;
    }

    public static int O00000o() {
        try {
            return (TimeZone.getDefault().getRawOffset() + ((!TimeZone.getDefault().useDaylightTime() || !TimeZone.getDefault().inDaylightTime(new Date())) ? 0 : TimeZone.getDefault().getDSTSavings())) / 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return -25200;
        }
    }

    public static boolean O00000oO() {
        String globalSettingServer = XmPluginHostApi.instance().getGlobalSettingServer();
        return !TextUtils.isEmpty(globalSettingServer) && globalSettingServer.toLowerCase().equals("cn");
    }

    public static int O000000o(String str, String str2) {
        gsy.O00000Oo("Util", "009 019 sourceVersion:" + str + " targetVersion:" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        try {
            if (!str.contains("_") || !str2.contains("_")) {
                return 0;
            }
            String substring = str.substring(str.lastIndexOf("_"));
            String substring2 = str2.substring(str2.lastIndexOf("_"));
            if (!TextUtils.isEmpty(substring) && substring.startsWith("_")) {
                substring = substring.substring(1);
            }
            if (!TextUtils.isEmpty(substring2) && substring2.startsWith("_")) {
                substring2 = substring2.substring(1);
            }
            return O00000o(substring, substring2);
        } catch (Exception e) {
            gsy.O000000o(6, "Util", "compareDeviceMinorVersion009019 Exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public static int O00000Oo(String str, String str2) {
        gsy.O00000Oo("Util", "v3 sourceVersion:" + str + " targetVersion:" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        try {
            if (!str.contains("_") || !str2.contains("_")) {
                return 0;
            }
            String substring = str.substring(str.lastIndexOf("_"));
            String substring2 = str2.substring(str2.lastIndexOf("_"));
            if (!TextUtils.isEmpty(substring) && substring.startsWith("_")) {
                substring = substring.substring(1);
            }
            if (!TextUtils.isEmpty(substring2) && substring2.startsWith("_")) {
                substring2 = substring2.substring(1);
            }
            return O00000o(substring, substring2);
        } catch (Exception e) {
            gsy.O000000o(6, "Util", "compareDeviceMinorVersionV3 Exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    private static int O00000o(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("[._]");
        String[] split2 = str2.split("[._]");
        int min = Math.min(split.length, split2.length);
        long j = 0;
        int i = 0;
        while (i < min) {
            j = Long.parseLong(split[i]) - Long.parseLong(split2[i]);
            if (j != 0) {
                break;
            }
            i++;
        }
        if (j != 0) {
            return j > 0 ? 1 : -1;
        }
        for (int i2 = i; i2 < split.length; i2++) {
            if (Long.parseLong(split[i2]) > 0) {
                return 1;
            }
        }
        while (i < split2.length) {
            if (Long.parseLong(split2[i]) > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static String O000000o(byte[] bArr) {
        return ckm.O000000o(bArr);
    }

    public static String O000000o(long j) {
        if (j == 0) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(2);
        int i2 = instance.get(5);
        int i3 = instance.get(11);
        int i4 = instance.get(12);
        int i5 = i + 1;
        if ("zh".equals(XmPluginHostApi.instance().context().getResources().getConfiguration().locale.getLanguage())) {
            return new SimpleDateFormat("MM月dd日 HH:mm").format(instance.getTime());
        }
        String str = "Dec";
        switch (i5) {
            case 1:
                str = "Jan";
                break;
            case 2:
                str = "Feb";
                break;
            case 3:
                str = "Mar";
                break;
            case 4:
                str = "Apr";
                break;
            case 5:
                str = "May";
                break;
            case 6:
                str = "June";
                break;
            case 7:
                str = "July";
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                str = "Aug";
                break;
            case 9:
                str = "Sept";
                break;
            case 10:
                str = "Oct";
                break;
            case 11:
                str = "Nov";
                break;
        }
        return str + "." + i2 + " " + i3 + ":" + i4;
    }

    public static byte[] O000000o(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static String O000000o(long j, Resources resources) {
        if (j == 0) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.get(2);
        instance.get(5);
        instance.get(11);
        instance.get(12);
        if ("zh".equals(resources.getConfiguration().locale.getLanguage())) {
            return new SimpleDateFormat("MM月dd日 HH点mm分").format(instance.getTime());
        }
        return new SimpleDateFormat("yyy/MM/dd HH:mm").format(instance.getTime());
    }

    public static String O00000Oo(String str) {
        String[] split = str.split(":");
        StringBuilder sb = new StringBuilder();
        try {
            for (String parseInt : split) {
                sb.append(Integer.parseInt(parseInt));
                sb.append(":");
            }
            if (sb.length() > 0) {
                return sb.substring(0, sb.length() - 1);
            }
            return str;
        } catch (Exception e) {
            gsy.O000000o(6, "Util", "formatToHms:" + e.getLocalizedMessage());
            return str;
        }
    }

    public static String O00000o0(String str) {
        String[] split = str.split(":");
        StringBuilder sb = new StringBuilder();
        try {
            for (String parseInt : split) {
                int parseInt2 = Integer.parseInt(parseInt);
                if (parseInt2 < 10) {
                    sb.append("0".concat(String.valueOf(parseInt2)));
                } else {
                    sb.append(parseInt2);
                }
                sb.append(":");
            }
            if (sb.length() > 0) {
                return sb.substring(0, sb.length() - 1);
            }
            return str;
        } catch (Exception e) {
            gsy.O00000Oo("Util", "formatToHHmmss Exception:" + e.getLocalizedMessage());
            return str;
        }
    }

    public static long O00000o(String str) {
        try {
            return new SimpleDateFormat("HH:mm:ss").parse(str).getTime();
        } catch (Exception e) {
            gsy.O00000Oo("Util", "TimeStringToLong Exception" + e.getLocalizedMessage());
            return -1;
        }
    }

    public static int O00000o0(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("[_]");
        String[] split2 = str2.split("[_]");
        long O000000o2 = O000000o(split);
        long O000000o3 = O000000o(split2);
        if (O000000o2 - O000000o3 > 0) {
            return 1;
        }
        if (O000000o2 == O000000o3) {
            return 0;
        }
        return -1;
    }

    private static long O000000o(String[] strArr) {
        long j;
        long j2 = 0;
        if (strArr != null && strArr.length > 1) {
            int i = 1;
            for (int length = strArr.length - 1; length > 0; length--) {
                String str = strArr[length];
                try {
                    j = Long.parseLong(str) * ((long) i);
                } catch (Exception unused) {
                    if (!TextUtils.isEmpty(str)) {
                        int i2 = 0;
                        int i3 = 1;
                        for (int length2 = str.length() - 1; length2 >= 0; length2--) {
                            i2 += (str.charAt(length2) - '0') * i3;
                            i3 *= 10;
                        }
                        j = (long) (i2 * i);
                    }
                }
                j2 += j;
                i *= 10;
            }
        }
        return j2;
    }

    public static String O000000o(Context context, int i) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        return context.getString(R.string.main_recording, String.format("%s:%s:%s", decimalFormat.format((long) (i / 3600)), decimalFormat.format((long) ((i / 60) % 60)), decimalFormat.format((long) (i % 60))));
    }

    public static void O000000o(dty dty) {
        if (MIStreamStatistic.getInstance().latestCameraConnect > 0 && dty != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - MIStreamStatistic.getInstance().latestCameraConnect;
                if (currentTimeMillis >= 0) {
                    MIStreamStatistic.getInstance().sendCameraConnectDuration(dty.getModel(), dty.getDid(), currentTimeMillis);
                }
            } catch (Exception e) {
                gsy.O000000o(6, "Util", e.getLocalizedMessage());
            }
        }
    }

    public static boolean O00000oO(String str) {
        if (!TextUtils.isEmpty(str) && DeviceConstant.isSupportNewUI(str)) {
            return true;
        }
        return false;
    }
}

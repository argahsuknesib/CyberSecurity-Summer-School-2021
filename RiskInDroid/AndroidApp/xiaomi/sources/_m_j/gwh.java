package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.xiaomi.smarthome.R;

public final class gwh {
    public static String O000000o(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String format = String.format(context.getResources().getString(R.string.version_name_string), packageInfo.versionName);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(format);
            if (gfr.O0000OOo || gfr.O0000o0o || gfr.O0000Ooo) {
                stringBuffer.append(".");
                stringBuffer.append(Math.abs(gfr.O00000o0));
            }
            if (gfr.O0000o00) {
                stringBuffer.append(context.getResources().getString(R.string.version_suffix_dev_publish));
            } else if (gfr.O0000o0o) {
                stringBuffer.append("测试版");
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}

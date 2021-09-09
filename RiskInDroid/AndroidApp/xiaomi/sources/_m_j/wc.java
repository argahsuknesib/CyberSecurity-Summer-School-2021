package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.application.CommonApplication;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class wc {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static String f2569O000000o;
        private static String O00000Oo;
        private static String O00000o0;

        public static String O000000o() {
            String str = f2569O000000o;
            if (str != null) {
                return str;
            }
            CommonApplication.getGlobalWorkerHandler().post($$Lambda$wc$O000000o$EQRuDw0AxA1cpW05334Lw9iRxA.INSTANCE);
            return null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O00000Oo() {
            String str;
            Context appContext = CommonApplication.getAppContext();
            if (TextUtils.isEmpty(O00000o0)) {
                String O00000o02 = ftm.O00000o0(appContext);
                if (TextUtils.equals(O00000o02, appContext.getPackageName())) {
                    O00000o0 = "mistat";
                } else {
                    O00000o0 = "mistat" + O000000o(O00000o02);
                }
            }
            SharedPreferences O000000o2 = gpy.O000000o(appContext, O00000o0);
            String string = O000000o2.getString("device_id_v2", "");
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(f2569O000000o)) {
                    String O00000Oo2 = O00000Oo(appContext);
                    String str2 = Build.SERIAL;
                    String O00000o03 = O00000o0(appContext);
                    str = O000000o(O00000Oo2 + str2 + O00000o03);
                } else {
                    str = f2569O000000o;
                }
                f2569O000000o = str;
                O000000o2.edit().putString("device_id", f2569O000000o).apply();
                return;
            }
            f2569O000000o = string;
        }

        public static String O000000o(Context context) {
            if (!TextUtils.isEmpty(O00000Oo)) {
                return O00000Oo;
            }
            String O00000Oo2 = O00000Oo(context);
            String str = Build.SERIAL;
            return O000000o(O00000Oo2 + str);
        }

        private static String O000000o(String str) {
            if (str == null) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA1");
                instance.update(str != null ? str.getBytes(StandardCharsets.UTF_8) : new byte[0]);
                return String.format("%1$032X", new BigInteger(1, instance.digest()));
            } catch (NoSuchAlgorithmException unused) {
                return str;
            }
        }

        @SuppressLint({"HardwareIds"})
        private static String O00000Oo(Context context) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable unused) {
                return null;
            }
        }

        private static String O00000o0(Context context) {
            String deviceId;
            try {
                if (Build.VERSION.SDK_INT <= 28 && ContextCompat.O000000o(context, "android.permission.READ_PHONE_STATE") == 0 && (deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId()) != null) {
                    return deviceId;
                }
            } catch (Exception unused) {
            }
            return "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        }
    }
}

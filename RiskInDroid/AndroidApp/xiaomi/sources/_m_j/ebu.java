package _m_j;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.UUID;

public final class ebu {
    private static String O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f15156O000000o;

    public static ebu O000000o() {
        return ecg.f15163O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    private static String O000000o(File file) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.readFully(bArr);
                String str = new String(bArr, "UTF-8");
                randomAccessFile.close();
                return str;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    private static String O00000Oo(Context context) {
        String str;
        String str2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            str = telephonyManager.getDeviceId();
            try {
                if (!TextUtils.isEmpty(str) && str.startsWith("86")) {
                    return str;
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(telephonyManager, 0);
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            str = "000000000000000";
            e.printStackTrace();
            Method declaredMethod2 = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE);
            declaredMethod2.setAccessible(true);
            str2 = (String) declaredMethod2.invoke(telephonyManager, 0);
            return str2;
        }
        try {
            Method declaredMethod22 = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE);
            declaredMethod22.setAccessible(true);
            str2 = (String) declaredMethod22.invoke(telephonyManager, 0);
            if (!TextUtils.isEmpty(str2) && str2.startsWith("86")) {
                return str2;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                for (int i = 0; i < telephonyManager.getPhoneCount(); i++) {
                    String deviceId = telephonyManager.getDeviceId(i);
                    if (!TextUtils.isEmpty(deviceId) && deviceId.startsWith("86")) {
                        return deviceId;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return TextUtils.isEmpty(str) ? "000000000000000" : str;
    }

    private static String O00000o0(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            e.printStackTrace();
            return "000000000000000";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091 A[Catch:{ Exception -> 0x009c }] */
    public final synchronized String O000000o(Context context) {
        FileOutputStream fileOutputStream;
        if (context != null) {
            this.f15156O000000o = context.getApplicationContext();
        }
        if (O00000Oo == null) {
            File file = new File(this.f15156O000000o.getFilesDir(), "UNIQUEID");
            try {
                if (!file.exists()) {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            String str = O00000o0(this.f15156O000000o);
                            fileOutputStream.write(new UUID((long) (Settings.Secure.getString(this.f15156O000000o.getContentResolver(), "android_id")).hashCode(), ((long) str.hashCode()) | (((long) (O00000Oo(this.f15156O000000o)).hashCode()) << 32)).toString().getBytes("UTF-8"));
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
                O00000Oo = O000000o(file);
            } catch (Exception unused) {
                return "no_id";
            }
        }
        if (O00000Oo == null) {
            O00000Oo = "";
        }
        return O00000Oo;
    }
}

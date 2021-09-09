package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.NotificationCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

public final class djn {
    public static String O000000o(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        return null;
    }

    public static String O000000o(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int O000000o(String str, String str2) {
        if (str == null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        if (split2.length > i) {
            return -1;
        }
        return 0;
    }

    public static String O00000Oo(Context context, String str) {
        diz.O000000o("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(signatureArr[0].toByteArray());
            String O000000o2 = djp.O000000o(instance.digest());
            instance.reset();
            diz.O000000o("openSDK_LOG.SystemUtils", "-->sign: ".concat(String.valueOf(O000000o2)));
            instance.update(djp.O00000oO(packageName + "_" + O000000o2 + "_" + str));
            str2 = djp.O000000o(instance.digest());
            instance.reset();
            diz.O000000o("openSDK_LOG.SystemUtils", "-->signEncryped: ".concat(String.valueOf(str2)));
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            diz.O00000Oo("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static String O000000o(Activity activity, String str) {
        if (activity == null) {
            diz.O00000oO("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] O000000o2 = djj.O000000o(str);
            if (O000000o2 == null) {
                diz.O00000oO("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(O000000o2, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(O000000o2, 8, bArr2, 0, 16);
            return djj.O000000o(activity.getPackageName(), djj.O000000o(bArr2), bArr);
        } catch (Exception e) {
            diz.O00000Oo("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    public static boolean O000000o(Context context, Intent intent) {
        if (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
            return false;
        }
        return true;
    }

    public static String O000000o(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1 A[SYNTHETIC, Splitter:B:42:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8 A[SYNTHETIC, Splitter:B:46:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b2 A[SYNTHETIC, Splitter:B:53:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9 A[SYNTHETIC, Splitter:B:57:0x00b9] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @SuppressLint({"SdCardPath"})
    public static boolean O00000Oo(String str, String str2) {
        InputStream inputStream;
        OutputStream outputStream;
        diz.O00000o0("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: ".concat(String.valueOf(str)));
        Context O000000o2 = djk.O000000o();
        if (O000000o2 == null) {
            diz.O00000o0("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
            return false;
        }
        SharedPreferences sharedPreferences = O000000o2.getSharedPreferences("secure_lib", 0);
        File file = new File(O000000o2.getFilesDir(), str2);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            int i = sharedPreferences.getInt("version", 0);
            diz.O00000o0("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: 5" + " | oldVersion: " + i);
            if (5 == i) {
                return true;
            }
        }
        ? r4 = 0;
        try {
            inputStream = O000000o2.getAssets().open(str);
            try {
                FileOutputStream openFileOutput = O000000o2.openFileOutput(str2, 0);
                O000000o(inputStream, openFileOutput);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("version", 5);
                edit.commit();
                r4 = openFileOutput;
                r4 = openFileOutput;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
                return true;
            } catch (Exception e2) {
                e = e2;
                OutputStream outputStream2 = r4;
                r4 = inputStream;
                outputStream = outputStream2;
                try {
                    diz.O00000Oo("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (r4 != 0) {
                    }
                    if (outputStream != null) {
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    InputStream inputStream2 = r4;
                    r4 = outputStream;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                    }
                    if (r4 != 0) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r4 = r4;
                if (inputStream != null) {
                }
                if (r4 != 0) {
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
            diz.O00000Oo("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
            if (r4 != 0) {
                try {
                    r4.close();
                } catch (IOException unused3) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused4) {
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            if (r4 != 0) {
                try {
                    r4.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    private static long O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                diz.O00000o0("openSDK_LOG.SystemUtils", "-->copy, copyed size is: ".concat(String.valueOf(j)));
                return j;
            }
        }
    }

    public static String O000000o(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            diz.O00000o0("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            diz.O00000Oo("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
            return null;
        } catch (Exception e2) {
            diz.O00000Oo("openSDK_LOG.SystemUtils", "Exception", e2);
            return null;
        }
    }
}

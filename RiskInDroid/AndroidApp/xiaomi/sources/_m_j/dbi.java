package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.UUID;

public final class dbi {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:12:0x001a */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002a A[SYNTHETIC, Splitter:B:22:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0039 A[SYNTHETIC, Splitter:B:32:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x004c A[SYNTHETIC, Splitter:B:43:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x005e A[SYNTHETIC, Splitter:B:53:0x005e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0041=Splitter:B:36:0x0041, B:26:0x0032=Splitter:B:26:0x0032, B:47:0x0054=Splitter:B:47:0x0054, B:12:0x001a=Splitter:B:12:0x001a} */
    /* JADX WARNING: Unknown variable types count: 1 */
    static Object O000000o(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        ? r0 = 0;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                r0 = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (StreamCorruptedException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    byteArrayInputStream.close();
                    return r0;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    r0 = objectInputStream;
                    th = th3;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException unused) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                byteArrayInputStream.close();
                return r0;
            } catch (ClassNotFoundException unused2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                byteArrayInputStream.close();
                return r0;
            }
            try {
                byteArrayInputStream.close();
            } catch (IOException e8) {
                e8.printStackTrace();
                r0 = r0;
            }
        } catch (StreamCorruptedException e9) {
            e = e9;
            objectInputStream = null;
            e.printStackTrace();
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return r0;
        } catch (IOException unused3) {
            objectInputStream = null;
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return r0;
        } catch (ClassNotFoundException unused4) {
            objectInputStream = null;
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            return r0;
        } catch (Throwable th4) {
            th = th4;
            if (r0 != 0) {
            }
            byteArrayInputStream.close();
            throw th;
        }
        return r0;
    }

    static String O000000o() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    static String O000000o(Context context) {
        if (context == null) {
            return null;
        }
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041 A[Catch:{ IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004f A[Catch:{ IOException -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    static void O000000o(String str, byte[] bArr) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(bArr));
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
            try {
                byte[] bArr2 = new byte[2048];
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read > 0) {
                        bufferedOutputStream2.write(bArr2, 0, read);
                    } else {
                        try {
                            bufferedInputStream.close();
                            bufferedOutputStream2.close();
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    try {
                        bufferedInputStream.close();
                        if (bufferedOutputStream == null) {
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedInputStream.close();
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream.close();
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            bufferedInputStream.close();
            if (bufferedOutputStream == null) {
                bufferedOutputStream.close();
            }
        }
    }

    static byte[] O000000o(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052 A[SYNTHETIC, Splitter:B:30:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0066 A[SYNTHETIC, Splitter:B:41:0x0066] */
    static byte[] O000000o(String str) {
        BufferedInputStream bufferedInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 1024);
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArray;
            } catch (IOException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (IOException e8) {
            e = e8;
            bufferedInputStream = null;
            e.printStackTrace();
            if (bufferedInputStream != null) {
            }
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    static String O00000Oo(Context context) {
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager.getDeviceId() == null ? "" : telephonyManager.getDeviceId();
    }

    private static String O00000Oo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(digest[i])));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    static boolean O00000Oo() {
        String[] strArr = {"/system/xbin/which", "/sbin/", "/system/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/", "/vendor/bin/"};
        for (int i = 0; i < 11; i++) {
            if (new File(strArr[i] + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    static int O00000o(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 16384).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static long O00000o() {
        long currentTimeMillis = System.currentTimeMillis();
        return ((double) currentTimeMillis) < 1.0E11d ? currentTimeMillis * 1000 : currentTimeMillis;
    }

    private static String O00000o0() {
        String readLine;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream()));
            for (int i = 1; i < 100 && (readLine = lineNumberReader.readLine()) != null; i++) {
                if (readLine.indexOf("Serial") >= 0) {
                    return readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static String O00000o0(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.isWifiEnabled()) {
            return wifiManager.getConnectionInfo().getBSSID();
        }
        return null;
    }

    static boolean O00000oO(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static String O00000oo(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 0) {
                return activeNetworkInfo.getSubtypeName();
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    static long O0000O0o(Context context) {
        if (context == null) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            if (Build.VERSION.SDK_INT > 8) {
                return packageManager.getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    static String O0000OOo(Context context) {
        String str = "" + "1-";
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            str = str + string;
        }
        String str2 = str + "_2-";
        String O00000Oo = O00000Oo(context);
        if (!TextUtils.isEmpty(O00000Oo)) {
            str2 = str2 + O00000Oo;
        }
        String str3 = str2 + "_3-";
        String O00000o0 = O00000o0();
        if (!TextUtils.isEmpty(O00000o0)) {
            str3 = str3 + O00000o0;
        }
        return O00000Oo(str3);
    }

    static String O0000Oo0(Context context) {
        return O00000Oo(O000000o(context) + O00000o() + UUID.randomUUID());
    }
}

package _m_j;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class imf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f1462O000000o = "";

    public static boolean O000000o() {
        String property = System.getProperty("os.arch");
        Log.i("os.arch", property + "000");
        if (property == null || !property.contains("86")) {
            return false;
        }
        Log.i("os.arch", property + "111");
        return true;
    }

    public static boolean O00000Oo() {
        String str;
        if (Build.VERSION.SDK_INT >= 21) {
            str = Arrays.toString(Build.SUPPORTED_ABIS);
        } else {
            str = Build.CPU_ABI + Build.CPU_ABI2;
        }
        Log.i("os.arch", "supportAbi:".concat(String.valueOf(str)));
        if (str != null) {
            return str.contains("armeabi-v7a") || str.contains("arm64-v8a");
        }
        return false;
    }

    public static HttpURLConnection O000000o(String str, String str2, Map<String, String> map) throws IOException {
        return O000000o(str, true, str2, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
    private static HttpURLConnection O000000o(String str, boolean z, String str2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        if (imj.O00000o0 != null && z) {
            if (imj.O00000o0.O0000Ooo != null) {
                httpURLConnection = imj.O00000o0.O0000Ooo.O000000o(str, str2, O000000o(map));
            } else if (!TextUtils.isEmpty(imj.O00000o0.O00000o0)) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(imj.O00000o0.O00000o0, imj.O00000o0.O00000o)));
                httpURLConnection.setRequestMethod(str2);
                if (!TextUtils.isEmpty(imj.O00000o0.O00000oo)) {
                    httpURLConnection.setRequestProperty("Authorization", imj.O00000o0.O00000oo);
                }
                if (map != null) {
                    for (Map.Entry next : map.entrySet()) {
                        if (next != null) {
                            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                        }
                    }
                }
                if (imj.O00000o0.O0000OoO != null) {
                    for (Map.Entry next2 : imj.O00000o0.O0000OoO.entrySet()) {
                        if (next2 != null) {
                            httpURLConnection.setRequestProperty((String) next2.getKey(), (String) next2.getValue());
                        }
                    }
                }
            }
            if (httpURLConnection == null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setRequestMethod(str2);
                if (imj.O00000Oo != null) {
                    httpURLConnection.setRequestProperty("User-Agent", imj.O00000Oo);
                }
                if (imj.O00000o != null && imj.O00000o.size() > 0) {
                    for (Map.Entry next3 : imj.O00000o.entrySet()) {
                        if (next3 != null) {
                            httpURLConnection.setRequestProperty((String) next3.getKey(), (String) next3.getValue());
                        }
                    }
                }
                if (map != null) {
                    for (Map.Entry next4 : map.entrySet()) {
                        if (next4 != null) {
                            httpURLConnection.setRequestProperty((String) next4.getKey(), (String) next4.getValue());
                        }
                    }
                }
            }
            return httpURLConnection;
        }
        httpURLConnection = null;
        if (httpURLConnection == null) {
        }
        return httpURLConnection;
    }

    private static imu O000000o(Map<String, String> map) {
        imu imu = new imu();
        imu.O0000O0o = 20000;
        imu.O0000OOo = 20000;
        imu.O00000Oo = true;
        imu.O0000OoO = new HashMap();
        if (imj.O00000Oo != null) {
            imu.O0000OoO.put("User-Agent", imj.O00000Oo);
        }
        if (imj.O00000o != null) {
            imu.O0000OoO.putAll(imj.O00000o);
        }
        if (map != null) {
            imu.O0000OoO.putAll(map);
        }
        return imu;
    }

    public static String O00000o0() {
        if (!TextUtils.isEmpty(f1462O000000o)) {
            return f1462O000000o;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i = 2; i < split.length; i++) {
                f1462O000000o += split[i] + " ";
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return f1462O000000o;
    }

    public static void O000000o(String str) {
        File file = new File(iml.O00000oO);
        if (file.isDirectory() && !TextUtils.isEmpty(str)) {
            String str2 = str + ".chunk";
            new File(file, str2).delete();
            new File(file, str + ".index").delete();
        }
    }

    public static void O00000Oo(String str) {
        String str2;
        File file = new File(iml.O00000oO);
        if (file.isDirectory()) {
            String str3 = null;
            if (!TextUtils.isEmpty(str)) {
                String O00000Oo = imd.O00000Oo(str);
                str3 = O00000Oo + ".chunk";
                str2 = O00000Oo + ".index";
            } else {
                str2 = null;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && ((str3 == null || !str3.equalsIgnoreCase(file2.getName())) && ((str2 == null || !str2.equalsIgnoreCase(file2.getName())) && (str2 == null || !str2.endsWith(iml.O00000oo))))) {
                        file2.delete();
                    }
                }
            }
        }
        ime.O000000o().O00000Oo(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0191  */
    public static HttpURLConnection O000000o(String[] strArr, String str, int i, boolean z, String str2) {
        boolean z2;
        imv imv;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        boolean z3;
        String str3;
        String[] strArr2 = strArr;
        String str4 = str;
        int i2 = i;
        ima ima = imj.f1473O000000o;
        String[][] O000000o2 = ima != null ? ima.O000000o(strArr2[0]) : null;
        int i3 = 1;
        if (O000000o2 == null || O000000o2.length == 0) {
            O000000o2 = new String[][]{new String[]{strArr2[0], null}};
            z2 = true;
        } else {
            z2 = false;
        }
        imw imw = imj.O00000oO;
        if (imw != null) {
            imv = imw.O000000o();
        } else {
            imv = null;
        }
        imc.O000000o("UnicomDigestAuthenticator 000 == 开始获取httpconnect");
        long j = 0;
        int i4 = 0;
        int i5 = 0;
        HttpURLConnection httpURLConnection3 = null;
        while (i4 < O000000o2.length) {
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            try {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        hashMap.put("RANGE", str4);
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection3;
                    }
                }
                if (O000000o2[i4][i3] != null) {
                    httpURLConnection2 = httpURLConnection3;
                    try {
                        hashMap.put("Host", O000000o2[i4][i3]);
                        hashMap.put("httpdnsType", "ip");
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        e.printStackTrace();
                        ima.O000000o(O000000o2[i4][1], O000000o2[i4][0], strArr2[0]);
                        if (z2) {
                        }
                        httpURLConnection3 = httpURLConnection;
                        i4++;
                        i3 = 1;
                    }
                } else {
                    HttpURLConnection httpURLConnection4 = httpURLConnection3;
                    hashMap.put("httpdnsType", "domain");
                }
                if (i2 == 0) {
                    hashMap.put("Accept-Encoding", "identity");
                }
                String str5 = O000000o2[i4][0];
                if (3 != i2) {
                    str3 = str2;
                    z3 = true;
                } else {
                    str3 = str2;
                    z3 = false;
                }
                httpURLConnection = O000000o(str5, z3, str3, hashMap);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (i2 == i3) {
                        httpURLConnection.connect();
                    }
                    j = System.currentTimeMillis();
                    i5++;
                    int responseCode = httpURLConnection.getResponseCode();
                    imc.O000000o("UnicomDigestAuthenticator 456 == 耗时= " + (System.currentTimeMillis() - currentTimeMillis) + " | code = " + responseCode);
                    if (i2 == 0 && responseCode == 206) {
                        if (imv != null) {
                            new StringBuilder().append(i5);
                            String str6 = imj.O00000Oo;
                            new StringBuilder().append(j);
                        }
                        return httpURLConnection;
                    } else if (i2 == 0 || responseCode < 200 || responseCode >= 400) {
                        if (ima != null) {
                            if (responseCode != 403 || !strArr2[0].contains("is_charge") || z) {
                                ima.O000000o(O000000o2[i4][1], O000000o2[i4][0], strArr2[0]);
                                if (z2) {
                                    if (imv != null) {
                                        String str7 = imj.O00000Oo;
                                        new StringBuilder().append(j);
                                    }
                                } else if (imv != null) {
                                    new StringBuilder().append(i5);
                                    String str8 = imj.O00000Oo;
                                    new StringBuilder().append(j);
                                }
                            } else {
                                String O00000Oo = ima.O00000Oo(strArr2[0]);
                                if (TextUtils.isEmpty(O00000Oo)) {
                                    return httpURLConnection;
                                }
                                strArr2[0] = O00000Oo;
                                return O000000o(strArr2, str4, i2, true, "GET");
                            }
                        }
                        httpURLConnection3 = httpURLConnection;
                        i4++;
                        i3 = 1;
                    } else {
                        if (imv != null) {
                            new StringBuilder().append(i5);
                            String str9 = imj.O00000Oo;
                            new StringBuilder().append(j);
                        }
                        return httpURLConnection;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    ima.O000000o(O000000o2[i4][1], O000000o2[i4][0], strArr2[0]);
                    if (z2) {
                    }
                    httpURLConnection3 = httpURLConnection;
                    i4++;
                    i3 = 1;
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection2 = httpURLConnection3;
                httpURLConnection = httpURLConnection2;
                e.printStackTrace();
                ima.O000000o(O000000o2[i4][1], O000000o2[i4][0], strArr2[0]);
                if (z2) {
                    if (imv != null) {
                        String str10 = imj.O00000Oo;
                        new StringBuilder().append(j);
                    }
                } else if (imv != null) {
                    new StringBuilder().append(i5);
                    String str11 = imj.O00000Oo;
                    new StringBuilder().append(j);
                }
                httpURLConnection3 = httpURLConnection;
                i4++;
                i3 = 1;
            }
        }
        return httpURLConnection3;
    }

    private static File O00000o(String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0035 A[SYNTHETIC, Splitter:B:24:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0040 A[SYNTHETIC, Splitter:B:30:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    public static void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            O00000o(str2);
            BufferedWriter bufferedWriter = null;
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2));
                try {
                    bufferedWriter2.write(str);
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    try {
                        e.printStackTrace();
                        if (bufferedWriter == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedWriter != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (bufferedWriter == null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC, Splitter:B:25:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0051 A[SYNTHETIC, Splitter:B:32:0x0051] */
    public static String O00000o0(String str) {
        BufferedReader bufferedReader;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                String stringBuffer2 = stringBuffer.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return stringBuffer2;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}

package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.Signature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.security.cert.X509Certificate;
import org.json.JSONException;
import org.json.JSONObject;

public final class fky {
    public static void O000000o(fkp fkp, int i, PluginDeviceInfo pluginDeviceInfo) {
        boolean z = true;
        if ((i & 1) == 1) {
            pluginDeviceInfo.O000000o(fkp.f16547O000000o);
            pluginDeviceInfo.O000000o(fkp.O00000Oo);
            pluginDeviceInfo.O00000o(fkp.O00000o0);
            pluginDeviceInfo.O00000o0(fkp.O00000oO);
            pluginDeviceInfo.O00000o(fkp.O00000oo);
            pluginDeviceInfo.O00000oO(fkp.O0000O0o);
            pluginDeviceInfo.O0000O0o(fkp.O0000Oo0);
            pluginDeviceInfo.O00000oO(fkp.O0000o00);
            if (fkp.O0000OoO != null) {
                pluginDeviceInfo.O0000OOo(fkp.O0000OoO.f16548O000000o);
            }
            pluginDeviceInfo.O00000oo(fkp.O0000o0);
            pluginDeviceInfo.O0000O0o(fkp.O0000o);
            pluginDeviceInfo.O0000OOo(fkp.O0000oO0);
            pluginDeviceInfo.O0000o0(fkp.O0000oO);
            pluginDeviceInfo.O0000Oo0(fkp.O0000oOo);
            pluginDeviceInfo.O0000Oo(fkp.O0000oo0);
            pluginDeviceInfo.O0000o00(fkp.O0000oo);
            pluginDeviceInfo.O0000OoO(fkp.O0000ooO);
            pluginDeviceInfo.O0000Ooo(fkp.O00oOooO);
            pluginDeviceInfo.O00000Oo(fkp.O000O0o);
            pluginDeviceInfo.O00000o0(fkp.O000O0oO);
            pluginDeviceInfo.O000000o(fkp.O000O0oo);
            pluginDeviceInfo.O0000o0O(fkp.O00oOooo);
            pluginDeviceInfo.O0000o0o(fkp.O000O00o);
            pluginDeviceInfo.O00000Oo(fkp.O000OO00);
            if (fkp.O000OO0o == 0) {
                z = false;
            }
            pluginDeviceInfo.O000000o(z);
            pluginDeviceInfo.O0000oo0 = fkp.O000O0Oo;
            pluginDeviceInfo.O00000o0(fkp.O000OO);
            pluginDeviceInfo.O00oOoOo = fkp.O000OOOo;
            pluginDeviceInfo.O000O0o0 = fkp.O000OOo0;
            pluginDeviceInfo.O0000oO0(fkp.O000OOo);
            pluginDeviceInfo.O0000oOo = fkp.O000OOoO;
            pluginDeviceInfo.O000O0o = fkp.O000OOoo;
            pluginDeviceInfo.O0000oo = fkp.O00oOoOo;
            pluginDeviceInfo.O0000ooO = fkp.O000O0o0;
        }
        if ((i & 2) == 2) {
            pluginDeviceInfo.O00000Oo(fkp.O00000o);
            pluginDeviceInfo.O0000Oo0(fkp.O0000Ooo);
            pluginDeviceInfo.O0000Oo(fkp.O0000o0o);
            pluginDeviceInfo.O00000oo(fkp.O0000OOo);
        }
    }

    public static String O000000o(int i, Map<String, PluginDeviceInfo> map) {
        if (i <= 0) {
            return "";
        }
        try {
            for (Map.Entry<String, PluginDeviceInfo> value : map.entrySet()) {
                PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) value.getValue();
                if (pluginDeviceInfo.O00000o0() == i) {
                    return pluginDeviceInfo.O00000Oo();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static int O000000o(String str, Map<String, PluginDeviceInfo> map) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            for (Map.Entry<String, PluginDeviceInfo> value : map.entrySet()) {
                PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) value.getValue();
                if (pluginDeviceInfo.O00000Oo().equalsIgnoreCase(str)) {
                    return pluginDeviceInfo.O00000o0();
                }
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean O000000o(Context context, PluginPackageInfo pluginPackageInfo, String str) {
        String O00000o = pluginPackageInfo.O00000o();
        String O0000O0o = pluginPackageInfo.O0000O0o();
        if (O0000O0o.equalsIgnoreCase("mpk")) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(O00000o) || TextUtils.isEmpty(O0000O0o)) {
                return false;
            }
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageArchiveInfo(O00000o, 64);
            } catch (Exception e) {
                LogType logType = LogType.PLUGIN;
                gsy.O00000o0(logType, "PluginManager", "PluginUtils", O00000o + " readSignatureFail " + Log.getStackTraceString(e));
            }
            if (packageInfo != null) {
                String O000000o2 = O000000o(packageInfo.signatures);
                if (str.equalsIgnoreCase(O000000o2)) {
                    return true;
                }
                LogType logType2 = LogType.PLUGIN;
                gsy.O00000o0(logType2, "PluginManager", "PluginUtils", "error validatePackageSignature signatureMD5:" + O000000o2 + " donot match developer developerInfo:" + str);
            } else {
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "validatePackageSignature packageInfo is null path:".concat(String.valueOf(O00000o)));
            }
        } else if (!O0000O0o.equalsIgnoreCase("rn") || O000000o(O00000o) == null) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x018c, code lost:
        if (r15 > r12) goto L_0x0192;
     */
    public static JSONObject O000000o(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        X509Certificate x509Certificate;
        X509Certificate x509Certificate2;
        JSONObject jSONObject;
        byte[] digest;
        long j;
        byte[] digest2;
        byte[] bArr;
        long currentTimeMillis = System.currentTimeMillis();
        String O00000Oo = O00000Oo(str);
        File file = new File(O00000Oo, "project.json");
        FileInputStream fileInputStream4 = null;
        if (!file.exists()) {
            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "checkRnBundleSignature projectFile not exits".concat(String.valueOf(file)));
            return null;
        }
        File file2 = new File(O00000Oo, "bundle.sign");
        if (!file2.exists()) {
            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "checkRnBundleSignature signFile not exits".concat(String.valueOf(file2)));
            return null;
        }
        File file3 = new File(O00000Oo, "bundle.cert");
        if (!file3.exists()) {
            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "checkRnBundleSignature certFile not exits".concat(String.valueOf(file3)));
            return null;
        }
        File file4 = new File(O00000Oo, "main.bundle");
        if (!file4.exists()) {
            file4 = new File(O00000Oo, "sdk.bundle");
            if (!file4.exists()) {
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "checkRnBundleSignature bundleFile not exits".concat(String.valueOf(file4)));
                return null;
            }
        }
        try {
            String O000000o2 = fkw.O000000o(file3.getAbsolutePath());
            if (TextUtils.isEmpty(O000000o2)) {
                gpg.O000000o((InputStream) null);
                gpg.O000000o((InputStream) null);
                gpg.O000000o((InputStream) null);
                return null;
            }
            if (O000000o2.charAt(0) != '-') {
                try {
                    O000000o2 = O000000o2.trim();
                } catch (Exception e) {
                    e = e;
                    fileInputStream3 = null;
                    fileInputStream2 = null;
                    try {
                        gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", Log.getStackTraceString(e));
                        gpg.O000000o(fileInputStream4);
                        gpg.O000000o(fileInputStream2);
                        gpg.O000000o(fileInputStream3);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream4;
                        gpg.O000000o(fileInputStream);
                        gpg.O000000o(fileInputStream2);
                        gpg.O000000o(fileInputStream3);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = null;
                    fileInputStream2 = null;
                    fileInputStream = null;
                    gpg.O000000o(fileInputStream);
                    gpg.O000000o(fileInputStream2);
                    gpg.O000000o(fileInputStream3);
                    throw th;
                }
            }
            int lastIndexOf = O000000o2.lastIndexOf("-----BEGIN ");
            if (lastIndexOf < 0) {
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "checkRnBundleSignature certs of rn plugin is invalid ".concat(String.valueOf(file3)));
                gpg.O000000o((InputStream) null);
                gpg.O000000o((InputStream) null);
                gpg.O000000o((InputStream) null);
                return null;
            }
            X509Certificate O000000o3 = O000000o();
            if (lastIndexOf > 0) {
                String trim = O000000o2.substring(0, lastIndexOf).trim();
                String trim2 = O000000o2.substring(lastIndexOf).trim();
                x509Certificate = X509Certificate.getInstance(trim.getBytes());
                if (O000000o(O000000o3, x509Certificate)) {
                    x509Certificate2 = X509Certificate.getInstance(trim2.getBytes());
                } else {
                    gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "checkRnBundleSignature  cert1 of rn plugin is invalid ".concat(String.valueOf(file3)));
                    gpg.O000000o((InputStream) null);
                    gpg.O000000o((InputStream) null);
                    gpg.O000000o((InputStream) null);
                    return null;
                }
            } else {
                x509Certificate2 = X509Certificate.getInstance(O000000o2.getBytes());
                x509Certificate = O000000o3;
            }
            if (!O000000o(x509Certificate, x509Certificate2)) {
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "checkRnBundleSignature  mijiaRootCert of rn plugin is invalid ".concat(String.valueOf(file3)));
                gpg.O000000o((InputStream) null);
                gpg.O000000o((InputStream) null);
                gpg.O000000o((InputStream) null);
                return null;
            }
            byte[] bArr2 = new byte[((int) file.length())];
            FileInputStream fileInputStream5 = new FileInputStream(file);
            try {
                fileInputStream5.read(bArr2);
                fileInputStream5.close();
                jSONObject = new JSONObject(new String(bArr2));
                int optInt = jSONObject.optInt("signature", -1);
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                instance.update(bArr2);
                digest = instance.digest();
                long length = file4.length();
                if (optInt > 1024) {
                    fileInputStream = fileInputStream5;
                    j = (long) optInt;
                } else {
                    fileInputStream = fileInputStream5;
                }
                j = length;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream5;
                fileInputStream4 = fileInputStream;
                fileInputStream3 = null;
                fileInputStream2 = null;
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", Log.getStackTraceString(e));
                gpg.O000000o(fileInputStream4);
                gpg.O000000o(fileInputStream2);
                gpg.O000000o(fileInputStream3);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream5;
                fileInputStream3 = null;
                fileInputStream2 = null;
                gpg.O000000o(fileInputStream);
                gpg.O000000o(fileInputStream2);
                gpg.O000000o(fileInputStream3);
                throw th;
            }
            try {
                byte[] bArr3 = new byte[((int) j)];
                fileInputStream2 = new FileInputStream(file4);
                try {
                    fileInputStream2.read(bArr3);
                    MessageDigest instance2 = MessageDigest.getInstance("SHA-256");
                    instance2.update(bArr3);
                    digest2 = instance2.digest();
                    bArr = new byte[((int) file2.length())];
                    fileInputStream3 = new FileInputStream(file2);
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream4 = fileInputStream;
                    fileInputStream3 = null;
                    gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", Log.getStackTraceString(e));
                    gpg.O000000o(fileInputStream4);
                    gpg.O000000o(fileInputStream2);
                    gpg.O000000o(fileInputStream3);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream3 = null;
                    gpg.O000000o(fileInputStream);
                    gpg.O000000o(fileInputStream2);
                    gpg.O000000o(fileInputStream3);
                    throw th;
                }
                try {
                    fileInputStream3.read(bArr);
                    fileInputStream3.close();
                    Signature instance3 = Signature.getInstance("SHA256withECDSA");
                    instance3.initVerify(x509Certificate2.getPublicKey());
                    byte[] bArr4 = new byte[(digest.length + digest2.length)];
                    System.arraycopy(digest, 0, bArr4, 0, digest.length);
                    System.arraycopy(digest2, 0, bArr4, digest.length, digest2.length);
                    instance3.update(bArr4);
                    boolean verify = instance3.verify(bArr);
                    gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "signature of rn bundle is " + verify + ">" + (System.currentTimeMillis() - currentTimeMillis) + " " + O00000Oo);
                    if (!verify) {
                        jSONObject = null;
                    }
                    gpg.O000000o(fileInputStream);
                    gpg.O000000o(fileInputStream2);
                    gpg.O000000o(fileInputStream3);
                    return jSONObject;
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream4 = fileInputStream;
                    gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", Log.getStackTraceString(e));
                    gpg.O000000o(fileInputStream4);
                    gpg.O000000o(fileInputStream2);
                    gpg.O000000o(fileInputStream3);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    gpg.O000000o(fileInputStream);
                    gpg.O000000o(fileInputStream2);
                    gpg.O000000o(fileInputStream3);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream4 = fileInputStream;
                fileInputStream3 = null;
                fileInputStream2 = null;
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", Log.getStackTraceString(e));
                gpg.O000000o(fileInputStream4);
                gpg.O000000o(fileInputStream2);
                gpg.O000000o(fileInputStream3);
                return null;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream3 = null;
                fileInputStream2 = null;
                gpg.O000000o(fileInputStream);
                gpg.O000000o(fileInputStream2);
                gpg.O000000o(fileInputStream3);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream4 = null;
            fileInputStream3 = null;
            fileInputStream2 = null;
            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", Log.getStackTraceString(e));
            gpg.O000000o(fileInputStream4);
            gpg.O000000o(fileInputStream2);
            gpg.O000000o(fileInputStream3);
            return null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream3 = null;
            fileInputStream2 = null;
            fileInputStream = null;
            gpg.O000000o(fileInputStream);
            gpg.O000000o(fileInputStream2);
            gpg.O000000o(fileInputStream3);
            throw th;
        }
    }

    private static X509Certificate O000000o() {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = CommonApplication.getAppContext().getAssets().open("MijiaRootCert.der");
            try {
                X509Certificate instance = X509Certificate.getInstance(inputStream);
                gpg.O000000o(inputStream);
                return instance;
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    gpg.O000000o(inputStream);
                    return null;
                } catch (Throwable th2) {
                    InputStream inputStream3 = inputStream;
                    th = th2;
                    inputStream2 = inputStream3;
                    gpg.O000000o(inputStream2);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
            e.printStackTrace();
            gpg.O000000o(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            gpg.O000000o(inputStream2);
            throw th;
        }
    }

    private static boolean O000000o(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String O000000o(android.content.pm.Signature[] signatureArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (signatureArr != null) {
                for (android.content.pm.Signature byteArray : signatureArr) {
                    instance.update(byteArray.toByteArray());
                }
            }
            return fku.O000000o(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean O000000o(PluginPackageInfo pluginPackageInfo) {
        String O0000O0o = pluginPackageInfo.O0000O0o();
        String O00000o = pluginPackageInfo.O00000o();
        if (!O000000o(O0000O0o, pluginPackageInfo.O0000OOo())) {
            fkw.O00000Oo(O00000o);
            LogType logType = LogType.PLUGIN;
            gsy.O00000o0(logType, "PluginManager", "PluginUtils", "#hPDSI# validateMinApiLevel fail:" + pluginPackageInfo.O0000o0o() + "CurrentApiLevel[111]");
            return false;
        } else if (!O00000Oo(pluginPackageInfo.O0000Oo(), O0000O0o)) {
            fkw.O00000Oo(O00000o);
            LogType logType2 = LogType.PLUGIN;
            StringBuilder sb = new StringBuilder("#hPDSI# validatePlatform fail:");
            sb.append(pluginPackageInfo.O0000o0o());
            sb.append("CurrentPlatform[");
            grr.O000000o();
            sb.append(grr.O0000o0O());
            sb.append("]");
            gsy.O00000o0(logType2, "PluginManager", "PluginUtils", sb.toString());
            return false;
        } else if (O000000o(O0000O0o, pluginPackageInfo.O0000OoO())) {
            return true;
        } else {
            fkw.O00000Oo(O00000o);
            LogType logType3 = LogType.PLUGIN;
            gsy.O00000o0(logType3, "PluginManager", "PluginUtils", "#hPDSI# validateModel fail:" + pluginPackageInfo.O0000o0o());
            return false;
        }
    }

    private static boolean O000000o(String str, int i) {
        if ("rn".equalsIgnoreCase(str)) {
            return true;
        }
        return i > 0 && i <= 111;
    }

    private static boolean O00000Oo(String str, String str2) {
        if ("rn".equalsIgnoreCase(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        grr.O000000o();
        if (str.equalsIgnoreCase(grr.O0000o0O())) {
            return true;
        }
        return false;
    }

    private static boolean O000000o(String str, List<String> list) {
        boolean z;
        if ("rn".equalsIgnoreCase(str)) {
            return true;
        }
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.isEmpty(it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public static final String O00000Oo(String str) {
        if (new File(str, "conf.json").exists()) {
            return new File(str, "android").getAbsolutePath();
        }
        return new File(str, "_android").getAbsolutePath();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0144  */
    public static PluginPackageInfo O000000o(Context context, long j, long j2, String str, String str2) {
        String str3;
        String str4;
        Bundle bundle;
        String str5 = str;
        String str6 = str2;
        PluginPackageInfo pluginPackageInfo = new PluginPackageInfo();
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            O00000o0("packagePath:" + str6 + ",packageType:" + str5);
            return null;
        }
        if (str5.equalsIgnoreCase("mpk")) {
            try {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str6, NotificationCompat.FLAG_HIGH_PRIORITY);
                if (packageArchiveInfo != null) {
                    pluginPackageInfo.O000000o(packageArchiveInfo.versionCode);
                    pluginPackageInfo.O00000Oo(packageArchiveInfo.packageName);
                    ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                    if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                        pluginPackageInfo.O000000o(Arrays.asList(bundle.getString("model", "").split("\\|")));
                        pluginPackageInfo.O00000Oo(bundle.getInt("minPluginSdkApiVersion", 0));
                        pluginPackageInfo.O00000o(O000000o(bundle));
                        pluginPackageInfo.O00000o(bundle.getString("MiHomePlatform", ""));
                        pluginPackageInfo.O000000o(bundle.getBoolean("MiHomeSupportWidget", false));
                        pluginPackageInfo.O00000Oo(bundle.getBoolean("MiHomeSupportAppAV", true));
                    }
                }
            } catch (Exception e) {
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", str6 + " readMetaDataFail " + Log.getStackTraceString(e));
                return null;
            }
        } else if (str5.equals("rn")) {
            try {
                str4 = O00000Oo(str2) + File.separator + "project.json";
                try {
                    str3 = fkw.O000000o(str4);
                } catch (Exception e2) {
                    e = e2;
                    str3 = null;
                    if (!(e instanceof JSONException)) {
                        str3 = Log.getStackTraceString(e);
                    } else if (TextUtils.isEmpty(str3)) {
                        str3 = str4;
                    }
                    gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "createPluginPackageInfo error :  ".concat(String.valueOf(str3)));
                    O00000o0(str3);
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    pluginPackageInfo.O00000o(hhc.O000000o((Object) jSONObject.optString("developer_id")));
                    pluginPackageInfo.O00000Oo(jSONObject.optString("package_path"));
                    fkk fkk = new fkk(new File(str6));
                    int optInt = fkk.f16518O000000o != null ? fkk.f16518O000000o.optInt("version", 0) : 0;
                    pluginPackageInfo.O000000o(fkk.O000000o());
                    pluginPackageInfo.O00000o("phone");
                    pluginPackageInfo.O00000Oo((int) hhc.O000000o((Object) jSONObject.optString("sdk_api_level")));
                    if (optInt <= 0) {
                        optInt = (int) hhc.O000000o((Object) jSONObject.optString("version_code"));
                    }
                    pluginPackageInfo.O000000o(optInt);
                    pluginPackageInfo.O000000o(false);
                    pluginPackageInfo.O00000Oo(true);
                } catch (Exception e3) {
                    e = e3;
                    if (!(e instanceof JSONException)) {
                    }
                    gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "createPluginPackageInfo error :  ".concat(String.valueOf(str3)));
                    O00000o0(str3);
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                str4 = null;
                str3 = null;
                if (!(e instanceof JSONException)) {
                }
                gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", "createPluginPackageInfo error :  ".concat(String.valueOf(str3)));
                O00000o0(str3);
                return null;
            }
        }
        pluginPackageInfo.O000000o(j);
        pluginPackageInfo.O00000Oo(j2);
        pluginPackageInfo.O000000o(str6);
        pluginPackageInfo.O00000o0(str5);
        pluginPackageInfo.O00000o0(!TextUtils.isEmpty(str2) ? new File(str6).lastModified() : 0);
        return pluginPackageInfo;
    }

    public static void O00000o0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("call_stack", str);
        hxi.O0000Ooo.O000000o("rn_plugin_framework", "rn_plugin_download_error", hashMap);
    }

    public static PluginPackageInfo O000000o(String str, String str2, List<String> list) {
        PluginPackageInfo pluginPackageInfo = new PluginPackageInfo();
        pluginPackageInfo.O000000o(1L);
        pluginPackageInfo.O00000Oo(1L);
        pluginPackageInfo.O00000o(1);
        pluginPackageInfo.O00000Oo(1);
        pluginPackageInfo.O00000o("android");
        pluginPackageInfo.O000000o(1);
        pluginPackageInfo.O00000o0("mpk");
        pluginPackageInfo.O000000o(str);
        pluginPackageInfo.O00000Oo(str2);
        pluginPackageInfo.O000000o(list);
        pluginPackageInfo.O000000o(false);
        pluginPackageInfo.O00000Oo(true);
        pluginPackageInfo.O00000o0(System.currentTimeMillis());
        return pluginPackageInfo;
    }

    private static long O000000o(Bundle bundle) {
        if (bundle == null) {
            return 0;
        }
        try {
            String string = bundle.getString("MiHomeDeveloperId", "");
            return Long.parseLong(string.substring(3, string.length()));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = O00000Oo(str) + File.separator + "main.bundle";
        File file = new File(str2);
        if (file.exists() && file.length() >= 20) {
            return true;
        }
        gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginUtils", str2 + " is not exits or file size is small 20");
        return false;
    }

    public static boolean O000000o(String str, String str2) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogType logType = LogType.PLUGIN;
            gsy.O00000o0(logType, "PluginManager", "PluginUtils", "checkRnInstallPackageModelListFile downloadPackagePath=" + str + "; installPackagePath=" + str2);
            return false;
        }
        File file = new File(str, "model_list.json");
        File file2 = new File(str2, "model_list.json");
        if (file.exists() && file2.exists()) {
            String O000000o2 = grv.O000000o(file);
            String O000000o3 = grv.O000000o(file2);
            if (!TextUtils.isEmpty(O000000o2) && TextUtils.equals(O000000o2, O000000o3)) {
                z = true;
            }
            LogType logType2 = LogType.PLUGIN;
            gsy.O00000o0(logType2, "PluginManager", "PluginUtils", "checkRnInstallPackageModelListFile downloadMD5: " + O000000o2 + "  installMD5" + O000000o3);
        }
        return z;
    }

    public static String O000000o(PluginPackageInfo pluginPackageInfo, String str, String str2) {
        String str3 = "";
        if (pluginPackageInfo == null) {
            return str3;
        }
        PluginPackageInfo pluginPackageInfo2 = null;
        if (!TextUtils.isEmpty(str)) {
            pluginPackageInfo2 = fcx.f16092O000000o.O00000Oo(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pluginId=" + pluginPackageInfo.O000000o() + "\n");
        sb.append("packageId=" + pluginPackageInfo.O00000Oo() + "\n");
        StringBuilder sb2 = new StringBuilder("newCachePackageId=");
        sb2.append(pluginPackageInfo2 == null ? str3 : Long.valueOf(pluginPackageInfo2.O00000Oo()));
        sb2.append("\n");
        sb.append(sb2.toString());
        sb.append("mPluginBundlePath=" + str2 + "\n");
        String O00000o = pluginPackageInfo.O00000o();
        if (TextUtils.isEmpty(O00000o)) {
            return sb.toString();
        }
        File file = new File(O00000o);
        if (file.exists()) {
            String O00000Oo = O00000Oo(O00000o);
            File file2 = new File(O00000Oo);
            int i = 0;
            if (!file2.exists()) {
                sb.append(O00000Oo + " is not exists  \n");
                if (file.isDirectory()) {
                    String[] list = file.list();
                    int length = list.length;
                    while (i < length) {
                        str3 = str3 + list[i] + "; ";
                        i++;
                    }
                    sb.append("file fileNames: " + str3 + "\n");
                } else {
                    sb.append(O00000o + " is a file not directory  \n");
                }
            } else if (file2.isDirectory()) {
                String[] list2 = file2.list();
                int length2 = list2.length;
                while (i < length2) {
                    str3 = str3 + list2[i] + "; ";
                    i++;
                }
                sb.append("realPackageFile fileNames: " + str3 + "\n");
            } else {
                sb.append(O00000Oo + " is a file not directory  \n");
            }
        } else {
            sb.append(O00000o + " is not exists  \n");
        }
        return sb.toString();
    }
}

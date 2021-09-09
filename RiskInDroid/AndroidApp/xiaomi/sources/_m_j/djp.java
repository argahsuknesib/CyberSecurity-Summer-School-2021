package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.tencent.open.utils.HttpUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

public final class djp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14725O000000o = "";
    private static String O00000Oo = "";
    private static String O00000o = "";
    private static String O00000o0 = "";
    private static int O00000oO = -1;
    private static String O00000oo = "0123456789ABCDEF";

    public static Bundle O000000o(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
    private static JSONObject O000000o(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    split2[0] = URLDecoder.decode(split2[0]);
                    split2[1] = URLDecoder.decode(split2[1]);
                    try {
                        jSONObject.put(split2[0], split2[1]);
                    } catch (JSONException e) {
                        diz.O00000oO("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Bundle O00000Oo(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle O000000o2 = O000000o(url.getQuery());
            O000000o2.putAll(O000000o(url.getRef()));
            return O000000o2;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject O00000o0(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject O000000o2 = O000000o((JSONObject) null, url.getQuery());
            O000000o(O000000o2, url.getRef());
            return O000000o2;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f14727O000000o;
        public long O00000Oo;
        public long O00000o0;

        public O000000o(String str, int i) {
            this.f14727O000000o = str;
            this.O00000Oo = (long) i;
            String str2 = this.f14727O000000o;
            if (str2 != null) {
                this.O00000o0 = (long) str2.length();
            }
        }
    }

    public static JSONObject O00000o(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    private static boolean O00000o0(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (djn.O000000o(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(signatureArr[0].toByteArray());
                    String O000000o2 = O000000o(instance.digest());
                    instance.reset();
                    if (O000000o2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e) {
                    diz.O00000oO("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e.getMessage());
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:13|14|15|16|17|18|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[SYNTHETIC, Splitter:B:13:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002d A[SYNTHETIC, Splitter:B:21:0x002d] */
    public static boolean O000000o(Context context, String str) {
        boolean z;
        try {
            z = O00000o0(context);
            if (z) {
                try {
                    O000000o(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                    return true;
                } catch (Exception unused) {
                    if (!z) {
                        O000000o(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                        O000000o(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        O000000o(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    }
                    O000000o(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    try {
                        O000000o(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    } catch (Exception unused2) {
                        return false;
                    }
                }
            } else {
                O000000o(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                return true;
            }
        } catch (Exception unused3) {
            z = false;
            if (!z) {
            }
        }
    }

    private static void O000000o(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static void O000000o(final Context context, String str, long j, String str2) {
        final Bundle bundle = new Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", "3.5.2.lite");
        if (j != 0) {
            bundle.putLong("elt", j);
        }
        new Thread() {
            /* class _m_j.djp.AnonymousClass1 */

            public final void run() {
                try {
                    HttpUtils.O000000o(context, "https://cgi.qplus.com/report/report", "GET", bundle);
                } catch (Exception e) {
                    diz.O00000oO("openSDK_LOG.Util", "reportBernoulli has exception: " + e.getMessage());
                }
            }
        }.start();
    }

    public static String O000000o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & 255, 16);
            if (num.length() == 1) {
                num = "0".concat(String.valueOf(num));
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static boolean O000000o(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo isConnectedOrConnecting : allNetworkInfo) {
                if (isConnectedOrConnecting.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Bundle O000000o(String str, String str2, String str3, String str4, String str5, String str6) {
        return O000000o(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        bundle.putString("platform", "1");
        return bundle;
    }

    public static Bundle O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", Build.VERSION.RELEASE);
        bundle.putString("network", diu.O000000o(djk.O000000o()));
        bundle.putString("apn", diu.O000000o());
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", "3.5.2.lite");
        bundle.putString("packagename", djk.O00000Oo());
        bundle.putString("app_ver", O00000o0(djk.O000000o(), djk.O00000Oo()));
        return bundle;
    }

    private static void O00000oO(Context context, String str) {
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                String str2 = packageInfo.versionName;
                O00000Oo = str2;
                f14725O000000o = str2.substring(0, O00000Oo.lastIndexOf(46));
                String str3 = O00000Oo;
                O00000o = str3.substring(str3.lastIndexOf(46) + 1, O00000Oo.length());
                O00000oO = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                diz.O00000oO("openSDK_LOG.Util", "getPackageInfo has exception: " + e.getMessage());
            } catch (Exception e2) {
                diz.O00000oO("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
            }
        }
    }

    public static String O00000Oo(Context context, String str) {
        if (context == null) {
            return "";
        }
        O00000oO(context, str);
        return O00000Oo;
    }

    public static String O00000o0(Context context, String str) {
        if (context == null) {
            return "";
        }
        O00000oO(context, str);
        return f14725O000000o;
    }

    public static String O00000o(Context context, String str) {
        if (context == null) {
            return "";
        }
        String O00000o02 = O00000o0(context, str);
        O00000o0 = O00000o02;
        return O00000o02;
    }

    public static byte[] O00000oO(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static boolean O00000Oo(Context context) {
        double d;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d = Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d));
        } catch (Throwable unused) {
            d = 0.0d;
        }
        return d > 6.5d;
    }

    public static String O00000oo(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(O000000o(str.getBytes(), "JCPTZXEZ"), 3);
    }

    private static byte[] O000000o(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                char[] charArray = str.toCharArray();
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr2[i] = (byte) (bArr[i] ^ charArray[i % charArray.length]);
                }
                return bArr2;
            } catch (Throwable th) {
                diz.O00000Oo("Util", "xor Exception! ", th);
            }
        }
        return bArr;
    }

    public static Drawable O000000o(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb;
        Drawable drawable = null;
        if (context == null) {
            diz.O00000oO("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                drawable = Drawable.createFromStream(inputStream, str);
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder("inputStream close exception: ");
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    diz.O00000oO("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder("inputStream close exception: ");
                    }
                    return drawable;
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                        diz.O00000oO("openSDK_LOG.Util", "inputStream close exception: " + e4.getMessage());
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
            diz.O00000oO("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
            inputStream.close();
            return drawable;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            inputStream.close();
            throw th;
        }
        return drawable;
        sb.append(e.getMessage());
        diz.O00000oO("openSDK_LOG.Util", sb.toString());
        return drawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    public static String O000000o() {
        File file;
        Context O000000o2 = djk.O000000o();
        if (O000000o2 != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                File[] externalFilesDirs = O000000o2.getExternalFilesDirs(null);
                if (externalFilesDirs != null && externalFilesDirs.length > 0) {
                    file = externalFilesDirs[0];
                }
            } else {
                file = O000000o2.getExternalFilesDir(null);
            }
            if (file != null) {
                return null;
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.toString();
        }
        file = null;
        if (file != null) {
        }
    }
}

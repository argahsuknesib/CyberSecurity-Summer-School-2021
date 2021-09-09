package com.alipay.sdk.app.statistic;

import _m_j.jdn;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

public class b {
    private String aA;
    private String aB;
    private String aC;
    private String aD;
    private String aE;
    private String aF;
    private String aG = "";
    private String aH = "";
    private String aI;
    private String az;

    public b(Context context, boolean z) {
        long j;
        context = context != null ? context.getApplicationContext() : context;
        this.az = c();
        this.aB = a(context);
        if (z) {
            j = 0;
        } else {
            j = a.c.a(context);
        }
        this.aC = a(j);
        this.aD = e();
        this.aE = b(context);
        this.aF = "-";
        this.aI = "-";
    }

    private boolean a() {
        return TextUtils.isEmpty(this.aH);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, Throwable th) {
        c(str, str2, a(th));
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, Throwable th, String str3) {
        String a2 = a(th);
        c(str, str2, str3 + ": " + a2);
    }

    private synchronized void c(String str, String str2, String str3) {
        c.d("mspl", String.format("err %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.aH)) {
            str4 = str4 + "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = TextUtils.isEmpty(str3) ? "-" : b(str3);
        objArr[3] = b(b());
        sb.append(String.format("%s,%s,%s,%s", objArr));
        this.aH += sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, String str3) {
        c(str, str2, str3);
    }

    /* access modifiers changed from: package-private */
    public void b(String str, String str2, String str3) {
        d("", str, str2 + "|" + str3);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        d("", str, str2);
    }

    private synchronized void d(String str, String str2, String str3) {
        c.b("mspl", String.format("event %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.aG)) {
            str4 = str4 + "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(str) ? "-" : b(str);
        objArr[1] = b(str2);
        objArr[2] = b(str3);
        objArr[3] = b(b());
        sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
        this.aG += sb.toString();
    }

    private static String b() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", "~").replace("#", "＃");
    }

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int i = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i++;
                    if (i > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public String a(String str) {
        this.aA = d(str);
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.az, this.aA, this.aB, this.aC, this.aD, this.aE, this.aF, c(this.aG), c(this.aH), this.aI);
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String c() {
        return String.format("%s,%s", d(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    private static String d() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    private static String d(String str) {
        String str2;
        String str3;
        if (str == null) {
            str = "";
        }
        String[] split = str.split("&");
        String str4 = null;
        if (split != null) {
            str3 = null;
            str2 = null;
            String str5 = null;
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    if (split3[0].equalsIgnoreCase("partner")) {
                        str3 = split3[1].replace(jdn.f1779O000000o, "");
                    } else if (split3[0].equalsIgnoreCase("out_trade_no")) {
                        str2 = split3[1].replace(jdn.f1779O000000o, "");
                    } else if (split3[0].equalsIgnoreCase("trade_no")) {
                        str5 = split3[1].replace(jdn.f1779O000000o, "");
                    } else if (split3[0].equalsIgnoreCase("biz_content")) {
                        try {
                            JSONObject jSONObject = new JSONObject(l.b(com.alipay.sdk.sys.a.a(), split3[1]));
                            if (TextUtils.isEmpty(str2)) {
                                str2 = jSONObject.getString("out_trade_no");
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (split3[0].equalsIgnoreCase("app_id")) {
                        if (TextUtils.isEmpty(str3)) {
                            str3 = split3[1];
                        }
                    }
                }
            }
            str4 = str5;
        } else {
            str3 = null;
            str2 = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", b(str4), b(str2), b(str3));
    }

    private static String a(Context context) {
        String str;
        String str2 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(str, 64);
                    str2 = packageInfo.versionName + "|" + a(packageInfo);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            return String.format("%s,%s,-,-,-", b(str), b(str2));
        }
        str = str2;
        return String.format("%s,%s,-,-,-", b(str), b(str2));
    }

    private static String a(PackageInfo packageInfo) {
        String str;
        if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.signatures.length);
            Signature[] signatureArr = packageInfo.signatures;
            int length = signatureArr.length;
            int i = 0;
            while (i < length) {
                try {
                    String a2 = l.a((com.alipay.sdk.sys.a) null, signatureArr[i].toByteArray());
                    if (TextUtils.isEmpty(a2)) {
                        str = "?";
                        sb.append("-");
                        sb.append(str);
                        i++;
                    } else {
                        str = l.f(a2).substring(0, 8);
                        sb.append("-");
                        sb.append(str);
                        i++;
                    }
                } catch (Throwable unused) {
                }
            }
            return sb.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    private static String a(long j) {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", b("15.8.00"), b("h.a.3.8.00"), "~".concat(String.valueOf(j)));
    }

    private static String e() {
        return String.format("%s,%s,-,-,-", b(com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.a().b()).a()), b(com.alipay.sdk.sys.b.a().e()));
    }

    private static String b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", b(com.alipay.sdk.util.a.d(context)), "android", b(Build.VERSION.RELEASE), b(Build.MODEL), "-", b(com.alipay.sdk.util.a.a(context).a()), b(com.alipay.sdk.util.a.b(context).b()), "gw", b(com.alipay.sdk.util.a.a(context).b()));
    }
}

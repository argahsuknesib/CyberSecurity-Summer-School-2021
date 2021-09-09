package com.alipay.sdk.app;

import _m_j.jdn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.f;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.l;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class PayTask {

    /* renamed from: a  reason: collision with root package name */
    static final Object f3176a = f.class;
    private static long i = 0;
    private static long k = -1;
    /* access modifiers changed from: private */
    public Activity b;
    private com.alipay.sdk.widget.a c;
    private final String d = "wappaygw.alipay.com/service/rest.htm";
    private final String e = "mclient.alipay.com/service/rest.htm";
    private final String f = "mclient.alipay.com/home/exterfaceAssign.htm";
    private final String g = "mclient.alipay.com/cashier/mobilepay.htm";
    private Map<String, a> h = new HashMap();

    public String getVersion() {
        return "15.8.00";
    }

    public PayTask(Activity activity) {
        this.b = activity;
        b.a().a(this.b);
        this.c = new com.alipay.sdk.widget.a(activity, "去支付宝付款");
    }

    public synchronized String pay(String str, boolean z) {
        return a(new com.alipay.sdk.sys.a(this.b, str, "pay"), str, z);
    }

    private synchronized String a(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        String c2;
        Context applicationContext;
        String str2;
        if (b()) {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "RepPay", "");
            return b.d();
        }
        if (z) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            a.a(substring.replaceAll(jdn.f1779O000000o, "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            a.a("");
        }
        if (str.contains("service=alipay.acquire.mr.ord.createandpay")) {
            com.alipay.sdk.cons.a.u = true;
        }
        if (com.alipay.sdk.cons.a.u) {
            if (str.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
                str = str.substring(str.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
            } else if (str.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?")) {
                str = str.substring(str.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
            }
        }
        try {
            c.b("mspl", "pay prepared: ".concat(String.valueOf(str)));
            c2 = a(str, aVar);
            c.b("mspl", "pay raw result: ".concat(String.valueOf(c2)));
            g.a(aVar, this.b.getApplicationContext(), c2);
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturn", sb.toString());
            com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturnV", j.a(c2, "resultStatus") + "|" + j.a(c2, "memo"));
            if (!com.alipay.sdk.data.a.s().n()) {
                com.alipay.sdk.data.a.s().a(aVar, this.b.getApplicationContext());
            }
            dismissLoading();
            applicationContext = this.b.getApplicationContext();
            str2 = aVar.q;
        } catch (Throwable th) {
            try {
                c2 = b.c();
                c.a(th);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturn", sb2.toString());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturnV", j.a(c2, "resultStatus") + "|" + j.a(c2, "memo"));
                if (!com.alipay.sdk.data.a.s().n()) {
                    com.alipay.sdk.data.a.s().a(aVar, this.b.getApplicationContext());
                }
                dismissLoading();
                applicationContext = this.b.getApplicationContext();
                str2 = aVar.q;
            } catch (Throwable th2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturn", sb3.toString());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturnV", j.a(c2, "resultStatus") + "|" + j.a(c2, "memo"));
                if (!com.alipay.sdk.data.a.s().n()) {
                    com.alipay.sdk.data.a.s().a(aVar, this.b.getApplicationContext());
                }
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(this.b.getApplicationContext(), aVar, str, aVar.q);
                throw th2;
            }
        }
        com.alipay.sdk.app.statistic.a.b(applicationContext, aVar, str, str2);
        c.b("mspl", "pay returning: ".concat(String.valueOf(c2)));
        return c2;
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        com.alipay.sdk.sys.a aVar;
        aVar = new com.alipay.sdk.sys.a(this.b, str, "payV2");
        return j.a(aVar, a(aVar, str, z));
    }

    public synchronized String fetchTradeToken() {
        return g.a(new com.alipay.sdk.sys.a(this.b, "", "fetchTradeToken"), this.b.getApplicationContext());
    }

    public synchronized boolean payInterceptorWithUrl(String str, final boolean z, final H5PayCallback h5PayCallback) {
        final String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            c.b("mspl", "intercepted: ".concat(String.valueOf(fetchOrderInfoFromH5PayUrl)));
            new Thread(new Runnable() {
                /* class com.alipay.sdk.app.PayTask.AnonymousClass1 */

                public void run() {
                    H5PayResultModel h5Pay = PayTask.this.h5Pay(new com.alipay.sdk.sys.a(PayTask.this.b, fetchOrderInfoFromH5PayUrl, "payInterceptorWithUrl"), fetchOrderInfoFromH5PayUrl, z);
                    c.b("mspl", "inc finished: " + h5Pay.getResultCode());
                    h5PayCallback.onPayResult(h5Pay);
                }
            }).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        String str2 = str;
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    String trim = str.trim();
                    if (trim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || trim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                        String trim2 = trim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                        if (!TextUtils.isEmpty(trim2)) {
                            String a2 = l.a("<request_token>", "</request_token>", l.b(trim2).get("req_data"));
                            com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.b, "", "");
                            String str3 = "_input_charset=\"utf-8\"&ordertoken=\"" + a2 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar.a("sc", "h5tonative") + jdn.f1779O000000o;
                            return str3;
                        }
                    }
                    if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                        String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                        if (!TextUtils.isEmpty(trim3)) {
                            String a3 = l.a("<request_token>", "</request_token>", l.b(trim3).get("req_data"));
                            com.alipay.sdk.sys.a aVar2 = new com.alipay.sdk.sys.a(this.b, "", "");
                            String str4 = "_input_charset=\"utf-8\"&ordertoken=\"" + a3 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar2.a("sc", "h5tonative") + jdn.f1779O000000o;
                            return str4;
                        }
                    }
                    if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                        com.alipay.sdk.sys.a aVar3 = new com.alipay.sdk.sys.a(this.b, "", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str2);
                        jSONObject.put("bizcontext", aVar3.a("sc", "h5tonative"));
                        String str5 = "new_external_info==" + jSONObject.toString();
                        return str5;
                    }
                    if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str2).find()) {
                        String a4 = l.a("?", "", str2);
                        if (!TextUtils.isEmpty(a4)) {
                            Map<String, String> b2 = l.b(a4);
                            StringBuilder sb = new StringBuilder();
                            if (a(false, true, "trade_no", sb, b2, "trade_no", "alipay_trade_no")) {
                                a(true, false, "pay_phase_id", sb, b2, "payPhaseId", "pay_phase_id", "out_relation_id");
                                sb.append("&biz_sub_type=\"TRADE\"");
                                sb.append("&biz_type=\"trade\"");
                                String str6 = b2.get("app_name");
                                if (TextUtils.isEmpty(str6) && !TextUtils.isEmpty(b2.get("cid"))) {
                                    str6 = "ali1688";
                                } else if (TextUtils.isEmpty(str6) && (!TextUtils.isEmpty(b2.get("sid")) || !TextUtils.isEmpty(b2.get("s_id")))) {
                                    str6 = "tb";
                                }
                                sb.append("&app_name=\"" + str6 + jdn.f1779O000000o);
                                if (!a(true, true, "extern_token", sb, b2, "extern_token", "cid", "sid", "s_id")) {
                                    return "";
                                }
                                a(true, false, "appenv", sb, b2, "appenv");
                                sb.append("&pay_channel_id=\"alipay_sdk\"");
                                a aVar4 = new a();
                                aVar4.a(b2.get("return_url"));
                                aVar4.c(b2.get("show_url"));
                                aVar4.b(b2.get("pay_order_id"));
                                com.alipay.sdk.sys.a aVar5 = new com.alipay.sdk.sys.a(this.b, "", "");
                                String str7 = sb.toString() + "&bizcontext=\"" + aVar5.a("sc", "h5tonative") + jdn.f1779O000000o;
                                this.h.put(str7, aVar4);
                                return str7;
                            }
                        }
                    }
                    if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm")) {
                        if (!EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm")) {
                            if (com.alipay.sdk.data.a.s().d() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                                Uri parse = Uri.parse(trim);
                                String queryParameter = parse.getQueryParameter("return_url");
                                String queryParameter2 = parse.getQueryParameter("show_url");
                                String queryParameter3 = parse.getQueryParameter("pay_order_id");
                                String a5 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                                String a6 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                                String[] strArr = new String[4];
                                strArr[0] = parse.getQueryParameter("app_name");
                                strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                                strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? "tb" : "";
                                strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? "tb" : "";
                                String a7 = a(strArr);
                                String a8 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                                String a9 = a(parse.getQueryParameter("appenv"));
                                if (!TextUtils.isEmpty(a5) && !TextUtils.isEmpty(a7) && !TextUtils.isEmpty(a8)) {
                                    String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a5, a6, a7, a8, a9, new com.alipay.sdk.sys.a(this.b, "", "").a("sc", "h5tonative"));
                                    a aVar6 = new a();
                                    aVar6.a(queryParameter);
                                    aVar6.c(queryParameter2);
                                    aVar6.b(queryParameter3);
                                    aVar6.d(a5);
                                    this.h.put(format, aVar6);
                                    return format;
                                }
                            }
                        }
                    }
                    String a10 = new com.alipay.sdk.sys.a(this.b, "", "").a("sc", "h5tonative");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", trim);
                    jSONObject2.put("bizcontext", a10);
                    String format2 = String.format("new_external_info==%s", jSONObject2.toString());
                    return format2;
                }
            } catch (Throwable th) {
                throw th;
            }
            return "";
        }
    }

    private static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                b.a().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - i < ((long) com.alipay.sdk.data.a.s().f())) {
                    return false;
                }
                i = elapsedRealtime;
                com.alipay.sdk.data.a.s().a(com.alipay.sdk.sys.a.a(), context.getApplicationContext());
                return true;
            } catch (Exception e2) {
                c.a(e2);
                return false;
            }
        }
    }

    class a {
        private String b;
        private String c;
        private String d;
        private String e;

        private a() {
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
        }

        public String a() {
            return this.b;
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
            return this.d;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String d() {
            return this.e;
        }

        public void d(String str) {
            this.e = str;
        }
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            if (z2) {
                return false;
            }
            return true;
        } else if (z) {
            sb.append("&");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append(jdn.f1779O000000o);
            return true;
        } else {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append(jdn.f1779O000000o);
            return true;
        }
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] split = a(aVar, str, z).split(";");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                int indexOf = str2.indexOf("={");
                if (indexOf >= 0) {
                    String substring = str2.substring(0, indexOf);
                    hashMap.put(substring, a(str2, substring));
                }
            }
            if (hashMap.containsKey("resultStatus")) {
                h5PayResultModel.setResultCode((String) hashMap.get("resultStatus"));
            }
            h5PayResultModel.setReturnUrl(a(str, hashMap));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "H5CbUrlEmpty", "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "H5CbEx", th);
            c.a(th);
        }
        return h5PayResultModel;
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        String str2;
        String str3;
        boolean equals = "9000".equals(map.get("resultStatus"));
        String str4 = map.get("result");
        a remove = this.h.remove(str);
        String[] strArr = new String[2];
        if (remove != null) {
            str2 = remove.b();
        } else {
            str2 = "";
        }
        strArr[0] = str2;
        if (remove != null) {
            str3 = remove.d();
        } else {
            str3 = "";
        }
        strArr[1] = str3;
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str4.length() > 15) {
            String a2 = a(l.a("&callBackUrl=\"", (String) jdn.f1779O000000o, str4), l.a("&call_back_url=\"", (String) jdn.f1779O000000o, str4), l.a("&return_url=\"", (String) jdn.f1779O000000o, str4), URLDecoder.decode(l.a("&return_url=", "&", str4), "utf-8"), URLDecoder.decode(l.a("&callBackUrl=", "&", str4), "utf-8"), l.a("call_back_url=\"", (String) jdn.f1779O000000o, str4));
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (remove != null) {
            String a3 = equals ? remove.a() : remove.c();
            if (!TextUtils.isEmpty(a3)) {
                return a3;
            }
        }
        if (remove != null) {
            return com.alipay.sdk.data.a.s().e();
        }
        return "";
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    private f.c a() {
        return new f.c() {
            /* class com.alipay.sdk.app.PayTask.AnonymousClass2 */

            public void a() {
            }

            public void b() {
                PayTask.this.dismissLoading();
            }
        };
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar = this.c;
        if (aVar != null) {
            aVar.c();
            this.c = null;
        }
    }

    private String a(String str, com.alipay.sdk.sys.a aVar) {
        String a2 = aVar.a(str);
        if (a2.contains("paymethod=\"expressGateway\"")) {
            return a(aVar, a2);
        }
        List<a.C0017a> r = com.alipay.sdk.data.a.s().r();
        if (!com.alipay.sdk.data.a.s().f3186a || r == null) {
            r = a.f3180a;
        }
        if (l.b(aVar, this.b, r)) {
            f fVar = new f(this.b, aVar, a());
            c.b("mspl", "pay inner started: ".concat(String.valueOf(a2)));
            String a3 = fVar.a(a2);
            c.b("mspl", "pay inner raw result: ".concat(String.valueOf(a3)));
            fVar.a();
            if (TextUtils.equals(a3, "failed") || TextUtils.equals(a3, "scheme_failed")) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "LogBindCalledH5");
                return a(aVar, a2);
            } else if (TextUtils.isEmpty(a3)) {
                return b.c();
            } else {
                if (!a3.contains("{\"isLogin\":\"false\"}")) {
                    return a3;
                }
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "LogHkLoginByIntent");
                return a(aVar, a2, r, a3, this.b);
            }
        } else {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "LogCalledH5");
            return a(aVar, a2);
        }
    }

    private static String a(com.alipay.sdk.sys.a aVar, String str, List<a.C0017a> list, String str2, Activity activity) {
        l.a a2 = l.a(aVar, activity, list);
        if (a2 == null || a2.a(aVar) || a2.a() || !TextUtils.equals(a2.f3211a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        c.a("mspl", "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        PayResultActivity.b.put(valueOf, new Object());
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra("orderSuffix", str);
        intent.putExtra("externalPkgName", activity.getPackageName());
        intent.putExtra("phonecashier.pay.hash", valueOf);
        a.C0019a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (PayResultActivity.b.get(valueOf)) {
            try {
                c.a("mspl", "PayTask wait");
                PayResultActivity.b.get(valueOf).wait();
            } catch (InterruptedException unused) {
                c.a("mspl", "PayTask interrupted");
                return b.c();
            }
        }
        String str3 = PayResultActivity.a.b;
        c.a("mspl", "PayTask ret: ".concat(String.valueOf(str3)));
        return str3;
    }

    private String a(com.alipay.sdk.sys.a aVar, String str) {
        String a2;
        showLoading();
        c cVar = null;
        try {
            JSONObject c2 = new com.alipay.sdk.packet.impl.f().a(aVar, this.b.getApplicationContext(), str).c();
            String optString = c2.optString("end_code", null);
            List<com.alipay.sdk.protocol.b> a3 = com.alipay.sdk.protocol.b.a(c2.optJSONObject("form").optJSONObject("onload"));
            int i2 = 0;
            for (int i3 = 0; i3 < a3.size(); i3++) {
                if (a3.get(i3).b() == com.alipay.sdk.protocol.a.Update) {
                    com.alipay.sdk.protocol.b.a(a3.get(i3));
                }
            }
            a(aVar, c2);
            dismissLoading();
            com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.q);
            while (i2 < a3.size()) {
                com.alipay.sdk.protocol.b bVar = a3.get(i2);
                if (bVar.b() == com.alipay.sdk.protocol.a.WapPay) {
                    a2 = a(aVar, bVar);
                } else if (bVar.b() == com.alipay.sdk.protocol.a.OpenWeb) {
                    a2 = a(aVar, bVar, optString);
                } else {
                    i2++;
                }
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.q);
                return a2;
            }
        } catch (IOException e2) {
            c b2 = c.b(c.NETWORK_ERROR.a());
            com.alipay.sdk.app.statistic.a.a(aVar, "net", e2);
            dismissLoading();
            com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.q);
            cVar = b2;
        } catch (Throwable th) {
            dismissLoading();
            com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.q);
            throw th;
        }
        dismissLoading();
        com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.q);
        if (cVar == null) {
            cVar = c.b(c.FAILED.a());
        }
        return b.a(cVar.a(), cVar.b(), "");
    }

    private void a(com.alipay.sdk.sys.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString("client_key");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                com.alipay.sdk.tid.a.a(b.a().b()).a(optString, optString2);
            }
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "ParserTidClientKeyEx", th);
        }
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar, String str) {
        boolean b2;
        String a2;
        String str2;
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.b, H5PayActivity.class);
        try {
            JSONObject c3 = l.c(new String(com.alipay.sdk.encrypt.a.a(c2[2])));
            intent.putExtra("url", c2[0]);
            intent.putExtra("title", c2[1]);
            intent.putExtra("version", "v2");
            intent.putExtra("method", c3.optString("method", "POST"));
            b.a(false);
            b.a((String) null);
            a.C0019a.a(aVar, intent);
            this.b.startActivity(intent);
            synchronized (f3176a) {
                try {
                    f3176a.wait();
                    b2 = b.b();
                    a2 = b.a();
                    b.a(false);
                    b.a((String) null);
                } catch (InterruptedException e2) {
                    c.a(e2);
                    return b.c();
                }
            }
            if (b2) {
                try {
                    List<com.alipay.sdk.protocol.b> a3 = com.alipay.sdk.protocol.b.a(l.c(new String(com.alipay.sdk.encrypt.a.a(a2))));
                    int i2 = 0;
                    while (true) {
                        if (i2 >= a3.size()) {
                            break;
                        }
                        com.alipay.sdk.protocol.b bVar2 = a3.get(i2);
                        if (bVar2.b() == com.alipay.sdk.protocol.a.SetResult) {
                            String[] c4 = bVar2.c();
                            str2 = b.a(Integer.valueOf(c4[1]).intValue(), c4[0], l.b(aVar, c4[2]));
                            break;
                        }
                        i2++;
                    }
                } catch (Throwable th) {
                    c.a(th);
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", "H5PayDataAnalysisError", th, a2);
                }
            }
            str2 = "";
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            try {
                return b.a(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th2) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "H5PayDataAnalysisError", th2, "endCode: ".concat(String.valueOf(str)));
                return b.a(8000, "", "");
            }
        } catch (Throwable th3) {
            c.a(th3);
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "H5PayDataAnalysisError", th3, Arrays.toString(c2));
            return b.c();
        }
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.b, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString("cookie", c2[1]);
        }
        intent.putExtras(bundle);
        a.C0019a.a(aVar, intent);
        this.b.startActivity(intent);
        synchronized (f3176a) {
            try {
                f3176a.wait();
            } catch (InterruptedException e2) {
                c.a(e2);
                return b.c();
            }
        }
        String a2 = b.a();
        if (TextUtils.isEmpty(a2)) {
            return b.c();
        }
        return a2;
    }

    private static boolean b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - k < 3000) {
            return true;
        }
        k = elapsedRealtime;
        return false;
    }
}

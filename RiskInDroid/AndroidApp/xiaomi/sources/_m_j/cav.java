package _m_j;

import _m_j.caw;
import _m_j.cbm;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.model.SyncModel;
import com.mi.global.shop.newmodel.domain.DomainModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public final class cav {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13571O000000o = "http://mobile.mi.com/";
    public static String O00000Oo = "http://mobile.test.mi.com/";
    public static String O00000o = "http://go-buy.test.mi.com/";
    public static String O00000o0 = (cad.O00000o() ? "https://in-go.buy.mi.com/" : cad.O0000OoO() ? "https://ru-go.buy.mi.com/" : "https://go.buy.mi.com/");
    public static String O00000oO = "http://in-fs.buy.mi.com/";
    public static String O00000oo = "http://fs-haiwai.test.mi.com/";
    public static String O0000O0o = "https://in-d2s.buy.mi.com/";
    public static String O0000OOo = "https://in-tp.mi.com/";
    public static String O0000Oo = "";
    public static String O0000Oo0 = "";
    public static String O0000OoO = "";
    public static String O0000Ooo = "";
    public static String O0000o = "";
    public static String O0000o0 = "";
    public static String O0000o00 = "";
    public static String O0000o0O = "";
    public static String O0000o0o = "";
    public static String O0000oO = "mi.com";
    public static String O0000oO0 = "http://sg.appeye.appmifile.com";
    public static String O0000oOO = (O0000oO + "/" + cad.f13513O000000o);
    public static String O0000oOo;
    public static String O0000oo = "http://push.buy.mi.com/";
    public static String O0000oo0 = cad.f13513O000000o;
    public static String O0000ooO = "http://push.buy.test.mi.com/";
    public static String O0000ooo = "http://xiaomi.api.cashify.in/";
    public static String O000O00o = ("https://www.miui.com/res/doc/eula/" + cad.f13513O000000o + ".html");
    public static String O000O0OO = ("https://mobile.mi.com/" + cad.f13513O000000o + "/app/service/terms/");
    public static String O000O0Oo;
    private static Random O000O0o;
    public static String O000O0o0 = (byl.O0000OOo() ? "staging.m.id.mipay.com" : "m.id.mipay.com");
    public static String O00oOoOo = ("https://go-buy.test.mi.com/" + cad.f13513O000000o + "/httpdns");
    public static String O00oOooO = (f13571O000000o + "in/service/smartboxdelivery/");
    public static String O00oOooo = "in/mifinance/upload";

    static {
        String str;
        StringBuilder sb = new StringBuilder("/");
        sb.append(cad.f13513O000000o);
        O0000oOo = sb.toString();
        if (cad.O00000o()) {
            str = "https://in-go.buy.mi.com/" + cad.f13513O000000o + "/httpdns";
        } else {
            StringBuilder sb2 = cad.O0000OoO() ? new StringBuilder("https://ru-go.buy.mi.com/") : new StringBuilder("https://go.buy.mi.com/");
            sb2.append(cad.f13513O000000o);
            sb2.append("/httpdns");
            str = sb2.toString();
        }
        O000O0Oo = str;
        O00000o0();
        O000000o();
    }

    public static void O000000o() {
        if (byl.O00000o0) {
            O0000Oo0 = cbl.O00000Oo(O0000Oo0);
            O0000Oo = cbl.O00000Oo(O0000Oo);
            O00000o = cbl.O00000Oo(O00000o);
            O00000o0 = cbl.O00000Oo(O00000o0);
            O0000o0 = cbl.O00000Oo(O0000o0);
            O0000oo = cbl.O00000Oo(O0000oo);
            O0000ooO = cbl.O00000Oo(O0000ooO);
            O0000o00 = cbl.O00000Oo(O0000o00);
            O0000OoO = cbl.O00000Oo(O0000OoO);
            f13571O000000o = cbl.O00000o(f13571O000000o);
            O00000Oo = cbl.O00000o(O00000Oo);
            O00000oo = cbl.O00000Oo(O00000oo);
            O00000oO = cbl.O00000Oo(O00000oO);
            O0000o = cbl.O00000Oo(O0000o);
            O0000O0o = cbl.O00000Oo(O0000O0o);
        } else {
            O00000o0();
        }
        O00000Oo();
    }

    public static void O00000Oo() {
        ArrayList<DomainModel> O000oO0o = O000oO0o();
        O0000Oo0 = O000000o(O000oO0o, O0000Oo0);
        O0000Oo = O000000o(O000oO0o, O0000Oo);
        O00000o = O000000o(O000oO0o, O00000o);
        O00000o0 = O000000o(O000oO0o, O00000o0);
        O0000o0 = O000000o(O000oO0o, O0000o0);
        O0000oo = O000000o(O000oO0o, O0000oo);
        O0000ooO = O000000o(O000oO0o, O0000ooO);
        O0000o00 = O000000o(O000oO0o, O0000o00);
        O0000OoO = O000000o(O000oO0o, O0000OoO);
        f13571O000000o = O000000o(O000oO0o, f13571O000000o);
        O00000Oo = O000000o(O000oO0o, O00000Oo);
        O000O0o0 = O000000o(O000oO0o, O000O0o0);
        O0000Ooo = O000000o(O000oO0o, O0000Ooo);
        cct.f13639O000000o = O000000o(O000oO0o, cct.f13639O000000o);
        O000oO();
        if (byl.O0000OoO()) {
            String str = O0000o0;
            O0000o0O = str;
            O0000o0o = str;
            return;
        }
        O000oOO0();
    }

    private static ArrayList<DomainModel> O000oO0o() {
        ArrayList<DomainModel> arrayList = new ArrayList<>();
        try {
            return (ArrayList) new Gson().fromJson(cbm.O00000o0.O00000Oo(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]"), new TypeToken<ArrayList<DomainModel>>() {
                /* class _m_j.cav.AnonymousClass1 */
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    private static String O000000o(ArrayList<DomainModel> arrayList, String str) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<DomainModel> it = arrayList.iterator();
            while (it.hasNext()) {
                DomainModel next = it.next();
                if (next.local.equals(cad.f13513O000000o)) {
                    if (System.currentTimeMillis() < next.launchTime) {
                        return str;
                    }
                    if (!TextUtils.isEmpty(next.replaceMatchedDomain(str))) {
                        return next.replaceMatchedDomain(str);
                    }
                }
            }
        }
        return str;
    }

    public static void O00000o0() {
        if (byl.O0000OOo()) {
            O0000Oo0 = O00000Oo + O0000oo0;
            StringBuilder sb = new StringBuilder("http://m-buy.test.mi.com/");
            sb.append(O0000oo0);
            O0000Oo = sb.toString();
            O0000o0 = O00000o + O0000oo0;
            StringBuilder sb2 = new StringBuilder("http://m-buy.test.mi.com/");
            sb2.append(O0000oo0);
            O0000o00 = sb2.toString();
            O0000OoO = "http://m-buy.test.mi.com/" + O0000oo0;
            O0000o = O00000oo + O0000oo0;
            StringBuilder sb3 = new StringBuilder("http://hd-c.test.mi.com/");
            sb3.append(O0000oo0);
            O0000Ooo = sb3.toString();
            return;
        }
        O0000Oo0 = f13571O000000o + O0000oo0;
        StringBuilder sb4 = new StringBuilder("http://m.buy.mi.com/");
        sb4.append(O0000oo0);
        O0000Oo = sb4.toString();
        if (byl.O0000Oo0()) {
            O0000o0 = "http://go.appmifile.com/" + O0000oo0;
        } else {
            O0000o0 = O00000o0 + O0000oo0;
        }
        O0000o00 = "https://m.buy.mi.com/" + O0000oo0;
        O0000OoO = "http://app.buy.mi.com/" + O0000oo0;
        O0000ooo = "http://xiaomi.api.cashify.in/";
        O0000o = O00000oO + O0000oo0;
        StringBuilder sb5 = new StringBuilder("http://hd.c.mi.com/");
        sb5.append(O0000oo0);
        O0000Ooo = sb5.toString();
        if (cad.O0000Ooo()) {
            O000O00o = "https://www.miui.com/res/doc/eula/en.html";
        }
    }

    private static void O000oO() {
        cdf.O00000Oo = cct.f13639O000000o + "micra/crash";
        cdf.O00000o0 = cct.f13639O000000o + "app/stat";
        cdj.f13666O000000o = cct.f13639O000000o + "micra/crash";
        cdk.f13667O000000o = cct.f13639O000000o + "micra/state/server";
    }

    public static void O00000o() {
        if (!byl.O0000OOo()) {
            O00000o0();
            O0000o0 = O00000o0 + O0000oo0;
        }
        if (byl.O0000OoO()) {
            String str = O0000o0;
            O0000o0O = str;
            O0000o0o = str;
        }
    }

    public static String O00000oO() {
        if (byl.O0000OOo()) {
            return O00000Oo;
        }
        return f13571O000000o;
    }

    private static void O000oOO0() {
        O0000o0O = O0000Oo;
        O0000o0o = O0000o00;
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (SyncModel.inHardAccelerUrls != null) {
            for (String contains : SyncModel.inHardAccelerUrls) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        try {
            if ("1".equals(Uri.parse(str).getQueryParameter("usehardware"))) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (SyncModel.inBrowserUrls != null) {
            for (String contains : SyncModel.inBrowserUrls) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        if (SyncModel.inAppUrls != null) {
            for (String contains2 : SyncModel.inAppUrls) {
                if (str.contains(contains2)) {
                    return false;
                }
            }
        }
        if ((str.contains("facebook.com") && !str.contains("oauth")) || str.contains("twitter.com") || str.contains("youtube.com")) {
            return true;
        }
        try {
            if ("1".equals(Uri.parse(str).getQueryParameter("outbrowser"))) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static boolean O00000o0(String str) {
        return str != null && str.contains(O0000oO);
    }

    public static String O00000oo() {
        return O0000o0O + "/cod/sendcodcode/";
    }

    public static String O00000o(String str) {
        return O0000Oo + "/item/" + str;
    }

    public static String O0000O0o() {
        return O0000o0O + "/cod/codconfirmbysms";
    }

    public static String O0000OOo() {
        return O0000o0O + "/cod/codconfirmbymanual";
    }

    public static String O0000Oo0() {
        return O0000o0O + "/cod/codconfirmbynoverify";
    }

    public static String O00000oO(String str) {
        if (O000O0o == null) {
            O000O0o = new Random();
        }
        return O0000o0O + "/cod/codimagecode?order_id=" + str + "&v=" + O000O0o.nextDouble();
    }

    public static String O0000Oo() {
        return O0000Oo + "/cod/aftercodconfirm";
    }

    public static String O0000OoO() {
        if (O000O0o == null) {
            O000O0o = new Random();
        }
        if (byl.O0000OoO()) {
            return O0000o0 + "/captcha?type=ordercancel&v=" + O000O0o.nextDouble();
        }
        return O0000Oo + "/order/getauthcode?&v=" + O000O0o.nextDouble();
    }

    public static String O0000Ooo() {
        return O0000o0O + "/order/refundapply";
    }

    public static String[] O0000o00() {
        return O0000Ooo("/buy/payinfo");
    }

    public static String[] O0000o0() {
        return O0000Ooo("/buy/checkout/");
    }

    public static String[] O0000o0O() {
        return O0000Ooo("/buy/submit/");
    }

    public static String O000000o(int i) {
        String str = O0000o0;
        if (i == 0) {
            return str + "/user/orderlist?type=0&ot=5";
        } else if (i == 1) {
            return str + "/user/orderlist?type=2&ot=5";
        } else if (i == 2) {
            return str + "/user/orderlist?type=5&ot=5";
        } else if (i == 3) {
            return str + "/user/orderlist?type=6&ot=5";
        } else if (i == 4) {
            return str + "/user/orderlist?type=7&ot=5";
        } else if (i == 5) {
            return str + "/user/orderlist?type=8&ot=5";
        } else {
            return str + "/user/orderlist?type=0&ot=5";
        }
    }

    public static String O0000o0o() {
        return O0000o0 + "/buy/checkgstin";
    }

    public static String O0000o() {
        return O0000o0 + "/user/ordercancel?ot=5";
    }

    public static String O0000oO0() {
        return O0000o00 + "/user/orderlist?type=2";
    }

    public static String O0000oO() {
        return O0000o00 + "/user/orderlist?type=17";
    }

    public static String O0000oOO() {
        return byl.O0000OOo() ? "http://push.buy.test.mi.com/in/client/pushtypes" : "http://push.buy.mi.com/in/client/pushtypes";
    }

    public static String O0000oOo() {
        return O0000o0 + "/user/expressinfo/express_sn/";
    }

    private static String[] O0000Ooo(String str) {
        if (byl.O0000OoO()) {
            if (byl.O0000OOo()) {
                return new String[]{O00000o + O0000oo0 + str};
            }
            String[] strArr = new String[2];
            StringBuilder sb = new StringBuilder();
            String str2 = "https://go.buy.mi.com/";
            sb.append(byl.O0000Oo0() ? "http://go.appmifile.com/" : SyncModel.useHttps ? str2 : O00000o0);
            sb.append(O0000oo0);
            sb.append(str);
            strArr[0] = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            if (byl.O0000Oo0()) {
                str2 = "http://go.appmifile.com/";
            } else if (SyncModel.useHttps) {
                str2 = O00000o0;
            }
            sb2.append(str2);
            sb2.append(O0000oo0);
            sb2.append(str);
            strArr[1] = sb2.toString();
            return strArr;
        } else if (byl.O0000OOo()) {
            return new String[]{"http://m-buy.test.mi.com/" + O0000oo0 + str};
        } else {
            String[] strArr2 = new String[2];
            StringBuilder sb3 = new StringBuilder();
            String str3 = "https://m.buy.mi.com/";
            sb3.append(SyncModel.useHttps ? str3 : "http://m.buy.mi.com/");
            sb3.append(O0000oo0);
            sb3.append(str);
            strArr2[0] = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            if (SyncModel.useHttps) {
                str3 = "http://m.buy.mi.com/";
            }
            sb4.append(str3);
            sb4.append(O0000oo0);
            sb4.append(str);
            strArr2[1] = sb4.toString();
            return strArr2;
        }
    }

    public static String[] O0000oo0() {
        return O0000Ooo("/cart/add");
    }

    public static String O0000oo() {
        return O0000o0o + "/cart/add";
    }

    public static String O000000o(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("jsontag", "true");
        buildUpon.appendQueryParameter("security", "true");
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter("item_ids", str2);
        }
        if (byl.O0000OoO()) {
            buildUpon.appendQueryParameter("ot", "5");
        }
        if (bzw.O000000o()) {
            buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
        }
        return buildUpon.toString();
    }

    public static String O0000ooO() {
        return O0000o0o + "/cart/delete";
    }

    public static String O0000ooo() {
        return O0000o0o + "/cart/deletebatch";
    }

    public static String O00oOooO() {
        return O0000o0o + "/cart/update";
    }

    public static String O00oOooo() {
        return O0000o0o + "/user/address?ot=5";
    }

    public static String O000O00o() {
        return O0000o0o + "/address/save";
    }

    public static String O000O0OO() {
        return O0000o0o + "/address/del";
    }

    public static String O000O0Oo() {
        return O0000o0o + "/address/setdefault";
    }

    public static String O00oOoOo() {
        return O0000o0o + "/address/checkzipcode";
    }

    public static String O000O0o0() {
        return O0000o0 + "/user/orderview?ot=5";
    }

    public static String O000O0o() {
        return O0000o0o + "/user/coupon";
    }

    public static String O000O0oO() {
        return O0000o0o + "/user/notifymessage";
    }

    public static String O000O0oo() {
        return O0000Oo0 + "/app/";
    }

    public static String O000OO00() {
        return O0000Oo0 + "/app/service/";
    }

    public static String O000OO0o() {
        if (cad.O00000o()) {
            return O0000o0O + "/discovery/view";
        }
        return O0000o0 + "/discovery/view?ot=5";
    }

    public static String O000OO() {
        return O0000Oo0 + "/app/cart-insurance/";
    }

    public static String O000OOOo() {
        return O0000Oo + "/user";
    }

    public static String O000OOo0() {
        if (byl.O0000OOo()) {
            return O00000Oo + O0000oo0 + "/app/category/";
        }
        return f13571O000000o + O0000oo0 + "/app/category/";
    }

    public static String O000OOo() {
        if (cad.O0000O0o()) {
            return O0000o0O + "/cart?ot=1";
        }
        return O0000o0O + "/cart?ot=5";
    }

    public static Boolean O00000oo(String str) {
        if (TextUtils.isEmpty(str) || !cad.O00000o()) {
            return Boolean.FALSE;
        }
        String str2 = "/" + O0000oo0 + "/cart";
        if (str.indexOf(str2) < 0) {
            return Boolean.FALSE;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf(63));
        }
        if (str.toLowerCase().contains(str2.toLowerCase())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Boolean O0000O0o(String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (str.toLowerCase().contains("oneclick=1")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static String O000OOoO() {
        return O0000Oo + "/accessories/";
    }

    public static String O000OOoo() {
        return O0000OoO + "/app/sync";
    }

    public static String O000Oo00() {
        return O0000o0O + "/app/sync";
    }

    public static String O000Oo0() {
        if (byl.O0000OOo()) {
            return O00oOoOo;
        }
        return O000O0Oo;
    }

    public static String O000Oo0O() {
        return O0000o0 + "/app/assemblyinfo";
    }

    public static String O000Oo0o() {
        return O0000o0O + "/app/block";
    }

    public static String O000OoO0() {
        return O0000o0 + "/page/home";
    }

    public static String O00O0Oo() {
        return O0000o0O + "/app/logincallback?ot=5";
    }

    public static String O000OoO() {
        return O0000o0O + "/buy/changeaddress";
    }

    public static String O000OoOO() {
        return O0000o0O + "/app/refreshuserinfo";
    }

    public static String O0000OOo(String str) {
        String str2 = f13571O000000o;
        if (str.startsWith("http:")) {
            str2 = "http://mobile.mi.com/";
        }
        if (str.startsWith("https:")) {
            str2 = "https://mobile.mi.com/";
        }
        if (byl.O0000OOo()) {
            str2 = str2.replace("mobile.mi.com", "mobile.test.mi.com");
            str = str.replace("mobile.mi.com", "mobile.test.mi.com").replace("m.buy.mi.com", "m-buy.test.mi.com");
        }
        String O000000o2 = O000000o(O000oO0o(), str);
        String O000000o3 = O000000o(O000oO0o(), str2);
        String str3 = "";
        if (O000000o2.contains("#")) {
            String[] split = O000000o2.split("#");
            if (split.length > 1) {
                str3 = split[1];
            }
            if (split.length > 0) {
                O000000o2 = split[0];
            }
        }
        if (O000000o2.startsWith(O000000o3)) {
            if (!O000000o2.startsWith(O000000o3 + O0000oo0 + "/app/")) {
                String[] split2 = O000000o2.split(O000000o3, 2);
                if (split2.length == 2) {
                    split2 = split2[1].split("/", 2);
                }
                if (split2.length == 1) {
                    return O00000Oo(O000000o3 + split2[0] + "/app/", str3);
                } else if (split2.length == 2) {
                    return O00000Oo(O000000o3 + split2[0] + "/app/" + split2[1], str3);
                }
            }
        }
        if (!TextUtils.isEmpty(O000000o2) && O000000o2.matches("^https*://m*event.c.mi.com.*")) {
            ccr.O00000Oo("ConnectionHelper", "getAppUrl matches regex :".concat(String.valueOf(O000000o2)));
            try {
                O000000o2 = O000000o2.replace(".event.c.mi.com", ".mevent.c.mi.com");
                String[] split3 = O000000o2.split("/");
                if (split3.length > 4 && !"app".equals(split3[4])) {
                    String str4 = split3[0] + "/" + split3[1] + "/" + split3[2] + "/" + split3[3] + "/app/";
                    for (int i = 4; i < split3.length; i++) {
                        str4 = str4 + split3[i] + "/";
                    }
                    return O00000Oo(str4.substring(0, str4.length() - 1), str3);
                }
            } catch (Exception e) {
                ccr.O00000Oo("ConnectionHelper", "getAppUrl erro url :" + O000000o2 + " exception  = " + e.toString());
            }
        }
        return O00000Oo(O000000o2, str3);
    }

    public static String O0000Oo0(String str) {
        String str2;
        String str3;
        if (str == null) {
            return null;
        }
        if (!bzw.O000000o()) {
            return str;
        }
        if (str.contains("#")) {
            str2 = str.split("#")[1];
            str = str.split("#")[0];
        } else {
            str2 = "";
        }
        String O000000o2 = cbf.O000000o();
        if (str.contains("?")) {
            str3 = str + "&_network_type=" + O000000o2;
        } else {
            str3 = str + "?_network_type=" + O000000o2;
        }
        return O00000Oo(str3, str2);
    }

    private static String O00000Oo(String str, String str2) {
        if (str2.equals("")) {
            return str;
        }
        return str + "#" + str2;
    }

    public static boolean O0000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        if (cad.O00000o()) {
            if (lowerCase.equals("cart") || lowerCase.equals("place order") || lowerCase.equals("pay") || lowerCase.equals("privacy policy") || lowerCase.equals("exchange coupon")) {
                return false;
            }
        } else if (cad.O00000oO() || cad.O00000oo()) {
            if (lowerCase.equals("購物車") || lowerCase.equals("成立訂單") || lowerCase.equals("付款")) {
                return false;
            }
        } else if (cad.O0000O0o()) {
            if (lowerCase.equalsIgnoreCase("Keranjang") || lowerCase.equalsIgnoreCase("Pesan sekarang") || lowerCase.equalsIgnoreCase("Bayar")) {
                return false;
            }
        } else if (cad.O0000OOo()) {
            if (lowerCase.equalsIgnoreCase("carrito") || lowerCase.equalsIgnoreCase("envío en camino") || lowerCase.equalsIgnoreCase("pagar") || lowerCase.contains("docdata") || lowerCase.contains("contrato del usuario") || lowerCase.contains("terms")) {
                return false;
            }
        } else if (cad.O0000Oo0()) {
            if (lowerCase.equalsIgnoreCase("mon panier") || lowerCase.equalsIgnoreCase("commander") || lowerCase.equalsIgnoreCase("Paiement") || lowerCase.contains("docdata") || lowerCase.contains("accord utilisateur") || lowerCase.contains("terms")) {
                return false;
            }
        } else if (cad.O0000OoO()) {
            if (lowerCase.equalsIgnoreCase("Корзина") || lowerCase.equalsIgnoreCase("Сделать заказ") || lowerCase.equalsIgnoreCase("Оплата") || lowerCase.contains("марвел кт") || lowerCase.contains("terms")) {
                return false;
            }
        } else if (cad.O0000Oo()) {
            if (lowerCase.equalsIgnoreCase("carrello") || lowerCase.equalsIgnoreCase("Effettua l‘ordine") || lowerCase.equalsIgnoreCase("Dati della carta") || lowerCase.contains("Condizion generali di") || lowerCase.contains("Termini")) {
                return false;
            }
        } else if (!cad.O0000Ooo() || (!lowerCase.equalsIgnoreCase("cart") && !lowerCase.equalsIgnoreCase("Place Order") && !lowerCase.equalsIgnoreCase("Card Details") && !lowerCase.contains("user agreement") && !lowerCase.contains("terms"))) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public static String[] O000OoOo() {
        if (byl.O0000OOo()) {
            return new String[]{O00000Oo + "in/hj.html", "http://m-buy.test.mi.com/in/misc/hj"};
        }
        return new String[]{f13571O000000o + "in/hj.html", "http://m.buy.mi.com/in/misc/hj"};
    }

    public static String O000Ooo0() {
        return O0000Oo + "/comment/getgoodslist";
    }

    public static String O000Ooo() {
        return O0000Oo + "/comment/writeevaluate";
    }

    public static String O000OooO() {
        return O0000o0O + "/user/cards";
    }

    public static String O000Oooo() {
        return O0000o0O + "/buy/paygo";
    }

    public static String O000o000() {
        return O0000oO0 + "/feedback/add";
    }

    public static String O000o00() {
        return O0000o0 + "/mifinance/getemiplan?ot=5";
    }

    public static String O000o00O() {
        return O0000o0 + "/mifinance/createloanapplication?ot=5";
    }

    public static String O000o00o() {
        return O0000o0 + "/mifinance/sendotp?ot=5";
    }

    public static String O000o0() {
        return O0000o0 + "/buy/sendotp";
    }

    public static String O000o0O0() {
        return O0000o0 + "/buy/paygo?ot=5";
    }

    public static String O000o0O() {
        return O0000o0 + "/buy/paygo";
    }

    public static String O000o0OO() {
        return O0000ooo + "v1/get-device-quote/automate/register";
    }

    public static String O000o0Oo() {
        return O0000ooo + "v1/get-device-quote/automate/quote";
    }

    public static String O000o0o0() {
        return O0000Oo0 + "/miexchange/enterimei/?";
    }

    public static String O000o0o() {
        return O0000Oo + "/user/exchangerecord";
    }

    public static String O000o0oo() {
        return O0000Oo0 + "/miexchange/selectdevice/";
    }

    public static String O000o() {
        return O0000o0 + "/buy/payment?ot=5";
    }

    public static String O000oO00() {
        return O0000o0 + "/recommend";
    }

    public static String O0000OoO(String str) {
        return O0000o0 + "/search?type=android&word=" + str;
    }

    public static String O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return O0000o0 + "/searchresult/" + str + "/" + str2 + "/" + str3 + "/" + str4 + "/" + str5 + "/" + str6 + "/" + str7;
    }

    public static String O000oO0() {
        return O0000Ooo + "/eventapi/api/warmup/follow";
    }

    public static String O000oO0O() {
        return O0000Ooo + "/eventapi/api/warmup/unfollow";
    }

    public static String[] O000000o(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            Uri.Builder buildUpon = Uri.parse(strArr[i]).buildUpon();
            buildUpon.appendQueryParameter("jsontag", "true");
            if (byl.O0000OoO()) {
                buildUpon.appendQueryParameter("ot", "5");
            }
            if (bzw.O000000o()) {
                buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
            }
            strArr2[i] = buildUpon.toString();
        }
        return strArr2;
    }

    public static String O000000o(String str, String str2, String str3, String str4, String str5) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("jsontag", "true");
        buildUpon.appendQueryParameter("security", "true");
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter("id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            buildUpon.appendQueryParameter("item_id", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            buildUpon.appendQueryParameter("parent_itemId", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            buildUpon.appendQueryParameter("count", str5);
        }
        if (byl.O0000OoO()) {
            buildUpon.appendQueryParameter("ot", "5");
        }
        if (!TextUtils.isEmpty("")) {
            buildUpon.appendQueryParameter("source", "");
        }
        if (!TextUtils.isEmpty("")) {
            buildUpon.appendQueryParameter("token", "");
        }
        if (bzw.O000000o()) {
            buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
        }
        return buildUpon.toString();
    }
}

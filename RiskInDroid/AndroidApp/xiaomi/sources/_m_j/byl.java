package _m_j;

import _m_j.caw;
import _m_j.cbj;
import _m_j.cbm;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.android.volley.toolbox.Volley;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.mi.global.shop.newmodel.domain.DomainModel;
import com.mi.mistatistic.sdk.controller.MiStatOptions;
import com.mi.util.Device;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public final class byl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f13410O000000o = cdz.f13673O000000o;
    public static boolean O00000Oo = false;
    public static boolean O00000o = false;
    public static boolean O00000o0 = false;
    public static boolean O00000oO = false;
    public static ccq O00000oo;
    public static ccp O0000O0o;
    public static boolean O0000OOo = false;
    public static boolean O0000Oo = true;
    public static boolean O0000Oo0 = true;
    public static boolean O0000OoO = false;
    public static boolean O0000Ooo = false;
    private static boolean O0000o0;
    private static boolean O0000o00 = true;
    private static boolean O0000o0O;
    private static byl O0000o0o;
    private static CallbackManager O0000oO0;
    private final Application O0000o;
    private MiStatOptions O0000oO;

    public static void O0000Ooo() {
    }

    private byl(Application application) {
        O0000o0o = this;
        this.O0000o = application;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.app.Application, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public static void O000000o(Application application, String str, String str2) {
        ccr.O000000o();
        boolean O000000o2 = cbm.O00000o0.O000000o((Context) application, "pref_key_is_agree_privacy_from_mihome_app_".concat(String.valueOf(str)), false);
        O0000Ooo = O000000o2;
        if (!O000000o2 || !str2.equals("mihome_sdk")) {
            ccr.O00000Oo("ShopApp", str + "，ShopApp.init() 启动, 当前米家渠道隐私协议同意的值 == " + O0000Ooo + ", 不进行 FaceBookSdk 初始化");
        } else {
            try {
                FacebookSdk.sdkInitialize(application);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ccr.O00000Oo("ShopApp", str + "，ShopApp.init() 启动, 当前米家渠道隐私协议同意的值 == " + O0000Ooo + ", 进行 FaceBookSdk 初始化");
        }
        bxp.f13383O000000o = application;
        Device.O000000o(application, cem.O000000o(application, "android.permission.READ_PHONE_STATE"));
        cef.O000000o().O000000o(application);
        ced.f13683O000000o = Volley.newRequestQueue(application);
        byl byl = new byl(application);
        ccr.O00000Oo("ShopApp", "ShopApp 初始化");
        eui.O000000o(application);
        bym.O000000o(application);
        cad.O000000o(str);
        cat.O000000o();
        ccn.O00000Oo(byl.O0000o);
        ny.O000000o(byl.O0000o);
        bzw.O00000Oo();
        cbj cbj = cbj.O000000o.f13594O000000o;
        cbj.f13593O000000o = cef.O000000o().O00000Oo;
        cbj.O00000Oo = (float) cef.O000000o().O00000o0;
        cbj.O00000o0 = (float) cef.O000000o().f13684O000000o;
        cbj.O00000o = cbj.O00000o0 / cbj.f13593O000000o;
        if (cbj.O00000oO == null) {
            cbj.O00000oO = new HashMap<>();
        }
        cbj.O00000oO.put(0, Float.valueOf(cbj.O00000Oo(540)));
        cbj.O00000oO.put(3, Float.valueOf(cbj.O000000o(370)));
        cbj.O00000oO.put(4, Float.valueOf(cbj.O000000o(540)));
        cbj.O00000oO.put(5, Float.valueOf(cbj.O00000Oo(720)));
        cbj.O00000oO.put(6, Float.valueOf(cbj.O00000Oo(1020)));
        cbj.O00000oO.put(7, Float.valueOf(cbj.O00000Oo(570)));
        cbj.O00000oO.put(8, Float.valueOf(cbj.O00000Oo(1020)));
        cbj.O00000oO.put(9, Float.valueOf(cbj.O00000Oo(480)));
        cbj.O00000oO.put(10, Float.valueOf(cbj.O00000Oo(310)));
        cbj.O00000oO.put(11, Float.valueOf(cbj.O00000Oo(540)));
        cbj.O00000oO.put(12, Float.valueOf(cbj.O00000Oo(650)));
        cbj.O00000oO.put(13, Float.valueOf(cbj.O00000Oo(360)));
        cbj.O00000oO.put(14, Float.valueOf(cbj.O00000Oo(360)));
        cbj.O00000oO.put(18, Float.valueOf(cbj.O00000Oo(1589)));
        cbj.O00000oO.put(17, Float.valueOf(cbj.O00000Oo(1080)));
        cbj.O00000oO.put(20, Float.valueOf(cbj.O00000Oo(690)));
        cbj.O00000oO.put(19, Float.valueOf(cbj.O00000Oo(1080)));
        cbj.O00000oO.put(21, Float.valueOf(cbj.O00000Oo(480)));
        cbj.O00000oO.put(22, Float.valueOf(cbj.O00000Oo(370)));
        cbj.O00000oO.put(23, Float.valueOf(cbj.O00000Oo(180)));
        cbj.O00000oO.put(24, Float.valueOf(cbj.O00000Oo(810)));
        cbj.O00000oO.put(25, Float.valueOf(cbj.O00000Oo(660)));
        cbj.O00000oO.put(26, Float.valueOf(cbj.O00000Oo(210)));
        cbq.O000000o(byl.O0000o, str2);
        if (str2.equals("mihome_sdk")) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("com.mi.global.bbs");
            arrayList.add("com.google.android.youtube.player");
            arrayList.add("com.mi.global.shop");
            arrayList.add("com.paytm.pgsdk");
            arrayList.add("com.payu.custombrowser");
            arrayList.add("com.payu.magicretry");
            arrayList.add("com.mobikwik.sdk");
            arrayList.add("com.mi.global.shop.base");
            arrayList.add("com.mi.global.shop.router");
            arrayList.add("com.mi.global.shop.feature.search");
            MiStatOptions.O000000o o000000o = new MiStatOptions.O000000o();
            o000000o.f5062O000000o.appId = byl.O00000o();
            o000000o.f5062O000000o.channel = Device.O000O00o;
            o000000o.f5062O000000o.test = O00000Oo;
            o000000o.f5062O000000o.userId = ccn.O0000o00().O00000Oo();
            o000000o.f5062O000000o.enableLog = false;
            o000000o.f5062O000000o.isForSdk = true;
            o000000o.f5062O000000o.needUploadPackageNameList = arrayList;
            byl.O0000oO = o000000o.f5062O000000o;
            if (cad.O00000o()) {
                byl.O0000oO.serverIndia = true;
            }
            if (cad.O0000OoO()) {
                byl.O0000oO.serverRussia = true;
            }
            if (O0000Ooo) {
                cbe.O000000o(byl.O0000o, byl.O0000oO);
                ccr.O00000Oo("ShopApp", str + "，ShopApp.init()，用户同意了隐私协议值，init() 直接初始化打点统计库");
            } else {
                ccr.O00000Oo("ShopApp", str + "，ShopApp.init()，用户没有同意了隐私协议值，init() 不初始化打点统计库");
            }
        }
        cbe.O000000o("shop_");
        byp.O000000o("shop_");
        File file = new File(Environment.getExternalStorageDirectory() + "/mishop/");
        if (!file.exists()) {
            file.mkdir();
        }
        O0000o0 = cbm.O00000o0.O000000o((Context) byl.O0000o, "pref_key_use_new_model", true);
        O0000oO0 = CallbackManager.Factory.create();
        O0000o0O = cbm.O00000o0.O000000o((Context) byl.O0000o, "pref_key_using_go_mifile_host_swtich", false);
        O00000o0 = cbm.O00000o0.O000000o((Context) byl.O0000o, "pref_key_https_request", true);
        O00000o = cbm.O00000o0.O000000o((Context) byl.O0000o, "pref_key_https_image_request", true);
        O00000oO = cbm.O00000o0.O000000o((Context) byl.O0000o, "pref_key_https_webview_url_request", true);
        if (cad.O0000O0o()) {
            cav.O0000oO = "mi.co.id";
        }
    }

    public static void O000000o(boolean z, String str, ExtendedAuthToken extendedAuthToken) {
        ccr.O00000Oo("ShopApp", "商城 SDK，登录完成.");
        ccn.O0000o00().O000000o(z, str, extendedAuthToken);
        O0000Oo = true;
    }

    public static ArrayList<DomainModel> O000000o() {
        if (ccn.O0000o00() != null) {
            return ccn.O0000o00().O0000o0();
        }
        return null;
    }

    public static void O00000Oo() {
        ccr.O00000Oo("ShopApp", "商城 SDK，需要登录");
        if (O0000Oo) {
            O0000Oo = false;
            O0000OoO = true;
            ccq ccq = O00000oo;
            caw.O000000o.O00000oO();
            ccq.O000000o(caw.O000000o.O00000o0());
        }
    }

    public static void O00000o0() {
        ccq ccq = O00000oo;
        caw.O000000o.O00000oO();
        ccq.O000000o(caw.O000000o.O00000o0());
    }

    public static Application O00000oO() {
        return O0000o0o.O0000o;
    }

    public static byl O00000oo() {
        return O0000o0o;
    }

    public static boolean O0000O0o() {
        return f13410O000000o;
    }

    public static boolean O0000OOo() {
        return O00000Oo;
    }

    public static boolean O0000Oo0() {
        return O0000o0O;
    }

    public static CallbackManager O0000Oo() {
        return O0000oO0;
    }

    public static boolean O0000OoO() {
        if (cad.O00000o()) {
            return O0000o00;
        }
        return false;
    }

    static class O000000o extends AsyncTask<Object, Integer, cco> {
        O000000o() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o(objArr);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            cco cco = (cco) obj;
            super.onPostExecute(cco);
            if (cco != null) {
                cco.O000000o();
            }
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
            super.onProgressUpdate((Integer[]) objArr);
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
        }

        private static cco O000000o(Object... objArr) {
            String str;
            cad.f13513O000000o = cad.O0000o0[Integer.parseInt((String) objArr[0])][0];
            cad.O00000Oo = cad.O0000o0[Integer.parseInt((String) objArr[0])][1];
            if (!(byl.O00000oo() == null || byl.O00000oO() == null)) {
                try {
                    ccn.O0000o00().O0000Oo();
                    cbi.O000000o();
                    cbm.O00000o0.O000000o(byl.O00000oO(), "pref_locale", cad.f13513O000000o);
                    cbm.O00000o0.O000000o(byl.O00000oO(), "pref_lang", cad.O00000Oo);
                    cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_user_center_list");
                    CookieSyncManager.createInstance(byl.O00000oO());
                    CookieManager.getInstance().removeAllCookie();
                    CookieSyncManager.getInstance().sync();
                    cbw.O000000o(byl.O00000oO());
                    cbw.O00000Oo(byl.O00000oO());
                } catch (Exception e) {
                    ccr.O000000o("ShopApp", e.getMessage());
                }
            }
            byl.O0000Oo = true;
            byl.O0000OoO = false;
            cav.O0000oo0 = cad.f13513O000000o;
            cav.f13571O000000o = "http://mobile.mi.com/";
            cav.O00000Oo = "http://mobile.test.mi.com/";
            cav.O00000o0 = "http://go.buy.mi.com/";
            cav.O00000o = "http://go-buy.test.mi.com/";
            cav.O0000Oo0 = "";
            cav.O0000Oo = "";
            cav.O0000OoO = "";
            cav.O0000o00 = "";
            cav.O0000o0 = "";
            cav.O0000o0O = "";
            cav.O0000o0o = "";
            cav.O0000oO0 = "http://sg.appeye.appmifile.com";
            cav.O0000oO = "mi.com";
            caw.O00000Oo.f13572O000000o = "mi.com";
            cav.O0000oOO = cav.O0000oO + "/" + cad.f13513O000000o;
            StringBuilder sb = new StringBuilder("/");
            sb.append(cad.f13513O000000o);
            cav.O0000oOo = sb.toString();
            cav.O0000oo = "http://push.buy.mi.com/";
            cav.O0000ooO = "http://push.buy.test.mi.com/";
            cav.O0000ooo = "http://xiaomi.api.cashify.in/";
            cav.O00oOooO = cav.f13571O000000o + "in/service/smartboxdelivery/";
            cav.O000O00o = "https://www.miui.com/res/doc/eula/" + cad.f13513O000000o + ".html";
            cav.O000O0OO = "https://mobile.mi.com/" + cad.f13513O000000o + "/app/service/terms/";
            cav.O000O0o0 = byl.O0000OOo() ? "staging.m.id.mipay.com" : "m.id.mipay.com";
            if (cad.O00000o()) {
                str = "https://in-go.buy.mi.com/" + cad.f13513O000000o + "/httpdns";
            } else {
                StringBuilder sb2 = cad.O0000OoO() ? new StringBuilder("https://ru-go.buy.mi.com/") : new StringBuilder("https://go.buy.mi.com/");
                sb2.append(cad.f13513O000000o);
                sb2.append("/httpdns");
                str = sb2.toString();
            }
            cav.O000O0Oo = str;
            cav.O00oOoOo = "https://go-buy.test.mi.com/" + cad.f13513O000000o + "/httpdns";
            cct.f13639O000000o = ccs.O00000Oo() ? "http://in.stat.appmifile.com/" : ccs.O00000o() ? "http://cn.stat.appmifile.com/" : "http://sg.stat.appmifile.com/";
            cav.O00000o0();
            cav.O000000o();
            ccr.O00000Oo("ShopApp", "商城 SDK 切换国家，清理，初始化完毕。");
            return (cco) objArr[1];
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            super.onCancelled();
        }
    }

    public static void O0000o00() {
        CookieManager.getInstance().removeAllCookie();
        ccn.O0000o00().O0000Oo();
        ccr.O00000Oo("ShopApp", "商城 SDK，logout。");
    }

    public static void O000000o(boolean z) {
        ccr.O000000o();
    }

    public static void O00000Oo(boolean z) {
        O0000OOo = z;
        ccr.O00000Oo("ShopApp", "点击商城的 tab");
        try {
            if (O0000O0o != null && z) {
                cbe.O000000o(O0000O0o.O00000oo + "_open_shop_key", car.O00000Oo());
                ccr.O00000Oo("ShopApp", "点击商城的 tab，长传点击事件统计数据");
            }
        } catch (Exception e) {
            ccr.O000000o("ShopApp", "上传点击商城的 tab 统计事件出错，" + e.getMessage());
        }
    }

    public static void O0000o0() {
        O0000Oo0 = false;
    }

    public static void O000000o(String str, String str2, cco cco) {
        cbm.O00000o0.O000000o(O0000o0o.O0000o, "pref_key_home_new_list", "");
        ccr.O00000Oo("ShopApp", "已清除首页缓存");
        ccr.O00000Oo("ShopApp", "商城 SDK，开始切花国家。");
        if (str.equals(str2) || TextUtils.isEmpty(str2)) {
            new O000000o().execute("0", cco);
        } else if (!str2.equals(cad.O00000o0)) {
            for (int i = 0; i < cad.O0000o0.length; i++) {
                if (cad.O0000o0[i][0].equals(str2)) {
                    if (TextUtils.isEmpty(cad.f13513O000000o) || TextUtils.isEmpty(cad.O00000Oo) || cad.f13513O000000o.equals(cad.O0000o0[i][0])) {
                        cco.O000000o();
                    } else {
                        new O000000o().execute(String.valueOf(i), cco);
                        return;
                    }
                }
            }
        } else if (!str2.equals(cad.O00000o0)) {
        } else {
            if (str.equals(cad.O00000o)) {
                new O000000o().execute("0", cco);
            } else if (str.equals(cad.O0000OoO)) {
                new O000000o().execute("6", cco);
            } else {
                new O000000o().execute("0", cco);
            }
        }
    }

    public final String O00000o() {
        if (f13410O000000o || O00000Oo) {
            return this.O0000o.getString(R.string.statistic_debug_id);
        }
        if (cad.O00000o()) {
            return this.O0000o.getString(R.string.statistic_in_id);
        }
        if (cad.O00000oO()) {
            return this.O0000o.getString(R.string.statistic_tw_id);
        }
        if (cad.O00000oo()) {
            return this.O0000o.getString(R.string.statistic_hk_id);
        }
        if (cad.O0000OOo()) {
            return this.O0000o.getString(R.string.statistic_es_id);
        }
        if (cad.O0000Oo0()) {
            return this.O0000o.getString(R.string.statistic_fr_id);
        }
        if (cad.O0000O0o()) {
            return this.O0000o.getString(R.string.statistic_id_id);
        }
        if (cad.O0000Oo()) {
            return this.O0000o.getString(R.string.statistic_it_id);
        }
        if (cad.O0000OoO()) {
            return this.O0000o.getString(R.string.statistic_ru_id);
        }
        if (cad.O0000Ooo()) {
            return this.O0000o.getString(R.string.statistic_uk_id);
        }
        return this.O0000o.getString(R.string.statistic_in_id);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.app.Application, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [android.app.Application, java.lang.String, boolean]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    public static void O000000o(boolean z, String str) {
        boolean O000000o2 = cbm.O00000o0.O000000o((Context) O0000o0o.O0000o, "pref_key_is_agree_privacy_from_mihome_app_".concat(String.valueOf(str)), false);
        ccr.O00000Oo("ShopApp", str + "，当前米家渠道隐私协议同意的值 == " + O000000o2);
        if (!O000000o2 && z) {
            try {
                FacebookSdk.sdkInitialize(O0000o0o.O0000o);
            } catch (Exception e) {
                e.printStackTrace();
            }
            byl byl = O0000o0o;
            cbe.O000000o(byl.O0000o, byl.O0000oO);
            ccr.O00000Oo("ShopApp", str + "，用户同意隐私协议后，进行 FaceBookSdk 和 打点统计库的初始化");
        }
        cbm.O00000o0.O00000Oo((Context) O0000o0o.O0000o, "pref_key_is_agree_privacy_from_mihome_app_".concat(String.valueOf(str)), z);
        ccr.O00000Oo("ShopApp", str + "，更新隐私同意的值后，米家渠道隐私协议同意的值 == " + cbm.O00000o0.O000000o((Context) O0000o0o.O0000o, "pref_key_is_agree_privacy_from_mihome_app_".concat(String.valueOf(str)), false));
    }
}

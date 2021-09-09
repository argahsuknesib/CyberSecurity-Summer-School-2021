package _m_j;

import _m_j.bxq;
import _m_j.bxs;
import _m_j.caw;
import _m_j.cbm;
import _m_j.cej;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.model.app.CookieInfo;
import com.mi.global.shop.model.app.LoginCallbackData;
import com.mi.global.shop.newmodel.domain.DomainModel;
import com.squareup.wire.Wire;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ccn extends bxq {
    protected static ccn O00000oO;
    private AccountManager O00000oo;

    public interface O000000o extends bxq.O000000o {
        void onUserInfoUpdate(String str, String str2, String str3, int i, String str4);
    }

    private ccn(Context context) {
        super(context);
        this.O00000oo = AccountManager.get(context);
    }

    public static void O00000Oo(Context context) {
        bxq.O000000o(context);
        caw.O000000o.O00000o();
        if (!TextUtils.isEmpty(cad.f13513O000000o) && !TextUtils.isEmpty(cad.O00000Oo(cad.f13513O000000o))) {
            bxs.O000000o.f13388O000000o = cad.O00000Oo(cad.f13513O000000o);
        }
        if (O00000oO == null) {
            O00000oO = new ccn(context);
        }
    }

    public static ccn O0000o00() {
        return O00000oO;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final String O00000o0() {
        String O00000o0 = super.O00000o0();
        if (O00000o0 != null) {
            return O00000o0;
        }
        if (cbm.O00000o0.O000000o(this.f13384O000000o, "pref_login_system", false)) {
            String O00000Oo = cbm.O00000o0.O00000Oo(this.f13384O000000o, "pref_system_extended_token", "");
            if (TextUtils.isEmpty(O00000Oo)) {
                bxs.O000000o.O00000Oo();
                String O000000o2 = O000000o(bxs.O000000o.O00000o0(), true);
                if (caf.O000000o(O000000o2) != null) {
                    return caf.O000000o(O000000o2).f13514O000000o;
                }
            } else if (caf.O000000o(O00000Oo) != null) {
                return caf.O000000o(O00000Oo).f13514O000000o;
            } else {
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    public final void O000000o(boolean z, String str, ExtendedAuthToken extendedAuthToken) {
        if (this.f13384O000000o != null && !TextUtils.isEmpty(str) && extendedAuthToken != null) {
            if (z) {
                cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_login_system", true);
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_system_uid", str);
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_system_extended_token", extendedAuthToken.toPlain());
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_extended_token", extendedAuthToken.toPlain());
            } else {
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_uid", str);
                cej.O00000Oo.O000000o(this.f13384O000000o, "pref_extended_token", extendedAuthToken.toPlain());
            }
            O000000o(str, extendedAuthToken.authToken, extendedAuthToken.security);
        }
    }

    public final ArrayList<DomainModel> O0000o0() {
        ArrayList<DomainModel> arrayList;
        String O00000Oo = cbm.O00000o0.O00000Oo(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]");
        if (TextUtils.isEmpty(O00000Oo)) {
            return null;
        }
        ArrayList<DomainModel> arrayList2 = new ArrayList<>();
        try {
            arrayList = (ArrayList) new Gson().fromJson(O00000Oo, new TypeToken<ArrayList<DomainModel>>() {
                /* class _m_j.ccn.AnonymousClass1 */
            }.getType());
        } catch (Exception unused) {
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            return arrayList;
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final boolean O0000o0O() {
        if (cej.O00000Oo.O000000o(this.f13384O000000o, "pref_login_system", false)) {
            return !TextUtils.isEmpty(cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_uid", "")) && !TextUtils.isEmpty(cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_extended_token", ""));
        }
        return !TextUtils.isEmpty(cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_uid", "")) && !TextUtils.isEmpty(cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_extended_token", ""));
    }

    public final void O000000o(String str, String str2, String str3) {
        if (cad.O0000O0o()) {
            O0000o0o();
        }
        super.O000000o(str, str2, str3);
        O0000oOo();
    }

    public final void O0000o0o() {
        if (O00000o()) {
            O0000ooo();
        } else {
            O0000ooO();
        }
    }

    private static void O0000ooO() {
        AccountInfo O00000Oo = O00000oO.O00000Oo(byl.O00000oO().getString(R.string.mipay_sid));
        if (O00000Oo != null) {
            O000000o(O00000Oo.serviceToken, O00000Oo.getSlh(), O00000Oo.getPh(), O00000Oo.getEncryptedUserId());
        }
    }

    private static void O0000ooo() {
        String string = byl.O00000oO().getString(R.string.mipay_sid);
        String O000000o2 = O00000oO.O000000o(string, false);
        ccn ccn = O00000oO;
        String O00000o0 = ccn.O00000o0(string + "_slh");
        ccn ccn2 = O00000oO;
        String O00000o02 = ccn2.O00000o0(string + "_ph");
        String O00000o03 = O00000oO.O00000o0("encrypted_user_id");
        if (!TextUtils.isEmpty(O00000o0) && O00000o0.contains(",")) {
            O00000o0 = O00000o0.split(",")[1];
        }
        if (!TextUtils.isEmpty(O00000o02) && O00000o02.contains(",")) {
            O00000o02 = O00000o02.split(",")[1];
        }
        O000000o(O000000o2, O00000o0, O00000o02, O00000o03);
    }

    private static void O000000o(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_mipay_token", str);
            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_mipay_slh", str2);
            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_mipay_ph", str3);
            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_mipay_cuid", str4);
        }
    }

    public final String O0000o() {
        if (O00000oo()) {
            return cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_mipay_token", "");
        }
        return "";
    }

    public final String O0000oO0() {
        if (O00000oo()) {
            return cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_mipay_slh", "");
        }
        return "";
    }

    public final String O0000oO() {
        if (O00000oo()) {
            return cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_mipay_ph", "");
        }
        return "";
    }

    public final String O0000oOO() {
        if (O00000oo()) {
            return cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_mipay_cuid", "");
        }
        return "";
    }

    public static void O000000o(String str, String str2, String str3, int i, String str4) {
        if (O00000Oo != null && !O00000Oo.isEmpty()) {
            for (bxq.O000000o o000000o : O00000Oo) {
                ccr.O00000Oo("LoginManager", "account listener:" + o000000o.toString());
                ((O000000o) o000000o).onUserInfoUpdate(str, str2, str3, i, str4);
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.android.volley.Request] */
    /* JADX WARN: Type inference failed for: r9v1, types: [_m_j.cah] */
    /* JADX WARN: Type inference failed for: r3v2, types: [_m_j.cai] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void O0000oOo() {
        /*
            r15 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = _m_j.cav.O0000oOO
            java.lang.String r2 = "xmuuid"
            java.lang.String r1 = _m_j.cbw.O000000o(r1, r2)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0016
            r0.put(r2, r1)
        L_0x0016:
            java.lang.String r1 = "security"
            java.lang.String r2 = "true"
            r0.put(r1, r2)
            boolean r1 = _m_j.byl.O0000OoO()
            java.lang.String r2 = "UTF-8"
            if (r1 == 0) goto L_0x0043
            _m_j.cai r1 = new _m_j.cai
            r4 = 1
            java.lang.String r5 = _m_j.cav.O00O0Oo()
            java.util.Map r0 = _m_j.cbh.O000000o(r0)
            java.lang.String r6 = _m_j.cbh.O000000o(r0, r2)
            _m_j.ccn$2 r7 = new _m_j.ccn$2
            r7.<init>()
            _m_j.ccn$3 r8 = new _m_j.ccn$3
            r8.<init>()
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x0060
        L_0x0043:
            _m_j.cah r1 = new _m_j.cah
            r10 = 1
            java.lang.String r11 = _m_j.cav.O00O0Oo()
            java.util.Map r0 = _m_j.cbh.O000000o(r0)
            java.lang.String r12 = _m_j.cbh.O000000o(r0, r2)
            _m_j.ccn$4 r13 = new _m_j.ccn$4
            r13.<init>()
            _m_j.ccn$5 r14 = new _m_j.ccn$5
            r14.<init>()
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14)
        L_0x0060:
            java.lang.String r0 = "LoginManager"
            r1.setTag(r0)
            com.android.volley.RequestQueue r0 = _m_j.ced.f13683O000000o
            r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.ccn.O0000oOo():void");
    }

    public static JSONArray O000000o(LoginCallbackData loginCallbackData) {
        JSONArray jSONArray = new JSONArray();
        if (!(loginCallbackData == null || loginCallbackData.cookies == null)) {
            for (int i = 0; i < loginCallbackData.cookies.size(); i++) {
                CookieInfo cookieInfo = loginCallbackData.cookies.get(i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", Wire.get(cookieInfo.key, ""));
                    jSONObject.put("value", Wire.get(cookieInfo.value, ""));
                    jSONObject.put("domain", Wire.get(cookieInfo.domain, ""));
                    jSONObject.put("path", Wire.get(cookieInfo.path, ""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public final String O0000oo0() {
        if (cbm.O00000o0.O000000o(this.f13384O000000o, "pref_login_system", false)) {
            return O00oOooO();
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private String O00oOooO() {
        Account[] accountsByType = this.O00000oo.getAccountsByType("com.xiaomi");
        if (accountsByType.length > 0) {
            try {
                return this.O00000oo.getUserData(accountsByType[0], "acc_user_name");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void O0000Oo() {
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "pref_cache_service_token_list");
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "shop_pref_user_names");
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "shop_pref_user_icons");
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "not_paid_order");
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "not_used_coupon");
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "pref_key_custom_cookies");
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "pref_key_shoppingcart_number");
        cbm.O00000o0.O00000Oo(this.f13384O000000o, "pref_kefu_token");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_c_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_c_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_extended_token");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_pass_token");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_uid");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_system_extended_token");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_key_user_ecryption_id");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_last_refresh_serviceToken_time");
        cej.O00000Oo.O00000Oo(this.f13384O000000o, "pref_login_system");
    }

    public final String O0000oo() {
        if (O0000o0O()) {
            return cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_kefu_token", "");
        }
        return "";
    }
}

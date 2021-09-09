package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public final class iif {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f1313O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    private String O0000OOo;

    private iif(Context context, String str, String str2, String str3, String str4) {
        this.f1313O000000o = "";
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.f1313O000000o = str;
        this.O00000Oo = str3;
        this.O00000o0 = TextUtils.isEmpty(str4) ? "" : str4;
        this.O00000o = iij.O000000o(context);
        this.O00000oO = str2;
        this.O0000O0o = "token";
        String O000000o2 = iij.O000000o(context, context.getPackageName());
        this.O0000OOo = TextUtils.isEmpty(O000000o2) ? "" : O000000o2;
    }

    public iif(Context context, String str, String str2, String str3) {
        this(context, str, context.getPackageName(), str2, str3);
    }

    private iif(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f1313O000000o = "";
        this.O00000Oo = "";
        this.O00000o0 = "";
        this.O00000o = "";
        this.O00000oO = "";
        this.O00000oo = "";
        this.O0000O0o = "";
        this.O0000OOo = "";
        this.f1313O000000o = str;
        this.O00000Oo = str2;
        this.O00000o = str3;
        this.O00000oO = str4;
        this.O00000o0 = str5;
        this.O00000oo = str6;
        this.O0000O0o = str7;
        this.O0000OOo = str8;
    }

    public static iif O000000o(Context context, Bundle bundle) {
        return new iif(bundle.getString("app_key"), bundle.getString("redirect_uri"), iij.O000000o(context), bundle.getString("pack_id"), bundle.getString("state"), bundle.getString("client_os_type"), bundle.getString("obtain_auth_type"), bundle.getString("third_app_name"));
    }
}

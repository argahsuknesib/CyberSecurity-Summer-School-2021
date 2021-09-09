package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;

public final class gwr {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18426O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;

    public gwr() {
    }

    public gwr(String str, String str2, String str3, String str4, String str5) {
        this.O0000OOo = str;
        this.O00000o0 = str2;
        this.O00000o = str3;
        this.O00000oO = str4;
        this.O0000O0o = str5;
        if (!TextUtils.isEmpty(str5)) {
            this.f18426O000000o = str5;
        } else if (!TextUtils.isEmpty(str4)) {
            this.f18426O000000o = str4;
        } else if (!TextUtils.isEmpty(str3)) {
            this.f18426O000000o = str3;
        }
        this.O00000Oo = gws.O000000o(ServiceApplication.getAppContext(), str2, str3, str4);
    }
}

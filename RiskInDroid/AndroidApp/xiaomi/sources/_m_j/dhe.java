package _m_j;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.Map;

public final class dhe implements dhd {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f14637O000000o;
    private final dgz O00000Oo;
    private final dgu O00000o;
    private final dgs O00000o0;

    public dhe(Context context, dgs dgs, dgz dgz, dgu dgu) {
        this.f14637O000000o = context;
        this.O00000Oo = dgz;
        this.O00000o0 = dgs;
        this.O00000o = dgu;
    }

    public final CrashDetailBean O000000o(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, byte[] bArr, Map<String, String> map) {
        String str11 = str;
        String str12 = str8;
        byte[] bArr2 = bArr;
        boolean O00000o02 = dha.O000000o().O00000o0();
        if (O00000o02) {
            did.O00000oO("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.O00000Oo = 1;
        crashDetailBean.O00000oO = this.O00000o0.O00000oO();
        crashDetailBean.O00000oo = this.O00000o0.O0000o0;
        crashDetailBean.O0000O0o = this.O00000o0.O0000oOO();
        crashDetailBean.O0000o00 = this.O00000o0.O00000o();
        crashDetailBean.O0000o0 = str3;
        String str13 = "";
        crashDetailBean.O0000o0O = O00000o02 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : str13;
        crashDetailBean.O0000o0o = str4;
        if (str5 != null) {
            str13 = str5;
        }
        crashDetailBean.O0000o = str13;
        crashDetailBean.O0000oO0 = j;
        crashDetailBean.O0000oOo = dif.O00000o(crashDetailBean.O0000o.getBytes());
        crashDetailBean.O00oOooO = str11;
        crashDetailBean.O00oOooo = str2;
        crashDetailBean.O000O0oO = this.O00000o0.O0000oo0();
        crashDetailBean.O0000OOo = this.O00000o0.O0000oO();
        crashDetailBean.O0000Oo0 = this.O00000o0.O000O0o0();
        crashDetailBean.O0000oo0 = str12;
        NativeCrashHandler O000000o2 = NativeCrashHandler.O000000o();
        String O00000Oo2 = O000000o2 != null ? O000000o2.O00000Oo() : null;
        String O000000o3 = dhf.O000000o(O00000Oo2, str12);
        if (!dif.O000000o(O000000o3)) {
            crashDetailBean.O000Oo0O = O000000o3;
        }
        crashDetailBean.O000Oo0o = dhf.O000000o(O00000Oo2);
        crashDetailBean.O0000oo = dhf.O000000o(str9, dha.O00000oO);
        crashDetailBean.O000O0oo = str7;
        crashDetailBean.O000OO00 = str6;
        crashDetailBean.O000OO0o = str10;
        crashDetailBean.O00oOoOo = this.O00000o0.O0000o00();
        crashDetailBean.O000O0o0 = this.O00000o0.O0000Ooo();
        crashDetailBean.O000O0o = this.O00000o0.O0000o0();
        crashDetailBean.O000O00o = -1;
        crashDetailBean.O000O0OO = -1;
        crashDetailBean.O000O0Oo = -1;
        if (crashDetailBean.O0000oo == null) {
            crashDetailBean.O0000oo = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
        }
        crashDetailBean.O000OO = -1;
        crashDetailBean.O000OOo = -1;
        crashDetailBean.O000OOoO = -1;
        crashDetailBean.O000OOoo = map;
        crashDetailBean.O000Oo00 = this.O00000o0.O000O0Oo();
        crashDetailBean.O0000ooo = null;
        if (str11 == null) {
            crashDetailBean.O00oOooO = "unknown(record)";
        }
        if (bArr2 != null) {
            crashDetailBean.O0000ooO = bArr2;
        }
        return crashDetailBean;
    }
}

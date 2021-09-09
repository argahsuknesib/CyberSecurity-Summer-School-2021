package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;

public class hxa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hxa f935O000000o;

    public static hxa O000000o() {
        if (f935O000000o == null) {
            synchronized (hxa.class) {
                if (f935O000000o == null) {
                    f935O000000o = new hxa();
                }
            }
        }
        return f935O000000o;
    }

    public static boolean O00000Oo() {
        CommonApplication.getAppContext();
        cme O0000OOo = cmc.O0000OOo();
        if (O0000OOo != null) {
            long currentTimeMillis = System.currentTimeMillis();
            LogType logType = LogType.MAIN_PAGE;
            gsy.O00000Oo(logType, "YP_Splash_link", O0000OOo.f14119O000000o);
            if (currentTimeMillis >= O0000OOo.O00000o0 && currentTimeMillis <= O0000OOo.O00000o) {
                return true;
            }
        }
        gsy.O00000Oo(LogType.MAIN_PAGE, "YP_Splash_null", "false");
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public static void O000000o(BaseActivity baseActivity, String str) {
        fbt fbt = new fbt(baseActivity, "SmartHomeMainActivity");
        fbt.O000000o(baseActivity.getIntent().getExtras());
        Bundle bundle = new Bundle();
        bundle.putString("splash_jump_url", str);
        fbt.O000000o(bundle);
        fbt.O000000o("source", 18);
        fbt.O000000o("SplashActivity.jumpTo.flag", true);
        fbt.O00000Oo(335544320);
        fbs.O000000o(fbt);
    }
}

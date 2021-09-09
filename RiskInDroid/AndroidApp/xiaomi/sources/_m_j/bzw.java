package _m_j;

import _m_j.cbm;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class bzw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Boolean f13503O000000o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.app.Application, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public static boolean O000000o() {
        if (f13503O000000o == null) {
            f13503O000000o = Boolean.valueOf(cbm.O00000o0.O000000o((Context) byl.O00000oO(), "pref_data_saver_mode", true));
        }
        return f13503O000000o.booleanValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [android.app.Application, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    public static void O00000Oo() {
        SharedPreferences defaultSharedPreferences;
        Application O00000oO = byl.O00000oO();
        if (O00000oO != null && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(O00000oO)) != null && !defaultSharedPreferences.contains("pref_data_saver_mode")) {
            cbm.O00000o0.O00000Oo((Context) O00000oO, "pref_data_saver_mode", true);
        }
    }
}

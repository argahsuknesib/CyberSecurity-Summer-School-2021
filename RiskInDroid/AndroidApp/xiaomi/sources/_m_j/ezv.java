package _m_j;

import android.content.Context;

public final class ezv {

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean
     arg types: [android.content.SharedPreferences, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean */
    public static boolean O000000o(Context context) {
        if (context == null) {
            return false;
        }
        return gpy.O00000Oo(context.getSharedPreferences("prefs_disclaim", 0), "pref_key_smarthome_show_disclaim_new", true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean
     arg types: [android.content.SharedPreferences, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.gpy.O00000Oo(android.content.SharedPreferences, java.lang.String, boolean):boolean */
    public static boolean O00000Oo(Context context) {
        if (context == null) {
            return false;
        }
        return gpy.O00000Oo(context.getSharedPreferences("prefs_disclaim", 0), "pref_key_smarthome_disclaim_confirmed", false);
    }
}

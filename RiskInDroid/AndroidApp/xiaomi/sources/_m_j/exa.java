package _m_j;

import _m_j.dus;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.io.File;

public final class exa {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f15909O000000o = "";
    public static String O00000Oo = "virtualview";

    public interface O000000o {
        void O000000o();
    }

    public static void O000000o(final String str, final String str2, final O000000o o000000o) {
        SharedPreferences defaultSharedPreferences;
        File filesDir = eui.f15823O000000o.getFilesDir();
        if (filesDir != null) {
            f15909O000000o = filesDir.getAbsolutePath() + "/" + O00000Oo;
            File file = new File(f15909O000000o);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        if (!TextUtils.isEmpty(f15909O000000o) && !TextUtils.isEmpty(str)) {
            Application application = eui.f15823O000000o;
            String str3 = O00000Oo;
            String str4 = "";
            if (!(application == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)) != null) {
                str4 = defaultSharedPreferences.getString(str3, str4);
            }
            if (!str4.equals(str2)) {
                duk.O000000o(new Runnable() {
                    /* class _m_j.exa.AnonymousClass1 */

                    public final void run() {
                        SharedPreferences defaultSharedPreferences;
                        SharedPreferences.Editor edit;
                        String str = exa.f15909O000000o + "/" + exa.O00000Oo;
                        if (ewz.O000000o(str, str + ".zip")) {
                            if (dus.O000000o.O000000o(str + ".zip", exa.f15909O000000o)) {
                                O000000o o000000o = o000000o;
                                if (o000000o != null) {
                                    o000000o.O000000o();
                                }
                                Application application = eui.f15823O000000o;
                                String str2 = exa.O00000Oo;
                                String str3 = str2;
                                if (!(application == null) && (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)) != null && (edit = defaultSharedPreferences.edit()) != null) {
                                    edit.putString(str2, str3);
                                    edit.commit();
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}

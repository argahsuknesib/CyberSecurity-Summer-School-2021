package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;

public final class btz {
    public static int O000000o(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void O000000o(Context context, String str, String str2, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString("command", str2);
            edit.putInt("version", i);
            O000000o(edit);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void O000000o(final SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                editor.apply();
                return;
            }
            try {
                new AsyncTask<Void, Void, Void>() {
                    /* class _m_j.btz.AnonymousClass1 */

                    private Void O000000o() {
                        try {
                            if (editor == null) {
                                return null;
                            }
                            editor.commit();
                            return null;
                        } catch (Throwable unused) {
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }
                }.execute(null, null, null);
            } catch (Throwable unused) {
            }
        }
    }

    public static String O00000Oo(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, null);
        } catch (Throwable unused) {
            return null;
        }
    }
}

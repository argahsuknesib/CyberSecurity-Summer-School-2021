package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONArray;

public class ilf {
    public static final int O00000Oo = (Build.VERSION.SDK_INT >= 24 ? 4 : 7);

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f1436O000000o;

    public ilf(Context context, String str) {
        this.f1436O000000o = context.getSharedPreferences(str, O00000Oo);
    }

    public final void O000000o(String str, long j) {
        O000000o(this.f1436O000000o.edit().putLong(str, j));
    }

    @SuppressLint({"NewApi"})
    private static void O000000o(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final long O000000o(String str) {
        return this.f1436O000000o.getLong(str, -1);
    }

    public final long O00000Oo(String str) {
        return this.f1436O000000o.getLong(str, 0);
    }

    public final void O000000o(String str, String str2) {
        O000000o(this.f1436O000000o.edit().putString(str, str2));
    }

    public final String O00000o0(String str) {
        return this.f1436O000000o.getString(str, "");
    }

    public final void O000000o(String str, int i) {
        O000000o(this.f1436O000000o.edit().putInt(str, i));
    }

    public final int O00000o(String str) {
        return this.f1436O000000o.getInt(str, 0);
    }

    public final void O000000o(String str, ArrayList<String> arrayList) {
        O000000o(this.f1436O000000o.edit().putString(str, new Gson().toJson(arrayList)));
    }

    public final ArrayList<String> O00000oO(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(this.f1436O000000o.getString(str, "{}"));
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public final void O00000oo(String str) {
        O000000o(this.f1436O000000o.edit().remove(str));
    }

    public final boolean O0000O0o(String str) {
        return this.f1436O000000o.contains(str);
    }
}

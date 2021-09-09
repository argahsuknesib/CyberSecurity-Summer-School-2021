package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public final class fbt {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f16049O000000o;
    Uri O00000Oo;
    HashMap<String, Object> O00000o0;

    public fbt(Context context, String str) {
        Uri uri;
        Intent intent;
        int intExtra;
        if (TextUtils.isEmpty(str)) {
            uri = Uri.EMPTY;
        } else {
            uri = Uri.parse(!TextUtils.isEmpty(str) ? str.toLowerCase(Locale.ENGLISH) : str);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f16049O000000o = context;
        this.O00000Oo = uri == null ? Uri.EMPTY : uri;
        this.O00000o0 = hashMap;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null && (intExtra = intent.getIntExtra("mj_dialog_theme_pad", 0)) != 0) {
            O000000o("mj_dialog_theme_pad", intExtra + 1);
        }
    }

    private <T> fbt O000000o(String str, Object obj) {
        if (obj != null) {
            this.O00000o0.put(str, obj);
        }
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt */
    public final fbt O000000o(int i) {
        O000000o("com.sankuai.waimai.router.activity.request_code", (Object) Integer.valueOf(i));
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt */
    public final fbt O00000Oo(int i) {
        O000000o("com.sankuai.waimai.router.activity.flags", (Object) Integer.valueOf(i));
        return this;
    }

    public final fbt O000000o(String str, boolean z) {
        O000000o().putBoolean(str, z);
        return this;
    }

    public final fbt O000000o(String str, int i) {
        O000000o().putInt(str, i);
        return this;
    }

    public final fbt O000000o(String str) {
        O000000o().putDouble(str, 0.7d);
        return this;
    }

    public final fbt O000000o(String str, String str2) {
        O000000o().putString(str, str2);
        return this;
    }

    public final fbt O000000o(String str, CharSequence charSequence) {
        O000000o().putCharSequence(str, charSequence);
        return this;
    }

    public final fbt O000000o(String str, Parcelable parcelable) {
        O000000o().putParcelable(str, parcelable);
        return this;
    }

    public final fbt O000000o(String str, ArrayList<? extends Parcelable> arrayList) {
        O000000o().putParcelableArrayList(str, arrayList);
        return this;
    }

    public final fbt O000000o(String str, Serializable serializable) {
        O000000o().putSerializable(str, serializable);
        return this;
    }

    public final fbt O000000o(String str, String[] strArr) {
        O000000o().putStringArray(str, strArr);
        return this;
    }

    public final fbt O000000o(String str, Bundle bundle) {
        O000000o().putBundle(str, bundle);
        return this;
    }

    public final fbt O000000o(Bundle bundle) {
        if (bundle != null) {
            O000000o().putAll(bundle);
        }
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
     arg types: [java.lang.String, android.os.Bundle]
     candidates:
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt */
    public final synchronized Bundle O000000o() {
        Bundle bundle;
        bundle = (Bundle) O000000o(Bundle.class, "com.sankuai.waimai.router.activity.intent_extra");
        if (bundle == null) {
            bundle = new Bundle();
            O000000o("com.sankuai.waimai.router.activity.intent_extra", (Object) bundle);
        }
        return bundle;
    }

    private <T> T O000000o(Class cls, String str) {
        Object obj = this.O00000o0.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            cvb.O0000OOo();
            return null;
        }
    }
}

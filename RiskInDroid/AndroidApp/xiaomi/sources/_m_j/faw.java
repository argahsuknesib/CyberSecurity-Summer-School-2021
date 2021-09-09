package _m_j;

import android.content.Context;
import android.graphics.RectF;
import android.os.Parcelable;

public final class faw {
    public static fbb O000000o() {
        fbb fbb = (fbb) fbs.O000000o(fbb.class, "key.com.xiaomi.smarthome.card.spec.router.MiotSpecCardManager");
        return fbb == null ? new fbk() : fbb;
    }

    public static fba O00000Oo() {
        fba fba = (fba) fbs.O000000o(fba.class, "key.com.xiaomi.smarthome.card.profile.router.ControlCardInfoManager");
        return fba == null ? new fbj() : fba;
    }

    public static faz O00000o0() {
        faz faz = (faz) fbs.O000000o(faz.class, "key.com.xiaomi.smarthome.card.main.router.MainPageOpManager");
        return faz == null ? new fbi() : faz;
    }

    public static fay O00000o() {
        fay fay = (fay) fbs.O000000o(fay.class, "key.com.xiaomi.smarthome.card.api.router");
        return fay == null ? new fbh() : fay;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, android.graphics.RectF]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public static void O000000o(Context context, String str, String str2, RectF rectF) {
        fbs.O000000o(new fbt(context, "card").O000000o("did", str).O000000o("room_name", str2).O000000o("view_position", (Parcelable) rectF).O000000o(6));
    }
}

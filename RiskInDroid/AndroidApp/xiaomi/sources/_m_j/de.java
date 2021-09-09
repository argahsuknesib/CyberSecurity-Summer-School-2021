package _m_j;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class de extends dc {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f14541O000000o;
    private int O0000OoO;
    private LayoutInflater O0000Ooo;

    @Deprecated
    public de(Context context, int i) {
        super(context, null, true);
        this.O0000OoO = i;
        this.f14541O000000o = i;
        this.O0000Ooo = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View O000000o(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.O0000Ooo.inflate(this.f14541O000000o, viewGroup, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View O00000Oo(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.O0000Ooo.inflate(this.O0000OoO, viewGroup, false);
    }
}

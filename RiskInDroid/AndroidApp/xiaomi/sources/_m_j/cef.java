package _m_j;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class cef {
    private static final String O00000o = "cef";

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13684O000000o;
    public float O00000Oo;
    public int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static cef f13685O000000o = new cef((byte) 0);
    }

    /* synthetic */ cef(byte b) {
        this();
    }

    private cef() {
    }

    public static cef O000000o() {
        return O000000o.f13685O000000o;
    }

    public final void O000000o(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f13684O000000o = displayMetrics.widthPixels;
        this.O00000oO = displayMetrics.heightPixels;
        this.O00000Oo = displayMetrics.density;
        this.O00000o0 = displayMetrics.densityDpi;
        this.O00000oo = (int) ((((float) displayMetrics.widthPixels) / this.O00000Oo) + 0.5f);
        this.O0000O0o = (int) ((((float) displayMetrics.heightPixels) / this.O00000Oo) + 0.5f);
        String str = O00000o;
        ccr.O00000Oo(str, "屏幕高度px:" + this.O00000oO + ",屏幕宽度px:" + this.f13684O000000o + ",Density:" + this.O00000Oo + ",dpi:" + this.O00000o0 + ",屏幕高度dip:" + this.O0000O0o + ",屏幕宽度dip:" + this.O00000oo);
        ccr.O00000Oo(O00000o, displayMetrics.toString());
    }
}

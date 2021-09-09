package _m_j;

import android.graphics.Bitmap;
import java.io.File;

public final class fzw extends fzx implements fzs {
    private fzt O00000oO;
    private final int O00000oo = 0;

    private fzw(fzq<Bitmap> fzq, int i, fzu<String> fzu, String str, int i2) {
        super(fzq, i, fzu, str);
    }

    public final void O000000o(int i) {
        O00000Oo(i);
    }

    public static void O000000o(fzq<Bitmap> fzq, int i, fzu fzu, String str) {
        try {
            new fzw(fzq, i, fzu, str, 0).execute(new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            fzu.O00000Oo();
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        this.O00000oO = new fzt(this.O00000Oo, this.O00000o0, new File(this.O00000o), this.O00000oo, this);
        this.O00000oO.O000000o();
        return "";
    }
}

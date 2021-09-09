package _m_j;

import android.content.Context;
import android.graphics.Bitmap;

public abstract class uz implements uu<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap O000000o(ux uxVar, Bitmap bitmap, int i, int i2);

    public final uw<Bitmap> O000000o(Context context, uw<Bitmap> uwVar, int i, int i2) {
        ux uxVar = uo.O000000o().f2540O000000o;
        Bitmap O000000o2 = uwVar.O000000o();
        if (i == Integer.MIN_VALUE) {
            i = O000000o2.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = O000000o2.getHeight();
        }
        Bitmap O000000o3 = O000000o(uxVar, O000000o2, i, i2);
        return O000000o2.equals(O000000o3) ? uwVar : uy.O000000o(O000000o3);
    }
}

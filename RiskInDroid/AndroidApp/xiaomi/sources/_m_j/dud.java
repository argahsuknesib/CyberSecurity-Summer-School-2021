package _m_j;

import android.content.Context;
import android.graphics.Bitmap;

public abstract class dud implements uu<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap O000000o(ux uxVar, Bitmap bitmap, int i, int i2);

    public final uw<Bitmap> O000000o(Context context, uw<Bitmap> uwVar, int i, int i2) {
        if (vo.O000000o(i, i2)) {
            ux O00000Oo = uo.O000000o().O00000Oo();
            Bitmap O000000o2 = uwVar.O000000o();
            if (i == Integer.MIN_VALUE) {
                i = O000000o2.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = O000000o2.getHeight();
            }
            context.getApplicationContext();
            Bitmap O000000o3 = O000000o(O00000Oo, O000000o2, i, i2);
            if (O000000o2.equals(O000000o3)) {
                return uwVar;
            }
            return uy.O000000o(O000000o3);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}

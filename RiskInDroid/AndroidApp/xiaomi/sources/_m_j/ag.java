package _m_j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

final class ag extends Drawable.ConstantState {

    /* renamed from: O000000o  reason: collision with root package name */
    int f12379O000000o;
    Drawable.ConstantState O00000Oo;
    PorterDuff.Mode O00000o = ae.f12365O000000o;
    ColorStateList O00000o0 = null;

    ag(ag agVar) {
        if (agVar != null) {
            this.f12379O000000o = agVar.f12379O000000o;
            this.O00000Oo = agVar.O00000Oo;
            this.O00000o0 = agVar.O00000o0;
            this.O00000o = agVar.O00000o;
        }
    }

    public final Drawable newDrawable() {
        return newDrawable(null);
    }

    public final Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new af(this, resources);
        }
        return new ae(this, resources);
    }

    public final int getChangingConfigurations() {
        int i = this.f12379O000000o;
        Drawable.ConstantState constantState = this.O00000Oo;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }
}

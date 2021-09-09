package _m_j;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.transition.ChangeBounds;
import android.util.Property;
import android.view.View;

@TargetApi(22)
final class drp extends dro {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Property<View, PointF> f14879O000000o = O000000o("POSITION_PROPERTY");
    private static final Property<View, PointF> O00000Oo = O000000o("BOTTOM_RIGHT_ONLY_PROPERTY");
    private static final PointF O00000o0 = new PointF();

    drp() {
    }

    private static Property<View, PointF> O000000o(String str) {
        Object O000000o2 = drl.O000000o(drl.O000000o(ChangeBounds.class, str));
        if (!(O000000o2 instanceof Property)) {
            return null;
        }
        Property<View, PointF> property = (Property) O000000o2;
        try {
            property.set(null, new PointF());
            return property;
        } catch (NullPointerException unused) {
            return property;
        } catch (Exception unused2) {
            return null;
        }
    }

    public final void O000000o(View view, int i, int i2, int i3, int i4) {
        if (f14879O000000o == null || O00000Oo == null) {
            super.O000000o(view, i, i2, i3, i4);
            return;
        }
        O00000o0.set((float) i, (float) i2);
        f14879O000000o.set(view, O00000o0);
        O00000o0.set((float) i3, (float) i4);
        O00000Oo.set(view, O00000o0);
    }
}

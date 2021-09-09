package _m_j;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class ii<T> extends Property<T, Float> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Property<T, PointF> f1308O000000o;
    private final PathMeasure O00000Oo;
    private final float[] O00000o = new float[2];
    private final float O00000o0;
    private final PointF O00000oO = new PointF();
    private float O00000oo;

    public final /* synthetic */ void set(Object obj, Object obj2) {
        Float f = (Float) obj2;
        this.O00000oo = f.floatValue();
        this.O00000Oo.getPosTan(this.O00000o0 * f.floatValue(), this.O00000o, null);
        PointF pointF = this.O00000oO;
        float[] fArr = this.O00000o;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f1308O000000o.set(obj, pointF);
    }

    ii(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f1308O000000o = property;
        this.O00000Oo = new PathMeasure(path, false);
        this.O00000o0 = this.O00000Oo.getLength();
    }

    public final /* synthetic */ Object get(Object obj) {
        return Float.valueOf(this.O00000oo);
    }
}

package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.Brush;
import com.horcrux.svg.SvgView;

@SuppressLint({"ViewConstructor"})
public final class ban extends bai {
    private static final float[] O0000O0o = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: O000000o  reason: collision with root package name */
    private baq f12748O000000o;
    private baq O00000Oo;
    private baq O00000o;
    private baq O00000o0;
    private ReadableArray O00000oO;
    private Brush.BrushUnits O00000oo;
    private Matrix O0000OOo = null;

    public ban(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x1")
    public final void setX1(Dynamic dynamic) {
        this.f12748O000000o = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "y1")
    public final void setY1(Dynamic dynamic) {
        this.O00000Oo = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "x2")
    public final void setX2(Dynamic dynamic) {
        this.O00000o0 = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "y2")
    public final void setY2(Dynamic dynamic) {
        this.O00000o = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "gradient")
    public final void setGradient(ReadableArray readableArray) {
        this.O00000oO = readableArray;
        invalidate();
    }

    @ReactProp(name = "gradientUnits")
    public final void setGradientUnits(int i) {
        if (i == 0) {
            this.O00000oo = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.O00000oo = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "gradientTransform")
    public final void setGradientTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int O000000o2 = bao.O000000o(readableArray, O0000O0o, this.mScale);
            if (O000000o2 == 6) {
                if (this.O0000OOo == null) {
                    this.O0000OOo = new Matrix();
                }
                this.O0000OOo.setValues(O0000O0o);
            } else if (O000000o2 != -1) {
                FLog.w("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.O0000OOo = null;
        }
        invalidate();
    }

    public final void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(Brush.BrushType.LINEAR_GRADIENT, new baq[]{this.f12748O000000o, this.O00000Oo, this.O00000o0, this.O00000o}, this.O00000oo);
            brush.O00000o0 = this.O00000oO;
            Matrix matrix = this.O0000OOo;
            if (matrix != null) {
                brush.O00000oo = matrix;
            }
            SvgView svgView = getSvgView();
            if (this.O00000oo == Brush.BrushUnits.USER_SPACE_ON_USE) {
                brush.O0000O0o = svgView.getCanvasBounds();
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}

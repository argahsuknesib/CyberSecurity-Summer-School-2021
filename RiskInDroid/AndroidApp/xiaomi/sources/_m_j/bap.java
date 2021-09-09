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
public final class bap extends bai {
    private static final float[] O0000Oo0 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: O000000o  reason: collision with root package name */
    private baq f12751O000000o;
    private baq O00000Oo;
    private baq O00000o;
    private baq O00000o0;
    private baq O00000oO;
    private baq O00000oo;
    private ReadableArray O0000O0o;
    private Brush.BrushUnits O0000OOo;
    private Matrix O0000Oo = null;

    public bap(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "fx")
    public final void setFx(Dynamic dynamic) {
        this.f12751O000000o = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "fy")
    public final void setFy(Dynamic dynamic) {
        this.O00000Oo = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "rx")
    public final void setRx(Dynamic dynamic) {
        this.O00000o0 = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "ry")
    public final void setRy(Dynamic dynamic) {
        this.O00000o = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "cx")
    public final void setCx(Dynamic dynamic) {
        this.O00000oO = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "cy")
    public final void setCy(Dynamic dynamic) {
        this.O00000oo = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(name = "gradient")
    public final void setGradient(ReadableArray readableArray) {
        this.O0000O0o = readableArray;
        invalidate();
    }

    @ReactProp(name = "gradientUnits")
    public final void setGradientUnits(int i) {
        if (i == 0) {
            this.O0000OOo = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.O0000OOo = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "gradientTransform")
    public final void setGradientTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            int O000000o2 = bao.O000000o(readableArray, O0000Oo0, this.mScale);
            if (O000000o2 == 6) {
                if (this.O0000Oo == null) {
                    this.O0000Oo = new Matrix();
                }
                this.O0000Oo.setValues(O0000Oo0);
            } else if (O000000o2 != -1) {
                FLog.w("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.O0000Oo = null;
        }
        invalidate();
    }

    public final void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(Brush.BrushType.RADIAL_GRADIENT, new baq[]{this.f12751O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo}, this.O0000OOo);
            brush.O00000o0 = this.O0000O0o;
            Matrix matrix = this.O0000Oo;
            if (matrix != null) {
                brush.O00000oo = matrix;
            }
            SvgView svgView = getSvgView();
            if (this.O0000OOo == Brush.BrushUnits.USER_SPACE_ON_USE) {
                brush.O0000O0o = svgView.getCanvasBounds();
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}

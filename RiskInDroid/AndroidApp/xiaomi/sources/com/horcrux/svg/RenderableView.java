package com.horcrux.svg;

import _m_j.bao;
import _m_j.baq;
import _m_j.bar;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.Brush;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RenderableView extends VirtualView {
    private static final Pattern regex = Pattern.compile("[0-9.-]+");
    public ReadableArray fill;
    public float fillOpacity = 1.0f;
    public Path.FillType fillRule = Path.FillType.WINDING;
    private ArrayList<String> mAttributeList;
    private ArrayList<String> mLastMergedList;
    private ArrayList<Object> mOriginProperties;
    private ArrayList<String> mPropList;
    public ReadableArray stroke;
    public baq[] strokeDasharray;
    public float strokeDashoffset = 0.0f;
    public Paint.Cap strokeLinecap = Paint.Cap.ROUND;
    public Paint.Join strokeLinejoin = Paint.Join.ROUND;
    public float strokeMiterlimit = 4.0f;
    public float strokeOpacity = 1.0f;
    public baq strokeWidth = new baq(1.0d);
    public int vectorEffect = 0;

    private static double saturate(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        return d;
    }

    /* access modifiers changed from: package-private */
    public abstract Path getPath(Canvas canvas, Paint paint);

    RenderableView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "vectorEffect")
    public void setVectorEffect(int i) {
        this.vectorEffect = i;
        invalidate();
    }

    @ReactProp(name = "fill")
    public void setFill(Dynamic dynamic) {
        if (dynamic == null || dynamic.isNull()) {
            this.fill = null;
            invalidate();
            return;
        }
        if (dynamic.getType().equals(ReadableType.Array)) {
            this.fill = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            int i = 0;
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                double parseDouble = Double.parseDouble(matcher.group());
                int i2 = i + 1;
                if (i < 3) {
                    parseDouble /= 255.0d;
                }
                javaOnlyArray.pushDouble(parseDouble);
                i = i2;
            }
            this.fill = javaOnlyArray;
        }
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(float f) {
        this.fillOpacity = f;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(int i) {
        if (i == 0) {
            this.fillRule = Path.FillType.EVEN_ODD;
        } else if (i != 1) {
            throw new JSApplicationIllegalArgumentException("fillRule " + this.fillRule + " unrecognized");
        }
        invalidate();
    }

    @ReactProp(name = "stroke")
    public void setStroke(Dynamic dynamic) {
        if (dynamic == null || dynamic.isNull()) {
            this.stroke = null;
            invalidate();
            return;
        }
        if (dynamic.getType().equals(ReadableType.Array)) {
            this.stroke = dynamic.asArray();
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            javaOnlyArray.pushInt(0);
            Matcher matcher = regex.matcher(dynamic.asString());
            while (matcher.find()) {
                javaOnlyArray.pushDouble(Double.parseDouble(matcher.group()));
            }
            this.stroke = javaOnlyArray;
        }
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(float f) {
        this.strokeOpacity = f;
        invalidate();
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(ReadableArray readableArray) {
        if (readableArray != null) {
            int size = readableArray.size();
            this.strokeDasharray = new baq[size];
            for (int i = 0; i < size; i++) {
                this.strokeDasharray[i] = baq.O000000o(readableArray.getDynamic(i));
            }
        } else {
            this.strokeDasharray = null;
        }
        invalidate();
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(float f) {
        this.strokeDashoffset = f * this.mScale;
        invalidate();
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(Dynamic dynamic) {
        this.strokeWidth = baq.O000000o(dynamic);
        invalidate();
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(float f) {
        this.strokeMiterlimit = f;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(int i) {
        if (i == 0) {
            this.strokeLinecap = Paint.Cap.BUTT;
        } else if (i == 1) {
            this.strokeLinecap = Paint.Cap.ROUND;
        } else if (i == 2) {
            this.strokeLinecap = Paint.Cap.SQUARE;
        } else {
            throw new JSApplicationIllegalArgumentException("strokeLinecap " + this.strokeLinecap + " unrecognized");
        }
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(int i) {
        if (i == 0) {
            this.strokeLinejoin = Paint.Join.MITER;
        } else if (i == 1) {
            this.strokeLinejoin = Paint.Join.ROUND;
        } else if (i == 2) {
            this.strokeLinejoin = Paint.Join.BEVEL;
        } else {
            throw new JSApplicationIllegalArgumentException("strokeLinejoin " + this.strokeLinejoin + " unrecognized");
        }
        invalidate();
    }

    @ReactProp(name = "propList")
    public void setPropList(ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mAttributeList = arrayList;
            this.mPropList = arrayList;
            for (int i = 0; i < readableArray.size(); i++) {
                this.mPropList.add(readableArray.getString(i));
            }
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void render(Canvas canvas, Paint paint, float f) {
        Paint paint2 = paint;
        MaskView maskView = this.mMask != null ? (MaskView) getSvgView().getDefinedMask(this.mMask) : null;
        if (maskView != null) {
            Rect clipBounds = canvas.getClipBounds();
            int height = clipBounds.height();
            int width = clipBounds.width();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            Canvas canvas3 = new Canvas(createBitmap);
            Canvas canvas4 = new Canvas(createBitmap3);
            int i = width;
            canvas3.clipRect((float) relativeOnWidth(maskView.mX), (float) relativeOnWidth(maskView.mY), (float) relativeOnWidth(maskView.mW), (float) relativeOnWidth(maskView.mH));
            Paint paint3 = new Paint(1);
            maskView.draw(canvas3, paint3, 1.0f);
            int i2 = i * height;
            int[] iArr = new int[i2];
            Canvas canvas5 = canvas4;
            Canvas canvas6 = canvas2;
            Bitmap bitmap = createBitmap3;
            createBitmap.getPixels(iArr, 0, i, 0, 0, i, height);
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                Paint paint4 = paint3;
                double d = (double) ((i4 >> 16) & 255);
                Double.isNaN(d);
                double d2 = (double) ((i4 >> 8) & 255);
                Double.isNaN(d2);
                double d3 = (double) (i4 & 255);
                Double.isNaN(d3);
                double saturate = saturate((((d * 0.299d) + (d2 * 0.587d)) + (d3 * 0.144d)) / 255.0d);
                double d4 = (double) (i4 >>> 24);
                Double.isNaN(d4);
                iArr[i3] = ((int) (d4 * saturate)) << 24;
                i3++;
                i2 = i2;
                paint3 = paint4;
            }
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, height);
            draw(canvas6, paint2, f);
            Paint paint5 = paint3;
            paint5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            Canvas canvas7 = canvas5;
            canvas7.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            canvas7.drawBitmap(createBitmap, 0.0f, 0.0f, paint5);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint2);
            return;
        }
        draw(canvas, paint, f);
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.mOpacity;
        if (f2 > 0.01f) {
            boolean z = false;
            boolean z2 = this.mPath == null;
            if (z2) {
                this.mPath = getPath(canvas, paint);
                this.mPath.setFillType(this.fillRule);
            }
            if (this.vectorEffect == 1) {
                z = true;
            }
            Path path = this.mPath;
            if (z) {
                path = new Path();
                this.mPath.transform(canvas.getMatrix(), path);
                canvas.setMatrix(null);
            }
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            this.mBox = new RectF(rectF);
            new Matrix(canvas.getMatrix()).mapRect(rectF);
            setClientRect(rectF);
            clip(canvas, paint);
            if (setupFillPaint(paint, this.fillOpacity * f2)) {
                if (z2) {
                    this.mFillPath = new Path();
                    paint.getFillPath(path, this.mFillPath);
                }
                canvas.drawPath(path, paint);
            }
            if (setupStrokePaint(paint, f2 * this.strokeOpacity)) {
                if (z2) {
                    this.mStrokePath = new Path();
                    paint.getFillPath(path, this.mStrokePath);
                }
                canvas.drawPath(path, paint);
            }
        }
    }

    private boolean setupFillPaint(Paint paint, float f) {
        ReadableArray readableArray = this.fill;
        if (readableArray == null || readableArray.size() <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(385);
        paint.setStyle(Paint.Style.FILL);
        setupPaint(paint, f, this.fill);
        return true;
    }

    private boolean setupStrokePaint(Paint paint, float f) {
        ReadableArray readableArray;
        paint.reset();
        double relativeOnOther = relativeOnOther(this.strokeWidth);
        if (relativeOnOther == 0.0d || (readableArray = this.stroke) == null || readableArray.size() == 0) {
            return false;
        }
        paint.setFlags(385);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.strokeLinecap);
        paint.setStrokeJoin(this.strokeLinejoin);
        paint.setStrokeMiter(this.strokeMiterlimit * this.mScale);
        paint.setStrokeWidth((float) relativeOnOther);
        setupPaint(paint, f, this.stroke);
        baq[] baqArr = this.strokeDasharray;
        if (baqArr == null) {
            return true;
        }
        int length = baqArr.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) relativeOnOther(this.strokeDasharray[i]);
        }
        paint.setPathEffect(new DashPathEffect(fArr, this.strokeDashoffset));
        return true;
    }

    private void setupPaint(Paint paint, float f, ReadableArray readableArray) {
        double d;
        float f2;
        float f3;
        Paint paint2 = paint;
        float f4 = f;
        ReadableArray readableArray2 = readableArray;
        int i = readableArray2.getInt(0);
        if (i == 0) {
            Paint paint3 = paint2;
            if (readableArray.size() == 2) {
                int i2 = readableArray2.getInt(1);
                paint3.setColor((i2 & 16777215) | (Math.round(((float) (i2 >>> 24)) * f4) << 24));
                return;
            }
            if (readableArray.size() > 4) {
                double d2 = readableArray2.getDouble(4);
                double d3 = (double) f4;
                Double.isNaN(d3);
                d = d2 * d3 * 255.0d;
            } else {
                d = (double) (255.0f * f4);
            }
            paint3.setARGB((int) d, (int) (readableArray2.getDouble(1) * 255.0d), (int) (readableArray2.getDouble(2) * 255.0d), (int) (readableArray2.getDouble(3) * 255.0d));
        } else if (i == 1) {
            Brush definedBrush = getSvgView().getDefinedBrush(readableArray2.getString(1));
            if (definedBrush != null) {
                RectF rectF = this.mBox;
                float f5 = this.mScale;
                if (!definedBrush.O00000o) {
                    rectF = new RectF(definedBrush.O0000O0o);
                }
                float width = rectF.width();
                float height = rectF.height();
                if (definedBrush.O00000o) {
                    f2 = rectF.left;
                    f3 = rectF.top;
                } else {
                    f3 = 0.0f;
                    f2 = 0.0f;
                }
                RectF rectF2 = new RectF(f2, f3, width + f2, height + f3);
                float width2 = rectF2.width();
                float height2 = rectF2.height();
                float f6 = rectF2.left;
                float f7 = rectF2.top;
                float textSize = paint.getTextSize();
                if (definedBrush.f4385O000000o == Brush.BrushType.PATTERN) {
                    double d4 = (double) width2;
                    float f8 = textSize;
                    float f9 = height2;
                    float f10 = f5;
                    double O000000o2 = definedBrush.O000000o(definedBrush.O00000Oo[0], d4, f5, f8);
                    double d5 = (double) f9;
                    double d6 = d5;
                    double d7 = O000000o2;
                    double O000000o3 = definedBrush.O000000o(definedBrush.O00000Oo[1], d5, f10, f8);
                    double d8 = d4;
                    double d9 = O000000o3;
                    double O000000o4 = definedBrush.O000000o(definedBrush.O00000Oo[2], d8, f10, f8);
                    double d10 = d6;
                    float f11 = width2;
                    float f12 = f9;
                    double d11 = O000000o4;
                    double O000000o5 = definedBrush.O000000o(definedBrush.O00000Oo[3], d10, f10, f8);
                    if (d11 > 1.0d && O000000o5 > 1.0d) {
                        Bitmap createBitmap = Bitmap.createBitmap((int) d11, (int) O000000o5, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        RectF viewBox = definedBrush.O0000OOo.getViewBox();
                        if (viewBox != null && viewBox.width() > 0.0f && viewBox.height() > 0.0f) {
                            canvas.concat(bar.O000000o(viewBox, new RectF((float) d7, (float) d9, (float) d11, (float) O000000o5), definedBrush.O0000OOo.mAlign, definedBrush.O0000OOo.mMeetOrSlice));
                        }
                        if (definedBrush.O00000oO) {
                            float f13 = f10;
                            canvas.scale(f11 / f13, f12 / f13);
                        }
                        definedBrush.O0000OOo.draw(canvas, new Paint(), f4);
                        Matrix matrix = new Matrix();
                        if (definedBrush.O00000oo != null) {
                            matrix.preConcat(definedBrush.O00000oo);
                        }
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
                        bitmapShader.setLocalMatrix(matrix);
                        paint.setShader(bitmapShader);
                        return;
                    }
                    return;
                }
                float f14 = width2;
                float f15 = height2;
                float f16 = f5;
                float f17 = textSize;
                int size = definedBrush.O00000o0.size() / 2;
                int[] iArr = new int[size];
                float[] fArr = new float[size];
                Brush.O000000o(definedBrush.O00000o0, size, fArr, iArr, f4);
                if (size == 1) {
                    int[] iArr2 = {iArr[0], iArr[0]};
                    float[] fArr2 = {fArr[0], fArr[0]};
                    FLog.w("ReactNative", "Gradient contains only on stop");
                    iArr = iArr2;
                    fArr = fArr2;
                }
                if (definedBrush.f4385O000000o == Brush.BrushType.LINEAR_GRADIENT) {
                    double d12 = (double) f14;
                    double d13 = (double) f6;
                    double d14 = (double) f16;
                    double d15 = (double) f17;
                    double O000000o6 = bao.O000000o(definedBrush.O00000Oo[0], d12, d13, d14, d15);
                    double d16 = (double) f15;
                    double d17 = (double) f7;
                    double d18 = d14;
                    double d19 = d15;
                    double d20 = O000000o6;
                    double O000000o7 = bao.O000000o(definedBrush.O00000Oo[1], d16, d17, d18, d19);
                    LinearGradient linearGradient = new LinearGradient((float) d20, (float) O000000o7, (float) bao.O000000o(definedBrush.O00000Oo[2], d12, d13, d18, d19), (float) bao.O000000o(definedBrush.O00000Oo[3], d16, d17, d18, d19), iArr, fArr, Shader.TileMode.CLAMP);
                    if (definedBrush.O00000oo != null) {
                        Matrix matrix2 = new Matrix();
                        matrix2.preConcat(definedBrush.O00000oo);
                        linearGradient.setLocalMatrix(matrix2);
                    }
                    paint.setShader(linearGradient);
                    return;
                }
                float f18 = f14;
                int[] iArr3 = iArr;
                float f19 = f15;
                if (definedBrush.f4385O000000o == Brush.BrushType.RADIAL_GRADIENT) {
                    double d21 = (double) f18;
                    double d22 = (double) f16;
                    double d23 = (double) f17;
                    double O000000o8 = bao.O000000o(definedBrush.O00000Oo[2], d21, 0.0d, d22, d23);
                    double d24 = (double) f19;
                    double d25 = d22;
                    double d26 = d23;
                    double O000000o9 = bao.O000000o(definedBrush.O00000Oo[3], d24, 0.0d, d25, d26);
                    double d27 = O000000o9 / O000000o8;
                    RadialGradient radialGradient = new RadialGradient((float) bao.O000000o(definedBrush.O00000Oo[4], d21, (double) f6, d22, d23), (float) (bao.O000000o(definedBrush.O00000Oo[5], d24, (double) f7, d25, d26) / d27), (float) O000000o8, iArr3, fArr, Shader.TileMode.CLAMP);
                    Matrix matrix3 = new Matrix();
                    matrix3.preScale(1.0f, (float) d27);
                    if (definedBrush.O00000oo != null) {
                        matrix3.preConcat(definedBrush.O00000oo);
                    }
                    radialGradient.setLocalMatrix(matrix3);
                    paint.setShader(radialGradient);
                }
            }
        } else if (i == 2) {
            paint2.setColor(getSvgView().mTintColor);
        }
    }

    /* access modifiers changed from: package-private */
    public int hitTest(float[] fArr) {
        if (this.mPath != null && this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            if (this.mRegion == null && this.mFillPath != null) {
                this.mRegion = getRegion(this.mFillPath);
            }
            if (this.mRegion == null && this.mPath != null) {
                this.mRegion = getRegion(this.mPath);
            }
            if (this.mStrokeRegion == null && this.mStrokePath != null) {
                this.mStrokeRegion = getRegion(this.mStrokePath);
            }
            if ((this.mRegion != null && this.mRegion.contains(round, round2)) || (this.mStrokeRegion != null && this.mStrokeRegion.contains(round, round2))) {
                Path clipPath = getClipPath();
                if (clipPath != null) {
                    if (this.mClipRegionPath != clipPath) {
                        this.mClipRegionPath = clipPath;
                        this.mClipRegion = getRegion(clipPath);
                    }
                    if (!this.mClipRegion.contains(round, round2)) {
                        return -1;
                    }
                }
                return getId();
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Region getRegion(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        Region region = new Region();
        region.setPath(path, new Region((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom)));
        return region;
    }

    private ArrayList<String> getAttributeList() {
        return this.mAttributeList;
    }

    /* access modifiers changed from: package-private */
    public void mergeProperties(RenderableView renderableView) {
        ArrayList<String> attributeList = renderableView.getAttributeList();
        if (attributeList != null && attributeList.size() != 0) {
            this.mOriginProperties = new ArrayList<>();
            ArrayList<String> arrayList = this.mPropList;
            this.mAttributeList = arrayList == null ? new ArrayList<>() : new ArrayList<>(arrayList);
            int i = 0;
            int size = attributeList.size();
            while (i < size) {
                try {
                    String str = attributeList.get(i);
                    Field field = getClass().getField(str);
                    Object obj = field.get(renderableView);
                    this.mOriginProperties.add(field.get(this));
                    if (!hasOwnProperty(str)) {
                        this.mAttributeList.add(str);
                        field.set(this, obj);
                    }
                    i++;
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
            this.mLastMergedList = attributeList;
        }
    }

    /* access modifiers changed from: package-private */
    public void resetProperties() {
        ArrayList<String> arrayList = this.mLastMergedList;
        if (arrayList != null && this.mOriginProperties != null) {
            try {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    getClass().getField(this.mLastMergedList.get(size)).set(this, this.mOriginProperties.get(size));
                }
                this.mLastMergedList = null;
                this.mOriginProperties = null;
                this.mAttributeList = this.mPropList;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private boolean hasOwnProperty(String str) {
        ArrayList<String> arrayList = this.mAttributeList;
        return arrayList != null && arrayList.contains(str);
    }
}

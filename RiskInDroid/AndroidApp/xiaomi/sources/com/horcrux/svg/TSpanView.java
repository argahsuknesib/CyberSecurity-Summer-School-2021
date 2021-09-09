package com.horcrux.svg;

import _m_j.bak;
import _m_j.bal;
import _m_j.bam;
import _m_j.bao;
import _m_j.baq;
import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SuppressLint({"ViewConstructor"})
class TSpanView extends TextView {
    private final ArrayList<String> emoji = new ArrayList<>();
    private final ArrayList<Matrix> emojiTransforms = new ArrayList<>();
    private Path mCachedPath;
    String mContent;
    private TextPathView textPath;

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "content")
    public void setContent(String str) {
        this.mContent = str;
        invalidate();
    }

    public void invalidate() {
        this.mCachedPath = null;
        super.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.mCachedPath = null;
        super.clearCache();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent != null) {
            int size = this.emoji.size();
            if (size > 0) {
                applyTextPropertiesToPaint(paint, getTextRootGlyphContext().O0000oO0);
                for (int i = 0; i < size; i++) {
                    canvas.save();
                    canvas.concat(this.emojiTransforms.get(i));
                    canvas.drawText(this.emoji.get(i), 0.0f, 0.0f, paint);
                    canvas.restore();
                }
            }
            drawPath(canvas, paint, f);
            return;
        }
        clip(canvas, paint);
        drawGroup(canvas, paint, f);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mCachedPath;
        if (path != null) {
            return path;
        }
        if (this.mContent == null) {
            this.mCachedPath = getGroupPath(canvas, paint);
            return this.mCachedPath;
        }
        setupTextPath();
        pushGlyphContext();
        this.mCachedPath = getLinePath(this.mContent, paint, canvas);
        popGlyphContext();
        return this.mCachedPath;
    }

    /* access modifiers changed from: package-private */
    public double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        String str = this.mContent;
        int i = 0;
        double d = 0.0d;
        if (str == null) {
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    d += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
                }
                i++;
            }
            this.cachedAdvance = d;
            return d;
        } else if (str.length() == 0) {
            this.cachedAdvance = 0.0d;
            return 0.0d;
        } else {
            bak bak = getTextRootGlyphContext().O0000oO0;
            applyTextPropertiesToPaint(paint, bak);
            double d2 = bak.O0000OoO;
            if (d2 == 0.0d && bak.O0000O0o == TextProperties.FontVariantLigatures.normal) {
                i = 1;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                String str2 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk'," + "'kern', ";
                if (i != 0) {
                    paint.setFontFeatureSettings(str2 + "'hlig', 'cala', " + bak.O00000oo);
                } else {
                    paint.setFontFeatureSettings(str2 + "'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + bak.O00000oo);
                }
                double d3 = bak.f12745O000000o;
                double d4 = (double) this.mScale;
                Double.isNaN(d4);
                paint.setLetterSpacing((float) (d2 / (d3 * d4)));
            }
            this.cachedAdvance = (double) paint.measureText(str);
            return this.cachedAdvance;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0363  */
    private Path getLinePath(String str, Paint paint, Canvas canvas) {
        double d;
        boolean z;
        PathMeasure pathMeasure;
        PathMeasure pathMeasure2;
        bal bal;
        bam bam;
        ReadableMap readableMap;
        boolean[] zArr;
        double d2;
        double d3;
        boolean z2;
        int i;
        double d4;
        double d5;
        Paint paint2;
        double d6;
        double d7;
        double d8;
        int i2;
        boolean z3;
        String str2;
        String str3;
        char c;
        int i3;
        bal bal2;
        double d9;
        float[] fArr;
        Matrix matrix;
        Matrix matrix2;
        PathMeasure pathMeasure3;
        int i4;
        double d10;
        double d11;
        bal bal3;
        int i5;
        Paint paint3;
        TSpanView tSpanView;
        double d12;
        Path path;
        int i6;
        bam bam2;
        double d13;
        bal bal4;
        PathMeasure pathMeasure4;
        double d14;
        double d15;
        Path path2;
        Path path3;
        boolean z4;
        String str4;
        int i7;
        char c2;
        Path path4;
        int i8;
        int i9;
        char c3;
        Paint paint4;
        double d16;
        TSpanView tSpanView2 = this;
        Paint paint5 = paint;
        Canvas canvas2 = canvas;
        int length = str.length();
        Path path5 = new Path();
        tSpanView2.emoji.clear();
        tSpanView2.emojiTransforms.clear();
        if (length == 0) {
            return path5;
        }
        boolean z5 = tSpanView2.textPath != null;
        if (z5) {
            PathMeasure pathMeasure5 = new PathMeasure(tSpanView2.textPath.getTextPath(canvas2, paint5), false);
            double length2 = (double) pathMeasure5.getLength();
            boolean isClosed = pathMeasure5.isClosed();
            if (length2 == 0.0d) {
                return path5;
            }
            pathMeasure = pathMeasure5;
            d = length2;
            z = isClosed;
        } else {
            pathMeasure = null;
            d = 0.0d;
            z = false;
        }
        bal textRootGlyphContext = getTextRootGlyphContext();
        bak bak = textRootGlyphContext.O0000oO0;
        tSpanView2.applyTextPropertiesToPaint(paint5, bak);
        bam bam3 = new bam(paint5);
        boolean[] zArr2 = new boolean[length];
        char[] charArray = str.toCharArray();
        Path path6 = path5;
        double d17 = bak.O0000Oo0;
        double d18 = bak.O0000Oo;
        double d19 = bak.O0000OoO;
        boolean z6 = !bak.O0000Ooo;
        boolean z7 = d19 == 0.0d && bak.O0000O0o == TextProperties.FontVariantLigatures.normal;
        bam bam4 = bam3;
        if (Build.VERSION.SDK_INT >= 21) {
            String str5 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk'," + "'kern', ";
            if (z7) {
                paint5.setFontFeatureSettings(str5 + "'hlig', 'cala', " + bak.O00000oo);
            } else {
                paint5.setFontFeatureSettings(str5 + "'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + bak.O00000oo);
            }
        }
        ReadableMap readableMap2 = bak.O00000o;
        float[] fArr2 = new float[length];
        paint5.getTextWidths(str, fArr2);
        TextProperties.TextAnchor textAnchor = bak.O0000OOo;
        float[] fArr3 = fArr2;
        double d20 = d19;
        double subtreeTextChunksTotalAdvance = getTextAnchorRoot().getSubtreeTextChunksTotalAdvance(paint5);
        double textAnchorOffset = tSpanView2.getTextAnchorOffset(textAnchor, subtreeTextChunksTotalAdvance);
        tSpanView2.applyTextPropertiesToPaint(paint5, bak);
        double d21 = textRootGlyphContext.O0000o;
        if (z5) {
            boolean z8 = tSpanView2.textPath.getMidLine() == TextProperties.TextPathMidLine.sharp;
            int i10 = tSpanView2.textPath.getSide() == TextProperties.TextPathSide.right ? -1 : 1;
            readableMap = readableMap2;
            TextProperties.TextAnchor textAnchor2 = textAnchor;
            bam = bam4;
            zArr = zArr2;
            pathMeasure2 = pathMeasure;
            bal = textRootGlyphContext;
            double absoluteStartOffset = getAbsoluteStartOffset(tSpanView2.textPath.getStartOffset(), d, d21);
            textAnchorOffset += absoluteStartOffset;
            if (z) {
                double d22 = absoluteStartOffset + (textAnchor2 == TextProperties.TextAnchor.middle ? -(d / 2.0d) : 0.0d);
                d3 = d22 + d;
                d2 = d22;
            } else {
                d3 = d;
                d2 = 0.0d;
            }
            z2 = z8;
            i = i10;
        } else {
            pathMeasure2 = pathMeasure;
            bal = textRootGlyphContext;
            readableMap = readableMap2;
            bam = bam4;
            zArr = zArr2;
            d3 = d;
            d2 = 0.0d;
            i = 1;
            z2 = false;
        }
        double d23 = 1.0d;
        if (tSpanView2.mTextLength != null) {
            d5 = d;
            d4 = d2;
            double O000000o2 = bao.O000000o(tSpanView2.mTextLength, (double) canvas.getWidth(), 0.0d, (double) tSpanView2.mScale, d21);
            if (O000000o2 < 0.0d) {
                throw new IllegalArgumentException("Negative textLength value");
            } else if (AnonymousClass1.f4395O000000o[tSpanView2.mLengthAdjust.ordinal()] != 2) {
                double d24 = (double) (length - 1);
                Double.isNaN(d24);
                d20 += (O000000o2 - subtreeTextChunksTotalAdvance) / d24;
            } else {
                d23 = O000000o2 / subtreeTextChunksTotalAdvance;
            }
        } else {
            d4 = d2;
            d5 = d;
        }
        double d25 = (double) i;
        Double.isNaN(d25);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        double d26 = (double) fontMetrics.descent;
        double d27 = d21;
        double d28 = (double) fontMetrics.leading;
        Double.isNaN(d26);
        Double.isNaN(d28);
        double d29 = d28 + d26;
        int i11 = i;
        double d30 = d23 * d25;
        double d31 = (double) ((-fontMetrics.ascent) + fontMetrics.leading);
        boolean z9 = z2;
        double d32 = (double) (-fontMetrics.top);
        Double.isNaN(d32);
        double d33 = d32 + d29;
        String baselineShift = getBaselineShift();
        TextProperties.AlignmentBaseline alignmentBaseline = getAlignmentBaseline();
        if (alignmentBaseline != null) {
            switch (AnonymousClass1.O00000Oo[alignmentBaseline.ordinal()]) {
                case 2:
                case 3:
                case 4:
                    paint4 = paint;
                    d6 = d27;
                    Double.isNaN(d26);
                    d32 = -d26;
                    break;
                case 6:
                    paint4 = paint;
                    d6 = d27;
                    Double.isNaN(d26);
                    d32 = -d26;
                    break;
                case 7:
                    Rect rect = new Rect();
                    paint2 = paint;
                    d6 = d27;
                    paint2.getTextBounds("x", 0, 1, rect);
                    double height = (double) rect.height();
                    Double.isNaN(height);
                    d32 = height / 2.0d;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    Double.isNaN(d31);
                    Double.isNaN(d26);
                    d32 = (d31 - d26) / 2.0d;
                    paint2 = paint;
                    d6 = d27;
                    break;
                case 9:
                    d16 = 0.5d;
                    Double.isNaN(d31);
                    d32 = d16 * d31;
                    paint2 = paint;
                    d6 = d27;
                    break;
                case 10:
                    d16 = 0.8d;
                    Double.isNaN(d31);
                    d32 = d16 * d31;
                    paint2 = paint;
                    d6 = d27;
                    break;
                case 11:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                    paint2 = paint;
                    d32 = d31;
                    d6 = d27;
                    break;
                case 14:
                    d32 = d29;
                    d6 = d27;
                    paint2 = paint;
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    d32 = d33 / 2.0d;
                    paint2 = paint;
                    d6 = d27;
                    break;
                case 16:
                    paint2 = paint;
                    d6 = d27;
                    break;
            }
            if (baselineShift != null || baselineShift.isEmpty() || (i9 = AnonymousClass1.O00000Oo[alignmentBaseline.ordinal()]) == 14 || i9 == 16) {
                d7 = d3;
            } else {
                int hashCode = baselineShift.hashCode();
                if (hashCode != -1720785339) {
                    if (hashCode != 114240) {
                        if (hashCode == 109801339 && baselineShift.equals("super")) {
                            c3 = 1;
                            if (c3 == 0) {
                                d7 = d3;
                                if (c3 != 1) {
                                    if (c3 != 2) {
                                        double d34 = (double) tSpanView2.mScale;
                                        Double.isNaN(d34);
                                        d32 -= bao.O000000o(baselineShift, d34 * d6, (double) tSpanView2.mScale, d6);
                                    }
                                } else if (readableMap != null) {
                                    ReadableMap readableMap3 = readableMap;
                                    if (readableMap3.hasKey("tables") && readableMap3.hasKey("unitsPerEm")) {
                                        int i12 = readableMap3.getInt("unitsPerEm");
                                        ReadableMap map = readableMap3.getMap("tables");
                                        if (map.hasKey("os2")) {
                                            ReadableMap map2 = map.getMap("os2");
                                            if (map2.hasKey("ySuperscriptYOffset")) {
                                                double d35 = map2.getDouble("ySuperscriptYOffset");
                                                d8 = d25;
                                                double d36 = (double) tSpanView2.mScale;
                                                Double.isNaN(d36);
                                                double d37 = (double) i12;
                                                Double.isNaN(d37);
                                                d32 -= ((d36 * d6) * d35) / d37;
                                            }
                                        }
                                    }
                                }
                            } else {
                                d7 = d3;
                                d8 = d25;
                                ReadableMap readableMap4 = readableMap;
                                if (readableMap4 != null && readableMap4.hasKey("tables") && readableMap4.hasKey("unitsPerEm")) {
                                    int i13 = readableMap4.getInt("unitsPerEm");
                                    ReadableMap map3 = readableMap4.getMap("tables");
                                    if (map3.hasKey("os2")) {
                                        ReadableMap map4 = map3.getMap("os2");
                                        if (map4.hasKey("ySubscriptYOffset")) {
                                            double d38 = map4.getDouble("ySubscriptYOffset");
                                            double d39 = (double) tSpanView2.mScale;
                                            Double.isNaN(d39);
                                            double d40 = (double) i13;
                                            Double.isNaN(d40);
                                            d32 += ((d39 * d6) * d38) / d40;
                                        }
                                    }
                                }
                            }
                            Matrix matrix3 = new Matrix();
                            Matrix matrix4 = new Matrix();
                            Matrix matrix5 = new Matrix();
                            float[] fArr4 = new float[9];
                            float[] fArr5 = new float[9];
                            i2 = 0;
                            while (i2 < length) {
                                char c4 = charArray[i2];
                                String valueOf = String.valueOf(c4);
                                boolean z10 = zArr[i2];
                                float f = 0.0f;
                                if (z10) {
                                    str2 = "";
                                    z3 = false;
                                } else {
                                    String str6 = valueOf;
                                    int i14 = i2;
                                    boolean z11 = true;
                                    z3 = false;
                                    while (true) {
                                        i14++;
                                        if (i14 >= length || fArr3[i14] > f) {
                                            str2 = str6;
                                        } else {
                                            str6 = str6 + charArray[i14];
                                            zArr[i14] = z11;
                                            f = 0.0f;
                                            z11 = true;
                                            z3 = true;
                                        }
                                    }
                                    str2 = str6;
                                }
                                int i15 = length;
                                double measureText = (double) paint2.measureText(str2);
                                Double.isNaN(measureText);
                                double d41 = measureText * d23;
                                if (z6) {
                                    str3 = str2;
                                    double d42 = (double) fArr3[i2];
                                    Double.isNaN(d42);
                                    d17 = (d42 * d23) - d41;
                                } else {
                                    str3 = str2;
                                }
                                boolean z12 = c4 == ' ';
                                double d43 = (z12 ? d18 : 0.0d) + d20 + d41;
                                if (z10) {
                                    c = c4;
                                    i3 = i2;
                                    d9 = 0.0d;
                                    bal2 = bal;
                                } else {
                                    c = c4;
                                    i3 = i2;
                                    bal2 = bal;
                                    d9 = d17 + d43;
                                }
                                double O000000o3 = bal2.O000000o(d9);
                                double d44 = d32;
                                double O00000Oo = bal2.O00000Oo();
                                double O00000o0 = bal2.O00000o0();
                                double O00000o = bal2.O00000o();
                                double d45 = O00000Oo;
                                double O00000oO = bal2.O00000oO();
                                if (z10 || z12) {
                                    tSpanView = this;
                                    paint3 = paint;
                                    matrix2 = matrix5;
                                    i5 = i15;
                                    i4 = i3;
                                    i6 = i11;
                                    bam2 = bam;
                                    pathMeasure3 = pathMeasure2;
                                    d10 = d5;
                                    matrix = matrix3;
                                    fArr = fArr5;
                                    path = path6;
                                    d12 = d18;
                                    d11 = d30;
                                    bal3 = bal2;
                                } else {
                                    Double.isNaN(d8);
                                    Double.isNaN(d8);
                                    double d46 = d41 * d8;
                                    Double.isNaN(d8);
                                    double d47 = (textAnchorOffset + ((O000000o3 + O00000o0) * d8)) - (d43 * d8);
                                    if (z5) {
                                        double d48 = d47 + d46;
                                        double d49 = d46 / 2.0d;
                                        double d50 = d47 + d49;
                                        if (d50 > d7 || d50 < d4) {
                                            matrix2 = matrix5;
                                            bal bal5 = bal2;
                                            i6 = i11;
                                            PathMeasure pathMeasure6 = pathMeasure2;
                                            double d51 = d5;
                                            matrix = matrix3;
                                            fArr = fArr5;
                                            d10 = d51;
                                            path = path6;
                                            d12 = d18;
                                            i5 = i15;
                                            i4 = i3;
                                            bam2 = bam;
                                            bal3 = bal5;
                                            d11 = d30;
                                            tSpanView = this;
                                            paint3 = paint;
                                            pathMeasure3 = pathMeasure6;
                                        } else {
                                            bal4 = bal2;
                                            if (z9) {
                                                PathMeasure pathMeasure7 = pathMeasure2;
                                                pathMeasure7.getMatrix((float) d50, matrix4, 3);
                                                d13 = O00000oO;
                                                matrix = matrix3;
                                                matrix2 = matrix5;
                                                pathMeasure4 = pathMeasure7;
                                                d14 = d5;
                                                fArr = fArr5;
                                            } else {
                                                pathMeasure4 = pathMeasure2;
                                                if (d47 < 0.0d) {
                                                    d13 = O00000oO;
                                                    pathMeasure4.getMatrix(0.0f, matrix3, 3);
                                                    matrix3.preTranslate((float) d47, 0.0f);
                                                    i8 = 1;
                                                } else {
                                                    d13 = O00000oO;
                                                    i8 = 1;
                                                    pathMeasure4.getMatrix((float) d47, matrix3, 1);
                                                }
                                                pathMeasure4.getMatrix((float) d50, matrix4, i8);
                                                if (d48 > d5) {
                                                    d14 = d5;
                                                    pathMeasure4.getMatrix((float) d14, matrix5, 3);
                                                    matrix5.preTranslate((float) (d48 - d14), 0.0f);
                                                } else {
                                                    d14 = d5;
                                                    pathMeasure4.getMatrix((float) d48, matrix5, i8);
                                                }
                                                matrix3.getValues(fArr4);
                                                matrix5.getValues(fArr5);
                                                double d52 = (double) fArr4[2];
                                                double d53 = (double) fArr4[5];
                                                double d54 = (double) fArr5[2];
                                                matrix = matrix3;
                                                matrix2 = matrix5;
                                                fArr = fArr5;
                                                double d55 = (double) fArr5[5];
                                                Double.isNaN(d54);
                                                Double.isNaN(d52);
                                                Double.isNaN(d55);
                                                Double.isNaN(d53);
                                                Double.isNaN(d8);
                                                matrix4.preRotate((float) (Math.atan2(d55 - d53, d54 - d52) * 57.29577951308232d * d8));
                                            }
                                            matrix4.preTranslate((float) (-d49), (float) (O00000o + d44));
                                            d15 = d30;
                                            i6 = i11;
                                            matrix4.preScale((float) d15, (float) i6);
                                            matrix4.postTranslate(0.0f, (float) d45);
                                        }
                                    } else {
                                        d13 = O00000oO;
                                        matrix2 = matrix5;
                                        bal4 = bal2;
                                        i6 = i11;
                                        pathMeasure4 = pathMeasure2;
                                        d14 = d5;
                                        matrix = matrix3;
                                        fArr = fArr5;
                                        d15 = d30;
                                        matrix4.setTranslate((float) d47, (float) (d45 + O00000o + d44));
                                    }
                                    matrix4.preRotate((float) d13);
                                    if (z3) {
                                        Path path7 = new Path();
                                        d10 = d14;
                                        String str7 = str3;
                                        int length3 = str3.length();
                                        str4 = str3;
                                        z4 = true;
                                        double d56 = d15;
                                        d12 = d18;
                                        d11 = d56;
                                        Path path8 = path6;
                                        i4 = i3;
                                        bal3 = bal4;
                                        pathMeasure3 = pathMeasure4;
                                        path2 = path8;
                                        i5 = i15;
                                        paint.getTextPath(str7, 0, length3, 0.0f, 0.0f, path7);
                                        path3 = path7;
                                        bam2 = bam;
                                    } else {
                                        d10 = d14;
                                        path2 = path6;
                                        i5 = i15;
                                        str4 = str3;
                                        i4 = i3;
                                        bam2 = bam;
                                        bal3 = bal4;
                                        z4 = true;
                                        pathMeasure3 = pathMeasure4;
                                        double d57 = d15;
                                        d12 = d18;
                                        d11 = d57;
                                        int i16 = c >> 8;
                                        int[] iArr = bam2.O00000Oo[i16];
                                        if (iArr == null) {
                                            c2 = c;
                                            i7 = 0;
                                        } else {
                                            c2 = c;
                                            i7 = iArr[c2 & 255];
                                        }
                                        if (i7 != 0) {
                                            path4 = bam2.f12747O000000o.get(i7);
                                        } else {
                                            path4 = new Path();
                                            bam2.O00000o0.getTextPath(str4, 0, 1, 0.0f, 0.0f, path4);
                                            int[] iArr2 = bam2.O00000Oo[i16];
                                            if (iArr2 == null) {
                                                int[] iArr3 = new int[256];
                                                bam2.O00000Oo[i16] = iArr3;
                                                iArr2 = iArr3;
                                            }
                                            iArr2[c2 & 255] = bam2.f12747O000000o.size();
                                            bam2.f12747O000000o.add(path4);
                                        }
                                        path3 = new Path();
                                        path3.addPath(path4);
                                    }
                                    RectF rectF = new RectF();
                                    path3.computeBounds(rectF, z4);
                                    if (rectF.width() == 0.0f) {
                                        canvas.save();
                                        Canvas canvas3 = canvas;
                                        canvas3.concat(matrix4);
                                        tSpanView = this;
                                        tSpanView.emoji.add(str4);
                                        tSpanView.emojiTransforms.add(new Matrix(matrix4));
                                        paint3 = paint;
                                        canvas3.drawText(str4, 0.0f, 0.0f, paint3);
                                        canvas.restore();
                                        path = path2;
                                    } else {
                                        tSpanView = this;
                                        paint3 = paint;
                                        path3.transform(matrix4);
                                        path = path2;
                                        path.addPath(path3);
                                    }
                                }
                                i2 = i4 + 1;
                                bam = bam2;
                                i11 = i6;
                                tSpanView2 = tSpanView;
                                length = i5;
                                bal = bal3;
                                d30 = d11;
                                d32 = d44;
                                path6 = path;
                                d18 = d12;
                                paint2 = paint3;
                                matrix5 = matrix2;
                                matrix3 = matrix;
                                fArr5 = fArr;
                                d5 = d10;
                                pathMeasure2 = pathMeasure3;
                            }
                            return path6;
                        }
                    } else if (baselineShift.equals("sub")) {
                        c3 = 0;
                        if (c3 == 0) {
                        }
                        Matrix matrix32 = new Matrix();
                        Matrix matrix42 = new Matrix();
                        Matrix matrix52 = new Matrix();
                        float[] fArr42 = new float[9];
                        float[] fArr52 = new float[9];
                        i2 = 0;
                        while (i2 < length) {
                        }
                        return path6;
                    }
                } else if (baselineShift.equals("baseline")) {
                    c3 = 2;
                    if (c3 == 0) {
                    }
                    Matrix matrix322 = new Matrix();
                    Matrix matrix422 = new Matrix();
                    Matrix matrix522 = new Matrix();
                    float[] fArr422 = new float[9];
                    float[] fArr522 = new float[9];
                    i2 = 0;
                    while (i2 < length) {
                    }
                    return path6;
                }
                c3 = 65535;
                if (c3 == 0) {
                }
                Matrix matrix3222 = new Matrix();
                Matrix matrix4222 = new Matrix();
                Matrix matrix5222 = new Matrix();
                float[] fArr4222 = new float[9];
                float[] fArr5222 = new float[9];
                i2 = 0;
                while (i2 < length) {
                }
                return path6;
            }
            d8 = d25;
            Matrix matrix32222 = new Matrix();
            Matrix matrix42222 = new Matrix();
            Matrix matrix52222 = new Matrix();
            float[] fArr42222 = new float[9];
            float[] fArr52222 = new float[9];
            i2 = 0;
            while (i2 < length) {
            }
            return path6;
        }
        paint2 = paint;
        d6 = d27;
        d32 = 0.0d;
        if (baselineShift != null) {
        }
        d7 = d3;
        d8 = d25;
        Matrix matrix322222 = new Matrix();
        Matrix matrix422222 = new Matrix();
        Matrix matrix522222 = new Matrix();
        float[] fArr422222 = new float[9];
        float[] fArr522222 = new float[9];
        i2 = 0;
        while (i2 < length) {
        }
        return path6;
    }

    private double getAbsoluteStartOffset(baq baq, double d, double d2) {
        return bao.O000000o(baq, d, 0.0d, (double) this.mScale, d2);
    }

    /* renamed from: com.horcrux.svg.TSpanView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f4395O000000o = new int[TextProperties.TextLengthAdjust.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[TextProperties.AlignmentBaseline.values().length];
        static final /* synthetic */ int[] O00000o0 = new int[TextProperties.TextAnchor.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|52) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00fc */
        static {
            try {
                O00000o0[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000o0[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000o0[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            O00000Oo[TextProperties.AlignmentBaseline.baseline.ordinal()] = 1;
            O00000Oo[TextProperties.AlignmentBaseline.textBottom.ordinal()] = 2;
            O00000Oo[TextProperties.AlignmentBaseline.afterEdge.ordinal()] = 3;
            O00000Oo[TextProperties.AlignmentBaseline.textAfterEdge.ordinal()] = 4;
            O00000Oo[TextProperties.AlignmentBaseline.alphabetic.ordinal()] = 5;
            O00000Oo[TextProperties.AlignmentBaseline.ideographic.ordinal()] = 6;
            O00000Oo[TextProperties.AlignmentBaseline.middle.ordinal()] = 7;
            O00000Oo[TextProperties.AlignmentBaseline.central.ordinal()] = 8;
            O00000Oo[TextProperties.AlignmentBaseline.mathematical.ordinal()] = 9;
            O00000Oo[TextProperties.AlignmentBaseline.hanging.ordinal()] = 10;
            O00000Oo[TextProperties.AlignmentBaseline.textTop.ordinal()] = 11;
            O00000Oo[TextProperties.AlignmentBaseline.beforeEdge.ordinal()] = 12;
            O00000Oo[TextProperties.AlignmentBaseline.textBeforeEdge.ordinal()] = 13;
            O00000Oo[TextProperties.AlignmentBaseline.bottom.ordinal()] = 14;
            O00000Oo[TextProperties.AlignmentBaseline.center.ordinal()] = 15;
            try {
                O00000Oo[TextProperties.AlignmentBaseline.top.ordinal()] = 16;
            } catch (NoSuchFieldError unused4) {
            }
            f4395O000000o[TextProperties.TextLengthAdjust.spacing.ordinal()] = 1;
            try {
                f4395O000000o[TextProperties.TextLengthAdjust.spacingAndGlyphs.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private double getTextAnchorOffset(TextProperties.TextAnchor textAnchor, double d) {
        int i = AnonymousClass1.O00000o0[textAnchor.ordinal()];
        if (i == 2) {
            return (-d) / 2.0d;
        }
        if (i != 3) {
            return 0.0d;
        }
        return -d;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4 = android.graphics.Typeface.createFromAsset(r1, "fonts/" + r11 + ".ttf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4 = com.facebook.react.views.text.ReactFontManager.getInstance().getTypeface(r11, r6, r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0051 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0067 */
    private void applyTextPropertiesToPaint(Paint paint, bak bak) {
        AssetManager assets = this.mContext.getResources().getAssets();
        double d = bak.f12745O000000o;
        double d2 = (double) this.mScale;
        Double.isNaN(d2);
        double d3 = d * d2;
        int i = 1;
        boolean z = bak.O00000oO == TextProperties.FontWeight.Bold;
        boolean z2 = bak.O00000o0 == TextProperties.FontStyle.italic;
        if (z && z2) {
            i = 3;
        } else if (!z) {
            i = z2 ? 2 : 0;
        }
        Typeface typeface = null;
        String str = bak.O00000Oo;
        typeface = Typeface.createFromAsset(assets, "fonts/" + str + ".otf");
        paint.setTypeface(typeface);
        paint.setTextSize((float) d3);
        paint.setTextAlign(Paint.Align.LEFT);
        if (Build.VERSION.SDK_INT >= 21) {
            paint.setLetterSpacing(0.0f);
        }
    }

    private void setupTextPath() {
        ViewParent parent = getParent();
        while (parent != null) {
            if (parent.getClass() == TextPathView.class) {
                this.textPath = (TextPathView) parent;
                return;
            } else if (parent instanceof TextView) {
                parent = parent.getParent();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int hitTest(float[] fArr) {
        if (this.mContent == null) {
            return super.hitTest(fArr);
        }
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
}

package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextLayer extends BaseLayer {
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter = new HashMap();
    private final Paint fillPaint = new Paint(1) {
        /* class com.airbnb.lottie.model.layer.TextLayer.AnonymousClass1 */

        {
            setStyle(Paint.Style.FILL);
        }
    };
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix = new Matrix();
    private final RectF rectF = new RectF();
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private final Paint strokePaint = new Paint(1) {
        /* class com.airbnb.lottie.model.layer.TextLayer.AnonymousClass2 */

        {
            setStyle(Paint.Style.STROKE);
        }
    };
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private final char[] tempCharArray = new char[1];
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;

    TextLayer(LottieDrawable lottieDrawable2, Layer layer) {
        super(lottieDrawable2, layer);
        this.lottieDrawable = lottieDrawable2;
        this.composition = layer.getComposition();
        this.textAnimation = layer.getText().createAnimation();
        this.textAnimation.addUpdateListener(this);
        addAnimation(this.textAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (!(textProperties == null || textProperties.color == null)) {
            this.colorAnimation = textProperties.color.createAnimation();
            this.colorAnimation.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (!(textProperties == null || textProperties.stroke == null)) {
            this.strokeColorAnimation = textProperties.stroke.createAnimation();
            this.strokeColorAnimation.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (!(textProperties == null || textProperties.strokeWidth == null)) {
            this.strokeWidthAnimation = textProperties.strokeWidth.createAnimation();
            this.strokeWidthAnimation.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties != null && textProperties.tracking != null) {
            this.trackingAnimation = textProperties.tracking.createAnimation();
            this.trackingAnimation.addUpdateListener(this);
            addAnimation(this.trackingAnimation);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix matrix2, int i) {
        canvas.save();
        if (!this.lottieDrawable.useTextGlyphs()) {
            canvas.setMatrix(matrix2);
        }
        DocumentData documentData = (DocumentData) this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(documentData.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorAnimation;
        if (baseKeyframeAnimation != null) {
            this.fillPaint.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            this.fillPaint.setColor(documentData.color);
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorAnimation;
        if (baseKeyframeAnimation2 != null) {
            this.strokePaint.setColor(baseKeyframeAnimation2.getValue().intValue());
        } else {
            this.strokePaint.setColor(documentData.strokeColor);
        }
        int intValue = (this.transform.getOpacity().getValue().intValue() * 255) / 100;
        this.fillPaint.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthAnimation;
        if (baseKeyframeAnimation3 != null) {
            this.strokePaint.setStrokeWidth(baseKeyframeAnimation3.getValue().floatValue());
        } else {
            float scale = Utils.getScale(matrix2);
            Paint paint = this.strokePaint;
            double d = documentData.strokeWidth;
            double dpScale = (double) Utils.dpScale();
            Double.isNaN(dpScale);
            double d2 = d * dpScale;
            double d3 = (double) scale;
            Double.isNaN(d3);
            paint.setStrokeWidth((float) (d2 * d3));
        }
        if (this.lottieDrawable.useTextGlyphs()) {
            drawTextGlyphs(documentData, matrix2, font, canvas);
        } else {
            drawTextWithFont(documentData, font, matrix2, canvas);
        }
        canvas.restore();
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix2, Font font, Canvas canvas) {
        float f = ((float) documentData.size) / 100.0f;
        float scale = Utils.getScale(matrix2);
        String str = documentData.text;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter O000000o2 = this.composition.getCharacters().O000000o(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()), null);
            if (O000000o2 != null) {
                drawCharacterAsGlyph(O000000o2, matrix2, f, documentData, canvas);
                float width = ((float) O000000o2.getWidth()) * f * Utils.dpScale() * scale;
                float f2 = ((float) documentData.tracking) / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
                if (baseKeyframeAnimation != null) {
                    f2 += baseKeyframeAnimation.getValue().floatValue();
                }
                canvas.translate(width + (f2 * scale), 0.0f);
            }
        }
    }

    private void drawTextWithFont(DocumentData documentData, Font font, Matrix matrix2, Canvas canvas) {
        float scale = Utils.getScale(matrix2);
        Typeface typeface = this.lottieDrawable.getTypeface(font.getFamily(), font.getStyle());
        if (typeface != null) {
            String str = documentData.text;
            TextDelegate textDelegate = this.lottieDrawable.getTextDelegate();
            if (textDelegate != null) {
                str = textDelegate.getTextInternal(str);
            }
            this.fillPaint.setTypeface(typeface);
            Paint paint = this.fillPaint;
            double d = documentData.size;
            double dpScale = (double) Utils.dpScale();
            Double.isNaN(dpScale);
            paint.setTextSize((float) (d * dpScale));
            this.strokePaint.setTypeface(this.fillPaint.getTypeface());
            this.strokePaint.setTextSize(this.fillPaint.getTextSize());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                drawCharacterFromFont(charAt, documentData, canvas);
                char[] cArr = this.tempCharArray;
                cArr[0] = charAt;
                float measureText = this.fillPaint.measureText(cArr, 0, 1);
                float f = ((float) documentData.tracking) / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
                if (baseKeyframeAnimation != null) {
                    f += baseKeyframeAnimation.getValue().floatValue();
                }
                canvas.translate(measureText + (f * scale), 0.0f);
            }
        }
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, Matrix matrix2, float f, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> contentsForCharacter2 = getContentsForCharacter(fontCharacter);
        for (int i = 0; i < contentsForCharacter2.size(); i++) {
            Path path = contentsForCharacter2.get(i).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(matrix2);
            this.matrix.preTranslate(0.0f, ((float) (-documentData.baselineShift)) * Utils.dpScale());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas);
                drawGlyph(path, this.strokePaint, canvas);
            } else {
                drawGlyph(path, this.strokePaint, canvas);
                drawGlyph(path, this.fillPaint, canvas);
            }
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void drawCharacterFromFont(char c, DocumentData documentData, Canvas canvas) {
        this.tempCharArray[0] = c;
        if (documentData.strokeOverFill) {
            drawCharacter(this.tempCharArray, this.fillPaint, canvas);
            drawCharacter(this.tempCharArray, this.strokePaint, canvas);
            return;
        }
        drawCharacter(this.tempCharArray, this.strokePaint, canvas);
        drawCharacter(this.tempCharArray, this.fillPaint, canvas);
    }

    private void drawCharacter(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey(fontCharacter)) {
            return this.contentsForCharacter.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i)));
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4;
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR && (baseKeyframeAnimation4 = this.colorAnimation) != null) {
            baseKeyframeAnimation4.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.STROKE_COLOR && (baseKeyframeAnimation3 = this.strokeColorAnimation) != null) {
            baseKeyframeAnimation3.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.STROKE_WIDTH && (baseKeyframeAnimation2 = this.strokeWidthAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.TEXT_TRACKING && (baseKeyframeAnimation = this.trackingAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        }
    }
}

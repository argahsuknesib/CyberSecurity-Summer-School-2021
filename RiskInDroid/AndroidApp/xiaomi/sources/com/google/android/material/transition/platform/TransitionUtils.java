package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

class TransitionUtils {
    private static final RectF transformAlphaRectF = new RectF();

    interface CanvasOperation {
        void run(Canvas canvas);
    }

    interface CornerSizeBinaryOperator {
        CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2);
    }

    static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    private TransitionUtils() {
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() {
            /* class com.google.android.material.transition.platform.TransitionUtils.AnonymousClass1 */

            public final CornerSize apply(CornerSize cornerSize) {
                if (cornerSize instanceof RelativeCornerSize) {
                    return cornerSize;
                }
                return new RelativeCornerSize(cornerSize.getCornerSize(rectF) / rectF.height());
            }
        });
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (isShapeAppearanceSignificant(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) ? false : true;
    }

    static float lerp(float f, float f2, float f3, float f4, float f5) {
        return lerp(f, f2, f3, f4, f5, false);
    }

    static float lerp(float f, float f2, float f3, float f4, float f5, boolean z) {
        if (z && (f5 < 0.0f || f5 > 1.0f)) {
            return lerp(f, f2, f5);
        }
        if (f5 < f3) {
            return f;
        }
        if (f5 > f4) {
            return f2;
        }
        return lerp(f, f2, (f5 - f3) / (f4 - f3));
    }

    static int lerp(int i, int i2, float f, float f2, float f3) {
        if (f3 < f) {
            return i;
        }
        return f3 > f2 ? i2 : (int) lerp((float) i, (float) i2, (f3 - f) / (f2 - f));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, float f, float f2, float f3) {
        if (f3 < f) {
            return shapeAppearanceModel;
        }
        if (f3 > f2) {
            return shapeAppearanceModel2;
        }
        final RectF rectF3 = rectF;
        final RectF rectF4 = rectF2;
        final float f4 = f;
        final float f5 = f2;
        final float f6 = f3;
        return transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() {
            /* class com.google.android.material.transition.platform.TransitionUtils.AnonymousClass2 */

            public final CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF3), cornerSize2.getCornerSize(rectF4), f4, f5, f6));
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
     arg types: [int, int, int, int, int, int, android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void} */
    static Shader createColorShader(int i) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, Shader.TileMode.CLAMP);
    }

    static View findDescendantOrAncestorById(View view, int i) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        return findAncestorById(view, i);
    }

    static View findAncestorById(View view, int i) {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static RectF getRelativeBounds(View view) {
        return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
    }

    static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new RectF((float) i, (float) i2, (float) (view.getWidth() + i), (float) (view.getHeight() + i2));
    }

    static float calculateArea(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i) {
        transformAlphaRectF.set(rect);
        if (Build.VERSION.SDK_INT >= 21) {
            return canvas.saveLayerAlpha(transformAlphaRectF, i);
        }
        return canvas.saveLayerAlpha(transformAlphaRectF.left, transformAlphaRectF.top, transformAlphaRectF.right, transformAlphaRectF.bottom, i, 31);
    }

    static void transform(Canvas canvas, Rect rect, float f, float f2, float f3, int i, CanvasOperation canvasOperation) {
        if (i > 0) {
            int save = canvas.save();
            canvas.translate(f, f2);
            canvas.scale(f3, f3);
            if (i < 255) {
                saveLayerAlphaCompat(canvas, rect, i);
            }
            canvasOperation.run(canvas);
            canvas.restoreToCount(save);
        }
    }

    static void maybeAddTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static void maybeRemoveTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }
}

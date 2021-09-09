package androidx.transition;

import _m_j.Cif;
import _m_j.ig;
import _m_j.ir;
import _m_j.is;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f3003O000000o = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> O00000Oo = new TypeEvaluator<Matrix>() {
        /* class androidx.transition.ChangeImageTransform.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> O00000o0 = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        /* class androidx.transition.ChangeImageTransform.AnonymousClass2 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            Cif.O000000o((ImageView) obj, (Matrix) obj2);
        }
    };

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void O000000o(is isVar) {
        Matrix matrix;
        View view = isVar.O00000Oo;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = isVar.f1596O000000o;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                Drawable drawable = imageView.getDrawable();
                if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                    int i = AnonymousClass3.f3004O000000o[imageView.getScaleType().ordinal()];
                    if (i == 1) {
                        Drawable drawable2 = imageView.getDrawable();
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(((float) imageView.getWidth()) / ((float) drawable2.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable2.getIntrinsicHeight()));
                        matrix = matrix2;
                    } else if (i == 2) {
                        Drawable drawable3 = imageView.getDrawable();
                        int intrinsicWidth = drawable3.getIntrinsicWidth();
                        float width = (float) imageView.getWidth();
                        float f = (float) intrinsicWidth;
                        int intrinsicHeight = drawable3.getIntrinsicHeight();
                        float height = (float) imageView.getHeight();
                        float f2 = (float) intrinsicHeight;
                        float max = Math.max(width / f, height / f2);
                        int round = Math.round((width - (f * max)) / 2.0f);
                        int round2 = Math.round((height - (f2 * max)) / 2.0f);
                        Matrix matrix3 = new Matrix();
                        matrix3.postScale(max, max);
                        matrix3.postTranslate((float) round, (float) round2);
                        matrix = matrix3;
                    }
                    map.put("android:changeImageTransform:matrix", matrix);
                }
                matrix = new Matrix(imageView.getImageMatrix());
                map.put("android:changeImageTransform:matrix", matrix);
            }
        }
    }

    public void captureStartValues(is isVar) {
        O000000o(isVar);
    }

    public void captureEndValues(is isVar) {
        O000000o(isVar);
    }

    public String[] getTransitionProperties() {
        return f3003O000000o;
    }

    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        if (isVar == null || isVar2 == null) {
            return null;
        }
        Rect rect = (Rect) isVar.f1596O000000o.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) isVar2.f1596O000000o.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) isVar.f1596O000000o.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) isVar2.f1596O000000o.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) isVar2.O00000Oo;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return ObjectAnimator.ofObject(imageView, O00000o0, O00000Oo, ig.f1264O000000o, ig.f1264O000000o);
        }
        if (matrix == null) {
            matrix = ig.f1264O000000o;
        }
        if (matrix2 == null) {
            matrix2 = ig.f1264O000000o;
        }
        O00000o0.set(imageView, matrix);
        return ObjectAnimator.ofObject(imageView, O00000o0, new ir.O000000o(), matrix, matrix2);
    }

    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f3004O000000o = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f3004O000000o[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            f3004O000000o[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        }
    }
}

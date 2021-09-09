package _m_j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public final class ir {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final boolean f1574O000000o = (Build.VERSION.SDK_INT >= 19);
    private static final boolean O00000Oo = (Build.VERSION.SDK_INT >= 18);
    private static final boolean O00000o0;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 28) {
            z = false;
        }
        O00000o0 = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0103  */
    public static View O000000o(ViewGroup viewGroup, View view, View view2) {
        boolean z;
        boolean z2;
        Bitmap bitmap;
        int i;
        ViewGroup viewGroup2;
        int round;
        int round2;
        ViewGroup viewGroup3 = viewGroup;
        View view3 = view;
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        jd.O000000o(view3, matrix);
        jd.O00000Oo(viewGroup3, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round3 = Math.round(rectF.left);
        int round4 = Math.round(rectF.top);
        int round5 = Math.round(rectF.right);
        int round6 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (f1574O000000o) {
            z2 = !view.isAttachedToWindow();
            if (viewGroup3 != null) {
                z = viewGroup.isAttachedToWindow();
                bitmap = null;
                if (O00000Oo || !z2) {
                    viewGroup2 = null;
                    i = 0;
                } else {
                    if (z) {
                        viewGroup2 = (ViewGroup) view.getParent();
                        i = viewGroup2.indexOfChild(view3);
                        viewGroup.getOverlay().add(view3);
                    }
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                    imageView.measure(View.MeasureSpec.makeMeasureSpec(round5 - round3, 1073741824), View.MeasureSpec.makeMeasureSpec(round6 - round4, 1073741824));
                    imageView.layout(round3, round4, round5, round6);
                    return imageView;
                }
                round = Math.round(rectF.width());
                round2 = Math.round(rectF.height());
                if (round > 0 && round2 > 0) {
                    float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
                    int round7 = Math.round(((float) round) * min);
                    int round8 = Math.round(((float) round2) * min);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    matrix.postScale(min, min);
                    if (!O00000o0) {
                        Picture picture = new Picture();
                        Canvas beginRecording = picture.beginRecording(round7, round8);
                        beginRecording.concat(matrix);
                        view3.draw(beginRecording);
                        picture.endRecording();
                        bitmap = Bitmap.createBitmap(picture);
                    } else {
                        bitmap = Bitmap.createBitmap(round7, round8, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.concat(matrix);
                        view3.draw(canvas);
                    }
                }
                if (O00000Oo && z2) {
                    viewGroup.getOverlay().remove(view3);
                    viewGroup2.addView(view3, i);
                }
                if (bitmap != null) {
                }
                imageView.measure(View.MeasureSpec.makeMeasureSpec(round5 - round3, 1073741824), View.MeasureSpec.makeMeasureSpec(round6 - round4, 1073741824));
                imageView.layout(round3, round4, round5, round6);
                return imageView;
            }
        } else {
            z2 = false;
        }
        z = false;
        bitmap = null;
        if (O00000Oo) {
        }
        viewGroup2 = null;
        i = 0;
        round = Math.round(rectF.width());
        round2 = Math.round(rectF.height());
        float min2 = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
        int round72 = Math.round(((float) round) * min2);
        int round82 = Math.round(((float) round2) * min2);
        matrix.postTranslate(-rectF.left, -rectF.top);
        matrix.postScale(min2, min2);
        if (!O00000o0) {
        }
        viewGroup.getOverlay().remove(view3);
        viewGroup2.addView(view3, i);
        if (bitmap != null) {
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round5 - round3, 1073741824), View.MeasureSpec.makeMeasureSpec(round6 - round4, 1073741824));
        imageView.layout(round3, round4, round5, round6);
        return imageView;
    }

    public static Animator O000000o(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }

    public static class O000000o implements TypeEvaluator<Matrix> {

        /* renamed from: O000000o  reason: collision with root package name */
        final float[] f1575O000000o = new float[9];
        final float[] O00000Oo = new float[9];
        final Matrix O00000o0 = new Matrix();

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            ((Matrix) obj).getValues(this.f1575O000000o);
            ((Matrix) obj2).getValues(this.O00000Oo);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.O00000Oo;
                float f2 = fArr[i];
                float[] fArr2 = this.f1575O000000o;
                fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
            }
            this.O00000o0.setValues(this.O00000Oo);
            return this.O00000o0;
        }
    }
}

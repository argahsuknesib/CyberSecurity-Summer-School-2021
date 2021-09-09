package _m_j;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class jj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Method f1872O000000o;
    private static boolean O00000Oo;
    private static boolean O00000o;
    private static Field O00000o0;
    private float[] O00000oO;

    jj() {
    }

    public void O000000o(View view, float f) {
        Float f2 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public float O000000o(View view) {
        Float f = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    public void O00000Oo(View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void O00000o0(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    public void O000000o(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            O000000o(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void O00000Oo(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            O00000Oo(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }

    public void O00000o0(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.O00000oO;
        if (fArr == null) {
            fArr = new float[9];
            this.O00000oO = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float sqrt = ((float) Math.sqrt((double) (1.0f - (f * f)))) * ((float) (fArr[0] < 0.0f ? -1 : 1));
        float degrees = (float) Math.toDegrees(Math.atan2((double) f, (double) sqrt));
        float f2 = fArr[0] / sqrt;
        float f3 = fArr[4] / sqrt;
        float f4 = fArr[2];
        float f5 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f4);
        view.setTranslationY(f5);
        view.setRotation(degrees);
        view.setScaleX(f2);
        view.setScaleY(f3);
    }

    public void O000000o(View view, int i) {
        if (!O00000o) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                O00000o0 = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            O00000o = true;
        }
        Field field = O00000o0;
        if (field != null) {
            try {
                O00000o0.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void O000000o(View view, int i, int i2, int i3, int i4) {
        if (!O00000Oo) {
            Class<View> cls = View.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                f1872O000000o = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e);
            }
            O00000Oo = true;
        }
        Method method = f1872O000000o;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}

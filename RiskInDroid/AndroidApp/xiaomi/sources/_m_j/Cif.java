package _m_j;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* renamed from: _m_j.if  reason: invalid class name */
public final class Cif {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1252O000000o = true;
    private static Field O00000Oo;
    private static boolean O00000o0;

    public static void O000000o(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
        } else if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                Matrix matrix2 = null;
                if (!O00000o0) {
                    try {
                        Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                        O00000Oo = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused) {
                    }
                    O00000o0 = true;
                }
                Field field = O00000Oo;
                if (field != null) {
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                matrix2 = new Matrix();
                                O00000Oo.set(imageView, matrix2);
                            } catch (IllegalAccessException unused2) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException unused3) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
                imageView.invalidate();
            }
        } else if (f1252O000000o) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused4) {
                f1252O000000o = false;
            }
        }
    }
}

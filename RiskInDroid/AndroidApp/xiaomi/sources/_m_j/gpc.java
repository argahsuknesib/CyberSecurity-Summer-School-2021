package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.xiaomi.smarthome.application.CommonApplication;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class gpc {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f18114O000000o = "gpc";

    public static Point O000000o(Context context) {
        if (context == null) {
            return new Point();
        }
        Point point = new Point();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        return point;
    }

    public static int O000000o(Activity activity, float f) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) ((f * displayMetrics.density) + 0.5f);
    }

    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int O00000Oo(Context context, float f) {
        double d = (double) f;
        double d2 = (double) context.getResources().getDisplayMetrics().scaledDensity;
        Double.isNaN(d);
        Double.isNaN(d2);
        return (int) ((d * d2) + 0.5d);
    }

    public static int O00000Oo(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int O000000o() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int O00000o0(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int O000000o(float f) {
        return O00000o0(CommonApplication.getAppContext(), f);
    }

    public static int O00000o(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int O00000Oo(float f) {
        return O00000o(CommonApplication.getAppContext(), f);
    }

    public static Bitmap O000000o(Bitmap bitmap) {
        int[] iArr;
        int i = 0;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.5f), Math.round(((float) bitmap.getHeight()) * 0.5f), false);
        Bitmap copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[Math.max(width, height)];
        int[] iArr7 = new int[65536];
        for (int i5 = 0; i5 < 65536; i5++) {
            iArr7[i5] = i5 / 256;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, 31, 3);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i6 >= height) {
                break;
            }
            int i9 = -15;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 15; i9 <= i19; i19 = 15) {
                int i20 = iArr2[i7 + Math.min(i3, Math.max(i9, i))];
                int[] iArr9 = iArr8[i9 + 15];
                iArr9[i] = (i20 & 16711680) >> 16;
                iArr9[1] = (i20 & 65280) >> 8;
                iArr9[2] = i20 & 255;
                int abs = 16 - Math.abs(i9);
                i10 += iArr9[i] * abs;
                i11 += iArr9[1] * abs;
                i12 += iArr9[2] * abs;
                if (i9 > 0) {
                    i16 += iArr9[i];
                    i17 += iArr9[1];
                    i18 += iArr9[2];
                } else {
                    i13 += iArr9[i];
                    i14 += iArr9[1];
                    i15 += iArr9[2];
                }
                i9++;
            }
            int i21 = 0;
            int i22 = 15;
            while (i21 < width) {
                iArr3[i7] = iArr7[i10];
                iArr4[i7] = iArr7[i11];
                iArr5[i7] = iArr7[i12];
                int i23 = i10 - i13;
                int i24 = i11 - i14;
                int i25 = i12 - i15;
                int[] iArr10 = iArr8[((i22 - 15) + 31) % 31];
                int i26 = i13 - iArr10[i];
                int i27 = i14 - iArr10[1];
                int i28 = i15 - iArr10[2];
                if (i6 == 0) {
                    iArr6[i21] = Math.min(i21 + 15 + 1, i3);
                }
                int i29 = iArr2[i8 + iArr6[i21]];
                iArr10[0] = (i29 & 16711680) >> 16;
                iArr10[1] = (i29 & 65280) >> 8;
                iArr10[2] = i29 & 255;
                int i30 = i16 + iArr10[0];
                int i31 = i17 + iArr10[1];
                int i32 = i18 + iArr10[2];
                i10 = i23 + i30;
                i11 = i24 + i31;
                i12 = i25 + i32;
                i22 = (i22 + 1) % 31;
                int[] iArr11 = iArr8[i22 % 31];
                i13 = i26 + iArr11[0];
                i14 = i27 + iArr11[1];
                i15 = i28 + iArr11[2];
                i16 = i30 - iArr11[0];
                i17 = i31 - iArr11[1];
                i18 = i32 - iArr11[2];
                i7++;
                i21++;
                i = 0;
            }
            i8 += width;
            i6++;
            i = 0;
        }
        int i33 = 0;
        while (i33 < width) {
            Bitmap bitmap2 = copy;
            int i34 = width * -15;
            int i35 = -15;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            for (int i45 = 15; i35 <= i45; i45 = 15) {
                int max = Math.max(0, i34) + i33;
                int[] iArr12 = iArr8[i35 + 15];
                iArr12[0] = iArr3[max];
                iArr12[1] = iArr4[max];
                iArr12[2] = iArr5[max];
                int abs2 = 16 - Math.abs(i35);
                i36 += iArr3[max] * abs2;
                i37 += iArr4[max] * abs2;
                i38 += iArr5[max] * abs2;
                if (i35 > 0) {
                    i42 += iArr12[0];
                    i43 += iArr12[1];
                    i44 += iArr12[2];
                } else {
                    i39 += iArr12[0];
                    i40 += iArr12[1];
                    i41 += iArr12[2];
                }
                if (i35 < i4) {
                    i34 += width;
                }
                i35++;
            }
            int i46 = i33;
            int i47 = 0;
            int i48 = 15;
            while (i47 < height) {
                iArr2[i46] = (iArr2[i46] & -16777216) | (iArr7[i36] << 16) | (iArr7[i37] << 8) | iArr7[i38];
                int i49 = i36 - i39;
                int i50 = i37 - i40;
                int i51 = i38 - i41;
                int[] iArr13 = iArr8[((i48 - 15) + 31) % 31];
                int i52 = i39 - iArr13[0];
                int i53 = i40 - iArr13[1];
                int i54 = i41 - iArr13[2];
                if (i33 == 0) {
                    iArr = iArr7;
                    iArr6[i47] = Math.min(i47 + 16, i4) * width;
                } else {
                    iArr = iArr7;
                }
                int i55 = iArr6[i47] + i33;
                iArr13[0] = iArr3[i55];
                iArr13[1] = iArr4[i55];
                iArr13[2] = iArr5[i55];
                int i56 = i42 + iArr13[0];
                int i57 = i43 + iArr13[1];
                int i58 = i44 + iArr13[2];
                i36 = i49 + i56;
                i37 = i50 + i57;
                i38 = i51 + i58;
                i48 = (i48 + 1) % 31;
                int[] iArr14 = iArr8[i48];
                i39 = i52 + iArr14[0];
                i40 = i53 + iArr14[1];
                i41 = i54 + iArr14[2];
                i42 = i56 - iArr14[0];
                i43 = i57 - iArr14[1];
                i44 = i58 - iArr14[2];
                i46 += width;
                i47++;
                iArr7 = iArr;
            }
            i33++;
            copy = bitmap2;
            iArr7 = iArr7;
        }
        Bitmap bitmap3 = copy;
        bitmap3.setPixels(iArr2, 0, width, 0, 0, width, height);
        return bitmap3;
    }

    public static void O000000o(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(100);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class _m_j.gpc.AnonymousClass1 */

                public final void onAnimationEnd(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            if (i == 4 || i == 8) {
                view.setVisibility(i);
            } else {
                view.setVisibility(8);
            }
            view.startAnimation(alphaAnimation);
        }
    }

    public static void O000000o(View view) {
        if (view != null && view.getVisibility() != 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class _m_j.gpc.AnonymousClass2 */

                public final void onAnimationEnd(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            view.setVisibility(0);
            view.startAnimation(alphaAnimation);
        }
    }

    private static boolean O00000oo(Context context) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(context)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean O00000o0(Context context) {
        boolean z;
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                obtainStyledAttributes.recycle();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    public static void O00000o(Context context) {
        if (Build.VERSION.SDK_INT == 26 && O00000o0(context)) {
            O00000oo(context);
        }
    }

    public static int O00000oO(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}

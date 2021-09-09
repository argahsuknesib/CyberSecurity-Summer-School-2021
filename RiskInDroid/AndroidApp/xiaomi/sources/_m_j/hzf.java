package _m_j;

import _m_j.gpx;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import miuix.view.HapticCompat;

public final class hzf {
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: O000000o  reason: collision with root package name */
    public static final View.OnTouchListener f1010O000000o = $$Lambda$hzf$rDVGqIY4i6a_5CTx4Dp7xNyno.INSTANCE;
    private static int O00000Oo = -1;

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O000000o(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (HapticCompat.performHapticFeedback(view, izf.O00000o0)) {
                return false;
            }
            view.performHapticFeedback(3);
            return false;
        } else if (motionEvent.getAction() != 1 || HapticCompat.performHapticFeedback(view, izf.O00000Oo)) {
            return false;
        } else {
            view.performHapticFeedback(7);
            return false;
        }
    }

    public static void O000000o(View view) {
        if (!HapticCompat.performHapticFeedback(view, izf.O00000Oo)) {
            view.performHapticFeedback(16);
        }
    }

    public static void O00000Oo(View view) {
        if (!HapticCompat.performHapticFeedback(view, izf.O00000oo)) {
            view.performHapticFeedback(4);
        }
    }

    public static boolean O00000o0(View view) {
        return view.isHapticFeedbackEnabled();
    }

    public static void O00000o(View view) {
        if (!HapticCompat.performHapticFeedback(view, izf.O0000Oo0)) {
            view.performHapticFeedback(3);
        }
    }

    public static void O00000oO(View view) {
        if (!HapticCompat.performHapticFeedback(view, izf.O00000Oo)) {
            view.performHapticFeedback(6);
        }
    }

    public static void O00000oo(View view) {
        view.setOnTouchListener(f1010O000000o);
    }

    public static void O000000o(CompoundButton compoundButton) {
        if (!HapticCompat.performHapticFeedback(compoundButton, izf.O00000oO)) {
            compoundButton.performHapticFeedback(compoundButton.isChecked() ? 3 : 7);
        }
    }

    public static void O0000O0o(View view) {
        if (!HapticCompat.performHapticFeedback(view, 16)) {
            view.performHapticFeedback(16);
        }
    }

    public static void O000000o(Activity activity) {
        try {
            O0000o00(activity.getWindow().getDecorView().findViewById(16908290));
        } catch (Exception e) {
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
        }
    }

    public static void O00000Oo(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            gpx.O000000o(inputMethodManager, "windowDismissed", new gpx.O000000o(activity.getWindow().getDecorView().getWindowToken(), IBinder.class));
            gpx.O000000o(inputMethodManager, "startGettingWindowFocus", new gpx.O000000o(null, View.class));
            String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 3; i++) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj != null && (obj instanceof View)) {
                        if (((View) obj).getContext() == activity) {
                            declaredField.set(inputMethodManager, null);
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static void O0000o00(View view) {
        if (view == null || view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
            return;
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        } else if (view instanceof WebView) {
            WebView webView = (WebView) view;
            webView.setTag(null);
            webView.stopLoading();
            webView.clearHistory();
            try {
                webView.removeAllViews();
            } catch (Exception unused) {
            }
            webView.clearView();
            try {
                ((ViewGroup) webView.getParent()).removeView(webView);
            } catch (Exception unused2) {
            }
            webView.destroy();
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                O0000o00(viewGroup.getChildAt(i));
            }
            try {
                viewGroup.removeAllViews();
            } catch (Exception unused3) {
            }
        }
    }

    public static RectF O0000OOo(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight()));
    }

    public static int O000000o(Context context) {
        int i = O00000Oo;
        if (i != -1) {
            return i;
        }
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                O00000Oo = resources.getDimensionPixelSize(identifier);
            }
        } catch (Exception unused) {
        }
        if (O00000Oo == -1) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                O00000Oo = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception unused2) {
            }
        }
        if (O00000Oo == -1) {
            O00000Oo = context.getResources().getDimensionPixelSize(R.dimen.title_bar_top_padding);
        }
        return O00000Oo;
    }

    private static String O000000o() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void O000000o(View view, RectF rectF, RectF rectF2) {
        View view2 = view;
        if (view2 != null && rectF != null) {
            AnimationSet animationSet = new AnimationSet(true);
            float max = Math.max(rectF.height() / rectF2.height(), rectF.width() / rectF2.width());
            animationSet.addAnimation(new ScaleAnimation(max, 1.0f, max, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0, rectF.centerX() - rectF2.centerX(), 0, 0.0f, 0, rectF.centerY() - rectF2.centerY(), 0, 0.0f));
            animationSet.setDuration(300);
            animationSet.setFillAfter(true);
            view2.startAnimation(animationSet);
        }
    }

    public static void O000000o(View view, RectF rectF, RectF rectF2, Runnable runnable) {
        View view2 = view;
        Runnable runnable2 = runnable;
        if (view2 != null && rectF != null) {
            AnimationSet animationSet = new AnimationSet(true);
            float max = Math.max(rectF.height() / rectF2.height(), rectF.width() / rectF2.width());
            animationSet.addAnimation(new ScaleAnimation(1.0f, max, 1.0f, max, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0, 0.0f, 0, rectF.centerX() - rectF2.centerX(), 0, 0.0f, 0, rectF.centerY() - rectF2.centerY()));
            animationSet.setDuration(300);
            animationSet.setFillAfter(true);
            view2.startAnimation(animationSet);
            view2.postDelayed(runnable2, 250);
        } else if (runnable2 != null) {
            runnable.run();
        }
    }

    public static void O0000Oo0(View view) {
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void O0000Oo(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
        view.setVisibility(4);
    }

    public static int O000000o(Context context, int i, int i2) {
        DisplayMetrics displayMetrics = CommonApplication.getAppContext().getResources().getDisplayMetrics();
        int i3 = context.getResources().getConfiguration().orientation;
        int i4 = displayMetrics.widthPixels;
        float f = context.getResources().getDisplayMetrics().density;
        return (int) ((((float) i4) - (30.0f * f)) / (((float) (i + i2)) * f));
    }

    public static void O0000OoO(View view) {
        if (!HapticCompat.performHapticFeedback(view, izf.O0000o0O)) {
            view.performHapticFeedback(7);
        }
    }

    public static void O0000Ooo(View view) {
        if (!HapticCompat.performHapticFeedback(view, izf.O0000o00)) {
            view.performHapticFeedback(3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (android.view.ViewConfiguration.get(r6).hasPermanentMenuKey() == false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    public static int O00000Oo(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = true;
        if (identifier != 0) {
            boolean z2 = resources.getBoolean(identifier);
            String O000000o2 = O000000o();
            if (!"1".equals(O000000o2)) {
                if (!"0".equals(O000000o2)) {
                    z = z2;
                }
                if (z) {
                    return 0;
                }
                Resources resources2 = context.getResources();
                return resources2.getDimensionPixelSize(resources2.getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        }
        z = false;
        if (z) {
        }
    }
}

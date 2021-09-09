package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.widget.CardFrameLayout;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.utils.ApplicationThemeWrap;
import com.xiaomi.smarthome.utils.DialogBase;
import java.lang.reflect.Method;
import java.util.List;

public final class hyy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1004O000000o = false;
    public static float O00000Oo = 1.0f;
    private static final int O00000o = View.generateViewId();
    private static final int O00000o0 = View.generateViewId();

    public static void O00000o() {
    }

    public static void O00000o0() {
    }

    public static void O00000Oo(final Activity activity) {
        CardFrameLayout cardFrameLayout = new CardFrameLayout(activity);
        Intent intent = activity.getIntent();
        boolean O000000o2 = O000000o();
        int O00000o02 = O00000o0(intent);
        if (O000000o(intent)) {
            final DisplayMetrics O00000Oo2 = O00000Oo(intent);
            gsy.O00000Oo("ActivityUtils", "pad plugin setContentView " + activity + " widthPixels " + O00000Oo2.widthPixels + " heightPixels " + O00000Oo2.heightPixels);
            O000000o(activity.getWindow(), cardFrameLayout);
            O00000o0(activity);
            O00000Oo(activity, O000000o2 ^ true);
            if (O00000o02 == 1) {
                cardFrameLayout.setBackgroundColor(-2013265920);
            } else {
                cardFrameLayout.setBackgroundColor(0);
            }
            activity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            activity.findViewById(16908290).setOnTouchListener(new View.OnTouchListener() {
                /* class _m_j.hyy.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final DisplayMetrics f1005O000000o = CommonApplication.getAppContext().getResources().getDisplayMetrics();
                final int O00000Oo = ((this.f1005O000000o.widthPixels - O00000Oo2.widthPixels) / 2);
                final int O00000o0 = ((this.f1005O000000o.heightPixels - O00000Oo2.heightPixels) / 2);

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
                 arg types: [java.lang.String, int]
                 candidates:
                  ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
                  ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    int action = motionEvent.getAction();
                    if (action != 0 && action != 1) {
                        return false;
                    }
                    if (((float) this.O00000Oo) <= x && ((float) this.O00000o0) <= y && ((float) (O00000Oo2.widthPixels + this.O00000Oo)) >= x && ((float) (O00000Oo2.heightPixels + this.O00000o0)) >= y) {
                        return false;
                    }
                    if (hyy.O000000o() && action == 1) {
                        Activity activity = activity;
                        activity.setResult(-2, activity.getIntent().putExtra("finish", true));
                        activity.finish();
                    }
                    return true;
                }
            });
        }
    }

    private static void O000000o(Window window, FrameLayout frameLayout) {
        ViewGroup viewGroup = (ViewGroup) window.findViewById(16908290);
        View childAt = viewGroup.getChildAt(0);
        viewGroup.removeViewAt(0);
        viewGroup.addView(frameLayout);
        frameLayout.addView(childAt);
        frameLayout.setId(O00000o0);
    }

    public static void O000000o(Context context, final DialogBase dialogBase, final int i) {
        WindowManager.LayoutParams attributes;
        boolean z;
        Intent intent;
        Window window = dialogBase.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            View view = null;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                view = activity.findViewById(O00000o0);
                intent = activity.getIntent();
                z = O000000o(intent);
            } else {
                intent = null;
                z = false;
            }
            DisplayMetrics O00000Oo2 = O00000Oo(intent);
            AnonymousClass2 r5 = new CardFrameLayout(context) {
                /* class _m_j.hyy.AnonymousClass2 */

                public final boolean onTouchEvent(MotionEvent motionEvent) {
                    if (!super.onTouchEvent(motionEvent) && motionEvent.getAction() == 1 && dialogBase.isCancelable()) {
                        Rect rect = new Rect();
                        int childCount = getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = getChildAt(i);
                            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                            if (childAt.getVisibility() == 0 && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                                return true;
                            }
                        }
                        dialogBase.cancel();
                    }
                    return true;
                }

                public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = i;
                    layoutParams.height = -2;
                    super.addView(view, i, layoutParams);
                }
            };
            if (view instanceof CardFrameLayout) {
                r5.O00000Oo = ((CardFrameLayout) view).getRadius();
            }
            O000000o(window, r5);
            ViewGroup.LayoutParams layoutParams = r5.getLayoutParams();
            int i2 = z ? O00000Oo2.heightPixels : -1;
            layoutParams.height = i2;
            attributes.height = i2;
            attributes.gravity = 17;
            attributes.horizontalMargin = 0.0f;
            if ((i & 80) == 80) {
                attributes.width = O00000Oo2.widthPixels;
            } else {
                attributes.width = (int) (((float) O00000Oo2.widthPixels) * 0.8f);
                View findViewById = window.findViewById(R.id.parentPanel);
                if (findViewById != null) {
                    findViewById.setBackgroundResource(R.drawable.std_dialog_bg);
                }
            }
            View findViewById2 = window.findViewById(16908290);
            if (findViewById2 != null) {
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams2).gravity = 1;
                    layoutParams2.width = attributes.width;
                } else if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams2).gravity = 1;
                    layoutParams2.width = attributes.width;
                }
            }
            attributes.dimAmount = 0.4f;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
    }

    public static void O000000o(Activity activity, Intent intent) {
        if (O00000o0(activity.getIntent()) != 0) {
            O000000o(intent, activity.getIntent());
        }
        if (O00000o(activity.getIntent()) != 0) {
            O00000Oo(intent, activity.getIntent());
        }
    }

    public static boolean O000000o(Intent intent) {
        return O00000o0(intent) != 0 && O000000o();
    }

    private static int O00000o0(Intent intent) {
        if (intent == null) {
            return 0;
        }
        return intent.getIntExtra("mj_dialog_theme_pad", 0);
    }

    private static void O000000o(Intent intent, Intent intent2) {
        if (intent != null) {
            intent.putExtra("mj_dialog_theme_pad", O00000o0(intent2) + 1);
        }
    }

    private static int O00000o(Intent intent) {
        if (intent == null) {
            return 0;
        }
        return intent.getIntExtra("mj_fullscreen_theme_pad", 0);
    }

    private static void O00000Oo(Intent intent, Intent intent2) {
        if (intent != null) {
            intent.putExtra("mj_fullscreen_theme_pad", O00000o(intent2) + 1);
        }
    }

    public static void O000000o(Intent intent, boolean z) {
        if (z) {
            O000000o(intent, intent);
        } else {
            O00000Oo(intent, intent);
        }
    }

    public static boolean O000000o() {
        DisplayMetrics displayMetrics = CommonApplication.getAppContext().getResources().getDisplayMetrics();
        float min = (float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        return min / displayMetrics.density >= 530.0f && ((float) Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)) / min < 1.8f;
    }

    public static boolean O000000o(Context context, String str) {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (!(context == null || TextUtils.isEmpty(str) || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(10)) == null || runningTasks.isEmpty())) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName != null && TextUtils.equals(str, componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static DisplayMetrics O00000Oo(Intent intent) {
        if (O000000o(intent)) {
            return O00000Oo();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) CommonApplication.getAppContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static DisplayMetrics O00000Oo() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) CommonApplication.getAppContext().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        displayMetrics.heightPixels = (int) ((((float) Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels)) * 0.85f) - ((float) hzf.O00000Oo(CommonApplication.getAppContext())));
        displayMetrics.widthPixels = displayMetrics.heightPixels / 2;
        float f = ((float) displayMetrics.widthPixels) / 360.0f;
        displayMetrics.densityDpi = (int) ((((float) displayMetrics.densityDpi) * f) / displayMetrics.density);
        displayMetrics.scaledDensity = f;
        displayMetrics.density = f;
        O00000Oo = ((float) displayMetrics.heightPixels) / ((float) i);
        return displayMetrics;
    }

    public static void O00000o0(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            O0000Oo0(activity);
        } else {
            O0000OOo(activity);
        }
    }

    private static void O0000OOo(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    private static void O0000Oo0(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, invoke);
        } catch (Throwable unused) {
        }
    }

    public static FrameLayout O00000o(Activity activity) {
        return O00000o0(activity, false);
    }

    public static FrameLayout O00000oO(Activity activity) {
        return O00000o0(activity, true);
    }

    private static FrameLayout O00000o0(Activity activity, boolean z) {
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        View decorView = window.getDecorView();
        View findViewById = decorView.findViewById(O00000o0);
        if (!(findViewById instanceof FrameLayout)) {
            View findViewById2 = decorView.findViewById(16908290);
            if (findViewById2 instanceof FrameLayout) {
                return (FrameLayout) findViewById2;
            }
            return null;
        } else if (!z) {
            return (FrameLayout) findViewById;
        } else {
            FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(O00000o);
            if (frameLayout != null) {
                return frameLayout;
            }
            FrameLayout frameLayout2 = new FrameLayout(findViewById.getContext());
            ((FrameLayout) findViewById).addView(frameLayout2);
            return frameLayout2;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(Activity activity, int i, Intent intent) {
        if (i == -2 && intent != null && intent.getBooleanExtra("finish", false)) {
            activity.setResult(i, activity.getIntent().putExtra("finish", true));
            activity.finish();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(Activity activity, Configuration configuration) {
        Intent intent = activity.getIntent();
        if (intent != null && ((O00000o0(intent) != 0 || O00000o(activity.getIntent()) != 0) && intent.getIntExtra("params_last_screenwidth", 0) != configuration.smallestScreenWidthDp)) {
            activity.setResult(1, activity.getIntent().putExtra("finish", true));
            activity.finish();
            LogType logType = LogType.PLUGIN;
            gsy.O00000o0(logType, "ActivityUtils", "onConfigurationChanged " + configuration.smallestScreenWidthDp);
        } else if (O000000o(intent)) {
            activity.getResources().getConfiguration().setTo(configuration);
            O0000Oo(activity);
        }
    }

    private static void O0000Oo(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            Resources resources = CommonApplication.getAppContext().getResources();
            Resources resources2 = activity.getResources();
            Configuration configuration = resources.getConfiguration();
            Configuration configuration2 = resources2.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            DisplayMetrics displayMetrics2 = resources2.getDisplayMetrics();
            if (O000000o()) {
                DisplayMetrics O00000Oo2 = O00000Oo(intent);
                displayMetrics2.density = O00000Oo2.density;
                displayMetrics2.scaledDensity = O00000Oo2.scaledDensity;
                int i = O00000Oo2.densityDpi;
                displayMetrics2.densityDpi = i;
                configuration2.densityDpi = i;
                resources2.updateConfiguration(configuration2, displayMetrics2);
                return;
            }
            displayMetrics2.density = displayMetrics.density;
            displayMetrics2.scaledDensity = displayMetrics.scaledDensity;
            int i2 = displayMetrics.densityDpi;
            displayMetrics2.densityDpi = i2;
            configuration2.densityDpi = i2;
            resources2.updateConfiguration(configuration, displayMetrics);
        }
    }

    public static Context O00000oo(Activity activity) {
        return new ApplicationThemeWrap(CommonApplication.getApplication(), activity.getTheme());
    }

    public static void O000000o(Activity activity, boolean z) {
        if (O000000o()) {
            f1004O000000o = z;
            O00000Oo(activity, z);
        }
    }

    public static void O00000Oo(Activity activity, boolean z) {
        View findViewById = activity.findViewById(O00000o0);
        if (findViewById instanceof FrameLayout) {
            gwg.O00000o0(activity);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((FrameLayout) findViewById).getChildAt(0).getLayoutParams();
            if (z) {
                findViewById.setPadding(0, 0, 0, 0);
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                findViewById.setPadding(0, hzf.O000000o(CommonApplication.getAppContext()), 0, 0);
                DisplayMetrics O00000Oo2 = O00000Oo(activity.getIntent());
                layoutParams.width = O00000Oo2.widthPixels;
                layoutParams.height = O00000Oo2.heightPixels;
                layoutParams.gravity = 17;
            }
            findViewById.requestLayout();
        }
    }

    public static void O0000O0o(Activity activity) {
        if (O00000o0(activity.getIntent()) == 1 && O000000o()) {
            activity.overridePendingTransition(R.anim.ftue_fade_in, R.anim.ftue_fade_out);
        }
    }

    public static void O000000o(Activity activity, Runnable runnable) {
        if (O00000o0(activity.getIntent()) == 1) {
            O000000o();
        }
        runnable.run();
    }

    public static void O000000o(Activity activity, int i) {
        Configuration configuration = activity.getResources().getConfiguration();
        if (activity.getWindow().isActive()) {
            int i2 = configuration.orientation;
            boolean z = false;
            if (i2 != 2 ? i2 == 1 && (i == 1 || i == 12 || i == 7) : i == 0 || i == 11 || i == 6) {
                z = true;
            }
            if (z) {
                try {
                    activity.onConfigurationChanged(configuration);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void O000000o(Activity activity) {
        try {
            if (!O000000o()) {
                activity.setRequestedOrientation(1);
            } else if (O00000o(activity.getIntent()) != 0) {
                activity.setRequestedOrientation(1);
            } else {
                activity.setRequestedOrientation(2);
            }
        } catch (Exception e) {
            Log.e("ActivityUtils", "setOrientation", e);
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            intent.putExtra("params_last_screenwidth", activity.getResources().getConfiguration().smallestScreenWidthDp);
            if (O000000o(intent)) {
                O0000Oo(activity);
            }
        }
    }
}

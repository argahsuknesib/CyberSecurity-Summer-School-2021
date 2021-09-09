package _m_j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(19)
public final class gwg {
    public static void O000000o(Window window, byte b, boolean z, Integer num) {
        View findViewById;
        if (window != null) {
            View decorView = window.getDecorView();
            if ((b & 1) == 1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    window.addFlags(Integer.MIN_VALUE);
                }
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 512);
                if (b == 3 && (findViewById = window.findViewById(16908290)) != null) {
                    findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getRight(), hzf.O00000Oo(window.getContext()));
                }
                num = 0;
            }
            if (z && Build.VERSION.SDK_INT >= 26) {
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            if (num != null && Build.VERSION.SDK_INT >= 21) {
                if (((decorView.getSystemUiVisibility() & 16) == 16 || !grr.O00000oO()) && Color.alpha(num.intValue()) == 0) {
                    num = Integer.valueOf(Color.argb(1, Color.red(num.intValue()), Color.green(num.intValue()), Color.blue(num.intValue())));
                }
                window.setNavigationBarColor(num.intValue());
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwg.O000000o(android.view.Window, boolean):void
     arg types: [android.view.Window, int]
     candidates:
      _m_j.gwg.O000000o(int, android.view.View):void
      _m_j.gwg.O000000o(android.app.Activity, android.view.View):void
      _m_j.gwg.O000000o(android.view.Window, boolean):void */
    public static void O000000o(Window window) {
        if (window != null) {
            O000000o(window, false);
        }
    }

    public static void O000000o(int i, View view) {
        if (view != null && view.getPaddingTop() < i) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams.height > 0) {
                layoutParams.height += i;
                view.setLayoutParams(layoutParams);
            }
            view.setPadding(0, i, 0, 0);
        }
    }

    private static void O000000o(Window window, boolean z) {
        if (!Build.BRAND.equalsIgnoreCase("htc") || !Build.MODEL.contains("M8w")) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    window.clearFlags(67108864);
                    window.addFlags(2048);
                    if (Build.VERSION.SDK_INT < 23 || !z) {
                        window.getDecorView().setSystemUiVisibility(1280);
                    } else {
                        window.getDecorView().setSystemUiVisibility(9472);
                    }
                    window.addFlags(Integer.MIN_VALUE);
                    if (!z || (!Build.BRAND.equalsIgnoreCase("oppo") && !Build.BRAND.equalsIgnoreCase("vivo"))) {
                        window.setStatusBarColor(0);
                    } else {
                        window.setStatusBarColor(33554431);
                    }
                } else if (Build.VERSION.SDK_INT < 19) {
                } else {
                    if (grr.O00000oO() && O00000o0(window, z)) {
                        window.setFlags(67108864, 67108864);
                        if (z) {
                            window.addFlags(Integer.MIN_VALUE);
                            window.getDecorView().setSystemUiVisibility(8192);
                            return;
                        }
                        window.addFlags(2048);
                        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & -8193);
                    } else if (O00000Oo(window, z)) {
                        window.setFlags(67108864, 67108864);
                        window.addFlags(2048);
                    } else {
                        window.addFlags(67108864);
                        window.addFlags(2048);
                    }
                }
            } catch (Exception e) {
                Log.e("TitleBarUtil", "translucent", e);
            }
        }
    }

    private static boolean O00000Oo(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (i ^ -1) & i2);
            window.setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean O00000o0(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                int i3 = i2 | i;
                method.invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
            } else {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i2 | i));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int O000000o(Context context) {
        int i;
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(fdb.O000000o(cls, new Object[0])).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return i == -1 ? (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics()) : i;
    }

    public static void O000000o(Activity activity, View view) {
        O000000o(activity, view, O00000Oo(activity));
    }

    public static void O000000o(Activity activity, View view, int i) {
        View findViewById = view != null ? view.findViewById(R.id.title_bar) : null;
        if (findViewById == null && activity != null) {
            findViewById = activity.findViewById(R.id.title_bar);
        }
        O000000o(i, findViewById);
    }

    public static boolean O000000o(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.BRAND.equalsIgnoreCase("htc") && Build.MODEL.contains("M8w")) {
            return false;
        }
        try {
            int i = activity.getWindow().getAttributes().flags;
            if (Build.VERSION.SDK_INT >= 21) {
                if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                    return true;
                }
            } else if (Build.VERSION.SDK_INT < 19 || (i & 67108864) != 67108864) {
                return false;
            } else {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int O00000Oo(Activity activity) {
        if (O000000o(activity)) {
            return hzf.O000000o(CommonApplication.getAppContext());
        }
        return 0;
    }

    public static void O00000Oo(Window window) {
        if (window != null) {
            O000000o(window, !gku.O000000o(window.getContext()));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwg.O000000o(android.view.Window, boolean):void
     arg types: [android.view.Window, int]
     candidates:
      _m_j.gwg.O000000o(int, android.view.View):void
      _m_j.gwg.O000000o(android.app.Activity, android.view.View):void
      _m_j.gwg.O000000o(android.view.Window, boolean):void */
    public static void O00000o0(Activity activity) {
        if (activity != null) {
            O000000o(activity.getWindow(), false);
        }
    }

    public static void O00000o(Activity activity) {
        O000000o(activity, null, O00000Oo(activity));
    }

    public static void O000000o(View view) {
        O000000o(hzf.O000000o(CommonApplication.getAppContext()), view);
    }
}

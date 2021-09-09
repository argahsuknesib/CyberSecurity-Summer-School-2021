package com.xiaomi.smarthome.frame.plugin.runtime.util;

import _m_j.grr;
import _m_j.hzf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;

@TargetApi(19)
public class TitleBarUtil {
    public static boolean TRANSLUCENT_STATUS_ENABLED = false;

    public static void enableTranslucentStatus(Activity activity) {
        if (Build.VERSION.SDK_INT < 19) {
            TRANSLUCENT_STATUS_ENABLED = false;
        } else if (activity != null) {
            Window window = activity.getWindow();
            if (!grr.O00000oO()) {
                enableTranslucentStatus(window);
                return;
            }
            try {
                Class<?> cls = window.getClass();
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                int i3 = i2 | i;
                cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
                window.setFlags(67108864, 67108864);
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
                TRANSLUCENT_STATUS_ENABLED = true;
            } catch (Exception unused) {
                TRANSLUCENT_STATUS_ENABLED = false;
            }
            if (!TRANSLUCENT_STATUS_ENABLED) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags = 67108864 | attributes.flags;
                window.setAttributes(attributes);
                TRANSLUCENT_STATUS_ENABLED = true;
            }
        }
    }

    public static void enableWhiteTranslucentStatus(Window window) {
        if (Build.VERSION.SDK_INT < 19) {
            TRANSLUCENT_STATUS_ENABLED = false;
            return;
        }
        try {
            Class<?> cls = window.getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i), Integer.valueOf(i2 | i));
            window.setFlags(67108864, 67108864);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & -8193);
            TRANSLUCENT_STATUS_ENABLED = true;
        } catch (Exception unused) {
            TRANSLUCENT_STATUS_ENABLED = false;
        }
        if (!TRANSLUCENT_STATUS_ENABLED) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.setInt(attributes, (declaredField.getInt(null) ^ -1) & declaredField2.getInt(attributes));
                window.setAttributes(attributes);
                window.setFlags(67108864, 67108864);
                TRANSLUCENT_STATUS_ENABLED = true;
            } catch (Exception unused2) {
                TRANSLUCENT_STATUS_ENABLED = false;
            }
        }
        if (!TRANSLUCENT_STATUS_ENABLED) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    window.clearFlags(67108864);
                    window.getDecorView().setSystemUiVisibility(9216);
                    window.addFlags(Integer.MIN_VALUE);
                    if (Build.BRAND.equalsIgnoreCase("oppo")) {
                        window.setStatusBarColor(-3355444);
                    } else {
                        window.setStatusBarColor(0);
                    }
                } else {
                    WindowManager.LayoutParams attributes2 = window.getAttributes();
                    attributes2.flags = 67108864 | attributes2.flags;
                    window.setAttributes(attributes2);
                }
                TRANSLUCENT_STATUS_ENABLED = true;
            } catch (Exception e) {
                e.printStackTrace();
                TRANSLUCENT_STATUS_ENABLED = false;
            }
        }
    }

    public static void enableWhiteTranslucentStatus(Activity activity) {
        if (activity != null) {
            if (Build.VERSION.SDK_INT < 19) {
                TRANSLUCENT_STATUS_ENABLED = false;
                return;
            }
            Window window = activity.getWindow();
            try {
                Class<?> cls = window.getClass();
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i), Integer.valueOf(i2 | i));
                window.setFlags(67108864, 67108864);
                grr.O000000o();
                if (grr.O00000oO()) {
                    window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & -8193);
                }
                TRANSLUCENT_STATUS_ENABLED = true;
            } catch (Exception unused) {
                TRANSLUCENT_STATUS_ENABLED = false;
            }
            if (!TRANSLUCENT_STATUS_ENABLED) {
                try {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                    Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    declaredField2.setInt(attributes, (declaredField.getInt(null) ^ -1) & declaredField2.getInt(attributes));
                    window.setAttributes(attributes);
                    window.setFlags(67108864, 67108864);
                    TRANSLUCENT_STATUS_ENABLED = true;
                } catch (Exception unused2) {
                    TRANSLUCENT_STATUS_ENABLED = false;
                }
            }
            if (!TRANSLUCENT_STATUS_ENABLED) {
                if (Build.VERSION.SDK_INT >= 21) {
                    window.clearFlags(67108864);
                    window.getDecorView().setSystemUiVisibility(9216);
                    window.addFlags(Integer.MIN_VALUE);
                    if (Build.BRAND.equalsIgnoreCase("oppo") || Build.BRAND.equalsIgnoreCase("HUAWEI")) {
                        window.setStatusBarColor(-3355444);
                    } else {
                        window.setStatusBarColor(0);
                    }
                } else {
                    WindowManager.LayoutParams attributes2 = window.getAttributes();
                    attributes2.flags = 67108864 | attributes2.flags;
                    window.setAttributes(attributes2);
                }
                TRANSLUCENT_STATUS_ENABLED = true;
            }
        }
    }

    public static void setTitleBar(Activity activity, View view) {
        View view2;
        if (TRANSLUCENT_STATUS_ENABLED && activity != null) {
            if (view == null) {
                view2 = activity.findViewById(R.id.title_bar);
            } else {
                view2 = view.findViewById(R.id.title_bar);
            }
            if (view2 != null) {
                int statusHeight = getStatusHeight(activity);
                if (view2.getLayoutParams().height > 0) {
                    view2.getLayoutParams().height += statusHeight;
                }
                view2.setPadding(0, statusHeight, 0, 0);
                view2.setLayoutParams(view2.getLayoutParams());
            }
        }
    }

    public static void setTitleBarPadding(View view) {
        if (view != null) {
            setTitleBarPadding(getStatusHeight(view.getContext()), view);
        }
    }

    public static int getStatusHeight(Context context) {
        return hzf.O000000o(context);
    }

    public static void setTitleBar(Activity activity) {
        setTitleBar(activity, null);
    }

    public static void setTitleBarPadding(int i, View view) {
        if (TRANSLUCENT_STATUS_ENABLED && view != null) {
            if (view.getLayoutParams().height > 0) {
                view.getLayoutParams().height += i;
            }
            view.setPadding(0, i, 0, 0);
            view.setLayoutParams(view.getLayoutParams());
        }
    }

    public static void enableTranslucentStatus(Window window) {
        if (Build.VERSION.SDK_INT < 19) {
            TRANSLUCENT_STATUS_ENABLED = false;
            return;
        }
        if (grr.O00000oO()) {
            try {
                Class<?> cls = window.getClass();
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2) | i;
                cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                window.setFlags(67108864, 67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(8192);
                TRANSLUCENT_STATUS_ENABLED = true;
            } catch (Exception unused) {
                TRANSLUCENT_STATUS_ENABLED = false;
            }
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
            window.setAttributes(attributes);
            window.setFlags(67108864, 67108864);
            TRANSLUCENT_STATUS_ENABLED = true;
        } catch (Exception unused2) {
            TRANSLUCENT_STATUS_ENABLED = false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(9216);
            window.addFlags(Integer.MIN_VALUE);
            if (Build.BRAND.equalsIgnoreCase("oppo")) {
                window.setStatusBarColor(-3355444);
            } else if (Build.BRAND.equalsIgnoreCase("vivo")) {
                window.setStatusBarColor(33554431);
            } else {
                window.setStatusBarColor(0);
            }
        } else {
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.flags |= 67108864;
            window.setAttributes(attributes2);
        }
        TRANSLUCENT_STATUS_ENABLED = true;
    }
}

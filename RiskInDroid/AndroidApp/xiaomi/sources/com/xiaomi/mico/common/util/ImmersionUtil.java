package com.xiaomi.mico.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.accountsdk.utils.MiuiOsBuildReflection;
import com.xiaomi.accountsdk.utils.MiuiVersionDev;
import com.xiaomi.accountsdk.utils.MiuiVersionStable;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersionUtil {

    public interface ImmersionSource {
        int getStatusBarColor();

        boolean isDarkMode();

        boolean needFitsSystemWindows();

        boolean needImmersiveStatusBar();

        boolean needSetStatusMode();
    }

    public static boolean supportTranslucentStatus() {
        return Build.VERSION.SDK_INT >= 19;
    }

    @TargetApi(19)
    public static void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    @TargetApi(19)
    public static void setTranslucentStatus(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    public static void setStatusBarMode(Activity activity, boolean z) {
        if (SystemUtil.isMeiZu() && Build.VERSION.SDK_INT >= 16) {
            try {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (i ^ -1) & i2);
                window.setAttributes(attributes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Build.VERSION.SDK_INT >= 23 && (!SystemUtil.isMiui() || ((!MiuiOsBuildReflection.isDevButNotAlpha(false) && !MiuiOsBuildReflection.isStable(false)) || ((MiuiOsBuildReflection.isDevButNotAlpha(false) && !MiuiVersionDev.earlyThan(new MiuiVersionDev(7, 7, 1), false)) || (MiuiOsBuildReflection.isStable(false) && !MiuiVersionStable.earlyThan(new MiuiVersionStable(9, 0), false)))))) {
            View decorView = activity.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        } else if (SystemUtil.isV6OrLater()) {
            Window window2 = activity.getWindow();
            try {
                Class<?> cls = window2.getClass();
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i3 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(z ? i3 : 0);
                objArr[1] = Integer.valueOf(i3);
                method.invoke(window2, objArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setStatusBarModeV2(Activity activity, boolean z) {
        if (SystemUtil.isMeiZu()) {
            try {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (i ^ -1) & i2);
                window.setAttributes(attributes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Build.VERSION.SDK_INT >= 23 && (!SystemUtil.isMiui() || ((!MiuiOsBuildReflection.isDevButNotAlpha(false) && !MiuiOsBuildReflection.isStable(false)) || ((MiuiOsBuildReflection.isDevButNotAlpha(false) && !MiuiVersionDev.earlyThan(new MiuiVersionDev(7, 7, 1), false)) || (MiuiOsBuildReflection.isStable(false) && !MiuiVersionStable.earlyThan(new MiuiVersionStable(9, 0), false)))))) {
            View decorView = activity.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        } else if (SystemUtil.isV6OrLater()) {
            Window window2 = activity.getWindow();
            try {
                Class<?> cls = window2.getClass();
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i3 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(z ? i3 : 0);
                objArr[1] = Integer.valueOf(i3);
                method.invoke(window2, objArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean hasImmersiveStatusBar(Activity activity) {
        if (activity instanceof ImmersionSource) {
            ImmersionSource immersionSource = (ImmersionSource) activity;
            if (!supportTranslucentStatus() || !immersionSource.needImmersiveStatusBar()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void addImmersivePaddingIfNeeded(Activity activity, View view) {
        if (activity instanceof ImmersionSource) {
            ImmersionSource immersionSource = (ImmersionSource) activity;
            if (supportTranslucentStatus() && immersionSource.needImmersiveStatusBar() && !immersionSource.needFitsSystemWindows()) {
                addImmersivePadding(view);
            }
        }
    }

    public static void addImmersivePadding(View view) {
        if (view != null) {
            int statusBarHeight = getStatusBarHeight(view.getContext());
            view.getLayoutParams().height += statusBarHeight;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + statusBarHeight, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setImmersivePaddingIfNeeded(Activity activity, View view) {
        if (activity instanceof ImmersionSource) {
            ImmersionSource immersionSource = (ImmersionSource) activity;
            if (supportTranslucentStatus() && immersionSource.needImmersiveStatusBar() && !immersionSource.needFitsSystemWindows()) {
                setImmersivePadding(view);
            }
        }
    }

    public static void setImmersivePadding(View view) {
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(view.getContext()), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                int dimensionPixelSize = resources.getDimensionPixelSize(identifier);
                if (dimensionPixelSize > 10) {
                    return dimensionPixelSize;
                }
            } catch (Resources.NotFoundException unused) {
            }
        }
        return resources.getDimensionPixelSize(R.dimen.common_status_bar_height);
    }
}

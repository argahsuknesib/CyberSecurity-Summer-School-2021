package com.xiaomi.smarthome.uwb.lib.utils;

import _m_j.gpc;
import _m_j.hzf;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class UIUtils {
    public static boolean isEnglish(char c) {
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean isActivityValid(Activity activity) {
        return !activity.isDestroyed() && !activity.isFinishing();
    }

    public static boolean isApkInDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static void initBottomMargin(Context context, View view) {
        int O00000Oo;
        if (view != null && (O00000Oo = hzf.O00000Oo(context)) != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.bottomMargin = O00000Oo;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void startShowAni(final View view, final View view2, final View view3) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.uwb.lib.utils.UIUtils.AnonymousClass1 */

            public final void onGlobalLayout() {
                View view = view3;
                if (view != null) {
                    view.setTranslationY((float) view.getHeight());
                    view3.animate().translationY(0.0f).start();
                }
                View view2 = view2;
                if (view2 != null) {
                    view2.setTranslationY((float) (-((gpc.O000000o() - view3.getHeight()) - view2.getHeight())));
                    view2.animate().translationY(0.0f).start();
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}

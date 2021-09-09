package com.facebook.react.views.modal;

import _m_j.cb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.views.modal.ReactModalHostView;

public class TranslucentModalHostView extends ReactModalHostView {
    public TranslucentModalHostView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
    }

    /* access modifiers changed from: protected */
    public void setOnRequestCloseListener(ReactModalHostView.OnRequestCloseListener onRequestCloseListener) {
        super.setOnRequestCloseListener(onRequestCloseListener);
    }

    /* access modifiers changed from: protected */
    public void setTransparent(boolean z) {
        super.setTransparent(z);
    }

    /* access modifiers changed from: protected */
    public void setHardwareAccelerated(boolean z) {
        super.setHardwareAccelerated(z);
    }

    /* access modifiers changed from: protected */
    public void setAnimationType(String str) {
        super.setAnimationType(str);
    }

    /* access modifiers changed from: protected */
    public void showOrUpdate() {
        super.showOrUpdate();
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStatusBarTranslucent(dialog.getWindow(), true);
            setStatusBarColor(dialog.getWindow(), 0);
            setStatusBarStyle(dialog.getWindow(), isDark());
        }
    }

    @TargetApi(23)
    private boolean isDark() {
        Activity currentActivity = ((ReactContext) getContext()).getCurrentActivity();
        if (currentActivity != null && (currentActivity.getWindow().getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
    }

    public static void setStatusBarTranslucent(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = window.getDecorView();
            if (z) {
                decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    /* class com.facebook.react.views.modal.TranslucentModalHostView.AnonymousClass1 */

                    @TargetApi(21)
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                        return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
                    }
                });
            } else {
                decorView.setOnApplyWindowInsetsListener(null);
            }
            cb.O0000ooO(decorView);
        }
    }

    public static void setStatusBarColor(Window window, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    public static void setStatusBarStyle(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(z ? 8192 : 0);
        }
    }
}

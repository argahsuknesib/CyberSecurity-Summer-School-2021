package com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar;

import _m_j.cb;
import _m_j.gbs;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

public class FixStatusBarModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "StatusBarManager";
    }

    public FixStatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        float dIPFromPixel = (gbs.O000000o() || identifier <= 0) ? 0.0f : PixelUtil.toDIPFromPixel((float) reactApplicationContext.getResources().getDimensionPixelSize(identifier));
        FLog.i("ReactNative", "StatusBarModule getConstants  height: ".concat(String.valueOf(dIPFromPixel)));
        return MapBuilder.of("HEIGHT", Float.valueOf(dIPFromPixel));
    }

    @ReactMethod
    public void setColor(int i, boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule setColor: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 21) {
            FLog.i("ReactNative", "StatusBarModule: animated=".concat(String.valueOf(z)));
            final boolean z2 = z;
            final int i2 = i;
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar.FixStatusBarModule.AnonymousClass1 */

                @TargetApi(21)
                public final void runGuarded() {
                    currentActivity.getWindow().addFlags(Integer.MIN_VALUE);
                    if (z2) {
                        int statusBarColor = currentActivity.getWindow().getStatusBarColor();
                        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(statusBarColor), Integer.valueOf(i2));
                        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar.FixStatusBarModule.AnonymousClass1.AnonymousClass1 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                currentActivity.getWindow().setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                        });
                        ofObject.setDuration(300L).setStartDelay(0);
                        ofObject.start();
                        return;
                    }
                    currentActivity.getWindow().setStatusBarColor(i2);
                }
            });
        } else {
            FLog.w("ReactNative", "StatusBarModule: Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP, cannot support setColor");
        }
    }

    @ReactMethod
    public void setTranslucent(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule setTranslucent: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 21) {
            FLog.i("ReactNative", "StatusBarModule: translucent=".concat(String.valueOf(z)));
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar.FixStatusBarModule.AnonymousClass2 */

                @TargetApi(21)
                public final void runGuarded() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    if (z) {
                        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar.FixStatusBarModule.AnonymousClass2.AnonymousClass1 */

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
            });
        } else {
            FLog.w("ReactNative", "StatusBarModule: Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP, cannot support setTranslucent");
        }
    }

    @ReactMethod
    public void setHidden(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule setHidden: Ignored status bar change, current activity is null.");
            return;
        }
        FLog.i("ReactNative", "StatusBarModule: hidden=".concat(String.valueOf(z)));
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar.FixStatusBarModule.AnonymousClass3 */

            public final void run() {
                if (z) {
                    currentActivity.getWindow().addFlags(1024);
                    currentActivity.getWindow().clearFlags(2048);
                    return;
                }
                currentActivity.getWindow().addFlags(2048);
                currentActivity.getWindow().clearFlags(1024);
            }
        });
    }

    @ReactMethod
    public void setStyle(final String str) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule  setStyle: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 23) {
            FLog.i("ReactNative", "StatusBarModule: style=".concat(String.valueOf(str)));
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.fixbug.statusbar.FixStatusBarModule.AnonymousClass4 */

                @TargetApi(23)
                public final void run() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    int systemUiVisibility = decorView.getSystemUiVisibility();
                    decorView.setSystemUiVisibility("dark-content".equals(str) ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
                }
            });
        } else {
            FLog.w("ReactNative", "StatusBarModule: Build.VERSION.SDK_INT < Build.VERSION_CODES.M, cannot support setStyle");
        }
    }
}

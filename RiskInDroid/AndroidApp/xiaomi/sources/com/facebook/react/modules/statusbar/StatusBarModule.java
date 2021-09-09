package com.facebook.react.modules.statusbar;

import _m_j.cb;
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
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

@ReactModule(name = "StatusBarManager")
public class StatusBarModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "StatusBarManager";
    }

    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Activity currentActivity = getCurrentActivity();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return MapBuilder.of("HEIGHT", Float.valueOf(identifier > 0 ? PixelUtil.toDIPFromPixel((float) reactApplicationContext.getResources().getDimensionPixelSize(identifier)) : 0.0f), "DEFAULT_BACKGROUND_COLOR", (currentActivity == null || Build.VERSION.SDK_INT < 21) ? "black" : String.format("#%06X", Integer.valueOf(currentActivity.getWindow().getStatusBarColor() & 16777215)));
    }

    @ReactMethod
    public void setColor(int i, boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 21) {
            final boolean z2 = z;
            final int i2 = i;
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass1 */

                @TargetApi(21)
                public void runGuarded() {
                    currentActivity.getWindow().addFlags(Integer.MIN_VALUE);
                    if (z2) {
                        int statusBarColor = currentActivity.getWindow().getStatusBarColor();
                        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(statusBarColor), Integer.valueOf(i2));
                        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass1.AnonymousClass1 */

                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
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
        }
    }

    @ReactMethod
    public void setTranslucent(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 21) {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass2 */

                @TargetApi(21)
                public void runGuarded() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    if (z) {
                        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                            /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass2.AnonymousClass1 */

                            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
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
        }
    }

    @ReactMethod
    public void setHidden(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass3 */

                public void run() {
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
    }

    @ReactMethod
    public void setStyle(final String str) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 23) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.modules.statusbar.StatusBarModule.AnonymousClass4 */

                @TargetApi(23)
                public void run() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    int systemUiVisibility = decorView.getSystemUiVisibility();
                    decorView.setSystemUiVisibility("dark-content".equals(str) ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
                }
            });
        }
    }
}

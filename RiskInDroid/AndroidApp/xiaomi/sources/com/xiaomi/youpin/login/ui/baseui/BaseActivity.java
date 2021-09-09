package com.xiaomi.youpin.login.ui.baseui;

import _m_j.gpx;
import _m_j.gsy;
import _m_j.icm;
import _m_j.ico;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseActivity extends FragmentActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f12091O000000o = false;
    private final BroadcastReceiver O00000Oo = new BroadcastReceiver() {
        /* class com.xiaomi.youpin.login.ui.baseui.BaseActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "miot_activit_finish_tag") && BaseActivity.this.f12091O000000o) {
                BaseActivity.this.finish();
            }
        }
    };
    private String O00000o;
    private String O00000o0;

    public static boolean isAppOnForeground(Context context) {
        String packageName = context.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.startsWith(packageName) && (next.importance == 100 || next.importance == 200)) {
                gsy.O000000o(6, "CommonUtils", "Process:" + next.processName);
                return true;
            }
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        icm.O00000Oo(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26 || !icm.O000000o(this)) {
            setRequestedOrientation(1);
        }
        ico.O000000o(getWindow());
    }

    public void onResume() {
        super.onResume();
        this.f12091O000000o = false;
    }

    public void onPause() {
        super.onPause();
        this.f12091O000000o = true;
    }

    public void onDestroy() {
        try {
            fixInputMethodManager(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearAllActivityViews(this);
        super.onDestroy();
    }

    public static void fixInputMethodManager(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
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

    private static void O000000o(View view) {
        if (view != null) {
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
                    O000000o(viewGroup.getChildAt(i));
                }
                try {
                    viewGroup.removeAllViews();
                } catch (Exception unused3) {
                }
            }
        }
    }

    public static void clearAllActivityViews(Activity activity) {
        try {
            O000000o(activity.getWindow().getDecorView().findViewById(16908290));
        } catch (Exception unused) {
        }
    }

    public String getSingleReferer() {
        String str = this.O00000o0;
        return str == null ? "" : str;
    }

    public String getFullReferer() {
        String str = this.O00000o;
        return str == null ? "" : str;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
    }
}

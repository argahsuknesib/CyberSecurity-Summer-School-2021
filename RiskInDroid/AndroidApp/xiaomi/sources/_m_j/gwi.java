package _m_j;

import _m_j.gpx;
import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.reflect.Field;

public final class gwi {
    public static void O000000o(Activity activity) {
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

    public static void O00000Oo(Activity activity) {
        try {
            O000000o(activity.getWindow().getDecorView().findViewById(16908290));
        } catch (Exception e) {
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
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
}

package com.facebook.react.devsupport;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.UiThreadUtil;
import com.xiaomi.smarthome.R;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class DevLoadingViewController {
    private static boolean sEnabled = true;
    private PopupWindow mDevLoadingPopup;
    public TextView mDevLoadingView;
    private final ReactInstanceManagerDevHelper mReactInstanceManagerHelper;

    public static void setDevLoadingEnabled(boolean z) {
        sEnabled = z;
    }

    public DevLoadingViewController(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper) {
        this.mReactInstanceManagerHelper = reactInstanceManagerDevHelper;
    }

    public void showMessage(final String str) {
        if (sEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevLoadingViewController.AnonymousClass1 */

                public void run() {
                    DevLoadingViewController.this.showInternal(str);
                }
            });
        }
    }

    public void showForUrl(String str) {
        Context context = getContext();
        if (context != null) {
            try {
                URL url = new URL(str);
                showMessage(context.getString(R.string.catalyst_loading_from_url, url.getHost() + ":" + url.getPort()));
            } catch (MalformedURLException e) {
                FLog.e("ReactNative", "Bundle url format is invalid. \n\n" + e.toString());
            }
        }
    }

    public void showForRemoteJSEnabled() {
        Context context = getContext();
        if (context != null) {
            showMessage(context.getString(R.string.catalyst_debug_connecting));
        }
    }

    public void updateProgress(final String str, final Integer num, final Integer num2) {
        if (sEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevLoadingViewController.AnonymousClass2 */

                public void run() {
                    Integer num;
                    StringBuilder sb = new StringBuilder();
                    String str = str;
                    if (str == null) {
                        str = "Loading";
                    }
                    sb.append(str);
                    if (!(num == null || (num = num2) == null || num.intValue() <= 0)) {
                        sb.append(String.format(Locale.getDefault(), " %.1f%% (%d/%d)", Float.valueOf((((float) num.intValue()) / ((float) num2.intValue())) * 100.0f), num, num2));
                    }
                    sb.append("…");
                    if (DevLoadingViewController.this.mDevLoadingView != null) {
                        DevLoadingViewController.this.mDevLoadingView.setText(sb);
                    }
                }
            });
        }
    }

    public void hide() {
        if (sEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevLoadingViewController.AnonymousClass3 */

                public void run() {
                    DevLoadingViewController.this.hideInternal();
                }
            });
        }
    }

    public void showInternal(String str) {
        PopupWindow popupWindow = this.mDevLoadingPopup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            Activity currentActivity = this.mReactInstanceManagerHelper.getCurrentActivity();
            if (currentActivity == null) {
                FLog.e("ReactNative", "Unable to display loading message because react activity isn't available");
                return;
            }
            Rect rect = new Rect();
            currentActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            this.mDevLoadingView = (TextView) ((LayoutInflater) currentActivity.getSystemService("layout_inflater")).inflate((int) R.layout.dev_loading_view, (ViewGroup) null);
            this.mDevLoadingView.setText(str);
            this.mDevLoadingPopup = new PopupWindow(this.mDevLoadingView, -1, -2);
            this.mDevLoadingPopup.setTouchable(false);
            this.mDevLoadingPopup.showAtLocation(currentActivity.getWindow().getDecorView(), 0, 0, i);
        }
    }

    public void hideInternal() {
        PopupWindow popupWindow = this.mDevLoadingPopup;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mDevLoadingPopup.dismiss();
            this.mDevLoadingPopup = null;
            this.mDevLoadingView = null;
        }
    }

    private Context getContext() {
        return this.mReactInstanceManagerHelper.getCurrentActivity();
    }
}

package _m_j;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

public final class ddc {
    public static void O000000o(View view) {
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

package _m_j;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public final class hkx implements hkv {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ArrayList<Pair<String, hkv>> f19026O000000o = new ArrayList<>();

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                ((hkv) it.next().second).onPageStarted(webView, str, bitmap);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                if (((hkv) next.second).shouldOverrideUrlLoading(webView, str)) {
                    gsy.O000000o(3, "UrlInterceptorChain", "shouldOverrideUrlLoading 1: by: " + ((String) next.first));
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                if (((hkv) next.second).shouldOverrideUrlLoading(webView, webResourceRequest)) {
                    gsy.O000000o(3, "UrlInterceptorChain", "shouldOverrideUrlLoading 2: by: " + ((String) next.first));
                    return true;
                }
            }
            return false;
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                ((hkv) it.next().second).onPageFinished(webView, str);
            }
        }
    }

    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                ((hkv) it.next().second).onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }

    public final void onResume() {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                ((hkv) it.next().second).onResume();
            }
        }
    }

    public final void onDestroy() {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                ((hkv) it.next().second).onDestroy();
            }
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                ((hkv) it.next().second).onReceivedError(webView, i, str, str2);
            }
        }
    }

    public final hkv O000000o(String str) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                if (TextUtils.equals((CharSequence) next.first, str)) {
                    hkv hkv = (hkv) next.second;
                    return hkv;
                }
            }
            return null;
        }
    }

    public final <C extends hkv> C O000000o(Class cls) {
        synchronized (this.f19026O000000o) {
            Iterator<Pair<String, hkv>> it = this.f19026O000000o.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                if (cls.isInstance(next.second)) {
                    C c = (hkv) next.second;
                    return c;
                }
            }
            return null;
        }
    }

    public final void O000000o(String str, hkv hkv) {
        synchronized (this.f19026O000000o) {
            O000000o(str, hkv, this.f19026O000000o.size());
        }
    }

    private void O000000o(String str, hkv hkv, int i) {
        hlp.O000000o(str, "name is empty!");
        hlp.O000000o(hkv, "interceptor is null!");
        synchronized (this.f19026O000000o) {
            this.f19026O000000o.add(i, Pair.create(str, hkv));
            gsy.O000000o(3, "UrlInterceptorChain", "install: name: " + str + " ;index: " + i);
        }
    }
}

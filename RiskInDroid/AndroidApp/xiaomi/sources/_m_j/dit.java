package _m_j;

import android.net.Uri;
import android.webkit.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class dit {

    /* renamed from: O000000o  reason: collision with root package name */
    protected HashMap<String, O00000Oo> f14698O000000o = new HashMap<>();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        protected WeakReference<WebView> f14699O000000o;
        protected long O00000Oo;
        protected String O00000o0;

        public O000000o(WebView webView, long j, String str) {
            this.f14699O000000o = new WeakReference<>(webView);
            this.O00000Oo = j;
            this.O00000o0 = str;
        }

        public void O000000o() {
            WebView webView = this.f14699O000000o.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.O00000Oo + ",{'r':0,'result':" + "'undefined'" + "});");
            }
        }

        public void O00000Oo() {
            WebView webView = this.f14699O000000o.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.O00000Oo + ",{'r':1,'result':'no such method'})");
            }
        }

        public void O000000o(String str) {
            WebView webView = this.f14699O000000o.get();
            if (webView != null) {
                webView.loadUrl("javascript:".concat(String.valueOf(str)));
            }
        }
    }

    public static class O00000Oo {
        public boolean customCallback() {
            return false;
        }

        public void call(String str, List<String> list, O000000o o000000o) {
            String str2;
            Method method;
            Object obj;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                str2 = null;
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i++;
            }
            if (method != null) {
                try {
                    int size = list.size();
                    if (size == 0) {
                        obj = method.invoke(this, new Object[0]);
                    } else if (size == 1) {
                        obj = method.invoke(this, list.get(0));
                    } else if (size == 2) {
                        obj = method.invoke(this, list.get(0), list.get(1));
                    } else if (size == 3) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2));
                    } else if (size == 4) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3));
                    } else if (size != 5) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                    } else {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                    }
                    Class<?> returnType = method.getReturnType();
                    diz.O00000Oo("openSDK_LOG.JsBridge", "-->call, result: " + obj + " | ReturnType: " + returnType.getName());
                    if (!"void".equals(returnType.getName())) {
                        if (returnType != Void.class) {
                            if (o000000o != null && customCallback()) {
                                if (obj != null) {
                                    str2 = obj.toString();
                                }
                                o000000o.O000000o(str2);
                                return;
                            }
                            return;
                        }
                    }
                    if (o000000o != null) {
                        o000000o.O000000o();
                    }
                } catch (Exception e) {
                    diz.O00000Oo("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: ".concat(String.valueOf(method)), e);
                    if (o000000o != null) {
                        o000000o.O00000Oo();
                    }
                }
            } else if (o000000o != null) {
                o000000o.O00000Oo();
            }
        }
    }

    public final void O000000o(O00000Oo o00000Oo, String str) {
        this.f14698O000000o.put(str, o00000Oo);
    }

    public void O000000o(String str, String str2, List<String> list, O000000o o000000o) {
        diz.O000000o("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        O00000Oo o00000Oo = this.f14698O000000o.get(str);
        if (o00000Oo != null) {
            diz.O00000Oo("openSDK_LOG.JsBridge", "call----");
            o00000Oo.call(str2, list, o000000o);
            return;
        }
        diz.O00000Oo("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        o000000o.O00000Oo();
    }

    public boolean O000000o(WebView webView, String str) {
        diz.O000000o("openSDK_LOG.JsBridge", "-->canHandleUrl---url = ".concat(String.valueOf(str)));
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        List subList = arrayList.subList(4, arrayList.size() - 1);
        O000000o o000000o = new O000000o(webView, 4, str);
        webView.getUrl();
        O000000o((String) arrayList.get(2), (String) arrayList.get(3), subList, o000000o);
        return true;
    }
}

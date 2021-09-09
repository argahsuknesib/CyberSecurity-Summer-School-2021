package com.facebook.react.modules.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.ReactContext;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ForwardingCookieHandler extends CookieHandler {
    public static final boolean USES_LEGACY_STORE = (Build.VERSION.SDK_INT < 21);
    private final ReactContext mContext;
    private CookieManager mCookieManager;
    public final CookieSaver mCookieSaver = new CookieSaver();

    public ForwardingCookieHandler(ReactContext reactContext) {
        this.mContext = reactContext;
    }

    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager == null) {
            return Collections.emptyMap();
        }
        String cookie = cookieManager.getCookie(uri.toString());
        if (TextUtils.isEmpty(cookie)) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap("Cookie", Collections.singletonList(cookie));
    }

    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        String uri2 = uri.toString();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (str != null && isCookieHeader(str)) {
                addCookies(uri2, (List) next.getValue());
            }
        }
    }

    public void clearCookies(final Callback callback) {
        if (USES_LEGACY_STORE) {
            new GuardedResultAsyncTask<Boolean>(this.mContext) {
                /* class com.facebook.react.modules.network.ForwardingCookieHandler.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public Boolean doInBackgroundGuarded() {
                    CookieManager cookieManager = ForwardingCookieHandler.this.getCookieManager();
                    if (cookieManager != null) {
                        cookieManager.removeAllCookie();
                    }
                    ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
                    return Boolean.TRUE;
                }

                /* access modifiers changed from: protected */
                public void onPostExecuteGuarded(Boolean bool) {
                    callback.invoke(bool);
                }
            }.execute(new Void[0]);
        } else {
            clearCookiesAsync(callback);
        }
    }

    private void clearCookiesAsync(final Callback callback) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.removeAllCookies(new ValueCallback<Boolean>() {
                /* class com.facebook.react.modules.network.ForwardingCookieHandler.AnonymousClass2 */

                public void onReceiveValue(Boolean bool) {
                    ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
                    callback.invoke(bool);
                }
            });
        }
    }

    public void destroy() {
        if (USES_LEGACY_STORE) {
            CookieManager cookieManager = getCookieManager();
            if (cookieManager != null) {
                cookieManager.removeExpiredCookie();
            }
            this.mCookieSaver.persistCookies();
        }
    }

    private void addCookies(final String str, final List<String> list) {
        final CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            if (USES_LEGACY_STORE) {
                runInBackground(new Runnable() {
                    /* class com.facebook.react.modules.network.ForwardingCookieHandler.AnonymousClass3 */

                    public void run() {
                        for (String cookie : list) {
                            cookieManager.setCookie(str, cookie);
                        }
                        ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
                    }
                });
                return;
            }
            for (String addCookieAsync : list) {
                addCookieAsync(str, addCookieAsync);
            }
            cookieManager.flush();
            this.mCookieSaver.onCookiesModified();
        }
    }

    @TargetApi(21)
    private void addCookieAsync(String str, String str2) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.setCookie(str, str2, null);
        }
    }

    private static boolean isCookieHeader(String str) {
        return str.equalsIgnoreCase("Set-cookie") || str.equalsIgnoreCase("Set-cookie2");
    }

    public void runInBackground(final Runnable runnable) {
        new GuardedAsyncTask<Void, Void>(this.mContext) {
            /* class com.facebook.react.modules.network.ForwardingCookieHandler.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                runnable.run();
            }
        }.execute(new Void[0]);
    }

    public CookieManager getCookieManager() {
        if (this.mCookieManager == null) {
            possiblyWorkaroundSyncManager(this.mContext);
            try {
                this.mCookieManager = CookieManager.getInstance();
                if (USES_LEGACY_STORE) {
                    this.mCookieManager.removeExpiredCookie();
                }
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Exception e) {
                String message = e.getMessage();
                if (message != null && message.contains("No WebView installed")) {
                    return null;
                }
                throw e;
            }
        }
        return this.mCookieManager;
    }

    private static void possiblyWorkaroundSyncManager(Context context) {
        if (USES_LEGACY_STORE) {
            CookieSyncManager.createInstance(context).sync();
        }
    }

    class CookieSaver {
        private final Handler mHandler;

        public CookieSaver() {
            this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback(ForwardingCookieHandler.this) {
                /* class com.facebook.react.modules.network.ForwardingCookieHandler.CookieSaver.AnonymousClass1 */

                public boolean handleMessage(Message message) {
                    if (message.what != 1) {
                        return false;
                    }
                    CookieSaver.this.persistCookies();
                    return true;
                }
            });
        }

        public void onCookiesModified() {
            if (ForwardingCookieHandler.USES_LEGACY_STORE) {
                this.mHandler.sendEmptyMessageDelayed(1, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
            }
        }

        public void persistCookies() {
            this.mHandler.removeMessages(1);
            ForwardingCookieHandler.this.runInBackground(new Runnable() {
                /* class com.facebook.react.modules.network.ForwardingCookieHandler.CookieSaver.AnonymousClass2 */

                public void run() {
                    if (ForwardingCookieHandler.USES_LEGACY_STORE) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        CookieSaver.this.flush();
                    }
                }
            });
        }

        @TargetApi(21)
        public void flush() {
            CookieManager cookieManager = ForwardingCookieHandler.this.getCookieManager();
            if (cookieManager != null) {
                cookieManager.flush();
            }
        }
    }
}

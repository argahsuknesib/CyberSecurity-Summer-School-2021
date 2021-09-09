package _m_j;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import com.xiaomi.smarthome.operation.js_sdk.share.LoadingDialogHelper;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hlk extends hkw {

    /* renamed from: O000000o  reason: collision with root package name */
    public final CommonWebView f19039O000000o;
    public LoadingDialogHelper O00000Oo;
    private BroadcastReceiver O00000o = null;
    private final Context O00000o0;

    public void onResume() {
    }

    public hlk(CommonWebView commonWebView, Context context) {
        this.f19039O000000o = commonWebView;
        this.O00000Oo = new LoadingDialogHelper(context);
        this.O00000o0 = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hlp.O000000o(android.webkit.WebView, java.lang.String):io.reactivex.Observable<java.lang.String>
     arg types: [com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView, java.lang.String]
     candidates:
      _m_j.hlp.O000000o(java.lang.Object, java.lang.String):T
      _m_j.hlp.O000000o(android.webkit.WebView, java.lang.String):io.reactivex.Observable<java.lang.String> */
    @SuppressLint({"CheckResult"})
    public final void O000000o() {
        if (Build.VERSION.SDK_INT >= 19) {
            hlp.O000000o((WebView) this.f19039O000000o, "window.hasOwnProperty('smartHome')").subscribe(new Consumer() {
                /* class _m_j.$$Lambda$hlk$kAvGJ4jgM_nwn8HMagddu3G0GdM */

                public final void accept(Object obj) {
                    hlk.this.O00000o0((String) obj);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hlp.O000000o(android.webkit.WebView, java.lang.String):io.reactivex.Observable<java.lang.String>
     arg types: [com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView, java.lang.String]
     candidates:
      _m_j.hlp.O000000o(java.lang.Object, java.lang.String):T
      _m_j.hlp.O000000o(android.webkit.WebView, java.lang.String):io.reactivex.Observable<java.lang.String> */
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(String str) throws Exception {
        if (Boolean.parseBoolean(str)) {
            hlp.O000000o((WebView) this.f19039O000000o, "smartHome.share.getOption()").subscribe(new Consumer() {
                /* class _m_j.$$Lambda$hlk$QttBjP6bShh4QKejCs4urRVMpPA */

                public final void accept(Object obj) {
                    hlk.this.O00000oO((String) obj);
                }
            });
        } else {
            Observable.zip(hlp.O000000o((WebView) this.f19039O000000o, "location.href"), hlp.O000000o((WebView) this.f19039O000000o, "document.title"), new BiFunction() {
                /* class _m_j.$$Lambda$hlk$L6P6DiDuHfMbwZHWE21hKCGtko */

                public final Object apply(Object obj, Object obj2) {
                    return hlk.this.O000000o((String) obj, (String) obj2);
                }
            }).subscribe(new Consumer() {
                /* class _m_j.$$Lambda$hlk$MtF8OWfXWApWtmzOfKlvgzVdE8 */

                public final void accept(Object obj) {
                    hlk.this.O00000o((String) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(String str) throws Exception {
        gsy.O00000Oo("ShareHelper", "doShare: smartHome.share.getOption()： " + String.valueOf(str));
        if (O00000Oo(str)) {
            O000000o(str);
        } else {
            this.O00000Oo.O000000o();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String O000000o(String str, String str2) throws Exception {
        JSONObject jSONObject = new JSONObject();
        String O000000o2 = hlp.O000000o(this.O00000o0);
        if (!TextUtils.isEmpty(O000000o2)) {
            jSONObject.put("url", str);
            jSONObject.put("title", str2);
            jSONObject.put("imageUrl", O000000o2);
            jSONObject.put("description", str2);
        }
        gsy.O000000o(3, "ShareHelper", "doShare: third web : " + jSONObject.toString());
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(String str) throws Exception {
        if (O00000Oo(str)) {
            O000000o(str);
        } else {
            hte.O000000o(this.O00000o0, (int) R.string.share_failed);
        }
    }

    private static boolean O00000Oo(String str) {
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str) && !"undefined".equalsIgnoreCase(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("url");
                String string2 = jSONObject.getString("description");
                String string3 = jSONObject.getString("title");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.util.ArrayList]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    public final void O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("url");
            String optString = jSONObject.optString("imageUrl");
            String string2 = jSONObject.getString("description");
            String string3 = jSONObject.getString("title");
            JSONArray optJSONArray = jSONObject.optJSONArray("channel");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            fbt O000000o2 = new fbt(this.O00000o0, "CommonShareActivity").O000000o("ShareTitle", string3);
            if (!TextUtils.isEmpty(string2)) {
                O000000o2.O000000o("ShareContent", string2);
            }
            if (!TextUtils.isEmpty(optString)) {
                if (optString.endsWith(".zip")) {
                    O000000o2.O000000o("SHARE_IMAGE_FILE_ZIP_URL", optString);
                } else {
                    O000000o2.O000000o("ShareImageUrlNotZip", optString);
                }
            }
            O000000o2.O000000o("ShareUrl", string);
            O000000o2.O000000o("share_channels", (Serializable) arrayList);
            fbs.O000000o(O000000o2);
            hxi.O00000o.f952O000000o.O000000o("content_article_share_click", "url", string);
            if (this.O00000o == null) {
                this.O00000o = new BroadcastReceiver() {
                    /* class _m_j.hlk.AnonymousClass1 */

                    public final void onReceive(Context context, Intent intent) {
                        int intExtra = intent.getIntExtra("result_code", -1);
                        String stringExtra = intent.getStringExtra("result_channel");
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", intExtra);
                            jSONObject.put("channel", stringExtra);
                        } catch (JSONException unused) {
                        }
                        hlp.O000000o(hlk.this.f19039O000000o, "smartHome.onShareResultCallback", jSONObject.toString());
                        hxi.O00000o.f952O000000o.O000000o("content_share_callback", "result", Integer.valueOf(intExtra), "channel", stringExtra);
                    }
                };
                ft.O000000o(this.O00000o0).O000000o(this.O00000o, new IntentFilter("ACTION_SHARE_RESULT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPageFinished(WebView webView, String str) {
        this.O00000Oo.O00000Oo();
    }

    public void onDestroy() {
        this.O00000Oo.O00000Oo();
        if (this.O00000o != null) {
            ft.O000000o(this.O00000o0).O000000o(this.O00000o);
        }
    }
}

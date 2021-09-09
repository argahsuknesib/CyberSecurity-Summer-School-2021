package com.xiaomi.smarthome.operation.js_sdk.titlebar;

import _m_j.gsy;
import _m_j.hlm;
import _m_j.hln;
import _m_j.hlp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

public class WebTitleBarView extends FrameLayout implements hlm {

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f10531O000000o;
    public ProgressBar O00000Oo;
    public O000000o O00000o;
    public int O00000o0;
    private ProgressBar O00000oO;
    private TextView O00000oo;
    private hln O0000O0o;
    private View O0000OOo;
    private ImageView O0000Oo;
    private String O0000Oo0;
    private CommonWebView O0000OoO;
    private boolean O0000Ooo;
    private boolean O0000o0;
    private boolean O0000o00;
    private boolean O0000o0O;

    public interface O000000o {
        void O000000o();

        void O000000o(View view, TitleBarMenu.O000000o o000000o, String str);

        void O000000o(boolean z);

        void O00000Oo();

        void O00000o0();
    }

    public WebTitleBarView(Context context) {
        this(context, null);
    }

    public WebTitleBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"HandlerLeak"})
    public WebTitleBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Ooo = false;
        this.O0000o00 = false;
        this.O0000o0O = false;
        inflate(context, R.layout.webview_title_bar_layout, this);
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.$$Lambda$WebTitleBarView$SLqP4pN7S75p9aAfY8CMZUqEofo */

            public final void onClick(View view) {
                WebTitleBarView.this.O00000o0(view);
            }
        });
        this.O0000Oo = (ImageView) findViewById(R.id.bg_img);
        this.O00000oo = (TextView) findViewById(R.id.title);
        this.O00000Oo = (ProgressBar) findViewById(R.id.progress_bar);
        this.O00000Oo.setIndeterminateDrawable(null);
        this.O0000OOo = findViewById(R.id.bootom_border);
        this.O00000oO = (ProgressBar) findViewById(R.id.loading_bar);
        this.f10531O000000o = new Handler() {
            /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.WebTitleBarView.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (message.what == 1 && WebTitleBarView.this.O00000Oo.getProgress() < WebTitleBarView.this.O00000o0) {
                    WebTitleBarView.this.O00000Oo.setProgress(WebTitleBarView.this.O00000Oo.getProgress() + 1);
                    WebTitleBarView.this.O00000Oo.postInvalidate();
                    WebTitleBarView.this.f10531O000000o.sendEmptyMessageDelayed(1, (long) ((((int) (Math.random() * 5.0d)) + 2) * 50));
                }
            }
        };
        this.O0000O0o = new hln(getContext(), (TitleBarMenu) findViewById(R.id.option_menu));
        this.O0000O0o.O00000o0 = new hln.O00000o0() {
            /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.WebTitleBarView.AnonymousClass2 */

            public final void O000000o(View view, TitleBarMenu.O000000o o000000o, String str) {
                if (WebTitleBarView.this.O00000o != null) {
                    WebTitleBarView.this.O00000o.O000000o(view, o000000o, str);
                }
            }
        };
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.$$Lambda$WebTitleBarView$rW186YIbuuYBisYYB7CJIj9Uv80 */

            public final void onClick(View view) {
                WebTitleBarView.this.O00000Oo(view);
            }
        });
        this.O0000O0o.O00000o = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.$$Lambda$WebTitleBarView$_nF5KdC1X1_MrXKbRocjSYat6U */

            public final void onClick(View view) {
                WebTitleBarView.this.O000000o(view);
            }
        };
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O00000o0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
    }

    public void setOmitMenu(boolean z) {
        hln hln = this.O0000O0o;
        if (hln != null && hln.O00000Oo != null) {
            hln.O00000Oo.setOmit(z);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hlp.O000000o(android.webkit.WebView, java.lang.String):io.reactivex.Observable<java.lang.String>
     arg types: [com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView, java.lang.String]
     candidates:
      _m_j.hlp.O000000o(java.lang.Object, java.lang.String):T
      _m_j.hlp.O000000o(android.webkit.WebView, java.lang.String):io.reactivex.Observable<java.lang.String> */
    @SuppressLint({"CheckResult"})
    private void setupShareMenuOnTitleReadyOnThirdOnce(String str) {
        if (this.O0000OoO != null && !this.O0000o0O && !this.O0000o00) {
            this.O0000o0O = true;
            if (Build.VERSION.SDK_INT >= 19) {
                hlp.O000000o((WebView) this.O0000OoO, "window.hasOwnProperty('smartHome')").subscribe(new Consumer() {
                    /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.$$Lambda$WebTitleBarView$IImKOYdA28UelNqTJSi6v1C_llU */

                    public final void accept(Object obj) {
                        WebTitleBarView.this.O00000o0((String) obj);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(String str) throws Exception {
        if (!Boolean.parseBoolean(str) && !this.O0000o00) {
            this.O0000O0o.O000000o();
        }
    }

    public void setWebView(CommonWebView commonWebView) {
        this.O0000OoO = commonWebView;
    }

    public void setFixedTitleText(boolean z) {
        this.O0000o0 = z;
    }

    public static class O00000Oo implements O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private O000000o f10535O000000o;

        public O00000Oo() {
        }

        public O00000Oo(O000000o o000000o) {
            this.f10535O000000o = o000000o;
        }

        public final void O000000o(View view, TitleBarMenu.O000000o o000000o, String str) {
            O000000o o000000o2 = this.f10535O000000o;
            if (o000000o2 != null) {
                o000000o2.O000000o(view, o000000o, str);
            }
        }

        public final void O00000Oo() {
            O000000o o000000o = this.f10535O000000o;
            if (o000000o != null) {
                o000000o.O00000Oo();
            }
        }

        public void O000000o() {
            O000000o o000000o = this.f10535O000000o;
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }

        public final void O000000o(boolean z) {
            O000000o o000000o = this.f10535O000000o;
            if (o000000o != null) {
                o000000o.O000000o(z);
            }
        }

        public final void O00000o0() {
            O000000o o000000o = this.f10535O000000o;
            if (o000000o != null) {
                o000000o.O00000o0();
            }
        }
    }

    public void setTitleBarActionReceiver(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public void setDefaultTitle(String str) {
        if (O00000Oo(str)) {
            this.O00000oo.setText(str);
            this.O0000Oo0 = str;
        }
    }

    private static boolean O00000Oo(String str) {
        if (!TextUtils.isEmpty(str) && !str.trim().startsWith("https://") && !str.trim().startsWith("http://")) {
            return true;
        }
        return false;
    }

    public void setNavigationBar(String str) {
        try {
            this.O0000Oo.setImageDrawable(new ColorDrawable(-1));
            setBackgroundColor(-1);
            this.O0000OOo.setBackgroundColor(-1);
            if (!TextUtils.isEmpty(this.O0000Oo0)) {
                this.O00000oo.setText(this.O0000Oo0);
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("backgroundImage");
            String optString3 = jSONObject.optString("backgroundColor", "");
            String optString4 = jSONObject.optString("borderBottomColor", "");
            boolean optBoolean = jSONObject.optBoolean("reset", false);
            Bitmap O000000o2 = hlp.O000000o(optString2);
            if (O000000o2 != null) {
                this.O0000Oo.setImageBitmap(O000000o2);
                this.O0000OOo.setBackgroundColor(0);
                return;
            }
            if (!TextUtils.isEmpty(optString)) {
                this.O00000oo.setText(optString);
            }
            if (optBoolean) {
                this.O0000Oo.setImageDrawable(new ColorDrawable(-1));
                setBackgroundColor(-1);
                this.O0000OOo.setBackgroundColor(-1);
            } else if (!TextUtils.isEmpty(optString3)) {
                int parseColor = Color.parseColor(optString3);
                this.O0000Oo.setImageDrawable(new ColorDrawable(parseColor));
                setBackgroundColor(parseColor);
                this.O0000OOo.setBackgroundColor(parseColor);
            }
            if (!optBoolean && TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                this.O0000OOo.setBackgroundColor(Color.parseColor(optString4));
            }
        } catch (Exception e) {
            gsy.O000000o(6, "WebViewTitleBar", "setNavigationBar: " + Log.getStackTraceString(e));
        }
    }

    public void setNavigationBarLoading(String str) {
        boolean z;
        int i = 0;
        try {
            z = new JSONObject(str).optBoolean("enabled", false);
        } catch (JSONException e) {
            e.printStackTrace();
            z = false;
        }
        ProgressBar progressBar = this.O00000oO;
        if (!z) {
            i = 8;
        }
        progressBar.setVisibility(i);
    }

    public final void O000000o(String str) {
        if (O00000Oo(str)) {
            if (this.O0000o0) {
                this.O00000oo.setText(this.O0000Oo0);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.O00000oo.setText(str);
            } else {
                this.O00000oo.setText(this.O0000Oo0);
            }
            setupShareMenuOnTitleReadyOnThirdOnce(str);
        }
    }

    public final void O000000o(int i) {
        Handler handler;
        if (i >= this.O00000o0) {
            this.O00000Oo.setVisibility(0);
            Handler handler2 = this.f10531O000000o;
            if (handler2 != null) {
                handler2.removeMessages(1);
                if (i >= this.O00000Oo.getProgress()) {
                    double d = (double) i;
                    Double.isNaN(d);
                    int i2 = (int) (d * 1.1d);
                    if (i2 <= 99) {
                        this.O00000Oo.setProgress(i2);
                        this.O00000Oo.postInvalidate();
                    }
                }
            }
        }
        if (i >= 90 && (handler = this.f10531O000000o) != null) {
            handler.removeMessages(1);
            this.O00000Oo.setVisibility(8);
        }
    }

    public void setShareButtonEnable(boolean z) {
        if (!z) {
            this.O0000o00 = true;
        }
        gsy.O00000Oo("WebViewTitleBar", "setShareButtonEnable: enable: ".concat(String.valueOf(z)));
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (z) {
            this.O0000O0o.O000000o();
        } else {
            this.O0000O0o.O00000Oo();
        }
    }

    public final void O000000o(boolean z) {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O000000o(z);
        }
    }

    public void setOptionButton(String str) {
        TitleBarMenu.O000000o o000000o;
        hln hln = this.O0000O0o;
        gsy.O00000Oo("TitleBarMenuAdapter", "setOptionButton: ".concat(String.valueOf(str)));
        hln.O000000o O000000o2 = hln.O000000o.O000000o(str);
        if (O000000o2 == null) {
            return;
        }
        if (O000000o2.O00000Oo) {
            hln.O00000Oo.setOptionsMenu(Collections.emptyList());
            hln.O000000o();
        } else if (O000000o2.O00000o0 == null || O000000o2.O00000o0.isEmpty()) {
            hln.O00000Oo.setOptionsMenu(Collections.emptyList());
            hln.O00000Oo();
        } else {
            ArrayList arrayList = new ArrayList();
            for (hln.O000000o.C0116O000000o next : O000000o2.O00000o0) {
                if (TextUtils.equals("share", next.O00000o0)) {
                    o000000o = new hln.O00000Oo(String.valueOf(next.f19048O000000o), "", O000000o2) {
                        /* class _m_j.hln.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000000o f19043O000000o;

                        {
                            this.f19043O000000o = r4;
                        }

                        public final void O000000o(View view, TitleBarMenu.O000000o o000000o) {
                            if (hln.this.O00000o != null) {
                                hln.this.O00000o.onClick(view);
                            }
                            hln.this.O000000o(view, o000000o, this.f19043O000000o.f19047O000000o);
                        }
                    };
                    hln.O00000Oo();
                } else {
                    Bitmap O000000o3 = hlp.O000000o(next.O00000Oo);
                    hln.AnonymousClass3 r6 = new TitleBarMenu.O000000o(String.valueOf(next.f19048O000000o), "", O000000o2) {
                        /* class _m_j.hln.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000000o f19044O000000o;

                        {
                            this.f19044O000000o = r4;
                        }

                        public final void O000000o(View view, TitleBarMenu.O000000o o000000o) {
                            hln.this.O000000o(view, o000000o, this.f19044O000000o.f19047O000000o);
                        }
                    };
                    r6.O00000o = O000000o3;
                    o000000o = r6;
                }
                o000000o.O00000oo = next.O00000o;
                arrayList.add(o000000o);
            }
            hln.O00000Oo.setOptionsMenu(arrayList);
        }
    }

    public void setPopMenu(String str) {
        TitleBarMenu.O000000o o000000o;
        hln hln = this.O0000O0o;
        gsy.O00000Oo("TitleBarMenuAdapter", "setDropDownMenu: ".concat(String.valueOf(str)));
        hln.O00000o O000000o2 = hln.O00000o.O000000o(str);
        if (O000000o2 == null) {
            return;
        }
        if (!O000000o2.f19049O000000o || O000000o2.O00000o0 == null || O000000o2.O00000o0.isEmpty()) {
            hln.O00000Oo.O000000o();
            hln.O000000o();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (hln.O00000o.O000000o next : O000000o2.O00000o0) {
            if (TextUtils.equals("share", next.O00000o0)) {
                if (TextUtils.isEmpty(next.O00000Oo)) {
                    next.O00000Oo = hln.f19041O000000o.getString(R.string.share_title);
                }
                o000000o = new hln.O00000Oo(String.valueOf(next.f19050O000000o), next.O00000Oo, O000000o2) {
                    /* class _m_j.hln.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O00000o f19045O000000o;

                    {
                        this.f19045O000000o = r4;
                    }

                    public final void O000000o(View view, TitleBarMenu.O000000o o000000o) {
                        if (hln.this.O00000o != null) {
                            hln.this.O00000o.onClick(view);
                        }
                        hln.this.O000000o(view, o000000o, this.f19045O000000o.O00000Oo);
                    }
                };
                hln.O00000Oo();
            } else {
                o000000o = new TitleBarMenu.O000000o(String.valueOf(next.f19050O000000o), next.O00000Oo, O000000o2) {
                    /* class _m_j.hln.AnonymousClass5 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O00000o f19046O000000o;

                    {
                        this.f19046O000000o = r4;
                    }

                    public final void O000000o(View view, TitleBarMenu.O000000o o000000o) {
                        hln.this.O000000o(view, o000000o, this.f19046O000000o.O00000Oo);
                    }
                };
                if (!TextUtils.isEmpty(next.O00000o)) {
                    o000000o.O00000o = hlp.O000000o(next.O00000o);
                }
            }
            o000000o.O00000oo = next.O00000oO;
            arrayList.add(o000000o);
        }
        hln.O00000Oo.setDropDownMenu(arrayList);
        hln.O000000o();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10531O000000o.removeCallbacksAndMessages(null);
    }
}

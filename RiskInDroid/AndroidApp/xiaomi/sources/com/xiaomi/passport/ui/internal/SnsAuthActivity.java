package com.xiaomi.passport.ui.internal;

import _m_j.ehh;
import _m_j.ixe;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SnsAuthActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mProgressHolder", "Lcom/xiaomi/passport/ui/internal/ProgressHolder;", "mWebView", "Landroid/webkit/WebView;", "getMWebView", "()Landroid/webkit/WebView;", "setMWebView", "(Landroid/webkit/WebView;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class SnsAuthActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap f6258O000000o;
    public final ehh mProgressHolder = new ehh();
    public WebView mWebView;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f6258O000000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.f6258O000000o == null) {
            this.f6258O000000o = new HashMap();
        }
        View view = (View) this.f6258O000000o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f6258O000000o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final WebView getMWebView() {
        WebView webView = this.mWebView;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        return webView;
    }

    public final void setMWebView(WebView webView) {
        ixe.O00000o0(webView, "<set-?>");
        this.mWebView = webView;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.widget.TextView, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.passport_webview_layout);
        setSupportActionBar((Toolbar) findViewById(R$id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            ixe.O000000o();
        }
        supportActionBar.O000000o(true);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 == null) {
            ixe.O000000o();
        }
        supportActionBar2.O000000o();
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 == null) {
            ixe.O000000o();
        }
        supportActionBar3.O00000Oo();
        TextView textView = (TextView) _$_findCachedViewById(R$id.close_btn);
        ixe.O000000o((Object) textView, "close_btn");
        textView.setVisibility(0);
        ((TextView) _$_findCachedViewById(R$id.close_btn)).setOnClickListener(new O000000o(this));
        Context context = this;
        this.mWebView = new O00000Oo(this, context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        WebView webView = this.mWebView;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        webView.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R$id.webview_container);
        WebView webView2 = this.mWebView;
        if (webView2 == null) {
            ixe.O000000o("mWebView");
        }
        relativeLayout.addView(webView2);
        this.mProgressHolder.O000000o(context);
        WebView webView3 = this.mWebView;
        if (webView3 == null) {
            ixe.O000000o("mWebView");
        }
        webView3.loadUrl(getIntent().getStringExtra("url"));
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ SnsAuthActivity f6259O000000o;

        O000000o(SnsAuthActivity snsAuthActivity) {
            this.f6259O000000o = snsAuthActivity;
        }

        public final void onClick(View view) {
            this.f6259O000000o.finish();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/passport/ui/internal/SnsAuthActivity$onCreate$2", "Lcom/xiaomi/passport/ui/internal/PassportWebView;", "(Lcom/xiaomi/passport/ui/internal/SnsAuthActivity;Landroid/content/Context;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "shouldOverrideUrlLoading", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000Oo extends PassportWebView {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ SnsAuthActivity f6260O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000Oo(SnsAuthActivity snsAuthActivity, Context context) {
            super(context);
            this.f6260O000000o = snsAuthActivity;
        }

        public final boolean O000000o(WebView webView, String str) {
            ixe.O00000o0(str, "url");
            String queryParameter = Uri.parse(str).getQueryParameter("code");
            if (queryParameter == null) {
                return super.O000000o(webView, str);
            }
            Intent intent = new Intent();
            intent.putExtra("code", queryParameter);
            this.f6260O000000o.setResult(-1, intent);
            this.f6260O000000o.finish();
            return true;
        }

        public final void O00000Oo() {
            this.f6260O000000o.mProgressHolder.O000000o();
        }
    }

    public final void onBackPressed() {
        WebView webView = this.mWebView;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        if (webView.canGoBack()) {
            WebView webView2 = this.mWebView;
            if (webView2 == null) {
                ixe.O000000o("mWebView");
            }
            webView2.goBack();
            return;
        }
        super.onBackPressed();
    }
}

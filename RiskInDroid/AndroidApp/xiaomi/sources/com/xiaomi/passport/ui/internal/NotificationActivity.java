package com.xiaomi.passport.ui.internal;

import _m_j.egp;
import _m_j.ekq;
import _m_j.eks;
import _m_j.ixe;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.NotificationAuthResult;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/passport/ui/internal/NotificationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mWebView", "Landroid/webkit/WebView;", "getResources", "Landroid/content/res/Resources;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNeedReLogin", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onPause", "setAddAccountResultAndFinish", "resultCode", "", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "NotificationAuthTaskCallback", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class NotificationActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private WebView f6248O000000o;
    private HashMap O00000Oo;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.O00000Oo;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new HashMap();
        }
        View view = (View) this.O00000Oo.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.O00000Oo.put(Integer.valueOf(i), findViewById);
        return findViewById;
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
        overridePendingTransition(0, 0);
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
        ((TextView) _$_findCachedViewById(R$id.close_btn)).setOnClickListener(new O00000Oo(this));
        String stringExtra = getIntent().getStringExtra("notification_url");
        this.f6248O000000o = new O00000o0(this, this);
        WebView webView = this.f6248O000000o;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        webView.loadUrl(stringExtra);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        WebView webView2 = this.f6248O000000o;
        if (webView2 == null) {
            ixe.O000000o("mWebView");
        }
        webView2.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R$id.webview_container);
        WebView webView3 = this.f6248O000000o;
        if (webView3 == null) {
            ixe.O000000o("mWebView");
        }
        relativeLayout.addView(webView3);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000Oo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f6250O000000o;

        O00000Oo(NotificationActivity notificationActivity) {
            this.f6250O000000o = notificationActivity;
        }

        public final void onClick(View view) {
            this.f6250O000000o.onNeedReLogin();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f"}, d2 = {"com/xiaomi/passport/ui/internal/NotificationActivity$onCreate$2", "Lcom/xiaomi/passport/ui/internal/PassportWebView;", "(Lcom/xiaomi/passport/ui/internal/NotificationActivity;Landroid/content/Context;)V", "onAuthEnd", "", "url", "", "onLoginEnd", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onNeedReLogin", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000o0 extends PassportWebView {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ NotificationActivity f6251O000000o;

        public final void O00000Oo() {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000o0(NotificationActivity notificationActivity, Context context) {
            super(context);
            this.f6251O000000o = notificationActivity;
        }

        public final boolean O000000o(AccountInfo accountInfo) {
            ixe.O00000o0(accountInfo, "accountInfo");
            eks.O00000Oo(this.f6251O000000o, accountInfo);
            this.f6251O000000o.setResult(-1);
            this.f6251O000000o.setAddAccountResultAndFinish(-1, accountInfo);
            return true;
        }

        public final boolean O000000o() {
            O000000o();
            return true;
        }

        public final boolean O000000o(String str) {
            ixe.O00000o0(str, "url");
            new egp(str, new O000000o(this.f6251O000000o)).execute(new Void[0]);
            return true;
        }
    }

    public final void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/NotificationActivity$NotificationAuthTaskCallback;", "Lcom/xiaomi/passport/ui/internal/NotificationAuthTask$NotificationAuthUICallback;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "call", "", "result", "Lcom/xiaomi/accountsdk/account/data/NotificationAuthResult;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o implements egp.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private Activity f6249O000000o;

        public O000000o(Activity activity) {
            ixe.O00000o0(activity, "activity");
            this.f6249O000000o = activity;
        }

        public final void O000000o(NotificationAuthResult notificationAuthResult) {
            if (!this.f6249O000000o.isFinishing()) {
                Intent intent = new Intent();
                if (notificationAuthResult != null) {
                    intent.putExtra("notification_auth_end", notificationAuthResult);
                    this.f6249O000000o.setResult(-1, intent);
                } else {
                    this.f6249O000000o.setResult(0, intent);
                }
                this.f6249O000000o.finish();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.os.Parcelable, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void setAddAccountResultAndFinish(int i, AccountInfo accountInfo) {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("accountAuthenticatorResponse");
        ixe.O000000o((Object) parcelableExtra, "intent.getParcelableExtr…T_AUTHENTICATOR_RESPONSE)");
        eks.O000000o(parcelableExtra, ekq.O000000o(i, accountInfo, getIntent().getBooleanExtra("need_retry_on_authenticator_response_result", false)));
        finish();
    }

    public final void onNeedReLogin() {
        setResult(0);
        finish();
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void onBackPressed() {
        WebView webView = this.f6248O000000o;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        if (webView.canGoBack()) {
            WebView webView2 = this.f6248O000000o;
            if (webView2 == null) {
                ixe.O000000o("mWebView");
            }
            webView2.goBack();
            return;
        }
        super.onBackPressed();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.Context, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.res.Resources, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final Resources getResources() {
        if (Build.VERSION.SDK_INT >= 24) {
            Context applicationContext = getApplicationContext();
            ixe.O000000o((Object) applicationContext, "applicationContext");
            Resources resources = applicationContext.getResources();
            ixe.O000000o((Object) resources, "applicationContext.resources");
            return resources;
        }
        Resources resources2 = super.getResources();
        ixe.O000000o((Object) resources2, "super.getResources()");
        return resources2;
    }
}

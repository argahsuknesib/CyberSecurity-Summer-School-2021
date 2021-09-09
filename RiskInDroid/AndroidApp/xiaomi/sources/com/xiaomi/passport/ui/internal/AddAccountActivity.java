package com.xiaomi.passport.ui.internal;

import _m_j.O0o0000;
import _m_j.ee;
import _m_j.efn;
import _m_j.efp;
import _m_j.eft;
import _m_j.efw;
import _m_j.efx;
import _m_j.egc;
import _m_j.ege;
import _m_j.egt;
import _m_j.ehc;
import _m_j.ehh;
import _m_j.ehq;
import _m_j.ehr;
import _m_j.ei;
import _m_j.eih;
import _m_j.eij;
import _m_j.eik;
import _m_j.ekq;
import _m_j.eks;
import _m_j.ft;
import _m_j.iuo;
import _m_j.ixe;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\rH\u0016J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\u0017H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0016J\"\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0012\u0010.\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\u0012\u00100\u001a\u00020\u00172\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020\u0017H\u0014J\u0010\u00104\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0017H\u0014J\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\rH\u0002J\b\u0010:\u001a\u00020\u0017H\u0002J\b\u0010;\u001a\u00020\u0017H\u0002J\b\u0010<\u001a\u00020\rH\u0016J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0005H\u0002J\b\u0010?\u001a\u00020\u0017H\u0002J\b\u0010@\u001a\u00020\u0017H\u0002J\u001a\u0010A\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\rH\u0002J\b\u0010D\u001a\u00020\u0017H\u0002J\u0010\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020\u0017H\u0002J\u0018\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AddAccountActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/xiaomi/passport/ui/internal/AddAccountListener;", "()V", "TAG", "", "defaultAuthProvider", "Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "mCommonErrorHandler", "Lcom/xiaomi/passport/ui/internal/CommonErrorHandler;", "mGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mKeyboardUp", "", "mProgressHolder", "Lcom/xiaomi/passport/ui/internal/ProgressHolder;", "mSid", "mSnsBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mSnsDirectlySignInType", "mWebAuth", "Lcom/xiaomi/passport/ui/internal/WebAuth;", "addGlobalLayoutListener", "", "dismissProgress", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "getResources", "Landroid/content/res/Resources;", "getSupportActionBarHeight", "", "goBack", "closeWebView", "gotoFragment", "fragment", "addToBackStack", "isSnsDirectlySignInMode", "loginCancelled", "loginSuccess", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttachFragment", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onSnsResultReturned", "success", "onSoftKeyboardHidden", "onSoftKeyboardShown", "onSupportNavigateUp", "overrideDefaultAuthProvider", "defaultAuthProviderName", "registerBroadcast", "removeGlobalLayoutListener", "setAddAccountResultAndFinish", "setAllContentVisibility", "visible", "setLoginCancelledResult", "showNetworkError", "e", "Ljava/io/IOException;", "showProgress", "signInWithSnsCredential", "snsAuthProvider", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "authCredential", "Lcom/xiaomi/passport/ui/internal/SNSAuthCredential;", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class AddAccountActivity extends AppCompatActivity implements efp {
    public static final O000000o Companion = new O000000o((byte) 0);
    public static Intent countryChoiceIntent;
    public static String countryName;
    public static String countryNameColor;

    /* renamed from: O000000o  reason: collision with root package name */
    private final ehh f6223O000000o = new ehh();
    private BroadcastReceiver O00000Oo;
    private final ViewTreeObserver.OnGlobalLayoutListener O00000o;
    private String O00000o0;
    private HashMap O00000oO;
    public final String TAG = "AddAccountActivity";
    public efw defaultAuthProvider;
    public final egc mCommonErrorHandler;
    public boolean mKeyboardUp;
    public String mSid;
    public eih mWebAuth = new eih();

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.O00000oO;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.O00000oO == null) {
            this.O00000oO = new HashMap();
        }
        View view = (View) this.O00000oO.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.O00000oO.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void onSoftKeyboardHidden() {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AddAccountActivity$Companion;", "", "()V", "countryChoiceIntent", "Landroid/content/Intent;", "countryName", "", "countryNameColor", "requestCountryNameCode", "", "setCountryChoiceButtonText", "", "setCountryChoiceButtonTextColor", "setCountryChoiceIntent", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public AddAccountActivity() {
        egt egt = egt.f15254O000000o;
        this.defaultAuthProvider = egt.O0000O0o();
        this.mCommonErrorHandler = new egc();
        this.O00000o = new O00000Oo(this);
    }

    public static final /* synthetic */ String access$getMSid$p(AddAccountActivity addAccountActivity) {
        String str = addAccountActivity.mSid;
        if (str == null) {
            ixe.O000000o("mSid");
        }
        return str;
    }

    static {
        O0o0000.O0000o0O();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter("passport_sns_events");
        this.O00000Oo = new AddAccountActivity$registerBroadcast$1(this);
        Context context = this;
        ft O000000o2 = ft.O000000o(context);
        BroadcastReceiver broadcastReceiver = this.O00000Oo;
        if (broadcastReceiver == null) {
            ixe.O000000o("mSnsBroadcastReceiver");
        }
        O000000o2.O000000o(broadcastReceiver, intentFilter);
        setContentView((int) R.layout.add_account_main);
        setSupportActionBar((Toolbar) _$_findCachedViewById(R$id.toolbar));
        AccountLog.d(this.TAG, "addGlobalLayoutListener");
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(this.O00000o);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                ixe.O000000o();
            }
            supportActionBar.O000000o(true);
            supportActionBar.O000000o();
            supportActionBar.O00000Oo();
            String stringExtra = getIntent().getStringExtra("service_id");
            if (stringExtra == null) {
                stringExtra = "passport";
            }
            this.mSid = stringExtra;
            String stringExtra2 = getIntent().getStringExtra("default_auth_provider");
            String stringExtra3 = getIntent().getStringExtra("default_phone_country_code");
            if (stringExtra2 != null) {
                O000000o(stringExtra2);
            }
            if (O00000Oo() == null) {
                efw efw = this.defaultAuthProvider;
                String str = this.mSid;
                if (str == null) {
                    ixe.O000000o("mSid");
                }
                ehc.O000000o O000000o3 = ege.O000000o(context, stringExtra3);
                gotoFragment(efw.O000000o(str, O000000o3 != null ? ege.O000000o(O000000o3) : null), false);
            }
            this.O00000o0 = getIntent().getStringExtra("sns_sign_in");
            if (this.O00000o0 != null) {
                egt egt = egt.f15254O000000o;
                Collection arrayList = new ArrayList();
                for (Object next : egt.O000000o()) {
                    if (next instanceof ehr) {
                        arrayList.add(next);
                    }
                }
                Iterator it = ((List) arrayList).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (ixe.O000000o((Object) ((ehr) obj).f15234O000000o, (Object) this.O00000o0)) {
                        break;
                    }
                }
                ehr ehr = (ehr) obj;
                if (ehr != null) {
                    Activity activity = this;
                    String str2 = this.mSid;
                    if (str2 == null) {
                        ixe.O000000o("mSid");
                    }
                    ehr.O000000o(activity, str2);
                    O000000o(false);
                    return;
                }
                Toast.makeText(context, (int) R.string.passport_access_denied, 1).show();
                setLoginCancelledResult();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    public final int getSupportActionBarHeight() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            return supportActionBar.O00000o();
        }
        return 0;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onGlobalLayout"}, k = 3, mv = {1, 1, 10})
    static final class O00000Oo implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AddAccountActivity f6224O000000o;

        O00000Oo(AddAccountActivity addAccountActivity) {
            this.f6224O000000o = addAccountActivity;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [android.view.View, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onGlobalLayout() {
            View findViewById = this.f6224O000000o.findViewById(16908290);
            if (findViewById != null) {
                int supportActionBarHeight = this.f6224O000000o.getSupportActionBarHeight();
                View rootView = findViewById.getRootView();
                ixe.O000000o((Object) rootView, "rootView.rootView");
                if (rootView.getHeight() - findViewById.getHeight() > supportActionBarHeight + 100) {
                    AccountLog.e(this.f6224O000000o.TAG, "keyboard is shown");
                    if (!this.f6224O000000o.mKeyboardUp) {
                        AddAccountActivity addAccountActivity = this.f6224O000000o;
                        addAccountActivity.mKeyboardUp = true;
                        addAccountActivity.onSoftKeyboardShown();
                    }
                } else if (this.f6224O000000o.mKeyboardUp) {
                    AccountLog.e(this.f6224O000000o.TAG, "keyboard is hidden");
                    AddAccountActivity addAccountActivity2 = this.f6224O000000o;
                    addAccountActivity2.mKeyboardUp = false;
                    addAccountActivity2.onSoftKeyboardHidden();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
            }
        }
    }

    public final void onSoftKeyboardShown() {
        _$_clearFindViewByIdCache();
        View findViewById = findViewById(R$id.sign_in_title_container);
        if (findViewById != null) {
            ScrollView scrollView = (ScrollView) findViewById(R$id.scroll_view_container);
            if (findViewById != null && scrollView != null) {
                findViewById.postDelayed(new O0000O0o(findViewById, scrollView), 50);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 10})
    static final class O0000O0o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ View f6227O000000o;
        final /* synthetic */ ScrollView O00000Oo;

        O0000O0o(View view, ScrollView scrollView) {
            this.f6227O000000o = view;
            this.O00000Oo = scrollView;
        }

        public final void run() {
            this.O00000Oo.smoothScrollTo(0, this.f6227O000000o.getHeight());
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        ixe.O00000o0(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            efn.O000000o("common_click_return_button");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final void O000000o(boolean z) {
        View findViewById = findViewById(16908290);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        } else if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    private final void O000000o(String str) {
        egt egt = egt.f15254O000000o;
        Collection arrayList = new ArrayList();
        Iterator it = egt.O000000o().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            eft eft = (eft) next;
            if (ixe.O000000o((Object) eft.f15234O000000o, (Object) str) && (eft instanceof efw)) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        eft eft2 = (eft) iuo.O000000o((List) arrayList, 0);
        if (eft2 != null) {
            this.defaultAuthProvider = (efw) eft2;
        }
    }

    public final void onAttachFragment(Fragment fragment) {
        TextView textView;
        super.onAttachFragment(fragment);
        if (fragment == null || !(fragment instanceof eij)) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R$id.help_center);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R$id.help_center);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        if (fragment == null || !(fragment instanceof efx) || countryName == null) {
            TextView textView2 = (TextView) _$_findCachedViewById(R$id.country_choice_btn);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(R$id.country_choice_btn);
            if (textView3 != null) {
                textView3.setText(countryName);
            }
            if (!(countryNameColor == null || (textView = (TextView) _$_findCachedViewById(R$id.country_choice_btn)) == null)) {
                textView.setTextColor(Color.parseColor(countryNameColor));
            }
            TextView textView4 = (TextView) _$_findCachedViewById(R$id.country_choice_btn);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = (TextView) _$_findCachedViewById(R$id.country_choice_btn);
            if (textView5 != null) {
                textView5.setOnClickListener(new O00000o0(this));
            }
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R$id.help_center);
        if (imageView3 != null) {
            imageView3.setOnClickListener(new O00000o(this));
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o0 implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AddAccountActivity f6226O000000o;

        O00000o0(AddAccountActivity addAccountActivity) {
            this.f6226O000000o = addAccountActivity;
        }

        public final void onClick(View view) {
            if (AddAccountActivity.countryChoiceIntent != null) {
                this.f6226O000000o.startActivityForResult(AddAccountActivity.countryChoiceIntent, 2020);
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AddAccountActivity f6225O000000o;

        O00000o(AddAccountActivity addAccountActivity) {
            this.f6225O000000o = addAccountActivity;
        }

        public final void onClick(View view) {
            eik.O000000o o000000o = eik.f15320O000000o;
            eik.O000000o.O000000o(this.f6225O000000o, "https://account.xiaomi.com/helpcenter");
        }
    }

    public final void onResume() {
        super.onResume();
        ehr.O000000o o000000o = ehr.O0000O0o;
        ehq ehq = ehr.O00000oo;
        if (ehq != null) {
            ehr.O000000o o000000o2 = ehr.O0000O0o;
            ehr.O00000oo = null;
            egt egt = egt.f15254O000000o;
            eft O000000o2 = egt.O000000o(ehq);
            if (O000000o2 != null) {
                O000000o((ehr) O000000o2, ehq);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.SNSAuthProvider");
        }
    }

    public final boolean isSnsDirectlySignInMode() {
        return !TextUtils.isEmpty(this.O00000o0);
    }

    public final void onDestroy() {
        dismissProgress();
        ft O000000o2 = ft.O000000o(this);
        BroadcastReceiver broadcastReceiver = this.O00000Oo;
        if (broadcastReceiver == null) {
            ixe.O000000o("mSnsBroadcastReceiver");
        }
        O000000o2.O000000o(broadcastReceiver);
        AccountLog.d(this.TAG, "removeGlobalLayoutListener");
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            findViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this.O00000o);
            super.onDestroy();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        egt egt = egt.f15254O000000o;
        Collection arrayList = new ArrayList();
        for (Object next : egt.O000000o()) {
            if (next instanceof ehr) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        Iterator it = ((List) arrayList).iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next2 = it.next();
            if (((ehr) next2).O000000o() != i) {
                z2 = false;
            }
            if (z2) {
                arrayList2.add(next2);
            }
        }
        Collection arrayList3 = new ArrayList();
        for (Object next3 : (List) arrayList2) {
            ehr ehr = (ehr) next3;
            ehr.O000000o(this, i, i2, intent);
            ehr.O000000o o000000o = ehr.O0000O0o;
            ehq ehq = ehr.O00000oo;
            onSnsResultReturned(ehq != null);
            if (ehq != null) {
                ehr.O000000o o000000o2 = ehr.O0000O0o;
                ehr.O00000oo = null;
                O000000o(ehr, ehq);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList3.add(next3);
            }
        }
        if (i == 2020 && i2 == -1) {
            if (intent == null) {
                ixe.O000000o();
            }
            String stringExtra = intent.getStringExtra("countryName");
            TextView textView = (TextView) _$_findCachedViewById(R$id.country_choice_btn);
            if (textView != null) {
                textView.setText(stringExtra);
            }
            countryName = stringExtra;
        }
    }

    public final void onSnsResultReturned(boolean z) {
        if (isSnsDirectlySignInMode() && z) {
            O000000o(true);
        }
    }

    private final void O000000o(ehr ehr, ehq ehq) {
        O000000o();
        ehr.O00000Oo(this, ehq).O000000o(new AddAccountActivity$signInWithSnsCredential$1(this), new AddAccountActivity$signInWithSnsCredential$2(this, ehr));
    }

    public final void loginSuccess(AccountInfo accountInfo) {
        ixe.O00000o0(accountInfo, "accountInfo");
        O000000o(-1, accountInfo);
    }

    public final void loginCancelled() {
        setLoginCancelledResult();
    }

    private final void O000000o() {
        this.f6223O000000o.O000000o(this);
    }

    public final void dismissProgress() {
        this.f6223O000000o.O000000o();
    }

    public final void showNetworkError(IOException iOException) {
        this.mCommonErrorHandler.O000000o(iOException, this, (ConstraintLayout) _$_findCachedViewById(R$id.fragment_main));
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public final void onBackPressed() {
        goBack(false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [_m_j.ee, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void goBack(boolean z) {
        TextView textView;
        Fragment O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null && (O00000Oo2 instanceof eij)) {
            eij eij = (eij) O00000Oo2;
            if (eij.O00000o0() && !z) {
                eij.O00000o();
                return;
            }
        }
        ee supportFragmentManager = getSupportFragmentManager();
        ixe.O000000o((Object) supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.O00000oO() > 0) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R$id.help_center);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (!(countryName == null || (textView = (TextView) _$_findCachedViewById(R$id.country_choice_btn)) == null)) {
                textView.setVisibility(0);
            }
            getSupportFragmentManager().O00000o0();
            return;
        }
        setLoginCancelledResult();
    }

    public final void setLoginCancelledResult() {
        O000000o(0, (AccountInfo) null);
    }

    private final void O000000o(int i, AccountInfo accountInfo) {
        eks.O000000o(getIntent().getParcelableExtra("accountAuthenticatorResponse"), ekq.O000000o(i, accountInfo, getIntent().getBooleanExtra("need_retry_on_authenticator_response_result", false)));
        ehr.O000000o o000000o = ehr.O0000O0o;
        ehr.O00000oO = null;
        setResult(i);
        if (!isFinishing()) {
            finish();
        }
    }

    public final void gotoFragment(Fragment fragment, boolean z) {
        ixe.O00000o0(fragment, "fragment");
        ei O00000Oo2 = getSupportFragmentManager().O000000o().O00000Oo(R$id.fragment_container, fragment);
        if (z) {
            O00000Oo2 = O00000Oo2.O000000o((String) null);
        }
        O00000Oo2.O00000o0();
    }

    private final Fragment O00000Oo() {
        return getSupportFragmentManager().O000000o(R$id.fragment_container);
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

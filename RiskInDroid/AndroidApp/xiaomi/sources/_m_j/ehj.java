package _m_j;

import _m_j.ehc;
import _m_j.ehi;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.AreaCodePickerActivity;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0005J\"\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J(\u0010,\u001a\u0004\u0018\u00010#2\b\b\u0001\u0010-\u001a\u00020.2\b\u0010\"\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001c\u00102\u001a\u00020\u001f2\b\b\u0001\u00103\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u0005H\u0016J\u0010\u00106\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u0005H\u0016J \u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u001fH\u0002J\u0016\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006A"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PswSignInFragment;", "Lcom/xiaomi/passport/ui/internal/BaseSignInFragment;", "Lcom/xiaomi/passport/ui/internal/PswSignInContract$View;", "()V", "TAG", "", "closeCountryCode", "", "getCloseCountryCode", "()Ljava/lang/Boolean;", "setCloseCountryCode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mSignInUserId", "getMSignInUserId", "()Ljava/lang/String;", "setMSignInUserId", "(Ljava/lang/String;)V", "phoneAuthProvider", "Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "getPhoneAuthProvider", "()Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "setPhoneAuthProvider", "(Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;)V", "presenter", "Lcom/xiaomi/passport/ui/internal/PswSignInContract$Presenter;", "getPresenter", "()Lcom/xiaomi/passport/ui/internal/PswSignInContract$Presenter;", "setPresenter", "(Lcom/xiaomi/passport/ui/internal/PswSignInContract$Presenter;)V", "adjustUserIdLeftPadding", "", "adjust", "getCountryCode", "container", "Landroid/view/View;", "isNumber", "input", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showPswError", "msg", "showUserNameError", "showVStep2Code", "authCredential", "Lcom/xiaomi/passport/ui/internal/IdPswBaseAuthCredential;", "step1Token", "metaLoginData", "Lcom/xiaomi/accountsdk/account/data/MetaLoginData;", "specifyUserId", "updateCountryCodeContainer", "isShow", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehj extends efx implements ehi.O00000Oo {
    public static final O000000o O0000O0o = new O000000o((byte) 0);
    efw O00000o;
    public ehi.O000000o O00000o0;
    String O00000oO;
    Boolean O00000oo;
    private HashMap O0000o0;
    private final String O0000o00 = "PswSignInFragment";

    public final View O000000o(int i) {
        if (this.O0000o0 == null) {
            this.O0000o0 = new HashMap();
        }
        View view = (View) this.O0000o0.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.O0000o0.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void O000000o() {
        HashMap hashMap = this.O0000o0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O000000o();
    }

    public ehj() {
        super("ID_PSW_AUTH_PROVIDER");
        egt egt = egt.f15254O000000o;
        this.O00000o = egt.O00000Oo("PHONE_SMS_AUTH_PROVIDER");
        this.O00000oo = Boolean.FALSE;
    }

    public final ehi.O000000o O00000Oo() {
        ehi.O000000o o000000o = this.O00000o0;
        if (o000000o == null) {
            ixe.O000000o("presenter");
        }
        return o000000o;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PswSignInFragment$Companion;", "", "()V", "newInstance", "Lcom/xiaomi/passport/ui/internal/PswSignInFragment;", "sid", "", "userId", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public static ehj O000000o(String str, String str2) {
            ixe.O00000o0(str, "sid");
            ehj ehj = new ehj();
            Bundle bundle = new Bundle();
            bundle.putString("sid", str);
            bundle.putString("userId", str2);
            ehj.setArguments(bundle);
            return ehj;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o0(layoutInflater, "inflater");
        return layoutInflater.inflate((int) R.layout.fg_psw_signin, viewGroup, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.widget.AutoCompleteTextView, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.view.View, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.widget.TextView, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.google.android.material.textfield.TextInputLayout, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void onViewCreated(View view, Bundle bundle) {
        ixe.O00000o0(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        ehi.O000000o o000000o = this.O00000o0;
        if (o000000o == null) {
            ixe.O000000o("presenter");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367043, o000000o.O000000o());
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) O000000o(R$id.userId);
        ixe.O000000o((Object) autoCompleteTextView, "userId");
        autoCompleteTextView.setThreshold(0);
        ((AutoCompleteTextView) O000000o(R$id.userId)).setAdapter(arrayAdapter);
        View findViewById = view.findViewById(R$id.passport_contry_code_container);
        ixe.O000000o((Object) findViewById, "view.findViewById(R.id.p…rt_contry_code_container)");
        ((Button) O000000o(R$id.sign_in_btn)).setOnClickListener(new O00000Oo(this, findViewById));
        ((TextView) O000000o(R$id.action_find_psw)).setOnClickListener(new O00000o0(this));
        ((TextView) O000000o(R$id.action_goto_siginup_from_psw)).setOnClickListener(new O00000o(this));
        ((TextView) O000000o(R$id.action_ph_ticket_signin)).setOnClickListener(new O0000O0o(this));
        Bundle arguments = getArguments();
        if (arguments == null) {
            ixe.O000000o();
        }
        this.O00000oO = arguments.getString("userId");
        if (this.O00000oO != null) {
            TextView textView = (TextView) O000000o(R$id.sign_in_user_id_text);
            ixe.O000000o((Object) textView, "sign_in_user_id_text");
            textView.setVisibility(0);
            TextView textView2 = (TextView) O000000o(R$id.sign_in_user_id_text);
            ixe.O000000o((Object) textView2, "sign_in_user_id_text");
            textView2.setText(getString(R.string.passport_user_id_intro, this.O00000oO));
            TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.userId_wapper);
            ixe.O000000o((Object) textInputLayout, "userId_wapper");
            textInputLayout.setVisibility(8);
            TextView textView3 = (TextView) O000000o(R$id.action_ph_ticket_signin);
            ixe.O000000o((Object) textView3, "action_ph_ticket_signin");
            textView3.setVisibility(8);
            TextView textView4 = (TextView) O000000o(R$id.action_goto_siginup_from_psw);
            ixe.O000000o((Object) textView4, "action_goto_siginup_from_psw");
            textView4.setVisibility(8);
        }
        ((ImageView) O000000o(R$id.passport_close_country_code_text)).setOnClickListener(new O0000OOo(this, findViewById));
        ((AutoCompleteTextView) O000000o(R$id.userId)).addTextChangedListener(new O0000Oo0(this, findViewById));
        ((TextView) O000000o(R$id.passport_country_code_text)).setOnClickListener(new O0000Oo(this));
        ((TextInputEditText) O000000o(R$id.password)).addTextChangedListener(new O0000o00(this));
        if (this.f15235O000000o != null) {
            TextView textView5 = (TextView) O000000o(R$id.passport_country_code_text);
            ixe.O000000o((Object) textView5, "passport_country_code_text");
            textView5.setText(this.f15235O000000o);
        } else {
            TextView textView6 = (TextView) O000000o(R$id.passport_country_code_text);
            ixe.O000000o((Object) textView6, "passport_country_code_text");
            O000000o(textView6);
        }
        Analytics.O000000o("setting_", "pwd_login_page");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000Oo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15284O000000o;
        final /* synthetic */ View O00000Oo;

        O00000Oo(ehj ehj, View view) {
            this.f15284O000000o = ehj;
            this.O00000Oo = view;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [android.widget.TextView, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [android.widget.AutoCompleteTextView, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [com.google.android.material.textfield.TextInputEditText, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onClick(View view) {
            String str;
            String str2;
            if (!this.f15284O000000o.O0000O0o().isUserAgreedProtocol()) {
                Toast.makeText(this.f15284O000000o.getActivity(), (int) R.string.passport_error_user_agreement_error, 0).show();
                return;
            }
            if (this.f15284O000000o.O00000oO != null) {
                str = this.f15284O000000o.O00000oO;
            } else {
                StringBuilder sb = new StringBuilder();
                ehj ehj = this.f15284O000000o;
                if (this.O00000Oo.getVisibility() == 0) {
                    TextView textView = (TextView) ehj.O000000o(R$id.passport_country_code_text);
                    ixe.O000000o((Object) textView, "passport_country_code_text");
                    if (textView.getVisibility() == 0) {
                        TextView textView2 = (TextView) ehj.O000000o(R$id.passport_country_code_text);
                        ixe.O000000o((Object) textView2, "passport_country_code_text");
                        str2 = textView2.getText().toString();
                        sb.append(str2);
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f15284O000000o.O000000o(R$id.userId);
                        ixe.O000000o((Object) autoCompleteTextView, "userId");
                        sb.append(autoCompleteTextView.getText().toString());
                        str = sb.toString();
                    }
                }
                str2 = "";
                sb.append(str2);
                AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) this.f15284O000000o.O000000o(R$id.userId);
                ixe.O000000o((Object) autoCompleteTextView2, "userId");
                sb.append(autoCompleteTextView2.getText().toString());
                str = sb.toString();
            }
            TextInputEditText textInputEditText = (TextInputEditText) this.f15284O000000o.O000000o(R$id.password);
            ixe.O000000o((Object) textInputEditText, "password");
            String obj = textInputEditText.getText().toString();
            if (TextUtils.isEmpty(str)) {
                ehj ehj2 = this.f15284O000000o;
                String string = ehj2.getString(R.string.passport_empty_user_name);
                ixe.O000000o((Object) string, "getString(R.string.passport_empty_user_name)");
                ehj2.O000000o(string);
            } else if (TextUtils.isEmpty(obj)) {
                ehj ehj3 = this.f15284O000000o;
                String string2 = ehj3.getString(R.string.passport_empty_password);
                ixe.O000000o((Object) string2, "getString(R.string.passport_empty_password)");
                ehj3.O00000Oo(string2);
            } else {
                ehi.O000000o O00000Oo2 = this.f15284O000000o.O00000Oo();
                if (str == null) {
                    ixe.O000000o();
                }
                TextView textView3 = (TextView) this.f15284O000000o.O000000o(R$id.passport_country_code_text);
                ixe.O000000o((Object) textView3, "passport_country_code_text");
                O00000Oo2.O000000o(str, obj, textView3.getText().toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o0 implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15286O000000o;

        O00000o0(ehj ehj) {
            this.f15286O000000o = ehj;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void
         arg types: [_m_j.ehu, int]
         candidates:
          _m_j.ehj.O000000o(boolean, android.view.View):void
          _m_j.ehu.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.ehu.O000000o(java.lang.String, _m_j.iar$O00000Oo):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void */
        public final void onClick(View view) {
            efn.O000000o("password_click_forgot_password");
            ehj ehj = this.f15286O000000o;
            Bundle arguments = ehj.getArguments();
            if (arguments == null) {
                ixe.O000000o();
            }
            String string = arguments.getString("sid");
            ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
            ixe.O00000o0(string, "sid");
            ehj.O000000o((Fragment) eih.O00000Oo(string, URLs.ACCOUNT_DOMAIN + "/pass/forgetPassword"), true);
            Analytics.O00000Oo("forgetpwd_link");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15285O000000o;

        O00000o(ehj ehj) {
            this.f15285O000000o = ehj;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void
         arg types: [_m_j.ehu, int]
         candidates:
          _m_j.ehj.O000000o(boolean, android.view.View):void
          _m_j.ehu.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.ehu.O000000o(java.lang.String, _m_j.iar$O00000Oo):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void */
        public final void onClick(View view) {
            efn.O000000o("password_click_sign_up");
            ehj ehj = this.f15285O000000o;
            Bundle arguments = ehj.getArguments();
            if (arguments == null) {
                ixe.O000000o();
            }
            String string = arguments.getString("sid");
            ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
            Context context = this.f15285O000000o.getContext();
            if (context == null) {
                ixe.O000000o();
            }
            ehc.O000000o O000000o2 = ege.O000000o(context, this.f15285O000000o.f15235O000000o);
            ehj.O000000o((Fragment) eih.O000000o(string, O000000o2 != null ? O000000o2.O00000o0 : null), true);
            Analytics.O00000Oo("register_link");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000O0o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15287O000000o;

        O0000O0o(ehj ehj) {
            this.f15287O000000o = ehj;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onClick(View view) {
            ehj ehj = this.f15287O000000o;
            efw efw = ehj.O00000o;
            Bundle arguments = this.f15287O000000o.getArguments();
            if (arguments == null) {
                ixe.O000000o();
            }
            String string = arguments.getString("sid");
            ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
            ehj.O000000o(efw.O000000o(string, this.f15287O000000o.f15235O000000o), false);
            Analytics.O00000Oo("phone_login_link");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000OOo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15288O000000o;
        final /* synthetic */ View O00000Oo;

        O0000OOo(ehj ehj, View view) {
            this.f15288O000000o = ehj;
            this.O00000Oo = view;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ehj.O000000o(boolean, android.view.View):void
         arg types: [int, android.view.View]
         candidates:
          _m_j.ehu.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void
          _m_j.ehu.O000000o(java.lang.String, _m_j.iar$O00000Oo):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.eht.O000000o.O000000o(androidx.fragment.app.Fragment, boolean):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.eht.O000000o.O000000o(androidx.fragment.app.Fragment, boolean):void
          _m_j.ehj.O000000o(boolean, android.view.View):void */
        public final void onClick(View view) {
            this.f15288O000000o.O000000o(false, this.O00000Oo);
            this.f15288O000000o.O00000oo = Boolean.TRUE;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/xiaomi/passport/ui/internal/PswSignInFragment$onViewCreated$6", "Landroid/text/TextWatcher;", "(Lcom/xiaomi/passport/ui/internal/PswSignInFragment;Landroid/view/View;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O0000Oo0 implements TextWatcher {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15290O000000o;
        final /* synthetic */ View O00000Oo;

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        O0000Oo0(ehj ehj, View view) {
            this.f15290O000000o = ehj;
            this.O00000Oo = view;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ehj.O000000o(boolean, android.view.View):void
         arg types: [int, android.view.View]
         candidates:
          _m_j.ehu.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void
          _m_j.ehu.O000000o(java.lang.String, _m_j.iar$O00000Oo):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.eht.O000000o.O000000o(androidx.fragment.app.Fragment, boolean):void
          _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
          _m_j.eht.O000000o.O000000o(androidx.fragment.app.Fragment, boolean):void
          _m_j.ehj.O000000o(boolean, android.view.View):void */
        public final void afterTextChanged(Editable editable) {
            String str;
            Boolean bool = null;
            if (!TextUtils.isEmpty(editable != null ? editable.toString() : null)) {
                if (editable != null) {
                    str = editable.toString();
                } else {
                    str = null;
                }
                if (str == null) {
                    ixe.O000000o();
                }
                if (str.length() > 6) {
                    Boolean bool2 = this.f15290O000000o.O00000oo;
                    if (bool2 != null) {
                        bool = Boolean.valueOf(!bool2.booleanValue());
                    }
                    if (bool == null) {
                        ixe.O000000o();
                    }
                    if (bool.booleanValue() && ehj.O00000o0(editable.toString())) {
                        this.f15290O000000o.O000000o(true, this.O00000Oo);
                        return;
                    }
                }
            }
            this.f15290O000000o.O000000o(false, this.O00000Oo);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f15290O000000o.O000000o(R$id.userId_wapper);
            if (textInputLayout != null) {
                textInputLayout.setError(null);
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000Oo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15289O000000o;

        O0000Oo(ehj ehj) {
            this.f15289O000000o = ehj;
        }

        public final void onClick(View view) {
            ehj ehj = this.f15289O000000o;
            ehj.startActivityForResult(new Intent(ehj.getActivity(), AreaCodePickerActivity.class), 2001);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/xiaomi/passport/ui/internal/PswSignInFragment$onViewCreated$8", "Landroid/text/TextWatcher;", "(Lcom/xiaomi/passport/ui/internal/PswSignInFragment;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O0000o00 implements TextWatcher {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15292O000000o;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        O0000o00(ehj ehj) {
            this.f15292O000000o = ehj;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f15292O000000o.O000000o(R$id.password_wapper);
            if (textInputLayout != null) {
                textInputLayout.setError(null);
            }
        }
    }

    public static boolean O00000o0(String str) {
        ixe.O00000o0(str, "input");
        Regex regex = new Regex("^\\d{1,15}+$");
        CharSequence charSequence = str;
        ixe.O00000o0(charSequence, "input");
        return regex.nativePattern.matcher(charSequence).matches();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.widget.TextView, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    @SuppressLint({"SetTextI18n"})
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2001 && i2 == -1) {
            if (intent == null) {
                ixe.O000000o();
            }
            String stringExtra = intent.getStringExtra("code");
            TextView textView = (TextView) O000000o(R$id.passport_country_code_text);
            ixe.O000000o((Object) textView, "passport_country_code_text");
            textView.setText("+".concat(String.valueOf(stringExtra)));
        }
    }

    public final void O000000o(String str) {
        ixe.O00000o0(str, "msg");
        TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.password_wapper);
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(false);
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) O000000o(R$id.userId_wapper);
        if (textInputLayout2 != null) {
            textInputLayout2.setError(str);
        }
    }

    public final void O00000Oo(String str) {
        ixe.O00000o0(str, "msg");
        TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.userId_wapper);
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(false);
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) O000000o(R$id.password_wapper);
        if (textInputLayout2 != null) {
            textInputLayout2.setError(str);
        }
    }

    public final void O000000o(egk egk, String str, MetaLoginData metaLoginData) {
        ixe.O00000o0(egk, "authCredential");
        ixe.O00000o0(str, "step1Token");
        ixe.O00000o0(metaLoginData, "metaLoginData");
        View inflate = getLayoutInflater().inflate((int) R.layout.dg_vcode_layout, (ViewGroup) null);
        View findViewById = inflate.findViewById(R$id.cb_add_to_trust_device);
        if (findViewById != null) {
            CheckBox checkBox = (CheckBox) findViewById;
            View findViewById2 = inflate.findViewById(R$id.v_code_input);
            if (findViewById2 != null) {
                EditText editText = (EditText) findViewById2;
                Context context = getContext();
                if (context == null) {
                    ixe.O000000o();
                }
                new AlertDialog.Builder(context).setTitle((int) R.string.v_code_title).setView(inflate).setPositiveButton(17039370, new O0000o0(this, egk, str, metaLoginData, editText, checkBox)).create().show();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.EditText");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.CheckBox");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000o0 implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehj f15291O000000o;
        final /* synthetic */ egk O00000Oo;
        final /* synthetic */ MetaLoginData O00000o;
        final /* synthetic */ String O00000o0;
        final /* synthetic */ EditText O00000oO;
        final /* synthetic */ CheckBox O00000oo;

        O0000o0(ehj ehj, egk egk, String str, MetaLoginData metaLoginData, EditText editText, CheckBox checkBox) {
            this.f15291O000000o = ehj;
            this.O00000Oo = egk;
            this.O00000o0 = str;
            this.O00000o = metaLoginData;
            this.O00000oO = editText;
            this.O00000oo = checkBox;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f15291O000000o.O00000Oo().O000000o(this.O00000Oo.O00000oo, this.O00000o0, this.O00000o, this.O00000oO.getText().toString(), this.O00000oo.isChecked());
        }
    }

    public final void O000000o(boolean z, View view) {
        ixe.O00000o0(view, "container");
        Context context = getContext();
        if (context == null) {
            ixe.O000000o();
        }
        Resources resources = context.getResources();
        if (resources == null) {
            ixe.O000000o();
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.passport_login_id_pwd_country_code_padding);
        Context context2 = getContext();
        if (context2 == null) {
            ixe.O000000o();
        }
        Resources resources2 = context2.getResources();
        if (resources2 == null) {
            ixe.O000000o();
        }
        int dimensionPixelSize2 = resources2.getDimensionPixelSize(R.dimen.passport_login_id_pwd_default_padding);
        if (z) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) O000000o(R$id.userId);
            if (autoCompleteTextView != null) {
                autoCompleteTextView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
            }
        } else {
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) O000000o(R$id.userId);
            if (autoCompleteTextView2 != null) {
                autoCompleteTextView2.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
            }
        }
        view.setVisibility(z ? 0 : 8);
    }
}

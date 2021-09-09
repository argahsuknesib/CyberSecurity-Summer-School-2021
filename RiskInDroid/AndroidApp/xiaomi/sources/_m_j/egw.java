package _m_j;

import _m_j.egv;
import _m_j.eha;
import _m_j.ehj;
import _m_j.iar;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.AreaCodePickerActivity;
import com.xiaomi.passport.ui.internal.PhAuthFragment$showVerification$1$onVerifyFail$1;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.smarthome.R;
import com.xiaomi.verificationsdk.internal.ErrorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J(\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\u001c\u0010,\u001a\u00020\u00172\b\b\u0001\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0017J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u001fH\u0016J\u0018\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhAuthFragment;", "Lcom/xiaomi/passport/ui/internal/BaseSignInFragment;", "Lcom/xiaomi/passport/ui/internal/PhAuthContract$View;", "()V", "TAG", "", "idPswAuthProvider", "Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "mPhoneViewWrapper", "Lcom/xiaomi/passport/ui/internal/PhoneViewWrapper;", "passportRepo", "Lcom/xiaomi/passport/ui/internal/PassportRepo;", "getPassportRepo", "()Lcom/xiaomi/passport/ui/internal/PassportRepo;", "setPassportRepo", "(Lcom/xiaomi/passport/ui/internal/PassportRepo;)V", "presenter", "Lcom/xiaomi/passport/ui/internal/PhAuthContract$Presenter;", "getPresenter", "()Lcom/xiaomi/passport/ui/internal/PhAuthContract$Presenter;", "setPresenter", "(Lcom/xiaomi/passport/ui/internal/PhAuthContract$Presenter;)V", "clearPhonePopList", "", "gotoPswSignIn", "userId", "gotoTicketSignIn", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showPhoneNumError", "msgRes", "showVerification", "captcha", "Lcom/xiaomi/passport/ui/internal/Captcha;", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egw extends efx implements egv.O00000Oo {
    public static final O000000o O0000O0o = new O000000o((byte) 0);
    public egv.O000000o O00000o;
    public final String O00000o0 = "PhAuthFragment";
    public efw O00000oO;
    public ehg O00000oo;
    private HashMap O0000o0;
    private egr O0000o00;

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

    public egw() {
        super("PHONE_SMS_AUTH_PROVIDER");
        egt egt = egt.f15254O000000o;
        this.O00000oO = egt.O00000Oo("ID_PSW_AUTH_PROVIDER");
        this.O0000o00 = new egs();
    }

    public final egv.O000000o O00000o0() {
        egv.O000000o o000000o = this.O00000o;
        if (o000000o == null) {
            ixe.O000000o("presenter");
        }
        return o000000o;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhAuthFragment$Companion;", "", "()V", "newInstance", "Lcom/xiaomi/passport/ui/internal/PhAuthFragment;", "sid", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
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
        return layoutInflater.inflate((int) R.layout.fg_ph_auth_method, viewGroup, false);
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
     arg types: [java.lang.String, java.lang.String]
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
     arg types: [android.widget.ImageView, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    @SuppressLint({"SetTextI18n"})
    public final void onViewCreated(View view, Bundle bundle) {
        ixe.O00000o0(view, "view");
        super.onViewCreated(view, bundle);
        ((Button) O000000o(R$id.ph_sign_in_btn)).setOnClickListener(new O00000Oo(this));
        ((TextView) O000000o(R$id.action_goto_psw_signin)).setOnClickListener(new O00000o0(this));
        ((TextView) O000000o(R$id.passport_country_code_text)).setOnClickListener(new O00000o(this));
        if (this.f15235O000000o != null) {
            TextView textView = (TextView) O000000o(R$id.passport_country_code_text);
            ixe.O000000o((Object) textView, "passport_country_code_text");
            textView.setText(this.f15235O000000o);
        } else {
            TextView textView2 = (TextView) O000000o(R$id.passport_country_code_text);
            ixe.O000000o((Object) textView2, "passport_country_code_text");
            O000000o(textView2);
        }
        ((AutoCompleteTextView) O000000o(R$id.phone)).addTextChangedListener(new O0000O0o(this));
        Bundle arguments = getArguments();
        if (arguments == null) {
            ixe.O000000o();
        }
        String string = arguments.getString("sid");
        ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
        Context context = getContext();
        if (context == null) {
            ixe.O000000o();
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) O000000o(R$id.phone);
        ixe.O000000o((Object) autoCompleteTextView, "phone");
        TextView textView3 = (TextView) O000000o(R$id.passport_country_code_text);
        ixe.O000000o((Object) textView3, "passport_country_code_text");
        ImageView imageView = (ImageView) O000000o(R$id.delete_phone);
        ixe.O000000o((Object) imageView, "delete_phone");
        this.O00000oo = new ehg(string, context, autoCompleteTextView, textView3, imageView, (TextView) O000000o(R$id.passport_operator_license));
        Analytics.O000000o("setting_", "phone_login_page");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000Oo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ egw f15256O000000o;

        O00000Oo(egw egw) {
            this.f15256O000000o = egw;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        public final void onClick(View view) {
            PhoneWrapper phoneWrapper;
            if (!this.f15256O000000o.O0000O0o().isUserAgreedProtocol()) {
                Toast.makeText(this.f15256O000000o.getActivity(), (int) R.string.passport_error_user_agreement_error, 0).show();
                return;
            }
            efn.O000000o("sms_click_next_after_get_phone");
            egv.O000000o O00000o0 = this.f15256O000000o.O00000o0();
            ehg ehg = this.f15256O000000o.O00000oo;
            if (ehg == null || !(!TextUtils.isEmpty(ehg.O00000oO.getText().toString()))) {
                phoneWrapper = null;
            } else {
                String obj = ehg.O00000oO.getText().toString();
                if (ehg.O00000Oo != null) {
                    List<? extends ActivatorPhoneInfo> list = ehg.O00000Oo;
                    if (list == null) {
                        ixe.O000000o();
                    }
                    Collection arrayList = new ArrayList();
                    for (Object next : list) {
                        if (ixe.O000000o((Object) ((ActivatorPhoneInfo) next).phone, (Object) obj)) {
                            arrayList.add(next);
                        }
                    }
                    Iterator it = ((List) arrayList).iterator();
                    if (it.hasNext()) {
                        phoneWrapper = new PhoneWrapper((ActivatorPhoneInfo) it.next(), ehg.O00000o0);
                    }
                }
                if (ixe.O000000o((Object) ehg.O00000oo.getText().toString(), (Object) "+86")) {
                    phoneWrapper = new PhoneWrapper(obj, ehg.O00000o0);
                } else {
                    phoneWrapper = new PhoneWrapper(ehg.O00000oo.getText().toString() + obj, ehg.O00000o0);
                }
            }
            O00000o0.O000000o(phoneWrapper);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o0 implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ egw f15258O000000o;

        O00000o0(egw egw) {
            this.f15258O000000o = egw;
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
            egw egw = this.f15258O000000o;
            efw efw = egw.O00000oO;
            Bundle arguments = this.f15258O000000o.getArguments();
            if (arguments == null) {
                ixe.O000000o();
            }
            String string = arguments.getString("sid");
            ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
            egw.O000000o(efw.O000000o(string, this.f15258O000000o.f15235O000000o), false);
            Analytics.O00000Oo("pwd_login_link");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ egw f15257O000000o;

        O00000o(egw egw) {
            this.f15257O000000o = egw;
        }

        public final void onClick(View view) {
            egw egw = this.f15257O000000o;
            egw.startActivityForResult(new Intent(egw.getActivity(), AreaCodePickerActivity.class), 2001);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/xiaomi/passport/ui/internal/PhAuthFragment$onViewCreated$4", "Landroid/text/TextWatcher;", "(Lcom/xiaomi/passport/ui/internal/PhAuthFragment;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O0000O0o implements TextWatcher {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ egw f15259O000000o;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        O0000O0o(egw egw) {
            this.f15259O000000o = egw;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f15259O000000o.O000000o(R$id.phone_wrapper);
            if (textInputLayout != null) {
                textInputLayout.setError(null);
            }
        }
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

    public final void onDestroyView() {
        ehg ehg = this.O00000oo;
        if (ehg != null) {
            ehg.O00000oO.removeTextChangedListener(ehg.f15278O000000o);
            ehg.f15278O000000o = null;
        }
        this.O00000oo = null;
        super.onDestroyView();
        O000000o();
    }

    public final void O00000Oo() {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) O000000o(R$id.phone);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setText("");
        }
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) O000000o(R$id.phone);
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.setEnabled(true);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/passport/ui/internal/PhAuthFragment$showVerification$1", "Lcom/xiaomi/verificationsdk/VerificationManager$VerifyResultCallback;", "(Lcom/xiaomi/passport/ui/internal/PhAuthFragment;Lcom/xiaomi/passport/ui/internal/PhoneWrapper;Lcom/xiaomi/passport/ui/internal/Captcha;)V", "onVerifyCancel", "", "onVerifyFail", "verifyError", "Lcom/xiaomi/verificationsdk/internal/VerifyError;", "onVerifySucess", "verifyResult", "Lcom/xiaomi/verificationsdk/internal/VerifyResult;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O0000OOo implements iar.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ egw f15260O000000o;
        public final /* synthetic */ PhoneWrapper O00000Oo;
        final /* synthetic */ efz O00000o0;

        O0000OOo(egw egw, PhoneWrapper phoneWrapper, efz efz) {
            this.f15260O000000o = egw;
            this.O00000Oo = phoneWrapper;
            this.O00000o0 = efz;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void O000000o(ibb ibb) {
            ixe.O00000o0(ibb, "verifyResult");
            Analytics.O00000o0("sms_login_verify_sucess");
            AccountLog.i(this.f15260O000000o.O00000o0, "onVerifySucess");
            egv.O000000o O00000o02 = this.f15260O000000o.O00000o0();
            PhoneWrapper phoneWrapper = this.O00000Oo;
            String O000000o2 = ibb.O000000o();
            ixe.O000000o((Object) O000000o2, "verifyResult.token");
            O00000o02.O000000o(phoneWrapper, null, new eif(O000000o2, "ticket-login"));
        }

        public final void O000000o() {
            AccountLog.e(this.f15260O000000o.O00000o0, "onVerifyCancel");
        }

        public final void O000000o(iaz iaz) {
            ixe.O00000o0(iaz, "verifyError");
            Analytics.O00000o0("sms_login_verify_fail");
            String str = this.f15260O000000o.O00000o0;
            AccountLog.e(str, "code=" + iaz.O000000o() + " msg=" + iaz.O00000Oo());
            if (iaz.O000000o() == ErrorInfo.ErrorCode.ERROR_VERIFY_SERVER.getCode()) {
                Analytics.O00000o0("sms_login_show_captcha");
                AccountLog.i(this.f15260O000000o.O00000o0, "showCaptcha");
                this.f15260O000000o.O000000o(this.O00000o0, new PhAuthFragment$showVerification$1$onVerifyFail$1(this));
            }
        }
    }

    public final void O000000o(efz efz, PhoneWrapper phoneWrapper) {
        ixe.O00000o0(efz, "captcha");
        ixe.O00000o0(phoneWrapper, "phone");
        Analytics.O00000o0("sms_login_show_verification");
        O000000o("ticket-login", new O0000OOo(this, phoneWrapper, efz));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void
     arg types: [_m_j.eha, int]
     candidates:
      _m_j.egw.O000000o(_m_j.efz, com.xiaomi.passport.ui.internal.PhoneWrapper):void
      _m_j.ehu.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
      _m_j.ehu.O000000o(java.lang.String, _m_j.iar$O00000Oo):void
      _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
      _m_j.egv.O00000Oo.O000000o(_m_j.efz, com.xiaomi.passport.ui.internal.PhoneWrapper):void
      _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
      _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void */
    public final void O000000o(PhoneWrapper phoneWrapper) {
        ixe.O00000o0(phoneWrapper, "phone");
        eha.O000000o o000000o = eha.O00000oO;
        O000000o((Fragment) eha.O000000o.O000000o(phoneWrapper.O00000o0, phoneWrapper), true);
    }

    public final void O00000Oo(int i) {
        TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.phone_wrapper);
        if (textInputLayout != null) {
            textInputLayout.setError(getString(i));
        }
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
     arg types: [_m_j.ehj, int]
     candidates:
      _m_j.egw.O000000o(_m_j.efz, com.xiaomi.passport.ui.internal.PhoneWrapper):void
      _m_j.ehu.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
      _m_j.ehu.O000000o(java.lang.String, _m_j.iar$O00000Oo):void
      _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
      _m_j.egv.O00000Oo.O000000o(_m_j.efz, com.xiaomi.passport.ui.internal.PhoneWrapper):void
      _m_j.eht.O000000o.O000000o(_m_j.efz, _m_j.iwn<? super java.lang.String, ? super java.lang.String, _m_j.iuh>):void
      _m_j.ehu.O000000o(androidx.fragment.app.Fragment, boolean):void */
    public final void O000000o(String str) {
        ixe.O00000o0(str, "userId");
        if (this.O00000oO != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                ixe.O000000o();
            }
            String string = arguments.getString("sid");
            ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
            ixe.O00000o0(string, "sid");
            ixe.O00000o0(str, "userId");
            ehj.O000000o o000000o = ehj.O0000O0o;
            O000000o((Fragment) ehj.O000000o.O000000o(string, str), true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.ui.internal.IdPswAuthProvider");
    }
}

package _m_j;

import _m_j.egz;
import _m_j.eik;
import _m_j.iar;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.PhTicketSignInFragment$chooseToSignInOrSignUp$1;
import com.xiaomi.passport.ui.internal.PhTicketSignInFragment$showVerification$1$onVerifyFail$1;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.utils.AccountSmsVerifyCodeReceiver;
import com.xiaomi.smarthome.R;
import com.xiaomi.verificationsdk.internal.ErrorInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J(\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u001c\u0010,\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\u001c\u00100\u001a\u00020\u001a2\b\b\u0001\u00101\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u00102\u001a\u00020\u001aH\u0016J\u0018\u00103\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u0002042\u0006\u00105\u001a\u00020\u0018H\u0016J\b\u00106\u001a\u00020\u001aH\u0016J\u0010\u00106\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u0018H\u0016J\u0010\u00107\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u000204H\u0016J\u0018\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000eH\u0016J\b\u0010<\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhTicketSignInFragment;", "Lcom/xiaomi/passport/ui/internal/SignInFragment;", "Lcom/xiaomi/passport/ui/internal/PhTicketSignInContract$View;", "Lcom/xiaomi/passport/ui/settings/utils/AccountSmsVerifyCodeReceiver$SmsVerifyCodeMessageListener;", "()V", "TAG", "", "mIsCountingDown", "", "getMIsCountingDown", "()Z", "setMIsCountingDown", "(Z)V", "mPhoneWrapper", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "mSmsReceiver", "Lcom/xiaomi/passport/ui/settings/utils/AccountSmsVerifyCodeReceiver;", "mTimer", "Landroid/os/CountDownTimer;", "passportRepo", "Lcom/xiaomi/passport/ui/internal/PassportRepo;", "presenter", "Lcom/xiaomi/passport/ui/internal/PhTicketSignInContract$Presenter;", "sendTicketSuccessCount", "", "chooseToSignInOrSignUp", "", "authCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "userInfo", "Lcom/xiaomi/accountsdk/account/data/RegisterUserInfo;", "enableSendTicketBtn", "getDisplayNickname", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onReceived", "message", "verifyCode", "onResume", "onViewCreated", "view", "sendTicketSuccess", "showInvalidPsw", "Lcom/xiaomi/passport/ui/internal/ChoosePhoneSmsAuthCredential;", "msg", "showInvalidTicket", "showSetPsw", "showVerification", "captcha", "Lcom/xiaomi/passport/ui/internal/Captcha;", "phone", "startFailReceiveSMSVerifyCodeQA", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eha extends ehu implements egz.O00000Oo, AccountSmsVerifyCodeReceiver.O000000o {
    public static final O000000o O00000oO = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f15263O000000o = "PhTicketSignInFragment";
    public egz.O000000o O00000Oo;
    boolean O00000o;
    public PhoneWrapper O00000o0;
    private CountDownTimer O00000oo;
    private int O0000O0o;
    private AccountSmsVerifyCodeReceiver O0000o0;
    private egr O0000o00 = new egs();
    private HashMap O0000o0O;

    public final View O000000o(int i) {
        if (this.O0000o0O == null) {
            this.O0000o0O = new HashMap();
        }
        View view = (View) this.O0000o0O.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.O0000o0O.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void O000000o() {
        HashMap hashMap = this.O0000o0O;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O000000o();
    }

    public static final /* synthetic */ egz.O000000o O000000o(eha eha) {
        egz.O000000o o000000o = eha.O00000Oo;
        if (o000000o == null) {
            ixe.O000000o("presenter");
        }
        return o000000o;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhTicketSignInFragment$Companion;", "", "()V", "newInstance", "Lcom/xiaomi/passport/ui/internal/PhTicketSignInFragment;", "sid", "", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public static eha O000000o(String str, PhoneWrapper phoneWrapper) {
            ixe.O00000o0(str, "sid");
            ixe.O00000o0(phoneWrapper, "phone");
            eha eha = new eha();
            Bundle bundle = new Bundle();
            bundle.putString("sid", str);
            bundle.putParcelable("phone", phoneWrapper);
            eha.setArguments(bundle);
            return eha;
        }
    }

    public final void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        this.O0000o0 = new AccountSmsVerifyCodeReceiver(this);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            ixe.O000000o();
        }
        activity.registerReceiver(this.O0000o0, intentFilter);
    }

    public final void O000000o(String str) {
        if (str != null) {
            ((TextInputEditText) O000000o(R$id.ticket)).setText(str);
        }
    }

    public final void onPause() {
        if (this.O0000o0 != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                ixe.O000000o();
            }
            activity.unregisterReceiver(this.O0000o0);
            this.O0000o0 = null;
        }
        super.onPause();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AccountSmsVerifyCodeReceiver.O000000o((Activity) getActivity());
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
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o0(layoutInflater, "inflater");
        Context context = getContext();
        if (context == null) {
            ixe.O000000o();
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            ixe.O000000o();
        }
        String string = arguments.getString("sid");
        ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
        this.O00000Oo = new ehb(context, string, this);
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            ixe.O000000o();
        }
        this.O00000o0 = (PhoneWrapper) arguments2.getParcelable("phone");
        return layoutInflater.inflate((int) R.layout.fg_ph_ticket_signin, viewGroup, false);
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
    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        ixe.O00000o0(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) O000000o(R$id.phone_text);
        ixe.O000000o((Object) textView, "phone_text");
        Object[] objArr = new Object[1];
        PhoneWrapper phoneWrapper = this.O00000o0;
        if (phoneWrapper == null) {
            str = null;
        } else if (!TextUtils.isEmpty(phoneWrapper.f6255O000000o)) {
            str = phoneWrapper.f6255O000000o;
            if (str == null) {
                ixe.O000000o();
            }
        } else if (phoneWrapper.O00000Oo != null) {
            str = phoneWrapper.O00000Oo.phone;
            ixe.O000000o((Object) str, "activateInfo.phone");
        } else {
            str = "null";
        }
        objArr[0] = str;
        textView.setText(getString(R.string.passport_sms_phone_intro, objArr));
        ((TextView) O000000o(R$id.action_get_ph_ticket)).setOnClickListener(new O00000o(this));
        ((Button) O000000o(R$id.ph_sign_in_btn)).setOnClickListener(new O0000O0o(this));
        ((TextView) O000000o(R$id.can_not_receive_sms_verify_code)).setOnClickListener(new O0000OOo(this));
        ((TextInputEditText) O000000o(R$id.ticket)).addTextChangedListener(new O0000Oo0(this));
        O00000Oo();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15265O000000o;

        O00000o(eha eha) {
            this.f15265O000000o = eha;
        }

        public final void onClick(View view) {
            TextView textView = (TextView) this.f15265O000000o.O000000o(R$id.action_get_ph_ticket);
            if (textView != null) {
                textView.setClickable(false);
            }
            if (this.f15265O000000o.O00000o0 != null) {
                egz.O000000o O000000o2 = eha.O000000o(this.f15265O000000o);
                PhoneWrapper phoneWrapper = this.f15265O000000o.O00000o0;
                if (phoneWrapper == null) {
                    ixe.O000000o();
                }
                O000000o2.O000000o(phoneWrapper, null, null);
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000O0o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15267O000000o;

        O0000O0o(eha eha) {
            this.f15267O000000o = eha;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [com.google.android.material.textfield.TextInputEditText, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onClick(View view) {
            if (this.f15267O000000o.O00000o0 != null) {
                egz.O000000o O000000o2 = eha.O000000o(this.f15267O000000o);
                PhoneWrapper phoneWrapper = this.f15267O000000o.O00000o0;
                if (phoneWrapper == null) {
                    ixe.O000000o();
                }
                TextInputEditText textInputEditText = (TextInputEditText) this.f15267O000000o.O000000o(R$id.ticket);
                ixe.O000000o((Object) textInputEditText, "ticket");
                O000000o2.O000000o(phoneWrapper, textInputEditText.getText().toString());
            }
            Analytics.O00000Oo("phone_login_or_reg");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000OOo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15268O000000o;

        O0000OOo(eha eha) {
            this.f15268O000000o = eha;
        }

        public final void onClick(View view) {
            eha eha = this.f15268O000000o;
            eik.O000000o o000000o = eik.f15320O000000o;
            FragmentActivity activity = eha.getActivity();
            if (activity == null) {
                ixe.O000000o();
            }
            eik.O000000o.O000000o(activity, "https://account.xiaomi.com/helpcenter");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/xiaomi/passport/ui/internal/PhTicketSignInFragment$onViewCreated$4", "Landroid/text/TextWatcher;", "(Lcom/xiaomi/passport/ui/internal/PhTicketSignInFragment;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O0000Oo0 implements TextWatcher {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15270O000000o;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        O0000Oo0(eha eha) {
            this.f15270O000000o = eha;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f15270O000000o.O000000o(R$id.ticket_wrapper);
            if (textInputLayout != null) {
                textInputLayout.setError(null);
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.O00000oo;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void O00000Oo() {
        if (!this.O00000o) {
            TextInputEditText textInputEditText = (TextInputEditText) O000000o(R$id.ticket);
            if (textInputEditText != null) {
                textInputEditText.requestFocus();
            }
            TextInputEditText textInputEditText2 = (TextInputEditText) O000000o(R$id.ticket);
            if (textInputEditText2 != null) {
                textInputEditText2.setText("");
            }
            this.O0000O0o++;
            int i = this.O0000O0o * 60;
            this.O00000oo = new O0000Oo(this, i, (long) (i * 1000));
            CountDownTimer countDownTimer = this.O00000oo;
            if (countDownTimer != null) {
                countDownTimer.start();
            }
            TextView textView = (TextView) O000000o(R$id.action_get_ph_ticket);
            if (textView != null) {
                textView.setClickable(false);
            }
            this.O00000o = true;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"com/xiaomi/passport/ui/internal/PhTicketSignInFragment$sendTicketSuccess$1", "Landroid/os/CountDownTimer;", "(Lcom/xiaomi/passport/ui/internal/PhTicketSignInFragment;IJJ)V", "onFinish", "", "onTick", "millisUntilFinished", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O0000Oo extends CountDownTimer {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15269O000000o;
        final /* synthetic */ int O00000Oo;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:25)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:130)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        O0000Oo(int r0, long r1, long r3) {
            /*
                r-1 = this;
                r0.f15269O000000o = r1
                r0.O00000Oo = r2
                r1 = 1000(0x3e8, double:4.94E-321)
                r0.<init>(r3, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.eha.O0000Oo.<init>(_m_j.eha, int, long):void");
        }

        @SuppressLint({"SetTextI18n"})
        public final void onTick(long j) {
            int i = (int) (j / 1000);
            TextView textView = (TextView) this.f15269O000000o.O000000o(R$id.action_get_ph_ticket);
            if (textView != null) {
                textView.setText(String.valueOf(i) + "s");
            }
        }

        public final void onFinish() {
            TextView textView = (TextView) this.f15269O000000o.O000000o(R$id.action_get_ph_ticket);
            if (textView != null) {
                textView.setClickable(true);
            }
            TextView textView2 = (TextView) this.f15269O000000o.O000000o(R$id.action_get_ph_ticket);
            if (textView2 != null) {
                textView2.setText(this.f15269O000000o.getString(R.string.passport_reload_ph_ticket));
            }
            this.f15269O000000o.O00000o = false;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/passport/ui/internal/PhTicketSignInFragment$showVerification$1", "Lcom/xiaomi/verificationsdk/VerificationManager$VerifyResultCallback;", "(Lcom/xiaomi/passport/ui/internal/PhTicketSignInFragment;Lcom/xiaomi/passport/ui/internal/PhoneWrapper;Lcom/xiaomi/passport/ui/internal/Captcha;)V", "onVerifyCancel", "", "onVerifyFail", "verifyError", "Lcom/xiaomi/verificationsdk/internal/VerifyError;", "onVerifySucess", "verifyResult", "Lcom/xiaomi/verificationsdk/internal/VerifyResult;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O0000o implements iar.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ eha f15271O000000o;
        public final /* synthetic */ PhoneWrapper O00000Oo;
        final /* synthetic */ efz O00000o0;

        O0000o(eha eha, PhoneWrapper phoneWrapper, efz efz) {
            this.f15271O000000o = eha;
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
            egz.O000000o O000000o2 = eha.O000000o(this.f15271O000000o);
            PhoneWrapper phoneWrapper = this.O00000Oo;
            String O000000o3 = ibb.O000000o();
            ixe.O000000o((Object) O000000o3, "verifyResult.token");
            O000000o2.O000000o(phoneWrapper, null, new eif(O000000o3, "ticket-login"));
        }

        public final void O000000o() {
            AccountLog.e(this.f15271O000000o.f15263O000000o, "onVerifyCancel");
        }

        public final void O000000o(iaz iaz) {
            ixe.O00000o0(iaz, "verifyError");
            Analytics.O00000o0("sms_login_verify_fail");
            String str = this.f15271O000000o.f15263O000000o;
            AccountLog.e(str, "code=" + iaz.O000000o() + " msg=" + iaz.O00000Oo());
            if (iaz.O000000o() == ErrorInfo.ErrorCode.ERROR_VERIFY_SERVER.getCode()) {
                Analytics.O00000o0("sms_login_show_captcha");
                this.f15271O000000o.O000000o(this.O00000o0, new PhTicketSignInFragment$showVerification$1$onVerifyFail$1(this));
            }
        }
    }

    public final void O000000o(efz efz, PhoneWrapper phoneWrapper) {
        ixe.O00000o0(efz, "captcha");
        ixe.O00000o0(phoneWrapper, "phone");
        Analytics.O00000o0("sms_login_show_verification");
        O000000o("ticket-login", new O0000o(this, phoneWrapper, efz));
    }

    public final void O00000o() {
        TextView textView = (TextView) O000000o(R$id.action_get_ph_ticket);
        if (textView != null) {
            textView.setClickable(true);
        }
    }

    public final void O00000o0() {
        TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.ticket_wrapper);
        if (textInputLayout != null) {
            textInputLayout.setError(getString(R.string.ticket_invalid));
        }
    }

    public final void O00000Oo(int i) {
        TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.ticket_wrapper);
        if (textInputLayout != null) {
            textInputLayout.setError(getString(i));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void O000000o(ehd ehd, RegisterUserInfo registerUserInfo) {
        String str;
        ixe.O00000o0(ehd, "authCredential");
        ixe.O00000o0(registerUserInfo, "userInfo");
        View inflate = getLayoutInflater().inflate((int) R.layout.dg_choose_to_signin_signup, (ViewGroup) null);
        View findViewById = inflate.findViewById(R$id.text_view_user_info);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.nick_name));
            sb.append(':');
            if (TextUtils.isEmpty(registerUserInfo.userName)) {
                str = registerUserInfo.maskedUserId;
            } else {
                str = registerUserInfo.userName;
            }
            sb.append(str);
            sb.append(10);
            sb.append(getString(R.string.phone_number));
            sb.append(':');
            sb.append(registerUserInfo.phone);
            textView.setText(sb.toString());
            Context context = getContext();
            if (context == null) {
                ixe.O000000o();
            }
            new AlertDialog.Builder(context).setTitle((int) R.string.isornot_your_mi_account).setView(inflate).setNegativeButton((int) R.string.choose_to_signup, new O00000Oo(this, ehd, registerUserInfo)).setPositiveButton((int) R.string.choose_to_signin, new O00000o0(this, ehd, registerUserInfo)).create().show();
            if (!TextUtils.isEmpty(registerUserInfo.avatarAddress)) {
                this.O0000o00.O00000Oo(registerUserInfo.avatarAddress).O000000o(new PhTicketSignInFragment$chooseToSignInOrSignUp$1(inflate));
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000Oo implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15264O000000o;
        final /* synthetic */ ehd O00000Oo;
        final /* synthetic */ RegisterUserInfo O00000o0;

        O00000Oo(eha eha, ehd ehd, RegisterUserInfo registerUserInfo) {
            this.f15264O000000o = eha;
            this.O00000Oo = ehd;
            this.O00000o0 = registerUserInfo;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            eha.O000000o(this.f15264O000000o).O000000o(this.O00000Oo, this.O00000o0);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o0 implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15266O000000o;
        final /* synthetic */ ehd O00000Oo;
        final /* synthetic */ RegisterUserInfo O00000o0;

        O00000o0(eha eha, ehd ehd, RegisterUserInfo registerUserInfo) {
            this.f15266O000000o = eha;
            this.O00000Oo = ehd;
            this.O00000o0 = registerUserInfo;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            eha.O000000o(this.f15266O000000o).O00000Oo(this.O00000Oo, this.O00000o0);
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.google.android.material.textfield.TextInputLayout, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void O00000Oo(egb egb) {
        ixe.O00000o0(egb, "authCredential");
        TextView textView = (TextView) O000000o(R$id.sign_in_user_id_text);
        ixe.O000000o((Object) textView, "sign_in_user_id_text");
        textView.setVisibility(0);
        TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.password_wapper);
        ixe.O000000o((Object) textInputLayout, "password_wapper");
        textInputLayout.setVisibility(0);
        TextView textView2 = (TextView) O000000o(R$id.phone_text);
        ixe.O000000o((Object) textView2, "phone_text");
        textView2.setVisibility(8);
        TextInputLayout textInputLayout2 = (TextInputLayout) O000000o(R$id.ticket_wrapper);
        ixe.O000000o((Object) textInputLayout2, "ticket_wrapper");
        textInputLayout2.setVisibility(8);
        ((Button) O000000o(R$id.ph_sign_in_btn)).setOnClickListener(new O0000o0(this, egb));
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000o0 implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15272O000000o;
        final /* synthetic */ egb O00000Oo;

        O0000o0(eha eha, egb egb) {
            this.f15272O000000o = eha;
            this.O00000Oo = egb;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [com.google.android.material.textfield.TextInputEditText, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onClick(View view) {
            egb egb = this.O00000Oo;
            TextInputEditText textInputEditText = (TextInputEditText) this.f15272O000000o.O000000o(R$id.password);
            ixe.O000000o((Object) textInputEditText, "password");
            egb.O0000O0o = textInputEditText.getText().toString();
            eha.O000000o(this.f15272O000000o).O000000o(this.O00000Oo);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.google.android.material.textfield.TextInputLayout, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void O000000o(egb egb) {
        ixe.O00000o0(egb, "authCredential");
        TextInputLayout textInputLayout = (TextInputLayout) O000000o(R$id.password_wapper);
        ixe.O000000o((Object) textInputLayout, "password_wapper");
        textInputLayout.setError(getString(R.string.passport_password_req_notice));
        ((Button) O000000o(R$id.ph_sign_in_btn)).setOnClickListener(new O0000o00(this, egb));
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000o00 implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eha f15273O000000o;
        final /* synthetic */ egb O00000Oo;

        O0000o00(eha eha, egb egb) {
            this.f15273O000000o = eha;
            this.O00000Oo = egb;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [com.google.android.material.textfield.TextInputEditText, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onClick(View view) {
            egb egb = this.O00000Oo;
            TextInputEditText textInputEditText = (TextInputEditText) this.f15273O000000o.O000000o(R$id.password);
            ixe.O000000o((Object) textInputEditText, "password");
            egb.O0000O0o = textInputEditText.getText().toString();
            eha.O000000o(this.f15273O000000o).O000000o(this.O00000Oo);
        }
    }
}

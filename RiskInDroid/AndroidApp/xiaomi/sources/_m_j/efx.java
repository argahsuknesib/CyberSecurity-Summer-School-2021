package _m_j;

import _m_j.ehc;
import _m_j.ehr;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\b\u0010\u001a\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/BaseSignInFragment;", "Lcom/xiaomi/passport/ui/internal/SignInFragment;", "provider", "", "(Ljava/lang/String;)V", "TAG", "defaultCountryCodeWithPrefix", "getDefaultCountryCodeWithPrefix", "()Ljava/lang/String;", "setDefaultCountryCodeWithPrefix", "mAuthProvider", "Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "mDiagnosisLauncher", "Lcom/xiaomi/passport/ui/diagnosis/DiagnosisLauncher;", "mOnDiagnosisClicked", "Landroid/view/View$OnClickListener;", "getProvider", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setCountryPhoneNumByISO", "countryCodeText", "Landroid/widget/TextView;", "showBindTitle", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public abstract class efx extends ehu {

    /* renamed from: O000000o  reason: collision with root package name */
    String f15235O000000o;
    public efo O00000Oo;
    private efw O00000o;
    private final String O00000o0 = "BaseSignInFragment";
    private final View.OnClickListener O00000oO;
    private final String O00000oo;
    private HashMap O0000O0o;

    public View O000000o(int i) {
        if (this.O0000O0o == null) {
            this.O0000O0o = new HashMap();
        }
        View view = (View) this.O0000O0o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.O0000O0o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void O000000o() {
        HashMap hashMap = this.O0000O0o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O000000o();
    }

    public efx(String str) {
        ixe.O00000o0(str, "provider");
        this.O00000oo = str;
        egt egt = egt.f15254O000000o;
        this.O00000o = egt.O00000Oo(this.O00000oo);
        this.O00000oO = new O000000o(this);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ efx f15236O000000o;

        O000000o(efx efx) {
            this.f15236O000000o = efx;
        }

        public final void onClick(View view) {
            efo efo = this.f15236O000000o.O00000Oo;
            if (efo != null) {
                efo.O000000o();
            }
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
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.widget.ImageView, java.lang.String]
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
    public void onViewCreated(View view, Bundle bundle) {
        ixe.O00000o0(view, "view");
        super.onViewCreated(view, bundle);
        this.O00000Oo = new efo(getActivity());
        efw efw = this.O00000o;
        Bundle arguments = getArguments();
        if (arguments == null) {
            ixe.O000000o();
        }
        String string = arguments.getString("sid");
        ixe.O000000o((Object) string, "arguments!!.getString(\"sid\")");
        efw.O000000o(string, this);
        String string2 = getString(R.string.passport_auth_title);
        ixe.O000000o((Object) string2, "titleText");
        if (string2 != null) {
            CharSequence charSequence = string2;
            if (!TextUtils.isEmpty(iyo.O00000Oo(charSequence).toString())) {
                ImageView imageView = (ImageView) O000000o(R$id.mi_logo);
                ixe.O000000o((Object) imageView, "mi_logo");
                imageView.setVisibility(8);
                TextView textView = (TextView) O000000o(R$id.signin_title);
                ixe.O000000o((Object) textView, "signin_title");
                textView.setVisibility(0);
                TextView textView2 = (TextView) O000000o(R$id.signin_title);
                ixe.O000000o((Object) textView2, "signin_title");
                textView2.setText(charSequence);
            }
            ((TextView) O000000o(R$id.signin_title)).setOnClickListener(this.O00000oO);
            ((ImageView) O000000o(R$id.mi_logo)).setOnClickListener(this.O00000oO);
            ehr.O000000o o000000o = ehr.O0000O0o;
            if (ehr.O000000o.O000000o()) {
                ImageView imageView2 = (ImageView) O000000o(R$id.mi_logo);
                ixe.O000000o((Object) imageView2, "mi_logo");
                imageView2.setVisibility(8);
                TextView textView3 = (TextView) O000000o(R$id.signin_title);
                ixe.O000000o((Object) textView3, "signin_title");
                textView3.setVisibility(0);
                ((TextView) O000000o(R$id.signin_title)).setText((int) R.string.bind_sign_in_title);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.util.Locale, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: protected */
    public final void O000000o(TextView textView) {
        ixe.O00000o0(textView, "countryCodeText");
        Locale locale = Locale.getDefault();
        ixe.O000000o((Object) locale, "Locale.getDefault()");
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            AccountLog.d(this.O00000o0, "region info is null, and set China as the default area iso");
            country = "CN";
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            ixe.O000000o();
        }
        ehc.O000000o O000000o2 = ege.O000000o(activity, country);
        textView.setText(O000000o2 != null ? ege.O000000o(O000000o2) : null);
    }
}

package _m_j;

import _m_j.ehi;
import android.content.Context;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.passport.ui.internal.PswSignInPresenter$signInWithAuthCredential$1;
import com.xiaomi.passport.ui.internal.PswSignInPresenter$signInWithAuthCredential$2;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J \u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\u0005H\u0016J0\u0010'\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001eH\u0016R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00060"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PswSignInPresenter;", "Lcom/xiaomi/passport/ui/internal/PswSignInContract$Presenter;", "context", "Landroid/content/Context;", "sid", "", "view", "Lcom/xiaomi/passport/ui/internal/PswSignInContract$View;", "name", "(Landroid/content/Context;Ljava/lang/String;Lcom/xiaomi/passport/ui/internal/PswSignInContract$View;Ljava/lang/String;)V", "TAG", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "provider", "Lcom/xiaomi/passport/ui/internal/AuthProvider;", "getProvider", "()Lcom/xiaomi/passport/ui/internal/AuthProvider;", "setProvider", "(Lcom/xiaomi/passport/ui/internal/AuthProvider;)V", "getSid", "getView", "()Lcom/xiaomi/passport/ui/internal/PswSignInContract$View;", "getSignedInUserIds", "", "()[Ljava/lang/String;", "saveSignedInUserId", "", "credential", "Lcom/xiaomi/passport/ui/internal/IdPswBaseAuthCredential;", "signInIdAndPsw", "id", "psw", "signInIdAndPswWithCountryCode", "cc", "signInPhoneAndPsw", "phone", "Lcom/xiaomi/passport/ui/internal/PhoneWrapper;", "signInVStep2", "step1Token", "metaLoginData", "Lcom/xiaomi/accountsdk/account/data/MetaLoginData;", "step2code", "trustCurrentEnv", "", "signInWithAuthCredential", "authCredential", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehk implements ehi.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f15293O000000o;
    public final Context O00000Oo;
    private eft O00000o;
    public final ehi.O00000Oo O00000o0;
    private final String O00000oO;
    private final String O00000oo;

    private ehk(Context context, String str, ehi.O00000Oo o00000Oo, String str2) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(str, "sid");
        ixe.O00000o0(o00000Oo, "view");
        ixe.O00000o0(str2, "name");
        this.O00000Oo = context;
        this.O00000oO = str;
        this.O00000o0 = o00000Oo;
        this.O00000oo = str2;
        this.f15293O000000o = "PswSignIn";
        egt egt = egt.f15254O000000o;
        eft O000000o2 = egt.O000000o(this.O00000oo);
        if (O000000o2 == null) {
            ixe.O000000o();
        }
        this.O00000o = O000000o2;
    }

    public /* synthetic */ ehk(Context context, String str, ehi.O00000Oo o00000Oo) {
        this(context, str, o00000Oo, "ID_PSW_AUTH_PROVIDER");
    }

    public final void O000000o(String str, String str2, MetaLoginData metaLoginData, String str3, boolean z) {
        ixe.O00000o0(str, "id");
        ixe.O00000o0(str2, "step1Token");
        ixe.O00000o0(metaLoginData, "metaLoginData");
        ixe.O00000o0(str3, "step2code");
        O000000o(new egm(str, str2, metaLoginData, str3, z, this.O00000oO));
    }

    public final void O000000o(egk egk) {
        ixe.O00000o0(egk, "authCredential");
        this.O00000o0.O00000oO();
        this.O00000o.O00000Oo(this.O00000Oo, egk).O000000o(new PswSignInPresenter$signInWithAuthCredential$1(this, egk), new PswSignInPresenter$signInWithAuthCredential$2(this, egk));
    }

    public final void O000000o(String str, String str2, String str3) {
        ixe.O00000o0(str, "id");
        ixe.O00000o0(str2, "psw");
        ixe.O00000o0(str3, "cc");
        efn.O000000o("password_click_login");
        O000000o(new egl(str, str3, str2, this.O00000oO));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.util.Set<java.lang.String>, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final String[] O000000o() {
        Set<String> stringSet = this.O00000Oo.getSharedPreferences("passport_ui", 0).getStringSet("sign_in_user_id", new HashSet());
        ixe.O000000o((Object) stringSet, "sf.getStringSet(\"sign_in…r_id\", HashSet<String>())");
        Collection collection = stringSet;
        if (collection != null) {
            Object[] array = collection.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }
}

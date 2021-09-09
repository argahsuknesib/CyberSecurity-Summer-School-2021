package _m_j;

import android.content.Context;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.ui.internal.AuthProvider$signInAndStoreAccount$1;
import com.xiaomi.passport.ui.internal.AuthProvider$signInAndStoreAccount$2;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH$J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AuthProvider;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "signInAndStoreAccount", "Lcom/xiaomi/passport/ui/internal/Source;", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "context", "Landroid/content/Context;", "credential", "Lcom/xiaomi/passport/ui/internal/AuthCredential;", "signInWithAuthCredential", "storePassToken", "", "accountInfo", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public abstract class eft {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f15234O000000o;

    /* access modifiers changed from: protected */
    public abstract eib<AccountInfo> O000000o(Context context, efs efs);

    public eft(String str) {
        ixe.O00000o0(str, "name");
        this.f15234O000000o = str;
    }

    public final eib<AccountInfo> O00000Oo(Context context, efs efs) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(efs, "credential");
        return O000000o(context, efs).O00000Oo(new AuthProvider$signInAndStoreAccount$1(this, context)).O00000Oo(AuthProvider$signInAndStoreAccount$2.f6240O000000o);
    }
}

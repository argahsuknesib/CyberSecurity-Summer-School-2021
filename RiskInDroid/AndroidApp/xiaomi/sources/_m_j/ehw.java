package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.ui.internal.PassportWebView;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SnsBindSignInFragment;", "Lcom/xiaomi/passport/ui/internal/SnsWebLoginBaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehw extends ehz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f15304O000000o = new O000000o((byte) 0);
    private HashMap O00000o;

    public final View O000000o(int i) {
        if (this.O00000o == null) {
            this.O00000o = new HashMap();
        }
        View view = (View) this.O00000o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.O00000o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void O000000o() {
        HashMap hashMap = this.O00000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O000000o();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SnsBindSignInFragment$Companion;", "", "()V", "newInstance", "Lcom/xiaomi/passport/ui/internal/SnsBindSignInFragment;", "e", "Lcom/xiaomi/passport/ui/internal/NeedBindSnsException;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/xiaomi/passport/ui/internal/SnsBindSignInFragment$onCreateView$1", "Lcom/xiaomi/passport/ui/internal/PassportWebView;", "(Lcom/xiaomi/passport/ui/internal/SnsBindSignInFragment;Landroid/content/Context;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onSnsBindCancel", "", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onSnsBindFinished", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000Oo extends PassportWebView {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ehw f15305O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000Oo(ehw ehw, Context context) {
            super(context);
            this.f15305O000000o = ehw;
        }

        public final boolean O00000o0(AccountInfo accountInfo) {
            if (accountInfo == null) {
                return true;
            }
            this.f15305O000000o.O000000o(accountInfo);
            return true;
        }

        public final boolean O00000Oo(AccountInfo accountInfo) {
            if (accountInfo == null) {
                return true;
            }
            this.f15305O000000o.O000000o(accountInfo);
            return true;
        }

        public final void O00000Oo() {
            this.f15305O000000o.O0000OOo.O000000o();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o0(layoutInflater, "inflater");
        Context context = getContext();
        if (context == null) {
            ixe.O000000o();
        }
        O000000o(new O00000Oo(this, context));
        O0000Oo0();
        return O00000Oo();
    }
}

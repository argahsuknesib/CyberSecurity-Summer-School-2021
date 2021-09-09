package com.xiaomi.passport.ui.internal;

import _m_j.ekq;
import _m_j.eks;
import _m_j.ixe;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/ConfirmCredentialActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setAddAccountResultAndFinish", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ConfirmCredentialActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap f6245O000000o;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f6245O000000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.f6245O000000o == null) {
            this.f6245O000000o = new HashMap();
        }
        View view = (View) this.f6245O000000o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f6245O000000o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.os.Parcelable, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = this;
        eks.O000000o(context, eks.O000000o(context));
        Parcelable parcelableExtra = getIntent().getParcelableExtra("accountAuthenticatorResponse");
        ixe.O000000o((Object) parcelableExtra, "intent.getParcelableExtr…T_AUTHENTICATOR_RESPONSE)");
        eks.O000000o(parcelableExtra, ekq.O000000o(0, (AccountInfo) null, getIntent().getBooleanExtra("need_retry_on_authenticator_response_result", false)));
        finish();
    }
}

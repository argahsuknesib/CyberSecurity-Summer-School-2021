package com.xiaomi.passport.ui.internal;

import _m_j.ehr;
import _m_j.eih;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
final class AddAccountActivity$signInWithSnsCredential$2 extends Lambda implements iwc<Throwable, iuh> {
    final /* synthetic */ ehr $snsAuthProvider;
    final /* synthetic */ AddAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddAccountActivity$signInWithSnsCredential$2(AddAccountActivity addAccountActivity, ehr ehr) {
        super(1);
        this.this$0 = addAccountActivity;
        this.$snsAuthProvider = ehr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final /* synthetic */ Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        ixe.O00000o0(th, "it");
        this.this$0.dismissProgress();
        if (th instanceof IOException) {
            this.this$0.showNetworkError((IOException) th);
        } else if (th instanceof NeedNotificationException) {
            AddAccountActivity addAccountActivity = this.this$0;
            String notificationUrl = ((NeedNotificationException) th).getNotificationUrl();
            ixe.O000000o((Object) notificationUrl, "it.notificationUrl");
            addAccountActivity.gotoFragment(eih.O000000o(notificationUrl), true);
            Analytics.O00000o0("sns_need_notification");
        } else if (th instanceof SNSRequest.NeedLoginForBindException) {
            AddAccountActivity addAccountActivity2 = this.this$0;
            addAccountActivity2.gotoFragment(addAccountActivity2.defaultAuthProvider.O000000o(AddAccountActivity.access$getMSid$p(this.this$0), (String) null), false);
        } else if (th instanceof SNSRequest.BindLimitException) {
            Toast.makeText(this.this$0, (int) R.string.sns_bind_limit, 0).show();
            Analytics.O00000o0("sns_bind_limit_exception");
        } else if (th instanceof SNSRequest.RedirectToWebLoginException) {
            this.this$0.gotoFragment(eih.O000000o((SNSRequest.RedirectToWebLoginException) th, this.$snsAuthProvider), true);
            String O00000o0 = this.$snsAuthProvider.O00000o0();
            if (O00000o0 != null) {
                Analytics.O000000o(O00000o0);
            }
        } else {
            this.this$0.mCommonErrorHandler.O000000o(th, this.this$0);
            Analytics.O00000o0("sns_exception");
        }
        return iuh.f1631O000000o;
    }
}

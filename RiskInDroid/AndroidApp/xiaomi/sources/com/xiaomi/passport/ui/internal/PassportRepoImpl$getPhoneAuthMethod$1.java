package com.xiaomi.passport.ui.internal;

import _m_j.iwb;
import _m_j.ixe;
import com.xiaomi.passport.data.LoginPreference;
import com.xiaomi.passport.uicontroller.PhoneLoginController;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xiaomi/passport/ui/internal/PhoneAuthMethod;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportRepoImpl$getPhoneAuthMethod$1 extends Lambda implements iwb<PhoneAuthMethod> {
    final /* synthetic */ PhoneWrapper $phone;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportRepoImpl$getPhoneAuthMethod$1(PhoneWrapper phoneWrapper) {
        super(0);
        this.$phone = phoneWrapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public PhoneAuthMethod invoke() {
        if (this.$phone.O00000Oo != null) {
            return PhoneAuthMethod.SMS;
        }
        try {
            Object obj = PhoneLoginController.O000000o(this.$phone.f6255O000000o).get();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.xiaomi.passport.data.LoginPreference");
            } else if (((LoginPreference) obj).O00000o0 == LoginPreference.PhoneLoginType.password) {
                return PhoneAuthMethod.PSW;
            } else {
                return PhoneAuthMethod.SMS;
            }
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                ixe.O000000o();
            }
            throw cause;
        }
    }
}

package _m_j;

import _m_j.cev;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.model.auth.CheckAuthModel;
import com.mibi.sdk.model.sms.VerifyRegetSmsCodeModel;
import com.mibi.sdk.task.RxCountDown;

public final class cew extends BaseMvpPresenter<cev.O00000Oo> implements cev.O000000o {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13697O000000o;

    public cew(Class<cev.O00000Oo> cls) {
        super(cls);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        this.f13697O000000o = getArguments().getString("processId");
    }

    public final void O000000o() {
        RxCountDown.getTask().start(60, new O00000Oo(this, (byte) 0));
    }

    public final void O000000o(String str) {
        CheckAuthModel checkAuthModel = new CheckAuthModel(getSession());
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.f13697O000000o);
        bundle.putString("smsCode", str);
        checkAuthModel.checkAuth(bundle, new O000000o(this, (byte) 0));
    }

    class O00000Oo implements RxCountDown.ICountDownListener {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(cew cew, byte b) {
            this();
        }

        public final void onStart() {
            Log.d("VerifySMSCodePresenter", "count down start");
            VerifyRegetSmsCodeModel verifyRegetSmsCodeModel = new VerifyRegetSmsCodeModel(cew.this.getSession());
            Bundle bundle = new Bundle();
            bundle.putString("processId", cew.this.f13697O000000o);
            verifyRegetSmsCodeModel.request(bundle, null);
        }

        public final void onError() {
            Log.e("VerifySMSCodePresenter", "count down error");
        }

        public final void onCompleted() {
            Log.d("VerifySMSCodePresenter", "count down completed");
        }

        public final void onProgress(long j) {
            Log.d("VerifySMSCodePresenter", "count down onProgress:".concat(String.valueOf(j)));
            ((cev.O00000Oo) cew.this.getView()).a(60 - ((int) j));
        }
    }

    class O000000o implements CheckAuthModel.ICheckAuthCallback {
        private O000000o() {
        }

        /* synthetic */ O000000o(cew cew, byte b) {
            this();
        }

        public final void onSuccess() {
            Log.d("VerifySMSCodePresenter", "check auth success");
            ((cev.O00000Oo) cew.this.getView()).a();
        }

        public final void onAccountFrozen() {
            Log.d("VerifySMSCodePresenter", "onAccountFrozen");
            ((cev.O00000Oo) cew.this.getView()).a(9801, "account frozen");
        }

        public final void onPasswordCheck() {
            Log.d("VerifySMSCodePresenter", "onPasswordCheck");
            ((cev.O00000Oo) cew.this.getView()).b();
        }

        public final void onSMSCodeCheck(Bundle bundle) {
            Log.d("VerifySMSCodePresenter", "onSMSCodeCheck");
            ((cev.O00000Oo) cew.this.getView()).a(9802, "need sms code check");
        }

        public final void onBindPhoneCheck(Bundle bundle) {
            Log.d("VerifySMSCodePresenter", "onBindPhoneCheck");
            ((cev.O00000Oo) cew.this.getView()).a(bundle);
        }

        public final void onProcessExpired() {
            Log.d("VerifySMSCodePresenter", "onProcessExpired");
            ((cev.O00000Oo) cew.this.getView()).a(9800, "process expired");
        }

        public final void onAuthCheckError(int i, String str, Throwable th) {
            Log.d("VerifySMSCodePresenter", "onAuthCheckError", th);
            if (i == 7003) {
                ((cev.O00000Oo) cew.this.getView()).a(str, th);
            } else {
                ((cev.O00000Oo) cew.this.getView()).a(i, str);
            }
        }
    }
}

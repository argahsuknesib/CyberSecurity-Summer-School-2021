package _m_j;

import _m_j.ces;
import _m_j.cet;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.model.auth.CheckAuthModel;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.mibi.sdk.task.handler.AccountChangedExceptionHandler;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

public final class ceu extends BaseMvpPresenter<cet.O00000Oo> implements cet.O000000o {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13693O000000o;

    public ceu(Class<cet.O00000Oo> cls) {
        super(cls);
    }

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        this.f13693O000000o = getArguments().getString("processId");
        if (TextUtils.isEmpty(this.f13693O000000o)) {
            Log.d("CheckPasswordPresenter", "process id is null");
        }
    }

    public final void O000000o(Activity activity, String str, String str2) {
        Log.d("CheckPasswordPresenter", "start login");
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", this.f13693O000000o);
        sortedParameter.add("userName", str);
        sortedParameter.add("password", str2);
        ces ces = new ces(activity);
        ces.f13691O000000o = sortedParameter;
        O00000Oo o00000Oo = new O00000Oo(this, getContext(), (byte) 0);
        o00000Oo.getDispatcher().register(new AccountChangedExceptionHandler(getContext()) {
            /* class _m_j.ceu.AnonymousClass1 */

            public final boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
                super.handle(th, bundle, exceptionDispatcher);
                ((cet.O00000Oo) ceu.this.getView()).a(bundle.getInt("errcode"), bundle.getString("errDesc"));
                return true;
            }
        });
        chh.O000000o(ces).O000000o(o00000Oo);
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<ces.O000000o> {
        /* synthetic */ O00000Oo(ceu ceu, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            ces.O000000o o000000o = (ces.O000000o) obj;
            Log.d("CheckPasswordPresenter", "start login success");
            super.handleSuccess(o000000o);
            if (o000000o.O00000Oo == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("processId", ceu.this.f13693O000000o);
                if (!TextUtils.isEmpty(o000000o.f13692O000000o)) {
                    bundle.putString("fullAuth", o000000o.f13692O000000o);
                }
                new CheckAuthModel(ceu.this.getSession()).checkAuth(bundle, new O000000o(ceu.this, (byte) 0));
                return;
            }
            Log.d("CheckPasswordPresenter", "result is not success,because check password error from account sdk");
            ((cet.O00000Oo) ceu.this.getView()).c();
        }

        private O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("CheckPasswordPresenter", "start login error:".concat(String.valueOf(i)));
            ((cet.O00000Oo) ceu.this.getView()).a(str, (Throwable) null);
        }
    }

    class O000000o implements CheckAuthModel.ICheckAuthCallback {
        private O000000o() {
        }

        /* synthetic */ O000000o(ceu ceu, byte b) {
            this();
        }

        public final void onSuccess() {
            Log.d("CheckPasswordPresenter", "check auth success");
            ((cet.O00000Oo) ceu.this.getView()).d();
        }

        public final void onAccountFrozen() {
            Log.d("CheckPasswordPresenter", "onAccountFrozen");
            ((cet.O00000Oo) ceu.this.getView()).b();
        }

        public final void onPasswordCheck() {
            Log.d("CheckPasswordPresenter", "onPasswordCheck");
            ((cet.O00000Oo) ceu.this.getView()).c();
        }

        public final void onSMSCodeCheck(Bundle bundle) {
            Log.d("CheckPasswordPresenter", "onSMSCodeCheck");
            ((cet.O00000Oo) ceu.this.getView()).a(bundle);
        }

        public final void onBindPhoneCheck(Bundle bundle) {
            Log.d("CheckPasswordPresenter", "onBindPhoneCheck");
            ((cet.O00000Oo) ceu.this.getView()).a(bundle);
        }

        public final void onProcessExpired() {
            Log.d("CheckPasswordPresenter", "onProcessExpired");
            ((cet.O00000Oo) ceu.this.getView()).a();
        }

        public final void onAuthCheckError(int i, String str, Throwable th) {
            Log.d("CheckPasswordPresenter", "onAuthCheckError", th);
            ((cet.O00000Oo) ceu.this.getView()).a(str, th);
        }
    }
}

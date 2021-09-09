package _m_j;

import _m_j.cgq;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpPresenter;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.auth.CheckAuthModel;
import com.mibi.sdk.pay.model.DoPayModel;
import com.mibi.sdk.pay.model.UploadOrderGiftcardModel;
import com.mibi.sdk.pay.task.RxStartAccountPaymentTask;

public final class cgr extends BaseMvpPresenter<cgq.O00000Oo> implements cgq.O000000o {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13785O000000o;
    private CheckAuthModel O00000Oo;
    private RxStartAccountPaymentTask.Result O00000o0;

    public final void onInit(Bundle bundle) {
        super.onInit(bundle);
        if (bundle != null) {
            this.f13785O000000o = bundle.getString("processId");
            this.O00000o0 = (RxStartAccountPaymentTask.Result) bundle.getSerializable("pay_type_result");
        } else {
            this.f13785O000000o = getArguments().getString("processId");
            this.O00000o0 = (RxStartAccountPaymentTask.Result) getArguments().getSerializable("pay_type_result");
        }
        this.O00000Oo = new CheckAuthModel(getSession());
    }

    public cgr() {
        super(cgq.O00000Oo.class);
    }

    public final void handleResult(int i, int i2, Bundle bundle) {
        super.handleResult(i, i2, bundle);
        MibiLog.d("PaymentOrderPre", "handleResult requestCode : " + i + " ; resultCode : " + i2);
        if (i == 48) {
            if (i2 == -1) {
                ((cgq.O00000Oo) getView()).a(bundle.getString("recharge_pay_type_chosen"));
            }
        } else if (i == 49) {
            if (i2 == -1) {
                boolean z = bundle.getBoolean("useGiftcard");
                boolean z2 = bundle.getBoolean("usePartnerGiftcard");
                ((cgq.O00000Oo) getView()).a(bundle.getBoolean("useBalance"), z, z2, bundle.getInt("discountGiftCardIndex"));
            }
        } else if (i == 50) {
            if (i2 == -1) {
                ((cgq.O00000Oo) getView()).d();
            } else {
                ((cgq.O00000Oo) getView()).a(i2, bundle.getString("message"), null);
            }
        } else if (i == 51) {
            if (i2 == -1) {
                ((cgq.O00000Oo) getView()).d();
            } else {
                ((cgq.O00000Oo) getView()).a(i2, bundle.getString("message"), null);
            }
        } else if (i != 52) {
        } else {
            if (i2 == -1) {
                ((cgq.O00000Oo) getView()).a(bundle, false);
            } else {
                ((cgq.O00000Oo) getView()).a(i2, bundle.getString("message"), null);
            }
        }
    }

    public final void O000000o() {
        Bundle bundle = new Bundle();
        bundle.putString("processId", this.f13785O000000o);
        this.O00000Oo.checkAuth(bundle, new CheckAuthModel.ICheckAuthCallback() {
            /* class _m_j.cgr.AnonymousClass1 */

            public final void onSuccess() {
                ((cgq.O00000Oo) cgr.this.getView()).d();
            }

            public final void onAccountFrozen() {
                ((cgq.O00000Oo) cgr.this.getView()).a();
            }

            public final void onPasswordCheck() {
                ((cgq.O00000Oo) cgr.this.getView()).c();
            }

            public final void onSMSCodeCheck(Bundle bundle) {
                ((cgq.O00000Oo) cgr.this.getView()).a(bundle);
            }

            public final void onBindPhoneCheck(Bundle bundle) {
                ((cgq.O00000Oo) cgr.this.getView()).b(bundle);
            }

            public final void onProcessExpired() {
                ((cgq.O00000Oo) cgr.this.getView()).b();
            }

            public final void onAuthCheckError(int i, String str, Throwable th) {
                ((cgq.O00000Oo) cgr.this.getView()).a(i, str, th);
            }
        });
    }

    public final String O00000Oo() {
        return this.f13785O000000o;
    }

    public final void O000000o(boolean z, boolean z2, int i, boolean z3) {
        MibiLog.d("PaymentOrderPre", "startPay useGiftCard : " + z + " ; usePartnerGiftCard : " + z2 + " ; useBalance : " + z);
        if (O000000o(z, z3, z2, i) <= 0) {
            MibiLog.d("PaymentOrderPre", "doPay");
            Bundle bundle = new Bundle();
            bundle.putString("processId", this.f13785O000000o);
            bundle.putBoolean("useBalance", z3);
            bundle.putBoolean("useGiftcard", z);
            bundle.putBoolean("usePartnerGiftcard", z2);
            bundle.putLong("discountGiftcardId", O000000o(i));
            new DoPayModel(getSession()).request(bundle, new O000000o(this, (byte) 0));
            return;
        }
        MibiLog.d("PaymentOrderPre", "uploadGiftCard");
        UploadOrderGiftcardModel uploadOrderGiftcardModel = new UploadOrderGiftcardModel(getSession());
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", this.f13785O000000o);
        sortedParameter.add("useGiftcard", Boolean.valueOf(z));
        sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(z2));
        sortedParameter.add("discountGiftcardId", Long.valueOf(O000000o(i)));
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("sortedParams", sortedParameter);
        uploadOrderGiftcardModel.request(bundle2, new O00000Oo(O000000o(z, z3, z2, i)));
    }

    private long O000000o(boolean z, boolean z2, boolean z3, int i) {
        return this.O00000o0.mOrderPrice - O00000Oo(z, z2, z3, i);
    }

    private long O00000Oo(boolean z, boolean z2, boolean z3, int i) {
        long j = 0;
        if (z) {
            j = 0 + this.O00000o0.mGiftcardValue;
        }
        if (z3) {
            j += this.O00000o0.mPartnerGiftcardValue;
        }
        if (z2) {
            j += this.O00000o0.mBalance;
        }
        return i >= 0 ? j + this.O00000o0.mDiscountGiftCards.get(i).mGiftCardValue : j;
    }

    private long O000000o(int i) {
        if (i < 0 || this.O00000o0.mDiscountGiftCards == null || this.O00000o0.mDiscountGiftCards.size() <= 0) {
            return 0;
        }
        return this.O00000o0.mDiscountGiftCards.get(i).mGiftCardId;
    }

    class O000000o implements IBaseModel.IResultCallback<Bundle> {
        private O000000o() {
        }

        /* synthetic */ O000000o(cgr cgr, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("PaymentOrderPre", "do direct pay success");
            ((cgq.O00000Oo) cgr.this.getView()).a((Bundle) obj, true);
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("PaymentOrderPre", "do direct failed:" + i + ",desc:" + str, th);
            ((cgq.O00000Oo) cgr.this.getView()).a(i, str, th);
        }
    }

    class O00000Oo implements IBaseModel.IResultCallback<Void> {
        private long O00000Oo;

        public O00000Oo(long j) {
            this.O00000Oo = j;
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("PaymentOrderPre", "upload giftCard failed");
            ((cgq.O00000Oo) cgr.this.getView()).a(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("PaymentOrderPre", "upload giftCard success");
            cgr.this.getSession().getMemoryStorage().put(cgr.this.f13785O000000o, "rechargeValue", Long.valueOf(this.O00000Oo));
            ((cgq.O00000Oo) cgr.this.getView()).e();
        }
    }

    public final void onSave(Bundle bundle) {
        super.onSave(bundle);
        bundle.putString("processId", this.f13785O000000o);
        bundle.putSerializable("pay_type_result", this.O00000o0);
    }
}

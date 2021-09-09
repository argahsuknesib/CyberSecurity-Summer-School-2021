package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.MemoryStorage;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.OrderBean;
import com.mibi.sdk.component.privacy.PrivacyManager;
import com.mibi.sdk.component.recharge.RechargeManager;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.pay.model.UploadOrderGiftcardModel;
import com.mibi.sdk.pay.task.RxAccountGetRechargeTypeTask;
import com.mibi.sdk.pay.task.RxStartAccountPaymentTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.mibi.sdk.task.RxPrivacyUploadTask;

public final class cgk extends Model<Bundle> {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13767O000000o;
    /* access modifiers changed from: private */
    public String O00000Oo;
    /* access modifiers changed from: private */
    public boolean O00000o0;

    public cgk(Session session, boolean z) {
        super(session);
        this.O00000o0 = z;
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Bundle> iResultCallback) {
        super.request(bundle, iResultCallback);
        SortedParameter sortedParameter = (SortedParameter) bundle.getSerializable("sortedParams");
        if (sortedParameter == null || iResultCallback == null) {
            throw new IllegalStateException();
        }
        this.f13767O000000o = sortedParameter.getString("processId");
        RxStartAccountPaymentTask rxStartAccountPaymentTask = new RxStartAccountPaymentTask(getContext(), getSession());
        rxStartAccountPaymentTask.setParams(sortedParameter);
        chh.O000000o(rxStartAccountPaymentTask).O000000o(new O00000Oo(this, getContext(), (byte) 0));
    }

    class O00000Oo extends RxBaseErrorHandleTaskListener<RxStartAccountPaymentTask.Result> {
        /* synthetic */ O00000Oo(cgk cgk, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            RxStartAccountPaymentTask.Result result = (RxStartAccountPaymentTask.Result) obj;
            if (result.mResult != null) {
                new Bundle().putString("payment_payment_result", result.mResult);
                cgk.this.getCallback().onFailed(result.mResultErrorCode, result.mResultErrorDesc, null);
                return;
            }
            String unused = cgk.this.O00000Oo = result.mServerMarketType;
            MemoryStorage memoryStorage = cgk.this.getSession().getMemoryStorage();
            if (cgk.this.O00000o0) {
                memoryStorage.put(cgk.this.f13767O000000o, "pay_type_result", result);
                cgk.O000000o(cgk.this, result.mOrderPrice);
                return;
            }
            memoryStorage.put(cgk.this.f13767O000000o, "orderFee", Long.valueOf(result.mOrderPrice));
            memoryStorage.put(cgk.this.f13767O000000o, "balance", Long.valueOf(result.mBalance));
            memoryStorage.put(cgk.this.f13767O000000o, "giftcardValue", Long.valueOf(result.mGiftcardValue));
            memoryStorage.put(cgk.this.f13767O000000o, "partnerGiftcardValue", Long.valueOf(result.mPartnerGiftcardValue));
            memoryStorage.put(cgk.this.f13767O000000o, "useGiftcardAllowed", Boolean.valueOf(result.mUseGiftcard));
            memoryStorage.put(cgk.this.f13767O000000o, "usePartnerGiftcardAllowed", Boolean.valueOf(result.mUsePartnerGiftcard));
            memoryStorage.put(cgk.this.f13767O000000o, "rechargeValue", Long.valueOf(cgk.O00000oo(cgk.this)));
            Log.d("AccountOrderCheckModel", "requesting giftcards");
            OrderBean orderBean = (OrderBean) cgk.this.getSession().getMemoryStorage().get(cgk.this.f13767O000000o, "orderBean");
            UploadOrderGiftcardModel uploadOrderGiftcardModel = new UploadOrderGiftcardModel(cgk.this.getSession());
            SortedParameter sortedParameter = new SortedParameter();
            sortedParameter.add("processId", cgk.this.f13767O000000o);
            sortedParameter.add("useGiftcard", Boolean.valueOf(orderBean.mUseGiftcard));
            sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(orderBean.mUseParterGiftcard));
            Bundle bundle = new Bundle();
            bundle.putSerializable("sortedParams", sortedParameter);
            uploadOrderGiftcardModel.request(bundle, new O00000o0(cgk.this, (byte) 0));
        }

        private O00000Oo(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cgk.this.getCallback().onFailed(i, str, th);
        }
    }

    class O00000o0 implements IBaseModel.IResultCallback<Void> {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(cgk cgk, byte b) {
            this();
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("AccountOrderCheckModel", "upload giftcard failed");
            cgk.this.getCallback().onFailed(i, str, th);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Log.d("AccountOrderCheckModel", "upload giftcard successed");
            long j = cgk.this.getSession().getMemoryStorage().getLong(cgk.this.f13767O000000o, "rechargeValue");
            if (j > 0) {
                Log.d("AccountOrderCheckModel", "need third party recharge");
                cgk.O000000o(cgk.this, j);
                return;
            }
            Log.d("AccountOrderCheckModel", "no need third party recharge");
            cgk.this.getCallback().onSuccess(null);
            cgk cgk = cgk.this;
            cgk.O00000Oo(cgk, cgk.O00000Oo);
        }
    }

    class O000000o implements IBaseModel.IResultCallback<RxAccountGetRechargeTypeTask.Result> {
        private O000000o() {
        }

        /* synthetic */ O000000o(cgk cgk, byte b) {
            this();
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            RxAccountGetRechargeTypeTask.Result result = (RxAccountGetRechargeTypeTask.Result) obj;
            Log.d("AccountOrderCheckModel", "get recharge types success");
            Bundle bundle = new Bundle();
            bundle.putSerializable("recharge_types", result.mRechargeTypes);
            if (cgk.this.O00000o0) {
                bundle.putSerializable("recharge_types_result", result);
            }
            cgk.this.getCallback().onSuccess(bundle);
            cgk cgk = cgk.this;
            cgk.O00000Oo(cgk, cgk.O00000Oo);
        }

        public final void onFailed(int i, String str, Throwable th) {
            Log.d("AccountOrderCheckModel", "get recharge types failed");
            cgk.this.getCallback().onFailed(i, str, th);
        }
    }

    static /* synthetic */ void O000000o(cgk cgk, long j) {
        cgj cgj = new cgj(cgk.getSession());
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", cgk.f13767O000000o);
        sortedParameter.add("chargeFee", Long.valueOf(j));
        sortedParameter.add("channels", RechargeManager.get().getChannels(cgk.getContext()));
        Bundle bundle = new Bundle();
        bundle.putSerializable("sortedParams", sortedParameter);
        cgj.request(bundle, new O000000o(cgk, (byte) 0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    static /* synthetic */ long O00000oo(cgk cgk) {
        MemoryStorage memoryStorage = cgk.getSession().getMemoryStorage();
        OrderBean orderBean = (OrderBean) memoryStorage.get(cgk.f13767O000000o, "orderBean");
        boolean z = orderBean.mUseBalance;
        boolean z2 = orderBean.mUseGiftcard;
        boolean z3 = orderBean.mUseParterGiftcard;
        long j = memoryStorage.getLong(cgk.f13767O000000o, "orderFee");
        long j2 = memoryStorage.getLong(cgk.f13767O000000o, "balance");
        long j3 = memoryStorage.getLong(cgk.f13767O000000o, "giftcardValue");
        long j4 = memoryStorage.getLong(cgk.f13767O000000o, "partnerGiftcardValue");
        boolean booleanValue = ((Boolean) memoryStorage.get(cgk.f13767O000000o, "useGiftcardAllowed")).booleanValue();
        boolean booleanValue2 = ((Boolean) memoryStorage.get(cgk.f13767O000000o, "usePartnerGiftcardAllowed")).booleanValue();
        long j5 = z ? j2 + 0 : 0;
        if (booleanValue && z2) {
            j5 += j3;
        }
        if (booleanValue2 && z3) {
            j5 += j4;
        }
        return Math.max(j - j5, 0L);
    }

    static /* synthetic */ void O00000Oo(cgk cgk, String str) {
        PrivacyManager.makePrivacyParam(cgk.getSession(), str, "PAYMENTPAGE");
        chh.O000000o(new RxPrivacyUploadTask(cgk.getSession())).O000000o();
    }
}

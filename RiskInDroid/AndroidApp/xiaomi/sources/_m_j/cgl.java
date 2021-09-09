package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.pay.task.RxStartNoAccountPaymentTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;
import com.mibi.sdk.task.handler.ServerErrorCodeExceptionHandler;

public final class cgl extends Model<Bundle> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13771O000000o;

    public cgl(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Bundle> iResultCallback) {
        super.request(bundle, iResultCallback);
        SortedParameter sortedParameter = (SortedParameter) bundle.getSerializable("sortedParams");
        if (sortedParameter == null || iResultCallback == null) {
            throw new IllegalStateException();
        }
        this.f13771O000000o = sortedParameter.getString("processId");
        RxStartNoAccountPaymentTask rxStartNoAccountPaymentTask = new RxStartNoAccountPaymentTask(getContext(), getSession());
        rxStartNoAccountPaymentTask.setParams(sortedParameter);
        O000000o o000000o = new O000000o(this, getContext(), (byte) 0);
        o000000o.getDispatcher().register(new ServerErrorCodeExceptionHandler(getContext()) {
            /* class _m_j.cgl.AnonymousClass1 */

            public final boolean handleServerErrorCodeError(int i, String str, Object obj) {
                int i2;
                if (i == 1986) {
                    i2 = 7;
                } else if (i != 1991) {
                    return false;
                } else {
                    i2 = 13;
                }
                RxStartNoAccountPaymentTask.Result result = (RxStartNoAccountPaymentTask.Result) obj;
                if (result.mResult != null) {
                    new Bundle().putString("payment_payment_result", result.mResult);
                }
                cgl.this.getCallback().onFailed(i2, str, null);
                return true;
            }
        });
        chh.O000000o(rxStartNoAccountPaymentTask).O000000o(o000000o);
    }

    class O000000o extends RxBaseErrorHandleTaskListener<RxStartNoAccountPaymentTask.Result> {
        /* synthetic */ O000000o(cgl cgl, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            RxStartNoAccountPaymentTask.Result result = (RxStartNoAccountPaymentTask.Result) obj;
            if (result.mResult != null) {
                Log.d("NoAccountCheckModel", "error,result is not null");
                cgl.this.getCallback().onFailed(result.mResultErrorCode, result.mResultErrorDesc, null);
                return;
            }
            cgl.O000000o(cgl.this, result);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cgl.this.getCallback().onFailed(i, str, th);
        }
    }

    static /* synthetic */ void O000000o(cgl cgl, RxStartNoAccountPaymentTask.Result result) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("recharge_types", result.mRechargeTypes);
        bundle.putString("processId", cgl.f13771O000000o);
        bundle.putLong("orderFee", result.mOrderFee);
        bundle.putLong("rechargeValue", result.mOrderFee);
        bundle.putString("orderDesc", result.mOrderDesc);
        cgl.getSession().getMemoryStorage().put(cgl.f13771O000000o, "orderFee", Long.valueOf(result.mOrderFee));
        cgl.getCallback().onSuccess(bundle);
    }
}

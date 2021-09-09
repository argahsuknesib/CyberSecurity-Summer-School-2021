package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.QueryPaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.common.utils.QueryIntervalUtils;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.pay.task.RxQueryAndPayTask;
import com.mibi.sdk.task.AutoQuerier;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public final class cgm extends Model<Bundle> {

    /* renamed from: O000000o  reason: collision with root package name */
    private int[] f13774O000000o = {0, 1, 1, 2, 3, 5, 7, 10};
    private AutoQuerier O00000Oo;
    private long O00000o;
    private String O00000o0;
    private AutoQuerier.AutoQuerierCallback O00000oO = new AutoQuerier.AutoQuerierCallback() {
        /* class _m_j.cgm.AnonymousClass1 */

        public final void onComplete() {
        }

        public final void onStart() {
        }

        public final void onProgressUpdate(long j) {
            Log.d("QueryModel", "current count down time:".concat(String.valueOf(j)));
            cgm.O000000o(cgm.this);
        }
    };

    public cgm(Session session) {
        super(session);
    }

    public final void request(Bundle bundle, IBaseModel.IResultCallback<Bundle> iResultCallback) {
        super.request(bundle, iResultCallback);
        this.O00000o0 = bundle.getString("processId");
        this.O00000o = getSession().getMemoryStorage().getLong(this.O00000o0, "orderFee");
        int[] queryInterval = QueryIntervalUtils.getQueryInterval((String) getSession().getMemoryStorage().getSerializable("mibi_extra_params"));
        if (queryInterval == null || queryInterval.length <= 0) {
            MibiLog.d("QueryModel", "interval is null");
        } else {
            this.f13774O000000o = queryInterval;
        }
        this.O00000Oo = new AutoQuerier(this.f13774O000000o, this.O00000oO);
        this.O00000Oo.query();
    }

    class O000000o extends RxBaseErrorHandleTaskListener<RxQueryAndPayTask.Result> {
        /* synthetic */ O000000o(cgm cgm, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            RxQueryAndPayTask.Result result = (RxQueryAndPayTask.Result) obj;
            if (TextUtils.equals(result.mChargeStatus, "TRADE_SUCCESS")) {
                cgm.O000000o(cgm.this, result);
            } else if (TextUtils.equals(result.mChargeStatus, "WAIT_BUYER_PAY")) {
                cgm.O00000Oo(cgm.this);
            } else if (TextUtils.equals(result.mChargeStatus, "TRADE_CLOSED")) {
                cgm.this.O000000o();
            } else if (TextUtils.equals(result.mChargeStatus, "TRADE_FAIL")) {
                cgm.this.O000000o(1, result.mErrorDesc, result);
            }
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            cgm.this.O000000o(i, str, (RxQueryAndPayTask.Result) null);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(int i, String str, RxQueryAndPayTask.Result result) {
        Bundle bundle = new Bundle();
        bundle.putInt("payment_error", i);
        bundle.putString("payment_error_des", str);
        if (result == null || !result.mRechargeSuccess) {
            bundle.putInt("resultCode", 1001);
        } else {
            bundle.putInt("resultCode", 1003);
        }
        getCallback().onFailed(i, str, new QueryPaymentException(bundle));
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        Bundle bundle = new Bundle();
        bundle.putInt("status", 3);
        bundle.putString("result", "");
        bundle.putInt("resultCode", 1002);
        getCallback().onFailed(0, "time out", new QueryPaymentException(bundle));
    }

    static /* synthetic */ void O000000o(cgm cgm) {
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", cgm.O00000o0);
        sortedParameter.add("mibi", Long.valueOf(cgm.O00000o));
        RxQueryAndPayTask rxQueryAndPayTask = new RxQueryAndPayTask(cgm.getContext(), cgm.getSession());
        rxQueryAndPayTask.setParams(sortedParameter);
        chh.O000000o(rxQueryAndPayTask).O000000o(new O000000o(cgm, cgm.getContext(), (byte) 0));
    }

    static /* synthetic */ void O000000o(cgm cgm, RxQueryAndPayTask.Result result) {
        if (result.mPayStatus == 200) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 1);
            bundle.putString("bannerPicUrl", result.mImageUrl);
            bundle.putSerializable("paySuccessBannerData", result.mEntryData);
            bundle.putInt("resultCode", 1004);
            cgm.getCallback().onSuccess(result.mResult);
            return;
        }
        cgm.O000000o(result.mPayStatus, "trade failed", result);
    }

    static /* synthetic */ void O00000Oo(cgm cgm) {
        if (cgm.O00000Oo.hasNext()) {
            cgm.O00000Oo.query();
        } else {
            cgm.O000000o();
        }
    }
}

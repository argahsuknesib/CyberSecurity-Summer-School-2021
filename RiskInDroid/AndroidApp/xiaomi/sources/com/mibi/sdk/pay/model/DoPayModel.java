package com.mibi.sdk.pay.model;

import _m_j.chh;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.model.IBaseModel;
import com.mibi.sdk.model.Model;
import com.mibi.sdk.pay.task.RxDoPayTask;
import com.mibi.sdk.task.RxBaseErrorHandleTaskListener;

public class DoPayModel extends Model<Bundle> {
    public DoPayModel(Session session) {
        super(session);
    }

    public void request(Bundle bundle, IBaseModel.IResultCallback<Bundle> iResultCallback) {
        super.request(bundle, iResultCallback);
        Log.d("DoPayModel", "request");
        String string = bundle.getString("processId");
        boolean z = bundle.getBoolean("useGiftcard");
        boolean z2 = bundle.getBoolean("usePartnerGiftcard");
        long j = bundle.getLong("discountGiftcardId", 0);
        SortedParameter sortedParameter = new SortedParameter();
        sortedParameter.add("processId", string);
        sortedParameter.add("useGiftcard", Boolean.valueOf(z));
        sortedParameter.add("usePartnerGiftcard", Boolean.valueOf(z2));
        sortedParameter.add("discountGiftcardId", Long.valueOf(j));
        RxDoPayTask rxDoPayTask = new RxDoPayTask(getContext(), getSession());
        rxDoPayTask.setParams(sortedParameter);
        chh.O000000o(rxDoPayTask).O000000o(new O000000o(this, getContext(), (byte) 0));
    }

    class O000000o extends RxBaseErrorHandleTaskListener<RxDoPayTask.Result> {
        /* synthetic */ O000000o(DoPayModel doPayModel, Context context, byte b) {
            this(context);
        }

        public final /* synthetic */ void handleSuccess(Object obj) {
            Log.d("DoPayModel", "success");
            DoPayModel.this.getCallback().onSuccess(((RxDoPayTask.Result) obj).mResult);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final void handleError(int i, String str, Throwable th) {
            Log.d("DoPayModel", "error:".concat(String.valueOf(i)), th);
            DoPayModel.this.getCallback().onFailed(i, str, th);
        }
    }
}

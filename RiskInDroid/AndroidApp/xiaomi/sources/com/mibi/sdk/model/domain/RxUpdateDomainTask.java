package com.mibi.sdk.model.domain;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.NotConnectedException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ServiceTokenExpiredException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.DomainManager;
import com.mibi.sdk.task.RxTask;

public class RxUpdateDomainTask extends RxTask<Result> {
    private Context mContext;
    private SortedParameter mParams;
    private Session mSession;

    public static class Result {
    }

    public RxUpdateDomainTask(Context context, Session session) {
        super(Result.class);
        this.mContext = context;
        this.mSession = session;
    }

    public void setParams(SortedParameter sortedParameter) {
        if (sortedParameter == null) {
            sortedParameter = new SortedParameter();
        }
        this.mParams = sortedParameter;
    }

    /* access modifiers changed from: protected */
    public void doLoad(Result result) throws PaymentException {
        if (Utils.isConnected(this.mContext)) {
            this.mSession.load(this.mContext);
            try {
                updateDomain(this.mParams);
            } catch (ServiceTokenExpiredException unused) {
                if (CommonConstants.DEBUG) {
                    Log.i("RxUpdateDomainTask", "updateDomain service token expired, re-login");
                }
                this.mSession.reload(this.mContext);
                updateDomain(this.mParams);
            }
        } else {
            throw new NotConnectedException();
        }
    }

    private void updateDomain(SortedParameter sortedParameter) throws PaymentException {
        DomainManager.updateDomainByOrder(this.mSession, sortedParameter.getString("payment_pay_order"), sortedParameter.getString("payment_pay_order_qr_url"));
    }
}

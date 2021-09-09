package com.mibi.sdk.task;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.recharge.EntryData;
import com.mibi.sdk.task.RxBaseQueryTask.Result;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RxBaseQueryTask<TaskResult extends Result> extends RxBasePaymentTask<TaskResult> {
    private long mLocalRechargeFee;

    public static class Result implements Serializable {
        public long mBalance;
        public String mChargeStatus;
        public String mErrorDesc;
        public String mHint;
        public EntryData mHintEntryData;
        public long mRechargeFee;
        public boolean mRechargeSuccess = false;
    }

    public RxBaseQueryTask(Context context, Session session, Class<TaskResult> cls) {
        super(context, session, cls);
    }

    public void setParams(SortedParameter sortedParameter) {
        super.setParams(sortedParameter);
        this.mLocalRechargeFee = sortedParameter.getLong("mibi");
    }

    /* access modifiers changed from: protected */
    public void parseResultInCommon(JSONObject jSONObject, TaskResult taskresult) throws PaymentException {
        taskresult.mErrorDesc = jSONObject.optString("errDesc");
        taskresult.mBalance = jSONObject.optLong("balance", -1);
    }

    /* access modifiers changed from: protected */
    public void parseResultInSuccess(JSONObject jSONObject, Result result) throws PaymentException {
        try {
            result.mChargeStatus = jSONObject.getString("chargeStatus");
            result.mRechargeFee = jSONObject.getLong("chargeFee");
            result.mHint = jSONObject.optString("resultActivity");
            JSONObject optJSONObject = jSONObject.optJSONObject("entry");
            if (optJSONObject != null) {
                result.mHintEntryData = new EntryData();
                result.mHintEntryData.parseEntryData(optJSONObject);
            }
            if (!TextUtils.equals(result.mChargeStatus, "TRADE_SUCCESS") && !TextUtils.equals(result.mChargeStatus, "WAIT_BUYER_PAY") && !TextUtils.equals(result.mChargeStatus, "TRADE_CLOSED") && !TextUtils.equals(result.mChargeStatus, "TRADE_FAIL")) {
                throw new ResultException("result has error");
            } else if (TextUtils.equals(result.mChargeStatus, "TRADE_SUCCESS")) {
                if (!(this.mSession.getAccountLoader() instanceof FakeAccountLoader) && result.mBalance < 0) {
                    throw new ResultException("result has error");
                } else if (result.mRechargeFee > 0) {
                    result.mRechargeSuccess = true;
                } else {
                    throw new ResultException("result has error");
                }
            } else if (result.mRechargeFee <= 0) {
                result.mRechargeFee = this.mLocalRechargeFee;
            }
        } catch (JSONException e) {
            throw new ResultException(e);
        }
    }
}

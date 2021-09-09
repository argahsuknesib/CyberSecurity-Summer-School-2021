package com.mibi.sdk.pay.task;

import android.content.Context;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.DiscountGiftCard;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RxStartAccountPaymentTask extends RxBasePaymentTask<Result> {
    public RxStartAccountPaymentTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("order");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/checkPayment"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("isPad", Boolean.valueOf(Utils.isPad()));
        parameter.add("order", string2);
        return createAccountConnection;
    }

    /* access modifiers changed from: protected */
    public boolean parseResultInError(JSONObject jSONObject, Result result) throws PaymentException {
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return false;
        }
        result.mResult = optJSONObject.toString();
        try {
            result.mResultErrorCode = jSONObject.getInt("errcode");
            result.mResultErrorDesc = jSONObject.optString("errDesc");
            return true;
        } catch (JSONException e) {
            throw new ResultException("error code not exists", e);
        }
    }

    /* access modifiers changed from: protected */
    public void parseResultInSuccess(JSONObject jSONObject, Result result) throws PaymentException {
        JSONObject jSONObject2 = jSONObject;
        Result result2 = result;
        try {
            long j = jSONObject2.getLong("balance");
            long j2 = jSONObject2.getLong("giftcardValue");
            long j3 = jSONObject2.getLong("partnerGiftcardValue");
            boolean optBoolean = jSONObject2.optBoolean("useGiftcard", true);
            boolean optBoolean2 = jSONObject2.optBoolean("usePartnerGiftcard", true);
            String string = jSONObject2.getString("partnerGiftcardName");
            String string2 = jSONObject2.getString("title");
            long j4 = jSONObject2.getLong("price");
            String string3 = jSONObject2.getString("marketType");
            String str = "giftcardValue";
            String string4 = jSONObject2.getString("tradeId");
            long j5 = j4;
            int optInt = jSONObject2.optInt("payMode", 0);
            String optString = jSONObject2.optString("merchantName");
            JSONArray optJSONArray = jSONObject2.optJSONArray("discountGiftcards");
            int i = optInt;
            int i2 = 0;
            int optInt2 = jSONObject2.optInt("orderConsumedDiscountGiftcardId", 0);
            if (Utils.checkStrings(string2, string3, string4)) {
                result2.mBalance = j;
                result2.mGiftcardValue = j2;
                result2.mPartnerGiftcardValue = j3;
                result2.mUseGiftcard = optBoolean;
                result2.mUsePartnerGiftcard = optBoolean2;
                result2.mPartnerGiftcardName = string;
                result2.mOrderTitle = string2;
                result2.mOrderPrice = j5;
                result2.mServerMarketType = string3;
                result2.mTradeId = string4;
                result2.mPayMode = i;
                result2.mMerchantName = optString;
                result2.mOrderConsumedDiscountGiftcardId = optInt2;
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    result2.mDiscountGiftCards = new ArrayList<>();
                    while (i2 < length) {
                        DiscountGiftCard discountGiftCard = new DiscountGiftCard();
                        JSONArray jSONArray = optJSONArray;
                        try {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            discountGiftCard.mGiftCardId = jSONObject3.getLong("giftcardId");
                            String str2 = str;
                            discountGiftCard.mGiftCardValue = jSONObject3.getLong(str2);
                            discountGiftCard.mOrderFeeRequiredValue = jSONObject3.getLong("orderFeeRequired");
                            result2.mDiscountGiftCards.add(discountGiftCard);
                            i2++;
                            optJSONArray = jSONArray;
                            str = str2;
                        } catch (JSONException e) {
                            throw new ResultException(e);
                        }
                    }
                    return;
                }
                return;
            }
            throw new ResultException("result has error");
        } catch (JSONException e2) {
            throw new ResultException(e2);
        }
    }

    public static class Result implements Serializable {
        public long mBalance;
        public ArrayList<DiscountGiftCard> mDiscountGiftCards;
        public long mGiftcardValue;
        public String mMerchantName;
        public int mOrderConsumedDiscountGiftcardId;
        public long mOrderPrice;
        public String mOrderTitle;
        public String mPartnerGiftcardName;
        public long mPartnerGiftcardValue;
        public int mPayMode;
        public String mResult;
        public int mResultErrorCode;
        public String mResultErrorDesc;
        public String mServerMarketType;
        public String mTradeId;
        public boolean mUseGiftcard;
        public boolean mUsePartnerGiftcard;

        public long getTotalBalance() {
            long j = this.mBalance;
            if (this.mUseGiftcard) {
                j += this.mGiftcardValue;
            }
            return this.mUsePartnerGiftcard ? j + this.mPartnerGiftcardValue : j;
        }
    }
}

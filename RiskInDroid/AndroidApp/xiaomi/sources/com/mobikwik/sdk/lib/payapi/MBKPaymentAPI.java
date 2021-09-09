package com.mobikwik.sdk.lib.payapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import com.google.gson.Gson;
import com.mobikwik.sdk.lib.Constants;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.model.MBKInitPaymentReq;
import com.mobikwik.sdk.lib.model.MbkInitPaymentResponse;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.payapi.PaymentAPI;
import com.mobikwik.sdk.lib.payinstrument.Bank;
import com.mobikwik.sdk.lib.payinstrument.Card;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.RSAEncUtils;
import com.mobikwik.sdk.lib.utils.Utils;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class MBKPaymentAPI implements PaymentAPI, Serializable {
    Activity activity;
    public String addAmount;
    String bankid;
    public String buyerEmail;
    private String buyerName;
    public String buyerPhoneNumber;
    public PaymentAPI.Callback callback;
    Card card;
    String currency;
    ProgressDialog dialog;
    public boolean isToken;
    public PaymentsMappingAPIResponse.PaymentsMapping.MbkPublicKey mbkKey;
    public String merchantName;
    String merchantOrderId;
    String mkOrderId;
    public String mobikwikMBKid;
    String sdkMode;
    public String tokenOrOtp;
    public String txnAmount;
    public String txnHash;

    class GetChecksumNew extends AsyncTask {
        private SDKErrorCodes code;
        private String response;

        private GetChecksumNew() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... strArr) {
            String str;
            RSAEncUtils rSAEncUtils = new RSAEncUtils(MBKPaymentAPI.this.mbkKey);
            String str2 = Constants.getServerUrl(MBKPaymentAPI.this.sdkMode) + "/p/pg/v1/sdk/initiate";
            MBKInitPaymentReq mBKInitPaymentReq = new MBKInitPaymentReq();
            if (MBKPaymentAPI.this.card != null) {
                mBKInitPaymentReq.cardBanking = MBKPaymentAPI.this.card.encrypt(rSAEncUtils);
                str = "CC";
            } else if (MBKPaymentAPI.this.bankid != null) {
                mBKInitPaymentReq.netBanking = new Bank(MBKPaymentAPI.this.bankid, "");
                str = "NB";
            } else {
                this.code = SDKErrorCodes.UNEXPECTED_ERROR;
                return null;
            }
            mBKInitPaymentReq.payMode = str;
            mBKInitPaymentReq.amount = MBKPaymentAPI.this.addAmount;
            mBKInitPaymentReq.deviceId = "jaglfiugl345ie4676urg89l0ile5rrgkjbsrgu";
            mBKInitPaymentReq.deviceName = Build.MANUFACTURER + " " + Build.MODEL;
            mBKInitPaymentReq.plateform = "ANDROID";
            mBKInitPaymentReq.memberId = MBKPaymentAPI.this.buyerEmail;
            mBKInitPaymentReq.mobileNumber = MBKPaymentAPI.this.buyerPhoneNumber;
            mBKInitPaymentReq.mid = MBKPaymentAPI.this.mobikwikMBKid;
            mBKInitPaymentReq.merchantName = MBKPaymentAPI.this.merchantName;
            if (MBKPaymentAPI.this.isToken) {
                mBKInitPaymentReq.token = MBKPaymentAPI.this.tokenOrOtp;
            } else {
                mBKInitPaymentReq.otp = MBKPaymentAPI.this.tokenOrOtp;
            }
            mBKInitPaymentReq.txnId = MBKPaymentAPI.this.merchantOrderId;
            mBKInitPaymentReq.txnAmount = MBKPaymentAPI.this.txnAmount;
            mBKInitPaymentReq.txnHash = MBKPaymentAPI.this.txnHash;
            this.response = Network.getResponseOfPostRequest(str2, new Gson().toJson(mBKInitPaymentReq), "application/json", null);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            if (MBKPaymentAPI.this.dialog != null && MBKPaymentAPI.this.dialog.isShowing()) {
                MBKPaymentAPI.this.dialog.dismiss();
            }
            if (this.code != null) {
                MBKPaymentAPI.this.callback.onError(this.code.getErrorCode(), this.code.getErrorDescription());
            } else if (!Network.validateNetworkResponse(MBKPaymentAPI.this.activity, this.response, true)) {
                MBKPaymentAPI.this.callback.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
            } else {
                MbkInitPaymentResponse mbkInitPaymentResponse = (MbkInitPaymentResponse) new Gson().fromJson(this.response, MbkInitPaymentResponse.class);
                if (mbkInitPaymentResponse.getSuccess().booleanValue()) {
                    MBKPaymentAPI.this.processSuccessResponse(mbkInitPaymentResponse);
                } else {
                    MBKPaymentAPI.this.callback.onError(mbkInitPaymentResponse.getMessage().getStatusCode(), mbkInitPaymentResponse.getMessage().getText());
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            MBKPaymentAPI mBKPaymentAPI = MBKPaymentAPI.this;
            mBKPaymentAPI.dialog = ProgressDialog.show(mBKPaymentAPI.activity, "", "Processing your payment request...", true);
            MBKPaymentAPI mBKPaymentAPI2 = MBKPaymentAPI.this;
            StringBuilder sb = new StringBuilder();
            sb.append(new Date().getTime());
            mBKPaymentAPI2.mkOrderId = sb.toString();
        }
    }

    private MBKPaymentAPI(User user, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8) {
        this.currency = "INR";
        this.buyerEmail = user.getEmail();
        this.buyerPhoneNumber = user.getCell();
        this.addAmount = str;
        this.sdkMode = str3;
        this.merchantOrderId = str2;
        this.mobikwikMBKid = str4;
        this.txnAmount = str5;
        this.isToken = z;
        this.tokenOrOtp = str6;
        this.merchantName = str7;
        this.txnHash = str8;
    }

    public MBKPaymentAPI(Card card2, PaymentsMappingAPIResponse.PaymentsMapping.MbkPublicKey mbkPublicKey, User user, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8) {
        this(user, str, str2, str3, str4, str5, z, str6, str7, str8);
        this.card = card2;
        this.mbkKey = mbkPublicKey;
    }

    public MBKPaymentAPI(String str, User user, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9) {
        this(user, str2, str3, str4, str5, str6, z, str7, str8, str9);
        this.bankid = str;
    }

    public void processSuccessResponse(MbkInitPaymentResponse mbkInitPaymentResponse) {
        if (mbkInitPaymentResponse.getData().getRedirect().booleanValue()) {
            String str = "";
            for (Map.Entry entry : mbkInitPaymentResponse.getData().getParameters().entrySet()) {
                str = str + ((String) entry.getKey()) + "=" + Utils.utf8Encode((String) entry.getValue()) + "&";
            }
            this.callback.onSuccess(mbkInitPaymentResponse.getData().getPostingUrl(), str, mbkInitPaymentResponse.getData().getHeaders());
            return;
        }
        this.callback.onPaymentCompleted((String) mbkInitPaymentResponse.getData().getParameters().get("Balance"));
    }

    public void setCurrency(String str) {
        if (!Utils.isNull(str)) {
            this.currency = str;
        }
    }

    public void startAPI(PaymentAPI.Callback callback2, Activity activity2) {
        this.activity = activity2;
        this.callback = callback2;
        if (Network.isConnected(activity2)) {
            new GetChecksumNew().execute(new String[0]);
        } else {
            callback2.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
        }
    }
}

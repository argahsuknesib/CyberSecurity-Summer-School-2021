package com.mobikwik.sdk.lib.payapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mobikwik.sdk.lib.Constants;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.payapi.PaymentAPI;
import com.mobikwik.sdk.lib.payinstrument.Card;
import com.mobikwik.sdk.lib.utils.CardUtils;
import com.mobikwik.sdk.lib.utils.Checksum;
import com.mobikwik.sdk.lib.utils.CommonUtils;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.ParamSanitizer;
import com.mobikwik.sdk.lib.utils.RSAEncUtils;
import com.mobikwik.sdk.lib.utils.Utils;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class ZaakpayPaymentAPI implements PaymentAPI, Serializable {
    Activity activity;
    public String amount;
    String bankid;
    private String buyerAddress;
    private String buyerCity;
    private String buyerCountry;
    public String buyerEmail;
    private String buyerFirstName;
    private String buyerLastName;
    private String buyerName;
    public String buyerPhoneNumber;
    private String buyerPincode;
    private String buyerState;
    private PaymentAPI.Callback callback;
    Card card;
    String checksum;
    public String checksumUrl;
    String currency;
    String date;
    String debitOrCredit;
    ProgressDialog dialog;
    int formValid;
    String ipAddress;
    public boolean isWalletTxn;
    String merchantId;
    String merchantOrderId;
    String mkOrderId;
    public String mobikwikMBKid;
    String mode;
    String payOption;
    String phone;
    String purpose;
    String purposeDescription;
    private String returnUrl;
    String returnUrlCopy;
    String sdkMode;
    String txnType;
    private PaymentsMappingAPIResponse.PaymentsMapping.ZaakPayPublicKey zaakpayKey;
    String zpPostUrl;

    class GetChecksumNew extends AsyncTask {
        private GetChecksumNew() {
        }

        private void returnFailure(String str) {
            Utils.sendResultBack(ZaakpayPaymentAPI.this.activity, null, "1", str);
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            String str;
            String str2 = ZaakpayPaymentAPI.this.buyerEmail;
            String str3 = ZaakpayPaymentAPI.this.mobikwikMBKid;
            String str4 = ZaakpayPaymentAPI.this.amount;
            ZaakpayPaymentAPI.this.sanitizeParams();
            HashMap hashMap = new HashMap();
            hashMap.put("amount", ZaakpayPaymentAPI.this.amount);
            if (ZaakpayPaymentAPI.this.isWalletTxn) {
                hashMap.put("ipAddr", ZaakpayPaymentAPI.this.ipAddress);
                hashMap.put("mode", ZaakpayPaymentAPI.this.mode);
                hashMap.put("merchantId", ZaakpayPaymentAPI.this.merchantId);
                hashMap.put("currency", "INR");
                hashMap.put("ipAddr", ZaakpayPaymentAPI.this.ipAddress);
                hashMap.put("date", CardUtils.getCurrentDate());
                hashMap.put("txId", ZaakpayPaymentAPI.this.mkOrderId);
                hashMap.put("codeforrecord", "AndroidSDK");
                hashMap.put("userId", ZaakpayPaymentAPI.this.buyerEmail);
                hashMap.put("gatewayId", "zaakpay");
                hashMap.put("cellNumber", ZaakpayPaymentAPI.this.buyerPhoneNumber);
                hashMap.put("email", str2);
                hashMap.put("mid", str3);
                hashMap.put("orderid", ZaakpayPaymentAPI.this.merchantOrderId);
                hashMap.put("txnAmount", str4);
                hashMap.put("isdesktoporwallet", "wallet");
                hashMap.put("mid", str3);
                str = Constants.getServerUrl(ZaakpayPaymentAPI.this.sdkMode) + "verifyMobilePaymentData.do";
            } else {
                hashMap.put("ipAddr", ZaakpayPaymentAPI.this.ipAddress);
                hashMap.put("orderid", ZaakpayPaymentAPI.this.merchantOrderId);
                hashMap.put("mid", ZaakpayPaymentAPI.this.merchantId);
                hashMap.put("pgName", "Zaakpay");
                hashMap.put("currency", "INR");
                hashMap.put("pgResponseUrl", Utils.utf8Encode(ZaakpayPaymentAPI.this.returnUrlCopy));
                str = ZaakpayPaymentAPI.this.checksumUrl;
            }
            return Network.getResponseOfPostRequest(str, hashMap);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (ZaakpayPaymentAPI.this.dialog != null && ZaakpayPaymentAPI.this.dialog.isShowing()) {
                ZaakpayPaymentAPI.this.dialog.dismiss();
            }
            if (Network.validateNetworkResponse(str)) {
                Checksum parseChecksumResponse = Checksum.parseChecksumResponse(str);
                if (parseChecksumResponse == null) {
                    returnFailure("Checksum failure");
                } else if ("SUCCESS".equals(parseChecksumResponse.getStatus())) {
                    ZaakpayPaymentAPI.this.checksum = parseChecksumResponse.getChecksum();
                    ZaakpayPaymentAPI.this.pay();
                } else {
                    returnFailure(parseChecksumResponse.getChecksum());
                }
            } else {
                Utils.sendResultBack(ZaakpayPaymentAPI.this.activity, null, SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            ZaakpayPaymentAPI zaakpayPaymentAPI = ZaakpayPaymentAPI.this;
            zaakpayPaymentAPI.dialog = ProgressDialog.show(zaakpayPaymentAPI.activity, "", "Processing your payment request...", true);
            ZaakpayPaymentAPI zaakpayPaymentAPI2 = ZaakpayPaymentAPI.this;
            StringBuilder sb = new StringBuilder();
            sb.append(new Date().getTime());
            zaakpayPaymentAPI2.mkOrderId = sb.toString();
            ZaakpayPaymentAPI.this.date = CardUtils.getCurrentDate();
        }
    }

    private ZaakpayPaymentAPI(User user, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        this.currency = "INR";
        this.purpose = "0";
        this.purposeDescription = "Recharge";
        this.payOption = "3";
        this.txnType = "3";
        this.mode = "0";
        this.debitOrCredit = "netbanking";
        this.formValid = 0;
        this.buyerState = "Delhi";
        this.buyerPincode = "110075";
        this.buyerCity = "Delhi";
        this.buyerAddress = "Delhi";
        this.buyerCountry = "India";
        this.zpPostUrl = str5;
        this.checksumUrl = str7;
        this.merchantId = str8;
        this.buyerEmail = user.getEmail();
        this.buyerPhoneNumber = user.getCell();
        if (Utils.isNull(this.buyerPhoneNumber)) {
            this.buyerPhoneNumber = " ";
        }
        if (this.buyerEmail.contains("@")) {
            String str10 = this.buyerEmail;
            str9 = str10.substring(0, str10.indexOf("@"));
        } else {
            str9 = this.buyerEmail;
        }
        this.buyerFirstName = str9;
        this.buyerLastName = " ";
        this.ipAddress = CardUtils.getLocalIpAddress();
        this.amount = str;
        this.returnUrl = str6;
        this.buyerName = this.buyerFirstName;
        this.sdkMode = str3;
        this.merchantOrderId = str2;
        this.isWalletTxn = z;
        this.mobikwikMBKid = str4;
        System.out.println("ZaakpayPaymentAPI.ZaakpayPaymentAPI() ".concat(String.valueOf(str6)));
    }

    public ZaakpayPaymentAPI(Card card2, PaymentsMappingAPIResponse.PaymentsMapping.ZaakPayPublicKey zaakPayPublicKey, User user, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8) {
        this(user, str, str2, str3, z, str4, str5, str6, str7, str8);
        this.debitOrCredit = "credit";
        this.zaakpayKey = zaakPayPublicKey;
        this.card = card2;
        this.txnType = "1";
    }

    public ZaakpayPaymentAPI(String str, User user, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9) {
        this(user, str2, str3, str4, z, str5, str6, str7, str8, str9);
        this.bankid = str;
    }

    private void openURLNetBanking() {
        String str = this.isWalletTxn ? this.mkOrderId : this.merchantOrderId;
        String str2 = this.returnUrlCopy;
        this.callback.onSuccess(this.zpPostUrl, "buyerEmail=" + this.buyerEmail + "&amount=" + ((int) CommonUtils.performArithmeticCalculations(this.amount, "100", 3).doubleValue()) + "&buyerPhoneNumber=" + this.buyerPhoneNumber + "&merchantIpAddress=" + this.ipAddress + "&txnDate=" + this.date + "&currency=" + this.currency + "&merchantIdentifier=" + this.merchantId + "&buyerAddress=" + this.buyerAddress + "&buyerCountry=" + this.buyerCountry + "&buyerState=" + this.buyerState + "&buyerCity=" + this.buyerCity + "&buyerFirstName=" + this.buyerFirstName + "&buyerLastName=" + this.buyerLastName + "&buyerPincode=" + this.buyerPincode + "&zpPayOption=" + this.payOption + "&purpose=" + this.purpose + "&productDescription=" + this.purposeDescription + "&txnType=" + this.txnType + "&checksum=" + this.checksum + "&orderId=" + str + "&mode=" + this.mode + "&nameoncard=" + this.buyerName + "&debitorcredit=" + this.debitOrCredit + "&bankid=" + this.bankid + "&returnUrl=" + Utils.utf8Encode(str2), null);
    }

    private void openUrlCard() {
        String str;
        RSAEncUtils rSAEncUtils = new RSAEncUtils(this.zaakpayKey);
        String encrypt = rSAEncUtils.encrypt(this.card.getCardCVV());
        String str2 = this.isWalletTxn ? this.mkOrderId : this.merchantOrderId;
        String str3 = this.returnUrlCopy;
        String str4 = "buyerEmail=" + this.buyerEmail + "&amount=" + ((int) CommonUtils.performArithmeticCalculations(this.amount, "100", 3).doubleValue()) + "&buyerPhoneNumber=" + this.buyerPhoneNumber + "&merchantIpAddress=" + this.ipAddress + "&txnDate=" + this.date + "&currency=" + this.currency + "&merchantIdentifier=" + this.merchantId + "&buyerAddress=" + this.buyerAddress + "&buyerCountry=" + this.buyerCountry + "&buyerState=" + this.buyerState + "&buyerCity=" + this.buyerCity + "&buyerFirstName=" + this.buyerFirstName + "&buyerLastName=" + this.buyerLastName + "&buyerPincode=" + this.buyerPincode + "&zpPayOption=" + this.payOption + "&purpose=" + this.purpose + "&productDescription=" + this.purposeDescription + "&txnType=" + this.txnType + "&checksum=" + this.checksum + "&orderId=" + str2 + "&mode=" + this.mode + "&nameoncard=" + (Utils.isNull(this.card.getNameOnCard()) ? this.buyerName : this.card.getNameOnCard()) + "&debitorcredit=" + this.debitOrCredit;
        if (!this.card.isSavedCard()) {
            str = str4 + "&encrypted_pan=" + rSAEncUtils.encrypt(this.card.getCardNumber()) + "&card=" + CardUtils.detectType(this.card.getCardNumber()) + "&encrypted_expiry_month=" + rSAEncUtils.encrypt(this.card.getCardExpMonth()) + "&encrypted_expiry_year=" + rSAEncUtils.encrypt(this.card.getCardExpYear());
            if (this.card.isToStoreThisCard()) {
                str = str + "&saveCard=true";
            }
        } else {
            str = str4 + "&cardId=" + this.card.getCardId();
        }
        this.callback.onSuccess(this.zpPostUrl, (str + "&encryptionKeyId=" + this.zaakpayKey.keyId) + "&encryptedcvv=" + encrypt + "&showMobile=true&" + "returnUrl=" + Utils.utf8Encode(str3), null);
    }

    public void pay() {
        this.formValid = 0;
        if (this.card == null) {
            openURLNetBanking();
        } else {
            openUrlCard();
        }
    }

    public void sanitizeParams() {
        this.buyerEmail = ParamSanitizer.sanitizeParam(this.buyerEmail);
        this.amount = ParamSanitizer.sanitizeParam(this.amount);
        this.buyerPhoneNumber = ParamSanitizer.sanitizeParam(this.buyerPhoneNumber);
        this.ipAddress = ParamSanitizer.sanitizeParam(this.ipAddress);
        this.date = ParamSanitizer.sanitizeParam(this.date);
        this.merchantId = ParamSanitizer.sanitizeParam(this.merchantId);
        this.buyerAddress = ParamSanitizer.sanitizeParam(this.buyerAddress);
        this.buyerCountry = ParamSanitizer.sanitizeParam(this.buyerCountry);
        this.buyerState = ParamSanitizer.sanitizeParam(this.buyerState);
        this.buyerCity = ParamSanitizer.sanitizeParam(this.buyerCity);
        this.buyerFirstName = ParamSanitizer.sanitizeParam(this.buyerFirstName);
        this.buyerLastName = ParamSanitizer.sanitizeParam(this.buyerLastName);
        this.mkOrderId = ParamSanitizer.sanitizeParam(this.mkOrderId);
        this.buyerPincode = ParamSanitizer.sanitizeParam(this.buyerPincode);
        this.buyerName = ParamSanitizer.sanitizeParam(this.buyerName);
        this.merchantOrderId = ParamSanitizer.sanitizeParam(this.merchantOrderId);
        this.returnUrlCopy = this.returnUrl;
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

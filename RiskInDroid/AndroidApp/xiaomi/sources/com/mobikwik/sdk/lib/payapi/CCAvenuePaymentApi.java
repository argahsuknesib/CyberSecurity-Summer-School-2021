package com.mobikwik.sdk.lib.payapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import com.mobikwik.sdk.lib.Constants;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.payapi.PaymentAPI;
import com.mobikwik.sdk.lib.utils.Checksum;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.ParamSanitizer;
import com.mobikwik.sdk.lib.utils.Utils;
import java.util.Date;
import java.util.HashMap;

public class CCAvenuePaymentApi implements PaymentAPI {
    public Activity activity;
    public String amount;
    final int balanceIndex = 1;
    String bankid;
    private String buyerAddress = "Delhi";
    private String buyerCity = "Delhi";
    private String buyerCountry = "India";
    public String buyerEmail;
    private String buyerName;
    public String buyerPhoneNumber;
    private String buyerPincode = "110075";
    private String buyerState = "Delhi";
    private PaymentAPI.Callback callback;
    String ccavePostUrl;
    String checksum;
    public String checksumUrl;
    ProgressDialog dialog;
    int formValid = 0;
    public boolean isWalletTxn;
    private boolean mIsRunning = false;
    String merchantId;
    String merchantOrderId;
    final int messageIndex = 2;
    String mkOrderId;
    public String mobikwikMBKid;
    String payOption;
    String purposeDescription = "Mobikwik Mobile Recharge";
    public String returnUrl;
    private String returnUrlCopy;
    String sdkMode;
    final int statusIndex = 0;
    final int versionIndex = 3;

    class GetChecksumNew extends AsyncTask {
        private GetChecksumNew() {
        }

        private void returnFailure(String str) {
            Utils.sendResultBack(CCAvenuePaymentApi.this.activity, null, "1", str);
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            String str;
            String str2 = CCAvenuePaymentApi.this.buyerEmail;
            String str3 = CCAvenuePaymentApi.this.mobikwikMBKid;
            String str4 = CCAvenuePaymentApi.this.amount;
            CCAvenuePaymentApi.this.sanitizeParams();
            HashMap hashMap = new HashMap();
            hashMap.put("amount", CCAvenuePaymentApi.this.amount);
            if (CCAvenuePaymentApi.this.isWalletTxn) {
                hashMap.put("txId", CCAvenuePaymentApi.this.mkOrderId);
                hashMap.put("codeforrecord", "AndroidSDK");
                hashMap.put("userId", CCAvenuePaymentApi.this.buyerEmail);
                hashMap.put("gatewayId", "ccavenue");
                hashMap.put("cellNumber", CCAvenuePaymentApi.this.buyerPhoneNumber);
                hashMap.put("email", str2);
                hashMap.put("mid", str3);
                hashMap.put("orderid", CCAvenuePaymentApi.this.merchantOrderId);
                hashMap.put("txnAmount", str4);
                hashMap.put("isdesktoporwallet", "wallet");
                hashMap.put("Redirect_Url", CCAvenuePaymentApi.this.returnUrl);
                str = Constants.getServerUrl(CCAvenuePaymentApi.this.sdkMode) + "verifyMobilePaymentData.do";
            } else {
                hashMap.put("orderid", CCAvenuePaymentApi.this.merchantOrderId);
                hashMap.put("mid", CCAvenuePaymentApi.this.merchantId);
                hashMap.put("pgName", "CCavenue");
                hashMap.put("currency", "INR");
                hashMap.put("pgResponseUrl", CCAvenuePaymentApi.this.returnUrl);
                str = CCAvenuePaymentApi.this.checksumUrl;
            }
            return Network.getResponseOfPostRequest(str, hashMap);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (CCAvenuePaymentApi.this.dialog != null && CCAvenuePaymentApi.this.dialog.isShowing()) {
                CCAvenuePaymentApi.this.dialog.dismiss();
            }
            if (Network.validateNetworkResponse(str)) {
                Checksum parseChecksumResponse = Checksum.parseChecksumResponse(str);
                if (parseChecksumResponse == null) {
                    returnFailure("Checksum failure");
                } else if ("SUCCESS".equals(parseChecksumResponse.getStatus())) {
                    CCAvenuePaymentApi.this.checksum = parseChecksumResponse.getChecksum();
                    CCAvenuePaymentApi.this.pay();
                } else {
                    returnFailure(parseChecksumResponse.getChecksum());
                }
            } else {
                returnFailure(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            CCAvenuePaymentApi cCAvenuePaymentApi = CCAvenuePaymentApi.this;
            StringBuilder sb = new StringBuilder();
            sb.append(new Date().getTime());
            cCAvenuePaymentApi.mkOrderId = sb.toString();
        }
    }

    public CCAvenuePaymentApi(User user, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, String str10) {
        this.bankid = str3;
        this.ccavePostUrl = str7;
        this.merchantId = str10;
        this.buyerEmail = user.getEmail();
        this.buyerPhoneNumber = user.getCell();
        this.amount = str;
        this.returnUrl = str8;
        this.payOption = str4;
        this.sdkMode = str5;
        this.isWalletTxn = z;
        this.bankid = str3;
        String str11 = this.buyerEmail;
        this.buyerName = str11.substring(0, str11.indexOf("@"));
        this.merchantOrderId = str2;
        this.mobikwikMBKid = str6;
        this.checksumUrl = str9;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00d3  */
    private void openURL() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        String str3 = "billing_cust_email=" + this.buyerEmail + "&Amount=" + this.amount + "&billing_cust_tel=" + this.buyerPhoneNumber + "&billing_cust_address=" + this.buyerAddress + "&billing_cust_country=" + this.buyerCountry + "&billing_cust_state=" + this.buyerState + "&billing_cust_city=" + this.buyerCity + "&billing_zip_code=" + this.buyerPincode + "&cardOption=" + this.payOption + "&billing_cust_notes=" + this.purposeDescription + "&Checksum=" + this.checksum + "&billing_cust_name=" + this.buyerName;
        if (this.payOption.compareTo("netBanking") == 0) {
            sb2 = new StringBuilder();
            sb2.append(str3);
            str2 = "&netBankingCards=";
        } else if (this.payOption.compareTo("NonMoto") == 0) {
            sb2 = new StringBuilder();
            sb2.append(str3);
            str2 = "&NonMotoCardType=";
        } else {
            Log.e("CCAVENUEAPI", "neither netbanking nor nonmoto, something is wrong!");
            if (!this.isWalletTxn) {
                sb = new StringBuilder();
                sb.append(str3);
                sb.append("&Order_Id=");
                str = this.mkOrderId;
            } else {
                sb = new StringBuilder();
                sb.append(str3);
                sb.append("&Order_Id=");
                str = this.merchantOrderId;
            }
            sb.append(str);
            sb.append("&Merchant_Id=");
            sb.append(this.merchantId);
            sb.append("&Redirect_Url=");
            sb.append(this.returnUrlCopy);
            this.callback.onSuccess(this.ccavePostUrl, sb.toString(), null);
        }
        sb2.append(str2);
        sb2.append(this.bankid);
        str3 = sb2.toString();
        if (!this.isWalletTxn) {
        }
        sb.append(str);
        sb.append("&Merchant_Id=");
        sb.append(this.merchantId);
        sb.append("&Redirect_Url=");
        sb.append(this.returnUrlCopy);
        this.callback.onSuccess(this.ccavePostUrl, sb.toString(), null);
    }

    public void pay() {
        this.formValid = 0;
        openURL();
    }

    public void sanitizeParams() {
        this.buyerEmail = ParamSanitizer.sanitizeParam(this.buyerEmail);
        this.amount = ParamSanitizer.sanitizeParam(this.amount);
        this.buyerPhoneNumber = ParamSanitizer.sanitizeParam(this.buyerPhoneNumber);
        this.merchantId = ParamSanitizer.sanitizeParam(this.merchantId);
        this.buyerAddress = ParamSanitizer.sanitizeParam(this.buyerAddress);
        this.buyerCountry = ParamSanitizer.sanitizeParam(this.buyerCountry);
        this.buyerState = ParamSanitizer.sanitizeParam(this.buyerState);
        this.buyerCity = ParamSanitizer.sanitizeParam(this.buyerCity);
        this.mkOrderId = ParamSanitizer.sanitizeParam(this.mkOrderId);
        this.buyerPincode = ParamSanitizer.sanitizeParam(this.buyerPincode);
        this.payOption = ParamSanitizer.sanitizeParam(this.payOption);
        this.purposeDescription = ParamSanitizer.sanitizeParam(this.purposeDescription);
        this.buyerName = ParamSanitizer.sanitizeParam(this.buyerName);
        this.returnUrlCopy = ParamSanitizer.SanitizeURLParam(this.returnUrl);
    }

    public void startAPI(PaymentAPI.Callback callback2, Activity activity2) {
        this.callback = callback2;
        this.activity = activity2;
        if (Network.isConnected(activity2)) {
            new GetChecksumNew().execute(new String[0]);
            this.dialog = ProgressDialog.show(activity2, "", "Processing your payment request...", true);
            this.dialog.show();
            return;
        }
        callback2.onError(SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
    }

    public void updateUser(User user) {
        if (user.getEmail() != null) {
            this.buyerEmail = user.getEmail();
        }
        if (user.getCell() != null) {
            this.buyerPhoneNumber = user.getCell();
        }
    }
}

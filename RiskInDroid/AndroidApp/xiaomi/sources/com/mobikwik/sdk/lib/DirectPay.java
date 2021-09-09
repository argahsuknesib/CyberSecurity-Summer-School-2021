package com.mobikwik.sdk.lib;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import com.google.gson.Gson;
import com.mobikwik.sdk.MobikwikSDK;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.payapi.PaymentAPI;
import com.mobikwik.sdk.lib.payapi.ZaakpayPaymentAPI;
import com.mobikwik.sdk.lib.payinstrument.Bank;
import com.mobikwik.sdk.lib.payinstrument.Card;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import com.mobikwik.sdk.lib.tasks.LoadPaymentsMapping;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.PaymentOptionsDecoder;
import com.mobikwik.sdk.lib.utils.Utils;
import java.util.ArrayList;

public class DirectPay {
    MobikwikSDK act;
    public String amount;
    public Bank bank;
    private String buyerEmail;
    private String buyerFirstName;
    private String buyerLastName = " ";
    private String buyerPhoneNumber = " ";
    public CallBack callback;
    public Card card;
    TransactionConfiguration configuration;
    ProgressDialog dialog;
    private Handler handler;
    private boolean isFirstResume;
    public PaymentsMappingAPIResponse mapping;
    protected ProgressDialog progressDialog;
    Transaction txn;

    public interface CallBack {
        void onFailure(String str, String str2);

        void onSuccess(PaymentAPI paymentAPI);
    }

    public DirectPay(MobikwikSDK mobikwikSDK, Transaction transaction, TransactionConfiguration transactionConfiguration, CallBack callBack) {
        this.act = mobikwikSDK;
        this.txn = transaction;
        this.configuration = transactionConfiguration;
        this.handler = new Handler();
        this.callback = callBack;
        Utils.print("DirectPay: Constractor");
        this.isFirstResume = true;
    }

    private void startPayProcess() {
        this.amount = this.txn.getAmount();
        final String mode = this.configuration.getMode();
        this.buyerEmail = this.txn.getUser().getEmail();
        this.buyerPhoneNumber = this.txn.getUser().getCell();
        if (this.buyerEmail.contains("@")) {
            String str = this.buyerEmail;
            this.buyerFirstName = str.substring(0, str.indexOf("@"));
        }
        AnonymousClass1 r1 = new AsyncTask() {
            /* class com.mobikwik.sdk.lib.DirectPay.AnonymousClass1 */
            ZaakpayPaymentAPI paymentAPI = null;

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                ZaakpayPaymentAPI zaakpayPaymentAPI;
                DirectPay directPay;
                String errorCode;
                String str;
                if (DirectPay.this.mapping == null) {
                    boolean paymentMapping = DirectPay.this.getPaymentMapping();
                    Utils.print("DirectPay: doInBackground paymentMapping = ".concat(String.valueOf(paymentMapping)));
                    if (!paymentMapping) {
                        return null;
                    }
                }
                String zaakpayMerchantIdForAmount = PaymentOptionsDecoder.getZaakpayMerchantIdForAmount(DirectPay.this.amount, false, DirectPay.this.mapping.getData().getBankMappingMerchant());
                if (DirectPay.this.card != null) {
                    PaymentsMappingAPIResponse.PaymentsMapping.ZaakPayPublicKey zaakpayKeyForMerchantId = PaymentOptionsDecoder.getZaakpayKeyForMerchantId(zaakpayMerchantIdForAmount, DirectPay.this.mapping.getData().getBankMappingMerchant());
                    if (zaakpayKeyForMerchantId == null) {
                        directPay = DirectPay.this;
                        errorCode = SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode();
                        str = SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription();
                    } else {
                        zaakpayPaymentAPI = new ZaakpayPaymentAPI(DirectPay.this.card, zaakpayKeyForMerchantId, DirectPay.this.txn.getUser(), DirectPay.this.amount, DirectPay.this.txn.getOrderId(), mode, false, DirectPay.this.configuration.getMbkId(), PaymentOptionsDecoder.getPGUrlForPaymentOption(DirectPay.this.mapping.getData().getBankMappingMerchant(), DirectPay.this.mapping.getData().getBankMappingMerchant().getCreditCardMappings(), 1), DirectPay.this.configuration.getPgResponseUrl(), DirectPay.this.configuration.getChecksumUrl(), zaakpayMerchantIdForAmount);
                        this.paymentAPI = zaakpayPaymentAPI;
                        return null;
                    }
                } else {
                    int indexForBank = PaymentOptionsDecoder.getIndexForBank(DirectPay.this.mapping.getData().getBankMappingMerchant().getNetBankingMappings(), DirectPay.this.bank.getBankCode());
                    if (indexForBank == -1) {
                        directPay = DirectPay.this;
                        errorCode = SDKErrorCodes.FAILURE.getErrorCode();
                        str = "Invalid bank code";
                    } else {
                        Utils.print("Direct Pay : bankPositionForBankId " + DirectPay.this.bank.getBankCode() + " " + indexForBank);
                        zaakpayPaymentAPI = new ZaakpayPaymentAPI(DirectPay.this.bank.getBankCode(), DirectPay.this.txn.getUser(), DirectPay.this.amount, DirectPay.this.txn.getOrderId(), mode, false, DirectPay.this.configuration.getMbkId(), PaymentOptionsDecoder.getPGUrlForPaymentOption(DirectPay.this.mapping.getData().getBankMappingMerchant(), DirectPay.this.mapping.getData().getBankMappingMerchant().getNetBankingMappings(), indexForBank), DirectPay.this.configuration.getPgResponseUrl(), DirectPay.this.configuration.getChecksumUrl(), zaakpayMerchantIdForAmount);
                        this.paymentAPI = zaakpayPaymentAPI;
                        return null;
                    }
                }
                directPay.returnToMerchantApp(errorCode, str);
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void voidR) {
                if (DirectPay.this.progressDialog != null && DirectPay.this.progressDialog.isShowing()) {
                    DirectPay.this.progressDialog.dismiss();
                }
                if (this.paymentAPI == null) {
                    DirectPay.this.callback.onFailure(SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                } else {
                    DirectPay.this.callback.onSuccess(this.paymentAPI);
                }
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
            }
        };
        if (Network.isConnected(this.act)) {
            r1.execute(new Void[0]);
        }
    }

    /* access modifiers changed from: protected */
    public boolean getPaymentMapping() {
        String errorCode;
        SDKErrorCodes sDKErrorCodes;
        String loadMappingSync = LoadPaymentsMapping.loadMappingSync(this.configuration.getMbkId(), Integer.parseInt(this.configuration.getMode()), this.act);
        if (Utils.isNull(loadMappingSync)) {
            errorCode = SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode();
            sDKErrorCodes = SDKErrorCodes.INTERNET_NOT_WORKING;
        } else {
            try {
                PaymentsMappingAPIResponse paymentsMappingAPIResponse = (PaymentsMappingAPIResponse) new Gson().fromJson(loadMappingSync, PaymentsMappingAPIResponse.class);
                if (!paymentsMappingAPIResponse.failure) {
                    ArrayList enabledOptions = paymentsMappingAPIResponse.getData().getEnabledOptions();
                    if ((this.card != null && (enabledOptions.contains(PaymentInstrumentType.CREDIT_CARD) || enabledOptions.contains(PaymentInstrumentType.DEBIT_CARD))) || (this.bank != null && enabledOptions.contains(PaymentInstrumentType.NETBANKING))) {
                        this.mapping = paymentsMappingAPIResponse;
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            errorCode = SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode();
            sDKErrorCodes = SDKErrorCodes.UNEXPECTED_ERROR;
        }
        returnToMerchantApp(errorCode, sDKErrorCodes.getErrorDescription());
        return false;
    }

    public void returnToMerchantApp(final String str, final String str2) {
        this.handler.post(new Runnable() {
            /* class com.mobikwik.sdk.lib.DirectPay.AnonymousClass2 */

            public void run() {
                if (DirectPay.this.progressDialog != null && DirectPay.this.progressDialog.isShowing()) {
                    DirectPay.this.progressDialog.dismiss();
                }
                DirectPay.this.callback.onFailure(str, str2);
            }
        });
    }

    public void start() {
        String str;
        if (this.isFirstResume) {
            this.progressDialog = ProgressDialog.show(this.act, "", "Processing...", true);
            this.isFirstResume = false;
            if (this.txn.getPayInstrument() instanceof Card) {
                this.card = (Card) this.txn.getPayInstrument();
                if (!this.card.isValid()) {
                    str = "Invalid Card details";
                }
                startPayProcess();
                return;
            } else if (this.txn.getPayInstrument() instanceof Bank) {
                this.bank = (Bank) this.txn.getPayInstrument();
                if (!this.bank.isValid()) {
                    str = "Invalid Bank details";
                }
                startPayProcess();
                return;
            } else {
                str = "Incomplete Details";
            }
            returnToMerchantApp("1", str);
        }
    }
}

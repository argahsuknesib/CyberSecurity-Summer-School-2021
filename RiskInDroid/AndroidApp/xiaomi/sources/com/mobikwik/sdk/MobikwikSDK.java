package com.mobikwik.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.mobikwik.sdk.lib.DirectPay;
import com.mobikwik.sdk.lib.MKTransactionResponse;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.payapi.PaymentAPI;
import com.mobikwik.sdk.lib.tasks.LoadPaymentsMapping;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletAPIs;
import com.mobikwik.sdk.ui.data.b;
import java.util.ArrayList;

public class MobikwikSDK extends Activity implements DirectPay.CallBack {

    /* renamed from: a  reason: collision with root package name */
    private DirectPay f5274a;
    /* access modifiers changed from: private */
    public ProgressDialog b;

    /* access modifiers changed from: private */
    public void a(ArrayList arrayList, SavedCardResponse.CardDetails[] cardDetailsArr) {
        b b2 = b.b(this);
        b2.a(arrayList);
        b2.b(cardDetailsArr);
        startActivityForResult(new Intent(this, PaymentOptions.class), 0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    public void a(Intent intent, String str, String str2) {
        b b2;
        Transaction d;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        if (intent2 != null) {
            intent3 = new Intent(intent2);
        }
        if (Utils.isNull(intent3.getStringExtra("statuscode"))) {
            if (Utils.isNull(str)) {
                intent3.putExtra("statuscode", "1");
            } else {
                intent3.putExtra("statuscode", str);
                if (Utils.isNull(intent3.getStringExtra("statusmessage"))) {
                    intent3.putExtra("statusmessage", Utils.isNull(str) ? "Something went bad" : str2);
                }
                b2 = b.b(this);
                d = b2.d();
                MKTransactionResponse mKTransactionResponse = new MKTransactionResponse();
                if (d != null) {
                    mKTransactionResponse.amount = d.getAmount();
                    mKTransactionResponse.orderId = d.getOrderId();
                }
                mKTransactionResponse.statusCode = intent3.getStringExtra("statuscode");
                mKTransactionResponse.statusMessage = intent3.getStringExtra("statusmessage");
                if (b2.j() && SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorCode().equals(mKTransactionResponse.statusCode)) {
                    WalletAPIs.getInstance("1".equals(b2.f().getMode()), this).cancelTxn(d.getUser().getEmail(), d.getUser().getCell(), d.getOrderId(), d.getAmount(), b2.f().getMbkId(), b2.i(), b2.f().getPgResponseUrl(), b2.f().getMerchantName(), null);
                }
                Intent intent4 = new Intent();
                intent4.putExtra("MK_EXT_TXN_RESP", mKTransactionResponse);
                setResult(1, intent4);
                finish();
            }
        }
        if (Utils.isNull(intent3.getStringExtra("statusmessage"))) {
        }
        b2 = b.b(this);
        d = b2.d();
        MKTransactionResponse mKTransactionResponse2 = new MKTransactionResponse();
        if (d != null) {
        }
        mKTransactionResponse2.statusCode = intent3.getStringExtra("statuscode");
        mKTransactionResponse2.statusMessage = intent3.getStringExtra("statusmessage");
        WalletAPIs.getInstance("1".equals(b2.f().getMode()), this).cancelTxn(d.getUser().getEmail(), d.getUser().getCell(), d.getOrderId(), d.getAmount(), b2.f().getMbkId(), b2.i(), b2.f().getPgResponseUrl(), b2.f().getMerchantName(), null);
        Intent intent42 = new Intent();
        intent42.putExtra("MK_EXT_TXN_RESP", mKTransactionResponse2);
        setResult(1, intent42);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && i2 == 1) {
            a(intent, (String) null, (String) null);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0084, code lost:
        if ((r2.getAmount().length() - r1) > 3) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099  */
    @SuppressLint({"InlinedApi"})
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle == null) {
            Transaction transaction = (Transaction) getIntent().getSerializableExtra("MK_EXT_TXN");
            if (transaction == null) {
                a((Intent) null, "1", "Invalid Request");
                return;
            } else if (!Network.isConnected(this)) {
                a((Intent) null, SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
                return;
            } else {
                TransactionConfiguration transactionConfiguration = (TransactionConfiguration) getIntent().getSerializableExtra("MK_EXT_TXN_CONFIG");
                b a2 = b.a(this);
                if (transactionConfiguration == null || !transactionConfiguration.isConfigValid()) {
                    a((Intent) null, SDKErrorCodes.FAILURE.getErrorCode(), "Invalid Configuration");
                    return;
                }
                a2.a(transactionConfiguration);
                a2.a(transaction);
                if (transaction.getPayInstrument() == null) {
                    try {
                        z = Double.parseDouble(transaction.getAmount()) <= 0.0d;
                        int indexOf = transaction.getAmount().indexOf(".");
                        if (indexOf != -1) {
                        }
                    } catch (Exception unused) {
                    }
                    if (!z) {
                        a((Intent) null, SDKErrorCodes.INVALID_AMOUNT.getErrorCode(), SDKErrorCodes.INVALID_AMOUNT.getErrorDescription());
                        return;
                    }
                    LoadPaymentsMapping loadPaymentsMapping = new LoadPaymentsMapping(this, transactionConfiguration.getMbkId(), Integer.parseInt(transactionConfiguration.getMode()), new a(this, transaction, new ArrayList(), a2, transactionConfiguration));
                    this.b = ProgressDialog.show(this, null, "Processing...", true);
                    loadPaymentsMapping.execute(new Void[0]);
                    return;
                }
                this.f5274a = new DirectPay(this, transaction, transactionConfiguration, this);
                this.f5274a.start();
                return;
            }
        } else {
            return;
        }
        z = true;
        if (!z) {
        }
    }

    public void onFailure(String str, String str2) {
        a((Intent) null, str, str2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onSuccess(PaymentAPI paymentAPI) {
        b b2 = b.b(this);
        Transaction d = b2.d();
        Intent intent = new Intent();
        intent.setClass(this, PGWebView.class);
        intent.putExtra("KEY_API", paymentAPI);
        intent.putExtra("KEY_IS_WALLET", false);
        intent.putExtra("KEY_PG_AMOUNT", d.getAmount());
        intent.putExtra("KEY_RESPONSE_URL", b2.f().getPgResponseUrl());
        startActivityForResult(intent, 0);
    }
}

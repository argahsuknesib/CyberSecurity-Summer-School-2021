package com.xiaomi.smarthome.nfctag.ui;

import _m_j.ezu;
import _m_j.ftn;
import _m_j.hif;
import _m_j.hig;
import _m_j.hih;
import _m_j.hiv;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import butterknife.ButterKnife;
import com.xiaomi.idm.tap.dispatcher.impl.NfcV1ActionDispatcher;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class NFCReadActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    NfcAdapter f10453O000000o;
    PendingIntent O00000Oo;
    long O00000o;
    NfcV1ActionDispatcher O00000o0;
    private IntentFilter[] O00000oO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ftn.O00000oO(this)) {
            finish();
            return;
        }
        if (ezu.O000000o()) {
            hif.O000000o();
        }
        setContentView((int) R.layout.activity_nfc_read);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        this.O00000o = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("click_time", -1);
        hih.O000000o("smarthome-nfc", "click " + longExtra + " , " + (this.O00000o - longExtra));
        StringBuilder sb = new StringBuilder("onCreate ");
        sb.append(this.O00000o);
        hih.O000000o("smarthome-nfc", sb.toString());
        if (this.f10453O000000o == null) {
            this.f10453O000000o = NfcAdapter.getDefaultAdapter(this);
        }
        NfcAdapter nfcAdapter = this.f10453O000000o;
        if (nfcAdapter == null) {
            hih.O000000o("smarthome-nfc", "nfcAdapter == null ");
            finish();
        } else if (!nfcAdapter.isEnabled()) {
            hih.O000000o("smarthome-nfc", "nfcAdapter is not enable ");
            finish();
        } else {
            this.O00000Oo = PendingIntent.getActivity(this, 0, new Intent(this, NFCReadActivity.class), 0);
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            this.O00000oO = new IntentFilter[]{intentFilter};
            this.O00000o0 = new NfcV1ActionDispatcher(this);
            this.O00000o0.setExecutorFactory(new hiv());
            O000000o(getIntent());
        }
    }

    public void onResume() {
        super.onResume();
        NfcAdapter nfcAdapter = this.f10453O000000o;
        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            this.f10453O000000o.enableForegroundDispatch(this, this.O00000Oo, this.O00000oO, null);
        }
    }

    public void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = this.f10453O000000o;
        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            this.f10453O000000o.disableForegroundDispatch(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if ("android.nfc.action.TAG_DISCOVERED".equals(intent.getAction())) {
            O000000o(intent);
        }
    }

    private void O000000o(Intent intent) {
        if (!hig.O00000oo()) {
            finish();
            return;
        }
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (parcelableArrayExtra != null) {
            for (Parcelable parcelable : parcelableArrayExtra) {
                this.O00000o0.dispatchRawData(((NdefMessage) parcelable).getRecords()[0].getPayload(), null);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        hih.O000000o("smarthome-nfc", "readover: " + currentTimeMillis + " , " + (currentTimeMillis - this.O00000o));
        finish();
    }
}

package com.xiaomi.qrcode;

import _m_j.esz;
import _m_j.eta;
import _m_j.eth;
import _m_j.eyk;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.smarthome.R;

@SuppressLint({"InvalidR2Usage"})
public final class CaptureActivityHandler extends Handler implements eth {
    private static final String O00000o0 = "CaptureActivityHandler";

    /* renamed from: O000000o  reason: collision with root package name */
    final eta f6583O000000o = new eta(this);
    public State O00000Oo;
    private final ScanBarcodeActivity O00000o;

    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public final void O000000o(byte[] bArr, int i, int i2, RectF rectF) {
        Handler O000000o2 = this.f6583O000000o.O000000o();
        if (O000000o2 != null && !O000000o2.hasMessages(R.id.decode)) {
            O000000o2.obtainMessage(R.id.decode, i, i2, new esz.O000000o(bArr, rectF)).sendToTarget();
        }
    }

    CaptureActivityHandler(ScanBarcodeActivity scanBarcodeActivity) {
        this.O00000o = scanBarcodeActivity;
        this.f6583O000000o.start();
        this.O00000Oo = State.PREVIEW;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == R.id.decode_succeeded) {
            this.O00000Oo = State.SUCCESS;
            this.O00000o.handleDecode((String) message.obj, null, 1.0f);
        } else if (i == R.id.restart_preview || i == R.id.decode_next || i == R.id.decode_failed) {
            this.O00000Oo = State.PREVIEW;
        } else if (i == R.id.return_scan_result) {
            this.O00000o.setResult(-1, (Intent) message.obj);
            this.O00000o.finish();
        } else if (i == R.id.launch_product_query) {
            eyk.O000000o(this.O00000o, (String) message.obj);
        }
    }
}

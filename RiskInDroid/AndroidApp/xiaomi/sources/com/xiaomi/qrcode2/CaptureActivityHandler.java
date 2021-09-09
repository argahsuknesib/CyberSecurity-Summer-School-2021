package com.xiaomi.qrcode2;

import _m_j.etl;
import _m_j.etq;
import _m_j.idf;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.xiaomi.qrcode2.camera.CameraManager;
import com.xiaomi.zxing.BarcodeFormat;
import java.util.Collection;

public final class CaptureActivityHandler extends Handler {
    private static final String O00000o = "CaptureActivityHandler";

    /* renamed from: O000000o  reason: collision with root package name */
    final etl f6600O000000o;
    State O00000Oo = State.SUCCESS;
    final CameraManager O00000o0;
    private final ScanBarcodeActivity O00000oO;

    enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    CaptureActivityHandler(ScanBarcodeActivity scanBarcodeActivity, Collection<BarcodeFormat> collection, CameraManager cameraManager) {
        this.O00000oO = scanBarcodeActivity;
        this.f6600O000000o = new etl(scanBarcodeActivity, collection, null, null, new etq(scanBarcodeActivity.O00000Oo));
        this.f6600O000000o.start();
        this.O00000o0 = cameraManager;
        cameraManager.O00000o0();
        O000000o();
    }

    public final void handleMessage(Message message) {
        String str = null;
        switch (message.what) {
            case 6:
                this.O00000Oo = State.PREVIEW;
                this.O00000o0.O000000o(this.f6600O000000o.O000000o());
                return;
            case 7:
                this.O00000Oo = State.SUCCESS;
                this.O00000oO.handleDecode((idf) message.obj, null, 1.0f);
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                String str2 = (String) message.obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(524288);
                intent.setData(Uri.parse(str2));
                ResolveInfo resolveActivity = this.O00000oO.getPackageManager().resolveActivity(intent, 65536);
                if (!(resolveActivity == null || resolveActivity.activityInfo == null)) {
                    str = resolveActivity.activityInfo.packageName;
                    Log.d(O00000o, "Using browser in package ".concat(String.valueOf(str)));
                }
                if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                    intent.setPackage(str);
                    intent.addFlags(268435456);
                    intent.putExtra("com.android.browser.application_id", str);
                }
                try {
                    this.O00000oO.startActivity(intent);
                    return;
                } catch (ActivityNotFoundException unused) {
                    Log.w(O00000o, "Can't find anything to handle VIEW of URI ".concat(String.valueOf(str2)));
                    return;
                }
            case 9:
            default:
                return;
            case 10:
                O000000o();
                return;
            case 11:
                this.O00000oO.setResult(-1, (Intent) message.obj);
                this.O00000oO.finish();
                return;
        }
    }

    private void O000000o() {
        if (this.O00000Oo == State.SUCCESS) {
            this.O00000Oo = State.PREVIEW;
            this.O00000o0.O000000o(this.f6600O000000o.O000000o());
            this.O00000oO.drawViewfinder();
        }
    }
}

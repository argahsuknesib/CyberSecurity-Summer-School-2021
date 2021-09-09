package _m_j;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

public final class etu implements Camera.PreviewCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15808O000000o = "etu";
    private final ets O00000Oo;
    private int O00000o;
    private Handler O00000o0;

    public etu(ets ets) {
        this.O00000Oo = ets;
    }

    public final void O000000o(Handler handler, int i) {
        this.O00000o0 = handler;
        this.O00000o = i;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Point point = this.O00000Oo.O00000oO;
        Handler handler = this.O00000o0;
        if (point == null || handler == null) {
            Log.d(f15808O000000o, "Got preview callback, but no handler or resolution available");
            return;
        }
        handler.obtainMessage(this.O00000o, point.x, point.y, bArr).sendToTarget();
        this.O00000o0 = null;
    }
}

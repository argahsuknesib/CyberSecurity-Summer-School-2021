package no.nordicsemi.android.dfu;

import _m_j.ft;
import android.content.Context;
import android.content.Intent;

public class DfuServiceController implements DfuController {
    private boolean mAborted;
    private ft mBroadcastManager;
    private boolean mPaused;

    DfuServiceController(Context context) {
        this.mBroadcastManager = ft.O000000o(context);
    }

    public void pause() {
        if (!this.mAborted && !this.mPaused) {
            this.mPaused = true;
            Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 0);
            this.mBroadcastManager.O000000o(intent);
        }
    }

    public void resume() {
        if (!this.mAborted && this.mPaused) {
            this.mPaused = false;
            Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 1);
            this.mBroadcastManager.O000000o(intent);
        }
    }

    public void abort() {
        if (!this.mAborted) {
            this.mAborted = true;
            this.mPaused = false;
            Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 2);
            this.mBroadcastManager.O000000o(intent);
        }
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public boolean isAborted() {
        return this.mAborted;
    }
}

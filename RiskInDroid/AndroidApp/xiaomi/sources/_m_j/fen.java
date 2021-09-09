package _m_j;

import android.os.AsyncTask;
import java.util.UUID;
import miui.bluetooth.ble.MiBleDeviceManager;

public final class fen implements MiBleDeviceManager.MiBleDeviceManagerListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public MiBleDeviceManager f16184O000000o;
    public int O00000Oo;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static fen f16186O000000o = new fen((byte) 0);
    }

    /* synthetic */ fen(byte b) {
        this();
    }

    private fen() {
        gor.O000000o(new AsyncTask<Void, Void, Void>() {
            /* class _m_j.fen.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                try {
                    MiBleDeviceManager.createManager(glc.O0000O0o, fen.this);
                } catch (Throwable th) {
                    gnk.O00000Oo(gnk.O00000Oo(th));
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                UUID.randomUUID();
                return null;
            }
        }, new Void[0]);
    }

    public static fen O000000o() {
        return O000000o.f16186O000000o;
    }

    public final void onInit(MiBleDeviceManager miBleDeviceManager) {
        if (miBleDeviceManager != null) {
            this.f16184O000000o = miBleDeviceManager;
            try {
                this.O00000Oo = this.f16184O000000o.getServiceVersion();
            } catch (Throwable th) {
                gnk.O00000Oo(gnk.O00000Oo(th));
            }
        }
    }

    public final boolean O000000o(String str) {
        boolean z;
        MiBleDeviceManager miBleDeviceManager = this.f16184O000000o;
        if (miBleDeviceManager != null) {
            try {
                z = miBleDeviceManager.unbindDevice(str);
            } catch (Throwable th) {
                gnk.O00000Oo(gnk.O00000Oo(th));
            }
            gnk.O00000oO(String.format("unbindDevice %s return %b", str, Boolean.valueOf(z)));
            return z;
        }
        z = false;
        gnk.O00000oO(String.format("unbindDevice %s return %b", str, Boolean.valueOf(z)));
        return z;
    }

    public final void onDestroy() {
        this.f16184O000000o = null;
    }

    public final boolean O000000o(String str, byte[] bArr) {
        boolean z;
        if (this.f16184O000000o != null && this.O00000Oo >= 13) {
            try {
                z = this.f16184O000000o.bindDevice(str, bArr);
            } catch (Throwable th) {
                gnk.O00000Oo(gnk.O00000Oo(th));
            }
            gnk.O00000oO(String.format("bindDevice %s return %b", str, Boolean.valueOf(z)));
            return z;
        }
        z = false;
        gnk.O00000oO(String.format("bindDevice %s return %b", str, Boolean.valueOf(z)));
        return z;
    }
}

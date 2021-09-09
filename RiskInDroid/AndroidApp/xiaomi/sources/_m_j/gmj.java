package _m_j;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectDispatcher;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectWorker;
import com.xiaomi.smarthome.library.bluetooth.connect.RuntimeChecker;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.GattResponseListener;
import com.xiaomi.smarthome.library.bluetooth.connect.request.IBleRequest;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.util.UUID;

public abstract class gmj implements Handler.Callback, IBleConnectWorker, RuntimeChecker, GattResponseListener, IBleRequest {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final boolean f18015O000000o = (!glc.O0000OOo);
    private boolean O00000Oo;
    protected UUID O00000o;
    protected UUID O00000oO;
    protected byte[] O00000oo;
    protected gma O0000O0o;
    protected Bundle O0000OOo = new Bundle();
    protected IBleConnectDispatcher O0000Oo;
    protected String O0000Oo0;
    protected IBleConnectWorker O0000OoO;
    protected Handler O0000Ooo = new Handler(Looper.myLooper(), this);
    public RuntimeChecker O0000o0;
    protected Handler O0000o00 = new Handler(Looper.getMainLooper());
    protected boolean O0000o0O;

    public abstract void O000000o();

    public gmj(gma gma) {
        this.O0000O0o = gma;
    }

    public final void O000000o(String str) {
        this.O0000Oo0 = str;
    }

    public final void O000000o(IBleConnectWorker iBleConnectWorker) {
        this.O0000OoO = iBleConnectWorker;
    }

    public final void O000000o(final int i) {
        if (!this.O00000Oo) {
            this.O00000Oo = true;
            this.O0000o00.post(new Runnable() {
                /* class _m_j.gmj.AnonymousClass1 */

                public final void run() {
                    try {
                        if (gmj.this.O0000O0o != null) {
                            gmj.this.O0000O0o.onResponse(i, gmj.this.O0000OOo);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void O000000o(String str, int i) {
        this.O0000OOo.putInt(str, i);
    }

    public final void O000000o(String str, byte[] bArr) {
        this.O0000OOo.putByteArray(str, bArr);
    }

    public final void O000000o(String str, Parcelable parcelable) {
        this.O0000OOo.putParcelable(str, parcelable);
    }

    public boolean openGatt() {
        return this.O0000OoO.openGatt();
    }

    public boolean discoverService() {
        return this.O0000OoO.discoverService();
    }

    public int getCurrentStatus() {
        return this.O0000OoO.getCurrentStatus();
    }

    public final void process(IBleConnectDispatcher iBleConnectDispatcher) {
        checkRuntime();
        this.O0000Oo = iBleConnectDispatcher;
        if (f18015O000000o) {
            gnk.O00000oO(String.format("Process %s, status = %s", getClass().getSimpleName(), gld.O000000o(getCurrentStatus())));
        }
        if (!gnl.O000000o()) {
            O00000Oo(-4);
        } else if (!gnl.O00000Oo()) {
            O00000Oo(-5);
        } else {
            try {
                registerGattResponseListener(this);
                O000000o();
            } catch (Throwable th) {
                gnk.O00000Oo(gnk.O00000Oo(th));
                O00000Oo(-15);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i) {
        if (f18015O000000o) {
            O00000Oo(String.format("request complete: code = %d", Integer.valueOf(i)));
        }
        this.O0000Ooo.removeCallbacksAndMessages(null);
        clearGattResponseListener(this);
        O000000o(i);
        this.O0000Oo.onRequestCompleted(this);
    }

    public void closeGatt() {
        if (f18015O000000o) {
            O00000Oo(String.format("close gatt", new Object[0]));
        }
        this.O0000OoO.closeGatt();
    }

    public boolean handleMessage(Message message) {
        if (message.what == 32) {
            this.O0000o0O = true;
            closeGatt();
        }
        return true;
    }

    public void registerGattResponseListener(GattResponseListener gattResponseListener) {
        this.O0000OoO.registerGattResponseListener(gattResponseListener);
    }

    public void clearGattResponseListener(GattResponseListener gattResponseListener) {
        this.O0000OoO.clearGattResponseListener(gattResponseListener);
    }

    public boolean refreshDeviceCache() {
        return this.O0000OoO.refreshDeviceCache();
    }

    public boolean readCharacteristic(UUID uuid, UUID uuid2) {
        return this.O0000OoO.readCharacteristic(uuid, uuid2);
    }

    public boolean writeCharacteristic(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.O0000OoO.writeCharacteristic(uuid, uuid2, bArr);
    }

    public boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.O0000OoO.writeCharacteristicWithNoRsp(uuid, uuid2, bArr);
    }

    public boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z) {
        return this.O0000OoO.setCharacteristicNotification(uuid, uuid2, z);
    }

    public boolean setCharacteristicIndication(UUID uuid, UUID uuid2, boolean z) {
        return this.O0000OoO.setCharacteristicIndication(uuid, uuid2, z);
    }

    public boolean readRemoteRssi() {
        return this.O0000OoO.readRemoteRssi();
    }

    public boolean requestConnectionPriority(int i) {
        return this.O0000OoO.requestConnectionPriority(i);
    }

    public boolean requestMtu(int i) {
        return this.O0000OoO.requestMtu(i);
    }

    public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        this.O0000OoO.isCharacterExist(uuid, uuid2, bleResponse);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        gnk.O00000o0(String.format("%s %s >>> %s", getClass().getSimpleName(), this.O0000Oo0, str));
    }

    public void checkRuntime() {
        this.O0000o0.checkRuntime();
    }

    public void cancel() {
        checkRuntime();
        if (f18015O000000o) {
            O00000Oo(String.format("request canceled", new Object[0]));
        }
        this.O0000Ooo.removeCallbacksAndMessages(null);
        clearGattResponseListener(this);
        O000000o(-2);
    }

    public boolean onConnectStatusChanged(boolean z) {
        if (z) {
            return true;
        }
        O00000Oo(this.O0000o0O ? -7 : -1);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        this.O0000Ooo.sendEmptyMessageDelayed(32, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        this.O0000Ooo.removeMessages(32);
    }

    public BleGattProfile getGattProfile() {
        return this.O0000OoO.getGattProfile();
    }
}

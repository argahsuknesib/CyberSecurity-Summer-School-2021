package _m_j;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.inuker.bluetooth.library.model.BleGattProfile;
import java.util.UUID;

public abstract class bjl implements bim, bit, biw, Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    protected bjr f13012O000000o;
    protected Bundle O00000Oo = new Bundle();
    protected bir O00000o;
    protected String O00000o0;
    protected bit O00000oO;
    protected Handler O00000oo = new Handler(Looper.myLooper(), this);
    protected Handler O0000O0o = new Handler(Looper.getMainLooper());
    public bim O0000OOo;
    private boolean O0000Oo;
    protected boolean O0000Oo0;

    public abstract void O0000Oo0();

    public bjl(bjr bjr) {
        this.f13012O000000o = bjr;
    }

    public final void O000000o(String str) {
        this.O00000o0 = str;
    }

    public final void O000000o(bit bit) {
        this.O00000oO = bit;
    }

    public final void O00000Oo(final int i) {
        if (!this.O0000Oo) {
            this.O0000Oo = true;
            this.O0000O0o.post(new Runnable() {
                /* class _m_j.bjl.AnonymousClass1 */

                public final void run() {
                    try {
                        if (bjl.this.f13012O000000o != null) {
                            bjl.this.f13012O000000o.O000000o(i, bjl.this.O00000Oo);
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
        this.O00000Oo.putInt(str, i);
    }

    public final void O000000o(String str, byte[] bArr) {
        this.O00000Oo.putByteArray(str, bArr);
    }

    public final void O000000o(String str, Parcelable parcelable) {
        this.O00000Oo.putParcelable(str, parcelable);
    }

    /* access modifiers changed from: protected */
    public final String O0000Oo() {
        return bik.O000000o(O00000oO());
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, UUID uuid3) {
        return this.O00000oO.O000000o(uuid, uuid2, uuid3);
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        return this.O00000oO.O000000o(uuid, uuid2, uuid3, bArr);
    }

    public final boolean O00000Oo() {
        return this.O00000oO.O00000Oo();
    }

    public final boolean O00000o() {
        return this.O00000oO.O00000o();
    }

    public final int O00000oO() {
        return this.O00000oO.O00000oO();
    }

    public final void O000000o(bir bir) {
        O000000o();
        this.O00000o = bir;
        bky.O00000o0(String.format("Process %s, status = %s", getClass().getSimpleName(), bik.O000000o(O00000oO())));
        if (!bkz.O000000o()) {
            O00000o0(-4);
        } else if (!bkz.O00000Oo()) {
            O00000o0(-5);
        } else {
            try {
                O000000o((biw) this);
                O0000Oo0();
            } catch (Throwable th) {
                bky.O000000o(th);
                O00000o0(-10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(int i) {
        O000000o();
        O00000Oo(String.format("request complete: code = %d", Integer.valueOf(i)));
        this.O00000oo.removeCallbacksAndMessages(null);
        O00000Oo(this);
        O00000Oo(i);
        this.O00000o.O00000Oo(this);
    }

    public final void O00000o0() {
        O00000Oo(String.format("close gatt", new Object[0]));
        this.O00000oO.O00000o0();
    }

    public boolean handleMessage(Message message) {
        if (message.what == 32) {
            this.O0000Oo0 = true;
            O00000o0();
        }
        return true;
    }

    public final void O000000o(biw biw) {
        this.O00000oO.O000000o(biw);
    }

    public final void O00000Oo(biw biw) {
        this.O00000oO.O00000Oo(biw);
    }

    public final boolean O00000oo() {
        return this.O00000oO.O00000oo();
    }

    public final boolean O000000o(UUID uuid, UUID uuid2) {
        return this.O00000oO.O000000o(uuid, uuid2);
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.O00000oO.O000000o(uuid, uuid2, bArr);
    }

    public final boolean O00000Oo(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.O00000oO.O00000Oo(uuid, uuid2, bArr);
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, boolean z) {
        return this.O00000oO.O000000o(uuid, uuid2, z);
    }

    public final boolean O00000Oo(UUID uuid, UUID uuid2, boolean z) {
        return this.O00000oO.O00000Oo(uuid, uuid2, z);
    }

    public final boolean O0000O0o() {
        return this.O00000oO.O0000O0o();
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        bky.O00000Oo(String.format("%s %s >>> %s", getClass().getSimpleName(), this.O00000o0, str));
    }

    public final void O000000o() {
        this.O0000OOo.O000000o();
    }

    public final void O0000OoO() {
        O000000o();
        O00000Oo(String.format("request canceled", new Object[0]));
        this.O00000oo.removeCallbacksAndMessages(null);
        O00000Oo(this);
        O00000Oo(-2);
    }

    public void O000000o(boolean z) {
        if (!z) {
            O00000o0(this.O0000Oo0 ? -7 : -1);
        }
    }

    /* access modifiers changed from: protected */
    public final void O0000Ooo() {
        this.O00000oo.sendEmptyMessageDelayed(32, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
    }

    /* access modifiers changed from: protected */
    public final void O0000o00() {
        this.O00000oo.removeMessages(32);
    }

    public final BleGattProfile O0000OOo() {
        return this.O00000oO.O0000OOo();
    }
}

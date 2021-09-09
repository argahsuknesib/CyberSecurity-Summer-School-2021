package _m_j;

import _m_j.cjg;
import android.content.Context;
import com.xiaomi.mistream.MIStreamStatistic;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.XmMp4Record;

public abstract class cix implements cjg {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f13929O000000o;
    protected cjd O00000Oo;
    private boolean O00000o;
    protected dty O00000o0;
    private cia O00000oO;

    public cix(Context context, dty dty, cia cia) {
        this.O00000o0 = dty;
        this.f13929O000000o = context;
        this.O00000oO = cia;
        O000000o();
    }

    public void O000000o() {
        this.O00000Oo = new cji(this.f13929O000000o, this.O00000o0);
        this.O00000Oo.O000000o(this.O00000oO);
    }

    public final boolean O00000Oo() {
        return this.O00000Oo.O00000Oo();
    }

    public final boolean O00000o0() {
        return this.O00000Oo.O00000o0();
    }

    public final void O00000o() {
        O00000o0(false);
        this.O00000Oo.O00000o();
    }

    public final void O00000oO() {
        this.O00000Oo.O00000oO();
    }

    public final boolean O00000oo() {
        return this.O00000Oo.O00000oo();
    }

    public final boolean O0000O0o() {
        return this.O00000Oo.O0000O0o();
    }

    public void O0000OOo() {
        cki.O00000o("BaseCameraPlayer", "pausePlay");
        this.O00000Oo.O0000OOo();
    }

    public void O000000o(boolean z) {
        cki.O00000o("BaseCameraPlayer", "release");
        cqh.O00000Oo(this.f13929O000000o, "abandonFoucs");
        this.f13929O000000o = null;
        cjd cjd = this.O00000Oo;
        if (cjd != null) {
            cjd.O000000o(z);
        }
    }

    public final void O0000Oo0() {
        cki.O00000o("BaseCameraPlayer", "resumePlay");
        MIStreamStatistic.getInstance().latestCameraConnect = System.currentTimeMillis();
        if (this.O00000o) {
            O00000o0((IXmConnectionClient.XmActionCallback) null);
        }
    }

    public final boolean O0000Oo() {
        return this.O00000Oo.O0000Oo();
    }

    public final boolean O0000OoO() {
        return this.O00000Oo.O0000OoO();
    }

    public final boolean O0000Ooo() {
        return this.O00000Oo.O0000Ooo();
    }

    public final void O000000o(String str, int i) {
        this.O00000Oo.O000000o(str, i);
    }

    public final void O000000o(String str, int i, int i2) {
        this.O00000Oo.O000000o(str, i, i2);
    }

    public final void O00000Oo(boolean z) {
        this.O00000Oo.O00000Oo(z);
    }

    public final void O000000o(XmMp4Record.IRecordListener iRecordListener) {
        this.O00000Oo.O000000o(iRecordListener);
    }

    public void O00000o0(boolean z) {
        this.O00000Oo.O00000o0(z);
        if (!O0000O0o()) {
            this.O00000Oo.O00000Oo(!z);
        }
    }

    public final boolean O0000o00() {
        return this.O00000Oo.O0000o00();
    }

    public final void O000000o(IXmConnectionClient.XmActionCallback xmActionCallback) {
        this.O00000Oo.O000000o(xmActionCallback);
    }

    public final void O000000o(XmMp4Record.IRecordTimeListener iRecordTimeListener) {
        this.O00000Oo.O000000o(iRecordTimeListener);
    }

    public final boolean O0000o0() {
        return this.O00000Oo.O0000o0();
    }

    public final void O000000o(int i) {
        this.O00000Oo.O000000o(i);
    }

    public final void O00000o(boolean z) {
        this.O00000Oo.O00000o(z);
    }

    public final void O0000o0O() {
        O00000Oo((IXmConnectionClient.XmActionCallback) null);
    }

    public final void O00000Oo(IXmConnectionClient.XmActionCallback xmActionCallback) {
        cki.O00000o("BaseCameraPlayer", "startStream");
        this.O00000o = true;
        O00000o0(xmActionCallback);
    }

    /* access modifiers changed from: protected */
    public void O00000o0(IXmConnectionClient.XmActionCallback xmActionCallback) {
        this.O00000Oo.O00000Oo(xmActionCallback);
    }

    public final void O0000o0o() {
        cki.O00000o("BaseCameraPlayer", "stopStream");
        this.O00000Oo.O0000o0o();
    }

    public final void O0000o() {
        this.O00000Oo.O0000o();
    }

    public final void O0000oO0() {
        this.O00000Oo.O0000oO0();
    }

    public final void O0000oO() {
        this.O00000Oo.O0000oO();
    }

    public final void O00000oO(boolean z) {
        this.O00000Oo.O00000oO(z);
    }

    public void O000000o(int i, int i2, int i3, IXmConnectionClient.XmActionCallback xmActionCallback) {
        this.O00000Oo.O000000o(i, i2, i3, xmActionCallback);
    }

    public final void O00000Oo(int i) {
        this.O00000Oo.O00000Oo(i);
    }

    public final int O0000oOO() {
        return this.O00000Oo.O0000oOO();
    }

    public final long O0000oOo() {
        return this.O00000Oo.O0000oOo();
    }

    public final void O000000o(int i, IXmConnectionClient.XmActionCallback xmActionCallback) {
        this.O00000Oo.O000000o(i, xmActionCallback);
    }

    public final void O000000o(cjg.O00000Oo o00000Oo) {
        this.O00000Oo.O000000o(o00000Oo);
    }

    public final void O000000o(cjg.O000000o o000000o) {
        this.O00000Oo.O000000o(o000000o);
    }
}

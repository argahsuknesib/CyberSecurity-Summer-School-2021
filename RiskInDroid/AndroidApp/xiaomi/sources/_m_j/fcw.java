package _m_j;

import android.os.IBinder;
import com.xiaomi.smarthome.core.client.IClientApi;

public final class fcw {

    /* renamed from: O000000o  reason: collision with root package name */
    private IClientApi f16091O000000o;
    private int O00000Oo;
    private String O00000o;
    private int O00000o0;
    private String[] O00000oO;
    private IBinder.DeathRecipient O00000oo;
    private long O0000O0o;

    public final synchronized IClientApi O000000o() {
        return this.f16091O000000o;
    }

    public final synchronized String O00000Oo() {
        return this.O00000o;
    }

    public final synchronized long O00000o0() {
        return this.O0000O0o;
    }

    public final synchronized void O000000o(IClientApi iClientApi, int i, int i2, String str, String[] strArr, long j) {
        this.f16091O000000o = iClientApi;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = str;
        this.O00000oO = strArr;
        this.O0000O0o = j;
    }

    public final synchronized void O000000o(IBinder.DeathRecipient deathRecipient) {
        this.O00000oo = deathRecipient;
    }
}

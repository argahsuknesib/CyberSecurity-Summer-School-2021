package _m_j;

public final class ot {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f2374O000000o;
    public String O00000Oo;
    public int O00000o;
    public int O00000o0 = -113;
    public long O00000oO;
    public long O00000oo = 0;
    public int O0000O0o;
    public boolean O0000OOo;

    public ot(long j, String str, int i, int i2, long j2) {
        this.f2374O000000o = j;
        this.O00000Oo = str == null ? "" : str;
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = j2;
    }

    private ot(long j, String str, int i, int i2, long j2, long j3, boolean z, int i3) {
        this.f2374O000000o = j;
        this.O00000Oo = str == null ? "" : str;
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = j2;
        this.O00000oo = j3;
        this.O0000OOo = z;
        this.O0000O0o = i3;
    }

    /* renamed from: O000000o */
    public final ot clone() {
        return new ot(this.f2374O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000OOo, this.O0000O0o);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WiFi:[");
        stringBuffer.append("mac:" + pe.O000000o(this.f2374O000000o) + ",");
        stringBuffer.append("ssid:" + this.O00000Oo + ",");
        stringBuffer.append("rssi:" + this.O00000o0 + ",");
        stringBuffer.append("freq:" + this.O00000o + ",");
        stringBuffer.append("time:" + this.O00000oO + ",");
        stringBuffer.append("utc:" + this.O00000oo + ",");
        stringBuffer.append("conn:" + this.O0000OOo + ",");
        stringBuffer.append("type:" + this.O0000O0o + ",");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

package _m_j;

public final class cqw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final cqw f14262O000000o = new cqw("CONNECTION_STATE");
    public static final cqw O00000Oo = new cqw("SERVICE_DISCOVERY");
    public static final cqw O00000o = new cqw("CHARACTERISTIC_WRITE");
    public static final cqw O00000o0 = new cqw("CHARACTERISTIC_READ");
    public static final cqw O00000oO = new cqw("CHARACTERISTIC_CHANGED");
    public static final cqw O00000oo = new cqw("DESCRIPTOR_READ");
    public static final cqw O0000O0o = new cqw("DESCRIPTOR_WRITE");
    public static final cqw O0000OOo = new cqw("RELIABLE_WRITE_COMPLETED");
    public static final cqw O0000Oo = new cqw("ON_MTU_CHANGED");
    public static final cqw O0000Oo0 = new cqw("READ_RSSI");
    private final String O0000OoO;

    private cqw(String str) {
        this.O0000OoO = str;
    }

    public final String toString() {
        return "BleGattOperation{description='" + this.O0000OoO + '\'' + '}';
    }
}

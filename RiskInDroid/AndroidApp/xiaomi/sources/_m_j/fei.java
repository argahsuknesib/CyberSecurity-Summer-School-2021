package _m_j;

import java.sql.Timestamp;

public final class fei implements Comparable<fei> {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f16183O000000o;
    public String O00000Oo;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return (int) (this.f16183O000000o - ((fei) obj).f16183O000000o);
    }

    public fei() {
    }

    public fei(String str) {
        this.O00000Oo = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fei)) {
            return false;
        }
        fei fei = (fei) obj;
        String str = this.O00000Oo;
        if (str != null) {
            return str.equals(fei.O00000Oo);
        }
        return fei.O00000Oo == null;
    }

    public final int hashCode() {
        String str = this.O00000Oo;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "DisconnectionHolder{deadline=" + new Timestamp(this.f16183O000000o) + ", mac='" + this.O00000Oo + '\'' + '}';
    }
}

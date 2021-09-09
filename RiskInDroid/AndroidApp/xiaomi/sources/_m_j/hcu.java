package _m_j;

public abstract class hcu {

    /* renamed from: O000000o  reason: collision with root package name */
    public double f18783O000000o;

    public interface O000000o {
        String format(Number number);
    }

    public hcu(double d) {
        this.f18783O000000o = d;
    }

    public static hdj O000000o(String str, String str2) {
        return new hdj(str, str2);
    }

    public hdj O000000o(Number number, String str, O000000o o000000o) {
        return new hdj(o000000o.format(Double.valueOf(number.doubleValue() * this.f18783O000000o)), str);
    }
}

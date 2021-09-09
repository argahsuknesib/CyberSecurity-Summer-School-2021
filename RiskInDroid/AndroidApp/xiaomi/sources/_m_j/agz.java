package _m_j;

import java.io.IOException;

public final class agz implements wx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final agy f12384O000000o = new agy();
    private String O00000Oo = "";

    public agz(xu xuVar) {
        xuVar.O000000o(this.f12384O000000o);
    }

    public final boolean O000000o(String str) {
        return str.equals("WAVE");
    }

    public final boolean O00000Oo(String str) {
        if (!str.equals("fmt ")) {
            return (this.O00000Oo.equals("INFO") && agy.O0000OOo.containsKey(str)) || str.equals("data");
        }
        return true;
    }

    public final boolean O00000o0(String str) {
        if (str.equals("INFO")) {
            this.O00000Oo = "INFO";
            return true;
        }
        this.O00000Oo = "";
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, short]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.Object):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, int):void */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:18|19|20|21|22|23|24|25|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00f7 */
    public final void O000000o(String str, byte[] bArr) {
        try {
            if (str.equals("fmt ")) {
                xc xcVar = new xc(bArr);
                xcVar.f2594O000000o = false;
                short O00000oo = xcVar.O00000oo(0);
                short O00000oo2 = xcVar.O00000oo(2);
                int O0000Oo0 = xcVar.O0000Oo0(4);
                int O0000Oo02 = xcVar.O0000Oo0(8);
                short O00000oo3 = xcVar.O00000oo(12);
                if (O00000oo == 1) {
                    this.f12384O000000o.O000000o(6, (int) xcVar.O00000oo(14));
                    this.f12384O000000o.O000000o(1, agy.O0000Oo0.get(Integer.valueOf(O00000oo)));
                } else if (agy.O0000Oo0.containsKey(Integer.valueOf(O00000oo))) {
                    this.f12384O000000o.O000000o(1, agy.O0000Oo0.get(Integer.valueOf(O00000oo)));
                } else {
                    this.f12384O000000o.O000000o(1, "Unknown");
                }
                this.f12384O000000o.O000000o(2, (int) O00000oo2);
                this.f12384O000000o.O000000o(3, O0000Oo0);
                this.f12384O000000o.O000000o(4, O0000Oo02);
                this.f12384O000000o.O000000o(5, (int) O00000oo3);
            } else if (str.equals("data")) {
                if (this.f12384O000000o.O000000o(4)) {
                    double length = (double) bArr.length;
                    double O00000oO = this.f12384O000000o.O00000oO();
                    Double.isNaN(length);
                    double d = length / O00000oO;
                    int i = (int) d;
                    Integer valueOf = Integer.valueOf(i / ((int) Math.pow(60.0d, 2.0d)));
                    Integer valueOf2 = Integer.valueOf((i / ((int) Math.pow(60.0d, 1.0d))) - (valueOf.intValue() * 60));
                    double pow = d / Math.pow(60.0d, 0.0d);
                    double intValue = (double) (valueOf2.intValue() * 60);
                    Double.isNaN(intValue);
                    this.f12384O000000o.O000000o(16, String.format("%1$02d:%2$02d:%3$02d", valueOf, valueOf2, Integer.valueOf((int) Math.round(pow - intValue))));
                    this.f12384O000000o.O000000o("Error calculating duration: bytes per second not found");
                }
            } else if (agy.O0000OOo.containsKey(str)) {
                this.f12384O000000o.O000000o(agy.O0000OOo.get(str).intValue(), new String(bArr).substring(0, bArr.length - 1));
            }
        } catch (IOException e) {
            this.f12384O000000o.O000000o(e.getMessage());
        }
    }
}

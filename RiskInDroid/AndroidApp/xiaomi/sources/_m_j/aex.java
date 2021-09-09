package _m_j;

import _m_j.xr;
import java.util.ArrayList;
import java.util.Arrays;

public final class aex<T extends xr> extends xx<aez> {
    public aex(aez aez) {
        super(aez);
    }

    public final String O000000o(int i) {
        if (i == 1) {
            byte[] O0000O0o = ((aez) this.f2602O000000o).O0000O0o(1);
            if (O0000O0o == null) {
                return null;
            }
            return aey.O000000o(new String(O0000O0o));
        } else if (i == 3) {
            return O00000oo();
        } else {
            if (i != 259) {
                return ((aez) this.f2602O000000o).O0000o0(i);
            }
            Long O0000Oo = ((aez) this.f2602O000000o).O0000Oo(259);
            if (O0000Oo == null) {
                return null;
            }
            double longValue = (double) O0000Oo.longValue();
            double pow = Math.pow(60.0d, 2.0d);
            Double.isNaN(longValue);
            Integer valueOf = Integer.valueOf((int) (longValue / pow));
            double longValue2 = (double) O0000Oo.longValue();
            double pow2 = Math.pow(60.0d, 1.0d);
            Double.isNaN(longValue2);
            double d = longValue2 / pow2;
            double intValue = (double) (valueOf.intValue() * 60);
            Double.isNaN(intValue);
            Integer valueOf2 = Integer.valueOf((int) (d - intValue));
            double longValue3 = (double) O0000Oo.longValue();
            double pow3 = Math.pow(60.0d, 0.0d);
            Double.isNaN(longValue3);
            double d2 = longValue3 / pow3;
            double intValue2 = (double) (valueOf2.intValue() * 60);
            Double.isNaN(intValue2);
            return String.format("%1$02d:%2$02d:%3$02d", valueOf, valueOf2, Integer.valueOf((int) Math.ceil(d2 - intValue2)));
        }
    }

    private String O00000oo() {
        String[] O00000o = ((aez) this.f2602O000000o).O00000o(3);
        if (O00000o == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : O00000o) {
            String O000000o2 = aey.O000000o(str);
            if (O000000o2 != null) {
                str = O000000o2;
            }
            arrayList.add(str);
        }
        return Arrays.toString(arrayList.toArray());
    }
}

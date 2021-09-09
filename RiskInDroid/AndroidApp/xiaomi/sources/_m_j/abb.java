package _m_j;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class abb extends xx<abc> {
    public abb(abc abc) {
        super(abc);
    }

    public final String O000000o(int i) {
        switch (i) {
            case 0:
                return ((abc) this.f2602O000000o).O0000o0(i);
            case 10:
                return String.format("0x%08X", ((abc) this.f2602O000000o).O00000o0(i));
            case 14:
                return String.format("%d", ((abc) this.f2602O000000o).O00000o0(i));
            case 18:
                return String.format("0x%08X", ((abc) this.f2602O000000o).O00000o0(i));
            case 22:
                return String.format("%d", ((abc) this.f2602O000000o).O00000o0(i));
            case 24:
            case 31:
            case 38:
            case 45:
            case 52:
                return ((abc) this.f2602O000000o).O0000o0(i);
            case 53:
                int[] O00000oo = ((abc) this.f2602O000000o).O00000oo(i);
                if (O00000oo == null) {
                    return null;
                }
                return String.format("%d/%d", Integer.valueOf(O00000oo[0]), Integer.valueOf(O00000oo[1]));
            case 55:
                return String.format("%d", ((abc) this.f2602O000000o).O00000o0(i));
            case 59:
                String O0000o0 = ((abc) this.f2602O000000o).O0000o0(i);
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                    return simpleDateFormat.format(simpleDateFormat.parse(O0000o0));
                } catch (ParseException unused) {
                    return null;
                }
            case 67:
                return O000000o(i, "New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full", "Waning Gibbous", "Last Quarter", "Waning Crescent");
            case 68:
            case 70:
                return String.format("%d", ((abc) this.f2602O000000o).O00000o0(i));
            case 72:
                return O000000o(i, "Off", "On");
            case 73:
                Double O0000OOo = ((abc) this.f2602O000000o).O0000OOo(i);
                DecimalFormat decimalFormat = new DecimalFormat("0.000");
                if (O0000OOo == null) {
                    return null;
                }
                return decimalFormat.format(O0000OOo);
            case 75:
                xv O0000o0O = ((abc) this.f2602O000000o).O0000o0O(i);
                if (O0000o0O == null) {
                    return null;
                }
                return O0000o0O.toString();
            case 80:
                return ((abc) this.f2602O000000o).O0000o0(i);
            default:
                return super.O000000o(i);
        }
    }
}

package _m_j;

import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class aaz extends xx<aba> {
    public aaz(aba aba) {
        super(aba);
    }

    public final String O000000o(int i) {
        switch (i) {
            case 0:
                return String.format("%d", ((aba) this.f2602O000000o).O00000o0(i));
            case 2:
                return ((aba) this.f2602O000000o).O0000o0(i);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return ((aba) this.f2602O000000o).O0000o0(i);
            case 14:
                int[] O00000oo = ((aba) this.f2602O000000o).O00000oo(i);
                if (O00000oo == null) {
                    return null;
                }
                return String.format("%d/%d", Integer.valueOf(O00000oo[0]), Integer.valueOf(O00000oo[1]));
            case 18:
                return String.format("%d", ((aba) this.f2602O000000o).O00000o0(i));
            case 22:
                String O0000o0 = ((aba) this.f2602O000000o).O0000o0(i);
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                    return simpleDateFormat.format(simpleDateFormat.parse(O0000o0));
                } catch (ParseException unused) {
                    return null;
                }
            case 36:
                return O000000o(i, "New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full", "Waning Gibbous", "Last Quarter", "Waning Crescent");
            case 38:
            case 40:
                return String.format("%d", ((aba) this.f2602O000000o).O00000o0(i));
            case 42:
                xv O0000o0O = ((aba) this.f2602O000000o).O0000o0O(i);
                if (O0000o0O == null) {
                    return null;
                }
                return O0000o0O.toString();
            case 72:
            case 74:
            case 76:
            case 78:
                return String.format("%d", ((aba) this.f2602O000000o).O00000o0(i));
            case 80:
                return O000000o(i, "Off", "On");
            case XiaomiOAuthConstants.VERSION_MINOR:
                return String.format("%d", ((aba) this.f2602O000000o).O00000o0(i));
            case 84:
                Double O0000OOo = ((aba) this.f2602O000000o).O0000OOo(i);
                DecimalFormat decimalFormat = new DecimalFormat("0.000");
                if (O0000OOo == null) {
                    return null;
                }
                return decimalFormat.format(O0000OOo);
            case 86:
                return ((aba) this.f2602O000000o).O0000o0(i);
            default:
                return super.O000000o(i);
        }
    }
}

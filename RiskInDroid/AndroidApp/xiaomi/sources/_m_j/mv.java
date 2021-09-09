package _m_j;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class mv {
    public static String O000000o(mm mmVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (mmVar.O0000Oo0()) {
            DecimalFormat decimalFormat = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.ENGLISH));
            stringBuffer.append(decimalFormat.format((long) mmVar.O000000o()));
            if (mmVar.O00000Oo() == 0) {
                return stringBuffer.toString();
            }
            decimalFormat.applyPattern("'-'00");
            stringBuffer.append(decimalFormat.format((long) mmVar.O00000Oo()));
            if (mmVar.O00000o0() == 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(decimalFormat.format((long) mmVar.O00000o0()));
            if (mmVar.O0000Oo()) {
                stringBuffer.append('T');
                decimalFormat.applyPattern("00");
                stringBuffer.append(decimalFormat.format((long) mmVar.O00000o()));
                stringBuffer.append(':');
                stringBuffer.append(decimalFormat.format((long) mmVar.O00000oO()));
                if (!(mmVar.O00000oo() == 0 && mmVar.O0000O0o() == 0)) {
                    double O00000oo = (double) mmVar.O00000oo();
                    double O0000O0o = (double) mmVar.O0000O0o();
                    Double.isNaN(O0000O0o);
                    Double.isNaN(O00000oo);
                    decimalFormat.applyPattern(":00.#########");
                    stringBuffer.append(decimalFormat.format(O00000oo + (O0000O0o / 1.0E9d)));
                }
                if (mmVar.O0000OoO()) {
                    int offset = mmVar.O0000OOo().getOffset(mmVar.O0000Ooo().getTimeInMillis());
                    if (offset == 0) {
                        stringBuffer.append('Z');
                    } else {
                        int i = offset / 3600000;
                        int abs = Math.abs((offset % 3600000) / 60000);
                        decimalFormat.applyPattern("+00;-00");
                        stringBuffer.append(decimalFormat.format((long) i));
                        decimalFormat.applyPattern(":00");
                        stringBuffer.append(decimalFormat.format((long) abs));
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}

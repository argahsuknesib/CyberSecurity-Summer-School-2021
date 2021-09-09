package org.apache.commons.text.translate;

import _m_j.jdl;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

public final class NumericEntityUnescaper extends jdl {
    private final EnumSet<OPTION> O00000Oo = EnumSet.copyOf(Arrays.asList(OPTION.semiColonRequired));

    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    private boolean O000000o(OPTION option) {
        EnumSet<OPTION> enumSet = this.O00000Oo;
        return enumSet != null && enumSet.contains(option);
    }

    public final int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2;
        int i3;
        int length = charSequence.length();
        if (charSequence.charAt(i) == '&' && i < length - 2 && charSequence.charAt(i + 1) == '#') {
            int i4 = i + 2;
            char charAt = charSequence.charAt(i4);
            if (charAt == 'x' || charAt == 'X') {
                i4++;
                if (i4 == length) {
                    return 0;
                }
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i5 = i4;
            while (i5 < length && ((charSequence.charAt(i5) >= '0' && charSequence.charAt(i5) <= '9') || ((charSequence.charAt(i5) >= 'a' && charSequence.charAt(i5) <= 'f') || (charSequence.charAt(i5) >= 'A' && charSequence.charAt(i5) <= 'F')))) {
                i5++;
            }
            int i6 = (i5 == length || charSequence.charAt(i5) != ';') ? 0 : 1;
            if (i6 == 0) {
                if (O000000o(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (O000000o(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            if (i2 != 0) {
                try {
                    i3 = Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 16);
                } catch (NumberFormatException unused) {
                }
            } else {
                i3 = Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 10);
            }
            if (i3 > 65535) {
                char[] chars = Character.toChars(i3);
                writer.write(chars[0]);
                writer.write(chars[1]);
            } else {
                writer.write(i3);
            }
            return ((i5 + 2) - i4) + i2 + i6;
        }
        return 0;
    }
}

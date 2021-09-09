package _m_j;

import java.io.IOException;
import java.io.Writer;

public final class jds extends jdl {
    private static boolean O000000o(char c) {
        return c >= '0' && c <= '7';
    }

    public final int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
        int length = (charSequence.length() - i) - 1;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        if (charSequence.charAt(i) == '\\' && length > 0) {
            int i2 = i + 1;
            if (O000000o(charSequence.charAt(i2))) {
                int i3 = i + 2;
                int i4 = i + 3;
                sb.append(charSequence.charAt(i2));
                if (length > 1 && O000000o(charSequence.charAt(i3))) {
                    sb.append(charSequence.charAt(i3));
                    if (length > 2) {
                        char charAt = charSequence.charAt(i2);
                        if (charAt >= '0' && charAt <= '3') {
                            z = true;
                        }
                        if (z && O000000o(charSequence.charAt(i4))) {
                            sb.append(charSequence.charAt(i4));
                        }
                    }
                }
                writer.write(Integer.parseInt(sb.toString(), 8));
                return sb.length() + 1;
            }
        }
        return 0;
    }
}

package _m_j;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

public abstract class jdl {

    /* renamed from: O000000o  reason: collision with root package name */
    static final char[] f1778O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public abstract int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException;

    public final String O000000o(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            O000000o(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void O000000o(CharSequence charSequence, Writer writer) throws IOException {
        jdf.O000000o(true, "The Writer must not be null", new Object[0]);
        if (charSequence != null) {
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int O000000o2 = O000000o(charSequence, i, writer);
                if (O000000o2 == 0) {
                    char charAt = charSequence.charAt(i);
                    writer.write(charAt);
                    i++;
                    if (Character.isHighSurrogate(charAt) && i < length) {
                        char charAt2 = charSequence.charAt(i);
                        if (Character.isLowSurrogate(charAt2)) {
                            writer.write(charAt2);
                            i++;
                        }
                    }
                } else {
                    int i2 = i;
                    for (int i3 = 0; i3 < O000000o2; i3++) {
                        i2 += Character.charCount(Character.codePointAt(charSequence, i2));
                    }
                    i = i2;
                }
            }
        }
    }

    public static String O000000o(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }
}

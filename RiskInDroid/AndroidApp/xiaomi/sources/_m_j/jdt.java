package _m_j;

import java.io.IOException;
import java.io.Writer;

abstract class jdt extends jdl {
    /* access modifiers changed from: package-private */
    public abstract void O000000o(CharSequence charSequence, Writer writer) throws IOException;

    jdt() {
    }

    public int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (i != 0) {
            StringBuilder sb = new StringBuilder();
            Class<?> cls = getClass();
            sb.append(cls.isAnonymousClass() ? cls.getName() : cls.getSimpleName());
            sb.append(".translate(final CharSequence input, final int index, final Writer out) can not handle a non-zero index.");
            throw new IllegalArgumentException(sb.toString());
        }
        O000000o(charSequence, writer);
        return Character.codePointCount(charSequence, i, charSequence.length());
    }
}

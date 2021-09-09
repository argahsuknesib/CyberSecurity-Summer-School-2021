package _m_j;

import java.io.IOException;
import java.io.Writer;

public final class jdn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f1779O000000o = "\"";
    public static final String O00000Oo = (f1779O000000o + f1779O000000o);
    public static final char[] O00000o0 = {',', '\"', 13, 10};

    public static class O000000o extends jdt {
        public final /* bridge */ /* synthetic */ int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
            return super.O000000o(charSequence, i, writer);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
        public final void O000000o(CharSequence charSequence, Writer writer) throws IOException {
            String charSequence2 = charSequence.toString();
            char[] cArr = jdn.O00000o0;
            boolean z = false;
            if (charSequence2 != null && cArr != null) {
                int length = charSequence2.length();
                int i = length - 1;
                int length2 = cArr.length;
                int i2 = length2 - 1;
                int i3 = 0;
                loop0:
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    char charAt = charSequence2.charAt(i3);
                    for (int i4 = 0; i4 < length2; i4++) {
                        if (cArr[i4] == charAt && (!Character.isHighSurrogate(charAt) || i4 == i2 || (i3 < i && cArr[i4 + 1] == charSequence2.charAt(i3 + 1)))) {
                            break loop0;
                        }
                    }
                    i3++;
                }
                if (!z) {
                    writer.write(charSequence2);
                    return;
                }
                writer.write(34);
                writer.write(jde.O000000o(charSequence2, jdn.f1779O000000o, jdn.O00000Oo));
                writer.write(34);
                return;
            }
            z = true;
            if (!z) {
            }
        }
    }

    public static class O00000Oo extends jdt {
        public final /* bridge */ /* synthetic */ int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
            return super.O000000o(charSequence, i, writer);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0076  */
        public final void O000000o(CharSequence charSequence, Writer writer) throws IOException {
            if (charSequence.charAt(0) == '\"') {
                boolean z = true;
                if (charSequence.charAt(charSequence.length() - 1) == '\"') {
                    String charSequence2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                    char[] cArr = jdn.O00000o0;
                    if (!jde.O000000o(charSequence2) && !jdd.O000000o(cArr)) {
                        int length = charSequence2.length();
                        int length2 = cArr.length;
                        int i = length - 1;
                        int i2 = length2 - 1;
                        int i3 = 0;
                        loop0:
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            char charAt = charSequence2.charAt(i3);
                            for (int i4 = 0; i4 < length2; i4++) {
                                if (cArr[i4] == charAt && (!Character.isHighSurrogate(charAt) || i4 == i2 || (i3 < i && cArr[i4 + 1] == charSequence2.charAt(i3 + 1)))) {
                                    break loop0;
                                }
                            }
                            i3++;
                        }
                        if (!z) {
                            writer.write(jde.O000000o(charSequence2, jdn.O00000Oo, jdn.f1779O000000o));
                            return;
                        } else {
                            writer.write(charSequence.toString());
                            return;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            writer.write(charSequence.toString());
        }
    }
}

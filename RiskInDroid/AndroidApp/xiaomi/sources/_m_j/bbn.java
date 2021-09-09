package _m_j;

import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.ParseException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

final class bbn {

    /* renamed from: O000000o  reason: collision with root package name */
    final Scanner f12765O000000o;
    final StringBuilder O00000Oo = new StringBuilder();
    private boolean O00000o;
    private final boolean O00000o0;

    bbn(InputStream inputStream, Encoding encoding) {
        this.f12765O000000o = new Scanner(inputStream, encoding.value).useLocale(Locale.US).useDelimiter("\\r?\\n");
        this.O00000o0 = encoding.supportsByteOrderMark;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o() throws ParseException {
        String next = this.f12765O000000o.next();
        if (this.O00000o0 && !this.O00000o) {
            if (!next.isEmpty() && next.charAt(0) == 65279) {
                next = next.substring(1);
            }
            this.O00000o = true;
        }
        StringBuilder sb = this.O00000Oo;
        sb.append(next);
        sb.append("\n");
        return next;
    }
}

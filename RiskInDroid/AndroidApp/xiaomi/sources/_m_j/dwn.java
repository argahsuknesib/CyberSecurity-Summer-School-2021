package _m_j;

import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class dwn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f15003O000000o = new ThreadLocal<SimpleDateFormat>() {
        /* class _m_j.dwn.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    };

    public static String O000000o(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static String O000000o(File file) {
        int i;
        String mimeTypeFromExtension;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf <= 0 || (i = lastIndexOf + 1) >= name.length() || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(i))) == null) {
            return dwk.f15000O000000o;
        }
        return mimeTypeFromExtension;
    }

    public static String O000000o(Date date) {
        return f15003O000000o.get().format(date);
    }
}

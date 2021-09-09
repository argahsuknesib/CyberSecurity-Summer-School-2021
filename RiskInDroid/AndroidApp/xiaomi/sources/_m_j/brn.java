package _m_j;

import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;

public final class brn {
    public static long O000000o(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable th) {
            brm.O000000o(th.getMessage(), th);
            return -1;
        }
    }

    public static String O000000o(HttpResponse httpResponse) {
        Header firstHeader;
        if (httpResponse == null || (firstHeader = httpResponse.getFirstHeader("Content-Disposition")) == null) {
            return null;
        }
        for (HeaderElement parameterByName : firstHeader.getElements()) {
            NameValuePair parameterByName2 = parameterByName.getParameterByName("filename");
            if (parameterByName2 != null) {
                String value = parameterByName2.getValue();
                return brk.O000000o(value, "UTF-8", value.length());
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[SYNTHETIC, Splitter:B:11:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[RETURN] */
    public static Charset O000000o(HttpRequestBase httpRequestBase) {
        String str;
        Header firstHeader = httpRequestBase.getFirstHeader("Content-Type");
        boolean z = false;
        if (firstHeader != null) {
            HeaderElement[] elements = firstHeader.getElements();
            int length = elements.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                NameValuePair parameterByName = elements[i].getParameterByName("charset");
                if (parameterByName != null) {
                    str = parameterByName.getValue();
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    z = Charset.isSupported(str);
                } catch (Throwable unused) {
                }
            }
            if (!z) {
                return Charset.forName(str);
            }
            return null;
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
        if (!z) {
        }
    }

    public static long O000000o(String str, String str2) throws UnsupportedEncodingException {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        if (length < 100) {
            return (long) str.getBytes(str2).length;
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 100;
            j += (long) new String(str.substring(i, i2 < length ? i2 : length)).getBytes(str2).length;
            i = i2;
        }
        return j;
    }

    public static StackTraceElement O000000o() {
        return Thread.currentThread().getStackTrace()[4];
    }
}

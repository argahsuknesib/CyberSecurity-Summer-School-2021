package com.xiaomi.mico.api.interceptor;

import _m_j.jax;
import _m_j.jaz;
import android.text.TextUtils;
import com.xiaomi.mico.api.logger.ApiLogger;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;

public class LoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static int sSequenceNumber = 1;
    private final ApiLogger mLogger;

    public LoggingInterceptor(ApiLogger apiLogger) {
        this.mLogger = apiLogger;
    }

    private static synchronized int incrementSequenceNumber() {
        int i;
        synchronized (LoggingInterceptor.class) {
            int i2 = sSequenceNumber + 1;
            sSequenceNumber = i2;
            if (i2 == Integer.MAX_VALUE) {
                sSequenceNumber = 1;
            }
            i = sSequenceNumber;
        }
        return i;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        Request request = chain.request();
        String str2 = "#" + incrementSequenceNumber() + " ";
        RequestBody body = request.body();
        this.mLogger.i(str2 + request.method() + ' ' + request.url());
        if (TextUtils.isEmpty(request.header("Not-Log-Request-Body")) && body != null && !bodyEncoded(request.headers())) {
            jax jax = new jax();
            body.writeTo(jax);
            Charset charset = UTF8;
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            if (isPlaintext(jax)) {
                this.mLogger.i(str2 + jax.O000000o(charset));
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(proceed.code());
            if (!proceed.isSuccessful()) {
                str = " " + proceed.message();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" (");
            sb.append(millis);
            sb.append("ms)");
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(request.header("Not-Log-Response-Body")) && HttpHeaders.hasBody(proceed) && !bodyEncoded(proceed.headers())) {
                ResponseBody body2 = proceed.body();
                jaz source = body2.source();
                source.O00000Oo(Long.MAX_VALUE);
                jax O000000o2 = source.O000000o();
                Charset charset2 = UTF8;
                MediaType contentType2 = body2.contentType();
                if (contentType2 != null) {
                    charset2 = contentType2.charset(UTF8);
                }
                if (isPlaintext(O000000o2) && body2.contentLength() != 0) {
                    sb2 = sb2 + " " + O000000o2.clone().O000000o(charset2);
                }
            }
            this.mLogger.i(sb2);
            return proceed;
        } catch (Exception e) {
            this.mLogger.i(str2 + "HTTP FAILED: " + e);
            throw e;
        }
    }

    private static boolean isPlaintext(jax jax) {
        long j;
        try {
            jax jax2 = new jax();
            if (jax.O00000Oo < 64) {
                j = jax.O00000Oo;
            } else {
                j = 64;
            }
            jax.O000000o(jax2, 0, j);
            for (int i = 0; i < 16 && !jax2.O00000o(); i++) {
                int O0000oO = jax2.O0000oO();
                if (Character.isISOControl(O0000oO) && !Character.isWhitespace(O0000oO)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private static boolean bodyEncoded(Headers headers) {
        String str = headers.get("Content-Encoding");
        return str != null && !str.equalsIgnoreCase("identity");
    }
}

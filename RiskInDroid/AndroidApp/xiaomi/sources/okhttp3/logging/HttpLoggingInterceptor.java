package okhttp3.logging;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbe;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            /* class okhttp3.logging.HttpLoggingInterceptor.Logger.AnonymousClass1 */

            public final void log(String str) {
                Platform.get().log(4, str, null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.level = Level.NONE;
        this.logger = logger2;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 != null) {
            this.level = level2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public final Level getLevel() {
        return this.level;
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x0314  */
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        String str2;
        boolean z;
        String str3;
        long j;
        String str4;
        String str5;
        Long l;
        boolean z2;
        Interceptor.Chain chain2 = chain;
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean z3 = true;
        boolean z4 = level2 == Level.BODY;
        boolean z5 = z4 || level2 == Level.HEADERS;
        RequestBody body = request.body();
        if (body == null) {
            z3 = false;
        }
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        if (connection != null) {
            str = " " + connection.protocol();
        } else {
            str = "";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (z5 || !z3) {
            str2 = " ";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(" (");
            str2 = " ";
            sb3.append(body.contentLength());
            sb3.append("-byte body)");
            sb2 = sb3.toString();
        }
        this.logger.log(sb2);
        if (z5) {
            if (z3) {
                if (body.contentType() != null) {
                    this.logger.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i = 0;
            while (i < size) {
                String name = headers.name(i);
                int i2 = size;
                if ("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name)) {
                    z2 = z5;
                } else {
                    z2 = z5;
                    this.logger.log(name + ": " + headers.value(i));
                }
                i++;
                size = i2;
                z5 = z2;
            }
            z = z5;
            if (!z4 || !z3) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                jax jax = new jax();
                body.writeTo(jax);
                Charset charset = UTF8;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }
                this.logger.log("");
                if (isPlaintext(jax)) {
                    this.logger.log(jax.O000000o(charset));
                    this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z5;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain2.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str3 = contentLength + "-byte";
            } else {
                str3 = "unknown-length";
            }
            Logger logger2 = this.logger;
            String str6 = "-byte body)";
            StringBuilder sb4 = new StringBuilder("<-- ");
            sb4.append(proceed.code());
            if (proceed.message().isEmpty()) {
                j = contentLength;
                str4 = "";
            } else {
                j = contentLength;
                str4 = str2 + proceed.message();
            }
            sb4.append(str4);
            sb4.append(' ');
            sb4.append(proceed.request().url());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            if (!z) {
                str5 = ", " + str3 + " body";
            } else {
                str5 = "";
            }
            sb4.append(str5);
            sb4.append(')');
            logger2.log(sb4.toString());
            if (z) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.logger.log(headers2.name(i3) + ": " + headers2.value(i3));
                }
                if (!z4 || !HttpHeaders.hasBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    jaz source = body2.source();
                    source.O00000Oo(Long.MAX_VALUE);
                    jax O000000o2 = source.O000000o();
                    jbe jbe = null;
                    if ("gzip".equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                        l = Long.valueOf(O000000o2.O00000Oo);
                        try {
                            jbe jbe2 = new jbe(O000000o2.clone());
                            try {
                                O000000o2 = new jax();
                                O000000o2.O000000o(jbe2);
                                jbe2.close();
                            } catch (Throwable th) {
                                th = th;
                                jbe = jbe2;
                                if (jbe != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (jbe != null) {
                                jbe.close();
                            }
                            throw th;
                        }
                    } else {
                        l = null;
                    }
                    Charset charset2 = UTF8;
                    MediaType contentType2 = body2.contentType();
                    if (contentType2 != null) {
                        charset2 = contentType2.charset(UTF8);
                    }
                    if (!isPlaintext(O000000o2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + O000000o2.O00000Oo + "-byte body omitted)");
                        return proceed;
                    }
                    if (j != 0) {
                        this.logger.log("");
                        this.logger.log(O000000o2.clone().O000000o(charset2));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + O000000o2.O00000Oo + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + O000000o2.O00000Oo + str6);
                    }
                }
            }
            return proceed;
        } catch (Exception e) {
            Exception exc = e;
            this.logger.log("<-- HTTP FAILED: ".concat(String.valueOf(exc)));
            throw exc;
        }
    }

    static boolean isPlaintext(jax jax) {
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

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return str != null && !str.equalsIgnoreCase("identity") && !str.equalsIgnoreCase("gzip");
    }
}

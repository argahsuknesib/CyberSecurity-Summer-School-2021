package _m_j;

import android.content.Context;
import java.io.IOException;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class ezf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f15975O000000o = "https://i.ai.mi.com/file";
    public String O00000Oo = "";
    public OkHttpClient O00000o;
    public Context O00000o0;

    public interface O00000Oo {
        void O000000o(long j, long j2);
    }

    public ezf() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.O00000o = builder.addInterceptor(new O000000o()).build();
    }

    public final boolean O000000o(String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(strArr[i]);
            sb.append("=");
            sb.append(strArr2[i]);
            sb.append(";");
        }
        this.O00000Oo = sb.toString();
        return true;
    }

    public class O00000o0 extends RequestBody {

        /* renamed from: O000000o  reason: collision with root package name */
        public O00000Oo f15982O000000o;
        private jay O00000o;
        private final RequestBody O00000o0;

        public O00000o0(RequestBody requestBody, O00000Oo o00000Oo) {
            this.O00000o0 = requestBody;
            this.f15982O000000o = o00000Oo;
        }

        public final long contentLength() throws IOException {
            return this.O00000o0.contentLength();
        }

        public final MediaType contentType() {
            return this.O00000o0.contentType();
        }

        public final void writeTo(jay jay) throws IOException {
            if (this.O00000o == null) {
                this.O00000o = jbg.O000000o(new jbb(jay) {
                    /* class _m_j.ezf.O00000o0.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    long f15983O000000o = 0;
                    long O00000Oo = 0;

                    public final void write(jax jax, long j) throws IOException {
                        super.write(jax, j);
                        if (O00000o0.this.f15982O000000o != null) {
                            if (this.O00000Oo == 0) {
                                this.O00000Oo = O00000o0.this.contentLength();
                            }
                            this.f15983O000000o += j;
                            O00000o0.this.f15982O000000o.O000000o(this.f15983O000000o, this.O00000Oo);
                        }
                    }
                });
            }
            this.O00000o0.writeTo(this.O00000o);
            this.O00000o.flush();
        }
    }

    public class O000000o implements Interceptor {
        private List<String> O00000Oo;

        public O000000o() {
        }

        public final Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder newBuilder = chain.request().newBuilder();
            newBuilder.addHeader("Cookie", ezf.this.O00000Oo);
            List<String> list = this.O00000Oo;
            if (list != null) {
                for (String str : list) {
                    newBuilder.addHeader("Cookie", str.toString());
                }
            }
            Response proceed = chain.proceed(newBuilder.build());
            this.O00000Oo = proceed.headers("Set-Cookie");
            return proceed;
        }
    }
}

package _m_j;

import java.io.IOException;
import java.net.CookieManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class gsg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile OkHttpClient f18206O000000o;
    private static CookieManager O00000Oo;

    private static <R> R O000000o(OkHttpClient okHttpClient, gsj gsj, gsp gsp) throws Exception {
        if (okHttpClient == null) {
            throw new RuntimeException("client is null");
        } else if (gsp != null) {
            Request.Builder builder = new Request.Builder();
            Headers O000000o2 = gss.O000000o(gsj.O00000Oo);
            if (O000000o2 != null) {
                builder.headers(O000000o2);
            }
            if (gsj.O000000o().equals("POST")) {
                builder.url(gsj.f18211O000000o).post(gst.O000000o(gsj));
            } else if (gsj.O000000o().equals("GET")) {
                builder.url(gst.O000000o(gsj.f18211O000000o, gsj.O00000o0));
            } else {
                throw new RuntimeException("method unsupported");
            }
            try {
                Response execute = okHttpClient.newCall(builder.build()).execute();
                R O000000o3 = gsp.O000000o(execute);
                if (!(execute == null || execute.body() == null)) {
                    execute.close();
                }
                return O000000o3;
            } catch (IOException e) {
                throw new RuntimeException("failure:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("handler is null");
        }
    }

    public static <R> R O000000o(gsj gsj, gsp<R> gsp) throws Exception {
        return O000000o(O00000Oo(), gsj, gsp);
    }

    public static gsn O000000o(gsj gsj, gsl gsl) throws Exception {
        return O000000o(O00000Oo(), gsj, gsl);
    }

    public static gsn O000000o(OkHttpClient okHttpClient, gsj gsj, final gsl gsl) {
        if (okHttpClient != null) {
            Request.Builder builder = new Request.Builder();
            Headers O000000o2 = gss.O000000o(gsj.O00000Oo);
            if (O000000o2 != null) {
                builder.headers(O000000o2);
            }
            if (gsj.O000000o().equals("POST")) {
                builder.url(gsj.f18211O000000o).post(gst.O000000o(gsj));
            } else if (gsj.O000000o().equals("GET")) {
                builder.url(gst.O000000o(gsj.f18211O000000o, gsj.O00000o0));
            } else {
                throw new RuntimeException("method unsupported");
            }
            Call newCall = okHttpClient.newCall(builder.build());
            newCall.enqueue(new Callback() {
                /* class _m_j.gsg.AnonymousClass1 */

                public final void onFailure(Call call, IOException iOException) {
                    gsl gsl = gsl;
                    if (gsl != null) {
                        gsl.processFailure(call, iOException);
                    }
                }

                public final void onResponse(Call call, Response response) throws IOException {
                    gsl gsl = gsl;
                    if (gsl != null) {
                        gsl.processResponse(response);
                    }
                    if (response.body() != null) {
                        response.close();
                    }
                }
            });
            return new gsn(newCall);
        }
        throw new RuntimeException("client is null");
    }

    public static gsn O00000Oo(gsj gsj, final gsl gsl) {
        Request.Builder builder = new Request.Builder();
        Headers O000000o2 = gss.O000000o(gsj.O00000Oo);
        if (O000000o2 != null) {
            builder.headers(O000000o2);
        }
        if (gsj.O000000o().equals("POST")) {
            builder.url(gsj.f18211O000000o).post(gst.O000000o(gsj));
        } else if (gsj.O000000o().equals("GET")) {
            builder.url(gst.O000000o(gsj.f18211O000000o, gsj.O00000o0));
        } else {
            throw new RuntimeException("method unsupported");
        }
        Call newCall = O00000Oo().newCall(builder.build());
        newCall.enqueue(new Callback() {
            /* class _m_j.gsg.AnonymousClass2 */

            public final void onFailure(Call call, IOException iOException) {
                gsl gsl = gsl;
                if (gsl != null) {
                    gsl.processFailure(call, iOException);
                }
            }

            public final void onResponse(Call call, Response response) throws IOException {
                gsl gsl = gsl;
                if (gsl != null) {
                    gsl.processResponse(response);
                }
                if (response.body() != null) {
                    response.close();
                }
            }
        });
        return new gsn(newCall);
    }

    @Deprecated
    public static <R> R O000000o(OkHttpClient okHttpClient, gsk gsk, gsp gsp) throws Exception {
        if (okHttpClient != null) {
            Request.Builder builder = new Request.Builder();
            Headers O000000o2 = gss.O000000o(gsk.O00000Oo);
            if (O000000o2 != null) {
                builder.headers(O000000o2);
            }
            if (gsk.O000000o().equals("POST")) {
                builder.url(gsk.f18213O000000o).post(gsu.O000000o(gsk.O00000o0));
            } else if (gsk.O000000o().equals("GET")) {
                builder.url(gsu.O000000o(gsk.f18213O000000o, gsk.O00000o0));
            } else {
                throw new RuntimeException("method unsupported");
            }
            try {
                Response execute = okHttpClient.newCall(builder.build()).execute();
                R O000000o3 = gsp.O000000o(execute);
                if (!(execute == null || execute.body() == null)) {
                    execute.close();
                }
                return O000000o3;
            } catch (IOException e) {
                throw new RuntimeException("failure:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("client is null");
        }
    }

    @Deprecated
    public static gsn O000000o(OkHttpClient okHttpClient, gsk gsk, final gsl gsl) {
        if (okHttpClient != null) {
            Request.Builder builder = new Request.Builder();
            Headers O000000o2 = gss.O000000o(gsk.O00000Oo);
            if (O000000o2 != null) {
                builder.headers(O000000o2);
            }
            if (gsk.O000000o().equals("POST")) {
                builder.url(gsk.f18213O000000o).post(gsu.O000000o(gsk.O00000o0));
            } else if (gsk.O000000o().equals("GET")) {
                builder.url(gsu.O000000o(gsk.f18213O000000o, gsk.O00000o0));
            } else {
                throw new RuntimeException("method unsupported");
            }
            Call newCall = okHttpClient.newCall(builder.build());
            newCall.enqueue(new Callback() {
                /* class _m_j.gsg.AnonymousClass3 */

                public final void onFailure(Call call, IOException iOException) {
                    gsl gsl = gsl;
                    if (gsl != null) {
                        gsl.processFailure(call, iOException);
                    }
                }

                public final void onResponse(Call call, Response response) throws IOException {
                    gsl gsl = gsl;
                    if (gsl != null) {
                        gsl.processResponse(response);
                    }
                    if (response.body() != null) {
                        response.close();
                    }
                }
            });
            return new gsn(newCall);
        }
        throw new RuntimeException("client is null");
    }

    private static OkHttpClient O00000Oo() {
        if (f18206O000000o == null) {
            synchronized (gsg.class) {
                if (f18206O000000o == null) {
                    f18206O000000o = gse.O000000o();
                    O00000Oo = gse.O00000o0;
                    fcn.O000000o().O0000o0();
                }
            }
        }
        return f18206O000000o;
    }

    public static CookieManager O000000o() {
        O00000Oo();
        return O00000Oo;
    }
}

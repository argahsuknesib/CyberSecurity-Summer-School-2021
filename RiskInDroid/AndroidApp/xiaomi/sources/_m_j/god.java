package _m_j;

import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;

public final class god {

    /* renamed from: O000000o  reason: collision with root package name */
    private static OkHttpClient f18081O000000o = gse.O000000o();

    public interface O000000o<T> {
        T O000000o(String str) throws JSONException;
    }

    public static <T> void O000000o(String str, String str2, List<gkw> list, final Callback<T> callback, final Parser<T> parser) {
        Request request;
        final AnonymousClass2 r0 = new O000000o<T>() {
            /* class _m_j.god.AnonymousClass2 */

            public final T O000000o(String str) throws JSONException {
                Parser parser = parser;
                if (parser != null) {
                    return parser.parse(str);
                }
                return null;
            }
        };
        final AnonymousClass3 r5 = new fsm<T, fso>() {
            /* class _m_j.god.AnonymousClass3 */

            public final void onSuccess(T t) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(t);
                }
            }

            public final void onFailure(fso fso) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(fso.f17063O000000o, "");
                }
            }
        };
        if (str2.equals("POST")) {
            request = new Request.Builder().url(str).post(gsu.O000000o(list)).build();
        } else {
            request = new Request.Builder().url(gsu.O000000o(str, list)).build();
        }
        f18081O000000o.newCall(request).enqueue(new okhttp3.Callback() {
            /* class _m_j.god.AnonymousClass1 */

            public final void onFailure(Call call, IOException iOException) {
                String str;
                fsm fsm = r5;
                if (fsm != null) {
                    int code = ErrorCode.INVALID.getCode();
                    if (iOException == null) {
                        str = "request failure";
                    } else {
                        str = iOException.getMessage();
                    }
                    fsm.sendFailureMessage(new fso(code, str));
                }
            }

            public final void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String string = response.body().string();
                        Object obj = null;
                        if (r0 != null) {
                            obj = r0.O000000o(string);
                        }
                        if (r5 != null) {
                            r5.sendSuccessMessage(obj);
                        }
                    } catch (Exception e) {
                        fsm fsm = r5;
                        if (fsm != null) {
                            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
                        }
                    }
                } else {
                    fsm fsm2 = r5;
                    if (fsm2 != null) {
                        fsm2.sendFailureMessage(new fso(response.code(), "request failure"));
                    }
                }
            }
        });
    }
}

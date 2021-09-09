package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import org.json.JSONException;
import org.json.JSONObject;

public final class hpo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Handler f475O000000o = new Handler(Looper.getMainLooper());

    public static <T> void O000000o(hpk hpk, Callback<T> callback, Parser<T> parser) {
        String str;
        int i = hpk.f468O000000o;
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hpk.O00000Oo);
            sb.append(":");
            sb.append(hpk.O000000o());
            sb.append(":");
            if (hpk.O0000OOo == null) {
                str = hpk.O0000OoO;
            } else {
                str = hpk.O0000OOo.getDid();
            }
            sb.append(str);
            gsy.O00000Oo("lumiscene", sb.toString());
            XmPluginHostApi.instance().callSmartHomeApi(hpk.O000000o(), hpk.O00000Oo, hpk.O0000O0o, O000000o(callback), O000000o(parser));
        } else if (i != 1) {
            callback.onFailure(-1, "request type not found");
        } else {
            gsy.O00000Oo("lumiscene", hpk.O00000o0 + ":" + hpk.O000000o() + ":" + hpk.O0000Oo0);
            if (hpk.O00000oo != null) {
                XmPluginHostApi.instance().callMethod(hpk.O0000Oo0, hpk.O00000o0, hpk.O00000oo, O000000o(callback), O000000o(parser));
                return;
            }
            if (hpk.O00000oO != null) {
                gsy.O00000Oo("lumiscene", hpk.O00000oO.toString());
            }
            XmPluginHostApi.instance().callMethod(hpk.O0000Oo0, hpk.O00000o0, hpk.O00000oO, O000000o(callback), O000000o(parser));
        }
    }

    private static <T> Callback<T> O000000o(final Callback<T> callback) {
        if (callback == null) {
            return null;
        }
        return new Callback<T>() {
            /* class _m_j.hpo.AnonymousClass1 */

            public final void onSuccess(T t) {
                hpo.f475O000000o.post(new Runnable(t) {
                    /* class _m_j.$$Lambda$hpo$1$C4wvRvuCd3WIeyzIzpdl_zPcucI */
                    private final /* synthetic */ Object f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        Callback.this.onSuccess(this.f$1);
                    }
                });
            }

            public final void onFailure(int i, String str) {
                hpo.f475O000000o.post(new Runnable(i, str) {
                    /* class _m_j.$$Lambda$hpo$1$mxjSkmF3LdweQ5OrLKbPl6XhUuo */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        Callback.this.onFailure(this.f$1, this.f$2);
                    }
                });
            }
        };
    }

    private static <T> Parser<T> O000000o(Parser<T> parser) {
        if (parser == null) {
            return null;
        }
        return new Parser() {
            /* class _m_j.$$Lambda$hpo$oxQMOtchLwOWrk3nLqXhAxlm2FU */

            public final Object parse(String str) {
                return hpo.O000000o(Parser.this, str);
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object O000000o(Parser parser, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            if (parser != null) {
                return parser.parse(str);
            }
            return null;
        } else if (str.contains("\"result\":")) {
            String optString = new JSONObject(str).optString("result", null);
            if (parser != null) {
                return optString != null ? parser.parse(optString) : parser.parse(str);
            }
            return null;
        } else if (parser != null) {
            return parser.parse(str);
        } else {
            return null;
        }
    }
}

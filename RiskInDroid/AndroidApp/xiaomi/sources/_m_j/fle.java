package _m_j;

import _m_j.wc;
import android.content.Context;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fle {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f16572O000000o = new Object();
    private static volatile fle O00000Oo;

    private fle() {
    }

    public static fle O000000o() {
        if (O00000Oo == null) {
            synchronized (f16572O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fle();
                }
            }
        }
        return O00000Oo;
    }

    public final fdf O000000o(Context context, JSONArray jSONArray, final fde<flf, fdg> fde) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", "v2");
            jSONObject.put("cid", wb.O000000o(context));
            jSONObject.put("msid", wc.O000000o.O000000o());
            grr.O000000o();
            jSONObject.put("mc", grr.O00000oO(context));
            grr.O000000o();
            jSONObject.put("av", grr.O00000Oo(context));
            StringBuilder sb = new StringBuilder();
            grr.O000000o();
            sb.append(grr.O0000O0o());
            sb.append("-");
            grr.O000000o();
            sb.append(grr.O0000Oo0());
            sb.append("-");
            grr.O000000o();
            sb.append(grr.O0000o00());
            jSONObject.put("ov", sb.toString());
            grr.O000000o();
            jSONObject.put("md", grr.O0000Ooo());
            grr.O000000o();
            jSONObject.put("am", grr.O0000o0());
            jSONObject.put("ch", gfr.O0000o0O);
            jSONObject.put("rd", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/stat/stat_info_p").O000000o(arrayList).O000000o();
        final AnonymousClass1 r7 = new fdv<flf>() {
            /* class _m_j.fle.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                flf flf = new flf();
                flf.f16579O000000o = jSONObject.optInt("interval");
                flf.O00000Oo = jSONObject.optInt("max_number");
                return flf;
            }
        };
        return new fdf(fdt.O000000o().O000000o(O000000o2, new fdh<NetResult, NetError>() {
            /* class _m_j.fle.AnonymousClass2 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                fde.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                fdw.O000000o().O000000o((NetResult) obj, r7, fde);
            }
        }));
    }

    public final fdf O000000o(Context context, String str, final fde<flf, fdg> fde) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", "v3");
            jSONObject.put("cid", wb.O000000o(context));
            jSONObject.put("msid", wc.O000000o.O000000o());
            grr.O000000o();
            jSONObject.put("mc", grr.O00000oO(context));
            grr.O000000o();
            jSONObject.put("av", grr.O00000Oo(context));
            StringBuilder sb = new StringBuilder();
            grr.O000000o();
            sb.append(grr.O0000O0o());
            sb.append("-");
            grr.O000000o();
            sb.append(grr.O0000Oo0());
            sb.append("-");
            grr.O000000o();
            sb.append(grr.O0000o00());
            jSONObject.put("ov", sb.toString());
            grr.O000000o();
            jSONObject.put("md", grr.O0000Ooo());
            grr.O000000o();
            jSONObject.put("am", grr.O0000o0());
            jSONObject.put("ch", gfr.O0000o0O);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        int lastIndexOf = jSONObject2.lastIndexOf(125);
        String str2 = jSONObject2.substring(0, lastIndexOf) + ",\"rd\":[" + str + "]}";
        hye.O000000o("STAT-UPLOAD", str2);
        arrayList.add(new KeyValuePair("data", str2));
        boolean O0000OOo = fcn.O000000o().O0000OOo();
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo(O0000OOo ? "/v2/statv2/stat_info" : "/stat/stat_info").O000000o(arrayList).O000000o();
        final AnonymousClass3 r0 = new fdv<flf>() {
            /* class _m_j.fle.AnonymousClass3 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                flf flf = new flf();
                flf.f16579O000000o = jSONObject.optInt("interval");
                flf.O00000Oo = jSONObject.optInt("max_number");
                return flf;
            }
        };
        AnonymousClass4 r1 = new fdh<NetResult, NetError>() {
            /* class _m_j.fle.AnonymousClass4 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                fde.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                fdw.O000000o().O000000o((NetResult) obj, r0, fde);
            }
        };
        if (O0000OOo) {
            return new fdf(fdt.O000000o().O000000o(O000000o2, r1));
        }
        return new fdf(fdq.O000000o().O000000o(O000000o2, r1));
    }

    public final fdf O00000Oo(Context context, JSONArray jSONArray, final fde<flf, fdg> fde) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", "v2");
            jSONObject.put("cid", wb.O000000o(context));
            jSONObject.put("msid", wc.O000000o.O000000o());
            grr.O000000o();
            jSONObject.put("mc", grr.O00000oO(context));
            grr.O000000o();
            jSONObject.put("av", grr.O00000Oo(context));
            StringBuilder sb = new StringBuilder();
            grr.O000000o();
            sb.append(grr.O0000O0o());
            sb.append("-");
            grr.O000000o();
            sb.append(grr.O0000Oo0());
            sb.append("-");
            grr.O000000o();
            sb.append(grr.O0000o00());
            jSONObject.put("ov", sb.toString());
            grr.O000000o();
            jSONObject.put("md", grr.O0000Ooo());
            grr.O000000o();
            jSONObject.put("am", grr.O0000o0());
            jSONObject.put("ch", gfr.O0000o0O);
            jSONObject.put("rd", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        boolean O0000OOo = fcn.O000000o().O0000OOo();
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo(O0000OOo ? "/v2/statv2/stat_info" : "/stat/stat_info").O000000o(arrayList).O000000o();
        final AnonymousClass5 r0 = new fdv<flf>() {
            /* class _m_j.fle.AnonymousClass5 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                flf flf = new flf();
                flf.f16579O000000o = jSONObject.optInt("interval");
                flf.O00000Oo = jSONObject.optInt("max_number");
                return flf;
            }
        };
        AnonymousClass6 r1 = new fdh<NetResult, NetError>() {
            /* class _m_j.fle.AnonymousClass6 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                fde.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                fdw.O000000o().O000000o((NetResult) obj, r0, fde);
            }
        };
        if (O0000OOo) {
            return new fdf(fdt.O000000o().O000000o(O000000o2, r1));
        }
        return new fdf(fdq.O000000o().O000000o(O000000o2, r1));
    }
}

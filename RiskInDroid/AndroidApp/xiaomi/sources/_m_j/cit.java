package _m_j;

import com.mijia.camera.nas.NASInfo;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cit {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13917O000000o = -30001;
    public static int O00000Oo = -30002;
    public NASInfo O00000o = null;
    public dty O00000o0;

    public cit(dty dty) {
        this.O00000o0 = dty;
    }

    public final void O000000o(final ciu ciu, final Callback<List<ciu>> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            ciu.O00000o.O0000O0o = ciu.f13927O000000o;
            jSONObject.put("share", ciu.O00000o.O00000Oo());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.O00000o0.callMethod("nas_list_dir", jSONObject, new Callback<List<ciu>>() {
            /* class _m_j.cit.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(list);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, new Parser<List<ciu>>() {
            /* class _m_j.cit.AnonymousClass4 */

            public final /* synthetic */ Object parse(String str) throws JSONException {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("result")) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                ArrayList<ciu> arrayList = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(new ciu(ciu, optJSONArray.optString(i)));
                }
                ciu.O00000o0 = arrayList;
                return arrayList;
            }
        });
    }

    public final void O000000o(final Callback<NASInfo> callback) {
        this.O00000o0.callMethod("nas_get_config", new JSONObject(), new Callback<NASInfo>() {
            /* class _m_j.cit.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                NASInfo nASInfo = (NASInfo) obj;
                cit.this.O00000o = nASInfo;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(nASInfo);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, new Parser<NASInfo>() {
            /* class _m_j.cit.AnonymousClass6 */

            public final /* synthetic */ Object parse(String str) throws JSONException {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("result")) {
                    jSONObject = jSONObject.getJSONObject("result");
                }
                return NASInfo.O000000o(jSONObject);
            }
        });
    }

    public final void O000000o(NASInfo nASInfo, final Callback<Object> callback) {
        this.O00000o0.callMethod("nas_set_config", nASInfo.O00000Oo(), new Callback<JSONObject>() {
            /* class _m_j.cit.AnonymousClass7 */

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000Oo(final Callback<Object> callback) {
        this.O00000o0.O000000o("nas_clear_dir", new JSONArray(), new Callback<Object>() {
            /* class _m_j.cit.AnonymousClass9 */

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }

            public final void onSuccess(Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }
        });
    }
}

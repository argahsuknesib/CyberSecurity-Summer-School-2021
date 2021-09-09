package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class cll {

    /* renamed from: O000000o  reason: collision with root package name */
    private clm f14072O000000o;
    public HashMap<String, Object> O00000o = new HashMap<>();
    public dty O00000o0;
    public O000000o O00000oO;

    public interface O000000o {
        void onCameraPropertyChanged(String str);
    }

    public abstract List<String> O000000o();

    public abstract List<String> O00000Oo();

    public cll(dty dty) {
        this.O00000o0 = dty;
        this.f14072O000000o = new clm(this.O00000o0);
    }

    public final void O000000o(final String[] strArr, final Callback<Void> callback) {
        if (strArr != null && strArr.length != 0) {
            JSONArray jSONArray = new JSONArray();
            for (String put : strArr) {
                jSONArray.put(put);
            }
            cki.O00000o("CameraProperties", "request params:" + jSONArray.toString());
            this.O00000o0.callMethod("get_prop", jSONArray, new Callback<JSONArray>() {
                /* class _m_j.cll.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONArray jSONArray = (JSONArray) obj;
                    if (jSONArray != null) {
                        civ.O000000o("CameraProperties", " update prop success:".concat(String.valueOf(jSONArray)));
                    }
                    if (jSONArray == null || jSONArray.length() == 0) {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(-1, "");
                            return;
                        }
                        return;
                    }
                    int i = 0;
                    while (i < jSONArray.length() && i < strArr.length) {
                        try {
                            cll.this.O00000o.put(strArr[i], jSONArray.get(i));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                    cll.this.O00000o0.notifyStateChanged();
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onSuccess(null);
                    }
                }

                public final void onFailure(int i, String str) {
                    civ.O000000o("CameraProperties", " update prop fail  ".concat(String.valueOf(str)));
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, new Parser<JSONArray>() {
                /* class _m_j.cll.AnonymousClass3 */

                public final /* synthetic */ Object parse(String str) throws JSONException {
                    return new JSONObject(str).optJSONArray("result");
                }
            });
        }
    }

    public final int O000000o(String str) {
        Object obj = this.O00000o.get(str);
        if (obj == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Integer.valueOf((String) obj).intValue();
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (Exception e) {
            civ.O000000o("SdCard", "getIntProperty", e);
            return 0;
        }
    }

    public final boolean O000000o(String str, boolean z) {
        Object obj = this.O00000o.get(str);
        if (obj == null) {
            return z;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if ("on".equals(obj)) {
            return true;
        }
        if ("off".equals(obj)) {
            return false;
        }
        return z;
    }

    public final String O00000o0() {
        Object obj = this.O00000o.get("motion_record");
        return obj instanceof String ? (String) obj : "";
    }

    public final boolean O00000o() {
        return O000000o("max_client") == 1;
    }

    public final void O000000o(String str, boolean z, Callback<Void> callback) {
        if (this.O00000oO != null && !TextUtils.isEmpty(str)) {
            this.O00000oO.onCameraPropertyChanged(str);
        }
        O000000o(str, z ? "on" : "off", callback);
    }

    public final void O000000o(String str, Object obj) {
        this.O00000o.put(str, obj);
    }

    public final void O000000o(final String str, final Object obj, final Callback<Void> callback) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(obj);
        this.O00000o0.callMethod("set_".concat(String.valueOf(str)), jSONArray, new Callback<JSONObject>() {
            /* class _m_j.cll.AnonymousClass4 */

            public final void onFailure(int i, String str) {
                civ.O00000o("CameraProperties", "set_" + str + "  fail " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                civ.O00000o0("CameraProperties", "set_" + str + "  success");
                cll.this.O000000o(str, obj);
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000Oo(String str, Object obj) {
        this.O00000o.put(str, obj);
    }
}

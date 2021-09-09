package _m_j;

import android.text.TextUtils;
import com.mijia.model.sdcard.SDCardInfo;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.camera.P2pResponse;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class clr extends cln {
    public SDCardInfo O0000OOo;
    public HashMap<String, Integer> O0000Oo = new HashMap<>();
    public cid O0000Oo0;

    public final String O00000oO() {
        return "com.mijia.camera.SdcardManager";
    }

    public clr(cid cid) {
        super(cid);
        this.O0000Oo0 = cid;
    }

    public final void O000000o() {
        this.O00000oO.removeMessages(1);
        this.O00000oO.removeMessages(2);
        this.O00000o0 = 40000;
        this.O00000Oo = false;
        this.O00000oO.sendEmptyMessageDelayed(1, 0);
    }

    public final synchronized List<clu> O0000OOo() {
        List<clu> O000000o2;
        O000000o2 = clu.O000000o(this.O0000O0o, this.O0000Oo0.getModel());
        this.O0000Oo.clear();
        if (O000000o2.size() > 0) {
            for (int i = 0; i < O000000o2.size(); i++) {
                this.O0000Oo.put(O000000o2.get(i).O00000oO, Integer.valueOf(i));
            }
        }
        return O000000o2;
    }

    public final synchronized int O000000o(String str) {
        Integer num = this.O0000Oo.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final synchronized void O000000o(List<TimeItem> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TimeItem timeItem = list.get(size);
                int size2 = this.O0000O0o.size() - 1;
                while (true) {
                    if (size2 < 0) {
                        break;
                    } else if (timeItem.equals(this.O0000O0o.get(size2))) {
                        gsy.O000000o(3, "deleteTime", "delete " + timeItem.f5243O000000o);
                        this.O0000O0o.remove(size2);
                        break;
                    } else {
                        size2--;
                    }
                }
            }
            this.O00000oO.post(new Runnable() {
                /* class _m_j.clr.AnonymousClass1 */

                public final void run() {
                    clr.this.O00000o0();
                }
            });
        }
    }

    public final synchronized void O00000Oo(List<TimeItem> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size).O00000oO = 1;
            }
            this.O00000oO.post(new Runnable() {
                /* class _m_j.clr.AnonymousClass2 */

                public final void run() {
                    clr.this.O00000o0();
                }
            });
        }
    }

    public final synchronized List<TimeItem> O00000oo() {
        return this.O0000O0o;
    }

    public final void O000000o(final Callback<SDCardInfo> callback, boolean z) {
        SDCardInfo sDCardInfo = this.O0000OOo;
        if (sDCardInfo != null && !z) {
            callback.onSuccess(sDCardInfo);
        }
        this.O00000o.callMethod("sd_storge", new JSONArray(), new Callback<String>() {
            /* class _m_j.clr.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                cki.O00000o0("SdcardManager", "onSuccess sd_storge:".concat(String.valueOf(str)));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!TextUtils.isEmpty(jSONObject.optString("error"))) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                        callback.onFailure(jSONObject2.optInt("code"), jSONObject2.optString("message"));
                        return;
                    }
                    JSONArray jSONArray = jSONObject.getJSONArray("result");
                    long j = 0;
                    long j2 = !jSONArray.isNull(0) ? jSONArray.getLong(0) : 0;
                    long j3 = !jSONArray.isNull(1) ? jSONArray.getLong(1) : 0;
                    if (!jSONArray.isNull(2)) {
                        j = jSONArray.getLong(2);
                    }
                    SDCardInfo sDCardInfo = new SDCardInfo(j2, j3, j, !jSONArray.isNull(3) ? jSONArray.getInt(3) : -1);
                    clr.this.O0000OOo = sDCardInfo;
                    callback.onSuccess(sDCardInfo);
                } catch (JSONException e) {
                    callback.onFailure(-1, e.toString());
                }
            }

            public final void onFailure(int i, String str) {
                cki.O00000o0("SdcardManager", "onFailure sd_storge:" + i + ":" + str);
                if (i == -2003) {
                    clr.this.O0000OOo = null;
                }
                callback.onFailure(i, str);
            }
        }, new Parser<String>() {
            /* class _m_j.clr.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                return str;
            }
        });
    }

    public final void O00000o0(Callback<Object> callback) {
        this.O00000o.O000000o("sd_format", null, callback);
    }

    public final void O00000o(final Callback<Object> callback) {
        this.O00000o.callMethod("sd_umount", new JSONArray(), new Callback<JSONObject>() {
            /* class _m_j.clr.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str;
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    callback.onSuccess(null);
                } else if (TextUtils.isEmpty(jSONObject.optString("error"))) {
                    callback.onSuccess(jSONObject);
                } else {
                    int i = -1;
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                        i = jSONObject2.optInt("code");
                        str = jSONObject2.optString("message");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        str = "";
                    }
                    callback.onFailure(i, str);
                }
            }

            public final void onFailure(int i, String str) {
                callback.onFailure(i, str);
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(final Callback<Void> callback) {
        cki.O00000o0("SdcardManager", "updateHistoryTime");
        if (this.O00000o.O0000ooo() == null) {
            O000000o(-1, "SdcardManager updateTime");
            if (callback != null) {
                callback.onFailure(-1, "");
                return;
            }
            return;
        }
        final ArrayList arrayList = new ArrayList();
        this.O00000o.O0000ooo().sendMsg(6, 6, null, new P2pResponse() {
            /* class _m_j.clr.AnonymousClass3 */

            public final void onResponse(int i, byte[] bArr) {
                List list = arrayList;
                if (bArr != null) {
                    for (int i2 = 0; i2 < bArr.length; i2 += TimeItem.O000000o()) {
                        TimeItem O000000o2 = TimeItem.O000000o(bArr, i2, chp.O000000o());
                        if (O000000o2.f5243O000000o != 0 && O000000o2.f5243O000000o <= O000000o2.O00000o0) {
                            list.add(O000000o2);
                        }
                    }
                }
                if (i == 0) {
                    cki.O00000o0("SdcardManager", "update save updateRecordTime onSuccess");
                    Collections.sort(arrayList, new clt());
                    clr clr = clr.this;
                    clr.O0000O0o = arrayList;
                    clr.O00000o();
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(null);
                    }
                }
            }

            public final void onError(int i) {
                cki.O00000o0("SdcardManager", "update save updateRecordTime onResult:".concat(String.valueOf(i)));
                clr.this.O000000o(i, "SdcardManager onError:".concat(String.valueOf(i)));
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(-1, "");
                }
            }
        });
    }
}

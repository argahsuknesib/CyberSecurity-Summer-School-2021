package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fjp {

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, Object> f16484O000000o = new ConcurrentHashMap();
    public Map<String, String> O00000Oo = new ConcurrentHashMap();
    public long O00000o = 0;
    public fjo<String> O00000o0;

    public final void O000000o(List<BatchRpcParam> list) {
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                BatchRpcParam batchRpcParam = list.get(i);
                final Device O000000o2 = fjd.O000000o().O000000o(batchRpcParam.f6888O000000o);
                if (O000000o2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("method", batchRpcParam.O00000Oo);
                        jSONObject.put("params", batchRpcParam.O00000o0);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    fjh.O000000o().O000000o(O000000o2.getLocalIP(), O000000o2.getDid(), O000000o2.getToken(), jSONObject.toString(), new fjo<String>() {
                        /* class _m_j.fjp.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            gsy.O000000o(3, "BatchRpcApi", "rpcAsyncRaw response:".concat(String.valueOf(str)));
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.optInt("code", -1) == 0) {
                                    fjp.this.f16484O000000o.put(O000000o2.getDid(), jSONObject.opt("result"));
                                } else {
                                    fjp.this.f16484O000000o.put(O000000o2.getDid(), Boolean.FALSE);
                                }
                            } catch (Exception e) {
                                fjp.this.f16484O000000o.put(O000000o2.getDid(), Boolean.FALSE);
                                e.printStackTrace();
                            }
                            fjp.this.O00000Oo.remove(O000000o2.getDid());
                            fjp.this.O000000o();
                        }

                        public final void O000000o(int i) {
                            gsy.O000000o(6, "BatchRpcApi", "local rpc response:".concat(String.valueOf(i)));
                            fjp.this.f16484O000000o.put(O000000o2.getDid(), Boolean.FALSE);
                            fjp.this.O00000Oo.remove(O000000o2.getDid());
                            fjp.this.O000000o();
                        }

                        public final void O000000o(int i, Object obj) {
                            StringBuilder sb = new StringBuilder("local rpc response:");
                            sb.append(i);
                            sb.append(", msg=");
                            sb.append(obj == null ? "" : obj.toString());
                            gsy.O000000o(6, "BatchRpcApi", sb.toString());
                            fjp.this.f16484O000000o.put(O000000o2.getDid(), Boolean.FALSE);
                            fjp.this.O00000Oo.remove(O000000o2.getDid());
                            fjp.this.O000000o();
                        }
                    });
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        return;
     */
    public final void O000000o() {
        synchronized (this) {
            if (this.O00000Oo.isEmpty()) {
                if (this.O00000o0 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis() - this.O00000o);
                    gsy.O000000o(3, "BatchRpcApi", sb.toString());
                    this.O00000o0.O000000o(O00000Oo());
                    this.O00000o0 = null;
                }
            }
        }
    }

    private String O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", ErrorCode.SUCCESS);
            JSONObject jSONObject2 = new JSONObject();
            for (String next : this.f16484O000000o.keySet()) {
                jSONObject2.put(next, this.f16484O000000o.get(next));
            }
            jSONObject.put("result", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String O00000Oo(List<BatchRpcParam> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            BatchRpcParam batchRpcParam = list.get(i);
            if (batchRpcParam != null && !TextUtils.isEmpty(batchRpcParam.f6888O000000o)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("did", batchRpcParam.f6888O000000o);
                    jSONObject.put("method", batchRpcParam.O00000Oo);
                    jSONObject.put("params", batchRpcParam.O00000o0);
                    if (!TextUtils.isEmpty(batchRpcParam.O00000o)) {
                        jSONObject.put("sid", batchRpcParam.O00000o);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("rpcs", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject2.toString();
    }

    public final void O000000o(List<BatchRpcParam> list, String str) {
        JSONArray optJSONArray;
        int optInt;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            if (!jSONObject.isNull("result") && (optJSONArray = jSONObject.optJSONArray("result")) != null) {
                HashSet hashSet = new HashSet();
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (!(optJSONObject == null || (optInt = optJSONObject.optInt("index", -1)) == -1 || optInt >= list.size())) {
                        String str2 = list.get(optInt).f6888O000000o;
                        this.f16484O000000o.put(str2, optJSONObject.opt("result"));
                        this.O00000Oo.remove(str2);
                        hashSet.add(str2);
                    }
                    i++;
                }
                for (BatchRpcParam next : list) {
                    if (!hashSet.contains(next.f6888O000000o)) {
                        this.f16484O000000o.put(next.f6888O000000o, "false");
                        this.O00000Oo.remove(next.f6888O000000o);
                    }
                }
                i = 1;
            }
            if (i == 0) {
                for (BatchRpcParam next2 : list) {
                    this.f16484O000000o.put(next2.f6888O000000o, "true");
                    this.O00000Oo.remove(next2.f6888O000000o);
                }
            }
        } catch (JSONException e) {
            gsy.O000000o(6, "BatchRpcApi", "batchrpc response:".concat(String.valueOf(str)));
            e.printStackTrace();
            for (BatchRpcParam next3 : list) {
                this.f16484O000000o.put(next3.f6888O000000o, "true");
                this.O00000Oo.remove(next3.f6888O000000o);
            }
        }
        O000000o();
    }
}

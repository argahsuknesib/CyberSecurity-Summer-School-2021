package _m_j;

import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.account.AccountType;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fjq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f16487O000000o = new Object();
    private static volatile fjq O00000Oo;

    private fjq() {
    }

    public static fjq O000000o() {
        if (O00000Oo == null) {
            synchronized (f16487O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fjq();
                }
            }
        }
        return O00000Oo;
    }

    public final fjc O000000o(String str, String str2, final fjo<String> fjo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str2));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/rpc/".concat(String.valueOf(str))).O000000o(arrayList).O000000o();
        if (fdk.O000000o().O00000o0() == AccountType.MI) {
            return new fjc(fdt.O000000o().O000000o(O000000o2, new fdh<NetResult, NetError>() {
                /* class _m_j.fjq.AnonymousClass2 */

                public final /* synthetic */ void onFailure(Error error) {
                    NetError netError = (NetError) error;
                    fjo fjo = fjo;
                    if (fjo != null) {
                        fjo.O000000o(netError.f6718O000000o, netError.O00000Oo);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    NetResult netResult = (NetResult) obj;
                    fjo fjo = fjo;
                    if (fjo != null) {
                        fjo.O000000o(netResult.O00000o0);
                    }
                }
            }));
        }
        fjo.O000000o(-9999, "Account type not supported!");
        return null;
    }

    public final fjc O00000Oo(String str, String str2, final fjo<String> fjo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str2));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/rpcv2/".concat(String.valueOf(str))).O000000o(arrayList).O000000o();
        if (fdk.O000000o().O00000o0() == AccountType.MI) {
            return new fjc(fdt.O000000o().O000000o(O000000o2, new fdh<NetResult, NetError>() {
                /* class _m_j.fjq.AnonymousClass3 */

                public final /* synthetic */ void onFailure(Error error) {
                    NetError netError = (NetError) error;
                    fjo fjo = fjo;
                    if (fjo != null) {
                        fjo.O000000o(netError.f6718O000000o, netError.O00000Oo);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    NetResult netResult = (NetResult) obj;
                    fjo fjo = fjo;
                    if (fjo != null) {
                        fjo.O000000o(netResult.O00000o0);
                    }
                }
            }));
        }
        fjo.O000000o(-9999, "Account type not supported!");
        return null;
    }

    public static fdi O000000o(String str, String str2, fdh<NetResult, NetError> fdh) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("newName", str2);
            jSONObject.put("did", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/rename").O000000o(arrayList).O000000o();
        if (fdk.O000000o().O00000o0() == AccountType.MI) {
            return fdt.O000000o().O000000o(O000000o2, fdh);
        }
        fdh.onFailure(new NetError(-9999, "account type not supported!"));
        return null;
    }

    public static fdi O000000o(JSONArray jSONArray, fdh<NetResult, NetError> fdh) {
        if (jSONArray.length() <= 0) {
            fdh.onFailure(new NetError(-9999, "list empty"));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devList", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/del_owner_device_batch").O000000o(arrayList).O000000o();
        if (fdk.O000000o().O00000o0() == AccountType.MI) {
            return fdt.O000000o().O000000o(O000000o2, fdh);
        }
        fdh.onFailure(new NetError(-9999, "account type not supported!"));
        return null;
    }

    public static fdi O000000o(List<String> list, fdh<ArrayList<Device>, NetError> fdh) {
        if (list == null || list.isEmpty()) {
            fdh.onFailure(new NetError(-9999, "list empty"));
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dids", jSONArray);
            if (fdk.O000000o().O00000o0() == AccountType.MI) {
                return new fjr().O000000o(jSONObject, fdh);
            }
            fdh.onFailure(new NetError(-9999, "account type not supported!"));
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            fdh.onFailure(new NetError(-9999, "param exception"));
            return null;
        }
    }

    public static fdi O000000o(Device device, int i, fdh<NetResult, NetError> fdh) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("did", device.getDid());
            jSONObject2.put("pid", device.getPid());
            jSONArray.put(jSONObject2);
            jSONObject.put("devList", jSONArray);
            jSONObject.put("errorCode", i);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/batch_unbind").O000000o(arrayList).O000000o();
        if (fdk.O000000o().O00000o0() == AccountType.MI) {
            return fdt.O000000o().O000000o(O000000o2, fdh);
        }
        fdh.onFailure(new NetError(-9999, "account type not supported!"));
        return null;
    }
}

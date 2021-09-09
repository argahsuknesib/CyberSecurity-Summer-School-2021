package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.ggj;
import _m_j.ggv;
import _m_j.iwc;
import _m_j.ixe;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/xiaomi/smarthome/homeroom/device_order/CateOrder;", "orderJson", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceOrderSourceUnion$parseHomeOrder$3 extends Lambda implements iwc<Object, ggj> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceUnion$parseHomeOrder$3 f8973O000000o = new DeviceOrderSourceUnion$parseHomeOrder$3();

    DeviceOrderSourceUnion$parseHomeOrder$3() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        ixe.O00000o(obj, "orderJson");
        JSONObject jSONObject = (JSONObject) obj;
        JSONArray optJSONArray = jSONObject.optJSONArray("did_order");
        ArrayList O000000o2 = optJSONArray == null ? null : ggv.O000000o(optJSONArray, new ArrayList(), DeviceOrderSourceUnion$parseHomeOrder$3$orders$1.f8974O000000o);
        if (O000000o2 == null) {
            O000000o2 = new ArrayList();
        }
        String string = jSONObject.getString("cate_id");
        ixe.O00000Oo(string, "orderJson.getString(\"cate_id\")");
        String optString = jSONObject.optString("parent_id", "");
        ixe.O00000Oo(optString, "orderJson.optString(\"parent_id\", \"\")");
        return new ggj(string, O000000o2, optString);
    }
}

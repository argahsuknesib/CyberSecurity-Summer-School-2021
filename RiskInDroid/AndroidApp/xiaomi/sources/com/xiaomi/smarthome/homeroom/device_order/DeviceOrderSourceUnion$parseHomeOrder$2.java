package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.ggs;
import _m_j.ggv;
import _m_j.iwc;
import _m_j.ixe;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/xiaomi/smarthome/homeroom/device_order/RoomOrder;", "orderJson", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceOrderSourceUnion$parseHomeOrder$2 extends Lambda implements iwc<Object, ggs> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceUnion$parseHomeOrder$2 f8971O000000o = new DeviceOrderSourceUnion$parseHomeOrder$2();

    DeviceOrderSourceUnion$parseHomeOrder$2() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        ixe.O00000o(obj, "orderJson");
        JSONObject jSONObject = (JSONObject) obj;
        JSONArray optJSONArray = jSONObject.optJSONArray("did_order");
        ArrayList O000000o2 = optJSONArray == null ? null : ggv.O000000o(optJSONArray, new ArrayList(), DeviceOrderSourceUnion$parseHomeOrder$2$orders$1.f8972O000000o);
        if (O000000o2 == null) {
            O000000o2 = new ArrayList();
        }
        String string = jSONObject.getString("room_id");
        ixe.O00000Oo(string, "orderJson.getString(\"room_id\")");
        return new ggs(string, O000000o2);
    }
}

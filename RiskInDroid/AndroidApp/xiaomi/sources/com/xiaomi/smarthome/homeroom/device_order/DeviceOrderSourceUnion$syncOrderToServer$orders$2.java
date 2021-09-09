package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.ggs;
import _m_j.ggv;
import _m_j.iwc;
import _m_j.ixe;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "roomOrder", "Lcom/xiaomi/smarthome/homeroom/device_order/RoomOrder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceOrderSourceUnion$syncOrderToServer$orders$2 extends Lambda implements iwc<ggs, Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceUnion$syncOrderToServer$orders$2 f8978O000000o = new DeviceOrderSourceUnion$syncOrderToServer$orders$2();

    DeviceOrderSourceUnion$syncOrderToServer$orders$2() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        ggs ggs = (ggs) obj;
        ixe.O00000o(ggs, "roomOrder");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", ggs.O000000o());
        jSONObject.put("value", ggv.O000000o(ggs.f17750O000000o, DeviceOrderSourceUnion$syncOrderToServer$orders$2$1$1.f8979O000000o));
        return jSONObject;
    }
}

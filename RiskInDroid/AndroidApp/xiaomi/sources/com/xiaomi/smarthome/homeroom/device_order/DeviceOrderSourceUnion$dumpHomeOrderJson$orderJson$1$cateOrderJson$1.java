package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.ggj;
import _m_j.ggv;
import _m_j.iwc;
import _m_j.ixe;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "cateOrder", "Lcom/xiaomi/smarthome/homeroom/device_order/CateOrder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$cateOrderJson$1 extends Lambda implements iwc<ggj, Object> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$cateOrderJson$1 f8961O000000o = new DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$cateOrderJson$1();

    DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$cateOrderJson$1() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        ggj ggj = (ggj) obj;
        ixe.O00000o(ggj, "cateOrder");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cate_id", ggj.f17741O000000o);
        jSONObject.put("parent_id", ggj.O00000o0);
        jSONObject.put("did", ggv.O000000o(ggj.O00000Oo, DeviceOrderSourceUnion$dumpHomeOrderJson$orderJson$1$cateOrderJson$1$1$1.f8962O000000o));
        return jSONObject;
    }
}

package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.ggl;
import _m_j.ggo;
import _m_j.iwc;
import _m_j.ixe;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/xiaomi/smarthome/homeroom/device_order/HomeOrder;", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceOrderSourceUnion$mParser$1$1 extends Lambda implements iwc<Object, ggo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceUnion$mParser$1$1 f8969O000000o = new DeviceOrderSourceUnion$mParser$1$1();

    DeviceOrderSourceUnion$mParser$1$1() {
        super(1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggl.O000000o(org.json.JSONObject, boolean):_m_j.ggo
     arg types: [org.json.JSONObject, int]
     candidates:
      _m_j.ggl.O000000o(java.util.List<_m_j.ggr$O000000o>, boolean):io.reactivex.Observable<java.util.List<_m_j.ggo>>
      _m_j.ggl.O000000o(boolean, java.util.List):io.reactivex.ObservableSource
      _m_j.ggl.O000000o(java.lang.String, java.util.List):io.reactivex.Single
      _m_j.ggl.O000000o(_m_j.ggr$O000000o, java.lang.Throwable):java.util.ArrayList
      _m_j.ggl.O000000o(org.json.JSONObject, boolean):_m_j.ggo */
    public final /* synthetic */ Object invoke(Object obj) {
        ixe.O00000o(obj, "it");
        ggl ggl = ggl.f17743O000000o;
        return ggl.O000000o((JSONObject) obj, false);
    }
}

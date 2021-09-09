package com.xiaomi.smarthome.homeroom.device_order;

import _m_j.ggk;
import _m_j.ggl;
import _m_j.ggv;
import _m_j.iwb;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceOrderSourceUnion$mHomesListOrder$2 extends Lambda implements iwb<ArrayList<String>> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceOrderSourceUnion$mHomesListOrder$2 f8966O000000o = new DeviceOrderSourceUnion$mHomesListOrder$2();

    DeviceOrderSourceUnion$mHomesListOrder$2() {
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return O000000o();
    }

    private static ArrayList<String> O000000o() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ggl ggl = ggl.f17743O000000o;
            ggv.O000000o(new JSONArray(ggl.O00000o0()), arrayList, AnonymousClass1.f8967O000000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ggk ggk = ggk.f17742O000000o;
        ArrayList<String> O000000o2 = ggk.O000000o();
        return (!arrayList.isEmpty() || O000000o2.isEmpty()) ? arrayList : O000000o2;
    }
}

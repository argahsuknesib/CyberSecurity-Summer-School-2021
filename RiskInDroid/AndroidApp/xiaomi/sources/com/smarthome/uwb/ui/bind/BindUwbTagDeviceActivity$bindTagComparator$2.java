package com.smarthome.uwb.ui.bind;

import _m_j.ivk;
import _m_j.ivl;
import _m_j.iwb;
import _m_j.ixe;
import com.xiaomi.smarthome.device.Device;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n"}, d2 = {"<anonymous>", "Ljava/util/Comparator;", "Lcom/xiaomi/smarthome/device/Device;", "Lkotlin/Comparator;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class BindUwbTagDeviceActivity$bindTagComparator$2 extends Lambda implements iwb<Comparator<Device>> {
    final /* synthetic */ BindUwbTagDeviceActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BindUwbTagDeviceActivity$bindTagComparator$2(BindUwbTagDeviceActivity bindUwbTagDeviceActivity) {
        super(0);
        this.this$0 = bindUwbTagDeviceActivity;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O000000o<T> implements Comparator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ BindUwbTagDeviceActivity f5735O000000o;

        public O000000o(BindUwbTagDeviceActivity bindUwbTagDeviceActivity) {
            this.f5735O000000o = bindUwbTagDeviceActivity;
        }

        public final int compare(T t, T t2) {
            Device device = (Device) t;
            List<String> list = this.f5735O000000o.allAssociateDevId;
            if (list != null) {
                Comparable valueOf = Boolean.valueOf(list.contains(device.did));
                Device device2 = (Device) t2;
                List<String> list2 = this.f5735O000000o.allAssociateDevId;
                if (list2 != null) {
                    return ivk.O000000o(valueOf, Boolean.valueOf(list2.contains(device2.did)));
                }
                ixe.O000000o("allAssociateDevId");
                throw null;
            }
            ixe.O000000o("allAssociateDevId");
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O00000Oo<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((Device) t).did, ((Device) t2).did);
        }
    }

    public final /* synthetic */ Object invoke() {
        Comparator o000000o = new O000000o(this.this$0);
        Comparator o00000Oo = new O00000Oo();
        ixe.O00000o0(o000000o, "receiver$0");
        ixe.O00000o0(o00000Oo, "comparator");
        return new ivl.O000000o(o000000o, o00000Oo);
    }
}

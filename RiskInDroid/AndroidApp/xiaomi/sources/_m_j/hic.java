package _m_j;

import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.newui.RoomDeviceRecycler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MainCameraEntryStatManager;", "Landroidx/lifecycle/ViewModel;", "Lcom/xiaomi/smarthome/newui/IOnPrimaryItemChanged;", "()V", "position", "", "switchIn", "", "logIfNeeded", "", "notifySwitch", "onChanged", "old", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler;", "current", "pos", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hic extends fm implements haa {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18958O000000o = new O000000o((byte) 0);
    public boolean O00000Oo;
    private int O00000o0 = -1;

    public static final hic O000000o(FragmentActivity fragmentActivity) {
        return O000000o.O000000o(fragmentActivity);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MainCameraEntryStatManager$Companion;", "", "()V", "TAG", "", "isCameraEntryShow", "", "()Z", "singletonWith", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MainCameraEntryStatManager;", "activity", "Landroidx/fragment/app/FragmentActivity;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public static hic O000000o(FragmentActivity fragmentActivity) {
            ixe.O00000o(fragmentActivity, "activity");
            fm O000000o2 = fo.O000000o(fragmentActivity).O000000o(hic.class);
            ixe.O00000Oo(O000000o2, "of(activity).get(MainCameraEntryStatManager::class.java)");
            return (hic) O000000o2;
        }

        public static boolean O000000o() {
            hfz hfz = hfz.f18889O000000o;
            return hfz.O00000o() >= 2;
        }
    }

    public final void O000000o(RoomDeviceRecycler roomDeviceRecycler, RoomDeviceRecycler roomDeviceRecycler2, int i) {
        ixe.O00000o(roomDeviceRecycler2, "current");
        if (i != this.O00000o0) {
            this.O00000o0 = i;
            if (i == 0) {
                O000000o();
            }
        }
    }

    public final void O000000o() {
        if (this.O00000o0 == 0 && O000000o.O000000o() && this.O00000Oo) {
            hxi.O00000o0.O000000o();
        }
    }
}

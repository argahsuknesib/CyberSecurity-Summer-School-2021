package _m_j;

import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.newui.RoomDeviceRecycler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\"\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/TabChangeWatcher;", "Landroidx/lifecycle/ViewModel;", "Lcom/xiaomi/smarthome/newui/IOnPrimaryItemChanged;", "()V", "pageIdx", "", "tabIdx", "visibleListeners", "", "Lcom/xiaomi/smarthome/newui/adapter/TabChangeWatcher$OnVisibleChangeListener;", "addVisibleChangeListener", "", "li", "onChanged", "old", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler;", "current", "pos", "onCleared", "onPageSelected", "idx", "removeVisibleChangeListener", "Companion", "OnVisibleChangeListener", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbr extends fm implements haa {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18756O000000o = new O000000o((byte) 0);
    public final List<O00000Oo> O00000Oo = new ArrayList();
    private int O00000o;
    public int O00000o0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\b"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/TabChangeWatcher$OnVisibleChangeListener;", "", "onIndicatorChanged", "", "last", "", "cur", "onTabChanged", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O00000Oo {
        void O000000o(int i);

        void O000000o(Object obj);
    }

    public static final hbr O000000o(FragmentActivity fragmentActivity) {
        return O000000o.O000000o(fragmentActivity);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/TabChangeWatcher$Companion;", "", "()V", "TAG", "", "singletonWith", "Lcom/xiaomi/smarthome/newui/adapter/TabChangeWatcher;", "activity", "Landroidx/fragment/app/FragmentActivity;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }

        public static hbr O000000o(FragmentActivity fragmentActivity) {
            ixe.O00000o(fragmentActivity, "activity");
            fm O000000o2 = fo.O000000o(fragmentActivity).O000000o(hbr.class);
            ixe.O00000Oo(O000000o2, "of(activity).get(TabChangeWatcher::class.java)");
            return (hbr) O000000o2;
        }
    }

    public final void O000000o(RoomDeviceRecycler roomDeviceRecycler, RoomDeviceRecycler roomDeviceRecycler2, int i) {
        ixe.O00000o(roomDeviceRecycler2, "current");
        if (i != this.O00000o) {
            for (O00000Oo O000000o2 : this.O00000Oo) {
                O000000o2.O000000o(i);
            }
            this.O00000o = i;
        }
    }

    public final void onCleared() {
        super.onCleared();
        this.O00000Oo.clear();
    }
}

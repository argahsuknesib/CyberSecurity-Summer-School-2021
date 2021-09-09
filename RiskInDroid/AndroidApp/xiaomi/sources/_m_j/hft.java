package _m_j;

import _m_j.gp;
import _m_j.gs;
import _m_j.hfr;
import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.AllDeviceActivity;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class hft extends haw implements hfr.O000000o.C0115O000000o, DviceEditInterface {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<MainPageDeviceModel> f18871O000000o = new ArrayList();
    public WeakReference<gzr> O00000Oo = null;
    private PageBean O0000Oo;
    private gs O0000Oo0;
    private int O0000OoO = hha.O000000o().O00000Oo;
    private hfr.O000000o O0000Ooo = new hfr.O000000o(this);
    private boolean O0000o = false;
    private int O0000o0 = 0;
    private final List<String> O0000o00 = new LinkedList();
    private boolean O0000o0O = false;
    private boolean O0000o0o = false;
    private boolean O0000oO0 = false;

    public final void O000000o(PageBean pageBean, List<MainPageDeviceModel> list) {
        int i;
        if (!this.O0000o0O && !this.O00000o) {
            this.O0000Oo = pageBean;
            if ("mijia.roomid.all".equals(pageBean.O00000Oo)) {
                i = 0;
            } else if ("mijia.roomid.share".equals(pageBean.O00000Oo)) {
                i = 1;
            } else if ("mijia.roomid.nearby".equals(pageBean.O00000Oo)) {
                i = 2;
            } else if ("mijia.roomid.default".equals(pageBean.O00000Oo)) {
                i = 5;
            } else if ("mijia.roomid.common".equals(pageBean.O00000Oo)) {
                i = 6;
            } else if ("mijia.roomid.uncommon".equals(pageBean.O00000Oo)) {
                i = 7;
            } else {
                i = pageBean.O00000o0 ? 3 : 4;
            }
            this.O0000o0 = i;
            LogType logType = LogType.MAIN_PAGE;
            gsy.O00000Oo(logType, "MVI-DeviceGridAdapterV3", "update in " + list.size());
            gp.O00000Oo O000000o2 = gp.O000000o(new hfr(this.f18871O000000o, list, this.O0000Ooo));
            this.f18871O000000o.clear();
            this.f18871O000000o.addAll(list);
            O000000o2.O000000o(this);
        }
    }

    public final int O000000o() {
        return this.O0000OoO;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new hfu(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_main_grid_v3, viewGroup, false), this, this.O0000Oo0);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ((hfu) o000OOo0).O000000o(this.f18871O000000o.get(i), this.O0000Ooo);
    }

    public int getItemCount() {
        return this.f18871O000000o.size();
    }

    public final void O00000oo() {
        this.O0000o0O = true;
        this.O0000o00.clear();
    }

    public final void O0000O0o() {
        List<MainPageDeviceModel> list;
        DeviceTagInterface.Category O00000o;
        this.O0000o0O = false;
        this.O0000o = false;
        this.O0000o00.clear();
        if (this.O0000oO0) {
            this.O0000oO0 = false;
        } else if (this.O0000o0o && (list = this.f18871O000000o) != null && !list.isEmpty()) {
            List<String> O0000Oo2 = O0000Oo();
            List<Room> O00000o2 = ggb.O00000Oo().O00000o();
            int i = this.O0000o0;
            if (i != 1) {
                if (i == 4) {
                    Room O00000o0 = ggb.O00000Oo().O00000o0(this.O0000Oo.O00000Oo);
                    if (O00000o0 != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= O00000o2.size()) {
                                break;
                            }
                            Room room = O00000o2.get(i2);
                            if (room.getId().equals(O00000o0.getId())) {
                                room.setDids(O0000Oo2);
                                break;
                            }
                            i2++;
                        }
                    }
                } else if (i == 5) {
                    ggb.O00000Oo().O00000Oo("mijia.roomid.default").setDids(O0000Oo2);
                    Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
                    if (O0000Oo02.getDids() == null) {
                        O0000Oo02.setDids(new ArrayList());
                    }
                    O0000Oo02.setDids(O0000Oo2);
                }
            } else {
                ggb.O00000Oo().O00000Oo("mijia.roomid.share").setDids(O0000Oo2);
            }
            int i3 = this.O0000o0;
            if (i3 == 0 || i3 == 6 || i3 == 7) {
                gfx.O000000o().O000000o(O0000Oo2, ggb.O00000Oo().O0000Oo0());
            } else if (i3 == 3) {
                DeviceTagInterface<Device> O00000Oo2 = fnn.O000000o().O00000Oo();
                PageBean pageBean = this.O0000Oo;
                if (pageBean != null) {
                    if (!(O00000Oo2 == null || pageBean.O00000Oo == null || (O00000o = O00000Oo2.O00000o(pageBean.f10340O000000o)) == null || TextUtils.isEmpty(O00000o.id))) {
                        ggb.O00000Oo().O000000o((String) null, O00000o.id, O0000Oo2);
                    }
                }
            } else {
                ggb.O00000Oo().O000000o((String) null, O00000o2);
            }
            hxi.O00000o.f952O000000o.O000000o("room_device_edit_sort", "from", Integer.valueOf(this.O0000o0));
            this.O0000o0o = false;
        }
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
        gsy.O00000o0(LogType.LOG_ANALYSIS, "zhudong_send", "deviceRecycler_exitCardEditMode");
        hza.O000000o((Application) ServiceApplication.getApplication());
    }

    public boolean O00000Oo() {
        return this.O0000o0O;
    }

    public boolean O00000o() {
        return this.O00000oo;
    }

    public final void a_(boolean z) {
        for (MainPageDeviceModel mainPageDeviceModel : this.f18871O000000o) {
            O000000o(mainPageDeviceModel.O00000oo, z);
        }
    }

    public final List<String> O0000Oo0() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet(this.O0000o00);
        for (int i = 0; i < this.f18871O000000o.size(); i++) {
            String str = this.f18871O000000o.get(i).O00000oo;
            if (hashSet.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final boolean O0000oO() {
        return this.O00000o;
    }

    public final int O0000Ooo() {
        List<String> list = this.O0000o00;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int O0000o00() {
        return this.f18871O000000o.size();
    }

    public void O000000o(String str, boolean z) {
        gzr gzr;
        if (z) {
            try {
                if (!this.O0000o00.contains(str)) {
                    this.O0000o00.add(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            this.O0000o00.remove(str);
        }
        if (this.O00000Oo != null && (gzr = this.O00000Oo.get()) != null) {
            gzr.updateActionItems(this, this.O0000o00.size());
        }
    }

    public final void O0000o0() {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.hft.AnonymousClass1 */

            public final void run() {
                hft.this.notifyDataSetChanged();
            }
        });
    }

    public final int O0000o0O() {
        return getItemCount();
    }

    public final int O0000o0o() {
        return this.O0000o0;
    }

    public final String O0000o() {
        PageBean pageBean = this.O0000Oo;
        if (pageBean == null) {
            return null;
        }
        return pageBean.O00000Oo;
    }

    public final gzr O0000oO0() {
        WeakReference<gzr> weakReference = this.O00000Oo;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean O00000o0() {
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo02 != null) {
            return O0000Oo02.isOwner();
        }
        return true;
    }

    public DviceEditInterface.HostPage O00000oO() {
        WeakReference<gzr> weakReference = this.O00000Oo;
        if (weakReference == null) {
            return null;
        }
        gzr gzr = weakReference.get();
        if (gzr instanceof gzs) {
            return DviceEditInterface.HostPage.MAIN_PAGE;
        }
        if (gzr instanceof AllDeviceActivity) {
            return DviceEditInterface.HostPage.ALL_PAGE;
        }
        return DviceEditInterface.HostPage.ROOM_PAGE;
    }

    public final void O000000o(gs gsVar) {
        this.O0000Oo0 = gsVar;
    }

    public int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        Home O0000Oo02;
        PageBean pageBean;
        if (this.O00000o) {
            return 0;
        }
        if ((O00000oO() != DviceEditInterface.HostPage.ALL_PAGE || (pageBean = this.O0000Oo) == null || pageBean.O00000o0) && (O0000Oo02 = ggb.O00000Oo().O0000Oo0()) != null && O0000Oo02.isOwner()) {
            return gs.O000000o.O000000o(15);
        }
        return 0;
    }

    public final boolean O000000o(int i, int i2) {
        this.O0000o0o = true;
        if (i2 >= 0 && i2 < getItemCount()) {
            if (i < i2) {
                int i3 = i;
                while (i3 < i2) {
                    try {
                        int i4 = i3 + 1;
                        Collections.swap(this.f18871O000000o, i3, i4);
                        i3 = i4;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                for (int i5 = i; i5 > i2; i5--) {
                    Collections.swap(this.f18871O000000o, i5, i5 - 1);
                }
            }
            notifyItemMoved(i, i2);
            return true;
        }
        return false;
    }

    public final void O0000OOo() {
        boolean z = this.O0000o0O && !this.O0000o;
        this.O0000o = this.O0000o0O;
        if (z) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.hft.AnonymousClass2 */

                public final void run() {
                    hft.this.notifyDataSetChanged();
                }
            });
        }
    }

    public final void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, int i) {
        super.O000000o(recyclerView, o000OOo0, i);
        notifyItemChanged(i);
    }

    public final int O00000Oo(String str) {
        if (this.f18871O000000o == null) {
            return -1;
        }
        for (int i = 0; i < this.f18871O000000o.size(); i++) {
            if (TextUtils.equals(this.f18871O000000o.get(i).O00000oo, str)) {
                return i;
            }
        }
        return -1;
    }

    public final List<String> O0000Oo() {
        ArrayList arrayList = new ArrayList();
        for (MainPageDeviceModel next : this.f18871O000000o) {
            if (next.f10251O000000o) {
                arrayList.add("com.xiaomi.smarthome.common_use.ir_did");
            } else {
                arrayList.add(next.O00000oo);
            }
        }
        return arrayList;
    }

    public final void O0000OoO() {
        this.O0000oO0 = true;
    }

    public final void O00000o(boolean z) {
        super.O00000o(z);
        notifyDataSetChanged();
    }

    public final void O00000o0(boolean z) {
        super.O00000o0(z);
        notifyDataSetChanged();
    }

    public final void O000000o(RecyclerView recyclerView) {
        this.O0000OoO = hha.O000000o().O00000Oo;
        notifyItemRangeChanged(0, getItemCount(), "flex");
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List list) {
        if (list.isEmpty() || !"flex".equals(list.get(0))) {
            super.onBindViewHolder(o000OOo0, i, list);
        } else {
            o000OOo0.itemView.requestLayout();
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.O0000Ooo.O00000Oo.removeCallbacksAndMessages(null);
    }

    public final void O000000o(String str) {
        List<MainPageDeviceModel> list = this.f18871O000000o;
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i).O00000oo)) {
                notifyItemChanged(i);
                return;
            }
        }
    }
}

package _m_j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ghl extends aya<ghc, ghj> implements axq<ghc, ghj> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f17782O000000o;
    protected List<Room> O00000Oo = new ArrayList();
    public ArrayList<Room> O00000o = new ArrayList<>();
    public Set<String> O00000o0 = new HashSet();
    public O000000o O00000oO;
    public O00000Oo O00000oo;
    public boolean O0000O0o = false;
    public boolean O0000OOo = false;
    private View O0000Oo;
    private boolean O0000Oo0 = false;
    private Home O0000OoO;
    private int O0000Ooo = 0;
    private int O0000o00 = 1;

    public interface O000000o {
        void O000000o();
    }

    public interface O00000Oo {
        void O000000o();
    }

    public final boolean O000000o(int i, int i2) {
        return i == i2;
    }

    public final int getGroupCount() {
        return 1;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final int getGroupItemViewType(int i) {
        return 0;
    }

    public final /* bridge */ /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
        return false;
    }

    public final /* synthetic */ boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        ghj ghj = (ghj) o000OOo0;
        View view = ghj instanceof ghj ? ghj.O00000o : null;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        ghj.itemView.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        rect2.left -= rect.left;
        rect2.top -= rect.top;
        return rect2.contains(i, i2);
    }

    public final /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
        int i4;
        ghj ghj = (ghj) o000OOo0;
        if (i2 < 0 || i2 >= this.O00000Oo.size()) {
            getItemCount();
        } else {
            ghj.O000000o(this, this.O00000Oo.get(i2), i2);
            boolean z = i2 == this.O00000Oo.size() - 1;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ghj.O0000Oo0.getLayoutParams();
            if (z) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = gpc.O000000o(CommonApplication.getAppContext(), 24.0f);
            }
            ghj.O0000OoO = this.O00000oo;
        }
        if (i3 == this.O0000o00) {
            Home home = this.O0000OoO;
            boolean z2 = this.O0000O0o;
            int i5 = 8;
            ghj.O0000OOo.setVisibility((!z2 || this.O0000OOo) ? 8 : 0);
            View view = ghj.O00000oo;
            if (!z2) {
                i5 = 0;
            }
            view.setVisibility(i5);
            if (home == null) {
                i4 = ggb.O00000Oo().O0000O0o().size();
            } else {
                i4 = ggb.O00000Oo().O0000OOo(home.getId()).size();
            }
            ghj.O00000o0.setVisibility(i4 > 0 ? 0 : 4);
            if (i4 <= 1) {
                ghj.O0000O0o.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_count, i4, Integer.valueOf(i4)));
            } else {
                ghj.O0000O0o.setText(CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.choose_device_device_counts, i4, Integer.valueOf(i4)));
            }
            ghj.O00000Oo.setOnLongClickListener(new View.OnLongClickListener() {
                /* class _m_j.ghj.AnonymousClass1 */

                public final boolean onLongClick(View view) {
                    if (ghj.this.O0000Oo != null) {
                        ghj.this.O0000Oo.O000000o();
                    }
                    hxi.O00000o.O00000oo();
                    return true;
                }
            });
        }
    }

    public final /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        ghc ghc = (ghc) o000OOo0;
        if (i >= 0) {
            ghc.O000000o(this.f17782O000000o.getString(R.string.tag_allroom_title));
            ((RecyclerView.LayoutParams) ghc.f17770O000000o.getLayoutParams()).height = 0;
        }
    }

    public ghl(Activity activity) {
        this.f17782O000000o = activity;
        setHasStableIds(true);
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        List<Room> list;
        if (i == i3 && i2 != i4 && (list = this.O00000Oo) != null && i2 < list.size() && i4 < this.O00000Oo.size()) {
            this.O00000Oo.add(i4, this.O00000Oo.remove(i2));
            this.O0000Oo0 = true;
            notifyItemMoved(i2, i4);
        }
    }

    public final int getChildCount(int i) {
        int i2 = this.O0000Oo != null ? 1 : 0;
        return i == 0 ? this.O00000Oo.size() + i2 : i2;
    }

    public final int O000000o() {
        View view = this.O0000Oo;
        return this.O00000Oo.size() + ((view == null || view.findViewById(R.id.view_group) == null || this.O0000Oo.findViewById(R.id.view_group).getVisibility() != 0) ? 0 : 1);
    }

    public final long getChildId(int i, int i2) {
        Room room;
        if (i2 < 0 || i2 >= this.O00000Oo.size() || (room = this.O00000Oo.get(i2)) == null || TextUtils.isEmpty(room.getId())) {
            return 0;
        }
        return (long) room.getId().hashCode();
    }

    public final int getChildItemViewType(int i, int i2) {
        if (this.O0000Oo != null && i == 0 && i2 == getChildCount(i) - 1) {
            return this.O0000o00;
        }
        return this.O0000Ooo;
    }

    public final void O000000o(boolean z) {
        String str;
        if (this.O0000Oo0) {
            if (z) {
                gqg.O00000Oo(this.f17782O000000o.getResources().getText(R.string.toast_sort_succeed));
                Home home = this.O0000OoO;
                if (home != null) {
                    str = home.getId();
                } else {
                    str = ggb.O00000Oo().O0000OOo();
                }
                ArrayList arrayList = new ArrayList(this.O00000Oo);
                arrayList.remove(0);
                ggb.O00000Oo().O000000o(str, arrayList);
            } else {
                this.O00000Oo.clear();
                this.O00000Oo.addAll(this.O00000o);
                notifyDataSetChanged();
            }
            this.O0000Oo0 = false;
        }
    }

    public final void O00000Oo() {
        this.O0000OOo = true;
        this.O00000o0.clear();
        this.O00000o = new ArrayList<>(this.O00000Oo);
        notifyDataSetChanged();
    }

    public final void O000000o(Room room, boolean z) {
        if (z) {
            this.O00000o0.add(room.getId());
        } else {
            this.O00000o0.remove(room.getId());
        }
        this.O00000o0.size();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ghl.O000000o(com.xiaomi.smarthome.homeroom.model.Room, boolean):void
     arg types: [com.xiaomi.smarthome.homeroom.model.Room, int]
     candidates:
      _m_j.ghl.O000000o(int, int):boolean
      _m_j.axq.O000000o(int, int):boolean
      _m_j.ghl.O000000o(com.xiaomi.smarthome.homeroom.model.Room, boolean):void */
    public final void O00000o0() {
        for (int i = 0; i < this.O00000Oo.size(); i++) {
            O000000o(this.O00000Oo.get(i), false);
        }
    }

    public final int O00000o() {
        return this.O00000Oo.size();
    }

    public final void O000000o(Home home) {
        List<Room> list;
        this.O0000OoO = home;
        if (home == null) {
            list = ggb.O00000Oo().O00000o();
        } else {
            list = home.getRoomList();
        }
        if (list == null) {
            this.O00000Oo = new ArrayList();
        } else {
            this.O00000Oo = new ArrayList(list);
        }
        String id = home != null ? home.getId() : "";
        List<Room> list2 = this.O00000Oo;
        Room room = new Room();
        room.setId("mijia.roomid.common");
        room.setName(this.f17782O000000o.getString(R.string.tag_common));
        room.setParentid(id);
        list2.add(0, room);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        if (i == this.O0000o00) {
            return new ghj(this.O0000Oo, this.O00000oO);
        }
        return new ghk(LayoutInflater.from(this.f17782O000000o).inflate((int) R.layout.room_child_item_sort_edit, viewGroup, false), this.O00000oO);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
        return new ghf(LayoutInflater.from(this.f17782O000000o).inflate((int) R.layout.tag_group_item_common_7, viewGroup, false));
    }

    public final /* synthetic */ axj O000000o(int i) {
        return new axo(1, this.O00000Oo.size() > 1 ? this.O00000Oo.size() : 1);
    }
}

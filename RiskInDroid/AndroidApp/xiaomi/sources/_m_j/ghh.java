package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.homeroom.HomeEditorActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import java.util.ArrayList;
import java.util.List;

public final class ghh extends aya<ghc, ghd> implements axq<ghc, ghd> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f17772O000000o;
    public List<Home> O00000Oo = new ArrayList();
    public ArrayList<Home> O00000o = new ArrayList<>();
    public List<gha> O00000o0 = new ArrayList();
    public O000000o O00000oO;
    public boolean O00000oo = false;
    public boolean O0000O0o = false;
    private boolean O0000OOo = false;
    private View.OnClickListener O0000Oo;
    private View O0000Oo0;

    public interface O000000o {
    }

    public final boolean O000000o(int i, int i2) {
        return i == i2;
    }

    public final int getChildItemViewType(int i, int i2) {
        return i == 0 ? 0 : 1;
    }

    public final long getGroupId(int i) {
        return (long) i;
    }

    public final int getGroupItemViewType(int i) {
        return 0;
    }

    public final /* bridge */ /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
        return false;
    }

    public final /* synthetic */ boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        View view;
        ghd ghd = (ghd) o000OOo0;
        if (!(ghd instanceof ghg) || (view = ((ghg) ghd).O00000o) == null || view.getVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        ghd.itemView.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        rect2.left -= rect.left;
        rect2.top -= rect.top;
        return rect2.contains(i, i2);
    }

    public final /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
        ghd ghd = (ghd) o000OOo0;
        int i4 = 8;
        boolean z = true;
        if (i3 == 0) {
            try {
                ghg ghg = (ghg) ghd;
                Home home = this.O00000Oo.get(i2);
                if (ghg.O0000OOo == 0) {
                    boolean z2 = this.O00000oo;
                    boolean z3 = this.O0000O0o;
                    if (home != null) {
                        if (!z2) {
                            ghg.O00000o.setVisibility(4);
                        } else if (z3) {
                            ghg.O00000o.setVisibility(0);
                        } else {
                            ghg.O00000o.setVisibility(4);
                        }
                        View view = ghg.O00000oO;
                        if (!z2) {
                            i4 = 0;
                        }
                        view.setVisibility(i4);
                        TextView textView = ghg.O00000o0;
                        ggb.O00000Oo();
                        textView.setText(ggb.O000000o(home));
                        int size = ggb.O00000Oo().O000000o(home.getId(), new boolean[0]).size();
                        int size2 = home.getRoomList().size();
                        String quantityString = CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.home_room_size, size2, Integer.valueOf(size2));
                        String quantityString2 = CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.home_device_size, size, Integer.valueOf(size));
                        ghg.O0000O0o.setText(quantityString + " / " + quantityString2);
                        if (!home.isOwner()) {
                            ghg.O0000O0o.setText((int) R.string.share_polymerization_shared_home);
                        }
                        ghg.O00000Oo.setOnClickListener(new View.OnClickListener(z2, home, this) {
                            /* class _m_j.ghg.AnonymousClass1 */

                            /* renamed from: O000000o */
                            final /* synthetic */ boolean f17771O000000o;
                            final /* synthetic */ Home O00000Oo;
                            final /* synthetic */ ghh O00000o0;

                            {
                                this.f17771O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                            }

                            public final void onClick(View view) {
                                if (!this.f17771O000000o) {
                                    if (ghg.this.O0000Oo0 != null) {
                                        view.setTag(R.id.home_id, this.O00000Oo.getId());
                                        ghg.this.O0000Oo0.onClick(view);
                                    } else {
                                        Intent intent = new Intent(this.O00000o0.O000000o(), HomeEditorActivity.class);
                                        intent.addFlags(268435456);
                                        intent.putExtra("home_id", this.O00000Oo.getId());
                                        this.O00000o0.O000000o().startActivity(intent);
                                    }
                                    hxk hxk = hxi.O00000o;
                                    String id = this.O00000Oo.getId();
                                    hxk.f952O000000o.O000000o("home_management_homeclick", "home_id", id, "type", Integer.valueOf(this.O00000Oo.isOwner() ^ true ? 1 : 0));
                                }
                            }
                        });
                    }
                }
                ghg ghg2 = (ghg) ghd;
                if (i2 != this.O00000Oo.size() - 1) {
                    z = false;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ghg2.O00000oo.getLayoutParams();
                if (z) {
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = gpc.O000000o(CommonApplication.getAppContext(), 24.0f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i3 == 1) {
            ((ghi) ghd).O000000o(this, this.O00000o0.get(i2));
            ((ghi) ghd).O00000o0.setVisibility(8);
        }
    }

    public final /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        ghc ghc = (ghc) o000OOo0;
        if (i == 0) {
            ghc.O000000o(this.f17772O000000o.getString(R.string.my_home_2));
        } else if (i == 1) {
            ghc.O000000o(this.f17772O000000o.getString(R.string.home_member_new_invite));
            if (ghc instanceof ghe) {
                ghe ghe = (ghe) ghc;
                ((RelativeLayout.LayoutParams) ghe.O00000Oo.getLayoutParams()).addRule(12, -1);
                ghe.O00000o.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ghe.O00000o.getLayoutParams();
                marginLayoutParams.leftMargin = gpc.O000000o(27.0f);
                marginLayoutParams.rightMargin = gpc.O000000o(27.0f);
            }
        }
    }

    public ghh(Activity activity) {
        this.f17772O000000o = activity;
        setHasStableIds(true);
    }

    public final Context O000000o() {
        return this.f17772O000000o;
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        List<Home> list;
        if (i == i3 && i2 != i4 && i == 0 && (list = this.O00000Oo) != null && i2 < list.size() && i4 < this.O00000Oo.size()) {
            this.O00000Oo.add(i4, this.O00000Oo.remove(i2));
            this.O0000OOo = true;
            notifyItemMoved(i2, i4);
        }
    }

    public final int getGroupCount() {
        return this.O00000o0.size() > 0 ? 2 : 1;
    }

    public final int getChildCount(int i) {
        int i2 = this.O0000Oo0 != null ? 1 : 0;
        if (i == 0) {
            return this.O00000Oo.size() + i2;
        }
        return i == 1 ? this.O00000o0.size() : i2;
    }

    public final long getChildId(int i, int i2) {
        int hashCode;
        if (i == 0 && i2 >= 0 && i2 < this.O00000Oo.size()) {
            hashCode = this.O00000Oo.get(i2).getId().hashCode();
        } else if (i != 1 || i2 < 0 || i2 >= this.O00000o0.size()) {
            return 0;
        } else {
            hashCode = this.O00000o0.get(i2).hashCode();
        }
        return (long) hashCode;
    }

    public final void O000000o(boolean z) {
        if (this.O0000OOo) {
            if (z) {
                gqg.O00000Oo(this.f17772O000000o.getResources().getText(R.string.toast_sort_succeed));
            } else {
                this.O00000Oo.clear();
                this.O00000Oo.addAll(this.O00000o);
                notifyDataSetChanged();
            }
            this.O0000OOo = false;
        }
    }

    public final void O00000Oo() {
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        if (list == null) {
            this.O00000Oo = new ArrayList();
        } else {
            this.O00000Oo = new ArrayList(list);
        }
        List<gha> O000000o2 = ggc.O000000o().O000000o(gha.f17769O000000o);
        if (O000000o2 == null) {
            this.O00000o0 = new ArrayList();
        } else {
            this.O00000o0 = O000000o2;
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.f17772O000000o);
        if (i == 0) {
            ghg ghg = new ghg(from.inflate((int) R.layout.item_home_list, viewGroup, false), this.O00000oO);
            ghg.O0000Oo0 = this.O0000Oo;
            return ghg;
        }
        ghi ghi = new ghi(from.inflate((int) R.layout.item_home_invite_list, viewGroup, false), this.O00000oO);
        ghi.O00000o = this.O0000Oo;
        return ghi;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f17772O000000o).inflate((int) R.layout.tag_group_item_common_6, viewGroup, false);
        inflate.findViewById(R.id.bottom_divider).setVisibility(8);
        return new ghe(inflate);
    }

    public final /* synthetic */ axj O000000o(int i) {
        if (i != 0) {
            return new axo(0, 0);
        }
        return new axo(0, this.O00000Oo.size() > 0 ? this.O00000Oo.size() - 1 : 0);
    }
}

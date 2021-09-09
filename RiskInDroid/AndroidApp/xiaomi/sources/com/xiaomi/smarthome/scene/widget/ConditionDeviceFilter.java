package com.xiaomi.smarthome.scene.widget;

import _m_j.fnn;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gpy;
import _m_j.hrw;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.newui.widget.FixHeightRecyclerView;
import com.xiaomi.smarthome.newui.widget.FlowLayoutCopy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ConditionDeviceFilter {

    /* renamed from: O000000o  reason: collision with root package name */
    private MLAlertDialog f11327O000000o;
    public Context O00000Oo;
    private View O00000o;
    private View O00000o0;
    private Home O00000oO;
    private Room O00000oo;
    private DeviceTagInterface.Category O0000O0o;
    private FixHeightRecyclerView O0000OOo;
    private O00000Oo O0000Oo;
    private FixHeightRecyclerView O0000Oo0;
    private O00000o0 O0000OoO;
    private List<hrw> O0000Ooo = new ArrayList();
    private Room O0000o0;
    private Room O0000o00;

    public abstract int O000000o(String str, DeviceTagInterface.Category category);

    public abstract int O000000o(String str, Room room);

    public abstract void O000000o(Home home);

    public abstract void O000000o(Home home, DeviceTagInterface.Category category);

    public abstract void O000000o(Home home, Room room);

    public ConditionDeviceFilter(Context context) {
        this.O00000Oo = context;
        this.O0000o00 = new Room();
        this.O0000o00.setId("ALL_ROOM");
        this.O0000o00.setName(context.getString(R.string.tag_all));
        this.O0000o0 = new Room();
        this.O0000o0.setId("DEFAULT_ROOM");
        this.O0000o0.setName(context.getString(R.string.tag_recommend_defaultroom));
        this.O00000o0 = LayoutInflater.from(context).inflate((int) R.layout.scene_filter_dialog, (ViewGroup) null);
        this.O0000OOo = (FixHeightRecyclerView) this.O00000o0.findViewById(R.id.recycler_tag);
        this.O0000OOo.setLayoutManager(new LinearLayoutManager(context));
    }

    public final MLAlertDialog O000000o() {
        if (this.f11327O000000o == null) {
            this.f11327O000000o = new MLAlertDialog.Builder(this.O00000Oo).O000000o(this.O00000o0).O00000o();
        }
        return this.f11327O000000o;
    }

    public final boolean O00000Oo() {
        Home O00000o2;
        List<Home> O00000oo2 = O00000oo();
        if (O00000oo2.isEmpty()) {
            View view = this.O00000o;
            if (view != null) {
                view.setVisibility(8);
            }
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            return false;
        }
        if (this.O00000o == null) {
            this.O00000o = ((ViewStub) this.O00000o0.findViewById(R.id.vs_family)).inflate();
            this.O0000Oo0 = (FixHeightRecyclerView) this.O00000o.findViewById(R.id.sc_home_layout);
            this.O0000Oo0.setLayoutManager(new LinearLayoutManager(this.O00000Oo));
            if (this.O0000OoO == null) {
                this.O0000OoO = new O00000o0();
                this.O0000Oo0.setAdapter(this.O0000OoO);
            }
        }
        this.O0000OoO.O000000o();
        this.O0000OoO.notifyDataSetChanged();
        this.O0000Ooo = O000000o(O00000oo2);
        if (this.O0000Ooo.isEmpty()) {
            View view2 = this.O00000o;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
            return false;
        }
        this.O00000o.setVisibility(0);
        if (this.O00000oO == null) {
            String O00000o02 = gpy.O00000o0(this.O00000Oo, "scene_device_filter", "slected_home", "");
            if (!TextUtils.isEmpty(O00000o02) && (O00000o2 = ggb.O00000Oo().O00000o(O00000o02)) != null && O00000o2.isOwner()) {
                this.O00000oO = O00000o2;
            }
            if (this.O00000oO == null) {
                this.O00000oO = ggb.O00000Oo().O0000Oo0();
            }
            if (!O00000Oo(this.O00000oO)) {
                this.O00000oO = O00000o();
            }
            this.O00000oo = null;
            this.O0000O0o = null;
        }
        O00000oO();
        String id = this.O00000oO.getId();
        if (!O00000oo2.isEmpty()) {
            O00000oo2.size();
        }
        O000000o(id);
        return true;
    }

    private Home O00000o() {
        Home home;
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        int i = 0;
        boolean z = false;
        int i2 = -1;
        while (true) {
            if (i >= list.size() || !list.get(i).isOwner()) {
                home = null;
            } else {
                if (!z) {
                    z = true;
                    i2 = i;
                }
                if (O00000Oo(list.get(i))) {
                    home = list.get(i);
                    break;
                }
                i++;
            }
        }
        home = null;
        return home == null ? list.get(i2) : home;
    }

    private void O00000oO() {
        if (this.O0000Oo0 != null) {
            if (this.O0000OoO == null) {
                this.O0000OoO = new O00000o0();
            }
            this.O0000OoO.O000000o();
            this.O0000OoO.notifyDataSetChanged();
            ViewGroup.LayoutParams layoutParams = null;
            FixHeightRecyclerView fixHeightRecyclerView = this.O0000OOo;
            if (fixHeightRecyclerView != null) {
                layoutParams = fixHeightRecyclerView.getLayoutParams();
            }
            if (this.O0000Ooo.isEmpty() || this.O0000Ooo.size() == 1) {
                this.O00000o.setVisibility(8);
                if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = gpc.O000000o(20.0f);
                    this.O0000OOo.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (layoutParams != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = gpc.O000000o(0.0f);
                this.O0000OOo.setLayoutParams(layoutParams);
            }
            this.O0000OoO.O000000o(0, this.O0000Ooo);
            this.O0000OoO.notifyDataSetChanged();
            this.O00000o.setVisibility(0);
        }
    }

    private static List<Home> O00000oo() {
        ArrayList arrayList = new ArrayList();
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        if (!list.isEmpty()) {
            arrayList.addAll(list);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((Home) arrayList.get(size)).isOwner()) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    public final void O00000o0() {
        O00000Oo();
        MLAlertDialog mLAlertDialog = this.f11327O000000o;
        if (mLAlertDialog != null) {
            mLAlertDialog.show();
        }
    }

    public class O00000o0 extends O00000Oo {
        public O00000o0() {
            super();
        }

        /* renamed from: O000000o */
        public final void onBindViewHolder(O000000o o000000o, int i) {
            o000000o.f11328O000000o.removeAllViews();
            for (int i2 = 0; i2 < ((List) this.f11329O000000o.get(i)).size(); i2++) {
                ConditionDeviceFilter conditionDeviceFilter = ConditionDeviceFilter.this;
                o000000o.f11328O000000o.addView(conditionDeviceFilter.O000000o(conditionDeviceFilter.O00000Oo, (hrw) ((List) this.f11329O000000o.get(i)).get(i2), o000000o.f11328O000000o));
            }
        }
    }

    public class O00000Oo extends RecyclerView.O000000o<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        SparseArray<List<hrw>> f11329O000000o = new SparseArray<>();

        public long getItemId(int i) {
            return (long) i;
        }

        public O00000Oo() {
        }

        public final boolean O000000o(hrw hrw) {
            List list;
            if (this.f11329O000000o.get(0) != null) {
                list = this.f11329O000000o.get(0);
            } else {
                list = new ArrayList();
                this.f11329O000000o.put(0, list);
            }
            if (this.f11329O000000o.size() <= 0) {
                return false;
            }
            list.add(0, hrw);
            return true;
        }

        public final void O000000o(int i, List<hrw> list) {
            List list2;
            if (this.f11329O000000o.get(i) != null) {
                list2 = this.f11329O000000o.get(i);
            } else {
                ArrayList arrayList = new ArrayList();
                this.f11329O000000o.put(i, arrayList);
                list2 = arrayList;
            }
            list2.clear();
            if (list != null) {
                list2.addAll(list);
            }
        }

        /* renamed from: O000000o */
        public void onBindViewHolder(O000000o o000000o, int i) {
            o000000o.f11328O000000o.removeAllViews();
            if (this.f11329O000000o.get(i) != null && this.f11329O000000o.get(i).size() > 0) {
                if (((hrw) this.f11329O000000o.get(i).get(0)).f578O000000o == 1) {
                    View view = new View(o000000o.f11328O000000o.getContext());
                    view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, gpc.O000000o(0.5f)));
                    view.setBackgroundResource(R.color.mj_color_black_15_transparent);
                    o000000o.f11328O000000o.addView(view);
                    ViewGroup.LayoutParams layoutParams = o000000o.f11328O000000o.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                        o000000o.f11328O000000o.setLayoutParams(layoutParams);
                    }
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.topMargin = gpc.O000000o(20.0f);
                        if (getItemCount() > 2) {
                            marginLayoutParams.bottomMargin = gpc.O000000o(20.0f);
                        } else {
                            marginLayoutParams.bottomMargin = 0;
                        }
                        o000000o.f11328O000000o.setLayoutParams(marginLayoutParams);
                        return;
                    }
                    return;
                }
                for (int i2 = 0; i2 < this.f11329O000000o.get(i).size(); i2++) {
                    ConditionDeviceFilter conditionDeviceFilter = ConditionDeviceFilter.this;
                    o000000o.f11328O000000o.addView(conditionDeviceFilter.O000000o(conditionDeviceFilter.O00000Oo, (hrw) this.f11329O000000o.get(i).get(i2), o000000o.f11328O000000o));
                }
            }
        }

        public int getItemCount() {
            SparseArray<List<hrw>> sparseArray = this.f11329O000000o;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        public final void O000000o() {
            SparseArray<List<hrw>> sparseArray = this.f11329O000000o;
            if (sparseArray != null && sparseArray.size() > 0) {
                this.f11329O000000o.clear();
            }
        }

        public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(new FlowLayoutCopy(ConditionDeviceFilter.this.O00000Oo));
        }
    }

    private boolean O00000Oo(Home home) {
        if (this.O0000Ooo.isEmpty() || home == null) {
            return false;
        }
        for (hrw hrw : this.O0000Ooo) {
            if (TextUtils.equals(hrw.O00000o0, home.getId())) {
                return true;
            }
        }
        return false;
    }

    private void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            O00000Oo o00000Oo = this.O0000Oo;
            if (o00000Oo != null) {
                o00000Oo.O000000o();
                this.O0000Oo.notifyDataSetChanged();
                return;
            }
            return;
        }
        List<Room> O000000o2 = ggb.O00000Oo().O000000o(str);
        ArrayList arrayList = new ArrayList();
        if (O000000o2 != null) {
            arrayList.addAll(O000000o2);
        }
        arrayList.add(0, this.O0000o0);
        if (this.O0000Oo == null) {
            this.O0000Oo = new O00000Oo();
            this.O0000OOo.setAdapter(this.O0000Oo);
        }
        this.O0000Oo.O000000o();
        this.O0000Oo.O000000o(0, O000000o(str, (List<Room>) arrayList));
        this.O0000Oo.O000000o(new hrw(this.O00000Oo.getString(R.string.tag_all), "ALL_ROOM"));
        if (this.O00000oo == null && this.O0000O0o == null) {
            this.O00000oo = this.O0000o00;
        }
        Map<String, List<String>> O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo(str);
        if (!O0000Oo2.isEmpty()) {
            Set<Map.Entry<String, List<String>>> entrySet = O0000Oo2.entrySet();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry next : entrySet) {
                DeviceTagInterface.Category O00000o2 = fnn.O000000o().O00000Oo().O00000o((String) next.getKey());
                if (!(O00000o2 == null || next.getValue() == null || ((List) next.getValue()).size() <= 0)) {
                    arrayList2.add(O00000o2);
                }
            }
            if (arrayList2.size() > 0) {
                List<hrw> O000000o3 = O000000o(str, (ArrayList<DeviceTagInterface.Category>) arrayList2);
                if (O000000o3.size() > 0) {
                    hrw hrw = new hrw();
                    hrw.f578O000000o = 1;
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(hrw);
                    this.O0000Oo.O000000o(1, arrayList3);
                    this.O0000Oo.O000000o(2, O000000o3);
                }
            }
        }
        this.O0000Oo.notifyDataSetChanged();
        if (this.O0000O0o == null && this.O00000oo == null) {
            O000000o(ggb.O00000Oo().O00000o(str));
        }
    }

    private static List<hrw> O000000o(List<Home> list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (Home next : list) {
                if (next != null && !TextUtils.isEmpty(next.getId())) {
                    ggb.O00000Oo();
                    if (!TextUtils.isEmpty(ggb.O000000o(next))) {
                        hrw hrw = new hrw();
                        ggb.O00000Oo();
                        hrw.O00000Oo = ggb.O000000o(next);
                        hrw.O00000o0 = next.getId();
                        hrw.f578O000000o = 3;
                        arrayList.add(hrw);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<hrw> O000000o(String str, List<Room> list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (Room next : list) {
                if (next != null && !TextUtils.isEmpty(next.getId()) && !TextUtils.isEmpty(next.getName()) && O000000o(str, next) > 0) {
                    hrw hrw = new hrw();
                    hrw.O00000Oo = next.getName();
                    hrw.O00000o0 = next.getId();
                    hrw.f578O000000o = 0;
                    arrayList.add(hrw);
                }
            }
        }
        return arrayList;
    }

    private List<hrw> O000000o(String str, ArrayList<DeviceTagInterface.Category> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator<DeviceTagInterface.Category> it = arrayList.iterator();
            while (it.hasNext()) {
                DeviceTagInterface.Category next = it.next();
                if (next != null && !TextUtils.isEmpty(next.id) && !TextUtils.isEmpty(next.name) && O000000o(str, next) > 0) {
                    hrw hrw = new hrw();
                    hrw.O00000Oo = next.name;
                    hrw.O00000o0 = next.id;
                    hrw.f578O000000o = 2;
                    arrayList2.add(hrw);
                }
            }
        }
        return arrayList2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final TextView O000000o(Context context, hrw hrw, ViewGroup viewGroup) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate((int) R.layout.scene_filter_item, viewGroup, false);
        if (!TextUtils.isEmpty(hrw.O00000Oo)) {
            textView.setText(hrw.O00000Oo);
        } else {
            textView.setText("");
        }
        int i = hrw.f578O000000o;
        boolean z = true;
        if (i == 0 ? this.O00000oo == null || !TextUtils.equals(hrw.O00000o0, this.O00000oo.getId()) : i == 2 ? this.O0000O0o == null || !TextUtils.equals(hrw.O00000o0, this.O0000O0o.id) : i != 3 || this.O00000oO == null || !TextUtils.equals(hrw.O00000o0, this.O00000oO.getId())) {
            z = false;
        }
        textView.setSelected(z);
        textView.setOnClickListener(new View.OnClickListener(hrw, context) {
            /* class com.xiaomi.smarthome.scene.widget.$$Lambda$ConditionDeviceFilter$WSEKoR6X9LDhnPvRjt4EyV6cyI */
            private final /* synthetic */ hrw f$1;
            private final /* synthetic */ Context f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                ConditionDeviceFilter.this.O000000o(this.f$1, this.f$2, view);
            }
        });
        return textView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(hrw hrw, Context context, View view) {
        int i = hrw.f578O000000o;
        if (i != 0) {
            if (i != 2) {
                if (i == 3 && !TextUtils.isEmpty(hrw.O00000o0) && !TextUtils.equals(this.O00000oO.getId(), hrw.O00000o0)) {
                    this.O00000oO = ggb.O00000Oo().O00000o(hrw.O00000o0);
                    if (this.O00000oO.isOwner()) {
                        this.O00000oo = null;
                        this.O0000O0o = null;
                        O000000o(this.O00000oO);
                        O00000oO();
                        O000000o(hrw.O00000o0);
                    }
                }
            } else if (!TextUtils.isEmpty(hrw.O00000o0)) {
                this.O00000oo = null;
                this.O0000O0o = fnn.O000000o().O00000Oo().O0000OOo(hrw.O00000o0);
                O000000o(this.O00000oO, this.O0000O0o);
                gpy.O000000o(context, "scene_device_filter", "slected_home", this.O00000oO.getId());
            }
        } else if (!TextUtils.isEmpty(hrw.O00000o0)) {
            if (TextUtils.equals(this.O0000o00.getId(), hrw.O00000o0)) {
                this.O00000oo = this.O0000o00;
            } else if (TextUtils.equals(this.O0000o0.getId(), hrw.O00000o0)) {
                this.O00000oo = this.O0000o0;
            } else {
                this.O00000oo = ggb.O00000Oo().O00000o0(hrw.O00000o0);
            }
            this.O0000O0o = null;
            O000000o(this.O00000oO, this.O00000oo);
            gpy.O000000o(context, "scene_device_filter", "slected_home", this.O00000oO.getId());
        }
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public FlowLayoutCopy f11328O000000o;

        public O000000o(View view) {
            super(view);
            this.f11328O000000o = (FlowLayoutCopy) view;
            this.f11328O000000o.setSingleLine(false);
            this.f11328O000000o.setItemSpacing(gpc.O000000o(10.0f));
            this.f11328O000000o.setLineSpacing(gpc.O000000o(14.0f));
        }
    }

    public static void O000000o(Context context) {
        gpy.O000000o(context, "scene_device_filter").edit().clear().commit();
    }
}

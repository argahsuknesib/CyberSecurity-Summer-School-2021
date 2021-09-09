package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.newui.widget.FixHeightRecyclerView;
import com.xiaomi.smarthome.newui.widget.FlowLayoutCopy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class hrv {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f574O000000o = false;
    public Context O00000Oo;
    public Room O00000o;
    public Room O00000o0;
    public View O00000oO;
    public FixHeightRecyclerView O00000oo;
    public int[] O0000O0o = new int[2];
    public View O0000OOo;
    public final ViewTreeObserver.OnGlobalLayoutListener O0000Oo = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class _m_j.hrv.AnonymousClass1 */

        public final void onGlobalLayout() {
            try {
                hrv.this.O0000OOo.getLocationOnScreen(hrv.this.O0000O0o);
                int height = hrv.this.O0000O0o[1] + hrv.this.O0000OOo.getHeight();
                if (height - hrv.this.O0000OOo.getHeight() <= 0) {
                    hrv.this.O000000o(false);
                    return;
                }
                hrv.this.O00000oo.setY((float) height);
                hrv.this.O00000oO.setY((float) (height - hrv.this.O0000OOo.getHeight()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    public int O0000Oo0 = -1;
    private hrw O0000OoO;
    private ViewGroup O0000Ooo;
    private Home O0000o;
    private View O0000o0;
    private View O0000o00;
    private TextView O0000o0O;
    private O00000Oo O0000o0o;
    private DeviceTagInterface.Category O0000oO;
    private Room O0000oO0;
    private Map<String, List<Room>> O0000oOO = new HashMap();

    public abstract void O000000o(Home home);

    public abstract void O000000o(Home home, DeviceTagInterface.Category category);

    public abstract void O000000o(Home home, Room room);

    public hrv(Context context, ViewGroup viewGroup) {
        this.O00000Oo = context;
        this.O0000Ooo = viewGroup;
        this.O0000o00 = LayoutInflater.from(context).inflate((int) R.layout.scene_filter_menu_layout, (ViewGroup) null);
        this.O0000o0 = this.O0000o00.findViewById(R.id.bg_mask);
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.$$Lambda$hrv$2nS9i45g99oDN1oQi8bRM3fiW2s */

            public final void onClick(View view) {
                hrv.this.O00000o0(view);
            }
        });
        this.O0000o0O = (TextView) this.O0000o00.findViewById(R.id.tv_home_filter);
        this.O0000o0O.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.$$Lambda$hrv$uwLm9JmjnbJ2Rb0DlxXW14TUolI */

            public final void onClick(View view) {
                hrv.this.O00000Oo(view);
            }
        });
        this.O00000oO = this.O0000o00.findViewById(R.id.layout_filter);
        this.O00000oO.findViewById(R.id.arrow_down_img).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.$$Lambda$hrv$F80G56jNeKGTme1nKNWJSsKwGcE */

            public final void onClick(View view) {
                hrv.this.O000000o(view);
            }
        });
        this.O00000oo = (FixHeightRecyclerView) this.O0000o00.findViewById(R.id.recycler_tag);
        this.O00000oo.setLayoutManager(new LinearLayoutManager(context));
        this.O00000oo.setMaxLines(10);
        this.O0000o0o = new O00000Oo();
        this.O00000oo.setAdapter(this.O0000o0o);
        this.O00000o0 = new Room();
        this.O00000o0.setId("ALL_ROOM");
        this.O00000o0.setName(context.getString(R.string.tag_all));
        this.O00000o = new Room();
        this.O00000o.setId("DEFAULT_ROOM");
        this.O00000o.setName(context.getString(R.string.tag_recommend_defaultroom));
        this.O0000OoO = new hrw();
        this.O0000OoO.f578O000000o = 1;
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        O000000o(this.O0000Oo0 == 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        if (this.O0000Oo0 == 0) {
            O000000o(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (this.O0000Oo0 == 1) {
            O000000o(false);
            return;
        }
        View view2 = this.O0000OOo;
        if (view2 != null) {
            view2.performClick();
        }
    }

    public final void O000000o() {
        if (this.O0000o == null) {
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo02 != null && O0000Oo02.isOwner()) {
                this.O0000o = O0000Oo02;
            }
            this.O0000oO0 = this.O00000o0;
            this.O0000oO = null;
        }
        if (this.O0000o != null) {
            int i = 0;
            for (Home isOwner : ggb.O00000Oo().O0000OoO.O00000Oo) {
                if (isOwner.isOwner()) {
                    i++;
                }
                if (i > 1) {
                    break;
                }
            }
            TextView textView = this.O0000o0O;
            if (textView != null) {
                ggb.O00000Oo();
                textView.setText(ggb.O000000o(this.O0000o));
            }
        }
    }

    public final void O00000Oo(Home home) {
        this.O0000o = home;
        this.O0000oO0 = null;
        this.O0000oO = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, java.util.List<_m_j.hrw>):void
     arg types: [int, java.util.List<_m_j.hrw>]
     candidates:
      _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, _m_j.hrw):void
      _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, java.util.List<_m_j.hrw>):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hrv.O00000Oo.O00000Oo(java.lang.Integer, _m_j.hrw):void
     arg types: [int, _m_j.hrw]
     candidates:
      _m_j.hrv.O00000Oo.O00000Oo(java.lang.Integer, java.util.List<_m_j.hrw>):void
      _m_j.hrv.O00000Oo.O00000Oo(java.lang.Integer, _m_j.hrw):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hrv.O00000Oo.O00000Oo(java.lang.Integer, java.util.List<_m_j.hrw>):void
     arg types: [int, java.util.List]
     candidates:
      _m_j.hrv.O00000Oo.O00000Oo(java.lang.Integer, _m_j.hrw):void
      _m_j.hrv.O00000Oo.O00000Oo(java.lang.Integer, java.util.List<_m_j.hrw>):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, java.util.List<_m_j.hrw>):void
     arg types: [int, java.util.List]
     candidates:
      _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, _m_j.hrw):void
      _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, java.util.List<_m_j.hrw>):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, _m_j.hrw):void
     arg types: [int, _m_j.hrw]
     candidates:
      _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, java.util.List<_m_j.hrw>):void
      _m_j.hrv.O00000Oo.O000000o(java.lang.Integer, _m_j.hrw):void */
    public final void O00000Oo() {
        View view = this.O00000oO;
        if (view != null) {
            ViewPropertyAnimator startDelay = view.findViewById(R.id.arrow_down_img).animate().rotation(180.0f).setDuration(125).setStartDelay(125);
            startDelay.setInterpolator(new AccelerateDecelerateInterpolator());
            startDelay.start();
        }
        if (this.O0000Ooo.indexOfChild(this.O0000o00) < 0) {
            this.O0000Ooo.addView(this.O0000o00);
        }
        this.O0000Oo0 = 1;
        if (this.O0000o != null) {
            ArrayList arrayList = new ArrayList();
            List<Room> O000000o2 = ggb.O00000Oo().O000000o(this.O0000o.getId());
            if (O000000o2 != null) {
                arrayList.addAll(O000000o2);
                arrayList.add(0, this.O00000o0);
                arrayList.add(1, this.O00000o);
                List<hrw> O000000o3 = O000000o((List<Room>) arrayList);
                if (this.O0000oO0 == null && this.O0000oO == null) {
                    this.O0000oO0 = this.O00000o0;
                }
                List arrayList2 = new ArrayList();
                Map<String, List<String>> O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo(this.O0000o.getId());
                if (!O0000Oo2.isEmpty()) {
                    Set<Map.Entry<String, List<String>>> entrySet = O0000Oo2.entrySet();
                    ArrayList arrayList3 = new ArrayList();
                    for (Map.Entry next : entrySet) {
                        DeviceTagInterface.Category O00000o2 = fnn.O000000o().O00000Oo().O00000o((String) next.getKey());
                        if (!(O00000o2 == null || next.getValue() == null || ((List) next.getValue()).size() <= 0)) {
                            arrayList3.add(O00000o2);
                        }
                    }
                    if (arrayList3.size() > 0) {
                        arrayList2 = O000000o((ArrayList<DeviceTagInterface.Category>) arrayList3);
                    }
                }
                if (O000000o3.size() > 0) {
                    this.O0000o0o.O000000o((Integer) 0, O000000o3);
                    if (arrayList2.size() > 0) {
                        this.O0000o0o.O00000Oo((Integer) 1, this.O0000OoO);
                        this.O0000o0o.O00000Oo((Integer) 2, (List<hrw>) arrayList2);
                    }
                } else if (arrayList2.size() > 0) {
                    this.O0000o0o.O000000o((Integer) 0, (List<hrw>) arrayList2);
                } else {
                    hrw hrw = new hrw();
                    hrw.f578O000000o = 0;
                    hrw.O00000o0 = this.O00000o0.getId();
                    hrw.O00000Oo = this.O00000o0.getName();
                    this.O0000o0o.O000000o((Integer) 0, hrw);
                }
                this.O0000o0o.notifyDataSetChanged();
            }
        }
    }

    public final void O000000o(boolean z) {
        View view;
        this.O0000Oo0 = -1;
        ViewGroup viewGroup = this.O0000Ooo;
        if (viewGroup != null && viewGroup.indexOfChild(this.O0000o00) >= 0) {
            this.O0000Ooo.removeView(this.O0000o00);
        }
        if (z && (view = this.O00000oO) != null) {
            ViewPropertyAnimator startDelay = view.findViewById(R.id.arrow_down_img).animate().rotation(0.0f).setDuration(125).setStartDelay(125);
            startDelay.setInterpolator(new AccelerateDecelerateInterpolator());
            startDelay.start();
        }
    }

    public final void O00000o0() {
        if (this.O0000o == null) {
            O000000o();
        }
        Home home = this.O0000o;
        if (home != null) {
            DeviceTagInterface.Category category = this.O0000oO;
            if (category != null) {
                O000000o(home, category);
                return;
            }
            Room room = this.O0000oO0;
            if (room != null) {
                O000000o(home, room);
            } else {
                O000000o(home, this.O00000o0);
            }
        } else {
            O000000o((Home) null);
        }
    }

    private static List<hrw> O000000o(List<Room> list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (Room next : list) {
                if (next != null && !TextUtils.isEmpty(next.getId()) && !TextUtils.isEmpty(next.getName())) {
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

    private static List<hrw> O000000o(ArrayList<DeviceTagInterface.Category> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator<DeviceTagInterface.Category> it = arrayList.iterator();
            while (it.hasNext()) {
                DeviceTagInterface.Category next = it.next();
                if (next != null && !TextUtils.isEmpty(next.id) && !TextUtils.isEmpty(next.name)) {
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
        if (i == 0 ? this.O0000oO0 == null || !TextUtils.equals(hrw.O00000o0, this.O0000oO0.getId()) : i == 2 ? this.O0000oO == null || !TextUtils.equals(hrw.O00000o0, this.O0000oO.id) : i != 3 || this.O0000o == null || !TextUtils.equals(hrw.O00000o0, this.O0000o.getId())) {
            z = false;
        }
        textView.setSelected(z);
        textView.setOnClickListener(new View.OnClickListener(hrw) {
            /* class _m_j.$$Lambda$hrv$dn66Ov_7z5qMLevd6bdXewJXU4 */
            private final /* synthetic */ hrw f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                hrv.this.O000000o(this.f$1, view);
            }
        });
        return textView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(hrw hrw, View view) {
        int i = hrw.f578O000000o;
        if (i != 0) {
            if (i != 2) {
                if (i == 3 && !TextUtils.isEmpty(hrw.O00000o0)) {
                    this.O0000o = ggb.O00000Oo().O00000o(hrw.O00000o0);
                    O00000o();
                }
            } else if (!TextUtils.isEmpty(hrw.O00000o0)) {
                this.O0000oO0 = null;
                this.O0000oO = fnn.O000000o().O00000Oo().O0000OOo(hrw.O00000o0);
                O000000o(this.O0000o, this.O0000oO);
            }
        } else if (!TextUtils.isEmpty(hrw.O00000o0)) {
            if (TextUtils.equals(this.O00000o0.getId(), hrw.O00000o0)) {
                this.O0000oO0 = this.O00000o0;
            } else if (TextUtils.equals(this.O00000o.getId(), hrw.O00000o0)) {
                this.O0000oO0 = this.O00000o;
            } else {
                this.O0000oO0 = ggb.O00000Oo().O00000o0(hrw.O00000o0);
            }
            this.O0000oO = null;
            O000000o(this.O0000o, this.O0000oO0);
        }
        O000000o(hrw.f578O000000o == 3);
    }

    public final void O00000o() {
        if (this.O0000o != null) {
            this.O0000oO0 = this.O00000o0;
            this.O0000oO = null;
        }
        O000000o(this.O0000o);
        TextView textView = this.O0000o0O;
        if (textView != null) {
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(this.O0000o));
        }
        O000000o(this.O0000o);
    }

    public class O00000Oo extends RecyclerView.O000000o<O000000o> {
        private Map<Integer, List<hrw>> O00000Oo = new HashMap();

        public final long getItemId(int i) {
            return (long) i;
        }

        public O00000Oo() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O000000o o000000o = (O000000o) o000OOo0;
            o000000o.f576O000000o.removeAllViews();
            if (this.O00000Oo.get(Integer.valueOf(i)) != null && !this.O00000Oo.get(Integer.valueOf(i)).isEmpty()) {
                if (((hrw) this.O00000Oo.get(Integer.valueOf(i)).get(0)).f578O000000o == 1) {
                    View view = new View(o000000o.f576O000000o.getContext());
                    view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, gpc.O000000o(0.5f)));
                    view.setBackgroundResource(R.color.mj_color_black_15_transparent);
                    o000000o.f576O000000o.addView(view);
                    ViewGroup.LayoutParams layoutParams = o000000o.f576O000000o.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                        o000000o.f576O000000o.setLayoutParams(layoutParams);
                    }
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.topMargin = gpc.O000000o(20.0f);
                        if (getItemCount() > 2) {
                            marginLayoutParams.bottomMargin = gpc.O000000o(20.0f);
                        } else {
                            marginLayoutParams.bottomMargin = 0;
                        }
                        o000000o.f576O000000o.setLayoutParams(marginLayoutParams);
                        return;
                    }
                    return;
                }
                if (i > 0 && ((hrw) this.O00000Oo.get(Integer.valueOf(i - 1)).get(0)).f578O000000o == 1) {
                    ViewGroup.LayoutParams layoutParams2 = o000000o.f576O000000o.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        marginLayoutParams2.topMargin = 0;
                        o000000o.f576O000000o.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i2 = 0; i2 < this.O00000Oo.get(Integer.valueOf(i)).size(); i2++) {
                    hrv hrv = hrv.this;
                    o000000o.f576O000000o.addView(hrv.O000000o(hrv.O00000Oo, (hrw) this.O00000Oo.get(Integer.valueOf(i)).get(i2), o000000o.f576O000000o));
                }
            }
        }

        public final void O000000o(Integer num, List<hrw> list) {
            this.O00000Oo.clear();
            if (list != null && !list.isEmpty()) {
                if (this.O00000Oo.containsKey(num)) {
                    this.O00000Oo.get(num).clear();
                } else {
                    this.O00000Oo.put(num, new ArrayList());
                }
                this.O00000Oo.get(num).addAll(list);
            }
        }

        public final void O000000o(Integer num, hrw hrw) {
            this.O00000Oo.clear();
            if (this.O00000Oo.containsKey(num)) {
                this.O00000Oo.get(num).clear();
            } else {
                this.O00000Oo.put(num, new ArrayList());
            }
            this.O00000Oo.get(num).add(hrw);
        }

        public final void O00000Oo(Integer num, List<hrw> list) {
            if (list != null && !list.isEmpty()) {
                if (this.O00000Oo.containsKey(num)) {
                    this.O00000Oo.get(num).clear();
                } else {
                    this.O00000Oo.put(num, new ArrayList());
                }
                this.O00000Oo.get(num).addAll(list);
            }
        }

        public final void O00000Oo(Integer num, hrw hrw) {
            if (hrw != null) {
                if (this.O00000Oo.containsKey(num)) {
                    this.O00000Oo.get(num).clear();
                } else {
                    this.O00000Oo.put(num, new ArrayList());
                }
                this.O00000Oo.get(num).add(hrw);
            }
        }

        public final int getItemCount() {
            Map<Integer, List<hrw>> map = this.O00000Oo;
            if (map == null) {
                return 0;
            }
            return map.size();
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(new FlowLayoutCopy(hrv.this.O00000Oo));
        }
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public FlowLayoutCopy f576O000000o;

        public O000000o(View view) {
            super(view);
            this.f576O000000o = (FlowLayoutCopy) view;
            this.f576O000000o.setSingleLine(false);
            this.f576O000000o.setItemSpacing(gpc.O000000o(10.0f));
            this.f576O000000o.setLineSpacing(gpc.O000000o(14.0f));
        }
    }
}

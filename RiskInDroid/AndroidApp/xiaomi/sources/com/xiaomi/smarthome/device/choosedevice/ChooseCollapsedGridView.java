package com.xiaomi.smarthome.device.choosedevice;

import _m_j.fmg;
import _m_j.fpt;
import _m_j.fpv;
import _m_j.go;
import _m_j.gpc;
import _m_j.hxi;
import _m_j.hzf;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.DeviceFactory;
import java.util.ArrayList;
import java.util.List;

public class ChooseCollapsedGridView extends ConstraintLayout {
    private static int O0000OoO = 8;

    /* renamed from: O000000o  reason: collision with root package name */
    public final TextView f7216O000000o;
    public final View O00000Oo;
    public fmg.O00000o0 O00000o;
    public O000000o O00000o0;
    public String O00000oO;
    public int O00000oo;
    public int O0000O0o;
    private final RecyclerView O0000OOo;
    private float O0000Oo;
    private Context O0000Oo0;
    private O00000Oo O0000Ooo;

    public interface O00000Oo {
    }

    public ChooseCollapsedGridView(Context context) {
        this(context, null);
    }

    public ChooseCollapsedGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseCollapsedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflate(context, R.layout.choose_device_grid_layout, this);
        this.O0000Oo0 = context;
        this.f7216O000000o = (TextView) findViewById(R.id.category_name);
        this.O0000OOo = (RecyclerView) findViewById(R.id.recycler);
        this.O00000Oo = findViewById(R.id.show_more);
        this.O0000O0o = getResources().getDimensionPixelOffset(R.dimen.choose_category_device_item_width);
        this.O0000Oo = getResources().getDisplayMetrics().density;
        this.O00000oo = hzf.O000000o(context, (int) (((float) this.O0000O0o) / this.O0000Oo), O0000OoO);
        this.O0000OOo.setLayoutManager(new GridLayoutManager(context, this.O00000oo));
        this.O00000o0 = new O000000o();
        this.O0000OOo.setAdapter(this.O00000o0);
        this.O0000OOo.addItemDecoration(new O00000o0(this, (byte) 0));
        go goVar = new go();
        goVar.O0000o00 = false;
        this.O0000OOo.setItemAnimator(goVar);
        this.O0000OOo.setHasFixedSize(true);
        RecyclerView recyclerView = this.O0000OOo;
        if (fpt.O00000Oo == null) {
            fpt.O00000Oo = new fpt();
        }
        fpt fpt = fpt.O00000Oo;
        if (fpt.f16886O000000o == null) {
            fpt.f16886O000000o = new RecyclerView.O000O00o();
            fpt.f16886O000000o.O000000o(6050, 20);
        }
        recyclerView.setRecycledViewPool(fpt.f16886O000000o);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseCollapsedGridView$S2ugIky58rrT_gFJIojPGFXpAc */

            public final void onClick(View view) {
                ChooseCollapsedGridView.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        view.post(new Runnable(view) {
            /* class com.xiaomi.smarthome.device.choosedevice.$$Lambda$ChooseCollapsedGridView$ibhqxnkRQL0l37D7B7xWQWj902A */
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ChooseCollapsedGridView.this.O00000Oo(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        view.setVisibility(8);
        this.O00000o0.O000000o();
        fpv O000000o2 = fpv.O000000o();
        String str = this.O00000oO;
        if (!O000000o2.f16891O000000o.contains(str)) {
            O000000o2.f16891O000000o.add(str);
        }
    }

    public void setChooseDeviceListener(fmg.O00000o0 o00000o0) {
        this.O00000o = o00000o0;
    }

    public final boolean O000000o(int i) {
        return i > 1000 && !fpv.O000000o().O000000o(this.O00000oO);
    }

    public class O000000o extends RecyclerView.O000000o<C0069O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f7217O000000o;
        private final List<Pair<String, List<PluginDeviceInfo>>> O00000o = new ArrayList();
        private final List<Pair<String, List<PluginDeviceInfo>>> O00000o0 = new ArrayList();

        public final int getItemViewType(int i) {
            return 6050;
        }

        @SuppressLint({"SetTextI18n"})
        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            C0069O000000o o000000o = (C0069O000000o) o000OOo0;
            Pair pair = this.O00000o.get(i);
            o000000o.itemView.getContext();
            o000000o.f7218O000000o.setText((String) pair.first);
            DeviceFactory.O00000Oo(((PluginDeviceInfo) ((List) pair.second).get(0)).O00000Oo(), o000000o.O00000Oo);
            o000000o.itemView.setOnClickListener(new View.OnClickListener(pair) {
                /* class com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView.O000000o.C0069O000000o.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Pair f7219O000000o;

                {
                    this.f7219O000000o = r2;
                }

                public final void onClick(View view) {
                    if (ChooseCollapsedGridView.this.O00000o != null) {
                        ChooseCollapsedGridView.this.O00000o.chooseCategory(O000000o.this.f7217O000000o, (String) this.f7219O000000o.first, (List) this.f7219O000000o.second);
                    }
                }
            });
        }

        O000000o() {
        }

        public final void O000000o(List<Pair<String, List<PluginDeviceInfo>>> list, boolean z) {
            this.O00000o.clear();
            this.O00000o0.clear();
            this.O00000o0.addAll(list);
            if (!z || !ChooseCollapsedGridView.this.O000000o(list.size())) {
                this.O00000o.addAll(list);
            } else {
                this.O00000o.addAll(list.subList(0, 1000));
            }
            notifyDataSetChanged();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            if (this.O00000o.size() != this.O00000o0.size()) {
                O000000o(new ArrayList(this.O00000o0), false);
                hxi.O00000o.O00000o0(this.f7217O000000o, this.O00000o0.size());
            }
        }

        /* renamed from: com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView$O000000o$O000000o  reason: collision with other inner class name */
        class C0069O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f7218O000000o;
            SimpleDraweeView O00000Oo;

            C0069O000000o(View view) {
                super(view);
                this.f7218O000000o = (TextView) view.findViewById(R.id.name);
                this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.image);
            }
        }

        public final int getItemCount() {
            return this.O00000o.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0069O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.choose_device_list_item, viewGroup, false));
        }
    }

    class O00000o0 extends RecyclerView.O0000Oo {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(ChooseCollapsedGridView chooseCollapsedGridView, byte b) {
            this();
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            int O00000Oo = ((gpc.O00000Oo(ChooseCollapsedGridView.this.getContext()) - gpc.O00000o0(ChooseCollapsedGridView.this.getContext(), 40.0f)) - (ChooseCollapsedGridView.this.O0000O0o * ChooseCollapsedGridView.this.O00000oo)) / (ChooseCollapsedGridView.this.O00000oo * 2);
            rect.right = O00000Oo;
            rect.left = O00000Oo;
            int O00000o0 = gpc.O00000o0(ChooseCollapsedGridView.this.getContext(), 5.0f);
            rect.bottom = O00000o0;
            rect.top = O00000o0;
        }
    }

    public void setOnManualCategoryDeviceClicked(O00000Oo o00000Oo) {
        this.O0000Ooo = o00000Oo;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int O000000o2 = hzf.O000000o(this.O0000Oo0, (int) (((float) this.O0000O0o) / this.O0000Oo), O0000OoO);
        if (this.O00000oo != O000000o2) {
            this.O00000oo = O000000o2;
            this.O0000OOo.setLayoutManager(new GridLayoutManager(this.O0000Oo0, this.O00000oo));
            this.O00000o0.O000000o();
        }
    }
}

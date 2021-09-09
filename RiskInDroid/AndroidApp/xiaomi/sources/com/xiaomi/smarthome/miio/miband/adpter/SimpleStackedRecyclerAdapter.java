package com.xiaomi.smarthome.miio.miband.adpter;

import _m_j.gxg;
import _m_j.gxh;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class SimpleStackedRecyclerAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<gxh> f9751O000000o = new ArrayList();
    public int O00000Oo = -1;
    public int O00000o = 3;
    public int O00000o0 = 34;
    public Resources O00000oO;
    public O000000o O00000oo;
    private float O0000O0o;
    private Context O0000OOo;
    private float O0000Oo = -1.0f;
    private SparseIntArray O0000Oo0 = new SparseIntArray();
    private float O0000OoO = -1.0f;

    public interface O000000o {
        void O000000o(gxh gxh);
    }

    public SimpleStackedRecyclerAdapter(Context context) {
        this.O0000OOo = context;
        this.O00000oO = this.O0000OOo.getResources();
        this.O0000O0o = this.O00000oO.getDisplayMetrics().density;
    }

    public final void O000000o(List<gxh> list) {
        if (list == null) {
            this.f9751O000000o.clear();
        } else {
            this.f9751O000000o = list;
        }
    }

    public final gxh O000000o() {
        int i = this.O00000Oo;
        if (i <= 0 || i >= this.f9751O000000o.size() + 1) {
            return null;
        }
        return this.f9751O000000o.get(this.O00000Oo - 1);
    }

    public final void O000000o(float f, float f2) {
        this.O0000Oo = f;
        this.O0000OoO = f2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new O00000o0(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_sleep_list_item_view, viewGroup, false));
        }
        if (i == 0) {
            return new O00000Oo(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_sleep_list_item_view, viewGroup, false));
        }
        if (i == 2) {
            return new O00000Oo(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_sleep_list_item_view, viewGroup, false));
        }
        return new O00000o0(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_sleep_list_item_view, viewGroup, false));
    }

    public final void O00000Oo() {
        this.O00000Oo = 1;
        this.O0000Oo0.clear();
        super.notifyDataSetChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        if (o000OOo0 instanceof O00000o0) {
            O00000o0 o00000o0 = (O00000o0) o000OOo0;
            final gxh gxh = this.f9751O000000o.get(i - 1);
            ViewGroup.LayoutParams layoutParams = o00000o0.O00000Oo.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = o00000o0.O00000o0.getLayoutParams();
            ViewGroup.LayoutParams layoutParams3 = o00000o0.O00000o.getLayoutParams();
            float f = (float) (gxh.O00000Oo + gxh.f18464O000000o);
            float f2 = this.O0000Oo;
            float f3 = 0.0f;
            float f4 = 110.0f;
            if (f2 != -1.0f) {
                float f5 = this.O0000OoO;
                if (!(f5 == -1.0f || f2 == 0.0f)) {
                    if (f2 == f5) {
                        f = this.O0000O0o;
                    } else {
                        f4 = (this.O0000O0o * 220.0f) / f2;
                    }
                    f3 = f * f4;
                    if (f3 >= 0.01f) {
                        o00000o0.O00000Oo.setVisibility(8);
                        o00000o0.O00000o0.setVisibility(8);
                    } else {
                        o00000o0.O00000Oo.setVisibility(0);
                        o00000o0.O00000o0.setVisibility(0);
                        float f6 = this.O0000O0o;
                        layoutParams.width = (int) (f6 * 32.0f);
                        layoutParams2.width = (int) (f6 * 32.0f);
                        double d = (double) f3;
                        double d2 = (double) gxh.O00000Oo;
                        Double.isNaN(d2);
                        double d3 = (double) (gxh.O00000Oo + gxh.f18464O000000o);
                        Double.isNaN(d3);
                        Double.isNaN(d);
                        layoutParams.height = (int) (((d2 * 1.0d) / d3) * d);
                        double d4 = (double) gxh.f18464O000000o;
                        Double.isNaN(d4);
                        Double.isNaN(d);
                        double d5 = d * d4 * 1.0d;
                        double d6 = (double) (gxh.f18464O000000o + gxh.O00000Oo);
                        Double.isNaN(d6);
                        layoutParams2.height = (int) (d5 / d6);
                        layoutParams3.height = (int) f3;
                        o00000o0.O00000o.setMinimumHeight(layoutParams3.height);
                        o00000o0.O00000o.setLayoutParams(layoutParams3);
                        o00000o0.O00000Oo.setMinimumHeight(layoutParams.height);
                        o00000o0.O00000Oo.setLayoutParams(layoutParams);
                        o00000o0.O00000o0.setMinimumHeight(layoutParams2.height);
                        o00000o0.O00000o0.setLayoutParams(layoutParams2);
                    }
                    if (this.O00000Oo != i) {
                        o00000o0.f9755O000000o.setTextColor(this.O0000OOo.getResources().getColor(R.color.mj_color_bg_select_text));
                        o00000o0.O00000Oo.setBackgroundResource(R.drawable.miband_deep_sleep_bar_select);
                        o00000o0.O00000o0.setBackgroundResource(R.drawable.miband_shallow_sleep_bar_select);
                    } else {
                        o00000o0.f9755O000000o.setTextColor(this.O0000OOo.getResources().getColor(R.color.mj_color_gray_lighter));
                        o00000o0.O00000Oo.setBackgroundResource(R.drawable.miband_deep_sleep_bar_normal);
                        o00000o0.O00000o0.setBackgroundResource(R.drawable.miband_shallow_sleep_bar_normal);
                    }
                    o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.miband.adpter.SimpleStackedRecyclerAdapter.AnonymousClass1 */

                        public final void onClick(View view) {
                            SimpleStackedRecyclerAdapter simpleStackedRecyclerAdapter = SimpleStackedRecyclerAdapter.this;
                            simpleStackedRecyclerAdapter.O00000Oo = i;
                            simpleStackedRecyclerAdapter.notifyDataSetChanged();
                        }
                    });
                    o00000o0.itemView.getLayoutParams().width = (int) (((float) this.O00000o0) * this.O0000O0o);
                    o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.miband.adpter.SimpleStackedRecyclerAdapter.AnonymousClass2 */

                        public final void onClick(View view) {
                            if (SimpleStackedRecyclerAdapter.this.O00000oo != null) {
                                SimpleStackedRecyclerAdapter simpleStackedRecyclerAdapter = SimpleStackedRecyclerAdapter.this;
                                simpleStackedRecyclerAdapter.O00000Oo = i;
                                simpleStackedRecyclerAdapter.O00000oo.O000000o(gxh);
                                SimpleStackedRecyclerAdapter.this.notifyDataSetChanged();
                            }
                        }
                    });
                    o00000o0.f9755O000000o.setText(gxg.O000000o(this.O0000OOo, this.O00000o, gxh.O0000O0o));
                    if (this.O0000Oo0.get(i, -1) != -1) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        o00000o0.O00000o.setPivotY((float) o00000o0.O00000o.getLayoutParams().height);
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o00000o0.O00000o, "scaleY", 0.0f, 1.0f);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(o00000o0.O00000o, "alpha", 0.0f, 1.0f);
                        animatorSet.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat(o00000o0.f9755O000000o, "scaleX", 0.0f, 1.0f));
                        animatorSet.setDuration(600L);
                        animatorSet.start();
                        this.O0000Oo0.put(i, i);
                        return;
                    }
                    return;
                }
            }
            if (((double) f) >= 0.001d) {
                f = this.O0000O0o;
                f3 = f * f4;
            }
            if (f3 >= 0.01f) {
            }
            if (this.O00000Oo != i) {
            }
            o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.adpter.SimpleStackedRecyclerAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    SimpleStackedRecyclerAdapter simpleStackedRecyclerAdapter = SimpleStackedRecyclerAdapter.this;
                    simpleStackedRecyclerAdapter.O00000Oo = i;
                    simpleStackedRecyclerAdapter.notifyDataSetChanged();
                }
            });
            o00000o0.itemView.getLayoutParams().width = (int) (((float) this.O00000o0) * this.O0000O0o);
            o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.adpter.SimpleStackedRecyclerAdapter.AnonymousClass2 */

                public final void onClick(View view) {
                    if (SimpleStackedRecyclerAdapter.this.O00000oo != null) {
                        SimpleStackedRecyclerAdapter simpleStackedRecyclerAdapter = SimpleStackedRecyclerAdapter.this;
                        simpleStackedRecyclerAdapter.O00000Oo = i;
                        simpleStackedRecyclerAdapter.O00000oo.O000000o(gxh);
                        SimpleStackedRecyclerAdapter.this.notifyDataSetChanged();
                    }
                }
            });
            o00000o0.f9755O000000o.setText(gxg.O000000o(this.O0000OOo, this.O00000o, gxh.O0000O0o));
            if (this.O0000Oo0.get(i, -1) != -1) {
            }
        }
    }

    public int getItemCount() {
        return this.f9751O000000o.size() + 2;
    }

    public final class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f9755O000000o;
        View O00000Oo;
        View O00000o;
        View O00000o0;

        public O00000o0(View view) {
            super(view);
            this.f9755O000000o = (TextView) view.findViewById(R.id.date_tv);
            this.O00000Oo = view.findViewById(R.id.bottom_bar);
            this.O00000o0 = view.findViewById(R.id.top_bar);
            this.O00000o = view.findViewById(R.id.rl_bar_container);
        }
    }

    public final class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f9754O000000o;
        View O00000Oo;
        View O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.f9754O000000o = (TextView) view.findViewById(R.id.date_tv);
            this.f9754O000000o.setVisibility(4);
            this.O00000Oo = view.findViewById(R.id.bottom_bar);
            this.O00000Oo.setVisibility(4);
            this.O00000o0 = view.findViewById(R.id.top_bar);
            this.O00000o0.setVisibility(4);
            if (SimpleStackedRecyclerAdapter.this.f9751O000000o.size() > 0) {
                view.getLayoutParams().width = (int) (((float) (SimpleStackedRecyclerAdapter.this.O00000oO.getDisplayMetrics().widthPixels / 2)) - (SimpleStackedRecyclerAdapter.this.O00000oO.getDisplayMetrics().density * 25.0f));
                return;
            }
            view.getLayoutParams().width = SimpleStackedRecyclerAdapter.this.O00000oO.getDisplayMetrics().widthPixels / 2;
        }
    }

    public int getItemViewType(int i) {
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        if (i == this.f9751O000000o.size() + 1) {
            z = true;
        }
        return z ? 2 : 1;
    }
}

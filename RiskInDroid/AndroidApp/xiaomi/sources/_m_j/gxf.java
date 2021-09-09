package _m_j;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class gxf extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<gxi> f18450O000000o = new ArrayList();
    public int O00000Oo = -1;
    public int O00000o = 3;
    public int O00000o0 = 34;
    public Resources O00000oO;
    public O000000o O00000oo;
    private float O0000O0o;
    private Context O0000OOo;
    private SparseIntArray O0000Oo = new SparseIntArray();
    private int O0000Oo0 = -1;
    private float O0000OoO = -1.0f;
    private float O0000Ooo = -1.0f;
    private LinearLayoutManager O0000o00;

    public interface O000000o {
        void O000000o(gxi gxi);
    }

    public gxf(Context context, LinearLayoutManager linearLayoutManager) {
        this.O0000OOo = context;
        this.O00000oO = this.O0000OOo.getResources();
        this.O0000O0o = this.O00000oO.getDisplayMetrics().density;
        this.O0000o00 = linearLayoutManager;
    }

    public final void O000000o(List<gxi> list) {
        if (list == null) {
            this.f18450O000000o.clear();
        } else {
            this.f18450O000000o = list;
        }
    }

    public final gxi O000000o() {
        int i = this.O00000Oo;
        if (i <= 0 || i >= this.f18450O000000o.size() + 1) {
            return null;
        }
        return this.f18450O000000o.get(this.O00000Oo - 1);
    }

    public final void O000000o(float f, float f2) {
        this.O0000OoO = f;
        this.O0000Ooo = f2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new O00000o0(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_num_list_item_view, viewGroup, false));
        }
        if (i == 0) {
            return new O00000Oo(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_num_list_item_view, viewGroup, false));
        }
        if (i == 2) {
            return new O00000Oo(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_num_list_item_view, viewGroup, false));
        }
        return new O00000o0(LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.miband_num_list_item_view, viewGroup, false));
    }

    public final void O00000Oo() {
        this.O00000Oo = 1;
        this.O0000Oo.clear();
        super.notifyDataSetChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        if (o000OOo0 instanceof O00000o0) {
            O00000o0 o00000o0 = (O00000o0) o000OOo0;
            final gxi gxi = this.f18450O000000o.get(i - 1);
            ViewGroup.LayoutParams layoutParams = o00000o0.O00000Oo.getLayoutParams();
            float f = (float) gxi.O0000O0o;
            float f2 = this.O0000OoO;
            float f3 = 0.0f;
            float f4 = 110.0f;
            if (f2 != -1.0f) {
                float f5 = this.O0000Ooo;
                if (!(f5 == -1.0f || f2 == 0.0f)) {
                    if (f2 == f5) {
                        f = this.O0000O0o;
                    } else {
                        f4 = (this.O0000O0o * 220.0f) / f2;
                    }
                    f3 = f * f4;
                    if (f3 >= 0.01f) {
                        o00000o0.O00000Oo.setVisibility(8);
                    } else {
                        o00000o0.O00000Oo.setVisibility(0);
                        layoutParams.width = (int) (this.O0000O0o * 32.0f);
                        layoutParams.height = (int) f3;
                        o00000o0.O00000Oo.setMinimumHeight(layoutParams.height);
                        o00000o0.O00000Oo.setLayoutParams(layoutParams);
                    }
                    if (this.O00000Oo != i) {
                        o00000o0.f18454O000000o.setTextColor(this.O0000OOo.getResources().getColor(R.color.mj_color_bg_select_text));
                        o00000o0.O00000Oo.setBackgroundResource(R.drawable.miband_num_bar_bg_sel);
                    } else {
                        o00000o0.f18454O000000o.setTextColor(this.O0000OOo.getResources().getColor(R.color.mj_color_gray_lighter));
                        o00000o0.O00000Oo.setBackgroundResource(R.drawable.miband_num_bar_bg_nor);
                    }
                    o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.gxf.AnonymousClass1 */

                        public final void onClick(View view) {
                            gxf gxf = gxf.this;
                            gxf.O00000Oo = i;
                            gxf.notifyDataSetChanged();
                        }
                    });
                    o00000o0.itemView.getLayoutParams().width = (int) (((float) this.O00000o0) * this.O0000O0o);
                    o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.gxf.AnonymousClass2 */

                        public final void onClick(View view) {
                            if (gxf.this.O00000oo != null) {
                                gxf gxf = gxf.this;
                                gxf.O00000Oo = i;
                                gxf.O00000oo.O000000o(gxi);
                                gxf.this.notifyDataSetChanged();
                            }
                        }
                    });
                    o00000o0.f18454O000000o.setText(gxg.O000000o(this.O0000OOo, this.O00000o, gxi.O0000Oo0));
                    if (this.O0000Oo.get(i, -1) != -1) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        o00000o0.O00000Oo.setPivotY((float) o00000o0.O00000Oo.getLayoutParams().height);
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o00000o0.O00000Oo, "scaleY", 0.0f, 1.0f);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(o00000o0.O00000Oo, "alpha", 0.0f, 1.0f);
                        animatorSet.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat(o00000o0.f18454O000000o, "scaleX", 0.0f, 1.0f));
                        animatorSet.setDuration(600L);
                        animatorSet.start();
                        this.O0000Oo0 = i;
                        this.O0000Oo.put(i, i);
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
                /* class _m_j.gxf.AnonymousClass1 */

                public final void onClick(View view) {
                    gxf gxf = gxf.this;
                    gxf.O00000Oo = i;
                    gxf.notifyDataSetChanged();
                }
            });
            o00000o0.itemView.getLayoutParams().width = (int) (((float) this.O00000o0) * this.O0000O0o);
            o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gxf.AnonymousClass2 */

                public final void onClick(View view) {
                    if (gxf.this.O00000oo != null) {
                        gxf gxf = gxf.this;
                        gxf.O00000Oo = i;
                        gxf.O00000oo.O000000o(gxi);
                        gxf.this.notifyDataSetChanged();
                    }
                }
            });
            o00000o0.f18454O000000o.setText(gxg.O000000o(this.O0000OOo, this.O00000o, gxi.O0000Oo0));
            if (this.O0000Oo.get(i, -1) != -1) {
            }
        }
    }

    public final int getItemCount() {
        return this.f18450O000000o.size() + 2;
    }

    public final class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f18454O000000o;
        View O00000Oo;

        public O00000o0(View view) {
            super(view);
            this.f18454O000000o = (TextView) view.findViewById(R.id.date_tv);
            this.O00000Oo = view.findViewById(R.id.v_bar);
        }
    }

    public final class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f18453O000000o;
        View O00000Oo;

        public O00000Oo(View view) {
            super(view);
            this.f18453O000000o = (TextView) view.findViewById(R.id.date_tv);
            this.O00000Oo = view.findViewById(R.id.v_bar);
            this.f18453O000000o.setVisibility(4);
            this.O00000Oo.setVisibility(4);
            if (gxf.this.f18450O000000o.size() > 0) {
                view.getLayoutParams().width = (int) (((float) (gxf.this.O00000oO.getDisplayMetrics().widthPixels / 2)) - (gxf.this.O00000oO.getDisplayMetrics().density * 25.0f));
                return;
            }
            view.getLayoutParams().width = gxf.this.O00000oO.getDisplayMetrics().widthPixels / 2;
        }
    }

    public final int getItemViewType(int i) {
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        if (i == this.f18450O000000o.size() + 1) {
            z = true;
        }
        return z ? 2 : 1;
    }
}

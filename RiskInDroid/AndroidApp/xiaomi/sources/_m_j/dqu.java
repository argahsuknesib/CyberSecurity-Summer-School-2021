package _m_j;

import _m_j.dpd;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dqu extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    int f14856O000000o = 5;
    JSONArray O00000Oo;
    ViewGroup O00000o;
    int O00000o0 = 1000000;
    int O00000oO = 0;
    private VafContext O00000oo;
    private don O0000O0o;
    private dqt O0000OOo;
    private String O0000Oo;
    private AtomicInteger O0000Oo0 = new AtomicInteger(0);
    private o0O0OOO0<String, Integer> O0000OoO = new o0O0OOO0<>();
    private o0OO00o0<String> O0000Ooo = new o0OO00o0<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        try {
            Object obj = this.O00000Oo.get(i);
            o000000o.itemView.setTag(Integer.valueOf(i));
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (2 == this.O0000OOo.O00000oO) {
                    StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) o000000o.itemView.getLayoutParams();
                    if (jSONObject.optInt("waterfall", -1) <= 0) {
                        layoutParams.O00000Oo = true;
                    } else {
                        layoutParams.O00000Oo = false;
                    }
                }
                if (jSONObject.optInt("stickyTop", -1) > 0) {
                    o000000o.f14857O000000o = true;
                    this.O00000o0 = i;
                } else {
                    o000000o.f14857O000000o = false;
                }
                o000000o.O00000Oo.O000000o(obj);
                if (o000000o.O00000Oo.O0000oo0()) {
                    this.O00000oo.O00000Oo().O000000o(1, dpj.O000000o(this.O00000oo, o000000o.O00000Oo));
                }
                o000000o.O00000Oo.O00000o0();
            } else {
                Log.e("ScrRecyAdapter_TMTEST", "failed");
            }
            int i2 = this.f14856O000000o;
            if (this.O00000Oo.length() < this.f14856O000000o) {
                i2 = 2;
            }
            if (i + i2 == this.O00000Oo.length()) {
                this.O0000OOo.O000000o();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("ScrRecyAdapter_TMTEST", "onBindViewHolder:".concat(String.valueOf(e)));
        }
    }

    public dqu(VafContext vafContext, dqt dqt) {
        this.O00000oo = vafContext;
        this.O0000OOo = dqt;
        this.O0000O0o = this.O00000oo.O0000OoO();
    }

    public final int getItemViewType(int i) {
        JSONArray jSONArray = this.O00000Oo;
        if (jSONArray != null) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("type");
                if (jSONObject.optInt("stickyTop", -1) > 0) {
                    this.O0000Oo = optString;
                }
                if (this.O0000OoO.containsKey(optString)) {
                    return this.O0000OoO.get(optString).intValue();
                }
                int andIncrement = this.O0000Oo0.getAndIncrement();
                this.O0000OoO.put(optString, Integer.valueOf(andIncrement));
                this.O0000Ooo.O00000Oo(andIncrement, optString);
                return andIncrement;
            } catch (JSONException e) {
                Log.e("ScrRecyAdapter_TMTEST", "getItemViewType:".concat(String.valueOf(e)));
            }
        } else {
            Log.e("ScrRecyAdapter_TMTEST", "getItemViewType data is null");
            return -1;
        }
    }

    public final int getItemCount() {
        JSONArray jSONArray = this.O00000Oo;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f14857O000000o = false;
        public dpf O00000Oo;

        public O000000o(View view, dpf dpf) {
            super(view);
            this.O00000Oo = dpf;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.don.O000000o(java.lang.String, boolean):android.view.View
     arg types: [java.lang.String, int]
     candidates:
      _m_j.don.O000000o(_m_j.dom, int):void
      _m_j.don.O000000o(java.lang.String, boolean):android.view.View */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        View view2;
        int i2;
        StaggeredGridLayoutManager.LayoutParams layoutParams = null;
        String O000000o2 = this.O0000Ooo.O000000o(i, null);
        if (2 == this.O0000OOo.O00000oO) {
            view = this.O0000O0o.O000000o(O000000o2, false);
            dpd.O000000o O000O0oo = ((dpb) view).getVirtualView().O000O0oo();
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(O000O0oo.f14826O000000o, O000O0oo.O00000Oo);
            view.setLayoutParams(layoutParams2);
            layoutParams = layoutParams2;
        } else {
            view = this.O0000O0o.O000000o(O000000o2);
        }
        if (O000000o2 == this.O0000Oo) {
            dpd.O000000o O000O0oo2 = ((dpb) view).getVirtualView().O000O0oo();
            this.O00000o = new FrameLayout(this.O00000oo.O0000O0o());
            if (2 == this.O0000OOo.O00000oO) {
                layoutParams = new StaggeredGridLayoutManager.LayoutParams(O000O0oo2.f14826O000000o, O000O0oo2.O00000Oo);
                this.O00000o.setLayoutParams(layoutParams);
            }
            this.O00000o.addView(view, O000O0oo2.f14826O000000o, O000O0oo2.O00000Oo);
            view2 = this.O00000o;
        } else {
            view2 = view;
        }
        if (!(layoutParams == null || (i2 = this.O00000oO) == 0)) {
            int i3 = i2 >> 1;
            if (this.O0000OOo.O00000Oo.canScrollVertically()) {
                layoutParams.setMargins(i3, 0, i3, 0);
            } else {
                layoutParams.setMargins(0, i3, 0, i3);
            }
        }
        return new O000000o(view2, ((dpb) view).getVirtualView());
    }
}

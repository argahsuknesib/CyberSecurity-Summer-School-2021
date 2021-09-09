package _m_j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class ddi extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private static final String O00000Oo = "_m_j.ddi";

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14495O000000o = -1;
    private int O00000o;
    private List<fcj> O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private float O0000Oo0;

    public ddi(List<fcj> list, int i, int i2, int i3, int i4, int i5, float f) {
        this.O00000o0 = list;
        list.add(0, new fcj("", ""));
        list.add(new fcj("", ""));
        this.O00000oO = i2;
        this.O00000oo = i3;
        this.O00000o = i;
        this.O0000O0o = i4;
        this.O0000OOo = i5;
        this.O0000Oo0 = f;
        gsy.O000000o(3, O00000Oo, "const ".concat(String.valueOf(i3)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (2 == i) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.chooser_item, viewGroup, false);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            layoutParams.height = this.O00000oo + gpc.O000000o(39.0f);
            String str = O00000Oo;
            gsy.O000000o(3, str, "height" + this.O00000oo);
            view.setLayoutParams(layoutParams);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.chooser_item, viewGroup, false);
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
            layoutParams2.height = this.O00000o;
            view.setLayoutParams(layoutParams2);
        }
        return new ddj(view);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        String str = O00000Oo;
        gsy.O000000o(3, str, "height" + this.O00000oo);
        if (o000OOo0 instanceof ddj) {
            ddj ddj = (ddj) o000OOo0;
            ddj.f14497O000000o.setText(this.O00000o0.get(i).f16082O000000o);
            if (i == this.f14495O000000o) {
                ddj.f14497O000000o.setTextSize(0, (float) this.O00000oo);
                ddj.f14497O000000o.setTextColor(this.O00000oO);
                return;
            }
            ddj.f14497O000000o.setTextSize(0, (float) this.O0000OOo);
            ddj.f14497O000000o.setTextColor(this.O0000O0o);
        }
    }

    public int getItemViewType(int i) {
        return (i == 0 || i == getItemCount() - 1) ? 1 : 2;
    }

    public int getItemCount() {
        List<fcj> list = this.O00000o0;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}

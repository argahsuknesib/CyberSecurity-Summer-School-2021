package _m_j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hannto.print.bean.PhotoBean;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.LinkedList;

public final class O00O00Oo extends jz {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f6623O000000o;
    public ArrayList<PhotoBean> O00000Oo;
    public LinkedList<View> O00000o0 = new LinkedList<>();

    public O00O00Oo(Context context, ArrayList<PhotoBean> arrayList) {
        this.f6623O000000o = context;
        this.O00000Oo = arrayList;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.O00000o0.add(view);
    }

    public final int getCount() {
        return this.O00000Oo.size();
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.O00000o0.size() == 0 ? View.inflate(this.f6623O000000o, R.layout.ht_item_image_pick, null) : this.O00000o0.removeFirst();
        uo.O000000o(this.f6623O000000o).O000000o(this.O00000Oo.get(i).imageUri).O000000o((ImageView) inflate.findViewById(R.id.imageview_item));
        viewGroup.addView(inflate);
        return inflate;
    }
}

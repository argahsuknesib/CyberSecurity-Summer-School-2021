package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class eza<T> extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f15967O000000o;
    protected List<T> O00000Oo;

    public abstract int O000000o();

    public abstract void O000000o(ezc ezc, T t, int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public eza(Context context, List<T> list) {
        this.f15967O000000o = context;
        this.O00000Oo = list;
    }

    public int getCount() {
        List<T> list = this.O00000Oo;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getItem(int i) {
        if (i < this.O00000Oo.size()) {
            return this.O00000Oo.get(i);
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        ezc ezc;
        if (view == null) {
            getItemViewType(i);
            view = LayoutInflater.from(this.f15967O000000o).inflate(O000000o(), viewGroup, false);
            ezc = ezc.O000000o(view);
            view.setTag(ezc);
        } else {
            ezc = (ezc) view.getTag();
        }
        O000000o(ezc, getItem(i), i);
        return view;
    }

    public final void O000000o(List<T> list) {
        if (list != null) {
            this.O00000Oo = list;
            notifyDataSetChanged();
        }
    }
}

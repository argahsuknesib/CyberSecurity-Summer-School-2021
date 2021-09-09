package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class ezb<T> extends RecyclerView.O000000o<ezc> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f15968O000000o;
    public List<T> O00000Oo;
    public O00000Oo O00000o;
    public O000000o O00000o0;
    public RecyclerView O00000oO;
    public final ArrayList<View> O00000oo = new ArrayList<>();
    public final ArrayList<View> O0000O0o = new ArrayList<>();

    public interface O000000o {
        void onItemClick(RecyclerView recyclerView, View view, int i);
    }

    public interface O00000Oo {
    }

    public abstract void O000000o(ezc ezc, T t, int i);

    public int O00000Oo(int i) {
        return 0;
    }

    public abstract int O00000o0(int i);

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        final ezc ezc = (ezc) o000OOo0;
        int size = this.O00000oo.size();
        if (i >= size) {
            List<T> list = this.O00000Oo;
            if (i < (list == null ? 0 : list.size()) + size) {
                if (this.O00000o0 != null) {
                    ezc.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.ezb.AnonymousClass1 */

                        public final void onClick(View view) {
                            ezb.this.O00000o0.onItemClick(ezb.this.O00000oO, view, ezc.getAdapterPosition() - ezb.this.O00000oo.size());
                        }
                    });
                }
                if (this.O00000o != null) {
                    ezc.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class _m_j.ezb.AnonymousClass2 */

                        public final boolean onLongClick(View view) {
                            ezc.getAdapterPosition();
                            ezb.this.O00000oo.size();
                            return true;
                        }
                    });
                }
                int i2 = i - size;
                O000000o(ezc, O000000o(i2), i2);
            }
        }
    }

    public ezb(Context context, List<T> list) {
        this.f15968O000000o = context;
        this.O00000Oo = list;
    }

    public final void O000000o(View view, ArrayList<View> arrayList) {
        if (!arrayList.contains(view)) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            arrayList.add(view);
            notifyDataSetChanged();
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.O00000oO = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.O00000oO = null;
    }

    public T O000000o(int i) {
        if (i < this.O00000Oo.size()) {
            return this.O00000Oo.get(i);
        }
        return null;
    }

    public final int getItemViewType(int i) {
        int size = this.O00000oo.size();
        List<T> list = this.O00000Oo;
        int size2 = list == null ? 0 : list.size();
        if (i < size) {
            return i - 2147483648;
        }
        if (i >= size + size2) {
            return (i - 2147483648) - size2;
        }
        return O00000Oo(i - size);
    }

    public int getItemCount() {
        int size = this.O00000oo.size() + this.O0000O0o.size();
        List<T> list = this.O00000Oo;
        return list == null ? size : list.size() + size;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        int i2 = i - Integer.MIN_VALUE;
        int size = this.O00000oo.size();
        if (i2 < 0 || i2 >= size) {
            int i3 = i2 - size;
            if (i3 < 0 || i3 >= this.O0000O0o.size()) {
                view = LayoutInflater.from(this.f15968O000000o).inflate(O00000o0(i), viewGroup, false);
            } else {
                view = this.O0000O0o.get(i3);
            }
        } else {
            view = this.O00000oo.get(i2);
        }
        return ezc.O000000o(view);
    }
}

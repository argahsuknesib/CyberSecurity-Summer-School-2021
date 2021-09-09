package _m_j;

import O000000o.O000000o.O000000o.O00000oO.q;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.hannto.circledialog.params.ButtonParams;
import com.hannto.circledialog.params.CircleParams;
import com.hannto.circledialog.params.ItemsParams;
import com.hannto.circledialog.params.TitleParams;
import java.util.Arrays;
import java.util.List;

public final class O00oOooO extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    public BaseAdapter f6654O000000o;

    public class O000000o implements Runnable {
        public O000000o() {
        }

        public final void run() {
            O00oOooO.this.f6654O000000o.notifyDataSetChanged();
        }
    }

    public static class O00000Oo<T> extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f6656O000000o;
        public List<T> O00000Oo;
        public int O00000o;
        public int O00000o0;
        public ItemsParams O00000oO;
        public TitleParams O00000oo;
        public ButtonParams O0000O0o;
        public ButtonParams O0000OOo;

        public class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public TextView f6657O000000o;
        }

        public O00000Oo(Context context, CircleParams circleParams) {
            List<T> asList;
            this.f6656O000000o = context;
            this.O00000oo = circleParams.O00000o0;
            this.O00000oO = circleParams.O0000O0o;
            this.O00000o0 = circleParams.O00000Oo.O0000OoO;
            this.O0000O0o = circleParams.O00000oO;
            this.O0000OOo = circleParams.O00000oo;
            int i = this.O00000oO.O0000O0o;
            this.O00000o = i == 0 ? -1 : i;
            Object obj = this.O00000oO.O00000oo;
            if (obj != null && (obj instanceof Iterable)) {
                asList = (List) obj;
            } else if (obj == null || !obj.getClass().isArray()) {
                throw new IllegalArgumentException("entity must be an Array or an Iterable.");
            } else {
                asList = Arrays.asList((Object[]) obj);
            }
            this.O00000Oo = asList;
        }

        public final int getCount() {
            List<T> list = this.O00000Oo;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final T getItem(int i) {
            List<T> list = this.O00000Oo;
            if (list != null) {
                return list.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            q qVar;
            O000000o o000000o;
            ItemsParams.O00000Oo o00000Oo;
            O00000o o00000o;
            TextView textView;
            O00000o o00000o2;
            TextView textView2;
            O00000o o00000o3;
            TextView textView3;
            O00000o o00000o4;
            TextView textView4;
            if (view == null) {
                o000000o = new O000000o();
                q qVar2 = new q(this.f6656O000000o);
                qVar2.setTextSize((float) this.O00000oO.O0000Oo0);
                qVar2.setHeight(this.O00000oO.O00000o);
                o000000o.f6657O000000o = qVar2;
                qVar2.setTag(o000000o);
                qVar = qVar2;
            } else {
                qVar = view;
                o000000o = (O000000o) view.getTag();
            }
            int i2 = 0;
            if (i == 0 && this.O00000oo == null) {
                ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{-872415232, -16737793});
                if (i == this.O00000oO.O0000Oo) {
                    o000000o.f6657O000000o.setTextColor(-16737793);
                } else {
                    o000000o.f6657O000000o.setTextColor(colorStateList);
                }
                List<T> list = this.O00000Oo;
                if (list != null) {
                    i2 = list.size();
                }
                if (i2 == 1) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        textView4 = o000000o.f6657O000000o;
                        int i3 = this.O00000o;
                        int i4 = this.O00000o0;
                        o00000o4 = new O00000o(i3, i4, i4, i4, i4);
                    } else {
                        textView3 = o000000o.f6657O000000o;
                        int i5 = this.O00000o;
                        int i6 = this.O00000o0;
                        o00000o3 = new O00000o(i5, i6, i6, i6, i6);
                        textView3.setBackgroundDrawable(o00000o3);
                    }
                } else if (Build.VERSION.SDK_INT >= 16) {
                    textView4 = o000000o.f6657O000000o;
                    int i7 = this.O00000o;
                    int i8 = this.O00000o0;
                    o00000o4 = new O00000o(i7, i8, i8, 0, 0);
                } else {
                    textView3 = o000000o.f6657O000000o;
                    int i9 = this.O00000o;
                    int i10 = this.O00000o0;
                    o00000o3 = new O00000o(i9, i10, i10, 0, 0);
                    textView3.setBackgroundDrawable(o00000o3);
                }
                textView4.setBackground(o00000o4);
            } else {
                List<T> list2 = this.O00000Oo;
                if (i == (list2 != null ? list2.size() : 0) - 1 && this.O0000O0o == null && this.O0000OOo == null) {
                    ColorStateList colorStateList2 = new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{-11776948, -16737793});
                    if (i == this.O00000oO.O0000Oo) {
                        o000000o.f6657O000000o.setTextColor(-16737793);
                    } else {
                        o000000o.f6657O000000o.setTextColor(colorStateList2);
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        textView2 = o000000o.f6657O000000o;
                        int i11 = this.O00000o;
                        int i12 = this.O00000o0;
                        o00000o2 = new O00000o(i11, 0, 0, i12, i12);
                    } else {
                        textView = o000000o.f6657O000000o;
                        int i13 = this.O00000o;
                        int i14 = this.O00000o0;
                        o00000o = new O00000o(i13, 0, 0, i14, i14);
                        textView.setBackgroundDrawable(o00000o);
                    }
                } else {
                    ColorStateList colorStateList3 = new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{-872415232, -16737793});
                    if (i == this.O00000oO.O0000Oo) {
                        o000000o.f6657O000000o.setTextColor(-16737793);
                    } else {
                        o000000o.f6657O000000o.setTextColor(colorStateList3);
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        textView2 = o000000o.f6657O000000o;
                        o00000o2 = new O00000o(this.O00000o, 0, 0, 0, 0);
                    } else {
                        textView = o000000o.f6657O000000o;
                        o00000o = new O00000o(this.O00000o, 0, 0, 0, 0);
                        textView.setBackgroundDrawable(o00000o);
                    }
                }
                textView2.setBackground(o00000o2);
            }
            List<T> list3 = this.O00000Oo;
            T t = list3 != null ? list3.get(i) : null;
            ItemsParams itemsParams = this.O00000oO;
            if (!(itemsParams == null || (o00000Oo = itemsParams.O00000Oo) == null)) {
                String O000000o2 = o00000Oo.O000000o();
                if (!TextUtils.isEmpty(O000000o2)) {
                    o000000o.f6657O000000o.setText(O000000o2);
                } else if (t == null) {
                    o000000o.f6657O000000o.setText("null");
                }
                return qVar;
            }
            o000000o.f6657O000000o.setText(String.valueOf(t.toString()));
            return qVar;
        }
    }

    public O00oOooO(Context context, CircleParams circleParams) {
        super(context);
        ItemsParams itemsParams = circleParams.O0000O0o;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setSelector(new ColorDrawable(0));
        setDivider(new ColorDrawable(-1));
        setDividerHeight(1);
        setOnItemClickListener(new O0000o(itemsParams));
        this.f6654O000000o = new O00000Oo(context, circleParams);
        setAdapter((ListAdapter) this.f6654O000000o);
    }
}

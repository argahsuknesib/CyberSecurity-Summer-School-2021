package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.widget.AutoSizeTextView;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import java.util.LinkedList;
import java.util.List;

public class hdm<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hcf<C, E, T> {
    protected int O0000o;
    protected int O0000o0o;
    protected int O0000oO;
    protected int O0000oO0;
    protected ViewGroup O0000oOO;
    private View O0000oOo;
    private int O0000oo;
    private View O0000oo0;

    public hdm(E e, T[] tArr) {
        super(e, tArr);
    }

    public void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        this.O0000oo = i2;
        this.O0000oOO = (ViewGroup) O000000o(viewGroup, (int) R.layout.miui10_card_item_text_number_wrap);
        this.O0000o0o = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
        this.O0000oO = viewGroup.getResources().getColor(R.color.mj_color_black_30_transparent);
        this.O0000o = viewGroup.getResources().getColor(R.color.mj_color_black_60_transparent);
        O0000O0o();
    }

    private void O000000o(C c, Pair<String, String> pair, boolean z, TextView textView, int i, AutoSizeTextView autoSizeTextView, TextView textView2) {
        if (z) {
            textView.setTextColor(this.O0000o0o);
            autoSizeTextView.setTextColor(this.O0000o0o);
            textView2.setTextColor(this.O0000o0o);
        } else {
            autoSizeTextView.setTextColor(this.O0000oO0);
            textView.setTextColor(this.O0000o);
            textView2.setTextColor(this.O0000oO);
        }
        autoSizeTextView.setText(TextUtils.isEmpty((CharSequence) pair.first) ? "--" : (CharSequence) pair.first);
        textView2.setText(TextUtils.isEmpty((CharSequence) pair.second) ? "" : (CharSequence) pair.second);
        hgw.O000000o(c, this.O0000oo, textView, i, autoSizeTextView, textView2);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v23, types: [android.view.View] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    public void O0000O0o() {
        TextView textView;
        View view;
        if (!this.O0000Oo0) {
            Object O000000o2 = hfa.O000000o((Object[]) this.f18773O000000o);
            Device O00000oO = O00000oO();
            hcc O00000oo = O00000oo();
            Object O00000Oo = this.O0000Ooo.O00000Oo(O00000oO, O000000o2);
            List<Pair<String, String>> list = this.O0000Ooo.O000000o(O000000o2, O00000Oo, O00000oO).f18813O000000o;
            String O00000Oo2 = this.O0000Ooo.O00000Oo(O00000oO, O000000o2, O00000Oo);
            if (!TextUtils.isEmpty(O00000Oo2)) {
                this.O0000oO0 = hyj.O00000o0.O000000o(Color.parseColor(O00000Oo2));
            } else {
                this.O0000oO0 = this.O0000oOO.getResources().getColor(R.color.mj_color_black_80_transparent);
            }
            boolean z = !(O00000oO instanceof BleDevice) && (!(O00000oo instanceof heb) || !((heb) O00000oo).O00000oO) && (!O00000oO.isOnline || this.O0000o0O != BaseCardRender.DataInitState.DONE);
            this.O0000oOO.removeAllViews();
            int size = list.size();
            int i = R.id.value;
            ViewGroup viewGroup = null;
            if (size > 1) {
                if (this.O0000oOo == null) {
                    this.O0000oOo = View.inflate(this.O0000oOO.getContext(), R.layout.miui10_card_item_text_number_complex, null);
                }
                this.O0000oOO.addView(this.O0000oOo);
                LinearLayout linearLayout = (LinearLayout) this.O0000oOo.findViewById(R.id.data);
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    linkedList.add(linearLayout.getChildAt(i2));
                }
                linearLayout.removeAllViews();
                TextView findViewById = this.O0000oOo.findViewById(R.id.desc);
                for (Pair next : list) {
                    if (linkedList.size() == 0) {
                        view = View.inflate(this.O0000oOO.getContext(), R.layout.miui10_card_item_text_number_item, viewGroup);
                    } else {
                        view = (View) linkedList.removeFirst();
                    }
                    linearLayout.addView(view);
                    O000000o(O00000oo, next, z, findViewById, size, (AutoSizeTextView) view.findViewById(i), (TextView) view.findViewById(R.id.unit));
                    viewGroup = viewGroup;
                    linkedList = linkedList;
                    linearLayout = linearLayout;
                    i = R.id.value;
                }
                textView = findViewById;
            } else {
                if (this.O0000oo0 == null) {
                    this.O0000oo0 = View.inflate(this.O0000oOO.getContext(), R.layout.miui10_card_item_text_number, null);
                }
                TextView textView2 = (TextView) this.O0000oo0.findViewById(R.id.unit);
                Pair pair = size == 1 ? list.get(0) : new Pair(null, null);
                textView = this.O0000oo0.findViewById(R.id.desc);
                O000000o(O00000oo, pair, z, textView, size, (AutoSizeTextView) this.O0000oo0.findViewById(R.id.value), (TextView) this.O0000oo0.findViewById(R.id.unit));
                TextView textView3 = (TextView) this.O0000oo0.findViewById(R.id.value);
                if (!(textView2 == null || textView3 == null)) {
                    ((ViewGroup.MarginLayoutParams) textView2.getLayoutParams()).topMargin = (int) (textView3.getTextSize() / 5.0f);
                    textView2.requestLayout();
                }
                this.O0000oOO.addView(this.O0000oo0);
            }
            String O000000o3 = this.O0000Ooo.O000000o(O00000oO, O000000o2);
            if (O000000o3 != null && textView != null) {
                textView.setText(O000000o3);
            }
        }
    }

    public final void O000000o(Object obj, Object obj2) {
        if (!this.O0000Oo0 && O00000oO() != null && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            O0000O0o();
        }
    }
}

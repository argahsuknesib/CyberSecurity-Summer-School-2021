package _m_j;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.State;

public final class hek extends hec {
    private TextView O0000o;
    private SimpleDraweeView O0000o0o;
    private String O0000oO0;
    private String O000O00o;
    private State O000O0OO = State.NOR;
    private int O000O0Oo;
    private int O00oOoOo;
    private String O00oOooo;

    public hek(hed hed) {
        super(hed);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hed.O000000o(com.xiaomi.smarthome.device.Device, java.lang.String, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
     arg types: [com.xiaomi.smarthome.device.Device, java.lang.String, java.lang.String, com.xiaomi.smarthome.newui.card.State]
     candidates:
      _m_j.hed.O000000o(android.util.ArrayMap<java.lang.String, java.lang.Object>, com.xiaomi.smarthome.device.Device, android.util.ArrayMap<java.lang.String, _m_j.hed>, java.lang.String):java.lang.Object
      _m_j.hed.O000000o(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hcc.O000000o.O000000o(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hed.O000000o(com.xiaomi.smarthome.device.Device, java.lang.String, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String */
    public final void O000000o(ViewGroup viewGroup, int i, final int i2) {
        super.O000000o(viewGroup, i, i2);
        View O000000o2 = O000000o(viewGroup, (int) R.layout.miui10_card_item_single_button);
        final TextView textView = (TextView) O000000o2.findViewById(R.id.desc);
        this.O000O0Oo = textView.getCurrentTextColor();
        this.O00oOoOo = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
        this.O0000o = textView;
        final SimpleDraweeView simpleDraweeView = (SimpleDraweeView) O000000o2.findViewById(R.id.image);
        this.O0000o0o = simpleDraweeView;
        final Device O00000oO = O00000oO();
        hgw.O000000o(i2, O00000oo(), textView, simpleDraweeView);
        String str = ((hdb) this.O00000o0.get(0)).O00000Oo;
        final String str2 = (String) hfa.O000000o((Object[]) this.f18773O000000o);
        this.O00oOooo = ((hed) this.O0000Ooo).O000000o(O00000oO, str2, (Object) str, State.NOR);
        this.O0000oO0 = ((hed) this.O0000Ooo).O000000o(O00000oO, str2, (Object) str, State.SELECTED);
        if (this.O00000o0.size() == 2 && !TextUtils.isEmpty(((hdb) this.O00000o0.get(1)).O0000Oo)) {
            this.O000O00o = ((hed) this.O0000Ooo).O000000o(O00000oO, str2, (Object) ((hdb) this.O00000o0.get(1)).O00000Oo, State.UNABLE);
        }
        if (this.O000O00o == null && !TextUtils.isEmpty(((hdb) this.O00000o0.get(0)).O0000Oo)) {
            this.O000O00o = ((hed) this.O0000Ooo).O000000o(O00000oO, str2, (Object) str, State.UNABLE);
        }
        O000000o(simpleDraweeView, hed.O000000o((hed) this.O0000Ooo, O00000oO, str2));
        simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hek.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.hek.O000000o(android.view.View, boolean):void
             arg types: [com.facebook.drawee.view.SimpleDraweeView, int]
             candidates:
              _m_j.hek.O000000o(com.facebook.drawee.view.SimpleDraweeView, java.lang.Object):void
              _m_j.hek.O000000o(java.lang.Object, java.lang.Object):void
              _m_j.hcf.O000000o(android.view.ViewGroup, int):android.view.View
              _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
              _m_j.hcy.O000000o(java.lang.Object, java.lang.Object):void
              _m_j.hek.O000000o(android.view.View, boolean):void */
            public final void onClick(View view) {
                if (!hek.this.O0000Oo0) {
                    hek.this.O000000o(view);
                    Object O000000o2 = hed.O000000o((hed) hek.this.O0000Ooo, O00000oO, str2);
                    hek.this.O000000o(simpleDraweeView, O000000o2);
                    hdb O000000o3 = hdb.O000000o(hek.this.O00000o0, O000000o2);
                    if (O000000o3 != null) {
                        hek.O000000o((View) simpleDraweeView, false);
                        Object O000000o4 = O000000o3.O000000o(hek.this.O00000o0);
                        hek hek = hek.this;
                        hek.O000000o(O000000o3, O00000oO, ((hed) hek.O0000Ooo).O00000o0, O000000o4, null);
                    }
                }
            }
        });
        O00000o().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class _m_j.hek.AnonymousClass2 */

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
                double width = (double) hek.this.O00000o().getWidth();
                Double.isNaN(width);
                int i9 = (int) (width / 4.72d);
                layoutParams.height = i9;
                layoutParams.width = i9;
                hek.this.O00000o().removeOnLayoutChangeListener(this);
                hgw.O000000o(i2, hek.this.O00000oo(), textView, simpleDraweeView);
                simpleDraweeView.requestLayout();
            }
        });
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000o0o = null;
        this.O0000o = null;
        this.O0000oO0 = null;
        this.O00oOooo = null;
        this.O000O00o = null;
    }

    public static void O000000o(View view, boolean z) {
        view.setEnabled(z);
        view.setFocusable(z);
        view.setClickable(z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hek.O000000o(android.view.View, boolean):void
     arg types: [com.facebook.drawee.view.SimpleDraweeView, int]
     candidates:
      _m_j.hek.O000000o(com.facebook.drawee.view.SimpleDraweeView, java.lang.Object):void
      _m_j.hek.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcf.O000000o(android.view.ViewGroup, int):android.view.View
      _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcy.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hek.O000000o(android.view.View, boolean):void */
    public final void O000000o(SimpleDraweeView simpleDraweeView, Object obj) {
        TextView textView = this.O0000o;
        SimpleDraweeView simpleDraweeView2 = this.O0000o0o;
        if (textView != null && simpleDraweeView2 != null) {
            String O000000o2 = O000000o(obj);
            textView.setText(((hed) this.O0000Ooo).O00000o0(obj));
            State state = State.NOR;
            if (this.O000O00o.equals(O000000o2)) {
                state = State.UNABLE;
                textView.setTextColor(this.O00oOoOo);
                O000000o((View) simpleDraweeView2, false);
            } else {
                textView.setTextColor(this.O000O0Oo);
                O000000o((View) simpleDraweeView2, true);
            }
            if (this.O00oOooo.equals(O000000o2)) {
                state = State.NOR;
            }
            if (this.O0000oO0.equals(O000000o2)) {
                state = State.SELECTED;
            }
            this.O000O0OO = state;
            hgw.O000000o(simpleDraweeView, gqb.O00000o(O000000o2));
        }
    }

    private String O000000o(Object obj) {
        if (this.O00000o0 == null || this.O00000o0.size() != 2) {
            return this.O000O00o;
        }
        hdb hdb = (hdb) this.O00000o0.get(0);
        if (!((hdb) this.O00000o0.get(0)).O000000o(String.valueOf(obj))) {
            hdb = (hdb) this.O00000o0.get(1);
        }
        if (!O000000o(O00000oO(), hdb)) {
            return this.O000O00o;
        }
        return O00000Oo(obj);
    }

    private String O00000Oo(Object obj) {
        if (this.O00000o0 == null || this.O00000o0.size() != 2) {
            return this.O00oOooo;
        }
        if (((hdb) this.O00000o0.get(0)).O000000o(String.valueOf(obj))) {
            return this.O0000oO0;
        }
        return this.O00oOooo;
    }

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, Object obj2) {
        SimpleDraweeView simpleDraweeView;
        if (!this.O0000Oo0 && (simpleDraweeView = this.O0000o0o) != null) {
            O000000o(simpleDraweeView, obj2);
        }
    }
}

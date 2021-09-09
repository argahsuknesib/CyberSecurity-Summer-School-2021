package _m_j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class hdx extends hec {
    int O0000o = -1;
    List<View> O0000o0o = new ArrayList();
    Map<View, State> O0000oO0 = new HashMap();
    private int O000O00o;
    private Object O000O0OO = new Object();
    private List<Integer> O00oOooo = new ArrayList();

    public hdx(hed hed) {
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
    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        final Device O00000oO = O00000oO();
        viewGroup.getContext();
        int size = this.O00000o0.size();
        View O000000o2 = O000000o(viewGroup, (int) R.layout.card_item_multibutton);
        LinearLayout linearLayout = (LinearLayout) O000000o2.findViewById(R.id.button_scroll_parent);
        LinearLayout linearLayout2 = (LinearLayout) O000000o2.findViewById(R.id.button_parent);
        this.O0000o0o.clear();
        this.O00oOooo.clear();
        this.O000O00o = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
        String str = (String) hfa.O000000o((Object[]) this.f18773O000000o);
        ViewGroup viewGroup2 = null;
        int i3 = R.layout.miui10_card_item_button_item;
        if (size > 4) {
            linearLayout2.setVisibility(8);
            int i4 = 0;
            for (hdb hdb : this.O00000o0) {
                View inflate = LayoutInflater.from(CommonApplication.getAppContext()).inflate((int) R.layout.miui10_card_item_button_item, (ViewGroup) null);
                linearLayout.addView(inflate);
                this.O0000o0o.add(inflate);
                TextView textView = (TextView) inflate.findViewById(R.id.button_name);
                this.O00oOooo.add(Integer.valueOf(textView.getCurrentTextColor()));
                if (hdb.f18806O000000o != null) {
                    textView.setText(hdb.f18806O000000o);
                }
                hdb.O0000OoO = i4;
                i4++;
            }
        } else {
            linearLayout.setVisibility(8);
            if (this.O00000o0.size() == 2) {
                int i5 = linearLayout2.getResources().getDisplayMetrics().widthPixels / 8;
                linearLayout2.setPadding(i5, 0, i5, 0);
            }
            int i6 = 0;
            for (hdb hdb2 : this.O00000o0) {
                View inflate2 = LayoutInflater.from(CommonApplication.getAppContext()).inflate(i3, viewGroup2);
                hgw.O000000o((SimpleDraweeView) inflate2.findViewById(R.id.image), gqb.O00000o(((hed) this.O0000Ooo).O000000o(O00000oO(), str, (Object) hdb2.O00000Oo, State.NOR)));
                linearLayout2.addView(inflate2, new LinearLayout.LayoutParams(0, -1, 1.0f));
                this.O0000o0o.add(inflate2);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.button_name);
                this.O00oOooo.add(Integer.valueOf(textView2.getCurrentTextColor()));
                if (hdb2.f18806O000000o != null) {
                    textView2.setText(hdb2.f18806O000000o);
                }
                hdb2.O0000OoO = i6;
                i6++;
                viewGroup2 = null;
                i3 = R.layout.miui10_card_item_button_item;
            }
        }
        Object O000000o3 = hed.O000000o((hed) this.O0000Ooo, O00000oO(), str);
        this.O0000o = -1;
        int i7 = 0;
        while (true) {
            if (i7 >= this.O00000o0.size()) {
                break;
            } else if (((hdb) this.O00000o0.get(i7)).O000000o(String.valueOf(O000000o3))) {
                this.O0000o = i7;
                break;
            } else {
                i7++;
            }
        }
        synchronized (this.O000O0OO) {
            for (int i8 = 0; i8 < this.O0000o0o.size(); i8++) {
                View view = this.O0000o0o.get(i8);
                if (O000000o(O00000oO(), (hdb) this.O00000o0.get(i8))) {
                    this.O0000oO0.put(view, State.UNABLE);
                } else if (this.O0000o == i8) {
                    this.O0000oO0.put(view, State.SELECTED);
                } else {
                    this.O0000oO0.put(view, State.NOR);
                }
            }
        }
        O0000O0o();
        for (final hdb hdb3 : this.O00000o0) {
            synchronized (this.O000O0OO) {
                this.O0000o0o.get(hdb3.O0000OoO).setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.hdx.AnonymousClass1 */

                    public final void onClick(View view) {
                        State state;
                        if (!hdx.this.O0000Oo0) {
                            hdx.this.O000000o(view);
                            hdx hdx = hdx.this;
                            int i = hdb3.O0000OoO;
                            for (int i2 = 0; i2 < hdx.O0000o0o.size(); i2++) {
                                View view2 = hdx.O0000o0o.get(i2);
                                hdx.O0000oO0.get(view2);
                                hdb hdb = (hdb) hdx.O00000o0.get(i2);
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.image);
                                Animation animation = simpleDraweeView.getAnimation();
                                if (animation != null) {
                                    animation.cancel();
                                }
                                if (i2 == i) {
                                    state = State.SELECTED;
                                } else if (i2 == hdx.O0000o) {
                                    state = State.NOR;
                                } else {
                                    state = hdx.O000000o(hdx.O00000oO(), hdb) ? State.NOR : State.UNABLE;
                                }
                                hgw.O000000o(simpleDraweeView, gqb.O00000o(hdx.O000000o(hdb, state)));
                            }
                            hdx hdx2 = hdx.this;
                            hdx2.O000000o(hdb3, O00000oO, ((hed) hdx2.O0000Ooo).O00000o0, hdb3.O00000Oo, null);
                        }
                    }
                });
            }
        }
    }

    public final void O00000o0() {
        synchronized (this.O000O0OO) {
            super.O00000o0();
            this.O0000o0o.clear();
            this.O0000oO0.clear();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hed.O000000o(com.xiaomi.smarthome.device.Device, java.lang.String, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
     arg types: [com.xiaomi.smarthome.device.Device, java.lang.String, java.lang.String, com.xiaomi.smarthome.newui.card.State]
     candidates:
      _m_j.hed.O000000o(android.util.ArrayMap<java.lang.String, java.lang.Object>, com.xiaomi.smarthome.device.Device, android.util.ArrayMap<java.lang.String, _m_j.hed>, java.lang.String):java.lang.Object
      _m_j.hed.O000000o(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hcc.O000000o.O000000o(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hed.O000000o(com.xiaomi.smarthome.device.Device, java.lang.String, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String */
    /* access modifiers changed from: package-private */
    public final String O000000o(hdb hdb, State state) {
        return ((hed) this.O0000Ooo).O000000o(O00000oO(), (String) hfa.O000000o((Object[]) this.f18773O000000o), (Object) hdb.O00000Oo, state);
    }

    private static void O000000o(boolean z, List<View> list) {
        for (View next : list) {
            next.setEnabled(z);
            next.setFocusable(z);
            next.setClickable(z);
        }
    }

    private void O0000O0o() {
        State state;
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            Object O000000o2 = hed.O000000o((hed) this.O0000Ooo, O00000oO(), (String) hfa.O000000o((Object[]) this.f18773O000000o));
            if (O000000o2 != null) {
                this.O0000o = -1;
                int i = 0;
                while (true) {
                    if (i >= this.O00000o0.size()) {
                        break;
                    } else if (((hdb) this.O00000o0.get(i)).O000000o(String.valueOf(O000000o2))) {
                        this.O0000o = i;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            synchronized (this.O000O0OO) {
                for (int i2 = 0; i2 < this.O0000o0o.size(); i2++) {
                    View view = this.O0000o0o.get(i2);
                    hdb hdb = (hdb) this.O00000o0.get(i2);
                    this.O0000oO0.get(view);
                    if (!O000000o(O00000oO(), hdb)) {
                        state = State.UNABLE;
                    } else if (i2 == this.O0000o) {
                        state = State.SELECTED;
                    } else {
                        state = State.NOR;
                    }
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.image);
                    Animation animation = simpleDraweeView.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                    }
                    hgw.O000000o(simpleDraweeView, gqb.O00000o(O000000o(hdb, state)));
                    TextView textView = (TextView) view.findViewById(R.id.button_name);
                    if (state == State.UNABLE) {
                        view.setClickable(false);
                        view.setFocusable(false);
                        view.setEnabled(false);
                        textView.setTextColor(this.O000O00o);
                    }
                    if (state == State.SELECTED) {
                        view.setClickable(false);
                        view.setFocusable(true);
                        view.setEnabled(false);
                        textView.setTextColor(this.O00oOooo.get(i2).intValue());
                    }
                    if (state == State.NOR) {
                        view.setClickable(true);
                        view.setFocusable(true);
                        view.setEnabled(true);
                        textView.setTextColor(this.O00oOooo.get(i2).intValue());
                    }
                    this.O0000oO0.put(view, state);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hdx.O000000o(boolean, java.util.List<android.view.View>):void
     arg types: [int, java.util.List<android.view.View>]
     candidates:
      _m_j.hdx.O000000o(_m_j.hdb, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hdx.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcf.O000000o(android.view.ViewGroup, int):android.view.View
      _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcy.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hdx.O000000o(boolean, java.util.List<android.view.View>):void */
    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        if (!this.O0000Oo0) {
            int i = this.O0000o;
            if (i < 0 || i >= this.O00000o0.size()) {
                O000000o(true, this.O0000o0o);
            } else {
                O000000o(O000000o(O00000oO(), (hdb) this.O00000o0.get(this.O0000o)), this.O0000o0o);
            }
            O0000O0o();
        }
    }
}

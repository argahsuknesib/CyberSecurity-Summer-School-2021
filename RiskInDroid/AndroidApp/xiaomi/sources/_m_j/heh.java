package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import com.xiaomi.smarthome.newui.card.State;
import java.util.Iterator;
import java.util.List;

public final class heh<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hcf<C, E, T> {
    public String O0000o;
    public SimpleDraweeView O0000o0o;
    private String O0000oO;
    private TextView O0000oO0;
    private String O0000oOO;
    private String O0000oOo;
    private int O0000oo;
    private int O0000oo0;

    public heh(E e, T[] tArr) {
        super(e, tArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        hcc O00000oo = O00000oo();
        Device O00000oO = O00000oO();
        View O000000o2 = O000000o(viewGroup, (int) R.layout.miui10_card_item_single_button);
        TextView textView = (TextView) O000000o2.findViewById(R.id.desc);
        this.O0000oo0 = textView.getCurrentTextColor();
        this.O0000oo = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
        this.O0000oO0 = textView;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) O000000o2.findViewById(R.id.image);
        this.O0000o0o = simpleDraweeView;
        hgw.O000000o(i2, O00000oo, textView, simpleDraweeView);
        Object O000000o3 = hfa.O000000o((Object[]) this.f18773O000000o);
        if (this.O0000O0o.O000000o(viewGroup) == BaseCardRender.LayoutPosition.TITLE) {
            int O000000o4 = gpc.O000000o(5.0f);
            simpleDraweeView.setPadding(O000000o4, O000000o4, O000000o4, O000000o4);
            this.O0000oO = O00000o0(this.O0000o + "_selected_s");
            this.O0000oOO = O00000o0(this.O0000o + "_normal_s");
            this.O0000oOo = O00000o0(this.O0000o + "_unable_s");
            this.O0000oO0.setVisibility(8);
        } else {
            String str = (this.O00000o0 == null || this.O00000o0.size() == 0) ? null : ((hdb) this.O00000o0.get(0)).O00000Oo;
            this.O0000oOO = this.O0000Ooo.O000000o(O00000oO(), O000000o3, str, State.NOR);
            this.O0000oO = this.O0000Ooo.O000000o(O00000oO(), O000000o3, str, State.SELECTED);
            this.O0000oOo = this.O0000Ooo.O000000o(O00000oO(), O000000o3, str, State.UNABLE);
        }
        O000000o(O000000o3, this.O0000Ooo.O00000Oo(O00000oO(), O000000o3));
        simpleDraweeView.setOnClickListener(new View.OnClickListener(O00000oO, O000000o3) {
            /* class _m_j.$$Lambda$heh$fyPraE2rSepsmQFTpMnzC2B98g */
            private final /* synthetic */ Device f$1;
            private final /* synthetic */ Object f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                heh.this.O000000o(this.f$1, this.f$2, view);
            }
        });
    }

    private static String O00000o0(String str) {
        hcz instance = hcz.getInstance();
        String cardIconPath = instance.getCardIconPath(instance.translateName(str));
        return TextUtils.isEmpty(cardIconPath) ? new StringBuilder("res://drawable/2132083811").toString() : cardIconPath;
    }

    public final void O000000o(View view) {
        super.O000000o(view);
        gtt.O000000o().O00000Oo();
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000o0o = null;
        this.O0000oO0 = null;
        this.O0000oO = null;
        this.O0000oOO = null;
        this.O0000oOo = null;
    }

    private static void O000000o(View view, boolean z) {
        view.setEnabled(z);
        view.setFocusable(z);
        view.setClickable(z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.heh.O000000o(android.view.View, boolean):void
     arg types: [com.facebook.drawee.view.SimpleDraweeView, int]
     candidates:
      _m_j.heh.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.hcf.O000000o(android.view.ViewGroup, int):android.view.View
      _m_j.hcf.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hdb):boolean
      _m_j.hcy.O000000o(java.lang.Object, java.lang.Object):void
      _m_j.heh.O000000o(android.view.View, boolean):void */
    public final void O000000o(T t, Object obj) {
        SimpleDraweeView simpleDraweeView;
        TextView textView;
        List<Object> list;
        if (!this.O0000Oo0 && (simpleDraweeView = this.O0000o0o) != null && (textView = this.O0000oO0) != null && simpleDraweeView != null) {
            textView.setText(this.O0000Ooo.O000000o(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o)));
            boolean z = false;
            if (!O000000o(O00000oO(), (this.O00000o0 == null || this.O00000o0.size() <= 0) ? null : (hdb) this.O00000o0.get(0))) {
                simpleDraweeView.setImageURI(gqb.O00000o(this.O0000oOo));
                textView.setTextColor(this.O0000oo);
                O000000o((View) simpleDraweeView, false);
                return;
            }
            O000000o((View) simpleDraweeView, true);
            textView.setTextColor(this.O0000oo0);
            if (obj != null) {
                hee O000000o2 = this.O0000Ooo.O000000o();
                if (O000000o2 != null && (list = O000000o2.O0000Oo0) != null) {
                    Iterator<Object> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (hgw.O000000o(it.next(), obj)) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    z = hfa.O000000o(obj);
                }
            } else {
                LogType logType = LogType.CARD;
                gsy.O00000o0(logType, "mijia-card", "getDrawableOnOrOff value is null device:" + O00000oO() + " prop:" + hfa.O000000o((Object[]) this.f18773O000000o));
            }
            if (z) {
                simpleDraweeView.setImageURI(gqb.O00000o(this.O0000oO));
            } else {
                simpleDraweeView.setImageURI(gqb.O00000o(this.O0000oOO));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Device device, Object obj, View view) {
        if (!this.O0000Oo0) {
            O000000o(view);
            O000000o(hdb.O000000o(this.O00000o0, this.O0000Ooo.O00000Oo(device, obj)), device, obj, this.O0000Ooo.O00000o0(device, obj), null);
        }
    }
}

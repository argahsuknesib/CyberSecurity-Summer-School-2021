package _m_j;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.BaseCardRender;
import com.xiaomi.smarthome.newui.card.State;

public final class hey extends heq {
    public SimpleDraweeView O0000oO;
    public int O0000oOO;
    public String O0000oOo = "carditemspec_switchstatus";
    private int O0000oo;
    private TextView O0000oo0;
    private int O0000ooO;

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, Object obj2) {
        O000000o(obj2);
    }

    public hey(hej hej, Spec.SpecItem[] specItemArr) {
        super(hej, specItemArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, final int i2) {
        super.O000000o(viewGroup, i, i2);
        View O000000o2 = O000000o(viewGroup, (int) R.layout.miui10_card_item_single_button);
        final TextView textView = (TextView) O000000o2.findViewById(R.id.desc);
        this.O0000oo0 = textView;
        if (textView != null) {
            this.O0000oo = textView.getCurrentTextColor();
            this.O0000ooO = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
            if (this.O0000o == null || !(this.O0000o instanceof SpecProperty)) {
                gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
                return;
            }
            final SimpleDraweeView simpleDraweeView = (SimpleDraweeView) O000000o2.findViewById(R.id.image);
            this.O0000oO = simpleDraweeView;
            if (simpleDraweeView != null) {
                Device O00000oO = O00000oO();
                O000000o(hej.O00000o0(O00000oO, this.O0000o));
                simpleDraweeView.setOnClickListener(new View.OnClickListener(O00000oO) {
                    /* class _m_j.$$Lambda$hey$mrJMBJrY691AF56cqQxeH2wMQuY */
                    private final /* synthetic */ Device f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        hey.this.O000000o(this.f$1, view);
                    }
                });
                if (this.O0000O0o.O000000o(this.O0000o00) != BaseCardRender.LayoutPosition.TITLE) {
                    O00000o().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                        /* class _m_j.hey.AnonymousClass1 */

                        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                            hey.this.O00000o().removeOnLayoutChangeListener(this);
                            ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
                            double width = (double) hey.this.O00000o().getWidth();
                            Double.isNaN(width);
                            int i9 = (int) (width / 4.72d);
                            layoutParams.height = i9;
                            layoutParams.width = i9;
                            hgw.O000000o(i2, hey.this.O00000oo(), textView, simpleDraweeView);
                            simpleDraweeView.requestLayout();
                        }
                    });
                }
            }
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000OOo = null;
        this.O0000oO = null;
        this.O0000oo0 = null;
    }

    private void O000000o(Object obj, hdb hdb, SpecAction specAction) {
        TextView textView = this.O0000oo0;
        if (textView != null) {
            int i = this.O0000oOO;
            String str = null;
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i == 1) {
                textView.setVisibility(0);
                str = hej.O000000o(O00000oO(), this.O0000o);
            } else if (i == 2) {
                textView.setVisibility(0);
                if (!(hdb == null || specAction == null)) {
                    String valueName = hcz.getInstance().getValueName(O00000oO(), specAction, null, null);
                    if (TextUtils.isEmpty(valueName)) {
                        valueName = hcz.getInstance().getValueName(O00000oO(), this.O0000o, String.valueOf(hdb.O00000Oo), hej.O00000o0(O00000oO(), this.O0000o));
                    }
                    str = valueName;
                }
                if (TextUtils.isEmpty(str)) {
                    str = hej.O000000o(O00000oO(), this.O0000o, obj);
                }
            }
            if (str != null) {
                hfa.O000000o(textView, str);
            }
            if (!O000000o(O00000oO(), hdb)) {
                textView.setTextColor(this.O0000ooO);
            } else {
                textView.setTextColor(this.O0000oo);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hej.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem, java.lang.String, com.xiaomi.smarthome.newui.card.State):java.lang.String
     arg types: [com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.device.api.spec.instance.SpecAction, ?[OBJECT, ARRAY], com.xiaomi.smarthome.newui.card.State]
     candidates:
      _m_j.hej.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hej.O000000o(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hcc.O000000o.O000000o(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object, com.xiaomi.smarthome.newui.card.State):java.lang.String
      _m_j.hej.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem, java.lang.String, com.xiaomi.smarthome.newui.card.State):java.lang.String */
    private void O000000o(SimpleDraweeView simpleDraweeView, Object obj, hdb hdb, SpecAction specAction) {
        State state;
        boolean O000000o2 = O000000o(O00000oO(), hdb);
        SimpleDraweeView simpleDraweeView2 = this.O0000oO;
        if (simpleDraweeView2 != null) {
            simpleDraweeView2.setEnabled(O000000o2);
        }
        if (!O000000o2) {
            state = State.UNABLE;
        } else if ((specAction == null || this.O00000o0.indexOf(hdb) != 0) && !hfa.O000000o(obj)) {
            state = State.NOR;
        } else {
            state = State.SELECTED;
        }
        String str = null;
        if (!(hdb == null || specAction == null)) {
            str = state == State.UNABLE ? hej.O000000o(O00000oO(), (Spec.SpecItem) specAction, (String) null, State.UNABLE) : hej.O000000o(O00000oO(), (Spec.SpecItem) specAction, (String) null, State.SELECTED);
        }
        if (str == null) {
            if (this.O0000O0o.O000000o(this.O0000o00) != BaseCardRender.LayoutPosition.TITLE) {
                str = hej.O000000o(O00000oO(), this.O0000o, obj, state);
            } else if (state == State.UNABLE) {
                hcz instance = hcz.getInstance();
                hcz instance2 = hcz.getInstance();
                str = instance.getCardIconPath(instance2.translateName(this.O0000oOo + "_unable_s"));
            } else if (state == State.NOR) {
                hcz instance3 = hcz.getInstance();
                hcz instance4 = hcz.getInstance();
                str = instance3.getCardIconPath(instance4.translateName(this.O0000oOo + "_normal_s"));
            } else if (state == State.SELECTED) {
                hcz instance5 = hcz.getInstance();
                hcz instance6 = hcz.getInstance();
                str = instance5.getCardIconPath(instance6.translateName(this.O0000oOo + "_selected_s"));
            }
        }
        if (str != null) {
            hgw.O000000o(simpleDraweeView, gqb.O00000o(str));
        }
    }

    private void O000000o(Object obj) {
        SimpleDraweeView simpleDraweeView;
        Activity activity;
        if (!this.O0000Oo0 && this.O0000o != null && (this.O0000o instanceof SpecProperty) && (simpleDraweeView = this.O0000oO) != null && (activity = this.O0000OOo) != null && !activity.isFinishing()) {
            hdb O000000o2 = hdb.O000000o(this.O00000o0, hfa.O000000o((SpecProperty) this.O0000o, hej.O00000o0(O00000oO(), this.O0000o)));
            SpecAction O000000o3 = hfa.O000000o(hcz.getInstance().getSpecInstance(O00000oO()), O000000o2);
            O000000o(simpleDraweeView, obj, O000000o2, O000000o3);
            O000000o(obj, O000000o2, O000000o3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Device device, View view) {
        if (this.O0000Oo0) {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "click when destory device:" + device + " cardType:" + this.O0000Ooo);
            return;
        }
        hdb O000000o2 = hdb.O000000o(this.O00000o0, hfa.O000000o((SpecProperty) this.O0000o, hej.O00000o0(device, this.O0000o)));
        if (!O000000o(device, O000000o2)) {
            LogType logType2 = LogType.CARD;
            gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + device + " cardType:" + this.O0000Ooo);
            return;
        }
        O000000o(view);
        O000000o(O000000o2, device, this.O0000o, hej.O00000Oo(device, this.O0000o), null);
    }
}

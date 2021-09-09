package _m_j;

import android.content.Context;
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
import com.xiaomi.smarthome.device.api.spec.definitions.PropertyDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class het extends heq {
    public List<View> O0000oO = new ArrayList();
    public int O0000oOO;
    private int O0000oOo = -1;
    private List<Integer> O0000oo = new ArrayList();
    private Map<View, State> O0000oo0 = new HashMap();
    private int O0000ooO;
    private List<ValueDefinition> O0000ooo = new ArrayList();
    private PropertyDefinition O00oOooO;

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, Object obj2) {
        O000000o(obj2);
    }

    public het(hej hej, Spec.SpecItem[] specItemArr) {
        super(hej, specItemArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        Context context = viewGroup.getContext();
        Device O00000oO = O00000oO();
        View O000000o2 = O000000o(viewGroup, (int) R.layout.card_item_multibutton);
        LinearLayout linearLayout = (LinearLayout) O000000o2.findViewById(R.id.button_scroll_parent);
        final LinearLayout linearLayout2 = (LinearLayout) O000000o2.findViewById(R.id.button_parent);
        this.O0000oO.clear();
        this.O0000oo.clear();
        this.O0000ooO = viewGroup.getResources().getColor(R.color.mj_color_gray_lighter);
        if (this.O0000o == null || !(this.O0000o instanceof SpecProperty)) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
            return;
        }
        this.O00oOooO = ((SpecProperty) this.O0000o).getPropertyDefinition();
        ConstraintValue constraintValue = this.O00oOooO.getConstraintValue();
        if (constraintValue instanceof ValueList) {
            this.O0000ooo.clear();
            List<ValueDefinition> values = ((ValueList) constraintValue).values();
            if (this.O0000o0o != null) {
                HashMap hashMap = new HashMap();
                for (int i3 = 0; i3 < values.size(); i3++) {
                    hashMap.put(hcg.O000000o(values.get(i3).description()), Integer.valueOf(i3));
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.O0000o0o.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) hashMap.get(hcg.O000000o((String) it.next()));
                    if (num != null) {
                        arrayList.add(values.get(num.intValue()));
                    }
                }
                if (arrayList.size() >= 3 || arrayList.size() == values.size()) {
                    this.O0000ooo.addAll(arrayList);
                    gsy.O00000Oo("mijia-card", "model:" + O00000oO.model + "SpecMultiButtonCardItem sort desc by " + this.O0000o0o);
                } else {
                    this.O0000ooo.addAll(values);
                }
            } else {
                this.O0000ooo.addAll(values);
            }
        } else {
            gsy.O000000o(6, "mijia-card", "SpecMultiButtonCardItem not get valuelist with " + this.O0000o + " did:" + O00000oO.did);
        }
        this.O0000oOO = Math.min(this.O0000ooo.size(), 3);
        linearLayout.setVisibility(8);
        for (int i4 = 0; i4 < this.O0000oOO; i4++) {
            View inflate = LayoutInflater.from(CommonApplication.getAppContext()).inflate((int) R.layout.miui10_card_item_button_item, (ViewGroup) null);
            linearLayout2.addView(inflate, new LinearLayout.LayoutParams(-2, -2));
            final View findViewById = inflate.findViewById(R.id.rl_item);
            findViewById.findViewById(R.id.image);
            this.O0000oO.add(findViewById);
            if (i4 != this.O0000oOO - 1) {
                linearLayout2.addView(new View(context), new LinearLayout.LayoutParams(0, 1, 1.0f));
            }
            TextView textView = (TextView) findViewById.findViewById(R.id.button_name);
            this.O0000oo.add(Integer.valueOf(textView.getCurrentTextColor()));
            String O000000o3 = hej.O000000o(O00000oO, this.O0000o, this.O0000ooo.get(i4).valueObject());
            if (O000000o3 != null) {
                hfa.O000000o(textView, O000000o3);
            }
            textView.setText(O000000o3);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.het.AnonymousClass1 */

                public final void onClick(View view) {
                    if (findViewById.isClickable()) {
                        findViewById.performClick();
                    }
                }
            });
        }
        O000000o(hej.O00000o0(O00000oO(), this.O0000o));
        for (int i5 = 0; i5 < this.O0000oOO; i5++) {
            this.O0000oO.get(i5).setOnClickListener(new View.OnClickListener(O00000oO, i5) {
                /* class _m_j.$$Lambda$het$KnGDIoFX4qgVgEhmo0GG4fnaDl4 */
                private final /* synthetic */ Device f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    het.this.O000000o(this.f$1, this.f$2, view);
                }
            });
        }
        O00000o().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class _m_j.het.AnonymousClass2 */

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                het.this.O00000o().removeOnLayoutChangeListener(this);
                int width = het.this.O00000o().getWidth();
                if (het.this.O0000oOO == 2) {
                    int i9 = width / 8;
                    linearLayout2.setPadding(i9, 0, i9, 0);
                }
                double d = (double) width;
                Double.isNaN(d);
                int i10 = (int) (d / 4.72d);
                int max = Math.max(((linearLayout2.getWidth() * 14) / 15) - ((het.this.O0000oO.size() - 1) * i10), i10);
                for (View next : het.this.O0000oO) {
                    ViewGroup.LayoutParams layoutParams = next.findViewById(R.id.image).getLayoutParams();
                    ((TextView) next.findViewById(R.id.button_name)).setMaxWidth(max);
                    layoutParams.width = i10;
                    layoutParams.height = i10;
                    next.requestLayout();
                }
            }
        });
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000oO.clear();
        this.O0000oo0.clear();
    }

    private void O000000o(int i) {
        State state;
        for (int i2 = 0; i2 < this.O0000oO.size(); i2++) {
            View view = this.O0000oO.get(i2);
            this.O0000oo0.get(view);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.image);
            Animation animation = simpleDraweeView.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            if (i2 == i && (this.O00oOooO.readable() || this.O00oOooO.notifiable())) {
                state = State.SELECTED;
            } else if (i2 == this.O0000oOo) {
                state = State.NOR;
            } else {
                state = O000000o(O00000oO(), null) ? State.NOR : State.UNABLE;
            }
            hgw.O000000o(simpleDraweeView, gqb.O00000o(hej.O000000o(O00000oO(), this.O0000o, this.O0000ooo.get(i2).valueObject(), state)));
        }
    }

    private void O000000o(Object obj) {
        if (this.O0000o == null || !(this.O0000o instanceof SpecProperty)) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
        } else {
            O00000Oo(obj);
        }
    }

    private void O00000Oo(Object obj) {
        State state;
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            try {
                this.O0000oOo = -1;
                int i = 0;
                while (true) {
                    if (i >= this.O0000oOO) {
                        break;
                    } else if (hgw.O000000o(obj, this.O0000ooo.get(i).valueObject())) {
                        this.O0000oOo = i;
                        break;
                    } else {
                        i++;
                    }
                }
            } catch (Exception e) {
                gsy.O00000o0(LogType.CARD, "mijia-card", "SpecMultiButtonCardItem".concat(String.valueOf(e)));
            }
            for (int i2 = 0; i2 < this.O0000oO.size(); i2++) {
                View view = this.O0000oO.get(i2);
                this.O0000oo0.get(view);
                if (!O000000o(O00000oO(), (hdb) null)) {
                    state = State.UNABLE;
                } else if (i2 != this.O0000oOo || (!this.O00oOooO.readable() && !this.O00oOooO.notifiable())) {
                    state = State.NOR;
                } else {
                    state = State.SELECTED;
                }
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.image);
                Animation animation = simpleDraweeView.getAnimation();
                if (animation != null) {
                    animation.cancel();
                }
                hgw.O000000o(simpleDraweeView, gqb.O00000o(hej.O000000o(O00000oO(), this.O0000o, this.O0000ooo.get(i2).valueObject(), state)));
                TextView textView = (TextView) view.findViewById(R.id.button_name);
                if (state == State.UNABLE) {
                    view.setClickable(false);
                    view.setFocusable(false);
                    view.setEnabled(false);
                    textView.setTextColor(this.O0000ooO);
                }
                if (state == State.SELECTED) {
                    view.setClickable(false);
                    view.setFocusable(true);
                    view.setEnabled(false);
                    textView.setTextColor(this.O0000oo.get(i2).intValue());
                }
                if (state == State.NOR) {
                    view.setClickable(true);
                    view.setFocusable(true);
                    view.setEnabled(true);
                    textView.setTextColor(this.O0000oo.get(i2).intValue());
                }
                this.O0000oo0.put(view, state);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Device device, int i, View view) {
        if (this.O0000Oo0) {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "click when destory device:" + device + " cardType:" + this.O0000Ooo);
        } else if (!O000000o(device, (hdb) null)) {
            LogType logType2 = LogType.CARD;
            gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + device + " cardType:" + this.O0000Ooo);
        } else {
            O000000o(view);
            O000000o(i);
            Object valueObject = this.O0000ooo.get(i).valueObject();
            gsy.O00000Oo("mijia-card", "SpecMultiButtonCardItem click prop:" + this.O0000o + " value:" + valueObject + " postion:" + i);
            O000000o(null, device, this.O0000o, valueObject, null);
        }
    }
}

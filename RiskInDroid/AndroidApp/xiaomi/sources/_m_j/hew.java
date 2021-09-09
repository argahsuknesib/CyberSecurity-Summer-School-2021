package _m_j;

import _m_j.hen;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.RoundedHorizontalSeekBar;
import com.xiaomi.smarthome.newui.widget.ShiftChooser;

public final class hew extends heq {
    public ConstraintValue O0000oO;
    private hen.O00000Oo O0000oOO;

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        O00000Oo(obj2);
    }

    public hew(hej hej, Spec.SpecItem[] specItemArr) {
        super(hej, specItemArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        final Spec.SpecItem specItem = (Spec.SpecItem) hfa.O000000o((Object[]) this.f18773O000000o);
        if (!(specItem instanceof SpecProperty)) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
            return;
        }
        this.O0000oO = ((SpecProperty) specItem).getPropertyDefinition().getConstraintValue();
        ConstraintValue constraintValue = this.O0000oO;
        if (constraintValue == null) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  constraintValues is not define");
            return;
        }
        int size = constraintValue.size();
        if (size <= 4) {
            this.O0000oOO = new hen.O00000o((ShiftChooser) O000000o(viewGroup, (int) R.layout.card_item_shift_chooser).findViewById(R.id.seekbar));
        } else if (size < 40) {
            View O000000o2 = O000000o(viewGroup, (int) R.layout.card_item_plus_minus2);
            this.O0000oOO = new hen.O00000o0((RoundedHorizontalSeekBar) O000000o2.findViewById(R.id.button_center), (ImageView) O000000o2.findViewById(R.id.button_left), (ImageView) O000000o2.findViewById(R.id.button_right));
        } else {
            this.O0000oOO = new hen.O00000o0((RoundedHorizontalSeekBar) O000000o(viewGroup, (int) R.layout.card_item_slide2).findViewById(R.id.seekbar));
        }
        final Device O00000oO = O00000oO();
        hen.O00000Oo o00000Oo = this.O0000oOO;
        if (o00000Oo != null) {
            o00000Oo.O00000Oo(size);
            if (!TextUtils.isEmpty(this.O00000o)) {
                this.O0000oOO.O000000o(gpj.O000000o(hcz.getInstance().getCardIconPath(hcz.getInstance().translateName(this.O00000o))));
            }
            this.O0000oOO.O000000o(new hen.O000000o() {
                /* class _m_j.hew.AnonymousClass1 */

                public final void O000000o(int i) {
                    hew hew = hew.this;
                    hew.O000000o(hew.O0000oO.getIndexValue(i));
                }

                public final void O00000Oo(int i) {
                    if (hew.this.O0000Oo0) {
                        LogType logType = LogType.CARD;
                        gsy.O00000o0(logType, "mijia-card", "click when destory device:" + O00000oO + " cardType:" + hew.this.O0000Ooo);
                    } else if (!hew.this.O000000o(O00000oO, (hdb) null)) {
                        LogType logType2 = LogType.CARD;
                        gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + O00000oO + " cardType:" + hew.this.O0000Ooo);
                    } else {
                        hew hew = hew.this;
                        hew.O000000o(null, hew.O00000oO(), specItem, hew.this.O0000oO.getIndexValue(i), null);
                    }
                }
            });
            O00000Oo(hej.O00000o0(O00000oO, specItem));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x006b, code lost:
        if (r3.equals(r4) != false) goto L_0x006d;
     */
    public final void O000000o(Object obj) {
        Device O00000oO = O00000oO();
        Spec.SpecItem specItem = (Spec.SpecItem) hfa.O000000o((Object[]) this.f18773O000000o);
        String O000000o2 = hej.O000000o(O00000oO(), specItem);
        String valueName = hcz.getInstance().getValueName(O00000oO(), specItem, specItem.getDescription() + "_format", null);
        String O000000o3 = hej.O000000o(O00000oO(), specItem, obj);
        if (TextUtils.isEmpty(O000000o3) || O000000o3.equals(O000000o2)) {
            String hdj = ((hej) this.O0000Ooo).O000000o(specItem, obj, O00000oO).toString();
            if (!TextUtils.isEmpty(valueName)) {
                O000000o3 = String.format(valueName, hdj);
            }
            O000000o3 = O000000o2 + " " + hdj;
        }
        if (!TextUtils.isEmpty(O000000o3)) {
            this.O0000oOO.O000000o(O000000o3);
        }
        String O00000Oo = hej.O00000Oo(O00000oO(), this.O0000o, obj);
        if (!TextUtils.isEmpty(O00000Oo)) {
            this.O0000oOO.O00000o(Color.parseColor(O00000Oo));
        }
    }

    private void O00000Oo(Object obj) {
        this.O0000oOO.O000000o(O000000o(O00000oO(), (hdb) null));
        this.O0000oOO.O00000o0(this.O0000oO.getValueIndex(obj));
        O000000o(obj);
    }
}

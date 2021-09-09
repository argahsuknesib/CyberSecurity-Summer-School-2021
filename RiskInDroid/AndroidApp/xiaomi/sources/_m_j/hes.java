package _m_j;

import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.BaseSeekBar;
import com.xiaomi.smarthome.newui.widget.RoundedGradientSeekBar;

public final class hes extends heq {
    public double O0000oO;
    public double O0000oOO;
    public double O0000oOo;
    private RoundedGradientSeekBar O0000oo0;

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        O00000Oo(obj2);
    }

    public hes(hej hej, Spec.SpecItem[] specItemArr) {
        super(hej, specItemArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        final Device O00000oO = O00000oO();
        this.O0000oo0 = (RoundedGradientSeekBar) O000000o(viewGroup, (int) R.layout.card_item_slide_gradient).findViewById(R.id.seekbar);
        if (this.O0000o == null || !(this.O0000o instanceof SpecProperty)) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
            return;
        }
        RoundedGradientSeekBar roundedGradientSeekBar = this.O0000oo0;
        if (roundedGradientSeekBar != null) {
            ConstraintValue constraintValue = ((SpecProperty) this.O0000o).getPropertyDefinition().getConstraintValue();
            if (!(constraintValue instanceof ValueRange)) {
                gsy.O00000Oo(LogType.CARD, "mijia-card", "SpecGradientSlideCardItem not define ValueRange:".concat(String.valueOf(constraintValue)));
                return;
            }
            ValueRange valueRange = (ValueRange) constraintValue;
            this.O0000oO = hhc.O000000o(valueRange.minValueObject(), 0.0d);
            this.O0000oOO = hhc.O000000o(valueRange.maxValueObject(), 0.0d);
            this.O0000oOo = hhc.O000000o(valueRange.stepValueObject(), 0.0d);
            O00000Oo(hej.O00000o0(O00000oO, this.O0000o));
            roundedGradientSeekBar.setOnSeekBarChangeListener(new BaseSeekBar.O000000o() {
                /* class _m_j.hes.AnonymousClass1 */

                public final void O000000o(int i) {
                }

                public final void O000000o(BaseSeekBar baseSeekBar) {
                    if (hes.this.O0000Oo0) {
                        LogType logType = LogType.CARD;
                        gsy.O00000o0(logType, "mijia-card", "click when destory device:" + O00000oO + " cardType:" + hes.this.O0000Ooo);
                        return;
                    }
                    String str = null;
                    if (!hes.this.O000000o(O00000oO, (hdb) null)) {
                        LogType logType2 = LogType.CARD;
                        gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + O00000oO + " cardType:" + hes.this.O0000Ooo);
                        hes hes = hes.this;
                        hes.O000000o(hej.O00000o0(O00000oO, hes.O0000o));
                        return;
                    }
                    SpecProperty specProperty = (SpecProperty) hes.this.O0000o;
                    double d = hes.this.O0000oO;
                    double progress = (double) baseSeekBar.getProgress();
                    Double.isNaN(progress);
                    double d2 = d + ((progress * (hes.this.O0000oOO - hes.this.O0000oO)) / 100.0d);
                    double d3 = hes.this.O0000oO;
                    double d4 = hes.this.O0000oOO;
                    double d5 = hes.this.O0000oOo;
                    if (specProperty != null) {
                        str = specProperty.getPropertyDefinition().getFormatString();
                    }
                    Number O000000o2 = hfa.O000000o(d2, d3, d4, d5, str);
                    hes hes2 = hes.this;
                    hes2.O000000o(null, hes2.O00000oO(), hes.this.O0000o, O000000o2, null);
                }
            });
        }
    }

    public final void O000000o(Object obj) {
        RoundedGradientSeekBar roundedGradientSeekBar = this.O0000oo0;
        if (roundedGradientSeekBar != null && obj != null && !obj.equals("null")) {
            try {
                double parseInt = (double) Integer.parseInt(String.valueOf(obj));
                double d = this.O0000oO;
                Double.isNaN(parseInt);
                roundedGradientSeekBar.setProgress((((int) (parseInt - d)) * 100) / ((int) (this.O0000oOO - this.O0000oO)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000oo0 = null;
    }

    private void O000000o(boolean z) {
        RoundedGradientSeekBar roundedGradientSeekBar = this.O0000oo0;
        if (roundedGradientSeekBar != null) {
            roundedGradientSeekBar.setClickable(z);
            roundedGradientSeekBar.setFocusable(z);
            roundedGradientSeekBar.setCanSeek(z);
            roundedGradientSeekBar.O000000o(z);
        }
    }

    private void O00000Oo(Object obj) {
        if (!this.O0000Oo0 && this.O0000o != null && (this.O0000o instanceof SpecProperty)) {
            O000000o(obj);
            O000000o(O000000o(O00000oO(), (hdb) null));
        }
    }
}

package _m_j;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.BaseSeekBar;
import com.xiaomi.smarthome.newui.widget.RoundedHorizontalSeekBar;

public final class hex extends heq {
    public RoundedHorizontalSeekBar O0000oO;
    public double O0000oOO;
    public double O0000oOo;
    public double O0000oo0;

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        O0000O0o();
    }

    public hex(hej hej, Spec.SpecItem[] specItemArr) {
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
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = (RoundedHorizontalSeekBar) O000000o(viewGroup, (int) R.layout.card_item_slide2).findViewById(R.id.seekbar);
        this.O0000oO = roundedHorizontalSeekBar;
        roundedHorizontalSeekBar.setMax(1000);
        if (this.O0000o == null || !(this.O0000o instanceof SpecProperty)) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
            return;
        }
        if (!TextUtils.isEmpty(this.O00000o)) {
            roundedHorizontalSeekBar.setImageIcon(gpj.O000000o(hcz.getInstance().getCardIconPath(hcz.getInstance().translateName(this.O00000o))));
            roundedHorizontalSeekBar.setContentPaddingLeft(0.0f);
        }
        if (roundedHorizontalSeekBar != null) {
            ConstraintValue constraintValue = ((SpecProperty) this.O0000o).getPropertyDefinition().getConstraintValue();
            if (!(constraintValue instanceof ValueRange)) {
                gsy.O00000Oo(LogType.CARD, "mijia-card", "SpecSlideCardItem2 not define ValueRange:".concat(String.valueOf(constraintValue)));
                return;
            }
            ValueRange valueRange = (ValueRange) constraintValue;
            this.O0000oOO = hhc.O000000o(valueRange.minValueObject(), 0.0d);
            this.O0000oOo = hhc.O000000o(valueRange.maxValueObject(), 0.0d);
            this.O0000oo0 = hhc.O000000o(valueRange.stepValueObject(), 0.0d);
            hej.O00000o0(O00000oO, this.O0000o);
            O0000O0o();
            roundedHorizontalSeekBar.setOnSeekBarChangeListener(new BaseSeekBar.O000000o() {
                /* class _m_j.hex.AnonymousClass1 */

                public final void O000000o(int i) {
                }

                public final void O000000o(BaseSeekBar baseSeekBar) {
                    if (hex.this.O0000Oo0) {
                        LogType logType = LogType.CARD;
                        gsy.O00000o0(logType, "mijia-card", "click when destory device:" + O00000oO + " cardType:" + hex.this.O0000Ooo);
                        return;
                    }
                    String str = null;
                    if (!hex.this.O000000o(O00000oO, (hdb) null)) {
                        LogType logType2 = LogType.CARD;
                        gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + O00000oO + " cardType:" + hex.this.O0000Ooo);
                        hex hex = hex.this;
                        Device device = O00000oO;
                        hex.O000000o(device, hej.O00000o0(device, hex.O0000o));
                    } else if (hex.this.O0000oO != null) {
                        SpecProperty specProperty = (SpecProperty) hex.this.O0000o;
                        double d = hex.this.O0000oOO;
                        double progress = (double) baseSeekBar.getProgress();
                        Double.isNaN(progress);
                        double d2 = d + ((progress * (hex.this.O0000oOo - hex.this.O0000oOO)) / 1000.0d);
                        double d3 = hex.this.O0000oOO;
                        double d4 = hex.this.O0000oOo;
                        double d5 = hex.this.O0000oo0;
                        if (specProperty != null) {
                            str = specProperty.getPropertyDefinition().getFormatString();
                        }
                        Number O000000o2 = hfa.O000000o(d2, d3, d4, d5, str);
                        hex hex2 = hex.this;
                        hex2.O000000o(null, hex2.O00000oO(), specProperty, O000000o2, null);
                    }
                }
            });
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000oO = null;
    }

    public final void O000000o(Device device, Object obj) {
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = this.O0000oO;
        if (roundedHorizontalSeekBar != null && obj != null && !obj.equals("null")) {
            try {
                roundedHorizontalSeekBar.setProgress((int) ((((hhc.O000000o(String.valueOf(obj), this.O0000oOO) - this.O0000oOO) * 1000.0d) / (this.O0000oOo - this.O0000oOO)) + this.O0000oOO));
                String O00000Oo = hej.O00000Oo(device, this.O0000o, obj);
                if (!TextUtils.isEmpty(O00000Oo)) {
                    roundedHorizontalSeekBar.setForegroundColor(Color.parseColor(O00000Oo));
                }
            } catch (Exception e) {
                gsy.O00000o0(LogType.CARD, "mijia-card", "setSeekBar".concat(String.valueOf(e)));
            }
        }
    }

    private void O000000o(boolean z) {
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = this.O0000oO;
        if (roundedHorizontalSeekBar != null) {
            roundedHorizontalSeekBar.setCanSeek(z);
            roundedHorizontalSeekBar.setFocusable(z);
            roundedHorizontalSeekBar.setClickable(z);
            roundedHorizontalSeekBar.O000000o(z);
        }
    }

    private void O0000O0o() {
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            O000000o(O000000o(O00000oO(), (hdb) null));
            O000000o(O00000oO(), hej.O00000o0(O00000oO(), this.O0000o));
        }
    }
}

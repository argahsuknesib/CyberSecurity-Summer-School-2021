package _m_j;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.BaseSeekBar;
import com.xiaomi.smarthome.newui.widget.RoundedHorizontalSeekBar;

public final class heu extends heq {
    public RoundedHorizontalSeekBar O0000oO;
    public double O0000oOO;
    public double O0000oOo;
    private String O0000oo = "";
    public double O0000oo0;
    private ImageView O0000ooO;
    private ImageView O0000ooo;

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, Object obj2) {
        O000000o(obj2);
    }

    public heu(hej hej, Spec.SpecItem[] specItemArr) {
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
        View O000000o2 = O000000o(viewGroup, (int) R.layout.card_item_plus_minus2);
        ImageView imageView = (ImageView) O000000o2.findViewById(R.id.button_right);
        ImageView imageView2 = (ImageView) O000000o2.findViewById(R.id.button_left);
        final RoundedHorizontalSeekBar roundedHorizontalSeekBar = (RoundedHorizontalSeekBar) O000000o2.findViewById(R.id.button_center);
        if (this.O0000o == null || !(this.O0000o instanceof SpecProperty)) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
            return;
        }
        this.O0000oO = roundedHorizontalSeekBar;
        this.O0000ooO = imageView;
        this.O0000ooo = imageView2;
        if (imageView != null && imageView2 != null && roundedHorizontalSeekBar != null) {
            imageView.setOnClickListener(new View.OnClickListener(O00000oO) {
                /* class _m_j.$$Lambda$heu$18D78JcjIEK9GvqS7AURcySELac */
                private final /* synthetic */ Device f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    heu.this.O00000Oo(this.f$1, view);
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener(O00000oO) {
                /* class _m_j.$$Lambda$heu$IfjGbHIcz5rZOutpEryUfsDWfA */
                private final /* synthetic */ Device f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    heu.this.O000000o(this.f$1, view);
                }
            });
            ConstraintValue constraintValue = ((SpecProperty) this.O0000o).getPropertyDefinition().getConstraintValue();
            if (!(constraintValue instanceof ValueRange)) {
                gsy.O00000Oo(LogType.CARD, "mijia-card", "SpecPlusMinusCardItem not define ValueRange:".concat(String.valueOf(constraintValue)));
                return;
            }
            ValueRange valueRange = (ValueRange) constraintValue;
            this.O0000oOO = hhc.O000000o(valueRange.minValueObject(), 0.0d);
            this.O0000oOo = hhc.O000000o(valueRange.maxValueObject(), 0.0d);
            this.O0000oo0 = hhc.O000000o(valueRange.stepValueObject(), 0.0d);
            if (this.O0000oo0 == 0.0d) {
                if (this.O00000oO != 0.0d) {
                    this.O0000oo0 = this.O00000oO;
                } else {
                    this.O0000oo0 = 1.0d;
                }
            }
            this.O0000oo = hej.O000000o(O00000oO(), this.O0000o);
            if (this.O0000oo == null) {
                this.O0000oo = "";
            }
            roundedHorizontalSeekBar.setMax(100);
            O000000o(hej.O00000o0(O00000oO, this.O0000o));
            roundedHorizontalSeekBar.setOnSeekBarChangeListener(new BaseSeekBar.O000000o() {
                /* class _m_j.heu.AnonymousClass1 */

                public final void O000000o(int i) {
                    double d = heu.this.O0000oOO;
                    double d2 = (double) i;
                    Double.isNaN(d2);
                    Number O000000o2 = hfa.O000000o(d + ((d2 * (heu.this.O0000oOo - heu.this.O0000oOO)) / 100.0d), heu.this.O0000oOO, heu.this.O0000oOo, heu.this.O0000oo0, heu.this.O0000o == null ? null : ((SpecProperty) heu.this.O0000o).getPropertyDefinition().getFormatString());
                    heu heu = heu.this;
                    heu.O000000o(O000000o2, heu.O00000oO(), roundedHorizontalSeekBar);
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hhc.O000000o(java.lang.Object, double):double
                 arg types: [java.lang.String, int]
                 candidates:
                  _m_j.hhc.O000000o(java.lang.Object, int):int
                  _m_j.hhc.O000000o(java.lang.Object, double):double */
                public final void O000000o(BaseSeekBar baseSeekBar) {
                    if (heu.this.O0000Oo0) {
                        LogType logType = LogType.CARD;
                        gsy.O00000o0(logType, "mijia-card", "click when destory device:" + O00000oO + " cardType:" + heu.this.O0000Ooo);
                    } else if (!heu.this.O000000o(O00000oO, (hdb) null)) {
                        LogType logType2 = LogType.CARD;
                        gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + O00000oO + " cardType:" + heu.this.O0000Ooo);
                        Object O00000o02 = hej.O00000o0(O00000oO, heu.this.O0000o);
                        heu heu = heu.this;
                        double d = 0.0d;
                        if (O00000o02 != null) {
                            d = hhc.O000000o((Object) String.valueOf(O00000o02), 0.0d);
                        }
                        heu.O000000o(d, heu.this.O0000oO);
                    } else {
                        heu heu2 = heu.this;
                        double d2 = heu2.O0000oOO;
                        double progress = (double) baseSeekBar.getProgress();
                        Double.isNaN(progress);
                        heu2.O000000o(d2 + ((progress * (heu.this.O0000oOo - heu.this.O0000oOO)) / 100.0d));
                    }
                }
            });
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000ooO = null;
        this.O0000ooo = null;
        this.O0000oO = null;
    }

    public final void O000000o(double d) {
        O000000o(null, O00000oO(), this.O0000o, hfa.O000000o(d, this.O0000oOO, this.O0000oOo, this.O0000oo0, this.O0000o == null ? null : ((SpecProperty) this.O0000o).getPropertyDefinition().getFormatString()), null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hej.O00000Oo(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem, java.lang.Object):java.lang.String
     arg types: [com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem, java.lang.Double]
     candidates:
      _m_j.hej.O00000Oo(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object):java.lang.String
      _m_j.hcc.O000000o.O00000Oo(com.xiaomi.smarthome.device.Device, java.lang.Object, java.lang.Object):java.lang.String
      _m_j.hej.O00000Oo(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem, java.lang.Object):java.lang.String */
    public final void O000000o(double d, RoundedHorizontalSeekBar roundedHorizontalSeekBar) {
        double d2 = this.O0000oOO;
        roundedHorizontalSeekBar.setProgress((int) ((((d - d2) + 0.0d) / (this.O0000oOo - d2)) * 100.0d));
        O000000o(Double.valueOf(d), O00000oO(), roundedHorizontalSeekBar);
        String O00000Oo = hej.O00000Oo(O00000oO(), this.O0000o, (Object) Double.valueOf(d));
        if (!TextUtils.isEmpty(O00000Oo)) {
            roundedHorizontalSeekBar.setForegroundColor(Color.parseColor(O00000Oo));
        }
    }

    private void O000000o(boolean z) {
        ImageView imageView = this.O0000ooO;
        ImageView imageView2 = this.O0000ooo;
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = this.O0000oO;
        if (imageView != null && imageView2 != null && roundedHorizontalSeekBar != null) {
            imageView.setEnabled(z);
            imageView2.setEnabled(z);
            roundedHorizontalSeekBar.O000000o(z);
            if (z) {
                imageView.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_a_grey_control));
                imageView2.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_d_grey_control));
                return;
            }
            imageView.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_a_grey_control).O000000o(hyj.O00000Oo));
            imageView2.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_d_grey_control).O000000o(hyj.O00000Oo));
        }
    }

    public final void O000000o(Object obj, Device device, RoundedHorizontalSeekBar roundedHorizontalSeekBar) {
        if (this.O0000o != null && (this.O0000o instanceof SpecProperty)) {
            String hdj = ((hej) this.O0000Ooo).O000000o(this.O0000o, obj, device).toString();
            if (!TextUtils.isEmpty(this.O0000oo)) {
                hdj = this.O0000oo + " " + hdj;
            }
            if (!TextUtils.isEmpty(hdj)) {
                roundedHorizontalSeekBar.setTextInfo(hdj);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    private void O000000o(Object obj) {
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            double d = 0.0d;
            if (obj != null) {
                d = hhc.O000000o((Object) String.valueOf(obj), 0.0d);
            }
            O000000o(d, this.O0000oO);
            O000000o(O000000o(O00000oO(), (hdb) null));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Device device, View view) {
        if (this.O0000Oo0) {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "click when destory device:" + device + " cardType:" + this.O0000Ooo);
        } else if (!O000000o(device, (hdb) null)) {
            LogType logType2 = LogType.CARD;
            gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + device + " cardType:" + this.O0000Ooo);
        } else {
            O000000o(view);
            O000000o(hhc.O000000o(hej.O00000o0(device, this.O0000o), 0.0d) - this.O0000oo0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Device device, View view) {
        if (this.O0000Oo0) {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "click when destory device:" + device + " cardType:" + this.O0000Ooo);
        } else if (!O000000o(device, (hdb) null)) {
            LogType logType2 = LogType.CARD;
            gsy.O00000o0(logType2, "mijia-card", "click when disable device:" + device + " cardType:" + this.O0000Ooo);
        } else {
            O000000o(view);
            O000000o(hhc.O000000o(hej.O00000o0(device, this.O0000o), 0.0d) + this.O0000oo0);
        }
    }
}

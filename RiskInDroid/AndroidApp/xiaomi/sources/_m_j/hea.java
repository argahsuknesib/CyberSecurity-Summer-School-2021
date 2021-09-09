package _m_j;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.widget.BaseSeekBar;
import com.xiaomi.smarthome.newui.widget.RoundedHorizontalSeekBar;

public final class hea extends hec {
    private ImageView O0000o;
    private String O0000o0o = "";
    private ImageView O0000oO0;
    private RoundedHorizontalSeekBar O00oOooo;

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, Object obj2) {
        O000000o(obj2);
    }

    public hea(hed hed) {
        super(hed);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        final Device O00000oO = O00000oO();
        View O000000o2 = O000000o(viewGroup, (int) R.layout.card_item_plus_minus2);
        ImageView imageView = (ImageView) O000000o2.findViewById(R.id.button_right);
        ImageView imageView2 = (ImageView) O000000o2.findViewById(R.id.button_left);
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = (RoundedHorizontalSeekBar) O000000o2.findViewById(R.id.button_center);
        this.O00oOooo = roundedHorizontalSeekBar;
        this.O0000o = imageView;
        this.O0000oO0 = imageView2;
        if (imageView != null && imageView2 != null && roundedHorizontalSeekBar != null) {
            this.O00000oO = this.O00000oO == 0.0d ? 1.0d : this.O00000oO;
            final String str = (String) hfa.O000000o((Object[]) this.f18773O000000o);
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hea.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hhc.O000000o(java.lang.Object, double):double
                 arg types: [java.lang.Object, int]
                 candidates:
                  _m_j.hhc.O000000o(java.lang.Object, int):int
                  _m_j.hhc.O000000o(java.lang.Object, double):double */
                public final void onClick(View view) {
                    if (!hea.this.O0000Oo0) {
                        hea.this.O000000o(view);
                        hea hea = hea.this;
                        hea.O000000o(hhc.O000000o(hed.O000000o((hed) hea.O0000Ooo, O00000oO, str), 0.0d) + hea.this.O00000oO);
                    }
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hea.AnonymousClass2 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hhc.O000000o(java.lang.Object, double):double
                 arg types: [java.lang.Object, int]
                 candidates:
                  _m_j.hhc.O000000o(java.lang.Object, int):int
                  _m_j.hhc.O000000o(java.lang.Object, double):double */
                public final void onClick(View view) {
                    if (!hea.this.O0000Oo0) {
                        hea.this.O000000o(view);
                        hea hea = hea.this;
                        hea.O000000o(hhc.O000000o(hed.O000000o((hed) hea.O0000Ooo, O00000oO, str), 0.0d) - hea.this.O00000oO);
                    }
                }
            });
            this.O0000o0o = O0000OOo();
            if (this.O0000o0o == null) {
                this.O0000o0o = "";
            }
            roundedHorizontalSeekBar.setMax(100);
            O000000o(hed.O000000o((hed) this.O0000Ooo, O00000oO, str));
            roundedHorizontalSeekBar.setOnSeekBarChangeListener(new BaseSeekBar.O000000o() {
                /* class _m_j.hea.AnonymousClass3 */

                public final void O000000o(int i) {
                }

                public final void O000000o(BaseSeekBar baseSeekBar) {
                    if (!hea.this.O0000Oo0) {
                        hea hea = hea.this;
                        hea.O000000o((double) (((float) hea.O00oOooO) + (((float) (((long) baseSeekBar.getProgress()) * (hea.this.O0000ooo - hea.this.O00oOooO))) / 100.0f)));
                    }
                }
            });
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000o = null;
        this.O0000oO0 = null;
        this.O00oOooo = null;
    }

    public final void O000000o(double d) {
        if (this.O00000o0 != null && this.O00000o0.size() != 0) {
            O000000o((hdb) this.O00000o0.get(0), O00000oO(), ((hed) this.O0000Ooo).O00000o0, hfa.O000000o(d, (double) this.O00oOooO, (double) this.O0000ooo, this.O00000oO, (String) null), null);
        }
    }

    private void O000000o(double d, RoundedHorizontalSeekBar roundedHorizontalSeekBar) {
        double d2 = (double) this.O00oOooO;
        Double.isNaN(d2);
        double d3 = (double) (this.O0000ooo - this.O00oOooO);
        Double.isNaN(d3);
        roundedHorizontalSeekBar.setProgress((int) ((((d - d2) + 0.0d) / d3) * 100.0d));
        String hdj = ((hed) this.O0000Ooo).O00000Oo(Double.valueOf(d)).toString();
        if (!TextUtils.isEmpty(this.O0000o0o)) {
            hdj = this.O0000o0o + " " + hdj;
        }
        if (!TextUtils.isEmpty(hdj)) {
            roundedHorizontalSeekBar.setTextInfo(hdj);
        }
    }

    private void O000000o(boolean z) {
        ImageView imageView = this.O0000o;
        ImageView imageView2 = this.O0000oO0;
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = this.O00oOooo;
        if (imageView != null && imageView2 != null && roundedHorizontalSeekBar != null) {
            imageView.setEnabled(z);
            imageView2.setEnabled(z);
            roundedHorizontalSeekBar.O000000o(z);
            roundedHorizontalSeekBar.setCanSeek(z);
            roundedHorizontalSeekBar.setFocusable(z);
            roundedHorizontalSeekBar.setClickable(z);
            if (z) {
                imageView.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_a_grey_control));
                imageView2.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_d_grey_control));
                return;
            }
            imageView.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_a_grey_control).O000000o(hyj.O00000Oo));
            imageView2.setImageDrawable(new hyn(imageView.getContext(), R.raw.mj_d_grey_control).O000000o(hyj.O00000Oo));
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
            if (this.O00000o0 != null && this.O00000o0.size() > 0) {
                O000000o(O000000o(O00000oO(), (hdb) this.O00000o0.get(0)));
            }
            double d = 0.0d;
            if (obj != null) {
                d = hhc.O000000o((Object) String.valueOf(obj), 0.0d);
            }
            O000000o(d, this.O00oOooo);
        }
    }
}

package _m_j;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.widget.BaseSeekBar;
import com.xiaomi.smarthome.newui.widget.RoundedGradientSeekBar;
import java.util.List;

public final class hdt extends hec {
    private RoundedGradientSeekBar O0000o0o;

    public final /* bridge */ /* synthetic */ void O000000o(Object obj, Object obj2) {
        O000000o(obj2);
    }

    public hdt(hed hed) {
        super(hed);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        heb heb = (heb) O00000oo();
        final Device O00000oO = O00000oO();
        this.O0000o0o = (RoundedGradientSeekBar) O000000o(viewGroup, (int) R.layout.card_item_slide_gradient).findViewById(R.id.seekbar);
        RoundedGradientSeekBar roundedGradientSeekBar = this.O0000o0o;
        if (roundedGradientSeekBar != null) {
            List O00000Oo = heb.O00000Oo();
            if (1 == heb.O00000Oo && O00000Oo.size() == 2 && ((hed) O00000Oo.get(0)).O00000o0() && i2 == 1) {
                this.O0000o0o.getLayoutParams().width = gpc.O000000o(viewGroup.getContext(), 193.33f);
            }
            if (3 == heb.O00000Oo && O00000Oo.size() == 3 && ((hed) O00000Oo.get(1)).O00000o0() && i2 == 2) {
                this.O0000o0o.getLayoutParams().width = gpc.O000000o(viewGroup.getContext(), 193.33f);
            }
            if (!TextUtils.isEmpty(this.O0000oOO)) {
                roundedGradientSeekBar.setColorFrom(O00000Oo(this.O0000oOO));
            }
            if (!TextUtils.isEmpty(this.O0000oOo)) {
                roundedGradientSeekBar.setColorTo(O00000Oo(this.O0000oOo));
            }
            if (this.O00000o0 != null && this.O00000o0.size() != 0) {
                final hdb hdb = (hdb) this.O00000o0.get(0);
                if (this.O0000ooo != this.O00oOooO) {
                    String str = (String) hfa.O000000o((Object[]) this.f18773O000000o);
                    Object O000000o2 = hed.O000000o((hed) this.O0000Ooo, O00000oO, str);
                    if (O000000o2 != null && !O000000o2.equals("null")) {
                        try {
                            roundedGradientSeekBar.setProgress(Math.round((((float) (((long) Integer.valueOf(String.valueOf(O000000o2)).intValue()) - this.O00oOooO)) * 100.0f) / ((float) (this.O0000ooo - this.O00oOooO))));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    O000000o(hed.O000000o((hed) this.O0000Ooo, O00000oO(), str));
                    roundedGradientSeekBar.setOnSeekBarChangeListener(new BaseSeekBar.O000000o() {
                        /* class _m_j.hdt.AnonymousClass1 */

                        public final void O000000o(int i) {
                        }

                        public final void O000000o(BaseSeekBar baseSeekBar) {
                            if (!hdt.this.O0000Oo0) {
                                Integer valueOf = Integer.valueOf(Math.round(((float) hdt.this.O00oOooO) + (((float) (((long) baseSeekBar.getProgress()) * (hdt.this.O0000ooo - hdt.this.O00oOooO))) / 100.0f)));
                                hdt hdt = hdt.this;
                                hdt.O000000o(hdb, O00000oO, ((hed) hdt.O0000Ooo).O00000o0, valueOf, null);
                            }
                        }
                    });
                }
            }
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O0000o0o = null;
    }

    private void O00000Oo(Object obj) {
        RoundedGradientSeekBar roundedGradientSeekBar = this.O0000o0o;
        if (roundedGradientSeekBar != null && obj != null && !obj.equals("null")) {
            try {
                roundedGradientSeekBar.setProgress(Math.round((((float) (((long) Integer.valueOf(String.valueOf(obj)).intValue()) - this.O00oOooO)) * 100.0f) / ((float) (this.O0000ooo - this.O00oOooO))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void O000000o(boolean z) {
        RoundedGradientSeekBar roundedGradientSeekBar = this.O0000o0o;
        if (roundedGradientSeekBar != null) {
            roundedGradientSeekBar.setClickable(z);
            roundedGradientSeekBar.setFocusable(z);
            roundedGradientSeekBar.setCanSeek(z);
            roundedGradientSeekBar.O000000o(z);
        }
    }

    private void O000000o(Object obj) {
        if (!this.O0000Oo0) {
            boolean O000000o2 = O000000o(O00000oO(), (hdb) this.O00000o0.get(0));
            O00000Oo(obj);
            O000000o(O000000o2);
        }
    }
}

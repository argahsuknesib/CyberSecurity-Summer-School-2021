package _m_j;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.widget.BaseSeekBar;
import com.xiaomi.smarthome.newui.widget.RoundedHorizontalSeekBar;

public final class hei extends hec {
    RoundedHorizontalSeekBar O0000o0o;

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        O00000Oo(obj2);
    }

    public hei(hed hed) {
        super(hed);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        final Device O00000oO = O00000oO();
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = (RoundedHorizontalSeekBar) O000000o(viewGroup, (int) R.layout.card_item_slide2).findViewById(R.id.seekbar);
        this.O0000o0o = roundedHorizontalSeekBar;
        if (roundedHorizontalSeekBar != null) {
            if (!TextUtils.isEmpty(this.O0000oo0)) {
                roundedHorizontalSeekBar.setImageIcon(gpj.O000000o(hcv.getInstance().getCardIconPath(hcv.getInstance().translateName(this.O0000oo0))));
                roundedHorizontalSeekBar.setContentPaddingLeft(0.0f);
            }
            if (this.O00000o0 != null && this.O00000o0.size() != 0) {
                final hdb hdb = (hdb) this.O00000o0.get(0);
                if (this.O0000ooo != this.O00oOooO) {
                    O00000Oo(hed.O000000o((hed) this.O0000Ooo, O00000oO(), (String) hfa.O000000o((Object[]) this.f18773O000000o)));
                    roundedHorizontalSeekBar.setOnSeekBarChangeListener(new BaseSeekBar.O000000o() {
                        /* class _m_j.hei.AnonymousClass1 */

                        public final void O000000o(int i) {
                        }

                        public final void O000000o(BaseSeekBar baseSeekBar) {
                            if (!hei.this.O0000Oo0 && hei.this.O0000o0o != null) {
                                Integer valueOf = Integer.valueOf(Math.round(((float) hei.this.O00oOooO) + (((float) (((long) baseSeekBar.getProgress()) * (hei.this.O0000ooo - hei.this.O00oOooO))) / 100.0f)));
                                hei hei = hei.this;
                                hei.O000000o(hdb, O00000oO, ((hed) hei.O0000Ooo).O00000o0, valueOf, null);
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

    private void O000000o(Object obj) {
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = this.O0000o0o;
        if (roundedHorizontalSeekBar != null && obj != null && !obj.equals("null")) {
            try {
                roundedHorizontalSeekBar.setProgress(Math.round((((float) (((long) Integer.valueOf(String.valueOf(obj)).intValue()) - this.O00oOooO)) * 100.0f) / ((float) (this.O0000ooo - this.O00oOooO))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void O0000O0o() {
        boolean O000000o2 = O000000o(O00000oO(), (hdb) this.O00000o0.get(0));
        RoundedHorizontalSeekBar roundedHorizontalSeekBar = this.O0000o0o;
        if (roundedHorizontalSeekBar != null) {
            roundedHorizontalSeekBar.setCanSeek(O000000o2);
            roundedHorizontalSeekBar.setFocusable(O000000o2);
            roundedHorizontalSeekBar.setClickable(O000000o2);
            roundedHorizontalSeekBar.O000000o(O000000o2);
        }
    }

    private void O00000Oo(Object obj) {
        if (!this.O0000Oo0 && this.O0000OOo != null && !this.O0000OOo.isFinishing()) {
            O000000o(obj);
            O0000O0o();
        }
    }
}

package _m_j;

import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.widget.ShiftChooser;
import java.util.ArrayList;
import java.util.List;

public final class heg extends hec {
    int O0000o = 0;
    List<Integer> O0000o0o = new ArrayList();
    String[] O0000oO0;
    private ShiftChooser O00oOooo;

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        O00000Oo(obj2);
    }

    public heg(hed hed) {
        super(hed);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        final Device O00000oO = O00000oO();
        ShiftChooser shiftChooser = (ShiftChooser) O000000o(viewGroup, (int) R.layout.card_item_shift_chooser).findViewById(R.id.seekbar);
        shiftChooser.setAutoTopPadding(false);
        shiftChooser.setHapticFeedbackEnabled(true);
        this.O00oOooo = shiftChooser;
        if (shiftChooser != null) {
            shiftChooser.setTotalShifts(this.O00000o0.size());
            this.O0000oO0 = new String[this.O00000o0.size()];
            for (int i3 = 0; i3 < this.O00000o0.size(); i3++) {
                this.O0000oO0[i3] = ((hdb) this.O00000o0.get(i3)).f18806O000000o;
            }
            shiftChooser.setShiftsTitles(this.O0000oO0);
            O00000Oo(hed.O000000o((hed) this.O0000Ooo, O00000oO(), (String) hfa.O000000o((Object[]) this.f18773O000000o)));
            shiftChooser.setOnShiftChangedListener(new ShiftChooser.O000000o() {
                /* class _m_j.heg.AnonymousClass1 */

                public final void O000000o(int i) {
                }

                public final void O00000Oo(int i) {
                    if (!heg.this.O0000Oo0) {
                        hdb hdb = (hdb) heg.this.O00000o0.get(i);
                        heg heg = heg.this;
                        heg.O000000o(hdb, O00000oO, ((hed) heg.O0000Ooo).O00000o0, hdb.O00000Oo, null);
                    }
                }
            });
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        this.O00oOooo = null;
    }

    private void O000000o(Object obj) {
        ShiftChooser shiftChooser = this.O00oOooo;
        if (shiftChooser != null && obj != null) {
            int i = 0;
            while (i < this.O00000o0.size()) {
                hdb hdb = (hdb) this.O00000o0.get(i);
                if (hdb == null || !hdb.O000000o(String.valueOf(obj))) {
                    i++;
                } else {
                    shiftChooser.scrollToShift(i, false);
                    this.O0000o = i;
                    return;
                }
            }
        }
    }

    private void O000000o(Device device, ShiftChooser shiftChooser) {
        this.O0000o0o.clear();
        for (int i = 0; i < this.O00000o0.size(); i++) {
            if (!O000000o(device, (hdb) this.O00000o0.get(i))) {
                this.O0000o0o.add(Integer.valueOf(i));
            }
        }
        if (this.O0000o0o.size() >= shiftChooser.getTotalShifts()) {
            O000000o(false);
        } else {
            O000000o(true);
        }
    }

    private void O000000o(boolean z) {
        ShiftChooser shiftChooser = this.O00oOooo;
        if (shiftChooser != null) {
            shiftChooser.setCanChoose(z);
            shiftChooser.setClickable(z);
            shiftChooser.setFocusable(z);
            shiftChooser.updateEnableUI(z);
        }
    }

    private void O00000Oo(Object obj) {
        ShiftChooser shiftChooser = this.O00oOooo;
        Device O00000oO = O00000oO();
        if (!this.O0000Oo0 && O00000oO != null && shiftChooser != null) {
            O000000o(O00000oO, shiftChooser);
            O000000o(obj);
        }
    }
}

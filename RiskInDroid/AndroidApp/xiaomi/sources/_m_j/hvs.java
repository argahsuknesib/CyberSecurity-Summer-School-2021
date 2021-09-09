package _m_j;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.miio.MiioLocalErrorCode;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.verify.view.PinInputView;
import com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;

public class hvs extends hvx implements PinSoftKeyboard.O000000o {
    private static final String O0000O0o = new dxf(MiioLocalErrorCode.EXCEPTION).O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    PinSoftKeyboard f717O000000o;
    View O00000Oo;
    View O00000o;
    PinInputView O00000o0;
    public View O00000oO;
    public ImageView O00000oo;
    private String O0000OOo = "";
    private int O0000Oo0 = 0;
    private View O000OooO;
    private hvz O000Oooo;

    public final int O00000Oo() {
        return -1;
    }

    public final void e_(int i) {
    }

    hvs() {
        this.O000Ooo = "APSecurePinV2Step";
    }

    public final boolean G_() {
        this.O000Oooo.O00000oO();
        O000000o("onBackPressed", new Object[0]);
        x_().post(new Runnable() {
            /* class _m_j.hvs.AnonymousClass1 */

            public final void run() {
                hvs.this.O000O0o();
            }
        });
        return true;
    }

    public final void O000000o(Context context) {
        O000000o("create step", new Object[0]);
        this.O000O0oO = LayoutInflater.from(context).inflate((int) R.layout.ap_secure_pin_code_layout, (ViewGroup) null);
        this.f717O000000o = (PinSoftKeyboard) this.O000O0oO.findViewById(R.id.xiaomi_sm_pin_softkeyboard);
        this.O00000Oo = this.O000O0oO.findViewById(R.id.cancel);
        this.O00000o0 = (PinInputView) this.O000O0oO.findViewById(R.id.xiaomi_sm_pin_inputs);
        this.O00000oO = this.O000O0oO.findViewById(R.id.error_hint);
        this.O00000o = this.O000O0oO.findViewById(R.id.ratio_container);
        this.O000OooO = this.O000O0oO.findViewById(R.id.fl_hint);
        this.O00000oo = (ImageView) this.O000O0oO.findViewById(R.id.mj_loading);
        this.f717O000000o.setClickListener(this);
        this.O00000o.setVisibility(8);
        int intValue = ((Integer) htr.O000000o().O000000o("length")).intValue();
        if (intValue < 6 && (this.O00000o0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O00000o0.getLayoutParams();
            marginLayoutParams.leftMargin = (marginLayoutParams.leftMargin * 3) / 2;
            marginLayoutParams.rightMargin = (marginLayoutParams.rightMargin * 3) / 2;
        }
        this.O00000o0.setSpacing(gri.O000000o(18.0f));
        this.O00000o0.setPincodeNumber(intValue);
        this.O000OooO.setVisibility(0);
        this.O00000oO.setVisibility(4);
        this.O00000oo.setVisibility(4);
        if (this.O000Oooo == null) {
            this.O000Oooo = new hvz();
            this.O000Oooo.O000000o(this.O000O0oo, new ArrayList(), (gkd) null);
            this.O000Oooo.O000000o(this);
        }
        this.O000Oooo.O000000o(0, (Bundle) null);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hvs.AnonymousClass2 */

            public final void onClick(View view) {
                hvs.this.O000000o("user click btn cancel", new Object[0]);
                hvs.this.G_();
            }
        });
    }

    public void onNumberClick(int i) {
        if (this.O00000oo.getVisibility() != 0) {
            String O000000o2 = this.O00000o0.O000000o(i);
            this.O00000oO.setVisibility(4);
            if (O000000o2.length() >= this.O00000o0.getPincodeNumber()) {
                Bundle bundle = new Bundle();
                bundle.putString("pincode", O000000o2);
                this.O000Oooo.O000000o(5, bundle);
            }
        }
    }

    public void onBackClick() {
        G_();
    }

    public void onDeleteClick() {
        if (this.O00000oo.getVisibility() != 0) {
            this.O00000o0.O000000o();
        }
    }

    public final void H_() {
        O000000o("onResumeStep", new Object[0]);
    }

    public final void I_() {
        O000000o("onPauseStep", new Object[0]);
    }

    public final void O0000O0o() {
        O000000o("onFinishStep", new Object[0]);
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_APSECURE_PIN_STEP_V2;
    }

    public final void O000000o(int i, Bundle bundle) {
        if (i == 11) {
            onBackClick();
        } else if (i == 114) {
            this.O00000oo.post(new Runnable() {
                /* class _m_j.hvs.AnonymousClass3 */

                public final void run() {
                    hvs.this.O00000oo.setVisibility(0);
                    Drawable drawable = hvs.this.O00000oo.getDrawable();
                    if (drawable instanceof AnimationDrawable) {
                        ((AnimationDrawable) drawable).start();
                    }
                }
            });
        } else if (i == 115) {
            this.O00000oO.post(new Runnable() {
                /* class _m_j.hvs.AnonymousClass4 */

                public final void run() {
                    hvs.this.O00000o0.O00000Oo();
                    hvs.this.O00000oo.setVisibility(4);
                    hvs.this.O00000oO.setVisibility(0);
                }
            });
        }
    }
}

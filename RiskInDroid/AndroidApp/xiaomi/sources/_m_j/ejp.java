package _m_j;

import android.app.Activity;
import android.app.AlertDialog;
import com.xiaomi.passport.ui.settings.CaptchaView;
import com.xiaomi.smarthome.R;

public final class ejp implements CaptchaView.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    final Activity f15527O000000o;
    public final O000000o O00000Oo;
    public CaptchaView O00000o;
    AlertDialog O00000o0;

    public interface O000000o {
        void O000000o(String str, String str2);
    }

    public final void O000000o(boolean z) {
        AlertDialog alertDialog = this.O00000o0;
        if (alertDialog != null) {
            alertDialog.setTitle(z ? R.string.passport_input_voice_hint : R.string.passport_input_captcha_hint);
        }
    }

    public ejp(Activity activity, O000000o o000000o) {
        this.f15527O000000o = activity;
        this.O00000Oo = o000000o;
    }
}

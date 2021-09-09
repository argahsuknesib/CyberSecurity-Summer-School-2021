package _m_j;

import android.app.Activity;
import android.os.Vibrator;
import com.xiaomi.passport.ui.diagnosis.PassportDiagnosisActivity;

public final class efo {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Activity f15224O000000o;
    private volatile int O00000Oo = 0;

    public efo(Activity activity) {
        this.f15224O000000o = activity;
    }

    public final void O000000o() {
        this.O00000Oo++;
        if (this.O00000Oo >= 5) {
            this.O00000Oo = 0;
            Vibrator vibrator = (Vibrator) this.f15224O000000o.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200);
            }
            PassportDiagnosisActivity.start(this.f15224O000000o);
        }
    }
}

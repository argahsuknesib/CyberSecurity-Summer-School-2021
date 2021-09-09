package miuix.view;

import _m_j.izf;
import _m_j.izg;
import _m_j.o0OO00o0;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import miui.util.HapticFeedbackUtil;

@Keep
class LinearVibrator implements izg {
    private final o0OO00o0<Integer> mIds = new o0OO00o0<>();

    private LinearVibrator() {
        buildIds();
    }

    public boolean performHapticFeedback(View view, int i) {
        int O00000o = this.mIds.O00000o(i);
        if (O00000o < 0) {
            Log.w("LinearVibrator", String.format("feedback(0x%08x-%s) is not found in current platform(v%d)", Integer.valueOf(i), izf.O000000o(i), Integer.valueOf(PlatformConstants.VERSION)));
            return false;
        }
        int intValue = this.mIds.O00000o0(O00000o).intValue();
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(intValue)) {
            return view.performHapticFeedback(intValue);
        }
        Log.w("LinearVibrator", String.format("unsupported feedback: 0x%08x. platform version: %d", Integer.valueOf(intValue), Integer.valueOf(PlatformConstants.VERSION)));
        return false;
    }

    /* access modifiers changed from: package-private */
    public int obtainFeedBack(int i) {
        int O00000o = this.mIds.O00000o(i);
        if (O00000o >= 0) {
            return this.mIds.O00000o0(O00000o).intValue();
        }
        return -1;
    }

    public boolean supportLinearMotor(int i) {
        int O00000o = this.mIds.O00000o(i);
        if (O00000o < 0) {
            Log.w("LinearVibrator", String.format("feedback(0x%08x-%s) is not found in current platform(v%d)", Integer.valueOf(i), izf.O000000o(i), Integer.valueOf(PlatformConstants.VERSION)));
            return false;
        }
        int intValue = this.mIds.O00000o0(O00000o).intValue();
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(intValue)) {
            return HapticFeedbackUtil.isSupportLinearMotorVibrate(intValue);
        }
        Log.w("LinearVibrator", String.format("unsupported feedback: 0x%08x. platform version: %d", Integer.valueOf(intValue), Integer.valueOf(PlatformConstants.VERSION)));
        return false;
    }

    private void buildIds() {
        this.mIds.O00000o0(izf.O00000Oo, 268435456);
        this.mIds.O00000o0(izf.O00000o0, 268435457);
        this.mIds.O00000o0(izf.O00000o, 268435458);
        this.mIds.O00000o0(izf.O00000oO, 268435459);
        this.mIds.O00000o0(izf.O00000oo, 268435460);
        this.mIds.O00000o0(izf.O0000O0o, 268435461);
        this.mIds.O00000o0(izf.O0000OOo, 268435462);
        this.mIds.O00000o0(izf.O0000Oo0, 268435463);
        this.mIds.O00000o0(izf.O0000Oo, 268435464);
        this.mIds.O00000o0(izf.O0000OoO, 268435465);
        if (PlatformConstants.VERSION >= 2) {
            this.mIds.O00000o0(izf.O0000Ooo, 268435466);
            this.mIds.O00000o0(izf.O0000o00, 268435467);
            this.mIds.O00000o0(izf.O0000o0, 268435468);
            if (PlatformConstants.VERSION >= 3) {
                this.mIds.O00000o0(izf.O0000o0O, 268435469);
                if (PlatformConstants.VERSION >= 4) {
                    this.mIds.O00000o0(izf.O0000o0o, 268435470);
                }
            }
        }
    }

    static {
        initialize();
    }

    private static void initialize() {
        boolean z;
        if (PlatformConstants.VERSION <= 0) {
            Log.w("LinearVibrator", "MiuiHapticFeedbackConstants not found or not compatible for LinearVibrator.");
            return;
        }
        try {
            z = HapticFeedbackUtil.isSupportLinearMotorVibrate();
        } catch (Throwable th) {
            Log.w("LinearVibrator", "MIUI Haptic Implementation is not available", th);
            z = false;
        }
        if (!z) {
            Log.w("LinearVibrator", "linear motor is not supported in this platform.");
            return;
        }
        HapticCompat.registerProvider(new LinearVibrator());
        Log.i("LinearVibrator", "setup LinearVibrator success.");
    }
}

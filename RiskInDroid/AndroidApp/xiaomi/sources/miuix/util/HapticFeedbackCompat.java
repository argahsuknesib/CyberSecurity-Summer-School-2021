package miuix.util;

import android.content.Context;
import android.util.Log;
import miui.util.HapticFeedbackUtil;
import miuix.view.PlatformConstants;

public class HapticFeedbackCompat {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f15391O000000o;
    private static boolean O00000Oo;
    private static boolean O00000o;
    private static boolean O00000o0;
    private static boolean O00000oO;
    private static boolean O0000O0o;
    private HapticFeedbackUtil O00000oo;

    @Deprecated
    private HapticFeedbackCompat(Context context, byte b) {
        if (PlatformConstants.VERSION <= 0) {
            Log.w("HapticFeedbackCompat", "MiuiHapticFeedbackConstants not found or not compatible for LinearVibrator.");
            return;
        }
        try {
            f15391O000000o = HapticFeedbackUtil.isSupportLinearMotorVibrate();
        } catch (Throwable th) {
            Log.w("HapticFeedbackCompat", "MIUI Haptic Implementation is not available", th);
            f15391O000000o = false;
        }
        if (!f15391O000000o) {
            Log.w("HapticFeedbackCompat", "linear motor is not supported in this platform.");
            return;
        }
        this.O00000oo = new HapticFeedbackUtil(context, true);
        Class<HapticFeedbackUtil> cls = HapticFeedbackUtil.class;
        try {
            cls.getMethod("performHapticFeedback", Integer.TYPE, Double.TYPE, String.class);
            O00000Oo = true;
        } catch (Throwable th2) {
            Log.w("HapticFeedbackCompat", "Not support haptic with reason", th2);
            O00000Oo = false;
        }
        Class<HapticFeedbackUtil> cls2 = HapticFeedbackUtil.class;
        try {
            cls2.getMethod("isSupportExtHapticFeedback", Integer.TYPE);
            O00000o = true;
        } catch (Throwable unused) {
            O00000o = false;
        }
        Class<HapticFeedbackUtil> cls3 = HapticFeedbackUtil.class;
        try {
            cls3.getMethod("performExtHapticFeedback", Integer.TYPE, Boolean.TYPE);
            O00000oO = true;
        } catch (Throwable unused2) {
            O00000oO = false;
        }
        try {
            HapticFeedbackUtil.class.getMethod("stop", new Class[0]);
            O0000O0o = true;
        } catch (Throwable unused3) {
            O0000O0o = false;
        }
        Class<HapticFeedbackUtil> cls4 = HapticFeedbackUtil.class;
        try {
            cls4.getMethod("performExtHapticFeedback", Integer.TYPE, Double.TYPE, String.class);
            O00000o0 = true;
        } catch (Throwable th3) {
            Log.w("HapticFeedbackCompat", "Not support ext haptic with reason", th3);
            O00000o0 = false;
        }
    }

    public HapticFeedbackCompat(Context context) {
        this(context, (byte) 0);
    }
}

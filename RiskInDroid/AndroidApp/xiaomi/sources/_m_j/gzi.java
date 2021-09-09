package _m_j;

import android.graphics.Bitmap;
import com.xiaomi.smarthome.module.blur.JavaBlurProcess;
import com.xiaomi.smarthome.module.blur.NativeBlurProcess;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class gzi {

    /* renamed from: O000000o  reason: collision with root package name */
    static boolean f18615O000000o;
    public static final int O00000Oo;
    private static volatile boolean O00000o = true;
    public static final ExecutorService O00000o0;
    private Bitmap O00000oO;
    private final gzh O00000oo;

    static {
        try {
            System.loadLibrary("native-lib");
            f18615O000000o = true;
        } catch (Throwable unused) {
            f18615O000000o = false;
        }
        f18615O000000o = true;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        O00000Oo = availableProcessors;
        O00000o0 = Executors.newFixedThreadPool(availableProcessors);
    }

    public gzi() {
        if (f18615O000000o) {
            this.O00000oo = new NativeBlurProcess();
        } else {
            this.O00000oo = new JavaBlurProcess();
        }
    }

    public final Bitmap O000000o(Bitmap bitmap) {
        this.O00000oO = this.O00000oo.O000000o(bitmap, 5.0f);
        return this.O00000oO;
    }
}

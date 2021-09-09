package com.google.android.play.core.internal;

import java.io.PrintStream;

public final class cd {

    /* renamed from: a  reason: collision with root package name */
    static final bx f3762a;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    static {
        bx bxVar;
        Integer num = null;
        try {
            num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = cb.class.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            bxVar = new cb();
        }
        if (num != null) {
            if (num.intValue() >= 19) {
                bxVar = new cc();
                f3762a = bxVar;
                if (num == null) {
                    num.intValue();
                    return;
                }
                return;
            }
        }
        bxVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new ca() : new cb();
        f3762a = bxVar;
        if (num == null) {
        }
    }

    public static void a(Throwable th, Throwable th2) {
        f3762a.a(th, th2);
    }
}

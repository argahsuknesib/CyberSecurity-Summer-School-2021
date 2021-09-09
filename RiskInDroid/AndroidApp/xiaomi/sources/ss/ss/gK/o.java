package ss.ss.gK;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class o extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f15494a;
    private IOException b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f15494a = method;
    }

    public o(IOException iOException) {
        super(iOException);
        this.b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method = f15494a;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public final IOException a() {
        return this.b;
    }

    public final void a(IOException iOException) {
        a(iOException, this.b);
        this.b = iOException;
    }
}

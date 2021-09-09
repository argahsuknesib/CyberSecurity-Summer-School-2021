package _m_j;

import android.util.Log;

public final class dlm {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f14770O000000o = true;
    private String O00000Oo = "default";
    private int O00000o0 = 2;

    public dlm() {
    }

    public dlm(String str) {
        this.O00000Oo = str;
    }

    private String O000000o() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.isNativeMethod() || stackTraceElement.getClassName().equals(Thread.class.getName()) || stackTraceElement.getClassName().equals(getClass().getName())) {
                i++;
            } else {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    private void O0000OOo(Object obj) {
        String str;
        if (this.O00000o0 <= 4) {
            String O000000o2 = O000000o();
            if (O000000o2 == null) {
                str = obj.toString();
            } else {
                str = O000000o2 + " - " + obj;
            }
            Log.i(this.O00000Oo, str);
            dkd.O0000oo();
        }
    }

    public final void O000000o(Throwable th) {
        if (this.O00000o0 <= 6) {
            Log.e(this.O00000Oo, "", th);
            dkd.O0000oo();
        }
    }

    public final void O00000Oo(Object obj) {
        String str;
        if (this.O00000o0 <= 5) {
            String O000000o2 = O000000o();
            if (O000000o2 == null) {
                str = obj.toString();
            } else {
                str = O000000o2 + " - " + obj;
            }
            Log.w(this.O00000Oo, str);
            dkd.O0000oo();
        }
    }

    public final void O00000o(Object obj) {
        String str;
        if (this.O00000o0 <= 6) {
            String O000000o2 = O000000o();
            if (O000000o2 == null) {
                str = obj.toString();
            } else {
                str = O000000o2 + " - " + obj;
            }
            Log.e(this.O00000Oo, str);
            dkd.O0000oo();
        }
    }

    public final void O00000oo(Object obj) {
        String str;
        if (this.O00000o0 <= 3) {
            String O000000o2 = O000000o();
            if (O000000o2 == null) {
                str = obj.toString();
            } else {
                str = O000000o2 + " - " + obj;
            }
            Log.d(this.O00000Oo, str);
            dkd.O0000oo();
        }
    }

    public final void O000000o(Object obj) {
        if (this.f14770O000000o) {
            O0000OOo(obj);
        }
    }

    public final void O00000o0(Object obj) {
        if (this.f14770O000000o) {
            O00000Oo(obj);
        }
    }

    public final void O00000oO(Object obj) {
        if (this.f14770O000000o) {
            O00000o(obj);
        }
    }

    public final void O00000Oo(Throwable th) {
        if (this.f14770O000000o) {
            O000000o(th);
        }
    }

    public final void O0000O0o(Object obj) {
        if (this.f14770O000000o) {
            O00000oo(obj);
        }
    }
}

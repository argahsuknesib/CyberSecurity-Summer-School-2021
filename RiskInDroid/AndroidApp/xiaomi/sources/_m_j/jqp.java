package _m_j;

import gK.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import ss.q;
import ss.ss.i$1;

public final class jqp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f2062O000000o = new byte[0];
    public static final String[] O00000Oo = new String[0];
    public static final TimeZone O00000o = TimeZone.getTimeZone("GMT");
    public static final Charset O00000o0 = Charset.forName("UTF-8");
    private static final Pattern O00000oO = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int O000000o(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int O000000o(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int O000000o(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static f O000000o(f fVar) {
        try {
            return f.O000000o(MessageDigest.getInstance("SHA-1").digest(fVar.O00000o()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static <T> List<T> O000000o(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> O000000o(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static ThreadFactory O000000o(String str) {
        return new i$1(str, true);
    }

    public static void O000000o(long j, long j2, long j3) {
        if ((j3 | 0) < 0 || 0 > j || j - 0 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void O000000o(Closeable closeable, Closeable closeable2) throws IOException {
        try {
            closeable.close();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            } else if (th instanceof Error) {
                throw ((Error) th);
            } else {
                throw new AssertionError(th);
            }
        }
    }

    public static void O000000o(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!O000000o(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean O000000o(iqz iqz, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long N_ = iqz.O000000o().M_() ? iqz.O000000o().N_() - nanoTime : Long.MAX_VALUE;
        iqz.O000000o().O000000o(Math.min(N_, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            iql iql = new iql();
            while (iqz.O000000o(iql, 2048) != -1) {
                iql.O0000o0o();
            }
            if (N_ == Long.MAX_VALUE) {
                iqz.O000000o().O00000oO();
                return true;
            }
            iqz.O000000o().O000000o(nanoTime + N_);
            return true;
        } catch (InterruptedIOException unused) {
            if (N_ == Long.MAX_VALUE) {
                iqz.O000000o().O00000oO();
                return false;
            }
            iqz.O000000o().O000000o(nanoTime + N_);
            return false;
        } catch (Throwable th) {
            if (N_ == Long.MAX_VALUE) {
                iqz.O000000o().O00000oO();
            } else {
                iqz.O000000o().O000000o(nanoTime + N_);
            }
            throw th;
        }
    }

    public static boolean O000000o(iqz iqz, TimeUnit timeUnit) {
        try {
            return O000000o(iqz, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean O000000o(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean O000000o(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean O000000o(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    public static int O00000Oo(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static f O00000Oo(f fVar) {
        try {
            return f.O000000o(MessageDigest.getInstance("SHA-256").digest(fVar.O00000o()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static String[] O00000Oo(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static String O00000o0(String str, int i, int i2) {
        int O000000o2 = O000000o(str, i, i2);
        return str.substring(O000000o2, O00000Oo(str, O000000o2, i2));
    }

    public static boolean O00000o0(String str) {
        return O00000oO.matcher(str).matches();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <T> T[] O000000o(java.lang.Class<T> r9, T[] r10, T[] r11) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r10.length
            r2 = 0
            r3 = 0
        L_0x0008:
            if (r3 >= r1) goto L_0x0022
            r4 = r10[r3]
            int r5 = r11.length
            r6 = 0
        L_0x000e:
            if (r6 >= r5) goto L_0x001f
            r7 = r11[r6]
            boolean r8 = r4.equals(r7)
            if (r8 == 0) goto L_0x001c
            r0.add(r7)
            goto L_0x001f
        L_0x001c:
            int r6 = r6 + 1
            goto L_0x000e
        L_0x001f:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x0022:
            int r10 = r0.size()
            java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r10)
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            java.lang.Object[] r9 = r0.toArray(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.jqp.O000000o(java.lang.Class, java.lang.Object[], java.lang.Object[]):java.lang.Object[]");
    }

    public static String O000000o(q qVar, boolean z) {
        String str;
        if (qVar.O00000Oo.contains(":")) {
            str = "[" + qVar.O00000Oo + "]";
        } else {
            str = qVar.O00000Oo;
        }
        if (!z && qVar.O00000o0 == q.O000000o(qVar.f15491O000000o)) {
            return str;
        }
        return str + ":" + qVar.O00000o0;
    }

    public static String O00000Oo(String str) {
        boolean z;
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            int i = 0;
            while (true) {
                z = true;
                if (i >= lowerCase.length()) {
                    z = false;
                    break;
                }
                char charAt = lowerCase.charAt(i);
                if (charAt <= 31) {
                    break;
                } else if (charAt >= 127) {
                    break;
                } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}

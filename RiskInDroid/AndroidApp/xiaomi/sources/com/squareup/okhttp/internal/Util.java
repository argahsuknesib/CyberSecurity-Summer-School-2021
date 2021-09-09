package com.squareup.okhttp.internal;

import _m_j.jax;
import _m_j.jbn;
import com.squareup.okhttp.HttpUrl;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Util() {
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!isAndroidGetsocknameError(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void closeAll(Closeable closeable, Closeable closeable2) throws IOException {
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

    public static boolean discard(jbn jbn, int i, TimeUnit timeUnit) {
        try {
            return skipAll(jbn, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean skipAll(jbn jbn, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = jbn.timeout().hasDeadline() ? jbn.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        jbn.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            jax jax = new jax();
            while (jbn.read(jax, 2048) != -1) {
                jax.O0000oOo();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                jbn.timeout().clearDeadline();
                return true;
            }
            jbn.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                jbn.timeout().clearDeadline();
                return false;
            }
            jbn.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                jbn.timeout().clearDeadline();
            } else {
                jbn.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static String md5Hex(String str) {
        try {
            return ByteString.O000000o(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))).O00000oo();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static String shaBase64(String str) {
        try {
            return ByteString.O000000o(MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"))).O00000Oo();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static ByteString sha1(ByteString byteString) {
        try {
            return ByteString.O000000o(MessageDigest.getInstance("SHA-1").digest(byteString.O0000Oo0()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static <T> List<T> immutableList(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() {
            /* class com.squareup.okhttp.internal.Util.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int):java.lang.Object throws java.lang.NegativeArraySizeException}
     arg types: [java.lang.Class<T>, int]
     candidates:
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int[]):java.lang.Object VARARG throws java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException}
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int):java.lang.Object throws java.lang.NegativeArraySizeException} */
    public static <T> T[] intersect(Class<T> cls, T[] tArr, T[] tArr2) {
        List intersect = intersect(tArr, tArr2);
        return intersect.toArray((Object[]) Array.newInstance((Class<?>) cls, intersect.size()));
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
    private static <T> java.util.List<T> intersect(T[] r9, T[] r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r9.length
            r2 = 0
            r3 = 0
        L_0x0008:
            if (r3 >= r1) goto L_0x0022
            r4 = r9[r3]
            int r5 = r10.length
            r6 = 0
        L_0x000e:
            if (r6 >= r5) goto L_0x001f
            r7 = r10[r6]
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
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.Util.intersect(java.lang.Object[], java.lang.Object[]):java.util.List");
    }

    public static String hostHeader(HttpUrl httpUrl) {
        if (httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
            return httpUrl.host();
        }
        return httpUrl.host() + ":" + httpUrl.port();
    }

    public static String toHumanReadableAscii(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt <= 31 || codePointAt >= 127) {
                jax jax = new jax();
                jax.O000000o(str, 0, i);
                while (i < length) {
                    int codePointAt2 = str.codePointAt(i);
                    jax.O000000o((codePointAt2 <= 31 || codePointAt2 >= 127) ? 63 : codePointAt2);
                    i += Character.charCount(codePointAt2);
                }
                return jax.O0000o();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean contains(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    public static String[] concat(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }
}

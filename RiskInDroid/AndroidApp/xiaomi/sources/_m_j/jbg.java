package _m_j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class jbg {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Logger f1727O000000o = Logger.getLogger(jbg.class.getName());

    private jbg() {
    }

    public static jaz O000000o(jbn jbn) {
        return new jbj(jbn);
    }

    public static jay O000000o(jbm jbm) {
        return new jbi(jbm);
    }

    public static jbm O000000o(OutputStream outputStream) {
        return O000000o(outputStream, new jbo());
    }

    private static jbm O000000o(final OutputStream outputStream, final jbo jbo) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (jbo != null) {
            return new jbm() {
                /* class _m_j.jbg.AnonymousClass1 */

                public final void write(jax jax, long j) throws IOException {
                    jbp.O000000o(jax.O00000Oo, 0, j);
                    while (j > 0) {
                        jbo.this.throwIfReached();
                        jbk jbk = jax.f1718O000000o;
                        int min = (int) Math.min(j, (long) (jbk.O00000o0 - jbk.O00000Oo));
                        outputStream.write(jbk.f1738O000000o, jbk.O00000Oo, min);
                        jbk.O00000Oo += min;
                        long j2 = (long) min;
                        j -= j2;
                        jax.O00000Oo -= j2;
                        if (jbk.O00000Oo == jbk.O00000o0) {
                            jax.f1718O000000o = jbk.O00000o0();
                            jbl.O000000o(jbk);
                        }
                    }
                }

                public final void flush() throws IOException {
                    outputStream.flush();
                }

                public final void close() throws IOException {
                    outputStream.close();
                }

                public final jbo timeout() {
                    return jbo.this;
                }

                public final String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static jbm O000000o(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            jav O00000o0 = O00000o0(socket);
            return O00000o0.sink(O000000o(socket.getOutputStream(), O00000o0));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static jbn O000000o(InputStream inputStream) {
        return O000000o(inputStream, new jbo());
    }

    private static jbn O000000o(final InputStream inputStream, final jbo jbo) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (jbo != null) {
            return new jbn() {
                /* class _m_j.jbg.AnonymousClass2 */

                public final long read(jax jax, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            jbo.this.throwIfReached();
                            jbk O00000oo = jax.O00000oo(1);
                            int read = inputStream.read(O00000oo.f1738O000000o, O00000oo.O00000o0, (int) Math.min(j, (long) (8192 - O00000oo.O00000o0)));
                            if (read == -1) {
                                return -1;
                            }
                            O00000oo.O00000o0 += read;
                            long j2 = (long) read;
                            jax.O00000Oo += j2;
                            return j2;
                        } catch (AssertionError e) {
                            if (jbg.O000000o(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                public final void close() throws IOException {
                    inputStream.close();
                }

                public final jbo timeout() {
                    return jbo.this;
                }

                public final String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static jbn O000000o(File file) throws FileNotFoundException {
        if (file != null) {
            return O000000o(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static jbm O00000Oo(File file) throws FileNotFoundException {
        if (file != null) {
            return O000000o(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public static jbm O00000o0(File file) throws FileNotFoundException {
        if (file != null) {
            return O000000o(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static jbm O000000o() {
        return new jbm() {
            /* class _m_j.jbg.AnonymousClass3 */

            public final void close() throws IOException {
            }

            public final void flush() throws IOException {
            }

            public final void write(jax jax, long j) throws IOException {
                jax.O0000Oo0(j);
            }

            public final jbo timeout() {
                return jbo.NONE;
            }
        };
    }

    public static jbn O00000Oo(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            jav O00000o0 = O00000o0(socket);
            return O00000o0.source(O000000o(socket.getInputStream(), O00000o0));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static jav O00000o0(final Socket socket) {
        return new jav() {
            /* class _m_j.jbg.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
             arg types: [java.util.logging.Level, java.lang.String, java.lang.AssertionError]
             candidates:
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
             arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
             candidates:
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
            /* access modifiers changed from: protected */
            public final void timedOut() {
                try {
                    socket.close();
                } catch (Exception e) {
                    Logger logger = jbg.f1727O000000o;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + socket, (Throwable) e);
                } catch (AssertionError e2) {
                    if (jbg.O000000o(e2)) {
                        Logger logger2 = jbg.f1727O000000o;
                        Level level2 = Level.WARNING;
                        logger2.log(level2, "Failed to close timed out socket " + socket, (Throwable) e2);
                        return;
                    }
                    throw e2;
                }
            }
        };
    }

    static boolean O000000o(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}

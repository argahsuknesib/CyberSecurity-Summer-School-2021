package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class iqt {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Logger f1566O000000o = Logger.getLogger(iqt.class.getName());

    private iqt() {
    }

    public static iqm O000000o(iqy iqy) {
        if (iqy != null) {
            return new iqu(iqy);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static iqn O000000o(iqz iqz) {
        if (iqz != null) {
            return new iqv(iqz);
        }
        throw new IllegalArgumentException("source == null");
    }

    static boolean O000000o(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    private static iqj O00000o0(final Socket socket) {
        return new iqj() {
            /* class _m_j.iqt.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public final IOException O00000Oo(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Exception} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.AssertionError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Exception} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
             arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
             candidates:
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
              ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Multi-variable type inference failed */
            public final void O00000o0() {
                Logger logger;
                Level level;
                StringBuilder sb;
                Exception exc;
                try {
                    socket.close();
                } catch (Exception e) {
                    logger = iqt.f1566O000000o;
                    level = Level.WARNING;
                    sb = new StringBuilder("Failed to close timed out socket ");
                    exc = e;
                    sb.append(socket);
                    logger.log(level, sb.toString(), (Throwable) exc);
                } catch (AssertionError e2) {
                    if (iqt.O000000o(e2)) {
                        logger = iqt.f1566O000000o;
                        level = Level.WARNING;
                        sb = new StringBuilder("Failed to close timed out socket ");
                        exc = e2;
                        sb.append(socket);
                        logger.log(level, sb.toString(), (Throwable) exc);
                    }
                    throw e2;
                }
            }
        };
    }

    public static iqy O000000o(Socket socket) throws IOException {
        if (socket != null) {
            final iqj O00000o0 = O00000o0(socket);
            final OutputStream outputStream = socket.getOutputStream();
            if (outputStream != null) {
                return new iqy(new iqy() {
                    /* class _m_j.iqt.AnonymousClass1 */

                    public final ira O000000o() {
                        return O00000o0;
                    }

                    public final void a_(iql iql, long j) throws IOException {
                        irb.O000000o(iql.O00000Oo, 0, j);
                        while (j > 0) {
                            O00000o0.O00000oo();
                            iqw iqw = iql.f1560O000000o;
                            int min = (int) Math.min(j, (long) (iqw.O00000o0 - iqw.O00000Oo));
                            outputStream.write(iqw.f1572O000000o, iqw.O00000Oo, min);
                            iqw.O00000Oo += min;
                            long j2 = (long) min;
                            j -= j2;
                            iql.O00000Oo -= j2;
                            if (iqw.O00000Oo == iqw.O00000o0) {
                                iql.f1560O000000o = iqw.O000000o();
                                iqx.O000000o(iqw);
                            }
                        }
                    }

                    public final void close() throws IOException {
                        outputStream.close();
                    }

                    public final void flush() throws IOException {
                        outputStream.flush();
                    }

                    public final String toString() {
                        return "sink(" + outputStream + ")";
                    }
                }) {
                    /* class _m_j.iqj.AnonymousClass1 */

                    /* renamed from: O000000o */
                    final /* synthetic */ iqy f1557O000000o;

                    {
                        this.f1557O000000o = r2;
                    }

                    public final ira O000000o() {
                        return iqj.this;
                    }

                    public final void a_(iql iql, long j) {
                        irb.O000000o(iql.O00000Oo, 0, j);
                        while (true) {
                            long j2 = 0;
                            if (j > 0) {
                                while (true) {
                                    if (j2 >= 65536) {
                                        break;
                                    }
                                    j2 += (long) (iql.f1560O000000o.O00000o0 - iql.f1560O000000o.O00000Oo);
                                    if (j2 >= j) {
                                        j2 = j;
                                        break;
                                    }
                                }
                                iqj.this.K_();
                                try {
                                    this.f1557O000000o.a_(iql, j2);
                                    j -= j2;
                                    iqj.this.O000000o(true);
                                } catch (IOException e) {
                                    throw iqj.this.O000000o(e);
                                } catch (Throwable th) {
                                    iqj.this.O000000o(false);
                                    throw th;
                                }
                            } else {
                                return;
                            }
                        }
                    }

                    public final void close() {
                        iqj.this.K_();
                        try {
                            this.f1557O000000o.close();
                            iqj.this.O000000o(true);
                        } catch (IOException e) {
                            throw iqj.this.O000000o(e);
                        } catch (Throwable th) {
                            iqj.this.O000000o(false);
                            throw th;
                        }
                    }

                    public final void flush() {
                        iqj.this.K_();
                        try {
                            this.f1557O000000o.flush();
                            iqj.this.O000000o(true);
                        } catch (IOException e) {
                            throw iqj.this.O000000o(e);
                        } catch (Throwable th) {
                            iqj.this.O000000o(false);
                            throw th;
                        }
                    }

                    public final String toString() {
                        return "AsyncTimeout.sink(" + this.f1557O000000o + ")";
                    }
                };
            }
            throw new IllegalArgumentException("out == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static iqz O00000Oo(Socket socket) throws IOException {
        if (socket != null) {
            final iqj O00000o0 = O00000o0(socket);
            final InputStream inputStream = socket.getInputStream();
            if (inputStream != null) {
                return new iqz(new iqz() {
                    /* class _m_j.iqt.AnonymousClass2 */

                    public final long O000000o(iql iql, long j) throws IOException {
                        if (j < 0) {
                            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                        } else if (j == 0) {
                            return 0;
                        } else {
                            try {
                                O00000o0.O00000oo();
                                iqw O00000oO = iql.O00000oO(1);
                                int read = inputStream.read(O00000oO.f1572O000000o, O00000oO.O00000o0, (int) Math.min(j, (long) (8192 - O00000oO.O00000o0)));
                                if (read == -1) {
                                    return -1;
                                }
                                O00000oO.O00000o0 += read;
                                long j2 = (long) read;
                                iql.O00000Oo += j2;
                                return j2;
                            } catch (AssertionError e) {
                                if (iqt.O000000o(e)) {
                                    throw new IOException(e);
                                }
                                throw e;
                            }
                        }
                    }

                    public final ira O000000o() {
                        return O00000o0;
                    }

                    public final void close() throws IOException {
                        inputStream.close();
                    }

                    public final String toString() {
                        return "source(" + inputStream + ")";
                    }
                }) {
                    /* class _m_j.iqj.AnonymousClass2 */

                    /* renamed from: O000000o */
                    final /* synthetic */ iqz f1558O000000o;

                    {
                        this.f1558O000000o = r2;
                    }

                    public final long O000000o(iql iql, long j) {
                        iqj.this.K_();
                        try {
                            long O000000o2 = this.f1558O000000o.O000000o(iql, j);
                            iqj.this.O000000o(true);
                            return O000000o2;
                        } catch (IOException e) {
                            throw iqj.this.O000000o(e);
                        } catch (Throwable th) {
                            iqj.this.O000000o(false);
                            throw th;
                        }
                    }

                    public final ira O000000o() {
                        return iqj.this;
                    }

                    public final void close() {
                        try {
                            this.f1558O000000o.close();
                            iqj.this.O000000o(true);
                        } catch (IOException e) {
                            throw iqj.this.O000000o(e);
                        } catch (Throwable th) {
                            iqj.this.O000000o(false);
                            throw th;
                        }
                    }

                    public final String toString() {
                        return "AsyncTimeout.source(" + this.f1558O000000o + ")";
                    }
                };
            }
            throw new IllegalArgumentException("in == null");
        }
        throw new IllegalArgumentException("socket == null");
    }
}

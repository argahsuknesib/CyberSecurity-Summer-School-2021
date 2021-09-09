package com.lidroid.xutils.http;

import _m_j.boi;
import _m_j.bqg;
import _m_j.bqi;
import _m_j.bqj;
import _m_j.bqk;
import _m_j.bql;
import _m_j.bqm;
import _m_j.bqn;
import _m_j.bqo;
import _m_j.brn;
import android.os.SystemClock;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.task.PriorityAsyncTask;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public final class HttpHandler<T> extends PriorityAsyncTask<Object, Object, Void> implements bqn {
    private static final O000000o O0000oo0 = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public bql f4510O000000o;
    public long O00000Oo = bqg.O000000o();
    private final AbstractHttpClient O0000O0o;
    private final HttpContext O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private HttpRequestBase O0000OoO;
    private boolean O0000Ooo = true;
    private boolean O0000o = false;
    private int O0000o0 = 0;
    private bqm<T> O0000o00;
    private String O0000o0O = null;
    private boolean O0000o0o = false;
    private String O0000oO;
    private boolean O0000oO0 = false;
    private State O0000oOO = State.WAITING;
    private long O0000oOo;

    public HttpHandler(AbstractHttpClient abstractHttpClient, HttpContext httpContext, String str, bqm<T> bqm) {
        this.O0000O0o = abstractHttpClient;
        this.O0000OOo = httpContext;
        this.O0000o00 = bqm;
        this.O0000oO = str;
        this.O0000O0o.setRedirectHandler(O0000oo0);
    }

    /* JADX INFO: additional move instructions added (5) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.File] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d4 A[Catch:{ UnknownHostException -> 0x01ac, IOException -> 0x019e, NullPointerException -> 0x0185, HttpException -> 0x0183, Throwable -> 0x016a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00dd A[Catch:{ UnknownHostException -> 0x01ac, IOException -> 0x019e, NullPointerException -> 0x0185, HttpException -> 0x0183, Throwable -> 0x016a }] */
    private bqi<T> O000000o(HttpRequestBase httpRequestBase) throws HttpException {
        IOException iOException;
        boolean z;
        boolean z2;
        boolean z3;
        String value;
        HttpRequestRetryHandler httpRequestRetryHandler = this.O0000O0o.getHttpRequestRetryHandler();
        do {
            if (this.O0000o && this.O0000o0o) {
                File file = new File(this.O0000o0O);
                long length = (!file.isFile() || !file.exists()) ? 0 : file.length();
                if (length > 0) {
                    httpRequestBase.setHeader("RANGE", "bytes=" + length + "-");
                }
            }
            try {
                this.O0000Oo = httpRequestBase.getMethod();
                bqg bqg = boi.f13166O000000o;
                String str = null;
                if (bqg.O000000o(this.O0000Oo)) {
                    bqg bqg2 = boi.f13166O000000o;
                    String str2 = this.O0000Oo0;
                    String O00000Oo2 = str2 != null ? bqg2.f13196O000000o.O00000Oo(str2) : null;
                    if (O00000Oo2 != null) {
                        return new bqi<>(null, O00000Oo2, true);
                    }
                }
                if (this.O00000o.get()) {
                    return null;
                }
                HttpResponse execute = this.O0000O0o.execute(httpRequestBase, this.O0000OOo);
                if (execute == null) {
                    throw new HttpException("response is null");
                } else if (this.O00000o.get()) {
                    return null;
                } else {
                    StatusLine statusLine = execute.getStatusLine();
                    int statusCode = statusLine.getStatusCode();
                    if (statusCode < 300) {
                        HttpEntity entity = execute.getEntity();
                        if (entity != null) {
                            this.O0000Ooo = false;
                            if (this.O0000o0o) {
                                if (this.O0000o) {
                                    if (execute != null) {
                                        Header firstHeader = execute.getFirstHeader("Accept-Ranges");
                                        if (firstHeader != null) {
                                            z3 = "bytes".equals(firstHeader.getValue());
                                        } else {
                                            Header firstHeader2 = execute.getFirstHeader("Content-Range");
                                            if (!(firstHeader2 == null || (value = firstHeader2.getValue()) == null || !value.startsWith("bytes"))) {
                                                z3 = true;
                                            }
                                        }
                                        if (z3) {
                                            z2 = true;
                                            this.O0000o = z2;
                                            if (this.O0000oO0) {
                                                str = brn.O000000o(execute);
                                            }
                                            new bqk();
                                            str = bqk.O000000o(entity, this, this.O0000o0O, this.O0000o, str);
                                        }
                                    }
                                    z3 = false;
                                    if (z3) {
                                    }
                                }
                                z2 = false;
                                this.O0000o = z2;
                                if (this.O0000oO0) {
                                }
                                new bqk();
                                str = bqk.O000000o(entity, this, this.O0000o0O, this.O0000o, str);
                            } else {
                                new bqo();
                                String O000000o2 = bqo.O000000o(entity, this, this.O0000oO);
                                bqg bqg3 = boi.f13166O000000o;
                                str = O000000o2;
                                if (bqg.O000000o(this.O0000Oo)) {
                                    bqg bqg4 = boi.f13166O000000o;
                                    String str3 = this.O0000Oo0;
                                    String str4 = O000000o2;
                                    long j = this.O00000Oo;
                                    str = O000000o2;
                                    str = O000000o2;
                                    if (!(str3 == null || str4 == null)) {
                                        if (j < 1) {
                                            str = O000000o2;
                                        } else {
                                            bqg4.f13196O000000o.O000000o(str3, str4, System.currentTimeMillis() + j);
                                            str = O000000o2;
                                        }
                                    }
                                }
                            }
                        }
                        return new bqi<>(execute, str, false);
                    }
                    if (statusCode != 301) {
                        if (statusCode != 302) {
                            if (statusCode == 416) {
                                throw new HttpException(statusCode, "maybe the file has downloaded completely");
                            }
                            throw new HttpException(statusCode, statusLine.getReasonPhrase());
                        }
                    }
                    if (this.f4510O000000o == null) {
                        this.f4510O000000o = new bqj();
                    }
                    HttpRequestBase O000000o3 = this.f4510O000000o.O000000o(execute);
                    if (O000000o3 != null) {
                        return O000000o(O000000o3);
                    }
                    return null;
                }
            } catch (UnknownHostException e) {
                iOException = e;
                int i = this.O0000o0 + 1;
                this.O0000o0 = i;
                z = httpRequestRetryHandler.retryRequest(iOException, i, this.O0000OOo);
                continue;
            } catch (IOException e2) {
                iOException = e2;
                int i2 = this.O0000o0 + 1;
                this.O0000o0 = i2;
                z = httpRequestRetryHandler.retryRequest(iOException, i2, this.O0000OOo);
                continue;
            } catch (NullPointerException e3) {
                iOException = new IOException(e3.getMessage());
                iOException.initCause(e3);
                int i3 = this.O0000o0 + 1;
                this.O0000o0 = i3;
                z = httpRequestRetryHandler.retryRequest(iOException, i3, this.O0000OOo);
                continue;
            } catch (HttpException e4) {
                throw e4;
            } catch (Throwable th) {
                iOException = new IOException(th.getMessage());
                iOException.initCause(th);
                int i4 = this.O0000o0 + 1;
                this.O0000o0 = i4;
                z = httpRequestRetryHandler.retryRequest(iOException, i4, this.O0000OOo);
                continue;
            }
        } while (z);
        throw new HttpException(iOException);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public Void O000000o(Object... objArr) {
        if (!(this.O0000oOO == State.CANCELLED || objArr == null || objArr.length == 0)) {
            if (objArr.length > 3) {
                this.O0000o0O = String.valueOf(objArr[1]);
                this.O0000o0o = this.O0000o0O != null;
                this.O0000o = ((Boolean) objArr[2]).booleanValue();
                this.O0000oO0 = ((Boolean) objArr[3]).booleanValue();
            }
            try {
                if (this.O0000oOO == State.CANCELLED) {
                    return null;
                }
                this.O0000OoO = (HttpRequestBase) objArr[0];
                this.O0000Oo0 = this.O0000OoO.getURI().toString();
                if (this.O0000o00 != null) {
                    this.O0000o00.setRequestUrl(this.O0000Oo0);
                }
                O00000o(1);
                this.O0000oOo = SystemClock.uptimeMillis();
                bqi O000000o2 = O000000o(this.O0000OoO);
                if (O000000o2 != null) {
                    O00000o(4, O000000o2);
                    return null;
                }
            } catch (HttpException e) {
                O00000o(3, e, e.getMessage());
            }
        }
        return null;
    }

    public final void O00000Oo(Object... objArr) {
        if (this.O0000oOO != State.CANCELLED && objArr != null && objArr.length != 0 && this.O0000o00 != null) {
            int intValue = ((Integer) objArr[0]).intValue();
            if (intValue == 1) {
                this.O0000oOO = State.STARTED;
                this.O0000o00.onStart();
            } else if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue == 4 && objArr.length == 2) {
                        this.O0000oOO = State.SUCCESS;
                        this.O0000o00.onSuccess((bqi) objArr[1]);
                    }
                } else if (objArr.length == 3) {
                    this.O0000oOO = State.FAILURE;
                    this.O0000o00.onFailure((HttpException) objArr[1], (String) objArr[2]);
                }
            } else if (objArr.length == 3) {
                this.O0000oOO = State.LOADING;
                this.O0000o00.onLoading(Long.valueOf(String.valueOf(objArr[1])).longValue(), Long.valueOf(String.valueOf(objArr[2])).longValue(), this.O0000Ooo);
            }
        }
    }

    public final boolean O000000o(long j, long j2, boolean z) {
        if (!(this.O0000o00 == null || this.O0000oOO == State.CANCELLED)) {
            if (z) {
                O00000o(2, Long.valueOf(j), Long.valueOf(j2));
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - this.O0000oOo >= ((long) this.O0000o00.getRate())) {
                    this.O0000oOo = uptimeMillis;
                    O00000o(2, Long.valueOf(j), Long.valueOf(j2));
                }
            }
        }
        return this.O0000oOO != State.CANCELLED;
    }

    public enum State {
        WAITING(0),
        STARTED(1),
        LOADING(2),
        FAILURE(3),
        CANCELLED(4),
        SUCCESS(5);
        
        private int value = 0;

        private State(int i) {
            this.value = i;
        }

        public static State valueOf(int i) {
            if (i == 0) {
                return WAITING;
            }
            if (i == 1) {
                return STARTED;
            }
            if (i == 2) {
                return LOADING;
            }
            if (i == 3) {
                return FAILURE;
            }
            if (i == 4) {
                return CANCELLED;
            }
            if (i != 5) {
                return FAILURE;
            }
            return SUCCESS;
        }

        public final int value() {
            return this.value;
        }
    }

    static final class O000000o implements RedirectHandler {
        public final URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
            return null;
        }

        public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return false;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }
}

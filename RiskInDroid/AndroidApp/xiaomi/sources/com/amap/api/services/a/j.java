package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

public abstract class j<T, V> extends df {

    /* renamed from: a  reason: collision with root package name */
    protected T f3422a;
    protected int b = 1;
    protected String c = "";
    protected Context d;
    protected String e = "";
    private int i = 1;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws AMapException;

    public Map<String, String> d() {
        return null;
    }

    public Map<String, String> e() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V f() {
        return null;
    }

    public j(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.d = context;
        this.f3422a = t;
        this.b = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    public String a() {
        return this.e;
    }

    public String b() {
        String i2 = i();
        if (i2 == null) {
            return null;
        }
        try {
            int indexOf = i2.indexOf(".com/");
            int indexOf2 = i2.indexOf("?");
            if (indexOf2 == -1) {
                return i2.substring(indexOf + 5);
            }
            return i2.substring(indexOf + 5, indexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            s.a(e2, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        s.b(str);
        return a(str);
    }

    public V c() throws AMapException {
        if (this.f3422a == null) {
            return null;
        }
        try {
            return g();
        } catch (AMapException e2) {
            ar.a(b(), a(), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0100, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010a, code lost:
        throw new com.amap.api.services.core.AMapException("未知错误");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f A[Catch:{ bo -> 0x005b, AMapException -> 0x0044, Throwable -> 0x00ff, AMapException -> 0x010b, Throwable -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a0 A[Catch:{ bo -> 0x005b, AMapException -> 0x0044, Throwable -> 0x00ff, AMapException -> 0x010b, Throwable -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ff A[ExcHandler: Throwable (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    private V g() throws AMapException {
        long currentTimeMillis;
        V v = null;
        int i2 = 0;
        while (i2 < this.b) {
            try {
                currentTimeMillis = System.currentTimeMillis();
                int protocol = ServiceSettings.getInstance().getProtocol();
                bv.a().a(this.d);
                de a2 = de.a(false);
                a(bx.a(this.d));
                byte[] a3 = a(protocol, a2, this);
                long currentTimeMillis2 = System.currentTimeMillis();
                v = b(a3);
                ar.a(this.d, b(), currentTimeMillis2 - currentTimeMillis, true);
                i2 = this.b;
            } catch (bo e2) {
                ar.a(this.d, b(), System.currentTimeMillis() - currentTimeMillis, false);
                i2++;
                if (i2 < this.b) {
                    Thread.sleep((long) (this.i * 1000));
                    if (!"http连接失败 - ConnectionException".equals(e2.getMessage()) && !"socket 连接异常 - SocketException".equals(e2.getMessage())) {
                        if ("服务器连接失败 - UnknownServiceException".equals(e2.getMessage())) {
                            throw new AMapException(e2.a(), 1, e2.c());
                        }
                    }
                    throw new AMapException("http或socket连接失败 - ConnectionException", 1, e2.c());
                }
                f();
                if (!"http连接失败 - ConnectionException".equals(e2.getMessage()) && !"socket 连接异常 - SocketException".equals(e2.getMessage()) && !"未知的错误".equals(e2.a())) {
                    if (!"服务器连接失败 - UnknownServiceException".equals(e2.getMessage())) {
                        throw new AMapException(e2.a(), 1, e2.c());
                    }
                }
                throw new AMapException("http或socket连接失败 - ConnectionException", 1, e2.c());
            } catch (AMapException e3) {
                ar.a(this.d, b(), System.currentTimeMillis() - currentTimeMillis, false);
                i2++;
                if (i2 >= this.b) {
                    throw e3;
                }
            } catch (AMapException e4) {
                throw e4;
            } catch (Throwable th) {
            }
        }
        return v;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.db.a(com.amap.api.services.a.df, boolean):com.amap.api.services.a.dh
     arg types: [com.amap.api.services.a.df, int]
     candidates:
      com.amap.api.services.a.de.a(boolean, int):com.amap.api.services.a.de
      com.amap.api.services.a.de.a(com.amap.api.services.a.bo, com.amap.api.services.a.dg):void
      com.amap.api.services.a.de.a(com.amap.api.services.a.dh, com.amap.api.services.a.dg):void
      com.amap.api.services.a.db.a(com.amap.api.services.a.df, boolean):com.amap.api.services.a.dh */
    /* access modifiers changed from: protected */
    public byte[] a(int i2, de deVar, df dfVar) throws bo {
        dh dhVar;
        if (i2 == 1) {
            dhVar = deVar.a(dfVar, false);
        } else {
            dhVar = i2 == 2 ? deVar.a(dfVar, true) : null;
        }
        if (dhVar == null) {
            return null;
        }
        byte[] bArr = dhVar.f3399a;
        this.e = dhVar.d;
        return bArr;
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }
}

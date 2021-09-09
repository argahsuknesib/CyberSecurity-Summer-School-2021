package _m_j;

import _m_j.dxr;
import _m_j.dya;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.core.net.NetInfo;
import com.xiaomi.miot.support.monitor.dns.DnsInfo;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public final class dxs extends EventListener {
    public static final EventListener.Factory O00000Oo = new EventListener.Factory() {
        /* class _m_j.dxs.AnonymousClass1 */

        public final EventListener create(Call call) {
            return new dxs(call, System.nanoTime());
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    long f15042O000000o;
    private long O00000o;
    private final long O00000o0;
    private long O00000oO;
    private long O00000oo;
    private String O0000O0o;
    private boolean O0000OOo = false;
    private String O0000Oo;
    private int O0000Oo0;

    public dxs(Call call, long j) {
        this.O00000o0 = j;
        if (call != null && call.request() != null && call.request().url() != null) {
            HttpUrl url = call.request().url();
            this.O0000Oo = url.toString();
            this.O0000O0o = url.host();
            new StringBuilder("HttpEventListener: ").append(this.O0000Oo);
        }
    }

    public final void callStart(Call call) {
        this.f15042O000000o = System.currentTimeMillis();
        super.callStart(call);
        new StringBuilder("callStart: ").append(this.O0000Oo);
    }

    public final void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        this.O0000Oo0 = 100;
        this.O0000OOo = true;
        this.O00000o = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("connect dns start =   && ");
        sb.append(str);
        sb.append("  ");
        sb.append(this.O0000OOo);
        sb.append("   && mUrl = ");
        sb.append(this.O0000Oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.dya.O000000o(java.lang.String, java.lang.String, java.util.List<com.xiaomi.miot.support.monitor.core.net.NetInfo>):void
      _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void */
    public final void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        long currentTimeMillis = System.currentTimeMillis() - this.O00000o;
        dya.O000000o.f15057O000000o.O000000o("dns", str, true);
        StringBuilder sb = new StringBuilder("connect dns time = ");
        sb.append(currentTimeMillis);
        sb.append("  && ");
        sb.append(str);
        sb.append("  ");
        sb.append(this.O0000OOo);
        sb.append("   && mUrl = ");
        sb.append(this.O0000Oo);
        if (this.O00000o > 0 && !TextUtils.isEmpty(this.O0000Oo) && currentTimeMillis > 0 && this.O0000OOo) {
            NetInfo netInfo = new NetInfo((byte) 0);
            String scheme = !TextUtils.isEmpty(this.O0000Oo) ? Uri.parse(this.O0000Oo).getScheme() : "https";
            netInfo.url = scheme + "://" + str;
            netInfo.costTime = currentTimeMillis;
            dya.O000000o.f15057O000000o.O000000o("dns", netInfo);
        }
        if (list != null && list.size() > 0) {
            dya dya = dya.O000000o.f15057O000000o;
            if (dxr.O000000o.f15041O000000o.O000000o().O0000Oo0.switchFlag && !TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
                dzg.O000000o(new Runnable(str, list) {
                    /* class _m_j.dya.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f15056O000000o;
                    final /* synthetic */ List O00000Oo;

                    {
                        this.f15056O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void run() {
                        Map map;
                        try {
                            synchronized (dya.this.O0000o00) {
                                map = dya.this.O0000Ooo.get();
                            }
                            if (map == null) {
                                map = new HashMap();
                            }
                            if (map.containsKey(this.f15056O000000o)) {
                                List list = (List) map.get(this.f15056O000000o);
                                for (InetAddress inetAddress : this.O00000Oo) {
                                    long O000000o2 = dya.O000000o(inetAddress);
                                    if (O000000o2 > 0) {
                                        synchronized (dya.this.O0000o00) {
                                            list.add(new DnsInfo(this.f15056O000000o, inetAddress.getHostAddress(), O000000o2));
                                        }
                                    }
                                }
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            for (InetAddress inetAddress2 : this.O00000Oo) {
                                long O000000o3 = dya.O000000o(inetAddress2);
                                if (O000000o3 > 0) {
                                    synchronized (dya.this.O0000o00) {
                                        arrayList.add(new DnsInfo(this.f15056O000000o, inetAddress2.getHostAddress(), O000000o3));
                                    }
                                }
                            }
                            synchronized (dya.this.O0000o00) {
                                map.put(this.f15056O000000o, arrayList);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
        this.O0000OOo = false;
    }

    public final void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        new StringBuilder("connectStart:    && mUrl = ").append(this.O0000Oo);
        this.O0000Oo0 = 101;
        this.O00000oO = System.currentTimeMillis();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.dya.O000000o(java.lang.String, java.lang.String, java.util.List<com.xiaomi.miot.support.monitor.core.net.NetInfo>):void
      _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void */
    public final void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        long currentTimeMillis = System.currentTimeMillis();
        this.O0000Oo0 = 102;
        this.O00000oo = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.O0000O0o)) {
            long j = this.O00000oo;
            long j2 = this.O00000oO;
            long j3 = j - j2;
            if (j2 > 0 && j3 > 0) {
                NetInfo netInfo = new NetInfo((byte) 0);
                String scheme = !TextUtils.isEmpty(this.O0000Oo) ? Uri.parse(this.O0000Oo).getScheme() : "https";
                netInfo.url = scheme + "://" + this.O0000O0o;
                StringBuilder sb = new StringBuilder("connect tcp time = ");
                sb.append(j3);
                sb.append("  && ");
                sb.append(netInfo.url);
                netInfo.costTime = j3;
                dya.O000000o.f15057O000000o.O000000o("tcp", netInfo);
            }
            dya.O000000o.f15057O000000o.O000000o("tcp", this.O0000O0o, true);
            StringBuilder sb2 = new StringBuilder("secureConnectStart time =  ");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            sb2.append("  ");
            sb2.append(this.O0000O0o);
            sb2.append("   && mUrl = ");
            sb2.append(this.O0000Oo);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.dya.O000000o(java.lang.String, java.lang.String, java.util.List<com.xiaomi.miot.support.monitor.core.net.NetInfo>):void
      _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void */
    public final void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        if (!TextUtils.isEmpty(this.O0000O0o)) {
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            long j = this.O00000oo;
            long j2 = currentTimeMillis2 - j;
            if (j > 0 && j2 > 0) {
                NetInfo netInfo = new NetInfo((byte) 0);
                String scheme = !TextUtils.isEmpty(this.O0000Oo) ? Uri.parse(this.O0000Oo).getScheme() : "https";
                netInfo.url = scheme + "://" + this.O0000O0o;
                StringBuilder sb = new StringBuilder("connect ssl time = ");
                sb.append(j2);
                sb.append("  && ");
                sb.append(netInfo.url);
                netInfo.costTime = j2;
                dya.O000000o.f15057O000000o.O000000o("ssl", netInfo);
            }
            dya.O000000o.f15057O000000o.O000000o("ssl", this.O0000O0o, true);
            StringBuilder sb2 = new StringBuilder("secureConnectEnd time =  ");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            sb2.append("   && mUrl = ");
            sb2.append(this.O0000Oo);
        }
    }

    public final void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        this.O0000Oo0 = 103;
        StringBuilder sb = new StringBuilder("connectEnd:    && mUrl = ");
        sb.append(this.O0000Oo);
        sb.append(" && ");
        sb.append(this.O0000O0o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.dya.O000000o(java.lang.String, java.lang.String, java.util.List<com.xiaomi.miot.support.monitor.core.net.NetInfo>):void
      _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void */
    public final void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        long currentTimeMillis = System.currentTimeMillis();
        if (O000000o()) {
            int i = this.O0000Oo0;
            if (i == 101) {
                dya.O000000o.f15057O000000o.O000000o("tcp", this.O0000O0o, false);
            } else if (i == 102) {
                dya.O000000o.f15057O000000o.O000000o("ssl", this.O0000O0o, false);
            }
        }
        StringBuilder sb = new StringBuilder("connectFailed time =  ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append("   && mUrl = ");
        sb.append(this.O0000Oo);
    }

    public final void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        new StringBuilder("connectionAcquired:    && mUrl = ").append(this.O0000Oo);
    }

    public final void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        new StringBuilder("connectionReleased:    && mUrl = ").append(this.O0000Oo);
    }

    public final void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        this.O0000Oo0 = 103;
        new StringBuilder("requestHeadersStart:    && mUrl = ").append(this.O0000Oo);
    }

    public final void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        new StringBuilder("requestHeadersEnd:    && mUrl = ").append(this.O0000Oo);
    }

    public final void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        new StringBuilder("requestBodyStart:    && mUrl = ").append(this.O0000Oo);
    }

    public final void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        new StringBuilder("requestBodyEnd:    && mUrl = ").append(this.O0000Oo);
    }

    public final void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        new StringBuilder("responseHeadersStart:    && mUrl = ").append(this.O0000Oo);
    }

    public final void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        new StringBuilder("responseHeadersEnd:    && mUrl = ").append(this.O0000Oo);
    }

    public final void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        new StringBuilder("responseBodyStart:    && mUrl = ").append(this.O0000Oo);
    }

    public final void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        new StringBuilder("responseBodyEnd:    && mUrl = ").append(this.O0000Oo);
    }

    public final void callEnd(Call call) {
        super.callEnd(call);
        new StringBuilder("callEnd:    && mUrl = ").append(this.O0000Oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.dya.O000000o(java.lang.String, java.lang.String, java.util.List<com.xiaomi.miot.support.monitor.core.net.NetInfo>):void
      _m_j.dya.O000000o(java.lang.String, java.lang.String, boolean):void */
    public final void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        StringBuilder sb = new StringBuilder("callFailed: miio_lifan_call :");
        sb.append(iOException.toString());
        sb.append("   && mUrl = ");
        sb.append(this.O0000Oo);
        sb.append("  && costTime = ");
        sb.append(System.currentTimeMillis() - this.f15042O000000o);
        try {
            boolean O000000o2 = O000000o();
            dya dya = dya.O000000o.f15057O000000o;
            String str = this.O0000O0o;
            String simpleName = iOException.getClass().getSimpleName();
            String iOException2 = iOException.toString();
            int i = this.O0000Oo0;
            String str2 = this.O0000Oo;
            long currentTimeMillis = System.currentTimeMillis() - this.f15042O000000o;
            String O000000o3 = O000000o(iOException);
            if (!TextUtils.isEmpty("all") && !TextUtils.isEmpty(str)) {
                try {
                    JSONObject put = new JSONObject().put("tp", "all").put("h", str).put("nt", O000000o2 ? 1 : 0).put("in", simpleName).put("ied", iOException2).put("st", i).put("ct", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).put("u", str2).put("rt", currentTimeMillis);
                    dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(109, dxr.O000000o.f15041O000000o.O000000o().O0000OOo.report_type, put);
                    gsy.O00000o0(LogType.MONITOR, "all", put.put("si", O000000o3).toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.O0000Oo0 == 100 && (iOException instanceof UnknownHostException) && O000000o2) {
                dya.O000000o.f15057O000000o.O000000o("dns", this.O0000O0o, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String O000000o(IOException iOException) {
        StackTraceElement[] stackTrace = iOException.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString() + "\n");
        }
        return sb.toString();
    }

    private static boolean O000000o() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) dxr.O000000o.f15041O000000o.O00000Oo.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

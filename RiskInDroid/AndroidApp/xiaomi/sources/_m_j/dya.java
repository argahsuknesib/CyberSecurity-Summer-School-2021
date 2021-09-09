package _m_j;

import _m_j.dxr;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.core.activity.ActivityInfo;
import com.xiaomi.miot.support.monitor.core.appstart.AppStartInfo;
import com.xiaomi.miot.support.monitor.core.fps.FpsInfo;
import com.xiaomi.miot.support.monitor.core.net.NetInfo;
import com.xiaomi.miot.support.monitor.core.net.NetRateInfo;
import com.xiaomi.miot.support.monitor.dns.DnsInfo;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class dya {

    /* renamed from: O000000o  reason: collision with root package name */
    public SoftReference<Map<String, Long>> f15053O000000o;
    public SoftReference<List<ActivityInfo>> O00000Oo;
    public SoftReference<List<FpsInfo>> O00000o;
    public String O00000o0;
    public String O00000oO;
    public long O00000oo;
    public long O0000O0o;
    public long O0000OOo;
    public SoftReference<List<AppStartInfo>> O0000Oo;
    public int O0000Oo0;
    public String O0000OoO;
    public SoftReference<Map<String, List<DnsInfo>>> O0000Ooo;
    private SoftReference<Map<String, List<NetInfo>>> O0000o;
    private SoftReference<Map<String, List<NetInfo>>> O0000o0;
    public String O0000o00;
    private SoftReference<Map<String, List<NetInfo>>> O0000o0O;
    private SoftReference<Map<String, List<NetInfo>>> O0000o0o;
    private SoftReference<Map<String, NetRateInfo>> O0000oO;
    private String O0000oO0;
    private SoftReference<Map<String, NetRateInfo>> O0000oOO;
    private SoftReference<Map<String, NetRateInfo>> O0000oOo;
    private String O0000oo;
    private SoftReference<Map<String, NetRateInfo>> O0000oo0;
    private SoftReference<Map<String, NetRateInfo>> O0000ooO;
    private String O0000ooo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static dya f15057O000000o = new dya((byte) 0);
    }

    /* synthetic */ dya(byte b) {
        this();
    }

    private dya() {
        this.f15053O000000o = new SoftReference<>(new HashMap());
        this.O0000o0 = new SoftReference<>(new HashMap());
        this.O0000o0O = new SoftReference<>(new HashMap());
        this.O0000o0o = new SoftReference<>(new HashMap());
        this.O0000o = new SoftReference<>(new HashMap());
        this.O0000oO0 = "netInfo";
        this.O0000oO = new SoftReference<>(new HashMap());
        this.O0000oOO = new SoftReference<>(new HashMap());
        this.O0000oOo = new SoftReference<>(new HashMap());
        this.O0000oo0 = new SoftReference<>(new HashMap());
        this.O0000oo = "net_rate";
        this.O00000Oo = new SoftReference<>(new ArrayList());
        this.O00000o0 = "activityInfo";
        this.O00000o = new SoftReference<>(new ArrayList());
        this.O00000oO = "fpsInfo";
        this.O00000oo = 0;
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        this.O0000Oo0 = 0;
        this.O0000Oo = new SoftReference<>(new ArrayList());
        this.O0000OoO = "appStartInfo";
        this.O0000Ooo = new SoftReference<>(new HashMap());
        this.O0000o00 = "dnsAddresses";
        this.O0000ooO = new SoftReference<>(new HashMap());
        this.O0000ooo = "dns_type";
    }

    public final void O000000o(String str, NetInfo netInfo) {
        Map map;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(netInfo.url)) {
                Uri parse = Uri.parse(netInfo.url);
                String str2 = parse.getHost() + parse.getPath();
                if (!TextUtils.isEmpty(str2)) {
                    if (TextUtils.equals(str, "tcp")) {
                        map = this.O0000o0O.get();
                    } else if (TextUtils.equals(str, "ssl")) {
                        map = this.O0000o0o.get();
                    } else if (TextUtils.equals(str, "dns")) {
                        map = this.O0000o.get();
                    } else {
                        map = this.O0000o0.get();
                    }
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (map.containsKey(str2)) {
                        List list = (List) map.get(str2);
                        synchronized (this.O0000oO0) {
                            if (list == null) {
                                list = new ArrayList();
                            }
                            list.add(netInfo);
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(netInfo);
                    map.put(str2, arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O000000o(String str, String str2, List<NetInfo> list) {
        long j;
        List<NetInfo> list2 = list;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list2 != null && list.size() != 0) {
            int i = 0;
            String str3 = list2.get(0).url;
            synchronized (this.O0000oO0) {
                Iterator<NetInfo> it = list.iterator();
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                int i2 = 0;
                long j7 = 0;
                while (it.hasNext()) {
                    NetInfo next = it.next();
                    if (next.statusCode != 200) {
                        j = j3;
                        O000000o(str, next.url, next.costTime, next.sentBytes, next.receivedBytes, next.back_type, 1, next.statusCode);
                        str3 = str3;
                        it = it;
                        i = i;
                    } else {
                        int i3 = i;
                        String str4 = str3;
                        Iterator<NetInfo> it2 = it;
                        j = j3;
                        if (next.back_type == 1) {
                            i2++;
                            j7 += next.costTime;
                            j2 += next.sentBytes;
                            j3 = j + next.receivedBytes;
                            str3 = str4;
                            it = it2;
                            i = i3;
                        } else {
                            i = i3 + 1;
                            j4 += next.costTime;
                            j5 += next.sentBytes;
                            j6 += next.receivedBytes;
                            str3 = str4;
                            it = it2;
                        }
                    }
                    j3 = j;
                }
                String str5 = str3;
                O000000o(str, str5, j7, j2, j3, 1, i2, 200);
                O000000o(str, str5, j4, j5, j6, 2, i, 200);
                list.clear();
            }
        }
    }

    private static void O000000o(String str, String str2, long j, long j2, long j3, int i, int i2, int i3) {
        if (i2 != 0) {
            try {
                JSONObject put = new JSONObject().put("tp", str).put("h", Uri.parse(str2).getHost()).put("t", j).put("stb", j2).put("rtb", j3).put("bt", i).put("n", i2).put("u", str2).put("sc", i3);
                if (i == 2) {
                    dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o("monitor background request:", put);
                }
                dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(107, dxr.O000000o.f15041O000000o.O000000o().O0000OOo.report_type, put);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void O000000o(String str, SoftReference<Map<String, List<NetInfo>>> softReference) {
        Map map;
        if (softReference != null && (map = softReference.get()) != null && map.size() != 0) {
            for (String str2 : map.keySet()) {
                O000000o(str, str2, (List) map.get(str2));
            }
        }
    }

    public final void O000000o(String str, String str2, boolean z) {
        Map map;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (TextUtils.equals(str, "tcp")) {
                    map = this.O0000oOo.get();
                } else if (TextUtils.equals(str, "ssl")) {
                    map = this.O0000oo0.get();
                } else if (TextUtils.equals(str, "dns")) {
                    map = this.O0000oOO.get();
                } else if (TextUtils.equals(str, "all")) {
                    map = this.O0000oO.get();
                } else {
                    return;
                }
                if (map == null) {
                    map = new HashMap();
                }
                synchronized (this.O0000oo) {
                    if (map.containsKey(str2)) {
                        NetRateInfo netRateInfo = (NetRateInfo) map.get(str2);
                        netRateInfo.totalCount++;
                        if (!z) {
                            netRateInfo.failedCount++;
                        }
                        StringBuilder sb = new StringBuilder("storeNetRateData: tn = ");
                        sb.append(netRateInfo.totalCount);
                        sb.append("  &&fn = ");
                        sb.append(netRateInfo.failedCount);
                        sb.append("  host= ");
                        sb.append(str2);
                    } else {
                        NetRateInfo netRateInfo2 = new NetRateInfo();
                        netRateInfo2.totalCount++;
                        if (!z) {
                            netRateInfo2.failedCount++;
                        }
                        map.put(str2, netRateInfo2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O00000Oo(String str, SoftReference<Map<String, NetRateInfo>> softReference) throws Exception {
        Map map;
        if (softReference != null && (map = softReference.get()) != null && map.size() != 0) {
            synchronized (this.O0000oo) {
                for (String str2 : map.keySet()) {
                    NetRateInfo netRateInfo = (NetRateInfo) map.get(str2);
                    dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(108, dxr.O000000o.f15041O000000o.O000000o().O0000OOo.report_type, new JSONObject().put("tp", str).put("h", str2).put("tn", netRateInfo.totalCount).put("fn", netRateInfo.failedCount));
                }
                map.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053 A[SYNTHETIC, Splitter:B:22:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[SYNTHETIC, Splitter:B:25:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a A[SYNTHETIC, Splitter:B:31:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0 A[SYNTHETIC, Splitter:B:40:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    public static long O000000o(InetAddress inetAddress) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, 80);
        Socket socket = null;
        try {
            Socket socket2 = new Socket();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                socket2.connect(inetSocketAddress, 6000);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (inetAddress != null) {
                    StringBuilder sb = new StringBuilder("execSocket: success :  ");
                    sb.append(currentTimeMillis2 - currentTimeMillis);
                    sb.append("  ");
                    sb.append(inetAddress.getHostName());
                    sb.append("  ");
                    sb.append(inetAddress.getHostAddress());
                }
                long j = currentTimeMillis2 - currentTimeMillis;
                try {
                    socket2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return j;
            } catch (SocketTimeoutException unused) {
                socket = socket2;
                if (inetAddress != null) {
                    StringBuilder sb2 = new StringBuilder("execSocket: SocketTimeoutException :  ");
                    sb2.append(inetAddress.getHostName());
                    sb2.append("  ");
                    sb2.append(inetAddress.getHostAddress());
                }
                if (socket != null) {
                    return -1;
                }
                try {
                    socket.close();
                    return -1;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return -1;
                }
            } catch (IOException unused2) {
                socket = socket2;
                if (inetAddress != null) {
                    try {
                        StringBuilder sb3 = new StringBuilder("execSocket: IOException :  ");
                        sb3.append(inetAddress.getHostName());
                        sb3.append("  ");
                        sb3.append(inetAddress.getHostAddress());
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                if (socket != null) {
                    return -2;
                }
                try {
                    socket.close();
                    return -2;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return -2;
                }
            } catch (Throwable th2) {
                th = th2;
                socket = socket2;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (SocketTimeoutException unused3) {
            if (inetAddress != null) {
            }
            if (socket != null) {
            }
        } catch (IOException unused4) {
            if (inetAddress != null) {
            }
            if (socket != null) {
            }
        }
    }

    public final void O000000o(String str, boolean z) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.O0000ooO == null) {
                    this.O0000ooO = new SoftReference<>(new HashMap());
                }
                Map map = this.O0000ooO.get();
                if (map == null) {
                    map = new HashMap();
                }
                synchronized (this.O0000ooo) {
                    if (map.containsKey(str)) {
                        NetRateInfo netRateInfo = (NetRateInfo) map.get(str);
                        if (z) {
                            netRateInfo.hdc++;
                        } else {
                            netRateInfo.sdc++;
                        }
                    } else {
                        NetRateInfo netRateInfo2 = new NetRateInfo();
                        if (z) {
                            netRateInfo2.hdc++;
                        } else {
                            netRateInfo2.sdc++;
                        }
                        map.put(str, netRateInfo2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O000000o(SoftReference<Map<String, NetRateInfo>> softReference) throws Exception {
        Map map;
        if (softReference != null && (map = softReference.get()) != null && map.size() != 0) {
            synchronized (this.O0000ooo) {
                for (String str : map.keySet()) {
                    NetRateInfo netRateInfo = (NetRateInfo) map.get(str);
                    dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(111, dxr.O000000o.f15041O000000o.O000000o().O0000OOo.report_type, new JSONObject().put("h", str).put("sdc", netRateInfo.sdc).put("hdc", netRateInfo.hdc));
                }
                map.clear();
            }
        }
    }

    public final void O000000o() {
        try {
            if (dxr.O000000o.f15041O000000o.O000000o().O0000OOo.switchFlag) {
                O000000o("http", this.O0000o0);
                O000000o("tcp", this.O0000o0O);
                O000000o("ssl", this.O0000o0o);
                O000000o("dns", this.O0000o);
                O00000Oo();
                O00000o0();
                O00000o();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O00000Oo() throws Exception {
        if (dxr.O000000o.f15041O000000o.O000000o().O0000OOo.switchFlag) {
            O00000Oo("tcp", this.O0000oOo);
            O00000Oo("ssl", this.O0000oo0);
            O00000Oo("dns", this.O0000oOO);
            O00000Oo("all", this.O0000oO);
        }
    }

    private void O00000o0() throws Exception {
        Map map;
        if (dxr.O000000o.f15041O000000o.O000000o().O0000Oo0.switchFlag && (map = this.O0000Ooo.get()) != null && map.size() != 0) {
            synchronized (this.O0000o00) {
                for (String str : map.keySet()) {
                    for (DnsInfo dnsInfo : (List) map.get(str)) {
                        dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(110, dxr.O000000o.f15041O000000o.O000000o().O0000Oo0.report_type, new JSONObject().put("h", dnsInfo.hostName).put("i", dnsInfo.ip).put("t", dnsInfo.tcpTime));
                    }
                }
                map.clear();
            }
        }
    }

    private void O00000o() throws Exception {
        if (dxr.O000000o.f15041O000000o.O000000o().O0000OOo.switchFlag) {
            O000000o(this.O0000ooO);
        }
    }
}

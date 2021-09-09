package _m_j;

import android.content.Context;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.smartconfig.WifiInfo;
import java.util.ArrayList;

public final class fuf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O00000Oo[] f17169O000000o = {new O00000Oo(1073741824, "GB/s"), new O00000Oo(ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, "MB/s"), new O00000Oo(1024, "KB/s")};
    private static volatile fuf O00000Oo;
    private static final Object O00000o0 = new Object();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17171O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public ArrayList<WifiInfo> f17173O000000o = new ArrayList<>();
    }

    private fuf() {
    }

    public static fuf O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0) {
                if (O00000Oo == null) {
                    O00000Oo = new fuf();
                }
            }
        }
        return O00000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
     arg types: [android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, int, ?[OBJECT, ARRAY], _m_j.fsm<java.lang.Void, _m_j.fso>]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn */
    public static fsn O000000o(Context context, String str, String str2, String str3, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("d", str3));
        arrayList.add(new KeyValuePair("deviceName", str2));
        arrayList.add(new KeyValuePair("deviceID", str));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/s/register").O000000o(arrayList).O000000o(), str, true, (fss) null, (fsm) fsm);
    }

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f17172O000000o;
        String O00000Oo;

        public O00000Oo(int i, String str) {
            this.f17172O000000o = i;
            this.O00000Oo = str;
        }
    }
}

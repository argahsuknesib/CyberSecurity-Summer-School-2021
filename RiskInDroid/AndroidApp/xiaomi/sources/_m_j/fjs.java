package _m_j;

import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import org.json.JSONObject;

public final class fjs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Object f16497O000000o = new Object();
    private static volatile fjs O00000Oo;

    public static fjs O000000o() {
        if (O00000Oo == null) {
            synchronized (f16497O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fjs();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(final Device device, final fdh<NetResult, NetError> fdh) {
        String did = device.getDid();
        if (did.startsWith("miwifi.")) {
            did = did.substring(7);
        }
        AnonymousClass1 r1 = new fdh<NetResult, NetError>() {
            /* class _m_j.fjs.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                int i;
                NetError netError = (NetError) error;
                if (netError != null) {
                    i = netError.f6718O000000o;
                } else {
                    i = -1;
                }
                fjq.O000000o();
                fjq.O000000o(device, i, new fdh<NetResult, NetError>() {
                    /* class _m_j.fjs.AnonymousClass1.AnonymousClass2 */

                    public final /* bridge */ /* synthetic */ void onFailure(Error error) {
                        NetError netError = (NetError) error;
                        if (fdh != null) {
                            fdh.onFailure(netError);
                        }
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        NetResult netResult = (NetResult) obj;
                        if (fdh != null) {
                            fdh.onSuccess(netResult);
                        }
                    }
                });
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                if (fdh != null) {
                    try {
                        int optInt = new JSONObject(netResult.O00000o0).optInt("code");
                        if (optInt != 0) {
                            fjq.O000000o();
                            fjq.O000000o(device, optInt, new fdh<NetResult, NetError>() {
                                /* class _m_j.fjs.AnonymousClass1.AnonymousClass1 */

                                public final /* bridge */ /* synthetic */ void onFailure(Error error) {
                                    NetError netError = (NetError) error;
                                    if (fdh != null) {
                                        fdh.onFailure(netError);
                                    }
                                }

                                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                    NetResult netResult = (NetResult) obj;
                                    if (fdh != null) {
                                        fdh.onSuccess(netResult);
                                    }
                                }
                            });
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fdh.onSuccess(netResult);
                }
            }
        };
        if (device.isOwner()) {
            O000000o();
            O000000o(did, r1);
        } else if (device.isShared() || device.isFamily()) {
            O000000o();
            O00000Oo(did, r1);
        }
    }

    private static fdi O000000o(String str, fdh<NetResult, NetError> fdh) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("deviceID", str));
        return fdo.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/s/admin/dismiss").O000000o(arrayList).O000000o(), str, true, fdh);
    }

    private static fdi O00000Oo(String str, fdh<NetResult, NetError> fdh) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("deviceId", str));
        return fdo.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/s/admin/demoteSelf").O000000o(arrayList).O000000o(), str, true, fdh);
    }
}

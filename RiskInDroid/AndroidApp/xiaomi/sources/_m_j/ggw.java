package _m_j;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ggw extends gfw<HomeDeviceInfo> {
    private static final String O00000Oo = "ggw";
    private static volatile ggw O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, HomeDeviceInfo> f17754O000000o = new ConcurrentHashMap();

    private ggw() {
    }

    public static ggw O000000o() {
        if (O00000o0 == null) {
            synchronized (ggw.class) {
                if (O00000o0 == null) {
                    O00000o0 = new ggw();
                }
            }
        }
        return O00000o0;
    }

    public final HomeDeviceInfo O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HomeDeviceInfo homeDeviceInfo = this.f17754O000000o.get(str);
        if (homeDeviceInfo == null && (homeDeviceInfo = O00000Oo(str)) != null) {
            this.f17754O000000o.put(str, homeDeviceInfo);
        }
        return homeDeviceInfo;
    }

    public final void O00000Oo() {
        Set<String> keySet = this.f17754O000000o.keySet();
        if (keySet != null) {
            try {
                for (String next : keySet) {
                    this.f17754O000000o.put(next, O00000Oo(next));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static HomeDeviceInfo O00000Oo(String str) {
        HomeDeviceInfo O0000Ooo = CoreApi.O000000o().O0000Ooo(str);
        if (O0000Ooo != null) {
            O000000o(O0000Ooo);
        }
        return O0000Ooo;
    }

    private static void O000000o(HomeDeviceInfo homeDeviceInfo) {
        if (homeDeviceInfo != null && homeDeviceInfo.O00000Oo() != null) {
            Home O00000Oo2 = homeDeviceInfo.O00000Oo();
            Home O00000o = ggb.O00000Oo().O00000o(O00000Oo2.getId());
            if (O00000o != null) {
                O00000o.setDids(O00000Oo2.getDids());
                List<Room> roomList = O00000Oo2.getRoomList();
                List<Room> roomList2 = O00000o.getRoomList();
                if (roomList != null && roomList2 != null && !roomList.isEmpty() && !roomList2.isEmpty()) {
                    for (int i = 0; i < roomList.size(); i++) {
                        Room room = roomList.get(i);
                        if (room != null) {
                            Room room2 = null;
                            int i2 = 0;
                            while (true) {
                                if (i2 < roomList2.size()) {
                                    Room room3 = roomList2.get(i2);
                                    if (room3 != null && TextUtils.equals(room3.getId(), room.getId())) {
                                        room2 = room3;
                                        break;
                                    }
                                    i2++;
                                } else {
                                    break;
                                }
                            }
                            if (room2 != null) {
                                room2.setDids(room.getDids());
                            }
                        }
                    }
                }
            }
        }
    }

    public final void O000000o(long j, final fsm fsm) {
        final String valueOf = String.valueOf(j);
        Home O00000o = ggb.O00000Oo().O00000o(valueOf);
        CoreApi O000000o2 = CoreApi.O000000o();
        try {
            O000000o2.O00000Oo().loadHomeDeviceList(O00000o.getOwnerUid(), j, new IClientCallback.Stub(new fsm<Object, fso>() {
                /* class _m_j.ggw.AnonymousClass1 */

                public final void onSuccess(final Object obj) {
                    ggw.this.f17754O000000o.put(valueOf, ggw.O00000Oo(valueOf));
                    fno.O000000o().O000000o(new fno.O000000o() {
                        /* class _m_j.ggw.AnonymousClass1.AnonymousClass1 */

                        public final void onRefreshClientDeviceChanged(int i, Device device) {
                        }

                        public final void onRefreshClientDeviceSuccess(int i) {
                            fno.O000000o().O00000Oo(this);
                            if (fsm != null) {
                                ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                                    /* class _m_j.ggw.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        fsm.onSuccess(obj);
                                    }
                                }, 500);
                            }
                        }
                    });
                    fno.O000000o().O0000Oo0();
                }

                public final void onFailure(fso fso) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                }
            }) {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass75 */
                final /* synthetic */ fsm val$callback;

                {
                    this.val$callback = r2;
                }

                public void onSuccess(Bundle bundle) {
                    fsm fsm = this.val$callback;
                    if (fsm != null) {
                        fsm.onSuccess(bundle);
                    }
                }

                /* JADX WARN: Type inference failed for: r4v7, types: [android.os.Parcelable] */
                /* JADX WARNING: Multi-variable type inference failed */
                public void onFailure(Bundle bundle) {
                    fso fso;
                    if (this.val$callback != null) {
                        NetError netError = null;
                        if (bundle != null) {
                            bundle.setClassLoader(fso.class.getClassLoader());
                            netError = bundle.getParcelable("error");
                        }
                        if (netError == null) {
                            fso = new fso(-9999, "errorBundle is null");
                        } else if (!TextUtils.isEmpty(netError.O00000o0)) {
                            fso = new fso(netError.f6718O000000o, netError.O00000Oo, netError.O00000o0);
                        } else {
                            fso = new fso(netError.f6718O000000o, netError.O00000Oo);
                        }
                        this.val$callback.onFailure(fso);
                    }
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final List<Device> O00000o0(String str) {
        HomeDeviceInfo O000000o2 = O000000o(str);
        if (O000000o2 == null) {
            return new ArrayList();
        }
        List<String> O00000oO = O000000o2.O00000oO();
        if (O00000oO == null || O00000oO.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < O00000oO.size(); i++) {
            Device O000000o3 = fno.O000000o().O000000o(O00000oO.get(i));
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        return arrayList;
    }
}

package _m_j;

import _m_j.fdi;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fjx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f16504O000000o = "fjx";
    private static volatile fjx O00000oO;
    public Map<String, HomeDeviceInfo> O00000Oo = new ConcurrentHashMap();
    public Set<Home> O00000o = new HashSet();
    public Home O00000o0;

    private fjx() {
        try {
            String O0000O0o = ftd.O0000O0o(O00000o0());
            if (!TextUtils.isEmpty(O0000O0o)) {
                O000000o(O0000O0o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static fjx O000000o() {
        if (O00000oO == null) {
            synchronized (fjx.class) {
                if (O00000oO == null) {
                    O00000oO = new fjx();
                }
            }
        }
        return O00000oO;
    }

    public final void O000000o(Home home, ArrayList<Device> arrayList, fdh<ArrayList<Device>, NetError> fdh) {
        HomeDeviceInfo homeDeviceInfo;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        for (Home home2 : new CopyOnWriteArraySet(this.O00000o)) {
            if (!(home2 == null || home2.equals(home) || (homeDeviceInfo = this.O00000Oo.get(home2.getId())) == null || homeDeviceInfo.O00000o0() == null)) {
                arrayList2.addAll(homeDeviceInfo.O00000o0());
            }
        }
        if (fdh != null) {
            fdh.onSuccess(arrayList2);
        }
    }

    public final fdi O000000o(long j, long j2, fdh<ArrayList<Device>, NetError> fdh) {
        gsy.O00000Oo(LogType.HOME_ROOM, f16504O000000o, "updateSharedHomeDeviceList in");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_owner", j);
            try {
                jSONObject.put("home_id", j2);
                jSONObject.put("limit", 200);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            fdi.O000000o o000000o = new fdi.O000000o();
            gsy.O00000Oo(LogType.HOME_ROOM, f16504O000000o, "request /v2/home/home_device_list homeId=".concat(String.valueOf(j2)));
            o000000o.f16102O000000o = fdt.O000000o().O000000o(fjr.O000000o(jSONObject, "/v2/home/home_device_list"), new fdh<NetResult, NetError>(o000000o, fdh, j2, new AtomicBoolean(true), j, 200) {
                /* class _m_j.fjx.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ fdi.O000000o f16506O000000o;
                final /* synthetic */ fdh O00000Oo;
                final /* synthetic */ AtomicBoolean O00000o;
                final /* synthetic */ long O00000o0;
                final /* synthetic */ long O00000oO;
                final /* synthetic */ int O00000oo = 200;

                {
                    this.f16506O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                    this.O00000o = r6;
                    this.O00000oO = r7;
                }

                public final /* synthetic */ void onFailure(Error error) {
                    String str;
                    NetError netError = (NetError) error;
                    fdh fdh = this.O00000Oo;
                    if (fdh != null) {
                        fdh.onFailure(netError);
                    }
                    LogType logType = LogType.HOME_ROOM;
                    String str2 = fjx.f16504O000000o;
                    StringBuilder sb = new StringBuilder("updateSharedHomeDeviceList onFailure ");
                    if (netError == null) {
                        str = null;
                    } else {
                        str = netError.f6718O000000o + "," + netError.O00000Oo;
                    }
                    sb.append(str);
                    gsy.O00000Oo(logType, str2, sb.toString());
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    NetResult netResult = (NetResult) obj;
                    if (this.f16506O000000o.O00000Oo) {
                        fdh fdh = this.O00000Oo;
                        if (fdh != null) {
                            fdh.onFailure(new NetError(-1, "cancelled"));
                        }
                    } else if (netResult == null || TextUtils.isEmpty(netResult.O00000o0)) {
                        fjx.this.O00000Oo.remove(String.valueOf(this.O00000o0));
                        fdh fdh2 = this.O00000Oo;
                        if (fdh2 != null) {
                            fdh2.onFailure(new NetError(ErrorCode.ERROR_RESPONSE_JSON_FAIL.getCode(), "empty result"));
                        }
                        gsy.O00000Oo(LogType.HOME_ROOM, fjx.f16504O000000o, "updateSharedHomeDeviceList empty network response");
                    } else {
                        try {
                            JSONObject optJSONObject = new JSONObject(netResult.O00000o0).optJSONObject("result");
                            HomeDeviceInfo homeDeviceInfo = fjx.this.O00000Oo.get(String.valueOf(this.O00000o0));
                            int i = 0;
                            if (homeDeviceInfo == null) {
                                homeDeviceInfo = HomeDeviceInfo.O000000o(optJSONObject);
                                fjx.this.O00000Oo.put(String.valueOf(this.O00000o0), homeDeviceInfo);
                            } else {
                                HomeDeviceInfo O000000o2 = HomeDeviceInfo.O000000o(optJSONObject);
                                if (this.O00000o.getAndSet(false)) {
                                    fjx.this.O00000Oo.put(String.valueOf(this.O00000o0), O000000o2);
                                    homeDeviceInfo = O000000o2;
                                } else if (O000000o2 != null) {
                                    if (!(O000000o2 == null || O000000o2.O00000oO == null)) {
                                        if (!O000000o2.O00000oO.isEmpty()) {
                                            if (homeDeviceInfo.O00000oO == null) {
                                                homeDeviceInfo.O000000o(O000000o2.O00000oO);
                                            } else {
                                                homeDeviceInfo.O00000oO.addAll(O000000o2.O00000oO);
                                                homeDeviceInfo.O000000o(homeDeviceInfo.O00000oO);
                                            }
                                        }
                                    }
                                    homeDeviceInfo.O000000o(O000000o2);
                                }
                            }
                            fjx.this.O00000o.add(homeDeviceInfo.O00000Oo);
                            this.O00000o.set(false);
                            homeDeviceInfo.O000000o(fcn.O000000o().O00000Oo());
                            LogType logType = LogType.HOME_ROOM;
                            String str = fjx.f16504O000000o;
                            StringBuilder sb = new StringBuilder("home_device_list current size=");
                            sb.append(homeDeviceInfo.O00000o0() == null ? 0 : homeDeviceInfo.O00000o0().size());
                            gsy.O00000Oo(logType, str, sb.toString());
                            if (optJSONObject.isNull("has_more") || !optJSONObject.optBoolean("has_more") || optJSONObject.isNull("max_did")) {
                                fjx.O000000o(homeDeviceInfo);
                                LogType logType2 = LogType.HOME_ROOM;
                                String str2 = fjx.f16504O000000o;
                                StringBuilder sb2 = new StringBuilder("updateSharedHomeDeviceList home_device_list total size=");
                                if (homeDeviceInfo.O00000o0() != null) {
                                    i = homeDeviceInfo.O00000o0().size();
                                }
                                sb2.append(i);
                                gsy.O00000Oo(logType2, str2, sb2.toString());
                                if (this.O00000Oo != null) {
                                    this.O00000Oo.onSuccess((ArrayList) homeDeviceInfo.O00000o0());
                                }
                                fjx.this.O00000Oo();
                                return;
                            }
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("home_owner", this.O00000oO);
                                jSONObject.put("home_id", this.O00000o0);
                                jSONObject.put("limit", this.O00000oo);
                                jSONObject.put("start_did", optJSONObject.optString("max_did"));
                                this.f16506O000000o.f16102O000000o = fdt.O000000o().O000000o(fjr.O000000o(jSONObject, "/v2/home/home_device_list"), this);
                            } catch (Exception | JSONException unused) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            LogType logType3 = LogType.HOME_ROOM;
                            String str3 = fjx.f16504O000000o;
                            gsy.O00000Oo(logType3, str3, "updateSharedHomeDeviceList exception1:" + e.getMessage());
                            fdh fdh3 = this.O00000Oo;
                            if (fdh3 != null) {
                                fdh3.onFailure(new NetError(-1, e.getMessage()));
                            }
                        }
                    }
                }
            });
            return o000000o;
        }
        fdi.O000000o o000000o2 = new fdi.O000000o();
        gsy.O00000Oo(LogType.HOME_ROOM, f16504O000000o, "request /v2/home/home_device_list homeId=".concat(String.valueOf(j2)));
        o000000o2.f16102O000000o = fdt.O000000o().O000000o(fjr.O000000o(jSONObject, "/v2/home/home_device_list"), new fdh<NetResult, NetError>(o000000o2, fdh, j2, new AtomicBoolean(true), j, 200) {
            /* class _m_j.fjx.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fdi.O000000o f16506O000000o;
            final /* synthetic */ fdh O00000Oo;
            final /* synthetic */ AtomicBoolean O00000o;
            final /* synthetic */ long O00000o0;
            final /* synthetic */ long O00000oO;
            final /* synthetic */ int O00000oo = 200;

            {
                this.f16506O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o0 = r4;
                this.O00000o = r6;
                this.O00000oO = r7;
            }

            public final /* synthetic */ void onFailure(Error error) {
                String str;
                NetError netError = (NetError) error;
                fdh fdh = this.O00000Oo;
                if (fdh != null) {
                    fdh.onFailure(netError);
                }
                LogType logType = LogType.HOME_ROOM;
                String str2 = fjx.f16504O000000o;
                StringBuilder sb = new StringBuilder("updateSharedHomeDeviceList onFailure ");
                if (netError == null) {
                    str = null;
                } else {
                    str = netError.f6718O000000o + "," + netError.O00000Oo;
                }
                sb.append(str);
                gsy.O00000Oo(logType, str2, sb.toString());
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                if (this.f16506O000000o.O00000Oo) {
                    fdh fdh = this.O00000Oo;
                    if (fdh != null) {
                        fdh.onFailure(new NetError(-1, "cancelled"));
                    }
                } else if (netResult == null || TextUtils.isEmpty(netResult.O00000o0)) {
                    fjx.this.O00000Oo.remove(String.valueOf(this.O00000o0));
                    fdh fdh2 = this.O00000Oo;
                    if (fdh2 != null) {
                        fdh2.onFailure(new NetError(ErrorCode.ERROR_RESPONSE_JSON_FAIL.getCode(), "empty result"));
                    }
                    gsy.O00000Oo(LogType.HOME_ROOM, fjx.f16504O000000o, "updateSharedHomeDeviceList empty network response");
                } else {
                    try {
                        JSONObject optJSONObject = new JSONObject(netResult.O00000o0).optJSONObject("result");
                        HomeDeviceInfo homeDeviceInfo = fjx.this.O00000Oo.get(String.valueOf(this.O00000o0));
                        int i = 0;
                        if (homeDeviceInfo == null) {
                            homeDeviceInfo = HomeDeviceInfo.O000000o(optJSONObject);
                            fjx.this.O00000Oo.put(String.valueOf(this.O00000o0), homeDeviceInfo);
                        } else {
                            HomeDeviceInfo O000000o2 = HomeDeviceInfo.O000000o(optJSONObject);
                            if (this.O00000o.getAndSet(false)) {
                                fjx.this.O00000Oo.put(String.valueOf(this.O00000o0), O000000o2);
                                homeDeviceInfo = O000000o2;
                            } else if (O000000o2 != null) {
                                if (!(O000000o2 == null || O000000o2.O00000oO == null)) {
                                    if (!O000000o2.O00000oO.isEmpty()) {
                                        if (homeDeviceInfo.O00000oO == null) {
                                            homeDeviceInfo.O000000o(O000000o2.O00000oO);
                                        } else {
                                            homeDeviceInfo.O00000oO.addAll(O000000o2.O00000oO);
                                            homeDeviceInfo.O000000o(homeDeviceInfo.O00000oO);
                                        }
                                    }
                                }
                                homeDeviceInfo.O000000o(O000000o2);
                            }
                        }
                        fjx.this.O00000o.add(homeDeviceInfo.O00000Oo);
                        this.O00000o.set(false);
                        homeDeviceInfo.O000000o(fcn.O000000o().O00000Oo());
                        LogType logType = LogType.HOME_ROOM;
                        String str = fjx.f16504O000000o;
                        StringBuilder sb = new StringBuilder("home_device_list current size=");
                        sb.append(homeDeviceInfo.O00000o0() == null ? 0 : homeDeviceInfo.O00000o0().size());
                        gsy.O00000Oo(logType, str, sb.toString());
                        if (optJSONObject.isNull("has_more") || !optJSONObject.optBoolean("has_more") || optJSONObject.isNull("max_did")) {
                            fjx.O000000o(homeDeviceInfo);
                            LogType logType2 = LogType.HOME_ROOM;
                            String str2 = fjx.f16504O000000o;
                            StringBuilder sb2 = new StringBuilder("updateSharedHomeDeviceList home_device_list total size=");
                            if (homeDeviceInfo.O00000o0() != null) {
                                i = homeDeviceInfo.O00000o0().size();
                            }
                            sb2.append(i);
                            gsy.O00000Oo(logType2, str2, sb2.toString());
                            if (this.O00000Oo != null) {
                                this.O00000Oo.onSuccess((ArrayList) homeDeviceInfo.O00000o0());
                            }
                            fjx.this.O00000Oo();
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("home_owner", this.O00000oO);
                            jSONObject.put("home_id", this.O00000o0);
                            jSONObject.put("limit", this.O00000oo);
                            jSONObject.put("start_did", optJSONObject.optString("max_did"));
                            this.f16506O000000o.f16102O000000o = fdt.O000000o().O000000o(fjr.O000000o(jSONObject, "/v2/home/home_device_list"), this);
                        } catch (Exception | JSONException unused) {
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogType logType3 = LogType.HOME_ROOM;
                        String str3 = fjx.f16504O000000o;
                        gsy.O00000Oo(logType3, str3, "updateSharedHomeDeviceList exception1:" + e.getMessage());
                        fdh fdh3 = this.O00000Oo;
                        if (fdh3 != null) {
                            fdh3.onFailure(new NetError(-1, e.getMessage()));
                        }
                    }
                }
            }
        });
        return o000000o2;
    }

    public static void O000000o(HomeDeviceInfo homeDeviceInfo) {
        if (homeDeviceInfo != null && homeDeviceInfo.O00000o0() != null && !homeDeviceInfo.O00000o0().isEmpty()) {
            try {
                List<Device> O00000o02 = homeDeviceInfo.O00000o0();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (int i2 = 0; i2 < O00000o02.size(); i2++) {
                    Device device = O00000o02.get(i2);
                    if (device != null && !TextUtils.isEmpty(device.getParentId())) {
                        arrayList.add(device);
                    }
                }
                if (!arrayList.isEmpty()) {
                    Map<String, Device> O00000o2 = homeDeviceInfo.O00000o();
                    while (i < arrayList.size()) {
                        Device device2 = (Device) arrayList.get(i);
                        if (!(device2 == null || O00000o2.get(device2.getParentId()) == null)) {
                            arrayList.remove(i);
                            i--;
                        }
                        i++;
                    }
                    if (!arrayList.isEmpty()) {
                        gsy.O00000Oo(LogType.HOME_ROOM, f16504O000000o, "filterInvalidDevices found " + arrayList.size() + " invalid sub-devices");
                        O00000o02.removeAll(arrayList);
                        homeDeviceInfo.O000000o(O00000o02);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                gsy.O00000Oo(LogType.HOME_ROOM, f16504O000000o, "filterInvalidDevices exception " + e.getMessage());
            }
        }
    }

    public final void O00000Oo() {
        try {
            ftd.O000000o(O00000o(), O00000o0());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String O00000o0() {
        return CommonApplication.getAppContext().getFilesDir() + File.separator + "shared_home" + File.separator + "shared_home_devices_list_data_" + gpp.O000000o(fcn.O000000o().O00000Oo());
    }

    private void O000000o(String str) throws JSONException {
        if (gfr.O0000OOo) {
            gsy.O00000Oo(LogType.HOME_ROOM, f16504O000000o, "deSerializeFromString in:".concat(String.valueOf(str)));
        }
        JSONObject jSONObject = new JSONObject(str);
        if (TextUtils.equals(jSONObject.optString("uid"), fcn.O000000o().O00000Oo())) {
            if (!jSONObject.isNull("current_home")) {
                this.O00000o0 = Home.parse(jSONObject.optJSONObject("current_home"));
            }
            jSONObject.optLong("ts");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                double length = (double) optJSONArray.length();
                Double.isNaN(length);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap((int) (length * 1.5d), 0.75f);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    HomeDeviceInfo O000000o2 = HomeDeviceInfo.O000000o(optJSONArray.optJSONObject(i));
                    if (!(O000000o2 == null || O000000o2.O00000Oo == null)) {
                        LogType logType = LogType.HOME_ROOM;
                        String str2 = f16504O000000o;
                        StringBuilder sb = new StringBuilder("deSerializeFromString ");
                        sb.append(O000000o2.O00000Oo().getId());
                        sb.append(":");
                        sb.append(O000000o2.O00000Oo().getRawName());
                        sb.append(":");
                        sb.append(O000000o2.O00000o0() == null ? 0 : O000000o2.O00000o0().size());
                        sb.append(" devices");
                        gsy.O00000Oo(logType, str2, sb.toString());
                        concurrentHashMap.put(O000000o2.O00000Oo.getId(), O000000o2);
                    }
                }
                this.O00000Oo = concurrentHashMap;
            }
        }
    }

    private String O00000o() throws JSONException {
        Map<String, HomeDeviceInfo> map = this.O00000Oo;
        JSONObject jSONObject = null;
        if (map == null || map.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (HomeDeviceInfo next : map.values()) {
            if (next != null) {
                jSONArray.put(next.O000000o());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", jSONArray);
        jSONObject2.put("uid", fcn.O000000o().O00000Oo());
        jSONObject2.put("ts", System.currentTimeMillis());
        Home home = this.O00000o0;
        if (home != null) {
            jSONObject = home.toJSON();
        }
        jSONObject2.put("current_home", jSONObject);
        return jSONObject2.toString();
    }
}

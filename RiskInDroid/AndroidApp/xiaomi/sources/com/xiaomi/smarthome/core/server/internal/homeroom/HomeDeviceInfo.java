package com.xiaomi.smarthome.core.server.internal.homeroom;

import _m_j.fjb;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Home;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<HomeDeviceInfo> CREATOR = new Parcelable.Creator<HomeDeviceInfo>() {
        /* class com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new HomeDeviceInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new HomeDeviceInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f6890O000000o;
    public Home O00000Oo;
    protected String O00000o;
    protected boolean O00000o0;
    public List<Device> O00000oO;
    protected Map<String, Device> O00000oo = new ConcurrentHashMap();
    private List<String> O0000O0o;

    public int describeContents() {
        return 0;
    }

    public static HomeDeviceInfo O000000o(JSONObject jSONObject) {
        Device O000000o2;
        if (jSONObject == null) {
            return null;
        }
        HomeDeviceInfo homeDeviceInfo = new HomeDeviceInfo();
        if (!jSONObject.isNull("home_info")) {
            homeDeviceInfo.O00000Oo = Home.parse(jSONObject.optJSONObject("home_info"));
        }
        if (!jSONObject.isNull("device_info")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("device_info");
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (O000000o2 = fjb.O000000o(optJSONObject)) == null)) {
                    arrayList.add(O000000o2);
                }
            }
            homeDeviceInfo.O000000o(arrayList);
        }
        if (!jSONObject.isNull("dids")) {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("dids");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString = optJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList2.add(optString);
                    }
                }
                homeDeviceInfo.O0000O0o = arrayList2;
            }
        } else if (homeDeviceInfo.O00000o0() != null && !homeDeviceInfo.O00000o0().isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            for (Device next : homeDeviceInfo.O00000o0()) {
                if (next != null && !TextUtils.isEmpty(next.getDid())) {
                    arrayList3.add(next.getDid());
                }
            }
            homeDeviceInfo.O0000O0o = arrayList3;
        }
        homeDeviceInfo.O00000o0 = jSONObject.optBoolean("has_more", false);
        homeDeviceInfo.O00000o = jSONObject.optString("max_did");
        return homeDeviceInfo;
    }

    public final JSONObject O000000o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Home home = this.O00000Oo;
        if (home != null) {
            jSONObject.put("home_info", home.toJSON());
        }
        jSONObject.put("has_more", this.O00000o0);
        jSONObject.put("max_did", this.O00000o);
        List<String> list = this.O0000O0o;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("dids", jSONArray);
        }
        return jSONObject;
    }

    public final void O000000o(String str) {
        this.f6890O000000o = str;
    }

    public final Home O00000Oo() {
        return this.O00000Oo;
    }

    public final void O000000o(Home home) {
        this.O00000Oo = home;
    }

    public final List<Device> O00000o0() {
        List<Device> list = this.O00000oO;
        return list == null ? new ArrayList() : list;
    }

    public final void O000000o(List<Device> list) {
        this.O00000oO = list;
        this.O00000oo = new ConcurrentHashMap();
        O00000Oo(list);
        O00000oo();
    }

    public final Map<String, Device> O00000o() {
        return this.O00000oo;
    }

    private void O00000Oo(List<Device> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Device device = list.get(i);
                if (device != null) {
                    this.O00000oo.put(device.getDid(), device);
                }
            }
        }
    }

    public final List<String> O00000oO() {
        List<String> list = this.O0000O0o;
        return list == null ? new ArrayList() : list;
    }

    private void O00000oo() {
        List<Device> list = this.O00000oO;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            this.O0000O0o = arrayList;
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Device device = list.get(i);
            if (device != null) {
                arrayList.add(device.getDid());
            }
        }
        this.O0000O0o = arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6890O000000o);
        parcel.writeParcelable(this.O00000Oo, i);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
        parcel.writeString(this.O00000o);
        parcel.writeStringList(this.O0000O0o);
    }

    public HomeDeviceInfo() {
    }

    protected HomeDeviceInfo(Parcel parcel) {
        this.f6890O000000o = parcel.readString();
        this.O00000Oo = (Home) parcel.readParcelable(Home.class.getClassLoader());
        this.O00000o0 = parcel.readByte() != 0;
        this.O00000o = parcel.readString();
        this.O0000O0o = parcel.createStringArrayList();
    }

    public final void O000000o(HomeDeviceInfo homeDeviceInfo) {
        Home home;
        if (homeDeviceInfo != null && (home = homeDeviceInfo.O00000Oo) != null) {
            Home home2 = this.O00000Oo;
            if (home2 == null) {
                this.O00000Oo = home;
            } else {
                home2.merge(home);
            }
        }
    }
}

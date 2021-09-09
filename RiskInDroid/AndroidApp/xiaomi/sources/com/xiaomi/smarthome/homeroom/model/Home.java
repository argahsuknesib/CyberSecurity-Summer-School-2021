package com.xiaomi.smarthome.homeroom.model;

import _m_j.ghb;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public class Home implements Parcelable {
    public static final Parcelable.Creator<Home> CREATOR = new Parcelable.Creator<Home>() {
        /* class com.xiaomi.smarthome.homeroom.model.Home.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Home[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Home(parcel);
        }
    };
    public static int PERMIT_HOME_OWNER = 0;
    public static int PERMIT_HOME_SHARE = 1;
    private String addr;
    private String background;
    private String bssid;
    private String city_id;
    private String desc;
    private List<String> dids;
    private String icon;
    private String id;
    private String latitude;
    private String longitude;
    private String name;
    private long ownerUid;
    private List<Room> roomList;
    private int shareflag;
    private List<String> status;
    private final String statusFlag;

    public int describeContents() {
        return 0;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f8989O000000o = "";
        public String O00000Oo = "";
        public String O00000o = "";
        public String O00000o0 = "";
        public String O00000oO = "";
        public String O00000oo = "";
        public String O0000O0o = "";
        public int O0000OOo = 0;
        public List<Room> O0000Oo = new ArrayList();
        public List<String> O0000Oo0 = new ghb(new CopyOnWriteArrayList());
        public String O0000OoO = "0";
        public String O0000Ooo = "0";
        public String O0000o0 = "";
        public String O0000o00 = "0";
        public long O0000o0O;

        public final O000000o O000000o(List<String> list) {
            List<String> list2 = this.O0000Oo0;
            if (list2 != list) {
                list2.clear();
                this.O0000Oo0.addAll(list);
            }
            return this;
        }

        public final Home O000000o() {
            return new Home(this);
        }
    }

    private Home(O000000o o000000o) {
        this.latitude = "0";
        this.longitude = "0";
        this.city_id = "0";
        this.addr = "";
        this.ownerUid = 0;
        this.bssid = o000000o.f8989O000000o;
        this.desc = o000000o.O00000Oo;
        this.icon = o000000o.O00000o0;
        this.statusFlag = o000000o.O00000o;
        this.status = "1".equals(this.statusFlag) ? new ArrayList() : null;
        this.background = o000000o.O00000oO;
        this.id = o000000o.O00000oo;
        this.name = o000000o.O0000O0o;
        this.shareflag = o000000o.O0000OOo;
        this.dids = o000000o.O0000Oo0;
        this.roomList = o000000o.O0000Oo;
        this.city_id = o000000o.O0000o00;
        this.latitude = o000000o.O0000OoO;
        this.longitude = o000000o.O0000Ooo;
        this.addr = o000000o.O0000o0;
        this.ownerUid = o000000o.O0000o0O;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLocationId(String str) {
        this.city_id = str;
    }

    public void setAddr(String str) {
        this.addr = str;
    }

    public String getLocationId() {
        return this.city_id;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setStatus(List<String> list) {
        this.status = list;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public List<Room> getRoomList() {
        return this.roomList;
    }

    public void setRoomList(List<Room> list) {
        this.roomList = list;
    }

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public String getBssid() {
        return this.bssid;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public List<String> getDefDids() {
        return this.status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getRawName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getShareflag() {
        return this.shareflag;
    }

    public void setShareflag(int i) {
        this.shareflag = i;
    }

    public List<String> getDids() {
        List<String> list = this.status;
        if (list == null || list.size() == 0) {
            return this.dids;
        }
        if (this.dids == null) {
            return this.status;
        }
        ghb ghb = new ghb(new CopyOnWriteArrayList());
        ghb.addAll(this.dids);
        ghb.addAll(this.status);
        return ghb;
    }

    public List<String> getDidsExcludeStatus() {
        return this.dids;
    }

    public void setDids(List<String> list) {
        List<String> list2 = this.dids;
        if (list != list2) {
            list2.clear();
            this.dids.addAll(list);
        }
    }

    public long getOwnerUid() {
        return this.ownerUid;
    }

    public void setOwnerUid(long j) {
        this.ownerUid = j;
    }

    public boolean isOwner() {
        return this.shareflag == PERMIT_HOME_OWNER;
    }

    public static boolean isValidLatLng(String str) {
        return !TextUtils.isEmpty(str) && !TextUtils.equals(str, "0");
    }

    public static boolean isSameLocation(String str, String str2, String str3, String str4) {
        if (!isValidLatLng(str) || !isValidLatLng(str2) || !isValidLatLng(str3) || !isValidLatLng(str4)) {
            return false;
        }
        return Math.abs(Double.parseDouble(str) - Double.parseDouble(str3)) < 0.001d && Math.abs(Double.parseDouble(str2) - Double.parseDouble(str4)) < 0.001d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj != null && obj.getClass() == getClass()) {
            Home home = (Home) obj;
            if (home.getId() == null || (str = this.id) == null || !str.equalsIgnoreCase(home.getId())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("background", this.background);
            jSONObject.put("bssid", this.bssid);
            jSONObject.put("city_id", this.city_id);
            jSONObject.put("desc", this.desc);
            jSONObject.put("icon", this.icon);
            jSONObject.put("id", this.id);
            jSONObject.put("latitude", this.latitude);
            jSONObject.put("longitude", this.longitude);
            jSONObject.put("address", this.addr);
            jSONObject.put("name", this.name);
            jSONObject.put("shareflag", this.shareflag);
            jSONObject.put("uid", this.ownerUid);
            if (this.dids != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.dids.size(); i++) {
                    jSONArray.put(this.dids.get(i));
                }
                jSONObject.put("dids", jSONArray);
            }
            if (!TextUtils.isEmpty(this.statusFlag)) {
                jSONObject.put("status", this.statusFlag);
            }
            if (this.status != null && !this.status.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.status.size(); i2++) {
                    jSONArray2.put(this.status.get(i2));
                }
                jSONObject.put("status_list", jSONArray2);
            }
            if (this.roomList != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i3 = 0; i3 < this.roomList.size(); i3++) {
                    jSONArray3.put(this.roomList.get(i3).toJSON());
                }
                jSONObject.put("roomlist", jSONArray3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static Home parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONObject jSONObject2 = jSONObject;
        O000000o o000000o = new O000000o();
        if (jSONObject2 != null) {
            try {
                if (!jSONObject2.isNull("bssid")) {
                    o000000o.f8989O000000o = jSONObject2.optString("bssid");
                }
                if (!jSONObject2.isNull("desc")) {
                    o000000o.O00000Oo = jSONObject2.optString("desc");
                }
                if (!jSONObject2.isNull("id")) {
                    o000000o.O00000oo = jSONObject2.optString("id");
                }
                if (!jSONObject2.isNull("name")) {
                    o000000o.O0000O0o = jSONObject2.optString("name");
                }
                if (!jSONObject2.isNull("shareflag")) {
                    o000000o.O0000OOo = jSONObject2.optInt("shareflag");
                }
                if (!jSONObject2.isNull("uid")) {
                    o000000o.O0000o0O = jSONObject2.optLong("uid");
                }
                if (!jSONObject2.isNull("icon")) {
                    o000000o.O00000o0 = jSONObject2.optString("icon");
                }
                if (!jSONObject2.isNull("status")) {
                    o000000o.O00000o = jSONObject2.optString("status");
                }
                if (!jSONObject2.isNull("background")) {
                    o000000o.O00000oO = jSONObject2.optString("background");
                }
                if (!jSONObject2.isNull("latitude")) {
                    o000000o.O0000OoO = jSONObject2.optString("latitude");
                }
                if (!jSONObject2.isNull("longitude")) {
                    o000000o.O0000Ooo = jSONObject2.optString("longitude");
                }
                if (!jSONObject2.isNull("city_id")) {
                    o000000o.O0000o00 = jSONObject2.optString("city_id");
                }
                if (!jSONObject2.isNull("status")) {
                    o000000o.O00000o = jSONObject2.optString("status");
                }
                if (!jSONObject2.isNull("dids") && (optJSONArray2 = jSONObject2.optJSONArray("dids")) != null) {
                    ghb ghb = new ghb(new CopyOnWriteArrayList());
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        if (!TextUtils.isEmpty(optJSONArray2.optString(i))) {
                            ghb.add(optJSONArray2.optString(i));
                        }
                    }
                    o000000o.O000000o(ghb);
                }
                if (!jSONObject2.isNull("roomlist")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("roomlist");
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        arrayList.add(Room.parse(optJSONArray3.optJSONObject(i2)));
                    }
                    o000000o.O0000Oo = arrayList;
                    arrayList.trimToSize();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Home O000000o2 = o000000o.O000000o();
        try {
            if (!jSONObject2.isNull("status_list") && (optJSONArray = jSONObject2.optJSONArray("status_list")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList2.add(optString);
                    }
                }
                O000000o2.status = arrayList2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return O000000o2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bssid);
        parcel.writeString(this.desc);
        parcel.writeString(this.icon);
        parcel.writeStringList(this.status);
        parcel.writeString(this.statusFlag);
        parcel.writeString(this.background);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.shareflag);
        parcel.writeStringList(this.dids);
        parcel.writeTypedList(this.roomList);
        parcel.writeString(this.latitude);
        parcel.writeString(this.longitude);
        parcel.writeString(this.city_id);
        parcel.writeLong(this.ownerUid);
    }

    protected Home(Parcel parcel) {
        this.latitude = "0";
        this.longitude = "0";
        this.city_id = "0";
        this.addr = "";
        this.ownerUid = 0;
        this.bssid = parcel.readString();
        this.desc = parcel.readString();
        this.icon = parcel.readString();
        this.status = parcel.createStringArrayList();
        this.statusFlag = parcel.readString();
        this.background = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.shareflag = parcel.readInt();
        this.dids = parcel.createStringArrayList();
        this.roomList = parcel.createTypedArrayList(Room.CREATOR);
        this.latitude = parcel.readString();
        this.longitude = parcel.readString();
        this.city_id = parcel.readString();
        this.ownerUid = parcel.readLong();
    }

    public void merge(Home home) {
        mergeDids(home);
    }

    private void mergeDids(Home home) {
        mergeDefaultDids(home);
        mergeRoomDids(home);
    }

    private void mergeDefaultDids(Home home) {
        if (home != null && home.getDids() != null && !home.getDids().isEmpty()) {
            List<String> list = this.dids;
            if (list == null) {
                this.dids = home.dids;
            } else {
                list.addAll(home.dids);
            }
        }
    }

    private void mergeRoomDids(Home home) {
        if (home != null && home.getRoomList() != null && !home.getRoomList().isEmpty()) {
            if (getRoomList() == null) {
                setRoomList(home.getRoomList());
                return;
            }
            List<Room> roomList2 = home.getRoomList();
            List<Room> roomList3 = getRoomList();
            for (int i = 0; i < roomList2.size(); i++) {
                Room room = roomList2.get(i);
                if (room != null) {
                    int indexOf = roomList3.indexOf(room);
                    if (indexOf == -1) {
                        roomList3.add(room);
                    } else {
                        roomList3.get(indexOf).merge(room);
                    }
                }
            }
        }
    }

    public List<String> getAllDids() {
        ArrayList arrayList = new ArrayList();
        List<String> list = this.dids;
        if (list != null) {
            arrayList.addAll(list);
        }
        for (int i = 0; i < this.roomList.size(); i++) {
            Room room = this.roomList.get(i);
            if (!(room == null || room.getDids() == null)) {
                arrayList.addAll(room.getDids());
            }
        }
        return arrayList;
    }
}

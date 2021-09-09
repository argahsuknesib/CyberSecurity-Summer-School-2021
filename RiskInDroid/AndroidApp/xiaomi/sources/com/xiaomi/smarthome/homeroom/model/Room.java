package com.xiaomi.smarthome.homeroom.model;

import _m_j.ghb;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public class Room implements Parcelable {
    public static final Parcelable.Creator<Room> CREATOR = new Parcelable.Creator<Room>() {
        /* class com.xiaomi.smarthome.homeroom.model.Room.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Room[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Room(parcel);
        }
    };
    private String background;
    private String bssid;
    private String createTime = "";
    private String desc;
    private volatile List<String> dids;
    private String icon;
    private String id;
    private String name;
    private String parentid;
    private int shareflag;

    public int describeContents() {
        return 0;
    }

    public Room() {
    }

    public Room(String str) {
        this.name = str;
    }

    public void copyFrom(Room room) {
        this.bssid = room.bssid;
        this.desc = room.desc;
        this.name = room.name;
        this.parentid = room.parentid;
        this.shareflag = room.shareflag;
        this.dids = room.dids;
        this.icon = room.icon;
        this.createTime = room.createTime;
        this.background = room.background;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
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

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getParentid() {
        return this.parentid;
    }

    public void setParentid(String str) {
        this.parentid = str;
    }

    public int getShareflag() {
        return this.shareflag;
    }

    public void setShareflag(int i) {
        this.shareflag = i;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public List<String> getDids() {
        if (this.dids == null) {
            this.dids = new ghb(new CopyOnWriteArrayList());
        }
        return this.dids;
    }

    public void setDids(List<String> list) {
        if (this.dids == null) {
            this.dids = new ghb(new CopyOnWriteArrayList());
        }
        if (this.dids != list) {
            this.dids.clear();
            this.dids.addAll(list);
        }
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bssid", this.bssid);
            jSONObject.put("desc", this.desc);
            jSONObject.put("id", this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("parentid", this.parentid);
            jSONObject.put("shareflag", this.shareflag);
            jSONObject.put("icon", this.icon);
            jSONObject.put("create_time", this.createTime);
            jSONObject.put("background", this.background);
            if (this.dids != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.dids.size(); i++) {
                    jSONArray.put(this.dids.get(i));
                }
                jSONObject.put("dids", jSONArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static Room parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Room room = new Room();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("bssid")) {
                    room.bssid = jSONObject.optString("bssid");
                }
                if (!jSONObject.isNull("desc")) {
                    room.desc = jSONObject.optString("desc");
                }
                if (!jSONObject.isNull("id")) {
                    room.id = jSONObject.optString("id");
                }
                if (!jSONObject.isNull("name")) {
                    room.name = jSONObject.optString("name");
                }
                if (!jSONObject.isNull("parentid")) {
                    room.parentid = jSONObject.optString("parentid");
                }
                if (!jSONObject.isNull("shareflag")) {
                    room.shareflag = jSONObject.optInt("shareflag");
                }
                if (!jSONObject.isNull("create_time")) {
                    room.createTime = jSONObject.optString("create_time");
                }
                if (!jSONObject.isNull("icon")) {
                    room.icon = jSONObject.optString("icon");
                }
                if (!jSONObject.isNull("background")) {
                    room.background = jSONObject.optString("background");
                }
                if (!jSONObject.isNull("dids") && (optJSONArray = jSONObject.optJSONArray("dids")) != null) {
                    room.dids = new ghb(new CopyOnWriteArrayList());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                            room.dids.add(optJSONArray.optString(i));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return room;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj != null && obj.getClass() == getClass()) {
            Room room = (Room) obj;
            if (room.getId() == null || (str = this.id) == null || !str.equalsIgnoreCase(room.getId())) {
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

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bssid);
        parcel.writeString(this.desc);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.parentid);
        parcel.writeInt(this.shareflag);
        parcel.writeStringList(this.dids);
        parcel.writeString(this.icon);
        parcel.writeString(this.createTime);
        parcel.writeString(this.background);
    }

    protected Room(Parcel parcel) {
        this.bssid = parcel.readString();
        this.desc = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.parentid = parcel.readString();
        this.shareflag = parcel.readInt();
        this.dids = parcel.createStringArrayList();
        this.icon = parcel.readString();
        this.createTime = parcel.readString();
        this.background = parcel.readString();
    }

    public void merge(Room room) {
        mergeDids(room);
    }

    private void mergeDids(Room room) {
        if (room != null && room.dids != null && !room.dids.isEmpty()) {
            if (this.dids == null) {
                this.dids = room.dids;
            } else {
                this.dids.addAll(room.dids);
            }
        }
    }
}

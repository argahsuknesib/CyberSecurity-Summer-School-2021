package com.xiaomi.smarthome.mibrain.roomsetting.model;

import _m_j.goy;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class XiaoAiRoomItem implements Parcelable {
    public static final Parcelable.Creator<XiaoAiRoomItem> CREATOR = new Parcelable.Creator<XiaoAiRoomItem>() {
        /* class com.xiaomi.smarthome.mibrain.roomsetting.model.XiaoAiRoomItem.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XiaoAiRoomItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new XiaoAiRoomItem(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9512O000000o;
    public String O00000Oo;
    public List<ControllableDevice> O00000o;
    public boolean O00000o0;

    public int describeContents() {
        return 0;
    }

    public XiaoAiRoomItem() {
    }

    public final boolean O000000o(XiaoAiVoiceCategory xiaoAiVoiceCategory) {
        List<ControllableDevice> list;
        if (xiaoAiVoiceCategory == null || (list = this.O00000o) == null || list.isEmpty() || !goy.O000000o(xiaoAiVoiceCategory.O00000o, this.O00000o)) {
            return true;
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9512O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0 ? 1 : 0);
        parcel.writeTypedList(this.O00000o);
    }

    protected XiaoAiRoomItem(Parcel parcel) {
        this.f9512O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt() != 1 ? false : true;
        this.O00000o = parcel.createTypedArrayList(ControllableDevice.CREATOR);
    }

    public static XiaoAiRoomItem O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        XiaoAiRoomItem xiaoAiRoomItem = new XiaoAiRoomItem();
        xiaoAiRoomItem.f9512O000000o = jSONObject.optString("room_id");
        xiaoAiRoomItem.O00000Oo = jSONObject.optString("intent");
        xiaoAiRoomItem.O00000o0 = jSONObject.optBoolean("use_default");
        JSONArray optJSONArray = jSONObject.optJSONArray("device_list");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                ControllableDevice O000000o2 = ControllableDevice.O000000o(optJSONArray.optJSONObject(i));
                if (O000000o2 != null) {
                    arrayList.add(O000000o2);
                }
            }
            xiaoAiRoomItem.O00000o = arrayList;
        }
        return xiaoAiRoomItem;
    }
}

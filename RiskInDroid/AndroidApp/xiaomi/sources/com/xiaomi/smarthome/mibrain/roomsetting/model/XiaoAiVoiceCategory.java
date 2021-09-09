package com.xiaomi.smarthome.mibrain.roomsetting.model;

import _m_j.fno;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class XiaoAiVoiceCategory implements Parcelable {
    public static final Parcelable.Creator<XiaoAiVoiceCategory> CREATOR = new Parcelable.Creator<XiaoAiVoiceCategory>() {
        /* class com.xiaomi.smarthome.mibrain.roomsetting.model.XiaoAiVoiceCategory.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XiaoAiVoiceCategory[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new XiaoAiVoiceCategory(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f9513O000000o;
    public int O00000Oo;
    public List<ControllableDevice> O00000o;
    public List<String> O00000o0;

    public int describeContents() {
        return 0;
    }

    public XiaoAiVoiceCategory() {
    }

    public static XiaoAiVoiceCategory O000000o(JSONObject jSONObject) {
        ControllableDevice O000000o2;
        if (jSONObject == null) {
            return null;
        }
        XiaoAiVoiceCategory xiaoAiVoiceCategory = new XiaoAiVoiceCategory();
        xiaoAiVoiceCategory.O00000Oo = jSONObject.optInt("option");
        xiaoAiVoiceCategory.f9513O000000o = jSONObject.optString("intent");
        JSONArray optJSONArray = jSONObject.optJSONArray("desc");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            xiaoAiVoiceCategory.O00000o0 = arrayList;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("devices");
        if (optJSONArray2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                if (!(optJSONObject == null || (O000000o2 = ControllableDevice.O000000o(optJSONObject)) == null || fno.O000000o().O000000o(O000000o2.f9511O000000o) == null)) {
                    arrayList2.add(O000000o2);
                }
            }
            xiaoAiVoiceCategory.O00000o = arrayList2;
        }
        return xiaoAiVoiceCategory;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9513O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeStringList(this.O00000o0);
        parcel.writeTypedList(this.O00000o);
    }

    protected XiaoAiVoiceCategory(Parcel parcel) {
        this.f9513O000000o = parcel.readString();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.createStringArrayList();
        this.O00000o = parcel.createTypedArrayList(ControllableDevice.CREATOR);
    }
}

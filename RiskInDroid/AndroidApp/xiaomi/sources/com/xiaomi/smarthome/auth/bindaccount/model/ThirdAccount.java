package com.xiaomi.smarthome.auth.bindaccount.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThirdAccount implements Parcelable {
    public static final Parcelable.Creator<ThirdAccount> CREATOR = new Parcelable.Creator<ThirdAccount>() {
        /* class com.xiaomi.smarthome.auth.bindaccount.model.ThirdAccount.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ThirdAccount[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ThirdAccount(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4322O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public List<Device> O00000oO = new ArrayList();
    public int O00000oo = -1;

    public int describeContents() {
        return 0;
    }

    public static ThirdAccount O000000o(JSONObject jSONObject) {
        ThirdAccount thirdAccount = new ThirdAccount();
        if (jSONObject == null) {
            return thirdAccount;
        }
        try {
            if (!jSONObject.isNull("group_id")) {
                thirdAccount.O00000Oo = jSONObject.optString("group_id");
            }
            if (!jSONObject.isNull("name")) {
                thirdAccount.f4322O000000o = jSONObject.optString("name");
            }
            if (!jSONObject.isNull("icon_url")) {
                thirdAccount.O00000o0 = jSONObject.optString("icon_url");
            }
            if (!jSONObject.isNull("intro")) {
                thirdAccount.O00000o = jSONObject.optString("intro");
            }
            if (!jSONObject.isNull("bind_status")) {
                thirdAccount.O00000oo = jSONObject.optInt("bind_status", -1);
            }
            if (!jSONObject.isNull("dev_list")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("dev_list");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Device device = new Device();
                    device.did = optJSONObject.optString("did");
                    device.name = optJSONObject.optString("name");
                    device.model = optJSONObject.optString("model");
                    if (device.propInfo == null) {
                        device.propInfo = new JSONObject();
                    }
                    device.propInfo.put("third_cloud_device_icon", optJSONObject.opt("icon_url"));
                    arrayList.add(device);
                }
                thirdAccount.O00000oO = arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thirdAccount;
    }

    public final String O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("group_id", this.O00000Oo);
            jSONObject.put("name", this.f4322O000000o);
            jSONObject.put("icon_url", this.O00000o0);
            jSONObject.put("intro", this.O00000o);
            jSONObject.put("bind_status", this.O00000oo);
            List<Device> list = this.O00000oO;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    Device device = list.get(i);
                    if (device != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("did", device.did);
                        jSONObject2.put("name", device.name);
                        jSONObject2.put("model", device.model);
                        if (device.propInfo != null) {
                            jSONObject2.put("icon_url", device.propInfo.opt("third_cloud_device_icon"));
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("dev_list", jSONArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private ThirdAccount() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4322O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeInt(this.O00000oo);
    }

    protected ThirdAccount(Parcel parcel) {
        this.f4322O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oo = parcel.readInt();
    }
}

package com.xiaomi.smarthome.scene.model;

import _m_j.fno;
import _m_j.ggb;
import _m_j.gwq;
import _m_j.hnt;
import _m_j.hot;
import _m_j.hpu;
import _m_j.hqa;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendSceneDetailInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendSceneDetailInfo> CREATOR = new Parcelable.Creator<RecommendSceneDetailInfo>() {
        /* class com.xiaomi.smarthome.scene.model.RecommendSceneDetailInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecommendSceneDetailInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RecommendSceneDetailInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O00000Oo> f11162O000000o;
    public List<O000000o> O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public SceneApi.O000000o f11164O000000o;
        public List<Device> O00000Oo = new ArrayList();
        public HashMap<String, Boolean> O00000o = new HashMap<>();
        public JSONArray O00000o0 = new JSONArray();
        public JSONObject O00000oO = new JSONObject();
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public String O0000Oo0;

        public O00000Oo() {
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public SceneApi.Action f11163O000000o;
        public List<Device> O00000Oo = new ArrayList();
        public HashMap<String, Boolean> O00000o = new HashMap<>();
        public JSONArray O00000o0 = new JSONArray();
        public JSONObject O00000oO = new JSONObject();
        public int O00000oo;
        public String O0000O0o;
        public String O0000OOo;

        public O000000o() {
        }
    }

    public final void O000000o(hqa.O00000Oo o00000Oo) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (o00000Oo != null) {
            this.O00000o0 = o00000Oo.O0000OOo;
            this.O00000o = o00000Oo.O0000O0o;
            this.O0000O0o = o00000Oo.O00000o;
            this.O0000OOo = o00000Oo.O00000oO;
            this.O0000Oo0 = o00000Oo.O00000o0;
            this.O00000oO = o00000Oo.f517O000000o;
            this.O00000oo = o00000Oo.O00000Oo;
            try {
                List<hqa.O000000o> list = o00000Oo.O0000Oo0;
                this.f11162O000000o.clear();
                for (int i = 0; i < list.size(); i++) {
                    hqa.O000000o o000000o = list.get(i);
                    O00000Oo o00000Oo2 = new O00000Oo();
                    o00000Oo2.O00000o0 = o000000o.O00000o0;
                    o00000Oo2.O00000oO = o000000o.f516O000000o;
                    o00000Oo2.O00000oo = o000000o.O00000o;
                    o00000Oo2.O0000O0o = o000000o.O00000oO;
                    o00000Oo2.O0000OOo = o000000o.O00000Oo;
                    if (o00000Oo2.O00000oo.equalsIgnoreCase("device")) {
                        JSONObject jSONObject = o000000o.f516O000000o;
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            List<Device> O0000Ooo = fno.O000000o().O0000Ooo(keys.next());
                            if (O0000Ooo != null) {
                                o00000Oo2.O00000Oo.addAll(O0000Ooo);
                            }
                        }
                        if (o00000Oo2.O00000Oo.size() > 0) {
                            o00000Oo2.f11164O000000o = O00000Oo(o00000Oo2.O00000Oo.get(0).model, jSONObject.getString(o00000Oo2.O00000Oo.get(0).model));
                            if (!(hpu.O000000o().O00000Oo.O00000Oo == null || (optJSONObject2 = hpu.O000000o().O00000Oo.O00000Oo.optJSONObject(jSONObject.getString(o00000Oo2.O00000Oo.get(0).model))) == null)) {
                                o00000Oo2.O0000Oo0 = optJSONObject2.optString("fw_version", "");
                            }
                        } else {
                            Iterator<String> keys2 = jSONObject.keys();
                            if (keys2.hasNext()) {
                                String next = keys2.next();
                                o00000Oo2.f11164O000000o = O00000Oo(next, jSONObject.getString(next));
                            }
                        }
                    } else if (o00000Oo2.O00000oo.equalsIgnoreCase("user")) {
                        if (o000000o.O00000oO.equalsIgnoreCase("click") || TextUtils.isEmpty(o000000o.O00000oO)) {
                            o00000Oo2.f11164O000000o = new hot().O000000o(0, null);
                        }
                    } else if (o000000o.O00000o.equalsIgnoreCase("cloud")) {
                        String optString = o000000o.f516O000000o.optString("virtual");
                        if (!TextUtils.isEmpty(optString)) {
                            o00000Oo2.f11164O000000o = SceneApi.O000000o.O000000o(hpu.O000000o().O00000Oo.O00000Oo.optJSONObject(optString));
                            if (o00000Oo2.f11164O000000o.O0000OoO == null) {
                                o00000Oo2.f11164O000000o.O0000OoO = new SceneApi.O0000o00();
                            }
                            o00000Oo2.f11164O000000o.O0000OoO.O00000oO = gwq.O000000o().O00000o().O000000o();
                            o00000Oo2.f11164O000000o.O0000OoO.O00000oo = gwq.O000000o().O00000o().O00000o();
                            SceneApi.O0000o00 o0000o00 = o00000Oo2.f11164O000000o.O0000OoO;
                            o0000o00.O0000O0o = gwq.O000000o().O00000o().O00000o() + o00000Oo2.f11164O000000o.O0000OoO.O00000Oo;
                        }
                    } else {
                        if (o000000o.O00000o.equalsIgnoreCase("timer")) {
                            String optString2 = o000000o.f516O000000o.optString("virtual");
                            if (!TextUtils.isEmpty(optString2)) {
                                o00000Oo2.f11164O000000o = SceneApi.O000000o.O000000o(hpu.O000000o().O00000Oo.O00000Oo.optJSONObject(optString2));
                            }
                        }
                    }
                    this.f11162O000000o.add(o00000Oo2);
                }
                List<hqa.O000000o> list2 = o00000Oo.O0000Oo;
                this.O00000Oo.clear();
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    hqa.O000000o o000000o2 = list2.get(i2);
                    O000000o o000000o3 = new O000000o();
                    o000000o3.O00000oO = o000000o2.f516O000000o;
                    o000000o3.O00000o0 = o000000o2.O00000o0;
                    o000000o3.O00000oo = o000000o2.O00000oo;
                    o000000o3.O0000O0o = o000000o2.O00000Oo;
                    if (o000000o3.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                        JSONObject jSONObject2 = o000000o2.f516O000000o;
                        Iterator<String> keys3 = jSONObject2.keys();
                        while (keys3.hasNext()) {
                            List<Device> O0000Ooo2 = fno.O000000o().O0000Ooo(keys3.next());
                            if (O0000Ooo2 != null) {
                                o000000o3.O00000Oo.addAll(O0000Ooo2);
                            }
                        }
                        if (o000000o3.O00000Oo.size() > 0) {
                            o000000o3.f11163O000000o = O000000o(o000000o3.O00000Oo.get(0).model, jSONObject2.getString(o000000o3.O00000Oo.get(0).model));
                            if (!(hpu.O000000o().O00000Oo.f515O000000o == null || (optJSONObject = hpu.O000000o().O00000Oo.f515O000000o.optJSONObject(jSONObject2.getString(o000000o3.O00000Oo.get(0).model))) == null)) {
                                o000000o3.O0000OOo = optJSONObject.optString("fw_version", "");
                            }
                        } else {
                            Iterator<String> keys4 = jSONObject2.keys();
                            if (keys4.hasNext()) {
                                String next2 = keys4.next();
                                o000000o3.f11163O000000o = O000000o(next2, jSONObject2.getString(next2));
                            }
                        }
                    } else if (o000000o3.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_PUSH.value) {
                        o000000o3.f11163O000000o = new hnt().O000000o("", 0, null, null);
                        ((SceneApi.O000OO) o000000o3.f11163O000000o.O0000O0o).O00000Oo = this.O00000oo;
                    }
                    this.O00000Oo.add(o000000o3);
                }
                O000000o();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o() {
        Room O0000o00;
        Room O0000o002;
        int i = this.O0000Oo0;
        if (i == 30) {
            for (int i2 = 0; i2 < this.O00000Oo.size(); i2++) {
                O000000o o000000o = this.O00000Oo.get(i2);
                if (o000000o.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                    for (int i3 = 0; i3 < o000000o.O00000Oo.size(); i3++) {
                        Device device = o000000o.O00000Oo.get(i3);
                        if (device != null && fno.O000000o().O0000Oo(device.did)) {
                            hpu.O000000o();
                            String str = o000000o.O0000OOo;
                            hpu.O000000o();
                            if (hpu.O000000o(str, hpu.O000000o(device))) {
                                o000000o.O00000o.put(device.did, Boolean.TRUE);
                            }
                        }
                        o000000o.O00000o.put(device.did, Boolean.FALSE);
                    }
                }
            }
        } else if (i == 15) {
            Room room = null;
            for (int i4 = 0; i4 < this.f11162O000000o.size(); i4++) {
                O00000Oo o00000Oo = this.f11162O000000o.get(i4);
                if (o00000Oo.O00000oo.equalsIgnoreCase("device")) {
                    Room room2 = room;
                    for (int i5 = 0; i5 < o00000Oo.O00000Oo.size(); i5++) {
                        Device device2 = o00000Oo.O00000Oo.get(i5);
                        hpu.O000000o();
                        String str2 = o00000Oo.O0000Oo0;
                        hpu.O000000o();
                        if (hpu.O000000o(str2, hpu.O000000o(device2)) && (O0000o00 = ggb.O00000Oo().O0000o00(device2.did)) != null) {
                            Room room3 = null;
                            int i6 = 0;
                            for (int i7 = 0; i7 < this.O00000Oo.size(); i7++) {
                                O000000o o000000o2 = this.O00000Oo.get(i7);
                                if (o000000o2.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                                    int i8 = 0;
                                    while (true) {
                                        if (i8 >= o000000o2.O00000Oo.size()) {
                                            break;
                                        }
                                        Device device3 = o000000o2.O00000Oo.get(i8);
                                        hpu.O000000o();
                                        String str3 = o000000o2.O0000OOo;
                                        hpu.O000000o();
                                        if (hpu.O000000o(str3, hpu.O000000o(device3)) && (O0000o002 = ggb.O00000Oo().O0000o00(device3.did)) != null && O0000o00 != null && O0000o00.getId().equalsIgnoreCase(O0000o002.getId())) {
                                            i6++;
                                            room3 = O0000o002;
                                            break;
                                        }
                                        i8++;
                                    }
                                }
                            }
                            if (i6 != this.O00000Oo.size()) {
                                room3 = null;
                            }
                            room2 = room3;
                        }
                    }
                    room = room2;
                }
            }
            if (room == null) {
                for (int i9 = 0; i9 < this.f11162O000000o.size(); i9++) {
                    O00000Oo o00000Oo2 = this.f11162O000000o.get(i9);
                    if (o00000Oo2.O00000oo.equalsIgnoreCase("device")) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= o00000Oo2.O00000Oo.size()) {
                                break;
                            }
                            Device device4 = o00000Oo2.O00000Oo.get(i10);
                            if (device4 != null && fno.O000000o().O0000Oo(device4.did)) {
                                hpu.O000000o();
                                String str4 = o00000Oo2.O0000Oo0;
                                hpu.O000000o();
                                if (hpu.O000000o(str4, hpu.O000000o(device4))) {
                                    o00000Oo2.O00000o.put(device4.did, Boolean.TRUE);
                                    break;
                                }
                            }
                            o00000Oo2.O00000o.put(device4.did, Boolean.FALSE);
                            i10++;
                        }
                    }
                }
                for (int i11 = 0; i11 < this.O00000Oo.size(); i11++) {
                    O000000o o000000o3 = this.O00000Oo.get(i11);
                    if (o000000o3.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                        int i12 = 0;
                        while (true) {
                            if (i12 >= o000000o3.O00000Oo.size()) {
                                break;
                            }
                            Device device5 = o000000o3.O00000Oo.get(i12);
                            if (device5 != null && fno.O000000o().O0000Oo(device5.did)) {
                                hpu.O000000o();
                                String str5 = o000000o3.O0000OOo;
                                hpu.O000000o();
                                if (hpu.O000000o(str5, hpu.O000000o(device5))) {
                                    o000000o3.O00000o.put(device5.did, Boolean.TRUE);
                                    break;
                                }
                            }
                            o000000o3.O00000o.put(device5.did, Boolean.FALSE);
                            i12++;
                        }
                    }
                }
                return;
            }
            for (int i13 = 0; i13 < this.f11162O000000o.size(); i13++) {
                O00000Oo o00000Oo3 = this.f11162O000000o.get(i13);
                if (o00000Oo3.O00000oo.equalsIgnoreCase("device")) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= o00000Oo3.O00000Oo.size()) {
                            break;
                        }
                        Device device6 = o00000Oo3.O00000Oo.get(i14);
                        Room O0000o003 = ggb.O00000Oo().O0000o00(device6.did);
                        if (device6 != null && fno.O000000o().O0000Oo(device6.did) && O0000o003 != null && O0000o003.getId().equalsIgnoreCase(room.getId())) {
                            hpu.O000000o();
                            String str6 = o00000Oo3.O0000Oo0;
                            hpu.O000000o();
                            if (hpu.O000000o(str6, hpu.O000000o(device6))) {
                                o00000Oo3.O00000o.put(device6.did, Boolean.TRUE);
                                break;
                            }
                        }
                        o00000Oo3.O00000o.put(device6.did, Boolean.FALSE);
                        i14++;
                    }
                }
            }
            for (int i15 = 0; i15 < this.O00000Oo.size(); i15++) {
                O000000o o000000o4 = this.O00000Oo.get(i15);
                if (o000000o4.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                    int i16 = 0;
                    while (true) {
                        if (i16 >= o000000o4.O00000Oo.size()) {
                            break;
                        }
                        Device device7 = o000000o4.O00000Oo.get(i16);
                        Room O0000o004 = ggb.O00000Oo().O0000o00(device7.did);
                        if (device7 != null && fno.O000000o().O0000Oo(device7.did) && O0000o004 != null && O0000o004.getId().equalsIgnoreCase(room.getId())) {
                            hpu.O000000o();
                            String str7 = o000000o4.O0000OOo;
                            hpu.O000000o();
                            if (hpu.O000000o(str7, hpu.O000000o(device7))) {
                                o000000o4.O00000o.put(device7.did, Boolean.TRUE);
                                break;
                            }
                        }
                        o000000o4.O00000o.put(device7.did, Boolean.FALSE);
                        i16++;
                    }
                }
            }
        }
    }

    public static SceneApi.Action O000000o(String str, String str2) {
        try {
            if (hpu.O000000o().O00000Oo != null) {
                if (hpu.O000000o().O00000Oo.f515O000000o != null) {
                    JSONObject optJSONObject = hpu.O000000o().O00000Oo.f515O000000o.optJSONObject(str2);
                    if (optJSONObject == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(optJSONObject.toString());
                    jSONObject.put("model", str);
                    try {
                        return SceneApi.Action.O000000o(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
            return new SceneApi.Action();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static SceneApi.O000000o O00000Oo(String str, String str2) {
        try {
            if (hpu.O000000o().O00000Oo != null) {
                if (hpu.O000000o().O00000Oo.O00000Oo != null) {
                    JSONObject jSONObject = new JSONObject(hpu.O000000o().O00000Oo.O00000Oo.optJSONObject(str2).toString());
                    jSONObject.put("key", String.format(jSONObject.optString("key"), str));
                    jSONObject.put("model", str);
                    return SceneApi.O000000o.O000000o(jSONObject);
                }
            }
            return new SceneApi.O000000o();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f11162O000000o);
        parcel.writeList(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
    }

    public RecommendSceneDetailInfo() {
        this.f11162O000000o = new ArrayList();
        this.O00000Oo = new ArrayList();
    }

    protected RecommendSceneDetailInfo(Parcel parcel) {
        this.f11162O000000o = new ArrayList();
        this.O00000Oo = new ArrayList();
        this.f11162O000000o = new ArrayList();
        parcel.readList(this.f11162O000000o, O00000Oo.class.getClassLoader());
        this.O00000Oo = new ArrayList();
        parcel.readList(this.O00000Oo, O000000o.class.getClassLoader());
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
    }

    public final boolean O00000Oo() {
        int i = this.O0000Oo0;
        if (i == 30) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.O00000Oo.size(); i3++) {
                O000000o o000000o = this.O00000Oo.get(i3);
                if (o000000o.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                    int i4 = i2;
                    for (int i5 = 0; i5 < o000000o.O00000Oo.size(); i5++) {
                        hpu.O000000o();
                        String str = o000000o.O0000OOo;
                        hpu.O000000o();
                        if (hpu.O000000o(str, hpu.O000000o(o000000o.O00000Oo.get(i5)))) {
                            i4++;
                        }
                    }
                    i2 = i4;
                } else {
                    i2++;
                }
            }
            return i2 >= 2;
        } else if (i != 15) {
            return false;
        } else {
            for (int i6 = 0; i6 < this.f11162O000000o.size(); i6++) {
                O00000Oo o00000Oo = this.f11162O000000o.get(i6);
                if (o00000Oo.O00000oo.equalsIgnoreCase("device")) {
                    if (o00000Oo.O00000Oo.size() == 0) {
                        return false;
                    }
                    int i7 = 0;
                    for (int i8 = 0; i8 < o00000Oo.O00000Oo.size(); i8++) {
                        hpu.O000000o();
                        String str2 = o00000Oo.O0000Oo0;
                        hpu.O000000o();
                        if (hpu.O000000o(str2, hpu.O000000o(o00000Oo.O00000Oo.get(i8)))) {
                            i7++;
                        }
                    }
                    if (i7 == 0) {
                        return false;
                    }
                }
            }
            for (int i9 = 0; i9 < this.O00000Oo.size(); i9++) {
                O000000o o000000o2 = this.O00000Oo.get(i9);
                if (o000000o2.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                    if (o000000o2.O00000Oo.size() == 0) {
                        return false;
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < o000000o2.O00000Oo.size(); i11++) {
                        hpu.O000000o();
                        String str3 = o000000o2.O0000OOo;
                        hpu.O000000o();
                        if (hpu.O000000o(str3, hpu.O000000o(o000000o2.O00000Oo.get(i11)))) {
                            i10++;
                        }
                    }
                    if (i10 == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

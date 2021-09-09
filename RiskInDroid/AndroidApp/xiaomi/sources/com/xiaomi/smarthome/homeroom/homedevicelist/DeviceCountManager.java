package com.xiaomi.smarthome.homeroom.homedevicelist;

import _m_j.fno;
import _m_j.gge;
import _m_j.gsy;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceCountManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f8984O000000o = "DeviceCountManager";
    private static volatile DeviceCountManager O00000o;
    public volatile DeviceCountModel O00000Oo;
    public BehaviorSubject<Integer> O00000o0;

    private DeviceCountManager() {
    }

    public static DeviceCountManager O000000o() {
        if (O00000o == null) {
            synchronized (DeviceCountManager.class) {
                if (O00000o == null) {
                    O00000o = new DeviceCountManager();
                }
            }
        }
        return O00000o;
    }

    public final int O00000o0() {
        int O0000o = fno.O000000o().O0000o();
        DeviceCountModel deviceCountModel = this.O00000Oo;
        if (deviceCountModel == null) {
            gsy.O00000o0(LogType.DEVICE_LIST, f8984O000000o, "calculateDeviceCnt: mDeviceCountModel is null, count from getTotalOperatableDeviceCount=".concat(String.valueOf(O0000o)));
            return O0000o;
        }
        int i = deviceCountModel.f8986O000000o;
        List<Device> list = gge.O000000o().f17734O000000o;
        if (list != null && !list.isEmpty()) {
            i += list.size();
        }
        int O000000o2 = deviceCountModel.O000000o();
        LogType logType = LogType.DEVICE_LIST;
        String str = f8984O000000o;
        StringBuilder sb = new StringBuilder("nearby=");
        sb.append(list == null ? null : Integer.valueOf(list.size()));
        sb.append(",ownerCnt=");
        sb.append(i);
        sb.append(",sharedHomeCnt=");
        sb.append(O000000o2);
        sb.append(",model.getSharedCnt=");
        sb.append(deviceCountModel.O00000Oo);
        gsy.O00000o0(logType, str, sb.toString());
        return i + O000000o2 + deviceCountModel.O00000Oo;
    }

    public static class DeviceCountModel implements Parcelable {
        public static final Parcelable.Creator<DeviceCountModel> CREATOR = new Parcelable.Creator<DeviceCountModel>() {
            /* class com.xiaomi.smarthome.homeroom.homedevicelist.DeviceCountManager.DeviceCountModel.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeviceCountModel[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DeviceCountModel(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f8986O000000o;
        int O00000Oo;
        private int O00000o;
        private int O00000o0;
        private List<SharedHomeDeviceCountModel> O00000oO;

        public int describeContents() {
            return 0;
        }

        public static DeviceCountModel O000000o(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (jSONObject == null) {
                return null;
            }
            DeviceCountModel deviceCountModel = new DeviceCountModel();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("owned");
            if (optJSONObject2 != null) {
                deviceCountModel.O00000o0 = optJSONObject2.optInt("cd");
                deviceCountModel.f8986O000000o = optJSONObject2.optInt("nd");
            }
            if (jSONObject.isNull("share") || (optJSONObject = jSONObject.optJSONObject("share")) == null) {
                return deviceCountModel;
            }
            deviceCountModel.O00000Oo = optJSONObject.optInt("nd");
            deviceCountModel.O00000o = optJSONObject.optInt("cd");
            if (!(optJSONObject.isNull("share_family") || (optJSONArray = optJSONObject.optJSONArray("share_family")) == null || optJSONArray.length() == 0)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    SharedHomeDeviceCountModel O000000o2 = SharedHomeDeviceCountModel.O000000o(optJSONArray.optJSONObject(i));
                    if (O000000o2 != null) {
                        arrayList.add(O000000o2);
                    }
                }
                deviceCountModel.O00000oO = arrayList;
            }
            return deviceCountModel;
        }

        public static class SharedHomeDeviceCountModel implements Parcelable {
            public static final Parcelable.Creator<SharedHomeDeviceCountModel> CREATOR = new Parcelable.Creator<SharedHomeDeviceCountModel>() {
                /* class com.xiaomi.smarthome.homeroom.homedevicelist.DeviceCountManager.DeviceCountModel.SharedHomeDeviceCountModel.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SharedHomeDeviceCountModel[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new SharedHomeDeviceCountModel(parcel);
                }
            };

            /* renamed from: O000000o  reason: collision with root package name */
            int f8987O000000o;
            private int O00000Oo;
            private long O00000o;
            private long O00000o0;

            public int describeContents() {
                return 0;
            }

            public static SharedHomeDeviceCountModel O000000o(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return null;
                }
                SharedHomeDeviceCountModel sharedHomeDeviceCountModel = new SharedHomeDeviceCountModel();
                sharedHomeDeviceCountModel.O00000Oo = jSONObject.optInt("cd");
                sharedHomeDeviceCountModel.f8987O000000o = jSONObject.optInt("nd");
                sharedHomeDeviceCountModel.O00000o = jSONObject.optLong("home_id");
                sharedHomeDeviceCountModel.O00000o0 = jSONObject.optLong("home_owner");
                return sharedHomeDeviceCountModel;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f8987O000000o);
                parcel.writeInt(this.O00000Oo);
                parcel.writeLong(this.O00000o0);
                parcel.writeLong(this.O00000o);
            }

            public SharedHomeDeviceCountModel() {
            }

            protected SharedHomeDeviceCountModel(Parcel parcel) {
                this.f8987O000000o = parcel.readInt();
                this.O00000Oo = parcel.readInt();
                this.O00000o0 = parcel.readLong();
                this.O00000o = parcel.readLong();
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f8986O000000o);
            parcel.writeInt(this.O00000o0);
            parcel.writeInt(this.O00000Oo);
            parcel.writeInt(this.O00000o);
            parcel.writeTypedList(this.O00000oO);
        }

        public DeviceCountModel() {
        }

        protected DeviceCountModel(Parcel parcel) {
            this.f8986O000000o = parcel.readInt();
            this.O00000o0 = parcel.readInt();
            this.O00000Oo = parcel.readInt();
            this.O00000o = parcel.readInt();
            this.O00000oO = parcel.createTypedArrayList(SharedHomeDeviceCountModel.CREATOR);
        }

        public final int O000000o() {
            List<SharedHomeDeviceCountModel> list = this.O00000oO;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                SharedHomeDeviceCountModel sharedHomeDeviceCountModel = list.get(i2);
                if (sharedHomeDeviceCountModel != null) {
                    i += sharedHomeDeviceCountModel.f8987O000000o;
                }
            }
            return i;
        }
    }

    public final void O00000Oo() {
        if (this.O00000o0 == null) {
            this.O00000o0 = BehaviorSubject.createDefault(Integer.valueOf(O00000o0()));
        }
        this.O00000o0.onNext(Integer.valueOf(O00000o0()));
    }
}

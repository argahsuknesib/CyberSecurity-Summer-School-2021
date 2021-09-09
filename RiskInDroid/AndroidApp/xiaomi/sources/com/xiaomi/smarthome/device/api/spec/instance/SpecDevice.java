package com.xiaomi.smarthome.device.api.spec.instance;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.xiaomi.smarthome.device.api.spec.operation.controller.ActionController;
import com.xiaomi.smarthome.device.api.spec.operation.controller.DeviceController;
import com.xiaomi.smarthome.device.api.spec.operation.controller.PropertyController;
import com.xiaomi.smarthome.device.api.spec.operation.controller.ServiceController;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SpecDevice extends Spec implements Parcelable {
    public static final Parcelable.Creator<SpecDevice> CREATOR = new Parcelable.Creator<SpecDevice>() {
        /* class com.xiaomi.smarthome.device.api.spec.instance.SpecDevice.AnonymousClass1 */

        public final SpecDevice createFromParcel(Parcel parcel) {
            return new SpecDevice(parcel);
        }

        public final SpecDevice[] newArray(int i) {
            return new SpecDevice[i];
        }
    };
    private final String classSpec;
    private final Map<Integer, SpecDevice> devices;
    private final byte dynamic;
    private final JSONObject mRef;
    private final Map<Integer, SpecService> services;
    private final String versionSpec;

    public int describeContents() {
        return 0;
    }

    public SpecDevice(String str, String str2) {
        this(str, str2, new LinkedHashMap(0, 0.75f, false));
    }

    public SpecDevice(String str, String str2, Map<Integer, SpecService> map) {
        this(0, str, null, str2, null, null, 0, map, null, null);
    }

    public SpecDevice(int i, String str, String str2, String str3, String str4, String str5, int i2, Map<Integer, SpecService> map, Map<Integer, SpecDevice> map2, JSONObject jSONObject) {
        super(i, str, str2, str3);
        this.services = map;
        this.versionSpec = str4;
        this.classSpec = str5;
        this.dynamic = (byte) i2;
        this.devices = map2;
        this.mRef = jSONObject;
        setParent(map);
        setParent(map2);
    }

    protected SpecDevice(Parcel parcel) {
        super(parcel);
        this.services = readMap(parcel);
        this.devices = readMap(parcel);
        this.versionSpec = parcel.readString();
        this.classSpec = parcel.readString();
        this.dynamic = parcel.readByte();
        String readString = parcel.readString();
        JSONObject jSONObject = null;
        if (readString == null) {
            this.mRef = jSONObject;
        } else {
            try {
                jSONObject = new JSONObject(readString);
            } catch (JSONException e) {
                Log.e("SpecDevice", "SpecDevice", e);
            } finally {
                this.mRef = jSONObject;
            }
        }
        setParent(this.services);
        setParent(this.devices);
    }

    private Map<Integer, ? extends Spec> readMap(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, false);
        for (int i = 0; i < readInt; i++) {
            Spec spec = (Spec) parcel.readParcelable(SpecDevice.class.getClassLoader());
            linkedHashMap.put(Integer.valueOf(spec.getIid()), spec);
        }
        return linkedHashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        writeMap(parcel, this.services);
        writeMap(parcel, this.devices);
        parcel.writeString(this.versionSpec);
        parcel.writeString(this.classSpec);
        parcel.writeByte(this.dynamic);
        JSONObject jSONObject = this.mRef;
        parcel.writeString(jSONObject == null ? null : jSONObject.toString());
    }

    private void writeMap(Parcel parcel, Map<Integer, ? extends Spec> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<Integer, ? extends Spec> value : map.entrySet()) {
            parcel.writeParcelable((Parcelable) value.getValue(), 0);
        }
    }

    public Map<Integer, SpecService> getServices() {
        return this.services;
    }

    public Map<Integer, SpecDevice> getDevices() {
        return this.devices;
    }

    public String getVersionSpec() {
        return this.versionSpec;
    }

    public String getClassSpec() {
        return this.classSpec;
    }

    public int getDynamic() {
        return this.dynamic;
    }

    public boolean isEmpty() {
        Map<Integer, SpecService> map = this.services;
        if (map != null && map.size() != 0) {
            return false;
        }
        Map<Integer, SpecDevice> map2 = this.devices;
        return map2 == null || map2.size() == 0;
    }

    public JSONObject getRefExtra() {
        return this.mRef;
    }

    public DeviceController createController(String str) {
        if (this.services == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, SpecService> value : this.services.entrySet()) {
            ArrayList arrayList2 = new ArrayList();
            SpecService specService = (SpecService) value.getValue();
            Map<Integer, SpecProperty> properties = specService.getProperties();
            if (properties != null) {
                for (Map.Entry<Integer, SpecProperty> value2 : properties.entrySet()) {
                    SpecProperty specProperty = (SpecProperty) value2.getValue();
                    arrayList2.add(new PropertyController(specProperty.getIid(), specProperty));
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Map<Integer, SpecAction> actions = specService.getActions();
            if (actions != null) {
                for (Map.Entry<Integer, SpecAction> value3 : actions.entrySet()) {
                    SpecAction specAction = (SpecAction) value3.getValue();
                    arrayList3.add(new ActionController(specAction.getIid(), specAction));
                }
            }
            arrayList.add(new ServiceController(specService.getIid(), specService.getType(), specService.getName(), specService.getDesc(), arrayList2, arrayList3));
        }
        return new DeviceController(str, getType(), getDescription(), arrayList);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("SpecDevice{type='");
        sb.append(getType());
        sb.append('\'');
        sb.append(", services=");
        Map<Integer, SpecService> map = this.services;
        if (map == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(map.size());
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}

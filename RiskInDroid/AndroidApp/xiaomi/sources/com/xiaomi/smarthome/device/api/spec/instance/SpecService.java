package com.xiaomi.smarthome.device.api.spec.instance;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpecService extends Spec implements Parcelable {
    public static final Parcelable.Creator<SpecService> CREATOR = new Parcelable.Creator<SpecService>() {
        /* class com.xiaomi.smarthome.device.api.spec.instance.SpecService.AnonymousClass1 */

        public final SpecService createFromParcel(Parcel parcel) {
            return new SpecService(parcel);
        }

        public final SpecService[] newArray(int i) {
            return new SpecService[i];
        }
    };
    private final Map<Integer, SpecAction> actions;
    private final Map<Integer, SpecEvent> events;
    private final Map<Integer, SpecProperty> properties;

    public int describeContents() {
        return 0;
    }

    public SpecService(int i, String str, String str2) {
        this(i, str, null, str2);
    }

    public SpecService(int i, String str, String str2, Map<Integer, SpecProperty> map, Map<Integer, SpecAction> map2, Map<Integer, SpecEvent> map3) {
        this(i, str, null, str2, map, map2, map3);
    }

    public SpecService(int i, String str, String str2, String str3) {
        super(i, str, str2, str3);
        this.properties = new LinkedHashMap(0, 0.75f, false);
        this.actions = new LinkedHashMap(0, 0.75f, false);
        this.events = new LinkedHashMap(0, 0.75f, false);
    }

    public SpecService(int i, String str, String str2, String str3, Map<Integer, SpecProperty> map, Map<Integer, SpecAction> map2, Map<Integer, SpecEvent> map3) {
        super(i, str, str2, str3);
        this.properties = map;
        this.actions = map2;
        this.events = map3;
        setParent(map);
        setParent(map2);
        setParent(map3);
    }

    protected SpecService(Parcel parcel) {
        super(parcel);
        ClassLoader classLoader = SpecService.class.getClassLoader();
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, false);
        parcel.readMap(linkedHashMap, classLoader);
        this.properties = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(0, 0.75f, false);
        parcel.readMap(linkedHashMap2, classLoader);
        this.actions = linkedHashMap2;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(0, 0.75f, false);
        parcel.readMap(linkedHashMap3, classLoader);
        this.events = linkedHashMap3;
        setParent(this.properties);
        setParent(this.actions);
        setParent(this.events);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeMap(this.properties);
        parcel.writeMap(this.actions);
        parcel.writeMap(this.events);
    }

    public Map<Integer, SpecProperty> getProperties() {
        return this.properties;
    }

    public Map<Integer, SpecAction> getActions() {
        return this.actions;
    }

    public Map<Integer, SpecEvent> getEvents() {
        return this.events;
    }

    public String getDesc() {
        return getDescription();
    }

    public void setDesc(String str) {
        setDescription(str);
    }
}

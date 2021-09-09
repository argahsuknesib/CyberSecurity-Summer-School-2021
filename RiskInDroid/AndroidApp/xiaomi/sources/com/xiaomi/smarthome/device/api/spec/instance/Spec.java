package com.xiaomi.smarthome.device.api.spec.instance;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.device.api.spec.definitions.SpecDefinition;
import java.util.Map;

public class Spec extends SpecDefinition implements Parcelable {
    public static final Parcelable.Creator<Spec> CREATOR = new Parcelable.Creator<Spec>() {
        /* class com.xiaomi.smarthome.device.api.spec.instance.Spec.AnonymousClass1 */

        public final Spec createFromParcel(Parcel parcel) {
            return new Spec(parcel);
        }

        public final Spec[] newArray(int i) {
            return new Spec[i];
        }
    };
    private int iid;
    private final String name;
    private Spec parent;

    public int describeContents() {
        return 0;
    }

    public Spec getDefinition() {
        return this;
    }

    protected Spec(int i, String str, String str2, String str3) {
        super(str, str3);
        this.iid = i;
        this.name = str2;
    }

    protected Spec(Parcel parcel) {
        super(parcel);
        this.iid = parcel.readInt();
        this.name = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.iid);
        parcel.writeString(this.name);
    }

    public int getIid() {
        return this.iid;
    }

    public void setIid(int i) {
        this.iid = i;
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public void setParent(Map<Integer, ? extends Spec> map) {
        if (map != null) {
            for (Map.Entry<Integer, ? extends Spec> value : map.entrySet()) {
                Spec spec = (Spec) value.getValue();
                if (spec != null) {
                    spec.parent = this;
                }
            }
        }
    }

    public Spec getParent() {
        return this.parent;
    }

    public static int getIid(Spec spec, int i) {
        Spec spec2 = spec;
        for (int i2 = 0; i2 < i; i2++) {
            if (spec2 == null) {
                return 0;
            }
            spec2 = spec2.getParent();
        }
        if (spec2 == null) {
            return 0;
        }
        return spec2.iid;
    }

    public static class SpecItem extends Spec {
        public SpecItem getDefinition() {
            return this;
        }

        protected SpecItem(int i, String str, String str2, String str3) {
            super(i, str, str2, str3);
        }

        protected SpecItem(Parcel parcel) {
            super(parcel);
        }
    }
}

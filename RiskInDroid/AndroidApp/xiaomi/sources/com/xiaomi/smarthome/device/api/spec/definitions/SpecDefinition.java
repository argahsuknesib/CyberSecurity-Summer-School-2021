package com.xiaomi.smarthome.device.api.spec.definitions;

import _m_j.gsy;
import android.os.Parcel;

public class SpecDefinition {
    private String description;
    private String extra;
    private String model;
    private String name;
    private String nameID;
    private String schema;
    private String urn;
    private String urnType;
    private String version;

    protected SpecDefinition(String str, String str2) {
        setType(str);
        this.description = str2;
    }

    public SpecDefinition(Parcel parcel) {
        this.urn = parcel.readString();
        this.schema = parcel.readString();
        this.urnType = parcel.readString();
        this.name = parcel.readString();
        this.nameID = parcel.readString();
        this.model = parcel.readString();
        this.version = parcel.readString();
        this.extra = parcel.readString();
        this.description = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.urn);
        parcel.writeString(this.schema);
        parcel.writeString(this.urnType);
        parcel.writeString(this.name);
        parcel.writeString(this.nameID);
        parcel.writeString(this.model);
        parcel.writeString(this.version);
        parcel.writeString(this.extra);
        parcel.writeString(this.description);
    }

    public String getType() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.urn);
        sb.append(":");
        sb.append(this.schema);
        sb.append(":");
        sb.append(this.urnType);
        if (this.name != null) {
            sb.append(":");
            sb.append(this.name);
        }
        if (this.nameID != null) {
            sb.append(":");
            sb.append(this.nameID);
        }
        if (this.model != null) {
            sb.append(":");
            sb.append(this.model);
        }
        if (this.version != null) {
            sb.append(":");
            sb.append(this.version);
        }
        String str = this.extra;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    private void appendNotNull(StringBuilder sb, String str) {
        if (str != null) {
            sb.append(":");
            sb.append(str);
        }
    }

    public void setType(String str) {
        try {
            String[] split = str.split(":");
            this.urn = split[0];
            this.schema = split[1];
            this.urnType = split[2];
            this.name = split[3];
            this.nameID = split[4];
            this.model = split[5];
            this.version = split[6];
            int length = split.length;
            if (length > 7) {
                StringBuilder sb = new StringBuilder();
                for (int i = 7; i < length; i++) {
                    sb.append(":");
                    sb.append(split[i]);
                }
                this.extra = sb.toString();
            }
        } catch (Exception unused) {
            gsy.O000000o(6, "Spec", "specUrn error:".concat(String.valueOf(str)));
        }
    }

    public String getTypeName() {
        return this.name;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String toString() {
        return "SpecDefinition{urn='" + getType() + '\'' + ", description='" + this.description + '\'' + '}';
    }
}

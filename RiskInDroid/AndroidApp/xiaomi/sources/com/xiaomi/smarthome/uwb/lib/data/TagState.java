package com.xiaomi.smarthome.uwb.lib.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.idm.uwb.proto.UwbData;
import com.xiaomi.smarthome.uwb.lib.auth.ByteUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TagState implements Parcelable {
    public static final Parcelable.Creator<TagState> CREATOR = new Parcelable.Creator<TagState>() {
        /* class com.xiaomi.smarthome.uwb.lib.data.TagState.AnonymousClass1 */

        public final TagState createFromParcel(Parcel parcel) {
            return new TagState(parcel);
        }

        public final TagState[] newArray(int i) {
            return new TagState[i];
        }
    };
    private int associationStatus;
    private int hid;
    private int idmSupport;
    private int milinkSupport;
    private int power;
    private int shutDown;
    private String tvAccountInfo;
    private int tvAuth;
    private int tvMode;
    private int tvScreenOff;
    private int usb = 0;

    public int describeContents() {
        return 0;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usb", this.usb);
            jSONObject.put("power", this.power);
            jSONObject.put("hid", this.hid);
            jSONObject.put("tvMode", this.tvMode);
            jSONObject.put("tvAccountInfo", this.tvAccountInfo);
            jSONObject.put("shutDown", this.shutDown);
            jSONObject.put("associationStatus", this.associationStatus);
            jSONObject.put("milinkSupport", this.milinkSupport);
            jSONObject.put("idmSupport", this.idmSupport);
            jSONObject.put("tvAuth", this.tvAuth);
            jSONObject.put("tvScreenOff", this.tvScreenOff);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static TagState parse(JSONObject jSONObject) {
        TagState tagState = new TagState();
        if (jSONObject == null) {
            return tagState;
        }
        tagState.setUsb(jSONObject.optInt("usb"));
        tagState.setPower(jSONObject.optInt("power"));
        tagState.setHid(jSONObject.optInt("hid"));
        tagState.setTvMode(jSONObject.optInt("tvMode"));
        tagState.setTvAccountInfo(jSONObject.optString("tvAccountInfo"));
        tagState.setShutDown(jSONObject.optInt("shutDown"));
        tagState.setAssociationStatus(jSONObject.optInt("associationStatus"));
        tagState.setMilinkSupport(jSONObject.optInt("milinkSupport"));
        tagState.setIdmSupport(jSONObject.optInt("idmSupport"));
        tagState.setTvAuth(jSONObject.optInt("tvAuth"));
        tagState.setTvScreenOff(jSONObject.optInt("tvScreenOff"));
        return tagState;
    }

    protected TagState(Parcel parcel) {
        this.usb = parcel.readInt();
        this.power = parcel.readInt();
        this.hid = parcel.readInt();
        this.tvMode = parcel.readInt();
        this.tvAccountInfo = parcel.readString();
        this.shutDown = parcel.readInt();
        this.associationStatus = parcel.readInt();
        this.milinkSupport = parcel.readInt();
        this.idmSupport = parcel.readInt();
        this.tvAuth = parcel.readInt();
        this.tvScreenOff = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.usb);
        parcel.writeInt(this.power);
        parcel.writeInt(this.hid);
        parcel.writeInt(this.tvMode);
        parcel.writeString(this.tvAccountInfo);
        parcel.writeInt(this.shutDown);
        parcel.writeInt(this.associationStatus);
        parcel.writeInt(this.milinkSupport);
        parcel.writeInt(this.idmSupport);
        parcel.writeInt(this.tvAuth);
        parcel.writeInt(this.tvScreenOff);
    }

    public static TagState parse(UwbData.TagState tagState) {
        if (tagState == null) {
            return null;
        }
        TagState tagState2 = new TagState();
        tagState2.setIdmSupport(tagState.getIdmSupport());
        tagState2.setTvAuth(tagState.getTvAuthorization());
        tagState2.setTvScreenOff(tagState.getTvScreenOff());
        tagState2.setHid(tagState.getHid());
        tagState2.setPower(tagState.getPower());
        if (tagState.getTvAccountInfo() != null) {
            tagState2.setTvAccountInfo(ByteUtils.byteToString(tagState.getTvAccountInfo().toByteArray()));
        }
        tagState2.setTvMode(tagState.getTvMode());
        tagState2.setUsb(tagState.getUsb());
        tagState2.setShutDown(tagState.getShutDown());
        tagState2.setAssociationStatus(tagState.getAssociationStatus());
        tagState2.setMilinkSupport(tagState.getMiLinkSupport());
        return tagState2;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int i) {
        this.power = i;
    }

    public int getUsb() {
        return this.usb;
    }

    public void setUsb(int i) {
        this.usb = i;
    }

    public int getHid() {
        return this.hid;
    }

    public void setHid(int i) {
        this.hid = i;
    }

    public int getTvMode() {
        return this.tvMode;
    }

    public void setTvMode(int i) {
        this.tvMode = i;
    }

    public String getTvAccountInfo() {
        if (TextUtils.equals("000000", this.tvAccountInfo)) {
            return "";
        }
        return this.tvAccountInfo;
    }

    public void setTvAccountInfo(String str) {
        this.tvAccountInfo = str;
    }

    public int getShutDown() {
        return this.shutDown;
    }

    public void setShutDown(int i) {
        this.shutDown = i;
    }

    public TagState() {
    }

    public int getAssociationStatus() {
        return this.associationStatus;
    }

    public void setAssociationStatus(int i) {
        this.associationStatus = i;
    }

    public int getMilinkSupport() {
        return this.milinkSupport;
    }

    public void setMilinkSupport(int i) {
        this.milinkSupport = i;
    }

    public int getIdmSupport() {
        return this.idmSupport;
    }

    public void setIdmSupport(int i) {
        this.idmSupport = i;
    }

    public int getTvAuth() {
        return this.tvAuth;
    }

    public void setTvAuth(int i) {
        this.tvAuth = i;
    }

    public int getTvScreenOff() {
        return this.tvScreenOff;
    }

    public void setTvScreenOff(int i) {
        this.tvScreenOff = i;
    }

    public String toString() {
        return "TagState{usb=" + this.usb + ", power=" + this.power + ", hid=" + this.hid + ", tvMode=" + this.tvMode + ", tvAccountInfo='" + this.tvAccountInfo + '\'' + ", shutDown=" + this.shutDown + ", associationStatus=" + this.associationStatus + ", milinkSupport=" + this.milinkSupport + ", idmSupport=" + this.idmSupport + ", tvAuth=" + this.tvAuth + ", tvScreenOff=" + this.tvScreenOff + '}';
    }
}

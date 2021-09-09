package com.xiaomi.smarthome.uwb.lib.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.idm.uwb.proto.UwbData;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceState implements Parcelable {
    public static final Parcelable.Creator<DeviceState> CREATOR = new Parcelable.Creator<DeviceState>() {
        /* class com.xiaomi.smarthome.uwb.lib.data.DeviceState.AnonymousClass1 */

        public final DeviceState createFromParcel(Parcel parcel) {
            return new DeviceState(parcel);
        }

        public final DeviceState[] newArray(int i) {
            return new DeviceState[i];
        }
    };
    private int auth;
    private int binding;
    private int idmSupport;
    private int milinkSupport;
    private int occupied;
    private int plazaMode;
    private int reset;
    private int tvScreenOff;

    public int describeContents() {
        return 0;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binding", this.binding);
            jSONObject.put("auth", this.auth);
            jSONObject.put("idmSupport", this.idmSupport);
            jSONObject.put("milinkSupport", this.milinkSupport);
            jSONObject.put("occupied", this.occupied);
            jSONObject.put("reset", this.reset);
            jSONObject.put("plazaMode", this.plazaMode);
            jSONObject.put("tvScreenOff", this.tvScreenOff);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static DeviceState parse(JSONObject jSONObject) {
        DeviceState deviceState = new DeviceState();
        if (jSONObject == null) {
            return deviceState;
        }
        deviceState.setBinding(jSONObject.optInt("binding"));
        deviceState.setAuth(jSONObject.optInt("auth"));
        deviceState.setIdmSupport(jSONObject.optInt("idmSupport"));
        deviceState.setMilinkSupport(jSONObject.optInt("milinkSupport"));
        deviceState.setOccupied(jSONObject.optInt("occupied"));
        deviceState.setReset(jSONObject.optInt("reset"));
        deviceState.setPlazaMode(jSONObject.optInt("plazaMode"));
        deviceState.setTvScreenOff(jSONObject.optInt("tvScreenOff"));
        return deviceState;
    }

    protected DeviceState(Parcel parcel) {
        this.binding = parcel.readInt();
        this.auth = parcel.readInt();
        this.idmSupport = parcel.readInt();
        this.milinkSupport = parcel.readInt();
        this.occupied = parcel.readInt();
        this.reset = parcel.readInt();
        this.plazaMode = parcel.readInt();
        this.tvScreenOff = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.binding);
        parcel.writeInt(this.auth);
        parcel.writeInt(this.idmSupport);
        parcel.writeInt(this.milinkSupport);
        parcel.writeInt(this.occupied);
        parcel.writeInt(this.reset);
        parcel.writeInt(this.plazaMode);
        parcel.writeInt(this.tvScreenOff);
    }

    public static DeviceState parse(UwbData.DeviceState deviceState) {
        if (deviceState == null) {
            return null;
        }
        DeviceState deviceState2 = new DeviceState();
        deviceState2.setBinding(deviceState.getBinding());
        deviceState2.setAuth(deviceState.getAuthorization());
        deviceState2.setIdmSupport(deviceState.getIdmSupport());
        deviceState2.setMilinkSupport(deviceState.getMiLinkSupport());
        deviceState2.setOccupied(deviceState.getOccupied());
        deviceState2.setReset(deviceState.getReset());
        deviceState2.setPlazaMode(deviceState.getTvPlazaMode());
        deviceState2.setTvScreenOff(deviceState.getTvScreenOff());
        return deviceState2;
    }

    public int getBinding() {
        return this.binding;
    }

    public void setBinding(int i) {
        this.binding = i;
    }

    public DeviceState() {
    }

    public int getAuth() {
        return this.auth;
    }

    public void setAuth(int i) {
        this.auth = i;
    }

    public int getIdmSupport() {
        return this.idmSupport;
    }

    public void setIdmSupport(int i) {
        this.idmSupport = i;
    }

    public int getMilinkSupport() {
        return this.milinkSupport;
    }

    public void setMilinkSupport(int i) {
        this.milinkSupport = i;
    }

    public int getOccupied() {
        return this.occupied;
    }

    public void setOccupied(int i) {
        this.occupied = i;
    }

    public int getReset() {
        return this.reset;
    }

    public void setReset(int i) {
        this.reset = i;
    }

    public int getPlazaMode() {
        return this.plazaMode;
    }

    public void setPlazaMode(int i) {
        this.plazaMode = i;
    }

    public int getTvScreenOff() {
        return this.tvScreenOff;
    }

    public void setTvScreenOff(int i) {
        this.tvScreenOff = i;
    }

    public String toString() {
        return "DeviceState{binding=" + this.binding + ", auth=" + this.auth + ", idmSupport=" + this.idmSupport + ", milinkSupport=" + this.milinkSupport + ", occupied=" + this.occupied + ", reset=" + this.reset + ", plazaMode=" + this.plazaMode + ", tvScreenOff=" + this.tvScreenOff + '}';
    }
}

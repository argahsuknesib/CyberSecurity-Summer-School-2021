package com.xiaomi.smarthome.core.server.internal.bluetooth.model;

import _m_j.gnk;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class BleDeviceProp implements Serializable {
    String beaconName;
    public int boundStatus;
    String desc;
    String did;
    String encryptedKeyId;
    String encryptedLtmk;
    String encryptedMeshBindInfo;
    String encryptedSession;
    String encryptedToken;
    JSONObject extras = new JSONObject();
    int ltmkEncryptType;
    public String model;
    String name;
    String ownerId;
    String ownerName;
    int permitLevel;
    String pincode;
    int productId;
    BleGattProfile profile;
    int rssi;
    String scanRecord;
    boolean showPincode;
    String smac;
    int type;

    public final void O000000o(String str, String str2) {
        try {
            this.extras.put(str, str2);
        } catch (JSONException e) {
            gnk.O00000Oo(gnk.O00000Oo(e));
        }
    }

    public final boolean O000000o(String str) {
        return this.extras.optBoolean(str, false);
    }

    public final String O00000Oo(String str, String str2) {
        return this.extras.optString(str, str2);
    }

    public final String O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("did", this.did);
            jSONObject.put("desc", this.desc);
            jSONObject.put("model", this.model);
            jSONObject.put("productId", this.productId);
            jSONObject.put("boundStatus", this.boundStatus);
            jSONObject.put("encryptedToken", this.encryptedToken);
            jSONObject.put("encryptedLtmk", this.encryptedLtmk);
            jSONObject.put("pincode", this.pincode);
            jSONObject.put("ltmkEncryptType", this.ltmkEncryptType);
            jSONObject.put("showPincode", this.showPincode);
            jSONObject.put("encryptedKeyId", this.encryptedKeyId);
            jSONObject.put("ownerId", this.ownerId);
            jSONObject.put("type", this.type);
            jSONObject.put("permitLevel", this.permitLevel);
            jSONObject.put("ownerName", this.ownerName);
            jSONObject.put("extras", this.extras);
            jSONObject.put("encryptedMeshBindInfo", this.encryptedMeshBindInfo);
        } catch (Exception e) {
            gnk.O00000Oo(gnk.O00000Oo(e));
        }
        return jSONObject.toString();
    }

    public static BleDeviceProp O00000Oo(String str) {
        try {
            BleDeviceProp bleDeviceProp = new BleDeviceProp();
            JSONObject jSONObject = new JSONObject(str);
            bleDeviceProp.name = jSONObject.optString("name");
            bleDeviceProp.did = jSONObject.optString("did");
            bleDeviceProp.desc = jSONObject.optString("desc");
            bleDeviceProp.model = jSONObject.optString("model");
            bleDeviceProp.productId = jSONObject.optInt("productId");
            bleDeviceProp.boundStatus = jSONObject.optInt("boundStatus");
            bleDeviceProp.encryptedToken = jSONObject.optString("encryptedToken");
            bleDeviceProp.encryptedLtmk = jSONObject.optString("encryptedLtmk");
            bleDeviceProp.pincode = jSONObject.optString("pincode");
            bleDeviceProp.ltmkEncryptType = jSONObject.optInt("ltmkEncryptType");
            bleDeviceProp.showPincode = jSONObject.optBoolean("showPincode", true);
            bleDeviceProp.encryptedKeyId = jSONObject.optString("encryptedKeyId");
            bleDeviceProp.ownerId = jSONObject.optString("ownerId");
            bleDeviceProp.permitLevel = jSONObject.optInt("permitLevel");
            bleDeviceProp.ownerName = jSONObject.optString("ownerName", "");
            bleDeviceProp.type = jSONObject.optInt("type", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("extras");
            if (optJSONObject != null) {
                bleDeviceProp.extras = optJSONObject;
            }
            bleDeviceProp.encryptedMeshBindInfo = jSONObject.optString("encryptedMeshBindInfo");
            return bleDeviceProp;
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.name)) {
            sb.append("name = " + this.name);
        }
        if (!TextUtils.isEmpty(this.did)) {
            sb.append(", did = " + this.did);
        }
        if (!TextUtils.isEmpty(this.desc)) {
            sb.append(", desc = " + this.desc);
        }
        if (!TextUtils.isEmpty(this.model)) {
            sb.append(", model = " + this.model);
        }
        if (this.productId > 0) {
            sb.append(", productId = " + this.productId);
        }
        sb.append(", boundStatus = " + this.boundStatus);
        if (this.extras.length() > 0) {
            sb.append(", extras = " + this.extras);
        }
        return sb.toString();
    }
}

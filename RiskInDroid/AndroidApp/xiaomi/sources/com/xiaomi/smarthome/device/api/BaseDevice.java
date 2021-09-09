package com.xiaomi.smarthome.device.api;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseDevice {
    private static int PERMISSION_FAMILY = 8;
    private static int PERMISSION_NONE = 65296;
    private static int PERMISSION_NONE_MASK = 30;
    private static int PERMISSION_OWNER = 16;
    private static int PERMISSION_SHARE = 4;
    private static int PERMISSION_SHARE_READONLY = 32;
    public DeviceStat mDeviceStat;
    protected String mSpecUrn;
    ArrayList<WeakReference<StateChangedListener>> mStateChangedListeners = new ArrayList<>();

    public interface StateChangedListener {
        void onStateChanged(BaseDevice baseDevice);
    }

    public BaseDevice(DeviceStat deviceStat) {
        this.mDeviceStat = deviceStat;
    }

    public void addStateChangedListener(StateChangedListener stateChangedListener) {
        if (stateChangedListener != null) {
            Iterator<WeakReference<StateChangedListener>> it = this.mStateChangedListeners.iterator();
            while (it.hasNext()) {
                if (it.next().get() == stateChangedListener) {
                    return;
                }
            }
            this.mStateChangedListeners.add(new WeakReference(stateChangedListener));
        }
    }

    public void removeStateChangedListener(StateChangedListener stateChangedListener) {
        if (stateChangedListener != null) {
            for (int i = 0; i < this.mStateChangedListeners.size(); i++) {
                if (this.mStateChangedListeners.get(i).get() == stateChangedListener) {
                    this.mStateChangedListeners.remove(i);
                    return;
                }
            }
        }
    }

    public void notifyStateChanged() {
        for (int i = 0; i < this.mStateChangedListeners.size(); i++) {
            StateChangedListener stateChangedListener = (StateChangedListener) this.mStateChangedListeners.get(i).get();
            if (stateChangedListener != null) {
                stateChangedListener.onStateChanged(this);
            }
        }
    }

    public <T> void callMethod(String str, Object[] objArr, Callback<T> callback, Parser<T> parser) {
        XmPluginHostApi.instance().callMethod(getDid(), str, objArr, callback, parser);
    }

    public <T> void callMethod(String str, JSONArray jSONArray, Callback<T> callback, Parser<T> parser) {
        XmPluginHostApi.instance().callMethod(getDid(), str, jSONArray, callback, parser);
    }

    public <T> void callMethod(String str, JSONObject jSONObject, Callback<T> callback, Parser<T> parser) {
        XmPluginHostApi.instance().callMethod(getDid(), str, jSONObject, callback, parser);
    }

    @Deprecated
    public void checkDeviceUpdateInfo(Callback<DeviceUpdateInfo> callback) {
        XmPluginHostApi.instance().getUpdateInfo(getModel(), getDid(), this.mDeviceStat.pid, callback);
    }

    public String getDid() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            return null;
        }
        return deviceStat.did;
    }

    public String getName() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            return null;
        }
        return deviceStat.name;
    }

    public void setName(String str) {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat != null) {
            deviceStat.name = str;
        }
    }

    public String getIp() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            return null;
        }
        return deviceStat.ip;
    }

    public String getMac() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            return null;
        }
        return deviceStat.mac;
    }

    public String getModel() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            return null;
        }
        return deviceStat.model;
    }

    public String getParentId() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            return null;
        }
        return deviceStat.parentId;
    }

    public String getParentModel() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            return null;
        }
        return deviceStat.parentModel;
    }

    public int getBindFlag() {
        return this.mDeviceStat.bindFlag;
    }

    public int getAuthFlag() {
        return this.mDeviceStat.authFlag;
    }

    public boolean isSubDevice() {
        return !TextUtils.isEmpty(this.mDeviceStat.parentId);
    }

    public boolean isBinded() {
        return this.mDeviceStat.bindFlag == 1;
    }

    public void updateDeviceStatus() {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(this.mDeviceStat.did);
        if (deviceByDid != null) {
            this.mDeviceStat = deviceByDid;
        }
    }

    public void setSpecUrn(String str) {
        this.mSpecUrn = str;
    }

    public String getSpecUrn() {
        return this.mSpecUrn;
    }

    public String getToken() {
        return this.mDeviceStat.token;
    }

    public DeviceStat deviceStat() {
        return this.mDeviceStat;
    }

    public boolean isOwner() {
        return ((this.mDeviceStat.permitLevel & PERMISSION_NONE_MASK) & PERMISSION_OWNER) != 0;
    }

    public boolean isFamily() {
        return ((this.mDeviceStat.permitLevel & PERMISSION_NONE_MASK) & PERMISSION_FAMILY) != 0;
    }

    public boolean isShared() {
        return (this.mDeviceStat.permitLevel & PERMISSION_SHARE) != 0 && !TextUtils.isEmpty(this.mDeviceStat.ownerName);
    }

    public boolean isBinded2() {
        return (this.mDeviceStat.permitLevel & PERMISSION_NONE_MASK) != 0;
    }

    public boolean isReadOnlyShared() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null || (deviceStat.permitLevel & PERMISSION_SHARE_READONLY) == 0 || TextUtils.isEmpty(this.mDeviceStat.ownerName)) {
            return false;
        }
        return true;
    }
}

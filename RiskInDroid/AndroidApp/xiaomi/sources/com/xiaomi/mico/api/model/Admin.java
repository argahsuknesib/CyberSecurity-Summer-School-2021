package com.xiaomi.mico.api.model;

import android.text.TextUtils;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Admin {
    public static HashMap<String, MicoLocalState> localStateHashMap = new HashMap<>();

    public static class Mico implements Serializable {
        private static final long serialVersionUID = 4498689688567310252L;
        public Map<String, Integer> capabilities;
        public boolean current;
        public String deviceID = "";
        public String hardware = "";
        public String miotDID;
        public String name;
        public String presence;
        public String romVersion = "";
        public transient boolean select;
        public String serialNumber = "";
        public transient String stereoJson;
        public transient boolean unKnownError;

        public boolean isValid() {
            return !TextUtils.isEmpty(this.deviceID);
        }

        public String getDisplayName() {
            return !TextUtils.isEmpty(this.name) ? this.name : this.deviceID;
        }

        public boolean isOnline() {
            return "online".equalsIgnoreCase(this.presence);
        }

        public boolean isOffline() {
            return "offline".equalsIgnoreCase(this.presence);
        }

        public void expectOnlineAfterBind() {
            if (this.current) {
                this.presence = "online";
            }
        }

        public boolean hasCapability(MicoCapability micoCapability) {
            Map<String, Integer> map = this.capabilities;
            if (map == null || !map.containsKey(micoCapability.toString()) || this.capabilities.get(micoCapability.toString()).intValue() <= 0) {
                return false;
            }
            return true;
        }

        public Hardware getHardwareType() {
            return Hardware.safeValueOf(this.hardware.toUpperCase(), this.serialNumber);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Mico)) {
                return false;
            }
            Mico mico = (Mico) obj;
            return mico.serialNumber.equals(this.serialNumber) && mico.deviceID.equals(this.deviceID);
        }

        public MicoLocalState getLocalState() {
            if (!Admin.localStateHashMap.containsKey(this.deviceID)) {
                Admin.localStateHashMap.put(this.deviceID, new MicoLocalState());
            }
            return Admin.localStateHashMap.get(this.deviceID);
        }

        public String getCapabilitiesLike(String str) {
            if (this.capabilities == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String next : this.capabilities.keySet()) {
                Integer num = this.capabilities.get(next);
                if (next.startsWith(str) && num.intValue() > 0) {
                    stringBuffer.append(next);
                    stringBuffer.append(",");
                }
            }
            return stringBuffer.toString();
        }

        public String toString() {
            return "Mico{, hardware='" + this.hardware + '\'' + ", romVersion='" + this.romVersion + '\'' + ", capabilities=" + this.capabilities + '}';
        }
    }

    public static class MicoLocalState {
        private String brainlevel = "product";

        public void setBrainlevel(String str) {
            this.brainlevel = str;
        }

        public String getBrainlevel() {
            return this.brainlevel;
        }
    }
}

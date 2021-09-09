package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import java.util.Map;

public final class chy {

    /* renamed from: O000000o  reason: collision with root package name */
    protected SpecDevice f13864O000000o;

    public chy(SpecDevice specDevice) {
        this.f13864O000000o = specDevice;
    }

    public final SpecDevice O000000o() {
        return this.f13864O000000o;
    }

    public final SpecService O000000o(String str) {
        if (this.f13864O000000o == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            for (Map.Entry<Integer, SpecService> value : this.f13864O000000o.getServices().entrySet()) {
                SpecService specService = (SpecService) value.getValue();
                if (specService != null && specService.getTypeName().equalsIgnoreCase(str)) {
                    return specService;
                }
            }
            return null;
        } catch (Exception e) {
            cki.O00000oO("CameraSpecDevice", "getSpecServiceByName:" + e.getLocalizedMessage());
            return null;
        }
    }

    public final SpecProperty O000000o(SpecService specService, String str) {
        if (this.f13864O000000o == null || specService == null || TextUtils.isEmpty(str) || specService == null) {
            return null;
        }
        try {
            for (Map.Entry<Integer, SpecProperty> value : specService.getProperties().entrySet()) {
                SpecProperty specProperty = (SpecProperty) value.getValue();
                if (specProperty != null && specProperty.getDefinition().getTypeName().equalsIgnoreCase(str)) {
                    return specProperty;
                }
            }
            return null;
        } catch (Exception e) {
            cki.O00000oO("CameraSpecDevice", "getSpecPropertyByName:" + e.getLocalizedMessage());
            return null;
        }
    }

    public final SpecAction O000000o(String str, String str2) {
        SpecService O000000o2;
        if (this.f13864O000000o == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (O000000o2 = O000000o(str)) == null) {
            return null;
        }
        try {
            for (Map.Entry<Integer, SpecAction> value : O000000o2.getActions().entrySet()) {
                SpecAction specAction = (SpecAction) value.getValue();
                if (specAction != null && specAction.getDefinition().getTypeName().equalsIgnoreCase(str2)) {
                    return specAction;
                }
            }
            return null;
        } catch (Exception e) {
            cki.O00000oO("CameraSpecDevice", "getSpecActionByName:" + e.getLocalizedMessage());
            return null;
        }
    }

    public final SpecService O000000o(int i) {
        Map<Integer, SpecService> services;
        SpecDevice specDevice = this.f13864O000000o;
        if (specDevice == null || (services = specDevice.getServices()) == null) {
            return null;
        }
        for (Map.Entry<Integer, SpecService> value : services.entrySet()) {
            SpecService specService = (SpecService) value.getValue();
            if (specService.getIid() == i) {
                return specService;
            }
        }
        return null;
    }

    public final SpecProperty O000000o(int i, int i2) {
        SpecService O000000o2;
        if (this.f13864O000000o == null || (O000000o2 = O000000o(i)) == null) {
            return null;
        }
        for (Map.Entry<Integer, SpecProperty> value : O000000o2.getProperties().entrySet()) {
            SpecProperty specProperty = (SpecProperty) value.getValue();
            if (specProperty.getIid() == i2) {
                return specProperty;
            }
        }
        return null;
    }
}

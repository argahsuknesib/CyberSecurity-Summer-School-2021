package com.xiaomi.smarthome.miio.device;

import _m_j.fml;
import _m_j.fqw;
import com.xiaomi.smarthome.device.MiioDeviceV2;

public class PhoneIRDevice extends MiioDeviceV2 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f9714O000000o = fml.O000000o();

    public boolean isOwner() {
        return true;
    }

    public PhoneIRDevice() {
        this.did = f9714O000000o;
        this.model = fqw.O000000o();
        this.canAuth = false;
        setOwner(true);
        this.isOnline = true;
    }
}

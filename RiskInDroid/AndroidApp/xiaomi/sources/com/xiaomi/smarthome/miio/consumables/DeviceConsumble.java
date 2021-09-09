package com.xiaomi.smarthome.miio.consumables;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Keep
public class DeviceConsumble implements Serializable {
    public int childSize = 0;
    public List<Consumable> consumables = new ArrayList();
    public String did;
    public boolean isBleGateway;
    public boolean isOnline;
    public boolean isSkipRpc;
}

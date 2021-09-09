package com.xiaomi.mico.setting.address;

import java.io.Serializable;

public interface POIInfoWrapper {
    String getCity();

    String getDesc();

    String getDisplayAddress();

    String getName();

    Serializable getOrigin();
}

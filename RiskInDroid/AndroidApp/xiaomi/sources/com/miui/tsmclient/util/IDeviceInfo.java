package com.miui.tsmclient.util;

import android.content.Context;
import java.util.List;

public interface IDeviceInfo {
    String getDeviceId(Context context);

    String getDeviceModel();

    int getDeviceType();

    List<String> getSIMNumber();

    boolean isEseEnabled(Context context);
}

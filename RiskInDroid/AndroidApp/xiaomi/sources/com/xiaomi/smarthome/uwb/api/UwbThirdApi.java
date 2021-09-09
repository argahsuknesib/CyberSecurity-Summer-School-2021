package com.xiaomi.smarthome.uwb.api;

import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class UwbThirdApi {
    public static void doKeyEventDown(int i) {
        UwbLogUtil.w("UwbThirdApi", "UwbLogUtilPlus UwbThirdApi doKeyEventDown");
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.TAG, getType(i), getKeyEventDownParam(i), UwbConst.Target.SEND_DATA_TO_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Type getType(int i) {
        return (26 == i || 24 == i || 25 == i || 3 == i || 4 == i) ? Type.Multimedia : Type.Keyboard;
    }

    public static void doKeyEventUp(Type type) {
        UwbLogUtil.w("UwbThirdApi", "UwbLogUtilPlus UwbThirdApi doKeyEventUp");
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.TAG, type, getKeyEventUpParam(), UwbConst.Target.SEND_DATA_TO_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] getKeyEventDownParam(int i) {
        if (i == 3) {
            return new byte[]{0, 6};
        }
        if (i == 4) {
            return new byte[]{0, 5};
        }
        if (i == 66) {
            return new byte[]{0, 88};
        }
        if (i == 82) {
            return new byte[]{0, 101};
        }
        switch (i) {
            case 19:
                return new byte[]{0, 82};
            case 20:
                return new byte[]{0, 81};
            case 21:
                return new byte[]{0, 80};
            case 22:
                return new byte[]{0, 79};
            default:
                switch (i) {
                    case 24:
                        return new byte[]{0, 2};
                    case 25:
                        return new byte[]{0, 3};
                    case 26:
                        return new byte[]{0, 1};
                    default:
                        return null;
                }
        }
    }

    public static byte[] getKeyEventUpParam() {
        return new byte[]{0, 0};
    }
}

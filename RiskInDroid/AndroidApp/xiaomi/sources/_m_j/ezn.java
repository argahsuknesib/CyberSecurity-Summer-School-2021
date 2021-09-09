package _m_j;

import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.push.PushType;

public interface ezn extends gze {
    void clearRegedPushIDAndDeviceID();

    void dispatchMessage(String str, String str2, boolean z);

    String getPushId();

    void getPushManagerInstance();

    void registerDevicePushListener(Device device, ezm ezm);

    void registerPushId();

    void registerPushListener(PushType pushType, gdy gdy);

    void registerPushService();

    void unregisterDevicePushListener(Device device);

    void unregisterDevicePushListener(Device device, ezm ezm);

    fsn unregisterPushId(fsm<Void, fso> fsm);

    void unregisterPushListener(PushType pushType, gdy gdy);

    void unregisterPushService();
}

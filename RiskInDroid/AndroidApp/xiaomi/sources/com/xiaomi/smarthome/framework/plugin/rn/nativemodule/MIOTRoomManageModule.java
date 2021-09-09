package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import android.text.TextUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.RoomStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.List;

public class MIOTRoomManageModule extends MIOTBaseJavaModule {
    public String getName() {
        return "MHRoom";
    }

    public MIOTRoomManageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getRoomList(Callback callback) {
        if (callback != null) {
            DeviceStat device = getDevice();
            if (device == null) {
                callback.invoke(Boolean.FALSE, "current device is null...");
            } else if (!isRock(device.model)) {
                callback.invoke(Boolean.FALSE, "current device model is " + device.model + ", can not support getRoomList...");
            } else {
                boolean shouldRetDidList = shouldRetDidList(device.model);
                List<RoomStat> roomAll = XmPluginHostApi.instance().getRoomAll();
                WritableArray createArray = Arguments.createArray();
                if (roomAll != null && roomAll.size() > 0) {
                    int size = roomAll.size();
                    for (int i = 0; i < size; i++) {
                        createArray.pushMap(roomStateToMap(roomAll.get(i), shouldRetDidList));
                    }
                }
                callback.invoke(Boolean.TRUE, createArray);
            }
        }
    }

    private boolean shouldRetDidList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("xiaomi.wifispeaker");
    }

    @ReactMethod
    public void editRoom(ReadableMap readableMap, final Callback callback) {
        if (callback != null) {
            if (readableMap == null) {
                callback.invoke(Boolean.FALSE, "params is null");
                return;
            }
            DeviceStat device = getDevice();
            if (device == null) {
                callback.invoke(Boolean.FALSE, "current device is null...");
            } else if (!isRock(device.model)) {
                callback.invoke(Boolean.FALSE, "current device model is " + device.model + ", can not support editRoom...");
            } else {
                String string = readableMap.getString("roomId");
                String string2 = readableMap.getString("name");
                if (TextUtils.isEmpty(string)) {
                    callback.invoke(Boolean.FALSE, "roomId is null or empty...");
                    return;
                }
                XmPluginHostApi.instance().renameRoom(string, string2, new com.xiaomi.smarthome.device.api.Callback<Void>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTRoomManageModule.AnonymousClass1 */

                    public final void onFailure(int i, String str) {
                        callback.invoke(Boolean.FALSE, str);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        callback.invoke(Boolean.TRUE, "edit room success");
                    }
                });
            }
        }
    }

    @ReactMethod
    public void addNewRoomWithName(String str, final Callback callback) {
        if (callback != null) {
            DeviceStat device = getDevice();
            if (device == null) {
                callback.invoke(Boolean.FALSE, "current device is null...");
            } else if (!isRock(device.model)) {
                callback.invoke(Boolean.FALSE, "current device model is " + device.model + ", can not support addNewRoom...");
            } else {
                RoomStat roomStat = new RoomStat();
                roomStat.name = str;
                XmPluginHostApi.instance().addRoom(roomStat, new com.xiaomi.smarthome.device.api.Callback<RoomStat>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTRoomManageModule.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        callback.invoke(Boolean.TRUE, MIOTRoomManageModule.this.roomStateToMap((RoomStat) obj));
                    }

                    public final void onFailure(int i, String str) {
                        callback.invoke(Boolean.FALSE, str);
                    }
                });
            }
        }
    }

    private boolean isRock(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("roborock.vacuum.") || str.startsWith("rockrobo.vacuum.") || str.startsWith("roborock.sweeper.") || str.startsWith("viomi.vacuum.") || str.startsWith("roidmi.vacuum.") || str.startsWith("ijai.vacuum.") || str.startsWith("zhimi.vacuum.") || str.startsWith("dreame.vacuum.") || str.startsWith("szkj.vacuum.") || str.startsWith("xiaomi.wifispeaker.")) {
            return true;
        }
        return false;
    }

    public WritableMap roomStateToMap(RoomStat roomStat) {
        return roomStateToMap(roomStat, false);
    }

    private WritableMap roomStateToMap(RoomStat roomStat, boolean z) {
        WritableMap createMap = Arguments.createMap();
        if (roomStat == null) {
            return createMap;
        }
        createMap.putString("homeId", roomStat.parentid);
        createMap.putString("name", roomStat.name);
        createMap.putString("roomId", roomStat.id);
        StringBuilder sb = new StringBuilder();
        sb.append(roomStat.shareflag);
        createMap.putString("shareFlag", sb.toString());
        if (z) {
            createMap.putArray("didList", Arguments.fromList(roomStat.dids));
        }
        return createMap;
    }
}

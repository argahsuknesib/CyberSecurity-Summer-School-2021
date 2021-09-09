package com.xiaomi.smarthome.uwb.lib.idm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.IDMUwbDevice;
import com.xiaomi.idm.uwb.UwbInitiator;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.idm.uwb.constant.UwbResultCode;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.auth.ByteUtils;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConnEngineMijia;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UwbIdmManager {
    private static volatile UwbIdmManager sInstance;
    IDMUwb.UwbCallback mCallback = new IDMUwb.UwbCallback() {
        /* class com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager.AnonymousClass1 */
        long logTimestamp = 0;

        public void onTagOTA(UwbResultCode uwbResultCode, int i) {
        }

        public void onMiConnectConnectionState(UwbResultCode uwbResultCode) {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onMiConnectConnectionState: " + uwbResultCode.getCode() + ", " + uwbResultCode.getMsg());
                if (UwbConnEngineMijia.isResultCodeSuccess(uwbResultCode)) {
                    UwbLogUtil.d("Mijia-UWB-IDMMGR", UwbSdk.getApplication().getPackageName() + ":onMiConnectConnectionState success");
                }
            }
            if (uwbResultCode.getCode() == UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE.getCode()) {
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "onMiConnectConnectionState: receive MI_CONNECT_SERVICE_NOT_AVAILABLE, will re-create initiator");
                UwbInitiator createInitiator = IDMUwb.createInitiator(UwbSdk.getApplication(), UwbIdmManager.this.getAppId(), this);
                if (createInitiator != null) {
                    UwbIdmManager.this.mIDMUwb = createInitiator;
                    UwbLogUtil.d("Mijia-UWB-IDMMGR", "onMiConnectConnectionState: successfully recreated UwbInitiator");
                    return;
                }
            }
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onMiConnectConnectionState(uwbResultCode);
            }
        }

        public void onScanState(UwbResultCode uwbResultCode) {
            int i;
            UwbLogUtil.d("Mijia-UWB-IDMMGR", "onScanState: " + uwbResultCode.getCode() + ", " + uwbResultCode.getMsg());
            for (int i2 = 0; i2 < UwbIdmManager.this.mDeleteCallbacks.size(); i2++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i2).onScanState(uwbResultCode);
            }
            UwbIdmManager uwbIdmManager = UwbIdmManager.this;
            uwbIdmManager.mScanningState = uwbResultCode;
            synchronized (uwbIdmManager.mScanListeners) {
                for (UwbScanListener next : UwbIdmManager.this.mScanListeners) {
                    if (uwbResultCode == null) {
                        i = 0;
                    } else {
                        i = uwbResultCode.getCode();
                    }
                    next.onScanState(i);
                }
            }
        }

        public void onScanning(List<IDMUwbDevice> list) {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3 && System.currentTimeMillis() - this.logTimestamp > 10000) {
                UwbLogUtil.e("Mijia-UWB-timestamp", UwbSdk.getApplication().getPackageName() + ":IDMUwb.UwbCallback onScanning");
                StringBuilder sb = new StringBuilder("onScanning: ");
                sb.append(list == null ? null : Integer.valueOf(list.size()));
                UwbLogUtil.d("Mijia-UWB-IDMMGR", sb.toString());
                this.logTimestamp = System.currentTimeMillis();
            }
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onScanning(list);
            }
            if (list != null) {
                synchronized (UwbIdmManager.this.mScanListeners) {
                    UwbIdmManager.this.mFoundDevices.clear();
                    for (IDMUwbDevice convert : list) {
                        UwbIdmManager.this.mFoundDevices.add(UwbScanDevice.convert(convert));
                    }
                    for (UwbScanListener onScanning : UwbIdmManager.this.mScanListeners) {
                        onScanning.onScanning(UwbIdmManager.this.mFoundDevices);
                    }
                }
            }
        }

        public void onSendPayload(UwbResultCode uwbResultCode, int i) {
            int i2;
            String str;
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onSendPayload: " + uwbResultCode.getCode() + ", " + uwbResultCode.getMsg());
            }
            for (int i3 = 0; i3 < UwbIdmManager.this.mDeleteCallbacks.size(); i3++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i3).onSendPayload(uwbResultCode, i3);
            }
            if (!(uwbResultCode == null || uwbResultCode.getCode() == UwbResultCode.GENERAL_SUCCESS.getCode() || UwbSdk.getSdkConfig().getLogLevel() < 5)) {
                StringBuilder sb = new StringBuilder("onSendPayload ");
                if (uwbResultCode == null) {
                    str = null;
                } else {
                    str = uwbResultCode.getCode() + "," + uwbResultCode.getMsg();
                }
                sb.append(str);
                UwbLogUtil.w("Mijia-UWB-IDMMGR", sb.toString());
            }
            synchronized (UwbIdmManager.this.mDataListeners) {
                for (UwbDataListener next : UwbIdmManager.this.mDataListeners) {
                    if (uwbResultCode == null) {
                        i2 = 0;
                    } else {
                        i2 = uwbResultCode.getCode();
                    }
                    next.onSendPayload(i2);
                }
            }
        }

        public void onPayloadReceived(String str, IDMUwb.Payload payload) {
            UwbLogUtil.w("Mijia-UWB-IDMMGR", "UwbLogUtilPlus onPayloadReceived in IdmManager: " + ByteUtils.toHexString(payload.payload));
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onPayloadReceived(str, payload);
            }
            Payload parse = Payload.parse(payload);
            if (parse == null) {
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "onPayloadReceived cannot parse payload for " + Arrays.toString(payload.payload));
                return;
            }
            synchronized (UwbIdmManager.this.mDataListeners) {
                for (UwbDataListener onPayloadReceived : UwbIdmManager.this.mDataListeners) {
                    onPayloadReceived.onPayloadReceived(parse);
                }
            }
        }

        public void onConnectionState(String str, UwbResultCode uwbResultCode) {
            int i;
            String str2;
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onConnectionState: " + uwbResultCode.getCode() + ", " + uwbResultCode.getMsg());
            }
            for (int i2 = 0; i2 < UwbIdmManager.this.mDeleteCallbacks.size(); i2++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i2).onConnectionState(str, uwbResultCode);
            }
            if (!(uwbResultCode == null || uwbResultCode.getCode() == UwbResultCode.GENERAL_SUCCESS.getCode() || UwbSdk.getSdkConfig().getLogLevel() < 5)) {
                StringBuilder sb = new StringBuilder("onConnectionState uwbAddress=");
                sb.append(str);
                if (uwbResultCode == null) {
                    str2 = null;
                } else {
                    str2 = uwbResultCode.getCode() + "," + uwbResultCode.getMsg();
                }
                sb.append(str2);
                UwbLogUtil.w("Mijia-UWB-IDMMGR", sb.toString());
            }
            UwbIdmManager uwbIdmManager = UwbIdmManager.this;
            uwbIdmManager.mConnState = uwbResultCode;
            synchronized (uwbIdmManager.mDataListeners) {
                for (UwbDataListener next : UwbIdmManager.this.mDataListeners) {
                    if (uwbResultCode == null) {
                        i = 0;
                    } else {
                        i = uwbResultCode.getCode();
                    }
                    next.onConnectionState(str, i);
                }
            }
        }

        public void onEstablishSecurityLine(UwbResultCode uwbResultCode) {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onEstablishSecurityLine: " + uwbResultCode.getCode() + ", " + uwbResultCode.getMsg() + ",callback size=" + UwbIdmManager.this.mDeleteCallbacks.size());
            }
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onEstablishSecurityLine(uwbResultCode);
            }
        }

        public void onTagPluggedIn() {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onTagPluggedIn");
            }
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onTagPluggedIn();
            }
        }

        public void onTagUnplugged() {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onTagUnplugged");
            }
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onTagUnplugged();
            }
        }

        public void onSwitchCommunicationType(UwbResultCode uwbResultCode) {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onSwitchCommunicationType: " + uwbResultCode.getCode() + ", " + uwbResultCode.getMsg());
            }
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onSwitchCommunicationType(uwbResultCode);
            }
        }

        public void onSetServerSecurityKey(UwbResultCode uwbResultCode) {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-IDMMGR", "onSetServerSecurityKey: " + uwbResultCode.getCode() + ", " + uwbResultCode.getMsg());
            }
            for (int i = 0; i < UwbIdmManager.this.mDeleteCallbacks.size(); i++) {
                UwbIdmManager.this.mDeleteCallbacks.get(i).onSetServerSecurityKey(uwbResultCode);
            }
        }
    };
    public UwbResultCode mConnState;
    private volatile boolean mConnected = false;
    public List<UwbDataListener> mDataListeners = new ArrayList();
    public List<IDMUwb.UwbCallback> mDeleteCallbacks = new ArrayList();
    public List<UwbScanDevice> mFoundDevices = new ArrayList();
    public UwbInitiator mIDMUwb;
    private volatile boolean mInited = false;
    public List<UwbScanListener> mScanListeners = new ArrayList();
    public UwbResultCode mScanningState;

    private UwbIdmManager() {
    }

    public static UwbIdmManager getInstance() {
        if (sInstance == null) {
            synchronized (UwbIdmManager.class) {
                if (sInstance == null) {
                    sInstance = new UwbIdmManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isUwbValid() {
        return this.mIDMUwb != null;
    }

    public void init(Context context) {
        if (isIDMServiceExist(context)) {
            if (this.mInited) {
                this.mCallback.onMiConnectConnectionState(UwbResultCode.fromCode(UwbResultCode.GENERAL_SUCCESS.getCode()));
                return;
            }
            try {
                this.mInited = true;
                UwbLogUtil.e("Mijia-UWB-timestamp", UwbSdk.getApplication().getPackageName() + ":IDMUwb.createInitiator start");
                this.mIDMUwb = IDMUwb.createInitiator(context, getAppId(), this.mCallback);
                if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                    UwbLogUtil.d("Mijia-UWB-IDMMGR", "IDMUwb created");
                }
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "init error: " + e.getMessage());
            }
        }
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public void connect(String str) {
        try {
            this.mConnected = true;
            this.mIDMUwb.connect(str);
            UwbLogUtil.d("Mijia-UWB-IDMMGR", "connect uwbAddress ".concat(String.valueOf(str)));
        } catch (Exception e) {
            e.printStackTrace();
            UwbLogUtil.e("Mijia-UWB-IDMMGR", "connect exception:" + e.getMessage());
        }
    }

    public void disconnect(String str) {
        if (isUwbValid()) {
            if (!this.mConnected) {
                UwbLogUtil.w("Mijia-UWB-IDMMGR", "already disconnected, no need disconnect again");
                return;
            }
            try {
                this.mConnected = false;
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "disconnect exception:" + e.getMessage());
            }
        }
    }

    public void startScan() {
        if (isUwbValid()) {
            try {
                this.mIDMUwb.startScan(0, 500, "0000");
                UwbLogUtil.e("Mijia-UWB-timestamp", "IDMUwb startScan");
                UwbLogUtil.w("Mijia-UWB-IDMMGR", "startScan appid1 " + UwbConst.AppId.MI_HOME);
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "scan exception1:" + e.getMessage());
            }
        }
    }

    public void startScan(int i, String str) {
        if (isUwbValid()) {
            try {
                this.mIDMUwb.startScan(0, i, str);
                UwbLogUtil.e("Mijia-UWB-timestamp", "IDMUwb startScan with timeout=" + i + ",address=" + str);
                UwbLogUtil.w("Mijia-UWB-IDMMGR", "startScan appid2 0");
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "scan exception2:" + e.getMessage());
            }
        }
    }

    public boolean isScanning() {
        if (!isUwbValid()) {
            return false;
        }
        try {
            boolean isScanning = this.mIDMUwb.isScanning();
            UwbLogUtil.d("Mijia-UWB-IDMMGR", "isScanning ".concat(String.valueOf(isScanning)));
            return isScanning;
        } catch (Exception e) {
            e.printStackTrace();
            UwbLogUtil.e("Mijia-UWB-IDMMGR", "isScanning exception:" + e.getMessage());
            return false;
        }
    }

    public void startAdvertising(String str, int i) {
        if (isUwbValid()) {
            try {
                this.mIDMUwb.startAdvertising(0, str, i);
                UwbLogUtil.w("Mijia-UWB-IDMMGR", "startAdvertising  0");
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "startAdvertising exception2:" + e.getMessage());
            }
        }
    }

    public void stopScan() {
        if (isUwbValid()) {
            try {
                this.mIDMUwb.stopScan();
                UwbLogUtil.w("Mijia-UWB-IDMMGR", "stopScan");
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "stopScan exception:" + e.getMessage());
            }
        }
    }

    public IDMUwb.Payload toIdmPayload(Payload payload) {
        return this.mIDMUwb.createPayload(payload.getIdmAppId(), payload.toIdmPayloadBytes());
    }

    public void sendPayload(String str, Payload payload, UwbConst.Flag flag) {
        if (!isUwbValid()) {
            UwbLogUtil.e("Mijia-UWB-IDMMGR", "uwb not valid, return");
            return;
        }
        try {
            byte[] bytes = payload.toBytes();
            IDMUwb.Payload idmPayload = toIdmPayload(payload);
            this.mIDMUwb.sendPayload(str, idmPayload, flag, payload.getTarget(), 0);
            UwbLogUtil.d("Mijia-UWB-IDMMGR", "sendPayload uwbAddress:" + str + ",flag=" + flag + ",target=" + payload.getTarget() + ",payload:" + idmPayload.toString());
            UwbIdmMonitor.getInstance().onPayloadSend(bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            UwbLogUtil.e("Mijia-UWB-IDMMGR", "sendPayload exception:" + e.getMessage());
        }
    }

    public void establishSecurityLine(UwbConst.AppId appId, String str, String str2, byte[] bArr, UwbConst.LoginType loginType) {
        String str3;
        if (isUwbValid()) {
            try {
                this.mIDMUwb.establishSecurityLine(str, str2, bArr, loginType, appId);
                if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                    StringBuilder sb = new StringBuilder("establishSecurityLine uwbAddress:");
                    sb.append(str);
                    sb.append(",key=");
                    sb.append(str2);
                    sb.append(",uidHash=");
                    if (bArr == null) {
                        str3 = null;
                    } else {
                        str3 = Arrays.toString(bArr);
                    }
                    sb.append(str3);
                    sb.append(",type=");
                    sb.append(loginType);
                    sb.append(",targetAppId=");
                    sb.append(appId);
                    UwbLogUtil.d("Mijia-UWB-IDMMGR", sb.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "sendPayload exception:" + e.getMessage());
            }
        }
    }

    public void switchCommunicationType(String str) {
        if (isUwbValid()) {
            try {
                this.mIDMUwb.switchCommunicationType(UwbConst.AppId.MI_HOME, str);
                UwbLogUtil.w("Mijia-UWB-IDMMGR", "switchCommunicationType " + UwbConst.AppId.MI_HOME);
            } catch (Exception e) {
                e.printStackTrace();
                UwbLogUtil.e("Mijia-UWB-IDMMGR", "switchCommunicationType exception:" + e.getMessage());
            }
        }
    }

    public boolean removeUWBScanListener(UwbScanListener uwbScanListener) {
        boolean remove;
        UwbLogUtil.d("Mijia-UWB-IDMMGR", "removeUWBScanListener ".concat(String.valueOf(uwbScanListener)));
        synchronized (this.mScanListeners) {
            remove = this.mScanListeners.remove(uwbScanListener);
        }
        return remove;
    }

    public void addUWBScanListener(UwbScanListener uwbScanListener) {
        UwbLogUtil.d("Mijia-UWB-IDMMGR", "addUWBScanListener ".concat(String.valueOf(uwbScanListener)));
        synchronized (this.mScanListeners) {
            if (!this.mScanListeners.contains(uwbScanListener)) {
                this.mScanListeners.add(uwbScanListener);
            }
        }
    }

    public void removeUWBDataListener(UwbDataListener uwbDataListener) {
        UwbLogUtil.d("Mijia-UWB-IDMMGR", "removeUWBDataListener ".concat(String.valueOf(uwbDataListener)));
        synchronized (this.mDataListeners) {
            this.mDataListeners.remove(uwbDataListener);
        }
    }

    public void addUWBDataListener(UwbDataListener uwbDataListener) {
        UwbLogUtil.d("Mijia-UWB-IDMMGR", "addUWBDataListener ".concat(String.valueOf(uwbDataListener)));
        synchronized (this.mDataListeners) {
            if (!this.mDataListeners.contains(uwbDataListener)) {
                this.mDataListeners.add(uwbDataListener);
            }
        }
    }

    public void addDelegateCallback(IDMUwb.UwbCallback uwbCallback) {
        UwbLogUtil.d("Mijia-UWB-IDMMGR", "addDelegateCallback ".concat(String.valueOf(uwbCallback)));
        this.mDeleteCallbacks.add(uwbCallback);
    }

    public boolean removeDelegateCallback(IDMUwb.UwbCallback uwbCallback) {
        UwbLogUtil.d("Mijia-UWB-IDMMGR", "removeDelegateCallback ".concat(String.valueOf(uwbCallback)));
        return this.mDeleteCallbacks.remove(uwbCallback);
    }

    public UwbConst.AppId getAppId() {
        return UwbConst.AppId.MI_HOME;
    }

    private boolean isIDMServiceExist(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.xiaomi.mi_connect_service", "com.xiaomi.mi_connect_service.MiConnectService"));
        boolean z = false;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            z = true;
        }
        UwbLogUtil.d("Mijia-UWB-IDMMGR", "isIDMServiceExist: ".concat(String.valueOf(z)));
        return z;
    }
}

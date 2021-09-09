package com.xiaomi.idm.uwb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xiaomi.idm.uwb.IMiCloseRange;
import com.xiaomi.idm.uwb.IMiCloseRangeCallback;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.idm.uwb.constant.UwbResultCode;
import com.xiaomi.idm.uwb.proto.MiCloseRange;
import com.xiaomi.idm.uwb.proto.UwbCommand;
import com.xiaomi.idm.uwb.proto.UwbData;
import com.xiaomi.idm.uwb.util.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IDMUwb {
    private byte mAppId = -1;
    public final IMiCloseRangeCallback.Stub mBinderCallback = new IMiCloseRangeCallback.Stub() {
        /* class com.xiaomi.idm.uwb.IDMUwb.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:26:0x006b A[Catch:{ InvalidProtocolBufferException -> 0x007e }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0076 A[Catch:{ InvalidProtocolBufferException -> 0x007e }] */
        public void onTransportChannelCommand(byte[] bArr) throws RemoteException {
            try {
                MiCloseRange.UwbResult parseFrom = MiCloseRange.UwbResult.parseFrom(bArr);
                if (parseFrom != null) {
                    int dataType = parseFrom.getDataType();
                    ByteString data = parseFrom.getData();
                    char c = 0;
                    if (dataType == 0) {
                        try {
                            MiCloseRange.OnScanning parseFrom2 = MiCloseRange.OnScanning.parseFrom(data);
                            LogUtil.v("IDMUwb", "onTransportChannelCommand: \ndevices size = " + parseFrom2.getMeasurementDataCount(), new Object[0]);
                            IDMUwb.this.mCallback.onScanning(IDMUwbDevice.createFromProto(parseFrom2));
                        } catch (InvalidProtocolBufferException e) {
                            LogUtil.e("IDMUwb", e.getMessage(), e);
                        }
                    } else if (dataType == 1) {
                        try {
                            MiCloseRange.PayLoad parseFrom3 = MiCloseRange.PayLoad.parseFrom(data);
                            LogUtil.v("IDMUwb", "onTransportChannelCommand: \npayload[" + parseFrom3.getData() + "]", new Object[0]);
                            IDMUwb.this.mCallback.onPayloadReceived(parseFrom3.getUwbAddress(), Payload.fromBytes(parseFrom3.getData().toByteArray()));
                        } catch (InvalidProtocolBufferException e2) {
                            LogUtil.e("IDMUwb", e2.getMessage(), e2);
                        }
                    } else if (dataType == 2) {
                        try {
                            MiCloseRange.UwbCommandResult parseFrom4 = MiCloseRange.UwbCommandResult.parseFrom(data);
                            String name = parseFrom4.getName();
                            UwbResultCode fromCode = UwbResultCode.fromCode(parseFrom4.getStatus());
                            LogUtil.d("IDMUwb", "onTransportChannelCommand: \ncommandName = " + name + "\nstatus = " + fromCode, new Object[0]);
                            switch (name.hashCode()) {
                                case -2046537714:
                                    if (name.equals("onScanStatus")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -2042961888:
                                    if (name.equals("onEstablishSecurityLineStatus")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1716783111:
                                    if (name.equals("onSetServerSecurityKey")) {
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1659638147:
                                    if (name.equals("onSwitchCommunicationType")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -580829063:
                                    if (name.equals("onSendPayLoadStatus")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -439693201:
                                    if (name.equals("onConnectionStatus")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1517153249:
                                    if (name.equals("onTagOTA")) {
                                        c = 6;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    IDMUwb.this.mCallback.onSetServerSecurityKey(fromCode);
                                    return;
                                case 1:
                                    IDMUwb.this.mCallback.onScanState(fromCode);
                                    return;
                                case 2:
                                    IDMUwb.this.mCallback.onSendPayload(fromCode, UwbCommand.OnSendPayload.parseFrom(parseFrom4.getData()).getTaskId());
                                    return;
                                case 3:
                                    IDMUwb.this.mCallback.onConnectionState(parseFrom4.getUwbAddress(), fromCode);
                                    return;
                                case 4:
                                    IDMUwb.this.mCallback.onEstablishSecurityLine(fromCode);
                                    return;
                                case 5:
                                    IDMUwb.this.mCallback.onSwitchCommunicationType(fromCode);
                                    return;
                                case 6:
                                    IDMUwb.this.mCallback.onTagOTA(fromCode, UwbCommand.OnTagOTA.parseFrom(parseFrom4.getData()).getTaskId());
                                    return;
                                default:
                                    return;
                            }
                        } catch (InvalidProtocolBufferException e3) {
                            LogUtil.e("IDMUwb", e3.getMessage(), e3);
                        }
                    } else if (dataType == 3) {
                        try {
                            MiCloseRange.CallbackMessage parseFrom5 = MiCloseRange.CallbackMessage.parseFrom(data);
                            parseFrom5.getData();
                            LogUtil.v("IDMUwb", "onTransportChannelCommand: \ncallback name[" + parseFrom5.getName() + "]", new Object[0]);
                            String name2 = parseFrom5.getName();
                            int hashCode = name2.hashCode();
                            if (hashCode != -1322355902) {
                                if (hashCode == 1729514308) {
                                    if (name2.equals("onTagUnplugged")) {
                                        c = 1;
                                        if (c == 0) {
                                            IDMUwb.this.mCallback.onTagPluggedIn();
                                            return;
                                        } else if (c == 1) {
                                            IDMUwb.this.mCallback.onTagUnplugged();
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            } else if (name2.equals("onTagPluggedIn")) {
                                if (c == 0) {
                                }
                            }
                            c = 65535;
                            if (c == 0) {
                            }
                        } catch (InvalidProtocolBufferException e4) {
                            LogUtil.e("IDMUwb", e4.getMessage(), e4);
                        }
                    }
                }
            } catch (InvalidProtocolBufferException e5) {
                LogUtil.e("IDMUwb", e5.getMessage(), e5);
                throw new RemoteException(e5.getMessage());
            }
        }
    };
    public final UwbCallback mCallback;
    protected IMiCloseRange mCloseRangeService;
    private final Context mContext;
    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        /* class com.xiaomi.idm.uwb.IDMUwb.AnonymousClass2 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IDMUwb.this.mCloseRangeService = IMiCloseRange.Stub.asInterface(iBinder);
            try {
                UwbResultCode fromCode = UwbResultCode.fromCode(IDMUwb.this.mCloseRangeService.registerCallback(IDMUwb.this.mBinderCallback));
                LogUtil.d("IDMUwb", "onServiceConnected: status = ".concat(String.valueOf(fromCode)), new Object[0]);
                IDMUwb.this.mCallback.onMiConnectConnectionState(fromCode);
            } catch (RemoteException e) {
                LogUtil.e("IDMUwb", e.getMessage(), e);
                IDMUwb.this.mCloseRangeService = null;
            }
        }

        public void onBindingDied(ComponentName componentName) {
            LogUtil.e("IDMUwb", "onBindingDied: name = ".concat(String.valueOf(componentName)), new Object[0]);
        }

        public void onNullBinding(ComponentName componentName) {
            LogUtil.e("IDMUwb", "onNullBinding: name = ".concat(String.valueOf(componentName)), new Object[0]);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.e("IDMUwb", "onServiceDisconnected", new Object[0]);
            IDMUwb iDMUwb = IDMUwb.this;
            iDMUwb.mCloseRangeService = null;
            iDMUwb.mCallback.onMiConnectConnectionState(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
        }
    };

    public interface UwbCallback {
        void onConnectionState(String str, UwbResultCode uwbResultCode);

        void onEstablishSecurityLine(UwbResultCode uwbResultCode);

        void onMiConnectConnectionState(UwbResultCode uwbResultCode);

        void onPayloadReceived(String str, Payload payload);

        void onScanState(UwbResultCode uwbResultCode);

        void onScanning(List<IDMUwbDevice> list);

        void onSendPayload(UwbResultCode uwbResultCode, int i);

        void onSetServerSecurityKey(UwbResultCode uwbResultCode);

        void onSwitchCommunicationType(UwbResultCode uwbResultCode);

        void onTagOTA(UwbResultCode uwbResultCode, int i);

        void onTagPluggedIn();

        void onTagUnplugged();
    }

    protected IDMUwb(Context context, UwbCallback uwbCallback) {
        this.mContext = context;
        this.mCallback = uwbCallback;
    }

    public static UwbInitiator createInitiator(Context context, UwbConst.AppId appId, UwbCallback uwbCallback) {
        UwbInitiator uwbInitiator = new UwbInitiator(context, uwbCallback);
        uwbInitiator.init(appId);
        return uwbInitiator;
    }

    public static UwbResponder createResponder(Context context, UwbConst.AppId appId, UwbCallback uwbCallback) {
        UwbResponder uwbResponder = new UwbResponder(context, uwbCallback);
        uwbResponder.init(appId);
        return uwbResponder;
    }

    /* access modifiers changed from: package-private */
    public void init(UwbConst.AppId appId) {
        LogUtil.v("IDMUwb", "init: \nappId[" + appId + "]", new Object[0]);
        this.mAppId = appId.getId();
        bind();
    }

    private void bind() {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.mi_connect_service.MiCloseRange");
        intent.setComponent(new ComponentName("com.xiaomi.mi_connect_service", "com.xiaomi.mi_connect_service.MiConnectService"));
        if (!serviceAvailable() && !startService(intent)) {
            this.mCallback.onMiConnectConnectionState(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            LogUtil.e("IDMUwb", "bind: starServiceFailed", new Object[0]);
        } else if (!this.mContext.bindService(intent, this.mServiceConnection, 1)) {
            this.mCallback.onMiConnectConnectionState(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            LogUtil.e("IDMUwb", "bind: bindServiceFailed", new Object[0]);
        }
    }

    private void unBind() {
        this.mContext.unbindService(this.mServiceConnection);
    }

    private boolean startService(Intent intent) {
        try {
            return this.mContext.startService(intent) != null;
        } catch (SecurityException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void setServerSecurityKey(String str, String str2) {
        LogUtil.v("IDMUwb", "setServerSecurityKey: \nmemoryKey[" + str + "]\nstrangeKey[" + str2 + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "setServerSecurityKey: service not available", new Object[0]);
            this.mCallback.onSetServerSecurityKey(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("setServerSecurityKey");
        newBuilder.setCommandBytes(((UwbCommand.SetServerSecurityKey) UwbCommand.SetServerSecurityKey.newBuilder().setMemoryKey(str).setStrangeKey(str2).build()).toByteString());
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onSetServerSecurityKey(UwbResultCode.REMOTE_EXCEPTION);
        }
    }

    /* access modifiers changed from: protected */
    public void startAdvertising(int i, String str, int i2) {
        LogUtil.v("IDMUwb", "startAdvertising: \ntimeout[" + i2 + "]\naddress[" + str + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "startAdvertising: service not available", new Object[0]);
            this.mCallback.onScanState(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("startAdvertising");
        newBuilder.setCommandBytes(((UwbCommand.StartADV) UwbCommand.StartADV.newBuilder().setTimeout(i2).setUwbAddress(str).setProjectId(i).build()).toByteString());
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onScanState(UwbResultCode.REMOTE_EXCEPTION);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isScanning() {
        LogUtil.v("IDMUwb", "isScanning", new Object[0]);
        if (!serviceAvailable()) {
            this.mCallback.onScanState(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return false;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("isScanning");
        try {
            byte[] command = this.mCloseRangeService.command(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
            if (command == null) {
                LogUtil.v("IDMUwb", "isScanning return false", new Object[0]);
                return false;
            } else if (command[0] == 1) {
                LogUtil.v("IDMUwb", "isScanning return true", new Object[0]);
                return true;
            } else if (command[0] != 0) {
                return false;
            } else {
                LogUtil.v("IDMUwb", "isScanning return false", new Object[0]);
                return false;
            }
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onScanState(UwbResultCode.REMOTE_EXCEPTION);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void startScan(int i, int i2, int i3, String str) {
        LogUtil.v("IDMUwb", "startScan: \nappId[" + ((int) this.mAppId) + "]\ndeviceRole[" + i + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "startScan: service not available", new Object[0]);
            this.mCallback.onScanState(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("startScan");
        newBuilder.setCommandBytes(((UwbCommand.StartScan) UwbCommand.StartScan.newBuilder().setProjectId(i2).setTimeout(i3).setUwbAddress(str).setAppId(this.mAppId).setDeviceRole(i).build()).toByteString());
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onScanState(UwbResultCode.REMOTE_EXCEPTION);
        }
    }

    /* access modifiers changed from: protected */
    public void stopScan() {
        LogUtil.v("IDMUwb", "stopScan", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "stopScan: service not available", new Object[0]);
            this.mCallback.onScanState(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("stopScan");
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onScanState(UwbResultCode.REMOTE_EXCEPTION);
        }
    }

    /* access modifiers changed from: protected */
    public UwbResultCode stopUwb(String str) {
        LogUtil.v("IDMUwb", "stopUwb: \nuwbAddress[" + str + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "stopUwb: service not available", new Object[0]);
            return UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("stopUwb");
        newBuilder.setCommandBytes(((UwbCommand.StopUwb) UwbCommand.StopUwb.newBuilder().setUwbAddress(str).build()).toByteString());
        try {
            return UwbResultCode.fromCode(MiCloseRange.UwbCommandResult.parseFrom(this.mCloseRangeService.command(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray())).getStatus());
        } catch (RemoteException | InvalidProtocolBufferException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            return UwbResultCode.GENERAL_ERROR;
        }
    }

    /* access modifiers changed from: protected */
    public void sendPayload(String str, Payload payload, int i, int i2, int i3) {
        LogUtil.v("IDMUwb", "sendPayload: \nuwbAddress[" + str + "]\npayload[" + payload + "]\nflag[" + i + "]\ntarget[" + i2 + "]\ntaskId[" + i3 + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "sendPayload: service not available", new Object[0]);
            this.mCallback.onSendPayload(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE, i3);
        } else if (!payload.isValid()) {
            this.mCallback.onSendPayload(UwbResultCode.PAY_LOAD_NOT_VALID, i3);
        } else {
            MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
            newBuilder.setCommandName("sendPayload");
            newBuilder.setCommandBytes(ByteString.copyFrom(((UwbCommand.SendPayload) UwbCommand.SendPayload.newBuilder().setUwbAddress(str).setFlag(i).setPayload(ByteString.copyFrom(payload.toBytes())).setTarget(i2).setTaskId(i3).build()).toByteArray()));
            try {
                this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
            } catch (RemoteException e) {
                LogUtil.e("IDMUwb", e.getMessage(), e);
                this.mCallback.onSendPayload(UwbResultCode.REMOTE_EXCEPTION, i3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void connect(String str) {
        LogUtil.v("IDMUwb", "connect: \nuwbAddress[" + str + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "connect: service not available", new Object[0]);
            this.mCallback.onConnectionState(str, UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("connect");
        newBuilder.setCommandBytes(ByteString.copyFrom(((UwbCommand.Connect) UwbCommand.Connect.newBuilder().setUwbAddress(str).build()).toByteArray()));
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onConnectionState(str, UwbResultCode.GENERAL_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void disconnect(String str) {
        LogUtil.v("IDMUwb", "disconnect: \nuwbAddress[" + str + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "disconnect: service not available", new Object[0]);
            this.mCallback.onConnectionState(str, UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("disconnect");
        newBuilder.setCommandBytes(ByteString.copyFrom(((UwbCommand.Disconnect) UwbCommand.Disconnect.newBuilder().setUwbAddress(str).build()).toByteArray()));
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onConnectionState(str, UwbResultCode.GENERAL_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void establishSecurityLine(String str, String str2, byte[] bArr, int i, int i2) {
        LogUtil.v("IDMUwb", "establishSecurityLine: \nuwbAddress[" + str + "]\nkey[" + str2 + "]\nuidHash[" + Arrays.toString(bArr) + "]\nmemberType[" + i + "]\nappId[" + i2 + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "establishSecurityLine: service not available", new Object[0]);
            this.mCallback.onEstablishSecurityLine(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder newBuilder = MiCloseRange.UwbCommand.newBuilder();
        newBuilder.setCommandName("establishSecurityLine");
        newBuilder.setCommandBytes(ByteString.copyFrom(((UwbCommand.EstablishSecurityLine) UwbCommand.EstablishSecurityLine.newBuilder().setUwbAddress(str).setKey(str2).setUidHash(ByteString.copyFrom(bArr)).setMemberType(i).setAppId(i2).build()).toByteArray()));
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) newBuilder.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onEstablishSecurityLine(UwbResultCode.REMOTE_EXCEPTION);
        }
    }

    public Payload createPayload(UwbConst.AppId appId, byte[] bArr) {
        return new Payload(this.mAppId, appId.getId(), bArr);
    }

    public UwbData.TagInfo getTagInfo() {
        LogUtil.v("IDMUwb", "getTagInfo", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "getTagInfo: service not available", new Object[0]);
            return (UwbData.TagInfo) UwbData.TagInfo.newBuilder().build();
        }
        try {
            return UwbData.TagInfo.parseFrom(this.mCloseRangeService.command(((MiCloseRange.UwbCommand) MiCloseRange.UwbCommand.newBuilder().setCommandName("getTagInfo").build()).toByteArray()));
        } catch (RemoteException | InvalidProtocolBufferException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            return (UwbData.TagInfo) UwbData.TagInfo.newBuilder().build();
        }
    }

    public List<String> queryTagConnection() {
        LogUtil.v("IDMUwb", "queryTagConnection", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "getTagInfo: service not available", new Object[0]);
            return Collections.emptyList();
        }
        try {
            return UwbData.TagConnections.parseFrom(this.mCloseRangeService.command(((MiCloseRange.UwbCommand) MiCloseRange.UwbCommand.newBuilder().setCommandName("queryTagConnection").build()).toByteArray())).getUwbAddressList();
        } catch (RemoteException | InvalidProtocolBufferException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: protected */
    public void switchCommunicationType(int i, String str) {
        LogUtil.v("IDMUwb", "switchCommunicationType: \nappId[" + i + "]\nuwbAddress[" + str + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "switchCommunicationType: service not available", new Object[0]);
            this.mCallback.onSwitchCommunicationType(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE);
            return;
        }
        MiCloseRange.UwbCommand.Builder commandName = MiCloseRange.UwbCommand.newBuilder().setCommandName("switchCommunicationType");
        commandName.setCommandBytes(((UwbCommand.SwitchCommunicationType) UwbCommand.SwitchCommunicationType.newBuilder().setAppId(i).setUwbAddress(str).build()).toByteString());
        try {
            this.mCloseRangeService.asyncCommand(((MiCloseRange.UwbCommand) commandName.build()).toByteArray());
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onSwitchCommunicationType(UwbResultCode.GENERAL_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void tagOTA(String str, int i, byte[] bArr) {
        LogUtil.v("IDMUwb", "tagOTA:  address[" + str + "] taskId[" + i + "] dataLen[" + bArr.length + "]", new Object[0]);
        if (!serviceAvailable()) {
            LogUtil.e("IDMUwb", "tagOTA: service not available", new Object[0]);
            this.mCallback.onTagOTA(UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE, i);
            return;
        }
        try {
            this.mCloseRangeService.frameData(str, i, bArr);
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
            this.mCallback.onTagOTA(UwbResultCode.GENERAL_ERROR, i);
        }
    }

    public void deInit() {
        LogUtil.v("IDMUwb", "deInit", new Object[0]);
        try {
            if (serviceAvailable()) {
                this.mCloseRangeService.unRegisterCallback();
            }
            this.mAppId = -1;
            unBind();
        } catch (RemoteException e) {
            LogUtil.e("IDMUwb", e.getMessage(), e);
        }
    }

    private boolean serviceAvailable() {
        IMiCloseRange iMiCloseRange = this.mCloseRangeService;
        if (iMiCloseRange == null) {
            LogUtil.e("IDMUwb", "serviceAvailable: service is null", new Object[0]);
            return false;
        } else if (iMiCloseRange.asBinder().isBinderAlive()) {
            return true;
        } else {
            LogUtil.e("IDMUwb", "serviceAvailable: binder not alive", new Object[0]);
            return false;
        }
    }

    public static class Payload {
        public byte dstId;
        public byte[] payload;
        public byte srcId;

        private Payload(byte b, byte b2, byte[] bArr) {
            this.srcId = b;
            this.dstId = b2;
            this.payload = bArr;
        }

        public byte[] toBytes() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(this.srcId);
                byteArrayOutputStream.write(this.dstId);
                byteArrayOutputStream.write(this.payload);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                LogUtil.e("IDMUwb", e.getMessage(), e);
                return new byte[0];
            }
        }

        public static Payload fromBytes(byte[] bArr) {
            if (bArr.length < 2) {
                return null;
            }
            return new Payload(bArr[0], bArr[1], Arrays.copyOfRange(bArr, 2, bArr.length));
        }

        public byte getDstId() {
            return this.dstId;
        }

        public byte getSrcId() {
            return this.srcId;
        }

        public byte[] getPayload() {
            return this.payload;
        }

        public void setSrcId(byte b) {
            this.srcId = b;
        }

        public void setDstId(byte b) {
            this.dstId = b;
        }

        public void setPayload(byte[] bArr) {
            this.payload = bArr;
        }

        public boolean isValid() {
            return this.srcId >= 0 && this.dstId >= 0;
        }

        public String toString() {
            return Arrays.toString(toBytes());
        }
    }
}

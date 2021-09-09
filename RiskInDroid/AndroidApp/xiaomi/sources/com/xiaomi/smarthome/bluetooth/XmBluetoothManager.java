package com.xiaomi.smarthome.bluetooth;

import android.content.Context;
import android.os.Bundle;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.xiaomi.smarthome.bluetooth.Response;
import java.util.UUID;

public abstract class XmBluetoothManager {
    private static byte[] SECURITY_CHIP_BOLT_STATE = {2};
    private static byte[] SECURITY_CHIP_LOCK_STATE = {1};
    private static byte[] SECURITY_CHIP_UNLOCK_STATE = {0};
    protected static XmBluetoothManager instance;

    public interface BluetoothSearchResponse {
        void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice);

        void onSearchCanceled();

        void onSearchStarted();

        void onSearchStopped();
    }

    public abstract void bindDevice(String str);

    public abstract void bleMeshConnect(String str, String str2, Response.BleConnectResponse bleConnectResponse);

    public abstract void bleStandardAuthConnect(String str, Response.BleConnectResponse bleConnectResponse);

    public abstract void bleStandardAuthDecrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse);

    public abstract void bleStandardAuthEncrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse);

    public abstract void call(String str, int i, Bundle bundle, Response.BleCallResponse bleCallResponse);

    public abstract void cancelBleMeshUpgrade(String str);

    public abstract void connect(String str, Response.BleConnectResponse bleConnectResponse);

    @Deprecated
    public abstract void deviceRename(String str, String str2);

    public abstract void disconnect(String str);

    public abstract void disconnect(String str, long j);

    public abstract void disconnectFromRN(String str, long j);

    public abstract void getBleMeshFirmwareVersion(String str, Response.BleReadFirmwareVersionResponse bleReadFirmwareVersionResponse);

    public abstract void getBleStandardAuthFirmwareVersion(String str, Response.BleReadFirmwareVersionResponse bleReadFirmwareVersionResponse);

    public abstract void getBluetoothFirmwareVersion(String str, Response.BleReadFirmwareVersionResponse bleReadFirmwareVersionResponse);

    public abstract String getBluetoothGatewayDevices();

    public abstract int getConnectStatus(String str);

    public abstract void getOneTimePassword(String str, int i, int i2, Response.BleResponseV2<int[]> bleResponseV2);

    public abstract void getOneTimePasswordWithDelayTime(String str, int i, int i2, long j, Response.BleResponseV2<int[]> bleResponseV2);

    public abstract String getTokenMd5(String str);

    public abstract void indication(String str, UUID uuid, UUID uuid2, Response.BleNotifyResponse bleNotifyResponse);

    @Deprecated
    public abstract boolean isAutoReconnect(String str);

    public abstract void isBleCharacterExist(String str, UUID uuid, UUID uuid2, Response.BleResponse<Void> bleResponse);

    public abstract void isBleGatewayConnected(String str, Response.BleResponse<Void> bleResponse);

    public abstract void isBleGatewayExistInDeviceList(Response.BleResponse<Bundle> bleResponse);

    public abstract boolean isBluetoothOpen();

    public abstract boolean isSecurityChipSharedKeyValid(String str);

    public abstract void miotBleDecrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse);

    public abstract byte[] miotBleDecryptSync(String str, byte[] bArr);

    public abstract void miotBleEncrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse);

    public abstract byte[] miotBleEncryptSync(String str, byte[] bArr);

    public abstract void notify(String str, UUID uuid, UUID uuid2, Response.BleNotifyResponse bleNotifyResponse);

    public abstract void openBluetooth(Context context);

    public abstract void openBluetoothSilently();

    public abstract void read(String str, UUID uuid, UUID uuid2, Response.BleReadResponse bleReadResponse);

    public abstract void readRemoteRssi(String str, Response.BleReadRssiResponse bleReadRssiResponse);

    @Deprecated
    public abstract void refreshDeviceStatus(String str, long j, Response.BleDeviceStatusResponse bleDeviceStatusResponse);

    public abstract void registerBlockListener(String str, Response.BleReadResponse bleReadResponse);

    public abstract void registerCharacterChanged(String str, UUID uuid, UUID uuid2, Response.BleWriteResponse bleWriteResponse);

    public abstract void registerMediaButtonReceiver(String str);

    public abstract void removeToken(String str);

    public abstract void secureConnect(String str, Response.BleConnectResponse bleConnectResponse);

    public abstract void securityChipConnect(String str, Response.BleConnectResponse bleConnectResponse);

    public abstract void securityChipDecrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse);

    public abstract void securityChipEncrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse);

    public abstract void securityChipOperate(String str, int i, Response.BleReadResponse bleReadResponse);

    public abstract void securityChipSharedDeviceConnect(String str, Response.BleConnectResponse bleConnectResponse);

    public abstract boolean setAlertConfigs(String str, int i, boolean z);

    @Deprecated
    public abstract boolean setAutoReconnect(String str, boolean z);

    public abstract void startBleMeshUpgrade(String str, String str2, String str3, String str4, Response.BleUpgradeResponse bleUpgradeResponse);

    public abstract void startLeScan(int i, UUID[] uuidArr, BluetoothSearchResponse bluetoothSearchResponse);

    public abstract void startMcuUpgrade(String str, String str2, String str3, boolean z, String str4, int i, Response.BleUpgradeResponse bleUpgradeResponse);

    public abstract void startScan(int i, int i2, BluetoothSearchResponse bluetoothSearchResponse);

    public abstract void stopScan();

    public abstract void unBindDevice(String str);

    public abstract void unRegisterMediaButtonReceiver(String str);

    public abstract void unindication(String str, UUID uuid, UUID uuid2);

    public abstract void unnotify(String str, UUID uuid, UUID uuid2);

    public abstract void unregisterBlockListener(String str);

    public abstract void unregisterCharacterChanged(String str, UUID uuid, UUID uuid2);

    public abstract void write(String str, UUID uuid, UUID uuid2, byte[] bArr, Response.BleWriteResponse bleWriteResponse);

    public abstract void writeBlock(String str, byte[] bArr, Response.BleWriteResponse bleWriteResponse);

    public abstract void writeNoRsp(String str, UUID uuid, UUID uuid2, byte[] bArr, Response.BleWriteResponse bleWriteResponse);

    public static XmBluetoothManager getInstance() {
        return instance;
    }

    public static class Code {
        public static String toString(int i) {
            switch (i) {
                case -55:
                    return "REQUEST_NOTIFY_TIMEDOUT";
                case -54:
                    return "REQUEST_STANDARD_AUTH_TOKEN_IS_EMPTY";
                case -53:
                    return "REQUEST_STANDARD_AUTH_ERR_RELOGIN";
                case -52:
                    return "REQUEST_STANDARD_AUTH_LOGIN_FAILED";
                case -51:
                    return "REQUEST_STANDARD_AUTH_REGISTER_FAILED";
                case -50:
                    return "REQUEST_STANDARD_AUTH_GET_QR_OOB_FAILED";
                case -49:
                    return "REQUEST_STANDARD_AUTH_OOB_FAILED";
                case -48:
                    return "REQUEST_STANDARD_AUTH_GET_APP_CONFIRM_FAILED";
                case -47:
                    return "REQUEST_STANDARD_AUTH_GET_DEVICE_INFO_FAILED";
                case -46:
                    return "REQUEST_SC_REGISTER_GET_BIND_KEY_FAILED";
                case -45:
                    return "REQUEST_MESH_SEND_SERVER_RESULT_FAILED";
                case -44:
                    return "REQUEST_MESH_PROVISION_INFO_FAILED";
                case -43:
                    return "REQUEST_MESH_REG_DEVICE_VERIFY_PUB_FAILED";
                case -42:
                    return "REQUEST_MESH_REG_DEVICE_VERIFY_SIGN_FAILED";
                case -41:
                    return "REQUEST_MESH_REG_DEVICE_VERIFY_CERT_FAILED";
                case -40:
                    return "REQUEST_MESH_REG_SERVER_VERIFY_SIGN_FAILED";
                case -39:
                    return "REQUEST_MESH_REG_SERVER_VERIFY_CERT_FAILED";
                case -38:
                    return "REQUEST_PINCODE_IS_EMPTY";
                case -37:
                    return "REQUEST_SC_REGISTER_UNSUPPORT_VERSION";
                case -36:
                    return "REQUEST_SC_REGISTER_GET_VERSION_FAILED";
                case -35:
                    return "REQUEST_SC_REGISTER_PAIR_CODE_EXPIRED";
                case -34:
                    return "REQUEST_SC_REGISTER_PAIR_CODE_FAILED";
                case -33:
                    return "REQUEST_SC_REGISTER_INPUT_PAIR_CODE";
                case -32:
                    return "REQUEST_STATUS_DISCONNECTED";
                case -31:
                    return "REQUEST_TOKEN_VERIFY_FAILED";
                case -30:
                    return "REQUEST_BIND_DID_FAILED";
                case -29:
                    return "REQUEST_GET_DID_FAILED";
                case -28:
                    return "REQUEST_WRITE_FAILED";
                case -27:
                    return "REQUEST_NOTIFY_FAILED";
                case -26:
                    return "REQUEST_SC_BIND_LTMK_FAILED";
                case -25:
                    return "REQUEST_SC_SHARED_LOGIN_KEY_ID_EMPTY";
                case -24:
                    return "REQUEST_SC_SHARED_LOGIN_FAILED";
                case -23:
                    return "REQUEST_SC_SHARED_LOGIN_ENCRYPT_DATA_FAILED";
                case -22:
                    return "REQUEST_SC_LOGIN_FAILED";
                case -21:
                    return "REQUEST_SC_LOGIN_ENCRYPT_DATA_FAILED";
                case -20:
                    return "REQUEST_SC_REGISTER_FAILED";
                case -19:
                    return "REQUEST_SC_SHARED_KEY_FAILED";
                case -18:
                    return "REQUEST_SHARED_KEY_EXPIRED";
                case -17:
                    return "REQUEST_REGISTERED";
                case -16:
                    return "REQUEST_NOT_REGISTERED";
                case -15:
                    return "REQUEST_EXCEPTION";
                case -14:
                    return "REQUEST_DENIED";
                case -13:
                    return "REQUEST_ONGOING";
                case -12:
                    return "CONFIG_UNREADY";
                case -11:
                    return "REQUEST_OVERFLOW";
                case -10:
                    return "TOKEN_NOT_MATCHED";
                case SplitInstallErrorCode.SERVICE_DIED:
                default:
                    return "unknown code: ".concat(String.valueOf(i));
                case -8:
                    return "REQUEST_NOT_CONNECTED";
                case -7:
                    return "REQUEST_TIMEDOUT";
                case -6:
                    return "CONNECTION_NOT_READY";
                case -5:
                    return "BLUETOOTH_DISABLED";
                case -4:
                    return "BLE_NOT_SUPPORTED";
                case -3:
                    return "ILLEGAL_ARGUMENT";
                case -2:
                    return "REQUEST_CANCELED";
                case -1:
                    return "REQUEST_FAILED";
                case 0:
                    return "REQUEST_SUCCESS";
            }
        }
    }
}

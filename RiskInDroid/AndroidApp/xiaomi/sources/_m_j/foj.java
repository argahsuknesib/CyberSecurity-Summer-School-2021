package _m_j;

import _m_j.glc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$1;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$10;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$11;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$12;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$13;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$15;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$16;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$17;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$18;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$19;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$2;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$20;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$21;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$22;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$23;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$24;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$25;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$26;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$27;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$28;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$29;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$3;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$30;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$31;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$32;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$33;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$34;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$35;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$4;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$5;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$6;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$8;
import com.xiaomi.smarthome.device.bluetooth.BluetoothManager$9;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginBluetoothManagerHostApi;
import java.util.UUID;

public final class foj extends PluginBluetoothManagerHostApi {

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f16763O000000o = new Handler(Looper.getMainLooper());

    public final boolean isAutoReconnect(String str) {
        return false;
    }

    public final boolean setAutoReconnect(String str, boolean z) {
        return false;
    }

    public final void read(String str, UUID uuid, UUID uuid2, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        CoreApi.O000000o().O000000o(str, 3, bundle, new BluetoothManager$2(this, str, uuid, uuid2, bleReadResponse));
    }

    public final void O000000o(String str, int i, String str2, UUID uuid, UUID uuid2) {
        String str3;
        String O000000o2 = O000000o(str);
        if (!TextUtils.isEmpty(O000000o2)) {
            int connectStatus = getConnectStatus(str);
            if (i == 0) {
                hxi.O0000Oo.O000000o(O000000o2, str2, str);
            } else if (2 == connectStatus) {
                hxt hxt = hxi.O0000Oo;
                if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o && !flu.O00000oO().O00000o0(O000000o2)) {
                    String O000000o3 = hxt.O000000o();
                    String str4 = "";
                    if (uuid == null) {
                        str3 = str4;
                    } else {
                        str3 = uuid.toString();
                    }
                    if (uuid2 != null) {
                        str4 = uuid2.toString();
                    }
                    String O000000o4 = hxy.O000000o(str);
                    hxt.f960O000000o.O000000o("add_bluetooth_fail", "model", O000000o2, "type", str2, "failcode", Integer.valueOf(i), "uid", O000000o3, "service", str3, "character", str4, "mac", O000000o4);
                }
            }
        }
    }

    public static String O000000o(String str) {
        BleDevice O00000o0;
        String modelByMacFromRnruntime = DeviceRouterFactory.getDeviceProviderImp().getModelByMacFromRnruntime();
        return (!TextUtils.isEmpty(modelByMacFromRnruntime) || (O00000o0 = fob.O00000o0(str)) == null) ? modelByMacFromRnruntime : O00000o0.model;
    }

    public final void write(String str, UUID uuid, UUID uuid2, byte[] bArr, Response.BleWriteResponse bleWriteResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 4, bundle, new BluetoothManager$3(this, bleWriteResponse, str, uuid, uuid2));
    }

    public final void notify(String str, UUID uuid, UUID uuid2, Response.BleNotifyResponse bleNotifyResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        CoreApi.O000000o().O000000o(str, 6, bundle, new BluetoothManager$4(this, bleNotifyResponse));
    }

    public final void unnotify(String str, UUID uuid, UUID uuid2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        CoreApi.O000000o().O000000o(str, 7, bundle, (IBleResponse) null);
    }

    public final void indication(String str, UUID uuid, UUID uuid2, Response.BleNotifyResponse bleNotifyResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        CoreApi.O000000o().O000000o(str, 15, bundle, new BluetoothManager$5(this, bleNotifyResponse));
    }

    public final void unindication(String str, UUID uuid, UUID uuid2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        CoreApi.O000000o().O000000o(str, 16, bundle, (IBleResponse) null);
    }

    public final void readRemoteRssi(String str, Response.BleReadRssiResponse bleReadRssiResponse) {
        CoreApi.O000000o().O000000o(str, 10, (Bundle) null, new BluetoothManager$6(this, bleReadRssiResponse));
    }

    public final void openBluetoothSilently() {
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.foj.AnonymousClass2 */

            public final void run() {
                gnl.O0000O0o();
            }
        });
    }

    public final boolean isBluetoothOpen() {
        return gnl.O00000Oo();
    }

    public final void deviceRename(String str, String str2) {
        DeviceRouterFactory.getDeviceProviderImp().deviceRename(str, str2);
    }

    public final void bindDevice(String str) {
        CoreApi.O000000o().O000000o(str, 33, (Bundle) null, (IBleResponse) null);
    }

    public final void unBindDevice(String str) {
        CoreApi.O000000o().O000000o(str, 34, (Bundle) null, (IBleResponse) null);
    }

    public final void secureConnect(String str, Response.BleConnectResponse bleConnectResponse) {
        DeviceRouterFactory.getDeviceProviderImp().secureConnect(str, new BluetoothManager$8(this, bleConnectResponse));
    }

    public final void call(String str, int i, Bundle bundle, Response.BleCallResponse bleCallResponse) {
        DeviceRouterFactory.getDeviceProviderImp().callBleApi(str, i, bundle, new BluetoothManager$9(this, bleCallResponse));
    }

    public final void disconnect(String str, long j) {
        fte.O00000Oo("disconnect " + fte.O000000o(str) + ", " + j);
        Bundle bundle = new Bundle();
        bundle.putLong("extra.delay", j);
        CoreApi.O000000o().O000000o(str, 2, bundle, (IBleResponse) null);
    }

    public final void disconnect(String str) {
        CoreApi.O000000o().O000000o(str, 2, new Bundle(), (IBleResponse) null);
    }

    public final void disconnectFromRN(String str, long j) {
        Bundle bundle = new Bundle();
        if (j > 0) {
            bundle.putLong("extra.delay", j);
        }
        bundle.putBoolean("extra.from.RN", true);
        CoreApi.O000000o().O000000o(str, 2, bundle, (IBleResponse) null);
    }

    public final void refreshDeviceStatus(String str, long j, Response.BleDeviceStatusResponse bleDeviceStatusResponse) {
        if (!TextUtils.isEmpty(str) && bleDeviceStatusResponse != null) {
            Bundle bundle = new Bundle();
            bundle.putLong("extra.duration", j);
            CoreApi.O000000o().O000000o(str, 35, bundle, new BluetoothManager$10(this, str, bleDeviceStatusResponse));
        }
    }

    public final void startScan(int i, int i2, XmBluetoothManager.BluetoothSearchResponse bluetoothSearchResponse) {
        if (i > 0 && bluetoothSearchResponse != null) {
            gsy.O000000o(4, "startScan", "BM startScan");
            SearchRequest.O000000o o000000o = new SearchRequest.O000000o();
            if (i2 == 1) {
                o000000o.O000000o(i, (UUID[]) null);
            } else if (i2 == 0) {
                o000000o.O000000o(i);
            } else {
                return;
            }
            CoreApi.O000000o().O000000o(o000000o.O000000o(), new BluetoothManager$11(this, bluetoothSearchResponse));
        }
    }

    public final void stopScan() {
        gsy.O000000o(4, "stopScan", "BM stop");
        CoreApi.O000000o().O000O0o();
    }

    public final void registerMediaButtonReceiver(String str) {
        DeviceRouterFactory.getDeviceProviderImp().registerMediaButtonReceiver(str);
    }

    public static String O000000o() {
        return DeviceRouterFactory.getDeviceProviderImp().getMediaButtonModel();
    }

    public final void unRegisterMediaButtonReceiver(String str) {
        DeviceRouterFactory.getDeviceProviderImp().unRegisterMediaButtonReceiver(str);
    }

    public final void removeToken(String str) {
        if (!TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("removeToken for %s", fte.O000000o(str)));
            call(str, 1, null, null);
        }
    }

    public final void writeNoRsp(String str, UUID uuid, UUID uuid2, byte[] bArr, Response.BleWriteResponse bleWriteResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 5, bundle, new BluetoothManager$12(this, bleWriteResponse));
    }

    public final void startLeScan(int i, UUID[] uuidArr, XmBluetoothManager.BluetoothSearchResponse bluetoothSearchResponse) {
        if (i > 0 && bluetoothSearchResponse != null) {
            gsy.O000000o(4, "startScan", "BM startLeScan");
            SearchRequest.O000000o o000000o = new SearchRequest.O000000o();
            o000000o.O000000o(i, uuidArr);
            CoreApi.O000000o().O000000o(o000000o.O000000o(), new BluetoothManager$13(this, bluetoothSearchResponse));
        }
    }

    public final void getBluetoothFirmwareVersion(final String str, final Response.BleReadFirmwareVersionResponse bleReadFirmwareVersionResponse) {
        if (bleReadFirmwareVersionResponse != null && !TextUtils.isEmpty(str)) {
            XmBluetoothManager.getInstance().read(str, glb.f17954O000000o, glb.O00000oO, new Response.BleReadResponse() {
                /* class _m_j.foj.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    byte[] bArr = (byte[]) obj;
                    if (i != 0 || got.O00000o(bArr)) {
                        bleReadFirmwareVersionResponse.onResponse(-1, "");
                        return;
                    }
                    bleReadFirmwareVersionResponse.onResponse(0, new String(got.O0000OOo(BLECipher.O000000o(foc.O0000OoO(str), bArr))));
                }
            });
        }
    }

    public final boolean setAlertConfigs(String str, int i, boolean z) {
        return CoreApi.O000000o().O000000o(str, i, z);
    }

    public final void writeBlock(String str, byte[] bArr, Response.BleWriteResponse bleWriteResponse) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 11, bundle, new BluetoothManager$15(this, bleWriteResponse));
    }

    public final void registerBlockListener(String str, Response.BleReadResponse bleReadResponse) {
        CoreApi.O000000o().O000000o(str, 12, (Bundle) null, new BluetoothManager$16(this, bleReadResponse));
    }

    public final void unregisterBlockListener(String str) {
        CoreApi.O000000o().O000000o(str, 13, (Bundle) null, (IBleResponse) null);
    }

    public final void securityChipConnect(String str, Response.BleConnectResponse bleConnectResponse) {
        DeviceRouterFactory.getDeviceProviderImp().securityChipConnect(str, new BluetoothManager$17(this, bleConnectResponse));
    }

    public final void securityChipEncrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 43, bundle, new BluetoothManager$18(this, bleReadResponse));
    }

    public final void securityChipDecrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 44, bundle, new BluetoothManager$19(this, bleReadResponse));
    }

    public final void securityChipSharedDeviceConnect(String str, Response.BleConnectResponse bleConnectResponse) {
        DeviceRouterFactory.getDeviceProviderImp().securityChipSharedDeviceConnect(str, new BluetoothManager$20(this, bleConnectResponse));
    }

    public final void isBleGatewayConnected(String str, Response.BleResponse<Void> bleResponse) {
        CoreApi.O000000o().O000000o(str, 46, (Bundle) null, new BluetoothManager$21(this, bleResponse));
    }

    public final void registerCharacterChanged(String str, UUID uuid, UUID uuid2, Response.BleWriteResponse bleWriteResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        CoreApi.O000000o().O000000o(str, 41, bundle, new BluetoothManager$22(this, bleWriteResponse));
    }

    public final void unregisterCharacterChanged(String str, UUID uuid, UUID uuid2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.service.uuid", uuid);
        bundle.putSerializable("extra.character.uuid", uuid2);
        CoreApi.O000000o().O000000o(str, 42, bundle, (IBleResponse) null);
    }

    public final boolean isSecurityChipSharedKeyValid(String str) {
        String O0000o0o = foc.O0000o0o(str);
        if (!TextUtils.isEmpty(O0000o0o) && !TextUtils.equals(O0000o0o, "-17973521")) {
            return true;
        }
        fte.O00000Oo("isSecurityChipSharedKeyValid = inValid(" + O0000o0o + ")");
        return false;
    }

    public final void securityChipOperate(String str, int i, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra.value", i);
        CoreApi.O000000o().O000000o(str, 45, bundle, new BluetoothManager$23(this, bleReadResponse));
    }

    public final String getTokenMd5(String str) {
        String O0000Oo = foc.O0000Oo(str);
        if (TextUtils.isEmpty(O0000Oo)) {
            return "";
        }
        return grv.O000000o(O0000Oo);
    }

    public final void getOneTimePassword(String str, int i, int i2, Response.BleResponseV2<int[]> bleResponseV2) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra.interval", i);
        bundle.putInt("extra.digits", i2);
        CoreApi.O000000o().O000000o(str, 47, bundle, new BluetoothManager$24(this, bleResponseV2));
    }

    public final void getOneTimePasswordWithDelayTime(String str, int i, int i2, long j, Response.BleResponseV2<int[]> bleResponseV2) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra.interval", i);
        bundle.putInt("extra.digits", i2);
        bundle.putLong("extra.utcdelaytime", j);
        CoreApi.O000000o().O000000o(str, 47, bundle, new BluetoothManager$25(this, bleResponseV2));
    }

    public final void isBleGatewayExistInDeviceList(Response.BleResponse<Bundle> bleResponse) {
        DeviceRouterFactory.getDeviceProviderImp().isBleGatewayExistInDeviceList(new BluetoothManager$26(this, bleResponse));
    }

    public final void bleMeshConnect(String str, String str2, Response.BleConnectResponse bleConnectResponse) {
        DeviceRouterFactory.getDeviceProviderImp().bleMeshConnect(str, str2, new BluetoothManager$27(this, bleConnectResponse));
    }

    public final void startBleMeshUpgrade(String str, String str2, String str3, String str4, Response.BleUpgradeResponse bleUpgradeResponse) {
        CoreApi O000000o2 = CoreApi.O000000o();
        try {
            O000000o2.O00000Oo().startBleMeshUpgrade(str, str2, str3, str4, new IBleMeshUpgradeResponse.Stub(bleUpgradeResponse) {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass63 */
                final /* synthetic */ Response.BleUpgradeResponse val$response;

                {
                    this.val$response = r2;
                }

                public void onProgress(final int i) {
                    if (this.val$response != null) {
                        glc.O000000o(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass63.AnonymousClass1 */

                            public final void run() {
                                AnonymousClass63.this.val$response.onProgress(i);
                            }
                        }, 0);
                    }
                }

                public void onResponse(final int i, final String str) {
                    if (this.val$response != null) {
                        glc.O000000o(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass63.AnonymousClass2 */

                            public final void run() {
                                AnonymousClass63.this.val$response.onResponse(i, str);
                            }
                        }, 0);
                    }
                }

                public boolean isMeshDevice() {
                    Response.BleUpgradeResponse bleUpgradeResponse = this.val$response;
                    if (bleUpgradeResponse != null) {
                        return bleUpgradeResponse.isMeshDevice();
                    }
                    return false;
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void startMcuUpgrade(String str, String str2, String str3, boolean z, String str4, int i, Response.BleUpgradeResponse bleUpgradeResponse) {
        CoreApi O000000o2 = CoreApi.O000000o();
        try {
            O000000o2.O00000Oo().startMcuUpgrade(str, str2, str3, z, str4, i, new IBleMeshUpgradeResponse.Stub(bleUpgradeResponse) {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass64 */
                final /* synthetic */ Response.BleUpgradeResponse val$response;

                {
                    this.val$response = r2;
                }

                public void onProgress(final int i) {
                    if (this.val$response != null) {
                        glc.O000000o(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass64.AnonymousClass1 */

                            public final void run() {
                                AnonymousClass64.this.val$response.onProgress(i);
                            }
                        }, 0);
                    }
                }

                public void onResponse(final int i, final String str) {
                    if (this.val$response != null) {
                        glc.O000000o(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass64.AnonymousClass2 */

                            public final void run() {
                                AnonymousClass64.this.val$response.onResponse(i, str);
                            }
                        }, 0);
                    }
                }

                public boolean isMeshDevice() {
                    Response.BleUpgradeResponse bleUpgradeResponse = this.val$response;
                    if (bleUpgradeResponse != null) {
                        return bleUpgradeResponse.isMeshDevice();
                    }
                    return false;
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void cancelBleMeshUpgrade(String str) {
        try {
            CoreApi.O000000o().O00000Oo().cancelBleMeshUpgrade(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public final void getBleMeshFirmwareVersion(String str, Response.BleReadFirmwareVersionResponse bleReadFirmwareVersionResponse) {
        if (bleReadFirmwareVersionResponse != null && !TextUtils.isEmpty(str)) {
            CoreApi.O000000o().O000000o(str, 48, new Bundle(), new BluetoothManager$28(this, bleReadFirmwareVersionResponse));
        }
    }

    public final void miotBleEncrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 49, bundle, new BluetoothManager$29(this, bleReadResponse));
    }

    public final void miotBleDecrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 50, bundle, new BluetoothManager$30(this, bleReadResponse));
    }

    public final void bleStandardAuthConnect(String str, Response.BleConnectResponse bleConnectResponse) {
        DeviceRouterFactory.getDeviceProviderImp().bleStandardAuthConnect(str, new BluetoothManager$31(this, bleConnectResponse));
    }

    public final void getBleStandardAuthFirmwareVersion(String str, Response.BleReadFirmwareVersionResponse bleReadFirmwareVersionResponse) {
        if (bleReadFirmwareVersionResponse != null && !TextUtils.isEmpty(str)) {
            CoreApi.O000000o().O000000o(str, 53, new Bundle(), new BluetoothManager$32(this, bleReadFirmwareVersionResponse));
        }
    }

    public final void bleStandardAuthEncrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 43, bundle, new BluetoothManager$33(this, bleReadResponse));
    }

    public final void bleStandardAuthDecrypt(String str, byte[] bArr, Response.BleReadResponse bleReadResponse) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("extra.byte.array", bArr);
        CoreApi.O000000o().O000000o(str, 44, bundle, new BluetoothManager$34(this, bleReadResponse));
    }

    public final void isBleCharacterExist(String str, UUID uuid, UUID uuid2, Response.BleResponse<Void> bleResponse) {
        if (getConnectStatus(str) == 2) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra.service.uuid", uuid);
            bundle.putSerializable("extra.character.uuid", uuid2);
            CoreApi.O000000o().O000000o(str, 54, bundle, new BluetoothManager$35(this, bleResponse));
        } else if (bleResponse != null) {
            bleResponse.onResponse(-8, null);
        }
    }

    public final byte[] miotBleEncryptSync(String str, byte[] bArr) {
        return CoreApi.O000000o().O000000o(str, bArr);
    }

    public final byte[] miotBleDecryptSync(String str, byte[] bArr) {
        return CoreApi.O000000o().O00000Oo(str, bArr);
    }

    public final String getBluetoothGatewayDevices() {
        return CoreApi.O000000o().O000O0oO();
    }

    public final void connect(String str, Response.BleConnectResponse bleConnectResponse) {
        if (!TextUtils.isEmpty(str)) {
            CoreApi.O000000o().O000000o(str, 1, new Bundle(), new BluetoothManager$1(this, bleConnectResponse));
        }
    }

    public final void openBluetooth(Context context) {
        if (context != null && (context instanceof Activity) && !gnl.O00000Oo()) {
            ((Activity) context).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 16);
        }
    }

    public final int getConnectStatus(String str) {
        if (TextUtils.isEmpty(str) || !gnl.O000000o()) {
            return -1;
        }
        return gnl.O00000o0().getConnectionState(gnl.O00000Oo(str), 7);
    }
}

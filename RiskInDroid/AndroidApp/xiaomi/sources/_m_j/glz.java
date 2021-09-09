package _m_j;

import _m_j.fap;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectWorker;
import com.xiaomi.smarthome.library.bluetooth.connect.IBluetoothGattResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.RuntimeChecker;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.GattResponseListener;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.ReadCharacterListener;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.ReadRssiListener;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.RequestMtuListener;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.ServiceDiscoverListener;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.WriteCharacterListener;
import com.xiaomi.smarthome.library.bluetooth.connect.listener.WriteDescriptorListener;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public final class glz implements gmu, Handler.Callback, IBleConnectWorker, IBluetoothGattResponse, RuntimeChecker {
    private static final boolean O00000Oo = (!glc.O0000OOo);

    /* renamed from: O000000o  reason: collision with root package name */
    public GattResponseListener f18007O000000o;
    private BluetoothDevice O00000o;
    private BluetoothGatt O00000o0;
    private Handler O00000oO;
    private volatile int O00000oo;
    private BleGattProfile O0000O0o;
    private Map<UUID, Map<UUID, BluetoothGattCharacteristic>> O0000OOo;
    private RuntimeChecker O0000Oo;
    private IBluetoothGattResponse O0000Oo0;
    private final Object O0000OoO = new Object();

    public glz(String str, RuntimeChecker runtimeChecker) {
        BluetoothAdapter O00000o2 = gnl.O00000o();
        if (O00000o2 != null) {
            this.O00000o = O00000o2.getRemoteDevice(str);
            this.O0000Oo = runtimeChecker;
            this.O00000oO = new Handler(Looper.myLooper(), this);
            this.O0000OOo = new HashMap();
            this.O0000Oo0 = (IBluetoothGattResponse) gmw.O000000o(this, IBluetoothGattResponse.class, this, false);
            return;
        }
        throw new IllegalStateException("ble adapter null");
    }

    private BluetoothGattCharacteristic O000000o(UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        BluetoothGattService service;
        Map map;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (uuid == null || uuid2 == null || (map = this.O0000OOo.get(uuid)) == null) ? null : (BluetoothGattCharacteristic) map.get(uuid2);
        return (bluetoothGattCharacteristic != null || (bluetoothGatt = this.O00000o0) == null || (service = bluetoothGatt.getService(uuid)) == null) ? bluetoothGattCharacteristic : service.getCharacteristic(uuid2);
    }

    public final void O000000o(int i) {
        if (O00000Oo) {
            gnk.O00000o0(String.format("setConnectStatus status = %s", gld.O000000o(i)));
        }
        this.O00000oo = i;
    }

    public final void onConnectionStateChange(int i, int i2) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onConnectionStateChange for %s: status = %d, newState = %d", this.O00000o.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)));
        } else {
            fte.O00000Oo(String.format("onConnectionStateChange status=%d, newState=%d", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (i == 0 && i2 == 2) {
            O000000o(2);
            if (this.O00000o.getBondState() == 12) {
                fte.O00000Oo("Waiting 1600 ms for a possible Service Changed indication...");
                synchronized (this.O0000OoO) {
                    try {
                        this.O0000OoO.wait(1600);
                    } catch (InterruptedException unused) {
                        gnk.O00000o("Sleeping interrupted");
                    }
                }
            }
            GattResponseListener gattResponseListener = this.f18007O000000o;
            if (gattResponseListener != null) {
                gattResponseListener.onConnectStatusChanged(true);
                return;
            }
            return;
        }
        O000000o();
    }

    public final void onServicesDiscovered(int i) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onServicesDiscovered for %s: status = %d", this.O00000o.getAddress(), Integer.valueOf(i)));
        }
        if (i == 0) {
            O000000o(19);
            O00000Oo(16);
            if (O00000Oo) {
                gnk.O00000o0(String.format("refreshServiceProfile for %s", this.O00000o.getAddress()));
            }
            BluetoothGatt bluetoothGatt = this.O00000o0;
            if (bluetoothGatt != null) {
                List<BluetoothGattService> services = bluetoothGatt.getServices();
                HashMap hashMap = new HashMap();
                for (BluetoothGattService next : services) {
                    UUID uuid = next.getUuid();
                    Map map = (Map) hashMap.get(uuid);
                    if (map == null) {
                        if (O00000Oo) {
                            gnk.O00000o0("Service: ".concat(String.valueOf(uuid)));
                        }
                        map = new HashMap();
                        hashMap.put(next.getUuid(), map);
                    }
                    for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                        UUID uuid2 = next2.getUuid();
                        if (O00000Oo) {
                            gnk.O00000o0("character: uuid = ".concat(String.valueOf(uuid2)));
                        }
                        map.put(next2.getUuid(), next2);
                    }
                }
                this.O0000OOo.clear();
                this.O0000OOo.putAll(hashMap);
                this.O0000O0o = new BleGattProfile(this.O0000OOo);
            } else if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
        }
        GattResponseListener gattResponseListener = this.f18007O000000o;
        if (gattResponseListener != null && (gattResponseListener instanceof ServiceDiscoverListener)) {
            ((ServiceDiscoverListener) gattResponseListener).onServicesDiscovered(i, this.O0000O0o);
        }
    }

    public final void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onCharacteristicRead for %s: status = %d, service = 0x%s, character = 0x%s, value = %s", this.O00000o.getAddress(), Integer.valueOf(i), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), got.O00000o0(bArr)));
        }
        GattResponseListener gattResponseListener = this.f18007O000000o;
        if (gattResponseListener != null && (gattResponseListener instanceof ReadCharacterListener)) {
            ((ReadCharacterListener) gattResponseListener).onCharacteristicRead(bluetoothGattCharacteristic, i, bArr);
        }
    }

    public final void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onCharacteristicWrite for %s: status = %d, service = 0x%s, character = 0x%s, value = %s", this.O00000o.getAddress(), Integer.valueOf(i), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), got.O00000o0(bArr)));
        }
        GattResponseListener gattResponseListener = this.f18007O000000o;
        if (gattResponseListener != null && (gattResponseListener instanceof WriteCharacterListener)) {
            ((WriteCharacterListener) gattResponseListener).onCharacteristicWrite(bluetoothGattCharacteristic, i, bArr);
        }
        UUID uuid = bluetoothGattCharacteristic.getService().getUuid();
        UUID uuid2 = bluetoothGattCharacteristic.getUuid();
        Intent intent = new Intent("com.xiaomi.smarthome.bluetooth.character_write");
        intent.putExtra("key_device_address", this.O00000o.getAddress());
        intent.putExtra("key_service_uuid", uuid);
        intent.putExtra("key_character_uuid", uuid2);
        intent.putExtra("key_character_value", bArr);
        intent.putExtra("key_character_write_status", i);
        glc.O0000O0o.sendBroadcast(intent);
    }

    public final void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onCharacteristicChanged for %s: value = %s, service = 0x%s, character = 0x%s", this.O00000o.getAddress(), got.O00000o0(bArr), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid()));
        }
        UUID uuid = bluetoothGattCharacteristic.getService().getUuid();
        UUID uuid2 = bluetoothGattCharacteristic.getUuid();
        Intent intent = new Intent("com.xiaomi.smarthome.bluetooth.character_changed");
        intent.putExtra("key_device_address", this.O00000o.getAddress());
        intent.putExtra("key_service_uuid", uuid);
        intent.putExtra("key_character_uuid", uuid2);
        intent.putExtra("key_character_value", bArr);
        glc.O0000O0o.sendBroadcast(intent);
    }

    public final void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onDescriptorWrite for %s: status = %d, service = 0x%s, character = 0x%s, descriptor = 0x%s", this.O00000o.getAddress(), Integer.valueOf(i), bluetoothGattDescriptor.getCharacteristic().getService().getUuid(), bluetoothGattDescriptor.getCharacteristic().getUuid(), bluetoothGattDescriptor.getUuid()));
        }
        GattResponseListener gattResponseListener = this.f18007O000000o;
        if (gattResponseListener != null && (gattResponseListener instanceof WriteDescriptorListener)) {
            ((WriteDescriptorListener) gattResponseListener).onDescriptorWrite(bluetoothGattDescriptor, i);
        }
    }

    public final void onReadRemoteRssi(int i, int i2) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onReadRemoteRssi for %s, rssi = %d, status = %d", this.O00000o.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        GattResponseListener gattResponseListener = this.f18007O000000o;
        if (gattResponseListener != null && (gattResponseListener instanceof ReadRssiListener)) {
            ((ReadRssiListener) gattResponseListener).onReadRemoteRssi(i, i2);
        }
    }

    public final void onMtuChanged(int i, int i2) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("onMtuChanged for %s, mtu = %d, status = %d", this.O00000o.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        GattResponseListener gattResponseListener = this.f18007O000000o;
        if (gattResponseListener != null && (gattResponseListener instanceof RequestMtuListener)) {
            ((RequestMtuListener) gattResponseListener).onMtuChanged(i, i2);
        }
    }

    public final void O00000Oo(int i) {
        if (O00000Oo) {
            gnk.O00000o0(String.format("broadcastConnectStatus status = %s", Integer.valueOf(i)));
        }
        if (i == 32) {
            fap.O000000o.f16027O000000o.O000000o(this.O00000o.getAddress()).O000000o();
        }
        Intent intent = new Intent("com.xiaomi.smarthome.bluetooth.connect_status_changed");
        intent.putExtra("key_device_address", this.O00000o.getAddress());
        intent.putExtra("key_connect_status", i);
        glc.O0000O0o.sendBroadcast(intent);
    }

    public final boolean openGatt() {
        checkRuntime();
        fte.O00000Oo("start openGatt for connect ble device");
        if (O00000Oo) {
            gnk.O00000o0(String.format("openGatt for %s", this.O00000o.getAddress()));
        }
        if (this.O00000o0 != null) {
            fte.O00000Oo(String.format("Previous gatt not closed", new Object[0]));
            return true;
        }
        Context context = glc.O0000O0o;
        gmb gmb = new gmb(this.O0000Oo0);
        MMKV.O000000o(fap.O000000o.f16027O000000o.O000000o(this.O00000o.getAddress()).f16028O000000o).O000000o("KEY.CONNECT.STATUS", 1);
        this.O00000o = gnl.O00000o().getRemoteDevice(this.O00000o.getAddress());
        if (gqh.O000000o()) {
            this.O00000o0 = this.O00000o.connectGatt(context, false, gmb, 2);
        } else {
            this.O00000o0 = this.O00000o.connectGatt(context, false, gmb);
        }
        if (this.O00000o0 != null) {
            return true;
        }
        fte.O00000Oo("openGatt failed: connectGatt return null!");
        return false;
    }

    public final void closeGatt() {
        checkRuntime();
        boolean z = true;
        if (O00000Oo) {
            gnk.O00000o0(String.format("closeGatt for %s", this.O00000o.getAddress()));
        } else {
            StringBuilder sb = new StringBuilder("close gatt, mBluetoothGatt is null=");
            if (this.O00000o0 != null) {
                z = false;
            }
            sb.append(z);
            fte.O00000Oo(sb.toString());
        }
        if (this.O00000o0 != null) {
            if (O00000Oo) {
                gnk.O00000o0("Disconnecting...");
            }
            this.O00000oO.sendEmptyMessageDelayed(289, 2000);
            this.O00000o0.disconnect();
            return;
        }
        GattResponseListener gattResponseListener = this.f18007O000000o;
        if (gattResponseListener != null) {
            gattResponseListener.onConnectStatusChanged(false);
        }
        O000000o(0);
        O00000Oo(32);
    }

    private void O000000o() {
        if (O00000Oo) {
            gnk.O00000o0(String.format("releaseAfterDisconnected for %s", this.O00000o.getAddress()));
        } else {
            StringBuilder sb = new StringBuilder("releaseAfterDisconnected，mBluetoothGatt=null: ");
            sb.append(this.O00000o0 == null);
            fte.O00000Oo(sb.toString());
        }
        this.O00000oO.removeMessages(289);
        if (this.O00000o0 != null) {
            refreshDeviceCache();
            if (this.O00000o0 != null) {
                if (O00000Oo) {
                    gnk.O00000o0("Closing...");
                }
                this.O00000o0.close();
            }
            this.O00000o0 = null;
            this.O00000oO.postDelayed(new Runnable() {
                /* class _m_j.glz.AnonymousClass1 */

                public final void run() {
                    if (glz.this.f18007O000000o != null) {
                        boolean onConnectStatusChanged = glz.this.f18007O000000o.onConnectStatusChanged(false);
                        glz.this.O000000o(0);
                        if (onConnectStatusChanged) {
                            glz.this.O00000Oo(32);
                            return;
                        }
                        return;
                    }
                    glz.this.O000000o(0);
                    glz.this.O00000Oo(32);
                }
            }, 600);
        } else if (O00000Oo) {
            gnk.O00000o0(String.format("releaseAfterDisconnected for %s failed, mBluetoothGatt is null", this.O00000o.getAddress()));
        }
    }

    public final boolean discoverService() {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("discoverService for %s", this.O00000o.getAddress()));
        }
        BluetoothGatt bluetoothGatt = this.O00000o0;
        if (bluetoothGatt == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("discoverService but gatt is null!", new Object[0]));
            }
            return false;
        } else if (bluetoothGatt.discoverServices()) {
            return true;
        } else {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("discoverServices failed", new Object[0]));
            }
            return false;
        }
    }

    public final int getCurrentStatus() {
        checkRuntime();
        return this.O00000oo;
    }

    public final void registerGattResponseListener(GattResponseListener gattResponseListener) {
        checkRuntime();
        this.f18007O000000o = gattResponseListener;
    }

    public final void clearGattResponseListener(GattResponseListener gattResponseListener) {
        checkRuntime();
        if (this.f18007O000000o == gattResponseListener) {
            this.f18007O000000o = null;
        }
    }

    public final boolean refreshDeviceCache() {
        if (O00000Oo) {
            gnk.O00000o0(String.format("refreshDeviceCache for %s", this.O00000o.getAddress()));
        }
        checkRuntime();
        BluetoothGatt bluetoothGatt = this.O00000o0;
        if (bluetoothGatt == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else if (gnl.O000000o(bluetoothGatt)) {
            return true;
        } else {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("refreshDeviceCache failed", new Object[0]));
            }
            return false;
        }
    }

    public final boolean readCharacteristic(UUID uuid, UUID uuid2) {
        if (O00000Oo) {
            gnk.O00000o0(String.format("readCharacteristic for %s: service = 0x%s, character = 0x%s", this.O00000o.getAddress(), uuid, uuid2));
        }
        checkRuntime();
        BluetoothGattCharacteristic O000000o2 = O000000o(uuid, uuid2);
        if (O000000o2 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not exist!", new Object[0]));
            }
            return false;
        }
        if (!((O000000o2 == null || (O000000o2.getProperties() & 2) == 0) ? false : true)) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not readable!", new Object[0]));
            }
            return false;
        }
        BluetoothGatt bluetoothGatt = this.O00000o0;
        if (bluetoothGatt == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else if (bluetoothGatt.readCharacteristic(O000000o2)) {
            return true;
        } else {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("readCharacteristic failed", new Object[0]));
            }
            return false;
        }
    }

    public final boolean writeCharacteristic(UUID uuid, UUID uuid2, byte[] bArr) {
        if (O00000Oo) {
            gnk.O00000o0(String.format("writeCharacteristic for %s: service = 0x%s, character = 0x%s, value = 0x%s", this.O00000o.getAddress(), uuid, uuid2, got.O00000o0(bArr)));
        }
        checkRuntime();
        BluetoothGattCharacteristic O000000o2 = O000000o(uuid, uuid2);
        if (O000000o2 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not exist!", new Object[0]));
            }
            return false;
        } else if (this.O00000o0 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else {
            if (bArr == null) {
                bArr = got.f18097O000000o;
            }
            O000000o2.setValue(bArr);
            if (this.O00000o0.writeCharacteristic(O000000o2)) {
                return true;
            }
            if (O00000Oo) {
                gnk.O00000Oo(String.format("writeCharacteristic failed", new Object[0]));
            }
            return false;
        }
    }

    public final boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte[] bArr) {
        if (O00000Oo) {
            gnk.O00000o0(String.format("writeCharacteristicWithNoRsp for %s: service = 0x%s, character = 0x%s, value = 0x%s", this.O00000o.getAddress(), uuid, uuid2, got.O00000o0(bArr)));
        }
        checkRuntime();
        BluetoothGattCharacteristic O000000o2 = O000000o(uuid, uuid2);
        if (O000000o2 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not exist!", new Object[0]));
            }
            return false;
        }
        if (!((O000000o2 == null || (O000000o2.getProperties() & 4) == 0) ? false : true)) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not norsp writable!", new Object[0]));
            }
            return false;
        } else if (this.O00000o0 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else {
            if (bArr == null) {
                bArr = got.f18097O000000o;
            }
            O000000o2.setValue(bArr);
            O000000o2.setWriteType(1);
            if (this.O00000o0.writeCharacteristic(O000000o2)) {
                return true;
            }
            if (O00000Oo) {
                gnk.O00000Oo(String.format("writeCharacteristic failed", new Object[0]));
            }
            return false;
        }
    }

    public final boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("setCharacteristicNotification for %s, service = %s, character = %s, enable = %b", this.O00000o.getAddress(), uuid, uuid2, Boolean.valueOf(z)));
        }
        BluetoothGattCharacteristic O000000o2 = O000000o(uuid, uuid2);
        if (O000000o2 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not exist!", new Object[0]));
            }
            return false;
        }
        if (!((O000000o2 == null || (O000000o2.getProperties() & 16) == 0) ? false : true)) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not notifyable!", new Object[0]));
            }
            return false;
        }
        BluetoothGatt bluetoothGatt = this.O00000o0;
        if (bluetoothGatt == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else if (!bluetoothGatt.setCharacteristicNotification(O000000o2, z)) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("setCharacteristicNotification failed", new Object[0]));
            }
            return false;
        } else {
            BluetoothGattDescriptor descriptor = O000000o2.getDescriptor(glb.O00000Oo);
            if (descriptor == null) {
                if (O00000Oo) {
                    gnk.O00000Oo(String.format("getDescriptor for notify null!", new Object[0]));
                }
                return false;
            }
            if (!descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                if (O00000Oo) {
                    gnk.O00000Oo(String.format("setValue for notify descriptor failed!", new Object[0]));
                }
                return false;
            } else if (this.O00000o0.writeDescriptor(descriptor)) {
                return true;
            } else {
                if (O00000Oo) {
                    gnk.O00000Oo(String.format("writeDescriptor for notify failed", new Object[0]));
                }
                return false;
            }
        }
    }

    public final boolean setCharacteristicIndication(UUID uuid, UUID uuid2, boolean z) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("setCharacteristicIndication for %s, service = %s, character = %s, enable = %b", this.O00000o.getAddress(), uuid, uuid2, Boolean.valueOf(z)));
        }
        BluetoothGattCharacteristic O000000o2 = O000000o(uuid, uuid2);
        if (O000000o2 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not exist!", new Object[0]));
            }
            return false;
        }
        if (!((O000000o2 == null || (O000000o2.getProperties() & 32) == 0) ? false : true)) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("characteristic not indicatable!", new Object[0]));
            }
            return false;
        }
        BluetoothGatt bluetoothGatt = this.O00000o0;
        if (bluetoothGatt == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else if (!bluetoothGatt.setCharacteristicNotification(O000000o2, z)) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("setCharacteristicIndication failed", new Object[0]));
            }
            return false;
        } else {
            BluetoothGattDescriptor descriptor = O000000o2.getDescriptor(glb.O00000Oo);
            if (descriptor == null) {
                if (O00000Oo) {
                    gnk.O00000Oo(String.format("getDescriptor for indicate null!", new Object[0]));
                }
                return false;
            }
            if (!descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                if (O00000Oo) {
                    gnk.O00000Oo(String.format("setValue for indicate descriptor failed!", new Object[0]));
                }
                return false;
            } else if (this.O00000o0.writeDescriptor(descriptor)) {
                return true;
            } else {
                if (O00000Oo) {
                    gnk.O00000Oo(String.format("writeDescriptor for indicate failed", new Object[0]));
                }
                return false;
            }
        }
    }

    public final boolean readRemoteRssi() {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("readRemoteRssi for %s", this.O00000o.getAddress()));
        }
        BluetoothGatt bluetoothGatt = this.O00000o0;
        if (bluetoothGatt == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else if (bluetoothGatt.readRemoteRssi()) {
            return true;
        } else {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("readRemoteRssi failed", new Object[0]));
            }
            return false;
        }
    }

    public final boolean requestConnectionPriority(int i) {
        if (O00000Oo) {
            gnk.O00000o0(String.format("requestConnectionPriority for %s: connectionPriority = %d", this.O00000o.getAddress(), Integer.valueOf(i)));
        }
        if (this.O00000o0 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else if (i < 0 || i > 2) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("connectionPriority not within valid range", new Object[0]));
            }
            return false;
        } else if (Build.VERSION.SDK_INT < 21) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("requestConnectionPriority only support from android 5.0", new Object[0]));
            }
            return false;
        } else if (this.O00000o0.requestConnectionPriority(i)) {
            return true;
        } else {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("requestConnectionPriority failed", new Object[0]));
            }
            return false;
        }
    }

    public final boolean requestMtu(int i) {
        checkRuntime();
        if (O00000Oo) {
            gnk.O00000o0(String.format("requestMtu for %s, mtu = %d", this.O00000o.getAddress(), Integer.valueOf(i)));
        }
        if (this.O00000o0 == null) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("ble gatt null", new Object[0]));
            }
            return false;
        } else if (Build.VERSION.SDK_INT < 21) {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("requestMtu only support from android 5.0", new Object[0]));
            }
            return false;
        } else if (this.O00000o0.requestMtu(i)) {
            return true;
        } else {
            if (O00000Oo) {
                gnk.O00000Oo(String.format("requestMtu failed", new Object[0]));
            }
            return false;
        }
    }

    public final void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        if (bleResponse != null) {
            if (this.O00000o0 == null || this.O0000OOo == null) {
                bleResponse.onResponse(-8, null);
            } else if (O000000o(uuid, uuid2) != null) {
                bleResponse.onResponse(0, null);
            } else {
                bleResponse.onResponse(-1, null);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 288) {
            ((gmt) message.obj).O000000o();
            return true;
        } else if (i != 289) {
            return true;
        } else {
            gnk.O00000o("disconnect timeout");
            O000000o();
            return true;
        }
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        this.O00000oO.obtainMessage(288, new gmt(obj, method, objArr)).sendToTarget();
        return true;
    }

    public final void checkRuntime() {
        this.O0000Oo.checkRuntime();
    }

    public final BleGattProfile getGattProfile() {
        return this.O0000O0o;
    }
}

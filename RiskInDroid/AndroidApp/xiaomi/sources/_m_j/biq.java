package _m_j;

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
import com.inuker.bluetooth.library.model.BleGattProfile;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class biq implements bim, bit, bix, bld, Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    private BluetoothGatt f13006O000000o;
    private BluetoothDevice O00000Oo;
    private Handler O00000o;
    private biw O00000o0;
    private volatile int O00000oO;
    private BleGattProfile O00000oo;
    private Map<UUID, Map<UUID, BluetoothGattCharacteristic>> O0000O0o;
    private bix O0000OOo;
    private bim O0000Oo0;

    public biq(String str, bim bim) {
        BluetoothAdapter O00000o02 = bkz.O00000o0();
        if (O00000o02 != null) {
            this.O00000Oo = O00000o02.getRemoteDevice(str);
            this.O0000Oo0 = bim;
            this.O00000o = new Handler(Looper.myLooper(), this);
            this.O0000O0o = new HashMap();
            this.O0000OOo = (bix) blf.O000000o(this, bix.class, this);
            return;
        }
        throw new IllegalStateException("ble adapter null");
    }

    private BluetoothGattCharacteristic O00000Oo(UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        BluetoothGattService service;
        Map map;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (uuid == null || uuid2 == null || (map = this.O0000O0o.get(uuid)) == null) ? null : (BluetoothGattCharacteristic) map.get(uuid2);
        return (bluetoothGattCharacteristic != null || (bluetoothGatt = this.f13006O000000o) == null || (service = bluetoothGatt.getService(uuid)) == null) ? bluetoothGattCharacteristic : service.getCharacteristic(uuid2);
    }

    private void O00000Oo(int i) {
        bky.O00000Oo(String.format("setConnectStatus status = %s", bik.O000000o(i)));
        this.O00000oO = i;
    }

    public final void O000000o(int i, int i2) {
        O000000o();
        bky.O00000Oo(String.format("onConnectionStateChange for %s: status = %d, newState = %d", this.O00000Oo.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)));
        if (i == 0 && i2 == 2) {
            O00000Oo(2);
            biw biw = this.O00000o0;
            if (biw != null) {
                biw.O000000o(true);
                return;
            }
            return;
        }
        O00000o0();
    }

    public final void O000000o(int i) {
        O000000o();
        bky.O00000Oo(String.format("onServicesDiscovered for %s: status = %d", this.O00000Oo.getAddress(), Integer.valueOf(i)));
        if (i == 0) {
            O00000Oo(19);
            O00000o0(16);
            bky.O00000Oo(String.format("refreshServiceProfile for %s", this.O00000Oo.getAddress()));
            List<BluetoothGattService> services = this.f13006O000000o.getServices();
            HashMap hashMap = new HashMap();
            for (BluetoothGattService next : services) {
                UUID uuid = next.getUuid();
                Map map = (Map) hashMap.get(uuid);
                if (map == null) {
                    bky.O00000Oo("Service: ".concat(String.valueOf(uuid)));
                    map = new HashMap();
                    hashMap.put(next.getUuid(), map);
                }
                for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                    bky.O00000Oo("character: uuid = ".concat(String.valueOf(next2.getUuid())));
                    map.put(next2.getUuid(), next2);
                }
            }
            this.O0000O0o.clear();
            this.O0000O0o.putAll(hashMap);
            this.O00000oo = new BleGattProfile(this.O0000O0o);
        }
        biw biw = this.O00000o0;
        if (biw != null && (biw instanceof bjb)) {
            ((bjb) biw).O000000o(i);
        }
    }

    public final void O000000o(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        O000000o();
        bky.O00000Oo(String.format("onCharacteristicRead for %s: status = %d, service = 0x%s, character = 0x%s, value = %s", this.O00000Oo.getAddress(), Integer.valueOf(i), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), bla.O000000o(bArr)));
        biw biw = this.O00000o0;
        if (biw != null && (biw instanceof biy)) {
            ((biy) biw).O000000o(i, bArr);
        }
    }

    public final void O00000Oo(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        O000000o();
        bky.O00000Oo(String.format("onCharacteristicWrite for %s: status = %d, service = 0x%s, character = 0x%s, value = %s", this.O00000Oo.getAddress(), Integer.valueOf(i), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), bla.O000000o(bArr)));
        biw biw = this.O00000o0;
        if (biw != null && (biw instanceof bjc)) {
            ((bjc) biw).O000000o(i);
        }
    }

    public final void O000000o(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        O000000o();
        bky.O00000Oo(String.format("onCharacteristicChanged for %s: value = %s, service = 0x%s, character = 0x%s", this.O00000Oo.getAddress(), bla.O000000o(bArr), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid()));
        UUID uuid = bluetoothGattCharacteristic.getService().getUuid();
        UUID uuid2 = bluetoothGattCharacteristic.getUuid();
        Intent intent = new Intent("action.character_changed");
        intent.putExtra("extra.mac", this.O00000Oo.getAddress());
        intent.putExtra("extra.service.uuid", uuid);
        intent.putExtra("extra.character.uuid", uuid2);
        intent.putExtra("extra.byte.value", bArr);
        bij.f13001O000000o.sendBroadcast(intent);
    }

    public final void O000000o(BluetoothGattDescriptor bluetoothGattDescriptor, int i, byte[] bArr) {
        O000000o();
        bky.O00000Oo(String.format("onDescriptorRead for %s: status = %d, service = 0x%s, character = 0x%s, descriptor = 0x%s", this.O00000Oo.getAddress(), Integer.valueOf(i), bluetoothGattDescriptor.getCharacteristic().getService().getUuid(), bluetoothGattDescriptor.getCharacteristic().getUuid(), bluetoothGattDescriptor.getUuid()));
        biw biw = this.O00000o0;
        if (biw != null && (biw instanceof biz)) {
            ((biz) biw).O000000o(i, bArr);
        }
    }

    public final void O000000o(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        O000000o();
        bky.O00000Oo(String.format("onDescriptorWrite for %s: status = %d, service = 0x%s, character = 0x%s, descriptor = 0x%s", this.O00000Oo.getAddress(), Integer.valueOf(i), bluetoothGattDescriptor.getCharacteristic().getService().getUuid(), bluetoothGattDescriptor.getCharacteristic().getUuid(), bluetoothGattDescriptor.getUuid()));
        biw biw = this.O00000o0;
        if (biw != null && (biw instanceof bjd)) {
            ((bjd) biw).O000000o(i);
        }
    }

    public final void O00000Oo(int i, int i2) {
        O000000o();
        bky.O00000Oo(String.format("onReadRemoteRssi for %s, rssi = %d, status = %d", this.O00000Oo.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)));
        biw biw = this.O00000o0;
        if (biw != null && (biw instanceof bja)) {
            ((bja) biw).O000000o(i, i2);
        }
    }

    private void O00000o0(int i) {
        Intent intent = new Intent("action.connect_status_changed");
        intent.putExtra("extra.mac", this.O00000Oo.getAddress());
        intent.putExtra("extra.status", i);
        bij.f13001O000000o.sendBroadcast(intent);
    }

    public final boolean O00000Oo() {
        O000000o();
        bky.O00000Oo(String.format("openGatt for %s", this.O00000Oo.getAddress()));
        if (this.f13006O000000o != null) {
            bky.O000000o(String.format("Previous gatt not closed", new Object[0]));
            return true;
        }
        Context context = bij.f13001O000000o;
        bjy bjy = new bjy(this.O0000OOo);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f13006O000000o = this.O00000Oo.connectGatt(context, false, bjy, 2);
        } else {
            this.f13006O000000o = this.O00000Oo.connectGatt(context, false, bjy);
        }
        if (this.f13006O000000o != null) {
            return true;
        }
        bky.O000000o(String.format("openGatt failed: connectGatt return null!", new Object[0]));
        return false;
    }

    public final void O00000o0() {
        O000000o();
        bky.O00000Oo(String.format("closeGatt for %s", this.O00000Oo.getAddress()));
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.f13006O000000o = null;
        }
        biw biw = this.O00000o0;
        if (biw != null) {
            biw.O000000o(false);
        }
        O00000Oo(0);
        O00000o0(32);
    }

    public final boolean O00000o() {
        O000000o();
        bky.O00000Oo(String.format("discoverService for %s", this.O00000Oo.getAddress()));
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt == null) {
            bky.O000000o(String.format("discoverService but gatt is null!", new Object[0]));
            return false;
        } else if (bluetoothGatt.discoverServices()) {
            return true;
        } else {
            bky.O000000o(String.format("discoverServices failed", new Object[0]));
            return false;
        }
    }

    public final int O00000oO() {
        O000000o();
        return this.O00000oO;
    }

    public final void O000000o(biw biw) {
        O000000o();
        this.O00000o0 = biw;
    }

    public final void O00000Oo(biw biw) {
        O000000o();
        if (this.O00000o0 == biw) {
            this.O00000o0 = null;
        }
    }

    public final boolean O00000oo() {
        bky.O00000Oo(String.format("refreshDeviceCache for %s", this.O00000Oo.getAddress()));
        O000000o();
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else if (bkz.O000000o(bluetoothGatt)) {
            return true;
        } else {
            bky.O000000o(String.format("refreshDeviceCache failed", new Object[0]));
            return false;
        }
    }

    public final boolean O000000o(UUID uuid, UUID uuid2) {
        bky.O00000Oo(String.format("readCharacteristic for %s: service = 0x%s, character = 0x%s", this.O00000Oo.getAddress(), uuid, uuid2));
        O000000o();
        BluetoothGattCharacteristic O00000Oo2 = O00000Oo(uuid, uuid2);
        if (O00000Oo2 == null) {
            bky.O000000o(String.format("characteristic not exist!", new Object[0]));
            return false;
        }
        if (!((O00000Oo2 == null || (O00000Oo2.getProperties() & 2) == 0) ? false : true)) {
            bky.O000000o(String.format("characteristic not readable!", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else if (bluetoothGatt.readCharacteristic(O00000Oo2)) {
            return true;
        } else {
            bky.O000000o(String.format("readCharacteristic failed", new Object[0]));
            return false;
        }
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        bky.O00000Oo(String.format("writeCharacteristic for %s: service = 0x%s, character = 0x%s, value = 0x%s", this.O00000Oo.getAddress(), uuid, uuid2, bla.O000000o(bArr)));
        O000000o();
        BluetoothGattCharacteristic O00000Oo2 = O00000Oo(uuid, uuid2);
        if (O00000Oo2 == null) {
            bky.O000000o(String.format("characteristic not exist!", new Object[0]));
            return false;
        }
        if (!((O00000Oo2 == null || (O00000Oo2.getProperties() & 8) == 0) ? false : true)) {
            bky.O000000o(String.format("characteristic not writable!", new Object[0]));
            return false;
        } else if (this.f13006O000000o == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else {
            if (bArr == null) {
                bArr = bla.f13031O000000o;
            }
            O00000Oo2.setValue(bArr);
            if (this.f13006O000000o.writeCharacteristic(O00000Oo2)) {
                return true;
            }
            bky.O000000o(String.format("writeCharacteristic failed", new Object[0]));
            return false;
        }
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, UUID uuid3) {
        bky.O00000Oo(String.format("readDescriptor for %s: service = 0x%s, character = 0x%s, descriptor = 0x%s", this.O00000Oo.getAddress(), uuid, uuid2, uuid3));
        O000000o();
        BluetoothGattCharacteristic O00000Oo2 = O00000Oo(uuid, uuid2);
        if (O00000Oo2 == null) {
            bky.O000000o(String.format("characteristic not exist!", new Object[0]));
            return false;
        }
        BluetoothGattDescriptor descriptor = O00000Oo2.getDescriptor(uuid3);
        if (descriptor == null) {
            bky.O000000o(String.format("descriptor not exist", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else if (bluetoothGatt.readDescriptor(descriptor)) {
            return true;
        } else {
            bky.O000000o(String.format("readDescriptor failed", new Object[0]));
            return false;
        }
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        bky.O00000Oo(String.format("writeDescriptor for %s: service = 0x%s, character = 0x%s, descriptor = 0x%s, value = 0x%s", this.O00000Oo.getAddress(), uuid, uuid2, uuid3, bla.O000000o(bArr)));
        O000000o();
        BluetoothGattCharacteristic O00000Oo2 = O00000Oo(uuid, uuid2);
        if (O00000Oo2 == null) {
            bky.O000000o(String.format("characteristic not exist!", new Object[0]));
            return false;
        }
        BluetoothGattDescriptor descriptor = O00000Oo2.getDescriptor(uuid3);
        if (descriptor == null) {
            bky.O000000o(String.format("descriptor not exist", new Object[0]));
            return false;
        } else if (this.f13006O000000o == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else {
            if (bArr == null) {
                bArr = bla.f13031O000000o;
            }
            descriptor.setValue(bArr);
            if (this.f13006O000000o.writeDescriptor(descriptor)) {
                return true;
            }
            bky.O000000o(String.format("writeDescriptor failed", new Object[0]));
            return false;
        }
    }

    public final boolean O00000Oo(UUID uuid, UUID uuid2, byte[] bArr) {
        bky.O00000Oo(String.format("writeCharacteristicWithNoRsp for %s: service = 0x%s, character = 0x%s, value = 0x%s", this.O00000Oo.getAddress(), uuid, uuid2, bla.O000000o(bArr)));
        O000000o();
        BluetoothGattCharacteristic O00000Oo2 = O00000Oo(uuid, uuid2);
        if (O00000Oo2 == null) {
            bky.O000000o(String.format("characteristic not exist!", new Object[0]));
            return false;
        }
        if (!((O00000Oo2 == null || (O00000Oo2.getProperties() & 4) == 0) ? false : true)) {
            bky.O000000o(String.format("characteristic not norsp writable!", new Object[0]));
            return false;
        } else if (this.f13006O000000o == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else {
            if (bArr == null) {
                bArr = bla.f13031O000000o;
            }
            O00000Oo2.setValue(bArr);
            O00000Oo2.setWriteType(1);
            if (this.f13006O000000o.writeCharacteristic(O00000Oo2)) {
                return true;
            }
            bky.O000000o(String.format("writeCharacteristic failed", new Object[0]));
            return false;
        }
    }

    public final boolean O000000o(UUID uuid, UUID uuid2, boolean z) {
        O000000o();
        bky.O00000Oo(String.format("setCharacteristicNotification for %s, service = %s, character = %s, enable = %b", this.O00000Oo.getAddress(), uuid, uuid2, Boolean.valueOf(z)));
        BluetoothGattCharacteristic O00000Oo2 = O00000Oo(uuid, uuid2);
        if (O00000Oo2 == null) {
            bky.O000000o(String.format("characteristic not exist!", new Object[0]));
            return false;
        }
        if (!((O00000Oo2 == null || (O00000Oo2.getProperties() & 16) == 0) ? false : true)) {
            bky.O000000o(String.format("characteristic not notifyable!", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else if (bluetoothGatt.setCharacteristicNotification(O00000Oo2, z)) {
            return true;
        } else {
            bky.O000000o(String.format("setCharacteristicNotification failed", new Object[0]));
            return false;
        }
    }

    public final boolean O00000Oo(UUID uuid, UUID uuid2, boolean z) {
        O000000o();
        bky.O00000Oo(String.format("setCharacteristicIndication for %s, service = %s, character = %s, enable = %b", this.O00000Oo.getAddress(), uuid, uuid2, Boolean.valueOf(z)));
        BluetoothGattCharacteristic O00000Oo2 = O00000Oo(uuid, uuid2);
        if (O00000Oo2 == null) {
            bky.O000000o(String.format("characteristic not exist!", new Object[0]));
            return false;
        }
        if (!((O00000Oo2 == null || (O00000Oo2.getProperties() & 32) == 0) ? false : true)) {
            bky.O000000o(String.format("characteristic not indicatable!", new Object[0]));
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else if (!bluetoothGatt.setCharacteristicNotification(O00000Oo2, z)) {
            bky.O000000o(String.format("setCharacteristicIndication failed", new Object[0]));
            return false;
        } else {
            BluetoothGattDescriptor descriptor = O00000Oo2.getDescriptor(bik.f13002O000000o);
            if (descriptor == null) {
                bky.O000000o(String.format("getDescriptor for indicate null!", new Object[0]));
                return false;
            }
            if (!descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                bky.O000000o(String.format("setValue for indicate descriptor failed!", new Object[0]));
                return false;
            } else if (this.f13006O000000o.writeDescriptor(descriptor)) {
                return true;
            } else {
                bky.O000000o(String.format("writeDescriptor for indicate failed", new Object[0]));
                return false;
            }
        }
    }

    public final boolean O0000O0o() {
        O000000o();
        bky.O00000Oo(String.format("readRemoteRssi for %s", this.O00000Oo.getAddress()));
        BluetoothGatt bluetoothGatt = this.f13006O000000o;
        if (bluetoothGatt == null) {
            bky.O000000o(String.format("ble gatt null", new Object[0]));
            return false;
        } else if (bluetoothGatt.readRemoteRssi()) {
            return true;
        } else {
            bky.O000000o(String.format("readRemoteRssi failed", new Object[0]));
            return false;
        }
    }

    public final BleGattProfile O0000OOo() {
        return this.O00000oo;
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 288) {
            return true;
        }
        ((blc) message.obj).O000000o();
        return true;
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        this.O00000o.obtainMessage(288, new blc(obj, method, objArr)).sendToTarget();
        return true;
    }

    public final void O000000o() {
        this.O0000Oo0.O000000o();
    }
}

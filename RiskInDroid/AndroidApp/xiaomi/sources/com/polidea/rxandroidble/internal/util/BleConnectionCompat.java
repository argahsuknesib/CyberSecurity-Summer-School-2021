package com.polidea.rxandroidble.internal.util;

import _m_j.crb;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import android.os.Build;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BleConnectionCompat {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f5416O000000o;

    public BleConnectionCompat(Context context) {
        this.f5416O000000o = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.polidea.rxandroidble.internal.util.BleConnectionCompat.O000000o(android.bluetooth.BluetoothGattCallback, android.bluetooth.BluetoothDevice, boolean):android.bluetooth.BluetoothGatt
     arg types: [android.bluetooth.BluetoothGattCallback, android.bluetooth.BluetoothDevice, int]
     candidates:
      com.polidea.rxandroidble.internal.util.BleConnectionCompat.O000000o(android.bluetooth.BluetoothDevice, boolean, android.bluetooth.BluetoothGattCallback):android.bluetooth.BluetoothGatt
      com.polidea.rxandroidble.internal.util.BleConnectionCompat.O000000o(android.bluetooth.BluetoothGattCallback, android.bluetooth.BluetoothDevice, boolean):android.bluetooth.BluetoothGatt */
    public final BluetoothGatt O000000o(BluetoothDevice bluetoothDevice, boolean z, BluetoothGattCallback bluetoothGattCallback) {
        Object obj;
        BluetoothGatt bluetoothGatt;
        Object obj2 = null;
        if (bluetoothDevice == null) {
            return null;
        }
        if (!z) {
            return O000000o(bluetoothGattCallback, bluetoothDevice, false);
        }
        try {
            crb.O000000o("Trying to connectGatt using reflection.", new Object[0]);
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                obj = null;
            } else {
                obj = O000000o(defaultAdapter.getClass(), "getBluetoothManager").invoke(defaultAdapter, new Object[0]);
            }
            if (obj != null) {
                obj2 = O000000o(obj.getClass(), "getBluetoothGatt").invoke(obj, new Object[0]);
            }
            if (obj2 == null) {
                crb.O00000Oo("Couldn't get iBluetoothGatt object", new Object[0]);
                return O000000o(bluetoothGattCallback, bluetoothDevice, true);
            }
            Constructor<?> constructor = BluetoothGatt.class.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            crb.O000000o("Found constructor with args count = " + constructor.getParameterTypes().length, new Object[0]);
            if (constructor.getParameterTypes().length == 4) {
                bluetoothGatt = (BluetoothGatt) constructor.newInstance(this.f5416O000000o, obj2, bluetoothDevice, 2);
            } else {
                bluetoothGatt = (BluetoothGatt) constructor.newInstance(this.f5416O000000o, obj2, bluetoothDevice);
            }
            if (bluetoothGatt == null) {
                crb.O00000Oo("Couldn't create BluetoothGatt object", new Object[0]);
                return O000000o(bluetoothGattCallback, bluetoothDevice, true);
            }
            crb.O000000o("Connecting using reflection", new Object[0]);
            Field declaredField = bluetoothGatt.getClass().getDeclaredField("mAutoConnect");
            declaredField.setAccessible(true);
            declaredField.setBoolean(bluetoothGatt, true);
            Method declaredMethod = bluetoothGatt.getClass().getDeclaredMethod("connect", Boolean.class, BluetoothGattCallback.class);
            declaredMethod.setAccessible(true);
            if (!((Boolean) declaredMethod.invoke(bluetoothGatt, Boolean.TRUE, bluetoothGattCallback)).booleanValue()) {
                crb.O00000Oo("Connection using reflection failed, closing gatt", new Object[0]);
                bluetoothGatt.close();
            }
            return bluetoothGatt;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            crb.O000000o(e, "Error during reflection", new Object[0]);
            return O000000o(bluetoothGattCallback, bluetoothDevice, true);
        }
    }

    private BluetoothGatt O000000o(BluetoothGattCallback bluetoothGattCallback, BluetoothDevice bluetoothDevice, boolean z) {
        crb.O000000o("Connecting without reflection", new Object[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            return bluetoothDevice.connectGatt(this.f5416O000000o, z, bluetoothGattCallback, 2);
        }
        return bluetoothDevice.connectGatt(this.f5416O000000o, z, bluetoothGattCallback);
    }

    private static Method O000000o(Class<?> cls, String str) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}

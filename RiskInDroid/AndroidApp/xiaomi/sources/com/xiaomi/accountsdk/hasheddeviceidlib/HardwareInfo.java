package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class HardwareInfo {
    public static String getWifiMacAddress(Context context) {
        String wifiMacAddressHack = getWifiMacAddressHack();
        if (!TextUtils.isEmpty(wifiMacAddressHack) && !wifiMacAddressHack.equals("0")) {
            return wifiMacAddressHack;
        }
        if (context == null) {
            return "0";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager.getConnectionInfo() == null) {
                return "0";
            }
            String macAddress = wifiManager.getConnectionInfo().getMacAddress();
            if (TextUtils.isEmpty(macAddress) || macAddress.equals("02:00:00:00:00:00")) {
                return "0";
            }
            return macAddress;
        } catch (SecurityException e) {
            AccountLog.e("UserEnvironment", "failed to get Mac Address", e);
        }
    }

    private static String getWifiMacAddressHack() {
        byte[] bArr;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "0";
            }
            while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    bArr = null;
                    break;
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName() != null && nextElement.getName().equalsIgnoreCase("wlan0")) {
                    bArr = nextElement.getHardwareAddress();
                    break;
                }
            }
            if (bArr == null) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02X:", Byte.valueOf(bArr[i])));
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (SocketException e) {
            AccountLog.e("UserEnvironment", "failed to get wifi Mac Address", e);
            return "0";
        }
    }

    public static String getBluetoothMacAddress(Context context) {
        String bluetoothMacAddressHack = getBluetoothMacAddressHack(context);
        if (!TextUtils.isEmpty(bluetoothMacAddressHack)) {
            return bluetoothMacAddressHack;
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                return "0";
            }
            String address = defaultAdapter.getAddress();
            if (TextUtils.isEmpty(address) || address.equals("02:00:00:00:00:00")) {
                return "0";
            }
            return address;
        } catch (SecurityException e) {
            AccountLog.e("UserEnvironment", "failed to get bluetooth id", e);
            return "0";
        }
    }

    private static String getBluetoothMacAddressHack(Context context) {
        if (context == null) {
            return null;
        }
        return Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
    }
}

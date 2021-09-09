package cn.com.xm.bt.sdk;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Base64;
import cn.com.xm.bt.a.a;
import cn.com.xm.bt.b.d;
import cn.com.xm.bt.b.e;
import cn.com.xm.bt.c.c;
import cn.com.xm.bt.profile.a.f;
import cn.com.xm.bt.profile.nfc.ApduResponse;
import cn.com.xm.bt.profile.nfc.HMAccessInfo;
import cn.com.xm.bt.profile.nfc.HMAidInfo;
import cn.com.xm.bt.profile.nfc.HMNFCStatus;
import java.io.File;

public class HMBleDevice {
    private boolean autoReconnect = true;
    private d bleDevice = null;

    public HMBleDevice(Context context, String str) {
        a.b("HMBleDevice", "connect:".concat(String.valueOf(str)));
        this.bleDevice = new d(context, str);
        this.bleDevice.a(new cn.com.xm.bt.profile.a.a());
    }

    public void connect(final IDeviceCallback iDeviceCallback) {
        a.b("HMBleDevice", "connect:".concat(String.valueOf(iDeviceCallback)));
        this.bleDevice.a(new f() {
            /* class cn.com.xm.bt.sdk.HMBleDevice.AnonymousClass1 */

            public byte[] onGetSignData(byte[] bArr, byte[] bArr2, int i) {
                a.b("HMBleDevice", "onGetSignData random:" + c.a(bArr) + ",publicKeyHash:" + c.a(bArr2) + ",algorithm:" + i);
                String encodeToString = Base64.encodeToString(bArr, 2);
                StringBuilder sb = new StringBuilder();
                sb.append(i == 0 ? "SHA1:" : "UNKNOWN:");
                sb.append(c.d(bArr2));
                String sb2 = sb.toString();
                a.a("HMBleDevice", "random:" + c.a(bArr) + ",base64Random:" + encodeToString + ",keyHash:" + sb2);
                byte[] onSignature = iDeviceCallback.onSignature(encodeToString, sb2);
                StringBuilder sb3 = new StringBuilder("signature:");
                sb3.append(c.a(onSignature));
                a.b("HMBleDevice", sb3.toString());
                return onSignature;
            }

            public void onAuthentication(cn.com.xm.bt.profile.a.c cVar) {
                a.b("HMBleDevice", "authState:".concat(String.valueOf(cVar)));
                IDeviceCallback iDeviceCallback = iDeviceCallback;
                if (iDeviceCallback != null) {
                    iDeviceCallback.onAuthStateChanged(cVar.a(), cVar.b());
                }
            }
        });
        this.bleDevice.a(new e() {
            /* class cn.com.xm.bt.sdk.HMBleDevice.AnonymousClass2 */

            public void onDeviceConnecting(BluetoothDevice bluetoothDevice, cn.com.xm.bt.b.c cVar) {
                a.b("HMBleDevice", "onDeviceConnecting");
                IDeviceCallback iDeviceCallback = iDeviceCallback;
                if (iDeviceCallback != null) {
                    iDeviceCallback.onConnectionStateChanged(1);
                }
            }

            public void onDeviceConnectingTimeout(BluetoothDevice bluetoothDevice, cn.com.xm.bt.b.c cVar) {
                a.b("HMBleDevice", "onDeviceConnectingTimeout");
                IDeviceCallback iDeviceCallback = iDeviceCallback;
                if (iDeviceCallback != null) {
                    iDeviceCallback.onConnectionStateChanged(2);
                }
            }

            public void onDeviceConnected(BluetoothDevice bluetoothDevice, cn.com.xm.bt.b.c cVar) {
                a.b("HMBleDevice", "onDeviceConnected");
                IDeviceCallback iDeviceCallback = iDeviceCallback;
                if (iDeviceCallback != null) {
                    iDeviceCallback.onConnectionStateChanged(0);
                }
            }

            public void onDeviceDisconnected(BluetoothDevice bluetoothDevice, cn.com.xm.bt.b.c cVar) {
                a.b("HMBleDevice", "onDeviceDisconnected");
                IDeviceCallback iDeviceCallback = iDeviceCallback;
                if (iDeviceCallback != null) {
                    iDeviceCallback.onConnectionStateChanged(3);
                }
            }
        });
        this.bleDevice.a(this.autoReconnect);
        this.bleDevice.f();
    }

    public void setPair(boolean z) {
        a.b("HMBleDevice", "setPair:".concat(String.valueOf(z)));
        d dVar = this.bleDevice;
        if (dVar != null) {
            dVar.d().a(z);
        }
    }

    public void setAutoConnect(boolean z) {
        a.b("HMBleDevice", "setAutoConnect:".concat(String.valueOf(z)));
        this.autoReconnect = z;
        d dVar = this.bleDevice;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public void setKey(String str) {
        a.b("HMBleDevice", "setKey:".concat(String.valueOf(str)));
        d dVar = this.bleDevice;
        if (dVar != null) {
            dVar.d().a(str);
        }
    }

    public String getKey() {
        d dVar = this.bleDevice;
        String a2 = dVar != null ? dVar.d().a() : null;
        a.b("HMBleDevice", "getKey:".concat(String.valueOf(a2)));
        return a2;
    }

    public int getRealtimeStep() {
        a.b("HMBleDevice", "getRealtimeStep");
        d dVar = this.bleDevice;
        cn.com.xm.bt.d.e h = dVar != null ? dVar.h() : null;
        if (h == null) {
            return -1;
        }
        return h.a();
    }

    public HMNFCStatus openApduChannel() {
        a.b("HMBleDevice", "openApduChannel");
        d dVar = this.bleDevice;
        if (dVar != null) {
            return dVar.a($$Lambda$HMBleDevice$QbK4Bi8wrg2LXl6ehbrfcKpl70M.INSTANCE);
        }
        return null;
    }

    public ApduResponse sendApduData(byte[] bArr, int i, boolean z) {
        a.b("HMBleDevice", "sendApduData:" + c.a(bArr) + ",apduLen:" + i + ",encrypt:" + z);
        d dVar = this.bleDevice;
        if (dVar != null) {
            return dVar.a(new cn.com.xm.bt.profile.nfc.a(bArr, i, z));
        }
        return null;
    }

    public boolean setAidInfoSync(HMAidInfo hMAidInfo) {
        a.b("HMBleDevice", "setAidInfoSync:".concat(String.valueOf(hMAidInfo)));
        d dVar = this.bleDevice;
        return dVar != null && dVar.a(hMAidInfo);
    }

    public boolean setAccessInfoSync(HMAccessInfo hMAccessInfo) {
        a.b("HMBleDevice", "setAccessInfoSync:".concat(String.valueOf(hMAccessInfo)));
        d dVar = this.bleDevice;
        return dVar != null && dVar.a(hMAccessInfo);
    }

    public HMNFCStatus closeApduChannel() {
        a.b("HMBleDevice", "closeApduChannel");
        d dVar = this.bleDevice;
        if (dVar != null) {
            return dVar.i();
        }
        return null;
    }

    public void disconnect() {
        a.b("HMBleDevice", "disconnect");
        d dVar = this.bleDevice;
        if (dVar != null) {
            dVar.g();
            this.bleDevice = null;
        }
    }

    public static int getVersion() {
        a.b("HMBleDevice", "getVersion");
        return 2;
    }

    public static void enableLog(boolean z) {
        a.b("HMBleDevice", "enableLog:".concat(String.valueOf(z)));
        a.a(z);
    }

    public static void setLogFile(File file) {
        a.b("HMBleDevice", "setLogFile:".concat(String.valueOf(file)));
        a.a(file);
    }
}

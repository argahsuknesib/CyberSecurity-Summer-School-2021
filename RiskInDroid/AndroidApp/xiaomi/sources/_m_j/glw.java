package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectManager;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectMaster;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadRssiResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleRequestMtuResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class glw implements gmu, Handler.Callback, IBleConnectManager {
    private static volatile IBleConnectManager O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap<String, IBleConnectMaster> f17998O000000o = new HashMap<>();
    private Handler O00000o0 = new Handler(Looper.getMainLooper(), this);

    private glw() {
    }

    public static IBleConnectManager O000000o() {
        if (O00000Oo == null) {
            synchronized (glw.class) {
                if (O00000Oo == null) {
                    glw glw = new glw();
                    O00000Oo = (IBleConnectManager) gmw.O000000o(glw, IBleConnectManager.class, glw, true);
                }
            }
        }
        return O00000Oo;
    }

    private IBleConnectMaster O000000o(String str) {
        IBleConnectMaster iBleConnectMaster = this.f17998O000000o.get(str);
        if (iBleConnectMaster != null) {
            return iBleConnectMaster;
        }
        IBleConnectMaster O000000o2 = glx.O000000o(str);
        this.f17998O000000o.put(str, O000000o2);
        return O000000o2;
    }

    public void connect(String str, BleConnectOptions bleConnectOptions, BleConnectResponse bleConnectResponse) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(str).connect(bleConnectOptions, bleConnectResponse);
        }
    }

    public void disconnect(String str) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(str).disconnect();
        }
    }

    public void read(String str, UUID uuid, UUID uuid2, BleReadResponse bleReadResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null) {
            O000000o(str).read(uuid, uuid2, bleReadResponse);
        }
    }

    public void write(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null && bArr != null) {
            O000000o(str).write(uuid, uuid2, bArr, bleWriteResponse);
        }
    }

    public void writeNoRsp(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null && bArr != null) {
            O000000o(str).writeNoRsp(uuid, uuid2, bArr, bleWriteResponse);
        }
    }

    public void notify(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null) {
            O000000o(str).notify(uuid, uuid2, bleNotifyResponse);
        }
    }

    public void unnotify(String str, UUID uuid, UUID uuid2) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null) {
            O000000o(str).unnotify(uuid, uuid2);
        }
    }

    public void indication(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null) {
            O000000o(str).indication(uuid, uuid2, bleNotifyResponse);
        }
    }

    public void unindication(String str, UUID uuid, UUID uuid2) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null) {
            O000000o(str).unindication(uuid, uuid2);
        }
    }

    public void readRemoteRssi(String str, BleReadRssiResponse bleReadRssiResponse) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(str).readRemoteRssi(bleReadRssiResponse);
        }
    }

    public void disconnectAllDevices() {
        for (IBleConnectMaster next : this.f17998O000000o.values()) {
            if (next != null) {
                next.disconnect();
            }
        }
    }

    public void refreshGattCache(String str) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(str).refreshGattCache();
        }
    }

    public void requestConnectionPriority(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(str).requestConnectionPriority(i);
        }
    }

    public void requestMtu(String str, int i, BleRequestMtuResponse bleRequestMtuResponse) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(str).requestMtu(i, bleRequestMtuResponse);
        }
    }

    public void writeNoRspFast(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null && bArr != null) {
            O000000o(str).writeNoRspFast(uuid, uuid2, bArr, bleWriteResponse);
        }
    }

    public void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List<byte[]> list, BleWriteResponse bleWriteResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null && list != null) {
            O000000o(str).writeBatchNoRsp(str, uuid, uuid2, list, bleWriteResponse);
        }
    }

    public void isCharacterExist(String str, UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        if (!TextUtils.isEmpty(str) && uuid != null && uuid2 != null) {
            O000000o(str).isCharacterExist(uuid, uuid2, bleResponse);
        }
    }

    public boolean handleMessage(Message message) {
        ((gmt) message.obj).O000000o();
        return true;
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        this.O00000o0.obtainMessage(0, new gmt(obj, method, objArr)).sendToTarget();
        return true;
    }
}

package _m_j;

import android.os.HandlerThread;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import java.util.HashMap;
import java.util.UUID;

public class bio {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f13004O000000o = "bio";
    private static HashMap<String, bis> O00000Oo = new HashMap<>();
    private static HandlerThread O00000o0;

    private static bis O00000o0(String str) {
        bis bis = O00000Oo.get(str);
        if (bis != null) {
            return bis;
        }
        if (O00000o0 == null) {
            HandlerThread handlerThread = new HandlerThread(f13004O000000o);
            O00000o0 = handlerThread;
            handlerThread.start();
        }
        bis O000000o2 = bip.O000000o(str, O00000o0.getLooper());
        O00000Oo.put(str, O000000o2);
        return O000000o2;
    }

    public static void O000000o(String str, BleConnectOptions bleConnectOptions, bjr bjr) {
        O00000o0(str).O000000o(bleConnectOptions, bjr);
    }

    public static void O000000o(String str) {
        O00000o0(str).O000000o();
    }

    public static void O000000o(String str, UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0(str).O000000o(uuid, uuid2, bjr);
    }

    public static void O000000o(String str, UUID uuid, UUID uuid2, byte[] bArr, bjr bjr) {
        O00000o0(str).O000000o(uuid, uuid2, bArr, bjr);
    }

    public static void O00000Oo(String str, UUID uuid, UUID uuid2, byte[] bArr, bjr bjr) {
        O00000o0(str).O00000Oo(uuid, uuid2, bArr, bjr);
    }

    public static void O000000o(String str, UUID uuid, UUID uuid2, UUID uuid3, bjr bjr) {
        O00000o0(str).O000000o(uuid, uuid2, uuid3, bjr);
    }

    public static void O000000o(String str, UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr, bjr bjr) {
        O00000o0(str).O000000o(uuid, uuid2, uuid3, bArr, bjr);
    }

    public static void O00000Oo(String str, UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0(str).O00000Oo(uuid, uuid2, bjr);
    }

    public static void O00000o0(String str, UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0(str).O00000o0(uuid, uuid2, bjr);
    }

    public static void O000000o(String str, bjr bjr) {
        O00000o0(str).O000000o(bjr);
    }

    public static void O00000o(String str, UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0(str).O00000o(uuid, uuid2, bjr);
    }

    public static void O000000o(String str, int i) {
        O00000o0(str).O000000o(i);
    }

    public static void O00000Oo(String str) {
        O00000o0(str).O00000Oo();
    }
}

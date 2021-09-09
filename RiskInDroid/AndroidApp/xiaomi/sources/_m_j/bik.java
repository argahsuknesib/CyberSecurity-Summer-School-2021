package _m_j;

import java.util.UUID;

public final class bik {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final UUID f13002O000000o = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    public static String O000000o(int i) {
        if (i == 0) {
            return "Disconnected";
        }
        if (i == 1) {
            return "Connecting";
        }
        if (i == 2) {
            return "Connected";
        }
        if (i == 3) {
            return "Disconnecting";
        }
        if (i == 19) {
            return "Service Ready";
        }
        return String.format("Unknown %d", Integer.valueOf(i));
    }
}

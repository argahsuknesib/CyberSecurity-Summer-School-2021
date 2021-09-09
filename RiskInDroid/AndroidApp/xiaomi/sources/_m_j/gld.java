package _m_j;

public final class gld {
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

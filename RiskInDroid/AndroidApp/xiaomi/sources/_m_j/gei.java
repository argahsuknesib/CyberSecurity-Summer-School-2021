package _m_j;

public final class gei extends gdy {
    public final boolean onReceiveMessage(String str, String str2) {
        O000000o(str, str2);
        return true;
    }

    public final boolean onReceiveNotifiedMessage(String str, String str2) {
        O000000o(str, str2);
        return true;
    }

    private static void O000000o(String str, String str2) {
        gsy.O000000o(4, "DeviceBindPushListener", "processMessage messageId:" + str + " " + str2);
    }
}

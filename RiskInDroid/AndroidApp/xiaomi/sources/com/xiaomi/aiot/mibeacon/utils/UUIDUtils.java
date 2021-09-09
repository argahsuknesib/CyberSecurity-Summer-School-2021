package com.xiaomi.aiot.mibeacon.utils;

import java.util.UUID;

public class UUIDUtils {
    public static UUID makeUUID(int i) {
        return UUID.fromString(String.format("0000%04x-0000-1000-8000-00805f9b34fb", Integer.valueOf(i)));
    }

    public static UUID makeUUID(String str) {
        return UUID.fromString(String.format("0000%4s-0000-1000-8000-00805f9b34fb", str));
    }
}

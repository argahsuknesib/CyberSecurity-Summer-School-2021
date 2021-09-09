package com.xiaomi.smarthome.device.api;

public class Permission {
    @Deprecated
    public static final String CALL_PHONE = "android.permission.CALL_PHONE";
    @Deprecated
    public static final String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
    @Deprecated
    public static final String SEND_SMS = "android.permission.SEND_SMS";

    public static final class Group {
        public static final String[] CAMERA = {"android.permission.CAMERA"};
        public static final String[] CONTACTS = {"android.permission.READ_CONTACTS", "android.permission.GET_ACCOUNTS"};
        public static final String[] LOCATION = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        public static final String[] MICROPHONE = {"android.permission.RECORD_AUDIO"};
        public static final String[] PHONE = {"android.permission.READ_PHONE_STATE", Permission.CALL_PHONE};
        @Deprecated
        public static final String[] SMS = {Permission.SEND_SMS, Permission.RECEIVE_SMS};
        public static final String[] STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }
}

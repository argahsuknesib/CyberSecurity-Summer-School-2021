package com.xiaomi.mico.setting.mijia.event;

public class MijiaEvent {

    public enum Reason {
        MAIN_ACTIVITY,
        MICO_LIST,
        SETTINGS,
        HOME_ACTIVITY,
        ROOM_ACTIVITY,
        INIT,
        MICO_MANAGER
    }

    public static class MijiaCurrHomeChanged {
        public final String id;
        public Reason reason;

        public MijiaCurrHomeChanged(String str, Reason reason2) {
            this.id = str;
            this.reason = reason2;
        }
    }

    public static class MijiaCurrRoomChanged {
        public final String name;
        public Reason reason;

        public MijiaCurrRoomChanged(String str, Reason reason2) {
            this.name = str;
            this.reason = reason2;
        }
    }

    public static class MijiaHomeInfoChanged {
        final String homeId;
        public Reason reason;
        final String roomName;

        public MijiaHomeInfoChanged(String str, String str2, Reason reason2) {
            this.homeId = str;
            this.roomName = str2;
            this.reason = reason2;
        }
    }
}

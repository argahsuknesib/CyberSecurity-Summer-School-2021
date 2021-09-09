package com.xiaomi.idm.uwb.constant;

public interface UwbConst {

    public enum DeviceRole implements UwbConst {
        INITIATOR(1),
        RESPONDER(2);
        
        private final int value;

        private DeviceRole(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum Flag implements UwbConst {
        ENCRYPT(1),
        NOT_ENCRYPT(2);
        
        private final int value;

        private Flag(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static Flag fromValue(int i) {
            for (Flag flag : values()) {
                if (flag.value == i) {
                    return flag;
                }
            }
            return null;
        }
    }

    public enum Target implements UwbConst {
        SEND_DATA_TO_HID((byte) 1, "发送数据文件到HID"),
        DATA_FROM_HID((byte) 82, "由Tag发送"),
        SEND_DATA_TO_TAG((byte) 3, "发送数据文件到Tag"),
        DATA_FROM_TAG((byte) 84, "由Tag发送"),
        SEND_DATA_TO_BOUND_DEVICE((byte) 5, "发送JSON RPC到绑定设备（OTU绑定或模组下位机）"),
        DATA_FROM_BOUND_DEVICE((byte) 86, "由Tag发送(JSON RPC)");
        
        private final byte cmd;
        private final String description;

        private Target(byte b, String str) {
            this.cmd = b;
            this.description = str;
        }

        public final byte getCmd() {
            return this.cmd;
        }

        public final String getDescription() {
            return this.description;
        }
    }

    public enum AppId implements UwbConst {
        TAG((byte) 0),
        IDM((byte) 1),
        MI_HOME((byte) 2),
        MI_LINK((byte) 3),
        MI_PAY((byte) 4),
        MI_AUDIO((byte) 5),
        MI_TEST((byte) 6),
        ALL((byte) -1);
        
        private final byte id;

        private AppId(byte b) {
            this.id = b;
        }

        public final byte getId() {
            return this.id;
        }

        public static AppId fromValue(byte b) {
            for (AppId appId : values()) {
                if (appId.id == b) {
                    return appId;
                }
            }
            return null;
        }
    }

    public enum LoginType implements UwbConst {
        MEMBER_LOGIN(0),
        STRANGER_LOGIN(1);
        
        private final int type;

        private LoginType(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }

        public static LoginType fromValue(byte b) {
            for (LoginType loginType : values()) {
                if (loginType.type == b) {
                    return loginType;
                }
            }
            return null;
        }
    }
}

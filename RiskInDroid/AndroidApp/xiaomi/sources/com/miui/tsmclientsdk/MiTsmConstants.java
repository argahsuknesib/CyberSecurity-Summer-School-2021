package com.miui.tsmclientsdk;

public class MiTsmConstants {

    public enum CardType {
        BANK,
        TRAFFIC
    }

    public enum Channel {
        UP
    }

    public enum OperationType {
        LOCK,
        DELETE,
        INSTALL
    }

    public class ErrorCode {
        private ErrorCode() {
        }
    }

    public class DataKey {
        private DataKey() {
        }
    }
}

package com.xiaomi.verificationsdk.internal;

import com.xiaomi.smarthome.R;

public enum ErrorInfo {
    NETWORK_ERROR_INFO(R.string.network_error_info),
    NETWORK_TIMEOUT_INFO(R.string.network_timeout_info),
    SYSTEM_ERROR_INFO(R.string.system_error_info),
    ACCESS_DENIED_INFO(R.string.access_denied_info),
    UNKNOWN_ERROR_INFO(R.string.unknown_error_info);
    
    public int errorMessageId;

    private ErrorInfo(int i) {
        this.errorMessageId = i;
    }

    public static int getMsgIdGivenErrorCode(ErrorCode errorCode) {
        if (errorCode == ErrorCode.ERROR_JSON_EXCEPTION) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_ACCESSDENIED_EXCEPTION) {
            return ACCESS_DENIED_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_AUTHENTICATIONFAILURE_EXCEPTION) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_NETWORK_EXCEPTION) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_ENCRYPT_EXCEPTION) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_HUMANCOMPUTER_VERIFICATION_FAILED) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_CONNECT_UNREACHABLE_EXCEPTION) {
            return NETWORK_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_SOCKET_TIMEOUT_EXCEPTION) {
            return NETWORK_TIMEOUT_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_CONNECT_TIMEOUT_EXCEPTION) {
            return NETWORK_TIMEOUT_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_SERVER) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_INTERRUPTED_EXCEPTION) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_EVENTID_EXPIRED) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_IO_EXCEPTION) {
            return NETWORK_ERROR_INFO.errorMessageId;
        }
        return UNKNOWN_ERROR_INFO.errorMessageId;
    }

    public enum ErrorCode {
        ERROR_SERVER(-1),
        ERROR_JSON_EXCEPTION(1),
        ERROR_ACCESSDENIED_EXCEPTION(2),
        ERROR_AUTHENTICATIONFAILURE_EXCEPTION(3),
        ERROR_NETWORK_EXCEPTION(4),
        ERROR_ENCRYPT_EXCEPTION(5),
        ERROR_INTERRUPTED_EXCEPTION(6),
        ERROR_HUMANCOMPUTER_VERIFICATION_FAILED(7),
        ERROR_EVENTID_EXPIRED(8),
        ERROR_CONNECT_UNREACHABLE_EXCEPTION(9),
        ERROR_SOCKET_TIMEOUT_EXCEPTION(10),
        ERROR_CONNECT_TIMEOUT_EXCEPTION(11),
        ERROR_IO_EXCEPTION(12),
        ERROR_REGISTRATION_SESSION_EXCEPTION(13),
        ERROR_VERIFY_SERVER(14);
        
        private int errorCode;

        private ErrorCode(int i) {
            this.errorCode = i;
        }

        public final int getCode() {
            return this.errorCode;
        }
    }
}

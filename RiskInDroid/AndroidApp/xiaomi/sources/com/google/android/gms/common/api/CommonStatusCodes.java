package com.google.android.gms.common.api;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@KeepForSdk
public class CommonStatusCodes {
    @Deprecated
    public static final int SERVICE_DISABLED = 3;
    @Deprecated
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;

    @KeepForSdk
    protected CommonStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("unknown status code: ");
                sb.append(i);
                return sb.toString();
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
        }
    }
}

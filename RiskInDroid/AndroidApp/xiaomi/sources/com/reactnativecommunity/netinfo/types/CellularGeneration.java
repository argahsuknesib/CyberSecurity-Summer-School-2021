package com.reactnativecommunity.netinfo.types;

import android.net.NetworkInfo;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public enum CellularGeneration {
    CG_2G("2g"),
    CG_3G("3g"),
    CG_4G("4g");
    
    public final String label;

    private CellularGeneration(String str) {
        this.label = str;
    }

    public static CellularGeneration fromNetworkInfo(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return null;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return CG_2G;
            case 3:
            case 5:
            case 6:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 14:
                return CG_3G;
            case 13:
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return CG_4G;
            default:
                return null;
        }
    }
}

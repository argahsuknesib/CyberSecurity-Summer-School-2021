package _m_j;

import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class jah {
    public static String O000000o(int i) {
        if (i == 0) {
            return "SUCCESS";
        }
        if (i == 1) {
            return "GATT CONN L2C FAILURE";
        }
        if (i == 8) {
            return "GATT CONN TIMEOUT";
        }
        if (i == 19) {
            return "GATT CONN TERMINATE PEER USER";
        }
        if (i == 22) {
            return "GATT CONN TERMINATE LOCAL HOST";
        }
        if (i == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i == 62) {
            return "GATT CONN FAIL ESTABLISH";
        }
        if (i == 133) {
            return "GATT ERROR";
        }
        if (i == 256) {
            return "GATT CONN CANCEL ";
        }
        return "UNKNOWN (" + i + ")";
    }

    public static String O00000Oo(int i) {
        if (i == 26) {
            return "HCI ERROR UNSUPPORTED REMOTE FEATURE";
        }
        if (i == 30) {
            return "HCI ERROR INVALID LMP PARAM";
        }
        if (i == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i == 42) {
            return "HCI ERROR DIFF TRANSACTION COLLISION";
        }
        if (i == 257) {
            return "TOO MANY OPEN CONNECTIONS";
        }
        if (i == 58) {
            return "GATT CONTROLLER BUSY";
        }
        if (i == 59) {
            return "GATT UNACCEPT CONN INTERVAL";
        }
        switch (i) {
            case 1:
                return "GATT INVALID HANDLE";
            case 2:
                return "GATT READ NOT PERMIT";
            case 3:
                return "GATT WRITE NOT PERMIT";
            case 4:
                return "GATT INVALID PDU";
            case 5:
                return "GATT INSUF AUTHENTICATION";
            case 6:
                return "GATT REQ NOT SUPPORTED";
            case 7:
                return "GATT INVALID OFFSET";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return "GATT INSUF AUTHORIZATION";
            case 9:
                return "GATT PREPARE Q FULL";
            case 10:
                return "GATT NOT FOUND";
            case 11:
                return "GATT NOT LONG";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return "GATT INSUF KEY SIZE";
            case 13:
                return "GATT INVALID ATTR LEN";
            case 14:
                return "GATT ERR UNLIKELY";
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return "GATT INSUF ENCRYPTION";
            case 16:
                return "GATT UNSUPPORT GRP TYPE";
            case 17:
                return "GATT INSUF RESOURCE";
            default:
                switch (i) {
                    case NotificationCompat.FLAG_HIGH_PRIORITY /*128*/:
                        return "GATT NO RESOURCES";
                    case 129:
                        return "GATT INTERNAL ERROR";
                    case 130:
                        return "GATT WRONG STATE";
                    case 131:
                        return "GATT DB FULL";
                    case 132:
                        return "GATT BUSY";
                    case 133:
                        return "GATT ERROR";
                    case 134:
                        return "GATT CMD STARTED";
                    case 135:
                        return "GATT ILLEGAL PARAMETER";
                    case 136:
                        return "GATT PENDING";
                    case 137:
                        return "GATT AUTH FAIL";
                    case 138:
                        return "GATT MORE";
                    case 139:
                        return "GATT INVALID CFG";
                    case 140:
                        return "GATT SERVICE STARTED";
                    case 141:
                        return "GATT ENCRYPTED NO MITM";
                    case 142:
                        return "GATT NOT ENCRYPTED";
                    case 143:
                        return "GATT CONGESTED";
                    default:
                        switch (i) {
                            case 253:
                                return "GATT CCCD CFG ERROR";
                            case 254:
                                return "GATT PROCEDURE IN PROGRESS";
                            case 255:
                                return "GATT VALUE OUT OF RANGE";
                            default:
                                switch (i) {
                                    case 4096:
                                        return "DFU DEVICE DISCONNECTED";
                                    case 4097:
                                        return "DFU FILE NOT FOUND";
                                    case 4098:
                                        return "DFU FILE ERROR";
                                    case 4099:
                                        return "DFU NOT A VALID HEX FILE";
                                    case 4100:
                                        return "DFU IO EXCEPTION";
                                    case 4101:
                                        return "DFU SERVICE DISCOVERY NOT STARTED";
                                    case 4102:
                                        return "DFU CHARACTERISTICS NOT FOUND";
                                    default:
                                        switch (i) {
                                            case 4104:
                                                return "DFU INVALID RESPONSE";
                                            case 4105:
                                                return "DFU FILE TYPE NOT SUPPORTED";
                                            case 4106:
                                                return "BLUETOOTH ADAPTER DISABLED";
                                            case 4107:
                                            case 4108:
                                                return "DFU INIT PACKET REQUIRED";
                                            case 4109:
                                                return "DFU CRC ERROR";
                                            case 4110:
                                                return "DFU DEVICE NOT BONDED";
                                            default:
                                                return "UNKNOWN (" + i + ")";
                                        }
                                }
                        }
                }
        }
    }

    public static String O00000o0(int i) {
        int i2 = i & 3840;
        if (i2 == 256) {
            return jai.O000000o(i);
        }
        if (i2 == 512) {
            return jaj.O000000o(i);
        }
        if (i2 == 1024) {
            return jaj.O00000Oo(i);
        }
        if (i2 == 2048) {
            return jaj.O00000o0(i);
        }
        return "UNKNOWN (" + i + ")";
    }
}

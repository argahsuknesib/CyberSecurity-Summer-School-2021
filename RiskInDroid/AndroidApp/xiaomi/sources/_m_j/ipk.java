package _m_j;

import android.content.Context;
import android.os.Build;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.device.api.Permission;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ipk implements ipa {
    public final boolean O000000o(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String O000000o2 : strArr) {
            if (!O000000o(context, O000000o2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean O000000o(Context context, String str) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2062386608:
                    if (str.equals("android.permission.READ_SMS")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1928411001:
                    if (str.equals("android.permission.READ_CALENDAR")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1921431796:
                    if (str.equals("android.permission.READ_CALL_LOG")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1479758289:
                    if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1238066820:
                    if (str.equals("android.permission.BODY_SENSORS")) {
                        c = 16;
                        break;
                    }
                    break;
                case -895679497:
                    if (str.equals("android.permission.RECEIVE_MMS")) {
                        c = 18;
                        break;
                    }
                    break;
                case -895673731:
                    if (str.equals(Permission.RECEIVE_SMS)) {
                        c = 21;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c = 22;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c = 6;
                        break;
                    }
                    break;
                case -5573545:
                    if (str.equals("android.permission.READ_PHONE_STATE")) {
                        c = 9;
                        break;
                    }
                    break;
                case 52602690:
                    if (str.equals(Permission.SEND_SMS)) {
                        c = 17;
                        break;
                    }
                    break;
                case 112197485:
                    if (str.equals(Permission.CALL_PHONE)) {
                        c = 10;
                        break;
                    }
                    break;
                case 214526995:
                    if (str.equals("android.permission.WRITE_CONTACTS")) {
                        c = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        c = 2;
                        break;
                    }
                    break;
                case 603653886:
                    if (str.equals("android.permission.WRITE_CALENDAR")) {
                        c = 1;
                        break;
                    }
                    break;
                case 610633091:
                    if (str.equals("android.permission.WRITE_CALL_LOG")) {
                        c = 12;
                        break;
                    }
                    break;
                case 784519842:
                    if (str.equals("android.permission.USE_SIP")) {
                        c = 14;
                        break;
                    }
                    break;
                case 952819282:
                    if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1271781903:
                    if (str.equals("android.permission.GET_ACCOUNTS")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c = 23;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1977429404:
                    if (str.equals("android.permission.READ_CONTACTS")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2133799037:
                    if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                        c = 13;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new ioq(context).O000000o();
                case 1:
                    return new ior(context).O000000o();
                case 2:
                    return new iou(context).O000000o();
                case 3:
                    return new iov(context).O000000o();
                case 4:
                    return new iow(context.getContentResolver()).O000000o();
                case 5:
                    return true;
                case 6:
                    return new ioy(context).O000000o();
                case 7:
                    return new ioz(context).O000000o();
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    return new ipd(context).O000000o();
                case 9:
                    return new ipc(context).O000000o();
                case 10:
                    return true;
                case 11:
                    return new ios(context).O000000o();
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return new iot(context).O000000o();
                case 13:
                    return new iop(context).O000000o();
                case 14:
                    return new ipf(context).O000000o();
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    return true;
                case 16:
                    return new ipe(context).O000000o();
                case 17:
                case 18:
                    return true;
                case 19:
                    return new ipg(context).O000000o();
                case 20:
                case 21:
                    return true;
                case 22:
                    return new ipi().O000000o();
                case 23:
                    return new ipj().O000000o();
                default:
                    return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}

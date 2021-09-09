package _m_j;

import android.content.Context;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Permission;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class iol {
    public static List<String> O000000o(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            char c = 65535;
            switch (next.hashCode()) {
                case -2062386608:
                    if (next.equals("android.permission.READ_SMS")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1928411001:
                    if (next.equals("android.permission.READ_CALENDAR")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1921431796:
                    if (next.equals("android.permission.READ_CALL_LOG")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1888586689:
                    if (next.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1479758289:
                    if (next.equals("android.permission.RECEIVE_WAP_PUSH")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1238066820:
                    if (next.equals("android.permission.BODY_SENSORS")) {
                        c = 15;
                        break;
                    }
                    break;
                case -895679497:
                    if (next.equals("android.permission.RECEIVE_MMS")) {
                        c = 20;
                        break;
                    }
                    break;
                case -895673731:
                    if (next.equals(Permission.RECEIVE_SMS)) {
                        c = 17;
                        break;
                    }
                    break;
                case -406040016:
                    if (next.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c = 21;
                        break;
                    }
                    break;
                case -63024214:
                    if (next.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c = 7;
                        break;
                    }
                    break;
                case -5573545:
                    if (next.equals("android.permission.READ_PHONE_STATE")) {
                        c = 9;
                        break;
                    }
                    break;
                case 52602690:
                    if (next.equals(Permission.SEND_SMS)) {
                        c = 16;
                        break;
                    }
                    break;
                case 112197485:
                    if (next.equals(Permission.CALL_PHONE)) {
                        c = 10;
                        break;
                    }
                    break;
                case 214526995:
                    if (next.equals("android.permission.WRITE_CONTACTS")) {
                        c = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (next.equals("android.permission.CAMERA")) {
                        c = 2;
                        break;
                    }
                    break;
                case 603653886:
                    if (next.equals("android.permission.WRITE_CALENDAR")) {
                        c = 1;
                        break;
                    }
                    break;
                case 610633091:
                    if (next.equals("android.permission.WRITE_CALL_LOG")) {
                        c = 12;
                        break;
                    }
                    break;
                case 784519842:
                    if (next.equals("android.permission.USE_SIP")) {
                        c = 13;
                        break;
                    }
                    break;
                case 952819282:
                    if (next.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1271781903:
                    if (next.equals("android.permission.GET_ACCOUNTS")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1365911975:
                    if (next.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1831139720:
                    if (next.equals("android.permission.RECORD_AUDIO")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1977429404:
                    if (next.equals("android.permission.READ_CONTACTS")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    String string = context.getString(R.string.yp_permission_name_calendar);
                    if (arrayList.contains(string)) {
                        break;
                    } else {
                        arrayList.add(string);
                        break;
                    }
                case 2:
                    String string2 = context.getString(R.string.yp_permission_name_camera);
                    if (arrayList.contains(string2)) {
                        break;
                    } else {
                        arrayList.add(string2);
                        break;
                    }
                case 3:
                case 4:
                case 5:
                    String string3 = context.getString(R.string.yp_permission_name_contacts);
                    if (arrayList.contains(string3)) {
                        break;
                    } else {
                        arrayList.add(string3);
                        break;
                    }
                case 6:
                case 7:
                    String string4 = context.getString(R.string.yp_permission_name_location);
                    if (arrayList.contains(string4)) {
                        break;
                    } else {
                        arrayList.add(string4);
                        break;
                    }
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    String string5 = context.getString(R.string.yp_permission_name_microphone);
                    if (arrayList.contains(string5)) {
                        break;
                    } else {
                        arrayList.add(string5);
                        break;
                    }
                case 9:
                case 10:
                case 11:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                case 14:
                    String string6 = context.getString(R.string.yp_permission_name_phone);
                    if (arrayList.contains(string6)) {
                        break;
                    } else {
                        arrayList.add(string6);
                        break;
                    }
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    String string7 = context.getString(R.string.yp_permission_name_sensors);
                    if (arrayList.contains(string7)) {
                        break;
                    } else {
                        arrayList.add(string7);
                        break;
                    }
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    String string8 = context.getString(R.string.yp_permission_name_sms);
                    if (arrayList.contains(string8)) {
                        break;
                    } else {
                        arrayList.add(string8);
                        break;
                    }
                case 21:
                case 22:
                    String string9 = context.getString(R.string.yp_permission_name_storage);
                    if (arrayList.contains(string9)) {
                        break;
                    } else {
                        arrayList.add(string9);
                        break;
                    }
            }
        }
        return arrayList;
    }
}

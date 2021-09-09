package com.google.android.gms.internal.measurement;

import com.google.android.exoplayer2.C;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

final class zzabg {
    static String zza(zzyw zzyw) {
        String str;
        zzabh zzabh = new zzabh(zzyw);
        StringBuilder sb = new StringBuilder(zzabh.size());
        for (int i = 0; i < zzabh.size(); i++) {
            int zzae = zzabh.zzae(i);
            if (zzae == 34) {
                str = "\\\"";
            } else if (zzae == 39) {
                str = "\\'";
            } else if (zzae != 92) {
                switch (zzae) {
                    case 7:
                        str = "\\a";
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (zzae < 32 || zzae > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzae >>> 6) & 3) + 48));
                            sb.append((char) (((zzae >>> 3) & 7) + 48));
                            zzae = (zzae & 7) + 48;
                        }
                        sb.append((char) zzae);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}

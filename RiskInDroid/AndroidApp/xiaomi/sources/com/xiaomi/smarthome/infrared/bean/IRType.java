package com.xiaomi.smarthome.infrared.bean;

import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public enum IRType {
    STB(1),
    TV(2),
    BOX(3),
    DVD(4),
    AC(5),
    NO_STATE_AC(5),
    PRO(6),
    PA(7),
    FAN(8),
    SLR(9),
    LIGHT(10),
    AIR_CLEANER(11),
    WATER_HEATER(12),
    Unknown(0);
    
    private int value = 0;

    private IRType(int i) {
        this.value = i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static IRType valueOfModel(String str) {
        char c;
        switch (str.hashCode()) {
            case -2132619104:
                if (str.equals("miir.stb.ir01")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1705284246:
                if (str.equals("miir.camera.ir01")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case -1538046743:
                if (str.equals("miir.remote.ir01")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case -672704689:
                if (str.equals("miir.dvd.ir01")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -651195253:
                if (str.equals("miir.light.ir01")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -1574995:
                if (str.equals("miir.tv.ir01")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1225669421:
                if (str.equals("miir.waterheater.ir01")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case 1494818283:
                if (str.equals("miir.airpurifier.ir01")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1510596542:
                if (str.equals("miir.aircondition.ir01")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1510596543:
                if (str.equals("miir.aircondition.ir02")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1641499374:
                if (str.equals("miir.fan.ir01")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 1645729317:
                if (str.equals("miir.projector.ir01")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1957550456:
                if (str.equals("miir.tvbox.ir01")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2143373335:
                if (str.equals("miir.wifispeaker.ir01")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return STB;
            case 1:
                return TV;
            case 2:
                return BOX;
            case 3:
                return DVD;
            case 4:
                return NO_STATE_AC;
            case 5:
                return AC;
            case 6:
                return PRO;
            case 7:
                return PA;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return FAN;
            case 9:
                return SLR;
            case 10:
                return LIGHT;
            case 11:
                return AIR_CLEANER;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return WATER_HEATER;
            case 13:
                return Unknown;
            default:
                return Unknown;
        }
    }

    public static IRType valueOf(int i) {
        switch (i) {
            case 1:
                return STB;
            case 2:
                return TV;
            case 3:
                return BOX;
            case 4:
                return DVD;
            case 5:
                return AC;
            case 6:
                return PRO;
            case 7:
                return PA;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return FAN;
            case 9:
                return SLR;
            case 10:
                return LIGHT;
            case 11:
                return AIR_CLEANER;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return WATER_HEATER;
            default:
                return Unknown;
        }
    }

    /* renamed from: com.xiaomi.smarthome.infrared.bean.IRType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f9039O000000o = new int[IRType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f9039O000000o[IRType.STB.ordinal()] = 1;
            f9039O000000o[IRType.TV.ordinal()] = 2;
            f9039O000000o[IRType.BOX.ordinal()] = 3;
            f9039O000000o[IRType.DVD.ordinal()] = 4;
            f9039O000000o[IRType.NO_STATE_AC.ordinal()] = 5;
            f9039O000000o[IRType.AC.ordinal()] = 6;
            f9039O000000o[IRType.PRO.ordinal()] = 7;
            f9039O000000o[IRType.PA.ordinal()] = 8;
            f9039O000000o[IRType.FAN.ordinal()] = 9;
            f9039O000000o[IRType.SLR.ordinal()] = 10;
            f9039O000000o[IRType.LIGHT.ordinal()] = 11;
            f9039O000000o[IRType.AIR_CLEANER.ordinal()] = 12;
            f9039O000000o[IRType.WATER_HEATER.ordinal()] = 13;
            f9039O000000o[IRType.Unknown.ordinal()] = 14;
        }
    }

    public static int getInfraredControllerLogo(IRType iRType) {
        switch (AnonymousClass1.f9039O000000o[iRType.ordinal()]) {
            case 1:
                return R.drawable.ir_main_device_list_settopbox;
            case 2:
                return R.drawable.ir_main_device_list_mitv;
            case 3:
                return R.drawable.ir_main_device_list_mibox;
            case 4:
                return R.drawable.ir_main_device_list_dvd;
            case 5:
            case 6:
                return R.drawable.ir_main_device_list_air;
            case 7:
                return R.drawable.ir_main_device_list_projector;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return R.drawable.ir_main_device_list_amplifier;
            case 9:
                return R.drawable.ir_main_device_list_fan;
            case 10:
                return R.drawable.ir_main_device_list_camera;
            case 11:
                return R.drawable.ir_device_list_lamp;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return R.drawable.ir_main_device_list_purifier;
            case 13:
                return R.drawable.ir_man_device_list_water_heater;
            case 14:
                return R.drawable.ir_main_device_list_others;
            default:
                return 0;
        }
    }

    public final int value() {
        return this.value;
    }
}

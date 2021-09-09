package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ejo {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15526O000000o;

    public ejo() {
        this.f15526O000000o = 0;
    }

    public ejo(int i) {
        this.f15526O000000o = i;
    }

    public final boolean O000000o() {
        return this.f15526O000000o != 0;
    }

    public final int O00000Oo() {
        switch (this.f15526O000000o) {
            case 0:
                return 0;
            case 1:
                return R.string.passport_bad_authentication;
            case 2:
                return R.string.passport_error_network;
            case 3:
                return R.string.passport_error_server;
            case 4:
                return R.string.passport_access_denied;
            case 5:
            case GmsLogger.MAX_PII_TAG_LENGTH:
            case 16:
            default:
                return R.string.passport_error_unknown;
            case 6:
                return R.string.sns_access_token_expired_warning;
            case 7:
                return R.string.passport_wrong_vcode;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return R.string.error_dup_binded_email;
            case 9:
                return R.string.error_invalid_bind_address;
            case 10:
                return R.string.get_phone_verifycode_exceed_limit;
            case 11:
                return R.string.exceed_binded_phone_times_notice;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                return R.string.passport_wrong_captcha;
            case 13:
                return R.string.resend_email_reach_limit_message;
            case 14:
                return R.string.passport_error_device_id;
            case 17:
                return R.string.passport_wrong_phone_number_format;
        }
    }
}

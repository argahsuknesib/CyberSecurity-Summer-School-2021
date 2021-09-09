package com.miui.tsmclient.model;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GmsLogger;
import com.miui.tsmclient.util.ResUtils;

public class ErrorCode {
    public static boolean isSuccess(int i) {
        return i == 0;
    }

    public static String getErrorText(Context context, int i, String str) {
        return TextUtils.isEmpty(str) ? findText(context, i) : str;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String findText(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == 0) {
            return ResUtils.getString(context, "error_common");
        }
        if (i == 1) {
            return ResUtils.getString(context, "error_invalid_param");
        }
        if (i == 2) {
            return ResUtils.getString(context, "error_network");
        }
        if (i == 5) {
            return ResUtils.getString(context, "error_login_account");
        }
        if (i == 6) {
            return ResUtils.getString(context, "error_user_cancel");
        }
        if (i == 7) {
            return ResUtils.getString(context, "error_auth_failed");
        }
        if (i == 10) {
            return ResUtils.getString(context, "error_nfc");
        }
        if (i == 11) {
            return ResUtils.getString(context, "error_interrupted");
        }
        if (i == 20) {
            return ResUtils.getString(context, "error_no_permission");
        }
        if (i == 3025) {
            return ResUtils.getString(context, "bank_system_busying");
        }
        if (i == 1001) {
            return ResUtils.getString(context, "error_recharge_failed");
        }
        if (i == 1002) {
            return ResUtils.getString(context, "card_recharge_promo_code_exhausted");
        }
        switch (i) {
            case 13:
                return ResUtils.getString(context, "error_get_cplc");
            case 14:
                return ResUtils.getString(context, "error_get_account");
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return ResUtils.getString(context, "error_get_imei");
            case 16:
                return ResUtils.getString(context, "error_server_response");
            default:
                switch (i) {
                    case 31:
                        return ResUtils.getString(context, "error_nfc_disabled");
                    case 32:
                        return ResUtils.getString(context, "error_se_restricted");
                    case 33:
                        return ResUtils.getString(context, "error_ese_route_disabled");
                    default:
                        switch (i) {
                            case 3001:
                                break;
                            case 3002:
                                return ResUtils.getString(context, "bank_card_user_account_expire");
                            case 3003:
                                return ResUtils.getString(context, "bank_card_user_not_reserve_phone");
                            case 3004:
                                return ResUtils.getString(context, "sms_code_wrong");
                            case 3005:
                                return ResUtils.getString(context, "sms_expire");
                            default:
                                switch (i) {
                                    case 3008:
                                        return ResUtils.getString(context, "apply_times_exceed_limit");
                                    case 3009:
                                        return ResUtils.getString(context, "failed_times_exceed_limit");
                                    case 3010:
                                        return ResUtils.getString(context, "user_account_no_apply_privilege");
                                    case 3011:
                                        return ResUtils.getString(context, "otp_info_reverify");
                                    case 3012:
                                        return ResUtils.getString(context, "user_account_not_exist");
                                    case 3013:
                                        return ResUtils.getString(context, "bank_card_not_supported");
                                    case 3014:
                                        return ResUtils.getString(context, "user_identity_verify_failed");
                                    case 3015:
                                        break;
                                    case 3016:
                                        return ResUtils.getString(context, "user_account_in_blank_list");
                                    case 3017:
                                        return ResUtils.getString(context, "fpan_duplicated_apply");
                                    case 3018:
                                        return ResUtils.getString(context, "total_apply_num_exceed_limit");
                                    case 3019:
                                        return ResUtils.getString(context, "card_status_no_apply_privilege");
                                    case 3020:
                                        return ResUtils.getString(context, "card_type_no_apply_privilege");
                                    case 3021:
                                        return ResUtils.getString(context, "activate_failed");
                                    case 3022:
                                        return ResUtils.getString(context, "activate_failed_no_retry");
                                    case 3023:
                                        return ResUtils.getString(context, "user_no_apply_privilege");
                                    default:
                                        int i2 = i - 1000000;
                                        if (i2 > 0) {
                                            i = i2;
                                        }
                                        if (i == 10041) {
                                            return ResUtils.getString(context, "bank_error");
                                        }
                                        return ResUtils.getString(context, "error_common");
                                }
                        }
                        return ResUtils.getString(context, "bank_card_verify_failed");
                }
        }
    }
}

package com.xiaomi.passport.servicetoken;

import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import java.io.IOException;

public final class AMAuthTokenConverter {
    public static Exception O000000o(ServiceTokenResult serviceTokenResult) {
        if (serviceTokenResult == null || serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE || serviceTokenResult.O00000oO == null || !serviceTokenResult.O00000oO.startsWith("error#")) {
            return null;
        }
        String substring = serviceTokenResult.O00000oO.substring(6);
        if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_CANCELLED) {
            return new OperationCanceledException(substring);
        }
        if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_IOERROR) {
            return new IOException(substring);
        }
        if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR) {
            return new AuthenticatorException(substring);
        }
        if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_OLD_MIUI_ACCOUNT_MANAGER_PERMISSION_ISSUE) {
            return new SecurityException(substring);
        }
        return new AuthenticatorException("errorcode:" + serviceTokenResult.O00000o + ";errorMsg");
    }

    public static ServiceTokenResult O000000o(Bundle bundle, String str) {
        ServiceTokenResult.ErrorCode errorCode;
        if (bundle == null) {
            ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(str);
            o000000o.O00000oo = ServiceTokenResult.ErrorCode.ERROR_UNKNOWN;
            return o000000o.O000000o();
        } else if (bundle.containsKey("authtoken")) {
            ServiceTokenResult O000000o2 = O000000o(str, bundle.getString("authtoken"), false);
            if (O000000o2 != null) {
                return O000000o2;
            }
            ServiceTokenResult.O000000o o000000o2 = new ServiceTokenResult.O000000o(str);
            o000000o2.O00000oo = ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR;
            o000000o2.O00000o = "invalid auth token";
            return o000000o2.O000000o();
        } else {
            Intent intent = (Intent) bundle.getParcelable("intent");
            if (intent != null) {
                ServiceTokenResult.O000000o o000000o3 = new ServiceTokenResult.O000000o(str);
                o000000o3.O00000oo = ServiceTokenResult.ErrorCode.ERROR_USER_INTERACTION_NEEDED;
                o000000o3.O0000O0o = intent;
                return o000000o3.O000000o();
            } else if (!bundle.containsKey("errorCode")) {
                ServiceTokenResult.O000000o o000000o4 = new ServiceTokenResult.O000000o(str);
                o000000o4.O00000oo = ServiceTokenResult.ErrorCode.ERROR_UNKNOWN;
                return o000000o4.O000000o();
            } else {
                int i = bundle.getInt("errorCode");
                String string = bundle.getString("errorMessage");
                switch (i) {
                    case 1:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_REMOTE_EXCEPTION;
                        break;
                    case 2:
                    default:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_UNKNOWN;
                        break;
                    case 3:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_IOERROR;
                        break;
                    case 4:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_CANCELLED;
                        break;
                    case 5:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR;
                        break;
                    case 6:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR;
                        break;
                    case 7:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR;
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR;
                        break;
                    case 9:
                        errorCode = ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR;
                        break;
                }
                ServiceTokenResult.O000000o o000000o5 = new ServiceTokenResult.O000000o(str);
                o000000o5.O00000oo = errorCode;
                o000000o5.O00000o = i + "#" + string;
                return o000000o5.O000000o();
            }
        }
    }

    public static Bundle O00000Oo(ServiceTokenResult serviceTokenResult) throws ConvertException {
        String str = serviceTokenResult.O00000oO;
        ServiceTokenResult.ErrorCode errorCode = serviceTokenResult.O00000o;
        if (errorCode == ServiceTokenResult.ErrorCode.ERROR_OLD_MIUI_ACCOUNT_MANAGER_PERMISSION_ISSUE) {
            throw new SecurityException(str + serviceTokenResult.O00000oo);
        } else if (errorCode == ServiceTokenResult.ErrorCode.ERROR_NONE) {
            Bundle bundle = new Bundle();
            bundle.putString("authtoken", O00000o0(serviceTokenResult));
            return bundle;
        } else if (errorCode == ServiceTokenResult.ErrorCode.ERROR_USER_INTERACTION_NEEDED) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("intent", serviceTokenResult.O0000O0o);
            return bundle2;
        } else {
            if (str != null && str.matches("\\d#.*")) {
                try {
                    int indexOf = str.indexOf("#");
                    int intValue = Integer.valueOf(str.substring(0, indexOf)).intValue();
                    String substring = str.substring(indexOf + 1);
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("errorCode", intValue);
                    bundle3.putString("errorMessage", substring);
                    return bundle3;
                } catch (NumberFormatException unused) {
                }
            }
            throw new ConvertException(errorCode, str, (byte) 0);
        }
    }

    public static String O00000o0(ServiceTokenResult serviceTokenResult) {
        if (serviceTokenResult == null) {
            return null;
        }
        if (serviceTokenResult.O00000o0 == null) {
            return serviceTokenResult.O00000Oo;
        }
        return String.format("%s%s%s", serviceTokenResult.O00000Oo, ",", serviceTokenResult.O00000o0);
    }

    public static ServiceTokenResult O000000o(String str, String str2, boolean z) {
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split(",");
        if (str != null && str.startsWith("weblogin:")) {
            str3 = split[0];
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
        } else if (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
            return null;
        } else {
            String str5 = split[0];
            str4 = split[1];
            str3 = str5;
        }
        ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(str);
        o000000o.O00000oo = ServiceTokenResult.ErrorCode.ERROR_NONE;
        o000000o.O00000Oo = str3;
        o000000o.O00000o0 = str4;
        o000000o.O0000OoO = z;
        return o000000o.O000000o();
    }

    public static class ConvertException extends Exception {
        public final ServiceTokenResult.ErrorCode errorCode;
        public final String errorMsg;

        /* synthetic */ ConvertException(ServiceTokenResult.ErrorCode errorCode2, String str, byte b) {
            this(errorCode2, str);
        }

        private ConvertException(ServiceTokenResult.ErrorCode errorCode2, String str) {
            this.errorCode = errorCode2;
            this.errorMsg = str;
        }
    }
}

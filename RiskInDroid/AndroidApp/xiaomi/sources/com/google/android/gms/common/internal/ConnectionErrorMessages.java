package com.google.android.gms.common.internal;

import _m_j.o0OO00OO;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.xiaomi.smarthome.R;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ConnectionErrorMessages {
    private static final o0OO00OO<String, String> zzse = new o0OO00OO<>();

    private ConnectionErrorMessages() {
    }

    public static String getAppName(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String getErrorDialogButtonMessage(Context context, int i) {
        return context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? 17039370 : R.string.common_google_play_services_enable_button : R.string.common_google_play_services_update_button : R.string.common_google_play_services_install_button);
    }

    public static String getErrorMessage(Context context, int i) {
        Resources resources = context.getResources();
        String appName = getAppName(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, appName);
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, appName);
            } else if (i == 5) {
                return zza(context, "common_google_play_services_invalid_account_text", appName);
            } else {
                if (i == 7) {
                    return zza(context, "common_google_play_services_network_error_text", appName);
                }
                if (i == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, appName);
                } else if (i == 20) {
                    return zza(context, "common_google_play_services_restricted_profile_text", appName);
                } else {
                    switch (i) {
                        case 16:
                            return zza(context, "common_google_play_services_api_unavailable_text", appName);
                        case 17:
                            return zza(context, "common_google_play_services_sign_in_failed_text", appName);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, appName);
                        default:
                            return resources.getString(R.string.common_google_play_services_unknown_issue, appName);
                    }
                }
            }
        } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, appName);
        }
    }

    public static String getErrorNotificationMessage(Context context, int i) {
        return i == 6 ? zza(context, "common_google_play_services_resolution_required_text", getAppName(context)) : getErrorMessage(context, i);
    }

    public static String getErrorNotificationTitle(Context context, int i) {
        String zzb = i == 6 ? zzb(context, "common_google_play_services_resolution_required_title") : getErrorTitle(context, i);
        return zzb == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : zzb;
    }

    public static String getErrorTitle(Context context, int i) {
        String str;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zzb(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zzb(context, "common_google_play_services_network_error_title");
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                str = sb.toString();
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zzb(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zzb(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    private static String zza(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zzb = zzb(context, str);
        if (zzb == null) {
            zzb = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zzb, str2);
    }

    private static String zzb(Context context, String str) {
        synchronized (zzse) {
            String str2 = zzse.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            zzse.put(str, string);
            return string;
        }
    }
}

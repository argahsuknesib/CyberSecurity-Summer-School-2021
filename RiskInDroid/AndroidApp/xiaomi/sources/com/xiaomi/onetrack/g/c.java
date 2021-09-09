package com.xiaomi.onetrack.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.q;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class c {
    @SuppressLint({"MissingPermission"})
    public static boolean a() {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a2.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception unused) {
            q.a("NetworkUtil", "isNetworkConnected exception");
            return false;
        }
    }

    public static OneTrack.NetType a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return OneTrack.NetType.WIFI;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                            case 16:
                                return OneTrack.NetType.MOBILE_2G;
                            case 3:
                            case 5:
                            case 6:
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            case 9:
                            case 10:
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            case 14:
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                            case 17:
                                return OneTrack.NetType.MOBILE_3G;
                            case 13:
                            case 18:
                            case 19:
                                return OneTrack.NetType.MOBILE_4G;
                            case 20:
                                return OneTrack.NetType.MOBILE_5G;
                            default:
                                return OneTrack.NetType.UNKNOWN;
                        }
                    } else {
                        if (activeNetworkInfo.getType() == 9) {
                            return OneTrack.NetType.ETHERNET;
                        }
                        return OneTrack.NetType.UNKNOWN;
                    }
                }
            }
            return OneTrack.NetType.NOT_CONNECTED;
        } catch (Exception e) {
            q.b("NetworkUtil", "getNetworkState error", e);
        }
    }
}

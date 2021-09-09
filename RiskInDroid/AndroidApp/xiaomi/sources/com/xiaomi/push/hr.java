package com.xiaomi.push;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class hr extends Enum<hr> {

    /* renamed from: a  reason: collision with root package name */
    public static final hr f6391a = new hr("DeviceInfo", 0, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ hr[] f50a = a();
    public static final hr b = new hr("AppInstallList", 1, 2);
    public static final hr c = new hr("AppActiveList", 2, 3);
    public static final hr d = new hr("Bluetooth", 3, 4);
    public static final hr e = new hr("Location", 4, 5);
    public static final hr f = new hr("Account", 5, 6);
    public static final hr g = new hr("WIFI", 6, 7);
    public static final hr h = new hr("Cellular", 7, 8);
    public static final hr i = new hr("TopApp", 8, 9);
    public static final hr j = new hr("BroadcastAction", 9, 10);
    public static final hr k = new hr("BroadcastActionAdded", 10, 11);
    public static final hr l = new hr("BroadcastActionRemoved", 11, 12);
    public static final hr m = new hr("BroadcastActionReplaced", 12, 13);
    public static final hr n = new hr("BroadcastActionDataCleared", 13, 14);
    public static final hr o = new hr("BroadcastActionRestarted", 14, 15);
    public static final hr p = new hr("BroadcastActionChanged", 15, 16);
    public static final hr q = new hr("AppPermission", 16, 17);
    public static final hr r = new hr("WifiDevicesMac", 17, 18);
    public static final hr s = new hr("ActivityActiveTimeStamp", 18, 19);
    public static final hr t = new hr("DeviceBaseInfo", 19, 20);
    public static final hr u = new hr("DeviceInfoV2", 20, 21);
    public static final hr v = new hr("Battery", 21, 22);
    public static final hr w = new hr("Storage", 22, 23);
    public static final hr x = new hr("AppIsInstalled", 23, 24);

    /* renamed from: a  reason: collision with other field name */
    private final int f51a;

    private hr(String str, int i2, int i3) {
        this.f51a = i3;
    }

    public static hr a(int i2) {
        switch (i2) {
            case 1:
                return f6391a;
            case 2:
                return b;
            case 3:
                return c;
            case 4:
                return d;
            case 5:
                return e;
            case 6:
                return f;
            case 7:
                return g;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return h;
            case 9:
                return i;
            case 10:
                return j;
            case 11:
                return k;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return l;
            case 13:
                return m;
            case 14:
                return n;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return o;
            case 16:
                return p;
            case 17:
                return q;
            case 18:
                return r;
            case 19:
                return s;
            case 20:
                return t;
            case 21:
                return u;
            case 22:
                return v;
            case 23:
                return w;
            case 24:
                return x;
            default:
                return null;
        }
    }

    public static hr valueOf(String str) {
        return (hr) Enum.valueOf(hr.class, str);
    }

    public static hr[] values() {
        return (hr[]) f50a.clone();
    }

    public final int a() {
        return this.f51a;
    }
}

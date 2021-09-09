package com.xiaomi.push;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class hp extends Enum<hp> {
    public static final hp A = new hp("Broadcast", 26, 103);
    public static final hp B = new hp("BatchPresence", 27, 104);
    public static final hp C = new hp("BatchMessage", 28, 105);
    public static final hp D = new hp("StatCounter", 29, 107);
    public static final hp E = new hp("FetchTopicMessage", 30, 108);
    public static final hp F = new hp("DeleteAliasCache", 31, 109);
    public static final hp G = new hp("UpdateRegistration", 32, 110);
    public static final hp H = new hp("BatchMessageNew", 33, 112);
    public static final hp I = new hp("PublicWelfareMessage", 34, 113);
    public static final hp J = new hp("RevokeMessage", 35, 114);
    public static final hp K = new hp("SimulatorJob", 36, 200);

    /* renamed from: a  reason: collision with root package name */
    public static final hp f6389a = new hp("Registration", 0, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ hp[] f46a = a();
    public static final hp b = new hp("UnRegistration", 1, 2);
    public static final hp c = new hp("Subscription", 2, 3);
    public static final hp d = new hp("UnSubscription", 3, 4);
    public static final hp e = new hp("SendMessage", 4, 5);
    public static final hp f = new hp("AckMessage", 5, 6);
    public static final hp g = new hp("SetConfig", 6, 7);
    public static final hp h = new hp("ReportFeedback", 7, 8);
    public static final hp i = new hp("Notification", 8, 9);
    public static final hp j = new hp("Command", 9, 10);
    public static final hp k = new hp("MultiConnectionBroadcast", 10, 11);
    public static final hp l = new hp("MultiConnectionResult", 11, 12);
    public static final hp m = new hp("ConnectionKick", 12, 13);
    public static final hp n = new hp("ApnsMessage", 13, 14);
    public static final hp o = new hp("IOSDeviceTokenWrite", 14, 15);
    public static final hp p = new hp("SaveInvalidRegId", 15, 16);
    public static final hp q = new hp("ApnsCertChanged", 16, 17);
    public static final hp r = new hp("RegisterDevice", 17, 18);
    public static final hp s = new hp("ExpandTopicInXmq", 18, 19);
    public static final hp t = new hp("SendMessageNew", 19, 22);
    public static final hp u = new hp("ExpandTopicInXmqNew", 20, 23);
    public static final hp v = new hp("DeleteInvalidMessage", 21, 24);
    public static final hp w = new hp("BadAction", 22, 99);
    public static final hp x = new hp("Presence", 23, 100);
    public static final hp y = new hp("FetchOfflineMessage", 24, 101);
    public static final hp z = new hp("SaveJob", 25, 102);

    /* renamed from: a  reason: collision with other field name */
    private final int f47a;

    private hp(String str, int i2, int i3) {
        this.f47a = i3;
    }

    public static hp a(int i2) {
        if (i2 == 200) {
            return K;
        }
        switch (i2) {
            case 1:
                return f6389a;
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
            default:
                switch (i2) {
                    case 22:
                        return t;
                    case 23:
                        return u;
                    case 24:
                        return v;
                    default:
                        switch (i2) {
                            case 99:
                                return w;
                            case 100:
                                return x;
                            case 101:
                                return y;
                            case 102:
                                return z;
                            case 103:
                                return A;
                            case 104:
                                return B;
                            case 105:
                                return C;
                            default:
                                switch (i2) {
                                    case 107:
                                        return D;
                                    case 108:
                                        return E;
                                    case 109:
                                        return F;
                                    case 110:
                                        return G;
                                    default:
                                        switch (i2) {
                                            case 112:
                                                return H;
                                            case 113:
                                                return I;
                                            case 114:
                                                return J;
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
        }
    }

    public static hp valueOf(String str) {
        return (hp) Enum.valueOf(hp.class, str);
    }

    public static hp[] values() {
        return (hp[]) f46a.clone();
    }

    public final int a() {
        return this.f47a;
    }
}

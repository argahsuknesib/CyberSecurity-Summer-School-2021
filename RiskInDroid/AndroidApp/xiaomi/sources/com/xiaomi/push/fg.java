package com.xiaomi.push;

import com.google.android.exoplayer2.C;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class fg extends Enum<fg> {
    public static final fg A = new fg("CONN_TCP_TIMEOUT", 26, 20105);
    public static final fg B = new fg("CONN_TCP_INVALARG", 27, 20106);
    public static final fg C = new fg("CONN_TCP_UKNOWNHOST", 28, 20107);
    public static final fg D = new fg("CONN_TCP_ERR_OTHER", 29, 20199);
    public static final fg E = new fg("CONN_XMPP_ERR", 30, 20399);
    public static final fg F = new fg("CONN_BOSH_UNKNOWNHOST", 31, 20407);
    public static final fg G = new fg("CONN_BOSH_ERR", 32, 20499);
    public static final fg H = new fg("BIND_SUCCESS", 33, 30000);
    public static final fg I = new fg("BIND_TCP_READ_TIMEOUT_DEPRECTED", 34, 30101);
    public static final fg J = new fg("BIND_TCP_CONNRESET_DEPRECTED", 35, 30102);
    public static final fg K = new fg("BIND_TCP_BROKEN_PIPE_DEPRECTED", 36, 30103);
    public static final fg L = new fg("BIND_TCP_READ_TIMEOUT", 37, 30108);
    public static final fg M = new fg("BIND_TCP_CONNRESET", 38, 30109);
    public static final fg N = new fg("BIND_TCP_BROKEN_PIPE", 39, 30110);
    public static final fg O = new fg("BIND_TCP_ERR", 40, 30199);
    public static final fg P = new fg("BIND_XMPP_ERR", 41, 30399);
    public static final fg Q = new fg("BIND_BOSH_ITEM_NOT_FOUND", 42, 30401);
    public static final fg R = new fg("BIND_BOSH_ERR", 43, 30499);
    public static final fg S = new fg("BIND_TIMEOUT", 44, 30501);
    public static final fg T = new fg("BIND_INVALID_SIG", 45, 30502);
    public static final fg U = new fg("CHANNEL_TCP_READTIMEOUT_DEPRECTED", 46, 40101);
    public static final fg V = new fg("CHANNEL_TCP_CONNRESET_DEPRECTED", 47, 40102);
    public static final fg W = new fg("CHANNEL_TCP_BROKEN_PIPE_DEPRECTED", 48, 40103);
    public static final fg X = new fg("CHANNEL_TCP_READTIMEOUT", 49, 40108);
    public static final fg Y = new fg("CHANNEL_TCP_CONNRESET", 50, 40109);
    public static final fg Z = new fg("CHANNEL_TCP_BROKEN_PIPE", 51, 40110);

    /* renamed from: a  reason: collision with root package name */
    public static final fg f6378a = new fg("TCP_CONN_FAIL", 0, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ fg[] f31a = a();
    public static final fg aa = new fg("CHANNEL_TCP_ERR", 52, 40199);
    public static final fg ab = new fg("CHANNEL_XMPPEXCEPTION", 53, 40399);
    public static final fg ac = new fg("CHANNEL_BOSH_ITEMNOTFIND", 54, 40401);
    public static final fg ad = new fg("CHANNEL_BOSH_EXCEPTION", 55, 40499);
    public static final fg ae = new fg("CHANNEL_TIMER_DELAYED", 56, 50001);
    public static final fg b = new fg("TCP_CONN_TIME", 1, 2);
    public static final fg c = new fg("PING_RTT", 2, 3);
    public static final fg d = new fg("CHANNEL_CON_FAIL", 3, 4);
    public static final fg e = new fg("CHANNEL_CON_OK", 4, 5);
    public static final fg f = new fg("ICMP_PING_FAIL", 5, 6);
    public static final fg g = new fg("ICMP_PING_OK", 6, 7);
    public static final fg h = new fg("CHANNEL_ONLINE_RATE", 7, 8);
    public static final fg i = new fg("BATCH_TCP_CONN_SUCCESS", 8, 1000);
    public static final fg j = new fg("BATCH_TCP_CONN_FAIL", 9, 1001);
    public static final fg k = new fg("CHANNEL_STATS_COUNTER", 10, 8000);
    public static final fg l = new fg("GSLB_REQUEST_SUCCESS", 11, C.MSG_CUSTOM_BASE);
    public static final fg m = new fg("GSLB_TCP_NOACCESS", 12, 10101);
    public static final fg n = new fg("GSLB_TCP_NETUNREACH", 13, 10102);
    public static final fg o = new fg("GSLB_TCP_CONNREFUSED", 14, 10103);
    public static final fg p = new fg("GSLB_TCP_NOROUTETOHOST", 15, 10104);
    public static final fg q = new fg("GSLB_TCP_TIMEOUT", 16, 10105);
    public static final fg r = new fg("GSLB_TCP_INVALARG", 17, 10106);
    public static final fg s = new fg("GSLB_TCP_UKNOWNHOST", 18, 10107);
    public static final fg t = new fg("GSLB_TCP_ERR_OTHER", 19, 10199);
    public static final fg u = new fg("GSLB_ERR", 20, 10999);
    public static final fg v = new fg("CONN_SUCCESS", 21, 20000);
    public static final fg w = new fg("CONN_TCP_NOACCESS", 22, 20101);
    public static final fg x = new fg("CONN_TCP_NETUNREACH", 23, 20102);
    public static final fg y = new fg("CONN_TCP_CONNREFUSED", 24, 20103);
    public static final fg z = new fg("CONN_TCP_NOROUTETOHOST", 25, 20104);

    /* renamed from: a  reason: collision with other field name */
    private final int f32a;

    private fg(String str, int i2, int i3) {
        this.f32a = i3;
    }

    public static fg a(int i2) {
        if (i2 == 30501) {
            return S;
        }
        if (i2 == 30502) {
            return T;
        }
        switch (i2) {
            case 1:
                return f6378a;
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
            default:
                switch (i2) {
                    case 8000:
                        return k;
                    case C.MSG_CUSTOM_BASE:
                        return l;
                    case 10199:
                        return t;
                    case 10999:
                        return u;
                    case 20000:
                        return v;
                    case 20199:
                        return D;
                    case 20399:
                        return E;
                    case 20407:
                        return F;
                    case 20499:
                        return G;
                    case 30000:
                        return H;
                    case 30199:
                        return O;
                    case 30399:
                        return P;
                    case 30401:
                        return Q;
                    case 30499:
                        return R;
                    case 40199:
                        return aa;
                    case 40399:
                        return ab;
                    case 40401:
                        return ac;
                    case 40499:
                        return ad;
                    case 50001:
                        return ae;
                    default:
                        switch (i2) {
                            case 10101:
                                return m;
                            case 10102:
                                return n;
                            case 10103:
                                return o;
                            case 10104:
                                return p;
                            case 10105:
                                return q;
                            case 10106:
                                return r;
                            case 10107:
                                return s;
                            default:
                                switch (i2) {
                                    case 20101:
                                        return w;
                                    case 20102:
                                        return x;
                                    case 20103:
                                        return y;
                                    case 20104:
                                        return z;
                                    case 20105:
                                        return A;
                                    case 20106:
                                        return B;
                                    case 20107:
                                        return C;
                                    default:
                                        switch (i2) {
                                            case 30101:
                                                return I;
                                            case 30102:
                                                return J;
                                            case 30103:
                                                return K;
                                            default:
                                                switch (i2) {
                                                    case 30108:
                                                        return L;
                                                    case 30109:
                                                        return M;
                                                    case 30110:
                                                        return N;
                                                    default:
                                                        switch (i2) {
                                                            case 40101:
                                                                return U;
                                                            case 40102:
                                                                return V;
                                                            case 40103:
                                                                return W;
                                                            default:
                                                                switch (i2) {
                                                                    case 40108:
                                                                        return X;
                                                                    case 40109:
                                                                        return Y;
                                                                    case 40110:
                                                                        return Z;
                                                                    default:
                                                                        return null;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static fg valueOf(String str) {
        return (fg) Enum.valueOf(fg.class, str);
    }

    public static fg[] values() {
        return (fg[]) f31a.clone();
    }

    public final int a() {
        return this.f32a;
    }
}

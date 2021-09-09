package _m_j;

import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import bsh.Token;
import bsh.TokenMgrError;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.io.PrintStream;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class le implements ld {
    static final long[] O00000Oo = {0, 0, -1, -1};
    static final long[] O00000o = {2301339413881290750L, -16384, 4294967295L, 432345564227567616L};
    static final long[] O00000o0 = {-2, -1, -1, -1};
    static final long[] O00000oO = {0, 0, 0, -36028797027352577L};
    static final long[] O00000oo = {0, -1, -1, -1};
    static final long[] O0000O0o = {-1, -1, 65535, 0};
    static final long[] O0000Oo = {70368744177663L, 0, 0, 0};
    static final long[] O0000Oo0 = {-1, -1, 0, 0};
    static final int[] O0000OoO = {37, 38, 43, 44, 47, 48, 15, 56, 61, 73, 26, 27, 29, 17, 19, 52, 54, 9, 57, 58, 60, 2, 3, 5, 11, 12, 15, 26, 27, 31, 29, 39, 40, 15, 47, 48, 15, 63, 64, 66, 69, 70, 72, 13, 14, 20, 21, 23, 28, 30, 32, 41, 42, 45, 46, 49, 50};
    public static final String[] O0000Ooo = {"", null, null, null, null, null, null, null, null, null, "abstract", "boolean", "break", "class", "byte", "case", "catch", "char", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "switch", "synchronized", "transient", "throw", "throws", "true", "try", "void", "volatile", "while", null, null, null, null, null, null, null, null, null, null, null, null, "(", ")", "{", "}", "[", "]", ";", ",", ".", "=", ">", "@gt", "<", "@lt", "!", "~", "?", ":", "==", "<=", "@lteq", ">=", "@gteq", "!=", "||", "@or", "&&", "@and", "++", "--", "+", "-", "*", "/", "&", "@bitwise_and", "|", "@bitwise_or", "^", "%", "<<", "@left_shift", ">>", "@right_shift", ">>>", "@right_unsigned_shift", "+=", "-=", "*=", "/=", "&=", "@and_assign", "|=", "@or_assign", "^=", "%=", "<<=", "@left_shift_assign", ">>=", "@right_shift_assign", ">>>=", "@right_unsigned_shift_assign"};
    static final long[] O0000o0 = {2305843009213692929L, -195, 63};
    public static final String[] O0000o00 = {"DEFAULT"};
    static final long[] O0000o0O = {1022, 0, 0};
    static final long[] O0000o0o = {896, 0, 0};

    /* renamed from: O000000o  reason: collision with root package name */
    public PrintStream f2164O000000o = System.out;
    protected lc O0000o;
    int O0000oO = 0;
    protected char O0000oO0;
    int O0000oOO = 0;
    int O0000oOo;
    int O0000oo;
    int O0000oo0;
    int O0000ooO;
    private final int[] O0000ooo = new int[74];
    private final int[] O00oOooO = new int[148];

    public le(lc lcVar) {
        this.O0000o = lcVar;
    }

    private final int O000000o(int i, int i2) {
        this.O0000ooO = i2;
        this.O0000oo = i;
        return i + 1;
    }

    private final int O000000o(int i, int i2, int i3) {
        this.O0000ooO = i2;
        this.O0000oo = i;
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return O00000oO(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int O000000o(int i, long j, long j2) {
        int i2;
        switch (i) {
            case 0:
                if ((144117387099111424L & j2) != 0) {
                    return 56;
                }
                if ((62 & j) != 0) {
                    return 0;
                }
                if ((j2 & 65536) != 0) {
                    return 11;
                }
                if ((j & 1152921504606845952L) == 0) {
                    return -1;
                }
                this.O0000ooO = 69;
                return 35;
            case 1:
                if ((4301258752L & j) != 0) {
                    return 35;
                }
                if ((j & 1152921500305587200L) == 0) {
                    return -1;
                }
                if (this.O0000oo != 1) {
                    this.O0000ooO = 69;
                    this.O0000oo = 1;
                }
                return 35;
            case 2:
                if ((1080862599528053760L & j) == 0) {
                    return (j & 72058900781727744L) != 0 ? 35 : -1;
                }
                if (this.O0000oo != 2) {
                    this.O0000ooO = 69;
                    this.O0000oo = 2;
                }
                return 35;
            case 3:
                if ((900716275798195200L & j) == 0) {
                    return (j & 180146461168812032L) != 0 ? 35 : -1;
                }
                if (this.O0000oo != 3) {
                    this.O0000ooO = 69;
                    this.O0000oo = 3;
                }
                return 35;
            case 4:
                if ((603623088562974720L & j) != 0) {
                    return 35;
                }
                if ((j & 297093187235220480L) == 0) {
                    return -1;
                }
                if (this.O0000oo != 4) {
                    this.O0000ooO = 69;
                    this.O0000oo = 4;
                }
                return 35;
            case 5:
                if ((295579692563958784L & j) != 0) {
                    this.O0000ooO = 69;
                    i2 = 5;
                    break;
                } else {
                    return (j & 19527893449179136L) != 0 ? 35 : -1;
                }
            case 6:
                if ((295566498121384960L & j) != 0) {
                    this.O0000ooO = 69;
                    i2 = 6;
                    break;
                } else {
                    return (j & 13194442573824L) != 0 ? 35 : -1;
                }
            case 7:
                if ((288793326105658368L & j) != 0) {
                    return 35;
                }
                if ((j & 6773172015726592L) != 0) {
                    this.O0000ooO = 69;
                    i2 = 7;
                    break;
                } else {
                    return -1;
                }
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                if ((2251842763358208L & j) != 0) {
                    this.O0000ooO = 69;
                    i2 = 8;
                    break;
                } else {
                    return (j & 4521329252368384L) != 0 ? 35 : -1;
                }
            case 9:
                if ((j & 2251799813685248L) != 0) {
                    this.O0000ooO = 69;
                    i2 = 9;
                    break;
                } else {
                    return (j & 42949672960L) != 0 ? 35 : -1;
                }
            case 10:
                if ((j & 2251799813685248L) == 0) {
                    return -1;
                }
                if (this.O0000oo != 10) {
                    this.O0000ooO = 69;
                    this.O0000oo = 10;
                }
                return 35;
            case 11:
                return (j & 2251799813685248L) != 0 ? 35 : -1;
            default:
                return -1;
        }
        this.O0000oo = i2;
        return 35;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, int]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O000000o(long j) {
        long j2 = j & 32;
        if (j2 == 0) {
            return O00000Oo(20, 0, 0);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return this.O0000oO0 != 'a' ? O00000Oo(21, 0, 0) : O00000Oo(j2);
        } catch (IOException unused) {
            O000000o(21, 0L, 0L);
            return 22;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O000000o(long j, long j2) {
        long j3 = j & 9007199254740992L;
        long j4 = 32 & j2;
        if ((j3 | j4) == 0) {
            return O00000Oo(17, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return this.O0000oO0 != 'f' ? O00000Oo(18, 0, j3) : O00000Oo(j3, j4);
        } catch (IOException unused) {
            O000000o(18, 0L, j3);
            return 19;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final int O000000o(long j, long j2, long j3) {
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c != '&') {
                if (c != '+') {
                    if (c != '-') {
                        if (c == 'r') {
                            return O000000o(j, 112616378963333120L, j2, 11258999068426240L, j3, 40);
                        }
                        if (c != '|') {
                            if (c == 'a') {
                                return O000000o(j, 4947869532160L, j2, 576460786663161856L, j3, 0);
                            }
                            if (c == 'b') {
                                return O000000o(j, 1024, j2, 43980465111040L, j3, 0);
                            }
                            if (c == 't') {
                                return O000000o(j, 844424930131968L, j2, 0, j3, 0);
                            }
                            if (c == 'u') {
                                return O000000o(j, 37383395344384L, j2, 0, j3, 0);
                            }
                            switch (c) {
                                case '<':
                                    if ((j2 & 281474976710656L) != 0) {
                                        this.O0000ooO = 112;
                                        this.O0000oo = 1;
                                    }
                                    return O000000o(j, 0, j2, 0, j3, 1);
                                case '=':
                                    if ((j2 & 67108864) != 0) {
                                        return O000000o(1, 90);
                                    }
                                    if ((j2 & 134217728) != 0) {
                                        return O000000o(1, 91);
                                    }
                                    if ((j2 & 536870912) != 0) {
                                        return O000000o(1, 93);
                                    }
                                    if ((j2 & 2147483648L) != 0) {
                                        return O000000o(1, 95);
                                    }
                                    if ((j2 & 18014398509481984L) != 0) {
                                        return O000000o(1, 118);
                                    }
                                    if ((j2 & 36028797018963968L) != 0) {
                                        return O000000o(1, 119);
                                    }
                                    if ((j2 & 72057594037927936L) != 0) {
                                        return O000000o(1, 120);
                                    }
                                    if ((j2 & 144115188075855872L) != 0) {
                                        return O000000o(1, 121);
                                    }
                                    if ((j2 & 288230376151711744L) != 0) {
                                        return O000000o(1, 122);
                                    }
                                    if ((j2 & 1152921504606846976L) != 0) {
                                        return O000000o(1, 124);
                                    }
                                    if ((j2 & 4611686018427387904L) != 0) {
                                        return O000000o(1, 126);
                                    }
                                    if ((j2 & Long.MIN_VALUE) != 0) {
                                        return O000000o(1, 127);
                                    }
                                    break;
                                case '>':
                                    if ((j2 & 1125899906842624L) != 0) {
                                        this.O0000ooO = 114;
                                        this.O0000oo = 1;
                                    }
                                    return O000000o(j, 0, j2, 4503599627370496L, j3, 20);
                                default:
                                    switch (c) {
                                        case 'e':
                                            return O000000o(j, 71468256854016L, j2, 0, j3, 0);
                                        case 'f':
                                            if ((j & 4294967296L) != 0) {
                                                return O000000o(1, 32, 35);
                                            }
                                            break;
                                        case 'g':
                                            return O000000o(j, 0, j2, 1074266112, j3, 0);
                                        case 'h':
                                            return O000000o(j, 603623087556132864L, j2, 0, j3, 0);
                                        case 'i':
                                            return O000000o(j, 402653184, j2, 0, j3, 0);
                                        default:
                                            switch (c) {
                                                case 'l':
                                                    return O000000o(j, 545267712, j2, 562950223953920L, j3, 2);
                                                case 'm':
                                                    return O000000o(j, 25769803776L, j2, 0, j3, 0);
                                                case 'n':
                                                    return O000000o(j, 240534945792L, j2, 0, j3, 0);
                                                case 'o':
                                                    if ((2097152 & j) != 0) {
                                                        this.O0000ooO = 21;
                                                        this.O0000oo = 1;
                                                    }
                                                    return O000000o(j, 432345842331682816L, j2, 2305843017803628544L, j3, 0);
                                                default:
                                                    switch (c) {
                                                        case 'w':
                                                            return O000000o(j, 1125899906842624L, j2, 0, j3, 0);
                                                        case 'x':
                                                            return O000000o(j, 33554432, j2, 0, j3, 0);
                                                        case 'y':
                                                            return O000000o(j, 2251799813701632L, j2, 0, j3, 0);
                                                    }
                                            }
                                    }
                            }
                        } else if ((j2 & 4294967296L) != 0) {
                            return O000000o(1, 96);
                        }
                    } else if ((j2 & 137438953472L) != 0) {
                        return O000000o(1, 101);
                    }
                } else if ((j2 & 68719476736L) != 0) {
                    return O000000o(1, 100);
                }
            } else if ((j2 & 17179869184L) != 0) {
                return O000000o(1, 98);
            }
            return O00000Oo(0, j, j2);
        } catch (IOException unused) {
            O000000o(0, j, j2);
            return 1;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O000000o(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return O00000Oo(11, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            return c != 'a' ? c != 'e' ? c != 's' ? O00000Oo(12, 0, j5) : O00000Oo(j5, 0, j6, 2) : O00000Oo(j5, 9007199254740992L, j6, 32) : O00000Oo(j5, 0, j6, 8);
        } catch (IOException unused) {
            O000000o(12, 0L, j5);
            return 13;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O000000o(long j, long j2, long j3, long j4, long j5) {
        long j6 = j3 & j2;
        long j7 = j5 & j4;
        if (((j & 0) | j6 | j7) == 0) {
            return O00000Oo(10, j, j2);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            return c != '_' ? c != 'a' ? c != 'n' ? O00000Oo(11, 0, j6) : O000000o(j6, 9007199254740992L, j7, 32) : O000000o(j6, 0, j7, 2) : O000000o(j6, 0, j7, 8);
        } catch (IOException unused) {
            O000000o(11, 0L, j6);
            return 12;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final int O000000o(long j, long j2, long j3, long j4, long j5, long j6) {
        int i;
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(0, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c != '=') {
                if (c == '>') {
                    if ((4503599627370496L & j8) != 0) {
                        this.O0000ooO = 116;
                        this.O0000oo = 2;
                    }
                    return O00000Oo(j7, 0, j8, 0, j9, 16);
                } else if (c == 'e') {
                    return O00000Oo(j7, 4096, j8, 562949953421312L, j9, 2);
                } else {
                    if (c == 'f') {
                        return O00000Oo(j7, 1048576, j8, 0, j9, 0);
                    }
                    if (c == 'i') {
                        return O00000Oo(j7, 721710636379144192L, j8, 11302979533537280L, j9, 40);
                    }
                    if (c == 'l') {
                        return O00000Oo(j7, 288232575242076160L, j8, 0, j9, 0);
                    }
                    if (c != 'w') {
                        if (c != 'y') {
                            switch (c) {
                                case 'a':
                                    return O00000Oo(j7, 4785074604220416L, j8, 0, j9, 0);
                                case 'b':
                                    return O00000Oo(j7, 35184372088832L, j8, 0, j9, 0);
                                case 'c':
                                    return O00000Oo(j7, 4398046511104L, j8, 0, j9, 0);
                                default:
                                    switch (c) {
                                        case 'n':
                                            return O00000Oo(j7, 2252075095031808L, j8, 576460786663161856L, j9, 0);
                                        case 'o':
                                            return O00000Oo(j7, 158330211272704L, j8, 0, j9, 0);
                                        case 'p':
                                            return O00000Oo(j7, 25769803776L, j8, 0, j9, 0);
                                        default:
                                            switch (c) {
                                                case 'r':
                                                    if ((1073741824 & j7) != 0) {
                                                        return O000000o(2, 30, 35);
                                                    }
                                                    if ((8589934592L & j8) != 0) {
                                                        this.O0000ooO = 97;
                                                        this.O0000oo = 2;
                                                    }
                                                    return O00000Oo(j7, 27584547717644288L, j8, 2305843009213693952L, j9, 0);
                                                case 's':
                                                    return O00000Oo(j7, 34368160768L, j8, 0, j9, 0);
                                                case 't':
                                                    if ((68719476736L & j7) != 0) {
                                                        i = 36;
                                                    } else if ((PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED & j8) != 0) {
                                                        i = 83;
                                                    } else {
                                                        if ((2097152 & j8) != 0) {
                                                            i = 85;
                                                        }
                                                        return O00000Oo(j7, 71058120065024L, j8, 1342177280, j9, 0);
                                                    }
                                                    this.O0000ooO = i;
                                                    this.O0000oo = 2;
                                                    return O00000Oo(j7, 71058120065024L, j8, 1342177280, j9, 0);
                                                case 'u':
                                                    return O00000Oo(j7, 36028797039935488L, j8, 0, j9, 0);
                                            }
                                    }
                            }
                        } else if ((72057594037927936L & j7) != 0) {
                            return O000000o(2, 56, 35);
                        }
                    } else if ((1099511627776L & j7) != 0) {
                        return O000000o(2, 40, 35);
                    }
                }
            } else if ((1 & j9) != 0) {
                return O000000o(2, (int) NotificationCompat.FLAG_HIGH_PRIORITY);
            } else {
                if ((4 & j9) != 0) {
                    return O000000o(2, 130);
                }
            }
            return O00000Oo(1, j7, j8);
        } catch (IOException unused) {
            O000000o(1, j7, j8);
            return 2;
        }
    }

    private final void O000000o(int i) {
        int[] iArr = this.O0000ooo;
        int i2 = iArr[i];
        int i3 = this.O0000oo0;
        if (i2 != i3) {
            int[] iArr2 = this.O00oOooO;
            int i4 = this.O0000oOo;
            this.O0000oOo = i4 + 1;
            iArr2[i4] = i;
            iArr[i] = i3;
        }
    }

    private static final boolean O000000o(int i, int i2, int i3, long j, long j2) {
        return i != 0 ? (O00000o0[i2] & j) != 0 : (O00000Oo[i3] & j2) != 0;
    }

    private static final boolean O000000o(int i, int i2, long j) {
        return i == 0 && (O00000Oo[i2] & j) != 0;
    }

    private final int O00000Oo(int i, long j, long j2) {
        return O00000oO(O000000o(i, j, j2), i + 1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, int]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000Oo(long j) {
        long j2 = j & 32;
        if (j2 == 0) {
            return O00000Oo(21, 0, 0);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return this.O0000oO0 != 's' ? O00000Oo(22, 0, 0) : O00000o0(j2);
        } catch (IOException unused) {
            O000000o(22, 0L, 0L);
            return 23;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000Oo(long j, long j2) {
        int i;
        long j3;
        le leVar;
        long j4 = j & 9007199254740992L;
        long j5 = 32 & j2;
        if ((j4 | j5) == 0) {
            i = 18;
            j3 = 0;
            leVar = this;
            j4 = j;
        } else {
            try {
                this.O0000oO0 = this.O0000o.O00000Oo();
                if (this.O0000oO0 != 't') {
                    i = 19;
                    j3 = 0;
                    leVar = this;
                } else {
                    if ((9007199254740992L & j4) != 0) {
                        this.O0000ooO = 117;
                        this.O0000oo = 20;
                    }
                    return O00000o0(j4, j5);
                }
            } catch (IOException unused) {
                O000000o(19, 0L, j4);
                return 20;
            }
        }
        return leVar.O00000Oo(i, j3, j4);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000Oo(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return O00000Oo(12, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            return c != 'd' ? c != 's' ? O00000Oo(13, 0, j5) : O00000o0(j5, 0, j6, 10) : O00000o0(j5, 9007199254740992L, j6, 32);
        } catch (IOException unused) {
            O000000o(13, 0L, j5);
            return 14;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final int O00000Oo(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(1, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c != '=') {
                if (c == '_') {
                    return O00000o0(j7, 0, j8, 2305843009213693952L, j9, 0);
                }
                if (c == 'i') {
                    return O00000o0(j7, 563499709235200L, j8, 0, j9, 0);
                }
                switch (c) {
                    case 'a':
                        return O00000o0(j7, 288230377092288512L, j8, 0, j9, 0);
                    case 'b':
                        return O00000o0(j7, 4194304, j8, 0, j9, 0);
                    case 'c':
                        return O00000o0(j7, 2251799813750784L, j8, 0, j9, 0);
                    case 'd':
                        if ((144115188075855872L & j7) != 0) {
                            return O000000o(3, 57, 35);
                        }
                        if ((34359738368L & j8) != 0) {
                            this.O0000ooO = 99;
                            this.O0000oo = 3;
                        }
                        return O00000o0(j7, 0, j8, 576460752303423488L, j9, 0);
                    case 'e':
                        return (16384 & j7) != 0 ? O000000o(3, 14, 35) : (32768 & j7) != 0 ? O000000o(3, 15, 35) : (8388608 & j7) != 0 ? O000000o(3, 23, 35) : (36028797018963968L & j7) != 0 ? O000000o(3, 55, 35) : O00000o0(j7, 137472507904L, j8, 1342177280, j9, 0);
                    case 'f':
                        return O00000o0(j7, 0, j8, 562949953421312L, j9, 2);
                    case 'g':
                        return (274877906944L & j7) != 0 ? O000000o(3, 38, 35) : O00000o0(j7, 0, j8, 11258999068426240L, j9, 40);
                    default:
                        switch (c) {
                            case 'k':
                                return O00000o0(j7, 4398046511104L, j8, 0, j9, 0);
                            case 'l':
                                return (2199023255552L & j7) != 0 ? O000000o(3, 41, 35) : O00000o0(j7, 576495945265448960L, j8, 0, j9, 0);
                            case 'm':
                                if ((16777216 & j7) != 0) {
                                    return O000000o(3, 24, 35);
                                }
                                break;
                            case 'n':
                                return O00000o0(j7, 4503599627370496L, j8, 0, j9, 0);
                            case 'o':
                                return (2147483648L & j7) != 0 ? O000000o(3, 31, 35) : O00000o0(j7, 27021614944092160L, j8, 0, j9, 0);
                            default:
                                switch (c) {
                                    case 'r':
                                        return (131072 & j7) != 0 ? O000000o(3, 17, 35) : O00000o0(j7, 140737488355328L, j8, 0, j9, 0);
                                    case 's':
                                        return O00000o0(j7, 67379200, j8, 0, j9, 0);
                                    case 't':
                                        return O00000o0(j7, 1425001429861376L, j8, 43980465111040L, j9, 0);
                                    case 'u':
                                        return O00000o0(j7, 70368744177664L, j8, 0, j9, 0);
                                    case 'v':
                                        return O00000o0(j7, 8796093022208L, j8, 0, j9, 0);
                                }
                        }
                }
            } else if ((16 & j9) != 0) {
                return O000000o(3, 132);
            }
            return O00000Oo(2, j7, j8);
        } catch (IOException unused) {
            O000000o(2, j7, j8);
            return 3;
        }
    }

    private final void O00000Oo() {
        this.O0000oo0 = -2147483647;
        int i = 74;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                this.O0000ooo[i2] = Integer.MIN_VALUE;
                i = i2;
            } else {
                return;
            }
        }
    }

    private final void O00000Oo(int i, int i2) {
        while (true) {
            int[] iArr = this.O00oOooO;
            int i3 = this.O0000oOo;
            this.O0000oOo = i3 + 1;
            iArr[i3] = O0000OoO[i];
            int i4 = i + 1;
            if (i != i2) {
                i = i4;
            } else {
                return;
            }
        }
    }

    private static final boolean O00000Oo(int i, int i2, int i3, long j, long j2) {
        return i != 0 ? i != 51 ? i != 61 ? i != 48 ? i != 49 ? (O00000o[i2] & j) != 0 : (O0000O0o[i3] & j2) != 0 : (O00000oo[i3] & j2) != 0 : (O0000Oo[i3] & j2) != 0 : (O0000Oo0[i3] & j2) != 0 : (O00000oO[i3] & j2) != 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, int]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000o(long j) {
        long j2 = j & 32;
        if (j2 == 0) {
            return O00000Oo(23, 0, 0);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return this.O0000oO0 != 'i' ? O00000Oo(24, 0, 0) : O00000oO(j2);
        } catch (IOException unused) {
            O000000o(24, 0L, 0L);
            return 25;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000o(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return O00000Oo(14, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            return c != 'g' ? c != 'i' ? c != 's' ? O00000Oo(15, 0, j5) : O00000oO(j5, 9007199254740992L, j6, 32) : O00000oO(j5, 0, j6, 8) : O00000oO(j5, 0, j6, 2);
        } catch (IOException unused) {
            O000000o(15, 0L, j5);
            return 16;
        }
    }

    private final int O00000o(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(3, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            switch (this.O0000oO0) {
                case '_':
                    return O00000oO(j7, 0, j8, 562949953421312L, j9, 2);
                case 'a':
                    return O00000oO(j7, 3072, j8, 576460752303423488L, j9, 0);
                case 'c':
                    return (35184372088832L & j7) != 0 ? O000000o(5, 45, 35) : (281474976710656L & j7) != 0 ? O000000o(5, 48, 35) : O00000oO(j7, 17592186044416L, j8, 0, j9, 0);
                case 'd':
                    return O00000oO(j7, 33554432, j8, 0, j9, 0);
                case 'e':
                    if ((4194304 & j7) != 0) {
                        return O000000o(5, 22, 35);
                    }
                    if ((549755813888L & j7) != 0) {
                        return O000000o(5, 39, 35);
                    }
                    break;
                case 'f':
                    return O00000oO(j7, 137438953472L, j8, 0, j9, 0);
                case 'g':
                    return O00000oO(j7, 4398046511104L, j8, 0, j9, 0);
                case 'h':
                    if ((1125899906842624L & j7) != 0) {
                        return O000000o(5, 50, 35);
                    }
                    break;
                case 'i':
                    return O00000oO(j7, 292733975779082240L, j8, 43980465111040L, j9, 0);
                case 'l':
                    return O00000oO(j7, 269484032, j8, 0, j9, 0);
                case 'm':
                    return O00000oO(j7, 8589934592L, j8, 0, j9, 0);
                case 'n':
                    return (70368744177664L & j7) != 0 ? O000000o(5, 46, 35) : O00000oO(j7, 34360262656L, j8, 0, j9, 0);
                case 'r':
                    return O00000oO(j7, 2251799813685248L, j8, 0, j9, 0);
                case 's':
                    return (18014398509481984L & j7) != 0 ? O000000o(5, 54, 35) : O00000oO(j7, 0, j8, 2305843009213693952L, j9, 0);
                case 't':
                    return (17179869184L & j7) != 0 ? O000000o(5, 34, 35) : O00000oO(j7, 571746046443520L, j8, 11258999068426240L, j9, 40);
            }
            return O00000Oo(4, j7, j8);
        } catch (IOException unused) {
            O000000o(4, j7, j8);
            return 5;
        }
    }

    private final void O00000o(int i, int i2) {
        while (true) {
            O000000o(O0000OoO[i]);
            int i3 = i + 1;
            if (i != i2) {
                i = i3;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, int]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000o0(long j) {
        long j2 = j & 32;
        if (j2 == 0) {
            return O00000Oo(22, 0, 0);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return this.O0000oO0 != 's' ? O00000Oo(23, 0, 0) : O00000o(j2);
        } catch (IOException unused) {
            O000000o(23, 0L, 0L);
            return 24;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, int]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000o0(long j, long j2) {
        long j3 = j2 & 32;
        if (((j & 0) | j3) == 0) {
            return O00000Oo(19, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return this.O0000oO0 != '_' ? O00000Oo(20, 0, 0) : O000000o(j3);
        } catch (IOException unused) {
            O000000o(20, 0L, 0L);
            return 21;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000o0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return O00000Oo(13, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            return c != '_' ? c != 'i' ? c != 's' ? O00000Oo(14, 0, j5) : O00000o(j5, 0, j6, 8) : O00000o(j5, 0, j6, 2) : O00000o(j5, 9007199254740992L, j6, 32);
        } catch (IOException unused) {
            O000000o(14, 0L, j5);
            return 15;
        }
    }

    private final int O00000o0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(2, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            switch (this.O0000oO0) {
                case '_':
                    return O00000o(j7, 0, j8, 576460752303423488L, j9, 0);
                case 'a':
                    return O00000o(j7, 13228499271680L, j8, 2305843009213693952L, j9, 0);
                case 'c':
                    return O00000o(j7, 1688849860263936L, j8, 0, j9, 0);
                case 'e':
                    return (67108864 & j7) != 0 ? O000000o(4, 26, 35) : (576460752303423488L & j7) != 0 ? O000000o(4, 59, 35) : O00000o(j7, 17600775981056L, j8, 0, j9, 0);
                case 'h':
                    return (65536 & j7) != 0 ? O000000o(4, 16, 35) : O00000o(j7, 2251799813685248L, j8, 11258999068426240L, j9, 40);
                case 'i':
                    return O00000o(j7, 316659349323776L, j8, 0, j9, 0);
                case 'k':
                    if ((4096 & j7) != 0) {
                        return O000000o(4, 12, 35);
                    }
                    break;
                case 'l':
                    if ((134217728 & j7) != 0) {
                        this.O0000ooO = 27;
                        this.O0000oo = 4;
                    }
                    return O00000o(j7, 272629760, j8, 0, j9, 0);
                case 'n':
                    return O00000o(j7, 33554432, j8, 0, j9, 0);
                case 'q':
                    if ((268435456 & j8) != 0) {
                        return O000000o(4, 92);
                    }
                    if ((1073741824 & j8) != 0) {
                        return O000000o(4, 94);
                    }
                    break;
                case 'r':
                    return O00000o(j7, 70523363001344L, j8, 0, j9, 0);
                case 's':
                    return (8192 & j7) != 0 ? O000000o(4, 13, 35) : O00000o(j7, 4503599627370496L, j8, 0, j9, 0);
                case 't':
                    return (262144 & j7) != 0 ? O000000o(4, 18, 35) : (536870912 & j7) != 0 ? O000000o(4, 29, 35) : (140737488355328L & j7) != 0 ? O000000o(4, 47, 35) : O00000o(j7, 288230376151711744L, j8, 562949953421312L, j9, 2);
                case 'u':
                    return O00000o(j7, 1048576, j8, 0, j9, 0);
                case 'v':
                    return O00000o(j7, 549755813888L, j8, 0, j9, 0);
                case 'w':
                    if ((9007199254740992L & j7) != 0) {
                        this.O0000ooO = 53;
                        this.O0000oo = 4;
                    }
                    return O00000o(j7, 18014398509481984L, j8, 43980465111040L, j9, 0);
            }
            return O00000Oo(3, j7, j8);
        } catch (IOException unused) {
            O000000o(3, j7, j8);
            return 4;
        }
    }

    private Token O00000o0() {
        Token O000000o2 = Token.O000000o();
        int i = this.O0000ooO;
        O000000o2.kind = i;
        String str = O0000Ooo[i];
        if (str == null) {
            str = this.O0000o.O0000O0o();
        }
        O000000o2.image = str;
        O000000o2.beginLine = this.O0000o.O00000oo();
        O000000o2.beginColumn = this.O0000o.O00000oO();
        O000000o2.endLine = this.O0000o.O00000o();
        O000000o2.endColumn = this.O0000o.O00000o0();
        return O000000o2;
    }

    private final void O00000o0(int i, int i2) {
        O000000o(i);
        O000000o(i2);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01e8, code lost:
        if ((r18 & 43980465111040L) != 0) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01f1, code lost:
        if (r4 > 64) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01fa, code lost:
        if (r4 > 64) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01fc, code lost:
        r4 = 64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01fe, code lost:
        r2 = 31;
        r7 = 33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0225, code lost:
        if (r4 > 69) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x022e, code lost:
        if (r4 > 69) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0230, code lost:
        r4 = 69;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0232, code lost:
        r2 = 35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x025e, code lost:
        if ((r18 & 71776119061217280L) != 0) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0288, code lost:
        if ((r18 & 566935683072L) != 0) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0294, code lost:
        if ((r18 & -17179878401L) != 0) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x029b, code lost:
        if (r0.O0000oO0 == '\"') goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x029d, code lost:
        O00000o(10, 12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02c9, code lost:
        if ((r18 & 71776119061217280L) != 0) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02e4, code lost:
        if ((r18 & 566935683072L) != 0) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0300, code lost:
        if ((r18 & -549755823105L) != 0) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0302, code lost:
        O000000o(18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        if ((r18 & -4398046511105L) != 0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        if ((r18 & -145135534866433L) != 0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x036c, code lost:
        if (r4 > 60) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        r2 = 71;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0418, code lost:
        if (r4 > 8) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
        if ((r18 & -4398046511105L) != 0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0426, code lost:
        if (r4 > 8) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0428, code lost:
        r4 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0432, code lost:
        if ((r18 & -9217) != 0) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x043a, code lost:
        if (r0.O0000oO0 == '!') goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x043c, code lost:
        r2 = 21;
        r7 = 23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        if (r0.O0000oO0 == '*') goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a0, code lost:
        r2 = 68;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a2, code lost:
        O00000o0(r2, 69);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
        if ((r18 & -4398046511105L) != 0) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        if ((r18 & -145135534866433L) != 0) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ca, code lost:
        r2 = 65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0107, code lost:
        if (r4 > 7) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0112, code lost:
        if (r4 > 7) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0114, code lost:
        r4 = 7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x06ff  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0714 A[SYNTHETIC, Splitter:B:445:0x0714] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0721 A[LOOP:3: B:357:0x05a2->B:450:0x0721, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x0713 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:482:0x06fa A[SYNTHETIC] */
    private final int O00000oO(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        this.O0000oOo = 74;
        this.O00oOooO[0] = i;
        int i20 = 1;
        int i21 = i2;
        int i22 = 1;
        int i23 = Integer.MAX_VALUE;
        int i24 = 0;
        while (true) {
            int i25 = this.O0000oo0 + i20;
            this.O0000oo0 = i25;
            if (i25 == Integer.MAX_VALUE) {
                O00000Oo();
            }
            char c = this.O0000oO0;
            int i26 = 63;
            int i27 = 7;
            if (c < '@') {
                long j = 1 << c;
                while (true) {
                    int[] iArr = this.O00oOooO;
                    i22--;
                    int i28 = 42;
                    switch (iArr[i22]) {
                        case 0:
                            if ((j & 8589934591L) != 0) {
                                if (i23 > 6) {
                                    i13 = 0;
                                    i23 = 6;
                                } else {
                                    i13 = 0;
                                }
                                O000000o(i13);
                                break;
                            }
                            break;
                        case 3:
                            if ((j & 9216) != 0) {
                            }
                            break;
                        case 4:
                            if (this.O0000oO0 == 10) {
                                break;
                            }
                            break;
                        case 5:
                            if (this.O0000oO0 == 13) {
                                int i29 = this.O0000oOo;
                                this.O0000oOo = i29 + 1;
                                iArr[i29] = 4;
                                break;
                            }
                            break;
                        case 6:
                            if ((j & 8589934591L) != 0) {
                                if (i23 > 6) {
                                    i23 = 6;
                                }
                                O000000o(0);
                            } else if ((j & 287948901175001088L) != 0) {
                                O00000o(0, 6);
                            } else {
                                char c2 = this.O0000oO0;
                                if (c2 == '/') {
                                    O00000Oo(7, 9);
                                } else {
                                    if (c2 != '$') {
                                        if (c2 != '\"') {
                                            if (c2 != '\'') {
                                                if (c2 != '.') {
                                                    if (c2 == '#') {
                                                        int i30 = this.O0000oOo;
                                                        this.O0000oOo = i30 + 1;
                                                        iArr[i30] = 1;
                                                        if ((j & 287667426198290432L) != 0) {
                                                            if (this.O0000oO0 == '0') {
                                                                if (i23 > 60) {
                                                                    i23 = 60;
                                                                }
                                                                int i31 = 15;
                                                                int i32 = 17;
                                                                O00000o(i31, i32);
                                                                break;
                                                            }
                                                        } else {
                                                            if (i23 > 60) {
                                                                i14 = 8;
                                                                i23 = 60;
                                                            } else {
                                                                i14 = 8;
                                                            }
                                                            O00000o0(i14, 9);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    i15 = 11;
                                                }
                                            } else {
                                                O00000Oo(13, 14);
                                            }
                                        } else {
                                            O00000o(10, 12);
                                        }
                                    } else {
                                        if (i23 > 69) {
                                            i23 = 69;
                                        }
                                        i15 = 35;
                                    }
                                    O000000o(i15);
                                }
                            }
                            if ((j & 287667426198290432L) != 0) {
                            }
                            break;
                        case 7:
                            i16 = 8;
                            if ((j & 287667426198290432L) != 0) {
                            }
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                            if ((j & 287948901175001088L) != 0) {
                                if (i23 > 60) {
                                    i16 = 8;
                                    i23 = 60;
                                    O00000o0(i16, 9);
                                } else {
                                    i16 = 8;
                                    O00000o0(i16, 9);
                                }
                            }
                            break;
                        case 10:
                            if (this.O0000oO0 == '.') {
                                i28 = 11;
                                O000000o(i28);
                            }
                            break;
                        case 11:
                            if ((j & 287948901175001088L) != 0) {
                                if (i23 > 64) {
                                    i23 = 64;
                                }
                                i18 = 24;
                                i17 = 26;
                                O00000o(i18, i17);
                            }
                            break;
                        case 13:
                            if ((j & 43980465111040L) != 0) {
                                i28 = 14;
                                O000000o(i28);
                            }
                            break;
                        case 14:
                            if ((j & 287948901175001088L) != 0) {
                                if (i23 > 64) {
                                    i23 = 64;
                                }
                                i28 = 14;
                                i19 = 15;
                                O00000o0(i28, i19);
                            }
                            break;
                        case 16:
                            if (this.O0000oO0 == '\'') {
                                O00000Oo(13, 14);
                            }
                            break;
                        case 18:
                            if (this.O0000oO0 == '\'' && i23 > 66) {
                                i23 = 66;
                            }
                            break;
                        case 21:
                            if ((j & 71776119061217280L) != 0) {
                                O00000o0(22, 18);
                            }
                            break;
                        case 23:
                            if ((j & 4222124650659840L) != 0) {
                                int i33 = this.O0000oOo;
                                this.O0000oOo = i33 + 1;
                                iArr[i33] = 24;
                            }
                            break;
                        case 24:
                            if ((j & 71776119061217280L) != 0) {
                                i28 = 22;
                                O000000o(i28);
                            }
                            break;
                        case 29:
                            if (this.O0000oO0 == '\"' && i23 > 67) {
                                i23 = 67;
                            }
                            break;
                        case 30:
                            if ((j & 71776119061217280L) != 0) {
                                i18 = 27;
                                i17 = 30;
                                O00000o(i18, i17);
                            }
                            break;
                        case 32:
                            if ((j & 4222124650659840L) != 0) {
                                int i34 = this.O0000oOo;
                                this.O0000oOo = i34 + 1;
                                iArr[i34] = 33;
                            }
                            break;
                        case 33:
                            if ((j & 71776119061217280L) != 0) {
                                i28 = 31;
                                O000000o(i28);
                            }
                            break;
                        case 34:
                            if (this.O0000oO0 == '$') {
                            }
                            break;
                        case 35:
                            if ((j & 287948969894477824L) != 0) {
                            }
                            break;
                        case 36:
                            if ((j & 287948901175001088L) != 0) {
                                i18 = 0;
                                i17 = 6;
                                O00000o(i18, i17);
                            }
                            break;
                        case 37:
                            if ((j & 287948901175001088L) != 0) {
                                i28 = 37;
                                i19 = 38;
                                O00000o0(i28, i19);
                            }
                            break;
                        case 38:
                            if (this.O0000oO0 == '.') {
                            }
                            break;
                        case 39:
                            if ((j & 287948901175001088L) != 0) {
                            }
                            break;
                        case 42:
                            if ((j & 287948901175001088L) != 0) {
                                if (i23 > 64) {
                                    i23 = 64;
                                }
                                i19 = 15;
                                O00000o0(i28, i19);
                            }
                            break;
                        case 43:
                            if ((j & 287948901175001088L) != 0) {
                                i28 = 43;
                                i19 = 44;
                                O00000o0(i28, i19);
                            }
                            break;
                        case 45:
                            if ((j & 43980465111040L) != 0) {
                                i28 = 46;
                                O000000o(i28);
                            }
                            break;
                        case 46:
                            if ((j & 287948901175001088L) != 0) {
                                if (i23 > 64) {
                                    i23 = 64;
                                }
                                i28 = 46;
                                i19 = 15;
                                O00000o0(i28, i19);
                            }
                            break;
                        case 47:
                            if ((j & 287948901175001088L) != 0) {
                                i18 = 34;
                                i17 = 36;
                                O00000o(i18, i17);
                            }
                            break;
                        case 49:
                            if ((j & 43980465111040L) != 0) {
                                i28 = 50;
                                O000000o(i28);
                            }
                            break;
                        case 50:
                            if ((j & 287948901175001088L) != 0) {
                                i28 = 50;
                                i19 = 15;
                                O00000o0(i28, i19);
                            }
                            break;
                        case 51:
                            if (this.O0000oO0 == '0') {
                                if (i23 > 60) {
                                    i23 = 60;
                                }
                                i18 = 15;
                                i17 = 17;
                                O00000o(i18, i17);
                            }
                            break;
                        case 53:
                            if ((j & 287948901175001088L) != 0) {
                                if (i23 > 60) {
                                    i23 = 60;
                                }
                                i16 = 53;
                                O00000o0(i16, 9);
                            }
                            break;
                        case 54:
                            if ((j & 71776119061217280L) != 0) {
                                if (i23 > 60) {
                                    i23 = 60;
                                }
                                i16 = 54;
                                O00000o0(i16, 9);
                            }
                            break;
                        case 55:
                            if (this.O0000oO0 == '/') {
                                O00000Oo(7, 9);
                            }
                            break;
                        case 56:
                            char c3 = this.O0000oO0;
                            if (c3 == '*') {
                                int i35 = this.O0000oOo;
                                this.O0000oOo = i35 + 1;
                                iArr[i35] = 67;
                            } else if (c3 == '/') {
                                if (i23 > 7) {
                                    i23 = 7;
                                }
                                O00000o(18, 20);
                            }
                            if (this.O0000oO0 == '*') {
                                i28 = 62;
                                O000000o(i28);
                            }
                            break;
                        case 57:
                            if ((j & -9217) != 0) {
                                if (i23 > 7) {
                                    i23 = 7;
                                }
                                O00000o(18, 20);
                            }
                            break;
                        case 58:
                            if ((j & 9216) != 0) {
                            }
                            break;
                        case 59:
                            if (this.O0000oO0 == 10) {
                            }
                            break;
                        case 60:
                            if (this.O0000oO0 == 13) {
                                int i36 = this.O0000oOo;
                                this.O0000oOo = i36 + 1;
                                iArr[i36] = 59;
                            }
                            break;
                        case 61:
                            if (this.O0000oO0 == '*') {
                                i28 = 62;
                                O000000o(i28);
                            }
                            break;
                        case 62:
                            if ((j & -4398046511105L) != 0) {
                                int i37 = 62;
                                O00000o0(i37, i26);
                            }
                            break;
                        case 63:
                            if (this.O0000oO0 == '*') {
                                i18 = 37;
                                i17 = 39;
                                O00000o(i18, i17);
                            }
                            break;
                        case 66:
                            if (this.O0000oO0 == '/' && i23 > 9) {
                                i23 = 9;
                            }
                            break;
                        case 69:
                            if (this.O0000oO0 == '*') {
                                O00000o(40, 42);
                            }
                            break;
                        case 72:
                            if (this.O0000oO0 == '/' && i23 > 68) {
                                i23 = 68;
                            }
                            break;
                        case 73:
                            if (this.O0000oO0 == '*') {
                                int i38 = this.O0000oOo;
                                this.O0000oOo = i38 + 1;
                                iArr[i38] = 67;
                            }
                            break;
                    }
                    if (i22 != i24) {
                        i26 = 63;
                    }
                }
            } else if (c < 128) {
                long j2 = 1 << (c & '?');
                do {
                    i22--;
                    switch (this.O00oOooO[i22]) {
                        case 2:
                            i8 = 21;
                            i7 = 23;
                            O00000Oo(i8, i7);
                            continue;
                        case 6:
                        case 35:
                            if ((j2 & 576460745995190270L) == 0) {
                                continue;
                            } else {
                                if (i23 > 69) {
                                    i23 = 69;
                                }
                                i9 = 35;
                                O000000o(i9);
                                continue;
                            }
                        case 9:
                            if ((j2 & 17592186048512L) != 0 && i23 > 60) {
                                i23 = 60;
                                continue;
                            }
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            if ((j2 & 137438953504L) != 0) {
                                i8 = 43;
                                i7 = 44;
                                O00000Oo(i8, i7);
                                continue;
                            } else {
                                continue;
                            }
                        case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                            if ((j2 & 343597383760L) != 0 && i23 > 64) {
                                i23 = 64;
                                continue;
                            }
                        case 17:
                            if ((j2 & -268435457) == 0) {
                                continue;
                            }
                            O000000o(18);
                            continue;
                        case 19:
                            if (this.O0000oO0 == '\\') {
                                i8 = 45;
                                i7 = 47;
                                O00000Oo(i8, i7);
                                continue;
                            } else {
                                continue;
                            }
                        case 20:
                            if ((j2 & 5700160604602368L) == 0) {
                                continue;
                            }
                            O000000o(18);
                            continue;
                        case 26:
                            if ((j2 & -268435457) == 0) {
                                continue;
                            }
                            O00000o(10, 12);
                            continue;
                        case 27:
                            if (this.O0000oO0 == '\\') {
                                i8 = 48;
                                i7 = 50;
                                O00000Oo(i8, i7);
                                continue;
                            } else {
                                continue;
                            }
                        case 28:
                            if ((j2 & 5700160604602368L) == 0) {
                                continue;
                            }
                            O00000o(10, 12);
                            continue;
                        case 40:
                            if ((j2 & 137438953504L) != 0) {
                                i8 = 51;
                                i7 = 52;
                                O00000Oo(i8, i7);
                                continue;
                            } else {
                                continue;
                            }
                        case 44:
                            if ((j2 & 137438953504L) != 0) {
                                i8 = 53;
                                i7 = 54;
                                O00000Oo(i8, i7);
                                continue;
                            } else {
                                continue;
                            }
                        case 48:
                            if ((j2 & 137438953504L) != 0) {
                                i8 = 55;
                                i7 = 56;
                                O00000Oo(i8, i7);
                                continue;
                            } else {
                                continue;
                            }
                        case 52:
                            if ((j2 & 72057594054705152L) != 0) {
                                i9 = 53;
                                O000000o(i9);
                                continue;
                            } else {
                                continue;
                            }
                        case 53:
                            if ((j2 & 541165879422L) == 0) {
                                continue;
                            } else {
                                if (i23 > 60) {
                                    i23 = 60;
                                }
                                O00000o0(53, 9);
                                continue;
                            }
                        case 57:
                            if (i23 > 7) {
                                i23 = 7;
                            }
                            O00000Oo(18, 20);
                            continue;
                        case 62:
                            i10 = 63;
                            i11 = 62;
                            O00000o0(i11, i10);
                            continue;
                        case 64:
                        case 65:
                            i11 = 65;
                            i10 = 63;
                            O00000o0(i11, i10);
                            continue;
                        case 68:
                            i12 = 68;
                            O00000o0(i12, 69);
                            continue;
                        case 70:
                        case 71:
                            i12 = 71;
                            O00000o0(i12, 69);
                            continue;
                    }
                } while (i22 != i24);
            } else {
                int i39 = c >> 8;
                int i40 = i39 >> 6;
                long j3 = 1 << (i39 & 63);
                int i41 = (c & 255) >> 6;
                long j4 = 1 << (c & '?');
                while (true) {
                    i22--;
                    int i42 = this.O00oOooO[i22];
                    if (i42 != 0) {
                        if (i42 != 2) {
                            if (i42 == 6) {
                                if (O000000o(i39, i41, j4)) {
                                    if (i23 > 6) {
                                        i23 = 6;
                                    }
                                    O000000o(0);
                                }
                                if (O00000Oo(i39, i40, i41, j3, j4)) {
                                    if (i23 > 69) {
                                        i23 = 69;
                                    }
                                    O000000o(35);
                                }
                            } else if (i42 != 17) {
                                if (i42 != 26) {
                                    if (i42 != 57) {
                                        if (i42 != 62) {
                                            if (i42 != 68) {
                                                if (i42 == 34 || i42 == 35) {
                                                    if (O00000Oo(i39, i40, i41, j3, j4)) {
                                                        if (i23 > 69) {
                                                            i23 = 69;
                                                        }
                                                        O000000o(35);
                                                    }
                                                } else if (i42 == 64 || i42 == 65) {
                                                    if (O000000o(i39, i40, i41, j3, j4)) {
                                                        i5 = 65;
                                                    }
                                                } else if ((i42 == 70 || i42 == 71) && O000000o(i39, i40, i41, j3, j4)) {
                                                    i6 = 71;
                                                }
                                            } else if (O000000o(i39, i40, i41, j3, j4)) {
                                                i6 = 68;
                                            }
                                            O00000o0(i6, 69);
                                        } else if (O000000o(i39, i40, i41, j3, j4)) {
                                            i5 = 62;
                                        }
                                        O00000o0(i5, 63);
                                    } else if (O000000o(i39, i40, i41, j3, j4)) {
                                        if (i23 > i27) {
                                            i23 = 7;
                                        }
                                        i3 = 20;
                                        i4 = 18;
                                        O00000Oo(i4, i3);
                                    }
                                } else if (O000000o(i39, i40, i41, j3, j4)) {
                                    i3 = 12;
                                    i4 = 10;
                                    O00000Oo(i4, i3);
                                }
                                if (i22 == i24) {
                                    if (i23 != Integer.MAX_VALUE) {
                                        this.O0000ooO = i23;
                                        this.O0000oo = i21;
                                        i23 = Integer.MAX_VALUE;
                                    }
                                    i21++;
                                    i22 = this.O0000oOo;
                                    this.O0000oOo = i24;
                                    i24 = 74 - i24;
                                    if (i22 != i24) {
                                        return i21;
                                    }
                                    try {
                                        this.O0000oO0 = this.O0000o.O00000Oo();
                                        i20 = 1;
                                    } catch (IOException unused) {
                                        return i21;
                                    }
                                } else {
                                    i27 = 7;
                                }
                            } else if (O000000o(i39, i40, i41, j3, j4)) {
                                int[] iArr2 = this.O00oOooO;
                                int i43 = this.O0000oOo;
                                this.O0000oOo = i43 + 1;
                                iArr2[i43] = 18;
                            }
                        } else if (O000000o(i39, i40, i41, j3, j4)) {
                            O00000Oo(21, 23);
                        }
                    } else if (O000000o(i39, i41, j4)) {
                        if (i23 > 6) {
                            i23 = 6;
                        }
                        O000000o(0);
                        if (i22 == i24) {
                        }
                    }
                    if (i22 == i24) {
                    }
                }
            }
            if (i23 != Integer.MAX_VALUE) {
            }
            i21++;
            i22 = this.O0000oOo;
            this.O0000oOo = i24;
            i24 = 74 - i24;
            if (i22 != i24) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, int]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000oO(long j) {
        long j2 = j & 32;
        if (j2 == 0) {
            return O00000Oo(24, 0, 0);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return this.O0000oO0 != 'g' ? O00000Oo(25, 0, 0) : O00000oo(j2);
        } catch (IOException unused) {
            O000000o(25, 0L, 0L);
            return 26;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000oO(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return O00000Oo(15, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            return c != 'g' ? c != 'h' ? (c == 'n' && (2 & j6) != 0) ? O000000o(17, 129) : O00000Oo(16, 0, j5) : O00000oo(j5, 9007199254740992L, j6, 32) : O00000oo(j5, 0, j6, 8);
        } catch (IOException unused) {
            O000000o(16, 0L, j5);
            return 17;
        }
    }

    private final int O00000oO(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(4, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c == '_') {
                return O00000oo(j7, 0, j8, 11258999068426240L, j9, 40);
            }
            if (c == 'a') {
                return O00000oo(j7, 137438953472L, j8, 0, j9, 0);
            }
            if (c == 'c') {
                return O00000oo(j7, 34359739392L, j8, 0, j9, 0);
            }
            if (c == 'l') {
                return O00000oo(j7, 288230376151711744L, j8, 0, j9, 0);
            }
            if (c != 'y') {
                if (c == 'e') {
                    return (4398046511104L & j7) != 0 ? O000000o(6, 42, 35) : (8796093022208L & j7) != 0 ? O000000o(6, 43, 35) : O00000oo(j7, 4503608217305088L, j8, 0, j9, 0);
                }
                if (c == 'f') {
                    return O00000oo(j7, 562949953421312L, j8, 0, j9, 0);
                }
                if (c != 'n') {
                    if (c == 'o') {
                        return O00000oo(j7, 2251799813685248L, j8, 0, j9, 0);
                    }
                    switch (c) {
                        case 's':
                            return (33554432 & j7) != 0 ? O000000o(6, 25, 35) : O00000oo(j7, 0, j8, 2882910691935649792L, j9, 2);
                        case 't':
                            return (1048576 & j7) != 0 ? O000000o(6, 20, 35) : O00000oo(j7, 17592186044416L, j8, 0, j9, 0);
                        case 'u':
                            return O00000oo(j7, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, j8, 0, j9, 0);
                    }
                } else if ((2048 & j7) != 0) {
                    return O000000o(6, 11, 35);
                }
            } else if ((268435456 & j7) != 0) {
                return O000000o(6, 28, 35);
            }
            return O00000Oo(5, j7, j8);
        } catch (IOException unused) {
            O000000o(5, j7, j8);
            return 6;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, int]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000oo(long j) {
        long j2 = j & 32;
        if (j2 == 0) {
            return O00000Oo(25, 0, 0);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            return (this.O0000oO0 == 'n' && (j2 & 32) != 0) ? O000000o(27, 133) : O00000Oo(26, 0, 0);
        } catch (IOException unused) {
            O000000o(26, 0L, 0L);
            return 27;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.le.O000000o(int, long, long):int
     arg types: [int, int, long]
     candidates:
      _m_j.le.O000000o(int, int, int):int
      _m_j.le.O000000o(long, long, long):int
      _m_j.le.O000000o(int, int, long):boolean
      _m_j.le.O000000o(int, long, long):int */
    private final int O00000oo(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return O00000Oo(16, 0, j);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            return c != 'i' ? (c == 'n' && (j6 & 8) != 0) ? O000000o(18, 131) : O00000Oo(17, 0, j5) : O000000o(j5, j6);
        } catch (IOException unused) {
            O000000o(17, 0L, j5);
            return 18;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final int O00000oo(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(5, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c == 'c') {
                return O0000O0o(j7, 137438953472L, j8, 0, j9, 0);
            }
            if (c == 'e') {
                return (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED & j7) != 0 ? O000000o(7, 19, 35) : (288230376151711744L & j7) != 0 ? O000000o(7, 58, 35) : O0000O0o(j7, 17626545782784L, j8, 43980465111040L, j9, 0);
            }
            if (c == 'n') {
                return O0000O0o(j7, 6755408030990336L, j8, 0, j9, 0);
            }
            if (c != 'p') {
                if (c == 'h') {
                    return O0000O0o(j7, 0, j8, 562949953421312L, j9, 2);
                }
                if (c == 'i') {
                    return O0000O0o(j7, 0, j8, 2305843009213693952L, j9, 0);
                }
                switch (c) {
                    case 's':
                        return O0000O0o(j7, 0, j8, 578712552117108736L, j9, 8);
                    case 't':
                        if ((1024 & j7) != 0) {
                            return O000000o(7, 10, 35);
                        }
                        break;
                    case 'u':
                        return O0000O0o(j7, 0, j8, 9007199254740992L, j9, 32);
                }
            } else if ((562949953421312L & j7) != 0) {
                return O000000o(7, 49, 35);
            }
            return O00000Oo(6, j7, j8);
        } catch (IOException unused) {
            O000000o(6, j7, j8);
            return 7;
        }
    }

    private final int O0000O0o(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(6, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c == '_') {
                return O0000OOo(j7, 0, j8, 43980465111040L, j9, 0);
            }
            if (c == 't') {
                return (4503599627370496L & j7) != 0 ? O000000o(8, 52, 35) : O0000OOo(j7, 8589934592L, j8, 0, j9, 0);
            }
            if (c != 'd') {
                if (c != 'e') {
                    if (c == 'n') {
                        return O0000OOo(j7, 0, j8, 9007199254740992L, j9, 32);
                    }
                    if (c == 'o') {
                        return O0000OOo(j7, 34359738368L, j8, 0, j9, 0);
                    }
                    switch (c) {
                        case 'g':
                            return O0000OOo(j7, 0, j8, 2305843009213693952L, j9, 0);
                        case 'h':
                            return O0000OOo(j7, 0, j8, 2251799813685248L, j9, 8);
                        case 'i':
                            return O0000OOo(j7, 2251799813685248L, j8, 577023702256844800L, j9, 2);
                    }
                } else if ((137438953472L & j7) != 0) {
                    return O000000o(8, 37, 35);
                }
            } else if ((17592186044416L & j7) != 0) {
                return O000000o(8, 44, 35);
            }
            return O00000Oo(7, j7, j8);
        } catch (IOException unused) {
            O000000o(7, j7, j8);
            return 8;
        }
    }

    private final int O0000OOo(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(7, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c == 'a') {
                return O0000Oo0(j7, 0, j8, 8796093022208L, j9, 0);
            }
            if (c == 'i') {
                return O0000Oo0(j7, 0, j8, 2251799813685248L, j9, 8);
            }
            if (c == 's') {
                return (8589934592L & j7) != 0 ? O000000o(9, 33, 35) : O0000Oo0(j7, 0, j8, 9007199254740992L, j9, 32);
            }
            if (c == 'z') {
                return O0000Oo0(j7, 2251799813685248L, j8, 0, j9, 0);
            }
            if (c == 'f') {
                return (34359738368L & j7) != 0 ? O000000o(9, 35, 35) : O0000Oo0(j7, 0, j8, 562949953421312L, j9, 2);
            }
            if (c == 'g') {
                return O0000Oo0(j7, 0, j8, 576460752303423488L, j9, 0);
            }
            if (c != 'n') {
                if (c == 'o') {
                    return O0000Oo0(j7, 0, j8, 35184372088832L, j9, 0);
                }
            } else if ((2305843009213693952L & j8) != 0) {
                return O000000o(9, 125);
            }
            return O00000Oo(8, j7, j8);
        } catch (IOException unused) {
            O000000o(8, j7, j8);
            return 9;
        }
    }

    private final int O0000Oo(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(9, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c == '_') {
                return O000000o(j7, j8, 0, j9, 2);
            }
            if (c != 'd') {
                if (c == 'g') {
                    return O000000o(j7, j8, 9007199254740992L, j9, 32);
                }
                if (c == 't') {
                    if ((2251799813685248L & j8) != 0) {
                        this.O0000ooO = 115;
                        this.O0000oo = 11;
                    }
                    return O000000o(j7, j8, 0, j9, 8);
                }
            } else if ((j7 & 2251799813685248L) != 0) {
                return O000000o(11, 51, 35);
            } else {
                if ((8796093022208L & j8) != 0) {
                    return O000000o(11, 107);
                }
            }
            return O00000Oo(10, j7, j8);
        } catch (IOException unused) {
            O000000o(10, j7, j8);
            return 11;
        }
    }

    private final int O0000Oo0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return O00000Oo(8, j, j3);
        }
        try {
            this.O0000oO0 = this.O0000o.O00000Oo();
            char c = this.O0000oO0;
            if (c == 'e') {
                return O0000Oo(j7, 2251799813685248L, j8, 0, j9, 0);
            }
            if (c == 'f') {
                return O0000Oo(j7, 0, j8, 2251799813685248L, j9, 8);
            }
            if (c == 'i') {
                return O0000Oo(j7, 0, j8, 9007199254740992L, j9, 32);
            }
            if (c == 'n') {
                return (576460752303423488L & j8) != 0 ? O000000o(10, 123) : O0000Oo(j7, 0, j8, 8796093022208L, j9, 0);
            }
            if (c != 'r') {
                if (c == 't') {
                    if ((562949953421312L & j8) != 0) {
                        this.O0000ooO = 113;
                        this.O0000oo = 10;
                    }
                    return O0000Oo(j7, 0, j8, 0, j9, 2);
                }
            } else if ((35184372088832L & j8) != 0) {
                return O000000o(10, 109);
            }
            return O00000Oo(9, j7, j8);
        } catch (IOException unused) {
            O000000o(9, j7, j8);
            return 10;
        }
    }

    public final void O000000o(lc lcVar) {
        this.O0000oOo = 0;
        this.O0000oo = 0;
        this.O0000oO = this.O0000oOO;
        this.O0000o = lcVar;
        O00000Oo();
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x01d6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0190  */
    public final Token O000000o() {
        int i;
        int i2;
        int i3;
        boolean z;
        String str;
        int i4;
        long j;
        long j2;
        long j3;
        int i5;
        String str2 = "";
        String str3 = null;
        Token token = null;
        while (true) {
            try {
                this.O0000oO0 = this.O0000o.O000000o();
                this.O0000ooO = Integer.MAX_VALUE;
                this.O0000oo = 0;
                char c = this.O0000oO0;
                if (c == 9) {
                    i4 = 2;
                } else if (c == 10) {
                    i4 = 5;
                } else if (c == 12) {
                    i4 = 4;
                } else if (c != 13) {
                    if (c != ' ') {
                        if (c == '!') {
                            this.O0000ooO = 86;
                            j3 = 0;
                            j2 = 2147483648L;
                        } else if (c == '%') {
                            this.O0000ooO = 111;
                            j3 = 0;
                            j2 = Long.MIN_VALUE;
                        } else if (c != '&') {
                            if (c == ']') {
                                i5 = 77;
                            } else if (c != '^') {
                                if (c == 'v') {
                                    j3 = 432345564227567616L;
                                } else if (c != 'w') {
                                    switch (c) {
                                        case '(':
                                            i5 = 72;
                                            break;
                                        case ')':
                                            i5 = 73;
                                            break;
                                        case '*':
                                            this.O0000ooO = 104;
                                            j3 = 0;
                                            j2 = 72057594037927936L;
                                            break;
                                        case '+':
                                            this.O0000ooO = 102;
                                            j3 = 0;
                                            j2 = 18014467228958720L;
                                            break;
                                        case ',':
                                            i5 = 79;
                                            break;
                                        case '-':
                                            this.O0000ooO = 103;
                                            j3 = 0;
                                            j2 = 36028934457917440L;
                                            break;
                                        case '.':
                                            i = O000000o(0, 80, 11);
                                            break;
                                        case '/':
                                            this.O0000ooO = 105;
                                            j3 = 0;
                                            j2 = 144115188075855872L;
                                            break;
                                        case '[':
                                            i5 = 76;
                                            break;
                                        case 'i':
                                            j3 = 270582939648L;
                                            break;
                                        case 'l':
                                            j3 = 274877906944L;
                                            break;
                                        case 'n':
                                            j3 = 3848290697216L;
                                            break;
                                        case 'p':
                                            j3 = 65970697666560L;
                                            break;
                                        case '{':
                                            i5 = 74;
                                            break;
                                        case '|':
                                            this.O0000ooO = 108;
                                            j3 = 0;
                                            j2 = 1152921508901814272L;
                                            break;
                                        case '}':
                                            i5 = 75;
                                            break;
                                        case '~':
                                            i5 = 87;
                                            break;
                                        default:
                                            switch (c) {
                                                case ':':
                                                    i5 = 89;
                                                    break;
                                                case ';':
                                                    i5 = 78;
                                                    break;
                                                case '<':
                                                    this.O0000ooO = 84;
                                                    j3 = 0;
                                                    j2 = 281475110928384L;
                                                    j = 1;
                                                    i = O000000o(j3, j2, j);
                                                    break;
                                                case '=':
                                                    this.O0000ooO = 81;
                                                    j3 = 0;
                                                    j2 = 67108864;
                                                    break;
                                                case '>':
                                                    this.O0000ooO = 82;
                                                    j3 = 0;
                                                    j2 = 5629500071084032L;
                                                    j = 20;
                                                    i = O000000o(j3, j2, j);
                                                    break;
                                                case '?':
                                                    i5 = 88;
                                                    break;
                                                case '@':
                                                    j3 = 0;
                                                    j2 = 2894169735298547712L;
                                                    j = 42;
                                                    i = O000000o(j3, j2, j);
                                                    break;
                                                default:
                                                    switch (c) {
                                                        case 'a':
                                                            j3 = 1024;
                                                            break;
                                                        case 'b':
                                                            j3 = 22528;
                                                            break;
                                                        case 'c':
                                                            j3 = 1024000;
                                                            break;
                                                        case 'd':
                                                            j3 = 7340032;
                                                            break;
                                                        case 'e':
                                                            j3 = 58720256;
                                                            break;
                                                        case 'f':
                                                            j3 = 2080374784;
                                                            break;
                                                        case 'g':
                                                            j3 = 2147483648L;
                                                            break;
                                                        default:
                                                            switch (c) {
                                                                case 'r':
                                                                    j3 = 70368744177664L;
                                                                    break;
                                                                case 's':
                                                                    j3 = 4362862139015168L;
                                                                    break;
                                                                case 't':
                                                                    j3 = 139611588448485376L;
                                                                    break;
                                                                default:
                                                                    i = O00000oO(6, 0);
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                                } else {
                                    j3 = 576460752303423488L;
                                }
                                j2 = 0;
                            } else {
                                this.O0000ooO = 110;
                                j3 = 0;
                                j2 = 4611686018427387904L;
                            }
                            i = O000000o(0, i5);
                        } else {
                            this.O0000ooO = 106;
                            j3 = 0;
                            j2 = 288230393331580928L;
                        }
                        j = 0;
                        i = O000000o(j3, j2, j);
                    } else {
                        i = O000000o(0, 1, 0);
                    }
                    if (this.O0000ooO == Integer.MAX_VALUE) {
                        int i6 = this.O0000oo;
                        if (i6 + 1 < i) {
                            this.O0000o.O000000o((i - i6) - 1);
                        }
                        long[] jArr = O0000o0;
                        int i7 = this.O0000ooO;
                        if ((jArr[i7 >> 6] & (1 << (i7 & 63))) != 0) {
                            Token O00000o02 = O00000o0();
                            O00000o02.specialToken = token;
                            return O00000o02;
                        }
                        if (((1 << (i7 & 63)) & O0000o0o[i7 >> 6]) != 0) {
                            Token O00000o03 = O00000o0();
                            if (token != null) {
                                O00000o03.specialToken = token;
                                token.next = O00000o03;
                            }
                            token = O00000o03;
                        }
                    } else {
                        int O00000o2 = this.O0000o.O00000o();
                        int O00000o04 = this.O0000o.O00000o0();
                        try {
                            this.O0000o.O00000Oo();
                            this.O0000o.O000000o(1);
                            i3 = O00000o2;
                            i2 = O00000o04;
                            z = false;
                        } catch (IOException unused) {
                            str3 = i <= 1 ? str2 : this.O0000o.O0000O0o();
                            char c2 = this.O0000oO0;
                            if (c2 == 10 || c2 == 13) {
                                i3 = O00000o2 + 1;
                                z = true;
                                i2 = 0;
                            } else {
                                i3 = O00000o2;
                                i2 = O00000o04 + 1;
                                z = true;
                            }
                        }
                        if (!z) {
                            this.O0000o.O000000o(1);
                            if (i > 1) {
                                str2 = this.O0000o.O0000O0o();
                            }
                            str = str2;
                        } else {
                            str = str3;
                        }
                        throw new TokenMgrError(z, this.O0000oO, i3, i2, str, this.O0000oO0, 0);
                    }
                } else {
                    i4 = 3;
                }
                i = O000000o(0, i4, 0);
                if (this.O0000ooO == Integer.MAX_VALUE) {
                }
            } catch (IOException unused2) {
                this.O0000ooO = 0;
                Token O00000o05 = O00000o0();
                O00000o05.specialToken = token;
                return O00000o05;
            }
        }
    }
}

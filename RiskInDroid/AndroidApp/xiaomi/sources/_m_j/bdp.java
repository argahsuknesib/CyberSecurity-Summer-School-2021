package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.imi.fastjson.JSONException;
import com.imi.fastjson.parser.Feature;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

public abstract class bdp implements Closeable {
    protected static boolean[] O0000o0;
    protected static final char[] O0000o00 = (jdn.f1779O000000o + bdf.f12884O000000o + "\":\"").toCharArray();
    protected static final int[] O0000o0O = new int[103];
    private static final ThreadLocal<SoftReference<char[]>> O0000o0o = new ThreadLocal<>();

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f12888O000000o;
    protected int O00000Oo;
    protected char O00000o;
    protected int O00000o0 = bdf.O00000Oo;
    protected int O00000oO;
    protected int O00000oo;
    protected char[] O0000O0o;
    protected int O0000OOo;
    protected boolean O0000Oo;
    protected int O0000Oo0;
    protected Calendar O0000OoO = null;
    protected bds O0000Ooo = bds.O00000Oo;

    private static boolean O00000Oo(char c) {
        return c == ' ' || c == 10 || c == 13 || c == 9 || c == 12 || c == 8;
    }

    public abstract String O000000o(int i, int i2, int i3, bdv bdv);

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i, int i2, char[] cArr);

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i, char[] cArr, int i2);

    public abstract char O00000o0(int i);

    public abstract String O0000OOo();

    public abstract boolean O0000Oo0();

    public abstract char O0000OoO();

    public abstract byte[] O0000o0o();

    public abstract String O0000oO0();

    static {
        boolean[] zArr = new boolean[256];
        O0000o0 = zArr;
        zArr[32] = true;
        boolean[] zArr2 = O0000o0;
        zArr2[10] = true;
        zArr2[13] = true;
        zArr2[9] = true;
        zArr2[12] = true;
        zArr2[8] = true;
        for (int i = 48; i <= 57; i++) {
            O0000o0O[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            O0000o0O[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            O0000o0O[i3] = (i3 - 65) + 10;
        }
    }

    public bdp() {
        SoftReference softReference = O0000o0o.get();
        if (softReference != null) {
            this.O0000O0o = (char[]) softReference.get();
            O0000o0o.set(null);
        }
        if (this.O0000O0o == null) {
            this.O0000O0o = new char[64];
        }
    }

    public final void O000000o() {
        this.O0000OOo = 0;
        while (true) {
            this.O00000Oo = this.O00000oO;
            char c = this.O00000o;
            if (c == '\"') {
                O0000o00();
                return;
            } else if (c == ',') {
                O0000OoO();
                this.f12888O000000o = 16;
                return;
            } else if (c < '0' || c > '9') {
                char c2 = this.O00000o;
                if (c2 == '-') {
                    O0000oOo();
                    return;
                }
                if (!(c2 == 12 || c2 == 13 || c2 == ' ')) {
                    if (c2 == ':') {
                        O0000OoO();
                        this.f12888O000000o = 17;
                        return;
                    } else if (c2 == '[') {
                        O0000OoO();
                        this.f12888O000000o = 14;
                        return;
                    } else if (c2 == ']') {
                        O0000OoO();
                        this.f12888O000000o = 15;
                        return;
                    } else if (c2 != 'f') {
                        if (c2 != 'n') {
                            if (c2 != 't') {
                                if (c2 == '{') {
                                    O0000OoO();
                                    this.f12888O000000o = 12;
                                    return;
                                } else if (c2 == '}') {
                                    O0000OoO();
                                    this.f12888O000000o = 13;
                                    return;
                                } else if (c2 != 'S') {
                                    if (c2 != 'T') {
                                        switch (c2) {
                                            default:
                                                switch (c2) {
                                                    case '\'':
                                                        if (O000000o(Feature.AllowSingleQuotes)) {
                                                            this.O0000Oo0 = this.O00000oO;
                                                            this.O0000Oo = false;
                                                            while (true) {
                                                                int i = this.O00000oO + 1;
                                                                this.O00000oO = i;
                                                                char O00000o02 = O00000o0(i);
                                                                if (O00000o02 == '\'') {
                                                                    this.f12888O000000o = 4;
                                                                    O0000OoO();
                                                                    return;
                                                                } else if (O00000o02 == 26) {
                                                                    throw new JSONException("unclosed single-quote string");
                                                                } else if (O00000o02 == '\\') {
                                                                    if (!this.O0000Oo) {
                                                                        this.O0000Oo = true;
                                                                        int i2 = this.O0000OOo;
                                                                        char[] cArr = this.O0000O0o;
                                                                        if (i2 > cArr.length) {
                                                                            char[] cArr2 = new char[(i2 * 2)];
                                                                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                                                                            this.O0000O0o = cArr2;
                                                                        }
                                                                        O000000o(this.O0000Oo0 + 1, this.O0000OOo, this.O0000O0o);
                                                                    }
                                                                    int i3 = this.O00000oO + 1;
                                                                    this.O00000oO = i3;
                                                                    char O00000o03 = O00000o0(i3);
                                                                    if (O00000o03 == '\"') {
                                                                        O000000o('\"');
                                                                    } else if (O00000o03 != '\'') {
                                                                        if (O00000o03 != 'F') {
                                                                            if (O00000o03 == '\\') {
                                                                                O000000o('\\');
                                                                            } else if (O00000o03 == 'b') {
                                                                                O000000o(8);
                                                                            } else if (O00000o03 != 'f') {
                                                                                if (O00000o03 == 'n') {
                                                                                    O000000o(10);
                                                                                } else if (O00000o03 == 'r') {
                                                                                    O000000o(13);
                                                                                } else if (O00000o03 != 'x') {
                                                                                    switch (O00000o03) {
                                                                                        case '/':
                                                                                            O000000o('/');
                                                                                            continue;
                                                                                        case '0':
                                                                                            O000000o(0);
                                                                                            continue;
                                                                                        case '1':
                                                                                            O000000o(1);
                                                                                            continue;
                                                                                        case '2':
                                                                                            O000000o(2);
                                                                                            continue;
                                                                                        case '3':
                                                                                            O000000o(3);
                                                                                            continue;
                                                                                        case '4':
                                                                                            O000000o(4);
                                                                                            continue;
                                                                                        case '5':
                                                                                            O000000o(5);
                                                                                            continue;
                                                                                        case '6':
                                                                                            O000000o(6);
                                                                                            continue;
                                                                                        case '7':
                                                                                            O000000o(7);
                                                                                            continue;
                                                                                        default:
                                                                                            switch (O00000o03) {
                                                                                                case 't':
                                                                                                    O000000o(9);
                                                                                                    continue;
                                                                                                case 'u':
                                                                                                    int i4 = this.O00000oO + 1;
                                                                                                    this.O00000oO = i4;
                                                                                                    char O00000o04 = O00000o0(i4);
                                                                                                    int i5 = this.O00000oO + 1;
                                                                                                    this.O00000oO = i5;
                                                                                                    char O00000o05 = O00000o0(i5);
                                                                                                    int i6 = this.O00000oO + 1;
                                                                                                    this.O00000oO = i6;
                                                                                                    char O00000o06 = O00000o0(i6);
                                                                                                    int i7 = this.O00000oO + 1;
                                                                                                    this.O00000oO = i7;
                                                                                                    O000000o((char) Integer.parseInt(new String(new char[]{O00000o04, O00000o05, O00000o06, O00000o0(i7)}), 16));
                                                                                                    continue;
                                                                                                case 'v':
                                                                                                    O000000o(11);
                                                                                                    continue;
                                                                                                    continue;
                                                                                                default:
                                                                                                    this.O00000o = O00000o03;
                                                                                                    throw new JSONException("unclosed single-quote string");
                                                                                            }
                                                                                    }
                                                                                } else {
                                                                                    int i8 = this.O00000oO + 1;
                                                                                    this.O00000oO = i8;
                                                                                    char O00000o07 = O00000o0(i8);
                                                                                    int i9 = this.O00000oO + 1;
                                                                                    this.O00000oO = i9;
                                                                                    char O00000o08 = O00000o0(i9);
                                                                                    int[] iArr = O0000o0O;
                                                                                    O000000o((char) ((iArr[O00000o07] * 16) + iArr[O00000o08]));
                                                                                }
                                                                            }
                                                                        }
                                                                        O000000o(12);
                                                                    } else {
                                                                        O000000o('\'');
                                                                    }
                                                                } else if (!this.O0000Oo) {
                                                                    this.O0000OOo++;
                                                                } else {
                                                                    int i10 = this.O0000OOo;
                                                                    char[] cArr3 = this.O0000O0o;
                                                                    if (i10 == cArr3.length) {
                                                                        O000000o(O00000o02);
                                                                    } else {
                                                                        this.O0000OOo = i10 + 1;
                                                                        cArr3[i10] = O00000o02;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            throw new JSONException("Feature.AllowSingleQuotes is false");
                                                        }
                                                    case '(':
                                                        O0000OoO();
                                                        this.f12888O000000o = 10;
                                                        return;
                                                    case ')':
                                                        O0000OoO();
                                                        this.f12888O000000o = 11;
                                                        return;
                                                    default:
                                                        if (!O0000Oo0()) {
                                                            this.f12888O000000o = 1;
                                                            O0000OoO();
                                                            return;
                                                        } else if (this.f12888O000000o != 20) {
                                                            this.f12888O000000o = 20;
                                                            int i11 = this.O00000oo;
                                                            this.O00000oO = i11;
                                                            this.O00000Oo = i11;
                                                            return;
                                                        } else {
                                                            throw new JSONException("EOF error");
                                                        }
                                                }
                                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                            case 9:
                                            case 10:
                                                break;
                                        }
                                    } else if (c2 == 'T') {
                                        O0000OoO();
                                        if (this.O00000o == 'r') {
                                            O0000OoO();
                                            if (this.O00000o == 'e') {
                                                O0000OoO();
                                                if (this.O00000o == 'e') {
                                                    O0000OoO();
                                                    if (this.O00000o == 'S') {
                                                        O0000OoO();
                                                        if (this.O00000o == 'e') {
                                                            O0000OoO();
                                                            if (this.O00000o == 't') {
                                                                O0000OoO();
                                                                char c3 = this.O00000o;
                                                                if (c3 == ' ' || c3 == 10 || c3 == 13 || c3 == 9 || c3 == 12 || c3 == 8 || c3 == '[' || c3 == '(') {
                                                                    this.f12888O000000o = 22;
                                                                    return;
                                                                }
                                                                throw new JSONException("scan set error");
                                                            }
                                                            throw new JSONException("error parse true");
                                                        }
                                                        throw new JSONException("error parse true");
                                                    }
                                                    throw new JSONException("error parse true");
                                                }
                                                throw new JSONException("error parse true");
                                            }
                                            throw new JSONException("error parse true");
                                        }
                                        throw new JSONException("error parse true");
                                    } else {
                                        throw new JSONException("error parse true");
                                    }
                                } else if (c2 == 'S') {
                                    O0000OoO();
                                    if (this.O00000o == 'e') {
                                        O0000OoO();
                                        if (this.O00000o == 't') {
                                            O0000OoO();
                                            char c4 = this.O00000o;
                                            if (c4 == ' ' || c4 == 10 || c4 == 13 || c4 == 9 || c4 == 12 || c4 == 8 || c4 == '[' || c4 == '(') {
                                                this.f12888O000000o = 21;
                                                return;
                                            }
                                            throw new JSONException("scan set error");
                                        }
                                        throw new JSONException("error parse true");
                                    }
                                    throw new JSONException("error parse true");
                                } else {
                                    throw new JSONException("error parse true");
                                }
                            } else if (c2 == 't') {
                                O0000OoO();
                                if (this.O00000o == 'r') {
                                    O0000OoO();
                                    if (this.O00000o == 'u') {
                                        O0000OoO();
                                        if (this.O00000o == 'e') {
                                            O0000OoO();
                                            char c5 = this.O00000o;
                                            if (c5 == ' ' || c5 == ',' || c5 == '}' || c5 == ']' || c5 == 10 || c5 == 13 || c5 == 9 || c5 == 26 || c5 == 12 || c5 == 8) {
                                                this.f12888O000000o = 6;
                                                return;
                                            }
                                            throw new JSONException("scan true error");
                                        }
                                        throw new JSONException("error parse true");
                                    }
                                    throw new JSONException("error parse true");
                                }
                                throw new JSONException("error parse true");
                            } else {
                                throw new JSONException("error parse true");
                            }
                        } else if (c2 == 'n') {
                            O0000OoO();
                            char c6 = this.O00000o;
                            if (c6 == 'u') {
                                O0000OoO();
                                if (this.O00000o == 'l') {
                                    O0000OoO();
                                    if (this.O00000o == 'l') {
                                        O0000OoO();
                                        char c7 = this.O00000o;
                                        if (c7 == ' ' || c7 == ',' || c7 == '}' || c7 == ']' || c7 == 10 || c7 == 13 || c7 == 9 || c7 == 26 || c7 == 12 || c7 == 8) {
                                            this.f12888O000000o = 8;
                                            return;
                                        }
                                        throw new JSONException("scan true error");
                                    }
                                    throw new JSONException("error parse true");
                                }
                                throw new JSONException("error parse true");
                            } else if (c6 == 'e') {
                                O0000OoO();
                                if (this.O00000o == 'w') {
                                    O0000OoO();
                                    char c8 = this.O00000o;
                                    if (c8 == ' ' || c8 == ',' || c8 == '}' || c8 == ']' || c8 == 10 || c8 == 13 || c8 == 9 || c8 == 26 || c8 == 12 || c8 == 8) {
                                        this.f12888O000000o = 9;
                                        return;
                                    }
                                    throw new JSONException("scan true error");
                                }
                                throw new JSONException("error parse w");
                            } else {
                                throw new JSONException("error parse e");
                            }
                        } else {
                            throw new JSONException("error parse null or new");
                        }
                    } else if (c2 == 'f') {
                        O0000OoO();
                        if (this.O00000o == 'a') {
                            O0000OoO();
                            if (this.O00000o == 'l') {
                                O0000OoO();
                                if (this.O00000o == 's') {
                                    O0000OoO();
                                    if (this.O00000o == 'e') {
                                        O0000OoO();
                                        char c9 = this.O00000o;
                                        if (c9 == ' ' || c9 == ',' || c9 == '}' || c9 == ']' || c9 == 10 || c9 == 13 || c9 == 9 || c9 == 26 || c9 == 12 || c9 == 8) {
                                            this.f12888O000000o = 7;
                                            return;
                                        }
                                        throw new JSONException("scan false error");
                                    }
                                    throw new JSONException("error parse false");
                                }
                                throw new JSONException("error parse false");
                            }
                            throw new JSONException("error parse false");
                        }
                        throw new JSONException("error parse false");
                    } else {
                        throw new JSONException("error parse false");
                    }
                }
                O0000OoO();
            } else {
                O0000oOo();
                return;
            }
        }
    }

    public final void O000000o(int i) {
        this.O0000OOo = 0;
        while (true) {
            if (i == 2) {
                char c = this.O00000o;
                if (c < '0' || c > '9') {
                    char c2 = this.O00000o;
                    if (c2 == '\"') {
                        this.O00000Oo = this.O00000oO;
                        O0000o00();
                        return;
                    } else if (c2 == '[') {
                        this.f12888O000000o = 14;
                        O0000OoO();
                        return;
                    } else if (c2 == '{') {
                        this.f12888O000000o = 12;
                        O0000OoO();
                        return;
                    }
                } else {
                    this.O00000Oo = this.O00000oO;
                    O0000oOo();
                    return;
                }
            } else if (i == 4) {
                char c3 = this.O00000o;
                if (c3 == '\"') {
                    this.O00000Oo = this.O00000oO;
                    O0000o00();
                    return;
                } else if (c3 < '0' || c3 > '9') {
                    char c4 = this.O00000o;
                    if (c4 == '[') {
                        this.f12888O000000o = 14;
                        O0000OoO();
                        return;
                    } else if (c4 == '{') {
                        this.f12888O000000o = 12;
                        O0000OoO();
                        return;
                    }
                } else {
                    this.O00000Oo = this.O00000oO;
                    O0000oOo();
                    return;
                }
            } else if (i == 12) {
                char c5 = this.O00000o;
                if (c5 == '{') {
                    this.f12888O000000o = 12;
                    O0000OoO();
                    return;
                } else if (c5 == '[') {
                    this.f12888O000000o = 14;
                    O0000OoO();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c6 = this.O00000o;
                            if (c6 == '[') {
                                this.f12888O000000o = 14;
                                O0000OoO();
                                return;
                            } else if (c6 == '{') {
                                this.f12888O000000o = 12;
                                O0000OoO();
                                return;
                            }
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            if (this.O00000o == ']') {
                                this.f12888O000000o = 15;
                                O0000OoO();
                                return;
                            }
                            break;
                        case 16:
                            char c7 = this.O00000o;
                            if (c7 == ',') {
                                this.f12888O000000o = 16;
                                O0000OoO();
                                return;
                            } else if (c7 == '}') {
                                this.f12888O000000o = 13;
                                O0000OoO();
                                return;
                            } else if (c7 == ']') {
                                this.f12888O000000o = 15;
                                O0000OoO();
                                return;
                            } else if (c7 == 26) {
                                this.f12888O000000o = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.O00000o == 26) {
                    this.f12888O000000o = 20;
                    return;
                }
            } else {
                while (O00000Oo(this.O00000o)) {
                    O0000OoO();
                }
                char c8 = this.O00000o;
                if (c8 == '_' || Character.isLetter(c8)) {
                    this.O0000Oo0 = this.O00000oO - 1;
                    this.O0000Oo = false;
                    do {
                        this.O0000OOo++;
                        O0000OoO();
                    } while (Character.isLetterOrDigit(this.O00000o));
                    Integer num = this.O0000Ooo.f12889O000000o.get(O0000oO0());
                    if (num != null) {
                        this.f12888O000000o = num.intValue();
                        return;
                    } else {
                        this.f12888O000000o = 18;
                        return;
                    }
                } else {
                    O000000o();
                    return;
                }
            }
            char c9 = this.O00000o;
            if (c9 == ' ' || c9 == 10 || c9 == 13 || c9 == 9 || c9 == 12 || c9 == 8) {
                O0000OoO();
            } else {
                O000000o();
                return;
            }
        }
    }

    public final void O00000Oo() {
        this.O0000OOo = 0;
        while (true) {
            char c = this.O00000o;
            if (c == ':') {
                O0000OoO();
                O000000o();
                return;
            } else if (c == ' ' || c == 10 || c == 13 || c == 9 || c == 12 || c == 8) {
                O0000OoO();
            } else {
                throw new JSONException("not match ':' - " + this.O00000o);
            }
        }
    }

    public final int O00000o0() {
        return this.f12888O000000o;
    }

    public final String O00000o() {
        return bdr.O000000o(this.f12888O000000o);
    }

    public final int O00000oO() {
        return this.O00000Oo;
    }

    public final int O00000oo() {
        return this.O00000oO;
    }

    public final Number O0000O0o() throws NumberFormatException {
        char c;
        boolean z;
        long j;
        long j2;
        int i = this.O0000Oo0;
        int i2 = this.O0000OOo + i;
        char O00000o02 = O00000o0(i2 - 1);
        if (O00000o02 == 'B') {
            i2--;
            c = 'B';
        } else if (O00000o02 == 'L') {
            i2--;
            c = 'L';
        } else if (O00000o02 != 'S') {
            c = ' ';
        } else {
            i2--;
            c = 'S';
        }
        if (O00000o0(this.O0000Oo0) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i < i2) {
            j2 = (long) (-O0000o0O[O00000o0(i)]);
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int i4 = O0000o0O[O00000o0(i)];
            if (j2 < -922337203685477580L) {
                return new BigInteger(O0000OOo());
            }
            long j3 = j2 * 10;
            long j4 = (long) i4;
            if (j3 < j + j4) {
                return new BigInteger(O0000OOo());
            }
            j2 = j3 - j4;
            i = i3;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c == 'L') {
                return Long.valueOf(j5);
            }
            if (c == 'S') {
                return Short.valueOf((short) ((int) j5));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j5));
            }
            return Integer.valueOf((int) j5);
        } else if (i <= this.O0000Oo0 + 1) {
            throw new NumberFormatException(O0000OOo());
        } else if (j2 < -2147483648L || c == 'L') {
            return Long.valueOf(j2);
        } else {
            return Integer.valueOf((int) j2);
        }
    }

    public final void O00000Oo(int i) {
        this.O0000OOo = 0;
        while (true) {
            char c = this.O00000o;
            if (c == ':') {
                O0000OoO();
                while (true) {
                    if (i == 2) {
                        char c2 = this.O00000o;
                        if (c2 >= '0' && c2 <= '9') {
                            this.O00000Oo = this.O00000oO;
                            O0000oOo();
                            return;
                        } else if (this.O00000o == '\"') {
                            this.O00000Oo = this.O00000oO;
                            O0000o00();
                            return;
                        }
                    } else if (i == 4) {
                        char c3 = this.O00000o;
                        if (c3 == '\"') {
                            this.O00000Oo = this.O00000oO;
                            O0000o00();
                            return;
                        } else if (c3 >= '0' && c3 <= '9') {
                            this.O00000Oo = this.O00000oO;
                            O0000oOo();
                            return;
                        }
                    } else if (i == 12) {
                        char c4 = this.O00000o;
                        if (c4 == '{') {
                            this.f12888O000000o = 12;
                            O0000OoO();
                            return;
                        } else if (c4 == '[') {
                            this.f12888O000000o = 14;
                            O0000OoO();
                            return;
                        }
                    } else if (i == 14) {
                        char c5 = this.O00000o;
                        if (c5 == '[') {
                            this.f12888O000000o = 14;
                            O0000OoO();
                            return;
                        } else if (c5 == '{') {
                            this.f12888O000000o = 12;
                            O0000OoO();
                            return;
                        }
                    }
                    if (O00000Oo(this.O00000o)) {
                        O0000OoO();
                    } else {
                        O000000o();
                        return;
                    }
                }
            } else if (O00000Oo(c)) {
                O0000OoO();
            } else {
                throw new JSONException("not match ':', actual " + this.O00000o);
            }
        }
    }

    public final boolean O000000o(Feature feature) {
        return Feature.isEnabled(this.O00000o0, feature);
    }

    public final char O0000Oo() {
        return this.O00000o;
    }

    public final String O000000o(bdv bdv) {
        O0000oOO();
        char c = this.O00000o;
        if (c == '\"') {
            return O000000o(bdv, '\"');
        }
        if (c == '\'') {
            if (O000000o(Feature.AllowSingleQuotes)) {
                return O000000o(bdv, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c == '}') {
            O0000OoO();
            this.f12888O000000o = 13;
            return null;
        } else if (c == ',') {
            O0000OoO();
            this.f12888O000000o = 16;
            return null;
        } else if (c == 26) {
            this.f12888O000000o = 20;
            return null;
        } else if (O000000o(Feature.AllowUnQuotedFieldNames)) {
            return O00000Oo(bdv);
        } else {
            throw new JSONException("syntax error");
        }
    }

    public final String O000000o(bdv bdv, char c) {
        this.O0000Oo0 = this.O00000oO;
        this.O0000OOo = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = this.O00000oO + 1;
            this.O00000oO = i2;
            char O00000o02 = O00000o0(i2);
            if (O00000o02 == c) {
                this.f12888O000000o = 4;
                O0000OoO();
                if (!z) {
                    return O000000o(this.O0000Oo0 + 1, this.O0000OOo, i, bdv);
                }
                return bdv.O000000o(this.O0000O0o, this.O0000OOo, i);
            } else if (O00000o02 == 26) {
                throw new JSONException("unclosed.str");
            } else if (O00000o02 == '\\') {
                if (!z) {
                    int i3 = this.O0000OOo;
                    char[] cArr = this.O0000O0o;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        char[] cArr3 = this.O0000O0o;
                        System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        this.O0000O0o = cArr2;
                    }
                    O000000o(this.O0000Oo0 + 1, this.O0000O0o, this.O0000OOo);
                    z = true;
                }
                int i4 = this.O00000oO + 1;
                this.O00000oO = i4;
                char O00000o03 = O00000o0(i4);
                if (O00000o03 == '\"') {
                    i = (i * 31) + 34;
                    O000000o('\"');
                } else if (O00000o03 != '\'') {
                    if (O00000o03 != 'F') {
                        if (O00000o03 == '\\') {
                            i = (i * 31) + 92;
                            O000000o('\\');
                        } else if (O00000o03 == 'b') {
                            i = (i * 31) + 8;
                            O000000o(8);
                        } else if (O00000o03 != 'f') {
                            if (O00000o03 == 'n') {
                                i = (i * 31) + 10;
                                O000000o(10);
                            } else if (O00000o03 == 'r') {
                                i = (i * 31) + 13;
                                O000000o(13);
                            } else if (O00000o03 != 'x') {
                                switch (O00000o03) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        O000000o('/');
                                        continue;
                                    case '0':
                                        i = (i * 31) + O00000o03;
                                        O000000o(0);
                                        continue;
                                    case '1':
                                        i = (i * 31) + O00000o03;
                                        O000000o(1);
                                        continue;
                                    case '2':
                                        i = (i * 31) + O00000o03;
                                        O000000o(2);
                                        continue;
                                    case '3':
                                        i = (i * 31) + O00000o03;
                                        O000000o(3);
                                        continue;
                                    case '4':
                                        i = (i * 31) + O00000o03;
                                        O000000o(4);
                                        continue;
                                    case '5':
                                        i = (i * 31) + O00000o03;
                                        O000000o(5);
                                        continue;
                                    case '6':
                                        i = (i * 31) + O00000o03;
                                        O000000o(6);
                                        continue;
                                    case '7':
                                        i = (i * 31) + O00000o03;
                                        O000000o(7);
                                        continue;
                                    default:
                                        switch (O00000o03) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                O000000o(9);
                                                continue;
                                            case 'u':
                                                int i5 = this.O00000oO + 1;
                                                this.O00000oO = i5;
                                                char O00000o04 = O00000o0(i5);
                                                int i6 = this.O00000oO + 1;
                                                this.O00000oO = i6;
                                                char O00000o05 = O00000o0(i6);
                                                int i7 = this.O00000oO + 1;
                                                this.O00000oO = i7;
                                                char O00000o06 = O00000o0(i7);
                                                int i8 = this.O00000oO + 1;
                                                this.O00000oO = i8;
                                                int parseInt = Integer.parseInt(new String(new char[]{O00000o04, O00000o05, O00000o06, O00000o0(i8)}), 16);
                                                i = (i * 31) + parseInt;
                                                O000000o((char) parseInt);
                                                continue;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                O000000o(11);
                                                continue;
                                                continue;
                                            default:
                                                this.O00000o = O00000o03;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                int i9 = this.O00000oO + 1;
                                this.O00000oO = i9;
                                char O00000o07 = O00000o0(i9);
                                this.O00000o = O00000o07;
                                int i10 = this.O00000oO + 1;
                                this.O00000oO = i10;
                                char O00000o08 = O00000o0(i10);
                                this.O00000o = O00000o08;
                                int[] iArr = O0000o0O;
                                char c2 = (char) ((iArr[O00000o07] * 16) + iArr[O00000o08]);
                                i = (i * 31) + c2;
                                O000000o(c2);
                            }
                        }
                    }
                    i = (i * 31) + 12;
                    O000000o(12);
                } else {
                    i = (i * 31) + 39;
                    O000000o('\'');
                }
            } else {
                i = (i * 31) + O00000o02;
                if (!z) {
                    this.O0000OOo++;
                } else {
                    int i11 = this.O0000OOo;
                    char[] cArr4 = this.O0000O0o;
                    if (i11 == cArr4.length) {
                        O000000o(O00000o02);
                    } else {
                        this.O0000OOo = i11 + 1;
                        cArr4[i11] = O00000o02;
                    }
                }
            }
        }
    }

    public final void O0000Ooo() {
        this.O0000OOo = 0;
    }

    public final String O00000Oo(bdv bdv) {
        boolean[] zArr = bdn.O00000Oo;
        int i = this.O00000o;
        if (i >= zArr.length || zArr[i]) {
            boolean[] zArr2 = bdn.O00000o0;
            this.O0000Oo0 = this.O00000oO;
            this.O0000OOo = 1;
            while (true) {
                int i2 = this.O00000oO + 1;
                this.O00000oO = i2;
                char O00000o02 = O00000o0(i2);
                if (O00000o02 < zArr2.length && !zArr2[O00000o02]) {
                    break;
                }
                i = (i * 31) + O00000o02;
                this.O0000OOo++;
            }
            this.O00000o = O00000o0(this.O00000oO);
            this.f12888O000000o = 18;
            if (this.O0000OOo == 4 && i == 3392903 && O00000o0(this.O0000Oo0) == 'n' && O00000o0(this.O0000Oo0 + 1) == 'u' && O00000o0(this.O0000Oo0 + 2) == 'l' && O00000o0(this.O0000Oo0 + 3) == 'l') {
                return null;
            }
            return O000000o(this.O0000Oo0, this.O0000OOo, i, bdv);
        }
        throw new JSONException("illegal identifier : " + this.O00000o);
    }

    public final void O0000o00() {
        this.O0000Oo0 = this.O00000oO;
        this.O0000Oo = false;
        while (true) {
            int i = this.O00000oO + 1;
            this.O00000oO = i;
            char O00000o02 = O00000o0(i);
            if (O00000o02 == '\"') {
                this.f12888O000000o = 4;
                int i2 = this.O00000oO + 1;
                this.O00000oO = i2;
                this.O00000o = O00000o0(i2);
                return;
            } else if (O00000o02 == 26) {
                throw new JSONException("unclosed string : ".concat(String.valueOf(O00000o02)));
            } else if (O00000o02 == '\\') {
                if (!this.O0000Oo) {
                    this.O0000Oo = true;
                    int i3 = this.O0000OOo;
                    char[] cArr = this.O0000O0o;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        char[] cArr3 = this.O0000O0o;
                        System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        this.O0000O0o = cArr2;
                    }
                    O000000o(this.O0000Oo0 + 1, this.O0000OOo, this.O0000O0o);
                }
                int i4 = this.O00000oO + 1;
                this.O00000oO = i4;
                char O00000o03 = O00000o0(i4);
                if (O00000o03 == '\"') {
                    O000000o('\"');
                } else if (O00000o03 != '\'') {
                    if (O00000o03 != 'F') {
                        if (O00000o03 == '\\') {
                            O000000o('\\');
                        } else if (O00000o03 == 'b') {
                            O000000o(8);
                        } else if (O00000o03 != 'f') {
                            if (O00000o03 == 'n') {
                                O000000o(10);
                            } else if (O00000o03 == 'r') {
                                O000000o(13);
                            } else if (O00000o03 != 'x') {
                                switch (O00000o03) {
                                    case '/':
                                        O000000o('/');
                                        continue;
                                    case '0':
                                        O000000o(0);
                                        continue;
                                    case '1':
                                        O000000o(1);
                                        continue;
                                    case '2':
                                        O000000o(2);
                                        continue;
                                    case '3':
                                        O000000o(3);
                                        continue;
                                    case '4':
                                        O000000o(4);
                                        continue;
                                    case '5':
                                        O000000o(5);
                                        continue;
                                    case '6':
                                        O000000o(6);
                                        continue;
                                    case '7':
                                        O000000o(7);
                                        continue;
                                    default:
                                        switch (O00000o03) {
                                            case 't':
                                                O000000o(9);
                                                continue;
                                            case 'u':
                                                int i5 = this.O00000oO + 1;
                                                this.O00000oO = i5;
                                                char O00000o04 = O00000o0(i5);
                                                int i6 = this.O00000oO + 1;
                                                this.O00000oO = i6;
                                                char O00000o05 = O00000o0(i6);
                                                int i7 = this.O00000oO + 1;
                                                this.O00000oO = i7;
                                                char O00000o06 = O00000o0(i7);
                                                int i8 = this.O00000oO + 1;
                                                this.O00000oO = i8;
                                                O000000o((char) Integer.parseInt(new String(new char[]{O00000o04, O00000o05, O00000o06, O00000o0(i8)}), 16));
                                                continue;
                                            case 'v':
                                                O000000o(11);
                                                continue;
                                                continue;
                                            default:
                                                this.O00000o = O00000o03;
                                                throw new JSONException("unclosed string : ".concat(String.valueOf(O00000o03)));
                                        }
                                }
                            } else {
                                int i9 = this.O00000oO + 1;
                                this.O00000oO = i9;
                                char O00000o07 = O00000o0(i9);
                                int i10 = this.O00000oO + 1;
                                this.O00000oO = i10;
                                char O00000o08 = O00000o0(i10);
                                int[] iArr = O0000o0O;
                                O000000o((char) ((iArr[O00000o07] * 16) + iArr[O00000o08]));
                            }
                        }
                    }
                    O000000o(12);
                } else {
                    O000000o('\'');
                }
            } else if (!this.O0000Oo) {
                this.O0000OOo++;
            } else {
                int i11 = this.O0000OOo;
                char[] cArr4 = this.O0000O0o;
                if (i11 == cArr4.length) {
                    O000000o(O00000o02);
                } else {
                    this.O0000OOo = i11 + 1;
                    cArr4[i11] = O00000o02;
                }
            }
        }
    }

    public final Calendar O0000o0() {
        return this.O0000OoO;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    public final int O0000o0O() {
        int i;
        boolean z;
        int i2;
        int i3 = this.O0000Oo0;
        int i4 = this.O0000OOo + i3;
        int i5 = 0;
        if (O00000o0(i3) == '-') {
            i3++;
            z = true;
            i = Integer.MIN_VALUE;
        } else {
            z = false;
            i = -2147483647;
        }
        if (i3 < i4) {
            i2 = i3 + 1;
            i5 = -O0000o0O[O00000o0(i3)];
            i3 = i2;
        }
        if (i3 < i4) {
            i2 = i3 + 1;
            char O00000o02 = O00000o0(i3);
            if (O00000o02 == 'L' || O00000o02 == 'S' || O00000o02 == 'B') {
                i3 = i2;
            } else {
                int i6 = O0000o0O[O00000o02];
                if (i5 >= -214748364) {
                    int i7 = i5 * 10;
                    if (i7 >= i + i6) {
                        i5 = i7 - i6;
                        i3 = i2;
                        if (i3 < i4) {
                        }
                    }
                    throw new NumberFormatException(O0000OOo());
                }
                throw new NumberFormatException(O0000OOo());
            }
        }
        if (!z) {
            return -i5;
        }
        if (i3 > this.O0000Oo0 + 1) {
            return i5;
        }
        throw new NumberFormatException(O0000OOo());
    }

    public void close() {
        char[] cArr = this.O0000O0o;
        if (cArr.length <= 8192) {
            O0000o0o.set(new SoftReference(cArr));
        }
        this.O0000O0o = null;
    }

    public final boolean O0000o() {
        if (this.O0000OOo == 4 && O00000o0(this.O0000Oo0 + 1) == '$' && O00000o0(this.O0000Oo0 + 2) == 'r' && O00000o0(this.O0000Oo0 + 3) == 'e' && O00000o0(this.O0000Oo0 + 4) == 'f') {
            return true;
        }
        return false;
    }

    public final boolean O0000oO() {
        int i = 0;
        while (true) {
            char O00000o02 = O00000o0(i);
            if (O00000o02 == 26) {
                return true;
            }
            if (!O00000Oo(O00000o02)) {
                return false;
            }
            i++;
        }
    }

    public final void O0000oOO() {
        while (O0000o0[this.O00000o]) {
            O0000OoO();
        }
    }

    private void O000000o(char c) {
        int i = this.O0000OOo;
        char[] cArr = this.O0000O0o;
        if (i == cArr.length) {
            char[] cArr2 = new char[(cArr.length * 2)];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.O0000O0o = cArr2;
        }
        char[] cArr3 = this.O0000O0o;
        int i2 = this.O0000OOo;
        this.O0000OOo = i2 + 1;
        cArr3[i2] = c;
    }

    public final void O0000oOo() {
        this.O0000Oo0 = this.O00000oO;
        if (this.O00000o == '-') {
            this.O0000OOo++;
            O0000OoO();
        }
        while (true) {
            char c = this.O00000o;
            if (c < '0' || c > '9') {
                boolean z = false;
            } else {
                this.O0000OOo++;
                O0000OoO();
            }
        }
        boolean z2 = false;
        if (this.O00000o == '.') {
            this.O0000OOo++;
            O0000OoO();
            while (true) {
                char c2 = this.O00000o;
                if (c2 < '0' || c2 > '9') {
                    z2 = true;
                } else {
                    this.O0000OOo++;
                    O0000OoO();
                }
            }
            z2 = true;
        }
        char c3 = this.O00000o;
        if (c3 == 'L') {
            this.O0000OOo++;
            O0000OoO();
        } else if (c3 == 'S') {
            this.O0000OOo++;
            O0000OoO();
        } else if (c3 == 'B') {
            this.O0000OOo++;
            O0000OoO();
        } else {
            if (c3 == 'F') {
                this.O0000OOo++;
                O0000OoO();
            } else if (c3 == 'D') {
                this.O0000OOo++;
                O0000OoO();
            } else if (c3 == 'e' || c3 == 'E') {
                this.O0000OOo++;
                O0000OoO();
                char c4 = this.O00000o;
                if (c4 == '+' || c4 == '-') {
                    this.O0000OOo++;
                    O0000OoO();
                }
                while (true) {
                    char c5 = this.O00000o;
                    if (c5 < '0' || c5 > '9') {
                        char c6 = this.O00000o;
                    } else {
                        this.O0000OOo++;
                        O0000OoO();
                    }
                }
                char c62 = this.O00000o;
                if (c62 == 'D' || c62 == 'F') {
                    this.O0000OOo++;
                    O0000OoO();
                }
            }
            z2 = true;
        }
        if (z2) {
            this.f12888O000000o = 3;
        } else {
            this.f12888O000000o = 2;
        }
    }

    public final long O0000oo0() throws NumberFormatException {
        long j;
        boolean z;
        long j2;
        int i;
        int i2 = this.O0000Oo0;
        int i3 = this.O0000OOo + i2;
        if (O00000o0(i2) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i2 < i3) {
            j2 = (long) (-O0000o0O[O00000o0(i2)]);
            i2++;
        } else {
            j2 = 0;
        }
        while (true) {
            if (i2 >= i3) {
                break;
            }
            i = i2 + 1;
            char O00000o02 = O00000o0(i2);
            if (O00000o02 == 'L' || O00000o02 == 'S' || O00000o02 == 'B') {
                i2 = i;
            } else {
                int i4 = O0000o0O[O00000o02];
                if (j2 >= -922337203685477580L) {
                    long j3 = j2 * 10;
                    long j4 = (long) i4;
                    if (j3 >= j + j4) {
                        j2 = j3 - j4;
                        i2 = i;
                    } else {
                        throw new NumberFormatException(O0000OOo());
                    }
                } else {
                    throw new NumberFormatException(O0000OOo());
                }
            }
        }
        i2 = i;
        if (!z) {
            return -j2;
        }
        if (i2 > this.O0000Oo0 + 1) {
            return j2;
        }
        throw new NumberFormatException(O0000OOo());
    }

    public final Number O000000o(boolean z) {
        char O00000o02 = O00000o0((this.O0000Oo0 + this.O0000OOo) - 1);
        if (O00000o02 == 'F') {
            return Float.valueOf(Float.parseFloat(O0000OOo()));
        }
        if (O00000o02 == 'D') {
            return Double.valueOf(Double.parseDouble(O0000OOo()));
        }
        if (z) {
            return O0000oo();
        }
        return Double.valueOf(Double.parseDouble(O0000OOo()));
    }

    public final BigDecimal O0000oo() {
        return new BigDecimal(O0000OOo());
    }

    public final Number O0000ooO() {
        char O00000o02 = O00000o0((this.O0000Oo0 + this.O0000OOo) - 1);
        String O0000OOo2 = O0000OOo();
        if (O00000o02 == 'D') {
            return Double.valueOf(Double.parseDouble(O0000OOo2));
        }
        if (O00000o02 != 'F') {
            return new BigDecimal(O0000OOo2);
        }
        return Float.valueOf(Float.parseFloat(O0000OOo2));
    }
}

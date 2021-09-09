package org.json.alipay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f15442a;
    private Reader b;
    private char c;
    private boolean d;

    private c(Reader reader) {
        this.b = !reader.markSupported() ? new BufferedReader(reader) : reader;
        this.d = false;
        this.f15442a = 0;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    private String a(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.d) {
            this.d = false;
            cArr[0] = this.c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        this.f15442a += i2;
        if (i2 >= i) {
            this.c = cArr[i - 1];
            return new String(cArr);
        }
        throw a("Substring bounds error");
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i;
        if (this.d || (i = this.f15442a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f15442a = i - 1;
        this.d = true;
    }

    public final char b() {
        if (this.d) {
            this.d = false;
            if (this.c != 0) {
                this.f15442a++;
            }
            return this.c;
        }
        try {
            int read = this.b.read();
            if (read <= 0) {
                this.c = 0;
                return 0;
            }
            this.f15442a++;
            this.c = (char) read;
            return this.c;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public final char c() {
        char b2;
        char b3;
        char b4;
        while (true) {
            b2 = b();
            if (b2 == '/') {
                char b5 = b();
                if (b5 != '*') {
                    if (b5 == '/') {
                        do {
                            b4 = b();
                            if (b4 == 10 || b4 == 13) {
                                break;
                            }
                        } while (b4 != 0);
                    } else {
                        a();
                        return '/';
                    }
                } else {
                    while (true) {
                        char b6 = b();
                        if (b6 != 0) {
                            if (b6 == '*') {
                                if (b() == '/') {
                                    break;
                                }
                                a();
                            }
                        } else {
                            throw a("Unclosed comment");
                        }
                    }
                }
            } else if (b2 == '#') {
                do {
                    b3 = b();
                    if (b3 == 10 || b3 == 13) {
                        break;
                    }
                } while (b3 != 0);
            } else if (b2 == 0 || b2 > ' ') {
                return b2;
            }
        }
        return b2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:56|57|58) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:42|(2:51|52)(3:48|49|50))|53|54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bd, code lost:
        return new java.lang.Long(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c3, code lost:
        return new java.lang.Double(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00b8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00be */
    public final Object d() {
        String a2;
        char c2 = c();
        if (c2 != '\"') {
            if (c2 != '[') {
                if (c2 == '{') {
                    a();
                    return new b(this);
                } else if (c2 != '\'') {
                    if (c2 != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char c3 = c2;
                        while (c3 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c3) < 0) {
                            stringBuffer.append(c3);
                            c3 = b();
                        }
                        a();
                        String trim = stringBuffer.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        } else if (trim.equalsIgnoreCase("true")) {
                            return Boolean.TRUE;
                        } else {
                            if (trim.equalsIgnoreCase("false")) {
                                return Boolean.FALSE;
                            }
                            if (trim.equalsIgnoreCase("null")) {
                                return b.f15441a;
                            }
                            if ((c2 < '0' || c2 > '9') && c2 != '.' && c2 != '-' && c2 != '+') {
                                return trim;
                            }
                            if (c2 == '0') {
                                return (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) ? new Integer(Integer.parseInt(trim, 8)) : new Integer(Integer.parseInt(trim.substring(2), 16));
                            }
                            return new Integer(trim);
                        }
                    }
                }
            }
            a();
            return new a(this);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char b2 = b();
            if (b2 != 0 && b2 != 10 && b2 != 13) {
                if (b2 == '\\') {
                    b2 = b();
                    if (b2 == 'b') {
                        stringBuffer2.append(8);
                    } else if (b2 == 'f') {
                        b2 = 12;
                    } else if (b2 == 'n') {
                        stringBuffer2.append(10);
                    } else if (b2 != 'r') {
                        if (b2 == 'x') {
                            a2 = a(2);
                        } else if (b2 == 't') {
                            b2 = 9;
                        } else if (b2 == 'u') {
                            a2 = a(4);
                        }
                        b2 = (char) Integer.parseInt(a2, 16);
                    } else {
                        stringBuffer2.append(13);
                    }
                } else if (b2 == c2) {
                    return stringBuffer2.toString();
                }
                stringBuffer2.append(b2);
            }
        }
        throw a("Unterminated string");
    }

    public final String toString() {
        return " at character " + this.f15442a;
    }
}

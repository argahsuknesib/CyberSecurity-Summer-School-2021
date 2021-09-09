package com.ta.utdid2.a.a;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f5796a = (!b.class.desiredAssertionStatus());

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public int f5797a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f0a;

        a() {
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        C0045b bVar = new C0045b(i3, new byte[((i2 * 3) / 4)]);
        if (!bVar.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.f5797a == bVar.f0a.length) {
            return bVar.f0a;
        } else {
            byte[] bArr2 = new byte[bVar.f5797a];
            System.arraycopy(bVar.f0a, 0, bArr2, 0, bVar.f5797a);
            return bArr2;
        }
    }

    /* renamed from: com.ta.utdid2.a.a.b$b  reason: collision with other inner class name */
    static class C0045b extends a {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f5798a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private final int[] c;
        private int state;
        private int value;

        public C0045b(int i, byte[] bArr) {
            this.f0a = bArr;
            this.c = (i & 8) == 0 ? f5798a : b;
            this.state = 0;
            this.value = 0;
        }

        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.state;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.value;
            byte[] bArr2 = this.f0a;
            int[] iArr = this.c;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4) {
                            break;
                        }
                        i6 = iArr[bArr[i9 + 3] & 255] | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 2] & 255] << 6);
                        if (i6 < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 != 2) {
                            if (i8 != 3) {
                                if (i8 == 4) {
                                    if (i12 != -2) {
                                        if (i12 != -1) {
                                            this.state = 6;
                                            return false;
                                        }
                                    }
                                    i8++;
                                } else if (i8 == 5 && i12 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i12 >= 0) {
                                i6 = (i6 << 6) | i12;
                                bArr2[i7 + 2] = (byte) i6;
                                bArr2[i7 + 1] = (byte) (i6 >> 8);
                                bArr2[i7] = (byte) (i6 >> 16);
                                i7 += 3;
                                i9 = i11;
                                i8 = 0;
                            } else if (i12 == -2) {
                                bArr2[i7 + 1] = (byte) (i6 >> 2);
                                bArr2[i7] = (byte) (i6 >> 10);
                                i7 += 2;
                                i9 = i11;
                                i8 = 5;
                            } else if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i7] = (byte) (i6 >> 4);
                                i7++;
                                i9 = i11;
                                i8 = 4;
                            } else if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                    } else if (i12 < 0) {
                        if (i12 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i6 = (i6 << 6) | i12;
                    i8++;
                } else if (i12 >= 0) {
                    i8++;
                    i6 = i12;
                } else if (i12 != -1) {
                    this.state = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.state = i8;
                this.value = i6;
                this.f5797a = i7;
                return true;
            }
            if (i8 != 0) {
                if (i8 == 1) {
                    this.state = 6;
                    return false;
                } else if (i8 == 2) {
                    bArr2[i7] = (byte) (i6 >> 4);
                    i7++;
                } else if (i8 == 3) {
                    int i13 = i7 + 1;
                    bArr2[i7] = (byte) (i6 >> 10);
                    i7 = i13 + 1;
                    bArr2[i13] = (byte) (i6 >> 2);
                } else if (i8 == 4) {
                    this.state = 6;
                    return false;
                }
            }
            this.state = i8;
            this.f5797a = i7;
            return true;
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!cVar.f2b) {
            int i6 = i2 % 3;
            if (i6 != 0) {
                if (i6 == 1) {
                    i4 += 2;
                } else if (i6 == 2) {
                    i4 += 3;
                }
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (cVar.f3c && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!cVar.d) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        cVar.f0a = new byte[i4];
        cVar.a(bArr, i, i2, true);
        if (f5796a || cVar.f5797a == i4) {
            return cVar.f0a;
        }
        throw new AssertionError();
    }

    static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f5799a = (!b.class.desiredAssertionStatus());
        private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: b  reason: collision with other field name */
        int f1b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f2b;

        /* renamed from: c  reason: collision with other field name */
        public final boolean f3c;
        private int count;
        public final boolean d;

        /* renamed from: d  reason: collision with other field name */
        private final byte[] f4d;
        private final byte[] e;

        public c(int i, byte[] bArr) {
            this.f0a = bArr;
            boolean z = true;
            this.f2b = (i & 1) == 0;
            this.f3c = (i & 2) == 0;
            this.d = (i & 4) == 0 ? false : z;
            this.e = (i & 8) == 0 ? b : c;
            this.f4d = new byte[2];
            this.f1b = 0;
            this.count = this.f3c ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01e1  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x00e9 A[SYNTHETIC] */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.e
                byte[] r2 = r0.f0a
                int r3 = r0.count
                int r4 = r20 + r19
                int r5 = r0.f1b
                r6 = -1
                r7 = 2
                r8 = 0
                r9 = 1
                if (r5 == 0) goto L_0x0053
                if (r5 == r9) goto L_0x0034
                if (r5 == r7) goto L_0x0017
                goto L_0x0053
            L_0x0017:
                int r5 = r19 + 1
                if (r5 > r4) goto L_0x0053
                byte[] r10 = r0.f4d
                byte r11 = r10[r8]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.f1b = r8
                r11 = r5
                r5 = r10
                goto L_0x0056
            L_0x0034:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0053
                byte[] r5 = r0.f4d
                byte r5 = r5[r8]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r5 = r5 | r10
                r0.f1b = r8
                goto L_0x0056
            L_0x0053:
                r11 = r19
                r5 = -1
            L_0x0056:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r5 == r6) goto L_0x0092
                int r6 = r5 >> 18
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r8] = r6
                int r6 = r5 >> 12
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r5 >> 6
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r7] = r6
                r5 = r5 & 63
                byte r5 = r1[r5]
                r6 = 3
                r2[r6] = r5
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x0090
                boolean r3 = r0.d
                if (r3 == 0) goto L_0x0088
                r3 = 5
                r2[r12] = r13
                goto L_0x0089
            L_0x0088:
                r3 = 4
            L_0x0089:
                int r5 = r3 + 1
                r2[r3] = r14
            L_0x008d:
                r3 = 19
                goto L_0x0093
            L_0x0090:
                r5 = 4
                goto L_0x0093
            L_0x0092:
                r5 = 0
            L_0x0093:
                int r6 = r11 + 3
                if (r6 > r4) goto L_0x00e9
                byte r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                byte r10 = r18[r16]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r15
                int r11 = r11 + 2
                byte r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                int r11 = r10 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r5] = r11
                int r11 = r5 + 1
                int r15 = r10 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r5 + 2
                int r15 = r10 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r5 + 3
                r10 = r10 & 63
                byte r10 = r1[r10]
                r2[r11] = r10
                int r5 = r5 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e7
                boolean r3 = r0.d
                if (r3 == 0) goto L_0x00e0
                int r3 = r5 + 1
                r2[r5] = r13
                goto L_0x00e1
            L_0x00e0:
                r3 = r5
            L_0x00e1:
                int r5 = r3 + 1
                r2[r3] = r14
                r11 = r6
                goto L_0x008d
            L_0x00e7:
                r11 = r6
                goto L_0x0093
            L_0x00e9:
                if (r21 == 0) goto L_0x01e1
                int r6 = r0.f1b
                int r10 = r11 - r6
                int r15 = r4 + -1
                if (r10 != r15) goto L_0x013d
                if (r6 <= 0) goto L_0x00fb
                byte[] r6 = r0.f4d
                byte r6 = r6[r8]
                r8 = 1
                goto L_0x0101
            L_0x00fb:
                int r6 = r11 + 1
                byte r7 = r18[r11]
                r11 = r6
                r6 = r7
            L_0x0101:
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << r12
                int r7 = r0.f1b
                int r7 = r7 - r8
                r0.f1b = r7
                int r7 = r5 + 1
                int r8 = r6 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r5] = r8
                int r5 = r7 + 1
                r6 = r6 & 63
                byte r1 = r1[r6]
                r2[r7] = r1
                boolean r1 = r0.f2b
                if (r1 == 0) goto L_0x0129
                int r1 = r5 + 1
                r6 = 61
                r2[r5] = r6
                int r5 = r1 + 1
                r2[r1] = r6
            L_0x0129:
                boolean r1 = r0.f3c
                if (r1 == 0) goto L_0x01c5
                boolean r1 = r0.d
                if (r1 == 0) goto L_0x0136
                int r1 = r5 + 1
                r2[r5] = r13
                goto L_0x0137
            L_0x0136:
                r1 = r5
            L_0x0137:
                int r5 = r1 + 1
                r2[r1] = r14
                goto L_0x01c5
            L_0x013d:
                int r10 = r11 - r6
                int r12 = r4 + -2
                if (r10 != r12) goto L_0x01ad
                if (r6 <= r9) goto L_0x014b
                byte[] r6 = r0.f4d
                byte r6 = r6[r8]
                r8 = 1
                goto L_0x0151
            L_0x014b:
                int r6 = r11 + 1
                byte r10 = r18[r11]
                r11 = r6
                r6 = r10
            L_0x0151:
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << r14
                int r10 = r0.f1b
                if (r10 <= 0) goto L_0x0161
                byte[] r10 = r0.f4d
                int r12 = r8 + 1
                byte r8 = r10[r8]
                r10 = r11
                r11 = r8
                goto L_0x0166
            L_0x0161:
                int r10 = r11 + 1
                byte r11 = r18[r11]
                r12 = r8
            L_0x0166:
                r8 = r11 & 255(0xff, float:3.57E-43)
                int r7 = r8 << 2
                r6 = r6 | r7
                int r7 = r0.f1b
                int r7 = r7 - r12
                r0.f1b = r7
                int r7 = r5 + 1
                int r8 = r6 >> 12
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r5] = r8
                int r5 = r7 + 1
                int r8 = r6 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r7] = r8
                int r7 = r5 + 1
                r6 = r6 & 63
                byte r1 = r1[r6]
                r2[r5] = r1
                boolean r1 = r0.f2b
                if (r1 == 0) goto L_0x0197
                int r1 = r7 + 1
                r5 = 61
                r2[r7] = r5
                goto L_0x0198
            L_0x0197:
                r1 = r7
            L_0x0198:
                boolean r5 = r0.f3c
                if (r5 == 0) goto L_0x01aa
                boolean r5 = r0.d
                if (r5 == 0) goto L_0x01a5
                int r5 = r1 + 1
                r2[r1] = r13
                r1 = r5
            L_0x01a5:
                int r5 = r1 + 1
                r2[r1] = r14
                r1 = r5
            L_0x01aa:
                r5 = r1
                r11 = r10
                goto L_0x01c5
            L_0x01ad:
                boolean r1 = r0.f3c
                if (r1 == 0) goto L_0x01c5
                if (r5 <= 0) goto L_0x01c5
                r1 = 19
                if (r3 == r1) goto L_0x01c5
                boolean r1 = r0.d
                if (r1 == 0) goto L_0x01c0
                int r1 = r5 + 1
                r2[r5] = r13
                goto L_0x01c1
            L_0x01c0:
                r1 = r5
            L_0x01c1:
                int r5 = r1 + 1
                r2[r1] = r14
            L_0x01c5:
                boolean r1 = com.ta.utdid2.a.a.b.c.f5799a
                if (r1 != 0) goto L_0x01d4
                int r1 = r0.f1b
                if (r1 != 0) goto L_0x01ce
                goto L_0x01d4
            L_0x01ce:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01d4:
                boolean r1 = com.ta.utdid2.a.a.b.c.f5799a
                if (r1 != 0) goto L_0x020c
                if (r11 != r4) goto L_0x01db
                goto L_0x020c
            L_0x01db:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01e1:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01f2
                byte[] r1 = r0.f4d
                int r2 = r0.f1b
                int r4 = r2 + 1
                r0.f1b = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x020c
            L_0x01f2:
                int r4 = r4 - r7
                if (r11 != r4) goto L_0x020c
                byte[] r1 = r0.f4d
                int r2 = r0.f1b
                int r4 = r2 + 1
                r0.f1b = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                int r2 = r0.f1b
                int r4 = r2 + 1
                r0.f1b = r4
                int r11 = r11 + r9
                byte r4 = r18[r11]
                r1[r2] = r4
            L_0x020c:
                r0.f5797a = r5
                r0.count = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.b.c.a(byte[], int, int, boolean):boolean");
        }
    }

    private b() {
    }
}

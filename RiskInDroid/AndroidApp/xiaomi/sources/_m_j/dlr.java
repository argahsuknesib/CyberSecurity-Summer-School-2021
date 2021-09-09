package _m_j;

public class dlr {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f14774O000000o = (!dlr.class.desiredAssertionStatus());

    private dlr() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0101, code lost:
        if (r8 == 0) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0103, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0104, code lost:
        if (r8 == 1) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0106, code lost:
        if (r8 == 2) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0108, code lost:
        if (r8 == 3) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010a, code lost:
        if (r8 == 4) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010d, code lost:
        r1 = r13 + 1;
        r9[r13] = (byte) (r12 >> 10);
        r13 = r1 + 1;
        r9[r1] = (byte) (r12 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011c, code lost:
        r9[r13] = (byte) (r12 >> 4);
        r13 = r13 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0129, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012a, code lost:
        r2.O00000o0 = r8;
        r2.O00000Oo = r13;
     */
    public static byte[] O000000o(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        dlt dlt = new dlt(0, new byte[((length * 3) / 4)]);
        int i = 1;
        if (dlt.O00000o0 != 6) {
            int i2 = length + 0;
            int i3 = dlt.O00000o0;
            int i4 = dlt.O00000o;
            byte[] bArr3 = dlt.f14775O000000o;
            int[] iArr = dlt.O00000oO;
            int i5 = i4;
            int i6 = 0;
            int i7 = i3;
            int i8 = 0;
            while (true) {
                if (i8 >= i2) {
                    break;
                }
                if (i7 == 0) {
                    while (true) {
                        int i9 = i8 + 4;
                        if (i9 > i2) {
                            break;
                        }
                        i5 = iArr[bArr2[i8 + 3] & 255] | (iArr[bArr2[i8 + 1] & 255] << 12) | (iArr[bArr2[i8] & 255] << 18) | (iArr[bArr2[i8 + 2] & 255] << 6);
                        if (i5 < 0) {
                            break;
                        }
                        bArr3[i6 + 2] = (byte) i5;
                        bArr3[i6 + 1] = (byte) (i5 >> 8);
                        bArr3[i6] = (byte) (i5 >> 16);
                        i6 += 3;
                        i8 = i9;
                    }
                    if (i8 >= i2) {
                        break;
                    }
                }
                int i10 = i8 + 1;
                int i11 = iArr[bArr2[i8] & 255];
                if (i7 == 0) {
                    if (i11 < 0) {
                        if (i11 != -1) {
                            break;
                        }
                    } else {
                        i7++;
                        i5 = i11;
                    }
                } else {
                    if (i7 == i) {
                        if (i11 < 0) {
                            if (i11 != -1) {
                                break;
                            }
                        }
                    } else if (i7 == 2) {
                        if (i11 < 0) {
                            if (i11 != -2) {
                                if (i11 != -1) {
                                    break;
                                }
                            } else {
                                bArr3[i6] = (byte) (i5 >> 4);
                                i6++;
                                i8 = i10;
                                i = 1;
                                i7 = 4;
                            }
                        }
                    } else if (i7 == 3) {
                        if (i11 < 0) {
                            if (i11 != -2) {
                                if (i11 != -1) {
                                    break;
                                }
                            } else {
                                bArr3[i6 + 1] = (byte) (i5 >> 2);
                                bArr3[i6] = (byte) (i5 >> 10);
                                i6 += 2;
                                i8 = i10;
                                i = 1;
                                i7 = 5;
                            }
                        } else {
                            i5 = (i5 << 6) | i11;
                            bArr3[i6 + 2] = (byte) i5;
                            bArr3[i6 + 1] = (byte) (i5 >> 8);
                            bArr3[i6] = (byte) (i5 >> 16);
                            i6 += 3;
                            i8 = i10;
                            i = 1;
                            i7 = 0;
                        }
                    } else if (i7 != 4) {
                        if (i7 == 5 && i11 != -1) {
                            break;
                        }
                    } else {
                        if (i11 != -2) {
                            if (i11 != -1) {
                                break;
                            }
                        }
                        i7++;
                    }
                    i5 = (i5 << 6) | i11;
                    i7++;
                }
                i8 = i10;
                i = 1;
            }
            dlt.O00000o0 = 6;
        }
        boolean z = false;
        if (!z) {
            throw new IllegalArgumentException("bad base-64");
        } else if (dlt.O00000Oo == dlt.f14775O000000o.length) {
            return dlt.f14775O000000o;
        } else {
            byte[] bArr4 = new byte[dlt.O00000Oo];
            System.arraycopy(dlt.f14775O000000o, 0, bArr4, 0, dlt.O00000Oo);
            return bArr4;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0215 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x011f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0176  */
    public static byte[] O00000Oo(byte[] r18) {
        /*
            r0 = r18
            int r1 = r0.length
            _m_j.dlu r2 = new _m_j.dlu
            r3 = 0
            r2.<init>(r3)
            int r4 = r1 / 3
            r5 = 4
            int r4 = r4 * 4
            boolean r6 = r2.O00000oo
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L_0x001b
            int r6 = r1 % 3
            if (r6 <= 0) goto L_0x0029
            int r4 = r4 + 4
            goto L_0x0029
        L_0x001b:
            int r6 = r1 % 3
            if (r6 == 0) goto L_0x0029
            if (r6 == r8) goto L_0x0027
            if (r6 == r7) goto L_0x0024
            goto L_0x0029
        L_0x0024:
            int r4 = r4 + 3
            goto L_0x0029
        L_0x0027:
            int r4 = r4 + 2
        L_0x0029:
            boolean r6 = r2.O0000O0o
            if (r6 == 0) goto L_0x003e
            if (r1 <= 0) goto L_0x003e
            int r6 = r1 + -1
            int r6 = r6 / 57
            int r6 = r6 + r8
            boolean r9 = r2.O0000OOo
            if (r9 == 0) goto L_0x003a
            r9 = 2
            goto L_0x003b
        L_0x003a:
            r9 = 1
        L_0x003b:
            int r6 = r6 * r9
            int r4 = r4 + r6
        L_0x003e:
            byte[] r6 = new byte[r4]
            r2.f14775O000000o = r6
            byte[] r6 = r2.O0000Oo0
            byte[] r9 = r2.f14775O000000o
            int r10 = r2.O00000oO
            int r1 = r1 + r3
            int r11 = r2.O00000o
            r12 = -1
            if (r11 == 0) goto L_0x0089
            if (r11 == r8) goto L_0x006f
            if (r11 == r7) goto L_0x0053
            goto L_0x0089
        L_0x0053:
            if (r1 <= 0) goto L_0x0089
            byte[] r11 = r2.O00000o0
            byte r11 = r11[r3]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            byte[] r13 = r2.O00000o0
            byte r13 = r13[r8]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 8
            r11 = r11 | r13
            byte r13 = r0[r3]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r2.O00000o = r3
            r13 = 1
            goto L_0x008b
        L_0x006f:
            if (r7 > r1) goto L_0x0089
            byte[] r11 = r2.O00000o0
            byte r11 = r11[r3]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            byte r13 = r0[r3]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 8
            r11 = r11 | r13
            byte r13 = r0[r8]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r2.O00000o = r3
            r13 = 2
            goto L_0x008b
        L_0x0089:
            r11 = -1
            r13 = 0
        L_0x008b:
            r15 = 13
            r16 = 10
            if (r11 == r12) goto L_0x00c6
            int r12 = r11 >> 18
            r12 = r12 & 63
            byte r12 = r6[r12]
            r9[r3] = r12
            int r12 = r11 >> 12
            r12 = r12 & 63
            byte r12 = r6[r12]
            r9[r8] = r12
            int r12 = r11 >> 6
            r12 = r12 & 63
            byte r12 = r6[r12]
            r9[r7] = r12
            r11 = r11 & 63
            byte r11 = r6[r11]
            r12 = 3
            r9[r12] = r11
            int r10 = r10 + -1
            if (r10 != 0) goto L_0x00c4
            boolean r10 = r2.O0000OOo
            if (r10 == 0) goto L_0x00bc
            r10 = 5
            r9[r5] = r15
            goto L_0x00bd
        L_0x00bc:
            r10 = 4
        L_0x00bd:
            int r11 = r10 + 1
            r9[r10] = r16
        L_0x00c1:
            r10 = 19
            goto L_0x00c7
        L_0x00c4:
            r11 = 4
            goto L_0x00c7
        L_0x00c6:
            r11 = 0
        L_0x00c7:
            int r12 = r13 + 3
            if (r12 > r1) goto L_0x011f
            byte r14 = r0[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << 16
            int r17 = r13 + 1
            byte r7 = r0[r17]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            r7 = r7 | r14
            int r13 = r13 + 2
            byte r13 = r0[r13]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r7 = r7 | r13
            int r13 = r7 >> 18
            r13 = r13 & 63
            byte r13 = r6[r13]
            r9[r11] = r13
            int r13 = r11 + 1
            int r14 = r7 >> 12
            r14 = r14 & 63
            byte r14 = r6[r14]
            r9[r13] = r14
            int r13 = r11 + 2
            int r14 = r7 >> 6
            r14 = r14 & 63
            byte r14 = r6[r14]
            r9[r13] = r14
            int r13 = r11 + 3
            r7 = r7 & 63
            byte r7 = r6[r7]
            r9[r13] = r7
            int r11 = r11 + 4
            int r10 = r10 + -1
            if (r10 != 0) goto L_0x011c
            boolean r7 = r2.O0000OOo
            if (r7 == 0) goto L_0x0114
            int r7 = r11 + 1
            r9[r11] = r15
            goto L_0x0115
        L_0x0114:
            r7 = r11
        L_0x0115:
            int r11 = r7 + 1
            r9[r7] = r16
            r13 = r12
            r7 = 2
            goto L_0x00c1
        L_0x011c:
            r13 = r12
            r7 = 2
            goto L_0x00c7
        L_0x011f:
            int r7 = r2.O00000o
            int r7 = r13 - r7
            int r12 = r1 + -1
            if (r7 != r12) goto L_0x0176
            int r7 = r2.O00000o
            if (r7 <= 0) goto L_0x0131
            byte[] r0 = r2.O00000o0
            byte r0 = r0[r3]
            r3 = 1
            goto L_0x0136
        L_0x0131:
            int r7 = r13 + 1
            byte r0 = r0[r13]
            r13 = r7
        L_0x0136:
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r5
            int r5 = r2.O00000o
            int r5 = r5 - r3
            r2.O00000o = r5
            int r3 = r11 + 1
            int r5 = r0 >> 6
            r5 = r5 & 63
            byte r5 = r6[r5]
            r9[r11] = r5
            int r5 = r3 + 1
            r0 = r0 & 63
            byte r0 = r6[r0]
            r9[r3] = r0
            boolean r0 = r2.O00000oo
            if (r0 == 0) goto L_0x015e
            int r0 = r5 + 1
            r3 = 61
            r9[r5] = r3
            int r5 = r0 + 1
            r9[r0] = r3
        L_0x015e:
            boolean r0 = r2.O0000O0o
            if (r0 == 0) goto L_0x0173
            boolean r0 = r2.O0000OOo
            if (r0 == 0) goto L_0x016b
            int r0 = r5 + 1
            r9[r5] = r15
            goto L_0x016c
        L_0x016b:
            r0 = r5
        L_0x016c:
            int r3 = r0 + 1
            r9[r0] = r16
        L_0x0170:
            r11 = r3
            goto L_0x0202
        L_0x0173:
            r11 = r5
            goto L_0x0202
        L_0x0176:
            int r5 = r2.O00000o
            int r5 = r13 - r5
            int r7 = r1 + -2
            if (r5 != r7) goto L_0x01ea
            int r5 = r2.O00000o
            if (r5 <= r8) goto L_0x0188
            byte[] r5 = r2.O00000o0
            byte r3 = r5[r3]
            r5 = r13
            goto L_0x018e
        L_0x0188:
            int r5 = r13 + 1
            byte r7 = r0[r13]
            r3 = r7
            r8 = 0
        L_0x018e:
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 10
            int r7 = r2.O00000o
            if (r7 <= 0) goto L_0x019e
            byte[] r0 = r2.O00000o0
            int r7 = r8 + 1
            byte r0 = r0[r8]
            r13 = r5
            goto L_0x01a4
        L_0x019e:
            int r7 = r5 + 1
            byte r0 = r0[r5]
            r13 = r7
            r7 = r8
        L_0x01a4:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r5 = 2
            int r0 = r0 << r5
            r0 = r0 | r3
            int r3 = r2.O00000o
            int r3 = r3 - r7
            r2.O00000o = r3
            int r3 = r11 + 1
            int r5 = r0 >> 12
            r5 = r5 & 63
            byte r5 = r6[r5]
            r9[r11] = r5
            int r5 = r3 + 1
            int r7 = r0 >> 6
            r7 = r7 & 63
            byte r7 = r6[r7]
            r9[r3] = r7
            int r3 = r5 + 1
            r0 = r0 & 63
            byte r0 = r6[r0]
            r9[r5] = r0
            boolean r0 = r2.O00000oo
            if (r0 == 0) goto L_0x01d5
            int r0 = r3 + 1
            r5 = 61
            r9[r3] = r5
            goto L_0x01d6
        L_0x01d5:
            r0 = r3
        L_0x01d6:
            boolean r3 = r2.O0000O0o
            if (r3 == 0) goto L_0x01e8
            boolean r3 = r2.O0000OOo
            if (r3 == 0) goto L_0x01e3
            int r3 = r0 + 1
            r9[r0] = r15
            r0 = r3
        L_0x01e3:
            int r3 = r0 + 1
            r9[r0] = r16
            goto L_0x0170
        L_0x01e8:
            r11 = r0
            goto L_0x0202
        L_0x01ea:
            boolean r0 = r2.O0000O0o
            if (r0 == 0) goto L_0x0202
            if (r11 <= 0) goto L_0x0202
            r0 = 19
            if (r10 == r0) goto L_0x0202
            boolean r0 = r2.O0000OOo
            if (r0 == 0) goto L_0x01fd
            int r0 = r11 + 1
            r9[r11] = r15
            goto L_0x01fe
        L_0x01fd:
            r0 = r11
        L_0x01fe:
            int r11 = r0 + 1
            r9[r0] = r16
        L_0x0202:
            boolean r0 = _m_j.dlu.O0000Oo
            if (r0 != 0) goto L_0x0211
            int r0 = r2.O00000o
            if (r0 != 0) goto L_0x020b
            goto L_0x0211
        L_0x020b:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0211:
            boolean r0 = _m_j.dlu.O0000Oo
            if (r0 != 0) goto L_0x021e
            if (r13 != r1) goto L_0x0218
            goto L_0x021e
        L_0x0218:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x021e:
            r2.O00000Oo = r11
            r2.O00000oO = r10
            boolean r0 = _m_j.dlr.f14774O000000o
            if (r0 != 0) goto L_0x0231
            int r0 = r2.O00000Oo
            if (r0 != r4) goto L_0x022b
            goto L_0x0231
        L_0x022b:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0231:
            byte[] r0 = r2.f14775O000000o
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.dlr.O00000Oo(byte[]):byte[]");
    }
}

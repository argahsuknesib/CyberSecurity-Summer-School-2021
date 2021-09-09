package _m_j;

import java.util.Arrays;

public final class axt {

    /* renamed from: O000000o  reason: collision with root package name */
    public long[] f12689O000000o;
    int[] O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo = -1;
    axr O0000O0o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axt.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      _m_j.axt.O000000o(int, int):void
      _m_j.axt.O000000o(_m_j.axr, boolean):void
      _m_j.axt.O000000o(int, boolean):void */
    public final void O000000o(axr axr, boolean z) {
        int groupCount = axr.getGroupCount();
        O000000o(groupCount, false);
        long[] jArr = this.f12689O000000o;
        int[] iArr = this.O00000Oo;
        int i = 0;
        for (int i2 = 0; i2 < groupCount; i2++) {
            long groupId = axr.getGroupId(i2);
            int childCount = axr.getChildCount(i2);
            if (z) {
                jArr[i2] = (((long) (i2 + i)) << 32) | ((long) childCount) | 2147483648L;
            } else {
                jArr[i2] = (((long) i2) << 32) | ((long) childCount);
            }
            iArr[i2] = (int) (groupId & 4294967295L);
            i += childCount;
        }
        this.O0000O0o = axr;
        this.O00000o0 = groupCount;
        this.O00000o = z ? groupCount : 0;
        if (!z) {
            i = 0;
        }
        this.O00000oO = i;
        this.O00000oo = Math.max(0, groupCount - 1);
    }

    public final void O000000o(int[] iArr) {
        if (iArr != null && iArr.length != 0 && this.f12689O000000o != null) {
            long[] jArr = new long[this.O00000o0];
            int i = 0;
            for (int i2 = 0; i2 < this.O00000o0; i2++) {
                jArr[i2] = (((long) this.O00000Oo[i2]) << 32) | ((long) i2);
            }
            Arrays.sort(jArr);
            int i3 = 0;
            while (i < iArr.length) {
                int i4 = iArr[i];
                int i5 = i3;
                while (i3 < jArr.length) {
                    int i6 = (int) (jArr[i3] >> 32);
                    int i7 = (int) (jArr[i3] & 2147483647L);
                    if (i6 >= i4) {
                        if (i6 != i4) {
                            break;
                        }
                        i5 = i3 + 1;
                        O00000oO(i7);
                    } else {
                        O00000o(i7);
                        i5 = i3;
                    }
                    i3++;
                }
                i++;
                i3 = i5;
            }
        }
    }

    public final int O000000o() {
        return this.O00000o0 + this.O00000oO;
    }

    public final boolean O000000o(int i) {
        return (this.f12689O000000o[i] & 2147483648L) != 0;
    }

    public final int O00000Oo(int i) {
        return (int) (this.f12689O000000o[i] & 2147483647L);
    }

    public final int O00000o0(int i) {
        if (O000000o(i)) {
            return O00000Oo(i);
        }
        return 0;
    }

    public final boolean O00000o(int i) {
        long[] jArr = this.f12689O000000o;
        if ((jArr[i] & 2147483648L) == 0) {
            return false;
        }
        jArr[i] = jArr[i] & -2147483649L;
        this.O00000o--;
        this.O00000oO -= (int) (jArr[i] & 2147483647L);
        this.O00000oo = Math.min(this.O00000oo, i);
        return true;
    }

    public final boolean O00000oO(int i) {
        long[] jArr = this.f12689O000000o;
        if ((jArr[i] & 2147483648L) != 0) {
            return false;
        }
        jArr[i] = 2147483648L | jArr[i];
        this.O00000o++;
        this.O00000oO += (int) (jArr[i] & 2147483647L);
        this.O00000oo = Math.min(this.O00000oo, i);
        return true;
    }

    public final void O000000o(int i, int i2) {
        if (i != i2) {
            long j = this.f12689O000000o[i];
            int i3 = this.O00000Oo[i];
            if (i2 < i) {
                for (int i4 = i; i4 > i2; i4--) {
                    long[] jArr = this.f12689O000000o;
                    int i5 = i4 - 1;
                    jArr[i4] = jArr[i5];
                    int[] iArr = this.O00000Oo;
                    iArr[i4] = iArr[i5];
                }
            } else {
                int i6 = i;
                while (i6 < i2) {
                    long[] jArr2 = this.f12689O000000o;
                    int i7 = i6 + 1;
                    jArr2[i6] = jArr2[i7];
                    int[] iArr2 = this.O00000Oo;
                    iArr2[i6] = iArr2[i7];
                    i6 = i7;
                }
            }
            this.f12689O000000o[i2] = j;
            this.O00000Oo[i2] = i3;
            int min = Math.min(i, i2);
            if (min > 0) {
                this.O00000oo = Math.min(this.O00000oo, min - 1);
            } else {
                this.O00000oo = -1;
            }
        }
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        if (i != i3) {
            long[] jArr = this.f12689O000000o;
            int i5 = (int) (jArr[i] & 2147483647L);
            int i6 = (int) (2147483647L & jArr[i3]);
            if (i5 != 0) {
                jArr[i] = (jArr[i] & -2147483648L) | ((long) (i5 - 1));
                jArr[i3] = (jArr[i3] & -2147483648L) | ((long) (i6 + 1));
                if ((jArr[i] & 2147483648L) != 0) {
                    this.O00000oO--;
                }
                if ((this.f12689O000000o[i3] & 2147483648L) != 0) {
                    this.O00000oO++;
                }
                int min = Math.min(i, i3);
                if (min > 0) {
                    this.O00000oo = Math.min(this.O00000oo, min - 1);
                } else {
                    this.O00000oo = -1;
                }
            } else {
                throw new IllegalStateException("moveChildItem(fromGroupPosition = " + i + ", fromChildPosition = " + i2 + ", toGroupPosition = " + i3 + ", toChildPosition = " + i4 + ")  --- may be a bug.");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085 A[SYNTHETIC] */
    public final long O00000oo(int i) {
        int i2;
        int i3;
        long j = -1;
        if (i == -1) {
            return -1;
        }
        int i4 = this.O00000o0;
        long[] jArr = this.f12689O000000o;
        int i5 = this.O00000oo;
        int i6 = 0;
        if (i5 > 0) {
            int i7 = (int) (jArr[0] >>> 32);
            int i8 = (int) (jArr[i5] >>> 32);
            if (i > i7) {
                if (i < i8) {
                    int i9 = i5;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < i9) {
                        int i12 = (i10 + i9) >>> 1;
                        if (((int) (jArr[i12] >>> 32)) < i) {
                            i11 = i10;
                            i10 = i12 + 1;
                        } else {
                            i9 = i12;
                        }
                    }
                    i5 = i11;
                }
                i2 = this.O00000oo;
                if (i5 != 0) {
                    i6 = (int) (this.f12689O000000o[i5] >>> 32);
                }
                while (true) {
                    int i13 = i5;
                    int i14 = i2;
                    i2 = i13;
                    if (i2 < i4) {
                        i2 = i14;
                        break;
                    }
                    long[] jArr2 = this.f12689O000000o;
                    long j2 = jArr2[i2];
                    jArr2[i2] = (((long) i3) << 32) | (4294967295L & j2);
                    if (i3 >= i) {
                        j = axp.O000000o(i2);
                        break;
                    }
                    i3++;
                    if ((2147483648L & j2) != 0) {
                        int i15 = (int) (j2 & 2147483647L);
                        if (i15 > 0 && (i3 + i15) - 1 >= i) {
                            j = axp.O000000o(i2, i - i3);
                            break;
                        }
                        i3 += i15;
                    }
                    i5 = i2 + 1;
                }
                this.O00000oo = Math.max(this.O00000oo, i2);
                return j;
            }
        }
        i5 = 0;
        i2 = this.O00000oo;
        if (i5 != 0) {
        }
        while (true) {
            int i132 = i5;
            int i142 = i2;
            i2 = i132;
            if (i2 < i4) {
            }
            i5 = i2 + 1;
        }
        this.O00000oo = Math.max(this.O00000oo, i2);
        return j;
    }

    public final int O000000o(long j) {
        int i = -1;
        if (j == -1) {
            return -1;
        }
        int i2 = (int) (j & 4294967295L);
        int i3 = (int) (j >>> 32);
        int i4 = this.O00000o0;
        if (i2 >= 0 && i2 < i4) {
            if (i3 != -1 && !O000000o(i2)) {
                return -1;
            }
            int max = Math.max(0, Math.min(i2, this.O00000oo));
            int i5 = this.O00000oo;
            int i6 = (int) (this.f12689O000000o[max] >>> 32);
            while (true) {
                int i7 = i5;
                i5 = max;
                int i8 = i7;
                if (i5 >= i4) {
                    i5 = i8;
                    break;
                }
                long[] jArr = this.f12689O000000o;
                long j2 = jArr[i5];
                jArr[i5] = (((long) i6) << 32) | (j2 & 4294967295L);
                int i9 = (int) (2147483647L & j2);
                if (i5 != i2) {
                    i6++;
                    if ((j2 & 2147483648L) != 0) {
                        i6 += i9;
                    }
                    max = i5 + 1;
                } else if (i3 == -1) {
                    i = i6;
                } else if (i3 < i9) {
                    i = i6 + 1 + i3;
                }
            }
            this.O00000oo = Math.max(this.O00000oo, i5);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, boolean z) {
        long[] jArr;
        int[] iArr;
        int i2 = (i + 511) & -256;
        long[] jArr2 = this.f12689O000000o;
        int[] iArr2 = this.O00000Oo;
        if (jArr2 == null || jArr2.length < i) {
            jArr = new long[i2];
        } else {
            jArr = jArr2;
        }
        if (iArr2 == null || iArr2.length < i) {
            iArr = new int[i2];
        } else {
            iArr = iArr2;
        }
        if (z) {
            if (!(jArr2 == null || jArr2 == jArr)) {
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            }
            if (!(iArr2 == null || iArr2 == iArr)) {
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            }
        }
        this.f12689O000000o = jArr;
        this.O00000Oo = iArr;
    }

    public final boolean O00000Oo() {
        return this.O00000o0 == 0;
    }
}

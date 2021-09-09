package com.google.android.gms.internal.clearcut;

import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;

final class zzfj extends zzfg {
    zzfj() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzff.zzam(i);
        }
        if (i2 == 1) {
            return zzff.zzp(i, zzfd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzff.zzd(i, zzfd.zza(bArr, j), zzfd.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b9, code lost:
        return -1;
     */
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        long j2;
        byte[] bArr2 = bArr;
        int i5 = i2;
        int i6 = i3;
        if ((i5 | i6 | (bArr2.length - i6)) >= 0) {
            long j3 = (long) i5;
            int i7 = (int) (((long) i6) - j3);
            if (i7 >= 16) {
                long j4 = j3;
                i4 = 0;
                while (true) {
                    if (i4 >= i7) {
                        i4 = i7;
                        break;
                    }
                    long j5 = j4 + 1;
                    if (zzfd.zza(bArr2, j4) < 0) {
                        break;
                    }
                    i4++;
                    j4 = j5;
                }
            } else {
                i4 = 0;
            }
            int i8 = i7 - i4;
            long j6 = j3 + ((long) i4);
            while (true) {
                byte b = 0;
                while (true) {
                    if (i8 <= 0) {
                        j = j6;
                        break;
                    }
                    j = j6 + 1;
                    b = zzfd.zza(bArr2, j6);
                    if (b < 0) {
                        break;
                    }
                    i8--;
                    j6 = j;
                }
                if (i8 == 0) {
                    return 0;
                }
                int i9 = i8 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i9 >= 3) {
                            i8 = i9 - 3;
                            long j7 = j + 1;
                            byte zza = zzfd.zza(bArr2, j);
                            if (zza > -65 || (((b << 28) + (zza + 112)) >> 30) != 0) {
                                break;
                            }
                            long j8 = j7 + 1;
                            if (zzfd.zza(bArr2, j7) > -65) {
                                break;
                            }
                            j2 = j8 + 1;
                            if (zzfd.zza(bArr2, j8) > -65) {
                                break;
                            }
                        } else {
                            return zza(bArr2, b, j, i9);
                        }
                    } else if (i9 >= 2) {
                        i8 = i9 - 2;
                        long j9 = j + 1;
                        byte zza2 = zzfd.zza(bArr2, j);
                        if (zza2 > -65 || ((b == -32 && zza2 < -96) || (b == -19 && zza2 >= -96))) {
                            break;
                        }
                        long j10 = j9 + 1;
                        if (zzfd.zza(bArr2, j9) > -65) {
                            break;
                        }
                        j6 = j10;
                    } else {
                        return zza(bArr2, b, j, i9);
                    }
                } else if (i9 != 0) {
                    i8 = i9 - 1;
                    if (b < -62) {
                        break;
                    }
                    j2 = j + 1;
                    if (zzfd.zza(bArr2, j) > -65) {
                        break;
                    }
                } else {
                    return b;
                }
                j6 = j2;
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr2.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00fb, LOOP_START, PHI: r2 r3 r4 r11 10  PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        int i3;
        char charAt;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        long j3 = (long) i4;
        long j4 = ((long) i5) + j3;
        int length = charSequence.length();
        if (length > i5 || bArr2.length - i5 < i4) {
            char charAt2 = charSequence2.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i4 + i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i6 = 0;
        while (true) {
            char c = 128;
            long j5 = 1;
            if (i6 < length && (charAt = charSequence2.charAt(i6)) < 128) {
                zzfd.zza(bArr2, j3, (byte) charAt);
                i6++;
                j3 = 1 + j3;
            } else if (i6 != length) {
                return (int) j3;
            } else {
                while (i6 < length) {
                    char charAt3 = charSequence2.charAt(i6);
                    if (charAt3 < c && j3 < j4) {
                        long j6 = j3 + j5;
                        zzfd.zza(bArr2, j3, (byte) charAt3);
                        j2 = j5;
                        j = j6;
                    } else if (charAt3 < 2048 && j3 <= j4 - 2) {
                        long j7 = j3 + j5;
                        zzfd.zza(bArr2, j3, (byte) ((charAt3 >>> 6) | 960));
                        zzfd.zza(bArr2, j7, (byte) ((charAt3 & '?') | 128));
                        j = j7 + j5;
                        j2 = j5;
                        i6++;
                        c = 128;
                        long j8 = j2;
                        j3 = j;
                        j5 = j8;
                    } else if ((charAt3 < 55296 || 57343 < charAt3) && j3 <= j4 - 3) {
                        long j9 = j3 + j5;
                        zzfd.zza(bArr2, j3, (byte) ((charAt3 >>> 12) | 480));
                        long j10 = j9 + j5;
                        zzfd.zza(bArr2, j9, (byte) (((charAt3 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                        zzfd.zza(bArr2, j10, (byte) ((charAt3 & '?') | 128));
                        j = j10 + 1;
                        j2 = 1;
                    } else if (j3 <= j4 - 4) {
                        int i7 = i6 + 1;
                        if (i7 != length) {
                            char charAt4 = charSequence2.charAt(i7);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j11 = j3 + 1;
                                zzfd.zza(bArr2, j3, (byte) ((codePoint >>> 18) | 240));
                                long j12 = j11 + 1;
                                zzfd.zza(bArr2, j11, (byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                long j13 = j12 + 1;
                                zzfd.zza(bArr2, j12, (byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                j2 = 1;
                                j = j13 + 1;
                                zzfd.zza(bArr2, j13, (byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                i6 = i7;
                                i6++;
                                c = 128;
                                long j82 = j2;
                                j3 = j;
                                j5 = j82;
                            } else {
                                i6 = i7;
                            }
                        }
                        throw new zzfi(i6 - 1, length);
                    } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i6 + 1) != length && Character.isSurrogatePair(charAt3, charSequence2.charAt(i3)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j3);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    } else {
                        throw new zzfi(i6, length);
                    }
                    i6++;
                    c = 128;
                    long j822 = j2;
                    j3 = j;
                    j5 = j822;
                }
                return (int) j3;
            }
        }
        if (i6 != length) {
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041 A[LOOP:1: B:12:0x0041->B:37:0x0100, LOOP_START, PHI: r2 r4 r9 r10 10  PHI: (r2v2 long) = (r2v0 long), (r2v3 long) binds: [B:8:0x0039, B:37:0x0100] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r4v5 long) = (r4v4 long), (r4v7 long) binds: [B:8:0x0039, B:37:0x0100] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r9v3 int) = (r9v2 int), (r9v5 int) binds: [B:8:0x0039, B:37:0x0100] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r10v1 char) = (r10v0 char), (r10v2 char) binds: [B:8:0x0039, B:37:0x0100] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003b  */
    public final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        int i;
        long j2;
        int i2;
        char charAt;
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        long zzb = zzfd.zzb(byteBuffer);
        long position = ((long) byteBuffer.position()) + zzb;
        long limit = ((long) byteBuffer.limit()) + zzb;
        int length = charSequence.length();
        if (((long) length) <= limit - position) {
            int i3 = 0;
            while (true) {
                char c = 128;
                if (i3 < length && (charAt = charSequence2.charAt(i3)) < 128) {
                    zzfd.zza(j, (byte) charAt);
                    i3++;
                    position = 1 + j;
                } else if (i3 != length) {
                    i = (int) (j - zzb);
                } else {
                    while (i3 < length) {
                        char charAt2 = charSequence2.charAt(i3);
                        if (charAt2 < c && j < limit) {
                            zzfd.zza(j, (byte) charAt2);
                            j++;
                            j2 = zzb;
                        } else if (charAt2 >= 2048 || j > limit - 2) {
                            j2 = zzb;
                            if ((charAt2 < 55296 || 57343 < charAt2) && j <= limit - 3) {
                                long j3 = j + 1;
                                zzfd.zza(j, (byte) ((charAt2 >>> 12) | 480));
                                long j4 = j3 + 1;
                                zzfd.zza(j3, (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                zzfd.zza(j4, (byte) ((charAt2 & '?') | 128));
                                j = j4 + 1;
                            } else if (j <= limit - 4) {
                                int i4 = i3 + 1;
                                if (i4 != length) {
                                    char charAt3 = charSequence2.charAt(i4);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        long j5 = j + 1;
                                        zzfd.zza(j, (byte) ((codePoint >>> 18) | 240));
                                        long j6 = j5 + 1;
                                        zzfd.zza(j5, (byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                        long j7 = j6 + 1;
                                        zzfd.zza(j6, (byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                        long j8 = j7 + 1;
                                        zzfd.zza(j7, (byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                        i3 = i4;
                                        j = j8;
                                    }
                                } else {
                                    i4 = i3;
                                }
                                throw new zzfi(i4 - 1, length);
                            } else if (55296 > charAt2 || charAt2 > 57343 || ((i2 = i3 + 1) != length && Character.isSurrogatePair(charAt2, charSequence2.charAt(i2)))) {
                                StringBuilder sb = new StringBuilder(46);
                                sb.append("Failed writing ");
                                sb.append(charAt2);
                                sb.append(" at index ");
                                sb.append(j);
                                throw new ArrayIndexOutOfBoundsException(sb.toString());
                            } else {
                                throw new zzfi(i3, length);
                            }
                        } else {
                            j2 = zzb;
                            long j9 = j + 1;
                            zzfd.zza(j, (byte) ((charAt2 >>> 6) | 960));
                            zzfd.zza(j9, (byte) ((charAt2 & '?') | 128));
                            j = j9 + 1;
                        }
                        i3++;
                        zzb = j2;
                        c = 128;
                    }
                    i = (int) (j - zzb);
                    byteBuffer2 = byteBuffer;
                }
            }
            if (i3 != length) {
            }
            byteBuffer2.position(i);
            return;
        }
        char charAt4 = charSequence2.charAt(length - 1);
        int limit2 = byteBuffer.limit();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Failed writing ");
        sb2.append(charAt4);
        sb2.append(" at index ");
        sb2.append(limit2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }
}

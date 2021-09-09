package com.google.android.gms.internal.measurement;

import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzabw {
    private final ByteBuffer zzbwv;

    private zzabw(ByteBuffer byteBuffer) {
        this.zzbwv = byteBuffer;
        this.zzbwv.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzabw(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i4 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i5 = remaining + arrayOffset;
                    while (i4 < length) {
                        int i6 = i4 + arrayOffset;
                        if (i6 >= i5 || (charAt = charSequence.charAt(i4)) >= 128) {
                            break;
                        }
                        array[i6] = (byte) charAt;
                        i4++;
                    }
                    if (i4 == length) {
                        i2 = arrayOffset + length;
                    } else {
                        i2 = arrayOffset + i4;
                        while (i4 < length) {
                            char charAt2 = charSequence.charAt(i4);
                            if (charAt2 < 128 && i2 < i5) {
                                i3 = i2 + 1;
                                array[i2] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i2 <= i5 - 2) {
                                int i7 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 6) | 960);
                                i2 = i7 + 1;
                                array[i7] = (byte) ((charAt2 & '?') | 128);
                                i4++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i2 <= i5 - 3) {
                                int i8 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 12) | 480);
                                int i9 = i8 + 1;
                                array[i8] = (byte) (((charAt2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                                i3 = i9 + 1;
                                array[i9] = (byte) ((charAt2 & '?') | 128);
                            } else if (i2 <= i5 - 4) {
                                int i10 = i4 + 1;
                                if (i10 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i10);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i11 = i2 + 1;
                                        array[i2] = (byte) ((codePoint >>> 18) | 240);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                                        int i13 = i12 + 1;
                                        array[i12] = (byte) (((codePoint >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                                        i2 = i13 + 1;
                                        array[i13] = (byte) ((codePoint & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                                        i4 = i10;
                                        i4++;
                                    } else {
                                        i4 = i10;
                                    }
                                }
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i4 - 1);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i2);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i2 = i3;
                            i4++;
                        }
                    }
                    byteBuffer.position(i2 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt4 = charSequence.charAt(i4);
                    if (charAt4 >= 128) {
                        if (charAt4 < 2048) {
                            i = (charAt4 >>> 6) | 960;
                        } else if (charAt4 < 55296 || 57343 < charAt4) {
                            byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                            i = ((charAt4 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY;
                        } else {
                            int i14 = i4 + 1;
                            if (i14 != charSequence.length()) {
                                char charAt5 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    byteBuffer.put((byte) ((codePoint2 & 63) | NotificationCompat.FLAG_HIGH_PRIORITY));
                                    i4 = i14;
                                    i4++;
                                } else {
                                    i4 = i14;
                                }
                            }
                            StringBuilder sb3 = new StringBuilder(39);
                            sb3.append("Unpaired surrogate at index ");
                            sb3.append(i4 - 1);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        byteBuffer.put((byte) i);
                        charAt4 = (charAt4 & '?') | 128;
                    }
                    byteBuffer.put((byte) charAt4);
                    i4++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    private final void zzan(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzap((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            j >>>= 7;
        }
        zzap((int) j);
    }

    public static int zzao(int i) {
        if (i >= 0) {
            return zzas(i);
        }
        return 10;
    }

    public static int zzao(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private final void zzap(int i) throws IOException {
        byte b = (byte) i;
        if (this.zzbwv.hasRemaining()) {
            this.zzbwv.put(b);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public static int zzaq(int i) {
        return zzas(i << 3);
    }

    public static int zzas(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzb(int i, zzace zzace) {
        int zzaq = zzaq(i);
        int zzvm = zzace.zzvm();
        return zzaq + zzas(zzvm) + zzvm;
    }

    public static zzabw zzb(byte[] bArr, int i, int i2) {
        return new zzabw(bArr, 0, i2);
    }

    public static int zzc(int i, long j) {
        return zzaq(i) + zzao(j);
    }

    public static int zzc(int i, String str) {
        return zzaq(i) + zzfm(str);
    }

    public static int zzf(int i, int i2) {
        return zzaq(i) + zzao(i2);
    }

    public static int zzfm(String str) {
        int zza = zza(str);
        return zzas(zza) + zza;
    }

    public static zzabw zzj(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public final void zza(int i, double d) throws IOException {
        zzg(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.zzbwv.remaining() >= 8) {
            this.zzbwv.putLong(doubleToLongBits);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zza(int i, float f) throws IOException {
        zzg(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzbwv.remaining() >= 4) {
            this.zzbwv.putInt(floatToIntBits);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zza(int i, long j) throws IOException {
        zzg(i, 0);
        zzan(j);
    }

    public final void zza(int i, zzace zzace) throws IOException {
        zzg(i, 2);
        zzb(zzace);
    }

    public final void zza(int i, boolean z) throws IOException {
        zzg(i, 0);
        byte b = z ? (byte) 1 : 0;
        if (this.zzbwv.hasRemaining()) {
            this.zzbwv.put(b);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zzar(int i) throws IOException {
        while ((i & -128) != 0) {
            zzap((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i >>>= 7;
        }
        zzap(i);
    }

    public final void zzb(int i, long j) throws IOException {
        zzg(i, 0);
        zzan(j);
    }

    public final void zzb(int i, String str) throws IOException {
        zzg(i, 2);
        try {
            int zzas = zzas(str.length());
            if (zzas == zzas(str.length() * 3)) {
                int position = this.zzbwv.position();
                if (this.zzbwv.remaining() >= zzas) {
                    this.zzbwv.position(position + zzas);
                    zza(str, this.zzbwv);
                    int position2 = this.zzbwv.position();
                    this.zzbwv.position(position);
                    zzar((position2 - position) - zzas);
                    this.zzbwv.position(position2);
                    return;
                }
                throw new zzabx(position + zzas, this.zzbwv.limit());
            }
            zzar(zza(str));
            zza(str, this.zzbwv);
        } catch (BufferOverflowException e) {
            zzabx zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            zzabx.initCause(e);
            throw zzabx;
        }
    }

    public final void zzb(zzace zzace) throws IOException {
        zzar(zzace.zzvl());
        zzace.zza(this);
    }

    public final void zze(int i, int i2) throws IOException {
        zzg(i, 0);
        if (i2 >= 0) {
            zzar(i2);
        } else {
            zzan((long) i2);
        }
    }

    public final void zzg(int i, int i2) throws IOException {
        zzar((i << 3) | i2);
    }

    public final void zzk(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzbwv.remaining() >= length) {
            this.zzbwv.put(bArr, 0, length);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zzve() {
        if (this.zzbwv.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzbwv.remaining())));
        }
    }
}

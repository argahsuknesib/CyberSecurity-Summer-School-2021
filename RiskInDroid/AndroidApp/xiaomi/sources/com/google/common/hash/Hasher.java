package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@Beta
public interface Hasher extends PrimitiveSink {

    /* renamed from: com.google.common.hash.Hasher$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    HashCode hash();

    @Deprecated
    int hashCode();

    Hasher putBoolean(boolean z);

    Hasher putByte(byte b);

    Hasher putBytes(ByteBuffer byteBuffer);

    Hasher putBytes(byte[] bArr);

    Hasher putBytes(byte[] bArr, int i, int i2);

    Hasher putChar(char c);

    Hasher putDouble(double d);

    Hasher putFloat(float f);

    Hasher putInt(int i);

    Hasher putLong(long j);

    <T> Hasher putObject(T t, Funnel<? super T> funnel);

    Hasher putShort(short s);

    Hasher putString(CharSequence charSequence, Charset charset);

    Hasher putUnencodedChars(CharSequence charSequence);
}

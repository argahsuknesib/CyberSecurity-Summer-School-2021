package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    /* access modifiers changed from: package-private */
    public abstract HashCode makeHash(Hasher[] hasherArr);

    AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction checkNotNull : hashFunctionArr) {
            Preconditions.checkNotNull(checkNotNull);
        }
        this.functions = hashFunctionArr;
    }

    public Hasher newHasher() {
        Hasher[] hasherArr = new Hasher[this.functions.length];
        for (int i = 0; i < hasherArr.length; i++) {
            hasherArr[i] = this.functions[i].newHasher();
        }
        return fromHashers(hasherArr);
    }

    public Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        Hasher[] hasherArr = new Hasher[this.functions.length];
        for (int i2 = 0; i2 < hasherArr.length; i2++) {
            hasherArr[i2] = this.functions[i2].newHasher(i);
        }
        return fromHashers(hasherArr);
    }

    private Hasher fromHashers(final Hasher[] hasherArr) {
        return new Hasher() {
            /* class com.google.common.hash.AbstractCompositeHashFunction.AnonymousClass1 */

            public Hasher putByte(byte b) {
                for (Hasher putByte : hasherArr) {
                    putByte.putByte(b);
                }
                return this;
            }

            public Hasher putBytes(byte[] bArr) {
                for (Hasher putBytes : hasherArr) {
                    putBytes.putBytes(bArr);
                }
                return this;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher
             arg types: [byte[], int, int]
             candidates:
              com.google.common.hash.PrimitiveSink.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
              com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher */
            public Hasher putBytes(byte[] bArr, int i, int i2) {
                for (Hasher putBytes : hasherArr) {
                    putBytes.putBytes(bArr, i, i2);
                }
                return this;
            }

            public Hasher putBytes(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                for (Hasher putBytes : hasherArr) {
                    byteBuffer.position(position);
                    putBytes.putBytes(byteBuffer);
                }
                return this;
            }

            public Hasher putShort(short s) {
                for (Hasher putShort : hasherArr) {
                    putShort.putShort(s);
                }
                return this;
            }

            public Hasher putInt(int i) {
                for (Hasher putInt : hasherArr) {
                    putInt.putInt(i);
                }
                return this;
            }

            public Hasher putLong(long j) {
                for (Hasher putLong : hasherArr) {
                    putLong.putLong(j);
                }
                return this;
            }

            public Hasher putFloat(float f) {
                for (Hasher putFloat : hasherArr) {
                    putFloat.putFloat(f);
                }
                return this;
            }

            public Hasher putDouble(double d) {
                for (Hasher putDouble : hasherArr) {
                    putDouble.putDouble(d);
                }
                return this;
            }

            public Hasher putBoolean(boolean z) {
                for (Hasher putBoolean : hasherArr) {
                    putBoolean.putBoolean(z);
                }
                return this;
            }

            public Hasher putChar(char c) {
                for (Hasher putChar : hasherArr) {
                    putChar.putChar(c);
                }
                return this;
            }

            public Hasher putUnencodedChars(CharSequence charSequence) {
                for (Hasher putUnencodedChars : hasherArr) {
                    putUnencodedChars.putUnencodedChars(charSequence);
                }
                return this;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.google.common.hash.Hasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.Hasher
             arg types: [java.lang.CharSequence, java.nio.charset.Charset]
             candidates:
              com.google.common.hash.PrimitiveSink.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.PrimitiveSink
              com.google.common.hash.Hasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.Hasher */
            public Hasher putString(CharSequence charSequence, Charset charset) {
                for (Hasher putString : hasherArr) {
                    putString.putString(charSequence, charset);
                }
                return this;
            }

            public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
                for (Hasher putObject : hasherArr) {
                    putObject.putObject(t, funnel);
                }
                return this;
            }

            public HashCode hash() {
                return AbstractCompositeHashFunction.this.makeHash(hasherArr);
            }
        };
    }
}

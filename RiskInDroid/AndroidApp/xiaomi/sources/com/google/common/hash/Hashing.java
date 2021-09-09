package com.google.common.hash;

import android.support.v4.app.NotificationCompat;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.crypto.spec.SecretKeySpec;

@Beta
public final class Hashing {
    static final int GOOD_FAST_HASH_SEED = ((int) System.currentTimeMillis());

    public static HashFunction goodFastHash(int i) {
        int checkPositiveAndMakeMultipleOf32 = checkPositiveAndMakeMultipleOf32(i);
        if (checkPositiveAndMakeMultipleOf32 == 32) {
            return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
        }
        if (checkPositiveAndMakeMultipleOf32 <= 128) {
            return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        }
        int i2 = (checkPositiveAndMakeMultipleOf32 + 127) / NotificationCompat.FLAG_HIGH_PRIORITY;
        HashFunction[] hashFunctionArr = new HashFunction[i2];
        hashFunctionArr[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int i3 = GOOD_FAST_HASH_SEED;
        for (int i4 = 1; i4 < i2; i4++) {
            i3 += 1500450271;
            hashFunctionArr[i4] = murmur3_128(i3);
        }
        return new ConcatenatedHashFunction(hashFunctionArr);
    }

    public static HashFunction murmur3_32(int i) {
        return new Murmur3_32HashFunction(i);
    }

    public static HashFunction murmur3_32() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }

    public static HashFunction murmur3_128(int i) {
        return new Murmur3_128HashFunction(i);
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static HashFunction sipHash24() {
        return SipHashFunction.SIP_HASH_24;
    }

    public static HashFunction sipHash24(long j, long j2) {
        return new SipHashFunction(2, 4, j, j2);
    }

    @Deprecated
    public static HashFunction md5() {
        return Md5Holder.MD5;
    }

    static class Md5Holder {
        static final HashFunction MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");

        private Md5Holder() {
        }
    }

    @Deprecated
    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }

    static class Sha1Holder {
        static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");

        private Sha1Holder() {
        }
    }

    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }

    static class Sha256Holder {
        static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");

        private Sha256Holder() {
        }
    }

    public static HashFunction sha384() {
        return Sha384Holder.SHA_384;
    }

    static class Sha384Holder {
        static final HashFunction SHA_384 = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");

        private Sha384Holder() {
        }
    }

    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }

    static class Sha512Holder {
        static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");

        private Sha512Holder() {
        }
    }

    public static HashFunction hmacMd5(Key key) {
        return new MacHashFunction("HmacMD5", key, hmacToString("hmacMd5", key));
    }

    public static HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    public static HashFunction hmacSha1(Key key) {
        return new MacHashFunction("HmacSHA1", key, hmacToString("hmacSha1", key));
    }

    public static HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA1"));
    }

    public static HashFunction hmacSha256(Key key) {
        return new MacHashFunction("HmacSHA256", key, hmacToString("hmacSha256", key));
    }

    public static HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA256"));
    }

    public static HashFunction hmacSha512(Key key) {
        return new MacHashFunction("HmacSHA512", key, hmacToString("hmacSha512", key));
    }

    public static HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512(new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA512"));
    }

    private static String hmacToString(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    public static HashFunction crc32c() {
        return Crc32cHashFunction.CRC_32_C;
    }

    public static HashFunction crc32() {
        return ChecksumType.CRC_32.hashFunction;
    }

    public static HashFunction adler32() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    @Immutable
    enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") {
            public final Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") {
            public final Checksum get() {
                return new Adler32();
            }
        };
        
        public final HashFunction hashFunction;

        private ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static HashFunction farmHashFingerprint64() {
        return FarmHashFingerprint64.FARMHASH_FINGERPRINT_64;
    }

    public static int consistentHash(HashCode hashCode, int i) {
        return consistentHash(hashCode.padToLong(), i);
    }

    public static int consistentHash(long j, int i) {
        int i2 = 0;
        Preconditions.checkArgument(i > 0, "buckets must be positive: %s", i);
        LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(j);
        while (true) {
            double d = (double) (i2 + 1);
            double nextDouble = linearCongruentialGenerator.nextDouble();
            Double.isNaN(d);
            int i3 = (int) (d / nextDouble);
            if (i3 < 0 || i3 >= i) {
                return i2;
            }
            i2 = i3;
        }
        return i2;
    }

    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        byte[] bArr = new byte[(it.next().bits() / 8)];
        for (HashCode asBytes : iterable) {
            byte[] asBytes2 = asBytes.asBytes();
            Preconditions.checkArgument(asBytes2.length == bArr.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes2.length; i++) {
                bArr[i] = (byte) ((bArr[i] * 37) ^ asBytes2[i]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        byte[] bArr = new byte[(it.next().bits() / 8)];
        for (HashCode asBytes : iterable) {
            byte[] asBytes2 = asBytes.asBytes();
            Preconditions.checkArgument(asBytes2.length == bArr.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes2.length; i++) {
                bArr[i] = (byte) (bArr[i] + asBytes2[i]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    static int checkPositiveAndMakeMultipleOf32(int i) {
        Preconditions.checkArgument(i > 0, "Number of bits must be positive");
        return (i + 31) & -32;
    }

    public static HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        arrayList.addAll(Arrays.asList(hashFunctionArr));
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static HashFunction concatenating(Iterable<HashFunction> iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList arrayList = new ArrayList();
        for (HashFunction add : iterable) {
            arrayList.add(add);
        }
        Preconditions.checkArgument(arrayList.size() > 0, "number of hash functions (%s) must be > 0", arrayList.size());
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, java.lang.Object):void
         arg types: [boolean, java.lang.String, int, com.google.common.hash.HashFunction]
         candidates:
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, char):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, int):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, long):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, java.lang.Object):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, char):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, int):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, long):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, char):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, int):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, long):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, java.lang.Object):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, char):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, int):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, long):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, java.lang.Object):void
          com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, java.lang.Object):void */
        private ConcatenatedHashFunction(HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), (Object) hashFunction);
            }
        }

        /* access modifiers changed from: package-private */
        public final HashCode makeHash(Hasher[] hasherArr) {
            byte[] bArr = new byte[(bits() / 8)];
            int i = 0;
            for (Hasher hash : hasherArr) {
                HashCode hash2 = hash.hash();
                i += hash2.writeBytesTo(bArr, i, hash2.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(bArr);
        }

        public final int bits() {
            int i = 0;
            for (HashFunction bits : this.functions) {
                i += bits.bits();
            }
            return i;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ConcatenatedHashFunction) {
                return Arrays.equals(this.functions, ((ConcatenatedHashFunction) obj).functions);
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.functions);
        }
    }

    static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long j) {
            this.state = j;
        }

        public final double nextDouble() {
            this.state = (this.state * 2862933555777941757L) + 1;
            double d = (double) (((int) (this.state >>> 33)) + 1);
            Double.isNaN(d);
            return d / 2.147483648E9d;
        }
    }

    private Hashing() {
    }
}

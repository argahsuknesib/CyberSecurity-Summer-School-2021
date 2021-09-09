package com.google.android.play.core.internal;

import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class h {
    private static int a(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                String valueOf = String.valueOf(Long.toHexString((long) i));
                throw new IllegalArgumentException(valueOf.length() == 0 ? new String("Unknown signature algorithm: 0x") : "Unknown signature algorithm: 0x".concat(valueOf));
        }
    }

    public static long a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return a(byteBuffer, byteBuffer.position() + 16);
    }

    private static long a(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> a2 = a(randomAccessFile, 0);
        return a2 == null ? a(randomAccessFile, 65535) : a2;
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i) throws IOException {
        int i2;
        long length = randomAccessFile.length();
        if (length >= 22) {
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i, -22 + length)) + 22);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            long capacity = length - ((long) allocate.capacity());
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            c(allocate);
            int capacity2 = allocate.capacity();
            if (capacity2 >= 22) {
                int i3 = capacity2 - 22;
                int min = Math.min(i3, 65535);
                int i4 = 0;
                while (true) {
                    if (i4 >= min) {
                        break;
                    }
                    i2 = i3 - i4;
                    if (allocate.getInt(i2) == 101010256 && ((char) allocate.getShort(i2 + 20)) == i4) {
                        break;
                    }
                    i4++;
                }
            }
            i2 = -1;
            if (i2 != -1) {
                allocate.position(i2);
                ByteBuffer slice = allocate.slice();
                slice.order(ByteOrder.LITTLE_ENDIAN);
                return Pair.create(slice, Long.valueOf(capacity + ((long) i2)));
            }
        }
        return null;
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public static String a(String str, String str2, String str3) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        sb.append(":");
        sb.append(str3);
        return sb.toString();
    }

    private static void a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    public static void a(ByteBuffer byteBuffer, long j) {
        c(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j < 0 || j > 4294967295L) {
            StringBuilder sb = new StringBuilder(47);
            sb.append("uint32 value of out range: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        byteBuffer.putInt(byteBuffer.position() + position, (int) j);
    }

    private static void a(Map<Integer, byte[]> map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            c cVar = new c(fileChannel, 0, j);
            c cVar2 = new c(fileChannel, j2, j3 - j2);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            a(duplicate, j);
            a aVar = new a(duplicate);
            int[] iArr = new int[map.size()];
            int i = 0;
            int i2 = 0;
            for (Integer intValue : map.keySet()) {
                iArr[i2] = intValue.intValue();
                i2++;
            }
            try {
                byte[][] a2 = a(iArr, new b[]{cVar, cVar2, aVar});
                while (i < iArr.length) {
                    int i3 = iArr[i];
                    if (MessageDigest.isEqual(map.get(Integer.valueOf(i3)), a2[i])) {
                        i++;
                    } else {
                        throw new SecurityException(b(i3).concat(" digest of contents did not verify"));
                    }
                }
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0139 A[Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x025e }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013a A[Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x025e }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0146  */
    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        String str;
        Pair pair;
        String str2;
        AlgorithmParameterSpec algorithmParameterSpec;
        Signature instance;
        String str3;
        String str4;
        PSSParameterSpec pSSParameterSpec;
        ByteBuffer d = d(byteBuffer);
        ByteBuffer d2 = d(byteBuffer);
        byte[] e = e(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i = -1;
        int i2 = 0;
        while (d2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer d3 = d(d2);
                if (d3.remaining() >= 8) {
                    int i3 = d3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (!(i3 == 513 || i3 == 514 || i3 == 769)) {
                        switch (i3) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                break;
                            default:
                                continue;
                        }
                    }
                    if (i != -1) {
                        int a2 = a(i3);
                        int a3 = a(i);
                        if (a2 != 1) {
                            if (a3 != 1) {
                            }
                        }
                    }
                    bArr2 = e(d3);
                    i = i3;
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Failed to parse signature record #");
                sb.append(i2);
                throw new SecurityException(sb.toString(), e2);
            }
        }
        if (i != -1) {
            if (i == 513 || i == 514) {
                str = "EC";
            } else if (i != 769) {
                switch (i) {
                    case 257:
                    case 258:
                    case 259:
                    case 260:
                        break;
                    default:
                        String valueOf = String.valueOf(Long.toHexString((long) i));
                        throw new IllegalArgumentException(valueOf.length() == 0 ? new String("Unknown signature algorithm: 0x") : "Unknown signature algorithm: 0x".concat(valueOf));
                }
                str = "RSA";
            } else {
                str = "DSA";
            }
            if (i == 513) {
                str3 = "SHA256withECDSA";
            } else if (i == 514) {
                str3 = "SHA512withECDSA";
            } else if (i != 769) {
                switch (i) {
                    case 257:
                        pSSParameterSpec = new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
                        str4 = "SHA256withRSA/PSS";
                        pair = Pair.create(str4, pSSParameterSpec);
                        break;
                    case 258:
                        pSSParameterSpec = new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1);
                        str4 = "SHA512withRSA/PSS";
                        pair = Pair.create(str4, pSSParameterSpec);
                        break;
                    case 259:
                        str3 = "SHA256withRSA";
                        break;
                    case 260:
                        str3 = "SHA512withRSA";
                        break;
                    default:
                        String valueOf2 = String.valueOf(Long.toHexString((long) i));
                        throw new IllegalArgumentException(valueOf2.length() == 0 ? new String("Unknown signature algorithm: 0x") : "Unknown signature algorithm: 0x".concat(valueOf2));
                }
                str2 = (String) pair.first;
                algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
                PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(e));
                instance = Signature.getInstance(str2);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec == null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(d);
                if (!instance.verify(bArr2)) {
                    d.clear();
                    ByteBuffer d4 = d(d);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (d4.hasRemaining()) {
                        i4++;
                        try {
                            ByteBuffer d5 = d(d4);
                            if (d5.remaining() >= 8) {
                                int i5 = d5.getInt();
                                arrayList2.add(Integer.valueOf(i5));
                                if (i5 == i) {
                                    bArr = e(d5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e3) {
                            StringBuilder sb2 = new StringBuilder(42);
                            sb2.append("Failed to parse digest record #");
                            sb2.append(i4);
                            throw new IOException(sb2.toString(), e3);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        int a4 = a(i);
                        byte[] put = map.put(Integer.valueOf(a4), bArr);
                        if (put == null || MessageDigest.isEqual(put, bArr)) {
                            ByteBuffer d6 = d(d);
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = 0;
                            while (d6.hasRemaining()) {
                                i6++;
                                byte[] e4 = e(d6);
                                try {
                                    arrayList3.add(new f((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(e4)), e4));
                                } catch (CertificateException e5) {
                                    StringBuilder sb3 = new StringBuilder(41);
                                    sb3.append("Failed to decode certificate #");
                                    sb3.append(i6);
                                    throw new SecurityException(sb3.toString(), e5);
                                }
                            }
                            if (arrayList3.isEmpty()) {
                                throw new SecurityException("No certificates listed");
                            } else if (Arrays.equals(e, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            } else {
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                        } else {
                            throw new SecurityException(b(a4).concat(" contents digest does not match the digest specified by a preceding signer"));
                        }
                    } else {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                } else {
                    throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
                }
            } else {
                str3 = "SHA256withDSA";
            }
            pair = Pair.create(str3, null);
            str2 = (String) pair.first;
            algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
            try {
                PublicKey generatePublic2 = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(e));
                instance = Signature.getInstance(str2);
                instance.initVerify(generatePublic2);
                if (algorithmParameterSpec == null) {
                }
                instance.update(d);
                if (!instance.verify(bArr2)) {
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e6) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(str2).length() + 27);
                sb4.append("Failed to verify ");
                sb4.append(str2);
                sb4.append(" signature");
                throw new SecurityException(sb4.toString(), e6);
            }
        } else if (i2 == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    private static byte[][] a(int[] iArr, b[] bVarArr) throws DigestException {
        long j;
        int i;
        int length;
        int[] iArr2 = iArr;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j = 1048576;
            i = 3;
            if (i2 >= 3) {
                break;
            }
            j3 += (bVarArr[i2].a() + 1048575) / 1048576;
            i2++;
        }
        if (j3 < 2097151) {
            int i3 = (int) j3;
            byte[][] bArr = new byte[iArr2.length][];
            int i4 = 0;
            while (true) {
                length = iArr2.length;
                if (i4 >= length) {
                    break;
                }
                byte[] bArr2 = new byte[((c(iArr2[i4]) * i3) + 5)];
                bArr2[0] = 90;
                a(i3, bArr2);
                bArr[i4] = bArr2;
                i4++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i5 = 0;
            while (i5 < iArr2.length) {
                String b = b(iArr2[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(b);
                    i5++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(b.concat(" digest not supported"), e);
                }
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i) {
                b bVar = bVarArr[i6];
                long j4 = j2;
                int i9 = i7;
                long a2 = bVar.a();
                while (a2 > j2) {
                    int min = (int) Math.min(a2, j);
                    a(min, bArr3);
                    for (MessageDigest update : messageDigestArr) {
                        update.update(bArr3);
                    }
                    long j5 = j4;
                    try {
                        bVar.a(messageDigestArr, j5, min);
                        int i10 = 0;
                        while (i10 < iArr2.length) {
                            int i11 = iArr2[i10];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i10];
                            int c = c(i11);
                            int i12 = i6;
                            MessageDigest messageDigest = messageDigestArr[i10];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i9 * c) + 5, c);
                            if (digest == c) {
                                i10++;
                                bArr3 = bArr4;
                                i6 = i12;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        long j6 = (long) min;
                        long j7 = j5 + j6;
                        a2 -= j6;
                        i9++;
                        j2 = 0;
                        i = 3;
                        j4 = j7;
                        j = 1048576;
                    } catch (IOException e2) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Failed to digest chunk #");
                        sb2.append(i9);
                        sb2.append(" of section #");
                        sb2.append(i8);
                        throw new DigestException(sb2.toString(), e2);
                    }
                }
                i8++;
                i6++;
                i7 = i9;
            }
            byte[][] bArr6 = new byte[iArr2.length][];
            int i13 = 0;
            while (i13 < iArr2.length) {
                int i14 = iArr2[i13];
                byte[] bArr7 = bArr[i13];
                String b2 = b(i14);
                try {
                    bArr6[i13] = MessageDigest.getInstance(b2).digest(bArr7);
                    i13++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(b2.concat(" digest not supported"), e3);
                }
            }
            return bArr6;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Too many chunks: ");
        sb3.append(j3);
        throw new DigestException(sb3.toString());
    }

    public static X509Certificate[][] a(String str) throws e, SecurityException, IOException {
        ByteBuffer byteBuffer;
        int limit;
        int position;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> a2 = a(randomAccessFile);
            if (a2 != null) {
                ByteBuffer byteBuffer2 = (ByteBuffer) a2.first;
                long longValue = ((Long) a2.second).longValue();
                long j = -20 + longValue;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new e("ZIP64 APK not supported");
                    }
                }
                long a3 = a(byteBuffer2);
                if (a3 >= longValue) {
                    StringBuilder sb = new StringBuilder(122);
                    sb.append("ZIP Central Directory offset out of range: ");
                    sb.append(a3);
                    sb.append(". ZIP End of Central Directory offset: ");
                    sb.append(longValue);
                    throw new e(sb.toString());
                } else if (b(byteBuffer2) + a3 != longValue) {
                    throw new e("ZIP Central Directory is not immediately followed by End of Central Directory");
                } else if (a3 >= 32) {
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(a3 - ((long) allocate.capacity()));
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    int i = 8;
                    if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                        int i2 = 0;
                        long j2 = allocate.getLong(0);
                        if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                            StringBuilder sb2 = new StringBuilder(57);
                            sb2.append("APK Signing Block size out of range: ");
                            sb2.append(j2);
                            throw new e(sb2.toString());
                        }
                        int i3 = (int) (8 + j2);
                        long j3 = a3 - ((long) i3);
                        if (j3 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i3);
                            allocate2.order(ByteOrder.LITTLE_ENDIAN);
                            randomAccessFile.seek(j3);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j4 = allocate2.getLong(0);
                            if (j4 == j2) {
                                Pair create = Pair.create(allocate2, Long.valueOf(j3));
                                byteBuffer = (ByteBuffer) create.first;
                                long longValue2 = ((Long) create.second).longValue();
                                if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                                    int capacity = byteBuffer.capacity() - 24;
                                    if (capacity >= 8) {
                                        int capacity2 = byteBuffer.capacity();
                                        if (capacity <= byteBuffer.capacity()) {
                                            limit = byteBuffer.limit();
                                            position = byteBuffer.position();
                                            byteBuffer.position(0);
                                            byteBuffer.limit(capacity);
                                            byteBuffer.position(8);
                                            ByteBuffer slice = byteBuffer.slice();
                                            slice.order(byteBuffer.order());
                                            byteBuffer.position(0);
                                            byteBuffer.limit(limit);
                                            byteBuffer.position(position);
                                            while (slice.hasRemaining()) {
                                                i2++;
                                                if (slice.remaining() >= i) {
                                                    long j5 = slice.getLong();
                                                    if (j5 < 4 || j5 > 2147483647L) {
                                                        StringBuilder sb3 = new StringBuilder(76);
                                                        sb3.append("APK Signing Block entry #");
                                                        sb3.append(i2);
                                                        sb3.append(" size out of range: ");
                                                        sb3.append(j5);
                                                        throw new e(sb3.toString());
                                                    }
                                                    int i4 = (int) j5;
                                                    int position2 = slice.position() + i4;
                                                    if (i4 > slice.remaining()) {
                                                        int remaining = slice.remaining();
                                                        StringBuilder sb4 = new StringBuilder(91);
                                                        sb4.append("APK Signing Block entry #");
                                                        sb4.append(i2);
                                                        sb4.append(" size out of range: ");
                                                        sb4.append(i4);
                                                        sb4.append(", available: ");
                                                        sb4.append(remaining);
                                                        throw new e(sb4.toString());
                                                    } else if (slice.getInt() == 1896449818) {
                                                        X509Certificate[][] a4 = a(randomAccessFile.getChannel(), new d(b(slice, i4 - 4), longValue2, a3, longValue, byteBuffer2));
                                                        randomAccessFile.close();
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (IOException unused) {
                                                        }
                                                        return a4;
                                                    } else {
                                                        slice.position(position2);
                                                        i = 8;
                                                    }
                                                } else {
                                                    StringBuilder sb5 = new StringBuilder(70);
                                                    sb5.append("Insufficient data to read size of APK Signing Block entry #");
                                                    sb5.append(i2);
                                                    throw new e(sb5.toString());
                                                }
                                            }
                                            throw new e("No APK Signature Scheme v2 block in APK Signing Block");
                                        }
                                        StringBuilder sb6 = new StringBuilder(41);
                                        sb6.append("end > capacity: ");
                                        sb6.append(capacity);
                                        sb6.append(" > ");
                                        sb6.append(capacity2);
                                        throw new IllegalArgumentException(sb6.toString());
                                    }
                                    StringBuilder sb7 = new StringBuilder(38);
                                    sb7.append("end < start: ");
                                    sb7.append(capacity);
                                    sb7.append(" < ");
                                    sb7.append(8);
                                    throw new IllegalArgumentException(sb7.toString());
                                }
                                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                            }
                            StringBuilder sb8 = new StringBuilder(103);
                            sb8.append("APK Signing Block sizes in header and footer do not match: ");
                            sb8.append(j4);
                            sb8.append(" vs ");
                            sb8.append(j2);
                            throw new e(sb8.toString());
                        }
                        StringBuilder sb9 = new StringBuilder(59);
                        sb9.append("APK Signing Block offset out of range: ");
                        sb9.append(j3);
                        throw new e(sb9.toString());
                    }
                    throw new e("No APK Signing Block before ZIP Central Directory");
                } else {
                    StringBuilder sb10 = new StringBuilder(87);
                    sb10.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                    sb10.append(a3);
                    throw new e(sb10.toString());
                }
            } else {
                long length = randomAccessFile.length();
                StringBuilder sb11 = new StringBuilder(102);
                sb11.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb11.append(length);
                sb11.append(" bytes");
                throw new e(sb11.toString());
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    private static X509Certificate[][] a(FileChannel fileChannel, d dVar) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer d = d(dVar.f3765a);
                int i = 0;
                while (d.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(a(d(d), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    a(hashMap, fileChannel, dVar.b, dVar.c, dVar.d, dVar.e);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    public static long b(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return a(byteBuffer, byteBuffer.position() + 12);
    }

    private static String b(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            StringBuilder sb = new StringBuilder(17);
            sb.append("size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static int c(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static void c(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer d(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return b(byteBuffer, i);
            } else {
                int remaining = byteBuffer.remaining();
                StringBuilder sb = new StringBuilder(101);
                sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb.append(i);
                sb.append(", remaining: ");
                sb.append(remaining);
                throw new IOException(sb.toString());
            }
        } else {
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(93);
            sb2.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb2.append(remaining2);
            throw new IOException(sb2.toString());
        }
    }

    private static byte[] e(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(90);
            sb.append("Underflow while reading length-prefixed value. Length: ");
            sb.append(i);
            sb.append(", available: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
    }
}

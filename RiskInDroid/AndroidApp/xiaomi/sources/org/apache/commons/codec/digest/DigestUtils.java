package org.apache.commons.codec.digest;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils {
    private static byte[] digest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr, 0, 1024);
        while (read >= 0) {
            messageDigest.update(bArr, 0, read);
            read = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest.digest();
    }

    private static byte[] getBytesUtf8(String str) {
        return StringUtils.getBytesUtf8(str);
    }

    static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }

    private static MessageDigest getSha256Digest() {
        return getDigest("SHA-256");
    }

    private static MessageDigest getSha384Digest() {
        return getDigest("SHA-384");
    }

    private static MessageDigest getSha512Digest() {
        return getDigest("SHA-512");
    }

    private static MessageDigest getShaDigest() {
        return getDigest("SHA");
    }

    public static byte[] md5(byte[] bArr) {
        return getMd5Digest().digest(bArr);
    }

    public static byte[] md5(InputStream inputStream) throws IOException {
        return digest(getMd5Digest(), inputStream);
    }

    public static byte[] md5(String str) {
        return md5(getBytesUtf8(str));
    }

    public static String md5Hex(byte[] bArr) {
        return Hex.encodeHexString(md5(bArr));
    }

    public static String md5Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(md5(inputStream));
    }

    public static String md5Hex(String str) {
        return Hex.encodeHexString(md5(str));
    }

    public static byte[] sha(byte[] bArr) {
        return getShaDigest().digest(bArr);
    }

    public static byte[] sha(InputStream inputStream) throws IOException {
        return digest(getShaDigest(), inputStream);
    }

    public static byte[] sha(String str) {
        return sha(getBytesUtf8(str));
    }

    public static byte[] sha256(byte[] bArr) {
        return getSha256Digest().digest(bArr);
    }

    public static byte[] sha256(InputStream inputStream) throws IOException {
        return digest(getSha256Digest(), inputStream);
    }

    public static byte[] sha256(String str) {
        return sha256(getBytesUtf8(str));
    }

    public static String sha256Hex(byte[] bArr) {
        return Hex.encodeHexString(sha256(bArr));
    }

    public static String sha256Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha256(inputStream));
    }

    public static String sha256Hex(String str) {
        return Hex.encodeHexString(sha256(str));
    }

    public static byte[] sha384(byte[] bArr) {
        return getSha384Digest().digest(bArr);
    }

    public static byte[] sha384(InputStream inputStream) throws IOException {
        return digest(getSha384Digest(), inputStream);
    }

    public static byte[] sha384(String str) {
        return sha384(getBytesUtf8(str));
    }

    public static String sha384Hex(byte[] bArr) {
        return Hex.encodeHexString(sha384(bArr));
    }

    public static String sha384Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha384(inputStream));
    }

    public static String sha384Hex(String str) {
        return Hex.encodeHexString(sha384(str));
    }

    public static byte[] sha512(byte[] bArr) {
        return getSha512Digest().digest(bArr);
    }

    public static byte[] sha512(InputStream inputStream) throws IOException {
        return digest(getSha512Digest(), inputStream);
    }

    public static byte[] sha512(String str) {
        return sha512(getBytesUtf8(str));
    }

    public static String sha512Hex(byte[] bArr) {
        return Hex.encodeHexString(sha512(bArr));
    }

    public static String sha512Hex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha512(inputStream));
    }

    public static String sha512Hex(String str) {
        return Hex.encodeHexString(sha512(str));
    }

    public static String shaHex(byte[] bArr) {
        return Hex.encodeHexString(sha(bArr));
    }

    public static String shaHex(InputStream inputStream) throws IOException {
        return Hex.encodeHexString(sha(inputStream));
    }

    public static String shaHex(String str) {
        return Hex.encodeHexString(sha(str));
    }
}

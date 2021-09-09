package com.facebook.imageformat;

public class ImageFormat {
    public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
    private final String mFileExtension;
    private final String mName;

    public interface FormatChecker {
        ImageFormat determineFormat(byte[] bArr, int i);

        int getHeaderSize();
    }

    public ImageFormat(String str, String str2) {
        this.mName = str;
        this.mFileExtension = str2;
    }

    public String getFileExtension() {
        return this.mFileExtension;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}

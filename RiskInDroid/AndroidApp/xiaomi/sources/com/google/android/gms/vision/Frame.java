package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame {
    /* access modifiers changed from: private */
    public Bitmap mBitmap;
    private Metadata zzam;
    /* access modifiers changed from: private */
    public ByteBuffer zzan;

    public static class Builder {
        private Frame zzao = new Frame();

        public Frame build() {
            if (this.zzao.zzan != null || this.zzao.mBitmap != null) {
                return this.zzao;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public Builder setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap unused = this.zzao.mBitmap = bitmap;
            Metadata metadata = this.zzao.getMetadata();
            int unused2 = metadata.zzap = width;
            int unused3 = metadata.zzaq = height;
            return this;
        }

        public Builder setId(int i) {
            int unused = this.zzao.getMetadata().mId = i;
            return this;
        }

        public Builder setImageData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (byteBuffer.capacity() < i * i2) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else if (i3 == 16 || i3 == 17 || i3 == 842094169) {
                ByteBuffer unused = this.zzao.zzan = byteBuffer;
                Metadata metadata = this.zzao.getMetadata();
                int unused2 = metadata.zzap = i;
                int unused3 = metadata.zzaq = i2;
                int unused4 = metadata.format = i3;
                return this;
            } else {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unsupported image format: ");
                sb.append(i3);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public Builder setRotation(int i) {
            int unused = this.zzao.getMetadata().zzg = i;
            return this;
        }

        public Builder setTimestampMillis(long j) {
            long unused = this.zzao.getMetadata().zzar = j;
            return this;
        }
    }

    public static class Metadata {
        /* access modifiers changed from: private */
        public int format = -1;
        /* access modifiers changed from: private */
        public int mId;
        /* access modifiers changed from: private */
        public int zzap;
        /* access modifiers changed from: private */
        public int zzaq;
        /* access modifiers changed from: private */
        public long zzar;
        /* access modifiers changed from: private */
        public int zzg;

        public Metadata() {
        }

        public Metadata(Metadata metadata) {
            this.zzap = metadata.getWidth();
            this.zzaq = metadata.getHeight();
            this.mId = metadata.getId();
            this.zzar = metadata.getTimestampMillis();
            this.zzg = metadata.getRotation();
        }

        public int getFormat() {
            return this.format;
        }

        public int getHeight() {
            return this.zzaq;
        }

        public int getId() {
            return this.mId;
        }

        public int getRotation() {
            return this.zzg;
        }

        public long getTimestampMillis() {
            return this.zzar;
        }

        public int getWidth() {
            return this.zzap;
        }

        public final void zzd() {
            if (this.zzg % 2 != 0) {
                int i = this.zzap;
                this.zzap = this.zzaq;
                this.zzaq = i;
            }
            this.zzg = 0;
        }
    }

    private Frame() {
        this.zzam = new Metadata();
        this.zzan = null;
        this.mBitmap = null;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ByteBuffer getGrayscaleImageData() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return this.zzan;
        }
        int width = bitmap.getWidth();
        int height = this.mBitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        this.mBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            bArr[i2] = (byte) ((int) ((((float) Color.red(iArr[i2])) * 0.299f) + (((float) Color.green(iArr[i2])) * 0.587f) + (((float) Color.blue(iArr[i2])) * 0.114f)));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Metadata getMetadata() {
        return this.zzam;
    }
}

package com.google.android.gms.vision.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzaa;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.internal.vision.zzt;
import com.google.android.gms.internal.vision.zzv;
import com.google.android.gms.internal.vision.zzz;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class TextRecognizer extends Detector<TextBlock> {
    private final zzz zzda;

    public static class Builder {
        private Context mContext;
        private zzaa zzdb = new zzaa();

        public Builder(Context context) {
            this.mContext = context;
        }

        public TextRecognizer build() {
            return new TextRecognizer(new zzz(this.mContext, this.zzdb));
        }
    }

    private TextRecognizer() {
        throw new IllegalStateException("Default constructor called");
    }

    private TextRecognizer(zzz zzz) {
        this.zzda = zzz;
    }

    public final SparseArray<TextBlock> detect(Frame frame) {
        Bitmap bitmap;
        byte[] bArr;
        zzv zzv = new zzv(new Rect());
        if (frame != null) {
            zzk zzc = zzk.zzc(frame);
            if (frame.getBitmap() != null) {
                bitmap = frame.getBitmap();
            } else {
                Frame.Metadata metadata = frame.getMetadata();
                ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
                int format = metadata.getFormat();
                int i = zzc.width;
                int i2 = zzc.height;
                if (!grayscaleImageData.hasArray() || grayscaleImageData.arrayOffset() != 0) {
                    byte[] bArr2 = new byte[grayscaleImageData.capacity()];
                    grayscaleImageData.get(bArr2);
                    bArr = bArr2;
                } else {
                    bArr = grayscaleImageData.array();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(bArr, format, i, i2, null).compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            Bitmap zzb = zzm.zzb(bitmap, zzc);
            if (!zzv.zzdm.isEmpty()) {
                Rect rect = zzv.zzdm;
                int width = frame.getMetadata().getWidth();
                int height = frame.getMetadata().getHeight();
                int i3 = zzc.rotation;
                zzv.zzdm.set(i3 != 1 ? i3 != 2 ? i3 != 3 ? rect : new Rect(rect.top, width - rect.right, rect.bottom, width - rect.left) : new Rect(width - rect.right, height - rect.bottom, width - rect.left, height - rect.top) : new Rect(height - rect.bottom, rect.left, height - rect.top, rect.right));
            }
            zzc.rotation = 0;
            zzt[] zza = this.zzda.zza(zzb, zzc, zzv);
            SparseArray sparseArray = new SparseArray();
            for (zzt zzt : zza) {
                SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzt.zzdk);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    sparseArray.append(zzt.zzdk, sparseArray2);
                }
                sparseArray2.append(zzt.zzdl, zzt);
            }
            SparseArray<TextBlock> sparseArray3 = new SparseArray<>(sparseArray.size());
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                sparseArray3.append(sparseArray.keyAt(i4), new TextBlock((SparseArray) sparseArray.valueAt(i4)));
            }
            return sparseArray3;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean isOperational() {
        return this.zzda.isOperational();
    }

    public final void release() {
        super.release();
        this.zzda.zzg();
    }
}

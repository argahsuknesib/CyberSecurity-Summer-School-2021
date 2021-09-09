package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class JpegTranscoder {
    public static boolean isExifOrientationAllowed(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return true;
            default:
                return false;
        }
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    static {
        ImagePipelineNativeLoader.load();
    }

    public static boolean isRotationAngleAllowed(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    public static void transcodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z = true;
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i2 <= 16);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i3 <= 100);
        Preconditions.checkArgument(isRotationAngleAllowed(i));
        if (i2 == 8 && i == 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "no transformation requested");
        nativeTranscodeJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
    }

    public static void transcodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z = false;
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i2 <= 16);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i3 <= 100);
        Preconditions.checkArgument(isExifOrientationAllowed(i));
        if (!(i2 == 8 && i == 1)) {
            z = true;
        }
        Preconditions.checkArgument(z, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
    }
}

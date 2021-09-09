package _m_j;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.view.Surface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class fzt {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f17449O000000o = false;
    private final int O00000Oo;
    private final int O00000o;
    private final File O00000o0;
    private final fzq<Bitmap> O00000oO;
    private final fzs O00000oo;
    private MediaCodec O0000O0o;
    private boolean O0000OOo = true;
    private int O0000Oo = 0;
    private MediaMuxer O0000Oo0;
    private boolean O0000OoO = false;
    private int O0000Ooo;

    public fzt(fzq<Bitmap> fzq, int i, File file, int i2, fzs fzs) {
        this.O00000Oo = i;
        this.O00000o0 = file;
        this.O00000o = i2;
        this.O00000oO = fzq;
        this.O00000oo = fzs;
    }

    public final void O000000o() {
        while (this.O0000OOo) {
            try {
                if (this.O00000oO.O000000o() > 0) {
                    this.O00000oo.O000000o(1);
                    Bitmap O00000Oo2 = this.O00000oO.O00000Oo();
                    if (O00000Oo2 != null) {
                        int width = (O00000Oo2.getWidth() / 4) * 4;
                        int height = (O00000Oo2.getHeight() / 4) * 4;
                        int i = this.O00000o;
                        if (this.O00000o == 0) {
                            i = width * height;
                        }
                        int codecCount = MediaCodecList.getCodecCount();
                        MediaCodecInfo mediaCodecInfo = null;
                        for (int i2 = 0; i2 < codecCount && mediaCodecInfo == null; i2++) {
                            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                            if (codecInfoAt.isEncoder()) {
                                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                                boolean z = false;
                                for (int i3 = 0; i3 < supportedTypes.length && !z; i3++) {
                                    if (supportedTypes[i3].equals("video/avc")) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    mediaCodecInfo = codecInfoAt;
                                }
                            }
                        }
                        gsy.O00000Oo("MeidaCodec", "found" + mediaCodecInfo.getName() + "supporting video/avc");
                        int[] iArr = mediaCodecInfo.getCapabilitiesForType("video/avc").colorFormats;
                        int length = iArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                int i5 = iArr[i4];
                                if (i5 != 39) {
                                    switch (i5) {
                                        case 19:
                                            this.O0000Ooo = i5;
                                            break;
                                        case 20:
                                            this.O0000Ooo = i5;
                                            break;
                                        case 21:
                                            this.O0000Ooo = i5;
                                            break;
                                        default:
                                            i4++;
                                    }
                                } else {
                                    this.O0000Ooo = i5;
                                }
                            }
                        }
                        if (this.O0000Ooo <= 0) {
                            this.O0000Ooo = 21;
                        }
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", width, height);
                        createVideoFormat.setInteger("color-format", this.O0000Ooo);
                        createVideoFormat.setInteger("bitrate", i);
                        createVideoFormat.setInteger("frame-rate", this.O00000Oo);
                        createVideoFormat.setInteger("i-frame-interval", 10);
                        try {
                            this.O0000O0o = MediaCodec.createEncoderByType("video/avc");
                            this.O0000Oo0 = new MediaMuxer(this.O00000o0.getAbsolutePath(), 0);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        this.O0000O0o.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.O0000O0o.start();
                        this.f17449O000000o = true;
                        this.O00000oo.O000000o(2);
                        O000000o(O00000Oo2);
                        this.O0000OOo = false;
                    }
                }
            } catch (Exception unused) {
                this.O0000OOo = false;
                this.f17449O000000o = false;
                MediaCodec mediaCodec = this.O0000O0o;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    this.O0000O0o.release();
                }
                MediaMuxer mediaMuxer = this.O0000Oo0;
                if (mediaMuxer != null) {
                    try {
                        if (this.O0000OoO) {
                            mediaMuxer.stop();
                            this.O0000Oo0.release();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                fzq<Bitmap> fzq = this.O00000oO;
                if (fzq instanceof fzr) {
                    ((fzr) fzq).O00000o0();
                }
                this.O00000oo.O000000o(100);
                return;
            }
        }
    }

    private byte[] O000000o(int i, int i2, Bitmap bitmap) {
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        int i7 = i5 * i6;
        int[] iArr = new int[i7];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        byte[] bArr = new byte[((i7 * 3) / 2)];
        int i8 = this.O0000Ooo;
        int i9 = 65280;
        int i10 = 16711680;
        int i11 = 255;
        int i12 = 0;
        if (i8 != 39) {
            switch (i8) {
                case 19:
                    int i13 = (i7 / 4) + i7;
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    while (i14 < i6) {
                        int i17 = i13;
                        int i18 = i15;
                        int i19 = 0;
                        while (i19 < i5) {
                            int i20 = (iArr[i16] & 16711680) >> 16;
                            int i21 = (iArr[i16] & 65280) >> 8;
                            int i22 = (iArr[i16] & i11) >> 0;
                            int i23 = (((((i20 * 66) + (i21 * 129)) + (i22 * 25)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + 16;
                            int i24 = (((((i20 * -38) - (i21 * 74)) + (i22 * 112)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                            int i25 = (((((i20 * 112) - (i21 * 94)) - (i22 * 18)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                            int i26 = i18 + 1;
                            if (i23 < 0) {
                                i23 = 0;
                            } else if (i23 > 255) {
                                i23 = 255;
                            }
                            bArr[i18] = (byte) i23;
                            if (i14 % 2 == 0 && i16 % 2 == 0) {
                                int i27 = i17 + 1;
                                if (i25 < 0) {
                                    i4 = 255;
                                    i25 = 0;
                                } else {
                                    i4 = 255;
                                    if (i25 > 255) {
                                        i25 = 255;
                                    }
                                }
                                bArr[i17] = (byte) i25;
                                int i28 = i7 + 1;
                                if (i24 < 0) {
                                    i24 = 0;
                                } else if (i24 > i4) {
                                    i24 = 255;
                                }
                                bArr[i7] = (byte) i24;
                                i7 = i28;
                                i17 = i27;
                            }
                            i16++;
                            i19++;
                            i18 = i26;
                            i11 = 255;
                        }
                        i14++;
                        i15 = i18;
                        i13 = i17;
                        i11 = 255;
                    }
                    break;
                case 20:
                    int length = bArr.length / 2;
                    int i29 = 0;
                    int i30 = 0;
                    int i31 = 0;
                    while (i29 < i6) {
                        int i32 = length;
                        int i33 = i30;
                        for (int i34 = 0; i34 < i5; i34++) {
                            int i35 = (iArr[i31] & 16711680) >> 16;
                            int i36 = (iArr[i31] & 65280) >> 8;
                            int i37 = (iArr[i31] & 255) >> 0;
                            int i38 = (((((i35 * 66) + (i36 * 129)) + (i37 * 25)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + 16;
                            int i39 = (((((i35 * -38) - (i36 * 74)) + (i37 * 112)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                            int i40 = (((((i35 * 112) - (i36 * 94)) - (i37 * 18)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                            int i41 = i29 % 2;
                            if (i41 == 0 && i31 % 2 == 0) {
                                int i42 = i33 + 1;
                                if (i38 < 0) {
                                    i38 = 0;
                                } else if (i38 > 255) {
                                    i38 = 255;
                                }
                                bArr[i33] = (byte) i38;
                                i33 = i42 + 1;
                                if (i39 < 0) {
                                    i39 = 0;
                                } else if (i39 > 255) {
                                    i39 = 255;
                                }
                                bArr[i33] = (byte) i39;
                                int i43 = i32 + 1;
                                if (i40 < 0) {
                                    i40 = 0;
                                } else if (i40 > 255) {
                                    i40 = 255;
                                }
                                bArr[i43] = (byte) i40;
                            } else if (i41 == 0 && i31 % 2 == 1) {
                                int i44 = i33 + 1;
                                if (i38 < 0) {
                                    i38 = 0;
                                } else if (i38 > 255) {
                                    i38 = 255;
                                }
                                bArr[i33] = (byte) i38;
                                i33 = i44;
                            } else if (i41 == 1 && i31 % 2 == 0) {
                                int i45 = i32 + 1;
                                if (i38 < 0) {
                                    i38 = 0;
                                } else if (i38 > 255) {
                                    i38 = 255;
                                }
                                bArr[i32] = (byte) i38;
                                i32 = i45 + 1;
                            } else if (i41 == 1 && i31 % 2 == 1) {
                                int i46 = i32 + 1;
                                if (i38 < 0) {
                                    i38 = 0;
                                } else if (i38 > 255) {
                                    i38 = 255;
                                }
                                bArr[i32] = (byte) i38;
                                i32 = i46;
                            }
                            i31++;
                        }
                        i29++;
                        i30 = i33;
                        length = i32;
                    }
                    break;
                case 21:
                    int i47 = i7;
                    int i48 = 0;
                    int i49 = 0;
                    int i50 = 0;
                    while (i48 < i6) {
                        int i51 = i47;
                        int i52 = i49;
                        int i53 = 0;
                        while (i53 < i5) {
                            int i54 = (iArr[i50] & i10) >> 16;
                            int i55 = (iArr[i50] & i9) >> 8;
                            int i56 = (iArr[i50] & 255) >> i12;
                            int i57 = (((((i54 * 66) + (i55 * 129)) + (i56 * 25)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + 16;
                            int i58 = (((((i54 * -38) - (i55 * 74)) + (i56 * 112)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                            int i59 = (((((i54 * 112) - (i55 * 94)) - (i56 * 18)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                            int i60 = i52 + 1;
                            if (i57 < 0) {
                                i57 = 0;
                            } else if (i57 > 255) {
                                i57 = 255;
                            }
                            bArr[i52] = (byte) i57;
                            if (i48 % 2 == 0 && i50 % 2 == 0) {
                                int i61 = i51 + 1;
                                if (i58 < 0) {
                                    i58 = 0;
                                } else if (i58 > 255) {
                                    i58 = 255;
                                }
                                bArr[i51] = (byte) i58;
                                i51 = i61 + 1;
                                if (i59 < 0) {
                                    i59 = 0;
                                } else if (i59 > 255) {
                                    i59 = 255;
                                }
                                bArr[i61] = (byte) i59;
                            }
                            i50++;
                            i53++;
                            i52 = i60;
                            i9 = 65280;
                            i10 = 16711680;
                            i12 = 0;
                        }
                        i48++;
                        i49 = i52;
                        i47 = i51;
                        i9 = 65280;
                        i10 = 16711680;
                        i12 = 0;
                    }
                    break;
            }
        } else {
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            while (i62 < i6) {
                int i65 = i63;
                for (int i66 = 0; i66 < i5; i66++) {
                    int i67 = (iArr[i64] & 16711680) >> 16;
                    int i68 = (iArr[i64] & 65280) >> 8;
                    int i69 = (iArr[i64] & 255) >> 0;
                    int i70 = (((((i67 * 66) + (i68 * 129)) + (i69 * 25)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + 16;
                    int i71 = (((((i67 * -38) - (i68 * 74)) + (i69 * 112)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                    int i72 = (((((i67 * 112) - (i68 * 94)) - (i69 * 18)) + NotificationCompat.FLAG_HIGH_PRIORITY) >> 8) + NotificationCompat.FLAG_HIGH_PRIORITY;
                    int i73 = i65 + 1;
                    if (i70 < 0) {
                        i70 = 0;
                    } else if (i70 > 255) {
                        i70 = 255;
                    }
                    bArr[i65] = (byte) i70;
                    if (i62 % 2 == 0 && i64 % 2 == 0) {
                        int i74 = i73 + 1;
                        if (i71 < 0) {
                            i3 = 255;
                            i71 = 0;
                        } else {
                            i3 = 255;
                            if (i71 > 255) {
                                i71 = 255;
                            }
                        }
                        bArr[i74] = (byte) i71;
                        int i75 = i73 + 3;
                        if (i72 < 0) {
                            i72 = 0;
                        } else if (i72 > i3) {
                            i72 = 255;
                        }
                        bArr[i75] = (byte) i72;
                    }
                    if (i64 % 2 == 0) {
                        i73++;
                    }
                    i65 = i73;
                    i64++;
                }
                i62++;
                i63 = i65;
            }
        }
        return bArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    private void O000000o(boolean z, MediaCodec.BufferInfo bufferInfo) {
        ByteBuffer byteBuffer;
        ByteBuffer[] outputBuffers = Build.VERSION.SDK_INT <= 21 ? this.O0000O0o.getOutputBuffers() : null;
        if (z) {
            try {
                this.O0000O0o.signalEndOfInputStream();
            } catch (Exception unused) {
            }
        }
        while (true) {
            int dequeueOutputBuffer = this.O0000O0o.dequeueOutputBuffer(bufferInfo, 10000);
            if (dequeueOutputBuffer == -1) {
                if (z) {
                    gsy.O00000Oo("MeidaCodec", "no output available, spinning to await EOS");
                } else {
                    return;
                }
            } else if (dequeueOutputBuffer == -2) {
                if (!this.O0000OoO) {
                    this.O0000Oo = this.O0000Oo0.addTrack(this.O0000O0o.getOutputFormat());
                    this.O0000Oo0.start();
                    this.O0000OoO = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                gsy.O00000Oo("MeidaCodec", "unexpected result from encoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
            } else {
                if (Build.VERSION.SDK_INT <= 21) {
                    byteBuffer = outputBuffers[dequeueOutputBuffer];
                } else {
                    byteBuffer = this.O0000O0o.getOutputBuffer(dequeueOutputBuffer);
                }
                if (byteBuffer != null) {
                    if ((bufferInfo.flags & 2) != 0) {
                        gsy.O00000Oo("MeidaCodec", "ignoring BUFFER_FLAG_CODEC_CONFIG");
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size != 0) {
                        if (this.O0000OoO) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            gsy.O00000Oo("MeidaCodec", "BufferInfo: " + bufferInfo.offset + "," + bufferInfo.size + "," + bufferInfo.presentationTimeUs);
                            try {
                                this.O0000Oo0.writeSampleData(this.O0000Oo, byteBuffer, bufferInfo);
                            } catch (Exception unused2) {
                                gsy.O00000Oo("MeidaCodec", "Too many frames");
                            }
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.O0000O0o.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        if (!z) {
                            gsy.O00000Oo("MeidaCodec", "reached end of stream unexpectedly");
                            return;
                        } else {
                            gsy.O00000Oo("MeidaCodec", "end of stream reached");
                            return;
                        }
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    private void O000000o(Bitmap bitmap) {
        ByteBuffer[] byteBufferArr;
        Bitmap bitmap2;
        ByteBuffer byteBuffer;
        this.f17449O000000o = true;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j = 0;
        if (Build.VERSION.SDK_INT <= 21) {
            bitmap2 = bitmap;
            byteBufferArr = this.O0000O0o.getInputBuffers();
        } else {
            bitmap2 = bitmap;
            byteBufferArr = null;
        }
        while (this.f17449O000000o) {
            int dequeueInputBuffer = this.O0000O0o.dequeueInputBuffer(10000);
            if (dequeueInputBuffer >= 0) {
                long j2 = j;
                long j3 = ((1000000 * j) / ((long) this.O00000Oo)) + 132;
                if (this.O00000oO.O000000o() <= 0) {
                    this.O0000O0o.queueInputBuffer(dequeueInputBuffer, 0, 0, j3, 4);
                    O000000o(true, bufferInfo);
                    this.f17449O000000o = false;
                } else {
                    if (bitmap2 == null) {
                        bitmap2 = this.O00000oO.O00000Oo();
                    }
                    byte[] O000000o2 = O000000o((bitmap2.getWidth() / 4) * 4, (bitmap2.getHeight() / 4) * 4, bitmap2);
                    fzq<Bitmap> fzq = this.O00000oO;
                    if (fzq instanceof fzr) {
                        ((fzr) fzq).O000000o(bitmap2);
                    }
                    if (Build.VERSION.SDK_INT <= 21) {
                        byteBuffer = byteBufferArr[dequeueInputBuffer];
                    } else {
                        byteBuffer = this.O0000O0o.getInputBuffer(dequeueInputBuffer);
                    }
                    byteBuffer.clear();
                    byteBuffer.put(O000000o2);
                    this.O0000O0o.queueInputBuffer(dequeueInputBuffer, 0, O000000o2.length, j3, 0);
                    O000000o(false, bufferInfo);
                    bitmap2 = null;
                }
                this.O00000oo.O000000o(((int) ((j2 * 96) / ((long) this.O00000oO.O000000o()))) + 2);
                j = j2 + 1;
            } else {
                long j4 = j;
                gsy.O00000Oo("MeidaCodec", "input buffer not available.");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                j = j4;
            }
        }
    }
}

package _m_j;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.support.v4.app.NotificationCompat;
import android.view.Surface;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@TargetApi(16)
public class fye {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17404O000000o;
    MediaCodec O00000Oo;
    MediaExtractor O00000o;
    MediaCodec O00000o0;
    ByteBuffer[] O00000oO;
    ByteBuffer[] O00000oo;
    ByteBuffer[] O0000O0o;
    ByteBuffer[] O0000OOo;
    MediaCodec.BufferInfo O0000Oo;
    MediaCodec.BufferInfo O0000Oo0;
    BufferedOutputStream O0000OoO;
    public ArrayList<byte[]> O0000Ooo;
    private String O0000o;
    public long O0000o0;
    public O00000o0 O0000o00;
    public long O0000o0O;
    public boolean O0000o0o = false;
    private FileOutputStream O0000oO;
    private String O0000oO0;
    private O00000o O0000oOO;

    public interface O00000o {
    }

    public interface O00000o0 {
        void O000000o();
    }

    public final void O000000o(String str, String str2) {
        this.O0000o = str;
        this.O0000oO0 = str2;
    }

    public final void O000000o() {
        if (this.f17404O000000o == null) {
            throw new IllegalArgumentException("encodeType can't be null");
        } else if (this.O0000o != null) {
            String str = this.O0000oO0;
            if (str != null) {
                try {
                    this.O0000oO = new FileOutputStream(new File(str));
                    this.O0000OoO = new BufferedOutputStream(this.O0000oO, 204800);
                    this.O0000o0 = new File(this.O0000o).length();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.O0000Ooo = new ArrayList<>();
                O00000oO();
                try {
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.f17404O000000o, 44100, 2);
                    createAudioFormat.setInteger("bitrate", 96000);
                    createAudioFormat.setInteger("aac-profile", 2);
                    createAudioFormat.setInteger("max-input-size", 102400);
                    this.O00000o0 = MediaCodec.createEncoderByType(this.f17404O000000o);
                    this.O00000o0.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                MediaCodec mediaCodec = this.O00000o0;
                if (mediaCodec == null) {
                    gsy.O000000o(6, "AudioConvert", "create mediaEncode failed");
                    return;
                }
                this.O0000O0o = mediaCodec.getInputBuffers();
                this.O0000OOo = this.O00000o0.getOutputBuffers();
                this.O0000Oo = new MediaCodec.BufferInfo();
                this.O00000o0.start();
                return;
            }
            throw new IllegalArgumentException("dstPath can't be null");
        } else {
            throw new IllegalArgumentException("srcPath can't be null");
        }
    }

    private void O00000oO() {
        try {
            this.O00000o = new MediaExtractor();
            this.O00000o.setDataSource(this.O0000o);
            int i = 0;
            while (true) {
                if (i >= this.O00000o.getTrackCount()) {
                    break;
                }
                MediaFormat trackFormat = this.O00000o.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string.startsWith("audio")) {
                    this.O00000o.selectTrack(i);
                    this.O00000Oo = MediaCodec.createDecoderByType(string);
                    this.O00000Oo.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                    break;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaCodec mediaCodec = this.O00000Oo;
        if (mediaCodec == null) {
            gsy.O000000o(6, "AudioConvert", "create mediaDecode failed");
            return;
        }
        mediaCodec.start();
        this.O00000oO = this.O00000Oo.getInputBuffers();
        this.O00000oo = this.O00000Oo.getOutputBuffers();
        this.O0000Oo0 = new MediaCodec.BufferInfo();
        O000000o("buffers:" + this.O00000oO.length);
    }

    public final void O00000Oo() {
        O000000o("start");
        new Thread(new O000000o(this, (byte) 0)).start();
        new Thread(new O00000Oo(this, (byte) 0)).start();
    }

    /* access modifiers changed from: package-private */
    public final byte[] O00000o0() {
        synchronized (fye.class) {
            O000000o("getPCM:" + this.O0000Ooo.size());
            if (this.O0000Ooo.isEmpty()) {
                return null;
            }
            byte[] bArr = this.O0000Ooo.get(0);
            this.O0000Ooo.remove(bArr);
            return bArr;
        }
    }

    public final void O00000o() {
        try {
            if (this.O0000OoO != null) {
                this.O0000OoO.flush();
            }
            BufferedOutputStream bufferedOutputStream = this.O0000OoO;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    this.O0000OoO = null;
                    throw th;
                }
                this.O0000OoO = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            BufferedOutputStream bufferedOutputStream2 = this.O0000OoO;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (Throwable th2) {
                    this.O0000OoO = null;
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            BufferedOutputStream bufferedOutputStream3 = this.O0000OoO;
            if (bufferedOutputStream3 != null) {
                try {
                    bufferedOutputStream3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                } catch (Throwable th4) {
                    this.O0000OoO = null;
                    throw th4;
                }
                this.O0000OoO = null;
            }
            throw th3;
        }
        try {
            if (this.O0000oO != null) {
                this.O0000oO.close();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (Throwable th5) {
            this.O0000oO = null;
            throw th5;
        }
        this.O0000oO = null;
        MediaCodec mediaCodec = this.O00000o0;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.O00000o0.release();
            this.O00000o0 = null;
        }
        MediaCodec mediaCodec2 = this.O00000Oo;
        if (mediaCodec2 != null) {
            mediaCodec2.stop();
            this.O00000Oo.release();
            this.O00000Oo = null;
        }
        MediaExtractor mediaExtractor = this.O00000o;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.O00000o = null;
        }
        if (this.O0000o00 != null) {
            this.O0000o00 = null;
        }
        if (this.O0000oOO != null) {
            this.O0000oOO = null;
        }
        O000000o("release");
    }

    class O000000o implements Runnable {
        private O000000o() {
        }

        /* synthetic */ O000000o(fye fye, byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
         arg types: [int, int]
         candidates:
          ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
          ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
        public final void run() {
            while (!fye.this.O0000o0o) {
                fye fye = fye.this;
                int i = 0;
                while (true) {
                    if (i < fye.O00000oO.length - 1) {
                        int dequeueInputBuffer = fye.O00000Oo.dequeueInputBuffer(-1);
                        if (dequeueInputBuffer < 0) {
                            fye.O0000o0o = true;
                            break;
                        }
                        ByteBuffer byteBuffer = fye.O00000oO[dequeueInputBuffer];
                        byteBuffer.clear();
                        int readSampleData = fye.O00000o.readSampleData(byteBuffer, 0);
                        if (readSampleData < 0) {
                            fye.O0000o0o = true;
                        } else {
                            fye.O00000Oo.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, 0, 0);
                            fye.O00000o.advance();
                            fye.O0000o0O += (long) readSampleData;
                        }
                        i++;
                    } else {
                        for (int dequeueOutputBuffer = fye.O00000Oo.dequeueOutputBuffer(fye.O0000Oo0, 10000); dequeueOutputBuffer >= 0; dequeueOutputBuffer = fye.O00000Oo.dequeueOutputBuffer(fye.O0000Oo0, 10000)) {
                            ByteBuffer byteBuffer2 = fye.O00000oo[dequeueOutputBuffer];
                            byte[] bArr = new byte[fye.O0000Oo0.size];
                            byteBuffer2.get(bArr);
                            byteBuffer2.clear();
                            synchronized (fye.class) {
                                fye.O0000Ooo.add(bArr);
                            }
                            fye.O00000Oo.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                        continue;
                    }
                }
            }
        }
    }

    class O00000Oo implements Runnable {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(fye fye, byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
         arg types: [int, int]
         candidates:
          ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
          ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
        public final void run() {
            byte[] O00000o0;
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                if (fye.this.O0000o0o && fye.this.O0000Ooo.isEmpty()) {
                    break;
                }
                fye fye = fye.this;
                for (int i = 0; i < fye.O0000O0o.length - 1 && (O00000o0 = fye.O00000o0()) != null; i++) {
                    int dequeueInputBuffer = fye.O00000o0.dequeueInputBuffer(-1);
                    ByteBuffer byteBuffer = fye.O0000O0o[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.limit(O00000o0.length);
                    byteBuffer.put(O00000o0);
                    fye.O00000o0.queueInputBuffer(dequeueInputBuffer, 0, O00000o0.length, 0, 0);
                }
                for (int dequeueOutputBuffer = fye.O00000o0.dequeueOutputBuffer(fye.O0000Oo, 10000); dequeueOutputBuffer >= 0; dequeueOutputBuffer = fye.O00000o0.dequeueOutputBuffer(fye.O0000Oo, 10000)) {
                    int i2 = fye.O0000Oo.size;
                    int i3 = i2 + 7;
                    ByteBuffer byteBuffer2 = fye.O0000OOo[dequeueOutputBuffer];
                    byteBuffer2.position(fye.O0000Oo.offset);
                    byteBuffer2.limit(fye.O0000Oo.offset + i2);
                    byte[] bArr = new byte[i3];
                    bArr[0] = -1;
                    bArr[1] = -7;
                    bArr[2] = 80;
                    bArr[3] = (byte) ((i3 >> 11) + NotificationCompat.FLAG_HIGH_PRIORITY);
                    bArr[4] = (byte) ((i3 & 2047) >> 3);
                    bArr[5] = (byte) (((i3 & 7) << 5) + 31);
                    bArr[6] = -4;
                    byteBuffer2.get(bArr, 7, i2);
                    byteBuffer2.position(fye.O0000Oo.offset);
                    try {
                        fye.O0000OoO.write(bArr, 0, bArr.length);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fye.O00000o0.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
            if (fye.this.O0000o00 != null) {
                fye.this.O0000o00.O000000o();
            }
            fye.O000000o("size:" + fye.this.O0000o0 + " decodeSize:" + fye.this.O0000o0O + "time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static void O000000o(String str) {
        gsy.O000000o(6, "AudioCodec", str);
    }
}

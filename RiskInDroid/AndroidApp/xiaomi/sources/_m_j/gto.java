package _m_j;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Parcel;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.xiaomi.smarthome.camera.VideoFrame;
import java.io.IOException;
import java.io.InputStream;

public final class gto extends gtp {

    /* renamed from: O000000o  reason: collision with root package name */
    LocalSocket f18266O000000o;
    private LocalServerSocket O00000o;
    private byte[] O00000oO = new byte[ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES];
    private String O00000oo;
    private long O0000O0o;

    /* access modifiers changed from: protected */
    public final void O000000o() {
        try {
            gsy.O000000o(6, "receiver_thread", "Create Socket before:camera_host" + this.O00000oo);
            this.O00000o = new LocalServerSocket("camera_host" + this.O00000oo);
            this.f18266O000000o = this.O00000o.accept();
            gsy.O000000o(6, "receiver_thread", "Create Socket after:camera_host" + this.O00000oo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        try {
            if (this.f18266O000000o == null) {
                try {
                    if (this.f18266O000000o != null) {
                        this.f18266O000000o.close();
                    }
                    if (this.O00000o != null) {
                        this.O00000o.close();
                    }
                    this.O00000o = new LocalServerSocket("camera_host" + this.O00000oo);
                    this.f18266O000000o = this.O00000o.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                InputStream inputStream = this.f18266O000000o.getInputStream();
                byte[] bArr = new byte[4];
                int read = inputStream.read(bArr, 0, 4);
                if (read == -1) {
                    try {
                        this.f18266O000000o.close();
                        this.O00000o.close();
                    } catch (IOException unused) {
                    }
                    this.f18266O000000o = null;
                } else if (read == 4) {
                    Parcel obtain = Parcel.obtain();
                    this.O0000O0o = System.currentTimeMillis();
                    byte b = ((bArr[3] & 255) << 24) | (bArr[0] & 255) | 0 | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
                    int i = 0;
                    do {
                        int i2 = b - i;
                        if (i2 > this.O00000oO.length) {
                            i2 = this.O00000oO.length;
                        }
                        int read2 = inputStream.read(this.O00000oO, 0, i2);
                        if (read2 == -1) {
                            break;
                        }
                        obtain.unmarshall(this.O00000oO, 0, read2);
                        i += read2;
                    } while (i < b);
                    obtain.setDataPosition(0);
                    String readString = obtain.readString();
                    int readInt = obtain.readInt();
                    int readInt2 = obtain.readInt();
                    long readLong = obtain.readLong();
                    int readInt3 = obtain.readInt();
                    long readLong2 = obtain.readLong();
                    int readInt4 = obtain.readInt();
                    boolean z = obtain.readInt() == 1;
                    if (readInt3 <= 0) {
                        return;
                    }
                    if (readInt3 <= 2097152) {
                        byte[] bArr2 = new byte[readInt3];
                        try {
                            obtain.readByteArray(bArr2);
                            VideoFrame videoFrame = new VideoFrame(bArr2, readLong, readInt3, readInt, readInt2, readLong2, readInt4, z);
                            if (!(readString == null || this.O00000o0 == null)) {
                                this.O00000o0.O000000o(readString, videoFrame);
                            }
                            obtain.recycle();
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        gsy.O000000o(6, "receiver_thread", "Release Socket:camera_host" + this.O00000oo);
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        try {
            gsy.O000000o(6, "receiver_thread", "interrupt Socket:camera_host" + this.O00000oo);
            if (this.f18266O000000o != null) {
                if (this.f18266O000000o != null) {
                    this.f18266O000000o.close();
                }
                if (this.O00000o != null) {
                    this.O00000o.close();
                    return;
                }
                return;
            }
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress("camera_host" + this.O00000oo));
            localSocket.close();
            if (this.O00000o != null) {
                this.O00000o.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public gto(String str) {
        this.O00000oo = str;
    }
}

package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public final class iab {
    private static iab O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    InetAddress[] f1067O000000o;
    public int O00000Oo = 0;
    public int O00000o = 0;
    public int O00000o0 = 0;
    public int O00000oO = 0;
    public O00000Oo O00000oo;
    public HandlerThread O0000O0o = new gpq("process_network2");
    public O000000o O0000OOo;
    private Handler O0000Oo = new Handler() {
        /* class _m_j.iab.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                if (i == 4 && iab.this.O0000OOo != null) {
                    iab.this.O0000OOo.O000000o(message.arg1);
                }
            } else if (iab.this.O0000OOo != null) {
                iab.this.O0000OOo.O000000o();
            }
        }
    };

    public interface O000000o {
        void O000000o();

        void O000000o(int i);
    }

    public class O00000Oo extends Handler {
        public O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            char c;
            int i;
            int i2 = message.what;
            if (i2 != 1) {
                c = 4;
                if (i2 != 2) {
                    if (i2 == 5) {
                        if (iab.this.O00000Oo()) {
                            iab.this.O000000o(true, 3, 0);
                            return;
                        } else {
                            iab.this.O000000o(false, 4, 2);
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (iab.this.O00000Oo < 3 && iab.this.O00000o < 2) {
                    iab iab = iab.this;
                    i = 0;
                    while (i < iab.f1067O000000o.length) {
                        try {
                            DatagramSocket datagramSocket = new DatagramSocket();
                            byte[] bArr = new byte[32];
                            bArr[0] = 49;
                            bArr[1] = 33;
                            bArr[2] = 0;
                            bArr[3] = 32;
                            bArr[c] = -1;
                            bArr[5] = -1;
                            bArr[6] = -1;
                            bArr[7] = -1;
                            bArr[8] = -1;
                            bArr[9] = -1;
                            bArr[10] = -1;
                            bArr[11] = -1;
                            bArr[12] = 0;
                            bArr[13] = 0;
                            bArr[14] = 0;
                            bArr[15] = 0;
                            bArr[16] = 0;
                            bArr[17] = 0;
                            bArr[18] = 0;
                            bArr[19] = 0;
                            bArr[20] = 0;
                            bArr[21] = 0;
                            bArr[22] = 0;
                            bArr[23] = 0;
                            bArr[24] = 0;
                            bArr[25] = 0;
                            bArr[26] = 0;
                            bArr[27] = 0;
                            bArr[28] = 0;
                            bArr[29] = 0;
                            bArr[30] = 0;
                            bArr[31] = 1;
                            DatagramPacket datagramPacket = new DatagramPacket(bArr, 32, iab.f1067O000000o[i], 8053);
                            DatagramPacket datagramPacket2 = new DatagramPacket(new byte[32], 32);
                            datagramSocket.setSoTimeout(1000);
                            datagramSocket.send(datagramPacket);
                            datagramSocket.receive(datagramPacket2);
                            iab.O00000Oo++;
                            iab.O00000o = 0;
                            iab.O000000o(true, 2, 0);
                            return;
                        } catch (SocketException unused) {
                            gsy.O000000o(LogType.GENERAL, "", "mHost  = " + iab.f1067O000000o[i]);
                        } catch (IOException | UnknownHostException unused2) {
                        }
                    }
                    iab.O00000Oo++;
                    iab.O00000o0++;
                    iab.O00000o++;
                    gsy.O000000o(6, "OT test", "mTotalFaildCount  = " + iab.O00000o0);
                    iab.O000000o(true, 2, 0);
                    return;
                } else if (iab.this.O00000Oo < 3) {
                    iab.this.O00000oo.sendEmptyMessage(5);
                    gsy.O00000o0(LogType.NETWORK, "", "send package to ot error");
                    return;
                } else if (iab.this.O00000Oo - iab.this.O00000o0 > 1) {
                    iab.this.O000000o(true, 3, 0);
                    return;
                } else {
                    iab.this.O00000oo.sendEmptyMessage(5);
                    gsy.O00000o0(LogType.NETWORK, "", "send package to ot error");
                    return;
                }
            } else {
                iab iab2 = iab.this;
                try {
                    iab2.f1067O000000o = InetAddress.getAllByName("ot.io.mi.com");
                    if (iab2.f1067O000000o != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= iab2.f1067O000000o.length) {
                                break;
                            } else if (hze.O000000o(iab2.f1067O000000o[i3].getAddress())) {
                                iab2.f1067O000000o = null;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (iab2.f1067O000000o != null) {
                        iab2.O000000o(true, 2, 0);
                        return;
                    } else if (iab2.O00000oO <= 0) {
                        iab2.O00000oO++;
                        iab2.O00000oo.sendEmptyMessageDelayed(1, 1000);
                        return;
                    } else {
                        gsy.O00000o0(LogType.NETWORK, "", "dns resolve error");
                        iab2.O000000o(false, 2, 1);
                        return;
                    }
                } catch (UnknownHostException unused3) {
                    if (iab2.f1067O000000o != null) {
                        iab2.O000000o(true, 2, 0);
                        return;
                    } else if (iab2.O00000oO <= 0) {
                        iab2.O00000oO++;
                        iab2.O00000oo.sendEmptyMessageDelayed(1, 1000);
                        return;
                    } else {
                        gsy.O00000o0(LogType.NETWORK, "", "dns resolve error");
                        iab2.O000000o(false, 2, 1);
                        return;
                    }
                } catch (Throwable th) {
                    if (iab2.f1067O000000o != null) {
                        iab2.O000000o(true, 2, 0);
                    } else if (iab2.O00000oO <= 0) {
                        iab2.O00000oO++;
                        iab2.O00000oo.sendEmptyMessageDelayed(1, 1000);
                    } else {
                        gsy.O00000o0(LogType.NETWORK, "", "dns resolve error");
                        iab2.O000000o(false, 2, 1);
                    }
                    throw th;
                }
            }
            i++;
            c = 4;
        }
    }

    public static iab O000000o() {
        if (O0000Oo0 == null) {
            O0000Oo0 = new iab();
        }
        return O0000Oo0;
    }

    public iab() {
        this.O0000O0o.start();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[SYNTHETIC, Splitter:B:20:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003a A[SYNTHETIC, Splitter:B:26:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x003d A[SYNTHETIC] */
    public final boolean O00000Oo() {
        Socket socket;
        int i = 0;
        while (i < this.f1067O000000o.length) {
            Socket socket2 = null;
            try {
                socket = new Socket();
                try {
                    socket.connect(new InetSocketAddress(this.f1067O000000o[i], 80), 2000);
                    if (socket.isConnected()) {
                        try {
                            socket.close();
                            return true;
                        } catch (Exception unused) {
                            return true;
                        }
                    } else {
                        try {
                            socket.close();
                        } catch (Exception unused2) {
                        }
                        i++;
                    }
                } catch (IOException unused3) {
                    socket2 = socket;
                    if (socket2 == null) {
                    }
                    i++;
                } catch (Throwable th) {
                    th = th;
                    if (socket != null) {
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                if (socket2 == null) {
                    socket2.close();
                }
                i++;
            } catch (Throwable th2) {
                th = th2;
                socket = null;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        gsy.O00000o0(LogType.NETWORK, "", "tcp 80 error");
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z, int i, int i2) {
        if (!z) {
            Message obtainMessage = this.O0000Oo.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.arg1 = i2;
            this.O0000Oo.sendMessage(obtainMessage);
        } else if (i == 3) {
            this.O0000Oo.sendEmptyMessage(i);
        } else {
            this.O00000oo.sendEmptyMessage(i);
        }
    }

    public final void O00000o0() {
        O00000Oo o00000Oo = this.O00000oo;
        if (o00000Oo != null) {
            o00000Oo.removeMessages(1);
            this.O00000oo.removeMessages(2);
        }
    }
}

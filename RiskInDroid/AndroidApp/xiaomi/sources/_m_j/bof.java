package _m_j;

import _m_j.bnx;
import _m_j.boa;
import android.content.Context;
import android.media.AudioTrack;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class bof implements bnx.O000000o, bnx.O00000Oo, boa.O000000o, boa.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public bnx f13160O000000o;
    public boa O00000Oo;
    public int O00000o;
    volatile int O00000o0;
    private bnw O00000oO;
    private O000000o O00000oo;
    private Thread O0000O0o;
    private Thread O0000OOo;
    private Handler O0000Oo0;

    public interface O000000o {
        void O00000o();
    }

    public bof(Context context, O000000o o000000o) {
        this(context, o000000o, (byte) 0);
    }

    private bof(Context context, O000000o o000000o, byte b) {
        this.O00000o0 = 2;
        this.O00000oo = o000000o;
        int minBufferSize = AudioTrack.getMinBufferSize(44100, 4, 2);
        this.O00000oO = new bnw(3, minBufferSize);
        this.O00000o = minBufferSize;
        this.f13160O000000o = new bnx(this);
        bnx bnx = this.f13160O000000o;
        bnx.f13151O000000o = this;
        bnx.O00000oO = context;
        bnx.O00000o.create(bnx.O00000oO, "com.sinvoice.demo", "SinVoice");
        this.O00000Oo = new boa(this, 44100, minBufferSize);
        this.O00000Oo.O00000o0 = this;
        this.O0000Oo0 = new Handler() {
            /* class _m_j.bof.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (message.what == 2) {
                    bof.this.O00000o();
                }
            }
        };
    }

    public final void O000000o(String str) {
        if (str != null) {
            final byte[] bArr = null;
            try {
                bArr = str.getBytes("UTF8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (bArr != null && 2 == this.O00000o0) {
                this.O00000o0 = 1;
                this.O00000oO.O000000o();
                this.O0000O0o = new Thread() {
                    /* class _m_j.bof.AnonymousClass2 */

                    public final void run() {
                        boa boa = bof.this.O00000Oo;
                        if (2 == boa.f13152O000000o) {
                            boa.O00000Oo = false;
                            if (boa.O00000o != null) {
                                boa.f13152O000000o = 1;
                                while (true) {
                                    if (1 == boa.f13152O000000o) {
                                        bnv O00000Oo = boa.O00000o.O00000Oo();
                                        if (O00000Oo != null) {
                                            if (O00000Oo.f13149O000000o == null) {
                                                break;
                                            }
                                            int write = boa.O00000oO.write(O00000Oo.f13149O000000o, 0, O00000Oo.O00000Oo);
                                            if (write != O00000Oo.O00000Oo) {
                                                bnz.O000000o("PcmPlayer", "PcmPlayerTime writedata, write is invalidate len:" + write + "   filledSize:" + O00000Oo.O00000Oo);
                                            }
                                            if (!boa.O00000Oo) {
                                                boa.O00000Oo = true;
                                                boa.O00000oO.play();
                                            }
                                            boa.O00000o.O000000o(O00000Oo);
                                        } else {
                                            bnz.O000000o("PcmPlayer", "get null data");
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (boa.O00000oO != null) {
                                    boa.O00000oO.flush();
                                }
                                boa.f13152O000000o = 2;
                                if (boa.O00000o0 != null) {
                                    boa.O00000o0.O00000o0();
                                }
                            }
                        }
                    }
                };
                Thread thread = this.O0000O0o;
                if (thread != null) {
                    thread.start();
                }
                this.O0000OOo = new Thread(0, false) {
                    /* class _m_j.bof.AnonymousClass3 */

                    public final void run() {
                        bnx bnx = bof.this.f13160O000000o;
                        int i = bof.this.O00000o;
                        byte[] bArr = bArr;
                        int i2 = 0;
                        boolean z = false;
                        if (2 == bnx.O00000o0) {
                            bnx.O00000o0 = 1;
                            bnx.O00000o.start(i);
                            if (bnx.O0000OOo) {
                                try {
                                    String path = Environment.getExternalStorageDirectory().getPath();
                                    if (!TextUtils.isEmpty(path)) {
                                        bnx.O00000Oo = new FileOutputStream(String.format("%s/player.pcm", path));
                                    }
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                            bnx.O0000O0o = 0;
                            do {
                                bnx.O000000o(bArr, i2);
                                if (!z) {
                                    break;
                                }
                            } while (1 == bnx.O00000o0);
                            bnx.O000000o();
                            bnx.O00000o.stop();
                            if (bnx.O0000OOo && bnx.O00000Oo != null) {
                                try {
                                    bnx.O00000Oo.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                };
                Thread thread2 = this.O0000OOo;
                if (thread2 != null) {
                    thread2.start();
                }
            }
        }
    }

    public final void O00000o() {
        if (1 == this.O00000o0) {
            this.O00000o0 = 2;
            this.f13160O000000o.O000000o();
            this.O00000Oo.O000000o();
            this.O00000oO.O00000Oo();
            Thread thread = this.O0000O0o;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.O0000O0o = null;
            }
            Thread thread2 = this.O0000OOo;
            if (thread2 != null) {
                try {
                    thread2.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.O0000OOo = null;
            }
            O000000o o000000o = this.O00000oo;
            if (o000000o != null) {
                o000000o.O00000o();
            }
        }
    }

    public final void O000000o() {
        this.O00000oO.O00000Oo(null);
    }

    public final bnv O00000Oo() {
        return this.O00000oO.O00000o0();
    }

    public final void O000000o(bnv bnv) {
        this.O00000oO.O000000o(bnv);
    }

    public final void O00000o0() {
        this.O0000Oo0.sendEmptyMessage(2);
    }
}

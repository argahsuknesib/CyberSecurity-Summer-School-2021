package _m_j;

import _m_j.gll;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.xiaomi.smarthome.library.bluetooth.channel.ChannelEvent;
import com.xiaomi.smarthome.library.bluetooth.channel.ChannelState;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

public abstract class glg implements glj, gmu {
    public static final boolean O00000o0 = (!glc.O0000OOo);

    /* renamed from: O000000o  reason: collision with root package name */
    private ChannelState f17957O000000o = ChannelState.IDLE;
    private byte[] O00000Oo;
    public List<Short> O00000o = new ArrayList();
    public int O00000oO;
    public int O00000oo;
    public glh O0000O0o;
    public Handler O0000OOo;
    private SparseArray<gls> O0000Oo = new SparseArray<>();
    public gll O0000Oo0 = new gll();
    private int O0000OoO;
    private glj O0000Ooo;
    private final glk O0000o = new glk() {
        /* class _m_j.glg.AnonymousClass17 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glr glr = (glr) objArr[0];
            glr.O0000O0o();
            if (glr.O00000oO() == 0) {
                int O00000Oo = glg.this.O00000Oo();
                int O00000o = glr.O00000o();
                int O00000o0 = glr.O00000o0();
                int min = Math.min(O00000Oo, O00000o);
                if (glg.O00000o0) {
                    gnk.O000000o("receive device mng ctr: local dmtu =%d,num=%d,device dmtu=%d, num=%d,minDMTU=%d", Integer.valueOf(O00000Oo), 6, Integer.valueOf(O00000o), Integer.valueOf(O00000o0), Integer.valueOf(min));
                }
                glg.this.O000000o(new glq(0, new byte[]{6, (byte) min}), new glh() {
                    /* class _m_j.glg.AnonymousClass17.AnonymousClass1 */

                    public final void O000000o(int i) {
                        glg.this.O0000OOo();
                    }
                });
            } else if (glr.O00000oO() == 1) {
                int O00000Oo2 = glg.this.O00000Oo();
                byte[] O00000oo = glr.O00000oo();
                int length = O00000oo.length + 2;
                int min2 = Math.min(length, O00000Oo2);
                if (min2 != length || !got.O000000o(O00000oo, (byte) min2)) {
                    glg.this.O000000o(18);
                    gnk.O00000o(new StringBuilder("channel=> sure dmtu is 18").toString());
                    min2 = 18;
                } else {
                    glg.this.O000000o(min2);
                    gnk.O00000o("channel=> sure dmtu is ".concat(String.valueOf(min2)));
                }
                byte[] bArr = new byte[(min2 - 2)];
                Arrays.fill(bArr, (byte) min2);
                glg.this.O000000o(new glq(1, bArr), new glh() {
                    /* class _m_j.glg.AnonymousClass17.AnonymousClass2 */

                    public final void O000000o(int i) {
                        glg.this.O0000OOo();
                        if (i == 0) {
                            glg.O00000oO();
                        }
                    }
                });
            }
        }
    };
    private final glk O0000o0 = new glk() {
        /* class _m_j.glg.AnonymousClass12 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glo glo = (glo) objArr[0];
            if (!glg.this.O000000o(glo)) {
                if (glg.O00000o0) {
                    gnk.O00000oO(String.format("dataPacket repeated!!", new Object[0]));
                }
            } else if (glo.f17991O000000o == glg.this.O00000oO) {
                glg.this.O0000O0o();
            } else {
                glg.this.O000000o(6000, new gll.O000000o("WaitData") {
                    /* class _m_j.glg.AnonymousClass12.AnonymousClass1 */

                    public final void O000000o() {
                        glg.this.O0000O0o();
                    }

                    public final void O00000Oo() {
                        glg.this.O0000Oo0.O000000o();
                    }
                });
            }
        }
    };
    private final glk O0000o00 = new glk() {
        /* class _m_j.glg.AnonymousClass1 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glo glo = (glo) objArr[0];
            short s = (short) glo.f17991O000000o;
            if (!glg.this.O00000o.contains(Short.valueOf(s))) {
                if (glg.O00000o0) {
                    gnk.O00000oO(String.format("sync packet not matched!!", new Object[0]));
                }
            } else if (glg.this.O000000o(glo)) {
                glg.this.O00000o.remove(Short.valueOf(s));
                if (glg.this.O00000o.size() == 0) {
                    glg.this.O0000O0o();
                }
            } else if (glg.O00000o0) {
                gnk.O00000oO(String.format("sync packet repeated!!", new Object[0]));
            }
        }
    };
    private final glk O0000o0O = new glk() {
        /* class _m_j.glg.AnonymousClass15 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            gln gln = (gln) objArr[0];
            glg.this.O00000oO = gln.f17990O000000o;
            glm glm = new glm(1);
            glg.this.O00000oo = gln.O00000Oo;
            glg.this.O000000o(ChannelState.READY);
            glg.this.O000000o(glm, new glh() {
                /* class _m_j.glg.AnonymousClass15.AnonymousClass1 */

                public final void O000000o(int i) {
                    glg.this.O0000Oo0();
                    if (i == 0) {
                        glg.this.O000000o(6000L);
                    } else {
                        glg.this.O0000OOo();
                    }
                }
            });
            glg.this.O000000o(ChannelState.READING);
        }
    };
    private final glk O0000o0o = new glk() {
        /* class _m_j.glg.AnonymousClass16 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glu glu = (glu) objArr[0];
            byte[] bArr = glu.f17996O000000o;
            final byte[] O000000o2 = glg.this.O000000o(ByteBuffer.wrap(bArr), bArr.length);
            glg.this.O00000oo = glu.O00000Oo;
            glt glt = new glt(0);
            glg.this.O000000o(ChannelState.READY);
            glg.this.O000000o(glt, new glh() {
                /* class _m_j.glg.AnonymousClass16.AnonymousClass1 */

                public final void O000000o(int i) {
                    glg.this.O0000Oo0();
                    glg.this.O0000OOo();
                    if (i == 0) {
                        glg.this.O00000Oo(O000000o2);
                    }
                }
            });
        }
    };
    private final glk O0000oO = new glk() {
        /* class _m_j.glg.AnonymousClass19 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glg.this.O000000o(ChannelState.WAIT_MNG_ACK);
            glg.this.O000000o(6000L);
        }
    };
    private final glk O0000oO0 = new glk() {
        /* class _m_j.glg.AnonymousClass18 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glg.this.O000000o(ChannelState.WAIT_START_ACK);
            glg.this.O000000o(6000L);
        }
    };
    private final glk O0000oOO = new glk() {
        /* class _m_j.glg.AnonymousClass20 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glg.this.O000000o(ChannelState.WAIT_SINGLE_ACK);
            glg.this.O000000o(6000L);
        }
    };
    private final gll.O000000o O0000oOo = new gll.O000000o(getClass().getSimpleName()) {
        /* class _m_j.glg.AnonymousClass21 */

        public final void O000000o() {
            glg.this.O0000Oo0();
            glg.this.O00000Oo(-2);
            glg.this.O0000OOo();
        }

        public final void O00000Oo() {
            glg.this.O0000Oo0.O000000o();
        }
    };
    private final glk O0000oo = new glk() {
        /* class _m_j.glg.AnonymousClass3 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glq glq = (glq) objArr[0];
            glq.O0000O0o();
            if (glq.O00000oO() == 0) {
                int O00000Oo = glg.this.O00000Oo();
                int O00000o = glg.this.O00000o();
                int O00000o2 = glq.O00000o();
                int O00000o0 = glq.O00000o0();
                if (glg.O00000o0) {
                    gnk.O000000o("Channel=>: receive mng ack : app dmtu =%d,maxPackage =%d; device dmtu = %d,max package =%d", Integer.valueOf(O00000Oo), Integer.valueOf(O00000o), Integer.valueOf(O00000o2), Integer.valueOf(O00000o0));
                }
                int min = Math.min(O00000Oo, O00000o2);
                if (O00000o == O00000o0) {
                    byte[] bArr = new byte[(min - 2)];
                    Arrays.fill(bArr, (byte) min);
                    glg.this.O000000o(new glr(1, bArr), new glh() {
                        /* class _m_j.glg.AnonymousClass3.AnonymousClass1 */

                        public final void O000000o(int i) {
                            glg.this.O0000Oo0();
                            if (i == 0) {
                                glg.this.O000000o(6000L);
                            } else {
                                glg.this.O0000OOo();
                            }
                        }
                    });
                    gnk.O00000o("channel=> send test package");
                    glg.this.O000000o(ChannelState.WAIT_MNG_ACK);
                }
            } else if (glq.O00000oO() == 1) {
                byte[] O00000oo = glq.O00000oo();
                int O00000Oo2 = glg.this.O00000Oo();
                int length = O00000oo.length + 2;
                int min2 = Math.min(O00000Oo2, length);
                gnk.O000000o("channel=> receive test package ack, byte length =%s, local dmtu =", Integer.valueOf(O00000oo.length), Integer.valueOf(O00000Oo2));
                if (length != min2 || !got.O000000o(O00000oo, (byte) min2)) {
                    glg.this.O000000o(18);
                    glg.this.O00000Oo(-1);
                    return;
                }
                gnk.O000000o("channel=> receive device test ack package ,all is correct, dmtu =".concat(String.valueOf(O00000Oo2)), new Object[0]);
                glg.this.O00000Oo(0);
                glg.this.O000000o(O00000Oo2);
            }
        }
    };
    private final glk O0000oo0 = new glk() {
        /* class _m_j.glg.AnonymousClass2 */

        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            int i = ((glt) objArr[0]).f17995O000000o;
            if (i == 0) {
                glg.this.O00000Oo(0);
                glg.this.O0000OOo();
            } else if (i != 2) {
                glg.this.O00000Oo(-1);
                glg.this.O0000OOo();
            } else {
                glg.this.O0000Oo();
                glg.this.O00000Oo(-3);
                glg.this.O0000OOo();
            }
        }
    };
    private final glk O0000ooO = new glk() {
        /* class _m_j.glg.AnonymousClass4 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.glg.O000000o(java.util.List<java.lang.Integer>, boolean):void
         arg types: [java.util.ArrayList, int]
         candidates:
          _m_j.glg.O000000o(byte[], byte[]):boolean
          _m_j.glg.O000000o(long, _m_j.gll$O000000o):void
          _m_j.glg.O000000o(_m_j.gls, _m_j.glh):void
          _m_j.glg.O000000o(com.xiaomi.smarthome.library.bluetooth.channel.ChannelEvent, java.lang.Object[]):void
          _m_j.glg.O000000o(java.nio.ByteBuffer, int):byte[]
          _m_j.glj.O000000o(java.util.List<byte[]>, _m_j.glh):void
          _m_j.glj.O000000o(byte[], int):void
          _m_j.glg.O000000o(java.util.List<java.lang.Integer>, boolean):void */
        public final void O000000o(Object... objArr) {
            glg.this.O0000Oo0();
            glm glm = (glm) objArr[0];
            int i = glm.f17989O000000o;
            if (i == 0) {
                glg.this.O00000Oo(0);
                glg.this.O0000OOo();
            } else if (i == 1) {
                glg.this.O0000Oo();
                glg.this.O000000o(ChannelState.WRITING);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < glg.this.O00000oO; i2++) {
                    arrayList.add(Integer.valueOf(i2));
                }
                glg.this.O000000o((List<Integer>) arrayList, false);
            } else if (i != 5) {
                glg.this.O00000Oo(-1);
                glg.this.O0000OOo();
            } else {
                List<Short> list = glm.O00000Oo;
                if (list.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Short shortValue : list) {
                        arrayList2.add(Integer.valueOf(shortValue.shortValue() - 1));
                    }
                    glg.this.O000000o((List<Integer>) arrayList2, true);
                }
            }
        }
    };
    private final gli[] O0000ooo = {new gli(ChannelState.READY, ChannelEvent.SEND_CTR, this.O0000oO0), new gli(ChannelState.READY, ChannelEvent.SEND_MNG, this.O0000oO), new gli(ChannelState.READY, ChannelEvent.SEND_SINGLE_CTR, this.O0000oOO), new gli(ChannelState.WAIT_START_ACK, ChannelEvent.RECV_ACK, this.O0000ooO), new gli(ChannelState.WAIT_MNG_ACK, ChannelEvent.RECV_MNG_ACK, this.O0000oo), new gli(ChannelState.WAIT_SINGLE_ACK, ChannelEvent.RECV_SINGLE_ACK, this.O0000oo0), new gli(ChannelState.SYNC, ChannelEvent.RECV_ACK, this.O0000ooO), new gli(ChannelState.WRITING, ChannelEvent.RECV_ACK, this.O0000ooO), new gli(ChannelState.IDLE, ChannelEvent.RECV_CTR, this.O0000o0O), new gli(ChannelState.IDLE, ChannelEvent.RECV_SINGLE_CTR, this.O0000o0o), new gli(ChannelState.IDLE, ChannelEvent.RECV_MNG, this.O0000o), new gli(ChannelState.READING, ChannelEvent.RECV_DATA, this.O0000o0), new gli(ChannelState.SYNC_ACK, ChannelEvent.RECV_DATA, this.O0000o00)};
    private final glj O00oOooO = new glj() {
        /* class _m_j.glg.AnonymousClass11 */

        public final void O000000o(byte[] bArr, glh glh, boolean z) {
            throw new UnsupportedOperationException();
        }

        public final void O000000o(List<byte[]> list, glh glh) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void O000000o(byte[] bArr) {
            char c;
            glg glg = glg.this;
            glg.O0000Oo0();
            gls O000000o2 = gls.O000000o(bArr);
            if (glg.O00000o0) {
                gnk.O000000o("channel=> onReceive from device, packet name =%s", O000000o2.O000000o());
            }
            String O000000o3 = O000000o2.O000000o();
            switch (O000000o3.hashCode()) {
                case 96393:
                    if (O000000o3.equals("ack")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 98849:
                    if (O000000o3.equals("ctr")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 108262:
                    if (O000000o3.equals("mng")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3076010:
                    if (O000000o3.equals("data")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 913950738:
                    if (O000000o3.equals("single_ack")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 913953194:
                    if (O000000o3.equals("single_ctr")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1200909232:
                    if (O000000o3.equals("mng_ack")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    glg.O000000o(ChannelEvent.RECV_ACK, O000000o2);
                    return;
                case 1:
                    glg.O000000o(ChannelEvent.RECV_DATA, O000000o2);
                    return;
                case 2:
                    glg.O000000o(ChannelEvent.RECV_CTR, O000000o2);
                    return;
                case 3:
                    glg.O000000o(ChannelEvent.RECV_MNG_ACK, O000000o2);
                    break;
                case 4:
                    break;
                case 5:
                    glg.O000000o(ChannelEvent.RECV_SINGLE_ACK, O000000o2);
                    return;
                case 6:
                    glg.O000000o(ChannelEvent.RECV_SINGLE_CTR, O000000o2);
                    return;
                default:
                    return;
            }
            glg.O000000o(ChannelEvent.RECV_MNG, O000000o2);
        }

        public final void O000000o(byte[] bArr, int i) {
            throw new UnsupportedOperationException();
        }

        public final void O000000o(byte[] bArr, int i, glh glh) {
            glg.this.O00000Oo(0, bArr, i, glh);
        }

        public final void O000000o(int i, byte[] bArr, int i2, glh glh) {
            glg.this.O00000Oo(i, bArr, i2, glh);
        }

        public final void O00000oo() {
            glg.this.O0000OOo();
        }
    };
    private final Handler.Callback O00oOooo = new Handler.Callback() {
        /* class _m_j.glg.AnonymousClass13 */

        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                ((gmt) message.obj).O000000o();
                return false;
            }
            ((glh) message.obj).O000000o(message.arg1);
            return false;
        }
    };

    public abstract void O000000o(int i);

    public abstract boolean O000000o();

    public abstract int O00000Oo();

    public abstract int O00000o();

    public abstract int O00000o0();

    public glg() {
        glj glj = this.O00oOooO;
        this.O0000Ooo = (glj) gmw.O000000o(glj, glj.getClass().getInterfaces(), this);
        gpq gpq = new gpq(getClass().getSimpleName());
        gpq.start();
        this.O0000OOo = new Handler(gpq.getLooper(), this.O00oOooo);
    }

    public final void O000000o(byte[] bArr) {
        this.O0000Ooo.O000000o(bArr);
    }

    public final void O000000o(int i, byte[] bArr, int i2, glh glh) {
        this.O0000Ooo.O000000o(i, bArr, i2, glh);
    }

    public static void O00000oO() {
        gnk.O00000o(" broadcast A4 result");
        gnl.O000000o(new Runnable("com.miot.action.a4.result") {
            /* class _m_j.gnl.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ String f18047O000000o;

            {
                this.f18047O000000o = r1;
            }

            public final void run() {
                gnl.O000000o(this.f18047O000000o);
            }
        }, 100);
    }

    public final void O000000o(byte[] bArr, int i, glh glh) {
        this.O0000Ooo.O000000o(bArr, i, glh);
    }

    public final void O00000oo() {
        this.O0000Ooo.O00000oo();
    }

    class O00000Oo implements glh {

        /* renamed from: O000000o  reason: collision with root package name */
        glh f17986O000000o;

        O00000Oo(glh glh) {
            this.f17986O000000o = glh;
        }

        public final void O000000o(int i) {
            if ("exception".equals(glg.this.O0000Oo0.O00000o())) {
                glg.this.O0000Oo();
            }
            glg.this.O0000OOo.obtainMessage(1, i, 0, this.f17986O000000o).sendToTarget();
        }
    }

    public final void O00000Oo(int i) {
        O0000Oo0();
        if (O00000o0) {
            gnk.O00000o0(String.format("%s: code = %d", O0000o00(), Integer.valueOf(i)));
        }
        glh glh = this.O0000O0o;
        if (glh != null) {
            glh.O000000o(i);
        }
    }

    public final boolean O000000o(glo glo) {
        O0000Oo0();
        if (this.O0000Oo.get(glo.f17991O000000o) != null) {
            return false;
        }
        this.O0000Oo.put(glo.f17991O000000o, glo);
        this.O0000OoO += glo.O00000Oo.O000000o();
        O0000Oo();
        return true;
    }

    public final void O0000O0o() {
        O0000Oo0();
        if (O00000o0) {
            gnk.O00000o0(O0000o00());
        }
        O000000o(6000L);
        O000000o(ChannelState.SYNC);
        O0000Oo0();
        if (O00000o0) {
            gnk.O00000o0(O0000o00());
        }
        ArrayList arrayList = new ArrayList();
        int O00000o2 = O00000o();
        boolean z = true;
        for (int i = 1; i <= this.O00000oO; i++) {
            if (this.O0000Oo.get(i) == null) {
                arrayList.add(Short.valueOf((short) i));
            }
            if (arrayList.size() >= O00000o2) {
                break;
            }
        }
        if (arrayList.size() > 0) {
            gnk.O00000o("exit lost seq,start sync packet");
            this.O00000o = arrayList;
            O000000o(new glm(5, arrayList), new glh() {
                /* class _m_j.glg.AnonymousClass9 */

                public final void O000000o(int i) {
                    glg.this.O0000Oo0();
                    if (i == 0) {
                        glg.this.O000000o(6000L);
                    } else {
                        glg.this.O0000OOo();
                    }
                }
            });
            O000000o(ChannelState.SYNC_ACK);
        } else {
            z = false;
        }
        if (!z) {
            final byte[] O0000OoO2 = O0000OoO();
            if (!got.O00000o(O0000OoO2)) {
                O000000o(new glm(0), new glh() {
                    /* class _m_j.glg.AnonymousClass8 */

                    public final void O000000o(int i) {
                        glg.this.O0000Oo0();
                        glg.this.O0000OOo();
                        if (i == 0) {
                            glg.this.O00000Oo(O0000OoO2);
                        }
                    }
                });
            } else {
                O0000OOo();
            }
        }
    }

    public final void O00000Oo(byte[] bArr) {
        if (O00000o0) {
            gnk.O00000o0(String.format(">>> receive: %s", new String(bArr)));
        }
        glc.O000000o(new O000000o(bArr, this.O00000oo), 0);
    }

    class O000000o implements Runnable {
        private byte[] O00000Oo;
        private int O00000o0;

        O000000o(byte[] bArr, int i) {
            this.O00000Oo = bArr;
            this.O00000o0 = i;
        }

        public final void run() {
            glg.this.O000000o(this.O00000Oo, this.O00000o0);
        }
    }

    private byte[] O0000OoO() {
        O0000Oo0();
        if (this.O0000Oo.size() == this.O00000oO) {
            if (O000000o()) {
                if (O00000o0) {
                    gnk.O00000o0(String.format("%s: totalBytes = %d (include 4 Bytes crc)", O0000o00(), Integer.valueOf(this.O0000OoO)));
                }
            } else if (O00000o0) {
                gnk.O00000o0(String.format("%s: totalBytes = %d", O0000o00(), Integer.valueOf(this.O0000OoO)));
            }
            ByteBuffer allocate = ByteBuffer.allocate(this.O0000OoO);
            for (int i = 1; i <= this.O00000oO; i++) {
                ((glo) this.O0000Oo.get(i)).O000000o(allocate);
            }
            return O000000o(allocate, this.O0000OoO);
        }
        O0000Ooo();
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public final byte[] O000000o(ByteBuffer byteBuffer, int i) {
        if (!O000000o()) {
            return byteBuffer.array();
        }
        int i2 = i - 4;
        byte[] bArr = {byteBuffer.get(i2), byteBuffer.get(i - 3), byteBuffer.get(i - 2), byteBuffer.get(i - 1)};
        byte[] bArr2 = new byte[i2];
        System.arraycopy(byteBuffer.array(), 0, bArr2, 0, i2);
        if (O000000o(bArr2, bArr)) {
            return bArr2;
        }
        if (O00000o0) {
            gnk.O00000Oo(String.format("check crc failed!!", new Object[0]));
        }
        return got.f18097O000000o;
    }

    public final void O0000OOo() {
        O0000Oo0();
        if (O00000o0) {
            gnk.O00000o0(O0000o00());
        }
        gnk.O00000o("resetChannelStatus");
        O0000Oo();
        O000000o(ChannelState.IDLE);
        this.O00000Oo = null;
        this.O00000oO = 0;
        this.O0000O0o = null;
        this.O0000Oo.clear();
        this.O00000o.clear();
        this.O0000OoO = 0;
    }

    private void O0000Ooo() {
        if (O00000o0) {
            gnk.O00000o0(O0000o00());
        }
        O0000Oo();
        this.f17957O000000o = ChannelState.IDLE;
        this.O00000Oo = null;
        this.O00000oO = 0;
        this.O0000O0o = null;
        this.O0000Oo.clear();
        this.O00000o.clear();
        this.O0000OoO = 0;
    }

    public final void O000000o(List<Integer> list, final boolean z) {
        O0000Oo0();
        int O00000o02 = O00000o0();
        gnk.O00000o("sendDataPacket list= " + list.toString());
        final ArrayList arrayList = new ArrayList();
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (intValue2 < this.O00000oO) {
                int i = intValue2 * O00000o02;
                int i2 = intValue2 + 1;
                arrayList.add(new glo(i2, this.O00000Oo, i, Math.min(this.O00000Oo.length, i2 * O00000o02)).O00000Oo());
            }
        }
        if (!arrayList.isEmpty()) {
            final AnonymousClass10 r8 = new glh() {
                /* class _m_j.glg.AnonymousClass10 */

                public final void O000000o(int i) {
                    if (!z) {
                        if (glg.this.O0000O0o == null) {
                            gnk.O00000o("send Data packet onCallback, channelCallback is null ,return");
                            return;
                        }
                        gnk.O00000o("receive batch write callback ,start sync");
                        glg.this.O000000o(ChannelState.SYNC);
                        glg.this.O000000o(18000L);
                    }
                }
            };
            O0000Oo0();
            if (!this.O0000Oo0.O00000o0()) {
                O0000o0();
            }
            glc.O000000o(new Runnable() {
                /* class _m_j.glg.AnonymousClass6 */

                public final void run() {
                    gnk.O00000o("perform batch write");
                    glg glg = glg.this;
                    glg.O000000o(arrayList, new O00000Oo(r8));
                }
            }, 0);
        }
    }

    public final void O000000o(ChannelState channelState) {
        O0000Oo0();
        if (O00000o0) {
            gnk.O00000o0(String.format("%s: state = %s", O0000o00(), channelState));
        }
        this.f17957O000000o = channelState;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(ChannelEvent channelEvent, Object... objArr) {
        O0000Oo0();
        if (O00000o0) {
            gnk.O00000o0(String.format("%s: state = %s, event = %s", O0000o00(), this.f17957O000000o, channelEvent));
        }
        for (gli gli : this.O0000ooo) {
            if (gli.f17987O000000o == this.f17957O000000o && gli.O00000Oo == channelEvent) {
                gli.O00000o0.O000000o(objArr);
                return;
            }
        }
    }

    public final void O0000Oo0() {
        if (Looper.myLooper() != this.O0000OOo.getLooper()) {
            O0000Ooo();
            throw new RuntimeException();
        }
    }

    public final void O00000Oo(int i, byte[] bArr, int i2, glh glh) {
        O0000Oo0();
        if (this.f17957O000000o != ChannelState.IDLE) {
            gnk.O00000o("preform send ,but channelState is not idle");
            glh.O000000o(-3);
            return;
        }
        this.O00000oo = i2;
        this.f17957O000000o = ChannelState.READY;
        gls gls = null;
        this.O0000O0o = (glh) gmw.O000000o(glh, glh.getClass().getInterfaces(), null);
        this.O0000OoO = bArr.length;
        int i3 = this.O0000OoO;
        if (O000000o()) {
            i3 += 4;
        }
        this.O00000oO = ((i3 - 1) / O00000o0()) + 1;
        if (O00000o0) {
            gnk.O00000o0(String.format("%s: totalBytes = %d, frameCount = %d", O0000o00(), Integer.valueOf(this.O0000OoO), Integer.valueOf(this.O00000oO)));
        }
        if (O000000o()) {
            this.O00000Oo = Arrays.copyOf(bArr, bArr.length + 4);
            System.arraycopy(glf.O000000o(bArr), 0, this.O00000Oo, bArr.length, 4);
            if (O00000o0) {
                gnk.O00000o0("performSend CRC32 = " + got.O00000o0(this.O00000Oo));
            }
        } else {
            this.O00000Oo = Arrays.copyOf(bArr, bArr.length);
        }
        byte[] bArr2 = this.O00000Oo;
        O0000Oo0();
        if (i == 0 || this.O00000oO > 1) {
            gls = new gln(this.O00000oO, i2);
            gnk.O000000o("prepare send CMD, frame count = %d,package type =%d", Integer.valueOf(this.O00000oO), Integer.valueOf(i2));
        } else if (i == 4) {
            gls = new glr(i2, bArr2);
        } else if (i == 2) {
            gls = new glu(i2, bArr2);
        }
        if (gls == null) {
            gnk.O00000Oo("send start flow packet, opcode =" + i + ",packageType=" + i2 + ",but build flow packet is null");
            return;
        }
        O000000o(gls, new glh() {
            /* class _m_j.glg.AnonymousClass7 */

            public final void O000000o(int i) {
                glg.this.O0000Oo0();
                if (i != 0) {
                    glg.this.O00000Oo(-1);
                    glg.this.O0000OOo();
                }
            }
        });
        if (i == 0 || this.O00000oO > 1) {
            O000000o(ChannelEvent.SEND_CTR, new Object[0]);
        } else if (i == 2) {
            O000000o(ChannelEvent.SEND_SINGLE_CTR, new Object[0]);
        } else if (i == 4) {
            O000000o(ChannelEvent.SEND_MNG, new Object[0]);
        }
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        this.O0000OOo.obtainMessage(0, new gmt(obj, method, objArr)).sendToTarget();
        return true;
    }

    private String O0000o00() {
        return String.format("%s.%s", getClass().getSimpleName(), glc.O0000Oo());
    }

    private void O0000o0() {
        O000000o(6000, new gll.O000000o("exception") {
            /* class _m_j.glg.AnonymousClass14 */

            public final void O000000o() throws TimeoutException {
                throw new TimeoutException();
            }

            public final void O00000Oo() {
                glg.this.O0000Oo0.O000000o();
            }
        });
    }

    public final void O000000o(long j) {
        O000000o(j, this.O0000oOo);
    }

    public final void O000000o(long j, gll.O000000o o000000o) {
        if (O00000o0) {
            gnk.O00000o0(String.format("%s: duration = %d", O0000o00(), Long.valueOf(j)));
        }
        this.O0000Oo0.O000000o(o000000o, j);
    }

    public final void O0000Oo() {
        if (O00000o0) {
            gnk.O00000o0(O0000o00());
        }
        this.O0000Oo0.O00000Oo();
    }

    private static boolean O000000o(byte[] bArr, byte[] bArr2) {
        return got.O00000Oo(bArr2, glf.O000000o(bArr));
    }

    public final void O000000o(gls gls, glh glh) {
        O0000Oo0();
        if (!this.O0000Oo0.O00000o0()) {
            O0000o0();
        }
        byte[] O00000Oo2 = gls.O00000Oo();
        if (O00000o0) {
            gnk.O00000oO(String.format("%s: %s", O0000o00(), gls));
        }
        glc.O000000o(new Runnable(O00000Oo2, glh, false) {
            /* class _m_j.glg.AnonymousClass5 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ byte[] f17980O000000o;
            final /* synthetic */ glh O00000Oo;
            final /* synthetic */ boolean O00000o0 = false;

            {
                this.f17980O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void run() {
                glg glg = glg.this;
                glg.O000000o(this.f17980O000000o, new O00000Oo(this.O00000Oo), this.O00000o0);
            }
        }, 0);
    }
}

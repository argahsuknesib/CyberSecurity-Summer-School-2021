package _m_j;

import _m_j.tl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.amap.openapi.dt;
import java.util.ArrayList;
import java.util.Iterator;

public final class tc {

    /* renamed from: O000000o  reason: collision with root package name */
    HandlerThread f2487O000000o;
    Looper O00000Oo;
    tb O00000o;
    O00000Oo O00000o0;
    dt O00000oO;
    O000000o O00000oo;
    final Object O0000O0o = new byte[0];
    ArrayList<Message> O0000OOo = new ArrayList<>();

    public tc(final Context context, final st stVar) {
        this.f2487O000000o = new HandlerThread("UpTunnelWorkThread") {
            /* class _m_j.tc.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* JADX WARNING: Can't wrap try/catch for region: R(20:2|3|(1:5)|6|(1:8)|9|(1:11)|12|(1:14)|15|(1:17)|18|19|20|21|22|(2:25|23)|32|26|27) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0123 */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0131 A[LOOP:0: B:23:0x012b->B:25:0x0131, LOOP_END] */
            public final void onLooperPrepared() {
                synchronized (tc.this.O0000O0o) {
                    tc.this.O00000oO = new dt(context);
                    tc.this.O00000Oo = tc.this.f2487O000000o.getLooper();
                    tc.this.O00000o0 = new O00000Oo(tc.this.O00000Oo);
                    tc.this.O00000o = new tb();
                    tb tbVar = tc.this.O00000o;
                    dt dtVar = tc.this.O00000oO;
                    st stVar = stVar;
                    Looper looper = tc.this.O00000Oo;
                    tbVar.O0000O0o = dtVar;
                    tbVar.O0000OOo = stVar.O00000oo;
                    if (stVar.f2481O000000o != null) {
                        tbVar.O00000Oo = new tl();
                        tl tlVar = tbVar.O00000Oo;
                        dt dtVar2 = tbVar.O0000O0o;
                        sy syVar = stVar.f2481O000000o;
                        ox oxVar = tbVar.O0000OOo;
                        tlVar.O00000o0 = dtVar2;
                        tlVar.O00000oo = 1;
                        tlVar.O00000o = new tk(syVar);
                        tlVar.O00000oO = oxVar;
                        tlVar.O00000Oo = dtVar2.O00000Oo();
                        tlVar.f2496O000000o = dt.O00000Oo(tlVar.O00000oo);
                        tlVar.O0000OOo = new qu();
                        tlVar.O0000OOo.O000000o(new tl.O000000o(), looper);
                        tlVar.O0000O0o = new qv();
                        tlVar.O0000O0o.O000000o(dtVar2.O000000o(), new tl.O00000Oo(), looper);
                        tlVar.O0000O0o.O000000o(20000);
                    }
                    if (stVar.O00000Oo != null) {
                        tbVar.O00000o0 = new tn();
                        tbVar.O00000o0.O000000o(tbVar.O0000O0o, stVar.O00000Oo, tbVar.O0000OOo, 2, looper);
                    }
                    if (stVar.O00000o0 != null) {
                        tbVar.O00000o = new tn();
                        tbVar.O00000o.O000000o(tbVar.O0000O0o, stVar.O00000o0, tbVar.O0000OOo, 5, looper);
                    }
                    if (stVar.O00000o != null) {
                        tbVar.O00000oO = new tn();
                        tbVar.O00000oO.O000000o(tbVar.O0000O0o, stVar.O00000o, tbVar.O0000OOo, 3, looper);
                    }
                    if (stVar.O00000oO != null) {
                        tbVar.O00000oo = new tn();
                        tbVar.O00000oo.O000000o(tbVar.O0000O0o, stVar.O00000oO, tbVar.O0000OOo, 4, looper);
                    }
                    tc tcVar = tc.this;
                    tcVar.O00000oo = new O000000o(tcVar, (byte) 0);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    tcVar.O00000oO.O000000o().registerReceiver(tcVar.O00000oo, intentFilter);
                    Iterator<Message> it = tc.this.O0000OOo.iterator();
                    while (it.hasNext()) {
                        tc.this.O00000o0.sendMessage(it.next());
                    }
                    tc.this.O0000OOo.clear();
                }
            }
        };
        this.f2487O000000o.start();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2, int i3, Object obj) {
        O00000Oo o00000Oo = this.O00000o0;
        if (o00000Oo != null) {
            o00000Oo.obtainMessage(i, i2, i3, obj).sendToTarget();
            return;
        }
        synchronized (this.O0000O0o) {
            if (this.O00000o0 != null) {
                this.O00000o0.obtainMessage(i, i2, i3, obj).sendToTarget();
            } else {
                this.O0000OOo.add(Message.obtain(null, i, i2, i3, obj));
            }
        }
    }

    final class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(tc tcVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                String action = intent.getAction();
                char c = 65535;
                if (action.hashCode() == -1172645946 && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    c = 0;
                }
                if (c == 0 && tc.this.O00000o0 != null) {
                    tc.this.O00000o0.sendEmptyMessage(11);
                }
            }
        }
    }

    class O00000Oo extends Handler {
        private boolean O00000Oo;

        O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (!this.O00000Oo) {
                if (message.what == 10) {
                    tb tbVar = tc.this.O00000o;
                    int i = message.arg1;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i == 5 && tbVar.O00000o != null) {
                                        tbVar.O00000o.O000000o(message.arg2, (byte[]) message.obj);
                                    }
                                } else if (tbVar.O00000oo != null) {
                                    tbVar.O00000oo.O000000o(message.arg2, ((String) message.obj).getBytes(tb.f2486O000000o));
                                }
                            } else if (tbVar.O00000oO != null) {
                                tbVar.O00000oO.O000000o(message.arg2, (byte[]) message.obj);
                            }
                        } else if (tbVar.O00000o0 != null) {
                            tbVar.O00000o0.O000000o(message.arg2, (byte[]) message.obj);
                        }
                    } else if (tbVar.O00000Oo != null) {
                        tl tlVar = tbVar.O00000Oo;
                        int i2 = message.arg2;
                        tlVar.O0000Oo0.put(i2, tlVar.O0000Oo0.get(i2) + 1);
                        tlVar.O0000OOo.O000000o(tl.O00000o0.f2500O000000o);
                    }
                } else if (message.what == 11) {
                    tb tbVar2 = tc.this.O00000o;
                    int O00000o0 = tbVar2.O0000O0o.O00000o0();
                    if (tbVar2.O00000Oo != null) {
                        tl tlVar2 = tbVar2.O00000Oo;
                        if (O00000o0 != -1) {
                            tlVar2.O0000O0o.O000000o(20000);
                        }
                    }
                    if (tbVar2.O00000o0 != null) {
                        tbVar2.O00000o0.O000000o(O00000o0);
                    }
                    if (tbVar2.O00000oO != null) {
                        tbVar2.O00000oO.O000000o(O00000o0);
                    }
                    if (tbVar2.O00000oo != null) {
                        tbVar2.O00000oo.O000000o(O00000o0);
                    }
                    if (tbVar2.O00000o != null) {
                        tbVar2.O00000o.O000000o(O00000o0);
                    }
                } else if (message.what == 12) {
                    sv svVar = (sv) message.obj;
                    tb tbVar3 = tc.this.O00000o;
                    if ((svVar instanceof sw) && tbVar3.O0000O0o.O00000o0() != -1) {
                        sw swVar = (sw) svVar;
                        int i3 = swVar.O00000Oo;
                        if (i3 != 3) {
                            if (i3 == 4 && tbVar3.O00000oo != null) {
                                tbVar3.O00000oo.O0000OOo.O00000Oo();
                            }
                        } else if (tbVar3.O00000oO != null) {
                            tbVar3.O00000oO.O0000OOo.O00000Oo();
                        }
                        new Thread(new sx(tbVar3.O0000O0o, swVar, tbVar3.O0000OOo), "command_thread").start();
                    }
                } else if (message.what == 13) {
                    this.O00000Oo = true;
                    removeCallbacksAndMessages(null);
                    tb tbVar4 = tc.this.O00000o;
                    if (tbVar4.O00000Oo != null) {
                        tl tlVar3 = tbVar4.O00000Oo;
                        tlVar3.O0000OOo.O000000o();
                        tlVar3.O0000O0o.O000000o();
                    }
                    if (tbVar4.O00000o0 != null) {
                        tbVar4.O00000o0.O000000o();
                    }
                    if (tbVar4.O00000oO != null) {
                        tbVar4.O00000oO.O000000o();
                    }
                    if (tbVar4.O00000oo != null) {
                        tbVar4.O00000oo.O000000o();
                    }
                    if (tbVar4.O00000o != null) {
                        tbVar4.O00000o.O000000o();
                    }
                    try {
                        tc.this.O00000oO.O000000o().unregisterReceiver(tc.this.O00000oo);
                    } catch (Exception unused) {
                    }
                    post(new Runnable() {
                        /* class _m_j.tc.O00000Oo.AnonymousClass1 */

                        public final void run() {
                            try {
                                O00000Oo.this.getLooper().quit();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            }
        }
    }
}

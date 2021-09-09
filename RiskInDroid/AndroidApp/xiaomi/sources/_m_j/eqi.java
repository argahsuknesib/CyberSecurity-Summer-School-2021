package _m_j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.fg;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.i;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class eqi extends eqb {
    protected Socket O0000oO;
    protected Exception O0000oO0 = null;
    String O0000oOO = null;
    protected XMPushService O0000oOo;
    protected volatile long O0000oo = 0;
    protected volatile long O0000oo0 = 0;
    protected volatile long O0000ooO = 0;
    private String O0000ooo;
    private int O00oOooO;
    private long O00oOooo = 0;

    public eqi(XMPushService xMPushService, eqc eqc) {
        super(xMPushService, eqc);
        this.O0000oOo = xMPushService;
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(boolean z);

    public void O000000o(epq[] epqArr) {
        throw new gg("Don't support send Blob");
    }

    public final void O00000Oo(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        O000000o(z);
        i.a(this.O0000oOo).m209c();
        if (!z) {
            this.O0000oOo.a(new eqj(this, elapsedRealtime, currentTimeMillis), 10000);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void O00000o0() {
    }

    public final void O00000o0(int i, Exception exc) {
        this.O0000oOo.a(new eqk(this, i, exc));
    }

    public final String O00000oO() {
        return this.O0000ooo;
    }

    public final String O0000o00() {
        return this.O0000OoO;
    }

    public final void O0000o0O() {
        this.O0000oo0 = SystemClock.elapsedRealtime();
    }

    public final void O0000o0o() {
        this.O0000oo = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    public synchronized void O000000o(int i, Exception exc) {
        if (this.O0000o00 != 2) {
            O000000o(2, i, exc);
            this.O0000OoO = "";
            try {
                this.O0000oO.close();
            } catch (Throwable unused) {
            }
            this.O0000oo0 = 0;
            this.O0000oo = 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.enp.a(java.lang.String, boolean):_m_j.enl
     arg types: [java.lang.String, int]
     candidates:
      _m_j.enp.a(java.lang.String, java.lang.String):void
      _m_j.enp.a(java.lang.String, _m_j.enl):void
      _m_j.enp.a(java.lang.String, boolean):_m_j.enl */
    public final void O00000Oo(int i, Exception exc) {
        O000000o(i, exc);
        if ((exc == null && i != 18) || this.O0000ooO == 0) {
            return;
        }
        if (SystemClock.elapsedRealtime() - this.O0000ooO >= 300000) {
            this.O00oOooO = 0;
        } else if (emf.O000000o(this.O0000oOo)) {
            this.O00oOooO++;
            if (this.O00oOooO >= 2) {
                String str = this.O0000ooo;
                duv.O000000o("max short conn time reached, sink down current host:".concat(String.valueOf(str)));
                enl a2 = enp.a().a(eqc.a(), false);
                if (a2 != null) {
                    a2.O00000Oo(str, 0, 0, exc);
                    enp.a().m601c();
                }
                this.O00oOooO = 0;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.enp.a(java.lang.String, boolean):_m_j.enl
     arg types: [java.lang.String, int]
     candidates:
      _m_j.enp.a(java.lang.String, java.lang.String):void
      _m_j.enp.a(java.lang.String, _m_j.enl):void
      _m_j.enp.a(java.lang.String, boolean):_m_j.enl */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0305 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0341 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x026c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02ee A[EDGE_INSN: B:135:0x02ee->B:96:0x02ee ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x026e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x026e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b1 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b3 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01cf A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01e1 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x022f A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0231 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x024d A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x025f A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02b1 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02b3 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02cf A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e1 A[Catch:{ IOException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02f1 A[Catch:{ IOException -> 0x0355 }] */
    public final synchronized void O0000o0() {
        StringBuilder sb;
        int i;
        boolean z;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        try {
            if (!O0000Oo()) {
                if (!O0000Oo0()) {
                    O000000o(0, 0, null);
                    eqc eqc = this.O0000o0O;
                    String c = eqc.c();
                    int a2 = eqc.m604a();
                    this.O0000oO0 = null;
                    ArrayList<String> arrayList = new ArrayList<>();
                    int intValue = duv.O00000oO("get bucket for host : ".concat(String.valueOf(c))).intValue();
                    enl a3 = enp.a().a(c, false);
                    if (!a3.O000000o()) {
                        erc.O000000o(new eql(this, c));
                    }
                    duv.O000000o(Integer.valueOf(intValue));
                    boolean z2 = true;
                    if (a3 != null) {
                        arrayList = a3.O000000o(true);
                    }
                    enl d = enp.a().d(c);
                    if (d != null) {
                        Iterator<String> it = d.O000000o(true).iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (arrayList.indexOf(next) == -1) {
                                arrayList.add(next);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        arrayList.add(c);
                    }
                    if (elk.f15608O000000o && esl.O00000Oo(this.O0000oOo)) {
                        String O000000o2 = est.O000000o("log.tag.debug.xmsf.ip", "");
                        if (!TextUtils.isEmpty(O000000o2)) {
                            arrayList.clear();
                            arrayList.add(O000000o2);
                            duv.O000000o("[debug] connect ip：".concat(String.valueOf(O000000o2)));
                        }
                    }
                    this.O0000ooO = 0;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    String str7 = "";
                    String O0000Oo0 = emf.O0000Oo0(this.O0000oOo);
                    StringBuilder sb2 = new StringBuilder();
                    Iterator<String> it2 = arrayList.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            sb = sb2;
                            i = i3;
                            break;
                        }
                        String next2 = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        this.O00000Oo += z2 ? 1 : 0;
                        i2 = i3 + 1;
                        try {
                            duv.O000000o("begin to connect to ".concat(String.valueOf(next2)));
                            this.O0000oO = new Socket();
                            this.O0000oO.connect(enn.O00000Oo(next2, a2), 8000);
                            duv.O000000o("tcp connected");
                            this.O0000oO.setTcpNoDelay(z2);
                            this.O0000ooo = next2;
                            O00000o0();
                            this.O00000o0 = System.currentTimeMillis() - currentTimeMillis;
                            this.O0000Ooo = O0000Oo0;
                            if (a3 == null) {
                                sb = sb2;
                                str = next2;
                                break;
                            }
                            sb = sb2;
                            str = next2;
                            try {
                                a3.O000000o(next2, this.O00000o0, 0);
                                break;
                            } catch (Exception e) {
                                e = e;
                                try {
                                    this.O0000oO0 = e;
                                    duv.O00000o("SMACK: Could not connect to:".concat(String.valueOf(str)));
                                    sb.append("SMACK: Could not connect to ");
                                    sb.append(str);
                                    sb.append(" port:");
                                    sb.append(a2);
                                    sb.append(" err:");
                                    sb.append(this.O0000oO0.getClass().getSimpleName());
                                    sb.append("\n");
                                    if (!TextUtils.isEmpty(str7)) {
                                    }
                                    ero.O000000o(str, this.O0000oO0);
                                    if (a3 == null) {
                                    }
                                    if (TextUtils.equals(str4, emf.O0000Oo0(this.O0000oOo))) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    duv.O00000o("SMACK: Could not connect to:".concat(String.valueOf(str)));
                                    sb.append("SMACK: Could not connect to ");
                                    sb.append(str);
                                    sb.append(" port:");
                                    sb.append(a2);
                                    sb.append(" err:");
                                    sb.append(this.O0000oO0.getClass().getSimpleName());
                                    sb.append("\n");
                                    if (!TextUtils.isEmpty(str7)) {
                                    }
                                    ero.O000000o(str, this.O0000oO0);
                                    if (a3 == null) {
                                    }
                                    if (TextUtils.equals(str2, emf.O0000Oo0(this.O0000oOo))) {
                                    }
                                    i = i2;
                                    z = false;
                                    enp.a().m601c();
                                    int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                    if (z) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                this.O0000oO0 = new Exception("abnormal exception", th);
                                duv.O000000o(th);
                                duv.O00000o("SMACK: Could not connect to:".concat(String.valueOf(str)));
                                sb.append("SMACK: Could not connect to ");
                                sb.append(str);
                                sb.append(" port:");
                                sb.append(a2);
                                sb.append(" err:");
                                sb.append(this.O0000oO0.getClass().getSimpleName());
                                sb.append("\n");
                                if (!TextUtils.isEmpty(str7)) {
                                }
                                ero.O000000o(str, this.O0000oO0);
                                if (a3 == null) {
                                }
                                if (TextUtils.equals(str4, emf.O0000Oo0(this.O0000oOo))) {
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            sb = sb2;
                            str = next2;
                            this.O0000oO0 = e;
                            duv.O00000o("SMACK: Could not connect to:".concat(String.valueOf(str)));
                            sb.append("SMACK: Could not connect to ");
                            sb.append(str);
                            sb.append(" port:");
                            sb.append(a2);
                            sb.append(" err:");
                            sb.append(this.O0000oO0.getClass().getSimpleName());
                            sb.append("\n");
                            if (!TextUtils.isEmpty(str7)) {
                                str6 = str;
                            } else {
                                str6 = str7 + "|" + str;
                            }
                            ero.O000000o(str, this.O0000oO0);
                            if (a3 == null) {
                                String str8 = str;
                                str5 = O0000Oo0;
                                a3.O00000Oo(str8, System.currentTimeMillis() - currentTimeMillis, 0, this.O0000oO0);
                            } else {
                                str5 = O0000Oo0;
                            }
                            if (TextUtils.equals(str4, emf.O0000Oo0(this.O0000oOo))) {
                                i = i2;
                                z = false;
                                enp.a().m601c();
                                int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (z) {
                                }
                            } else {
                                sb2 = sb;
                                O0000Oo0 = str4;
                                i3 = i2;
                                z2 = true;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            sb = sb2;
                            str = next2;
                            duv.O00000o("SMACK: Could not connect to:".concat(String.valueOf(str)));
                            sb.append("SMACK: Could not connect to ");
                            sb.append(str);
                            sb.append(" port:");
                            sb.append(a2);
                            sb.append(" err:");
                            sb.append(this.O0000oO0.getClass().getSimpleName());
                            sb.append("\n");
                            if (!TextUtils.isEmpty(str7)) {
                                str3 = str;
                            } else {
                                str3 = str7 + "|" + str;
                            }
                            ero.O000000o(str, this.O0000oO0);
                            if (a3 == null) {
                                String str9 = str;
                                str2 = O0000Oo0;
                                a3.O00000Oo(str9, System.currentTimeMillis() - currentTimeMillis, 0, this.O0000oO0);
                            } else {
                                str2 = O0000Oo0;
                            }
                            if (TextUtils.equals(str2, emf.O0000Oo0(this.O0000oOo))) {
                                throw th;
                            }
                            i = i2;
                            z = false;
                            enp.a().m601c();
                            int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (z) {
                            }
                        }
                        enp.a().m601c();
                        int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (z) {
                            if (this.O00oOooo == 0 || SystemClock.elapsedRealtime() - this.O00oOooo > 480000) {
                                this.O00oOooo = SystemClock.elapsedRealtime();
                                ero.O000000o(fg.j.a(), elapsedRealtime2222, str7, emf.O00000Oo(this.O0000oOo.getApplicationContext()) ? 1 : 0);
                            }
                            throw new gg(sb.toString());
                        }
                        ero.O000000o(fg.i.a(), elapsedRealtime2222, str7, i);
                        return;
                        sb2 = sb;
                        O0000Oo0 = str4;
                        i3 = i2;
                        z2 = true;
                    }
                    this.O0000ooO = SystemClock.elapsedRealtime();
                    duv.O000000o("connected to " + str + " in " + this.O00000o0);
                    i = i2;
                    z = true;
                    enp.a().m601c();
                    int elapsedRealtime22222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                    if (z) {
                    }
                }
            }
            duv.O000000o("WARNING: current xmpp has connected");
        } catch (IOException e3) {
            throw new gg(e3);
        }
    }
}

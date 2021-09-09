package _m_j;

import _m_j.jpj;
import _m_j.jpt;
import _m_j.jpy;
import _m_j.jri;
import _m_j.jrk;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ss.q;
import ss.ss.gK.l;
import ss.ss.gK.o;
import ss.u;

final class jrh implements joy {

    /* renamed from: O000000o  reason: collision with root package name */
    final jrg f2093O000000o;
    volatile boolean O00000Oo;
    jpy O00000o;
    jri O00000o0;
    private boolean O00000oO;

    protected jrh(jrg jrg, jri jri) {
        this.f2093O000000o = jrg;
        this.O00000o0 = jri;
    }

    class O000000o implements jpj.O000000o {
        private final int O00000Oo;
        private final boolean O00000o;
        private final jri O00000o0;

        O000000o(int i, jri jri, boolean z) {
            this.O00000Oo = i;
            this.O00000o0 = jri;
            this.O00000o = z;
        }

        public final jri O000000o() {
            return this.O00000o0;
        }

        public final jrk O000000o(jri jri) throws IOException {
            if (this.O00000Oo >= jrh.this.f2093O000000o.O00000oO.size()) {
                return jrh.this.O000000o(jri, this.O00000o);
            }
            O000000o o000000o = new O000000o(this.O00000Oo + 1, jri, this.O00000o);
            jpj jpj = jrh.this.f2093O000000o.O00000oO.get(this.O00000Oo);
            jrk O000000o2 = jpj.O000000o(o000000o);
            if (O000000o2 != null) {
                return O000000o2;
            }
            throw new NullPointerException("application interceptor " + jpj + " returned null");
        }
    }

    public final jrk O000000o() throws IOException {
        synchronized (this) {
            if (!this.O00000oO) {
                this.O00000oO = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.f2093O000000o.f2091O000000o.O000000o(this);
            jrk O000000o2 = new O000000o(0, this.O00000o0, false).O000000o(this.O00000o0);
            if (O000000o2 != null) {
                return O000000o2;
            }
            throw new IOException("Canceled");
        } finally {
            this.f2093O000000o.f2091O000000o.O000000o((joy) this);
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:61:0x00f5 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:305:0x04e2 */
    /* JADX INFO: additional move instructions added (3) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:198:0x02d2 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
     arg types: [ss.q, int]
     candidates:
      _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
      _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
      _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
      _m_j.jqp.O000000o(ss.q, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01e3, code lost:
        r2 = r0;
        r13 = r4;
        r11 = r6;
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01eb, code lost:
        r2 = r0;
        r13 = r4;
        r11 = r6;
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01f2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01f3, code lost:
        r9 = r2;
        r13 = r4;
        r11 = r6;
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01fa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01fb, code lost:
        r9 = r2;
        r13 = r4;
        r11 = r6;
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x022a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x022b, code lost:
        r2 = r0;
        r13 = r4;
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0231, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0232, code lost:
        r2 = r0;
        r13 = r4;
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0255, code lost:
        if (r1 > 0) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x02d7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x02da, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x036e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x036f, code lost:
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0371, code lost:
        r2 = r0;
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0375, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0376, code lost:
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0378, code lost:
        r2 = r0;
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x037c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x037d, code lost:
        r31 = r14;
        r2 = r0;
        r13 = r4;
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0382, code lost:
        r4 = r26;
        r9 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0388, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0389, code lost:
        r31 = r14;
        r2 = r0;
        r13 = r4;
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x038e, code lost:
        r4 = r26;
        r9 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0394, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0395, code lost:
        r31 = r14;
        r9 = r2;
        r13 = r4;
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x039a, code lost:
        r4 = r26;
        r7 = -1;
        r1 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x03a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x03a5, code lost:
        r31 = r14;
        r9 = r2;
        r13 = r4;
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x03aa, code lost:
        r4 = r26;
        r7 = -1;
        r1 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x04e8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x04ea, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x04ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x04ee, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x04f0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x04f1, code lost:
        r23 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x04f3, code lost:
        r24 = r6;
        r25 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x04f7, code lost:
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x04fa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x04fb, code lost:
        r23 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x04fd, code lost:
        r24 = r6;
        r25 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0501, code lost:
        r31 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x053c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x053d, code lost:
        r22 = true;
        r1 = r41;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0544, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0545, code lost:
        r25 = r3;
        r31 = r4;
        r23 = r5;
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x054d, code lost:
        r13 = r9;
        r4 = r11;
        r7 = -1;
        r1 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x0557, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0558, code lost:
        r25 = r3;
        r31 = r4;
        r23 = r5;
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x0560, code lost:
        r13 = r9;
        r4 = r11;
        r7 = -1;
        r1 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x056a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x07e6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:483:0x07e7, code lost:
        r9 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x07ea, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:485:0x07eb, code lost:
        r9 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:502:0x0818, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:503:0x0819, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:547:0x08ae, code lost:
        if (r11.equals("HEAD") == false) goto L_0x085f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:594:0x09ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:595:0x09ae, code lost:
        r25 = r3;
        r31 = r4;
        r23 = r5;
        r24 = r6;
        r18 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:599:0x09c1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:600:0x09c2, code lost:
        r25 = r3;
        r31 = r4;
        r23 = r5;
        r24 = r6;
        r18 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:604:0x09d5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:606:0x09d7, code lost:
        r2 = r0;
        r22 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:607:0x09dc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:608:0x09dd, code lost:
        r25 = r3;
        r31 = r4;
        r23 = r5;
        r24 = r6;
        r18 = r8;
        r4 = r11;
        r7 = r12;
        r13 = r9;
        r11 = r10;
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:619:0x0a00, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:620:0x0a01, code lost:
        r25 = r3;
        r31 = r4;
        r23 = r5;
        r24 = r6;
        r18 = r8;
        r4 = r11;
        r7 = r12;
        r13 = r9;
        r11 = r10;
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:629:0x0a36, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:631:0x0a38, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:633:0x0a3d, code lost:
        throw r2.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:634:0x0a3e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:635:0x0a40, code lost:
        if (r22 != false) goto L_0x0a42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:636:0x0a42, code lost:
        r1.O00000o.O00000o0().O00000Oo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:637:0x0a4b, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x02e6 A[Catch:{ all -> 0x04de, l -> 0x056a, o -> 0x052b, IOException -> 0x051a, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0337 A[Catch:{ all -> 0x04de, l -> 0x056a, o -> 0x052b, IOException -> 0x051a, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x033f A[Catch:{ all -> 0x04de, l -> 0x056a, o -> 0x052b, IOException -> 0x051a, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x035b A[Catch:{ all -> 0x04de, l -> 0x056a, o -> 0x052b, IOException -> 0x051a, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0365 A[Catch:{ all -> 0x04de, l -> 0x056a, o -> 0x052b, IOException -> 0x051a, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x03fa A[Catch:{ all -> 0x04de, l -> 0x056a, o -> 0x052b, IOException -> 0x051a, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x042d A[Catch:{ all -> 0x04de, l -> 0x056a, o -> 0x052b, IOException -> 0x051a, all -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0458 A[SYNTHETIC, Splitter:B:276:0x0458] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x053c A[ExcHandler: all (r0v54 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:30:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x056a A[ExcHandler: l (e ss.ss.gK.l), Splitter:B:19:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x06a4 A[Catch:{ l -> 0x0818, o -> 0x07ea, IOException -> 0x07e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x06d2 A[Catch:{ l -> 0x0818, o -> 0x07e4, IOException -> 0x07e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x0725 A[Catch:{ l -> 0x0818, o -> 0x07e4, IOException -> 0x07e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x072d A[Catch:{ l -> 0x0818, o -> 0x07e4, IOException -> 0x07e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0761 A[Catch:{ l -> 0x0818, o -> 0x07e4, IOException -> 0x07e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x0818 A[ExcHandler: l (r0v20 'e' ss.ss.gK.l A[CUSTOM_DECLARE]), Splitter:B:419:0x0670] */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x082a  */
    /* JADX WARNING: Removed duplicated region for block: B:560:0x08ea  */
    /* JADX WARNING: Removed duplicated region for block: B:565:0x090a  */
    /* JADX WARNING: Removed duplicated region for block: B:568:0x0914  */
    /* JADX WARNING: Removed duplicated region for block: B:575:0x092d  */
    /* JADX WARNING: Removed duplicated region for block: B:604:0x09d5 A[ExcHandler: all (th java.lang.Throwable), PHI: r1 10  PHI: (r1v11 _m_j.jrh) = (r1v1 _m_j.jrh), (r1v1 _m_j.jrh), (r1v1 _m_j.jrh), (r1v1 _m_j.jrh), (r1v16 _m_j.jrh), (r1v16 _m_j.jrh) binds: [B:13:0x0067, B:14:?, B:15:0x0069, B:16:?, B:346:0x0581, B:347:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:13:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:617:0x09ff A[SYNTHETIC, Splitter:B:617:0x09ff] */
    /* JADX WARNING: Removed duplicated region for block: B:624:0x0a1f A[Catch:{ l -> 0x0a36, o -> 0x0a00, IOException -> 0x09dc, all -> 0x09d5, all -> 0x0a3e }] */
    /* JADX WARNING: Removed duplicated region for block: B:629:0x0a36 A[Catch:{ l -> 0x0a36, o -> 0x0a00, IOException -> 0x09dc, all -> 0x09d5, all -> 0x0a3e }, ExcHandler: l (e ss.ss.gK.l), Splitter:B:13:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:636:0x0a42  */
    /* JADX WARNING: Removed duplicated region for block: B:640:0x098b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:647:0x0925 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:650:0x0a31 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final jrk O000000o(jri jri, boolean z) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        String str8;
        String str9;
        long j;
        String str10;
        o oVar;
        jpy O000000o2;
        String str11;
        String str12;
        String str13;
        String str14;
        long j2;
        IOException iOException;
        String str15;
        long j3;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        jpy jpy;
        String str31;
        jqh jqh;
        String str32;
        jri jri2;
        jqh jqh2;
        String O000000o3;
        q O00000o02;
        String str33;
        String str34;
        Proxy proxy;
        String str35;
        String str36;
        String str37;
        o oVar2;
        String str38;
        o oVar3;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        IOException iOException2;
        String str45;
        IOException iOException3;
        String str46;
        String str47;
        jrk jrk;
        jrk O00000Oo2;
        boolean z2;
        Date O00000Oo3;
        String str48;
        jrk jrk2;
        jri jri3;
        jpt jpt;
        iqy O000000o4;
        jrk O00000Oo4;
        ? r14;
        long j4;
        String str49;
        String str50;
        long j5;
        long j6;
        long j7;
        jri O000000o5;
        String str51;
        String str52;
        String str53;
        jrh jrh = this;
        String str54 = "Last-Modified";
        String str55 = "User-Agent";
        String str56 = "Accept-Encoding";
        String str57 = "Connection";
        String str58 = "Host";
        jri jri4 = jri;
        jrj jrj = jri4.O00000o;
        String str59 = "Content-Type";
        String str60 = "Transfer-Encoding";
        String str61 = "Content-Length";
        long j8 = -1;
        if (jrj != null) {
            jri.O000000o O000000o6 = jri.O000000o();
            jpk O000000o7 = jrj.O000000o();
            if (O000000o7 != null) {
                O000000o6.O000000o(str59, O000000o7.toString());
            }
            long O00000Oo5 = jrj.O00000Oo();
            if (O00000Oo5 != -1) {
                O000000o6.O000000o(str61, Long.toString(O00000Oo5));
                O000000o6.O000000o(str60);
            } else {
                O000000o6.O000000o(str60, "chunked");
                O000000o6.O000000o(str61);
            }
            jri4 = O000000o6.O000000o();
        }
        jrh.O00000o = new jpy(jrh.f2093O000000o, jri4, false, false, z, null, null, null);
        int i2 = 0;
        while (!jrh.O00000Oo) {
            try {
                jpy jpy2 = jrh.O00000o;
                i = i2;
                if (jpy2.O0000oO0 == null) {
                    try {
                        if (jpy2.O00000oO == null) {
                            jri jri5 = jpy2.O0000Oo0;
                            jri.O000000o O000000o8 = jri5.O000000o();
                            if (jri5.O000000o(str58) == null) {
                                try {
                                    O000000o8.O000000o(str58, jqp.O000000o(jri5.f2095O000000o, false));
                                } catch (l e) {
                                } catch (o e2) {
                                    e = e2;
                                    String str62 = str55;
                                    str18 = str56;
                                    String str63 = str57;
                                    String str64 = str58;
                                    str16 = str59;
                                    str17 = str61;
                                    j2 = -1;
                                    str12 = str54;
                                    String str65 = str60;
                                    oVar = e;
                                    O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                    if (O000000o2 != null) {
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    str5 = str55;
                                    str21 = str56;
                                    str7 = str57;
                                    str6 = str58;
                                    str19 = str59;
                                    str20 = str61;
                                    j3 = -1;
                                    str9 = str54;
                                    String str66 = str60;
                                    iOException = e;
                                    O000000o2 = jrh.O00000o.O000000o(iOException);
                                    if (O000000o2 == null) {
                                    }
                                    try {
                                        jrh.O00000o = O000000o2;
                                        str54 = str9;
                                        str60 = str8;
                                        str59 = r13;
                                        str57 = str7;
                                        str58 = str6;
                                        str55 = str5;
                                        str61 = str10;
                                        j8 = j;
                                        i2 = i;
                                        str56 = str;
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        boolean z3 = false;
                                    }
                                }
                            }
                            if (jri5.O000000o(str57) == null) {
                                O000000o8.O000000o(str57, "Keep-Alive");
                            }
                            if (jri5.O000000o(str56) == null) {
                                jpy2.O0000O0o = true;
                                O000000o8.O000000o(str56, "gzip");
                            }
                            List<jpd> O000000o9 = jpy2.O00000Oo.O0000OOo.O000000o();
                            if (!O000000o9.isEmpty()) {
                                O000000o8.O000000o("Cookie", jpy.O000000o(O000000o9));
                            }
                            if (jri5.O000000o(str55) == null) {
                                O000000o8.O000000o(str55, "");
                            }
                            jri O000000o10 = O000000o8.O000000o();
                            jpo O000000o11 = jpn.O00000Oo.O000000o(jpy2.O00000Oo);
                            if (O000000o11 != null) {
                                jrk2 = O000000o11.O000000o();
                                str48 = str55;
                                str22 = str56;
                            } else {
                                str48 = str55;
                                str22 = str56;
                                jrk2 = null;
                            }
                            str7 = str57;
                            jpt.O000000o o000000o = new jpt.O000000o(System.currentTimeMillis(), O000000o10, jrk2);
                            if (o000000o.O00000o0 == null) {
                                try {
                                    str6 = str58;
                                    str5 = str48;
                                    try {
                                        jpt = new jpt(o000000o.O00000Oo, null, (byte) 0);
                                    } catch (l e4) {
                                    } catch (o e5) {
                                        e = e5;
                                        str16 = str59;
                                        str17 = str61;
                                        str18 = str22;
                                        j2 = -1;
                                        str12 = str54;
                                        String str652 = str60;
                                        oVar = e;
                                        O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                        if (O000000o2 != null) {
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                        str19 = str59;
                                        str20 = str61;
                                        str21 = str22;
                                        j3 = -1;
                                        str9 = str54;
                                        String str662 = str60;
                                        iOException = e;
                                        O000000o2 = jrh.O00000o.O000000o(iOException);
                                        if (O000000o2 == null) {
                                        }
                                        jrh.O00000o = O000000o2;
                                        str54 = str9;
                                        str60 = str8;
                                        str59 = r13;
                                        str57 = str7;
                                        str58 = str6;
                                        str55 = str5;
                                        str61 = str10;
                                        j8 = j;
                                        i2 = i;
                                        str56 = str;
                                    }
                                } catch (l e42) {
                                } catch (o e7) {
                                    e = e7;
                                    str6 = str58;
                                    str5 = str48;
                                    str16 = str59;
                                    str17 = str61;
                                    str18 = str22;
                                    j2 = -1;
                                    str12 = str54;
                                    String str6522 = str60;
                                    oVar = e;
                                    O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                    if (O000000o2 != null) {
                                    }
                                } catch (IOException e8) {
                                    e = e8;
                                    str6 = str58;
                                    str5 = str48;
                                    str19 = str59;
                                    str20 = str61;
                                    str21 = str22;
                                    j3 = -1;
                                    str9 = str54;
                                    String str6622 = str60;
                                    iOException = e;
                                    O000000o2 = jrh.O00000o.O000000o(iOException);
                                    if (O000000o2 == null) {
                                    }
                                    jrh.O00000o = O000000o2;
                                    str54 = str9;
                                    str60 = str8;
                                    str59 = r13;
                                    str57 = str7;
                                    str58 = str6;
                                    str55 = str5;
                                    str61 = str10;
                                    j8 = j;
                                    i2 = i;
                                    str56 = str;
                                }
                            } else {
                                str6 = str58;
                                str5 = str48;
                                if (o000000o.O00000Oo.f2095O000000o.O00000Oo()) {
                                    if (o000000o.O00000o0.O00000oO == null) {
                                        jpt = new jpt(o000000o.O00000Oo, null, (byte) 0);
                                    }
                                }
                                if (!jpt.O000000o(o000000o.O00000o0, o000000o.O00000Oo)) {
                                    jpt = new jpt(o000000o.O00000Oo, null, (byte) 0);
                                } else {
                                    jox O00000Oo6 = o000000o.O00000Oo.O00000Oo();
                                    if (!O00000Oo6.O00000o0) {
                                        if (!jpt.O000000o.O000000o(o000000o.O00000Oo)) {
                                            if (o000000o.O00000o != null) {
                                                str50 = str59;
                                                str49 = str60;
                                                try {
                                                    str4 = str61;
                                                    try {
                                                        j4 = Math.max(0L, o000000o.O0000Oo - o000000o.O00000o.getTime());
                                                    } catch (l e422) {
                                                    } catch (o e9) {
                                                        e = e9;
                                                        str24 = str54;
                                                        str23 = str50;
                                                        str25 = str49;
                                                        str = str22;
                                                        str14 = str4;
                                                        j2 = -1;
                                                        oVar = e;
                                                        O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                                        if (O000000o2 != null) {
                                                        }
                                                    } catch (IOException e10) {
                                                        e = e10;
                                                        str27 = str54;
                                                        str26 = str50;
                                                        str28 = str49;
                                                        str = str22;
                                                        str15 = str4;
                                                        j3 = -1;
                                                        iOException = e;
                                                        O000000o2 = jrh.O00000o.O000000o(iOException);
                                                        if (O000000o2 == null) {
                                                        }
                                                        jrh.O00000o = O000000o2;
                                                        str54 = str9;
                                                        str60 = str8;
                                                        str59 = r13;
                                                        str57 = str7;
                                                        str58 = str6;
                                                        str55 = str5;
                                                        str61 = str10;
                                                        j8 = j;
                                                        i2 = i;
                                                        str56 = str;
                                                    }
                                                } catch (l e4222) {
                                                } catch (o e11) {
                                                    str12 = str54;
                                                    String str67 = str50;
                                                    str13 = str61;
                                                    str = str22;
                                                    j = -1;
                                                    oVar = e11;
                                                    str11 = str49;
                                                    O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                                    if (O000000o2 != null) {
                                                        jrh.O00000o = O000000o2;
                                                        str54 = str9;
                                                        str60 = str8;
                                                        str59 = r13;
                                                        str57 = str7;
                                                        str58 = str6;
                                                        str55 = str5;
                                                        str61 = str10;
                                                        j8 = j;
                                                        i2 = i;
                                                        str56 = str;
                                                    } else {
                                                        throw oVar.a();
                                                    }
                                                } catch (IOException e12) {
                                                    str9 = str54;
                                                    String str68 = str50;
                                                    str10 = str61;
                                                    str = str22;
                                                    j = -1;
                                                    iOException = e12;
                                                    str8 = str49;
                                                    O000000o2 = jrh.O00000o.O000000o(iOException);
                                                    if (O000000o2 == null) {
                                                        throw iOException;
                                                    }
                                                    jrh.O00000o = O000000o2;
                                                    str54 = str9;
                                                    str60 = str8;
                                                    str59 = str68;
                                                    str57 = str7;
                                                    str58 = str6;
                                                    str55 = str5;
                                                    str61 = str10;
                                                    j8 = j;
                                                    i2 = i;
                                                    str56 = str;
                                                }
                                            } else {
                                                str50 = str59;
                                                str49 = str60;
                                                str4 = str61;
                                                j4 = 0;
                                            }
                                            if (o000000o.O0000Ooo != -1) {
                                                str3 = str54;
                                                j4 = Math.max(j4, TimeUnit.SECONDS.toMillis((long) o000000o.O0000Ooo));
                                            } else {
                                                str3 = str54;
                                            }
                                            str2 = str49;
                                            jri3 = O000000o10;
                                            long j9 = j4 + (o000000o.O0000Oo - o000000o.O0000Oo0) + (o000000o.f2035O000000o - o000000o.O0000Oo);
                                            jox O00000Oo7 = o000000o.O00000o0.O00000Oo();
                                            if (O00000Oo7.O00000oO != -1) {
                                                j5 = TimeUnit.SECONDS.toMillis((long) O00000Oo7.O00000oO);
                                            } else {
                                                if (o000000o.O0000OOo != null) {
                                                    j5 = o000000o.O0000OOo.getTime() - (o000000o.O00000o != null ? o000000o.O00000o.getTime() : o000000o.O0000Oo);
                                                } else if (o000000o.O00000oo != null) {
                                                    q qVar = o000000o.O00000o0.f2098O000000o.f2095O000000o;
                                                    if (qVar.O00000o == null) {
                                                        str53 = null;
                                                    } else {
                                                        StringBuilder sb = new StringBuilder();
                                                        q.O00000Oo(sb, qVar.O00000o);
                                                        str53 = sb.toString();
                                                    }
                                                    if (str53 == null) {
                                                        long time = (o000000o.O00000o != null ? o000000o.O00000o.getTime() : o000000o.O0000Oo0) - o000000o.O00000oo.getTime();
                                                        if (time > 0) {
                                                            j5 = time / 10;
                                                        }
                                                    }
                                                }
                                                j5 = 0;
                                            }
                                            if (O00000Oo6.O00000oO != -1) {
                                                j5 = Math.min(j5, TimeUnit.SECONDS.toMillis((long) O00000Oo6.O00000oO));
                                            }
                                            if (O00000Oo6.O0000Oo != -1) {
                                                j6 = TimeUnit.SECONDS.toMillis((long) O00000Oo6.O0000Oo);
                                            } else {
                                                j6 = 0;
                                            }
                                            jox O00000Oo8 = o000000o.O00000o0.O00000Oo();
                                            if (!O00000Oo8.O0000OOo) {
                                                str = str22;
                                                str22 = -1;
                                                if (O00000Oo6.O0000Oo0 != -1) {
                                                    str22 = str50;
                                                    j7 = TimeUnit.SECONDS.toMillis((long) O00000Oo6.O0000Oo0);
                                                    if (!O00000Oo8.O00000o0) {
                                                        long j10 = j6 + j9;
                                                        if (j10 < j7 + j5) {
                                                            jrk.O000000o O000000o12 = o000000o.O00000o0.O000000o();
                                                            if (j10 >= j5) {
                                                                O000000o12.O00000Oo("Warning", "110 HttpURLConnection \"Response is stale\"");
                                                            }
                                                            if (j9 > 86400000) {
                                                                if (o000000o.O00000o0.O00000Oo().O00000oO == -1 && o000000o.O0000OOo == null) {
                                                                    O000000o12.O00000Oo("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                                                }
                                                            }
                                                            jpt = new jpt(null, O000000o12.O000000o(), (byte) 0);
                                                            r14 = str22;
                                                            if (jpt.f2034O000000o != null && o000000o.O00000Oo.O00000Oo().O0000OoO) {
                                                                jpt = new jpt(null, null, (byte) 0);
                                                            }
                                                            jpy2.O0000oO0 = jpt;
                                                            jpy2.O0000Oo = jpy2.O0000oO0.f2034O000000o;
                                                            jpy2.O0000OoO = jpy2.O0000oO0.O00000Oo;
                                                            if (jrk2 != null && jpy2.O0000OoO == null) {
                                                                jqp.O000000o(jrk2.O0000O0o);
                                                            }
                                                            if (jpy2.O0000Oo != null && jpy2.O0000OoO == null) {
                                                                jrk.O000000o o000000o2 = new jrk.O000000o();
                                                                o000000o2.f2099O000000o = jpy2.O0000Oo0;
                                                                jrk.O000000o O00000o03 = o000000o2.O00000o0(jpy.O000000o(jpy2.O00000o));
                                                                O00000o03.O00000Oo = u.HTTP_1_1;
                                                                O00000o03.O00000o0 = 504;
                                                                O00000o03.O00000o = "Unsatisfiable Request (only-if-cached)";
                                                                O00000o03.O0000O0o = jpy.f2043O000000o;
                                                                O00000Oo4 = O00000o03.O000000o();
                                                            } else if (jpy2.O0000Oo != null) {
                                                                jrk.O000000o O000000o13 = jpy2.O0000OoO.O000000o();
                                                                O000000o13.f2099O000000o = jpy2.O0000Oo0;
                                                                jpy2.O0000Ooo = O000000o13.O00000o0(jpy.O000000o(jpy2.O00000o)).O00000Oo(jpy.O000000o(jpy2.O0000OoO)).O000000o();
                                                                O00000Oo4 = jpy2.O00000Oo(jpy2.O0000Ooo);
                                                            } else {
                                                                jpy2.O00000oO = jpy2.O00000o0.O000000o(jpy2.O00000Oo.O0000oo, jpy2.O00000Oo.O0000ooO, jpy2.O00000Oo.O0000ooo, jpy2.O00000Oo.O0000oo0, !jpy2.O0000Oo.O00000Oo.equals("GET"));
                                                                jpy2.O00000oO.O000000o(jpy2);
                                                                if (jpy2.O0000o0O && jpy.O000000o(jpy2.O0000Oo) && jpy2.O0000o00 == null) {
                                                                    long O000000o14 = jqb.O000000o(jri3);
                                                                    if (!jpy2.O0000OOo) {
                                                                        jpy2.O00000oO.O000000o(jpy2.O0000Oo);
                                                                        O000000o4 = jpy2.O00000oO.O000000o(jpy2.O0000Oo, O000000o14);
                                                                    } else if (O000000o14 > 2147483647L) {
                                                                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                                                                    } else if (O000000o14 != -1) {
                                                                        jpy2.O00000oO.O000000o(jpy2.O0000Oo);
                                                                        jpy2.O0000o00 = new jqe((int) O000000o14);
                                                                    } else {
                                                                        O000000o4 = new jqe();
                                                                    }
                                                                    jpy2.O0000o00 = O000000o4;
                                                                }
                                                            }
                                                            jpy2.O0000Ooo = O00000Oo4;
                                                        }
                                                    }
                                                    jri.O000000o O000000o15 = o000000o.O00000Oo.O000000o();
                                                    if (o000000o.O0000OoO == null) {
                                                        str51 = "If-None-Match";
                                                        str52 = o000000o.O0000OoO;
                                                    } else if (o000000o.O00000oo != null) {
                                                        str51 = "If-Modified-Since";
                                                        str52 = o000000o.O0000O0o;
                                                    } else {
                                                        if (o000000o.O00000o != null) {
                                                            str51 = "If-Modified-Since";
                                                            str52 = o000000o.O00000oO;
                                                        }
                                                        O000000o5 = O000000o15.O000000o();
                                                        if (jpt.O000000o.O000000o(O000000o5)) {
                                                            jpt = new jpt(O000000o5, o000000o.O00000o0, (byte) 0);
                                                            r14 = str22;
                                                        } else {
                                                            jpt = new jpt(O000000o5, null, (byte) 0);
                                                            r14 = str22;
                                                        }
                                                        jpt = new jpt(null, null, (byte) 0);
                                                        jpy2.O0000oO0 = jpt;
                                                        jpy2.O0000Oo = jpy2.O0000oO0.f2034O000000o;
                                                        jpy2.O0000OoO = jpy2.O0000oO0.O00000Oo;
                                                        jqp.O000000o(jrk2.O0000O0o);
                                                        if (jpy2.O0000Oo != null) {
                                                        }
                                                        if (jpy2.O0000Oo != null) {
                                                        }
                                                    }
                                                    O000000o15.O000000o(str51, str52);
                                                    O000000o5 = O000000o15.O000000o();
                                                    if (jpt.O000000o.O000000o(O000000o5)) {
                                                    }
                                                    jpt = new jpt(null, null, (byte) 0);
                                                    jpy2.O0000oO0 = jpt;
                                                    jpy2.O0000Oo = jpy2.O0000oO0.f2034O000000o;
                                                    jpy2.O0000OoO = jpy2.O0000oO0.O00000Oo;
                                                    jqp.O000000o(jrk2.O0000O0o);
                                                    if (jpy2.O0000Oo != null) {
                                                    }
                                                    if (jpy2.O0000Oo != null) {
                                                    }
                                                }
                                            } else {
                                                str = str22;
                                            }
                                            str22 = str50;
                                            j7 = 0;
                                            if (!O00000Oo8.O00000o0) {
                                            }
                                            jri.O000000o O000000o152 = o000000o.O00000Oo.O000000o();
                                            if (o000000o.O0000OoO == null) {
                                            }
                                            O000000o152.O000000o(str51, str52);
                                            O000000o5 = O000000o152.O000000o();
                                            if (jpt.O000000o.O000000o(O000000o5)) {
                                            }
                                            jpt = new jpt(null, null, (byte) 0);
                                            jpy2.O0000oO0 = jpt;
                                            jpy2.O0000Oo = jpy2.O0000oO0.f2034O000000o;
                                            jpy2.O0000OoO = jpy2.O0000oO0.O00000Oo;
                                            jqp.O000000o(jrk2.O0000O0o);
                                            if (jpy2.O0000Oo != null) {
                                            }
                                            if (jpy2.O0000Oo != null) {
                                            }
                                        }
                                    }
                                    str3 = str54;
                                    jri3 = O000000o10;
                                    str2 = str60;
                                    str4 = str61;
                                    str = str22;
                                    r14 = str59;
                                    jpt = new jpt(o000000o.O00000Oo, null, (byte) 0);
                                    jpt = new jpt(null, null, (byte) 0);
                                    jpy2.O0000oO0 = jpt;
                                    jpy2.O0000Oo = jpy2.O0000oO0.f2034O000000o;
                                    jpy2.O0000OoO = jpy2.O0000oO0.O00000Oo;
                                    jqp.O000000o(jrk2.O0000O0o);
                                    if (jpy2.O0000Oo != null) {
                                    }
                                    if (jpy2.O0000Oo != null) {
                                    }
                                }
                            }
                            str3 = str54;
                            jri3 = O000000o10;
                            str2 = str60;
                            str4 = str61;
                            str = str22;
                            r14 = str59;
                            jpt = new jpt(null, null, (byte) 0);
                            jpy2.O0000oO0 = jpt;
                            jpy2.O0000Oo = jpy2.O0000oO0.f2034O000000o;
                            jpy2.O0000OoO = jpy2.O0000oO0.O00000Oo;
                            jqp.O000000o(jrk2.O0000O0o);
                            if (jpy2.O0000Oo != null) {
                            }
                            if (jpy2.O0000Oo != null) {
                            }
                        } else {
                            String str69 = str54;
                            String str70 = str55;
                            String str71 = str56;
                            String str72 = str57;
                            String str73 = str58;
                            String str74 = str59;
                            String str75 = str60;
                            String str76 = str61;
                            throw new IllegalStateException();
                        }
                    } catch (l e13) {
                    } catch (o e14) {
                        o oVar4 = e14;
                        String str77 = str22;
                        str13 = str4;
                        String str78 = str3;
                        str11 = str2;
                        j = -1;
                        jrh = this;
                        O000000o2 = jrh.O00000o.O000000o(oVar.a());
                        if (O000000o2 != null) {
                        }
                    } catch (IOException e15) {
                        IOException iOException4 = e15;
                        String str79 = str22;
                        str10 = str4;
                        String str80 = str3;
                        str8 = str2;
                        j = -1;
                        jrh = this;
                        O000000o2 = jrh.O00000o.O000000o(iOException);
                        if (O000000o2 == null) {
                        }
                        jrh.O00000o = O000000o2;
                        str54 = str9;
                        str60 = str8;
                        str59 = str68;
                        str57 = str7;
                        str58 = str6;
                        str55 = str5;
                        str61 = str10;
                        j8 = j;
                        i2 = i;
                        str56 = str;
                    } catch (Throwable th3) {
                    }
                } else {
                    str3 = str54;
                    str5 = str55;
                    str = str56;
                    str7 = str57;
                    str6 = str58;
                    str22 = str59;
                    str2 = str60;
                    str4 = str61;
                }
                jrh = this;
                jpy jpy3 = jrh.O00000o;
                if (jpy3.O0000Ooo == null) {
                    try {
                        if (jpy3.O0000Oo == null) {
                            try {
                                if (jpy3.O0000OoO == null) {
                                    throw new IllegalStateException("call sendRequest() first!");
                                }
                            } catch (l e42222) {
                            } catch (o e16) {
                                oVar2 = e16;
                                str35 = str22;
                                str37 = str4;
                                str36 = str3;
                                str38 = str2;
                                j = -1;
                                O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                if (O000000o2 != null) {
                                }
                            } catch (IOException e17) {
                                iOException2 = e17;
                                str42 = str22;
                                str44 = str4;
                                str43 = str3;
                                str45 = str2;
                                j = -1;
                                O000000o2 = jrh.O00000o.O000000o(iOException);
                                if (O000000o2 == null) {
                                }
                                jrh.O00000o = O000000o2;
                                str54 = str9;
                                str60 = str8;
                                str59 = str68;
                                str57 = str7;
                                str58 = str6;
                                str55 = str5;
                                str61 = str10;
                                j8 = j;
                                i2 = i;
                                str56 = str;
                            }
                        }
                        if (jpy3.O0000Oo != null) {
                            if (jpy3.O0000o0o) {
                                jpy3.O00000oO.O000000o(jpy3.O0000Oo);
                                str30 = str4;
                                j = -1;
                            } else if (!jpy3.O0000o0O) {
                                try {
                                    try {
                                        jrk = new jpy.O000000o(0, jpy3.O0000Oo, jpy3.O00000o0.O000000o()).O000000o(jpy3.O0000Oo);
                                        str30 = str4;
                                        j = -1;
                                        jpy3.O000000o(jrk.O00000oo);
                                        if (jpy3.O0000OoO == null) {
                                            jrk jrk3 = jpy3.O0000OoO;
                                            if (jrk.O00000o0 == 304) {
                                                str29 = str3;
                                            } else {
                                                str29 = str3;
                                                Date O00000Oo9 = jrk3.O00000oo.O00000Oo(str29);
                                                if (O00000Oo9 == null || (O00000Oo3 = jrk.O00000oo.O00000Oo(str29)) == null || O00000Oo3.getTime() >= O00000Oo9.getTime()) {
                                                    z2 = false;
                                                    if (!z2) {
                                                        jrk.O000000o O000000o16 = jpy3.O0000OoO.O000000o();
                                                        O000000o16.f2099O000000o = jpy3.O0000Oo0;
                                                        jpy3.O0000Ooo = O000000o16.O00000o0(jpy.O000000o(jpy3.O00000o)).O000000o(jpy.O000000o(jpy3.O0000OoO.O00000oo, jrk.O00000oo)).O00000Oo(jpy.O000000o(jpy3.O0000OoO)).O000000o(jpy.O000000o(jrk)).O000000o();
                                                        jrk.O0000O0o.close();
                                                        jpy3.O00000Oo();
                                                        jpn jpn = jpn.O00000Oo;
                                                        jpy.O000000o(jpy3.O0000Ooo);
                                                        O00000Oo2 = jpy3.O00000Oo(jpy3.O0000Ooo);
                                                    } else {
                                                        jqp.O000000o(jpy3.O0000OoO.O0000O0o);
                                                        jrk.O000000o O000000o17 = jrk.O000000o();
                                                        O000000o17.f2099O000000o = jpy3.O0000Oo0;
                                                        jpy3.O0000Ooo = O000000o17.O00000o0(jpy.O000000o(jpy3.O00000o)).O00000Oo(jpy.O000000o(jpy3.O0000OoO)).O000000o(jpy.O000000o(jrk)).O000000o();
                                                        if (jpy.O00000o0(jpy3.O0000Ooo)) {
                                                            jpo O000000o18 = jpn.O00000Oo.O000000o(jpy3.O00000Oo);
                                                            if (O000000o18 != null) {
                                                                if (!jpt.O000000o(jpy3.O0000Ooo, jpy3.O0000Oo)) {
                                                                    String str81 = jpy3.O0000Oo.O00000Oo;
                                                                    if (!str81.equals("POST") && !str81.equals("PATCH") && !str81.equals("PUT") && !str81.equals("DELETE")) {
                                                                        str81.equals("MOVE");
                                                                    }
                                                                } else {
                                                                    jpy.O000000o(jpy3.O0000Ooo);
                                                                    jpy3.O0000o = O000000o18.O00000Oo();
                                                                }
                                                            }
                                                            jps jps = jpy3.O0000o;
                                                            jrk jrk4 = jpy3.O0000Ooo;
                                                            if (jps != null) {
                                                                iqy O000000o19 = jps.O000000o();
                                                                if (O000000o19 != null) {
                                                                    jpy.AnonymousClass2 r12 = new iqz(jrk4.O0000O0o.O00000o0(), jps, iqt.O000000o(O000000o19)) {
                                                                        /* class _m_j.jpy.AnonymousClass2 */

                                                                        /* renamed from: O000000o */
                                                                        boolean f2044O000000o;
                                                                        final /* synthetic */ iqn O00000Oo;
                                                                        final /* synthetic */ iqm O00000o;
                                                                        final /* synthetic */ jps O00000o0;

                                                                        {
                                                                            this.O00000Oo = r2;
                                                                            this.O00000o0 = r3;
                                                                            this.O00000o = r4;
                                                                        }

                                                                        public final ira O000000o() {
                                                                            return this.O00000Oo.O000000o();
                                                                        }

                                                                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                                                         method: _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
                                                                         arg types: [_m_j.jpy$2, java.util.concurrent.TimeUnit]
                                                                         candidates:
                                                                          _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
                                                                          _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
                                                                          _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
                                                                          _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
                                                                          _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean */
                                                                        public final void close() {
                                                                            if (!this.f2044O000000o && !jqp.O000000o((iqz) this, TimeUnit.MILLISECONDS)) {
                                                                                this.f2044O000000o = true;
                                                                            }
                                                                            this.O00000Oo.close();
                                                                        }

                                                                        public final long O000000o(iql iql, long j) {
                                                                            try {
                                                                                long O000000o2 = this.O00000Oo.O000000o(iql, j);
                                                                                if (O000000o2 == -1) {
                                                                                    if (!this.f2044O000000o) {
                                                                                        this.f2044O000000o = true;
                                                                                        this.O00000o.close();
                                                                                    }
                                                                                    return -1;
                                                                                }
                                                                                iql.O000000o(this.O00000o.O00000Oo(), iql.O00000Oo - O000000o2, O000000o2);
                                                                                this.O00000o.O0000o();
                                                                                return O000000o2;
                                                                            } catch (IOException e) {
                                                                                if (!this.f2044O000000o) {
                                                                                    this.f2044O000000o = true;
                                                                                }
                                                                                throw e;
                                                                            }
                                                                        }
                                                                    };
                                                                    jrk.O000000o O000000o20 = jrk4.O000000o();
                                                                    O000000o20.O0000O0o = new jqc(jrk4.O00000oo, iqt.O000000o(r12));
                                                                    jrk4 = O000000o20.O000000o();
                                                                }
                                                            }
                                                            O00000Oo2 = jpy3.O00000Oo(jrk4);
                                                        }
                                                        jpy = jrh.O00000o;
                                                        if (jpy.O0000Ooo != null) {
                                                            jrk jrk5 = jpy.O0000Ooo;
                                                            jpy jpy4 = jrh.O00000o;
                                                            if (jpy4.O0000Ooo != null) {
                                                                jqr O000000o21 = jpy4.O00000o0.O000000o();
                                                                jou O000000o22 = O000000o21 != null ? O000000o21.O000000o() : null;
                                                                int i3 = jpy4.O0000Ooo.O00000o0;
                                                                String str82 = jpy4.O0000Oo0.O00000Oo;
                                                                if (i3 == 307 || i3 == 308) {
                                                                    if (!str82.equals("GET")) {
                                                                    }
                                                                    if (jpy4.O00000Oo.O0000oOo && (O000000o3 = jpy4.O0000Ooo.O000000o("Location")) != null && (O00000o02 = jpy4.O0000Oo0.f2095O000000o.O00000o0(O000000o3)) != null && (O00000o02.f15491O000000o.equals(jpy4.O0000Oo0.f2095O000000o.f15491O000000o) || jpy4.O00000Oo.O0000oOO)) {
                                                                        jri.O000000o O000000o23 = jpy4.O0000Oo0.O000000o();
                                                                        if (!jpz.O00000Oo(str82)) {
                                                                            if (!str82.equals("PROPFIND")) {
                                                                                jqh = null;
                                                                                O000000o23.O000000o("GET", (jrj) null);
                                                                            } else {
                                                                                jqh = null;
                                                                                O000000o23.O000000o(str82, (jrj) null);
                                                                            }
                                                                            str34 = str2;
                                                                            O000000o23.O000000o(str34);
                                                                            O000000o23.O000000o(str30);
                                                                            str33 = str22;
                                                                            O000000o23.O000000o(str33);
                                                                        } else {
                                                                            str33 = str22;
                                                                            str34 = str2;
                                                                            jqh = null;
                                                                        }
                                                                        if (!jpy4.O000000o(O00000o02)) {
                                                                            O000000o23.O000000o("Authorization");
                                                                        }
                                                                        jri2 = O000000o23.O000000o(O00000o02).O000000o();
                                                                        if (jri2 == null) {
                                                                            if (!z) {
                                                                                jrh.O00000o.O00000Oo();
                                                                            }
                                                                            return jrk5;
                                                                        }
                                                                        jqh O00000o04 = jrh.O00000o.O00000o0();
                                                                        int i4 = i + 1;
                                                                        if (i4 <= 20) {
                                                                            if (!jrh.O00000o.O000000o(jri2.f2095O000000o)) {
                                                                                O00000o04.O00000Oo();
                                                                                jqh2 = jqh;
                                                                            } else {
                                                                                jqh2 = O00000o04;
                                                                            }
                                                                            jrh.O00000o = new jpy(jrh.f2093O000000o, jri2, false, false, z, jqh2, null, jrk5);
                                                                            str54 = str29;
                                                                            str59 = str31;
                                                                            str57 = str7;
                                                                            str58 = str6;
                                                                            str55 = str5;
                                                                            j8 = j;
                                                                            i2 = i4;
                                                                            str60 = str32;
                                                                            str61 = str30;
                                                                            str56 = str;
                                                                        } else {
                                                                            O00000o04.O00000Oo();
                                                                            throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i4)));
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (i3 != 401) {
                                                                        if (i3 == 407) {
                                                                            if (O000000o22 != null) {
                                                                                proxy = O000000o22.O00000Oo;
                                                                            } else {
                                                                                proxy = jpy4.O00000Oo.O00000Oo;
                                                                            }
                                                                            if (proxy.type() != Proxy.Type.HTTP) {
                                                                                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                                                                            }
                                                                        } else if (i3 != 408) {
                                                                            switch (i3) {
                                                                                case 300:
                                                                                case 301:
                                                                                case 302:
                                                                                case 303:
                                                                                    jri.O000000o O000000o232 = jpy4.O0000Oo0.O000000o();
                                                                                    if (!jpz.O00000Oo(str82)) {
                                                                                    }
                                                                                    if (!jpy4.O000000o(O00000o02)) {
                                                                                    }
                                                                                    jri2 = O000000o232.O000000o(O00000o02).O000000o();
                                                                                    break;
                                                                                default:
                                                                                    str31 = str22;
                                                                                    str32 = str2;
                                                                                    jqh = null;
                                                                                    jri2 = null;
                                                                                    break;
                                                                            }
                                                                            if (jri2 == null) {
                                                                            }
                                                                        } else {
                                                                            boolean z4 = jpy4.O0000o00 == null || (jpy4.O0000o00 instanceof jqe);
                                                                            if (!jpy4.O0000o0O || z4) {
                                                                                jri2 = jpy4.O0000Oo0;
                                                                                str31 = str22;
                                                                                str32 = str2;
                                                                                jqh = null;
                                                                                if (jri2 == null) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    str31 = str22;
                                                                    str32 = str2;
                                                                    jri2 = null;
                                                                    jqh = null;
                                                                    if (jri2 == null) {
                                                                    }
                                                                }
                                                                str31 = str22;
                                                                str32 = str2;
                                                                jqh = null;
                                                                jri2 = null;
                                                                if (jri2 == null) {
                                                                }
                                                            } else {
                                                                throw new IllegalStateException();
                                                            }
                                                        } else {
                                                            throw new IllegalStateException();
                                                        }
                                                    }
                                                }
                                            }
                                            z2 = true;
                                            if (!z2) {
                                            }
                                        } else {
                                            str29 = str3;
                                            jrk.O000000o O000000o172 = jrk.O000000o();
                                            O000000o172.f2099O000000o = jpy3.O0000Oo0;
                                            jpy3.O0000Ooo = O000000o172.O00000o0(jpy.O000000o(jpy3.O00000o)).O00000Oo(jpy.O000000o(jpy3.O0000OoO)).O000000o(jpy.O000000o(jrk)).O000000o();
                                            if (jpy.O00000o0(jpy3.O0000Ooo)) {
                                            }
                                            jpy = jrh.O00000o;
                                            if (jpy.O0000Ooo != null) {
                                            }
                                        }
                                        jpy3.O0000Ooo = O00000Oo2;
                                        jpy = jrh.O00000o;
                                        if (jpy.O0000Ooo != null) {
                                        }
                                    } catch (l e422222) {
                                    } catch (o e18) {
                                        e = e18;
                                        oVar2 = e;
                                        str35 = str22;
                                        str37 = str4;
                                        str36 = str3;
                                        str38 = str2;
                                        j = -1;
                                        O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                        if (O000000o2 != null) {
                                        }
                                    } catch (IOException e19) {
                                        e = e19;
                                        iOException2 = e;
                                        str42 = str22;
                                        str44 = str4;
                                        str43 = str3;
                                        str45 = str2;
                                        j = -1;
                                        O000000o2 = jrh.O00000o.O000000o(iOException);
                                        if (O000000o2 == null) {
                                        }
                                        jrh.O00000o = O000000o2;
                                        str54 = str9;
                                        str60 = str8;
                                        str59 = str68;
                                        str57 = str7;
                                        str58 = str6;
                                        str55 = str5;
                                        str61 = str10;
                                        j8 = j;
                                        i2 = i;
                                        str56 = str;
                                    }
                                } catch (l e4222222) {
                                } catch (o e20) {
                                    e = e20;
                                    oVar2 = e;
                                    str35 = str22;
                                    str37 = str4;
                                    str36 = str3;
                                    str38 = str2;
                                    j = -1;
                                    O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                    if (O000000o2 != null) {
                                    }
                                } catch (IOException e21) {
                                    e = e21;
                                    iOException2 = e;
                                    str42 = str22;
                                    str44 = str4;
                                    str43 = str3;
                                    str45 = str2;
                                    j = -1;
                                    O000000o2 = jrh.O00000o.O000000o(iOException);
                                    if (O000000o2 == null) {
                                    }
                                    jrh.O00000o = O000000o2;
                                    str54 = str9;
                                    str60 = str8;
                                    str59 = str68;
                                    str57 = str7;
                                    str58 = str6;
                                    str55 = str5;
                                    str61 = str10;
                                    j8 = j;
                                    i2 = i;
                                    str56 = str;
                                }
                            } else {
                                try {
                                    if (jpy3.O0000o0 != null) {
                                        if (jpy3.O0000o0.O00000Oo().O00000Oo > 0) {
                                            jpy3.O0000o0.O00000o0();
                                        }
                                    }
                                    j = -1;
                                    if (jpy3.O00000oo == -1) {
                                        try {
                                            if (jqb.O000000o(jpy3.O0000Oo) != -1 || !(jpy3.O0000o00 instanceof jqe)) {
                                                str30 = str4;
                                            } else {
                                                str30 = str4;
                                                try {
                                                    jpy3.O0000Oo = jpy3.O0000Oo.O000000o().O000000o(str30, Long.toString(((jqe) jpy3.O0000o00).f2052O000000o.O00000Oo)).O000000o();
                                                } catch (l e42222222) {
                                                } catch (o e22) {
                                                    e = e22;
                                                    oVar3 = e;
                                                    str39 = str22;
                                                    str29 = str3;
                                                    str38 = str2;
                                                    O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                                    if (O000000o2 != null) {
                                                    }
                                                } catch (IOException e23) {
                                                    e = e23;
                                                    iOException3 = e;
                                                    str46 = str22;
                                                    str29 = str3;
                                                    str45 = str2;
                                                    O000000o2 = jrh.O00000o.O000000o(iOException);
                                                    if (O000000o2 == null) {
                                                    }
                                                    jrh.O00000o = O000000o2;
                                                    str54 = str9;
                                                    str60 = str8;
                                                    str59 = str68;
                                                    str57 = str7;
                                                    str58 = str6;
                                                    str55 = str5;
                                                    str61 = str10;
                                                    j8 = j;
                                                    i2 = i;
                                                    str56 = str;
                                                }
                                            }
                                            jpy3.O00000oO.O000000o(jpy3.O0000Oo);
                                        } catch (l e422222222) {
                                        } catch (o e24) {
                                            e = e24;
                                            str30 = str4;
                                            oVar3 = e;
                                            str39 = str22;
                                            str29 = str3;
                                            str38 = str2;
                                            O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                            if (O000000o2 != null) {
                                            }
                                        } catch (IOException e25) {
                                            e = e25;
                                            str30 = str4;
                                            iOException3 = e;
                                            str46 = str22;
                                            str29 = str3;
                                            str45 = str2;
                                            O000000o2 = jrh.O00000o.O000000o(iOException);
                                            if (O000000o2 == null) {
                                            }
                                            jrh.O00000o = O000000o2;
                                            str54 = str9;
                                            str60 = str8;
                                            str59 = str68;
                                            str57 = str7;
                                            str58 = str6;
                                            str55 = str5;
                                            str61 = str10;
                                            j8 = j;
                                            i2 = i;
                                            str56 = str;
                                        }
                                    } else {
                                        str30 = str4;
                                    }
                                } catch (l e4222222222) {
                                } catch (o e26) {
                                    e = e26;
                                    str40 = str4;
                                    str41 = str3;
                                    j = -1;
                                    oVar3 = e;
                                    str39 = str22;
                                    str38 = str2;
                                    O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                    if (O000000o2 != null) {
                                    }
                                } catch (IOException e27) {
                                    e = e27;
                                    str47 = str4;
                                    str29 = str3;
                                    j = -1;
                                    iOException3 = e;
                                    str46 = str22;
                                    str45 = str2;
                                    O000000o2 = jrh.O00000o.O000000o(iOException);
                                    if (O000000o2 == null) {
                                    }
                                    jrh.O00000o = O000000o2;
                                    str54 = str9;
                                    str60 = str8;
                                    str59 = str68;
                                    str57 = str7;
                                    str58 = str6;
                                    str55 = str5;
                                    str61 = str10;
                                    j8 = j;
                                    i2 = i;
                                    str56 = str;
                                }
                                try {
                                    if (jpy3.O0000o00 != null) {
                                        if (jpy3.O0000o0 != null) {
                                            jpy3.O0000o0.close();
                                        } else {
                                            jpy3.O0000o00.close();
                                        }
                                        if (jpy3.O0000o00 instanceof jqe) {
                                            jpy3.O00000oO.O000000o((jqe) jpy3.O0000o00);
                                        }
                                    }
                                } catch (l e42222222222) {
                                } catch (o e28) {
                                    e = e28;
                                    oVar3 = e;
                                    str39 = str22;
                                    str38 = str2;
                                    O000000o2 = jrh.O00000o.O000000o(oVar.a());
                                    if (O000000o2 != null) {
                                    }
                                } catch (IOException e29) {
                                    e = e29;
                                    iOException3 = e;
                                    str46 = str22;
                                    str45 = str2;
                                    O000000o2 = jrh.O00000o.O000000o(iOException);
                                    if (O000000o2 == null) {
                                    }
                                    jrh.O00000o = O000000o2;
                                    str54 = str9;
                                    str60 = str8;
                                    str59 = str68;
                                    str57 = str7;
                                    str58 = str6;
                                    str55 = str5;
                                    str61 = str10;
                                    j8 = j;
                                    i2 = i;
                                    str56 = str;
                                }
                            }
                            jrk = jpy3.O00000o();
                            jpy3.O000000o(jrk.O00000oo);
                            if (jpy3.O0000OoO == null) {
                            }
                            jpy3.O0000Ooo = O00000Oo2;
                            jpy = jrh.O00000o;
                            if (jpy.O0000Ooo != null) {
                            }
                        }
                    } catch (l e422222222222) {
                    } catch (o e30) {
                        e = e30;
                        str40 = str4;
                        str41 = str3;
                        j = -1;
                        oVar3 = e;
                        str39 = str22;
                        str38 = str2;
                        O000000o2 = jrh.O00000o.O000000o(oVar.a());
                        if (O000000o2 != null) {
                        }
                    } catch (IOException e31) {
                        e = e31;
                        str47 = str4;
                        str29 = str3;
                        j = -1;
                        iOException3 = e;
                        str46 = str22;
                        str45 = str2;
                        O000000o2 = jrh.O00000o.O000000o(iOException);
                        if (O000000o2 == null) {
                        }
                        jrh.O00000o = O000000o2;
                        str54 = str9;
                        str60 = str8;
                        str59 = str68;
                        str57 = str7;
                        str58 = str6;
                        str55 = str5;
                        str61 = str10;
                        j8 = j;
                        i2 = i;
                        str56 = str;
                    }
                }
                str30 = str4;
                str29 = str3;
                j = -1;
                jpy = jrh.O00000o;
                if (jpy.O0000Ooo != null) {
                }
            } catch (l e32) {
            } catch (o e33) {
                e = e33;
                str23 = str22;
                str14 = str4;
                str24 = str3;
                str25 = str2;
                j2 = -1;
                oVar = e;
                O000000o2 = jrh.O00000o.O000000o(oVar.a());
                if (O000000o2 != null) {
                }
            } catch (IOException e34) {
                e = e34;
                str26 = str22;
                str15 = str4;
                str27 = str3;
                str28 = str2;
                j3 = -1;
                iOException = e;
                O000000o2 = jrh.O00000o.O000000o(iOException);
                if (O000000o2 == null) {
                }
                jrh.O00000o = O000000o2;
                str54 = str9;
                str60 = str8;
                str59 = str68;
                str57 = str7;
                str58 = str6;
                str55 = str5;
                str61 = str10;
                j8 = j;
                i2 = i;
                str56 = str;
            } catch (Throwable th4) {
            }
        }
        jrh.O00000o.O00000Oo();
        throw new IOException("Canceled");
    }
}

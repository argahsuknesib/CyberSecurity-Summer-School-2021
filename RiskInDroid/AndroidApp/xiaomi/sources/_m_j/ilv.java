package _m_j;

import android.net.Uri;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class ilv {
    public static long O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f1453O000000o = false;
    private long O00000o;
    private long O00000o0;
    private ilr O00000oO;
    private int O00000oo;
    private ByteBuffer O0000O0o = ByteBuffer.allocate(65536);

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public ilv(ilr ilr, int i) {
        imc.O000000o("dl_mp3", (Object) ("======================DownloadThread Constructor(" + i + ")"));
        this.O00000oO = ilr;
        this.O00000oo = i;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:1050:0x0048 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r36v2 */
    /* JADX WARN: Type inference failed for: r36v11 */
    /* JADX WARN: Type inference failed for: r36v12 */
    /* JADX WARN: Type inference failed for: r36v21 */
    /* JADX WARN: Type inference failed for: r36v22 */
    /* JADX WARN: Type inference failed for: r36v36 */
    /* JADX WARN: Type inference failed for: r36v38 */
    /* JADX WARN: Type inference failed for: r36v39 */
    /* JADX WARN: Type inference failed for: r36v48 */
    /* JADX WARN: Type inference failed for: r36v49 */
    /* JADX WARN: Type inference failed for: r36v50 */
    /* JADX WARN: Type inference failed for: r36v57 */
    /* JADX WARN: Type inference failed for: r36v61 */
    /* JADX WARN: Type inference failed for: r36v67 */
    /* JADX WARN: Type inference failed for: r36v68 */
    /* JADX WARN: Type inference failed for: r36v77 */
    /* JADX WARN: Type inference failed for: r36v81 */
    /* JADX WARN: Type inference failed for: r36v82 */
    /* JADX WARN: Type inference failed for: r36v83 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imq.O000000o(float, boolean):float
     arg types: [float, int]
     candidates:
      _m_j.imq.O000000o(_m_j.imo, com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel):void
      _m_j.imq.O000000o(float, boolean):float */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:1001:0x104d, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1004:0x1058, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1011:0x1070, code lost:
        r4 = r8.O00000oO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1012:0x1073, code lost:
        if (r4 == -1) goto L_0x1075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1013:0x1075, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1014:0x1078, code lost:
        if (r4 == 0) goto L_0x107a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1015:0x107a, code lost:
        r1.O00000o0 = (long) r8.O00000Oo;
        r1.O00000o = (long) r8.O00000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1016:0x108a, code lost:
        if (r14 > (r1.O00000o0 * 1000)) goto L_0x108c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1017:0x108c, code lost:
        r13.O0000O0o = "cdn_connected_too_slow";
        r13.O00000oo = "connected_time=" + (((float) r14) / 1000.0f) + "s, connected_time_threshold=" + r1.O00000o0 + "s";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1018:0x10b2, code lost:
        r12 = r9;
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1020:0x10bb, code lost:
        if (((float) r1.O00000o) > r3) goto L_0x10bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1021:0x10bd, code lost:
        r13.O0000O0o = "cdn_download_too_slow";
        r13.O00000oo = "download_speed=" + _m_j.imq.O000000o(r3, true) + "KB/s, download_speed_threshold=" + r1.O00000o + "KB/s";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1023:0x10e7, code lost:
        if (r4 == 1) goto L_0x10e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1024:0x10e9, code lost:
        r1.O00000o0 = (long) r8.f12180O000000o;
        r1.O00000o = (long) r8.O00000o0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1025:0x10f9, code lost:
        if (r14 > (r1.O00000o0 * 1000)) goto L_0x10fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1026:0x10fb, code lost:
        r13.O0000O0o = "cdn_connected_too_slow";
        r13.O00000oo = "connected_time=" + (((float) r14) / 1000.0f) + "s, connected_time_threshold=" + r1.O00000o0 + "s";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1028:0x1127, code lost:
        if (((float) r1.O00000o) > r3) goto L_0x1129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1029:0x1129, code lost:
        r13.O0000O0o = "cdn_download_too_slow";
        r13.O00000oo = "download_speed=" + _m_j.imq.O000000o(r3, true) + "KB/s, download_speed_threshold=" + r1.O00000o + "KB/s";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1032:0x1156, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0306, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0307, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x030b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x030c, code lost:
        r38 = r2;
        r36 = r3;
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0317, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0318, code lost:
        r38 = r2;
        r36 = r3;
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0323, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0324, code lost:
        r38 = r2;
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0328, code lost:
        r9 = r12;
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x032d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x032e, code lost:
        r38 = r2;
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0332, code lost:
        r9 = r12;
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0337, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0338, code lost:
        r38 = r2;
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x033c, code lost:
        r9 = r12;
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0341, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0342, code lost:
        r38 = r2;
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0346, code lost:
        r9 = r12;
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x034b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x034c, code lost:
        r38 = r2;
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0350, code lost:
        r9 = r12;
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x03ad, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x03af, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x03b1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x03b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x03b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x03b7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x03b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x03bb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x03bc, code lost:
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x03be, code lost:
        r38 = r2;
        r36 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x03c4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x03c5, code lost:
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x03c7, code lost:
        r38 = r2;
        r36 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x03cd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x03ce, code lost:
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x03d0, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x03d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03d5, code lost:
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x03d7, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x03db, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x03dc, code lost:
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x03de, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x03e2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x03e3, code lost:
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x03e5, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03ea, code lost:
        r35 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x03ec, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0445, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0446, code lost:
        r36 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x044c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x044d, code lost:
        r36 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        r2 = r0;
        r10 = r6;
        r9 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0089, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        r34 = r2;
        r33 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
        r34 = r2;
        r33 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        r33 = r3;
        r3 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r38 = null;
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bb, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r38 = null;
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c5, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r38 = null;
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cf, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r38 = null;
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d9, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r38 = null;
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x082e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x082f, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x0833, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x0834, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:509:0x0838, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:0x0839, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:512:0x083f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:513:0x0840, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x0846, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:516:0x0847, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x084d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:519:0x084e, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:521:0x0854, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x0855, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:549:0x08d9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:550:0x08da, code lost:
        r38 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011e, code lost:
        r2 = r0;
        r36 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r34 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0129, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012a, code lost:
        r2 = r0;
        r36 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r34 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0135, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0136, code lost:
        r2 = r0;
        r3 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:639:0x0a41, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:640:0x0a42, code lost:
        r36 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r34 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:641:0x0a4c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:642:0x0a4d, code lost:
        r36 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r34 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:643:0x0a57, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:644:0x0a58, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r2 = r0;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:645:0x0a5e, code lost:
        r12 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:646:0x0a61, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:647:0x0a62, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r2 = r0;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:648:0x0a68, code lost:
        r12 = r15;
        r5 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:649:0x0a6d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013f, code lost:
        r2 = r0;
        r3 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:650:0x0a6e, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r2 = r0;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:651:0x0a74, code lost:
        r12 = r15;
        r5 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:652:0x0a79, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:653:0x0a7a, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r2 = r0;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:654:0x0a80, code lost:
        r12 = r15;
        r5 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:655:0x0a85, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:656:0x0a86, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r2 = r0;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:657:0x0a8c, code lost:
        r12 = r15;
        r5 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:658:0x0a91, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:659:0x0a92, code lost:
        r33 = r3;
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r12 = r2;
        r3 = r5;
        r38 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0147, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:661:0x0a9f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:662:0x0aa0, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r12 = r2;
        r38 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:663:0x0aa7, code lost:
        r2 = r0;
        r43 = r5;
        r5 = r3;
        r3 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:664:0x0aaf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:665:0x0ab0, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r12 = r2;
        r38 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:666:0x0ab7, code lost:
        r2 = r0;
        r43 = r5;
        r5 = r3;
        r3 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:667:0x0abf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:668:0x0ac0, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r12 = r2;
        r38 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:669:0x0ac7, code lost:
        r2 = r0;
        r43 = r5;
        r5 = r3;
        r3 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0148, code lost:
        r2 = r0;
        r3 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:670:0x0acf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:671:0x0ad0, code lost:
        r10 = r6;
        r9 = r12;
        r35 = r14;
        r12 = r2;
        r38 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:672:0x0ad7, code lost:
        r2 = r0;
        r43 = r5;
        r5 = r3;
        r3 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:673:0x0adf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:674:0x0ae0, code lost:
        r10 = r6;
        r9 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:675:0x0ae3, code lost:
        r3 = r20;
        r14 = r25;
        r11 = r28;
        r38 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:676:0x0aed, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:677:0x0aee, code lost:
        r34 = r2;
        r33 = r3;
        r36 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:678:0x0af8, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:679:0x0af9, code lost:
        r5 = r19;
        r38 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0150, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:686:0x0b0d, code lost:
        r11 = java.lang.System.currentTimeMillis() - r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:687:0x0b13, code lost:
        if (r11 != 0) goto L_0x0b15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:688:0x0b15, code lost:
        r3 = ((((float) r5) + 0.0f) / 1024.0f) / ((((float) r11) + 0.0f) / 1000.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:689:0x0b22, code lost:
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0151, code lost:
        r2 = r0;
        r3 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:691:?, code lost:
        r6 = new java.lang.StringBuilder();
        r6.append(_m_j.imq.O000000o(r3, true));
        r13.O00000oO = r6.toString();
        r13.O0000o0O = java.lang.String.valueOf(r5);
        r13.O0000o0o = java.lang.String.valueOf(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:692:0x0b43, code lost:
        r20 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:697:0x0b4f, code lost:
        r11 = java.lang.System.currentTimeMillis() - r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:699:?, code lost:
        r13.O0000Oo = _m_j.imq.O000000o((float) r11, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:700:0x0b59, code lost:
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:707:0x0b73, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015a, code lost:
        r2 = r0;
        r3 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:710:0x0b7e, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:717:0x0b96, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:724:0x0bad, code lost:
        _m_j.imq.O000000o(r13, r8);
        r19 = r5;
        r12 = r9;
        r6 = r10;
        r18 = r13;
        r16 = r29;
        r3 = r33;
        r2 = r34;
        r14 = r35;
        r5 = r36;
        r11 = 1;
        r27 = true;
        r28 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:726:0x0bd1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:727:0x0bd2, code lost:
        r34 = r2;
        r33 = r3;
        r36 = r5;
        r10 = r6;
        r9 = r12;
        r35 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:728:0x0bdc, code lost:
        r2 = r0;
        r36 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:729:0x0bdd, code lost:
        r5 = r19;
        r38 = null;
        r36 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:734:0x0beb, code lost:
        if (android.text.TextUtils.isEmpty(r13.O00000oO) != false) goto L_0x0bed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:736:0x0bf1, code lost:
        r11 = java.lang.System.currentTimeMillis() - r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:737:0x0bf7, code lost:
        if (r11 != 0) goto L_0x0bf9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:738:0x0bf9, code lost:
        r3 = ((((float) r5) + 0.0f) / 1024.0f) / ((((float) r11) + 0.0f) / 1000.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:739:0x0c06, code lost:
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:741:?, code lost:
        r6 = new java.lang.StringBuilder();
        r6.append(_m_j.imq.O000000o(r3, true));
        r13.O00000oO = r6.toString();
        r13.O0000o0O = java.lang.String.valueOf(r5);
        r13.O0000o0o = java.lang.String.valueOf(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:742:0x0c27, code lost:
        r20 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:743:0x0c2a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:744:0x0c2b, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:747:0x0c32, code lost:
        if (r13.O0000Oo <= 0.0f) goto L_0x0c34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:749:0x0c38, code lost:
        r11 = java.lang.System.currentTimeMillis() - r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:751:?, code lost:
        r13.O0000Oo = _m_j.imq.O000000o((float) r11, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:752:0x0c42, code lost:
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:753:0x0c45, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:754:0x0c46, code lost:
        r2 = r0;
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:757:0x0c4e, code lost:
        if (r2.getMessage() == null) goto L_0x0c73;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:762:0x0c68, code lost:
        r3 = r36;
        r13.O0000o0O = r3;
        r13.O0000o0o = r3;
        r13.O0000O0o = "system_exception";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:763:0x0c73, code lost:
        r3 = r36;
        r13.O0000O0o = "cdn_io_exception";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:764:0x0c79, code lost:
        r13.O00000oo = _m_j.imq.O000000o(r2);
        r13.O0000o = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:771:0x0ca7, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:774:0x0cb2, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:781:0x0cca, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:788:0x0ce1, code lost:
        _m_j.imq.O000000o(r13, r8);
        r19 = r5;
        r6 = r10;
        r2 = r12;
        r18 = r13;
        r16 = r29;
        r14 = r35;
        r11 = 1;
        r27 = true;
        r28 = true;
        r5 = r3;
        r12 = r9;
        r3 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:797:0x0d13, code lost:
        if (r13.O0000Oo <= 0.0f) goto L_0x0d15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:799:0x0d19, code lost:
        r5 = java.lang.System.currentTimeMillis() - r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:801:?, code lost:
        r13.O0000Oo = _m_j.imq.O000000o((float) r5, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:802:0x0d23, code lost:
        r25 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:803:0x0d26, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:804:0x0d27, code lost:
        r2 = r0;
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:807:?, code lost:
        r13.O0000O0o = "system_exception";
        r13.O00000oo = _m_j.imq.O000000o(r2);
        r5 = r33;
        r13.O00000oO = r5;
        r13.O0000o0O = r3;
        r13.O0000o0o = r3;
        r13.O0000o = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:814:0x0d63, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:817:0x0d6e, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:824:0x0d86, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:826:0x0d8b, code lost:
        if (r9 == false) goto L_0x0d8d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:828:0x0d93, code lost:
        if (android.text.TextUtils.isEmpty(r13.O0000O0o) == false) goto L_0x0d95;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:830:0x0d9b, code lost:
        if (android.text.TextUtils.isEmpty(r13.O00000oo) == false) goto L_0x0f78;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:840:0x0dbb, code lost:
        r14 = java.lang.System.currentTimeMillis() - r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:842:?, code lost:
        r13.O0000Oo = _m_j.imq.O000000o((float) r14, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:843:0x0dc5, code lost:
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:852:0x0dfa, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:855:0x0e05, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:862:0x0e1d, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:864:0x0e22, code lost:
        if (r9 == false) goto L_0x0e24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:866:0x0e2a, code lost:
        if (android.text.TextUtils.isEmpty(r13.O0000O0o) == false) goto L_0x0e2c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:868:0x0e32, code lost:
        if (android.text.TextUtils.isEmpty(r13.O00000oo) == false) goto L_0x0f78;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:878:0x0e52, code lost:
        r14 = java.lang.System.currentTimeMillis() - r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:880:?, code lost:
        r13.O0000Oo = _m_j.imq.O000000o((float) r14, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:881:0x0e5c, code lost:
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:890:0x0e91, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:893:0x0e9c, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:900:0x0eb4, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:902:0x0eb9, code lost:
        if (r9 == false) goto L_0x0ebb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:904:0x0ec1, code lost:
        if (android.text.TextUtils.isEmpty(r13.O0000O0o) == false) goto L_0x0ec3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:906:0x0ec9, code lost:
        if (android.text.TextUtils.isEmpty(r13.O00000oo) == false) goto L_0x0f78;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:916:0x0eeb, code lost:
        r14 = java.lang.System.currentTimeMillis() - r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:918:?, code lost:
        r13.O0000Oo = _m_j.imq.O000000o((float) r14, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:919:0x0ef5, code lost:
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:923:0x0f01, code lost:
        r13.O0000O0o = "cdn_socket_timeout";
        r13.O00000oo = java.lang.String.valueOf(r2) + _m_j.imq.O000000o(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:924:0x0f1f, code lost:
        r13.O0000O0o = "cdn_connect_timeout";
        r13.O00000oo = _m_j.imq.O000000o(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:930:0x0f3e, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:933:0x0f49, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:940:0x0f61, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:942:0x0f66, code lost:
        if (r9 == false) goto L_0x0f68;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:944:0x0f6e, code lost:
        if (android.text.TextUtils.isEmpty(r13.O0000O0o) == false) goto L_0x0f70;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:946:0x0f76, code lost:
        if (android.text.TextUtils.isEmpty(r13.O00000oo) == false) goto L_0x0f78;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:947:0x0f78, code lost:
        _m_j.imq.O000000o(r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:956:0x0f96, code lost:
        if (r13.O0000Oo <= 0.0f) goto L_0x0f98;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:958:0x0f9c, code lost:
        r14 = java.lang.System.currentTimeMillis() - r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:960:?, code lost:
        r13.O0000Oo = _m_j.imq.O000000o((float) r14, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:961:0x0fa6, code lost:
        r25 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:962:0x0fa9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:963:0x0faa, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:964:0x0fab, code lost:
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:968:?, code lost:
        r13.O0000O0o = "cdn_connect_fail ";
        r13.O00000oo = _m_j.imq.O000000o(r2);
        r13.O00000oO = r5;
        r13.O0000o0O = r3;
        r13.O0000o0o = r3;
        r13.O0000o = "failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:975:0x0fe7, code lost:
        r13.O0000Oo0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:978:0x0ff2, code lost:
        r13.O0000OOo = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:985:0x100a, code lost:
        r38.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:987:0x100f, code lost:
        if (r9 == false) goto L_0x1011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:989:0x1017, code lost:
        if (android.text.TextUtils.isEmpty(r13.O0000O0o) == false) goto L_0x1019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:991:0x101f, code lost:
        if (android.text.TextUtils.isEmpty(r13.O00000oo) == false) goto L_0x0f78;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:1001:0x104d  */
    /* JADX WARNING: Removed duplicated region for block: B:1004:0x1058  */
    /* JADX WARNING: Removed duplicated region for block: B:1011:0x1070  */
    /* JADX WARNING: Removed duplicated region for block: B:1032:0x1156  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0306 A[ExcHandler: all (th java.lang.Throwable), PHI: r14 10  PHI: (r14v58 long) = (r14v37 long), (r14v37 long), (r14v37 long), (r14v37 long), (r14v37 long), (r14v37 long), (r14v59 long), (r14v59 long) binds: [B:237:0x0404, B:238:?, B:242:0x040f, B:198:0x038c, B:199:?, B:201:0x0392, B:153:0x02e4, B:154:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:153:0x02e4] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x03b1 A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), PHI: r35 10  PHI: (r35v87 java.lang.String) = (r35v77 java.lang.String), (r35v77 java.lang.String), (r35v97 java.lang.String) binds: [B:237:0x0404, B:238:?, B:201:0x0392] A[DONT_GENERATE, DONT_INLINE], Splitter:B:201:0x0392] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03b3 A[ExcHandler: IllegalArgumentException (e java.lang.IllegalArgumentException), PHI: r35 10  PHI: (r35v86 java.lang.String) = (r35v77 java.lang.String), (r35v77 java.lang.String), (r35v97 java.lang.String) binds: [B:237:0x0404, B:238:?, B:201:0x0392] A[DONT_GENERATE, DONT_INLINE], Splitter:B:201:0x0392] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03b5 A[ExcHandler: UnknownHostException (e java.net.UnknownHostException), PHI: r35 10  PHI: (r35v85 java.lang.String) = (r35v77 java.lang.String), (r35v77 java.lang.String), (r35v97 java.lang.String) binds: [B:237:0x0404, B:238:?, B:201:0x0392] A[DONT_GENERATE, DONT_INLINE], Splitter:B:201:0x0392] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03b7 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), PHI: r35 10  PHI: (r35v84 java.lang.String) = (r35v77 java.lang.String), (r35v77 java.lang.String), (r35v97 java.lang.String) binds: [B:237:0x0404, B:238:?, B:201:0x0392] A[DONT_GENERATE, DONT_INLINE], Splitter:B:201:0x0392] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03b9 A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), PHI: r35 10  PHI: (r35v83 java.lang.String) = (r35v77 java.lang.String), (r35v77 java.lang.String), (r35v97 java.lang.String) binds: [B:237:0x0404, B:238:?, B:201:0x0392] A[DONT_GENERATE, DONT_INLINE], Splitter:B:201:0x0392] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0435 A[Catch:{ MalformedURLException -> 0x04a8, SocketTimeoutException -> 0x049a, UnknownHostException -> 0x048c, IllegalArgumentException -> 0x047e, FileNotFoundException -> 0x0472, IOException -> 0x0470, Throwable -> 0x046e, all -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0438 A[Catch:{ MalformedURLException -> 0x04a8, SocketTimeoutException -> 0x049a, UnknownHostException -> 0x048c, IllegalArgumentException -> 0x047e, FileNotFoundException -> 0x0472, IOException -> 0x0470, Throwable -> 0x046e, all -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083 A[ExcHandler: all (r0v289 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:25:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), Splitter:B:25:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba A[ExcHandler: IllegalArgumentException (e java.lang.IllegalArgumentException), Splitter:B:25:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4 A[ExcHandler: UnknownHostException (e java.net.UnknownHostException), Splitter:B:25:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0750  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ce A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:25:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d8 A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), Splitter:B:25:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:549:0x08d9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:233:0x03f2] */
    /* JADX WARNING: Removed duplicated region for block: B:673:0x0adf A[ExcHandler: all (r0v14 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:19:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:676:0x0aed A[ExcHandler: Throwable (th java.lang.Throwable), PHI: r21 10  PHI: (r21v23 long) = (r21v1 long), (r21v24 long), (r21v24 long), (r21v24 long), (r21v24 long) binds: [B:19:0x005c, B:21:0x0060, B:22:?, B:48:0x00e2, B:49:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:19:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:685:0x0b09 A[Catch:{ all -> 0x1038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:696:0x0b4b A[Catch:{ all -> 0x1038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:707:0x0b73  */
    /* JADX WARNING: Removed duplicated region for block: B:710:0x0b7e  */
    /* JADX WARNING: Removed duplicated region for block: B:717:0x0b96  */
    /* JADX WARNING: Removed duplicated region for block: B:719:0x0b9b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:726:0x0bd1 A[ExcHandler: IOException (e java.io.IOException), PHI: r21 10  PHI: (r21v19 long) = (r21v1 long), (r21v24 long), (r21v24 long), (r21v24 long), (r21v24 long) binds: [B:19:0x005c, B:21:0x0060, B:22:?, B:48:0x00e2, B:49:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:19:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:731:0x0be3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0ca7  */
    /* JADX WARNING: Removed duplicated region for block: B:774:0x0cb2  */
    /* JADX WARNING: Removed duplicated region for block: B:781:0x0cca  */
    /* JADX WARNING: Removed duplicated region for block: B:783:0x0ccf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:794:0x0d0d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:814:0x0d63  */
    /* JADX WARNING: Removed duplicated region for block: B:817:0x0d6e  */
    /* JADX WARNING: Removed duplicated region for block: B:824:0x0d86  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x0d8b  */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x0db7 A[Catch:{ all -> 0x1038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0dfa  */
    /* JADX WARNING: Removed duplicated region for block: B:855:0x0e05  */
    /* JADX WARNING: Removed duplicated region for block: B:862:0x0e1d  */
    /* JADX WARNING: Removed duplicated region for block: B:864:0x0e22  */
    /* JADX WARNING: Removed duplicated region for block: B:877:0x0e4e A[Catch:{ all -> 0x1038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:890:0x0e91  */
    /* JADX WARNING: Removed duplicated region for block: B:893:0x0e9c  */
    /* JADX WARNING: Removed duplicated region for block: B:900:0x0eb4  */
    /* JADX WARNING: Removed duplicated region for block: B:902:0x0eb9  */
    /* JADX WARNING: Removed duplicated region for block: B:915:0x0ee7 A[Catch:{ all -> 0x1038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:923:0x0f01 A[Catch:{ all -> 0x1038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:924:0x0f1f A[Catch:{ all -> 0x1038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:930:0x0f3e  */
    /* JADX WARNING: Removed duplicated region for block: B:933:0x0f49  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x0f61  */
    /* JADX WARNING: Removed duplicated region for block: B:942:0x0f66  */
    /* JADX WARNING: Removed duplicated region for block: B:953:0x0f90 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:975:0x0fe7  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x0ff2  */
    /* JADX WARNING: Removed duplicated region for block: B:985:0x100a  */
    /* JADX WARNING: Removed duplicated region for block: B:987:0x100f  */
    public final int O000000o() {
        ilr ilr;
        String str;
        HttpURLConnection httpURLConnection;
        long j;
        boolean z;
        String str2;
        boolean z2;
        float f;
        Throwable th;
        String str3;
        String str4;
        String str5;
        String str6;
        MalformedURLException malformedURLException;
        String str7;
        String str8;
        SocketTimeoutException socketTimeoutException;
        String str9;
        String str10;
        UnknownHostException unknownHostException;
        String str11;
        String str12;
        IllegalArgumentException illegalArgumentException;
        String str13;
        FileNotFoundException fileNotFoundException;
        String str14;
        String str15;
        int i;
        IOException iOException;
        Throwable th2;
        boolean z3;
        HttpURLConnection httpURLConnection2;
        int i2;
        int i3;
        String str16;
        String str17;
        IOException iOException2;
        Throwable th3;
        Throwable th4;
        float f2;
        HttpURLConnection httpURLConnection3;
        MalformedURLException malformedURLException2;
        SocketTimeoutException socketTimeoutException2;
        UnknownHostException unknownHostException2;
        IllegalArgumentException illegalArgumentException2;
        FileNotFoundException fileNotFoundException2;
        HttpURLConnection httpURLConnection4;
        boolean z4;
        MalformedURLException malformedURLException3;
        HttpURLConnection httpURLConnection5;
        boolean z5;
        SocketTimeoutException socketTimeoutException3;
        HttpURLConnection httpURLConnection6;
        boolean z6;
        UnknownHostException unknownHostException3;
        HttpURLConnection httpURLConnection7;
        boolean z7;
        IllegalArgumentException illegalArgumentException3;
        HttpURLConnection httpURLConnection8;
        boolean z8;
        FileNotFoundException fileNotFoundException3;
        String str18;
        long j2;
        int i4;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        int read;
        long j8;
        long j9;
        StringBuilder sb;
        long j10;
        float f3;
        boolean z9;
        int i5;
        int i6;
        int i7;
        int i8;
        float f4;
        long currentTimeMillis;
        HttpURLConnection httpURLConnection9;
        boolean z10;
        HttpURLConnection httpURLConnection10;
        boolean z11;
        HttpURLConnection httpURLConnection11;
        boolean z12;
        HttpURLConnection httpURLConnection12;
        boolean z13;
        String str19;
        String str20;
        HttpURLConnection httpURLConnection13;
        boolean z14;
        boolean z15;
        HttpURLConnection httpURLConnection14;
        String str21;
        int i9;
        long currentTimeMillis2;
        String str22;
        String str23 = "DownloadThread IOException:";
        String str24 = "0.0";
        String str25 = "0";
        String str26 = "";
        CdnConfigModel cdnConfigModel = imq.f1481O000000o;
        if (this.f1453O000000o || (ilr = this.O00000oO) == null || this.O00000oo < 0 || TextUtils.isEmpty(ilr.f1449O000000o)) {
            return -1;
        }
        int i10 = 1;
        boolean z16 = cdnConfigModel == null ? 1 : false;
        String uuid = UUID.randomUUID().toString();
        int i11 = 3;
        imo imo = null;
        int i12 = 0;
        float f5 = 0.0f;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        boolean z17 = false;
        boolean z18 = false;
        while (true) {
            int i13 = i11 - 1;
            if (i11 <= 0) {
                return -1;
            }
            imo imo2 = !z16 ? new imo() : imo;
            try {
                j11 = System.currentTimeMillis();
                if (this.O00000oo == this.O00000oO.O000000o().O00000o0 - i10) {
                    try {
                        int i14 = this.O00000oo * 65536;
                        i2 = ((int) this.O00000oO.O000000o().O00000Oo) - i10;
                        i3 = i14;
                    } catch (MalformedURLException e) {
                    } catch (SocketTimeoutException e2) {
                    } catch (UnknownHostException e3) {
                    } catch (IllegalArgumentException e4) {
                    } catch (FileNotFoundException e5) {
                    } catch (IOException e6) {
                        e = e6;
                        String str27 = str24;
                        String str28 = str23;
                        str = str25;
                        str2 = str26;
                        z14 = z16;
                        str3 = uuid;
                        i9 = i12;
                        httpURLConnection13 = null;
                        iOException = e;
                        if (!z2) {
                        }
                        String str29 = str;
                        str4 = str15;
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                        }
                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                        }
                        imo2.O0000OoO = System.currentTimeMillis();
                        imo2.O0000o = "failed";
                        if (httpURLConnection != null) {
                        }
                        if (imo2 != null) {
                        }
                        i12 = i;
                        str5 = str13;
                        str26 = str2;
                        str23 = str4;
                        imo = imo2;
                        i11 = i13;
                        uuid = str3;
                        i10 = 1;
                        z17 = true;
                        z18 = true;
                        boolean z19 = z2;
                        String str30 = str5;
                        str25 = str6;
                        str24 = str30;
                    } catch (Throwable th5) {
                    }
                } else {
                    i3 = this.O00000oo * 65536;
                    i2 = ((this.O00000oo + i10) * 65536) - 1;
                }
                if (imo2 != null) {
                    imo2.O0000o00 = i3 + "-" + i2;
                    str16 = str23;
                    str13 = str24;
                    imo2.O0000o0 = String.valueOf(((int) this.O00000oO.O000000o().O00000Oo) - 1);
                } else {
                    str16 = str23;
                    str13 = str24;
                }
                String format = String.format("bytes=%d-%d", Integer.valueOf(i3), Integer.valueOf(i2));
                String[] strArr = {this.O00000oO.f1449O000000o};
                if (TextUtils.isEmpty(this.O00000oO.f1449O000000o)) {
                    str17 = str26;
                } else {
                    str17 = Uri.parse(this.O00000oO.f1449O000000o).getHost();
                }
                HttpURLConnection O000000o2 = imf.O000000o(strArr, format, 0, false, "GET");
                try {
                    this.O00000oO.f1449O000000o = strArr[0];
                    if (O000000o2 != null) {
                        if (imo2 != null) {
                            try {
                                str6 = str25;
                                str2 = str26;
                                currentTimeMillis2 = System.currentTimeMillis() - j11;
                                str15 = str16;
                            } catch (MalformedURLException e7) {
                                e = e7;
                                str2 = str26;
                                httpURLConnection9 = O000000o2;
                                str6 = str25;
                                z10 = z16;
                                str3 = uuid;
                                str7 = str16;
                                str8 = str13;
                                malformedURLException = e;
                                if (!z2) {
                                }
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z192 = z2;
                                String str302 = str5;
                                str25 = str6;
                                str24 = str302;
                            } catch (SocketTimeoutException e8) {
                                e = e8;
                                str2 = str26;
                                httpURLConnection10 = O000000o2;
                                str6 = str25;
                                z11 = z16;
                                str3 = uuid;
                                str9 = str16;
                                str10 = str13;
                                socketTimeoutException = e;
                                imo2.O00000oO = str5;
                                if (imo2.O0000Oo <= 0.0f) {
                                }
                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                }
                                imo2.O0000o0O = str6;
                                imo2.O0000o0o = str6;
                                imo2.O0000o = "failed";
                                imo2.O00000o = true;
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z1922 = z2;
                                String str3022 = str5;
                                str25 = str6;
                                str24 = str3022;
                            } catch (UnknownHostException e9) {
                                e = e9;
                                str2 = str26;
                                httpURLConnection11 = O000000o2;
                                str6 = str25;
                                z12 = z16;
                                str3 = uuid;
                                str11 = str16;
                                str12 = str13;
                                unknownHostException = e;
                                if (imo2.O0000Oo <= 0.0f) {
                                }
                                imo2.O0000O0o = "dns_fail";
                                imo2.O00000oo = imq.O000000o(unknownHostException);
                                imo2.O00000oO = str5;
                                imo2.O0000o0O = str6;
                                imo2.O0000o0o = str6;
                                imo2.O0000o = "failed";
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z19222 = z2;
                                String str30222 = str5;
                                str25 = str6;
                                str24 = str30222;
                            } catch (IllegalArgumentException e10) {
                                e = e10;
                                str2 = str26;
                                httpURLConnection12 = O000000o2;
                                str6 = str25;
                                z13 = z16;
                                str3 = uuid;
                                str4 = str16;
                                str5 = str13;
                                illegalArgumentException = e;
                                if (imo2.O0000Oo <= 0.0f) {
                                }
                                imo2.O0000O0o = "dns_fail";
                                imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                imo2.O00000oO = str5;
                                imo2.O0000o0O = str6;
                                imo2.O0000o0o = str6;
                                imo2.O0000o = "failed";
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z192222 = z2;
                                String str302222 = str5;
                                str25 = str6;
                                str24 = str302222;
                            } catch (FileNotFoundException e11) {
                                e = e11;
                                str2 = str26;
                                httpURLConnection2 = O000000o2;
                                str6 = str25;
                                z3 = z16;
                                str3 = uuid;
                                str14 = str16;
                                fileNotFoundException = e;
                                if (!z2) {
                                }
                                String str31 = str13;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z1922222 = z2;
                                String str3022222 = str5;
                                str25 = str6;
                                str24 = str3022222;
                            } catch (IOException e12) {
                                e = e12;
                                str2 = str26;
                                str15 = str16;
                                httpURLConnection13 = O000000o2;
                                str = str25;
                                z14 = z16;
                                str3 = uuid;
                                i9 = i12;
                                iOException = e;
                                if (!z2) {
                                }
                                String str292 = str;
                                str4 = str15;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                i12 = i;
                                str5 = str13;
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z19222222 = z2;
                                String str30222222 = str5;
                                str25 = str6;
                                str24 = str30222222;
                            } catch (Throwable th6) {
                                th = th6;
                                str2 = str26;
                                httpURLConnection14 = O000000o2;
                                z2 = z16;
                                f = f5;
                                j = j13;
                                z = z18;
                                th = th;
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (!z17) {
                                }
                                boolean z20 = z2;
                                if (httpURLConnection != null) {
                                }
                                z2 = z20;
                                imq.O000000o(imo2, cdnConfigModel);
                                throw th;
                            }
                            try {
                                imo2.O0000Oo = imq.O000000o((float) currentTimeMillis2, false);
                                imo2.f1479O000000o = this.O00000oO.f1449O000000o;
                                imo2.O0000oO0 = str17;
                                imo2.O00000o0 = imq.O000000o(this.O00000oO.f1449O000000o);
                                imo2.O0000Ooo = "play";
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(O000000o2.getResponseCode());
                                imo2.O0000OOo = sb2.toString();
                                imo2.O0000Oo0 = O000000o2.getHeaderField("via");
                                imo2.O0000oO = uuid;
                                j13 = currentTimeMillis2;
                            } catch (MalformedURLException e13) {
                                e = e13;
                                httpURLConnection9 = O000000o2;
                                j13 = currentTimeMillis2;
                                z10 = z16;
                                str3 = uuid;
                                str8 = str13;
                                str7 = str15;
                                malformedURLException = e;
                                if (!z2) {
                                }
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z192222222 = z2;
                                String str302222222 = str5;
                                str25 = str6;
                                str24 = str302222222;
                            } catch (SocketTimeoutException e14) {
                                e = e14;
                                httpURLConnection10 = O000000o2;
                                j13 = currentTimeMillis2;
                                z11 = z16;
                                str3 = uuid;
                                str10 = str13;
                                str9 = str15;
                                socketTimeoutException = e;
                                imo2.O00000oO = str5;
                                if (imo2.O0000Oo <= 0.0f) {
                                }
                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                }
                                imo2.O0000o0O = str6;
                                imo2.O0000o0o = str6;
                                imo2.O0000o = "failed";
                                imo2.O00000o = true;
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z1922222222 = z2;
                                String str3022222222 = str5;
                                str25 = str6;
                                str24 = str3022222222;
                            } catch (UnknownHostException e15) {
                                e = e15;
                                httpURLConnection11 = O000000o2;
                                j13 = currentTimeMillis2;
                                z12 = z16;
                                str3 = uuid;
                                str12 = str13;
                                str11 = str15;
                                unknownHostException = e;
                                if (imo2.O0000Oo <= 0.0f) {
                                }
                                imo2.O0000O0o = "dns_fail";
                                imo2.O00000oo = imq.O000000o(unknownHostException);
                                imo2.O00000oO = str5;
                                imo2.O0000o0O = str6;
                                imo2.O0000o0o = str6;
                                imo2.O0000o = "failed";
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z19222222222 = z2;
                                String str30222222222 = str5;
                                str25 = str6;
                                str24 = str30222222222;
                            } catch (IllegalArgumentException e16) {
                                e = e16;
                                httpURLConnection12 = O000000o2;
                                j13 = currentTimeMillis2;
                                z13 = z16;
                                str3 = uuid;
                                str5 = str13;
                                str4 = str15;
                                illegalArgumentException = e;
                                if (imo2.O0000Oo <= 0.0f) {
                                }
                                imo2.O0000O0o = "dns_fail";
                                imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                imo2.O00000oO = str5;
                                imo2.O0000o0O = str6;
                                imo2.O0000o0o = str6;
                                imo2.O0000o = "failed";
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z192222222222 = z2;
                                String str302222222222 = str5;
                                str25 = str6;
                                str24 = str302222222222;
                            } catch (FileNotFoundException e17) {
                                e = e17;
                                httpURLConnection2 = O000000o2;
                                j13 = currentTimeMillis2;
                                z3 = z16;
                                str3 = uuid;
                                str14 = str15;
                                fileNotFoundException = e;
                                if (!z2) {
                                }
                                String str312 = str13;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z1922222222222 = z2;
                                String str3022222222222 = str5;
                                str25 = str6;
                                str24 = str3022222222222;
                            } catch (IOException e18) {
                                e = e18;
                                httpURLConnection13 = O000000o2;
                                str = str6;
                                j13 = currentTimeMillis2;
                                z14 = z16;
                                str3 = uuid;
                                i9 = i12;
                                iOException = e;
                                if (!z2) {
                                }
                                String str2922 = str;
                                str4 = str15;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (httpURLConnection != null) {
                                }
                                if (imo2 != null) {
                                }
                                i12 = i;
                                str5 = str13;
                                str26 = str2;
                                str23 = str4;
                                imo = imo2;
                                i11 = i13;
                                uuid = str3;
                                i10 = 1;
                                z17 = true;
                                z18 = true;
                                boolean z19222222222222 = z2;
                                String str30222222222222 = str5;
                                str25 = str6;
                                str24 = str30222222222222;
                            } catch (Throwable th7) {
                                th = th7;
                                httpURLConnection14 = O000000o2;
                                j = currentTimeMillis2;
                                z2 = z16;
                                f = f5;
                                z = z18;
                                th = th;
                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                }
                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                }
                                imo2.O0000OoO = System.currentTimeMillis();
                                imo2.O0000o = "failed";
                                if (!z17) {
                                }
                                boolean z202 = z2;
                                if (httpURLConnection != null) {
                                }
                                z2 = z202;
                                imq.O000000o(imo2, cdnConfigModel);
                                throw th;
                            }
                        } else {
                            str6 = str25;
                            str2 = str26;
                            str15 = str16;
                        }
                        try {
                            int responseCode = O000000o2.getResponseCode();
                            if (imo2 != null) {
                                try {
                                    str18 = uuid;
                                    j = System.currentTimeMillis() - j11;
                                } catch (MalformedURLException e19) {
                                    e = e19;
                                    httpURLConnection9 = O000000o2;
                                    z10 = z16;
                                    str3 = uuid;
                                    str8 = str13;
                                    str7 = str15;
                                    malformedURLException = e;
                                    if (!z2) {
                                    }
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z192222222222222 = z2;
                                    String str302222222222222 = str5;
                                    str25 = str6;
                                    str24 = str302222222222222;
                                } catch (SocketTimeoutException e20) {
                                    e = e20;
                                    httpURLConnection10 = O000000o2;
                                    z11 = z16;
                                    str3 = uuid;
                                    str10 = str13;
                                    str9 = str15;
                                    socketTimeoutException = e;
                                    imo2.O00000oO = str5;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                    }
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imo2.O00000o = true;
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z1922222222222222 = z2;
                                    String str3022222222222222 = str5;
                                    str25 = str6;
                                    str24 = str3022222222222222;
                                } catch (UnknownHostException e21) {
                                    e = e21;
                                    httpURLConnection11 = O000000o2;
                                    z12 = z16;
                                    str3 = uuid;
                                    str12 = str13;
                                    str11 = str15;
                                    unknownHostException = e;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    imo2.O0000O0o = "dns_fail";
                                    imo2.O00000oo = imq.O000000o(unknownHostException);
                                    imo2.O00000oO = str5;
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z19222222222222222 = z2;
                                    String str30222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str30222222222222222;
                                } catch (IllegalArgumentException e22) {
                                    e = e22;
                                    httpURLConnection12 = O000000o2;
                                    z13 = z16;
                                    str3 = uuid;
                                    str5 = str13;
                                    str4 = str15;
                                    illegalArgumentException = e;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    imo2.O0000O0o = "dns_fail";
                                    imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                    imo2.O00000oO = str5;
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z192222222222222222 = z2;
                                    String str302222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str302222222222222222;
                                } catch (FileNotFoundException e23) {
                                    e = e23;
                                    httpURLConnection2 = O000000o2;
                                    z3 = z16;
                                    str3 = uuid;
                                    str14 = str15;
                                    fileNotFoundException = e;
                                    if (!z2) {
                                    }
                                    String str3122 = str13;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z1922222222222222222 = z2;
                                    String str3022222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str3022222222222222222;
                                } catch (IOException e24) {
                                    e = e24;
                                    httpURLConnection13 = O000000o2;
                                    str = str6;
                                    z14 = z16;
                                    str3 = uuid;
                                    i9 = i12;
                                    iOException = e;
                                    if (!z2) {
                                    }
                                    String str29222 = str;
                                    str4 = str15;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    i12 = i;
                                    str5 = str13;
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z19222222222222222222 = z2;
                                    String str30222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str30222222222222222222;
                                } catch (Throwable th8) {
                                    th = th8;
                                    httpURLConnection14 = O000000o2;
                                    z2 = z16;
                                    f = f5;
                                    j = j13;
                                    z = z18;
                                    th = th;
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (!z17) {
                                    }
                                    boolean z2022 = z2;
                                    if (httpURLConnection != null) {
                                    }
                                    z2 = z2022;
                                    imq.O000000o(imo2, cdnConfigModel);
                                    throw th;
                                }
                                try {
                                    imo2.O0000Oo = imq.O000000o((float) j, false);
                                    imo2.O0000Oo0 = O000000o2.getHeaderField("via");
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(O000000o2.getResponseCode());
                                    imo2.O0000OOo = sb3.toString();
                                } catch (MalformedURLException e25) {
                                    e = e25;
                                    httpURLConnection9 = O000000o2;
                                    z10 = z16;
                                    j13 = j;
                                    str8 = str13;
                                    str7 = str15;
                                    str6 = str;
                                    malformedURLException = e;
                                    if (!z2) {
                                    }
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z192222222222222222222 = z2;
                                    String str302222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str302222222222222222222;
                                } catch (SocketTimeoutException e26) {
                                    e = e26;
                                    httpURLConnection10 = O000000o2;
                                    z11 = z16;
                                    j13 = j;
                                    str10 = str13;
                                    str9 = str15;
                                    str6 = str;
                                    socketTimeoutException = e;
                                    imo2.O00000oO = str5;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                    }
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imo2.O00000o = true;
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z1922222222222222222222 = z2;
                                    String str3022222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str3022222222222222222222;
                                } catch (UnknownHostException e27) {
                                    e = e27;
                                    httpURLConnection11 = O000000o2;
                                    z12 = z16;
                                    j13 = j;
                                    str12 = str13;
                                    str11 = str15;
                                    str6 = str;
                                    unknownHostException = e;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    imo2.O0000O0o = "dns_fail";
                                    imo2.O00000oo = imq.O000000o(unknownHostException);
                                    imo2.O00000oO = str5;
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z19222222222222222222222 = z2;
                                    String str30222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str30222222222222222222222;
                                } catch (IllegalArgumentException e28) {
                                    e = e28;
                                    httpURLConnection12 = O000000o2;
                                    z13 = z16;
                                    j13 = j;
                                    str5 = str13;
                                    str4 = str15;
                                    str6 = str;
                                    illegalArgumentException = e;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    imo2.O0000O0o = "dns_fail";
                                    imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                    imo2.O00000oO = str5;
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z192222222222222222222222 = z2;
                                    String str302222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str302222222222222222222222;
                                } catch (FileNotFoundException e29) {
                                    e = e29;
                                    httpURLConnection2 = O000000o2;
                                    z3 = z16;
                                    j13 = j;
                                    str14 = str15;
                                    str6 = str;
                                    fileNotFoundException = e;
                                    if (!z2) {
                                    }
                                    String str31222 = str13;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z1922222222222222222222222 = z2;
                                    String str3022222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str3022222222222222222222222;
                                } catch (IOException e30) {
                                    e = e30;
                                    HttpURLConnection httpURLConnection15 = O000000o2;
                                    z14 = z16;
                                    j13 = j;
                                    i9 = i12;
                                    iOException = e;
                                    if (!z2) {
                                    }
                                    String str292222 = str;
                                    str4 = str15;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    i12 = i;
                                    str5 = str13;
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z19222222222222222222222222 = z2;
                                    String str30222222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str30222222222222222222222222;
                                } catch (Throwable th9) {
                                }
                            } else {
                                str18 = uuid;
                                j = j13;
                            }
                            if (responseCode == 206 || responseCode == 200) {
                                str3 = str18;
                                try {
                                    int contentLength = O000000o2.getContentLength();
                                    String headerField = O000000o2.getHeaderField("Content-Range");
                                    if (!TextUtils.isEmpty(headerField)) {
                                        String[] split = headerField.split("/");
                                        str = str6;
                                        if (split.length >= 2) {
                                            if (!TextUtils.isEmpty(split[0])) {
                                                String[] split2 = split[0].split(" ");
                                                i4 = responseCode;
                                                if (split2.length >= 2) {
                                                    str20 = split2[1];
                                                    str19 = TextUtils.isEmpty(split[1]) ? split[1] : str2;
                                                }
                                            } else {
                                                i4 = responseCode;
                                            }
                                            str20 = str2;
                                            if (TextUtils.isEmpty(split[1])) {
                                            }
                                        } else {
                                            i4 = responseCode;
                                            str20 = str2;
                                            str19 = str20;
                                        }
                                        if (imo2 != null) {
                                            imo2.O0000o00 = str20;
                                            imo2.O0000o0 = str19;
                                        }
                                    } else {
                                        str = str6;
                                        i4 = responseCode;
                                    }
                                    if (contentLength > 0) {
                                        int i15 = 65536;
                                        if (contentLength != 65536) {
                                            if (this.O00000oo >= this.O00000oO.O000000o().O00000o0 - 1) {
                                                i15 = 65536;
                                            }
                                            httpURLConnection = O000000o2;
                                            z2 = z16;
                                            j2 = j;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "DownloadThread fail contentLength1:".concat(String.valueOf(contentLength)));
                                            throw new IOException("DownloadThread fail contentLength(" + contentLength + ")!=DEFAULT_CHUNK_SIZE65536");
                                        }
                                        if (contentLength <= i15) {
                                            j12 = System.currentTimeMillis();
                                            InputStream inputStream = O000000o2.getInputStream();
                                            long currentTimeMillis3 = System.currentTimeMillis();
                                            int i16 = 0;
                                            while (true) {
                                                httpURLConnection = O000000o2;
                                                try {
                                                    read = inputStream.read(this.O0000O0o.array(), i16, 65536 - i16);
                                                    if (read == -1) {
                                                        z2 = z16;
                                                        i16 = i12;
                                                        break;
                                                    }
                                                    i16 += read;
                                                    try {
                                                        z2 = z16;
                                                        try {
                                                            O00000Oo += (long) read;
                                                            if (65536 - i16 > 0) {
                                                                i12 = i16;
                                                                z16 = z2;
                                                                O000000o2 = httpURLConnection;
                                                            }
                                                        } catch (MalformedURLException e31) {
                                                            e = e31;
                                                            malformedURLException2 = e;
                                                            j13 = j;
                                                            str8 = str13;
                                                            str7 = str15;
                                                            str6 = str;
                                                            if (!z2) {
                                                            }
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            }
                                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            }
                                                            imo2.O0000OoO = System.currentTimeMillis();
                                                            imo2.O0000o = "failed";
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (imo2 != null) {
                                                            }
                                                            str26 = str2;
                                                            str23 = str4;
                                                            imo = imo2;
                                                            i11 = i13;
                                                            uuid = str3;
                                                            i10 = 1;
                                                            z17 = true;
                                                            z18 = true;
                                                            boolean z192222222222222222222222222 = z2;
                                                            String str302222222222222222222222222 = str5;
                                                            str25 = str6;
                                                            str24 = str302222222222222222222222222;
                                                        } catch (SocketTimeoutException e32) {
                                                            e = e32;
                                                            socketTimeoutException2 = e;
                                                            j13 = j;
                                                            str10 = str13;
                                                            str9 = str15;
                                                            str6 = str;
                                                            imo2.O00000oO = str5;
                                                            if (imo2.O0000Oo <= 0.0f) {
                                                            }
                                                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                            }
                                                            imo2.O0000o0O = str6;
                                                            imo2.O0000o0o = str6;
                                                            imo2.O0000o = "failed";
                                                            imo2.O00000o = true;
                                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            }
                                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            }
                                                            imo2.O0000OoO = System.currentTimeMillis();
                                                            imo2.O0000o = "failed";
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (imo2 != null) {
                                                            }
                                                            str26 = str2;
                                                            str23 = str4;
                                                            imo = imo2;
                                                            i11 = i13;
                                                            uuid = str3;
                                                            i10 = 1;
                                                            z17 = true;
                                                            z18 = true;
                                                            boolean z1922222222222222222222222222 = z2;
                                                            String str3022222222222222222222222222 = str5;
                                                            str25 = str6;
                                                            str24 = str3022222222222222222222222222;
                                                        } catch (UnknownHostException e33) {
                                                            e = e33;
                                                            unknownHostException2 = e;
                                                            j13 = j;
                                                            str12 = str13;
                                                            str11 = str15;
                                                            str6 = str;
                                                            if (imo2.O0000Oo <= 0.0f) {
                                                            }
                                                            imo2.O0000O0o = "dns_fail";
                                                            imo2.O00000oo = imq.O000000o(unknownHostException);
                                                            imo2.O00000oO = str5;
                                                            imo2.O0000o0O = str6;
                                                            imo2.O0000o0o = str6;
                                                            imo2.O0000o = "failed";
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            }
                                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            }
                                                            imo2.O0000OoO = System.currentTimeMillis();
                                                            imo2.O0000o = "failed";
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (imo2 != null) {
                                                            }
                                                            str26 = str2;
                                                            str23 = str4;
                                                            imo = imo2;
                                                            i11 = i13;
                                                            uuid = str3;
                                                            i10 = 1;
                                                            z17 = true;
                                                            z18 = true;
                                                            boolean z19222222222222222222222222222 = z2;
                                                            String str30222222222222222222222222222 = str5;
                                                            str25 = str6;
                                                            str24 = str30222222222222222222222222222;
                                                        } catch (IllegalArgumentException e34) {
                                                            e = e34;
                                                            illegalArgumentException2 = e;
                                                            j13 = j;
                                                            str5 = str13;
                                                            str4 = str15;
                                                            str6 = str;
                                                            if (imo2.O0000Oo <= 0.0f) {
                                                            }
                                                            imo2.O0000O0o = "dns_fail";
                                                            imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                            imo2.O00000oO = str5;
                                                            imo2.O0000o0O = str6;
                                                            imo2.O0000o0o = str6;
                                                            imo2.O0000o = "failed";
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            }
                                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            }
                                                            imo2.O0000OoO = System.currentTimeMillis();
                                                            imo2.O0000o = "failed";
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (imo2 != null) {
                                                            }
                                                            str26 = str2;
                                                            str23 = str4;
                                                            imo = imo2;
                                                            i11 = i13;
                                                            uuid = str3;
                                                            i10 = 1;
                                                            z17 = true;
                                                            z18 = true;
                                                            boolean z192222222222222222222222222222 = z2;
                                                            String str302222222222222222222222222222 = str5;
                                                            str25 = str6;
                                                            str24 = str302222222222222222222222222222;
                                                        } catch (FileNotFoundException e35) {
                                                            e = e35;
                                                            fileNotFoundException2 = e;
                                                            j13 = j;
                                                            str14 = str15;
                                                            str6 = str;
                                                            if (!z2) {
                                                            }
                                                            String str312222 = str13;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            }
                                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            }
                                                            imo2.O0000OoO = System.currentTimeMillis();
                                                            imo2.O0000o = "failed";
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (imo2 != null) {
                                                            }
                                                            str26 = str2;
                                                            str23 = str4;
                                                            imo = imo2;
                                                            i11 = i13;
                                                            uuid = str3;
                                                            i10 = 1;
                                                            z17 = true;
                                                            z18 = true;
                                                            boolean z1922222222222222222222222222222 = z2;
                                                            String str3022222222222222222222222222222 = str5;
                                                            str25 = str6;
                                                            str24 = str3022222222222222222222222222222;
                                                        } catch (IOException e36) {
                                                            e = e36;
                                                            iOException2 = e;
                                                            j13 = j;
                                                            i = i12;
                                                            if (!z2) {
                                                            }
                                                            String str2922222 = str;
                                                            str4 = str15;
                                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            }
                                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            }
                                                            imo2.O0000OoO = System.currentTimeMillis();
                                                            imo2.O0000o = "failed";
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (imo2 != null) {
                                                            }
                                                            i12 = i;
                                                            str5 = str13;
                                                            str26 = str2;
                                                            str23 = str4;
                                                            imo = imo2;
                                                            i11 = i13;
                                                            uuid = str3;
                                                            i10 = 1;
                                                            z17 = true;
                                                            z18 = true;
                                                            boolean z19222222222222222222222222222222 = z2;
                                                            String str30222222222222222222222222222222 = str5;
                                                            str25 = str6;
                                                            str24 = str30222222222222222222222222222222;
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            th4 = th;
                                                            f2 = f5;
                                                            z = z18;
                                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            }
                                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            }
                                                            imo2.O0000OoO = System.currentTimeMillis();
                                                            imo2.O0000o = "failed";
                                                            if (!z17) {
                                                            }
                                                            boolean z20222 = z2;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            z2 = z20222;
                                                            imq.O000000o(imo2, cdnConfigModel);
                                                            throw th;
                                                        }
                                                    } catch (MalformedURLException e37) {
                                                        e = e37;
                                                        z2 = z16;
                                                        malformedURLException2 = e;
                                                        j13 = j;
                                                        str8 = str13;
                                                        str7 = str15;
                                                        str6 = str;
                                                        if (!z2) {
                                                        }
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z192222222222222222222222222222222 = z2;
                                                        String str302222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str302222222222222222222222222222222;
                                                    } catch (SocketTimeoutException e38) {
                                                        e = e38;
                                                        z2 = z16;
                                                        socketTimeoutException2 = e;
                                                        j13 = j;
                                                        str10 = str13;
                                                        str9 = str15;
                                                        str6 = str;
                                                        imo2.O00000oO = str5;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                        }
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imo2.O00000o = true;
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z1922222222222222222222222222222222 = z2;
                                                        String str3022222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str3022222222222222222222222222222222;
                                                    } catch (UnknownHostException e39) {
                                                        e = e39;
                                                        z2 = z16;
                                                        unknownHostException2 = e;
                                                        j13 = j;
                                                        str12 = str13;
                                                        str11 = str15;
                                                        str6 = str;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        imo2.O0000O0o = "dns_fail";
                                                        imo2.O00000oo = imq.O000000o(unknownHostException);
                                                        imo2.O00000oO = str5;
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z19222222222222222222222222222222222 = z2;
                                                        String str30222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str30222222222222222222222222222222222;
                                                    } catch (IllegalArgumentException e40) {
                                                        e = e40;
                                                        z2 = z16;
                                                        illegalArgumentException2 = e;
                                                        j13 = j;
                                                        str5 = str13;
                                                        str4 = str15;
                                                        str6 = str;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        imo2.O0000O0o = "dns_fail";
                                                        imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                        imo2.O00000oO = str5;
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z192222222222222222222222222222222222 = z2;
                                                        String str302222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str302222222222222222222222222222222222;
                                                    } catch (FileNotFoundException e41) {
                                                        e = e41;
                                                        z2 = z16;
                                                        fileNotFoundException2 = e;
                                                        j13 = j;
                                                        str14 = str15;
                                                        str6 = str;
                                                        if (!z2) {
                                                        }
                                                        String str3122222 = str13;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z1922222222222222222222222222222222222 = z2;
                                                        String str3022222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str3022222222222222222222222222222222222;
                                                    } catch (IOException e42) {
                                                        e = e42;
                                                        z2 = z16;
                                                        iOException2 = e;
                                                        j13 = j;
                                                        i = i12;
                                                        if (!z2) {
                                                        }
                                                        String str29222222 = str;
                                                        str4 = str15;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        i12 = i;
                                                        str5 = str13;
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z19222222222222222222222222222222222222 = z2;
                                                        String str30222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str30222222222222222222222222222222222222;
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        z2 = z16;
                                                        th4 = th;
                                                        f2 = f5;
                                                        z = z18;
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (!z17) {
                                                        }
                                                        boolean z202222 = z2;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        z2 = z202222;
                                                        imq.O000000o(imo2, cdnConfigModel);
                                                        throw th;
                                                    }
                                                } catch (MalformedURLException e43) {
                                                    e = e43;
                                                    z2 = z16;
                                                    j2 = j;
                                                    malformedURLException2 = e;
                                                    j13 = j3;
                                                    str8 = str13;
                                                    str7 = str15;
                                                    str6 = str;
                                                    if (!z2) {
                                                    }
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z192222222222222222222222222222222222222 = z2;
                                                    String str302222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str302222222222222222222222222222222222222;
                                                } catch (SocketTimeoutException e44) {
                                                    e = e44;
                                                    z2 = z16;
                                                    j2 = j;
                                                    socketTimeoutException2 = e;
                                                    j13 = j4;
                                                    str10 = str13;
                                                    str9 = str15;
                                                    str6 = str;
                                                    imo2.O00000oO = str5;
                                                    if (imo2.O0000Oo <= 0.0f) {
                                                    }
                                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                    }
                                                    imo2.O0000o0O = str6;
                                                    imo2.O0000o0o = str6;
                                                    imo2.O0000o = "failed";
                                                    imo2.O00000o = true;
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z1922222222222222222222222222222222222222 = z2;
                                                    String str3022222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str3022222222222222222222222222222222222222;
                                                } catch (UnknownHostException e45) {
                                                    e = e45;
                                                    z2 = z16;
                                                    j2 = j;
                                                    unknownHostException2 = e;
                                                    j13 = j5;
                                                    str12 = str13;
                                                    str11 = str15;
                                                    str6 = str;
                                                    if (imo2.O0000Oo <= 0.0f) {
                                                    }
                                                    imo2.O0000O0o = "dns_fail";
                                                    imo2.O00000oo = imq.O000000o(unknownHostException);
                                                    imo2.O00000oO = str5;
                                                    imo2.O0000o0O = str6;
                                                    imo2.O0000o0o = str6;
                                                    imo2.O0000o = "failed";
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z19222222222222222222222222222222222222222 = z2;
                                                    String str30222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str30222222222222222222222222222222222222222;
                                                } catch (IllegalArgumentException e46) {
                                                    e = e46;
                                                    z2 = z16;
                                                    j2 = j;
                                                    illegalArgumentException2 = e;
                                                    j13 = j6;
                                                    str5 = str13;
                                                    str4 = str15;
                                                    str6 = str;
                                                    if (imo2.O0000Oo <= 0.0f) {
                                                    }
                                                    imo2.O0000O0o = "dns_fail";
                                                    imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                    imo2.O00000oO = str5;
                                                    imo2.O0000o0O = str6;
                                                    imo2.O0000o0o = str6;
                                                    imo2.O0000o = "failed";
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z192222222222222222222222222222222222222222 = z2;
                                                    String str302222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str302222222222222222222222222222222222222222;
                                                } catch (FileNotFoundException e47) {
                                                    e = e47;
                                                    z2 = z16;
                                                    j2 = j;
                                                    fileNotFoundException2 = e;
                                                    j13 = j7;
                                                    str14 = str15;
                                                    str6 = str;
                                                    if (!z2) {
                                                    }
                                                    String str31222222 = str13;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z1922222222222222222222222222222222222222222 = z2;
                                                    String str3022222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str3022222222222222222222222222222222222222222;
                                                } catch (IOException e48) {
                                                    e = e48;
                                                    z2 = z16;
                                                    j2 = j;
                                                    iOException2 = e;
                                                    j13 = j2;
                                                    i = i12;
                                                    if (!z2) {
                                                    }
                                                    String str292222222 = str;
                                                    str4 = str15;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    i12 = i;
                                                    str5 = str13;
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z19222222222222222222222222222222222222222222 = z2;
                                                    String str30222222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str30222222222222222222222222222222222222222222;
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    z2 = z16;
                                                    th4 = th;
                                                    f2 = f5;
                                                    z = z18;
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (!z17) {
                                                    }
                                                    boolean z2022222 = z2;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    z2 = z2022222;
                                                    imq.O000000o(imo2, cdnConfigModel);
                                                    throw th;
                                                }
                                            }
                                            try {
                                                sb = new StringBuilder("UnicomDigestAuthenticator 789 == 读取流成功 ==  耗时=");
                                                j10 = j;
                                            } catch (MalformedURLException e49) {
                                                e = e49;
                                                j3 = j;
                                                malformedURLException2 = e;
                                                i12 = i;
                                                j13 = j3;
                                                str8 = str13;
                                                str7 = str15;
                                                str6 = str;
                                                if (!z2) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z192222222222222222222222222222222222222222222 = z2;
                                                String str302222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str302222222222222222222222222222222222222222222;
                                            } catch (SocketTimeoutException e50) {
                                                e = e50;
                                                j4 = j;
                                                socketTimeoutException2 = e;
                                                i12 = i;
                                                j13 = j4;
                                                str10 = str13;
                                                str9 = str15;
                                                str6 = str;
                                                imo2.O00000oO = str5;
                                                if (imo2.O0000Oo <= 0.0f) {
                                                }
                                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                }
                                                imo2.O0000o0O = str6;
                                                imo2.O0000o0o = str6;
                                                imo2.O0000o = "failed";
                                                imo2.O00000o = true;
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z1922222222222222222222222222222222222222222222 = z2;
                                                String str3022222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str3022222222222222222222222222222222222222222222;
                                            } catch (UnknownHostException e51) {
                                                e = e51;
                                                j5 = j;
                                                unknownHostException2 = e;
                                                i12 = i;
                                                j13 = j5;
                                                str12 = str13;
                                                str11 = str15;
                                                str6 = str;
                                                if (imo2.O0000Oo <= 0.0f) {
                                                }
                                                imo2.O0000O0o = "dns_fail";
                                                imo2.O00000oo = imq.O000000o(unknownHostException);
                                                imo2.O00000oO = str5;
                                                imo2.O0000o0O = str6;
                                                imo2.O0000o0o = str6;
                                                imo2.O0000o = "failed";
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z19222222222222222222222222222222222222222222222 = z2;
                                                String str30222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str30222222222222222222222222222222222222222222222;
                                            } catch (IllegalArgumentException e52) {
                                                e = e52;
                                                j6 = j;
                                                illegalArgumentException2 = e;
                                                i12 = i;
                                                j13 = j6;
                                                str5 = str13;
                                                str4 = str15;
                                                str6 = str;
                                                if (imo2.O0000Oo <= 0.0f) {
                                                }
                                                imo2.O0000O0o = "dns_fail";
                                                imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                imo2.O00000oO = str5;
                                                imo2.O0000o0O = str6;
                                                imo2.O0000o0o = str6;
                                                imo2.O0000o = "failed";
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z192222222222222222222222222222222222222222222222 = z2;
                                                String str302222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str302222222222222222222222222222222222222222222222;
                                            } catch (FileNotFoundException e53) {
                                                e = e53;
                                                j7 = j;
                                                fileNotFoundException2 = e;
                                                i12 = i;
                                                j13 = j7;
                                                str14 = str15;
                                                str6 = str;
                                                if (!z2) {
                                                }
                                                String str312222222 = str13;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z1922222222222222222222222222222222222222222222222 = z2;
                                                String str3022222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str3022222222222222222222222222222222222222222222222;
                                            } catch (IOException e54) {
                                                e = e54;
                                                j8 = j;
                                                iOException = e;
                                                j13 = j8;
                                                if (!z2) {
                                                }
                                                String str2922222222 = str;
                                                str4 = str15;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                i12 = i;
                                                str5 = str13;
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z19222222222222222222222222222222222222222222222222 = z2;
                                                String str30222222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str30222222222222222222222222222222222222222222222222;
                                            } catch (Throwable th13) {
                                                th = th13;
                                                th4 = th;
                                                f2 = f5;
                                                z = z18;
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (!z17) {
                                                }
                                                boolean z20222222 = z2;
                                                if (httpURLConnection != null) {
                                                }
                                                z2 = z20222222;
                                                imq.O000000o(imo2, cdnConfigModel);
                                                throw th;
                                            }
                                            try {
                                                sb.append(System.currentTimeMillis() - currentTimeMillis3);
                                                imc.O000000o(sb.toString());
                                                if (imo2 != null) {
                                                    try {
                                                        currentTimeMillis = System.currentTimeMillis() - j12;
                                                        if (currentTimeMillis != 0) {
                                                            f5 = ((((float) i) + 0.0f) / 1024.0f) / ((((float) currentTimeMillis) + 0.0f) / 1000.0f);
                                                        }
                                                        f3 = f5;
                                                    } catch (MalformedURLException e55) {
                                                        malformedURLException = e55;
                                                        i5 = i;
                                                        str8 = str13;
                                                        str7 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (!z2) {
                                                        }
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z192222222222222222222222222222222222222222222222222 = z2;
                                                        String str302222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str302222222222222222222222222222222222222222222222222;
                                                    } catch (SocketTimeoutException e56) {
                                                        socketTimeoutException = e56;
                                                        i6 = i;
                                                        str10 = str13;
                                                        str9 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        imo2.O00000oO = str5;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                        }
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imo2.O00000o = true;
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z1922222222222222222222222222222222222222222222222222 = z2;
                                                        String str3022222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str3022222222222222222222222222222222222222222222222222;
                                                    } catch (UnknownHostException e57) {
                                                        unknownHostException = e57;
                                                        i7 = i;
                                                        str12 = str13;
                                                        str11 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        imo2.O0000O0o = "dns_fail";
                                                        imo2.O00000oo = imq.O000000o(unknownHostException);
                                                        imo2.O00000oO = str5;
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z19222222222222222222222222222222222222222222222222222 = z2;
                                                        String str30222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str30222222222222222222222222222222222222222222222222222;
                                                    } catch (IllegalArgumentException e58) {
                                                        illegalArgumentException = e58;
                                                        i8 = i;
                                                        str5 = str13;
                                                        str4 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        imo2.O0000O0o = "dns_fail";
                                                        imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                        imo2.O00000oO = str5;
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z192222222222222222222222222222222222222222222222222222 = z2;
                                                        String str302222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str302222222222222222222222222222222222222222222222222222;
                                                    } catch (FileNotFoundException e59) {
                                                        fileNotFoundException = e59;
                                                        i12 = i;
                                                        str14 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (!z2) {
                                                        }
                                                        String str3122222222 = str13;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z1922222222222222222222222222222222222222222222222222222 = z2;
                                                        String str3022222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str3022222222222222222222222222222222222222222222222222222;
                                                    } catch (IOException e60) {
                                                        iOException = e60;
                                                        j13 = j10;
                                                        if (!z2) {
                                                        }
                                                        String str29222222222 = str;
                                                        str4 = str15;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        i12 = i;
                                                        str5 = str13;
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z19222222222222222222222222222222222222222222222222222222 = z2;
                                                        String str30222222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str30222222222222222222222222222222222222222222222222222222;
                                                    } catch (Throwable th14) {
                                                        th = th14;
                                                        f4 = f5;
                                                        z = z18;
                                                        j = j10;
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (!z17) {
                                                        }
                                                        boolean z202222222 = z2;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        z2 = z202222222;
                                                        imq.O000000o(imo2, cdnConfigModel);
                                                        throw th;
                                                    }
                                                    try {
                                                        imo2.O0000o0O = String.valueOf(i);
                                                        imo2.O0000o0o = String.valueOf(currentTimeMillis);
                                                        if (read != -1) {
                                                            if (i != 65536) {
                                                                imo2.O0000o = "failed";
                                                                StringBuilder sb4 = new StringBuilder();
                                                                sb4.append(imq.O000000o(f3, true));
                                                                imo2.O00000oO = sb4.toString();
                                                                imo2.O00000Oo = (long) contentLength;
                                                            }
                                                        }
                                                        imo2.O0000o = "success";
                                                        StringBuilder sb42 = new StringBuilder();
                                                        sb42.append(imq.O000000o(f3, true));
                                                        imo2.O00000oO = sb42.toString();
                                                        imo2.O00000Oo = (long) contentLength;
                                                    } catch (MalformedURLException e61) {
                                                        malformedURLException = e61;
                                                        i5 = i;
                                                        f5 = f3;
                                                        str8 = str13;
                                                        str7 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (!z2) {
                                                        }
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z192222222222222222222222222222222222222222222222222222222 = z2;
                                                        String str302222222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str302222222222222222222222222222222222222222222222222222222;
                                                    } catch (SocketTimeoutException e62) {
                                                        socketTimeoutException = e62;
                                                        i6 = i;
                                                        f5 = f3;
                                                        str10 = str13;
                                                        str9 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        imo2.O00000oO = str5;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                        }
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imo2.O00000o = true;
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z1922222222222222222222222222222222222222222222222222222222 = z2;
                                                        String str3022222222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str3022222222222222222222222222222222222222222222222222222222;
                                                    } catch (UnknownHostException e63) {
                                                        unknownHostException = e63;
                                                        i7 = i;
                                                        f5 = f3;
                                                        str12 = str13;
                                                        str11 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        imo2.O0000O0o = "dns_fail";
                                                        imo2.O00000oo = imq.O000000o(unknownHostException);
                                                        imo2.O00000oO = str5;
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z19222222222222222222222222222222222222222222222222222222222 = z2;
                                                        String str30222222222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str30222222222222222222222222222222222222222222222222222222222;
                                                    } catch (IllegalArgumentException e64) {
                                                        illegalArgumentException = e64;
                                                        i8 = i;
                                                        f5 = f3;
                                                        str5 = str13;
                                                        str4 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (imo2.O0000Oo <= 0.0f) {
                                                        }
                                                        imo2.O0000O0o = "dns_fail";
                                                        imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                        imo2.O00000oO = str5;
                                                        imo2.O0000o0O = str6;
                                                        imo2.O0000o0o = str6;
                                                        imo2.O0000o = "failed";
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z192222222222222222222222222222222222222222222222222222222222 = z2;
                                                        String str302222222222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str302222222222222222222222222222222222222222222222222222222222;
                                                    } catch (FileNotFoundException e65) {
                                                        fileNotFoundException = e65;
                                                        i12 = i;
                                                        f5 = f3;
                                                        str14 = str15;
                                                        str6 = str;
                                                        j13 = j10;
                                                        if (!z2) {
                                                        }
                                                        String str31222222222 = str13;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z1922222222222222222222222222222222222222222222222222222222222 = z2;
                                                        String str3022222222222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str3022222222222222222222222222222222222222222222222222222222222;
                                                    } catch (IOException e66) {
                                                        iOException = e66;
                                                        f5 = f3;
                                                        j13 = j10;
                                                        if (!z2) {
                                                        }
                                                        String str292222222222 = str;
                                                        str4 = str15;
                                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (httpURLConnection != null) {
                                                        }
                                                        if (imo2 != null) {
                                                        }
                                                        i12 = i;
                                                        str5 = str13;
                                                        str26 = str2;
                                                        str23 = str4;
                                                        imo = imo2;
                                                        i11 = i13;
                                                        uuid = str3;
                                                        i10 = 1;
                                                        z17 = true;
                                                        z18 = true;
                                                        boolean z19222222222222222222222222222222222222222222222222222222222222 = z2;
                                                        String str30222222222222222222222222222222222222222222222222222222222222 = str5;
                                                        str25 = str6;
                                                        str24 = str30222222222222222222222222222222222222222222222222222222222222;
                                                    } catch (Throwable th15) {
                                                        th = th15;
                                                        f4 = f3;
                                                        z = z18;
                                                        j = j10;
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        imo2.O0000o = "failed";
                                                        if (!z17) {
                                                        }
                                                        boolean z2022222222 = z2;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        z2 = z2022222222;
                                                        imq.O000000o(imo2, cdnConfigModel);
                                                        throw th;
                                                    }
                                                } else {
                                                    f3 = f5;
                                                }
                                                try {
                                                    inputStream.close();
                                                    this.O00000oO.O00000Oo = this.O0000O0o;
                                                    if (z2 == 0 && imo2 != null) {
                                                        if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                            imo2.O0000Oo0 = null;
                                                        }
                                                        if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                            imo2.O0000OOo = str2;
                                                        }
                                                        imo2.O0000OoO = System.currentTimeMillis();
                                                        if (imo2.O0000o == null || !imo2.O0000o.contains("success")) {
                                                            imo2.O0000o = "failed";
                                                        }
                                                        if (!z17) {
                                                            int i17 = cdnConfigModel.O00000oO;
                                                            if (i17 == -1) {
                                                                z9 = true;
                                                            } else {
                                                                if (i17 == 0) {
                                                                    this.O00000o0 = (long) cdnConfigModel.O00000Oo;
                                                                    this.O00000o = (long) cdnConfigModel.O00000o;
                                                                    if (j10 > this.O00000o0 * 1000) {
                                                                        imo2.O0000O0o = "cdn_connected_too_slow";
                                                                        imo2.O00000oo = "connected_time=" + (((float) j10) / 1000.0f) + "s, connected_time_threshold=" + this.O00000o0 + "s";
                                                                    } else if (((float) this.O00000o) > f3) {
                                                                        imo2.O0000O0o = "cdn_download_too_slow";
                                                                        imo2.O00000oo = "download_speed=" + imq.O000000o(f3, true) + "KB/s, download_speed_threshold=" + this.O00000o + "KB/s";
                                                                    }
                                                                } else {
                                                                    long j14 = j10;
                                                                    if (i17 == 1) {
                                                                        this.O00000o0 = (long) cdnConfigModel.f12180O000000o;
                                                                        this.O00000o = (long) cdnConfigModel.O00000o0;
                                                                        if (j14 > this.O00000o0 * 1000) {
                                                                            imo2.O0000O0o = "cdn_connected_too_slow";
                                                                            imo2.O00000oo = "connected_time=" + (((float) j14) / 1000.0f) + "s, connected_time_threshold=" + this.O00000o0 + "s";
                                                                        } else if (((float) this.O00000o) > f3) {
                                                                            imo2.O0000O0o = "cdn_download_too_slow";
                                                                            imo2.O00000oo = "download_speed=" + imq.O000000o(f3, true) + "KB/s, download_speed_threshold=" + this.O00000o + "KB/s";
                                                                        }
                                                                    }
                                                                }
                                                                z9 = z2;
                                                                z18 = true;
                                                            }
                                                            if (httpURLConnection != null) {
                                                                httpURLConnection.disconnect();
                                                            }
                                                            z2 = z9;
                                                        }
                                                        z9 = z2;
                                                        if (httpURLConnection != null) {
                                                        }
                                                        z2 = z9;
                                                    }
                                                    if (imo2 != null && z18 && !z2 && !TextUtils.isEmpty(imo2.O0000O0o) && !TextUtils.isEmpty(imo2.O00000oo)) {
                                                        imq.O000000o(imo2, cdnConfigModel);
                                                    }
                                                    return i4;
                                                } catch (MalformedURLException e67) {
                                                    malformedURLException2 = e67;
                                                    i12 = i;
                                                    j13 = j10;
                                                    f5 = f3;
                                                } catch (SocketTimeoutException e68) {
                                                    socketTimeoutException2 = e68;
                                                    i12 = i;
                                                    j13 = j10;
                                                    f5 = f3;
                                                    str10 = str13;
                                                    str9 = str15;
                                                    str6 = str;
                                                    imo2.O00000oO = str5;
                                                    if (imo2.O0000Oo <= 0.0f) {
                                                    }
                                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                    }
                                                    imo2.O0000o0O = str6;
                                                    imo2.O0000o0o = str6;
                                                    imo2.O0000o = "failed";
                                                    imo2.O00000o = true;
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z192222222222222222222222222222222222222222222222222222222222222 = z2;
                                                    String str302222222222222222222222222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str302222222222222222222222222222222222222222222222222222222222222;
                                                } catch (UnknownHostException e69) {
                                                    unknownHostException2 = e69;
                                                    i12 = i;
                                                    j13 = j10;
                                                    f5 = f3;
                                                    str12 = str13;
                                                    str11 = str15;
                                                    str6 = str;
                                                    if (imo2.O0000Oo <= 0.0f) {
                                                    }
                                                    imo2.O0000O0o = "dns_fail";
                                                    imo2.O00000oo = imq.O000000o(unknownHostException);
                                                    imo2.O00000oO = str5;
                                                    imo2.O0000o0O = str6;
                                                    imo2.O0000o0o = str6;
                                                    imo2.O0000o = "failed";
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z1922222222222222222222222222222222222222222222222222222222222222 = z2;
                                                    String str3022222222222222222222222222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str3022222222222222222222222222222222222222222222222222222222222222;
                                                } catch (IllegalArgumentException e70) {
                                                    illegalArgumentException2 = e70;
                                                    i12 = i;
                                                    j13 = j10;
                                                    f5 = f3;
                                                    str5 = str13;
                                                    str4 = str15;
                                                    str6 = str;
                                                    if (imo2.O0000Oo <= 0.0f) {
                                                    }
                                                    imo2.O0000O0o = "dns_fail";
                                                    imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                    imo2.O00000oO = str5;
                                                    imo2.O0000o0O = str6;
                                                    imo2.O0000o0o = str6;
                                                    imo2.O0000o = "failed";
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z19222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                    String str30222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str30222222222222222222222222222222222222222222222222222222222222222;
                                                } catch (FileNotFoundException e71) {
                                                    fileNotFoundException2 = e71;
                                                    i12 = i;
                                                    j13 = j10;
                                                    f5 = f3;
                                                    str14 = str15;
                                                    str6 = str;
                                                    if (!z2) {
                                                    }
                                                    String str312222222222 = str13;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z192222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                    String str302222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str302222222222222222222222222222222222222222222222222222222222222222;
                                                } catch (IOException e72) {
                                                    iOException = e72;
                                                    j13 = j10;
                                                    f5 = f3;
                                                    if (!z2) {
                                                    }
                                                    String str2922222222222 = str;
                                                    str4 = str15;
                                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (httpURLConnection != null) {
                                                    }
                                                    if (imo2 != null) {
                                                    }
                                                    i12 = i;
                                                    str5 = str13;
                                                    str26 = str2;
                                                    str23 = str4;
                                                    imo = imo2;
                                                    i11 = i13;
                                                    uuid = str3;
                                                    i10 = 1;
                                                    z17 = true;
                                                    z18 = true;
                                                    boolean z1922222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                    String str3022222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                    str25 = str6;
                                                    str24 = str3022222222222222222222222222222222222222222222222222222222222222222;
                                                } catch (Throwable th16) {
                                                    th4 = th16;
                                                    f2 = f3;
                                                    j = j10;
                                                    z = z18;
                                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                    }
                                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                    }
                                                    imo2.O0000OoO = System.currentTimeMillis();
                                                    imo2.O0000o = "failed";
                                                    if (!z17) {
                                                    }
                                                    boolean z20222222222 = z2;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    z2 = z20222222222;
                                                    imq.O000000o(imo2, cdnConfigModel);
                                                    throw th;
                                                }
                                            } catch (MalformedURLException e73) {
                                                e = e73;
                                                j3 = j10;
                                                malformedURLException2 = e;
                                                i12 = i;
                                                j13 = j3;
                                                str8 = str13;
                                                str7 = str15;
                                                str6 = str;
                                                if (!z2) {
                                                }
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z19222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                String str30222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str30222222222222222222222222222222222222222222222222222222222222222222;
                                            } catch (SocketTimeoutException e74) {
                                                e = e74;
                                                j4 = j10;
                                                socketTimeoutException2 = e;
                                                i12 = i;
                                                j13 = j4;
                                                str10 = str13;
                                                str9 = str15;
                                                str6 = str;
                                                imo2.O00000oO = str5;
                                                if (imo2.O0000Oo <= 0.0f) {
                                                }
                                                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                                }
                                                imo2.O0000o0O = str6;
                                                imo2.O0000o0o = str6;
                                                imo2.O0000o = "failed";
                                                imo2.O00000o = true;
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z192222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                String str302222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str302222222222222222222222222222222222222222222222222222222222222222222;
                                            } catch (UnknownHostException e75) {
                                                e = e75;
                                                j5 = j10;
                                                unknownHostException2 = e;
                                                i12 = i;
                                                j13 = j5;
                                                str12 = str13;
                                                str11 = str15;
                                                str6 = str;
                                                if (imo2.O0000Oo <= 0.0f) {
                                                }
                                                imo2.O0000O0o = "dns_fail";
                                                imo2.O00000oo = imq.O000000o(unknownHostException);
                                                imo2.O00000oO = str5;
                                                imo2.O0000o0O = str6;
                                                imo2.O0000o0o = str6;
                                                imo2.O0000o = "failed";
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z1922222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                String str3022222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str3022222222222222222222222222222222222222222222222222222222222222222222;
                                            } catch (IllegalArgumentException e76) {
                                                e = e76;
                                                j6 = j10;
                                                illegalArgumentException2 = e;
                                                i12 = i;
                                                j13 = j6;
                                                str5 = str13;
                                                str4 = str15;
                                                str6 = str;
                                                if (imo2.O0000Oo <= 0.0f) {
                                                }
                                                imo2.O0000O0o = "dns_fail";
                                                imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                                imo2.O00000oO = str5;
                                                imo2.O0000o0O = str6;
                                                imo2.O0000o0o = str6;
                                                imo2.O0000o = "failed";
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z19222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                String str30222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str30222222222222222222222222222222222222222222222222222222222222222222222;
                                            } catch (FileNotFoundException e77) {
                                                e = e77;
                                                j7 = j10;
                                                fileNotFoundException2 = e;
                                                i12 = i;
                                                j13 = j7;
                                                str14 = str15;
                                                str6 = str;
                                                if (!z2) {
                                                }
                                                String str3122222222222 = str13;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z192222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                String str302222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str302222222222222222222222222222222222222222222222222222222222222222222222;
                                            } catch (IOException e78) {
                                                e = e78;
                                                j8 = j10;
                                                iOException = e;
                                                j13 = j8;
                                                if (!z2) {
                                                }
                                                String str29222222222222 = str;
                                                str4 = str15;
                                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (httpURLConnection != null) {
                                                }
                                                if (imo2 != null) {
                                                }
                                                i12 = i;
                                                str5 = str13;
                                                str26 = str2;
                                                str23 = str4;
                                                imo = imo2;
                                                i11 = i13;
                                                uuid = str3;
                                                i10 = 1;
                                                z17 = true;
                                                z18 = true;
                                                boolean z1922222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                                String str3022222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                                str25 = str6;
                                                str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222;
                                            } catch (Throwable th17) {
                                                th = th17;
                                                j2 = j10;
                                                th4 = th;
                                                j = j2;
                                                f2 = f5;
                                                z = z18;
                                                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                                }
                                                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                                }
                                                imo2.O0000OoO = System.currentTimeMillis();
                                                imo2.O0000o = "failed";
                                                if (!z17) {
                                                }
                                                boolean z202222222222 = z2;
                                                if (httpURLConnection != null) {
                                                }
                                                z2 = z202222222222;
                                                imq.O000000o(imo2, cdnConfigModel);
                                                throw th;
                                            }
                                        }
                                        httpURLConnection = O000000o2;
                                        z2 = z16;
                                        j2 = j;
                                        try {
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "DownloadThread fail contentLength1:".concat(String.valueOf(contentLength)));
                                            throw new IOException("DownloadThread fail contentLength(" + contentLength + ")!=DEFAULT_CHUNK_SIZE65536");
                                        } catch (MalformedURLException e79) {
                                            e = e79;
                                            malformedURLException2 = e;
                                            j13 = j3;
                                            str8 = str13;
                                            str7 = str15;
                                            str6 = str;
                                            if (!z2) {
                                            }
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                            }
                                            imo2.O0000OoO = System.currentTimeMillis();
                                            imo2.O0000o = "failed";
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo2 != null) {
                                            }
                                            str26 = str2;
                                            str23 = str4;
                                            imo = imo2;
                                            i11 = i13;
                                            uuid = str3;
                                            i10 = 1;
                                            z17 = true;
                                            z18 = true;
                                            boolean z19222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                            String str30222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                            str25 = str6;
                                            str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222;
                                        } catch (SocketTimeoutException e80) {
                                            e = e80;
                                            socketTimeoutException2 = e;
                                            j13 = j4;
                                            str10 = str13;
                                            str9 = str15;
                                            str6 = str;
                                            imo2.O00000oO = str5;
                                            if (imo2.O0000Oo <= 0.0f) {
                                            }
                                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                            }
                                            imo2.O0000o0O = str6;
                                            imo2.O0000o0o = str6;
                                            imo2.O0000o = "failed";
                                            imo2.O00000o = true;
                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                            }
                                            imo2.O0000OoO = System.currentTimeMillis();
                                            imo2.O0000o = "failed";
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo2 != null) {
                                            }
                                            str26 = str2;
                                            str23 = str4;
                                            imo = imo2;
                                            i11 = i13;
                                            uuid = str3;
                                            i10 = 1;
                                            z17 = true;
                                            z18 = true;
                                            boolean z192222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                            String str302222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                            str25 = str6;
                                            str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222;
                                        } catch (UnknownHostException e81) {
                                            e = e81;
                                            unknownHostException2 = e;
                                            j13 = j5;
                                            str12 = str13;
                                            str11 = str15;
                                            str6 = str;
                                            if (imo2.O0000Oo <= 0.0f) {
                                            }
                                            imo2.O0000O0o = "dns_fail";
                                            imo2.O00000oo = imq.O000000o(unknownHostException);
                                            imo2.O00000oO = str5;
                                            imo2.O0000o0O = str6;
                                            imo2.O0000o0o = str6;
                                            imo2.O0000o = "failed";
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                            }
                                            imo2.O0000OoO = System.currentTimeMillis();
                                            imo2.O0000o = "failed";
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo2 != null) {
                                            }
                                            str26 = str2;
                                            str23 = str4;
                                            imo = imo2;
                                            i11 = i13;
                                            uuid = str3;
                                            i10 = 1;
                                            z17 = true;
                                            z18 = true;
                                            boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                            String str3022222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                            str25 = str6;
                                            str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222;
                                        } catch (IllegalArgumentException e82) {
                                            e = e82;
                                            illegalArgumentException2 = e;
                                            j13 = j6;
                                            str5 = str13;
                                            str4 = str15;
                                            str6 = str;
                                            if (imo2.O0000Oo <= 0.0f) {
                                            }
                                            imo2.O0000O0o = "dns_fail";
                                            imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                            imo2.O00000oO = str5;
                                            imo2.O0000o0O = str6;
                                            imo2.O0000o0o = str6;
                                            imo2.O0000o = "failed";
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                            }
                                            imo2.O0000OoO = System.currentTimeMillis();
                                            imo2.O0000o = "failed";
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo2 != null) {
                                            }
                                            str26 = str2;
                                            str23 = str4;
                                            imo = imo2;
                                            i11 = i13;
                                            uuid = str3;
                                            i10 = 1;
                                            z17 = true;
                                            z18 = true;
                                            boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                            String str30222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                            str25 = str6;
                                            str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222;
                                        } catch (FileNotFoundException e83) {
                                            e = e83;
                                            fileNotFoundException2 = e;
                                            j13 = j7;
                                            str14 = str15;
                                            str6 = str;
                                            if (!z2) {
                                            }
                                            String str31222222222222 = str13;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                            }
                                            imo2.O0000OoO = System.currentTimeMillis();
                                            imo2.O0000o = "failed";
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo2 != null) {
                                            }
                                            str26 = str2;
                                            str23 = str4;
                                            imo = imo2;
                                            i11 = i13;
                                            uuid = str3;
                                            i10 = 1;
                                            z17 = true;
                                            z18 = true;
                                            boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                            String str302222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                            str25 = str6;
                                            str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222;
                                        } catch (IOException e84) {
                                            e = e84;
                                            iOException2 = e;
                                            j13 = j2;
                                            i = i12;
                                            if (!z2) {
                                            }
                                            String str292222222222222 = str;
                                            str4 = str15;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                            }
                                            imo2.O0000OoO = System.currentTimeMillis();
                                            imo2.O0000o = "failed";
                                            if (httpURLConnection != null) {
                                            }
                                            if (imo2 != null) {
                                            }
                                            i12 = i;
                                            str5 = str13;
                                            str26 = str2;
                                            str23 = str4;
                                            imo = imo2;
                                            i11 = i13;
                                            uuid = str3;
                                            i10 = 1;
                                            z17 = true;
                                            z18 = true;
                                            boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                            String str3022222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                            str25 = str6;
                                            str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222;
                                        } catch (Throwable th18) {
                                            th = th18;
                                            th4 = th;
                                            j = j2;
                                            f2 = f5;
                                            z = z18;
                                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                            }
                                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                            }
                                            imo2.O0000OoO = System.currentTimeMillis();
                                            imo2.O0000o = "failed";
                                            if (!z17) {
                                            }
                                            boolean z2022222222222 = z2;
                                            if (httpURLConnection != null) {
                                            }
                                            z2 = z2022222222222;
                                            imq.O000000o(imo2, cdnConfigModel);
                                            throw th;
                                        }
                                    } else {
                                        HttpURLConnection httpURLConnection16 = O000000o2;
                                        boolean z21 = z16;
                                        long j15 = j;
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "DownloadThread fail contentLength0:".concat(String.valueOf(contentLength)));
                                        throw new IOException("DownloadThread fail contentLength(" + contentLength + ") <= 0");
                                    }
                                } catch (MalformedURLException e85) {
                                    httpURLConnection4 = O000000o2;
                                    z4 = z16;
                                    malformedURLException3 = e85;
                                    j13 = j;
                                    str8 = str13;
                                    str7 = str15;
                                    if (!z2) {
                                    }
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                    String str30222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                } catch (SocketTimeoutException e86) {
                                    httpURLConnection5 = O000000o2;
                                    z5 = z16;
                                    socketTimeoutException3 = e86;
                                    j13 = j;
                                    str10 = str13;
                                    str9 = str15;
                                    imo2.O00000oO = str5;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                                    }
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imo2.O00000o = true;
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                    String str302222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                } catch (UnknownHostException e87) {
                                    httpURLConnection6 = O000000o2;
                                    z6 = z16;
                                    unknownHostException3 = e87;
                                    j13 = j;
                                    str12 = str13;
                                    str11 = str15;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    imo2.O0000O0o = "dns_fail";
                                    imo2.O00000oo = imq.O000000o(unknownHostException);
                                    imo2.O00000oO = str5;
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                    String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                } catch (IllegalArgumentException e88) {
                                    httpURLConnection7 = O000000o2;
                                    z7 = z16;
                                    illegalArgumentException3 = e88;
                                    j13 = j;
                                    str5 = str13;
                                    str4 = str15;
                                    if (imo2.O0000Oo <= 0.0f) {
                                    }
                                    imo2.O0000O0o = "dns_fail";
                                    imo2.O00000oo = imq.O000000o(illegalArgumentException);
                                    imo2.O00000oO = str5;
                                    imo2.O0000o0O = str6;
                                    imo2.O0000o0o = str6;
                                    imo2.O0000o = "failed";
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                    String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                } catch (FileNotFoundException e89) {
                                    httpURLConnection8 = O000000o2;
                                    z8 = z16;
                                    fileNotFoundException3 = e89;
                                    j13 = j;
                                    str14 = str15;
                                    if (!z2) {
                                    }
                                    String str312222222222222 = str13;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                    String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                } catch (IOException e90) {
                                    e = e90;
                                    httpURLConnection = O000000o2;
                                    str = str6;
                                    z2 = z16;
                                    j2 = j;
                                    iOException2 = e;
                                    j13 = j2;
                                    i = i12;
                                    if (!z2) {
                                    }
                                    String str2922222222222222 = str;
                                    str4 = str15;
                                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                                    }
                                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                                    }
                                    imo2.O0000OoO = System.currentTimeMillis();
                                    imo2.O0000o = "failed";
                                    if (httpURLConnection != null) {
                                    }
                                    if (imo2 != null) {
                                    }
                                    i12 = i;
                                    str5 = str13;
                                    str26 = str2;
                                    str23 = str4;
                                    imo = imo2;
                                    i11 = i13;
                                    uuid = str3;
                                    i10 = 1;
                                    z17 = true;
                                    z18 = true;
                                    boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                                    String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                                    str25 = str6;
                                    str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                                } catch (Throwable th19) {
                                }
                            } else {
                                str3 = str18;
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "DownloadThread fail responseCode:".concat(String.valueOf(responseCode)));
                                throw new IOException("DownloadThread fail responseCode:".concat(String.valueOf(responseCode)));
                            }
                        } catch (MalformedURLException e91) {
                            httpURLConnection4 = O000000o2;
                            z4 = z16;
                            str3 = uuid;
                            malformedURLException3 = e91;
                            str8 = str13;
                            str7 = str15;
                            if (!z2) {
                            }
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (SocketTimeoutException e92) {
                            httpURLConnection5 = O000000o2;
                            z5 = z16;
                            str3 = uuid;
                            socketTimeoutException3 = e92;
                            str10 = str13;
                            str9 = str15;
                            imo2.O00000oO = str5;
                            if (imo2.O0000Oo <= 0.0f) {
                            }
                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                            }
                            imo2.O0000o0O = str6;
                            imo2.O0000o0o = str6;
                            imo2.O0000o = "failed";
                            imo2.O00000o = true;
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (UnknownHostException e93) {
                            httpURLConnection6 = O000000o2;
                            z6 = z16;
                            str3 = uuid;
                            unknownHostException3 = e93;
                            str12 = str13;
                            str11 = str15;
                            if (imo2.O0000Oo <= 0.0f) {
                            }
                            imo2.O0000O0o = "dns_fail";
                            imo2.O00000oo = imq.O000000o(unknownHostException);
                            imo2.O00000oO = str5;
                            imo2.O0000o0O = str6;
                            imo2.O0000o0o = str6;
                            imo2.O0000o = "failed";
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (IllegalArgumentException e94) {
                            httpURLConnection7 = O000000o2;
                            z7 = z16;
                            str3 = uuid;
                            illegalArgumentException3 = e94;
                            str5 = str13;
                            str4 = str15;
                            if (imo2.O0000Oo <= 0.0f) {
                            }
                            imo2.O0000O0o = "dns_fail";
                            imo2.O00000oo = imq.O000000o(illegalArgumentException);
                            imo2.O00000oO = str5;
                            imo2.O0000o0O = str6;
                            imo2.O0000o0o = str6;
                            imo2.O0000o = "failed";
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (FileNotFoundException e95) {
                            httpURLConnection8 = O000000o2;
                            z8 = z16;
                            str3 = uuid;
                            fileNotFoundException3 = e95;
                            str14 = str15;
                            if (!z2) {
                            }
                            String str3122222222222222 = str13;
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (IOException e96) {
                            e = e96;
                            httpURLConnection = O000000o2;
                            str = str6;
                            z2 = z16;
                            str3 = uuid;
                            iOException2 = e;
                            i = i12;
                            if (!z2) {
                            }
                            String str29222222222222222 = str;
                            str4 = str15;
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            i12 = i;
                            str5 = str13;
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (Throwable th20) {
                            th = th20;
                            httpURLConnection3 = O000000o2;
                            z2 = z16;
                            th4 = th;
                            f2 = f5;
                            j = j13;
                            z = z18;
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (!z17) {
                            }
                            boolean z20222222222222 = z2;
                            if (httpURLConnection != null) {
                            }
                            z2 = z20222222222222;
                            imq.O000000o(imo2, cdnConfigModel);
                            throw th;
                        }
                    } else {
                        httpURLConnection = O000000o2;
                        str = str25;
                        str2 = str26;
                        z2 = z16;
                        str3 = uuid;
                        str15 = str16;
                        try {
                            throw new IOException("DownloadThread fail httpUrlConnection connect fail httpUrlConnection==null");
                        } catch (MalformedURLException e97) {
                            malformedURLException2 = e97;
                            str8 = str13;
                            str7 = str15;
                            str6 = str;
                            if (!z2) {
                            }
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (SocketTimeoutException e98) {
                            socketTimeoutException2 = e98;
                            str10 = str13;
                            str9 = str15;
                            str6 = str;
                            imo2.O00000oO = str5;
                            if (imo2.O0000Oo <= 0.0f) {
                            }
                            if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                            }
                            imo2.O0000o0O = str6;
                            imo2.O0000o0o = str6;
                            imo2.O0000o = "failed";
                            imo2.O00000o = true;
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (UnknownHostException e99) {
                            unknownHostException2 = e99;
                            str12 = str13;
                            str11 = str15;
                            str6 = str;
                            if (imo2.O0000Oo <= 0.0f) {
                            }
                            imo2.O0000O0o = "dns_fail";
                            imo2.O00000oo = imq.O000000o(unknownHostException);
                            imo2.O00000oO = str5;
                            imo2.O0000o0O = str6;
                            imo2.O0000o0o = str6;
                            imo2.O0000o = "failed";
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (IllegalArgumentException e100) {
                            illegalArgumentException2 = e100;
                            str5 = str13;
                            str4 = str15;
                            str6 = str;
                            if (imo2.O0000Oo <= 0.0f) {
                            }
                            imo2.O0000O0o = "dns_fail";
                            imo2.O00000oo = imq.O000000o(illegalArgumentException);
                            imo2.O00000oO = str5;
                            imo2.O0000o0O = str6;
                            imo2.O0000o0o = str6;
                            imo2.O0000o = "failed";
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (FileNotFoundException e101) {
                            fileNotFoundException2 = e101;
                            str14 = str15;
                            str6 = str;
                            if (!z2) {
                            }
                            String str31222222222222222 = str13;
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (IOException e102) {
                            e = e102;
                            iOException2 = e;
                            i = i12;
                            if (!z2) {
                            }
                            String str292222222222222222 = str;
                            str4 = str15;
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (httpURLConnection != null) {
                            }
                            if (imo2 != null) {
                            }
                            i12 = i;
                            str5 = str13;
                            str26 = str2;
                            str23 = str4;
                            imo = imo2;
                            i11 = i13;
                            uuid = str3;
                            i10 = 1;
                            z17 = true;
                            z18 = true;
                            boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                            String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                            str25 = str6;
                            str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                        } catch (Throwable th21) {
                            th = th21;
                            th4 = th;
                            f2 = f5;
                            j = j13;
                            z = z18;
                            if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                            }
                            if (TextUtils.isEmpty(imo2.O0000OOo)) {
                            }
                            imo2.O0000OoO = System.currentTimeMillis();
                            imo2.O0000o = "failed";
                            if (!z17) {
                            }
                            boolean z202222222222222 = z2;
                            if (httpURLConnection != null) {
                            }
                            z2 = z202222222222222;
                            imq.O000000o(imo2, cdnConfigModel);
                            throw th;
                        }
                    }
                } catch (MalformedURLException e103) {
                    httpURLConnection = O000000o2;
                    str2 = str26;
                    z2 = z16;
                    str3 = uuid;
                    malformedURLException = e103;
                    str6 = str25;
                    str7 = str16;
                    str8 = str13;
                    if (!z2) {
                    }
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                    }
                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                    }
                    imo2.O0000OoO = System.currentTimeMillis();
                    imo2.O0000o = "failed";
                    if (httpURLConnection != null) {
                    }
                    if (imo2 != null) {
                    }
                    str26 = str2;
                    str23 = str4;
                    imo = imo2;
                    i11 = i13;
                    uuid = str3;
                    i10 = 1;
                    z17 = true;
                    z18 = true;
                    boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                    String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                    str25 = str6;
                    str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                } catch (SocketTimeoutException e104) {
                    httpURLConnection = O000000o2;
                    str2 = str26;
                    z2 = z16;
                    str3 = uuid;
                    socketTimeoutException = e104;
                    str6 = str25;
                    str9 = str16;
                    str10 = str13;
                    imo2.O00000oO = str5;
                    if (imo2.O0000Oo <= 0.0f) {
                    }
                    if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                    }
                    imo2.O0000o0O = str6;
                    imo2.O0000o0o = str6;
                    imo2.O0000o = "failed";
                    imo2.O00000o = true;
                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                    }
                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                    }
                    imo2.O0000OoO = System.currentTimeMillis();
                    imo2.O0000o = "failed";
                    if (httpURLConnection != null) {
                    }
                    if (imo2 != null) {
                    }
                    str26 = str2;
                    str23 = str4;
                    imo = imo2;
                    i11 = i13;
                    uuid = str3;
                    i10 = 1;
                    z17 = true;
                    z18 = true;
                    boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                    String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                    str25 = str6;
                    str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                } catch (UnknownHostException e105) {
                    httpURLConnection = O000000o2;
                    str2 = str26;
                    z2 = z16;
                    str3 = uuid;
                    unknownHostException = e105;
                    str6 = str25;
                    str11 = str16;
                    str12 = str13;
                    if (imo2.O0000Oo <= 0.0f) {
                    }
                    imo2.O0000O0o = "dns_fail";
                    imo2.O00000oo = imq.O000000o(unknownHostException);
                    imo2.O00000oO = str5;
                    imo2.O0000o0O = str6;
                    imo2.O0000o0o = str6;
                    imo2.O0000o = "failed";
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                    }
                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                    }
                    imo2.O0000OoO = System.currentTimeMillis();
                    imo2.O0000o = "failed";
                    if (httpURLConnection != null) {
                    }
                    if (imo2 != null) {
                    }
                    str26 = str2;
                    str23 = str4;
                    imo = imo2;
                    i11 = i13;
                    uuid = str3;
                    i10 = 1;
                    z17 = true;
                    z18 = true;
                    boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                    String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                    str25 = str6;
                    str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                } catch (IllegalArgumentException e106) {
                    httpURLConnection = O000000o2;
                    str2 = str26;
                    z2 = z16;
                    str3 = uuid;
                    illegalArgumentException = e106;
                    str6 = str25;
                    str4 = str16;
                    str5 = str13;
                    if (imo2.O0000Oo <= 0.0f) {
                    }
                    imo2.O0000O0o = "dns_fail";
                    imo2.O00000oo = imq.O000000o(illegalArgumentException);
                    imo2.O00000oO = str5;
                    imo2.O0000o0O = str6;
                    imo2.O0000o0o = str6;
                    imo2.O0000o = "failed";
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                    }
                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                    }
                    imo2.O0000OoO = System.currentTimeMillis();
                    imo2.O0000o = "failed";
                    if (httpURLConnection != null) {
                    }
                    if (imo2 != null) {
                    }
                    str26 = str2;
                    str23 = str4;
                    imo = imo2;
                    i11 = i13;
                    uuid = str3;
                    i10 = 1;
                    z17 = true;
                    z18 = true;
                    boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                    String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                    str25 = str6;
                    str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                } catch (FileNotFoundException e107) {
                    httpURLConnection = O000000o2;
                    str2 = str26;
                    z2 = z16;
                    str3 = uuid;
                    fileNotFoundException = e107;
                    str6 = str25;
                    str14 = str16;
                    if (!z2) {
                    }
                    String str312222222222222222 = str13;
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                    }
                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                    }
                    imo2.O0000OoO = System.currentTimeMillis();
                    imo2.O0000o = "failed";
                    if (httpURLConnection != null) {
                    }
                    if (imo2 != null) {
                    }
                    str26 = str2;
                    str23 = str4;
                    imo = imo2;
                    i11 = i13;
                    uuid = str3;
                    i10 = 1;
                    z17 = true;
                    z18 = true;
                    boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                    String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                    str25 = str6;
                    str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                } catch (IOException e108) {
                    e = e108;
                    httpURLConnection = O000000o2;
                    str = str25;
                    str2 = str26;
                    z2 = z16;
                    str3 = uuid;
                    str15 = str16;
                    iOException2 = e;
                    i = i12;
                    if (!z2) {
                    }
                    String str2922222222222222222 = str;
                    str4 = str15;
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + iOException.toString()));
                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                    }
                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                    }
                    imo2.O0000OoO = System.currentTimeMillis();
                    imo2.O0000o = "failed";
                    if (httpURLConnection != null) {
                    }
                    if (imo2 != null) {
                    }
                    i12 = i;
                    str5 = str13;
                    str26 = str2;
                    str23 = str4;
                    imo = imo2;
                    i11 = i13;
                    uuid = str3;
                    i10 = 1;
                    z17 = true;
                    z18 = true;
                    boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                    String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                    str25 = str6;
                    str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
                } catch (Throwable th22) {
                    th = th22;
                    httpURLConnection3 = O000000o2;
                    str2 = str26;
                    z2 = z16;
                    th4 = th;
                    f2 = f5;
                    j = j13;
                    z = z18;
                    if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                    }
                    if (TextUtils.isEmpty(imo2.O0000OOo)) {
                    }
                    imo2.O0000OoO = System.currentTimeMillis();
                    imo2.O0000o = "failed";
                    if (!z17) {
                    }
                    boolean z2022222222222222 = z2;
                    if (httpURLConnection != null) {
                    }
                    z2 = z2022222222222222;
                    imq.O000000o(imo2, cdnConfigModel);
                    throw th;
                }
            } catch (MalformedURLException e109) {
                String str32 = str26;
                boolean z22 = z16;
                String str33 = uuid;
                String str34 = str23;
                String str35 = str25;
                String str36 = str24;
                String str37 = str35;
                MalformedURLException malformedURLException4 = e109;
                httpURLConnection = null;
                if (!z2) {
                }
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) ("DownloadThread MalformedURLException:" + malformedURLException.toString()));
                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                }
                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                }
                imo2.O0000OoO = System.currentTimeMillis();
                imo2.O0000o = "failed";
                if (httpURLConnection != null) {
                }
                if (imo2 != null) {
                }
                str26 = str2;
                str23 = str4;
                imo = imo2;
                i11 = i13;
                uuid = str3;
                i10 = 1;
                z17 = true;
                z18 = true;
                boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                str25 = str6;
                str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
            } catch (SocketTimeoutException e110) {
                String str38 = str26;
                boolean z23 = z16;
                String str39 = uuid;
                String str40 = str23;
                String str41 = str25;
                String str42 = str24;
                String str43 = str41;
                SocketTimeoutException socketTimeoutException4 = e110;
                httpURLConnection = null;
                imo2.O00000oO = str5;
                if (imo2.O0000Oo <= 0.0f) {
                }
                if (!TextUtils.isEmpty(socketTimeoutException.getMessage())) {
                }
                imo2.O0000o0O = str6;
                imo2.O0000o0o = str6;
                imo2.O0000o = "failed";
                imo2.O00000o = true;
                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                }
                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                }
                imo2.O0000OoO = System.currentTimeMillis();
                imo2.O0000o = "failed";
                if (httpURLConnection != null) {
                }
                if (imo2 != null) {
                }
                str26 = str2;
                str23 = str4;
                imo = imo2;
                i11 = i13;
                uuid = str3;
                i10 = 1;
                z17 = true;
                z18 = true;
                boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                str25 = str6;
                str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
            } catch (UnknownHostException e111) {
                String str44 = str26;
                boolean z24 = z16;
                String str45 = uuid;
                String str46 = str23;
                String str47 = str25;
                String str48 = str24;
                String str49 = str47;
                UnknownHostException unknownHostException4 = e111;
                httpURLConnection = null;
                if (imo2.O0000Oo <= 0.0f) {
                }
                imo2.O0000O0o = "dns_fail";
                imo2.O00000oo = imq.O000000o(unknownHostException);
                imo2.O00000oO = str5;
                imo2.O0000o0O = str6;
                imo2.O0000o0o = str6;
                imo2.O0000o = "failed";
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + unknownHostException.toString()));
                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                }
                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                }
                imo2.O0000OoO = System.currentTimeMillis();
                imo2.O0000o = "failed";
                if (httpURLConnection != null) {
                }
                if (imo2 != null) {
                }
                str26 = str2;
                str23 = str4;
                imo = imo2;
                i11 = i13;
                uuid = str3;
                i10 = 1;
                z17 = true;
                z18 = true;
                boolean z1922222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                String str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                str25 = str6;
                str24 = str3022222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
            } catch (IllegalArgumentException e112) {
                String str50 = str26;
                boolean z25 = z16;
                String str51 = uuid;
                String str52 = str23;
                String str53 = str25;
                String str54 = str24;
                String str55 = str53;
                IllegalArgumentException illegalArgumentException4 = e112;
                httpURLConnection = null;
                if (imo2.O0000Oo <= 0.0f) {
                }
                imo2.O0000O0o = "dns_fail";
                imo2.O00000oo = imq.O000000o(illegalArgumentException);
                imo2.O00000oO = str5;
                imo2.O0000o0O = str6;
                imo2.O0000o0o = str6;
                imo2.O0000o = "failed";
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + illegalArgumentException.toString()));
                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                }
                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                }
                imo2.O0000OoO = System.currentTimeMillis();
                imo2.O0000o = "failed";
                if (httpURLConnection != null) {
                }
                if (imo2 != null) {
                }
                str26 = str2;
                str23 = str4;
                imo = imo2;
                i11 = i13;
                uuid = str3;
                i10 = 1;
                z17 = true;
                z18 = true;
                boolean z19222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                String str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                str25 = str6;
                str24 = str30222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
            } catch (FileNotFoundException e113) {
                str13 = str24;
                str6 = str25;
                str2 = str26;
                boolean z26 = z16;
                str3 = uuid;
                String str56 = str23;
                FileNotFoundException fileNotFoundException4 = e113;
                httpURLConnection = null;
                if (!z2) {
                }
                String str3122222222222222222 = str13;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) (str4 + fileNotFoundException.toString()));
                if (TextUtils.isEmpty(imo2.O0000Oo0)) {
                }
                if (TextUtils.isEmpty(imo2.O0000OOo)) {
                }
                imo2.O0000OoO = System.currentTimeMillis();
                imo2.O0000o = "failed";
                if (httpURLConnection != null) {
                }
                if (imo2 != null) {
                }
                str26 = str2;
                str23 = str4;
                imo = imo2;
                i11 = i13;
                uuid = str3;
                i10 = 1;
                z17 = true;
                z18 = true;
                boolean z192222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = z2;
                String str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222 = str5;
                str25 = str6;
                str24 = str302222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
            } catch (IOException e114) {
            } catch (Throwable th23) {
            }
        }
    }
}

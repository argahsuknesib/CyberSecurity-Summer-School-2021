package com.xiaomi.smarthome.download;

import _m_j.fri;
import _m_j.frm;
import _m_j.gpg;
import _m_j.gsy;
import android.content.ContentValues;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.download.Helpers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SyncFailedException;
import java.util.Collections;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class DownloadThread extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f7313O000000o;
    private final fri O00000Oo;
    private frm O00000o0;

    public DownloadThread(Context context, frm frm, fri fri) {
        this.f7313O000000o = context;
        this.O00000o0 = frm;
        this.O00000Oo = fri;
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f7315O000000o;
        public FileOutputStream O00000Oo;
        public boolean O00000o = false;
        public String O00000o0;
        public int O00000oO = 0;
        public int O00000oo = 0;
        public String O0000O0o;
        public boolean O0000OOo = false;
        public String O0000Oo0;

        public O00000Oo(fri fri) {
            this.O00000o0 = DownloadThread.O000000o(fri.O00000oo);
            this.O0000Oo0 = fri.O00000Oo;
            this.f7315O000000o = fri.O00000oO;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f7314O000000o;
        public String O00000Oo;
        public String O00000o;
        public boolean O00000o0;
        public String O00000oO;
        public String O00000oo;
        public int O0000O0o;
        public long O0000OOo;

        private O000000o() {
            this.f7314O000000o = 0;
            this.O00000o0 = false;
            this.O0000O0o = 0;
            this.O0000OOo = 0;
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    class StopRequest extends Throwable {
        private static final long serialVersionUID = 1;
        public int mFinalStatus;

        public StopRequest(int i, String str) {
            super(str);
            this.mFinalStatus = i;
        }

        public StopRequest(int i, String str, Throwable th) {
            super(str, th);
            this.mFinalStatus = i;
        }
    }

    class RetryDownload extends Throwable {
        private static final long serialVersionUID = 1;

        private RetryDownload() {
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:392:0x0614 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:385:0x05e7 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:404:0x0032 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.os.PowerManager$WakeLock] */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.os.PowerManager$WakeLock] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v87 */
    /* JADX WARN: Type inference failed for: r10v88 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0252, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02e6, code lost:
        if (r10.equalsIgnoreCase("chunked") == false) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0390, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0391, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x03ac, code lost:
        throw new com.xiaomi.smarthome.download.DownloadThread.StopRequest(r9, 492, "while opening destination file: " + r1.toString(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x03b7, code lost:
        r35 = r3;
        r34 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x03bd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03be, code lost:
        r35 = r3;
        r34 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0402, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0404, code lost:
        r23 = r1;
        r19 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0408, code lost:
        r35 = r3;
        r34 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0417, code lost:
        r23 = r1;
        r19 = r2;
        r35 = r3;
        r34 = r4;
        r16 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0421, code lost:
        r22 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x043a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x043b, code lost:
        r22 = r12;
        r1 = r0;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0441, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0442, code lost:
        r22 = r12;
        r1 = r0;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0467, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0468, code lost:
        r1 = r0;
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x046d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x046e, code lost:
        r1 = r0;
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x04c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x04c2, code lost:
        r3 = r34;
        r2 = r35;
        r1 = r0;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x04cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x04cd, code lost:
        r3 = r34;
        r2 = r35;
        r1 = r0;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x04df, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x04e0, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x04e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x04e3, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x04e8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x04e9, code lost:
        r3 = r34;
        r2 = r35;
        r1 = r0;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0512, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0513, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:?, code lost:
        android.util.Log.w("DownloadManager", r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0519, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x051a, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0525, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x0526, code lost:
        r7 = r19;
        r3 = r34;
        r2 = r35;
        r1 = r0;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0550, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0551, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x0553, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x0554, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0556, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x0557, code lost:
        r7 = r19;
        r8 = r23;
        r3 = r34;
        r2 = r35;
        r1 = r0;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x0581, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0582, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x0584, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x0585, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x05c1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x05c8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x05c9, code lost:
        r22 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x0605, code lost:
        r10.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0638, code lost:
        r10.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x0646, code lost:
        r22.release();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x01ab */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f9 A[SYNTHETIC, Splitter:B:112:0x01f9] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x031c A[SYNTHETIC, Splitter:B:189:0x031c] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x035d A[Catch:{ RetryDownload -> 0x0423, all -> 0x0402 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0368 A[Catch:{ RetryDownload -> 0x0423, all -> 0x0402 }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0402 A[Catch:{ StopRequest -> 0x046d, Throwable -> 0x0467, all -> 0x05c1 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:180:0x030e] */
    /* JADX WARNING: Removed duplicated region for block: B:236:? A[ExcHandler: RetryDownload (unused com.xiaomi.smarthome.download.DownloadThread$RetryDownload), SYNTHETIC, Splitter:B:125:0x0211] */
    /* JADX WARNING: Removed duplicated region for block: B:238:? A[ExcHandler: RetryDownload (unused com.xiaomi.smarthome.download.DownloadThread$RetryDownload), PHI: r19 r23 10  PHI: (r19v15 java.lang.String) = (r19v16 java.lang.String), (r19v16 java.lang.String), (r19v16 java.lang.String), (r19v16 java.lang.String), (r19v17 java.lang.String), (r19v20 java.lang.String), (r19v20 java.lang.String) binds: [B:170:0x02eb, B:171:?, B:174:0x02f4, B:165:0x02e2, B:159:0x0266, B:151:0x024b, B:152:?] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r23v10 java.lang.String) = (r23v11 java.lang.String), (r23v11 java.lang.String), (r23v11 java.lang.String), (r23v11 java.lang.String), (r23v12 java.lang.String), (r23v14 java.lang.String), (r23v14 java.lang.String) binds: [B:170:0x02eb, B:171:?, B:174:0x02f4, B:165:0x02e2, B:159:0x0266, B:151:0x024b, B:152:?] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:151:0x024b] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x04c1 A[ExcHandler: all (r0v31 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:258:0x0453] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x04cc A[ExcHandler: RuntimeException (r0v30 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:258:0x0453] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x04da A[SYNTHETIC, Splitter:B:302:0x04da] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x04e8 A[ExcHandler: IOException (r0v25 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:258:0x0453] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x050d A[SYNTHETIC, Splitter:B:318:0x050d] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x054c A[SYNTHETIC, Splitter:B:334:0x054c] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x057d A[SYNTHETIC, Splitter:B:345:0x057d] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0589  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x05b1 A[SYNTHETIC, Splitter:B:359:0x05b1] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x05c1 A[ExcHandler: all (th java.lang.Throwable), PHI: r22 10  PHI: (r22v13 android.os.PowerManager$WakeLock) = (r22v12 android.os.PowerManager$WakeLock), (r22v12 android.os.PowerManager$WakeLock), (r22v12 android.os.PowerManager$WakeLock), (r22v12 android.os.PowerManager$WakeLock), (r22v12 android.os.PowerManager$WakeLock), (r22v12 android.os.PowerManager$WakeLock), (r22v18 android.os.PowerManager$WakeLock), (r22v23 android.os.PowerManager$WakeLock), (r22v27 android.os.PowerManager$WakeLock) binds: [B:359:0x05b1, B:363:0x05b7, B:322:0x0514, B:318:0x050d, B:272:0x0477, B:264:0x0462, B:61:0x013a, B:231:0x03ed, B:180:0x030e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:231:0x03ed] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x05c8 A[ExcHandler: all (th java.lang.Throwable), PHI: r12 10  PHI: (r12v4 android.os.PowerManager$WakeLock) = (r12v3 android.os.PowerManager$WakeLock), (r12v3 android.os.PowerManager$WakeLock), (r12v5 android.os.PowerManager$WakeLock), (r12v5 android.os.PowerManager$WakeLock), (r12v5 android.os.PowerManager$WakeLock), (r12v5 android.os.PowerManager$WakeLock), (r12v5 android.os.PowerManager$WakeLock), (r12v5 android.os.PowerManager$WakeLock) binds: [B:3:0x0029, B:4:?, B:7:0x0034, B:8:?, B:17:0x0074, B:51:0x011e, B:52:?, B:58:0x012b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0605  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0638  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0646  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0122 A[SYNTHETIC, Splitter:B:54:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014d A[SYNTHETIC, Splitter:B:65:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01c8 A[SYNTHETIC, Splitter:B:94:0x01c8] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:322:0x0514=Splitter:B:322:0x0514, B:272:0x0477=Splitter:B:272:0x0477} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:342:0x0561=Splitter:B:342:0x0561, B:331:0x052e=Splitter:B:331:0x052e} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:392:0x0614=Splitter:B:392:0x0614, B:385:0x05e7=Splitter:B:385:0x05e7} */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void run() {
        PowerManager.WakeLock wakeLock;
        Throwable th;
        String str;
        StopRequest stopRequest;
        int i;
        Throwable th2;
        String str2;
        FileOutputStream fileOutputStream;
        String str3;
        String str4;
        Throwable th3;
        FileNotFoundException fileNotFoundException;
        IOException iOException;
        String str5;
        String str6;
        SyncFailedException syncFailedException;
        String str7;
        String str8;
        IOException iOException2;
        boolean z;
        Call newCall;
        String str9;
        String str10;
        String str11;
        Throwable th4;
        int code;
        boolean z2;
        Helpers.GenerateSaveFileError generateSaveFileError;
        Context context;
        String str12;
        String str13;
        String str14;
        String str15;
        int i2;
        String str16 = "file ";
        String str17 = ": ";
        String str18 = "exception while closing file: ";
        String str19 = "IOException while closing synced file: ";
        Process.setThreadPriority(10);
        O00000Oo o00000Oo = new O00000Oo(this.O00000Oo);
        ? r10 = 0;
        byte b = 0;
        try {
            PowerManager.WakeLock newWakeLock = ((PowerManager) this.f7313O000000o.getSystemService("power")).newWakeLock(1, "DownloadManager");
            try {
                newWakeLock.acquire();
                OkHttpClient okHttpClient = new OkHttpClient();
                boolean z3 = false;
                while (!z3) {
                    StringBuilder sb = new StringBuilder("Initiating request for download ");
                    OkHttpClient okHttpClient2 = okHttpClient;
                    sb.append(this.O00000Oo.f16968O000000o);
                    gsy.O000000o(4, "DownloadManager", sb.toString());
                    Request.Builder url = new Request.Builder().url(o00000Oo.O0000Oo0);
                    String str20 = this.O00000Oo.O0000oO0;
                    if (str20 == null) {
                        str20 = "AndroidDownloadManager";
                    }
                    Request.Builder header = url.header("User-Agent", str20);
                    O000000o o000000o = new O000000o(b);
                    long j = 0;
                    if (!TextUtils.isEmpty(o00000Oo.f7315O000000o)) {
                        try {
                            if (Helpers.O00000Oo(o00000Oo.f7315O000000o)) {
                                File file = new File(o00000Oo.f7315O000000o);
                                if (file.exists()) {
                                    boolean z4 = z3;
                                    long length = file.length();
                                    if (length == 0) {
                                        file.delete();
                                        o00000Oo.f7315O000000o = r10;
                                        z = z4;
                                    } else {
                                        if (this.O00000Oo.O0000oo0 == null) {
                                            if (!this.O00000Oo.O00000o0) {
                                                file.delete();
                                                throw new StopRequest(489, "Trying to resume a download that can't be resumed");
                                            }
                                        }
                                        z = z4;
                                        o00000Oo.O00000Oo = new FileOutputStream(o00000Oo.f7315O000000o, true);
                                        o000000o.f7314O000000o = (int) length;
                                        if (this.O00000Oo.O0000oOO != -1) {
                                            o000000o.O00000o = Long.toString(this.O00000Oo.O0000oOO);
                                        }
                                        o000000o.O00000Oo = this.O00000Oo.O0000oo0;
                                        o000000o.O00000o0 = true;
                                    }
                                    if (o00000Oo.O00000Oo != null) {
                                        if (this.O00000Oo.O0000O0o == 0) {
                                            O000000o(o00000Oo);
                                        }
                                    }
                                    O000000o(o000000o, header);
                                    OkHttpClient okHttpClient3 = okHttpClient2;
                                    newCall = okHttpClient3.newCall(header.build());
                                    byte[] bArr = new byte[4096];
                                    O000000o();
                                    Response O000000o2 = O000000o(o00000Oo, newCall);
                                    code = O000000o2.code();
                                    OkHttpClient okHttpClient4 = okHttpClient3;
                                    if (code == 503) {
                                        try {
                                            if (this.O00000Oo.O0000OoO < 5) {
                                                gsy.O000000o(2, "DownloadManager", "got HTTP response code 503");
                                                o00000Oo.O00000o = true;
                                                String header2 = O000000o2.header("Retry-After");
                                                if (header2 != null) {
                                                    gsy.O000000o(2, "DownloadManager", "Retry-After :".concat(String.valueOf(header2)));
                                                    o00000Oo.O00000oO = Integer.parseInt(header2);
                                                    if (o00000Oo.O00000oO >= 0) {
                                                        if (o00000Oo.O00000oO < 30) {
                                                            o00000Oo.O00000oO = 30;
                                                        } else if (o00000Oo.O00000oO > 86400) {
                                                            o00000Oo.O00000oO = 86400;
                                                        }
                                                        o00000Oo.O00000oO += Helpers.f7316O000000o.nextInt(31);
                                                        o00000Oo.O00000oO *= 1000;
                                                    } else {
                                                        o00000Oo.O00000oO = 0;
                                                    }
                                                }
                                                throw new StopRequest(194, "got 503 Service Unavailable, will retry later");
                                            }
                                        } catch (RetryDownload unused) {
                                        } catch (Throwable th5) {
                                            th4 = th5;
                                            newCall.cancel();
                                            throw th4;
                                        }
                                    }
                                    if (code == (!o000000o.O00000o0 ? 206 : 200)) {
                                        if (!Downloads.isStatusError(code)) {
                                            if (code >= 300) {
                                                if (code < 400) {
                                                    i2 = 493;
                                                }
                                            }
                                            i2 = (!o000000o.O00000o0 || code != 200) ? 494 : 489;
                                        } else {
                                            i2 = code;
                                        }
                                        throw new StopRequest(i2, "http error ".concat(String.valueOf(code)));
                                    }
                                    if (!o000000o.O00000o0) {
                                        String header3 = O000000o2.header("Content-Disposition");
                                        if (header3 != null) {
                                            o000000o.O00000oO = header3;
                                        }
                                        String header4 = O000000o2.header("Content-Location");
                                        if (header4 != null) {
                                            o000000o.O00000oo = header4;
                                        }
                                        try {
                                            if (o00000Oo.O00000o0 == null) {
                                                String header5 = O000000o2.header("Content-Type");
                                                if (header5 != null) {
                                                    o00000Oo.O00000o0 = O000000o(header5);
                                                }
                                            }
                                            String header6 = O000000o2.header("ETag");
                                            if (header6 != null) {
                                                o000000o.O00000Oo = header6;
                                            }
                                            String header7 = O000000o2.header("Transfer-Encoding");
                                            if (header7 == null) {
                                                header7 = null;
                                            }
                                            if (header7 == null) {
                                                String header8 = O000000o2.header("Content-Length");
                                                if (header8 != null) {
                                                    o000000o.O00000o = header8;
                                                    str11 = str16;
                                                    str2 = str17;
                                                    try {
                                                        this.O00000Oo.O0000oOO = Long.parseLong(o000000o.O00000o);
                                                    } catch (RetryDownload unused2) {
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        PowerManager.WakeLock wakeLock2 = newWakeLock;
                                                        th4 = th;
                                                        newCall.cancel();
                                                        throw th4;
                                                    }
                                                } else {
                                                    str11 = str16;
                                                    str2 = str17;
                                                }
                                            } else {
                                                str11 = str16;
                                                str2 = str17;
                                                gsy.O000000o(2, "DownloadManager", "ignoring content-length because of xfer-encoding");
                                            }
                                            gsy.O000000o(2, "DownloadManager", "Content-Disposition: " + o000000o.O00000oO);
                                            gsy.O000000o(2, "DownloadManager", "Content-Length: " + o000000o.O00000o);
                                            gsy.O000000o(2, "DownloadManager", "Content-Location: " + o000000o.O00000oo);
                                            gsy.O000000o(2, "DownloadManager", "Content-Type: " + o00000Oo.O00000o0);
                                            gsy.O000000o(2, "DownloadManager", "ETag: " + o000000o.O00000Oo);
                                            gsy.O000000o(2, "DownloadManager", "Transfer-Encoding: ".concat(String.valueOf(header7)));
                                            if (o000000o.O00000o == null) {
                                                if (header7 != null) {
                                                }
                                                z2 = true;
                                                if (!this.O00000Oo.O00000o0 || !z2) {
                                                    context = this.f7313O000000o;
                                                    str12 = this.O00000Oo.O00000Oo;
                                                    str13 = this.O00000Oo.O00000o;
                                                    str14 = o000000o.O00000oO;
                                                    str15 = o000000o.O00000oo;
                                                    wakeLock = newWakeLock;
                                                    String str21 = o00000Oo.O00000o0;
                                                    str10 = str19;
                                                    int i3 = this.O00000Oo.O0000O0o;
                                                    str9 = str18;
                                                    try {
                                                        if (o000000o.O00000o != null) {
                                                            try {
                                                                j = Long.parseLong(o000000o.O00000o);
                                                            } catch (Helpers.GenerateSaveFileError e) {
                                                                generateSaveFileError = e;
                                                                throw new StopRequest(generateSaveFileError.mStatus, generateSaveFileError.mMessage);
                                                            }
                                                        }
                                                        o00000Oo.f7315O000000o = Helpers.O000000o(context, str12, str13, str14, str15, str21, i3, j, this.O00000Oo.O0000ooO);
                                                        o00000Oo.O00000Oo = new FileOutputStream(o00000Oo.f7315O000000o);
                                                        ContentValues contentValues = new ContentValues();
                                                        contentValues.put("_data", o00000Oo.f7315O000000o);
                                                        if (o000000o.O00000Oo != null) {
                                                            contentValues.put("etag", o000000o.O00000Oo);
                                                        }
                                                        if (o00000Oo.O00000o0 != null) {
                                                            contentValues.put("mimetype", o00000Oo.O00000o0);
                                                        }
                                                        contentValues.put("total_bytes", Long.valueOf(this.O00000Oo.O0000oOO));
                                                        str19 = null;
                                                        this.f7313O000000o.getContentResolver().update(this.O00000Oo.O00000o0(), contentValues, null, null);
                                                        O000000o();
                                                    } catch (Helpers.GenerateSaveFileError e2) {
                                                        e = e2;
                                                        generateSaveFileError = e;
                                                        throw new StopRequest(generateSaveFileError.mStatus, generateSaveFileError.mMessage);
                                                    }
                                                } else {
                                                    throw new StopRequest(495, "can't know size of download, giving up");
                                                }
                                            }
                                            z2 = false;
                                            if (!this.O00000Oo.O00000o0) {
                                            }
                                            try {
                                                context = this.f7313O000000o;
                                                str12 = this.O00000Oo.O00000Oo;
                                                str13 = this.O00000Oo.O00000o;
                                                str14 = o000000o.O00000oO;
                                                str15 = o000000o.O00000oo;
                                                wakeLock = newWakeLock;
                                            } catch (Helpers.GenerateSaveFileError e3) {
                                                e = e3;
                                                String str22 = str18;
                                                String str23 = str19;
                                                PowerManager.WakeLock wakeLock3 = newWakeLock;
                                                generateSaveFileError = e;
                                                throw new StopRequest(generateSaveFileError.mStatus, generateSaveFileError.mMessage);
                                            }
                                        } catch (RetryDownload unused3) {
                                        } catch (Throwable th7) {
                                            th = th7;
                                            th4 = th;
                                            newCall.cancel();
                                            throw th4;
                                        }
                                        try {
                                            String str212 = o00000Oo.O00000o0;
                                            str10 = str19;
                                            int i32 = this.O00000Oo.O0000O0o;
                                            str9 = str18;
                                            if (o000000o.O00000o != null) {
                                            }
                                            o00000Oo.f7315O000000o = Helpers.O000000o(context, str12, str13, str14, str15, str212, i32, j, this.O00000Oo.O0000ooO);
                                            o00000Oo.O00000Oo = new FileOutputStream(o00000Oo.f7315O000000o);
                                            ContentValues contentValues2 = new ContentValues();
                                            contentValues2.put("_data", o00000Oo.f7315O000000o);
                                            if (o000000o.O00000Oo != null) {
                                            }
                                            if (o00000Oo.O00000o0 != null) {
                                            }
                                            contentValues2.put("total_bytes", Long.valueOf(this.O00000Oo.O0000oOO));
                                            str19 = null;
                                            this.f7313O000000o.getContentResolver().update(this.O00000Oo.O00000o0(), contentValues2, null, null);
                                            O000000o();
                                        } catch (Helpers.GenerateSaveFileError e4) {
                                            e = e4;
                                            String str24 = str18;
                                            generateSaveFileError = e;
                                            throw new StopRequest(generateSaveFileError.mStatus, generateSaveFileError.mMessage);
                                        } catch (RetryDownload unused4) {
                                            str9 = str18;
                                            str19 = null;
                                            newCall.cancel();
                                            r10 = str19;
                                            okHttpClient = okHttpClient4;
                                            str17 = str2;
                                            z3 = z;
                                            newWakeLock = wakeLock;
                                            str16 = str11;
                                            str19 = str10;
                                            str18 = str9;
                                            b = 0;
                                        } catch (Throwable th8) {
                                        }
                                    } else {
                                        str11 = str16;
                                        str2 = str17;
                                        str9 = str18;
                                        str10 = str19;
                                        wakeLock = newWakeLock;
                                        str19 = null;
                                    }
                                    O000000o(o00000Oo, o000000o, bArr, O000000o(o00000Oo, O000000o2));
                                    gpg.O000000o(O000000o2);
                                    try {
                                        newCall.cancel();
                                        r10 = str19;
                                        okHttpClient = okHttpClient4;
                                        str17 = str2;
                                        newWakeLock = wakeLock;
                                        str16 = str11;
                                        str19 = str10;
                                        str18 = str9;
                                        b = 0;
                                        z3 = true;
                                    } catch (StopRequest e5) {
                                        e = e5;
                                        stopRequest = e;
                                        r10 = wakeLock;
                                        gsy.O000000o(5, "DownloadManager", "Aborting request for download " + this.O00000Oo.f16968O000000o + str + stopRequest.getMessage());
                                        i = stopRequest.mFinalStatus;
                                        if (r10 != 0) {
                                        }
                                        O000000o(o00000Oo, i);
                                        O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                                        this.O00000Oo.O00oOoOo = false;
                                    } catch (Throwable th9) {
                                    }
                                }
                            } else {
                                throw new StopRequest(492, "found invalid internal destination filename");
                            }
                        } catch (FileNotFoundException e6) {
                            FileNotFoundException fileNotFoundException2 = e6;
                            throw new StopRequest(492, "while opening destination for resuming: " + fileNotFoundException2.toString(), fileNotFoundException2);
                        } catch (StopRequest e7) {
                            stopRequest = e7;
                            str = str17;
                            r10 = newWakeLock;
                            gsy.O000000o(5, "DownloadManager", "Aborting request for download " + this.O00000Oo.f16968O000000o + str + stopRequest.getMessage());
                            i = stopRequest.mFinalStatus;
                            if (r10 != 0) {
                            }
                            O000000o(o00000Oo, i);
                            O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                            this.O00000Oo.O00oOoOo = false;
                        } catch (Throwable th10) {
                            th = th10;
                            wakeLock = newWakeLock;
                            if (wakeLock != null) {
                            }
                            O000000o(o00000Oo, 491);
                            O000000o(491, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                            this.O00000Oo.O00oOoOo = false;
                            throw th;
                        }
                    }
                    z = z3;
                    if (o00000Oo.O00000Oo != null) {
                    }
                    O000000o(o000000o, header);
                    OkHttpClient okHttpClient32 = okHttpClient2;
                    newCall = okHttpClient32.newCall(header.build());
                    try {
                        byte[] bArr2 = new byte[4096];
                        O000000o();
                        Response O000000o22 = O000000o(o00000Oo, newCall);
                        code = O000000o22.code();
                        OkHttpClient okHttpClient42 = okHttpClient32;
                        if (code == 503) {
                        }
                        if (code == (!o000000o.O00000o0 ? 206 : 200)) {
                        }
                    } catch (RetryDownload unused32) {
                    } catch (Throwable th11) {
                        th = th11;
                        String str25 = str17;
                        PowerManager.WakeLock wakeLock22 = newWakeLock;
                        th4 = th;
                        newCall.cancel();
                        throw th4;
                    }
                }
                String str26 = str16;
                str2 = str17;
                String str27 = str18;
                String str28 = str19;
                FileOutputStream fileOutputStream2 = r10;
                wakeLock = newWakeLock;
                try {
                    fileOutputStream = new FileOutputStream(o00000Oo.f7315O000000o, true);
                    try {
                        fileOutputStream.getFD().sync();
                    } catch (FileNotFoundException e8) {
                        str5 = str28;
                        str6 = str27;
                        fileNotFoundException = e8;
                        String str29 = str2;
                        String str30 = str26;
                        gsy.O000000o(5, "DownloadManager", str30 + o00000Oo.f7315O000000o + " not found: " + fileNotFoundException);
                        if (fileOutputStream != null) {
                        }
                        if (wakeLock != null) {
                        }
                        O000000o(o00000Oo, 200);
                        i = 200;
                        O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                        this.O00000Oo.O00oOoOo = false;
                    } catch (SyncFailedException e9) {
                        str3 = str28;
                        str4 = str27;
                        syncFailedException = e9;
                        str = str2;
                        gsy.O000000o(5, "DownloadManager", str26 + o00000Oo.f7315O000000o + " sync failed: " + syncFailedException);
                        if (fileOutputStream != null) {
                        }
                        if (wakeLock != null) {
                        }
                        O000000o(o00000Oo, 200);
                        i = 200;
                        O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                        this.O00000Oo.O00oOoOo = false;
                    } catch (IOException e10) {
                        String str31 = str28;
                        String str32 = str27;
                        IOException iOException3 = e10;
                        try {
                            StringBuilder sb2 = new StringBuilder("IOException trying to sync ");
                            sb2.append(o00000Oo.f7315O000000o);
                            str = str2;
                            try {
                                sb2.append(str);
                                sb2.append(iOException3);
                                gsy.O000000o(5, "DownloadManager", sb2.toString());
                                if (fileOutputStream != null) {
                                }
                                if (wakeLock != null) {
                                }
                                O000000o(o00000Oo, 200);
                                i = 200;
                                O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                                this.O00000Oo.O00oOoOo = false;
                            } catch (Throwable th12) {
                                th = th12;
                                th3 = th;
                                if (fileOutputStream != null) {
                                }
                                throw th3;
                            }
                        } catch (Throwable th13) {
                            th = th13;
                            str = str2;
                            th3 = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e11) {
                                    Log.w("DownloadManager", str3, e11);
                                } catch (RuntimeException e12) {
                                    Log.w("DownloadManager", str4, e12);
                                }
                            }
                            throw th3;
                        }
                    } catch (RuntimeException e13) {
                        str7 = str28;
                        str8 = str27;
                        RuntimeException runtimeException = e13;
                        try {
                            Log.w("DownloadManager", "exception while syncing file: ", runtimeException);
                            if (fileOutputStream != null) {
                            }
                            if (wakeLock != null) {
                            }
                            O000000o(o00000Oo, 200);
                            i = 200;
                            O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                            this.O00000Oo.O00oOoOo = false;
                        } catch (Throwable th14) {
                            th = th14;
                            th3 = th;
                            str = str2;
                            if (fileOutputStream != null) {
                            }
                            throw th3;
                        }
                    } catch (Throwable th15) {
                        th = th15;
                        str7 = str28;
                        str8 = str27;
                        th3 = th;
                        str = str2;
                        if (fileOutputStream != null) {
                        }
                        throw th3;
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e14) {
                        iOException2 = e14;
                        str7 = str28;
                    } catch (RuntimeException e15) {
                        RuntimeException runtimeException2 = e15;
                        str8 = str27;
                        Log.w("DownloadManager", str8, runtimeException2);
                        if (wakeLock != null) {
                        }
                        O000000o(o00000Oo, 200);
                        i = 200;
                        O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                        this.O00000Oo.O00oOoOo = false;
                    }
                } catch (FileNotFoundException e16) {
                    str5 = str28;
                    str6 = str27;
                    fileNotFoundException = e16;
                    fileOutputStream = fileOutputStream2;
                    String str292 = str2;
                    String str302 = str26;
                    gsy.O000000o(5, "DownloadManager", str302 + o00000Oo.f7315O000000o + " not found: " + fileNotFoundException);
                    if (fileOutputStream != null) {
                    }
                    if (wakeLock != null) {
                    }
                    O000000o(o00000Oo, 200);
                    i = 200;
                    O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                    this.O00000Oo.O00oOoOo = false;
                } catch (SyncFailedException e17) {
                    str3 = str28;
                    str4 = str27;
                    syncFailedException = e17;
                    fileOutputStream = fileOutputStream2;
                    str = str2;
                    gsy.O000000o(5, "DownloadManager", str26 + o00000Oo.f7315O000000o + " sync failed: " + syncFailedException);
                    if (fileOutputStream != null) {
                    }
                    if (wakeLock != null) {
                    }
                    O000000o(o00000Oo, 200);
                    i = 200;
                    O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                    this.O00000Oo.O00oOoOo = false;
                } catch (IOException e18) {
                } catch (RuntimeException e19) {
                } catch (Throwable th16) {
                }
                if (wakeLock != null) {
                    wakeLock.release();
                }
                O000000o(o00000Oo, 200);
                i = 200;
            } catch (StopRequest e20) {
                e = e20;
                str = str17;
                wakeLock = newWakeLock;
                stopRequest = e;
                r10 = wakeLock;
                gsy.O000000o(5, "DownloadManager", "Aborting request for download " + this.O00000Oo.f16968O000000o + str + stopRequest.getMessage());
                i = stopRequest.mFinalStatus;
                if (r10 != 0) {
                }
                O000000o(o00000Oo, i);
                O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
                this.O00000Oo.O00oOoOo = false;
            } catch (Throwable th17) {
            }
        } catch (StopRequest e21) {
            str = str17;
            stopRequest = e21;
            gsy.O000000o(5, "DownloadManager", "Aborting request for download " + this.O00000Oo.f16968O000000o + str + stopRequest.getMessage());
            i = stopRequest.mFinalStatus;
            if (r10 != 0) {
            }
            O000000o(o00000Oo, i);
            O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
            this.O00000Oo.O00oOoOo = false;
        } catch (Throwable th18) {
            th = th18;
            wakeLock = null;
            if (wakeLock != null) {
            }
            O000000o(o00000Oo, 491);
            O000000o(491, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
            this.O00000Oo.O00oOoOo = false;
            throw th;
        }
        O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
        this.O00000Oo.O00oOoOo = false;
        Log.w("DownloadManager", str7, iOException2);
        if (wakeLock != null) {
        }
        O000000o(o00000Oo, 200);
        i = 200;
        O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
        this.O00000Oo.O00oOoOo = false;
        Log.w("DownloadManager", str3, iOException);
        if (wakeLock != null) {
        }
        O000000o(o00000Oo, 200);
        i = 200;
        O000000o(i, o00000Oo.O00000o, o00000Oo.O00000oO, o00000Oo.O0000OOo, o00000Oo.f7315O000000o, o00000Oo.O0000O0o, o00000Oo.O00000o0);
        this.O00000Oo.O00oOoOo = false;
    }

    private void O000000o() throws StopRequest {
        int O00000Oo2 = this.O00000Oo.O00000Oo();
        if (O00000Oo2 != 1) {
            int i = 196;
            if (!(O00000Oo2 == 3 || O00000Oo2 == 4)) {
                i = 195;
            }
            throw new StopRequest(i, fri.O000000o(O00000Oo2));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    private void O000000o(O00000Oo o00000Oo, O000000o o000000o, byte[] bArr, InputStream inputStream) throws StopRequest {
        do {
            int O00000Oo2 = O00000Oo(o00000Oo, o000000o, bArr, inputStream);
            boolean z = false;
            if (O00000Oo2 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("current_bytes", Integer.valueOf(o000000o.f7314O000000o));
                if (o000000o.O00000o == null) {
                    contentValues.put("total_bytes", Integer.valueOf(o000000o.f7314O000000o));
                }
                this.f7313O000000o.getContentResolver().update(this.O00000Oo.O00000o0(), contentValues, null, null);
                if (!(o000000o.O00000o == null || o000000o.f7314O000000o == Integer.parseInt(o000000o.O00000o))) {
                    z = true;
                }
                if (!z) {
                    return;
                }
                if (O000000o(o000000o)) {
                    throw new StopRequest(489, "mismatched content length");
                }
                throw new StopRequest(O00000Oo(o00000Oo), "closed socket before end of file");
            }
            o00000Oo.O0000OOo = true;
            try {
                if (o00000Oo.O00000Oo == null) {
                    o00000Oo.O00000Oo = new FileOutputStream(o00000Oo.f7315O000000o, true);
                }
                o00000Oo.O00000Oo.write(bArr, 0, O00000Oo2);
                if (this.O00000Oo.O0000O0o == 0) {
                    O000000o(o00000Oo);
                }
                o000000o.f7314O000000o += O00000Oo2;
                long O000000o2 = this.O00000o0.O000000o();
                if (o000000o.f7314O000000o - o000000o.O0000O0o > 4096 && O000000o2 - o000000o.O0000OOo > 1500) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("current_bytes", Integer.valueOf(o000000o.f7314O000000o));
                    this.f7313O000000o.getContentResolver().update(this.O00000Oo.O00000o0(), contentValues2, null, null);
                    o000000o.O0000O0o = o000000o.f7314O000000o;
                    o000000o.O0000OOo = O000000o2;
                }
                gsy.O000000o(2, "DownloadManager", "downloaded " + o000000o.f7314O000000o + " for " + this.O00000Oo.O00000Oo);
                synchronized (this.O00000Oo) {
                    if (this.O00000Oo.O0000Oo0 == 1) {
                        throw new StopRequest(193, "download paused by owner");
                    }
                }
                if (this.O00000Oo.O0000Oo == 490) {
                    throw new StopRequest(490, "download canceled");
                }
            } catch (IOException e) {
                if (!Helpers.O000000o()) {
                    throw new StopRequest(499, "external media not mounted while writing destination file");
                } else if (Helpers.O000000o(Helpers.O000000o(o00000Oo.f7315O000000o)) < ((long) O00000Oo2)) {
                    throw new StopRequest(498, "insufficient space while writing destination file", e);
                } else {
                    throw new StopRequest(492, "while writing destination file: " + e.toString(), e);
                }
            }
        } while (!this.O00000o0.O0000OOo());
        throw new StopRequest(192, "download thread exit");
    }

    private static void O000000o(O00000Oo o00000Oo, int i) {
        O000000o(o00000Oo);
        if (o00000Oo.f7315O000000o != null && Downloads.isStatusError(i)) {
            new File(o00000Oo.f7315O000000o).delete();
            o00000Oo.f7315O000000o = null;
        }
    }

    private static void O000000o(O00000Oo o00000Oo) {
        try {
            if (o00000Oo.O00000Oo != null) {
                o00000Oo.O00000Oo.close();
                o00000Oo.O00000Oo = null;
            }
        } catch (IOException unused) {
        }
    }

    private boolean O000000o(O000000o o000000o) {
        return o000000o.f7314O000000o > 0 && !this.O00000Oo.O00000o0 && o000000o.O00000Oo == null;
    }

    private int O00000Oo(O00000Oo o00000Oo, O000000o o000000o, byte[] bArr, InputStream inputStream) throws StopRequest {
        try {
            return inputStream.read(bArr);
        } catch (IOException e) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_bytes", Integer.valueOf(o000000o.f7314O000000o));
            this.f7313O000000o.getContentResolver().update(this.O00000Oo.O00000o0(), contentValues, null, null);
            if (O000000o(o000000o)) {
                throw new StopRequest(489, "while reading response: " + e.toString() + ", can't resume interrupted download with no ETag", e);
            }
            int O00000Oo2 = O00000Oo(o00000Oo);
            throw new StopRequest(O00000Oo2, "while reading response: " + e.toString(), e);
        }
    }

    private InputStream O000000o(O00000Oo o00000Oo, Response response) throws StopRequest {
        try {
            return response.body().byteStream();
        } catch (Exception e) {
            int O00000Oo2 = O00000Oo(o00000Oo);
            throw new StopRequest(O00000Oo2, "while getting entity: " + e.toString(), e);
        }
    }

    private Response O000000o(O00000Oo o00000Oo, Call call) throws StopRequest {
        try {
            return call.execute();
        } catch (IllegalArgumentException e) {
            throw new StopRequest(495, "while trying to execute request: " + e.toString(), e);
        } catch (IOException e2) {
            int O00000Oo2 = O00000Oo(o00000Oo);
            throw new StopRequest(O00000Oo2, "while trying to execute request: " + e2.toString(), e2);
        }
    }

    private int O00000Oo(O00000Oo o00000Oo) {
        if (!Helpers.O000000o(this.O00000o0)) {
            return 195;
        }
        if (this.O00000Oo.O0000OoO < 5) {
            o00000Oo.O00000o = true;
            return 194;
        }
        gsy.O000000o(5, "DownloadManager", "reached max retries for " + this.O00000Oo.f16968O000000o);
        return 495;
    }

    private void O000000o(O000000o o000000o, Request.Builder builder) {
        for (Pair pair : Collections.unmodifiableList(this.O00000Oo.O000O0o0)) {
            builder.addHeader((String) pair.first, (String) pair.second);
        }
        if (o000000o.O00000o0) {
            if (o000000o.O00000Oo != null) {
                builder.addHeader("If-Match", o000000o.O00000Oo);
            }
            builder.addHeader("Range", "bytes=" + o000000o.f7314O000000o + "-");
        }
    }

    private void O000000o(int i, boolean z, int i2, boolean z2, String str, String str2, String str3) {
        O00000Oo(i, z, i2, z2, str, str2, str3);
        if (Downloads.isStatusCompleted(i)) {
            this.O00000Oo.O000000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    private void O00000Oo(int i, boolean z, int i2, boolean z2, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        contentValues.put("_data", str);
        if (str2 != null) {
            contentValues.put("uri", str2);
        }
        contentValues.put("mimetype", str3);
        contentValues.put("lastmod", Long.valueOf(this.O00000o0.O000000o()));
        contentValues.put("method", Integer.valueOf(i2));
        if (!z) {
            contentValues.put("numfailed", (Integer) 0);
        } else if (z2) {
            contentValues.put("numfailed", (Integer) 1);
        } else {
            contentValues.put("numfailed", Integer.valueOf(this.O00000Oo.O0000OoO + 1));
        }
        this.f7313O000000o.getContentResolver().update(this.O00000Oo.O00000o0(), contentValues, null, null);
    }

    public static String O000000o(String str) {
        try {
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            int indexOf = lowerCase.indexOf(59);
            return indexOf != -1 ? lowerCase.substring(0, indexOf) : lowerCase;
        } catch (NullPointerException unused) {
            return null;
        }
    }
}

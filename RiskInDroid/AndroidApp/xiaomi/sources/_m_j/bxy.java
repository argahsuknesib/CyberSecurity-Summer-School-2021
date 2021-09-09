package _m_j;

import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

final class bxy extends bxt {
    private final int O00000o = ((int) (((float) this.O00000Oo) * 1.2f));
    private final LinkedHashMap<Long, String> O00000oO = new LinkedHashMap<>();
    private int O00000oo = 0;
    private long O0000O0o = 0;
    private long O0000OOo = 0;
    private long O0000Oo = 0;
    private long O0000Oo0 = 0;
    private long O0000OoO = 0;
    private long O0000Ooo = 0;

    public bxy(long j) {
        super(j);
    }

    public final void O000000o() {
        super.O000000o();
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        this.O0000Oo0 = 0;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
    }

    public final String O00000o() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.O00000oO) {
            for (Map.Entry next : this.O00000oO.entrySet()) {
                sb.append(bye.f13404O000000o.format(Long.valueOf(((Long) next.getKey()).longValue())));
                sb.append(' ');
                sb.append((String) next.getValue());
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    public final boolean O000000o(long j, long j2) {
        if (j2 - j <= this.O00000Oo) {
            return false;
        }
        long j3 = j - this.O00000Oo;
        long j4 = j + this.O00000Oo;
        synchronized (this.O00000oO) {
            long j5 = 0;
            for (Map.Entry<Long, String> key : this.O00000oO.entrySet()) {
                long longValue = ((Long) key.getKey()).longValue();
                if (j3 < longValue && longValue < j4) {
                    if (j5 != 0 && longValue - j5 > ((long) this.O00000o)) {
                        return true;
                    }
                    j5 = longValue;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f2 A[SYNTHETIC, Splitter:B:76:0x01f2] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f7 A[Catch:{ IOException -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0201 A[SYNTHETIC, Splitter:B:83:0x0201] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0209 A[Catch:{ IOException -> 0x0205 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    public final void O00000o0() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        long j;
        long j2;
        BufferedReader bufferedReader3 = null;
        try {
            BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
            try {
                String readLine = bufferedReader4.readLine();
                if (readLine == null) {
                    readLine = "";
                }
                if (this.O00000oo == 0) {
                    try {
                        this.O00000oo = Process.myPid();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        bufferedReader2 = bufferedReader4;
                        Throwable th2 = th;
                        if (bufferedReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th2;
                    }
                }
                BufferedReader bufferedReader5 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + this.O00000oo + "/stat")), 1000);
                try {
                    String readLine2 = bufferedReader5.readLine();
                    if (readLine2 == null) {
                        readLine2 = "";
                    }
                    String[] split = readLine.split(" ");
                    if (split.length >= 9) {
                        long parseLong = Long.parseLong(split[2]);
                        long parseLong2 = Long.parseLong(split[3]);
                        long parseLong3 = Long.parseLong(split[4]);
                        long parseLong4 = Long.parseLong(split[5]);
                        long parseLong5 = Long.parseLong(split[6]);
                        long parseLong6 = parseLong2 + parseLong + parseLong3 + parseLong4 + parseLong5 + Long.parseLong(split[7]) + Long.parseLong(split[8]);
                        String[] split2 = readLine2.split(" ");
                        if (split2.length >= 17) {
                            bufferedReader = bufferedReader5;
                            long parseLong7 = Long.parseLong(split2[13]) + Long.parseLong(split2[14]) + Long.parseLong(split2[15]) + Long.parseLong(split2[16]);
                            bufferedReader2 = bufferedReader4;
                            try {
                                if (this.O0000OoO != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    long j3 = parseLong4 - this.O0000Oo0;
                                    j2 = parseLong4;
                                    long j4 = parseLong6 - this.O0000OoO;
                                    j = parseLong6;
                                    sb.append("cpu:");
                                    sb.append(((j4 - j3) * 100) / j4);
                                    sb.append("% app:");
                                    sb.append(((parseLong7 - this.O0000Ooo) * 100) / j4);
                                    sb.append("% [user:");
                                    sb.append(((parseLong - this.O0000O0o) * 100) / j4);
                                    sb.append("% system:");
                                    sb.append(((parseLong3 - this.O0000OOo) * 100) / j4);
                                    sb.append("% ioWait:");
                                    sb.append(((parseLong5 - this.O0000Oo) * 100) / j4);
                                    sb.append("% ]");
                                    synchronized (this.O00000oO) {
                                        this.O00000oO.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
                                        if (this.O00000oO.size() > 10) {
                                            Iterator<Map.Entry<Long, String>> it = this.O00000oO.entrySet().iterator();
                                            if (it.hasNext()) {
                                                this.O00000oO.remove((Long) it.next().getKey());
                                            }
                                        }
                                    }
                                } else {
                                    j = parseLong6;
                                    j2 = parseLong4;
                                }
                                this.O0000O0o = parseLong;
                                this.O0000OOo = parseLong3;
                                this.O0000Oo0 = j2;
                                this.O0000Oo = parseLong5;
                                this.O0000OoO = j;
                                this.O0000Ooo = parseLong7;
                                bufferedReader2.close();
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                th = th3;
                                Throwable th22 = th;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e) {
                                        Log.e("CpuSampler", "doSample: ", e);
                                        throw th22;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th22;
                            }
                        }
                    }
                    bufferedReader2 = bufferedReader4;
                    bufferedReader = bufferedReader5;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader2 = bufferedReader4;
                    bufferedReader = bufferedReader5;
                    Throwable th222 = th;
                    if (bufferedReader2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th222;
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader2 = bufferedReader4;
                bufferedReader = null;
                Throwable th2222 = th;
                if (bufferedReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th2222;
            }
            try {
                bufferedReader2.close();
                bufferedReader.close();
            } catch (IOException e2) {
                Log.e("CpuSampler", "doSample: ", e2);
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader2 = null;
            bufferedReader = null;
            Throwable th22222 = th;
            if (bufferedReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th22222;
        }
    }
}

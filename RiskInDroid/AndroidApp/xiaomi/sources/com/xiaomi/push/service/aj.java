package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.ele;
import _m_j.enn;
import _m_j.eou;
import _m_j.erm;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class aj {

    /* renamed from: a  reason: collision with root package name */
    private static long f6496a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f247a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f248a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append("\n");
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        ele.O000000o(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                ele.O000000o(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                ele.O000000o(bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
            ele.O000000o(bufferedReader);
            return null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            ele.O000000o(bufferedReader);
            throw th;
        }
    }

    public static void a(List<String> list, boolean z) {
        f247a.execute(new ak(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            duv.O000000o("dump tcp for uid = " + Process.myUid());
            duv.O000000o(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a3)) {
            duv.O000000o("dump tcp6 for uid = " + Process.myUid());
            duv.O000000o(a3);
        }
    }

    private static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            duv.O000000o("ConnectivityTest: begin to connect to ".concat(String.valueOf(str)));
            Socket socket = new Socket();
            socket.connect(enn.O00000Oo(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            duv.O000000o("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            duv.O00000o("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    public static void a() {
        eou.O000000o a2;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f247a.getActiveCount() <= 0 || currentTimeMillis - f6496a >= 1800000) && erm.O000000o.f15749O000000o.f15748O000000o && (a2 = bo.a().m193a()) != null && a2.O00000Oo.size() > 0) {
            f6496a = currentTimeMillis;
            a(a2.O00000Oo, true);
        }
    }
}

package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.ele;
import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6484a;

    /* renamed from: a  reason: collision with other field name */
    private Context f226a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f227a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final String f228a = "mipush_region";
    private final Object b = new Object();

    /* renamed from: b  reason: collision with other field name */
    private final String f229b = "mipush_country_code";
    private final String c = "mipush_region.lock";
    private final String d = "mipush_country_code.lock";
    private volatile String e;
    private volatile String f;

    public a(Context context) {
        this.f226a = context;
    }

    public static a a(Context context) {
        if (f6484a == null) {
            synchronized (a.class) {
                if (f6484a == null) {
                    f6484a = new a(context);
                }
            }
        }
        return f6484a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065 A[SYNTHETIC, Splitter:B:34:0x0065] */
    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            duv.O000000o("No ready file to get data from ".concat(String.valueOf(str)));
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                ele.O00000o0(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        String O00000Oo = ele.O00000Oo(file);
                        if (fileLock != null) {
                            if (fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e2) {
                                    duv.O000000o(e2);
                                }
                            }
                        }
                        ele.O000000o(randomAccessFile);
                        return O00000Oo;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            duv.O000000o(e);
                            if (fileLock != null) {
                            }
                            ele.O000000o(randomAccessFile);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            fileLock2 = fileLock;
                            try {
                                fileLock2.release();
                            } catch (IOException e4) {
                                duv.O000000o(e4);
                            }
                            ele.O000000o(randomAccessFile);
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileLock = null;
                    duv.O000000o(e);
                    if (fileLock != null) {
                    }
                    ele.O000000o(randomAccessFile);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileLock2.release();
                    ele.O000000o(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                fileLock = null;
                duv.O000000o(e);
                if (fileLock != null) {
                    if (fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e7) {
                            duv.O000000o(e7);
                        }
                    }
                }
                ele.O000000o(randomAccessFile);
                return null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock2 != null && fileLock2.isValid()) {
                    fileLock2.release();
                }
                ele.O000000o(randomAccessFile);
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[SYNTHETIC, Splitter:B:24:0x0049] */
    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                File file = new File(context.getFilesDir(), str3);
                ele.O00000o0(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    ele.O000000o(new File(context.getFilesDir(), str2), str);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                duv.O000000o(e2);
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        duv.O000000o(e);
                        if (fileLock != null) {
                            if (fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e4) {
                                    duv.O000000o(e4);
                                }
                            }
                        }
                        ele.O000000o(randomAccessFile);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            duv.O000000o(e5);
                        }
                        ele.O000000o(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                duv.O000000o(e);
                if (fileLock != null) {
                }
                ele.O000000o(randomAccessFile);
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                ele.O000000o(randomAccessFile);
                throw th;
            }
            ele.O000000o(randomAccessFile);
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(this.f226a, "mipush_region", "mipush_region.lock", this.f227a);
        }
        return this.e;
    }

    public void a(String str) {
        if (!TextUtils.equals(str, this.e)) {
            this.e = str;
            a(this.f226a, this.e, "mipush_region", "mipush_region.lock", this.f227a);
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = a(this.f226a, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.f;
    }

    public void b(String str) {
        if (!TextUtils.equals(str, this.f)) {
            this.f = str;
            a(this.f226a, this.f, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
    }
}

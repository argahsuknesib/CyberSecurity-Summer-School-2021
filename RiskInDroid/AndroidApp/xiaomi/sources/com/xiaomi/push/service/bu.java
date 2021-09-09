package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.ele;
import android.content.Context;
import com.xiaomi.push.ht;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6537a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ht f306a;

    bu(Context context, ht htVar) {
        this.f6537a = context;
        this.f306a = htVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a A[SYNTHETIC, Splitter:B:25:0x004a] */
    public void run() {
        RandomAccessFile randomAccessFile;
        synchronized (bt.f6536a) {
            FileLock fileLock = null;
            try {
                File file = new File(this.f6537a.getFilesDir(), "tiny_data.lock");
                ele.O00000o0(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    bt.c(this.f6537a, this.f306a);
                    if (fileLock != null) {
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e) {
                                duv.O000000o(e);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        duv.O000000o(e);
                        if (fileLock != null) {
                            if (fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    duv.O000000o(e3);
                                }
                            }
                        }
                        ele.O000000o(randomAccessFile);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            duv.O000000o(e4);
                        }
                        ele.O000000o(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
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
}

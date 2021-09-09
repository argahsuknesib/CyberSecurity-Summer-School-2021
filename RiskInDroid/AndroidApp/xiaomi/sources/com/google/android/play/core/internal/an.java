package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.q;
import com.google.android.play.core.splitinstall.b;
import com.google.android.play.core.splitinstall.d;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.v;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;

public final class an implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3752a;
    private final com.google.android.play.core.splitcompat.d b;
    /* access modifiers changed from: private */
    public final ao c;
    private final Executor d;
    private final q e;

    public an(Context context, Executor executor, ao aoVar, com.google.android.play.core.splitcompat.d dVar, q qVar) {
        this.f3752a = context;
        this.b = dVar;
        this.c = aoVar;
        this.d = executor;
        this.e = qVar;
    }

    @SplitInstallErrorCode
    private final Integer a(List<Intent> list) {
        FileChannel channel;
        FileLock fileLock;
        FileOutputStream fileOutputStream;
        try {
            channel = new RandomAccessFile(this.b.b(), "rw").getChannel();
            Integer num = null;
            try {
                fileLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLock = null;
            }
            if (fileLock != null) {
                int i = -11;
                try {
                    Log.i("SplitCompat", "Copying splits.");
                    for (Intent next : list) {
                        String stringExtra = next.getStringExtra("split_id");
                        AssetFileDescriptor openAssetFileDescriptor = this.f3752a.getContentResolver().openAssetFileDescriptor(next.getData(), "r");
                        File a2 = this.b.a(stringExtra);
                        if (!a2.exists() || a2.length() == openAssetFileDescriptor.getLength()) {
                            if (a2.exists()) {
                            }
                        }
                        if (!this.b.b(stringExtra).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                            try {
                                fileOutputStream = new FileOutputStream(a2);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                bufferedInputStream.close();
                            } catch (Throwable th) {
                                bufferedInputStream.close();
                                throw th;
                            }
                        }
                    }
                    Log.i("SplitCompat", "Splits copied.");
                    try {
                        if (this.c.a()) {
                            Log.i("SplitCompat", "Splits verified.");
                            i = 0;
                        } else {
                            Log.e("SplitCompat", "Split verification failed.");
                        }
                    } catch (Exception e2) {
                        Log.e("SplitCompat", "Error verifying splits.", e2);
                    }
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Error copying splits.", e3);
                    i = -13;
                } catch (Throwable th2) {
                    cd.a(th, th2);
                }
                num = Integer.valueOf(i);
                fileLock.release();
            }
            if (channel != null) {
                channel.close();
            }
            return num;
            throw th;
            throw th;
        } catch (Exception e4) {
            Log.e("SplitCompat", "Error locking files.", e4);
            return -13;
        } catch (Throwable th3) {
            cd.a(th, th3);
        }
    }

    static /* synthetic */ void a(an anVar, b bVar) {
        try {
            if (SplitCompat.a(v.a(anVar.f3752a))) {
                Log.i("SplitCompat", "Splits installed.");
                bVar.a();
                return;
            }
            Log.e("SplitCompat", "Emulating splits failed.");
            bVar.a(-12);
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error emulating splits.", e2);
            bVar.a(-12);
        }
    }

    static /* synthetic */ void a(an anVar, List list, b bVar) {
        Integer a2 = anVar.a(list);
        if (a2 == null) {
            return;
        }
        if (a2.intValue() == 0) {
            bVar.b();
        } else {
            bVar.a(a2.intValue());
        }
    }

    public final void a(List<Intent> list, b bVar) {
        if (SplitCompat.a()) {
            this.d.execute(new am(this, list, bVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}

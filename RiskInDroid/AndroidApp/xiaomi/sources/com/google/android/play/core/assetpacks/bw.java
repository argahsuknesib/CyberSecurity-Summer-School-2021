package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.internal.ce;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.zip.GZIPInputStream;

final class bw {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3666a = new aa("ExtractChunkTaskHandler");
    private final byte[] b = new byte[8192];
    private final bc c;
    private final ce<x> d;
    private final ce<ax> e;
    private final cb f;

    bw(bc bcVar, ce<x> ceVar, ce<ax> ceVar2, cb cbVar) {
        this.c = bcVar;
        this.d = ceVar;
        this.e = ceVar2;
        this.f = cbVar;
    }

    private final File b(bv bvVar) {
        File a2 = this.c.a(bvVar.k, bvVar.f3665a, bvVar.b, bvVar.c);
        if (!a2.exists()) {
            a2.mkdirs();
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0180 A[Catch:{ all -> 0x033b, all -> 0x0341, IOException -> 0x0347 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02a0 A[SYNTHETIC, Splitter:B:96:0x02a0] */
    public final void a(bv bvVar) {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        InputStream inputStream;
        dx a2;
        long j;
        File file;
        int min;
        int max;
        long j2;
        bv bvVar2 = bvVar;
        dr drVar = new dr(this.c, bvVar2.k, bvVar2.f3665a, bvVar2.b, bvVar2.c);
        File f2 = this.c.f(bvVar2.k, bvVar2.f3665a, bvVar2.b, bvVar2.c);
        if (!f2.exists()) {
            f2.mkdirs();
        }
        try {
            InputStream inputStream2 = bvVar2.i;
            gZIPInputStream = bvVar2.d != 1 ? inputStream2 : new GZIPInputStream(inputStream2, this.b.length);
            if (bvVar2.e > 0) {
                dq a3 = drVar.a();
                int e2 = a3.e();
                int i = bvVar2.e;
                if (e2 == i - 1) {
                    int a4 = a3.a();
                    if (a4 == 1) {
                        f3666a.a("Resuming zip entry from last chunk during file %s.", a3.b());
                        File file2 = new File(a3.b());
                        if (file2.exists()) {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                            randomAccessFile.seek(a3.c());
                            long d2 = a3.d();
                            while (true) {
                                min = (int) Math.min(d2, (long) this.b.length);
                                max = Math.max(gZIPInputStream.read(this.b, 0, min), 0);
                                if (max > 0) {
                                    randomAccessFile.write(this.b, 0, max);
                                }
                                j2 = d2 - ((long) max);
                                if (j2 > 0) {
                                    if (max <= 0) {
                                        break;
                                    }
                                    d2 = j2;
                                } else {
                                    break;
                                }
                            }
                            long length = randomAccessFile.length();
                            randomAccessFile.close();
                            if (max != min) {
                                f3666a.a("Chunk has ended while resuming the previous chunks file content.", new Object[0]);
                                drVar.a(file2.getCanonicalPath(), length, j2, bvVar2.e);
                            }
                        } else {
                            throw new by("Partial file specified in checkpoint does not exist. Corrupt directory.", bvVar2.j);
                        }
                    } else if (a4 == 2) {
                        f3666a.a("Resuming zip entry from last chunk during local file header.", new Object[0]);
                        File d3 = this.c.d(bvVar2.k, bvVar2.f3665a, bvVar2.b, bvVar2.c);
                        if (d3.exists()) {
                            inputStream = new SequenceInputStream(new FileInputStream(d3), gZIPInputStream);
                            if (inputStream != null) {
                                bp bpVar = new bp(inputStream);
                                File b2 = b(bvVar);
                                do {
                                    a2 = bpVar.a();
                                    if ((a2.a() == null || !a2.a().endsWith("/")) && !a2.d() && !bpVar.c()) {
                                        if (a2.c() == 0) {
                                            drVar.a(a2.e());
                                            File file3 = new File(b2, a2.a());
                                            file3.getParentFile().mkdirs();
                                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                            for (int read = bpVar.read(this.b); read > 0; read = bpVar.read(this.b)) {
                                                fileOutputStream.write(this.b, 0, read);
                                            }
                                            fileOutputStream.close();
                                        } else {
                                            drVar.a(a2.e(), bpVar);
                                        }
                                    }
                                    if (bpVar.b()) {
                                        break;
                                    }
                                } while (!bpVar.c());
                                if (bpVar.c()) {
                                    f3666a.a("Writing central directory metadata.", new Object[0]);
                                    drVar.a(a2.e(), inputStream);
                                }
                                if (!bvVar.a()) {
                                    if (a2.d()) {
                                        f3666a.a("Writing slice checkpoint for partial local file header.", new Object[0]);
                                        drVar.a(a2.e(), bvVar2.e);
                                    } else if (bpVar.c()) {
                                        f3666a.a("Writing slice checkpoint for central directory.", new Object[0]);
                                        drVar.a(bvVar2.e);
                                    } else {
                                        if (a2.c() == 0) {
                                            f3666a.a("Writing slice checkpoint for partial file.", new Object[0]);
                                            file = new File(b(bvVar), a2.a());
                                            j = a2.b() - bpVar.d();
                                            if (file.length() != j) {
                                                throw new by("Partial file is of unexpected size.");
                                            }
                                        } else {
                                            f3666a.a("Writing slice checkpoint for partial unextractable file.", new Object[0]);
                                            file = drVar.b();
                                            j = file.length();
                                        }
                                        drVar.a(file.getCanonicalPath(), j, bpVar.d(), bvVar2.e);
                                    }
                                }
                            }
                            gZIPInputStream.close();
                            if (bvVar.a()) {
                                try {
                                    drVar.b(bvVar2.e);
                                } catch (IOException e3) {
                                    f3666a.b("Writing extraction finished checkpoint failed with %s.", e3.getMessage());
                                    throw new by("Writing extraction finished checkpoint failed.", e3, bvVar2.j);
                                }
                            }
                            f3666a.c("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bvVar2.e), bvVar2.c, bvVar2.k, Integer.valueOf(bvVar2.j));
                            this.d.a().a(bvVar2.j, bvVar2.k, bvVar2.c, bvVar2.e);
                            bvVar2.i.close();
                            if (bvVar2.h == 3) {
                                String str = bvVar2.k;
                                long j3 = bvVar2.g;
                                this.e.a().a(AssetPackState.a(str, 3, 0, j3, j3, this.f.a(str, bvVar2)));
                                return;
                            }
                            return;
                        }
                        throw new by("Checkpoint extension file not found.", bvVar2.j);
                    } else if (a4 == 3) {
                        f3666a.a("Resuming central directory from last chunk.", new Object[0]);
                        drVar.a(gZIPInputStream, a3.c());
                        if (!bvVar.a()) {
                            throw new by("Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB.", bvVar2.j);
                        }
                    } else {
                        throw new by(String.format("Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s.", Integer.valueOf(a3.a())), bvVar2.j);
                    }
                    inputStream = null;
                    if (inputStream != null) {
                    }
                    gZIPInputStream.close();
                    if (bvVar.a()) {
                    }
                    f3666a.c("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bvVar2.e), bvVar2.c, bvVar2.k, Integer.valueOf(bvVar2.j));
                    this.d.a().a(bvVar2.j, bvVar2.k, bvVar2.c, bvVar2.e);
                    bvVar2.i.close();
                    if (bvVar2.h == 3) {
                    }
                } else {
                    throw new by(String.format("Trying to resume with chunk number %s when previously processed chunk was number %s.", Integer.valueOf(i), Integer.valueOf(a3.e())), bvVar2.j);
                }
            }
            inputStream = gZIPInputStream;
            if (inputStream != null) {
            }
            gZIPInputStream.close();
            if (bvVar.a()) {
            }
            f3666a.c("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bvVar2.e), bvVar2.c, bvVar2.k, Integer.valueOf(bvVar2.j));
            this.d.a().a(bvVar2.j, bvVar2.k, bvVar2.c, bvVar2.e);
            try {
                bvVar2.i.close();
            } catch (IOException unused) {
                f3666a.d("Could not close file for chunk %s of slice %s of pack %s.", Integer.valueOf(bvVar2.e), bvVar2.c, bvVar2.k);
            }
            if (bvVar2.h == 3) {
            }
        } catch (IOException e4) {
            f3666a.b("IOException during extraction %s.", e4.getMessage());
            throw new by(String.format("Error extracting chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bvVar2.e), bvVar2.c, bvVar2.k, Integer.valueOf(bvVar2.j)), e4, bvVar2.j);
        } catch (Throwable th2) {
            cd.a(th, th2);
        }
        throw th;
    }
}

package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.internal.ce;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.play.core.assetpacks.do  reason: invalid class name */
final class Cdo {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3709a = new aa("PatchSliceTaskHandler");
    private final bc b;
    private final ce<x> c;

    Cdo(bc bcVar, ce<x> ceVar) {
        this.b = bcVar;
        this.c = ceVar;
    }

    public final void a(dn dnVar) {
        InputStream inputStream;
        Throwable th;
        dn dnVar2 = dnVar;
        File a2 = this.b.a(dnVar2.k, dnVar2.f3708a, dnVar2.b);
        bc bcVar = this.b;
        String str = dnVar2.k;
        int i = dnVar2.f3708a;
        long j = dnVar2.b;
        File file = new File(bcVar.b(str, i, j), dnVar2.f);
        try {
            inputStream = dnVar2.h;
            if (dnVar2.e == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            bf bfVar = new bf(a2, file);
            File file2 = new File(this.b.f(dnVar2.k, dnVar2.c, dnVar2.d, dnVar2.f), "slice.zip.tmp");
            if (file2.getParentFile() != null) {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
            }
            aq.a(bfVar, inputStream, new FileOutputStream(file2), dnVar2.g);
            if (file2.renameTo(this.b.e(dnVar2.k, dnVar2.c, dnVar2.d, dnVar2.f))) {
                inputStream.close();
                f3709a.c("Patching finished for slice %s of pack %s.", dnVar2.f, dnVar2.k);
                this.c.a().a(dnVar2.j, dnVar2.k, dnVar2.f, 0);
                try {
                    dnVar2.h.close();
                    return;
                } catch (IOException unused) {
                    f3709a.d("Could not close file for slice %s of pack %s.", dnVar2.f, dnVar2.k);
                    return;
                }
            } else {
                throw new by(String.format("Error moving patch for slice %s of pack %s.", dnVar2.f, dnVar2.k), dnVar2.j);
            }
        } catch (IOException e) {
            f3709a.b("IOException during patching %s.", e.getMessage());
            throw new by(String.format("Error patching slice %s of pack %s.", dnVar2.f, dnVar2.k), e, dnVar2.j);
        } catch (Throwable th2) {
            cd.a(th, th2);
        }
        throw th;
    }
}

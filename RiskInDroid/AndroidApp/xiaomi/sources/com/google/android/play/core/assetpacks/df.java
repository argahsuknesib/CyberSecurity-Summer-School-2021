package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.aa;
import java.io.File;
import java.io.IOException;

final class df {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3700a = new aa("MergeSliceTaskHandler");
    private final bc b;

    df(bc bcVar) {
        this.b = bcVar;
    }

    private static void a(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                a(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new by(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new by(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new by(sb3.toString());
        }
    }

    public final void a(de deVar) {
        File b2 = this.b.b(deVar.k, deVar.f3699a, deVar.b, deVar.c);
        if (b2.exists()) {
            File c = this.b.c(deVar.k, deVar.f3699a, deVar.b);
            if (!c.exists()) {
                c.mkdirs();
            }
            a(b2, c);
            try {
                this.b.a(deVar.k, deVar.f3699a, deVar.b, this.b.d(deVar.k, deVar.f3699a, deVar.b) + 1);
            } catch (IOException e) {
                f3700a.b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new by("Writing merge checkpoint failed.", e, deVar.j);
            }
        } else {
            throw new by(String.format("Cannot find verified files for slice %s.", deVar.c), deVar.j);
        }
    }
}

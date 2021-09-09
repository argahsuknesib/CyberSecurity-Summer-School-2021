package com.mipay.imageloadhelper.cache;

import _m_j.cng;
import _m_j.cnh;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

public class DiskLruCache$1 implements Callable<Void> {
    final /* synthetic */ cng this$0;

    DiskLruCache$1(cng cng) {
        this.this$0 = cng;
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fd, code lost:
        return null;
     */
    public Void call() throws Exception {
        synchronized (this.this$0) {
            if (this.this$0.O0000OOo == null) {
                return null;
            }
            this.this$0.O00000Oo();
            if (this.this$0.O000000o()) {
                cng cng = this.this$0;
                if (cng.O0000OOo != null) {
                    cng.O0000OOo.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cng.O00000o), cnh.f14142O000000o));
                try {
                    bufferedWriter.write("libcore.io.DiskLruCache");
                    bufferedWriter.write("\n");
                    bufferedWriter.write("1");
                    bufferedWriter.write("\n");
                    bufferedWriter.write(Integer.toString(cng.O00000oo));
                    bufferedWriter.write("\n");
                    bufferedWriter.write(Integer.toString(cng.O0000O0o));
                    bufferedWriter.write("\n");
                    bufferedWriter.write("\n");
                    for (cng.O00000Oo next : cng.O0000Oo0.values()) {
                        if (next.O00000o != null) {
                            bufferedWriter.write("DIRTY " + next.f14141O000000o + 10);
                        } else {
                            bufferedWriter.write("CLEAN " + next.f14141O000000o + next.O000000o() + 10);
                        }
                    }
                    bufferedWriter.close();
                    if (cng.O00000o0.exists()) {
                        cng.O000000o(cng.O00000o0, cng.O00000oO, true);
                    }
                    cng.O000000o(cng.O00000o, cng.O00000o0, false);
                    cng.O00000oO.delete();
                    cng.O0000OOo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cng.O00000o0, true), cnh.f14142O000000o));
                    this.this$0.O0000Oo = 0;
                } catch (Throwable th) {
                    bufferedWriter.close();
                    throw th;
                }
            }
        }
    }
}

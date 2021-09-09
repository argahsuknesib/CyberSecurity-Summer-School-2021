package org.apache.commons.compress.archivers.zip;

import _m_j.jbw;
import _m_j.jcm;
import java.util.concurrent.Callable;

public class ParallelScatterZipCreator$3 implements Callable<Object> {
    final /* synthetic */ jbw this$0;
    final /* synthetic */ jcm val$zipArchiveEntryRequestSupplier;

    ParallelScatterZipCreator$3(jbw jbw, jcm jcm) {
        this.this$0 = jbw;
        this.val$zipArchiveEntryRequestSupplier = jcm;
    }

    public Object call() throws Exception {
        this.this$0.f1750O000000o.get().O000000o(this.val$zipArchiveEntryRequestSupplier.O000000o());
        return null;
    }
}

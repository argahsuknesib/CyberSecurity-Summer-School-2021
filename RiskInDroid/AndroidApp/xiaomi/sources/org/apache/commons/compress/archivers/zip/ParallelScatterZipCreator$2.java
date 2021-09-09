package org.apache.commons.compress.archivers.zip;

import _m_j.jbw;
import _m_j.jcl;
import java.util.concurrent.Callable;

public class ParallelScatterZipCreator$2 implements Callable<Object> {
    final /* synthetic */ jbw this$0;
    final /* synthetic */ jcl val$zipArchiveEntryRequest;

    ParallelScatterZipCreator$2(jbw jbw, jcl jcl) {
        this.this$0 = jbw;
        this.val$zipArchiveEntryRequest = jcl;
    }

    public Object call() throws Exception {
        this.this$0.f1750O000000o.get().O000000o(this.val$zipArchiveEntryRequest);
        return null;
    }
}

package com.xiaomi.infra.galaxy.fds.android;

import _m_j.dvz;
import _m_j.dwg;
import java.util.concurrent.Callable;

public class GalaxyFDSClientImpl$2 implements Callable<dwg> {
    final /* synthetic */ dvz this$0;
    final /* synthetic */ String val$bucketName;
    final /* synthetic */ byte[] val$buffer;
    final /* synthetic */ String val$finalObjectName;
    final /* synthetic */ int val$finalPartNumber;
    final /* synthetic */ String val$finalUploadId;

    public GalaxyFDSClientImpl$2(dvz dvz, String str, String str2, String str3, int i, byte[] bArr) {
        this.this$0 = dvz;
        this.val$finalUploadId = str;
        this.val$bucketName = str2;
        this.val$finalObjectName = str3;
        this.val$finalPartNumber = i;
        this.val$buffer = bArr;
    }

    public dwg call() throws Exception {
        return this.this$0.O000000o(this.val$finalUploadId, this.val$bucketName, this.val$finalObjectName, this.val$finalPartNumber, this.val$buffer);
    }
}

package com.alipay.security.mobile.module.http;

import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DataReportRequest f3243a;
    final /* synthetic */ b b;

    c(b bVar, DataReportRequest dataReportRequest) {
        this.b = bVar;
        this.f3243a = dataReportRequest;
    }

    public void run() {
        try {
            DataReportResult unused = b.e = this.b.c.reportData(this.f3243a);
        } catch (Throwable th) {
            DataReportResult unused2 = b.e = new DataReportResult();
            b.e.success = false;
            DataReportResult a2 = b.e;
            a2.resultCode = "static data rpc upload error, " + a.a(th);
            new StringBuilder("rpc failed:").append(a.a(th));
        }
    }
}

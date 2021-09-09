package com.mi.multimonitor;

import android.content.Context;

public class CrashSender implements ICrashDataSender {
    private ICrashProcessor crashProcessor;
    private Context mContext;
    private Executor mExecutor;

    CrashSender(Context context, Executor executor, ICrashProcessor iCrashProcessor) {
        this.mExecutor = executor;
        this.crashProcessor = iCrashProcessor;
        this.mContext = context;
    }

    public void postCrashData(Thread thread, Throwable th) {
        CrashReportBean processorException = this.crashProcessor.processorException(thread, th);
        if (processorException != null) {
            this.mExecutor.execute(new CrashRequest(this.mContext, thread, th, processorException));
        }
    }
}

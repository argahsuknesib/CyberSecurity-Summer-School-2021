package com.xiaomi.smarthome.library.common.threadpool;

import _m_j.gsy;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class StatisticalRejectedExecutionPolicy implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        gsy.O00000o0(LogType.SERIOUS_EXCEPTION, "rejectedExecution", threadPoolExecutor.toString());
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "\n");
        }
        gsy.O00000o0(LogType.SERIOUS_EXCEPTION, "发生rejectedExecution任务的堆栈信息", sb.toString());
    }
}

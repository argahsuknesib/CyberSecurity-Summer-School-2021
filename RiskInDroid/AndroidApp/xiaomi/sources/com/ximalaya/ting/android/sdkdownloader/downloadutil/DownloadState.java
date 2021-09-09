package com.ximalaya.ting.android.sdkdownloader.downloadutil;

public enum DownloadState {
    WAITING(0),
    STARTED(1),
    FINISHED(2),
    STOPPED(3),
    ERROR(4),
    NOADD(5);
    
    private final int value;

    private DownloadState(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }

    public static DownloadState valueOf(int i) {
        if (i == 0) {
            return WAITING;
        }
        if (i == 1) {
            return STARTED;
        }
        if (i == 2) {
            return FINISHED;
        }
        if (i == 3) {
            return STOPPED;
        }
        if (i == 4) {
            return ERROR;
        }
        if (i != 5) {
            return NOADD;
        }
        return NOADD;
    }

    public final String toString() {
        int i = this.value;
        if (i == 0) {
            return "等待";
        }
        if (i == 1) {
            return "开始";
        }
        if (i == 2) {
            return "结束";
        }
        if (i == 3) {
            return "停止";
        }
        if (i != 4) {
            return i != 5 ? "未知" : "未添加";
        }
        return "错误";
    }
}

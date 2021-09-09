package com.google.android.play.core.install;

import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;

public abstract class InstallState {
    public static InstallState a(@InstallStatus int i, long j, long j2, @InstallErrorCode int i2, String str) {
        return new a(i, j, j2, i2, str);
    }

    public abstract long bytesDownloaded();

    @InstallErrorCode
    public abstract int installErrorCode();

    @InstallStatus
    public abstract int installStatus();

    public abstract String packageName();

    public abstract long totalBytesToDownload();
}

package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$InternalHandler$NXQcmC9peGeDWV0s_8pBfzdJpS0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DownloadManager$InternalHandler$NXQcmC9peGeDWV0s_8pBfzdJpS0 implements Comparator {
    public static final /* synthetic */ $$Lambda$DownloadManager$InternalHandler$NXQcmC9peGeDWV0s_8pBfzdJpS0 INSTANCE = new $$Lambda$DownloadManager$InternalHandler$NXQcmC9peGeDWV0s_8pBfzdJpS0();

    private /* synthetic */ $$Lambda$DownloadManager$InternalHandler$NXQcmC9peGeDWV0s_8pBfzdJpS0() {
    }

    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
    }
}

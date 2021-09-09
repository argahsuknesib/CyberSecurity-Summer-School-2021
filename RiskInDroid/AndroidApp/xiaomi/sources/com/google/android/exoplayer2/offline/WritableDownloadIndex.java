package com.google.android.exoplayer2.offline;

import java.io.IOException;

public interface WritableDownloadIndex extends DownloadIndex {
    void putDownload(Download download) throws IOException;

    void removeDownload(String str) throws IOException;

    void setDownloadingStatesToQueued() throws IOException;

    void setStatesToRemoving() throws IOException;

    void setStopReason(int i) throws IOException;

    void setStopReason(String str, int i) throws IOException;
}

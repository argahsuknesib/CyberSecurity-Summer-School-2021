package com.miui.tsmclient.common.net;

import java.io.File;

public interface FileRequestCallback extends RequestCallback<File> {
    void onProgress(int i);
}

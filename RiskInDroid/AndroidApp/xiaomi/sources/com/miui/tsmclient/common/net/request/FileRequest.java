package com.miui.tsmclient.common.net.request;

import com.miui.tsmclient.common.net.FileRequestCallback;
import com.miui.tsmclient.common.net.RequestCallback;
import com.miui.tsmclient.common.net.request.BaseRequest;
import com.miui.tsmclient.util.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileRequest extends BaseRequest<File> {
    private File mFile;
    private FileRequestCallback mFileRequestCallback;

    public boolean isStringResponse() {
        return false;
    }

    public FileRequest(String str, File file, RequestCallback requestCallback) {
        super(0, str, requestCallback);
        this.mRequestType = BaseRequest.RequestType.NORMAL;
        this.mFile = file;
        if (requestCallback instanceof FileRequestCallback) {
            this.mFileRequestCallback = (FileRequestCallback) requestCallback;
        }
    }

    public File parseBody(InputStream inputStream, long j) throws IOException {
        FileRequestCallback fileRequestCallback;
        File file = this.mFile;
        if (file == null || !file.canWrite()) {
            throw new IOException("the saving path is invalid");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.mFile);
        long j2 = 0;
        if (j > 0) {
            try {
                fileRequestCallback = this.mFileRequestCallback;
            } catch (Throwable th) {
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                throw th;
            }
        } else {
            fileRequestCallback = null;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
                if (fileRequestCallback != null) {
                    j2 += (long) read;
                    fileRequestCallback.onProgress((int) (((((float) j2) * 1.0f) / ((float) j)) * 100.0f));
                }
            } else {
                fileOutputStream.flush();
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                return this.mFile;
            }
        }
    }

    public File parseBody(String str) throws IOException {
        throw new UnsupportedOperationException();
    }
}

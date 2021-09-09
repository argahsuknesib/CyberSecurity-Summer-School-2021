package org.apache.http.entity.mime.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileBody extends AbstractContentBody {
    private final String charset;
    private final File file;
    private final String filename;

    public String getTransferEncoding() {
        return "binary";
    }

    public FileBody(File file2, String str, String str2, String str3) {
        super(str2);
        if (file2 != null) {
            this.file = file2;
            if (str != null) {
                this.filename = str;
            } else {
                this.filename = file2.getName();
            }
            this.charset = str3;
            return;
        }
        throw new IllegalArgumentException("File may not be null");
    }

    public FileBody(File file2, String str, String str2) {
        this(file2, null, str, str2);
    }

    public FileBody(File file2, String str) {
        this(file2, str, null);
    }

    public FileBody(File file2) {
        this(file2, "application/octet-stream");
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        return;
                    }
                }
            } finally {
                fileInputStream.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public String getCharset() {
        return this.charset;
    }

    public long getContentLength() {
        return this.file.length();
    }

    public String getFilename() {
        return this.filename;
    }

    public File getFile() {
        return this.file;
    }
}

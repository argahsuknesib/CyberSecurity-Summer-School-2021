package com.xiaomi.smarthome.fastvideo.decoder;

import _m_j.ckn;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RawDataSaveHelper {
    protected FileOutputStream fileOutputStream;
    protected String mFileName;

    public void init() {
        try {
            ckn.O000000o(this.mFileName);
            this.fileOutputStream = new FileOutputStream(this.mFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(byte[] bArr) {
        FileOutputStream fileOutputStream2 = this.fileOutputStream;
        if (fileOutputStream2 != null) {
            try {
                fileOutputStream2.write(bArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        FileOutputStream fileOutputStream2 = this.fileOutputStream;
        if (fileOutputStream2 != null) {
            try {
                fileOutputStream2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

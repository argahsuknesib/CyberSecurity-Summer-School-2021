package com.xiaomi.smarthome.fastvideo.decoder;

import _m_j.ckh;
import java.io.File;

public class VideoRawDataSaveHelper extends RawDataSaveHelper {
    public void init(int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(ckh.O000000o().getExternalFilesDir("debug_mijia"));
        sb.append(File.separatorChar);
        sb.append(System.currentTimeMillis());
        sb.append("_frameRate".concat(String.valueOf(i)));
        sb.append("_width".concat(String.valueOf(i3)));
        sb.append("_height".concat(String.valueOf(i4)));
        if (i2 == 1) {
            sb.append(".h264");
        } else {
            sb.append(".h265");
        }
        this.mFileName = sb.toString();
        super.init();
    }
}

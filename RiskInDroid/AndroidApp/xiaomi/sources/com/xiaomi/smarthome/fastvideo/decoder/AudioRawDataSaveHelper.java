package com.xiaomi.smarthome.fastvideo.decoder;

import _m_j.ckh;
import java.io.File;

public class AudioRawDataSaveHelper extends RawDataSaveHelper {
    public void init(String str) {
        this.mFileName = ckh.O000000o().getExternalFilesDir("debug_mijia") + File.separatorChar + System.currentTimeMillis() + "_audio".concat(String.valueOf(str));
        super.init();
    }
}

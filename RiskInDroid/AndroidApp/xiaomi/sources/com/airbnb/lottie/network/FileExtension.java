package com.airbnb.lottie.network;

import com.airbnb.lottie.L;

public enum FileExtension {
    Json(".json"),
    Zip(".zip");
    
    public final String extension;

    private FileExtension(String str) {
        this.extension = str;
    }

    public final String tempExtension() {
        return ".temp" + this.extension;
    }

    public final String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        L.warn("Unable to find correct extension for ".concat(String.valueOf(str)));
        return Json;
    }
}

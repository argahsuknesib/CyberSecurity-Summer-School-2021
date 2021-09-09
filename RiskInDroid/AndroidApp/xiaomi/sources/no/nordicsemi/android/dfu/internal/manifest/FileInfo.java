package no.nordicsemi.android.dfu.internal.manifest;

import com.google.gson.annotations.SerializedName;

public class FileInfo {
    @SerializedName("bin_file")
    private String binFile;
    @SerializedName("dat_file")
    private String datFile;

    public String getBinFileName() {
        return this.binFile;
    }

    public String getDatFileName() {
        return this.datFile;
    }
}

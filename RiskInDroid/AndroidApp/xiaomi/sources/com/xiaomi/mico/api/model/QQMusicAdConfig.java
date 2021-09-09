package com.xiaomi.mico.api.model;

import com.google.gson.annotations.SerializedName;

public class QQMusicAdConfig {
    public boolean closeable = true;
    @SerializedName("appears_every_x_days")
    public int expiration;
    @SerializedName("force_display")
    public boolean forceDisplay;
    @SerializedName("green_diamond_icon")
    public String greenDiamondIcon;
    public String text;

    public String toString() {
        return "QQMusicAdConfig{greenDiamondIcon='" + this.greenDiamondIcon + '\'' + ", text='" + this.text + '\'' + ", expiration=" + this.expiration + ", forceDisplay=" + this.forceDisplay + ", closeable=" + this.closeable + '}';
    }
}

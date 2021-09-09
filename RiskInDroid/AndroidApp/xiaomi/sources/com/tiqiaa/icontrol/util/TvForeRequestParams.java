package com.tiqiaa.icontrol.util;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;
import java.util.Date;

public class TvForeRequestParams implements IJsonable {
    @bdk(O000000o = "channel_ids")
    int[] channel_ids;
    @bdk(O000000o = "date")
    Date date;
    @bdk(O000000o = "playing")
    boolean playing;
    @bdk(O000000o = "pp")
    String pp;

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public int[] getChannel_ids() {
        return this.channel_ids;
    }

    public void setChannel_ids(int[] iArr) {
        this.channel_ids = iArr;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public void setPlaying(boolean z) {
        this.playing = z;
    }

    public String getPp() {
        return this.pp;
    }

    public void setPp(String str) {
        this.pp = str;
    }
}

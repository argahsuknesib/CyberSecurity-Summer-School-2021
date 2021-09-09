package com.hzy.tvmao.model.db.bean;

import com.hzy.tvmao.model.legacy.api.StreamHelper;
import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.StringUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public final class ChannelInfo implements Serializable {
    private static final long serialVersionUID = -3812070525470731599L;
    public int channelId = 0;
    public String countryId = "";
    public int deviceId = 0;
    public byte[] encname;
    public byte[] encnum;
    public short fee = 0;
    public short isHd = 0;
    public int ishidden = 0;
    private a key;
    public int linupId;
    public String llogo = "";
    public String logo = "";
    public String name = "";
    public int num = 0;
    public String pulse;
    public int sequence = 0;
    public short type = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4428a = 0;
        public String b = "";
        public int c = 0;

        public a(int i, String str, int i2) {
            this.f4428a = i;
            this.b = str;
            this.c = i2;
        }

        public a() {
        }

        public int hashCode() {
            int i = (this.f4428a + 31) * 31;
            String str = this.b;
            return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4428a != aVar.f4428a) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (aVar.b != null) {
                    return false;
                }
            } else if (!str.equals(aVar.b)) {
                return false;
            }
            return this.c == aVar.c;
        }
    }

    public final String toString() {
        return "ChannelInfo [channelId=" + this.channelId + ", name=" + this.name + ", logo=" + this.logo + ", llogo=" + this.llogo + ", ishidden=" + this.ishidden + ", num=" + this.num + ", isHd=" + ((int) this.isHd) + ", countryId=" + this.countryId + ", linupId=" + this.linupId + ", sequence=" + this.sequence + ", type=" + ((int) this.type) + ", fee=" + ((int) this.fee) + ", deviceId=" + this.deviceId + ", encname=" + Arrays.toString(this.encname) + ", encnum=" + Arrays.toString(this.encnum) + ", pulse=" + this.pulse + "]";
    }

    public final void encrypt() {
        try {
            this.encname = StreamHelper.enc1(this.name.getBytes("UTF-8"));
            this.encnum = StreamHelper.enc1(String.valueOf(this.num).getBytes("UTF-8"));
            this.num = -1;
            this.name = "";
        } catch (UnsupportedEncodingException e) {
            LogUtil.d("encrypt failed");
            e.printStackTrace();
        }
    }

    public final void decrypt() {
        try {
            this.name = new String(StreamHelper.dec1(this.encname), "UTF-8");
            if (this.encnum != null) {
                this.num = StringUtil.parseInt(new String(StreamHelper.dec1(this.encnum), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            LogUtil.d("encrypt failed");
            e.printStackTrace();
        }
    }

    public final a getKey() {
        if (this.key == null) {
            this.key = new a(this.channelId, this.countryId, this.isHd);
        }
        return this.key;
    }
}

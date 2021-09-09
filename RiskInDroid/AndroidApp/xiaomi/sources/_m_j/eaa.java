package _m_j;

import com.xiaomi.push.service.module.PushChannelRegion;

public final class eaa {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f15114O000000o;
    boolean O00000Oo;
    boolean O00000o;
    boolean O00000o0;
    private PushChannelRegion O00000oO;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public PushChannelRegion f15115O000000o;
        public boolean O00000Oo;
        public boolean O00000o;
        public boolean O00000o0;
        public boolean O00000oO;
    }

    public eaa() {
        this.O00000oO = PushChannelRegion.China;
        this.f15114O000000o = false;
        this.O00000Oo = false;
        this.O00000o0 = false;
        this.O00000o = false;
    }

    private eaa(O000000o o000000o) {
        this.O00000oO = o000000o.f15115O000000o == null ? PushChannelRegion.China : o000000o.f15115O000000o;
        this.f15114O000000o = o000000o.O00000Oo;
        this.O00000Oo = o000000o.O00000o0;
        this.O00000o0 = o000000o.O00000o;
        this.O00000o = o000000o.O00000oO;
    }

    public /* synthetic */ eaa(O000000o o000000o, byte b) {
        this(o000000o);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        PushChannelRegion pushChannelRegion = this.O00000oO;
        stringBuffer.append(pushChannelRegion == null ? "null" : pushChannelRegion.name());
        stringBuffer.append(",mOpenHmsPush:" + this.f15114O000000o);
        stringBuffer.append(",mOpenFCMPush:" + this.O00000Oo);
        stringBuffer.append(",mOpenCOSPush:" + this.O00000o0);
        stringBuffer.append(",mOpenFTOSPush:" + this.O00000o);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

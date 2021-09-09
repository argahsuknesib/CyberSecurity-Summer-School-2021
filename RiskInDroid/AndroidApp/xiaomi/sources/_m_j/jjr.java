package _m_j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class jjr implements jji {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Map<Long, jjr> f1885O000000o = Collections.synchronizedMap(new HashMap());
    public byte O00000Oo;
    public byte O00000o;
    public byte O00000o0;
    public byte O00000oO;
    public byte O00000oo;
    public boolean O0000O0o;
    public int O0000OOo;

    public String toString() {
        StringBuilder sb = new StringBuilder("isLeading=");
        sb.append((int) this.O00000Oo);
        sb.append(", dependsOn=");
        sb.append((int) this.O00000o0);
        sb.append(", isDependedOn=");
        sb.append((int) this.O00000o);
        sb.append(", hasRedundancy=");
        sb.append((int) this.O00000oO);
        sb.append(", paddingValue=");
        sb.append((int) this.O00000oo);
        sb.append(", isSyncSample=");
        sb.append(!this.O0000O0o);
        sb.append(", sampleDegradationPriority=");
        sb.append(this.O0000OOo);
        return sb.toString();
    }
}

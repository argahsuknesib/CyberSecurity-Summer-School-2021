package javax.jmdns;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public abstract class ServiceInfo implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f15358O000000o = new byte[0];

    public enum Fields {
        Domain,
        Protocol,
        Application,
        Instance,
        Subtype
    }

    public abstract String O000000o(String str);

    public abstract boolean O000000o();

    public abstract String O00000Oo();

    public abstract String O00000o();

    public abstract String O00000o0();

    public abstract String O00000oO();

    @Deprecated
    public abstract InetAddress O00000oo();

    public abstract Inet4Address[] O0000O0o();

    public abstract Inet6Address[] O0000OOo();

    public abstract int O0000Oo();

    public abstract int O0000Oo0();

    public abstract int O0000OoO();

    public abstract byte[] O0000Ooo();

    public abstract String O0000o();

    public abstract String O0000o0();

    public abstract boolean O0000o00();

    public abstract String O0000o0O();

    public abstract String O0000o0o();

    /* renamed from: O0000oO0 */
    public ServiceInfo clone() {
        try {
            return (ServiceInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}

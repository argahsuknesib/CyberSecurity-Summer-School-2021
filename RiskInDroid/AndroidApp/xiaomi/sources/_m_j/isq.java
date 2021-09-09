package _m_j;

import java.io.Closeable;
import java.net.InetAddress;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.JmDNSImpl;

public abstract class isq implements Closeable {
    public abstract ServiceInfo O000000o(String str, String str2);

    public abstract void O000000o(String str, iss iss);

    public static isq O000000o(InetAddress inetAddress) throws Exception {
        return new JmDNSImpl(inetAddress);
    }
}

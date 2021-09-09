package _m_j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.impl.Log4jLoggerAdapter;

public class jnc implements jmw {

    /* renamed from: O000000o  reason: collision with root package name */
    ConcurrentMap<String, jmx> f1968O000000o = new ConcurrentHashMap();

    public final jmx O000000o(String str) {
        jef jef;
        jmx jmx = this.f1968O000000o.get(str);
        if (jmx != null) {
            return jmx;
        }
        if (str.equalsIgnoreCase("ROOT")) {
            jef = jee.O000000o();
        } else {
            jef = jee.O000000o(str);
        }
        Log4jLoggerAdapter log4jLoggerAdapter = new Log4jLoggerAdapter(jef);
        jmx putIfAbsent = this.f1968O000000o.putIfAbsent(str, log4jLoggerAdapter);
        return putIfAbsent == null ? log4jLoggerAdapter : putIfAbsent;
    }
}

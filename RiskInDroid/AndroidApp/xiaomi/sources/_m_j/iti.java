package _m_j;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.JmDNSImpl;

public class iti extends ith {
    static Logger O00000Oo = Logger.getLogger(iti.class.getName());

    public iti(JmDNSImpl jmDNSImpl) {
        super(jmDNSImpl);
    }

    public final String O000000o() {
        String str;
        StringBuilder sb = new StringBuilder("RecordReaper(");
        if (this.f1625O000000o != null) {
            str = this.f1625O000000o.O0000o0O;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    public void run() {
        if (!this.f1625O000000o.O0000Ooo() && !this.f1625O000000o.O0000o00()) {
            if (O00000Oo.isLoggable(Level.FINEST)) {
                Logger logger = O00000Oo;
                logger.finest(O000000o() + ".run() JmDNS reaping cache");
            }
            this.f1625O000000o.O0000oO();
        }
    }
}

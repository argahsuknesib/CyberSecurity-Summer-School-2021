package _m_j;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.JmDNSImpl;

public class itf extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    static Logger f1623O000000o = Logger.getLogger(itf.class.getName());
    private final JmDNSImpl O00000Oo;

    public itf(JmDNSImpl jmDNSImpl) {
        super("SocketListener(" + jmDNSImpl.O0000o0O + ")");
        setDaemon(true);
        this.O00000Oo = jmDNSImpl;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c8, code lost:
        r1.printStackTrace();
        r2 = _m_j.itf.f1623O000000o;
        r3 = java.util.logging.Level.WARNING;
        r2.log(r3, getName() + ".run() exception ", (java.lang.Throwable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        r2 = _m_j.itf.f1623O000000o;
        r3 = java.util.logging.Level.WARNING;
        r2.log(r3, getName() + ".run() exception ", (java.lang.Throwable) r1);
        r8.O00000Oo.O0000oO0();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7 A[ExcHandler: Exception (r1v5 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    public void run() {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[8972], 8972);
            while (!this.O00000Oo.O0000Ooo() && !this.O00000Oo.O0000o00()) {
                datagramPacket.setLength(8972);
                this.O00000Oo.O00000Oo.receive(datagramPacket);
                if (this.O00000Oo.O0000Ooo() || this.O00000Oo.O0000o00() || this.O00000Oo.O0000o0() || this.O00000Oo.O0000o0O()) {
                    break;
                } else if (!this.O00000Oo.O0000Oo0.O000000o(datagramPacket)) {
                    isw isw = new isw(datagramPacket);
                    if (f1623O000000o.isLoggable(Level.FINEST)) {
                        Logger logger = f1623O000000o;
                        logger.finest(getName() + ".run() JmDNS in:" + isw.O00000Oo());
                    }
                    if (isw.O0000o0()) {
                        if (datagramPacket.getPort() != itg.f1624O000000o) {
                            JmDNSImpl jmDNSImpl = this.O00000Oo;
                            datagramPacket.getAddress();
                            jmDNSImpl.O00000Oo(isw, datagramPacket.getPort());
                        }
                        this.O00000Oo.O00000Oo(isw, itg.f1624O000000o);
                    } else {
                        this.O00000Oo.O000000o(isw);
                    }
                }
            }
        } catch (IOException e) {
            Logger logger2 = f1623O000000o;
            Level level = Level.WARNING;
            logger2.log(level, getName() + ".run() exception ", (Throwable) e);
        } catch (Exception e2) {
        }
        if (f1623O000000o.isLoggable(Level.FINEST)) {
            Logger logger3 = f1623O000000o;
            logger3.finest(getName() + ".run() exiting.");
        }
    }
}

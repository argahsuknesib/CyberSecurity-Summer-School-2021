package bsh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Hashtable;

public class XThis extends This {
    Hashtable interfaces;
    InvocationHandler invocationHandler;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("'this' reference (XThis) to Bsh object: ");
        stringBuffer.append(this.namespace);
        return stringBuffer.toString();
    }

    public final Object O000000o(Class cls) {
        Class[] clsArr = {cls};
        if (this.interfaces == null) {
            this.interfaces = new Hashtable();
        }
        int i = 0;
        for (int i2 = 0; i2 <= 0; i2++) {
            i = (clsArr[0].hashCode() + 3) * 21;
        }
        Integer valueOf = Integer.valueOf(i);
        Object obj = this.interfaces.get(valueOf);
        if (obj != null) {
            return obj;
        }
        Object newProxyInstance = Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, this.invocationHandler);
        this.interfaces.put(valueOf, newProxyInstance);
        return newProxyInstance;
    }
}

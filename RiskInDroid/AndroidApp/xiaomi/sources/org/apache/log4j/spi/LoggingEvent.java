package org.apache.log4j.spi;

import _m_j.jdy;
import _m_j.jeg;
import _m_j.jeh;
import _m_j.jej;
import _m_j.jeo;
import _m_j.jep;
import _m_j.jeu;
import _m_j.jev;
import _m_j.jfb;
import _m_j.jff;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.log4j.Level;

public class LoggingEvent implements Serializable {
    static final Class[] O00000o = {Integer.TYPE};
    static final Integer[] O00000o0 = new Integer[1];
    static final Hashtable O00000oO = new Hashtable(3);
    static Class O00000oo = null;
    private static long O0000O0o = System.currentTimeMillis();
    static final long serialVersionUID = -868428216207166145L;

    /* renamed from: O000000o  reason: collision with root package name */
    public final transient String f15437O000000o;
    public transient jej O00000Oo;
    private transient jdy O0000OOo;
    private transient Object O0000Oo0;
    public final String categoryName;
    private LocationInfo locationInfo;
    private Hashtable mdcCopy;
    private boolean mdcCopyLookupRequired = true;
    private String ndc;
    private boolean ndcLookupRequired = true;
    private String renderedMessage;
    private String threadName;
    private ThrowableInformation throwableInfo;
    public final long timeStamp;

    public LoggingEvent(String str, jdy jdy, jej jej, Object obj, Throwable th) {
        this.f15437O000000o = str;
        this.O0000OOo = jdy;
        this.categoryName = jdy.O00000oO();
        this.O00000Oo = jej;
        this.O0000Oo0 = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th, jdy);
        }
        this.timeStamp = System.currentTimeMillis();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        try {
            String str = (String) objectInputStream.readObject();
            if (str == null) {
                this.O00000Oo = Level.O000000o(readInt);
            } else {
                Method method = (Method) O00000oO.get(str);
                if (method == null) {
                    method = jeo.O00000Oo(str).getDeclaredMethod("toLevel", O00000o);
                    O00000oO.put(str, method);
                }
                this.O00000Oo = (Level) method.invoke(null, Integer.valueOf(readInt));
            }
        } catch (InvocationTargetException e) {
            if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            jep.O00000o0("Level deserialization failed, reverting to default.", e);
            this.O00000Oo = Level.O000000o(readInt);
        } catch (NoSuchMethodException e2) {
            jep.O00000o0("Level deserialization failed, reverting to default.", e2);
            this.O00000Oo = Level.O000000o(readInt);
        } catch (IllegalAccessException e3) {
            jep.O00000o0("Level deserialization failed, reverting to default.", e3);
            this.O00000Oo = Level.O000000o(readInt);
        } catch (RuntimeException e4) {
            jep.O00000o0("Level deserialization failed, reverting to default.", e4);
            this.O00000Oo = Level.O000000o(readInt);
        }
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo();
        }
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object obj;
        String str;
        jeu jeu;
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        if (this.renderedMessage == null && (obj = this.O0000Oo0) != null) {
            if (obj instanceof String) {
                this.renderedMessage = (String) obj;
            } else {
                jfb O00000o2 = this.O0000OOo.O00000o();
                if (O00000o2 instanceof jff) {
                    jev O00000o02 = ((jff) O00000o2).O00000o0();
                    Object obj2 = this.O0000Oo0;
                    if (obj2 == null) {
                        str = null;
                    } else {
                        Class<?> cls = obj2.getClass();
                        while (true) {
                            if (cls != null) {
                                jeu = (jeu) O00000o02.f1799O000000o.get(cls);
                                if (jeu != null || (jeu = O00000o02.O000000o(cls)) != null) {
                                    break;
                                }
                                cls = cls.getSuperclass();
                            } else {
                                jeu = jev.O00000Oo;
                                break;
                            }
                        }
                        str = jeu.O000000o(obj2);
                    }
                    this.renderedMessage = str;
                } else {
                    this.renderedMessage = this.O0000Oo0.toString();
                }
            }
        }
        if (this.ndcLookupRequired) {
            this.ndcLookupRequired = false;
            this.ndc = jeh.O000000o();
        }
        if (this.mdcCopyLookupRequired) {
            this.mdcCopyLookupRequired = false;
            Hashtable O000000o2 = jeg.O000000o();
            if (O000000o2 != null) {
                this.mdcCopy = (Hashtable) O000000o2.clone();
            }
        }
        ThrowableInformation throwableInformation = this.throwableInfo;
        if (throwableInformation != null) {
            throwableInformation.O000000o();
        }
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.O00000Oo.O0000Oo);
        Class<?> cls2 = this.O00000Oo.getClass();
        Class<?> cls3 = O00000oo;
        if (cls3 == null) {
            cls3 = O000000o("org.apache.log4j.Level");
            O00000oo = cls3;
        }
        if (cls2 == cls3) {
            objectOutputStream.writeObject(null);
        } else {
            objectOutputStream.writeObject(cls2.getName());
        }
    }
}

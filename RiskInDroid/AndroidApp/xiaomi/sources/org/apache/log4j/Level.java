package org.apache.log4j;

import _m_j.jej;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Level extends jej implements Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Level f15435O000000o = new Level(Integer.MAX_VALUE, "OFF", 0);
    public static final Level O00000Oo = new Level(50000, "FATAL", 0);
    public static final Level O00000o = new Level(30000, "WARN", 4);
    public static final Level O00000o0 = new Level(40000, "ERROR", 3);
    public static final Level O00000oO = new Level(20000, "INFO", 6);
    public static final Level O00000oo = new Level(C.MSG_CUSTOM_BASE, "DEBUG", 7);
    public static final Level O0000O0o = new Level(5000, "TRACE", 7);
    public static final Level O0000OOo = new Level(Integer.MIN_VALUE, "ALL", 7);
    static Class O0000Oo0 = null;
    static final long serialVersionUID = 3491141966387921974L;

    public Level(int i, String str, int i2) {
        super(i, str, i2);
    }

    public static Level O000000o(int i) {
        Level level = O00000oo;
        if (i == Integer.MIN_VALUE) {
            return O0000OOo;
        }
        if (i == 5000) {
            return O0000O0o;
        }
        if (i == 10000) {
            return level;
        }
        if (i == 20000) {
            return O00000oO;
        }
        if (i == 30000) {
            return O00000o;
        }
        if (i == 40000) {
            return O00000o0;
        }
        if (i != 50000) {
            return i != Integer.MAX_VALUE ? level : f15435O000000o;
        }
        return O00000Oo;
    }

    public static Level O000000o(String str, Level level) {
        if (str == null) {
            return level;
        }
        String upperCase = str.toUpperCase();
        if (upperCase.equals("ALL")) {
            return O0000OOo;
        }
        if (upperCase.equals("DEBUG")) {
            return O00000oo;
        }
        if (upperCase.equals("INFO")) {
            return O00000oO;
        }
        if (upperCase.equals("WARN")) {
            return O00000o;
        }
        if (upperCase.equals("ERROR")) {
            return O00000o0;
        }
        if (upperCase.equals("FATAL")) {
            return O00000Oo;
        }
        if (upperCase.equals("OFF")) {
            return f15435O000000o;
        }
        if (upperCase.equals("TRACE")) {
            return O0000O0o;
        }
        return upperCase.equals("İNFO") ? O00000oO : level;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.O0000Oo = objectInputStream.readInt();
        this.O0000Ooo = objectInputStream.readInt();
        this.O0000OoO = objectInputStream.readUTF();
        if (this.O0000OoO == null) {
            this.O0000OoO = "";
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.O0000Oo);
        objectOutputStream.writeInt(this.O0000Ooo);
        objectOutputStream.writeUTF(this.O0000OoO);
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private Object readResolve() throws ObjectStreamException {
        Class<?> cls = getClass();
        Class<?> cls2 = O0000Oo0;
        if (cls2 == null) {
            cls2 = O000000o("org.apache.log4j.Level");
            O0000Oo0 = cls2;
        }
        return cls == cls2 ? O000000o(this.O0000Oo) : this;
    }
}

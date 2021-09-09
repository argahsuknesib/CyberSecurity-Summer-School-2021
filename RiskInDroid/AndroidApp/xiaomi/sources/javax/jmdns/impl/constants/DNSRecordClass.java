package javax.jmdns.impl.constants;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum DNSRecordClass {
    CLASS_UNKNOWN("?", 0),
    CLASS_IN("in", 1),
    CLASS_CS("cs", 2),
    CLASS_CH("ch", 3),
    CLASS_HS("hs", 4),
    CLASS_NONE("none", 254),
    CLASS_ANY("any", 255);
    
    private static Logger logger = Logger.getLogger(DNSRecordClass.class.getName());
    private final String _externalName;
    private final int _index;

    private DNSRecordClass(String str, int i) {
        this._externalName = str;
        this._index = i;
    }

    public final String externalName() {
        return this._externalName;
    }

    public final int indexValue() {
        return this._index;
    }

    public final boolean isUnique(int i) {
        return (this == CLASS_UNKNOWN || (i & 32768) == 0) ? false : true;
    }

    public static DNSRecordClass classForName(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            for (DNSRecordClass dNSRecordClass : values()) {
                if (dNSRecordClass._externalName.equals(lowerCase)) {
                    return dNSRecordClass;
                }
            }
        }
        logger.log(Level.WARNING, "Could not find record class for name: ".concat(String.valueOf(str)));
        return CLASS_UNKNOWN;
    }

    public static DNSRecordClass classForIndex(int i) {
        int i2 = i & 32767;
        for (DNSRecordClass dNSRecordClass : values()) {
            if (dNSRecordClass._index == i2) {
                return dNSRecordClass;
            }
        }
        logger.log(Level.WARNING, "Could not find record class for index: ".concat(String.valueOf(i)));
        return CLASS_UNKNOWN;
    }

    public final String toString() {
        return name() + " index " + indexValue();
    }
}

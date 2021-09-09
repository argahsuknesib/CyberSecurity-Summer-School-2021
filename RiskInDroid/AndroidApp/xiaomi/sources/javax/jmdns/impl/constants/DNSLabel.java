package javax.jmdns.impl.constants;

import android.support.v4.app.NotificationCompat;

public enum DNSLabel {
    Unknown("", NotificationCompat.FLAG_HIGH_PRIORITY),
    Standard("standard label", 0),
    Compressed("compressed label", 192),
    Extended("extended label", 64);
    
    private final String _externalName;
    private final int _index;

    public static int labelValue(int i) {
        return i & 63;
    }

    private DNSLabel(String str, int i) {
        this._externalName = str;
        this._index = i;
    }

    public final String externalName() {
        return this._externalName;
    }

    public final int indexValue() {
        return this._index;
    }

    public static DNSLabel labelForByte(int i) {
        int i2 = i & 192;
        for (DNSLabel dNSLabel : values()) {
            if (dNSLabel._index == i2) {
                return dNSLabel;
            }
        }
        return Unknown;
    }

    public final String toString() {
        return name() + " index " + indexValue();
    }
}

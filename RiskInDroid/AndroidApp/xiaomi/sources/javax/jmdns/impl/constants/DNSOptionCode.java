package javax.jmdns.impl.constants;

public enum DNSOptionCode {
    Unknown("Unknown", 65535),
    LLQ("LLQ", 1),
    UL("UL", 2),
    NSID("NSID", 3),
    Owner("Owner", 4);
    
    private final String _externalName;
    private final int _index;

    private DNSOptionCode(String str, int i) {
        this._externalName = str;
        this._index = i;
    }

    public final String externalName() {
        return this._externalName;
    }

    public final int indexValue() {
        return this._index;
    }

    public static DNSOptionCode resultCodeForFlags(int i) {
        for (DNSOptionCode dNSOptionCode : values()) {
            if (dNSOptionCode._index == i) {
                return dNSOptionCode;
            }
        }
        return Unknown;
    }

    public final String toString() {
        return name() + " index " + indexValue();
    }
}

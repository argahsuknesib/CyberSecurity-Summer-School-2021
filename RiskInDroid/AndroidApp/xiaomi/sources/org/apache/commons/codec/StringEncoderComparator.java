package org.apache.commons.codec;

import java.util.Comparator;

public class StringEncoderComparator implements Comparator {
    private final StringEncoder stringEncoder;

    public StringEncoderComparator() {
        this.stringEncoder = null;
    }

    public StringEncoderComparator(StringEncoder stringEncoder2) {
        this.stringEncoder = stringEncoder2;
    }

    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.stringEncoder.encode(obj)).compareTo((Comparable) this.stringEncoder.encode(obj2));
        } catch (EncoderException unused) {
            return 0;
        }
    }
}

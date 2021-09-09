package com.drew.metadata.jpeg;

import java.io.Serializable;

public class JpegComponent implements Serializable {
    private static final long serialVersionUID = 61121257899091914L;
    private final int _componentId;
    private final int _quantizationTableNumber;
    private final int _samplingFactorByte;

    public JpegComponent(int i, int i2, int i3) {
        this._componentId = i;
        this._samplingFactorByte = i2;
        this._quantizationTableNumber = i3;
    }

    public final String O000000o() {
        int i = this._componentId;
        if (i == 1) {
            return "Y";
        }
        if (i == 2) {
            return "Cb";
        }
        if (i == 3) {
            return "Cr";
        }
        if (i == 4) {
            return "I";
        }
        if (i == 5) {
            return "Q";
        }
        return String.format("Unknown (%s)", Integer.valueOf(i));
    }

    public String toString() {
        return String.format("Quantization table %d, Sampling factors %d horiz/%d vert", Integer.valueOf(this._quantizationTableNumber), Integer.valueOf((this._samplingFactorByte >> 4) & 15), Integer.valueOf(this._samplingFactorByte & 15));
    }
}

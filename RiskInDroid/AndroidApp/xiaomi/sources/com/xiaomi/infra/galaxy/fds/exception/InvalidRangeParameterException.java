package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class InvalidRangeParameterException extends GalaxyFDSException {
    private final long[] range;

    public InvalidRangeParameterException(long[] jArr) {
        super(rangeToStr(jArr), null);
        this.range = jArr;
    }

    public FDSError getError() {
        return FDSError.InvalidRequestRange;
    }

    private static String rangeToStr(long[] jArr) {
        if (jArr == null) {
            return "range parameter is null";
        }
        if (jArr.length == 1) {
            return "[ " + jArr[0] + "]";
        } else if (jArr.length == 2) {
            return "[" + jArr[0] + ", " + jArr[1] + "]";
        } else {
            return "[" + jArr[0] + " " + jArr[1] + " " + jArr[2] + "...]";
        }
    }

    public String toString() {
        String galaxyFDSException = super.toString();
        if (this.range == null) {
            return galaxyFDSException;
        }
        return galaxyFDSException + rangeToStr(this.range) + " in request";
    }
}

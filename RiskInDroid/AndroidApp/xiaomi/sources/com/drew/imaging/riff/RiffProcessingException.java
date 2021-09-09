package com.drew.imaging.riff;

import com.drew.imaging.ImageProcessingException;

public class RiffProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -1658134596321487960L;

    public RiffProcessingException(String str) {
        super(str);
    }

    public RiffProcessingException(String str, Throwable th) {
        super(str, th);
    }

    public RiffProcessingException(Throwable th) {
        super(th);
    }
}

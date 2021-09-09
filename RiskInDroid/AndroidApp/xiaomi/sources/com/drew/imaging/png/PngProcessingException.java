package com.drew.imaging.png;

import com.drew.imaging.ImageProcessingException;

public class PngProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -687991554932005033L;

    public PngProcessingException(String str) {
        super(str);
    }

    public PngProcessingException(String str, Throwable th) {
        super(str, th);
    }

    public PngProcessingException(Throwable th) {
        super(th);
    }
}

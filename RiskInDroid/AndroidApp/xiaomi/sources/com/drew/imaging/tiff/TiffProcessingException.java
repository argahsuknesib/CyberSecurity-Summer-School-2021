package com.drew.imaging.tiff;

import com.drew.imaging.ImageProcessingException;

public class TiffProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -1658134119488001891L;

    public TiffProcessingException(String str) {
        super(str);
    }

    public TiffProcessingException(String str, Throwable th) {
        super(str, th);
    }

    public TiffProcessingException(Throwable th) {
        super(th);
    }
}

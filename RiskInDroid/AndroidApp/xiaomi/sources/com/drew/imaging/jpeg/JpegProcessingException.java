package com.drew.imaging.jpeg;

import com.drew.imaging.ImageProcessingException;

public class JpegProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -7870179776125450158L;

    public JpegProcessingException(String str) {
        super(str);
    }

    public JpegProcessingException(String str, Throwable th) {
        super(str, th);
    }

    public JpegProcessingException(Throwable th) {
        super(th);
    }
}

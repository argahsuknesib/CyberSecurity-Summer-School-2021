package com.shockwave.pdfium;

import java.io.IOException;

public class PdfPasswordException extends IOException {
    public PdfPasswordException() {
    }

    public PdfPasswordException(String str) {
        super(str);
    }
}

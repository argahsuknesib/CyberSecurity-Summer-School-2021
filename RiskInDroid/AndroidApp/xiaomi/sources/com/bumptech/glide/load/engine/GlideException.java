package com.bumptech.glide.load.engine;

public final class GlideException extends Exception {
    private static final long serialVersionUID = 1;
    private String detailMessage;

    public GlideException(String str) {
        super(str);
        this.detailMessage = str;
    }

    public final String getDetailMessage() {
        return this.detailMessage;
    }
}

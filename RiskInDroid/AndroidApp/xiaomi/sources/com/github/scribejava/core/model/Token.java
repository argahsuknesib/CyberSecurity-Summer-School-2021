package com.github.scribejava.core.model;

import java.io.Serializable;

public abstract class Token implements Serializable {
    private static final long serialVersionUID = -8409640649946468092L;
    public final String rawResponse;

    protected Token(String str) {
        this.rawResponse = str;
    }

    public final String O00000o0() {
        String str = this.rawResponse;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("This token object was not constructed by ScribeJava and does not have a rawResponse");
    }
}

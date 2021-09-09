package com.luajava;

public class LuaException extends Exception {
    private static final long serialVersionUID = 1;

    public LuaException(String str) {
        super(str);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LuaException(Exception exc) {
        super(exc.getCause() != null ? exc.getCause() : exc);
    }
}

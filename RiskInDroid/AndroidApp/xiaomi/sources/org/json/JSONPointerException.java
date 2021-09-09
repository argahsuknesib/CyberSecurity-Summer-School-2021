package org.json;

public class JSONPointerException extends JSONException {
    private static final long serialVersionUID = 8872944667561856751L;

    public JSONPointerException(String str) {
        super(str);
    }

    public JSONPointerException(String str, Throwable th) {
        super(str, th);
    }
}

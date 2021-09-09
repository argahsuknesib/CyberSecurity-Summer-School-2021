package org.apache.commons.httpclient;

public class InvalidRedirectLocationException extends RedirectException {
    private final String location;

    public InvalidRedirectLocationException(String str, String str2) {
        super(str);
        this.location = str2;
    }

    public InvalidRedirectLocationException(String str, String str2, Throwable th) {
        super(str, th);
        this.location = str2;
    }

    public String getLocation() {
        return this.location;
    }
}

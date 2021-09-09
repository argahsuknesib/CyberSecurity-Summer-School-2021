package org.apache.commons.compress;

import java.io.IOException;

public class PasswordRequiredException extends IOException {
    private static final long serialVersionUID = 1391070005491684483L;

    public PasswordRequiredException(String str) {
        super("Cannot read encrypted content from " + str + " without a password.");
    }
}

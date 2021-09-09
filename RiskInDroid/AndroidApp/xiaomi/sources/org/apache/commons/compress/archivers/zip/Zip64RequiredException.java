package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

public class Zip64RequiredException extends ZipException {
    private static final long serialVersionUID = 20110809;

    public Zip64RequiredException(String str) {
        super(str);
    }
}

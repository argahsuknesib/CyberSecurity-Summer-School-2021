package org.apache.commons.compress.archivers.dump;

public class UnsupportedCompressionAlgorithmException extends DumpArchiveException {
    private static final long serialVersionUID = 1;

    public UnsupportedCompressionAlgorithmException() {
        super("this file uses an unsupported compression algorithm.");
    }

    public UnsupportedCompressionAlgorithmException(String str) {
        super("this file uses an unsupported compression algorithm: " + str + ".");
    }
}

package jcifs.dcerpc.ndr;

import java.io.IOException;

public class NdrException extends IOException {
    public NdrException(String str) {
        super(str);
    }
}

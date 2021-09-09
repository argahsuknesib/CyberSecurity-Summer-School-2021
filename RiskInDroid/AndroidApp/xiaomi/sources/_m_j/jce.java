package _m_j;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jce extends PKWareExtraHeader {
    public jce() {
        super(new ZipShort(20));
    }
}

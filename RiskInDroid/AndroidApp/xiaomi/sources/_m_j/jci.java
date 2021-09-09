package _m_j;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jci extends PKWareExtraHeader {
    public jci() {
        super(new ZipShort(25));
    }
}

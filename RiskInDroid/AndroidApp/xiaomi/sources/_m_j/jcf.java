package _m_j;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jcf extends PKWareExtraHeader {
    public jcf() {
        super(new ZipShort(21));
    }
}

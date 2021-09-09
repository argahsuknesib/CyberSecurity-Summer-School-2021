package _m_j;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jcg extends PKWareExtraHeader {
    public jcg() {
        super(new ZipShort(22));
    }
}

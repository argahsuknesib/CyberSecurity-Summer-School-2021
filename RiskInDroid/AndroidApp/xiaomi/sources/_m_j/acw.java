package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.metadata.jpeg.HuffmanTablesDirectory;
import java.io.IOException;
import java.util.Collections;

public final class acw implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.DHT);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        for (byte[] xlVar : iterable) {
            xl xlVar2 = new xl(xlVar);
            HuffmanTablesDirectory huffmanTablesDirectory = (HuffmanTablesDirectory) xuVar.O000000o(HuffmanTablesDirectory.class);
            if (huffmanTablesDirectory == null) {
                huffmanTablesDirectory = new HuffmanTablesDirectory();
                xuVar.O000000o(huffmanTablesDirectory);
            }
            while (xlVar2.O00000o0() > 0) {
                try {
                    byte O00000Oo = xlVar2.O00000Oo();
                    HuffmanTablesDirectory.HuffmanTable.HuffmanTableClass typeOf = HuffmanTablesDirectory.HuffmanTable.HuffmanTableClass.typeOf((O00000Oo & 240) >> 4);
                    byte b = O00000Oo & 15;
                    byte[] O000000o2 = O000000o(xlVar2, 16);
                    int i = 0;
                    for (byte b2 : O000000o2) {
                        i += b2 & 255;
                    }
                    huffmanTablesDirectory.O00000oo().add(new HuffmanTablesDirectory.HuffmanTable(typeOf, b, O000000o2, O000000o(xlVar2, i)));
                } catch (IOException e) {
                    huffmanTablesDirectory.O000000o(e.getMessage());
                }
            }
            huffmanTablesDirectory.O000000o(1, huffmanTablesDirectory.O00000oo().size());
        }
    }

    private static byte[] O000000o(xm xmVar, int i) throws IOException {
        byte O00000Oo;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            byte O00000Oo2 = xmVar.O00000Oo();
            if ((O00000Oo2 & 255) != 255 || (O00000Oo = xmVar.O00000Oo()) == 0) {
                bArr[i2] = O00000Oo2;
                i2++;
            } else {
                throw new IOException("Marker " + JpegSegmentType.fromByte(O00000Oo) + " found inside DHT segment");
            }
        }
        return bArr;
    }
}

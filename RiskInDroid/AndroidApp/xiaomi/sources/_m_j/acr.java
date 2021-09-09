package _m_j;

import com.drew.metadata.jpeg.HuffmanTablesDirectory;

public final class acr extends xx<HuffmanTablesDirectory> {
    public acr(HuffmanTablesDirectory huffmanTablesDirectory) {
        super(huffmanTablesDirectory);
    }

    public final String O000000o(int i) {
        if (i != 1) {
            return super.O000000o(i);
        }
        Integer O00000o0 = ((HuffmanTablesDirectory) this.f2602O000000o).O00000o0(1);
        if (O00000o0 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(O00000o0);
        sb.append(O00000o0.intValue() == 1 ? " Huffman table" : " Huffman tables");
        return sb.toString();
    }
}

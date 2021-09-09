package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class AI013x0xDecoder extends AI01weightDecoder {
    AI013x0xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 60) {
            StringBuilder sb = new StringBuilder();
            encodeCompressedGtin(sb, 5);
            encodeCompressedWeight(sb, 45, 15);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}

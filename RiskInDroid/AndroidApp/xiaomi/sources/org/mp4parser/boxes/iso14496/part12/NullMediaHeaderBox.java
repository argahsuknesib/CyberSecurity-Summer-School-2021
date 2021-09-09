package org.mp4parser.boxes.iso14496.part12;

import java.nio.ByteBuffer;

public class NullMediaHeaderBox extends AbstractMediaHeaderBox {
    public long getContentSize() {
        return 4;
    }

    public NullMediaHeaderBox() {
        super("nmhd");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
    }
}

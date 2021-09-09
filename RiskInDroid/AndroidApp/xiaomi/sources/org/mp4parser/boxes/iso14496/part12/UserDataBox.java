package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgz;
import _m_j.jko;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class UserDataBox extends jko {
    public UserDataBox() {
        super("udta");
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        super.parse(readableByteChannel, byteBuffer, j, jgz);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        super.getBox(writableByteChannel);
    }
}

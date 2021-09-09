package _m_j;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public interface jgy {
    void getBox(WritableByteChannel writableByteChannel) throws IOException;

    long getSize();

    String getType();
}

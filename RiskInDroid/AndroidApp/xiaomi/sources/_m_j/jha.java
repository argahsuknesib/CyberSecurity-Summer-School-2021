package _m_j;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import java.util.List;

public interface jha {
    List<jgy> getBoxes();

    <T extends jgy> List<T> getBoxes(Class<T> cls);

    <T extends jgy> List<T> getBoxes(Class<T> cls, boolean z);

    void writeContainer(WritableByteChannel writableByteChannel) throws IOException;
}

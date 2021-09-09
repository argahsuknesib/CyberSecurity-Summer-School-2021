package _m_j;

import java.io.Closeable;
import org.mp4parser.boxes.iso14496.part12.SampleDescriptionBox;

public interface jjk extends Closeable {
    void addTrackExtension(jjl jjl);

    String getHandler();

    String getLanguage();

    SampleDescriptionBox getSampleDescriptionBox();

    long getTimescale();

    <T extends jjl> T getTrackExtension(Class<T> cls);

    void setSampleSink(jkk jkk);
}

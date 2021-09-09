package _m_j;

import java.util.HashMap;
import org.mp4parser.boxes.iso14496.part12.TrackHeaderBox;

public abstract class jjt implements jjk {
    protected jkk sampleSink;
    protected TrackHeaderBox tkhd = new TrackHeaderBox();
    protected HashMap<Class<? extends jjl>, jjl> trackExtensions = new HashMap<>();

    public jjt() {
        this.tkhd.setTrackId(1);
    }

    public void setSampleSink(jkk jkk) {
        this.sampleSink = jkk;
    }

    public <T extends jjl> T getTrackExtension(Class<T> cls) {
        return (jjl) this.trackExtensions.get(cls);
    }

    public void addTrackExtension(jjl jjl) {
        this.trackExtensions.put(jjl.getClass(), jjl);
    }

    public void removeTrackExtension(Class<? extends jjl> cls) {
        this.trackExtensions.remove(cls);
    }
}

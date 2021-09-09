package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jgx implements jha {
    private List<jgy> boxes = new ArrayList();

    public jgx() {
    }

    public jgx(List<jgy> list) {
        this.boxes = list;
    }

    public List<jgy> getBoxes() {
        return this.boxes;
    }

    public void setBoxes(List<? extends jgy> list) {
        this.boxes = new ArrayList(list);
    }

    /* access modifiers changed from: protected */
    public long getContainerSize() {
        long j = 0;
        for (int i = 0; i < getBoxes().size(); i++) {
            j += this.boxes.get(i).getSize();
        }
        return j;
    }

    public <T extends jgy> List<T> getBoxes(Class<T> cls) {
        ArrayList arrayList = null;
        jgy jgy = null;
        for (jgy next : getBoxes()) {
            if (cls.isInstance(next)) {
                if (jgy == null) {
                    jgy = next;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                        arrayList.add(jgy);
                    }
                    arrayList.add(next);
                }
            }
        }
        if (arrayList != null) {
            return arrayList;
        }
        if (jgy != null) {
            return Collections.singletonList(jgy);
        }
        return Collections.emptyList();
    }

    public <T extends jgy> List<T> getBoxes(Class<T> cls, boolean z) {
        ArrayList arrayList = new ArrayList(2);
        List<jgy> boxes2 = getBoxes();
        for (int i = 0; i < boxes2.size(); i++) {
            jgy jgy = boxes2.get(i);
            if (cls.isInstance(jgy)) {
                arrayList.add(jgy);
            }
            if (z && (jgy instanceof jha)) {
                arrayList.addAll(((jha) jgy).getBoxes(cls, z));
            }
        }
        return arrayList;
    }

    public void addBox(jgy jgy) {
        if (jgy != null) {
            this.boxes = new ArrayList(getBoxes());
            this.boxes.add(jgy);
        }
    }

    public void initContainer(ReadableByteChannel readableByteChannel, long j, jgz jgz) throws IOException {
        long j2 = 0;
        while (true) {
            if (j < 0 || j2 < j) {
                try {
                    jhd O000000o2 = jgz.O000000o(readableByteChannel, this instanceof jhd ? ((jhd) this).getType() : null);
                    this.boxes.add(O000000o2);
                    j2 += O000000o2.getSize();
                } catch (EOFException e) {
                    if (j >= 0) {
                        throw e;
                    }
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.boxes.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.boxes.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public final void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        for (jgy box : getBoxes()) {
            box.getBox(writableByteChannel);
        }
    }
}

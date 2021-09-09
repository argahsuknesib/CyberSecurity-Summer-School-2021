package org.mp4parser.boxes.samplegrouping;

import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;

public class TemporalLevelEntry extends GroupEntry {
    private boolean levelIndependentlyDecodable;
    private short reserved;

    public String getType() {
        return "tele";
    }

    public boolean isLevelIndependentlyDecodable() {
        return this.levelIndependentlyDecodable;
    }

    public void setLevelIndependentlyDecodable(boolean z) {
        this.levelIndependentlyDecodable = z;
    }

    public void parse(ByteBuffer byteBuffer) {
        this.levelIndependentlyDecodable = (byteBuffer.get() & 128) == 128;
    }

    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) (this.levelIndependentlyDecodable ? NotificationCompat.FLAG_HIGH_PRIORITY : 0));
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TemporalLevelEntry temporalLevelEntry = (TemporalLevelEntry) obj;
        return this.levelIndependentlyDecodable == temporalLevelEntry.levelIndependentlyDecodable && this.reserved == temporalLevelEntry.reserved;
    }

    public int hashCode() {
        return ((this.levelIndependentlyDecodable ? 1 : 0) * true) + this.reserved;
    }

    public String toString() {
        return "TemporalLevelEntry" + "{levelIndependentlyDecodable=" + this.levelIndependentlyDecodable + '}';
    }
}

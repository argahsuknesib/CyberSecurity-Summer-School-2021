package org.mp4parser.boxes.microsoft;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import org.mp4parser.boxes.iso23001.part7.AbstractTrackEncryptionBox;

public class PiffTrackEncryptionBox extends AbstractTrackEncryptionBox {
    private static final jhf.O000000o ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("PiffTrackEncryptionBox.java", PiffTrackEncryptionBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getFlags", "org.mp4parser.boxes.microsoft.PiffTrackEncryptionBox", "", "", "", "int"), 29);
    }

    public PiffTrackEncryptionBox() {
        super("uuid");
    }

    public byte[] getUserType() {
        return new byte[]{-119, 116, -37, -50, 123, -25, 76, 81, -124, -7, 113, 72, -7, -120, 37, 84};
    }

    public int getFlags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return 0;
    }
}

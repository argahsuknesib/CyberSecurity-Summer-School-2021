package _m_j;

import com.google.android.gms.vision.Frame;
import java.nio.ByteBuffer;

public final class jmv {
    public static jmu O000000o(byte[] bArr, int i, int i2, int i3) {
        Frame.Builder builder = new Frame.Builder();
        builder.setImageData(ByteBuffer.wrap(bArr), i, i2, 17);
        if (i3 == 90) {
            builder.setRotation(1);
        } else if (i3 == 180) {
            builder.setRotation(2);
        } else if (i3 != 270) {
            builder.setRotation(0);
        } else {
            builder.setRotation(3);
        }
        return new jmu(builder.build(), new jmp(i, i2, i3));
    }
}

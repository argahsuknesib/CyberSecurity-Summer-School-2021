package _m_j;

import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.io.OutputStream;

public class fhq {

    /* renamed from: O000000o  reason: collision with root package name */
    public OutputStream f16387O000000o;

    public fhq(OutputStream outputStream) {
        this.f16387O000000o = outputStream;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) throws IOException {
        if (i > 127) {
            int i2 = i;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            O00000Oo((byte) (i3 | NotificationCompat.FLAG_HIGH_PRIORITY));
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                O00000Oo((byte) (i >> i4));
            }
            return;
        }
        O00000Oo((byte) i);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i) throws IOException {
        this.f16387O000000o.write(i);
    }

    public void O000000o(fhm fhm) throws IOException {
        if (fhm != null) {
            fhm.O000000o().O000000o(this);
            return;
        }
        throw new IOException("null object detected");
    }

    /* access modifiers changed from: package-private */
    public fhq O000000o() {
        return new fht(this.f16387O000000o);
    }
}

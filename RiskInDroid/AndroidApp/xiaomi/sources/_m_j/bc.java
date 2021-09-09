package _m_j;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import java.io.Writer;

@Deprecated
public final class bc extends Writer {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f12846O000000o;
    private StringBuilder O00000Oo = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);

    public bc(String str) {
        this.f12846O000000o = str;
    }

    public final void close() {
        O000000o();
    }

    public final void flush() {
        O000000o();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                O000000o();
            } else {
                this.O00000Oo.append(c);
            }
        }
    }

    private void O000000o() {
        if (this.O00000Oo.length() > 0) {
            Log.d(this.f12846O000000o, this.O00000Oo.toString());
            StringBuilder sb = this.O00000Oo;
            sb.delete(0, sb.length());
        }
    }
}

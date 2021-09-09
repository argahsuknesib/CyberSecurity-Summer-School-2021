package _m_j;

import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xiaomi.zxing.qrcode.decoder.Mode;

public final class iho {

    /* renamed from: O000000o  reason: collision with root package name */
    Mode f1301O000000o;
    ErrorCorrectionLevel O00000Oo;
    int O00000o = -1;
    ihd O00000o0;
    public ihk O00000oO;

    public final String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f1301O000000o);
        sb.append("\n ecLevel: ");
        sb.append(this.O00000Oo);
        sb.append("\n version: ");
        sb.append(this.O00000o0);
        sb.append("\n maskPattern: ");
        sb.append(this.O00000o);
        if (this.O00000oO == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.O00000oO);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}

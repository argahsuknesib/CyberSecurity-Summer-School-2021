package _m_j;

import androidx.media.AudioAttributesCompat;
import java.util.Arrays;

public final class fw implements fu {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17295O000000o = 0;
    public int O00000Oo = 0;
    public int O00000o = -1;
    public int O00000o0 = 0;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0), Integer.valueOf(this.f17295O000000o), Integer.valueOf(this.O00000o)});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof fw)) {
            return false;
        }
        fw fwVar = (fw) obj;
        if (this.O00000Oo == fwVar.O00000Oo) {
            int i = this.O00000o0;
            int i2 = fwVar.O00000o0;
            int i3 = fwVar.O00000o;
            if (i3 == -1) {
                i3 = AudioAttributesCompat.O000000o(i2, fwVar.f17295O000000o);
            }
            if (i3 == 6) {
                i2 |= 4;
            } else if (i3 == 7) {
                i2 |= 1;
            }
            if (i == (i2 & 273) && this.f17295O000000o == fwVar.f17295O000000o && this.O00000o == fwVar.O00000o) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.O00000o != -1) {
            sb.append(" stream=");
            sb.append(this.O00000o);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.O000000o(this.f17295O000000o));
        sb.append(" content=");
        sb.append(this.O00000Oo);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.O00000o0).toUpperCase());
        return sb.toString();
    }
}

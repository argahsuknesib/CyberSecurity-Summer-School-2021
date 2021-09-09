package _m_j;

import com.iheartradio.m3u8.data.EncryptionMethod;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class bch {

    /* renamed from: O000000o  reason: collision with root package name */
    public final EncryptionMethod f12852O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final List<Byte> O00000o0;
    public final List<Integer> O00000oO;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public EncryptionMethod f12853O000000o;
        public String O00000Oo;
        public String O00000o;
        public List<Byte> O00000o0;
        public List<Integer> O00000oO;
    }

    public /* synthetic */ bch(EncryptionMethod encryptionMethod, String str, List list, String str2, List list2, byte b) {
        this(encryptionMethod, str, list, str2, list2);
    }

    private bch(EncryptionMethod encryptionMethod, String str, List<Byte> list, String str2, List<Integer> list2) {
        List<Byte> list3;
        this.f12852O000000o = encryptionMethod;
        this.O00000Oo = str;
        List<Integer> list4 = null;
        if (list == null) {
            list3 = null;
        } else {
            list3 = Collections.unmodifiableList(list);
        }
        this.O00000o0 = list3;
        this.O00000o = str2;
        this.O00000oO = list2 != null ? Collections.unmodifiableList(list2) : list4;
    }

    public final int hashCode() {
        return Objects.hash(this.O00000o0, this.O00000o, this.O00000oO, this.f12852O000000o, this.O00000Oo);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bch)) {
            return false;
        }
        bch bch = (bch) obj;
        if (!Objects.equals(this.O00000o0, bch.O00000o0) || !Objects.equals(this.O00000o, bch.O00000o) || !Objects.equals(this.O00000oO, bch.O00000oO) || !Objects.equals(this.f12852O000000o, bch.f12852O000000o) || !Objects.equals(this.O00000Oo, bch.O00000Oo)) {
            return false;
        }
        return true;
    }
}

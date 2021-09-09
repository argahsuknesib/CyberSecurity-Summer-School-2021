package _m_j;

import com.iheartradio.m3u8.data.MediaType;
import java.util.List;
import java.util.Objects;

public final class bcl {

    /* renamed from: O000000o  reason: collision with root package name */
    public final MediaType f12858O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final boolean O0000O0o;
    public final boolean O0000OOo;
    public final String O0000Oo;
    public final boolean O0000Oo0;
    public final List<String> O0000OoO;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public MediaType f12859O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public boolean O0000O0o;
        public boolean O0000OOo;
        public String O0000Oo;
        public boolean O0000Oo0;
        public List<String> O0000OoO;
    }

    public /* synthetic */ bcl(MediaType mediaType, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, List list, byte b) {
        this(mediaType, str, str2, str3, str4, str5, z, z2, z3, str6, list);
    }

    private bcl(MediaType mediaType, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, List<String> list) {
        this.f12858O000000o = mediaType;
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = str3;
        this.O00000oO = str4;
        this.O00000oo = str5;
        this.O0000O0o = z;
        this.O0000OOo = z2;
        this.O0000Oo0 = z3;
        this.O0000Oo = str6;
        this.O0000OoO = bcg.O000000o(list);
    }

    public final boolean O000000o() {
        String str = this.O00000Oo;
        return str != null && !str.isEmpty();
    }

    public final int hashCode() {
        return Objects.hash(this.O00000oO, Boolean.valueOf(this.O0000OOo), this.O0000OoO, Boolean.valueOf(this.O0000O0o), Boolean.valueOf(this.O0000Oo0), this.O00000o0, this.O0000Oo, this.O00000o, this.O00000oo, this.f12858O000000o, this.O00000Oo);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bcl)) {
            return false;
        }
        bcl bcl = (bcl) obj;
        if (this.f12858O000000o != bcl.f12858O000000o || !Objects.equals(this.O00000Oo, bcl.O00000Oo) || !Objects.equals(this.O00000o0, bcl.O00000o0) || !Objects.equals(this.O00000o, bcl.O00000o) || !Objects.equals(this.O00000oO, bcl.O00000oO) || !Objects.equals(this.O00000oo, bcl.O00000oo) || this.O0000O0o != bcl.O0000O0o || this.O0000OOo != bcl.O0000OOo || this.O0000Oo0 != bcl.O0000Oo0 || !Objects.equals(this.O0000Oo, bcl.O0000Oo) || !Objects.equals(this.O0000OoO, bcl.O0000OoO)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "MediaData [mType=" + this.f12858O000000o + ", mUri=" + this.O00000Oo + ", mGroupId=" + this.O00000o0 + ", mLanguage=" + this.O00000o + ", mAssociatedLanguage=" + this.O00000oO + ", mName=" + this.O00000oo + ", mDefault=" + this.O0000O0o + ", mAutoSelect=" + this.O0000OOo + ", mForced=" + this.O0000Oo0 + ", mInStreamId=" + this.O0000Oo + ", mCharacteristics=" + this.O0000OoO + "]";
    }
}

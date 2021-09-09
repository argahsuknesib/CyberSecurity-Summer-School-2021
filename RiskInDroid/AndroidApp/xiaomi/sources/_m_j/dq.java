package _m_j;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

final class dq extends dn {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f14847O000000o;
    private Uri O00000Oo;

    dq(Context context, Uri uri) {
        super(null);
        this.f14847O000000o = context;
        this.O00000Oo = uri;
    }

    public final dn O000000o(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public final Uri O000000o() {
        return this.O00000Oo;
    }

    public final String O00000Oo() {
        return C0119do.O000000o(this.f14847O000000o, this.O00000Oo, "_display_name");
    }

    public final String O00000o0() {
        return C0119do.O000000o(this.f14847O000000o, this.O00000Oo);
    }

    public final long O00000o() {
        return C0119do.O00000Oo(this.f14847O000000o, this.O00000Oo, "_size");
    }

    public final boolean O00000oO() {
        try {
            return DocumentsContract.deleteDocument(this.f14847O000000o.getContentResolver(), this.O00000Oo);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean O00000oo() {
        return C0119do.O00000Oo(this.f14847O000000o, this.O00000Oo);
    }

    public final dn[] O0000O0o() {
        throw new UnsupportedOperationException();
    }
}

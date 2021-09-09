package _m_j;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

public final class dr extends dn {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f14862O000000o;
    private Uri O00000Oo;

    public dr(dn dnVar, Context context, Uri uri) {
        super(dnVar);
        this.f14862O000000o = context;
        this.O00000Oo = uri;
    }

    public final dn O000000o(String str, String str2) {
        Uri O000000o2 = O000000o(this.f14862O000000o, this.O00000Oo, str, str2);
        if (O000000o2 != null) {
            return new dr(this, this.f14862O000000o, O000000o2);
        }
        return null;
    }

    private static Uri O000000o(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Uri O000000o() {
        return this.O00000Oo;
    }

    public final String O00000Oo() {
        return C0119do.O000000o(this.f14862O000000o, this.O00000Oo, "_display_name");
    }

    public final String O00000o0() {
        return C0119do.O000000o(this.f14862O000000o, this.O00000Oo);
    }

    public final long O00000o() {
        return C0119do.O00000Oo(this.f14862O000000o, this.O00000Oo, "_size");
    }

    public final boolean O00000oO() {
        try {
            return DocumentsContract.deleteDocument(this.f14862O000000o.getContentResolver(), this.O00000Oo);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean O00000oo() {
        return C0119do.O00000Oo(this.f14862O000000o, this.O00000Oo);
    }

    public final dn[] O0000O0o() {
        ContentResolver contentResolver = this.f14862O000000o.getContentResolver();
        Uri uri = this.O00000Oo;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
            while (cursor.moveToNext()) {
                arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.O00000Oo, cursor.getString(0)));
            }
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: ".concat(String.valueOf(e)));
        } catch (Throwable th) {
            O000000o((AutoCloseable) null);
            throw th;
        }
        O000000o(cursor);
        Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
        dn[] dnVarArr = new dn[uriArr.length];
        for (int i = 0; i < uriArr.length; i++) {
            dnVarArr[i] = new dr(this, this.f14862O000000o, uriArr[i]);
        }
        return dnVarArr;
    }

    private static void O000000o(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}

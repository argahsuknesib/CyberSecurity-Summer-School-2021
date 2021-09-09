package _m_j;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

public final class f {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: android.os.CancellationSignal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: android.os.CancellationSignal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: android.os.CancellationSignal} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static Cursor O000000o(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, al alVar) {
        CancellationSignal cancellationSignal;
        if (Build.VERSION.SDK_INT >= 16) {
            if (alVar != null) {
                try {
                    cancellationSignal = alVar.O00000Oo();
                } catch (Exception e) {
                    if (e instanceof OperationCanceledException) {
                        throw new androidx.core.os.OperationCanceledException();
                    }
                    throw e;
                }
            } else {
                cancellationSignal = null;
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } else if (alVar == null || !alVar.O000000o()) {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } else {
            throw new androidx.core.os.OperationCanceledException();
        }
    }
}

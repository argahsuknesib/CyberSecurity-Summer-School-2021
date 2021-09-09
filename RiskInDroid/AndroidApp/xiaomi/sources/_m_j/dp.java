package _m_j;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

final class dp extends dn {

    /* renamed from: O000000o  reason: collision with root package name */
    private File f14824O000000o;

    dp(dn dnVar, File file) {
        super(dnVar);
        this.f14824O000000o = file;
    }

    public final dn O000000o(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.f14824O000000o, str2);
        try {
            file.createNewFile();
            return new dp(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: ".concat(String.valueOf(e)));
            return null;
        }
    }

    public final Uri O000000o() {
        return Uri.fromFile(this.f14824O000000o);
    }

    public final String O00000Oo() {
        return this.f14824O000000o.getName();
    }

    public final String O00000o0() {
        String mimeTypeFromExtension;
        if (this.f14824O000000o.isDirectory()) {
            return null;
        }
        String name = this.f14824O000000o.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1).toLowerCase())) == null) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public final long O00000o() {
        return this.f14824O000000o.length();
    }

    public final boolean O00000oO() {
        O00000Oo(this.f14824O000000o);
        return this.f14824O000000o.delete();
    }

    public final boolean O00000oo() {
        return this.f14824O000000o.exists();
    }

    public final dn[] O0000O0o() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f14824O000000o.listFiles();
        if (listFiles != null) {
            for (File dpVar : listFiles) {
                arrayList.add(new dp(this, dpVar));
            }
        }
        return (dn[]) arrayList.toArray(new dn[arrayList.size()]);
    }

    private static boolean O00000Oo(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        boolean z = true;
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                z &= O00000Oo(file2);
            }
            if (!file2.delete()) {
                Log.w("DocumentFile", "Failed to delete ".concat(String.valueOf(file2)));
                z = false;
            }
        }
        return z;
    }
}

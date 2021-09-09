package _m_j;

import android.content.Context;
import java.io.File;

final class iod implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1514O000000o;

    iod(Context context) {
        this.f1514O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        File externalFilesDir = this.f1514O000000o.getExternalFilesDir(null);
        if (externalFilesDir == null || !externalFilesDir.exists() || !externalFilesDir.canWrite()) {
            return false;
        }
        File file = new File(externalFilesDir, "ANDROID.PERMISSION.TEST");
        if (file.exists()) {
            return file.delete();
        }
        return file.createNewFile();
    }
}

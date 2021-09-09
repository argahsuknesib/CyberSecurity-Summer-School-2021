package _m_j;

import android.content.Context;
import java.io.File;

final class ioc implements inv {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1513O000000o;

    ioc(Context context) {
        this.f1513O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        File externalFilesDir = this.f1513O000000o.getExternalFilesDir(null);
        if (externalFilesDir != null && externalFilesDir.exists() && externalFilesDir.canRead()) {
            long lastModified = externalFilesDir.lastModified();
            String[] list = externalFilesDir.list();
            if (lastModified <= 0 || list == null) {
                return false;
            }
            return true;
        }
        return false;
    }
}

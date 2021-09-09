package _m_j;

import android.os.Environment;
import java.io.File;

final class ipi implements ipb {
    ipi() {
    }

    public final boolean O000000o() throws Throwable {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canRead()) {
            long lastModified = externalStorageDirectory.lastModified();
            String[] list = externalStorageDirectory.list();
            if (lastModified <= 0 || list == null) {
                return false;
            }
            return true;
        }
        return false;
    }
}

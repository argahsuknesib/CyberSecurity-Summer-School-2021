package _m_j;

import android.os.Environment;
import java.io.File;

final class ipj implements ipb {
    ipj() {
    }

    public final boolean O000000o() throws Throwable {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists() || !externalStorageDirectory.canWrite()) {
            return false;
        }
        File file = new File(externalStorageDirectory, "Android");
        if (file.exists() && file.isFile() && !file.delete()) {
            return false;
        }
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(file, "ANDROID.PERMISSION.TEST");
        if (file2.exists()) {
            return file2.delete();
        }
        return file2.createNewFile();
    }
}

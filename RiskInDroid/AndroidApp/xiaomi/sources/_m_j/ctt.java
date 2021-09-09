package _m_j;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class ctt {
    private static File O000000o(File file) throws IOException {
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Couldn't create directory '" + file + "'");
    }

    public static String O000000o(File file, String str) throws IOException {
        O000000o(file);
        String uuid = UUID.randomUUID().toString();
        return file + File.separator + uuid + str;
    }
}

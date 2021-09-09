package _m_j;

import com.drew.imaging.FileType;
import java.util.HashMap;

public final class abq extends xr {
    protected static final HashMap<Integer, String> O0000O0o;

    public final String O000000o() {
        return "File Type";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        hashMap.put(1, "Detected File Type Name");
        O0000O0o.put(2, "Detected File Type Long Name");
        O0000O0o.put(3, "Detected MIME Type");
        O0000O0o.put(4, "Expected File Name Extension");
    }

    public abq(FileType fileType) {
        O000000o(new abp(this));
        O000000o(1, fileType.getName());
        O000000o(2, fileType.getLongName());
        if (fileType.getMimeType() != null) {
            O000000o(3, fileType.getMimeType());
        }
        if (fileType.getCommonExtension() != null) {
            O000000o(4, fileType.getCommonExtension());
        }
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }
}

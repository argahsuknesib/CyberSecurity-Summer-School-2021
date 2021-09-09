package _m_j;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import java.io.File;

public final class dbs {
    @TargetApi(10)
    public static long O000000o(String str) {
        if (!new File(str).exists()) {
            return 0;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception unused) {
            return 0;
        }
    }
}

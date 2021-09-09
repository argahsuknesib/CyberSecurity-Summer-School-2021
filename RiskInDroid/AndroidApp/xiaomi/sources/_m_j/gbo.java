package _m_j;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.FileNotFoundException;

public final class gbo {
    public static ParcelFileDescriptor O000000o(Uri uri, int i) throws FileNotFoundException {
        if (!TextUtils.equals("content", uri.getScheme()) && !TextUtils.equals("file", uri.getScheme())) {
            return ParcelFileDescriptor.open(new File(uri.toString()), i);
        }
        return CommonApplication.getAppContext().getContentResolver().openFileDescriptor(uri, i != 536870912 ? i != 805306368 ? "r" : "rw" : "w");
    }
}

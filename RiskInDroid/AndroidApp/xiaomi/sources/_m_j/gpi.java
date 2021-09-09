package _m_j;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;

public final class gpi {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f18123O000000o = ("SmartHome" + File.separator + "images" + File.separator + "screenshot" + File.separator);
    public static final String O00000Oo;
    static SimpleDateFormat O00000o0 = new SimpleDateFormat("yyyy_MM_dd");

    static {
        String str;
        StringBuilder sb = new StringBuilder();
        File externalFilesDir = CommonApplication.getAppContext().getExternalFilesDir("external");
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(File.separator);
        sb.append(f18123O000000o);
        O00000Oo = sb.toString();
    }

    public static void O000000o(File file) throws FileNotFoundException {
        MediaStore.Images.Media.insertImage(CommonApplication.getAppContext().getContentResolver(), file.getAbsolutePath(), "", (String) null);
        CommonApplication.getAppContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
    }
}

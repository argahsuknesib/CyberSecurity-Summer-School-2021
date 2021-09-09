package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.smarthome.library.common.widget.crop.CropImageActivity;
import java.io.File;

public final class gqz {

    /* renamed from: O000000o  reason: collision with root package name */
    public Activity f18169O000000o;
    public String O00000Oo;
    public O000000o O00000o;
    public String O00000o0;
    private final int O00000oO = 1;
    private final int O00000oo = 1;

    public interface O000000o {
        void O000000o(String str);
    }

    public gqz(Activity activity, O000000o o000000o) {
        this.f18169O000000o = activity;
        this.O00000o = o000000o;
    }

    public static boolean O000000o(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static String O000000o(String str) {
        return str.substring(0, str.lastIndexOf(".")).concat(String.valueOf(System.currentTimeMillis())).concat(".jpg");
    }

    private static void O00000Oo(String str) {
        File file = new File(str.substring(0, str.lastIndexOf("/")));
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void O000000o(Uri uri) {
        if (!this.f18169O000000o.isFinishing()) {
            this.O00000o0 = O000000o(gqy.f18166O000000o);
            O00000Oo(this.O00000o0);
            File file = new File(this.O00000o0);
            Intent intent = new Intent(this.f18169O000000o, CropImageActivity.class);
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 720);
            intent.putExtra("outputY", 720);
            intent.putExtra("output", Uri.fromFile(file));
            this.f18169O000000o.startActivityForResult(intent, 150);
        }
    }

    public static String O000000o(File file, String str) {
        String str2;
        File file2 = new File(file, str);
        if (!file2.exists()) {
            return file2.getAbsolutePath();
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf + 1);
            str = substring;
        } else {
            str2 = "";
        }
        int i = 1;
        while (true) {
            File file3 = new File(file, String.format("%s_%d.%s", str, Integer.valueOf(i), str2));
            if (!file3.exists()) {
                return file3.getAbsolutePath();
            }
            i++;
        }
    }
}

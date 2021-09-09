package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;

public final class cbb extends ceb {
    public static String O000000o(int i, int i2, String str) {
        String str2;
        if (str.indexOf(47) < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, str.lastIndexOf(47)));
        String substring = str.substring(str.lastIndexOf(47));
        if (substring.contains("!")) {
            stringBuffer.append(substring.subSequence(0, substring.indexOf(33)));
            stringBuffer.append('!');
            stringBuffer.append(i);
            stringBuffer.append('x');
            stringBuffer.append(i2);
            if (substring.indexOf(33) != substring.lastIndexOf(33)) {
                stringBuffer.append(substring.substring(substring.lastIndexOf(33)));
            } else {
                stringBuffer.append('!');
                stringBuffer.append(O000000o());
                if (substring.contains(".")) {
                    stringBuffer.append(substring.substring(substring.lastIndexOf(46)));
                }
            }
        } else if (substring.contains(".")) {
            stringBuffer.append(substring.subSequence(0, substring.lastIndexOf(46)));
            stringBuffer.append('!');
            stringBuffer.append(i);
            stringBuffer.append('x');
            stringBuffer.append(i2);
            stringBuffer.append('!');
            stringBuffer.append(O000000o());
            stringBuffer.append(substring.substring(substring.lastIndexOf(46)));
        } else {
            stringBuffer.append(substring);
            stringBuffer.append('!');
            stringBuffer.append(i);
            stringBuffer.append('x');
            stringBuffer.append(i2);
            stringBuffer.append('!');
            stringBuffer.append(O000000o());
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.startsWith("http:") || stringBuffer2.startsWith("https:")) {
            return stringBuffer2;
        }
        if (stringBuffer2.startsWith("//")) {
            str2 = "http:".concat(String.valueOf(str));
        } else {
            str2 = "http://".concat(String.valueOf(str));
        }
        return cbl.O00000o0(str2);
    }

    private static int O000000o() {
        return cbf.O00000Oo() ? 70 : 40;
    }

    public static Bitmap O000000o(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = O000000o(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public static void O000000o(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int O000000o(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        if (i4 > i3) {
            return Math.round(((float) i3) / ((float) i2));
        }
        return Math.round(((float) i4) / ((float) i));
    }
}

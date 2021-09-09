package com.hzy.tvmao.offline;

import android.content.Context;
import android.text.TextUtils;
import com.hzy.tvmao.KookongSDK;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class a {
    private static Context a() {
        return KookongSDK.getContext();
    }

    public static boolean a(String str, String str2) {
        Context a2 = a();
        File file = new File(str2.substring(0, str2.lastIndexOf(File.separator)));
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String[] list = a2.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                String str3 = str;
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = str3 + "/";
                    }
                    a(str3 + str4, str2 + "/" + str4);
                }
                return true;
            }
            InputStream open = a2.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

package _m_j;

import java.io.File;
import java.io.FileOutputStream;

public final class edv extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f15188O000000o = "\n";
    private String O00000Oo;
    private byte[] O00000o0;

    public edv(String str, byte[] bArr) {
        this.O00000Oo = str;
        this.O00000o0 = bArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
    public final void run() {
        super.run();
        byte[] bArr = this.O00000o0;
        try {
            File file = new File(this.O00000Oo);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(this.O00000Oo, true);
            if (bArr != null && bArr.length > 0) {
                fileOutputStream.write(bArr);
                fileOutputStream.write(this.f15188O000000o.getBytes());
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

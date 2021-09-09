package _m_j;

import _m_j.cej;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class cbm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13599O000000o = "cbm";

    public static final class O00000Oo extends cej.O000000o {
    }

    public static final class O00000o0 extends cej.O00000Oo {
    }

    public static final class O000000o {
        public static long O000000o(File file) {
            long j;
            File[] listFiles = file.listFiles();
            long j2 = 0;
            if (!(listFiles == null || listFiles.length == 0)) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        j = O000000o(listFiles[i]);
                    } else {
                        j = listFiles[i].length();
                    }
                    j2 += j;
                }
            }
            return j2;
        }

        public static boolean O000000o(String str, String str2) {
            ccr.O00000Oo(cbm.f13599O000000o, String.format("zipFile:%s, targetDir:%s", str, str2));
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if (!str2.endsWith("/")) {
                    str2 = str2 + "/";
                }
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                    byte[] bArr = new byte[4096];
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            File file = new File(str2 + name);
                            if (!name.endsWith("/")) {
                                File file2 = new File(file.getParent());
                                if (!file2.exists() || !file2.isDirectory()) {
                                    file2.mkdirs();
                                }
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                                while (true) {
                                    int read = zipInputStream.read(bArr, 0, 4096);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                            }
                        } else {
                            zipInputStream.close();
                            return true;
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        public static boolean O00000Oo(File file) {
            if (file == null || !file.exists()) {
                return false;
            }
            if (!file.isDirectory()) {
                return file.delete();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File O00000Oo : listFiles) {
                    if (!O00000Oo(O00000Oo)) {
                        return false;
                    }
                }
            }
            file.delete();
            return true;
        }

        public static boolean O000000o(AssetManager assetManager, String str, String str2) {
            boolean z;
            try {
                String[] list = assetManager.list(str);
                new File(str2).mkdirs();
                boolean z2 = true;
                for (String str3 : list) {
                    if (str3.contains(".")) {
                        z = O00000Oo(assetManager, str + "/" + str3, str2 + "/" + str3);
                    } else {
                        z = O000000o(assetManager, str + "/" + str3, str2 + "/" + str3);
                    }
                    z2 &= z;
                }
                return z2;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private static boolean O00000Oo(AssetManager assetManager, String str, String str2) {
            try {
                InputStream open = assetManager.open(str);
                new File(str2).createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                O000000o(open, fileOutputStream);
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private static void O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        }
    }

    public static String O000000o(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(cdv.f13670O000000o.getBytes("utf-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, secretKeySpec, O00000o0(cdv.O00000Oo));
            try {
                return new String(instance.doFinal(Base64.decode(str, 0)), "utf-8");
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception e2) {
            System.out.println(e2.toString());
            return null;
        }
    }

    public static String O00000Oo(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        return new String(O000000o(bArr, cdv.f13670O000000o, cdv.O00000Oo));
    }

    private static byte[] O000000o(byte[] bArr, String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(1, new SecretKeySpec(str.getBytes(), "AES"), new IvParameterSpec(str2.getBytes()));
            return Base64.encode(instance.doFinal(bArr), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static IvParameterSpec O00000o0(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        return new IvParameterSpec(bArr);
    }
}

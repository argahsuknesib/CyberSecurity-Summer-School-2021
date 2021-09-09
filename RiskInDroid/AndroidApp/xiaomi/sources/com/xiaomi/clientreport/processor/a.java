package com.xiaomi.clientreport.processor;

import _m_j.duv;
import _m_j.dux;
import _m_j.duz;
import _m_j.dvb;
import _m_j.dvk;
import _m_j.ele;
import _m_j.eli;
import _m_j.eml;
import _m_j.emn;
import _m_j.ert;
import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class a implements dvk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f5976O000000o;
    private HashMap<String, ArrayList<duz>> O00000Oo;

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        _m_j.duv.O00000o("eventData read from cache file failed because magicNumber error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        _m_j.duv.O00000o(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
     */
    private List<String> O000000o(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            while (true) {
                try {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    } else if (read == 4) {
                        if (eli.O000000o(bArr) != -573785174) {
                            break;
                        }
                        int read2 = fileInputStream2.read(bArr2);
                        if (read2 == -1) {
                            break;
                        } else if (read2 != 4) {
                            str2 = "eventData read from cache file failed cause lengthBuffer error";
                            break;
                        } else {
                            int O000000o2 = eli.O000000o(bArr2);
                            if (O000000o2 <= 0) {
                                break;
                            } else if (O000000o2 > 4096) {
                                break;
                            } else {
                                byte[] bArr3 = new byte[O000000o2];
                                if (fileInputStream2.read(bArr3) != O000000o2) {
                                    str2 = "eventData read from cache file failed cause buffer size not equal length";
                                    break;
                                }
                                String O000000o3 = O000000o(bArr3);
                                if (!TextUtils.isEmpty(O000000o3)) {
                                    arrayList.add(O000000o3);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        duv.O000000o(e);
                        ele.O000000o(fileInputStream);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        ele.O000000o(fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ele.O000000o(fileInputStream2);
                    throw th;
                }
            }
            ele.O000000o(fileInputStream2);
        } catch (Exception e2) {
            e = e2;
            duv.O000000o(e);
            ele.O000000o(fileInputStream);
            return arrayList;
        }
        return arrayList;
    }

    private static void O000000o(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                duv.O000000o(e);
            }
        }
        ele.O000000o(randomAccessFile);
    }

    public final void O000000o(HashMap<String, ArrayList<duz>> hashMap) {
        this.O00000Oo = hashMap;
    }

    public void O000000o(List<String> list) {
        emn.O000000o(this.f5976O000000o, list);
    }

    public a(Context context) {
        this.f5976O000000o = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0138 A[SYNTHETIC] */
    public final void O000000o() {
        RandomAccessFile randomAccessFile;
        emn.O000000o(this.f5976O000000o, "event", "eventUploading");
        File[] O00000Oo2 = emn.O00000Oo(this.f5976O000000o, "eventUploading");
        if (O00000Oo2 != null && O00000Oo2.length > 0) {
            FileLock fileLock = null;
            RandomAccessFile randomAccessFile2 = null;
            File file = null;
            for (File file2 : O00000Oo2) {
                if (file2 == null) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            duv.O000000o(e);
                        }
                    }
                    ele.O000000o(randomAccessFile2);
                    if (file != null) {
                        file.delete();
                    }
                } else {
                    try {
                        if (file2.length() > 5242880) {
                            duv.O00000o("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                            dux O000000o2 = dvb.O000000o(this.f5976O000000o).O000000o("24:" + file2.getName() + "," + Formatter.formatFileSize(this.f5976O000000o, file2.length()));
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(O000000o2.O00000Oo());
                            O000000o(arrayList);
                            file2.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e2) {
                                    duv.O000000o(e2);
                                }
                            }
                            ele.O000000o(randomAccessFile2);
                            if (file == null) {
                            }
                            file.delete();
                        } else {
                            String absolutePath = file2.getAbsolutePath();
                            File file3 = new File(absolutePath + ".lock");
                            try {
                                ele.O00000o0(file3);
                                randomAccessFile = new RandomAccessFile(file3, "rw");
                            } catch (Exception e3) {
                                e = e3;
                                file = file3;
                                try {
                                    duv.O000000o(e);
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        duv.O000000o(e4);
                                    }
                                    ele.O000000o(randomAccessFile2);
                                    if (file == null) {
                                    }
                                    file.delete();
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        fileLock.release();
                                    } catch (IOException e5) {
                                        duv.O000000o(e5);
                                    }
                                    ele.O000000o(randomAccessFile2);
                                    if (file != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                file = file3;
                                if (fileLock != null && fileLock.isValid()) {
                                    fileLock.release();
                                }
                                ele.O000000o(randomAccessFile2);
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                O000000o(O000000o(absolutePath));
                                file2.delete();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e6) {
                                        duv.O000000o(e6);
                                    }
                                }
                                ele.O000000o(randomAccessFile);
                                file3.delete();
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                            } catch (Exception e7) {
                                e = e7;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                duv.O000000o(e);
                                fileLock.release();
                                ele.O000000o(randomAccessFile2);
                                if (file == null) {
                                }
                                file.delete();
                            } catch (Throwable th3) {
                                th = th3;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                fileLock.release();
                                ele.O000000o(randomAccessFile2);
                                if (file != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        duv.O000000o(e);
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        ele.O000000o(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    }
                }
            }
        }
    }

    private String O000000o(byte[] bArr) {
        byte[] O000000o2;
        if (bArr.length <= 0) {
            return null;
        }
        if (!dvb.O000000o(this.f5976O000000o).O000000o().f14961O000000o) {
            return eml.O000000o(bArr);
        }
        String O000000o3 = emn.O000000o(this.f5976O000000o);
        if (!TextUtils.isEmpty(O000000o3) && (O000000o2 = emn.O000000o(O000000o3)) != null && O000000o2.length > 0) {
            try {
                return eml.O000000o(Base64.decode(ert.O000000o(O000000o2, bArr), 2));
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                duv.O000000o(e);
            }
        }
        return null;
    }

    private byte[] O00000Oo(String str) {
        byte[] O000000o2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!dvb.O000000o(this.f5976O000000o).O000000o().f14961O000000o) {
            return eml.O00000o0(str);
        }
        String O000000o3 = emn.O000000o(this.f5976O000000o);
        byte[] O00000o0 = eml.O00000o0(str);
        if (!TextUtils.isEmpty(O000000o3) && O00000o0 != null && O00000o0.length > 1 && (O000000o2 = emn.O000000o(O000000o3)) != null) {
            try {
                if (O000000o2.length > 1) {
                    return ert.O00000Oo(O000000o2, Base64.encode(O00000o0, 2));
                }
            } catch (Exception e) {
                duv.O000000o(e);
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0054 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055 A[SYNTHETIC, Splitter:B:12:0x0055] */
    private duz[] O000000o(duz[] duzArr) {
        String str;
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        duz duz = duzArr[0];
        File externalFilesDir = this.f5976O000000o.getExternalFilesDir("event");
        String valueOf = String.valueOf(duz.O00000oO);
        if (externalFilesDir != null) {
            String str2 = externalFilesDir.getAbsolutePath() + File.separator + valueOf;
            int i = 0;
            while (true) {
                if (i >= 100) {
                    break;
                }
                str = str2 + i;
                if (emn.O000000o(this.f5976O000000o, str)) {
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                File file = new File(str + ".lock");
                ele.O00000o0(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e) {
                    e = e;
                    fileLock = null;
                    bufferedOutputStream = null;
                    try {
                        duv.O000000o("event data write to cache file failed cause exception", e);
                        ele.O000000o(bufferedOutputStream);
                        O000000o(randomAccessFile, fileLock);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        ele.O000000o(bufferedOutputStream);
                        O000000o(randomAccessFile, fileLock);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileLock = null;
                    bufferedOutputStream = null;
                    ele.O000000o(bufferedOutputStream);
                    O000000o(randomAccessFile, fileLock);
                    throw th;
                }
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str), true));
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                    duv.O000000o("event data write to cache file failed cause exception", e);
                    ele.O000000o(bufferedOutputStream);
                    O000000o(randomAccessFile, fileLock);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    ele.O000000o(bufferedOutputStream);
                    O000000o(randomAccessFile, fileLock);
                    throw th;
                }
                try {
                    int i2 = 0;
                    for (duz duz2 : duzArr) {
                        if (duz2 != null) {
                            byte[] O00000Oo2 = O00000Oo(duz2.O00000Oo());
                            if (O00000Oo2 != null && O00000Oo2.length > 0) {
                                if (O00000Oo2.length <= 4096) {
                                    if (!emn.O000000o(this.f5976O000000o, str)) {
                                        int length = duzArr.length - i2;
                                        duz[] duzArr2 = new duz[length];
                                        System.arraycopy(duzArr, i2, duzArr2, 0, length);
                                        ele.O000000o(bufferedOutputStream);
                                        O000000o(randomAccessFile, fileLock);
                                        return duzArr2;
                                    }
                                    bufferedOutputStream.write(eli.O000000o(-573785174));
                                    bufferedOutputStream.write(eli.O000000o(O00000Oo2.length));
                                    bufferedOutputStream.write(O00000Oo2);
                                    bufferedOutputStream.flush();
                                    i2++;
                                }
                            }
                            duv.O00000o("event data throw a invalid item ");
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    duv.O000000o("event data write to cache file failed cause exception", e);
                    ele.O000000o(bufferedOutputStream);
                    O000000o(randomAccessFile, fileLock);
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                fileLock = null;
                randomAccessFile = null;
                bufferedOutputStream = null;
                duv.O000000o("event data write to cache file failed cause exception", e);
                ele.O000000o(bufferedOutputStream);
                O000000o(randomAccessFile, fileLock);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                randomAccessFile = null;
                bufferedOutputStream = null;
                ele.O000000o(bufferedOutputStream);
                O000000o(randomAccessFile, fileLock);
                throw th;
            }
            ele.O000000o(bufferedOutputStream);
            O000000o(randomAccessFile, fileLock);
            return null;
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
    }

    public final void O00000Oo() {
        HashMap<String, ArrayList<duz>> hashMap = this.O00000Oo;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.O00000Oo.keySet()) {
                    ArrayList arrayList = this.O00000Oo.get(str);
                    if (arrayList != null && arrayList.size() > 0) {
                        duz[] duzArr = new duz[arrayList.size()];
                        arrayList.toArray(duzArr);
                        if (duzArr.length != 0 && duzArr[0] != null) {
                            do {
                                duzArr = O000000o(duzArr);
                                if (duzArr == null || duzArr.length <= 0) {
                                    break;
                                }
                            } while (duzArr[0] != null);
                        } else {
                            duv.O000000o("event data write to cache file failed because data null");
                        }
                    }
                }
            }
            this.O00000Oo.clear();
        }
    }

    public final void O000000o(duz duz) {
        if ((duz instanceof dux) && this.O00000Oo != null) {
            dux dux = (dux) duz;
            String valueOf = String.valueOf(dux.O00000oO);
            ArrayList arrayList = this.O00000Oo.get(valueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dux);
            this.O00000Oo.put(valueOf, arrayList);
        }
    }
}

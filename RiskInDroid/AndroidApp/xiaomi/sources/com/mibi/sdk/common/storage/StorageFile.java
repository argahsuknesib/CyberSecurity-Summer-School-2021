package com.mibi.sdk.common.storage;

import com.mibi.sdk.common.Coder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StorageFile extends File {
    private static HashMap<String, Object> sFileLocks = new HashMap<>();

    public StorageFile(File file, String str) {
        super(file, str);
    }

    public StorageFile(String str, String str2) {
        super(str, str2);
    }

    public StorageFile(String str) {
        super(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:26|(0)|(0)|(0)|45|46) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:27|(0)|(0)|(0)|61|62|63) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:9|10|(2:11|12)|(2:15|16)|17|18|19|20|21) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0022 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0048 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0037 A[SYNTHETIC, Splitter:B:35:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x003e A[SYNTHETIC, Splitter:B:39:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0045 A[SYNTHETIC, Splitter:B:43:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x004d A[SYNTHETIC, Splitter:B:50:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0056 A[SYNTHETIC, Splitter:B:55:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x005d A[SYNTHETIC, Splitter:B:59:0x005d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x0060=Splitter:B:61:0x0060, B:19:0x0022=Splitter:B:19:0x0022, B:45:0x0048=Splitter:B:45:0x0048} */
    public void writeObject(Serializable serializable) {
        OutputStream outputStream;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        synchronized (getFileLock(this)) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this);
                try {
                    outputStream = Coder.encodeBase64Stream(fileOutputStream);
                    try {
                        objectOutputStream = new ObjectOutputStream(outputStream);
                    } catch (Exception unused) {
                        if (objectOutputStream2 != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (objectOutputStream2 != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    outputStream = null;
                    if (objectOutputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    if (objectOutputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    objectOutputStream.writeObject(serializable);
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    fileOutputStream.close();
                    return;
                } catch (Exception unused4) {
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileOutputStream = null;
                outputStream = null;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused6) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                outputStream = null;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused8) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused9) {
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:23:? */
    /* JADX INFO: additional move instructions added (4) to help type inference */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:2|3|4|5|6|7|8|9|10|11|12|(2:15|16)|17|18|19|20|21) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:24|25|(0)|(0)|(0)|45|46) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:27|26|(0)|(0)|(0)|62|63|64) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0022 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0051 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0040 A[SYNTHETIC, Splitter:B:35:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0047 A[SYNTHETIC, Splitter:B:39:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x004e A[SYNTHETIC, Splitter:B:43:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0057 A[SYNTHETIC, Splitter:B:51:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0060 A[SYNTHETIC, Splitter:B:56:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0067 A[SYNTHETIC, Splitter:B:60:0x0067] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0051=Splitter:B:45:0x0051, B:19:0x0025=Splitter:B:19:0x0025, B:62:0x006a=Splitter:B:62:0x006a} */
    public Serializable readObject() {
        ObjectInputStream objectInputStream;
        InputStream inputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream2;
        InputStream inputStream2;
        Throwable th;
        synchronized (getFileLock(this)) {
            try {
                fileInputStream = new FileInputStream(this);
                try {
                    inputStream = Coder.decodeBase64Stream(fileInputStream);
                    try {
                        objectInputStream = new ObjectInputStream(inputStream);
                    } catch (Exception unused) {
                        objectInputStream = null;
                        inputStream = inputStream;
                        if (objectInputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        objectInputStream = null;
                        th = th3;
                        inputStream2 = inputStream;
                        if (objectInputStream != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    objectInputStream2 = null;
                    objectInputStream = objectInputStream2;
                    inputStream = objectInputStream2;
                    if (objectInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th4) {
                    objectInputStream = null;
                    th = th4;
                    inputStream2 = null;
                    if (objectInputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                try {
                    Serializable serializable = (Serializable) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException unused3) {
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    fileInputStream.close();
                    return serializable;
                } catch (Exception unused4) {
                    if (objectInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream2 = inputStream;
                    if (objectInputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileInputStream = null;
                objectInputStream2 = null;
                objectInputStream = objectInputStream2;
                inputStream = objectInputStream2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (Throwable th6) {
                inputStream2 = null;
                objectInputStream = null;
                th = th6;
                fileInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused8) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused9) {
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0022 A[Catch:{ Exception -> 0x001c, all -> 0x001a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0028 A[Catch:{ Exception -> 0x001c, all -> 0x001a }] */
    public void write(String str) {
        PrintWriter printWriter;
        synchronized (getFileLock(this)) {
            PrintWriter printWriter2 = null;
            try {
                printWriter = new PrintWriter(this);
                try {
                    printWriter.println(Coder.encodeBase64(str));
                    printWriter.flush();
                    printWriter.close();
                } catch (Exception unused) {
                    printWriter2 = printWriter;
                    if (printWriter2 != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (printWriter != null) {
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                if (printWriter2 != null) {
                    printWriter2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                printWriter = null;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0031 A[SYNTHETIC, Splitter:B:26:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x003c A[SYNTHETIC, Splitter:B:34:0x003c] */
    public void writeBytes(byte[] bArr) {
        synchronized (getFileLock(this)) {
            if (bArr == null) {
                super.delete();
                return;
            }
            BufferedOutputStream bufferedOutputStream = null;
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(this));
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c A[SYNTHETIC, Splitter:B:18:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0038 A[SYNTHETIC, Splitter:B:28:0x0038] */
    public byte[] readBytes() {
        BufferedInputStream bufferedInputStream;
        byte[] bArr;
        synchronized (getFileLock(this)) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(this));
                try {
                    bArr = new byte[((int) super.length())];
                    bufferedInputStream.read(bArr);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception unused) {
                    if (bufferedInputStream != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                    th = th;
                    bufferedInputStream2 = bufferedInputStream3;
                    if (bufferedInputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedInputStream = null;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return bArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [com.mibi.sdk.common.storage.StorageFile, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:9|10|11|12|13|14|15|16|17|18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:7|8|9|10|11|12|13|14|15|16|17|18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:28|29|(0)|(0)|(0)|43|44) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:31|30|(0)|(0)|(0)|57|58|59) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x003e A[Catch:{ Exception -> 0x002e, all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0043 A[SYNTHETIC, Splitter:B:37:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x004a A[SYNTHETIC, Splitter:B:41:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0052 A[Catch:{ Exception -> 0x002e, all -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x005a A[SYNTHETIC, Splitter:B:51:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0061 A[SYNTHETIC, Splitter:B:55:0x0061] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x0064=Splitter:B:57:0x0064, B:17:0x0029=Splitter:B:17:0x0029, B:43:0x004d=Splitter:B:43:0x004d} */
    public void append(String str) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        synchronized (getFileLock(this)) {
            PrintWriter printWriter = null;
            try {
                fileOutputStream = new FileOutputStream((File) this, true);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Exception unused) {
                    bufferedOutputStream = null;
                    if (printWriter != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                    if (printWriter != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    PrintWriter printWriter2 = new PrintWriter(bufferedOutputStream);
                    try {
                        printWriter2.println(Coder.encodeBase64(str));
                        printWriter2.flush();
                        printWriter2.close();
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                        printWriter = printWriter2;
                        if (printWriter != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        printWriter = printWriter2;
                        if (printWriter != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                    if (printWriter != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (printWriter != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused4) {
                fileOutputStream = null;
                bufferedOutputStream = null;
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                bufferedOutputStream = null;
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[Catch:{ Exception -> 0x0047, all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[Catch:{ Exception -> 0x0047, all -> 0x003c }] */
    public String read() {
        Scanner scanner;
        synchronized (getFileLock(this)) {
            StringBuilder sb = new StringBuilder();
            try {
                scanner = new Scanner(this);
                while (scanner.hasNextLine()) {
                    try {
                        String nextLine = scanner.nextLine();
                        sb.append(Coder.decodeBase64(nextLine) + "\n");
                    } catch (Exception unused) {
                        if (scanner != null) {
                            scanner.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (scanner != null) {
                            scanner.close();
                        }
                        throw th;
                    }
                }
                scanner.close();
                String sb2 = sb.toString();
                return sb2;
            } catch (Exception unused2) {
                scanner = null;
                if (scanner != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                scanner = null;
                if (scanner != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[Catch:{ Exception -> 0x0039, all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b A[Catch:{ Exception -> 0x0039, all -> 0x002e }] */
    public ArrayList<String> readAndSplit() {
        Scanner scanner;
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (getFileLock(this)) {
            try {
                scanner = new Scanner(this);
                while (scanner.hasNextLine()) {
                    try {
                        arrayList.add(Coder.decodeBase64(scanner.nextLine()));
                    } catch (Exception unused) {
                        if (scanner != null) {
                            scanner.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (scanner != null) {
                            scanner.close();
                        }
                        throw th;
                    }
                }
                scanner.close();
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
            } catch (Exception unused2) {
                scanner = null;
                if (scanner != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                scanner = null;
                if (scanner != null) {
                }
                throw th;
            }
        }
    }

    public boolean delete() {
        boolean delete;
        synchronized (getFileLock(this)) {
            delete = super.delete();
        }
        return delete;
    }

    public long lastModified() {
        long lastModified;
        synchronized (getFileLock(this)) {
            lastModified = super.lastModified();
        }
        return lastModified;
    }

    public long length() {
        long length;
        synchronized (getFileLock(this)) {
            length = super.length();
        }
        return length;
    }

    static Object getFileLock(File file) {
        Object obj;
        synchronized (sFileLocks) {
            String absolutePath = file.getAbsolutePath();
            obj = sFileLocks.get(absolutePath);
            if (obj == null) {
                obj = new Object();
                sFileLocks.put(absolutePath, obj);
            }
        }
        return obj;
    }
}

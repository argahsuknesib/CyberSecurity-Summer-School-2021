package com.mibi.sdk.common.storage;

import android.os.FileObserver;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class StorageDir extends StorageFile {
    public StorageDir(File file, String str) {
        super(file, str);
        mkdirs();
    }

    public StorageDir(String str, String str2) {
        super(str, str2);
        mkdirs();
    }

    public StorageDir(String str) {
        super(str);
        mkdirs();
    }

    public void writeBytes(String str, byte[] bArr) {
        new StorageFile(this, str).writeBytes(bArr);
    }

    public byte[] readBytes(String str) {
        return new StorageFile(this, str).readBytes();
    }

    public void writeObject(String str, Serializable serializable) {
        new StorageFile(this, str).writeObject(serializable);
    }

    public Serializable readObject(String str) {
        return new StorageFile(this, str).readObject();
    }

    public void write(String str, String str2) {
        new StorageFile(this, str).write(str2);
    }

    public void append(String str, String str2) {
        new StorageFile(this, str).append(str2);
    }

    public String read(String str) {
        return new StorageFile(this, str).read();
    }

    public ArrayList<String> readAndSplit(String str) {
        return new StorageFile(this, str).readAndSplit();
    }

    public boolean delete(String str) {
        return new StorageFile(this, str).delete();
    }

    public boolean deleteAll() {
        if (!hasFiles()) {
            return true;
        }
        for (StorageFile delete : listFiles()) {
            if (!delete.delete()) {
                return false;
            }
        }
        return true;
    }

    public long lastModified(String str) {
        return new StorageFile(this, str).lastModified();
    }

    public long getFileLength(String str) {
        return new StorageFile(this, str).length();
    }

    public boolean hasFile(String str) {
        if (hasFiles()) {
            for (StorageFile name : listFiles()) {
                if (name.getName().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasFiles() {
        StorageFile[] listFiles = listFiles();
        if (listFiles != null && listFiles.length > 0) {
            return true;
        }
        return false;
    }

    public StorageFile[] listFiles() {
        synchronized (getFileLock(this)) {
            String[] list = list();
            if (list == null) {
                return null;
            }
            int length = list.length;
            StorageFile[] storageFileArr = new StorageFile[length];
            for (int i = 0; i < length; i++) {
                storageFileArr[i] = new StorageFile(this, list[i]);
            }
            return storageFileArr;
        }
    }

    public String[] list() {
        String[] list;
        synchronized (getFileLock(this)) {
            list = super.list();
        }
        return list;
    }

    public abstract class StorageDirObserver extends FileObserver {
        public StorageDirObserver(int i) {
            super(StorageDir.this.getAbsolutePath(), i);
        }
    }
}

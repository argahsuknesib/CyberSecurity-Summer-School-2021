package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private String[] mAbis;
    protected final Context mContext;

    /* access modifiers changed from: protected */
    public abstract Unpacker makeUnpacker() throws IOException;

    protected UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        public final void close() throws IOException {
            this.content.close();
        }
    }

    public static abstract class InputDsoIterator implements Closeable {
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;

        protected InputDsoIterator() {
        }
    }

    public static abstract class Unpacker implements Closeable {
        public void close() throws IOException {
        }

        /* access modifiers changed from: protected */
        public abstract DsoManifest getDsoManifest() throws IOException;

        /* access modifiers changed from: protected */
        public abstract InputDsoIterator openDsoIterator() throws IOException;

        protected Unpacker() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r3 != null) goto L_0x0028;
     */
    public static void writeState(File file, byte b) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(0);
        randomAccessFile.write(b);
        randomAccessFile.setLength(randomAccessFile.getFilePointer());
        randomAccessFile.getFD().sync();
        randomAccessFile.close();
        return;
        throw th;
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(str)) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file ".concat(String.valueOf(file)));
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        Log.i("fb-UnpackingSoSource", "extracting DSO " + inputDso.dso.name);
        if (this.soDirectory.setWritable(true, true)) {
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil.fallocateIfSupported(randomAccessFile.getFD(), (long) available);
                }
                SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (!file.setExecutable(true, false)) {
                    throw new IOException("cannot make file executable: ".concat(String.valueOf(file)));
                }
            } finally {
                randomAccessFile.close();
            }
        } else {
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045 A[Catch:{ Throwable -> 0x0037, all -> 0x0034, Throwable -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c A[Catch:{ Throwable -> 0x0037, all -> 0x0034, Throwable -> 0x00d8 }] */
    private void regenerate(byte b, DsoManifest dsoManifest, InputDsoIterator inputDsoIterator) throws IOException {
        DsoManifest dsoManifest2;
        InputDso next;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Log.v("fb-UnpackingSoSource", "regenerating DSO store " + getClass().getName());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.soDirectory, "dso_manifest"), "rw");
        if (b == 1) {
            try {
                dsoManifest2 = DsoManifest.read(randomAccessFile);
            } catch (Exception e) {
                try {
                    Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e);
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            if (dsoManifest2 == null) {
                dsoManifest2 = new DsoManifest(new Dso[0]);
            }
            deleteUnmentionedFiles(dsoManifest.dsos);
            byte[] bArr = new byte[32768];
            while (inputDsoIterator.hasNext()) {
                next = inputDsoIterator.next();
                boolean z = true;
                int i = 0;
                while (z) {
                    try {
                        if (i >= dsoManifest2.dsos.length) {
                            break;
                        }
                        if (dsoManifest2.dsos[i].name.equals(next.dso.name) && dsoManifest2.dsos[i].hash.equals(next.dso.hash)) {
                            z = false;
                        }
                        i++;
                    } catch (Throwable th5) {
                        Throwable th6 = th5;
                        th = th;
                        th2 = th6;
                    }
                }
                if (z) {
                    extractDso(next, bArr);
                }
                if (next != null) {
                    next.close();
                }
            }
            randomAccessFile.close();
            Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store " + getClass().getName());
            return;
        }
        dsoManifest2 = null;
        if (dsoManifest2 == null) {
        }
        deleteUnmentionedFiles(dsoManifest.dsos);
        byte[] bArr2 = new byte[32768];
        while (inputDsoIterator.hasNext()) {
        }
        randomAccessFile.close();
        Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store " + getClass().getName());
        return;
        throw th;
        if (next != null) {
            if (th != null) {
                try {
                    next.close();
                } catch (Throwable th7) {
                    th.addSuppressed(th7);
                }
            } else {
                next.close();
            }
        }
        throw th2;
        throw th2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009f, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a4, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a5, code lost:
        r11 = r14;
        r14 = r13;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b9, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00be, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00bf, code lost:
        r11 = r14;
        r14 = r13;
        r13 = r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b9 A[ExcHandler: all (th java.lang.Throwable)] */
    private boolean refreshLocked(FileLocker fileLocker, int i, byte[] bArr) throws IOException {
        byte b;
        final DsoManifest dsoManifest;
        Unpacker makeUnpacker;
        Throwable th;
        Throwable th2;
        InputDsoIterator openDsoIterator;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        final File file = new File(this.soDirectory, "dso_state");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b = randomAccessFile.readByte();
            if (b != 1) {
                Log.v("fb-UnpackingSoSource", "dso store " + this.soDirectory + " regeneration interrupted: wiping clean");
                b = 0;
            }
        } catch (EOFException unused) {
        } catch (Throwable th6) {
            th5.addSuppressed(th6);
        }
        randomAccessFile.close();
        File file2 = new File(this.soDirectory, "dso_deps");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
        try {
            byte[] bArr2 = new byte[((int) randomAccessFile2.length())];
            if (randomAccessFile2.read(bArr2) != bArr2.length) {
                Log.v("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");
                b = 0;
            }
            if (!Arrays.equals(bArr2, bArr)) {
                Log.v("fb-UnpackingSoSource", "deps mismatch on deps store: regenerating");
                b = 0;
            }
            if (b == 0) {
                Log.v("fb-UnpackingSoSource", "so store dirty: regenerating");
                writeState(file, (byte) 0);
                makeUnpacker = makeUnpacker();
                DsoManifest dsoManifest2 = makeUnpacker.getDsoManifest();
                openDsoIterator = makeUnpacker.openDsoIterator();
                regenerate(b, dsoManifest2, openDsoIterator);
                if (openDsoIterator != null) {
                    openDsoIterator.close();
                }
                if (makeUnpacker != null) {
                    makeUnpacker.close();
                }
                dsoManifest = dsoManifest2;
            } else {
                dsoManifest = null;
            }
            randomAccessFile2.close();
            if (dsoManifest == null) {
                return false;
            }
            final File file3 = file2;
            final byte[] bArr3 = bArr;
            final FileLocker fileLocker2 = fileLocker;
            AnonymousClass1 r1 = new Runnable() {
                /* class com.facebook.soloader.UnpackingSoSource.AnonymousClass1 */

                public void run() {
                    RandomAccessFile randomAccessFile;
                    Throwable th;
                    RandomAccessFile randomAccessFile2;
                    Throwable th2;
                    try {
                        Log.v("fb-UnpackingSoSource", "starting syncer worker");
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                        randomAccessFile.write(bArr3);
                        randomAccessFile.setLength(randomAccessFile.getFilePointer());
                        randomAccessFile.close();
                        randomAccessFile2 = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, "dso_manifest"), "rw");
                        dsoManifest.write(randomAccessFile2);
                        randomAccessFile2.close();
                        SysUtil.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                        UnpackingSoSource.writeState(file, (byte) 1);
                        try {
                            Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                            fileLocker2.close();
                            return;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        throw th;
                        throw th;
                    } catch (Throwable th3) {
                        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                        fileLocker2.close();
                        throw th3;
                    }
                }
            };
            if ((i & 1) != 0) {
                new Thread(r1, "SoSync:" + this.soDirectory.getName()).start();
            } else {
                r1.run();
            }
            return true;
        } catch (Throwable th7) {
            Throwable th8 = th7;
            try {
                throw th8;
            } catch (Throwable th9) {
                th8.addSuppressed(th9);
            }
        }
        if (makeUnpacker != null) {
            if (th != null) {
                makeUnpacker.close();
            } else {
                makeUnpacker.close();
            }
        }
        throw th2;
        throw th2;
        throw th;
        if (openDsoIterator != null) {
            if (th3 != null) {
                try {
                    openDsoIterator.close();
                } catch (Throwable th10) {
                }
            } else {
                openDsoIterator.close();
            }
        }
        throw th4;
        throw th4;
        throw th;
    }

    /* access modifiers changed from: protected */
    public byte[] getDepsBlock() throws IOException {
        Throwable th;
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker();
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public void prepare(int i) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker lock = FileLocker.lock(new File(this.soDirectory, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.soDirectory);
            if (refreshLocked(lock, i, getDepsBlock())) {
                lock = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.soDirectory);
            }
            if (lock == null) {
                Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        } finally {
            if (lock != null) {
                Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
                lock.close();
            } else {
                Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        }
    }
}

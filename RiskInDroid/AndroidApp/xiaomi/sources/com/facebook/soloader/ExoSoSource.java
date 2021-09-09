package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public final class ExoSoSource extends UnpackingSoSource {
    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: protected */
    public final UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ExoUnpacker(this, this);
    }

    final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        public final FileDso[] mDsos;
        final /* synthetic */ ExoSoSource this$0;

        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r11.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00da, code lost:
            r10.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ed, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            r8.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f7, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f8, code lost:
            r2 = r0;
            r8 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            r10.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0106, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0107, code lost:
            r8.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x010c, code lost:
            r10.close();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00f7 A[ExcHandler: all (r0v11 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:7:0x005c] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0102 A[SYNTHETIC, Splitter:B:57:0x0102] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x010c  */
        ExoUnpacker(ExoSoSource exoSoSource, UnpackingSoSource unpackingSoSource) throws IOException {
            Throwable th;
            Throwable th2;
            BufferedReader bufferedReader;
            Throwable th3;
            Throwable th4;
            boolean z;
            ExoSoSource exoSoSource2 = exoSoSource;
            this.this$0 = exoSoSource2;
            Context context = exoSoSource2.mContext;
            File file = new File("/data/local/tmp/exopackage/" + context.getPackageName() + "/native-libs/");
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] supportedAbis = SysUtil.getSupportedAbis();
            int length = supportedAbis.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                String str = supportedAbis[i2];
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else if (readLine.length() != 0) {
                                        int indexOf = readLine.indexOf(32);
                                        if (indexOf != -1) {
                                            String str2 = readLine.substring(i, indexOf) + ".so";
                                            int size = arrayList.size();
                                            while (true) {
                                                if (i >= size) {
                                                    z = false;
                                                    break;
                                                } else if (((FileDso) arrayList.get(i)).name.equals(str2)) {
                                                    z = true;
                                                    break;
                                                } else {
                                                    i++;
                                                }
                                            }
                                            if (!z) {
                                                String substring = readLine.substring(indexOf + 1);
                                                arrayList.add(new FileDso(str2, substring, new File(file2, substring)));
                                            }
                                            i = 0;
                                        } else {
                                            throw new RuntimeException("illegal line in exopackage metadata: [" + readLine + "]");
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th4 = th5;
                                }
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                        }
                    } else {
                        continue;
                    }
                }
                i2++;
                i = 0;
            }
            unpackingSoSource.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            this.mDsos = (FileDso[]) arrayList.toArray(new FileDso[arrayList.size()]);
            return;
            if (th == null) {
            }
            throw th2;
            throw th4;
            if (th3 != null) {
                bufferedReader.close();
            } else {
                bufferedReader.close();
            }
            throw th4;
            throw th2;
        }

        /* access modifiers changed from: protected */
        public final UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.mDsos);
        }

        /* access modifiers changed from: protected */
        public final UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator();
        }

        final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            private int mCurrentDso;

            private FileBackedInputDsoIterator() {
            }

            public final boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            public final UnpackingSoSource.InputDso next() throws IOException {
                FileDso[] fileDsoArr = ExoUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                FileDso fileDso = fileDsoArr[i];
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    return new UnpackingSoSource.InputDso(fileDso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }
    }

    static final class FileDso extends UnpackingSoSource.Dso {
        final File backingFile;

        FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }
}

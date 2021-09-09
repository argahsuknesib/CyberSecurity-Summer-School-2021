package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Util;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Deprecated
final class ActionFile {
    private final AtomicFile atomicFile;

    public ActionFile(File file) {
        this.atomicFile = new AtomicFile(file);
    }

    public final boolean exists() {
        return this.atomicFile.exists();
    }

    public final void delete() {
        this.atomicFile.delete();
    }

    public final DownloadRequest[] load() throws IOException {
        if (!exists()) {
            return new DownloadRequest[0];
        }
        InputStream inputStream = null;
        try {
            inputStream = this.atomicFile.openRead();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int readInt = dataInputStream.readInt();
            if (readInt <= 0) {
                int readInt2 = dataInputStream.readInt();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < readInt2; i++) {
                    try {
                        arrayList.add(readDownloadRequest(dataInputStream));
                    } catch (DownloadRequest.UnsupportedRequestException unused) {
                    }
                }
                return (DownloadRequest[]) arrayList.toArray(new DownloadRequest[0]);
            }
            throw new IOException("Unsupported action file version: ".concat(String.valueOf(readInt)));
        } finally {
            Util.closeQuietly(inputStream);
        }
    }

    private static DownloadRequest readDownloadRequest(DataInputStream dataInputStream) throws IOException {
        byte[] bArr;
        String readUTF = dataInputStream.readUTF();
        int readInt = dataInputStream.readInt();
        Uri parse = Uri.parse(dataInputStream.readUTF());
        boolean readBoolean = dataInputStream.readBoolean();
        int readInt2 = dataInputStream.readInt();
        String str = null;
        if (readInt2 != 0) {
            byte[] bArr2 = new byte[readInt2];
            dataInputStream.readFully(bArr2);
            bArr = bArr2;
        } else {
            bArr = null;
        }
        boolean z = true;
        boolean z2 = readInt == 0 && "progressive".equals(readUTF);
        ArrayList arrayList = new ArrayList();
        if (!z2) {
            int readInt3 = dataInputStream.readInt();
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(readKey(readUTF, readInt, dataInputStream));
            }
        }
        if (readInt >= 2 || (!"dash".equals(readUTF) && !"hls".equals(readUTF) && !"ss".equals(readUTF))) {
            z = false;
        }
        if (!z && dataInputStream.readBoolean()) {
            str = dataInputStream.readUTF();
        }
        String generateDownloadId = readInt < 3 ? generateDownloadId(parse, str) : dataInputStream.readUTF();
        if (!readBoolean) {
            return new DownloadRequest(generateDownloadId, readUTF, parse, arrayList, str, bArr);
        }
        throw new DownloadRequest.UnsupportedRequestException();
    }

    private static StreamKey readKey(String str, int i, DataInputStream dataInputStream) throws IOException {
        int i2;
        int i3;
        int i4;
        if (("hls".equals(str) || "ss".equals(str)) && i == 0) {
            i4 = 0;
            i3 = dataInputStream.readInt();
            i2 = dataInputStream.readInt();
        } else {
            i4 = dataInputStream.readInt();
            i3 = dataInputStream.readInt();
            i2 = dataInputStream.readInt();
        }
        return new StreamKey(i4, i3, i2);
    }

    private static String generateDownloadId(Uri uri, String str) {
        return str != null ? str : uri.toString();
    }
}

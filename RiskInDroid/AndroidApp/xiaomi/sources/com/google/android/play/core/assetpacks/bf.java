package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.bv;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

final class bf extends bv {

    /* renamed from: a  reason: collision with root package name */
    private final File f3650a;
    private final File b;
    private final NavigableMap<Long, File> c = new TreeMap();

    bf(File file, File file2) throws IOException {
        this.f3650a = file;
        this.b = file2;
        List<File> a2 = dt.a(this.f3650a, this.b);
        if (!a2.isEmpty()) {
            int size = a2.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                File file3 = a2.get(i);
                this.c.put(Long.valueOf(j), file3);
                j += file3.length();
            }
            return;
        }
        throw new by(String.format("Virtualized slice archive empty for %s, %s", this.f3650a, this.b));
    }

    private final InputStream a(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new by(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", l));
    }

    public final long a() {
        Map.Entry<Long, File> lastEntry = this.c.lastEntry();
        return lastEntry.getKey().longValue() + lastEntry.getValue().length();
    }

    public final InputStream a(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new by(String.format("Invalid input parameters %s, %s", Long.valueOf(j), Long.valueOf(j2)));
        }
        long j3 = j + j2;
        if (j3 <= a()) {
            Long floorKey = this.c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new be(a(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(j, floorKey));
            for (File fileInputStream : this.c.subMap(floorKey, false, floorKey2, false).values()) {
                arrayList.add(new FileInputStream(fileInputStream));
            }
            arrayList.add(new be(new FileInputStream((File) this.c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new by(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", Long.valueOf(a()), Long.valueOf(j3)));
    }

    public final void close() {
    }
}

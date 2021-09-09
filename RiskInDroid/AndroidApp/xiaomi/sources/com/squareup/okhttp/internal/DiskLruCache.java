package com.squareup.okhttp.internal;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jbg;
import _m_j.jbm;
import _m_j.jbn;
import _m_j.jbo;
import _m_j.jdn;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final jbm NULL_SINK = new jbm() {
        /* class com.squareup.okhttp.internal.DiskLruCache.AnonymousClass4 */

        public final void close() throws IOException {
        }

        public final void flush() throws IOException {
        }

        public final void write(jax jax, long j) throws IOException {
            jax.O0000Oo0(j);
        }

        public final jbo timeout() {
            return jbo.NONE;
        }
    };
    private final int appVersion;
    private final Runnable cleanupRunnable = new Runnable() {
        /* class com.squareup.okhttp.internal.DiskLruCache.AnonymousClass1 */

        public void run() {
            synchronized (DiskLruCache.this) {
                if (!(!DiskLruCache.this.initialized) && !DiskLruCache.this.closed) {
                    try {
                        DiskLruCache.this.trimToSize();
                        if (DiskLruCache.this.journalRebuildRequired()) {
                            DiskLruCache.this.rebuildJournal();
                            DiskLruCache.this.redundantOpCount = 0;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    };
    public boolean closed;
    public final File directory;
    private final Executor executor;
    public final FileSystem fileSystem;
    public boolean hasJournalErrors;
    public boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private jay journalWriter;
    public final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0;
    public int redundantOpCount;
    private long size = 0;
    public final int valueCount;

    DiskLruCache(FileSystem fileSystem2, File file, int i, int i2, long j, Executor executor2) {
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor2;
    }

    public final synchronized void initialize() throws IOException {
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.get();
                    platform.logW("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing");
                    delete();
                    this.closed = false;
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem2, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new DiskLruCache(fileSystem2, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.O00000o() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        rebuildJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    private void readJournal() throws IOException {
        jaz O000000o2 = jbg.O000000o(this.fileSystem.source(this.journalFile));
        try {
            String O0000oO0 = O000000o2.O0000oO0();
            String O0000oO02 = O000000o2.O0000oO0();
            String O0000oO03 = O000000o2.O0000oO0();
            String O0000oO04 = O000000o2.O0000oO0();
            String O0000oO05 = O000000o2.O0000oO0();
            if (!"libcore.io.DiskLruCache".equals(O0000oO0) || !"1".equals(O0000oO02) || !Integer.toString(this.appVersion).equals(O0000oO03) || !Integer.toString(this.valueCount).equals(O0000oO04) || !"".equals(O0000oO05)) {
                throw new IOException("unexpected journal header: [" + O0000oO0 + ", " + O0000oO02 + ", " + O0000oO04 + ", " + O0000oO05 + "]");
            }
            int i = 0;
            while (true) {
                readJournalLine(O000000o2.O0000oO0());
                i++;
            }
        } finally {
            Util.closeQuietly(O000000o2);
        }
    }

    private jay newJournalWriter() throws FileNotFoundException {
        return jbg.O000000o(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
            /* class com.squareup.okhttp.internal.DiskLruCache.AnonymousClass2 */
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<DiskLruCache> cls = DiskLruCache.class;
            }

            /* access modifiers changed from: protected */
            public void onException(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                entry.currentEditor = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
        } else {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i]);
                    this.fileSystem.delete(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        jay O000000o2 = jbg.O000000o(this.fileSystem.sink(this.journalFileTmp));
        try {
            O000000o2.O00000Oo("libcore.io.DiskLruCache").O0000Oo(10);
            O000000o2.O00000Oo("1").O0000Oo(10);
            O000000o2.O0000o0O((long) this.appVersion).O0000Oo(10);
            O000000o2.O0000o0O((long) this.valueCount).O0000Oo(10);
            O000000o2.O0000Oo(10);
            for (Entry next : this.lruEntries.values()) {
                if (next.currentEditor != null) {
                    O000000o2.O00000Oo("DIRTY").O0000Oo(32);
                    O000000o2.O00000Oo(next.key);
                    O000000o2.O0000Oo(10);
                } else {
                    O000000o2.O00000Oo("CLEAN").O0000Oo(32);
                    O000000o2.O00000Oo(next.key);
                    next.writeLengths(O000000o2);
                    O000000o2.O0000Oo(10);
                }
            }
            O000000o2.close();
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
        } catch (Throwable th) {
            O000000o2.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    public final synchronized Snapshot get(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null) {
            if (entry.readable) {
                Snapshot snapshot = entry.snapshot();
                if (snapshot == null) {
                    return null;
                }
                this.redundantOpCount++;
                this.journalWriter.O00000Oo("READ").O0000Oo(32).O00000Oo(str).O0000Oo(10);
                if (journalRebuildRequired()) {
                    this.executor.execute(this.cleanupRunnable);
                }
            }
        }
    }

    public final Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    public final synchronized Editor edit(String str, long j) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j == -1 || (entry != null && entry.sequenceNumber == j)) {
            if (entry != null) {
                if (entry.currentEditor != null) {
                    return null;
                }
            }
            this.journalWriter.O00000Oo("DIRTY").O0000Oo(32).O00000Oo(str).O0000Oo(10);
            this.journalWriter.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(str);
                this.lruEntries.put(str, entry);
            }
            Editor editor = new Editor(entry);
            entry.currentEditor = editor;
            return editor;
        }
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ed, code lost:
        return;
     */
    public final synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor == editor) {
            if (z && !entry.readable) {
                int i = 0;
                while (i < this.valueCount) {
                    if (!editor.written[i]) {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    } else if (!this.fileSystem.exists(entry.dirtyFiles[i])) {
                        editor.abort();
                        return;
                    } else {
                        i++;
                    }
                }
            }
            for (int i2 = 0; i2 < this.valueCount; i2++) {
                File file = entry.dirtyFiles[i2];
                if (!z) {
                    this.fileSystem.delete(file);
                } else if (this.fileSystem.exists(file)) {
                    File file2 = entry.cleanFiles[i2];
                    this.fileSystem.rename(file, file2);
                    long j = entry.lengths[i2];
                    long size2 = this.fileSystem.size(file2);
                    entry.lengths[i2] = size2;
                    this.size = (this.size - j) + size2;
                }
            }
            this.redundantOpCount++;
            entry.currentEditor = null;
            if (entry.readable || z) {
                entry.readable = true;
                this.journalWriter.O00000Oo("CLEAN").O0000Oo(32);
                this.journalWriter.O00000Oo(entry.key);
                entry.writeLengths(this.journalWriter);
                this.journalWriter.O0000Oo(10);
                if (z) {
                    long j2 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j2;
                    entry.sequenceNumber = j2;
                }
            } else {
                this.lruEntries.remove(entry.key);
                this.journalWriter.O00000Oo("REMOVE").O0000Oo(32);
                this.journalWriter.O00000Oo(entry.key);
                this.journalWriter.O0000Oo(10);
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public final synchronized boolean remove(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        return removeEntry(entry);
    }

    public final boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.hasErrors = true;
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(entry.cleanFiles[i]);
            this.size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.O00000Oo("REMOVE").O0000Oo(32).O00000Oo(entry.key).O0000Oo(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    public final synchronized void close() throws IOException {
        if (this.initialized) {
            if (!this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(removeEntry);
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + jdn.f1779O000000o);
        }
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() {
            /* class com.squareup.okhttp.internal.DiskLruCache.AnonymousClass3 */
            final Iterator<Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
            Snapshot nextSnapshot;
            Snapshot removeSnapshot;

            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.closed) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        Snapshot snapshot = this.delegate.next().snapshot();
                        if (snapshot != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                }
            }

            public Snapshot next() {
                if (hasNext()) {
                    this.removeSnapshot = this.nextSnapshot;
                    this.nextSnapshot = null;
                    return this.removeSnapshot;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Snapshot snapshot = this.removeSnapshot;
                if (snapshot != null) {
                    try {
                        DiskLruCache.this.remove(snapshot.key);
                    } catch (IOException unused) {
                    } finally {
                        this.removeSnapshot = null;
                    }
                } else {
                    throw new IllegalStateException("remove() before next()");
                }
            }
        };
    }

    public final class Snapshot implements Closeable {
        public final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final jbn[] sources;

        private Snapshot(String str, long j, jbn[] jbnArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = jbnArr;
            this.lengths = jArr;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final jbn getSource(int i) {
            return this.sources[i];
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        public final void close() {
            for (jbn closeQuietly : this.sources) {
                Util.closeQuietly(closeQuietly);
            }
        }
    }

    public final class Editor {
        private boolean committed;
        public final Entry entry;
        public boolean hasErrors;
        public final boolean[] written;

        private Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public final jbn newSource(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (!this.entry.readable) {
                    return null;
                } else {
                    try {
                        jbn source = DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[i]);
                        return source;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        public final jbm newSink(int i) throws IOException {
            AnonymousClass1 r1;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor == this) {
                    if (!this.entry.readable) {
                        this.written[i] = true;
                    }
                    try {
                        r1 = new FaultHidingSink(DiskLruCache.this.fileSystem.sink(this.entry.dirtyFiles[i])) {
                            /* class com.squareup.okhttp.internal.DiskLruCache.Editor.AnonymousClass1 */

                            /* access modifiers changed from: protected */
                            public void onException(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.hasErrors = true;
                                }
                            }
                        };
                    } catch (FileNotFoundException unused) {
                        return DiskLruCache.NULL_SINK;
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return r1;
        }

        public final void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.hasErrors) {
                    DiskLruCache.this.completeEdit(this, false);
                    DiskLruCache.this.removeEntry(this.entry);
                } else {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.committed = true;
            }
        }

        public final void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.completeEdit(this, false);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
        public final void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.committed) {
                    DiskLruCache.this.completeEdit(this, false);
                }
            }
        }
    }

    final class Entry {
        public final File[] cleanFiles;
        public Editor currentEditor;
        public final File[] dirtyFiles;
        public final String key;
        public final long[] lengths;
        public boolean readable;
        public long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                sb.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        public final void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.valueCount) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.lengths[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
                return;
            }
            throw invalidLengths(strArr);
        }

        /* access modifiers changed from: package-private */
        public final void writeLengths(jay jay) throws IOException {
            for (long O0000o0O : this.lengths) {
                jay.O0000Oo(32).O0000o0O(O0000o0O);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public final Snapshot snapshot() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                jbn[] jbnArr = new jbn[DiskLruCache.this.valueCount];
                long[] jArr = (long[]) this.lengths.clone();
                int i = 0;
                int i2 = 0;
                while (i2 < DiskLruCache.this.valueCount) {
                    try {
                        jbnArr[i2] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (i < DiskLruCache.this.valueCount && jbnArr[i] != null) {
                            Util.closeQuietly(jbnArr[i]);
                            i++;
                        }
                        return null;
                    }
                }
                return new Snapshot(this.key, this.sequenceNumber, jbnArr, jArr);
            }
            throw new AssertionError();
        }
    }
}

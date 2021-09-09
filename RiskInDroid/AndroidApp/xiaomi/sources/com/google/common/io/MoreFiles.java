package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.io.ByteSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@GwtIncompatible
@Beta
public final class MoreFiles {
    private static final SuccessorsFunction<Path> FILE_TREE = new SuccessorsFunction<Path>() {
        /* class com.google.common.io.MoreFiles.AnonymousClass1 */

        public final Iterable<Path> successors(Path path) {
            return MoreFiles.fileTreeChildren(path);
        }
    };

    private MoreFiles() {
    }

    public static ByteSource asByteSource(Path path, OpenOption... openOptionArr) {
        return new PathByteSource(path, openOptionArr);
    }

    static final class PathByteSource extends ByteSource {
        private static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
        private final boolean followLinks;
        private final OpenOption[] options;
        public final Path path;

        private PathByteSource(Path path2, OpenOption... openOptionArr) {
            this.path = (Path) Preconditions.checkNotNull(path2);
            this.options = (OpenOption[]) openOptionArr.clone();
            this.followLinks = followLinks(this.options);
        }

        private static boolean followLinks(OpenOption[] openOptionArr) {
            for (OpenOption openOption : openOptionArr) {
                if (openOption == LinkOption.NOFOLLOW_LINKS) {
                    return false;
                }
            }
            return true;
        }

        public final InputStream openStream() throws IOException {
            return Files.newInputStream(this.path, this.options);
        }

        private BasicFileAttributes readAttributes() throws IOException {
            return Files.readAttributes(this.path, BasicFileAttributes.class, this.followLinks ? FOLLOW_LINKS : new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        }

        public final Optional<Long> sizeIfKnown() {
            try {
                BasicFileAttributes readAttributes = readAttributes();
                if (readAttributes.isDirectory() || readAttributes.isSymbolicLink()) {
                    return Optional.absent();
                }
                return Optional.of(Long.valueOf(readAttributes.size()));
            } catch (IOException unused) {
                return Optional.absent();
            }
        }

        public final long size() throws IOException {
            BasicFileAttributes readAttributes = readAttributes();
            if (readAttributes.isDirectory()) {
                throw new IOException("can't read: is a directory");
            } else if (!readAttributes.isSymbolicLink()) {
                return readAttributes.size();
            } else {
                throw new IOException("can't read: is a symbolic link");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
            if (r0 != null) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
            if (r1 != null) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            r1.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
            r2 = move-exception;
         */
        public final byte[] read() throws IOException {
            SeekableByteChannel newByteChannel = Files.newByteChannel(this.path, this.options);
            byte[] byteArray = ByteStreams.toByteArray(Channels.newInputStream(newByteChannel), newByteChannel.size());
            if (newByteChannel != null) {
                newByteChannel.close();
            }
            return byteArray;
            throw th;
        }

        public final CharSource asCharSource(Charset charset) {
            if (this.options.length == 0) {
                return new ByteSource.AsCharSource(charset) {
                    /* class com.google.common.io.MoreFiles.PathByteSource.AnonymousClass1 */

                    public Stream<String> lines() throws IOException {
                        return Files.lines(PathByteSource.this.path, this.charset);
                    }
                };
            }
            return super.asCharSource(charset);
        }

        public final String toString() {
            return "MoreFiles.asByteSource(" + this.path + ", " + Arrays.toString(this.options) + ")";
        }
    }

    public static ByteSink asByteSink(Path path, OpenOption... openOptionArr) {
        return new PathByteSink(path, openOptionArr);
    }

    static final class PathByteSink extends ByteSink {
        private final OpenOption[] options;
        private final Path path;

        private PathByteSink(Path path2, OpenOption... openOptionArr) {
            this.path = (Path) Preconditions.checkNotNull(path2);
            this.options = (OpenOption[]) openOptionArr.clone();
        }

        public final OutputStream openStream() throws IOException {
            return Files.newOutputStream(this.path, this.options);
        }

        public final String toString() {
            return "MoreFiles.asByteSink(" + this.path + ", " + Arrays.toString(this.options) + ")";
        }
    }

    public static CharSource asCharSource(Path path, Charset charset, OpenOption... openOptionArr) {
        return asByteSource(path, openOptionArr).asCharSource(charset);
    }

    public static CharSink asCharSink(Path path, Charset charset, OpenOption... openOptionArr) {
        return asByteSink(path, openOptionArr).asCharSink(charset);
    }

    public static ImmutableList<Path> listFiles(Path path) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        try {
            newDirectoryStream = Files.newDirectoryStream(path);
            ImmutableList<Path> copyOf = ImmutableList.copyOf(newDirectoryStream);
            if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            return copyOf;
        } catch (DirectoryIteratorException e) {
            throw e.getCause();
        } catch (Throwable th) {
            r0.addSuppressed(th);
        }
        throw th;
    }

    public static Traverser<Path> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    public static Iterable<Path> fileTreeChildren(Path path) {
        if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            return ImmutableList.of();
        }
        try {
            return listFiles(path);
        } catch (IOException e) {
            throw new DirectoryIteratorException(e);
        }
    }

    public static Predicate<Path> isDirectory(LinkOption... linkOptionArr) {
        final LinkOption[] linkOptionArr2 = (LinkOption[]) linkOptionArr.clone();
        return new Predicate<Path>() {
            /* class com.google.common.io.MoreFiles.AnonymousClass2 */

            public /* synthetic */ boolean test(T t) {
                return Predicate.CC.$default$test(this, t);
            }

            public final boolean apply(Path path) {
                return Files.isDirectory(path, linkOptionArr2);
            }

            public final String toString() {
                return "MoreFiles.isDirectory(" + Arrays.toString(linkOptionArr2) + ")";
            }
        };
    }

    private static boolean isDirectory(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) throws IOException {
        return ((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, linkOptionArr)).readAttributes().isDirectory();
    }

    public static Predicate<Path> isRegularFile(LinkOption... linkOptionArr) {
        final LinkOption[] linkOptionArr2 = (LinkOption[]) linkOptionArr.clone();
        return new Predicate<Path>() {
            /* class com.google.common.io.MoreFiles.AnonymousClass3 */

            public /* synthetic */ boolean test(T t) {
                return Predicate.CC.$default$test(this, t);
            }

            public final boolean apply(Path path) {
                return Files.isRegularFile(path, linkOptionArr2);
            }

            public final String toString() {
                return "MoreFiles.isRegularFile(" + Arrays.toString(linkOptionArr2) + ")";
            }
        };
    }

    public static boolean equal(Path path, Path path2) throws IOException {
        Preconditions.checkNotNull(path);
        Preconditions.checkNotNull(path2);
        if (Files.isSameFile(path, path2)) {
            return true;
        }
        ByteSource asByteSource = asByteSource(path, new OpenOption[0]);
        ByteSource asByteSource2 = asByteSource(path2, new OpenOption[0]);
        long longValue = asByteSource.sizeIfKnown().or((Object) 0L).longValue();
        long longValue2 = asByteSource2.sizeIfKnown().or((Object) 0L).longValue();
        if (longValue == 0 || longValue2 == 0 || longValue == longValue2) {
            return asByteSource.contentEquals(asByteSource2);
        }
        return false;
    }

    public static void touch(Path path) throws IOException {
        Preconditions.checkNotNull(path);
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
        } catch (NoSuchFileException unused) {
            try {
                Files.createFile(path, new FileAttribute[0]);
            } catch (FileAlreadyExistsException unused2) {
            }
        }
    }

    public static void createParentDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path parent = path.toAbsolutePath().normalize().getParent();
        if (parent != null && !Files.isDirectory(parent, new LinkOption[0])) {
            Files.createDirectories(parent, fileAttributeArr);
            if (!Files.isDirectory(parent, new LinkOption[0])) {
                throw new IOException("Unable to create parent directories of ".concat(String.valueOf(path)));
            }
        }
    }

    public static String getFileExtension(Path path) {
        String path2;
        int lastIndexOf;
        Path fileName = path.getFileName();
        if (fileName == null || (lastIndexOf = (path2 = fileName.toString()).lastIndexOf(46)) == -1) {
            return "";
        }
        return path2.substring(lastIndexOf + 1);
    }

    public static String getNameWithoutExtension(Path path) {
        Path fileName = path.getFileName();
        if (fileName == null) {
            return "";
        }
        String path2 = fileName.toString();
        int lastIndexOf = path2.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return path2;
        }
        return path2.substring(0, lastIndexOf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        r5 = r2;
        r2 = r7;
        r7 = r5;
     */
    public static void deleteRecursively(Path path, RecursiveDeleteOption... recursiveDeleteOptionArr) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        Throwable th;
        Throwable th2;
        Path parentPath = getParentPath(path);
        Collection<IOException> collection = null;
        if (parentPath != null) {
            boolean z = false;
            try {
                newDirectoryStream = Files.newDirectoryStream(parentPath);
                if (newDirectoryStream instanceof SecureDirectoryStream) {
                    z = true;
                    collection = deleteRecursivelySecure((SecureDirectoryStream) newDirectoryStream, path.getFileName());
                }
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
                if (!z) {
                    checkAllowsInsecure(path, recursiveDeleteOptionArr);
                    collection = deleteRecursivelyInsecure(path);
                }
            } catch (IOException e) {
                if (collection != null) {
                    collection.add(e);
                } else {
                    throw e;
                }
            }
            if (collection != null) {
                throwDeleteFailed(path, collection);
                return;
            }
            return;
        }
        throw new FileSystemException(path.toString(), null, "can't delete recursively");
        throw th;
        if (newDirectoryStream != null) {
            if (th2 != null) {
                try {
                    newDirectoryStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            } else {
                newDirectoryStream.close();
            }
        }
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        r3 = r2;
        r2 = r5;
        r5 = r3;
     */
    public static void deleteDirectoryContents(Path path, RecursiveDeleteOption... recursiveDeleteOptionArr) throws IOException {
        DirectoryStream<Path> newDirectoryStream;
        Throwable th;
        Throwable th2;
        Collection<IOException> collection;
        Collection<IOException> collection2 = null;
        try {
            newDirectoryStream = Files.newDirectoryStream(path);
            if (newDirectoryStream instanceof SecureDirectoryStream) {
                collection = deleteDirectoryContentsSecure((SecureDirectoryStream) newDirectoryStream);
            } else {
                checkAllowsInsecure(path, recursiveDeleteOptionArr);
                collection = deleteDirectoryContentsInsecure(newDirectoryStream);
            }
            collection2 = collection;
            if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
        } catch (IOException e) {
            if (collection2 != null) {
                collection2.add(e);
            } else {
                throw e;
            }
        }
        if (collection2 != null) {
            throwDeleteFailed(path, collection2);
            return;
        }
        return;
        throw th;
        if (newDirectoryStream != null) {
            if (th2 != null) {
                try {
                    newDirectoryStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            } else {
                newDirectoryStream.close();
            }
        }
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        r5 = r7;
        r7 = r6;
        r6 = r5;
     */
    private static Collection<IOException> deleteRecursivelySecure(SecureDirectoryStream<Path> secureDirectoryStream, Path path) {
        SecureDirectoryStream<Path> newDirectoryStream;
        Throwable th;
        Throwable th2;
        Collection<IOException> collection = null;
        try {
            if (isDirectory(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                newDirectoryStream = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
                collection = deleteDirectoryContentsSecure(newDirectoryStream);
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
                if (collection == null) {
                    secureDirectoryStream.deleteDirectory(path);
                }
            } else {
                secureDirectoryStream.deleteFile(path);
            }
            return collection;
            if (newDirectoryStream != null) {
                if (th != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                } else {
                    newDirectoryStream.close();
                }
            }
            throw th2;
            throw th2;
        } catch (IOException e) {
            return addException(collection, e);
        }
    }

    private static Collection<IOException> deleteDirectoryContentsSecure(SecureDirectoryStream<Path> secureDirectoryStream) {
        Collection<IOException> collection = null;
        try {
            for (Path fileName : secureDirectoryStream) {
                collection = concat(collection, deleteRecursivelySecure(secureDirectoryStream, fileName.getFileName()));
            }
            return collection;
        } catch (DirectoryIteratorException e) {
            return addException(null, e.getCause());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        r4 = r2;
        r2 = r5;
        r5 = r4;
     */
    private static Collection<IOException> deleteRecursivelyInsecure(Path path) {
        DirectoryStream<Path> newDirectoryStream;
        Throwable th;
        Throwable th2;
        Collection<IOException> collection = null;
        try {
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                newDirectoryStream = Files.newDirectoryStream(path);
                collection = deleteDirectoryContentsInsecure(newDirectoryStream);
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
            }
            if (collection == null) {
                Files.delete(path);
            }
            return collection;
            throw th;
            if (newDirectoryStream != null) {
                if (th2 != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                } else {
                    newDirectoryStream.close();
                }
            }
            throw th;
        } catch (IOException e) {
            return addException(collection, e);
        }
    }

    private static Collection<IOException> deleteDirectoryContentsInsecure(DirectoryStream<Path> directoryStream) {
        Collection<IOException> collection = null;
        try {
            for (Path deleteRecursivelyInsecure : directoryStream) {
                collection = concat(collection, deleteRecursivelyInsecure(deleteRecursivelyInsecure));
            }
            return collection;
        } catch (DirectoryIteratorException e) {
            return addException(null, e.getCause());
        }
    }

    private static Path getParentPath(Path path) {
        Path parent = path.getParent();
        if (parent != null) {
            return parent;
        }
        if (path.getNameCount() == 0) {
            return null;
        }
        return path.getFileSystem().getPath(".", new String[0]);
    }

    private static void checkAllowsInsecure(Path path, RecursiveDeleteOption[] recursiveDeleteOptionArr) throws InsecureRecursiveDeleteException {
        if (!Arrays.asList(recursiveDeleteOptionArr).contains(RecursiveDeleteOption.ALLOW_INSECURE)) {
            throw new InsecureRecursiveDeleteException(path.toString());
        }
    }

    private static Collection<IOException> addException(Collection<IOException> collection, IOException iOException) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        collection.add(iOException);
        return collection;
    }

    private static Collection<IOException> concat(Collection<IOException> collection, Collection<IOException> collection2) {
        if (collection == null) {
            return collection2;
        }
        if (collection2 != null) {
            collection.addAll(collection2);
        }
        return collection;
    }

    private static void throwDeleteFailed(Path path, Collection<IOException> collection) throws FileSystemException {
        FileSystemException fileSystemException = new FileSystemException(path.toString(), null, "failed to delete one or more files; see suppressed exceptions for details");
        for (IOException addSuppressed : collection) {
            fileSystemException.addSuppressed(addSuppressed);
        }
        throw fileSystemException;
    }
}

package com.google.common.reflect;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;

@Beta
public final class ClassPath {
    public static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    private static final Predicate<ClassInfo> IS_TOP_LEVEL = new Predicate<ClassInfo>() {
        /* class com.google.common.reflect.ClassPath.AnonymousClass1 */

        public /* synthetic */ boolean test(T t) {
            return Predicate.CC.$default$test(this, t);
        }

        public final boolean apply(ClassInfo classInfo) {
            return classInfo.className.indexOf(36) == -1;
        }
    };
    public static final Logger logger = Logger.getLogger(ClassPath.class.getName());
    private final ImmutableSet<ResourceInfo> resources;

    private ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.resources = immutableSet;
    }

    public static ClassPath from(ClassLoader classLoader) throws IOException {
        DefaultScanner defaultScanner = new DefaultScanner();
        defaultScanner.scan(classLoader);
        return new ClassPath(defaultScanner.getResources());
    }

    public final ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public final ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }

    public final ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
    }

    public final ImmutableSet<ClassInfo> getTopLevelClasses(String str) {
        Preconditions.checkNotNull(str);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getPackageName().equals(str)) {
                builder.add((Object) next);
            }
        }
        return builder.build();
    }

    public final ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String str) {
        Preconditions.checkNotNull(str);
        String str2 = str + '.';
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getName().startsWith(str2)) {
                builder.add((Object) next);
            }
        }
        return builder.build();
    }

    @Beta
    public static class ResourceInfo {
        final ClassLoader loader;
        private final String resourceName;

        static ResourceInfo of(String str, ClassLoader classLoader) {
            if (str.endsWith(".class")) {
                return new ClassInfo(str, classLoader);
            }
            return new ResourceInfo(str, classLoader);
        }

        ResourceInfo(String str, ClassLoader classLoader) {
            this.resourceName = (String) Preconditions.checkNotNull(str);
            this.loader = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        public final URL url() {
            URL resource = this.loader.getResource(this.resourceName);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.resourceName);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset charset) {
            return Resources.asCharSource(url(), charset);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceInfo) {
                ResourceInfo resourceInfo = (ResourceInfo) obj;
                if (!this.resourceName.equals(resourceInfo.resourceName) || this.loader != resourceInfo.loader) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String toString() {
            return this.resourceName;
        }
    }

    @Beta
    public static final class ClassInfo extends ResourceInfo {
        public final String className;

        ClassInfo(String str, ClassLoader classLoader) {
            super(str, classLoader);
            this.className = ClassPath.getClassName(str);
        }

        public final String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public final String getSimpleName() {
            int lastIndexOf = this.className.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.digit().trimLeadingFrom(this.className.substring(lastIndexOf + 1));
            }
            String packageName = getPackageName();
            if (packageName.isEmpty()) {
                return this.className;
            }
            return this.className.substring(packageName.length() + 1);
        }

        public final String getName() {
            return this.className;
        }

        public final Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        public final String toString() {
            return this.className;
        }
    }

    static abstract class Scanner {
        private final Set<File> scannedUris = Sets.newHashSet();

        /* access modifiers changed from: protected */
        public abstract void scanDirectory(ClassLoader classLoader, File file) throws IOException;

        /* access modifiers changed from: protected */
        public abstract void scanJarFile(ClassLoader classLoader, JarFile jarFile) throws IOException;

        Scanner() {
        }

        public final void scan(ClassLoader classLoader) throws IOException {
            UnmodifiableIterator<Map.Entry<File, ClassLoader>> it = getClassPathEntries(classLoader).entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                scan((File) next.getKey(), (ClassLoader) next.getValue());
            }
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public final void scan(File file, ClassLoader classLoader) throws IOException {
            if (this.scannedUris.add(file.getCanonicalFile())) {
                scanFrom(file, classLoader);
            }
        }

        private void scanFrom(File file, ClassLoader classLoader) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        scanDirectory(classLoader, file);
                    } else {
                        scanJar(file, classLoader);
                    }
                }
            } catch (SecurityException e) {
                Logger logger = ClassPath.logger;
                logger.warning("Cannot access " + file + ": " + e);
            }
        }

        private void scanJar(File file, ClassLoader classLoader) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator<File> it = getClassPathFromManifest(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        scan(it.next(), classLoader);
                    }
                    scanJarFile(classLoader, jarFile);
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        @VisibleForTesting
        static ImmutableSet<File> getClassPathFromManifest(File file, Manifest manifest) {
            if (manifest == null) {
                return ImmutableSet.of();
            }
            ImmutableSet.Builder builder = ImmutableSet.builder();
            String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (value != null) {
                for (String next : ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(value)) {
                    try {
                        URL classPathEntry = getClassPathEntry(file, next);
                        if (classPathEntry.getProtocol().equals("file")) {
                            builder.add((Object) ClassPath.toFile(classPathEntry));
                        }
                    } catch (MalformedURLException unused) {
                        ClassPath.logger.warning("Invalid Class-Path entry: ".concat(String.valueOf(next)));
                    }
                }
            }
            return builder.build();
        }

        @VisibleForTesting
        static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader classLoader) {
            LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
            ClassLoader parent = classLoader.getParent();
            if (parent != null) {
                newLinkedHashMap.putAll(getClassPathEntries(parent));
            }
            UnmodifiableIterator<URL> it = getClassLoaderUrls(classLoader).iterator();
            while (it.hasNext()) {
                URL next = it.next();
                if (next.getProtocol().equals("file")) {
                    File file = ClassPath.toFile(next);
                    if (!newLinkedHashMap.containsKey(file)) {
                        newLinkedHashMap.put(file, classLoader);
                    }
                }
            }
            return ImmutableMap.copyOf(newLinkedHashMap);
        }

        private static ImmutableList<URL> getClassLoaderUrls(ClassLoader classLoader) {
            if (classLoader instanceof URLClassLoader) {
                return ImmutableList.copyOf(((URLClassLoader) classLoader).getURLs());
            }
            if (classLoader.equals(ClassLoader.getSystemClassLoader())) {
                return parseJavaClassPath();
            }
            return ImmutableList.of();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.net.MalformedURLException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:3|4|5|7|8|15|12|1) */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0039, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0050, code lost:
            com.google.common.reflect.ClassPath.logger.log(java.util.logging.Level.WARNING, "malformed classpath entry: ".concat(java.lang.String.valueOf(r2)), (java.lang.Throwable) r3);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003b */
        @VisibleForTesting
        static ImmutableList<URL> parseJavaClassPath() {
            ImmutableList.Builder builder = ImmutableList.builder();
            Iterator<String> it = Splitter.on(StandardSystemProperty.PATH_SEPARATOR.value()).split(StandardSystemProperty.JAVA_CLASS_PATH.value()).iterator();
            while (it.hasNext()) {
                String next = it.next();
                builder.add((Object) new File(next).toURI().toURL());
                builder.add((Object) new URL("file", (String) null, new File(next).getAbsolutePath()));
            }
            return builder.build();
        }

        @VisibleForTesting
        static URL getClassPathEntry(File file, String str) throws MalformedURLException {
            return new URL(file.toURI().toURL(), str);
        }
    }

    @VisibleForTesting
    static final class DefaultScanner extends Scanner {
        private final SetMultimap<ClassLoader, String> resources = MultimapBuilder.hashKeys().linkedHashSetValues().build();

        DefaultScanner() {
        }

        /* access modifiers changed from: package-private */
        public final ImmutableSet<ResourceInfo> getResources() {
            ImmutableSet.Builder builder = ImmutableSet.builder();
            for (Map.Entry next : this.resources.entries()) {
                builder.add((Object) ResourceInfo.of((String) next.getValue(), (ClassLoader) next.getKey()));
            }
            return builder.build();
        }

        /* access modifiers changed from: protected */
        public final void scanJarFile(ClassLoader classLoader, JarFile jarFile) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    this.resources.get((BasicAnnotationProcessor.ProcessingStep) classLoader).add(nextElement.getName());
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void scanDirectory(ClassLoader classLoader, File file) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            scanDirectory(file, classLoader, "", hashSet);
        }

        private void scanDirectory(File file, ClassLoader classLoader, String str, Set<File> set) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                ClassPath.logger.warning("Cannot read directory ".concat(String.valueOf(file)));
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        scanDirectory(canonicalFile, classLoader, str + name + "/", set);
                        set.remove(canonicalFile);
                    }
                } else {
                    String str2 = str + name;
                    if (!str2.equals("META-INF/MANIFEST.MF")) {
                        this.resources.get((BasicAnnotationProcessor.ProcessingStep) classLoader).add(str2);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    @VisibleForTesting
    static String getClassName(String str) {
        return str.substring(0, str.length() - 6).replace('/', '.');
    }

    @VisibleForTesting
    static File toFile(URL url) {
        Preconditions.checkArgument(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }
}

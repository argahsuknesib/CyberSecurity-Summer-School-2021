package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.OriginType;
import com.typesafe.config.impl.SimpleConfigObject;
import com.typesafe.config.impl.Tokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;

public abstract class dsz implements dsk {
    private static final ThreadLocal<LinkedList<dsz>> O00000o = new ThreadLocal<LinkedList<dsz>>() {
        /* class _m_j.dsz.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new LinkedList();
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    dsj f14909O000000o;
    private dsa O00000Oo;
    private dsi O00000o0;

    /* access modifiers changed from: protected */
    public abstract Reader O00000Oo() throws IOException;

    /* access modifiers changed from: package-private */
    public ConfigSyntax O00000o() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public ConfigSyntax O00000o0() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract dsi O00000oo();

    protected dsz() {
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(dsj dsj) {
        this.f14909O000000o = O00000o0(dsj);
        this.O00000Oo = new dtk(this);
        if (this.f14909O000000o.O00000Oo != null) {
            this.O00000o0 = dtj.O000000o(this.f14909O000000o.O00000Oo);
        } else {
            this.O00000o0 = O00000oo();
        }
    }

    protected static void O000000o(String str) {
        if (dss.O00000oo()) {
            dss.O000000o(str);
        }
    }

    /* access modifiers changed from: package-private */
    public dsk O00000Oo(String str) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        return O000000o(str, this.f14909O000000o.O000000o((String) null));
    }

    private static dso O000000o(dsn dsn) {
        if (dsn instanceof dso) {
            return (dso) dsn;
        }
        throw new ConfigException.WrongType(dsn.O00000Oo(), "", "object at file root", dsn.O00000o0().name());
    }

    public final dsh O000000o(dsj dsj) {
        LinkedList linkedList = O00000o.get();
        if (linkedList.size() < 50) {
            linkedList.addFirst(this);
            try {
                return O000000o(O00000o(dsj));
            } finally {
                linkedList.removeFirst();
                if (linkedList.isEmpty()) {
                    O00000o.remove();
                }
            }
        } else {
            throw new ConfigException.Parse(this.O00000o0, "include statements nested more than 50 times, you probably have a cycle in your includes. Trace: ".concat(String.valueOf(linkedList)));
        }
    }

    private AbstractConfigValue O00000o(dsj dsj) {
        dsi dsi;
        dsj O00000o02 = O00000o0(dsj);
        if (O00000o02.O00000Oo != null) {
            dsi = dtj.O000000o(O00000o02.O00000Oo);
        } else {
            dsi = this.O00000o0;
        }
        return O00000Oo(dsi, O00000o02);
    }

    private final AbstractConfigValue O00000Oo(dsi dsi, dsj dsj) {
        try {
            return O000000o(dsi, dsj);
        } catch (IOException e) {
            if (dsj.O00000o0) {
                return SimpleConfigObject.O00000o(dsi);
            }
            O000000o("exception loading " + dsi.O000000o() + ": " + e.getClass().getName() + ": " + e.getMessage());
            throw new ConfigException.IO(dsi, e.getClass().getName() + ": " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public AbstractConfigValue O000000o(dsi dsi, dsj dsj) throws IOException {
        Reader O00000Oo2 = O00000Oo();
        ConfigSyntax O00000o2 = O00000o();
        if (O00000o2 != null) {
            if (dss.O00000oo() && dsj.f14891O000000o != null) {
                O000000o("Overriding syntax " + dsj.f14891O000000o + " with Content-Type which specified " + O00000o2);
            }
            dsj = dsj.O000000o(O00000o2);
        }
        try {
            return O000000o(O00000Oo2, dsi, dsj);
        } finally {
            O00000Oo2.close();
        }
    }

    public final dsj O000000o() {
        return this.f14909O000000o;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public static ConfigSyntax O00000o0(String str) {
        if (str.endsWith(".json")) {
            return ConfigSyntax.JSON;
        }
        if (str.endsWith(".conf")) {
            return ConfigSyntax.CONF;
        }
        if (str.endsWith(".properties")) {
            return ConfigSyntax.PROPERTIES;
        }
        return null;
    }

    static Reader O000000o(InputStream inputStream, String str) {
        try {
            return new BufferedReader(new InputStreamReader(inputStream, str));
        } catch (UnsupportedEncodingException e) {
            throw new ConfigException.BugOrBroken("Java runtime does not support UTF-8", e);
        }
    }

    static URL O000000o(URL url, String str) {
        if (new File(str).isAbsolute()) {
            return null;
        }
        try {
            return url.toURI().resolve(new URI(str)).toURL();
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            return null;
        }
    }

    static final class O00000Oo extends dsz {
        private final String O00000Oo;
        private final String O00000o0;

        O00000Oo(String str, String str2, dsj dsj) {
            this.O00000Oo = str;
            this.O00000o0 = str2;
            O00000Oo(dsj);
        }

        /* access modifiers changed from: protected */
        public final Reader O00000Oo() throws IOException {
            throw new FileNotFoundException(this.O00000o0);
        }

        /* access modifiers changed from: protected */
        public final dsi O00000oo() {
            return dtj.O000000o(this.O00000Oo);
        }
    }

    public static dsz O000000o(String str, String str2, dsj dsj) {
        return new O00000Oo(str, str2, dsj);
    }

    static final class O0000O0o extends dsz {
        private final URL O00000Oo;
        private String O00000o0 = null;

        O0000O0o(URL url, dsj dsj) {
            this.O00000Oo = url;
            O00000Oo(dsj);
        }

        /* access modifiers changed from: protected */
        public final Reader O00000Oo() throws IOException {
            if (dss.O00000oo()) {
                O000000o("Loading config from a URL: " + this.O00000Oo.toExternalForm());
            }
            URLConnection openConnection = this.O00000Oo.openConnection();
            openConnection.connect();
            this.O00000o0 = openConnection.getContentType();
            if (this.O00000o0 != null) {
                if (dss.O00000oo()) {
                    O000000o("URL sets Content-Type: '" + this.O00000o0 + "'");
                }
                this.O00000o0 = this.O00000o0.trim();
                int indexOf = this.O00000o0.indexOf(59);
                if (indexOf >= 0) {
                    this.O00000o0 = this.O00000o0.substring(0, indexOf);
                }
            }
            return dsz.O000000o(openConnection.getInputStream(), "UTF-8");
        }

        /* access modifiers changed from: package-private */
        public final ConfigSyntax O00000o0() {
            return dsz.O00000o0(this.O00000Oo.getPath());
        }

        /* access modifiers changed from: package-private */
        public final ConfigSyntax O00000o() {
            String str = this.O00000o0;
            if (str != null) {
                if (str.equals("application/json")) {
                    return ConfigSyntax.JSON;
                }
                if (this.O00000o0.equals("text/x-java-properties")) {
                    return ConfigSyntax.PROPERTIES;
                }
                if (this.O00000o0.equals("application/hocon")) {
                    return ConfigSyntax.CONF;
                }
                if (dss.O00000oo()) {
                    O000000o("'" + this.O00000o0 + "' isn't a known content type");
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final dsk O00000Oo(String str) {
            URL O000000o2 = O000000o(this.O00000Oo, str);
            if (O000000o2 == null) {
                return null;
            }
            return O000000o(O000000o2, this.f14909O000000o.O000000o((String) null));
        }

        /* access modifiers changed from: protected */
        public final dsi O00000oo() {
            String externalForm = this.O00000Oo.toExternalForm();
            return new dtj(externalForm, -1, -1, OriginType.URL, externalForm, null);
        }

        public final String toString() {
            return getClass().getSimpleName() + "(" + this.O00000Oo.toExternalForm() + ")";
        }
    }

    public static dsz O000000o(URL url, dsj dsj) {
        if (url.getProtocol().equals("file")) {
            return O000000o(dst.O000000o(url), dsj);
        }
        return new O0000O0o(url, dsj);
    }

    static final class O000000o extends dsz {
        private final File O00000Oo;

        O000000o(File file, dsj dsj) {
            this.O00000Oo = file;
            O00000Oo(dsj);
        }

        /* access modifiers changed from: protected */
        public final Reader O00000Oo() throws IOException {
            if (dss.O00000oo()) {
                O000000o("Loading config from a file: " + this.O00000Oo);
            }
            return dsz.O000000o(new FileInputStream(this.O00000Oo), "UTF-8");
        }

        /* access modifiers changed from: package-private */
        public final ConfigSyntax O00000o0() {
            return dsz.O00000o0(this.O00000Oo.getName());
        }

        /* access modifiers changed from: package-private */
        public final dsk O00000Oo(String str) {
            File file;
            File parentFile;
            if (new File(str).isAbsolute()) {
                file = new File(str);
            } else {
                File file2 = this.O00000Oo;
                if (!new File(str).isAbsolute() && (parentFile = file2.getParentFile()) != null) {
                    file = new File(parentFile, str);
                } else {
                    file = null;
                }
            }
            if (file == null) {
                return null;
            }
            if (file.exists()) {
                return O000000o(file, this.f14909O000000o.O000000o((String) null));
            }
            return dsz.super.O00000Oo(str);
        }

        /* access modifiers changed from: protected */
        public final dsi O00000oo() {
            return dtj.O00000Oo(this.O00000Oo.getPath());
        }

        public final String toString() {
            return getClass().getSimpleName() + "(" + this.O00000Oo.getPath() + ")";
        }
    }

    public static dsz O000000o(File file, dsj dsj) {
        return new O000000o(file, dsj);
    }

    static final class O00000o extends dsz {
        private final String O00000Oo;

        O00000o(String str, dsj dsj) {
            this.O00000Oo = str;
            O00000Oo(dsj);
        }

        /* access modifiers changed from: protected */
        public final Reader O00000Oo() throws IOException {
            throw new ConfigException.BugOrBroken("reader() should not be called on resources");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00bf  */
        /* renamed from: O00000Oo */
        public dso O000000o(dsi dsi, dsj dsj) throws IOException {
            ClassLoader O00000Oo2 = dsj.O00000Oo();
            if (O00000Oo2 != null) {
                Enumeration<URL> resources = O00000Oo2.getResources(this.O00000Oo);
                if (!resources.hasMoreElements()) {
                    if (dss.O00000oo()) {
                        O000000o("Loading config from class loader " + O00000Oo2 + " but there were no resources called " + this.O00000Oo);
                    }
                    throw new IOException("resource not found on classpath: " + this.O00000Oo);
                }
                dso O00000o0 = SimpleConfigObject.O00000o0(dsi);
                while (resources.hasMoreElements()) {
                    URL nextElement = resources.nextElement();
                    if (dss.O00000oo()) {
                        O000000o("Loading config from URL " + nextElement.toExternalForm() + " from class loader " + O00000Oo2);
                    }
                    dtj dtj = (dtj) dsi;
                    InputStream inputStream = null;
                    dtj dtj2 = new dtj(dtj.f14922O000000o, dtj.O00000Oo, dtj.O00000o0, dtj.O00000o, nextElement != null ? nextElement.toExternalForm() : null, dtj.O00000oO);
                    InputStream openStream = nextElement.openStream();
                    try {
                        Reader O000000o2 = dsz.O000000o(openStream, "UTF-8");
                        try {
                            AbstractConfigValue O000000o3 = O000000o(O000000o2, dtj2, dsj);
                            O000000o2.close();
                            O00000o0 = O00000o0.O00000o0((dsg) O000000o3);
                        } catch (Throwable th) {
                            th = th;
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                }
                return O00000o0;
            }
            throw new ConfigException.BugOrBroken("null class loader; pass in a class loader or use Thread.currentThread().setContextClassLoader()");
        }

        /* access modifiers changed from: package-private */
        public final ConfigSyntax O00000o0() {
            return dsz.O00000o0(this.O00000Oo);
        }

        /* access modifiers changed from: package-private */
        public final dsk O00000Oo(String str) {
            String str2;
            if (str.startsWith("/")) {
                return O000000o(str.substring(1), this.f14909O000000o.O000000o((String) null));
            }
            String str3 = this.O00000Oo;
            int lastIndexOf = str3.lastIndexOf(47);
            if (lastIndexOf < 0) {
                str2 = null;
            } else {
                str2 = str3.substring(0, lastIndexOf);
            }
            if (str2 == null) {
                return O000000o(str, this.f14909O000000o.O000000o((String) null));
            }
            return O000000o(str2 + "/" + str, this.f14909O000000o.O000000o((String) null));
        }

        /* access modifiers changed from: protected */
        public final dsi O00000oo() {
            return new dtj(this.O00000Oo, -1, -1, OriginType.RESOURCE, null, null);
        }

        public final String toString() {
            return getClass().getSimpleName() + "(" + this.O00000Oo + ")";
        }
    }

    public static dsz O000000o(String str, dsj dsj) {
        if (dsj.O00000Oo() != null) {
            return new O00000o(str, dsj);
        }
        throw new ConfigException.BugOrBroken("null class loader; pass in a class loader or use Thread.currentThread().setContextClassLoader()");
    }

    static final class O00000o0 extends dsz {
        private final Properties O00000Oo;

        O00000o0(Properties properties, dsj dsj) {
            this.O00000Oo = properties;
            O00000Oo(dsj);
        }

        /* access modifiers changed from: protected */
        public final Reader O00000Oo() throws IOException {
            throw new ConfigException.BugOrBroken("reader() should not be called on props");
        }

        /* access modifiers changed from: package-private */
        public final ConfigSyntax O00000o0() {
            return ConfigSyntax.PROPERTIES;
        }

        /* access modifiers changed from: protected */
        public final dsi O00000oo() {
            return dtj.O000000o("properties");
        }

        public final String toString() {
            return getClass().getSimpleName() + "(" + this.O00000Oo.size() + " props)";
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ AbstractConfigValue O000000o(dsi dsi, dsj dsj) throws IOException {
            if (dss.O00000oo()) {
                O000000o("Loading config from properties " + this.O00000Oo);
            }
            return dtd.O000000o(dsi, this.O00000Oo);
        }
    }

    public static dsz O000000o(Properties properties, dsj dsj) {
        return new O00000o0(properties, dsj);
    }

    private dsj O00000o0(dsj dsj) {
        ConfigSyntax configSyntax = dsj.f14891O000000o;
        if (configSyntax == null) {
            configSyntax = O00000o0();
        }
        if (configSyntax == null) {
            configSyntax = ConfigSyntax.CONF;
        }
        dsj O000000o2 = dsj.O000000o(configSyntax);
        dsb O000000o3 = dss.O000000o();
        if (O000000o2.O00000o != O000000o3) {
            if (O000000o2.O00000o != null) {
                O000000o2 = O000000o2.O000000o(O000000o2.O00000o.O000000o(O000000o3));
            } else {
                O000000o2 = O000000o2.O000000o(O000000o3);
            }
        }
        return O000000o2.O000000o(dtl.O00000Oo(O000000o2.O00000o));
    }

    /* access modifiers changed from: protected */
    public final AbstractConfigValue O000000o(Reader reader, dsi dsi, dsj dsj) throws IOException {
        if (dsj.f14891O000000o == ConfigSyntax.PROPERTIES) {
            return dtd.O000000o(reader, dsi);
        }
        return dta.O000000o(Tokenizer.O000000o(dsi, reader, dsj.f14891O000000o), dsi, dsj, this.O00000Oo);
    }

    public final dsh O00000oO() {
        return O000000o(O00000o(this.f14909O000000o));
    }
}

package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class jhe extends jgw {
    static Properties O00000Oo;
    static String[] O00000o0 = new String[0];
    Properties O00000o;
    Pattern O00000oO = Pattern.compile("(.*)\\((.*?)\\)");
    StringBuilder O00000oo = new StringBuilder();
    ThreadLocal<String> O0000O0o = new ThreadLocal<>();
    ThreadLocal<String[]> O0000OOo = new ThreadLocal<>();

    public jhe() {
        InputStream openStream;
        Properties properties = O00000Oo;
        if (properties != null) {
            this.O00000o = new Properties(properties);
            return;
        }
        InputStream resourceAsStream = getClass().getResourceAsStream("/isoparser-default.properties");
        try {
            this.O00000o = new Properties();
            try {
                this.O00000o.load(resourceAsStream);
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Enumeration<URL> resources = (contextClassLoader == null ? ClassLoader.getSystemClassLoader() : contextClassLoader).getResources("isoparser-custom.properties");
                while (resources.hasMoreElements()) {
                    openStream = resources.nextElement().openStream();
                    this.O00000o.load(openStream);
                    openStream.close();
                }
                O00000Oo = this.O00000o;
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th) {
                openStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                resourceAsStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th2;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:14:0x0089 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x0054 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final jhd O000000o(String str, byte[] bArr, String str2) {
        String str3;
        String str4;
        Object obj;
        if (bArr == null) {
            String property = this.O00000o.getProperty(str);
            str3 = property;
            if (property == null) {
                StringBuilder sb = this.O00000oo;
                sb.append(str2);
                sb.append('-');
                sb.append(str);
                String sb2 = sb.toString();
                this.O00000oo.setLength(0);
                str3 = this.O00000o.getProperty(sb2);
            }
        } else if ("uuid".equals(str)) {
            Properties properties = this.O00000o;
            String property2 = properties.getProperty("uuid[" + jkx.O000000o(bArr).toUpperCase() + "]");
            str3 = property2;
            if (property2 == null) {
                Properties properties2 = this.O00000o;
                str3 = properties2.getProperty(String.valueOf(str2) + "-uuid[" + jkx.O000000o(bArr).toUpperCase() + "]");
            }
            if (str3 == null) {
                str3 = this.O00000o.getProperty("uuid");
            }
        } else {
            throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
        }
        if (str3 == null) {
            str3 = this.O00000o.getProperty("default");
        }
        if (str3 != null) {
            if (!str3.endsWith(")")) {
                this.O0000OOo.set(O00000o0);
                obj = this.O0000O0o;
                str4 = str3;
            } else {
                Matcher matcher = this.O00000oO.matcher(str3);
                if (matcher.matches()) {
                    this.O0000O0o.set(matcher.group(1));
                    if (matcher.group(2).length() == 0) {
                        obj = this.O0000OOo;
                        str4 = O00000o0;
                    } else {
                        Object obj2 = this.O0000OOo;
                        String split = matcher.group(2).length() > 0 ? matcher.group(2).split(",") : new String[0];
                        obj = obj2;
                        str4 = split;
                    }
                } else {
                    throw new RuntimeException("Cannot work with that constructor: ".concat(String.valueOf(str3)));
                }
            }
            obj.set(str4);
            String[] strArr = this.O0000OOo.get();
            try {
                Class<?> cls = Class.forName(this.O0000O0o.get());
                if (strArr.length <= 0) {
                    return (jhd) cls.newInstance();
                }
                Class[] clsArr = new Class[strArr.length];
                Object[] objArr = new Object[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    if ("userType".equals(strArr[i])) {
                        objArr[i] = bArr;
                        clsArr[i] = byte[].class;
                    } else if ("type".equals(strArr[i])) {
                        objArr[i] = str;
                        clsArr[i] = String.class;
                    } else if ("parent".equals(strArr[i])) {
                        objArr[i] = str2;
                        clsArr[i] = String.class;
                    } else {
                        throw new InternalError("No such param: " + strArr[i]);
                    }
                }
                return (jhd) cls.getConstructor(clsArr).newInstance(objArr);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException(e5);
            }
        } else {
            throw new RuntimeException("No box object found for ".concat(String.valueOf(str)));
        }
    }
}

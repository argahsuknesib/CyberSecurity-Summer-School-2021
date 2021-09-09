package _m_j;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class eqx {
    private static eqx O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, Object> f15735O000000o = new ConcurrentHashMap();
    private Map<String, Object> O00000o0 = new ConcurrentHashMap();

    private eqx() {
        O00000Oo();
    }

    public static synchronized eqx O000000o() {
        eqx eqx;
        synchronized (eqx.class) {
            if (O00000Oo == null) {
                O00000Oo = new eqx();
            }
            eqx = O00000Oo;
        }
        return eqx;
    }

    public static String O00000Oo(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    public final Object O000000o(String str, String str2) {
        return this.f15735O000000o.get(O00000Oo(str, str2));
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:52|53|54|55|56) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x012d */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0124 A[SYNTHETIC, Splitter:B:50:0x0124] */
    private void O00000Oo() {
        InputStream inputStream;
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        try {
            ClassLoader[] classLoaderArr = {eqx.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                ClassLoader classLoader = classLoaderArr[i];
                if (classLoader != null) {
                    arrayList.add(classLoader);
                }
            }
            for (ClassLoader resources : (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()])) {
                Enumeration<URL> resources2 = resources.getResources("META-INF/smack.providers");
                while (resources2.hasMoreElements()) {
                    inputStream = null;
                    inputStream = resources2.nextElement().openStream();
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                    newPullParser.setInput(inputStream, "UTF-8");
                    int eventType = newPullParser.getEventType();
                    do {
                        if (eventType == 2) {
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText3 = newPullParser.nextText();
                                String O00000Oo2 = O00000Oo(nextText, nextText2);
                                if (!this.O00000o0.containsKey(O00000Oo2)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (eqv.class.isAssignableFrom(cls)) {
                                            map2 = this.O00000o0;
                                            obj2 = cls.newInstance();
                                        } else if (eqp.class.isAssignableFrom(cls)) {
                                            map2 = this.O00000o0;
                                            obj2 = cls;
                                        }
                                        map2.put(O00000Oo2, obj2);
                                    } catch (ClassNotFoundException e) {
                                        e = e;
                                        e.printStackTrace();
                                        eventType = newPullParser.next();
                                        if (eventType == 1) {
                                            inputStream.close();
                                        }
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText4 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText5 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText6 = newPullParser.nextText();
                                String O00000Oo3 = O00000Oo(nextText4, nextText5);
                                if (!this.f15735O000000o.containsKey(O00000Oo3)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (eqw.class.isAssignableFrom(cls2)) {
                                            map = this.f15735O000000o;
                                            obj = cls2.newInstance();
                                        } else if (eqs.class.isAssignableFrom(cls2)) {
                                            map = this.f15735O000000o;
                                            obj = cls2;
                                        }
                                        map.put(O00000Oo3, obj);
                                    } catch (ClassNotFoundException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        eventType = newPullParser.next();
                                        if (eventType == 1) {
                                        }
                                    }
                                }
                            }
                        }
                        eventType = newPullParser.next();
                    } while (eventType == 1);
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}

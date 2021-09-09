package _m_j;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class eqh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f15723O000000o = 5000;
    private static int O00000Oo = 330000;
    private static int O00000o = 330000;
    private static int O00000o0 = 600000;
    private static Vector<String> O00000oO = new Vector<>();

    private eqh() {
    }

    private static int O000000o(XmlPullParser xmlPullParser, int i) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String O000000o() {
        return "3.1.0";
    }

    public static int O00000Oo() {
        return O00000Oo;
    }

    private static ClassLoader[] O00000o() {
        ClassLoader[] classLoaderArr = {eqh.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public static int O00000o0() {
        return O00000o0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:34|38|39|40|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00ba */
    static {
        InputStream inputStream;
        try {
            for (ClassLoader resources : O00000o()) {
                Enumeration<URL> resources2 = resources.getResources("META-INF/smack-config.xml");
                while (resources2.hasMoreElements()) {
                    inputStream = null;
                    try {
                        inputStream = resources2.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(inputStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("className")) {
                                    String nextText = newPullParser.nextText();
                                    Class.forName(nextText);
                                    System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: ".concat(String.valueOf(nextText)));
                                } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                    f15723O000000o = O000000o(newPullParser, f15723O000000o);
                                } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                    O00000Oo = O000000o(newPullParser, O00000Oo);
                                } else if (newPullParser.getName().equals("mechName")) {
                                    O00000oO.add(newPullParser.nextText());
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}

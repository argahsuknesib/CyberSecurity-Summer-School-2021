package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

public final class jng implements jnf {

    /* renamed from: O000000o  reason: collision with root package name */
    private Properties f1970O000000o = new Properties();
    private boolean O00000Oo;

    public final String O00000Oo() {
        return "org/wltea/analyzer/dic/main2012.dic";
    }

    public final String O00000o0() {
        return "org/wltea/analyzer/dic/quantifier.dic";
    }

    public jng() {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("IKAnalyzer.cfg.xml");
        if (resourceAsStream != null) {
            try {
                this.f1970O000000o.loadFromXML(resourceAsStream);
            } catch (InvalidPropertiesFormatException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean O000000o() {
        return this.O00000Oo;
    }

    public final void O000000o(boolean z) {
        this.O00000Oo = true;
    }

    public final List<String> O00000o() {
        String[] split;
        ArrayList arrayList = new ArrayList(2);
        String property = this.f1970O000000o.getProperty("ext_dict");
        if (!(property == null || (split = property.split(";")) == null)) {
            for (String str : split) {
                if (str != null && !"".equals(str.trim())) {
                    arrayList.add(str.trim());
                }
            }
        }
        return arrayList;
    }

    public final List<String> O00000oO() {
        String[] split;
        ArrayList arrayList = new ArrayList(2);
        String property = this.f1970O000000o.getProperty("ext_stopwords");
        if (!(property == null || (split = property.split(";")) == null)) {
            for (String str : split) {
                if (str != null && !"".equals(str.trim())) {
                    arrayList.add(str.trim());
                }
            }
        }
        return arrayList;
    }
}

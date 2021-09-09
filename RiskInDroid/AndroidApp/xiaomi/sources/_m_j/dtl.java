package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import com.typesafe.config.impl.SimpleConfigObject;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

final class dtl implements dsw {

    /* renamed from: O000000o  reason: collision with root package name */
    private dsb f14925O000000o;

    interface O000000o {
        dsk O000000o(String str, dsj dsj);
    }

    dtl(dsb dsb) {
        this.f14925O000000o = dsb;
    }

    public final dsh O000000o(dsa dsa, String str) {
        dsh O00000o = O00000o(dsa, str);
        dsb dsb = this.f14925O000000o;
        return dsb != null ? O00000o.O000000o(dsb.O000000o(dsa, str)) : O00000o;
    }

    private static dsh O00000o(dsa dsa, String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url != null) {
            return O00000Oo(dsa, url);
        }
        return O000000o(new O00000o0(dsa), str, dsa.O000000o());
    }

    public final dsh O000000o(dsa dsa, URL url) {
        dsh O00000Oo2 = O00000Oo(dsa, url);
        dsb dsb = this.f14925O000000o;
        return (dsb == null || !(dsb instanceof dse)) ? O00000Oo2 : O00000Oo2.O000000o(((dse) dsb).O000000o(dsa, url));
    }

    static dsh O00000Oo(dsa dsa, URL url) {
        return drz.O000000o(url, dsa.O000000o()).O000000o();
    }

    public final dsh O000000o(dsa dsa, File file) {
        dsh O00000Oo2 = O00000Oo(dsa, file);
        dsb dsb = this.f14925O000000o;
        return (dsb == null || !(dsb instanceof dsd)) ? O00000Oo2 : O00000Oo2.O000000o(((dsd) dsb).O000000o(dsa, file));
    }

    static dsh O00000Oo(dsa dsa, File file) {
        return drz.O000000o(file, dsa.O000000o()).O000000o();
    }

    public final dsh O00000Oo(dsa dsa, String str) {
        dsh O00000o02 = O00000o0(dsa, str);
        dsb dsb = this.f14925O000000o;
        return (dsb == null || !(dsb instanceof dsc)) ? O00000o02 : O00000o02.O000000o(((dsc) dsb).O00000Oo(dsa, str));
    }

    static dsh O00000o0(dsa dsa, String str) {
        return drz.O000000o(str, dsa.O000000o()).O000000o();
    }

    public final dsb O000000o(dsb dsb) {
        if (this != dsb) {
            dsb dsb2 = this.f14925O000000o;
            if (dsb2 == dsb) {
                return this;
            }
            if (dsb2 != null) {
                return new dtl(dsb2.O000000o(dsb));
            }
            return new dtl(dsb);
        }
        throw new ConfigException.BugOrBroken("trying to create includer cycle");
    }

    static class O00000o0 implements O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final dsa f14927O000000o;

        O00000o0(dsa dsa) {
            this.f14927O000000o = dsa;
        }

        public final dsk O000000o(String str, dsj dsj) {
            dsk O000000o2 = this.f14927O000000o.O000000o(str);
            if (O000000o2 != null) {
                return O000000o2;
            }
            return dsz.O000000o(str, "include was not found: '" + str + "'", dsj);
        }
    }

    static dsh O000000o(O000000o o000000o, String str, dsj dsj) {
        boolean z;
        if (str.endsWith(".conf") || str.endsWith(".json") || str.endsWith(".properties")) {
            dsk O000000o2 = o000000o.O000000o(str, dsj);
            return O000000o2.O000000o(O000000o2.O000000o().O000000o(dsj.O00000o0));
        }
        dsk O000000o3 = o000000o.O000000o(str + ".conf", dsj);
        dsk O000000o4 = o000000o.O000000o(str + ".json", dsj);
        dsk O000000o5 = o000000o.O000000o(str + ".properties", dsj);
        ArrayList<ConfigException.IO> arrayList = new ArrayList<>();
        ConfigSyntax configSyntax = dsj.f14891O000000o;
        dsh O00000o02 = SimpleConfigObject.O00000o0(dtj.O000000o(str));
        if (configSyntax == null || configSyntax == ConfigSyntax.CONF) {
            try {
                O00000o02 = O000000o3.O000000o(O000000o3.O000000o().O000000o(false).O000000o(ConfigSyntax.CONF));
                z = true;
            } catch (ConfigException.IO e) {
                arrayList.add(e);
            }
            if (configSyntax == null || configSyntax == ConfigSyntax.JSON) {
                O00000o02 = O00000o02.O000000o(O000000o4.O000000o(O000000o4.O000000o().O000000o(false).O000000o(ConfigSyntax.JSON)));
                z = true;
            }
            if (configSyntax == null || configSyntax == ConfigSyntax.PROPERTIES) {
                O00000o02 = O00000o02.O000000o(O000000o5.O000000o(O000000o5.O000000o().O000000o(false).O000000o(ConfigSyntax.PROPERTIES)));
                z = true;
            }
            if (dsj.O00000o0 && !z) {
                if (dss.O00000oo()) {
                    dss.O000000o("Did not find '" + str + "' with any extension (.conf, .json, .properties); exceptions should have been logged above.");
                }
                if (!arrayList.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (ConfigException.IO message : arrayList) {
                        sb.append(message.getMessage());
                        sb.append(", ");
                    }
                    sb.setLength(sb.length() - 2);
                    throw new ConfigException.IO(dtj.O000000o(str), sb.toString(), (Throwable) arrayList.get(0));
                }
                throw new ConfigException.BugOrBroken("should not be reached: nothing found but no exceptions thrown");
            } else if (z && dss.O00000oo()) {
                dss.O000000o("Did not find '" + str + "' with any extension (.conf, .json, .properties); but '" + str + "' is allowed to be missing. Exceptions from load attempts should have been logged above.");
                return O00000o02;
            }
        }
        z = false;
        try {
            O00000o02 = O00000o02.O000000o(O000000o4.O000000o(O000000o4.O000000o().O000000o(false).O000000o(ConfigSyntax.JSON)));
            z = true;
        } catch (ConfigException.IO e2) {
            arrayList.add(e2);
        }
        try {
            O00000o02 = O00000o02.O000000o(O000000o5.O000000o(O000000o5.O000000o().O000000o(false).O000000o(ConfigSyntax.PROPERTIES)));
            z = true;
        } catch (ConfigException.IO e3) {
            arrayList.add(e3);
        }
        if (dsj.O00000o0) {
        }
        return z ? O00000o02 : O00000o02;
    }

    static class O00000Oo implements dsw {

        /* renamed from: O000000o  reason: collision with root package name */
        final dsb f14926O000000o;

        public final dsb O000000o(dsb dsb) {
            return this;
        }

        O00000Oo(dsb dsb) {
            this.f14926O000000o = dsb;
        }

        public final dsh O000000o(dsa dsa, String str) {
            return this.f14926O000000o.O000000o(dsa, str);
        }

        public final dsh O00000Oo(dsa dsa, String str) {
            dsb dsb = this.f14926O000000o;
            if (dsb instanceof dsc) {
                return ((dsc) dsb).O00000Oo(dsa, str);
            }
            return dtl.O00000o0(dsa, str);
        }

        public final dsh O000000o(dsa dsa, URL url) {
            dsb dsb = this.f14926O000000o;
            if (dsb instanceof dse) {
                return ((dse) dsb).O000000o(dsa, url);
            }
            return dtl.O00000Oo(dsa, url);
        }

        public final dsh O000000o(dsa dsa, File file) {
            dsb dsb = this.f14926O000000o;
            if (dsb instanceof dsd) {
                return ((dsd) dsb).O000000o(dsa, file);
            }
            return dtl.O00000Oo(dsa, file);
        }
    }

    static dsw O00000Oo(dsb dsb) {
        if (dsb instanceof dsw) {
            return (dsw) dsb;
        }
        return new O00000Oo(dsb);
    }
}

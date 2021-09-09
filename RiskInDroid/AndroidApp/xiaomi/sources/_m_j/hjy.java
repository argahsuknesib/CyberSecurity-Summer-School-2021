package _m_j;

import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"install", "", "Ljava/net/CookieManager;", "url", "", "name", "value", "domain", "path", "app-support-util_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class hjy {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public static final void O000000o(CookieManager cookieManager, String str, String str2, String str3, String str4, String str5) {
        boolean z;
        ixe.O00000o(cookieManager, "<this>");
        ixe.O00000o(str, "url");
        ixe.O00000o(str2, "name");
        ixe.O00000o(str3, "value");
        ixe.O00000o(str4, "domain");
        ixe.O00000o(str5, "path");
        if (!iyo.O000000o((CharSequence) str2) && !iyo.O000000o((CharSequence) str3)) {
            List<HttpCookie> list = cookieManager.getCookieStore().get(new URI(str));
            ixe.O00000Oo(list, "cookieStore.get(URI(url))");
            Iterable iterable = list;
            boolean z2 = true;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HttpCookie httpCookie = (HttpCookie) it.next();
                    if (!ixe.O000000o((Object) httpCookie.getName(), (Object) str2) || !ixe.O000000o((Object) httpCookie.getValue(), (Object) str3) || !ixe.O000000o((Object) httpCookie.getDomain(), (Object) str4) || !ixe.O000000o((Object) httpCookie.getPath(), (Object) str5)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                gsr.O00000Oo(cookieManager, str, str2, str3, str4, str5);
            }
        }
    }
}

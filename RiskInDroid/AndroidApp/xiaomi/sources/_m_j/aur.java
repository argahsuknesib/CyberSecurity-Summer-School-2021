package _m_j;

import com.github.scribejava.core.exceptions.OAuthParametersMissingException;
import java.util.Collections;

public final class aur implements auq {
    public final String O000000o(avd avd) {
        String str;
        avt.O000000o(avd, "Cannot extract base string from a null object");
        if (avd.O0000O0o == null || avd.O0000O0o.size() <= 0) {
            throw new OAuthParametersMissingException(avd);
        }
        String O000000o2 = avs.O000000o(avd.O00000Oo.name());
        if (avd.f12636O000000o.startsWith("http://") && (avd.f12636O000000o.endsWith(":80") || avd.f12636O000000o.contains(":80/"))) {
            str = avd.f12636O000000o.replaceAll("\\?.*", "").replaceAll(":80", "");
        } else if (!avd.f12636O000000o.startsWith("https://") || (!avd.f12636O000000o.endsWith(":443") && !avd.f12636O000000o.contains(":443/"))) {
            str = avd.f12636O000000o.replaceAll("\\?.*", "");
        } else {
            str = avd.f12636O000000o.replaceAll("\\?.*", "").replaceAll(":443", "");
        }
        String O000000o3 = avs.O000000o(str);
        avf avf = new avf();
        avf.O000000o(avd.O00000Oo());
        avf.O000000o(avd.O00000o0);
        avf.O000000o(new avf(avd.O0000O0o));
        avf avf2 = new avf(avf.f12638O000000o);
        Collections.sort(avf2.f12638O000000o);
        return String.format("%s&%s&%s", O000000o2, O000000o3, avs.O000000o(avf2.O000000o()));
    }
}

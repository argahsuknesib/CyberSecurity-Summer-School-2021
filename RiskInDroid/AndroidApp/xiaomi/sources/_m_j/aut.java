package _m_j;

import com.github.scribejava.core.exceptions.OAuthParametersMissingException;
import java.util.Map;

public final class aut implements aus {
    public final String O000000o(avd avd) {
        avt.O000000o(avd, "Cannot extract a header from a null object");
        if (avd.O0000O0o == null || avd.O0000O0o.size() <= 0) {
            throw new OAuthParametersMissingException(avd);
        }
        Map<String, String> map = avd.O0000O0o;
        StringBuilder sb = new StringBuilder(map.size() * 20);
        sb.append("OAuth ");
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 6) {
                sb.append(", ");
            }
            sb.append(String.format("%s=\"%s\"", next.getKey(), avs.O000000o((String) next.getValue())));
        }
        if (avd.O0000OOo != null && !avd.O0000OOo.isEmpty()) {
            sb.append(", ");
            sb.append(String.format("%s=\"%s\"", "realm", avd.O0000OOo));
        }
        return sb.toString();
    }
}

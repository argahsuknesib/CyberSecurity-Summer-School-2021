package _m_j;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Collections;
import java.util.List;

public final class hdj {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<Pair<String, String>> f18813O000000o;

    public hdj(List<Pair<String, String>> list) {
        this.f18813O000000o = Collections.unmodifiableList(list);
    }

    public hdj(String str, String str2) {
        this.f18813O000000o = Collections.singletonList(new Pair(str, str2));
    }

    public final String toString() {
        if (this.f18813O000000o == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Pair next : this.f18813O000000o) {
            sb.append(TextUtils.isEmpty((CharSequence) next.first) ? "--" : (String) next.first);
            sb.append((String) next.second);
        }
        return sb.toString();
    }
}

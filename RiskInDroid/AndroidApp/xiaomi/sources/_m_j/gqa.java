package _m_j;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gqa {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int f18142O000000o = CommonApplication.getAppContext().getResources().getColor(R.color.mj_color_black_40_transparent);
    public static final int O00000Oo = CommonApplication.getAppContext().getResources().getColor(R.color.mj_color_black_30_transparent);
    private static final String O00000o = String.format("([^<>/]*)<\\s*%s\\s*([^>]*)\\s*>([^<>]*)<\\s*/%s\\s*>([^<>/]*)", "p", "p");
    public static final int O00000o0 = CommonApplication.getAppContext().getResources().getColor(R.color.mj_color_white_40_transparent);

    private static SpannableStringBuilder O000000o(List<O000000o> list, boolean z, boolean z2) {
        if (list.size() == 0) {
            return null;
        }
        int size = list.size();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            O000000o o000000o = list.get(i2);
            if (!TextUtils.isEmpty(o000000o.O00000Oo)) {
                i = O000000o(spannableStringBuilder, o000000o.O00000Oo, z ? O00000o0 : f18142O000000o, i);
            }
            i = O000000o(spannableStringBuilder, o000000o.O00000o0, O000000o(o000000o, z, z2), i);
            if (!TextUtils.isEmpty(o000000o.O00000o)) {
                i = O000000o(spannableStringBuilder, o000000o.O00000o, z ? O00000o0 : f18142O000000o, i);
            }
        }
        return spannableStringBuilder;
    }

    private static int O000000o(O000000o o000000o, boolean z, boolean z2) {
        int i = z ? O00000o0 : f18142O000000o;
        if (o000000o.O00000oO == null || !o000000o.O00000oO.containsKey("color")) {
            return i;
        }
        try {
            return Color.parseColor(o000000o.O00000oO.get("color"));
        } catch (Exception unused) {
            return i;
        }
    }

    private static int O000000o(SpannableStringBuilder spannableStringBuilder, String str, int i, int i2) {
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), i2, str.length() + i2, 17);
        return i2 + str.length();
    }

    private static HashMap<String, String> O000000o(String str) {
        Matcher matcher = Pattern.compile("([a-z]+)\\s*=\\s*\"([^\"]+)\"").matcher(str);
        HashMap<String, String> hashMap = new HashMap<>();
        while (matcher.find()) {
            if (matcher.groupCount() == 2) {
                hashMap.put(matcher.group(1), matcher.group(2));
            }
        }
        return hashMap;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18143O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public HashMap<String, String> O00000oO;

        public O000000o() {
        }

        public O000000o(String str) {
            this.O00000o0 = str;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("orig = %s\r\n", this.f18143O000000o));
            sb.append(String.format("prefix = %s\r\n", this.O00000Oo));
            sb.append(String.format("text = %s\r\n", this.O00000o0));
            sb.append(String.format("suffix = %s\r\n", this.O00000o));
            HashMap<String, String> hashMap = this.O00000oO;
            if (hashMap != null && hashMap.size() > 0) {
                for (Map.Entry next : this.O00000oO.entrySet()) {
                    sb.append(String.format("%s = %s\r\n", next.getKey(), next.getValue()));
                }
            }
            return sb.toString();
        }
    }

    public static void O000000o(TextView textView, String str, boolean z, boolean z2) {
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = Pattern.compile(O00000o).matcher(str);
                while (matcher.find()) {
                    O000000o o000000o = new O000000o();
                    o000000o.f18143O000000o = matcher.group(0);
                    o000000o.O00000Oo = matcher.group(1);
                    o000000o.O00000oO = O000000o(matcher.group(2));
                    o000000o.O00000o0 = matcher.group(3);
                    o000000o.O00000o = matcher.group(4);
                    arrayList.add(o000000o);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new O000000o(str));
                }
            }
            SpannableStringBuilder O000000o2 = O000000o(arrayList, z, z2);
            if (O000000o2 != null) {
                textView.setText(O000000o2);
            }
        } catch (Exception unused) {
            textView.setText(str);
        }
    }
}

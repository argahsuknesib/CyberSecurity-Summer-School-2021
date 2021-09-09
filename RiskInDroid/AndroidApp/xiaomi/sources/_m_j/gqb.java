package _m_j;

import _m_j.gob;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public final class gqb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Pattern f18144O000000o = Pattern.compile("[\"!$^*{}<>?|\\[\\]=\\\\]|--");
    private static WeakReference<TextView> O00000Oo = new WeakReference<>(null);

    public static String O0000O0o(String str) {
        return str != null ? str : "";
    }

    public static boolean O000000o(String str) {
        return str == null || "".equals(str) || "NULL".equals(str);
    }

    public static String O000000o(Context context, String str, float f, TextView textView, int i) {
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return str;
        }
        TextView textView2 = O00000Oo.get();
        if (textView2 == null) {
            textView2 = new TextView(context);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            O00000Oo = new WeakReference<>(textView2);
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        textView2.setText(str);
        textView2.setTextSize(0, f);
        textView.getTextScaleX();
        textView2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * ((float) i)), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        try {
            int lineStart = textView2.getLayout().getLineStart(0);
            int ellipsisStart = textView2.getLayout().getEllipsisStart(0);
            if (ellipsisStart > 0) {
                return textView2.getText().toString().substring(lineStart, ellipsisStart) + "... ";
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!(charAt == 0 || charAt == 9 || charAt == 10 || charAt == 13 || ((charAt >= ' ' && charAt <= 55295) || ((charAt >= 57344 && charAt <= 65533) || charAt >= 0))) || charAt == 169 || charAt == 174 || charAt == 8482 || charAt == 12336 || (charAt >= 9654 && charAt <= 10175) || charAt == 9000 || ((charAt >= 9193 && charAt <= 9210) || ((charAt >= 61440 && charAt <= 65535) || ((charAt >= 9986 && charAt <= 10160) || (charAt >= 62977 && charAt <= 63055))))) {
                return true;
            }
        }
        return false;
    }

    public static int O000000o(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            int codePointAt = Character.codePointAt(charSequence, i4);
            if (codePointAt >= 19968 && codePointAt <= 40879) {
                i++;
            } else if (codePointAt < 32 || codePointAt > 126) {
                i3++;
            } else {
                i2++;
            }
        }
        return (i * 2) + 0 + i2 + i3;
    }

    public static String O000000o(String str, int i, String str2) {
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int codePointAt = Character.codePointAt(str, i3);
            i2 = (codePointAt < 19968 || codePointAt > 40879) ? i2 + 1 : i2 + 2;
            if (i < i2) {
                int max = Math.max(0, i3);
                return str.substring(0, max) + str2;
            }
        }
        return str;
    }

    public static int O00000Oo(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        int i = 1;
        int i2 = 0;
        while (i <= charSequence.length() && O000000o(charSequence.subSequence(0, i)) <= 10) {
            i2 = i;
            i++;
        }
        return i2;
    }

    public static int O00000o0(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (String.valueOf(charSequence.charAt(i3)).matches("[一-龥]")) {
                i++;
            } else {
                i2++;
            }
        }
        return (i * 2) + i2;
    }

    public static String O000000o(CharSequence charSequence, int i) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            String valueOf = String.valueOf(charSequence.charAt(i3));
            i2 = valueOf.matches("[一-龥]") ? i2 + 2 : i2 + 1;
            if (i2 <= i) {
                sb.append(valueOf);
            }
            if (i2 >= i) {
                break;
            }
        }
        return sb.toString();
    }

    public static boolean O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String trim = str.trim();
        if (!TextUtils.isEmpty(trim) && TextUtils.equals(f18144O000000o.matcher(trim).replaceAll("").trim(), trim)) {
            return false;
        }
        return true;
    }

    public static boolean O000000o(CharSequence charSequence, String str) {
        if (TextUtils.isEmpty(charSequence)) {
            return true;
        }
        String trim = ((String) charSequence).trim();
        if (!TextUtils.isEmpty(trim) && TextUtils.equals(Pattern.compile(str).matcher(trim).replaceAll("").trim(), trim)) {
            return false;
        }
        return true;
    }

    public static SpannableStringBuilder O000000o(Context context, int i, int i2, ClickableSpan clickableSpan) {
        String string = context.getString(i);
        String string2 = context.getString(i2, string);
        int indexOf = string2.indexOf(string);
        if (indexOf < 0) {
            indexOf = 0;
        }
        int length = string.length() + indexOf;
        if (length > string2.length()) {
            length = string2.length() - 1;
        }
        if (indexOf > length) {
            length = indexOf;
        }
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(string2);
        valueOf.setSpan(clickableSpan, indexOf, length, 33);
        return valueOf;
    }

    public static String O000000o(Activity activity, Locale locale, int i) {
        try {
            return O000000o(activity, locale).getString(i);
        } catch (Exception unused) {
            return activity.getApplicationContext().getString(i);
        }
    }

    public static boolean O000000o(Activity activity, Locale locale, int i, TextView textView) {
        try {
            textView.setText(O000000o(activity, locale).getString(i));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static Resources O000000o(Activity activity, Locale locale) {
        Configuration configuration = activity.getApplicationContext().getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration(configuration);
            configuration2.setLocale(locale);
            return activity.getApplicationContext().createConfigurationContext(configuration2).getResources();
        }
        configuration.locale = locale;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return new Resources(activity.getApplicationContext().getAssets(), displayMetrics, configuration);
    }

    public static Uri O00000o(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("http") || str.startsWith("res")) {
            return Uri.parse(str);
        }
        return Uri.fromFile(new File(str));
    }

    public static String O00000oO(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(O00000oo(str));
            return String.format("%1$032X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] O00000oo(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String O000000o(Context context, int i) {
        return context.getString(i);
    }

    public static String O000000o(Context context, int i, int i2, Object obj) {
        return context.getResources().getQuantityString(i, i2, obj);
    }

    public static String[] O000000o(Context context) {
        return context.getResources().getStringArray(R.array.month);
    }

    public static String O000000o(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        if (objArr == null) {
            return null;
        }
        int i = length + 0;
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i * ((objArr[0] == null ? 16 : objArr[0].toString().length()) + str.length()));
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                sb.append(str);
            }
            if (objArr[i2] != null) {
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    public static byte[] O0000OOo(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String O0000Oo0(String str) {
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT < 14) {
            ArrayList<gob.O000000o> O000000o2 = gob.O000000o().O000000o(str);
            if (O000000o2.size() > 0) {
                Iterator<gob.O000000o> it = O000000o2.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().O00000o0);
                }
            }
        } else {
            ArrayList<gob.O000000o> O000000o3 = goc.O000000o().O000000o(str);
            if (O000000o3.size() > 0) {
                Iterator<gob.O000000o> it2 = O000000o3.iterator();
                while (it2.hasNext()) {
                    sb.append(it2.next().O00000o0);
                }
            }
        }
        if (TextUtils.isEmpty(sb)) {
            return str.toLowerCase(Locale.ENGLISH);
        }
        return sb.toString().toLowerCase(Locale.ENGLISH);
    }

    public static String O0000Oo(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(O00000oo(str));
            return String.format("%1$040X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void O000000o(String str, Map<String, String> map) {
        if (str != null && map != null) {
            String[] split = str.split(",");
            if (split.length > 0) {
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3 != null && split3.length == 2) {
                        map.put(split3[0], split3[1]);
                    }
                }
            }
        }
    }

    public static String O000000o(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            sb.append(",");
        }
        return sb.toString();
    }
}

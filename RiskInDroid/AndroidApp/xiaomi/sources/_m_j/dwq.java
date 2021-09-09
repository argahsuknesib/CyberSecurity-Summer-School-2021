package _m_j;

import com.google.common.collect.LinkedListMultimap;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class dwq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f15006O000000o = new ThreadLocal<SimpleDateFormat>() {
        /* class _m_j.dwq.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    };
    private static final ThreadLocal<SimpleDateFormat> O00000Oo = new ThreadLocal<SimpleDateFormat>() {
        /* class _m_j.dwq.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMM-yy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    };
    private static final ThreadLocal<SimpleDateFormat> O00000o0 = new ThreadLocal<SimpleDateFormat>() {
        /* class _m_j.dwq.AnonymousClass3 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    };

    public static LinkedListMultimap<String, String> O000000o(URI uri) {
        LinkedListMultimap<String, String> create = LinkedListMultimap.create();
        String query = uri.getQuery();
        if (query != null) {
            for (String str : query.split("&")) {
                String[] split = str.split("=");
                if (split.length >= 2) {
                    create.put(split[0], str.substring(split[0].length() + 1));
                } else {
                    create.put(split[0], "");
                }
            }
        }
        return create;
    }
}

package _m_j;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ent {

    public static class O000000o extends ens {
        public final String O000000o(Context context, String str, List<eme> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (eme next : list) {
                    buildUpon.appendQueryParameter(next.O000000o(), next.O00000Oo());
                }
                url = new URL(buildUpon.toString());
            }
            return emf.O000000o(context, url);
        }
    }

    private static int O000000o(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    private static int O000000o(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    private static int O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    private static int O000000o(List<eme> list) {
        int i = 0;
        for (eme next : list) {
            if (!TextUtils.isEmpty(next.O000000o())) {
                i += next.O000000o().length();
            }
            if (!TextUtils.isEmpty(next.O00000Oo())) {
                i += next.O00000Oo().length();
            }
        }
        return i * 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e A[SYNTHETIC, Splitter:B:42:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a2 A[Catch:{ MalformedURLException -> 0x00ab }] */
    public static String O000000o(Context context, String str, List<eme> list, ens ens) {
        String str2;
        String str3;
        String str4 = str;
        ens ens2 = ens;
        if (emf.O000000o(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                enl a2 = enp.a().m594a(str4);
                if (a2 != null) {
                    arrayList = a2.O000000o(str4);
                }
                if (!arrayList.contains(str4)) {
                    arrayList.add(str4);
                }
                Iterator<String> it = arrayList.iterator();
                String str5 = null;
                while (it.hasNext()) {
                    String next = it.next();
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        str3 = ens2.O000000o(context, next, null);
                        try {
                            if (!TextUtils.isEmpty(str3)) {
                                if (a2 != null) {
                                    try {
                                        try {
                                            a2.O000000o(new URL(next).getHost(), System.currentTimeMillis() - currentTimeMillis, (long) O000000o(ens2, next, (List<eme>) null, str3));
                                        } catch (MalformedURLException unused) {
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        if (a2 != null) {
                                        }
                                        e.printStackTrace();
                                        str5 = str2;
                                    }
                                }
                                return str3;
                            }
                            if (a2 != null) {
                                str2 = str3;
                                try {
                                    a2.O000000o(next, System.currentTimeMillis() - currentTimeMillis, (long) O000000o(ens2, next, (List<eme>) null, str3), null);
                                } catch (IOException e2) {
                                    e = e2;
                                    str3 = str2;
                                }
                            } else {
                                str2 = str3;
                            }
                            str5 = str2;
                        } catch (IOException e3) {
                            e = e3;
                            if (a2 != null) {
                            }
                            e.printStackTrace();
                            str5 = str2;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        str3 = str5;
                        if (a2 != null) {
                            str2 = str3;
                            a2.O000000o(next, System.currentTimeMillis() - currentTimeMillis, (long) O000000o(ens2, next, (List<eme>) null, str3), e);
                        } else {
                            str2 = str3;
                        }
                        e.printStackTrace();
                        str5 = str2;
                    }
                }
                return str5;
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    private static int O000000o(ens ens, String str, List<eme> list, String str2) {
        if (ens.f15658O000000o == 1) {
            return O000000o(str.length(), O000000o(str2));
        }
        if (ens.f15658O000000o != 2) {
            return -1;
        }
        return O000000o(str.length(), O000000o(list), O000000o(str2));
    }
}

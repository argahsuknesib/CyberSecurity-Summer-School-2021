package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gpz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f18135O000000o = "(\\+)?\\d{1,20}";
    private static Pattern O00000Oo = Pattern.compile("(\\+)?\\d{1,20}");
    private static HashMap<String, O000000o> O00000o;
    private static HashMap<String, O000000o> O00000o0;

    public static O000000o O000000o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        O000000o(context);
        O000000o o000000o = O00000o.get(str.toUpperCase());
        if (o000000o != null) {
            return o000000o;
        }
        return O00000o0.get(str.toUpperCase());
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x00a0=Splitter:B:45:0x00a0, B:53:0x00c5=Splitter:B:53:0x00c5, B:61:0x00ea=Splitter:B:61:0x00ea} */
    private static synchronized void O000000o(Context context) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        IOException e;
        JSONException e2;
        Exception e3;
        synchronized (gpz.class) {
            if (O00000o0 == null || O00000o == null) {
                O00000o0 = new HashMap<>();
                O00000o = new HashMap<>();
                try {
                    inputStream = context.getResources().openRawResource(Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage()) ? R.raw.smarthome_countries_cn : R.raw.smarthome_countries);
                    try {
                        byte[] bArr = new byte[512];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                                    O00000o0 = O000000o(jSONObject.getJSONArray("countries"));
                                    O00000o = O000000o(jSONObject.getJSONArray("recommend countries"));
                                    gpg.O000000o(inputStream);
                                    gpg.O000000o(byteArrayOutputStream);
                                    return;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                gsy.O00000Oo(LogType.GENERAL, "SHPhoneNumUtil", "error when load area codes" + e.getMessage());
                                gpg.O000000o(inputStream);
                                gpg.O000000o(byteArrayOutputStream);
                            } catch (JSONException e5) {
                                e2 = e5;
                                gsy.O00000Oo(LogType.GENERAL, "PhoneNumUtil", "error when parse json" + e2.getMessage());
                                gpg.O000000o(inputStream);
                                gpg.O000000o(byteArrayOutputStream);
                            } catch (Exception e6) {
                                e3 = e6;
                                try {
                                    gsy.O00000Oo(LogType.GENERAL, "PhoneNumUtil", "unknown exception" + e3.getMessage());
                                    gpg.O000000o(inputStream);
                                    gpg.O000000o(byteArrayOutputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    gpg.O000000o(inputStream);
                                    gpg.O000000o(byteArrayOutputStream);
                                    throw th;
                                }
                            }
                        }
                    } catch (IOException e7) {
                        byteArrayOutputStream = null;
                        e = e7;
                        gsy.O00000Oo(LogType.GENERAL, "SHPhoneNumUtil", "error when load area codes" + e.getMessage());
                        gpg.O000000o(inputStream);
                        gpg.O000000o(byteArrayOutputStream);
                    } catch (JSONException e8) {
                        byteArrayOutputStream = null;
                        e2 = e8;
                        gsy.O00000Oo(LogType.GENERAL, "PhoneNumUtil", "error when parse json" + e2.getMessage());
                        gpg.O000000o(inputStream);
                        gpg.O000000o(byteArrayOutputStream);
                    } catch (Exception e9) {
                        byteArrayOutputStream = null;
                        e3 = e9;
                        gsy.O00000Oo(LogType.GENERAL, "PhoneNumUtil", "unknown exception" + e3.getMessage());
                        gpg.O000000o(inputStream);
                        gpg.O000000o(byteArrayOutputStream);
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        th = th2;
                        gpg.O000000o(inputStream);
                        gpg.O000000o(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e10) {
                    byteArrayOutputStream = null;
                    e = e10;
                    inputStream = null;
                    gsy.O00000Oo(LogType.GENERAL, "SHPhoneNumUtil", "error when load area codes" + e.getMessage());
                    gpg.O000000o(inputStream);
                    gpg.O000000o(byteArrayOutputStream);
                } catch (JSONException e11) {
                    byteArrayOutputStream = null;
                    e2 = e11;
                    inputStream = null;
                    gsy.O00000Oo(LogType.GENERAL, "PhoneNumUtil", "error when parse json" + e2.getMessage());
                    gpg.O000000o(inputStream);
                    gpg.O000000o(byteArrayOutputStream);
                } catch (Exception e12) {
                    byteArrayOutputStream = null;
                    e3 = e12;
                    inputStream = null;
                    gsy.O00000Oo(LogType.GENERAL, "PhoneNumUtil", "unknown exception" + e3.getMessage());
                    gpg.O000000o(inputStream);
                    gpg.O000000o(byteArrayOutputStream);
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    inputStream = null;
                    gpg.O000000o(inputStream);
                    gpg.O000000o(byteArrayOutputStream);
                    throw th;
                }
            }
        }
    }

    private static HashMap<String, O000000o> O000000o(JSONArray jSONArray) throws JSONException {
        HashMap<String, O000000o> hashMap = new HashMap<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("cn");
            String string2 = jSONObject.getString("ic");
            String string3 = jSONObject.getString("iso");
            O000000o o000000o = new O000000o(string, string2, string3);
            JSONArray optJSONArray = jSONObject.optJSONArray("len");
            if (optJSONArray != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(Integer.valueOf(optJSONArray.getInt(i2)));
                }
                o000000o.O00000o = arrayList;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mc");
            if (optJSONArray2 != null) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    arrayList2.add(optJSONArray2.getString(i3));
                }
                o000000o.O00000oO = arrayList2;
            }
            hashMap.put(string3, o000000o);
        }
        return hashMap;
    }

    public static class O000000o implements Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18136O000000o;
        public String O00000Oo;
        ArrayList<Integer> O00000o;
        public String O00000o0;
        ArrayList<String> O00000oO;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f18136O000000o.compareTo(((O000000o) obj).f18136O000000o);
        }

        O000000o(String str, String str2, String str3) {
            this.f18136O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
        }
    }
}

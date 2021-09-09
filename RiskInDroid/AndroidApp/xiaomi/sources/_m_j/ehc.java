package _m_j;

import android.content.Context;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.IOUtils;
import com.xiaomi.smarthome.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ehc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15275O000000o = "(\\+)?\\d{1,20}";
    private static Pattern O00000Oo = Pattern.compile("(\\+)?\\d{1,20}");
    private static HashMap<String, O000000o> O00000o;
    private static HashMap<String, O000000o> O00000o0;

    private static synchronized void O00000o0(Context context) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        IOException e;
        JSONException e2;
        synchronized (ehc.class) {
            if (O00000o0 == null || O00000o == null) {
                O00000o0 = new HashMap<>();
                O00000o = new HashMap<>();
                try {
                    inputStream = context.getResources().openRawResource(Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage()) ? R.raw.passport_countries_cn : R.raw.passport_countries);
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
                                    IOUtils.closeQuietly(inputStream);
                                    IOUtils.closeQuietly(byteArrayOutputStream);
                                    return;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                AccountLog.e("PhoneNumUtil", "error when load area codes", e);
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly(byteArrayOutputStream);
                            } catch (JSONException e4) {
                                e2 = e4;
                                try {
                                    AccountLog.e("PhoneNumUtil", "error when parse json", e2);
                                    IOUtils.closeQuietly(inputStream);
                                    IOUtils.closeQuietly(byteArrayOutputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    IOUtils.closeQuietly(inputStream);
                                    IOUtils.closeQuietly(byteArrayOutputStream);
                                    throw th;
                                }
                            }
                        }
                    } catch (IOException e5) {
                        byteArrayOutputStream = null;
                        e = e5;
                        AccountLog.e("PhoneNumUtil", "error when load area codes", e);
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(byteArrayOutputStream);
                    } catch (JSONException e6) {
                        byteArrayOutputStream = null;
                        e2 = e6;
                        AccountLog.e("PhoneNumUtil", "error when parse json", e2);
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(byteArrayOutputStream);
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        th = th2;
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e7) {
                    byteArrayOutputStream = null;
                    e = e7;
                    inputStream = null;
                    AccountLog.e("PhoneNumUtil", "error when load area codes", e);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(byteArrayOutputStream);
                } catch (JSONException e8) {
                    byteArrayOutputStream = null;
                    e2 = e8;
                    inputStream = null;
                    AccountLog.e("PhoneNumUtil", "error when parse json", e2);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(byteArrayOutputStream);
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    inputStream = null;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(byteArrayOutputStream);
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

    public static List<O000000o> O000000o(Context context) {
        O00000o0(context);
        return O000000o(O00000o0);
    }

    public static List<O000000o> O00000Oo(Context context) {
        O00000o0(context);
        return O000000o(O00000o);
    }

    private static List<O000000o> O000000o(HashMap<String, O000000o> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(hashMap.size());
        for (O000000o add : hashMap.values()) {
            arrayList.add(add);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static class O000000o implements Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15276O000000o;
        public String O00000Oo;
        ArrayList<Integer> O00000o;
        public String O00000o0;
        ArrayList<String> O00000oO;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f15276O000000o.compareTo(((O000000o) obj).f15276O000000o);
        }

        O000000o(String str, String str2, String str3) {
            this.f15276O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
        }
    }
}

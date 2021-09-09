package _m_j;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.rt2zz.reactnativecontacts.ContactsProvider$1;
import com.rt2zz.reactnativecontacts.ContactsProvider$2;
import com.rt2zz.reactnativecontacts.ContactsProvider$3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ctz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final List<String> f14356O000000o = new ContactsProvider$1();
    private static final List<String> O00000o = new ContactsProvider$3();
    private static final List<String> O00000o0 = new ContactsProvider$2();
    public final ContentResolver O00000Oo;

    public ctz(ContentResolver contentResolver) {
        this.O00000Oo = contentResolver;
    }

    public final WritableArray O000000o(String str) {
        ContentResolver contentResolver = this.O00000Oo;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = O00000o0;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "display_name LIKE ?", new String[]{"%" + str + "%"}, null);
        try {
            Map<String, O000000o> O000000o2 = O000000o(query);
            WritableArray createArray = Arguments.createArray();
            for (O000000o O000000o3 : O000000o2.values()) {
                createArray.pushMap(O000000o3.O000000o());
            }
            return createArray;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public final WritableMap O00000Oo(String str) {
        ContentResolver contentResolver = this.O00000Oo;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = O00000o0;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        try {
            Map<String, O000000o> O000000o2 = O000000o(query);
            if (O000000o2.values().size() > 0) {
                return O000000o2.values().iterator().next().O000000o();
            }
            return null;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public final WritableArray O000000o() {
        ContentResolver contentResolver = this.O00000Oo;
        Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        List<String> list = f14356O000000o;
        Cursor query = contentResolver.query(withAppendedPath, (String[]) list.toArray(new String[list.size()]), null, null, null);
        try {
            Map<String, O000000o> O000000o2 = O000000o(query);
            ContentResolver contentResolver2 = this.O00000Oo;
            Uri uri = ContactsContract.Data.CONTENT_URI;
            List<String> list2 = O00000o0;
            Cursor query2 = contentResolver2.query(uri, (String[]) list2.toArray(new String[list2.size()]), "mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=?", new String[]{"vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/contact_event"}, null);
            try {
                Map<String, O000000o> O000000o3 = O000000o(query2);
                WritableArray createArray = Arguments.createArray();
                for (O000000o O000000o4 : O000000o2.values()) {
                    createArray.pushMap(O000000o4.O000000o());
                }
                for (O000000o O000000o5 : O000000o3.values()) {
                    createArray.pushMap(O000000o5.O000000o());
                }
                return createArray;
            } finally {
                if (query2 != null) {
                    query2.close();
                }
            }
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    private static Map<String, O000000o> O000000o(Cursor cursor) {
        Cursor cursor2 = cursor;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor2 != null && cursor.moveToNext()) {
            int columnIndex = cursor2.getColumnIndex("contact_id");
            int columnIndex2 = cursor2.getColumnIndex("_id");
            int columnIndex3 = cursor2.getColumnIndex("raw_contact_id");
            String str = "-1";
            String string = columnIndex != -1 ? cursor2.getString(columnIndex) : str;
            String string2 = columnIndex2 != -1 ? cursor2.getString(columnIndex2) : str;
            if (columnIndex3 != -1) {
                str = cursor2.getString(columnIndex3);
            }
            if (!linkedHashMap.containsKey(string)) {
                linkedHashMap.put(string, new O000000o(string));
            }
            O000000o o000000o = (O000000o) linkedHashMap.get(string);
            String string3 = cursor2.getString(cursor2.getColumnIndex("mimetype"));
            String string4 = cursor2.getString(cursor2.getColumnIndex("display_name"));
            o000000o.f14357O000000o = str;
            if (!TextUtils.isEmpty(string4) && TextUtils.isEmpty(o000000o.O00000Oo)) {
                o000000o.O00000Oo = string4;
            }
            if (TextUtils.isEmpty(o000000o.O0000Ooo)) {
                String string5 = cursor2.getString(cursor2.getColumnIndex("photo_uri"));
                if (!TextUtils.isEmpty(string5)) {
                    o000000o.O0000Ooo = string5;
                    o000000o.O0000OoO = true;
                }
            }
            if (string3.equals("vnd.android.cursor.item/name")) {
                o000000o.O00000o0 = cursor2.getString(cursor2.getColumnIndex("data2"));
                o000000o.O00000o = cursor2.getString(cursor2.getColumnIndex("data5"));
                o000000o.O00000oO = cursor2.getString(cursor2.getColumnIndex("data3"));
                o000000o.O00000oo = cursor2.getString(cursor2.getColumnIndex("data4"));
                o000000o.O0000O0o = cursor2.getString(cursor2.getColumnIndex("data6"));
            } else {
                String str2 = "work";
                if (string3.equals("vnd.android.cursor.item/phone_v2")) {
                    String string6 = cursor2.getString(cursor2.getColumnIndex("data1"));
                    int i = cursor2.getInt(cursor2.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string6)) {
                        if (i == 1) {
                            str2 = "home";
                        } else if (i == 2) {
                            str2 = "mobile";
                        } else if (i != 3) {
                            str2 = "other";
                        }
                        o000000o.O0000o0.add(new O000000o.O00000Oo(str2, string6, string2));
                    }
                } else if (string3.equals("vnd.android.cursor.item/email_v2")) {
                    String string7 = cursor2.getString(cursor2.getColumnIndex("data1"));
                    int i2 = cursor2.getInt(cursor2.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string7)) {
                        if (i2 == 0) {
                            str2 = cursor2.getString(cursor2.getColumnIndex("data3")) != null ? cursor2.getString(cursor2.getColumnIndex("data3")).toLowerCase() : "";
                        } else if (i2 == 1) {
                            str2 = "home";
                        } else if (i2 != 2) {
                            str2 = i2 != 4 ? "other" : "mobile";
                        }
                        o000000o.O0000o00.add(new O000000o.O00000Oo(str2, string7, string2));
                    }
                } else if (string3.equals("vnd.android.cursor.item/organization")) {
                    o000000o.O0000OOo = cursor2.getString(cursor2.getColumnIndex("data1"));
                    o000000o.O0000Oo0 = cursor2.getString(cursor2.getColumnIndex("data4"));
                    o000000o.O0000Oo = cursor2.getString(cursor2.getColumnIndex("data5"));
                } else if (string3.equals("vnd.android.cursor.item/postal-address_v2")) {
                    o000000o.O0000o0O.add(new O000000o.O00000o0(cursor2));
                } else if (string3.equals("vnd.android.cursor.item/contact_event") && cursor2.getInt(cursor2.getColumnIndex("data2")) == 3) {
                    try {
                        List asList = Arrays.asList(cursor2.getString(cursor2.getColumnIndex("data1")).replace("--", "").split("-"));
                        if (asList.size() == 2) {
                            int parseInt = Integer.parseInt((String) asList.get(0));
                            int parseInt2 = Integer.parseInt((String) asList.get(1));
                            if (parseInt > 0 && parseInt <= 12 && parseInt2 > 0 && parseInt2 <= 31) {
                                o000000o.O0000o0o = new O000000o.C0099O000000o(parseInt, parseInt2);
                            }
                        } else if (asList.size() == 3) {
                            int parseInt3 = Integer.parseInt((String) asList.get(0));
                            int parseInt4 = Integer.parseInt((String) asList.get(1));
                            int parseInt5 = Integer.parseInt((String) asList.get(2));
                            if (parseInt3 > 0 && parseInt4 > 0 && parseInt4 <= 12 && parseInt5 > 0 && parseInt5 <= 31) {
                                o000000o.O0000o0o = new O000000o.C0099O000000o(parseInt3, parseInt4, parseInt5);
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        Log.w("ContactsProvider", e.toString());
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public final String O00000o0(String str) {
        ContentResolver contentResolver = this.O00000Oo;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = O00000o;
        Cursor query = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("photo_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query == null) {
            return null;
        }
        query.close();
        return null;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f14357O000000o;
        public String O00000Oo;
        public String O00000o = "";
        public String O00000o0 = "";
        public String O00000oO = "";
        public String O00000oo = "";
        public String O0000O0o = "";
        public String O0000OOo = "";
        public String O0000Oo = "";
        public String O0000Oo0 = "";
        public boolean O0000OoO = false;
        public String O0000Ooo;
        private String O0000o;
        public List<O00000Oo> O0000o0 = new ArrayList();
        public List<O00000Oo> O0000o00 = new ArrayList();
        public List<O00000o0> O0000o0O = new ArrayList();
        public C0099O000000o O0000o0o;

        public O000000o(String str) {
            this.O0000o = str;
        }

        public final WritableMap O000000o() {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("recordID", this.O0000o);
            createMap.putString("rawContactId", this.f14357O000000o);
            createMap.putString("givenName", TextUtils.isEmpty(this.O00000o0) ? this.O00000Oo : this.O00000o0);
            createMap.putString("middleName", this.O00000o);
            createMap.putString("familyName", this.O00000oO);
            createMap.putString("prefix", this.O00000oo);
            createMap.putString("suffix", this.O0000O0o);
            createMap.putString("company", this.O0000OOo);
            createMap.putString("jobTitle", this.O0000Oo0);
            createMap.putString("department", this.O0000Oo);
            createMap.putBoolean("hasThumbnail", this.O0000OoO);
            String str = this.O0000Ooo;
            if (str == null) {
                str = "";
            }
            createMap.putString("thumbnailPath", str);
            WritableArray createArray = Arguments.createArray();
            for (O00000Oo next : this.O0000o0) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString("number", next.O00000Oo);
                createMap2.putString("label", next.f14359O000000o);
                createMap2.putString("id", next.O00000o0);
                createArray.pushMap(createMap2);
            }
            createMap.putArray("phoneNumbers", createArray);
            WritableArray createArray2 = Arguments.createArray();
            for (O00000Oo next2 : this.O0000o00) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putString("email", next2.O00000Oo);
                createMap3.putString("label", next2.f14359O000000o);
                createMap3.putString("id", next2.O00000o0);
                createArray2.pushMap(createMap3);
            }
            createMap.putArray("emailAddresses", createArray2);
            WritableArray createArray3 = Arguments.createArray();
            for (O00000o0 o00000o0 : this.O0000o0O) {
                createArray3.pushMap(o00000o0.f14360O000000o);
            }
            createMap.putArray("postalAddresses", createArray3);
            WritableMap createMap4 = Arguments.createMap();
            C0099O000000o o000000o = this.O0000o0o;
            if (o000000o != null) {
                if (o000000o.f14358O000000o > 0) {
                    createMap4.putInt("year", this.O0000o0o.f14358O000000o);
                }
                createMap4.putInt("month", this.O0000o0o.O00000Oo);
                createMap4.putInt("day", this.O0000o0o.O00000o0);
                createMap.putMap("birthday", createMap4);
            }
            return createMap;
        }

        public static class O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public String f14359O000000o;
            public String O00000Oo;
            public String O00000o0;

            public O00000Oo(String str, String str2, String str3) {
                this.O00000o0 = str3;
                this.f14359O000000o = str;
                this.O00000Oo = str2;
            }
        }

        /* renamed from: _m_j.ctz$O000000o$O000000o  reason: collision with other inner class name */
        public static class C0099O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public int f14358O000000o = 0;
            public int O00000Oo = 0;
            public int O00000o0 = 0;

            public C0099O000000o(int i, int i2, int i3) {
                this.f14358O000000o = i;
                this.O00000Oo = i2;
                this.O00000o0 = i3;
            }

            public C0099O000000o(int i, int i2) {
                this.O00000Oo = i;
                this.O00000o0 = i2;
            }
        }

        public static class O00000o0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public final WritableMap f14360O000000o = Arguments.createMap();

            public O00000o0(Cursor cursor) {
                String str;
                WritableMap writableMap = this.f14360O000000o;
                int i = cursor.getInt(cursor.getColumnIndex("data2"));
                if (i != 0) {
                    str = i != 1 ? i != 2 ? "other" : "work" : "home";
                } else {
                    str = cursor.getString(cursor.getColumnIndex("data3"));
                    if (str == null) {
                        str = "";
                    }
                }
                writableMap.putString("label", str);
                O000000o(cursor, "formattedAddress", "data1");
                O000000o(cursor, "street", "data4");
                O000000o(cursor, "pobox", "data5");
                O000000o(cursor, "neighborhood", "data6");
                O000000o(cursor, "city", "data7");
                O000000o(cursor, "region", "data8");
                O000000o(cursor, "state", "data8");
                O000000o(cursor, "postCode", "data9");
                O000000o(cursor, "country", "data10");
            }

            private void O000000o(Cursor cursor, String str, String str2) {
                String string = cursor.getString(cursor.getColumnIndex(str2));
                if (!TextUtils.isEmpty(string)) {
                    this.f14360O000000o.putString(str, string);
                }
            }
        }
    }
}
